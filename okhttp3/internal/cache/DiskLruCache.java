package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.io.FileSystem;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class DiskLruCache
  implements Closeable, Flushable
{
  static final long ANY_SEQUENCE_NUMBER = -1L;
  private static final String CLEAN = "CLEAN";
  private static final String DIRTY = "DIRTY";
  static final String JOURNAL_FILE = "journal";
  static final String JOURNAL_FILE_BACKUP = "journal.bkp";
  static final String JOURNAL_FILE_TEMP = "journal.tmp";
  static final Pattern LEGAL_KEY_PATTERN = Pattern.compile("[a-z0-9_-]{1,120}");
  static final String MAGIC = "libcore.io.DiskLruCache";
  private static final String READ = "READ";
  private static final String REMOVE = "REMOVE";
  static final String VERSION_1 = "1";
  private final int appVersion;
  private final Runnable cleanupRunnable = new Runnable()
  {
    public void run()
    {
      synchronized (DiskLruCache.this)
      {
        DiskLruCache localDiskLruCache2 = DiskLruCache.this;
        int i;
        if (!localDiskLruCache2.initialized) {
          i = 1;
        } else {
          i = 0;
        }
        if ((i | localDiskLruCache2.closed) != 0) {
          return;
        }
        try
        {
          localDiskLruCache2.trimToSize();
        }
        catch (IOException localIOException1)
        {
          DiskLruCache.this.mostRecentTrimFailed = true;
        }
        try
        {
          if (DiskLruCache.this.journalRebuildRequired())
          {
            DiskLruCache.this.rebuildJournal();
            DiskLruCache.this.redundantOpCount = 0;
          }
        }
        catch (IOException localIOException2)
        {
          DiskLruCache localDiskLruCache3 = DiskLruCache.this;
          localDiskLruCache3.mostRecentRebuildFailed = true;
          localDiskLruCache3.journalWriter = Okio.buffer(Okio.blackhole());
        }
        return;
      }
    }
  };
  boolean closed;
  final File directory;
  private final Executor executor;
  final FileSystem fileSystem;
  boolean hasJournalErrors;
  boolean initialized;
  private final File journalFile;
  private final File journalFileBackup;
  private final File journalFileTmp;
  BufferedSink journalWriter;
  final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap(0, 0.75F, true);
  private long maxSize;
  boolean mostRecentRebuildFailed;
  boolean mostRecentTrimFailed;
  private long nextSequenceNumber = 0L;
  int redundantOpCount;
  private long size = 0L;
  final int valueCount;
  
  DiskLruCache(FileSystem paramFileSystem, File paramFile, int paramInt1, int paramInt2, long paramLong, Executor paramExecutor)
  {
    this.fileSystem = paramFileSystem;
    this.directory = paramFile;
    this.appVersion = paramInt1;
    this.journalFile = new File(paramFile, "journal");
    this.journalFileTmp = new File(paramFile, "journal.tmp");
    this.journalFileBackup = new File(paramFile, "journal.bkp");
    this.valueCount = paramInt2;
    this.maxSize = paramLong;
    this.executor = paramExecutor;
  }
  
  private void checkNotClosed()
  {
    try
    {
      boolean bool = isClosed();
      if (!bool) {
        return;
      }
      IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
      localIllegalStateException.<init>("cache is closed");
      throw localIllegalStateException;
    }
    finally {}
  }
  
  public static DiskLruCache create(FileSystem paramFileSystem, File paramFile, int paramInt1, int paramInt2, long paramLong)
  {
    if (paramLong > 0L)
    {
      if (paramInt2 > 0) {
        return new DiskLruCache(paramFileSystem, paramFile, paramInt1, paramInt2, paramLong, new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp DiskLruCache", true)));
      }
      throw new IllegalArgumentException("valueCount <= 0");
    }
    throw new IllegalArgumentException("maxSize <= 0");
  }
  
  private BufferedSink newJournalWriter()
    throws FileNotFoundException
  {
    Okio.buffer(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile))
    {
      protected void onException(IOException paramAnonymousIOException)
      {
        DiskLruCache.this.hasJournalErrors = true;
      }
    });
  }
  
  private void processJournal()
    throws IOException
  {
    this.fileSystem.delete(this.journalFileTmp);
    Iterator localIterator = this.lruEntries.values().iterator();
    while (localIterator.hasNext())
    {
      Entry localEntry = (Entry)localIterator.next();
      Editor localEditor = localEntry.currentEditor;
      int i = 0;
      int j = 0;
      if (localEditor == null)
      {
        while (j < this.valueCount)
        {
          this.size += localEntry.lengths[j];
          j++;
        }
      }
      else
      {
        localEntry.currentEditor = null;
        for (j = i; j < this.valueCount; j++)
        {
          this.fileSystem.delete(localEntry.cleanFiles[j]);
          this.fileSystem.delete(localEntry.dirtyFiles[j]);
        }
        localIterator.remove();
      }
    }
  }
  
  private void readJournal()
    throws IOException
  {
    BufferedSource localBufferedSource = Okio.buffer(this.fileSystem.source(this.journalFile));
    try
    {
      String str1 = localBufferedSource.readUtf8LineStrict();
      String str2 = localBufferedSource.readUtf8LineStrict();
      Object localObject2 = localBufferedSource.readUtf8LineStrict();
      String str3 = localBufferedSource.readUtf8LineStrict();
      String str4 = localBufferedSource.readUtf8LineStrict();
      if (("libcore.io.DiskLruCache".equals(str1)) && ("1".equals(str2)) && (Integer.toString(this.appVersion).equals(localObject2)) && (Integer.toString(this.valueCount).equals(str3)))
      {
        boolean bool = "".equals(str4);
        if (bool)
        {
          int i = 0;
          try
          {
            for (;;)
            {
              readJournalLine(localBufferedSource.readUtf8LineStrict());
              i++;
            }
            localIOException = new java/io/IOException;
          }
          catch (EOFException localEOFException)
          {
            this.redundantOpCount = (i - this.lruEntries.size());
            if (!localBufferedSource.exhausted()) {
              rebuildJournal();
            } else {
              this.journalWriter = newJournalWriter();
            }
            return;
          }
        }
      }
      IOException localIOException;
      localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>();
      ((StringBuilder)localObject2).append("unexpected journal header: [");
      ((StringBuilder)localObject2).append(str1);
      ((StringBuilder)localObject2).append(", ");
      ((StringBuilder)localObject2).append(localEOFException);
      ((StringBuilder)localObject2).append(", ");
      ((StringBuilder)localObject2).append(str3);
      ((StringBuilder)localObject2).append(", ");
      ((StringBuilder)localObject2).append(str4);
      ((StringBuilder)localObject2).append("]");
      localIOException.<init>(((StringBuilder)localObject2).toString());
      throw localIOException;
    }
    finally
    {
      Util.closeQuietly(localBufferedSource);
    }
  }
  
  private void readJournalLine(String paramString)
    throws IOException
  {
    int i = paramString.indexOf(' ');
    if (i != -1)
    {
      int j = i + 1;
      int k = paramString.indexOf(' ', j);
      if (k == -1)
      {
        localObject1 = paramString.substring(j);
        localObject2 = localObject1;
        if (i == 6)
        {
          localObject2 = localObject1;
          if (paramString.startsWith("REMOVE")) {
            this.lruEntries.remove(localObject1);
          }
        }
      }
      else
      {
        localObject2 = paramString.substring(j, k);
      }
      Entry localEntry = (Entry)this.lruEntries.get(localObject2);
      Object localObject1 = localEntry;
      if (localEntry == null)
      {
        localObject1 = new Entry((String)localObject2);
        this.lruEntries.put(localObject2, localObject1);
      }
      if ((k != -1) && (i == 5) && (paramString.startsWith("CLEAN")))
      {
        paramString = paramString.substring(k + 1).split(" ");
        ((Entry)localObject1).readable = true;
        ((Entry)localObject1).currentEditor = null;
        ((Entry)localObject1).setLengths(paramString);
      }
      else if ((k == -1) && (i == 5) && (paramString.startsWith("DIRTY")))
      {
        ((Entry)localObject1).currentEditor = new Editor((Entry)localObject1);
      }
      else
      {
        if ((k != -1) || (i != 4) || (!paramString.startsWith("READ"))) {
          break label243;
        }
      }
      return;
      label243:
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("unexpected journal line: ");
      ((StringBuilder)localObject2).append(paramString);
      throw new IOException(((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("unexpected journal line: ");
    ((StringBuilder)localObject2).append(paramString);
    throw new IOException(((StringBuilder)localObject2).toString());
  }
  
  private void validateKey(String paramString)
  {
    if (LEGAL_KEY_PATTERN.matcher(paramString).matches()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("keys must match regex [a-z0-9_-]{1,120}: \"");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\"");
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void close()
    throws IOException
  {
    try
    {
      if ((this.initialized) && (!this.closed))
      {
        Entry[] arrayOfEntry = (Entry[])this.lruEntries.values().toArray(new Entry[this.lruEntries.size()]);
        int i = arrayOfEntry.length;
        for (int j = 0; j < i; j++)
        {
          Editor localEditor = arrayOfEntry[j].currentEditor;
          if (localEditor != null) {
            localEditor.abort();
          }
        }
        trimToSize();
        this.journalWriter.close();
        this.journalWriter = null;
        this.closed = true;
        return;
      }
      this.closed = true;
      return;
    }
    finally {}
  }
  
  void completeEdit(Editor paramEditor, boolean paramBoolean)
    throws IOException
  {
    try
    {
      Object localObject = paramEditor.entry;
      if (((Entry)localObject).currentEditor == paramEditor)
      {
        int i = 0;
        int j = i;
        if (paramBoolean)
        {
          j = i;
          if (!((Entry)localObject).readable)
          {
            for (int k = 0;; k++)
            {
              j = i;
              if (k >= this.valueCount) {
                break label136;
              }
              if (paramEditor.written[k] == 0) {
                break;
              }
              if (!this.fileSystem.exists(localObject.dirtyFiles[k]))
              {
                paramEditor.abort();
                return;
              }
            }
            paramEditor.abort();
            paramEditor = new java/lang/IllegalStateException;
            localObject = new java/lang/StringBuilder;
            ((StringBuilder)localObject).<init>();
            ((StringBuilder)localObject).append("Newly created entry didn't create value for index ");
            ((StringBuilder)localObject).append(k);
            paramEditor.<init>(((StringBuilder)localObject).toString());
            throw paramEditor;
          }
        }
        label136:
        long l2;
        while (j < this.valueCount)
        {
          paramEditor = localObject.dirtyFiles[j];
          if (paramBoolean)
          {
            if (this.fileSystem.exists(paramEditor))
            {
              File localFile = localObject.cleanFiles[j];
              this.fileSystem.rename(paramEditor, localFile);
              long l1 = localObject.lengths[j];
              l2 = this.fileSystem.size(localFile);
              ((Entry)localObject).lengths[j] = l2;
              this.size = (this.size - l1 + l2);
            }
          }
          else {
            this.fileSystem.delete(paramEditor);
          }
          j++;
        }
        this.redundantOpCount += 1;
        ((Entry)localObject).currentEditor = null;
        if ((((Entry)localObject).readable | paramBoolean))
        {
          ((Entry)localObject).readable = true;
          this.journalWriter.writeUtf8("CLEAN").writeByte(32);
          this.journalWriter.writeUtf8(((Entry)localObject).key);
          ((Entry)localObject).writeLengths(this.journalWriter);
          this.journalWriter.writeByte(10);
          if (paramBoolean)
          {
            l2 = this.nextSequenceNumber;
            this.nextSequenceNumber = (1L + l2);
            ((Entry)localObject).sequenceNumber = l2;
          }
        }
        else
        {
          this.lruEntries.remove(((Entry)localObject).key);
          this.journalWriter.writeUtf8("REMOVE").writeByte(32);
          this.journalWriter.writeUtf8(((Entry)localObject).key);
          this.journalWriter.writeByte(10);
        }
        this.journalWriter.flush();
        if ((this.size > this.maxSize) || (journalRebuildRequired())) {
          this.executor.execute(this.cleanupRunnable);
        }
        return;
      }
      paramEditor = new java/lang/IllegalStateException;
      paramEditor.<init>();
      throw paramEditor;
    }
    finally {}
  }
  
  public void delete()
    throws IOException
  {
    close();
    this.fileSystem.deleteContents(this.directory);
  }
  
  @Nullable
  public Editor edit(String paramString)
    throws IOException
  {
    return edit(paramString, -1L);
  }
  
  Editor edit(String paramString, long paramLong)
    throws IOException
  {
    try
    {
      initialize();
      checkNotClosed();
      validateKey(paramString);
      Entry localEntry = (Entry)this.lruEntries.get(paramString);
      if (paramLong != -1L) {
        if (localEntry != null)
        {
          long l = localEntry.sequenceNumber;
          if (l == paramLong) {}
        }
        else
        {
          return null;
        }
      }
      Object localObject;
      if (localEntry != null)
      {
        localObject = localEntry.currentEditor;
        if (localObject != null) {
          return null;
        }
      }
      if ((!this.mostRecentTrimFailed) && (!this.mostRecentRebuildFailed))
      {
        this.journalWriter.writeUtf8("DIRTY").writeByte(32).writeUtf8(paramString).writeByte(10);
        this.journalWriter.flush();
        boolean bool = this.hasJournalErrors;
        if (bool) {
          return null;
        }
        localObject = localEntry;
        if (localEntry == null)
        {
          localObject = new okhttp3/internal/cache/DiskLruCache$Entry;
          ((Entry)localObject).<init>(this, paramString);
          this.lruEntries.put(paramString, localObject);
        }
        paramString = new okhttp3/internal/cache/DiskLruCache$Editor;
        paramString.<init>(this, (Entry)localObject);
        ((Entry)localObject).currentEditor = paramString;
        return paramString;
      }
      this.executor.execute(this.cleanupRunnable);
      return null;
    }
    finally {}
  }
  
  public void evictAll()
    throws IOException
  {
    try
    {
      initialize();
      Entry[] arrayOfEntry = (Entry[])this.lruEntries.values().toArray(new Entry[this.lruEntries.size()]);
      int i = arrayOfEntry.length;
      for (int j = 0; j < i; j++) {
        removeEntry(arrayOfEntry[j]);
      }
      this.mostRecentTrimFailed = false;
      return;
    }
    finally {}
  }
  
  public void flush()
    throws IOException
  {
    try
    {
      boolean bool = this.initialized;
      if (!bool) {
        return;
      }
      checkNotClosed();
      trimToSize();
      this.journalWriter.flush();
      return;
    }
    finally {}
  }
  
  public Snapshot get(String paramString)
    throws IOException
  {
    try
    {
      initialize();
      checkNotClosed();
      validateKey(paramString);
      Object localObject = (Entry)this.lruEntries.get(paramString);
      if ((localObject != null) && (((Entry)localObject).readable))
      {
        localObject = ((Entry)localObject).snapshot();
        if (localObject == null) {
          return null;
        }
        this.redundantOpCount += 1;
        this.journalWriter.writeUtf8("READ").writeByte(32).writeUtf8(paramString).writeByte(10);
        if (journalRebuildRequired()) {
          this.executor.execute(this.cleanupRunnable);
        }
        return (Snapshot)localObject;
      }
      return null;
    }
    finally {}
  }
  
  public File getDirectory()
  {
    return this.directory;
  }
  
  public long getMaxSize()
  {
    try
    {
      long l = this.maxSize;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void initialize()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 387	okhttp3/internal/cache/DiskLruCache:initialized	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 122	okhttp3/internal/cache/DiskLruCache:fileSystem	Lokhttp3/internal/io/FileSystem;
    //   18: aload_0
    //   19: getfield 137	okhttp3/internal/cache/DiskLruCache:journalFileBackup	Ljava/io/File;
    //   22: invokeinterface 419 2 0
    //   27: ifeq +52 -> 79
    //   30: aload_0
    //   31: getfield 122	okhttp3/internal/cache/DiskLruCache:fileSystem	Lokhttp3/internal/io/FileSystem;
    //   34: aload_0
    //   35: getfield 133	okhttp3/internal/cache/DiskLruCache:journalFile	Ljava/io/File;
    //   38: invokeinterface 419 2 0
    //   43: ifeq +19 -> 62
    //   46: aload_0
    //   47: getfield 122	okhttp3/internal/cache/DiskLruCache:fileSystem	Lokhttp3/internal/io/FileSystem;
    //   50: aload_0
    //   51: getfield 137	okhttp3/internal/cache/DiskLruCache:journalFileBackup	Ljava/io/File;
    //   54: invokeinterface 217 2 0
    //   59: goto +20 -> 79
    //   62: aload_0
    //   63: getfield 122	okhttp3/internal/cache/DiskLruCache:fileSystem	Lokhttp3/internal/io/FileSystem;
    //   66: aload_0
    //   67: getfield 137	okhttp3/internal/cache/DiskLruCache:journalFileBackup	Ljava/io/File;
    //   70: aload_0
    //   71: getfield 133	okhttp3/internal/cache/DiskLruCache:journalFile	Ljava/io/File;
    //   74: invokeinterface 428 3 0
    //   79: aload_0
    //   80: getfield 122	okhttp3/internal/cache/DiskLruCache:fileSystem	Lokhttp3/internal/io/FileSystem;
    //   83: aload_0
    //   84: getfield 133	okhttp3/internal/cache/DiskLruCache:journalFile	Ljava/io/File;
    //   87: invokeinterface 419 2 0
    //   92: istore_1
    //   93: iload_1
    //   94: ifeq +112 -> 206
    //   97: aload_0
    //   98: invokespecial 504	okhttp3/internal/cache/DiskLruCache:readJournal	()V
    //   101: aload_0
    //   102: invokespecial 506	okhttp3/internal/cache/DiskLruCache:processJournal	()V
    //   105: aload_0
    //   106: iconst_1
    //   107: putfield 387	okhttp3/internal/cache/DiskLruCache:initialized	Z
    //   110: aload_0
    //   111: monitorexit
    //   112: return
    //   113: astore_2
    //   114: invokestatic 511	okhttp3/internal/platform/Platform:get	()Lokhttp3/internal/platform/Platform;
    //   117: astore_3
    //   118: new 308	java/lang/StringBuilder
    //   121: astore 4
    //   123: aload 4
    //   125: invokespecial 309	java/lang/StringBuilder:<init>	()V
    //   128: aload 4
    //   130: ldc_w 513
    //   133: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: pop
    //   137: aload 4
    //   139: aload_0
    //   140: getfield 124	okhttp3/internal/cache/DiskLruCache:directory	Ljava/io/File;
    //   143: invokevirtual 516	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   146: pop
    //   147: aload 4
    //   149: ldc_w 518
    //   152: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload 4
    //   158: aload_2
    //   159: invokevirtual 521	java/io/IOException:getMessage	()Ljava/lang/String;
    //   162: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload 4
    //   168: ldc_w 523
    //   171: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: pop
    //   175: aload_3
    //   176: iconst_5
    //   177: aload 4
    //   179: invokevirtual 321	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: aload_2
    //   183: invokevirtual 527	okhttp3/internal/platform/Platform:log	(ILjava/lang/String;Ljava/lang/Throwable;)V
    //   186: aload_0
    //   187: invokevirtual 529	okhttp3/internal/cache/DiskLruCache:delete	()V
    //   190: aload_0
    //   191: iconst_0
    //   192: putfield 389	okhttp3/internal/cache/DiskLruCache:closed	Z
    //   195: goto +11 -> 206
    //   198: astore_3
    //   199: aload_0
    //   200: iconst_0
    //   201: putfield 389	okhttp3/internal/cache/DiskLruCache:closed	Z
    //   204: aload_3
    //   205: athrow
    //   206: aload_0
    //   207: invokevirtual 298	okhttp3/internal/cache/DiskLruCache:rebuildJournal	()V
    //   210: aload_0
    //   211: iconst_1
    //   212: putfield 387	okhttp3/internal/cache/DiskLruCache:initialized	Z
    //   215: aload_0
    //   216: monitorexit
    //   217: return
    //   218: astore_3
    //   219: aload_0
    //   220: monitorexit
    //   221: aload_3
    //   222: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	DiskLruCache
    //   6	88	1	bool	boolean
    //   113	70	2	localIOException	IOException
    //   117	59	3	localPlatform	okhttp3.internal.platform.Platform
    //   198	7	3	localObject1	Object
    //   218	4	3	localObject2	Object
    //   121	57	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   97	110	113	java/io/IOException
    //   186	190	198	finally
    //   2	7	218	finally
    //   14	59	218	finally
    //   62	79	218	finally
    //   79	93	218	finally
    //   97	110	218	finally
    //   114	186	218	finally
    //   190	195	218	finally
    //   199	206	218	finally
    //   206	215	218	finally
  }
  
  public boolean isClosed()
  {
    try
    {
      boolean bool = this.closed;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  boolean journalRebuildRequired()
  {
    int i = this.redundantOpCount;
    boolean bool;
    if ((i >= 2000) && (i >= this.lruEntries.size())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  /* Error */
  void rebuildJournal()
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 302	okhttp3/internal/cache/DiskLruCache:journalWriter	Lokio/BufferedSink;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +9 -> 17
    //   11: aload_1
    //   12: invokeinterface 405 1 0
    //   17: aload_0
    //   18: getfield 122	okhttp3/internal/cache/DiskLruCache:fileSystem	Lokhttp3/internal/io/FileSystem;
    //   21: aload_0
    //   22: getfield 135	okhttp3/internal/cache/DiskLruCache:journalFileTmp	Ljava/io/File;
    //   25: invokeinterface 532 2 0
    //   30: invokestatic 209	okio/Okio:buffer	(Lokio/Sink;)Lokio/BufferedSink;
    //   33: astore_1
    //   34: aload_1
    //   35: ldc 51
    //   37: invokeinterface 437 2 0
    //   42: bipush 10
    //   44: invokeinterface 441 2 0
    //   49: pop
    //   50: aload_1
    //   51: ldc 58
    //   53: invokeinterface 437 2 0
    //   58: bipush 10
    //   60: invokeinterface 441 2 0
    //   65: pop
    //   66: aload_1
    //   67: aload_0
    //   68: getfield 126	okhttp3/internal/cache/DiskLruCache:appVersion	I
    //   71: i2l
    //   72: invokeinterface 536 3 0
    //   77: bipush 10
    //   79: invokeinterface 441 2 0
    //   84: pop
    //   85: aload_1
    //   86: aload_0
    //   87: getfield 139	okhttp3/internal/cache/DiskLruCache:valueCount	I
    //   90: i2l
    //   91: invokeinterface 536 3 0
    //   96: bipush 10
    //   98: invokeinterface 441 2 0
    //   103: pop
    //   104: aload_1
    //   105: bipush 10
    //   107: invokeinterface 441 2 0
    //   112: pop
    //   113: aload_0
    //   114: getfield 113	okhttp3/internal/cache/DiskLruCache:lruEntries	Ljava/util/LinkedHashMap;
    //   117: invokevirtual 221	java/util/LinkedHashMap:values	()Ljava/util/Collection;
    //   120: invokeinterface 227 1 0
    //   125: astore_2
    //   126: aload_2
    //   127: invokeinterface 232 1 0
    //   132: ifeq +103 -> 235
    //   135: aload_2
    //   136: invokeinterface 236 1 0
    //   141: checkcast 21	okhttp3/internal/cache/DiskLruCache$Entry
    //   144: astore_3
    //   145: aload_3
    //   146: getfield 240	okhttp3/internal/cache/DiskLruCache$Entry:currentEditor	Lokhttp3/internal/cache/DiskLruCache$Editor;
    //   149: ifnull +42 -> 191
    //   152: aload_1
    //   153: ldc 37
    //   155: invokeinterface 437 2 0
    //   160: bipush 32
    //   162: invokeinterface 441 2 0
    //   167: pop
    //   168: aload_1
    //   169: aload_3
    //   170: getfield 444	okhttp3/internal/cache/DiskLruCache$Entry:key	Ljava/lang/String;
    //   173: invokeinterface 437 2 0
    //   178: pop
    //   179: aload_1
    //   180: bipush 10
    //   182: invokeinterface 441 2 0
    //   187: pop
    //   188: goto -62 -> 126
    //   191: aload_1
    //   192: ldc 35
    //   194: invokeinterface 437 2 0
    //   199: bipush 32
    //   201: invokeinterface 441 2 0
    //   206: pop
    //   207: aload_1
    //   208: aload_3
    //   209: getfield 444	okhttp3/internal/cache/DiskLruCache$Entry:key	Ljava/lang/String;
    //   212: invokeinterface 437 2 0
    //   217: pop
    //   218: aload_3
    //   219: aload_1
    //   220: invokevirtual 448	okhttp3/internal/cache/DiskLruCache$Entry:writeLengths	(Lokio/BufferedSink;)V
    //   223: aload_1
    //   224: bipush 10
    //   226: invokeinterface 441 2 0
    //   231: pop
    //   232: goto -106 -> 126
    //   235: aload_1
    //   236: invokeinterface 405 1 0
    //   241: aload_0
    //   242: getfield 122	okhttp3/internal/cache/DiskLruCache:fileSystem	Lokhttp3/internal/io/FileSystem;
    //   245: aload_0
    //   246: getfield 133	okhttp3/internal/cache/DiskLruCache:journalFile	Ljava/io/File;
    //   249: invokeinterface 419 2 0
    //   254: ifeq +20 -> 274
    //   257: aload_0
    //   258: getfield 122	okhttp3/internal/cache/DiskLruCache:fileSystem	Lokhttp3/internal/io/FileSystem;
    //   261: aload_0
    //   262: getfield 133	okhttp3/internal/cache/DiskLruCache:journalFile	Ljava/io/File;
    //   265: aload_0
    //   266: getfield 137	okhttp3/internal/cache/DiskLruCache:journalFileBackup	Ljava/io/File;
    //   269: invokeinterface 428 3 0
    //   274: aload_0
    //   275: getfield 122	okhttp3/internal/cache/DiskLruCache:fileSystem	Lokhttp3/internal/io/FileSystem;
    //   278: aload_0
    //   279: getfield 135	okhttp3/internal/cache/DiskLruCache:journalFileTmp	Ljava/io/File;
    //   282: aload_0
    //   283: getfield 133	okhttp3/internal/cache/DiskLruCache:journalFile	Ljava/io/File;
    //   286: invokeinterface 428 3 0
    //   291: aload_0
    //   292: getfield 122	okhttp3/internal/cache/DiskLruCache:fileSystem	Lokhttp3/internal/io/FileSystem;
    //   295: aload_0
    //   296: getfield 137	okhttp3/internal/cache/DiskLruCache:journalFileBackup	Ljava/io/File;
    //   299: invokeinterface 217 2 0
    //   304: aload_0
    //   305: aload_0
    //   306: invokespecial 300	okhttp3/internal/cache/DiskLruCache:newJournalWriter	()Lokio/BufferedSink;
    //   309: putfield 302	okhttp3/internal/cache/DiskLruCache:journalWriter	Lokio/BufferedSink;
    //   312: aload_0
    //   313: iconst_0
    //   314: putfield 488	okhttp3/internal/cache/DiskLruCache:hasJournalErrors	Z
    //   317: aload_0
    //   318: iconst_0
    //   319: putfield 486	okhttp3/internal/cache/DiskLruCache:mostRecentRebuildFailed	Z
    //   322: aload_0
    //   323: monitorexit
    //   324: return
    //   325: astore_3
    //   326: aload_1
    //   327: invokeinterface 405 1 0
    //   332: aload_3
    //   333: athrow
    //   334: astore_1
    //   335: aload_0
    //   336: monitorexit
    //   337: aload_1
    //   338: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	this	DiskLruCache
    //   6	321	1	localBufferedSink	BufferedSink
    //   334	4	1	localObject1	Object
    //   125	11	2	localIterator	Iterator
    //   144	75	3	localEntry	Entry
    //   325	8	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   34	126	325	finally
    //   126	188	325	finally
    //   191	232	325	finally
    //   2	7	334	finally
    //   11	17	334	finally
    //   17	34	334	finally
    //   235	274	334	finally
    //   274	322	334	finally
    //   326	334	334	finally
  }
  
  public boolean remove(String paramString)
    throws IOException
  {
    try
    {
      initialize();
      checkNotClosed();
      validateKey(paramString);
      paramString = (Entry)this.lruEntries.get(paramString);
      if (paramString == null) {
        return false;
      }
      boolean bool = removeEntry(paramString);
      if ((bool) && (this.size <= this.maxSize)) {
        this.mostRecentTrimFailed = false;
      }
      return bool;
    }
    finally {}
  }
  
  boolean removeEntry(Entry paramEntry)
    throws IOException
  {
    Object localObject = paramEntry.currentEditor;
    if (localObject != null) {
      ((Editor)localObject).detach();
    }
    for (int i = 0; i < this.valueCount; i++)
    {
      this.fileSystem.delete(paramEntry.cleanFiles[i]);
      long l = this.size;
      localObject = paramEntry.lengths;
      this.size = (l - localObject[i]);
      localObject[i] = 0L;
    }
    this.redundantOpCount += 1;
    this.journalWriter.writeUtf8("REMOVE").writeByte(32).writeUtf8(paramEntry.key).writeByte(10);
    this.lruEntries.remove(paramEntry.key);
    if (journalRebuildRequired()) {
      this.executor.execute(this.cleanupRunnable);
    }
    return true;
  }
  
  public void setMaxSize(long paramLong)
  {
    try
    {
      this.maxSize = paramLong;
      if (this.initialized) {
        this.executor.execute(this.cleanupRunnable);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public long size()
    throws IOException
  {
    try
    {
      initialize();
      long l = this.size;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public Iterator<Snapshot> snapshots()
    throws IOException
  {
    try
    {
      initialize();
      Iterator local3 = new Iterator()
      {
        final Iterator<DiskLruCache.Entry> delegate = new ArrayList(DiskLruCache.this.lruEntries.values()).iterator();
        DiskLruCache.Snapshot nextSnapshot;
        DiskLruCache.Snapshot removeSnapshot;
        
        public boolean hasNext()
        {
          if (this.nextSnapshot != null) {
            return true;
          }
          synchronized (DiskLruCache.this)
          {
            if (DiskLruCache.this.closed) {
              return false;
            }
            while (this.delegate.hasNext())
            {
              Object localObject1 = (DiskLruCache.Entry)this.delegate.next();
              if (((DiskLruCache.Entry)localObject1).readable)
              {
                localObject1 = ((DiskLruCache.Entry)localObject1).snapshot();
                if (localObject1 != null)
                {
                  this.nextSnapshot = ((DiskLruCache.Snapshot)localObject1);
                  return true;
                }
              }
            }
            return false;
          }
        }
        
        public DiskLruCache.Snapshot next()
        {
          if (hasNext())
          {
            DiskLruCache.Snapshot localSnapshot = this.nextSnapshot;
            this.removeSnapshot = localSnapshot;
            this.nextSnapshot = null;
            return localSnapshot;
          }
          throw new NoSuchElementException();
        }
        
        /* Error */
        public void remove()
        {
          // Byte code:
          //   0: aload_0
          //   1: getfield 76	okhttp3/internal/cache/DiskLruCache$3:removeSnapshot	Lokhttp3/internal/cache/DiskLruCache$Snapshot;
          //   4: astore_1
          //   5: aload_1
          //   6: ifnull +32 -> 38
          //   9: aload_0
          //   10: getfield 24	okhttp3/internal/cache/DiskLruCache$3:this$0	Lokhttp3/internal/cache/DiskLruCache;
          //   13: aload_1
          //   14: invokestatic 88	okhttp3/internal/cache/DiskLruCache$Snapshot:access$000	(Lokhttp3/internal/cache/DiskLruCache$Snapshot;)Ljava/lang/String;
          //   17: invokevirtual 91	okhttp3/internal/cache/DiskLruCache:remove	(Ljava/lang/String;)Z
          //   20: pop
          //   21: goto +11 -> 32
          //   24: astore_1
          //   25: aload_0
          //   26: aconst_null
          //   27: putfield 76	okhttp3/internal/cache/DiskLruCache$3:removeSnapshot	Lokhttp3/internal/cache/DiskLruCache$Snapshot;
          //   30: aload_1
          //   31: athrow
          //   32: aload_0
          //   33: aconst_null
          //   34: putfield 76	okhttp3/internal/cache/DiskLruCache$3:removeSnapshot	Lokhttp3/internal/cache/DiskLruCache$Snapshot;
          //   37: return
          //   38: new 93	java/lang/IllegalStateException
          //   41: dup
          //   42: ldc 95
          //   44: invokespecial 98	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
          //   47: athrow
          //   48: astore_1
          //   49: goto -17 -> 32
          // Local variable table:
          //   start	length	slot	name	signature
          //   0	52	0	this	3
          //   4	10	1	localSnapshot	DiskLruCache.Snapshot
          //   24	7	1	localObject	Object
          //   48	1	1	localIOException	IOException
          // Exception table:
          //   from	to	target	type
          //   9	21	24	finally
          //   9	21	48	java/io/IOException
        }
      };
      return local3;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  void trimToSize()
    throws IOException
  {
    while (this.size > this.maxSize) {
      removeEntry((Entry)this.lruEntries.values().iterator().next());
    }
    this.mostRecentTrimFailed = false;
  }
  
  public final class Editor
  {
    private boolean done;
    final DiskLruCache.Entry entry;
    final boolean[] written;
    
    Editor(DiskLruCache.Entry paramEntry)
    {
      this.entry = paramEntry;
      if (paramEntry.readable) {
        this$1 = null;
      } else {
        this$1 = new boolean[DiskLruCache.this.valueCount];
      }
      this.written = DiskLruCache.this;
    }
    
    public void abort()
      throws IOException
    {
      synchronized (DiskLruCache.this)
      {
        if (!this.done)
        {
          if (this.entry.currentEditor == this) {
            DiskLruCache.this.completeEdit(this, false);
          }
          this.done = true;
          return;
        }
        IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
        localIllegalStateException.<init>();
        throw localIllegalStateException;
      }
    }
    
    public void abortUnlessCommitted()
    {
      synchronized (DiskLruCache.this)
      {
        if (!this.done)
        {
          Editor localEditor = this.entry.currentEditor;
          if (localEditor != this) {}
        }
      }
      try
      {
        DiskLruCache.this.completeEdit(this, false);
        return;
        localObject = finally;
        throw ((Throwable)localObject);
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
    }
    
    public void commit()
      throws IOException
    {
      synchronized (DiskLruCache.this)
      {
        if (!this.done)
        {
          if (this.entry.currentEditor == this) {
            DiskLruCache.this.completeEdit(this, true);
          }
          this.done = true;
          return;
        }
        IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
        localIllegalStateException.<init>();
        throw localIllegalStateException;
      }
    }
    
    void detach()
    {
      int i;
      if (this.entry.currentEditor == this) {
        i = 0;
      }
      for (;;)
      {
        DiskLruCache localDiskLruCache = DiskLruCache.this;
        if (i < localDiskLruCache.valueCount) {}
        try
        {
          localDiskLruCache.fileSystem.delete(this.entry.dirtyFiles[i]);
          i++;
          continue;
          this.entry.currentEditor = null;
          return;
        }
        catch (IOException localIOException)
        {
          for (;;) {}
        }
      }
    }
    
    public Sink newSink(int paramInt)
    {
      synchronized (DiskLruCache.this)
      {
        if (!this.done)
        {
          Object localObject1 = this.entry;
          if (((DiskLruCache.Entry)localObject1).currentEditor != this)
          {
            localObject1 = Okio.blackhole();
            return (Sink)localObject1;
          }
          if (!((DiskLruCache.Entry)localObject1).readable) {
            this.written[paramInt] = true;
          }
          localObject1 = localObject1.dirtyFiles[paramInt];
          try
          {
            Sink localSink = DiskLruCache.this.fileSystem.sink((File)localObject1);
            localObject1 = new okhttp3/internal/cache/DiskLruCache$Editor$1;
            ((1)localObject1).<init>(this, localSink);
            return (Sink)localObject1;
          }
          catch (FileNotFoundException localFileNotFoundException)
          {
            localObject2 = Okio.blackhole();
            return (Sink)localObject2;
          }
        }
        Object localObject2 = new java/lang/IllegalStateException;
        ((IllegalStateException)localObject2).<init>();
        throw ((Throwable)localObject2);
      }
    }
    
    public Source newSource(int paramInt)
    {
      synchronized (DiskLruCache.this)
      {
        if (!this.done)
        {
          DiskLruCache.Entry localEntry = this.entry;
          if (localEntry.readable)
          {
            Object localObject1 = localEntry.currentEditor;
            if (localObject1 == this) {
              try
              {
                localObject1 = DiskLruCache.this.fileSystem.source(localEntry.cleanFiles[paramInt]);
                return (Source)localObject1;
              }
              catch (FileNotFoundException localFileNotFoundException)
              {
                return null;
              }
            }
          }
          return null;
        }
        IllegalStateException localIllegalStateException = new java/lang/IllegalStateException;
        localIllegalStateException.<init>();
        throw localIllegalStateException;
      }
    }
  }
  
  private final class Entry
  {
    final File[] cleanFiles;
    DiskLruCache.Editor currentEditor;
    final File[] dirtyFiles;
    final String key;
    final long[] lengths;
    boolean readable;
    long sequenceNumber;
    
    Entry(String paramString)
    {
      this.key = paramString;
      int i = DiskLruCache.this.valueCount;
      this.lengths = new long[i];
      this.cleanFiles = new File[i];
      this.dirtyFiles = new File[i];
      paramString = new StringBuilder(paramString);
      paramString.append('.');
      int j = paramString.length();
      for (i = 0; i < DiskLruCache.this.valueCount; i++)
      {
        paramString.append(i);
        this.cleanFiles[i] = new File(DiskLruCache.this.directory, paramString.toString());
        paramString.append(".tmp");
        this.dirtyFiles[i] = new File(DiskLruCache.this.directory, paramString.toString());
        paramString.setLength(j);
      }
    }
    
    private IOException invalidLengths(String[] paramArrayOfString)
      throws IOException
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unexpected journal line: ");
      localStringBuilder.append(Arrays.toString(paramArrayOfString));
      throw new IOException(localStringBuilder.toString());
    }
    
    void setLengths(String[] paramArrayOfString)
      throws IOException
    {
      if (paramArrayOfString.length == DiskLruCache.this.valueCount)
      {
        int i = 0;
        try
        {
          while (i < paramArrayOfString.length)
          {
            this.lengths[i] = Long.parseLong(paramArrayOfString[i]);
            i++;
          }
          return;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          throw invalidLengths(paramArrayOfString);
        }
      }
      throw invalidLengths(paramArrayOfString);
    }
    
    DiskLruCache.Snapshot snapshot()
    {
      DiskLruCache localDiskLruCache;
      if (Thread.holdsLock(DiskLruCache.this))
      {
        Source[] arrayOfSource = new Source[DiskLruCache.this.valueCount];
        long[] arrayOfLong = (long[])this.lengths.clone();
        int i = 0;
        int j = 0;
        try
        {
          for (;;)
          {
            localObject = DiskLruCache.this;
            if (j >= ((DiskLruCache)localObject).valueCount) {
              break;
            }
            arrayOfSource[j] = ((DiskLruCache)localObject).fileSystem.source(this.cleanFiles[j]);
            j++;
          }
          Object localObject = new DiskLruCache.Snapshot((DiskLruCache)localObject, this.key, this.sequenceNumber, arrayOfSource, arrayOfLong);
          return (DiskLruCache.Snapshot)localObject;
        }
        catch (FileNotFoundException localFileNotFoundException)
        {
          for (j = i;; j++)
          {
            localDiskLruCache = DiskLruCache.this;
            if ((j >= localDiskLruCache.valueCount) || (arrayOfSource[j] == null)) {
              break;
            }
            Util.closeQuietly(arrayOfSource[j]);
          }
        }
      }
      try
      {
        localDiskLruCache.removeEntry(this);
        return null;
        throw new AssertionError();
      }
      catch (IOException localIOException)
      {
        for (;;) {}
      }
    }
    
    void writeLengths(BufferedSink paramBufferedSink)
      throws IOException
    {
      for (long l : this.lengths) {
        paramBufferedSink.writeByte(32).writeDecimalLong(l);
      }
    }
  }
  
  public final class Snapshot
    implements Closeable
  {
    private final String key;
    private final long[] lengths;
    private final long sequenceNumber;
    private final Source[] sources;
    
    Snapshot(String paramString, long paramLong, Source[] paramArrayOfSource, long[] paramArrayOfLong)
    {
      this.key = paramString;
      this.sequenceNumber = paramLong;
      this.sources = paramArrayOfSource;
      this.lengths = paramArrayOfLong;
    }
    
    public void close()
    {
      Source[] arrayOfSource = this.sources;
      int i = arrayOfSource.length;
      for (int j = 0; j < i; j++) {
        Util.closeQuietly(arrayOfSource[j]);
      }
    }
    
    @Nullable
    public DiskLruCache.Editor edit()
      throws IOException
    {
      return DiskLruCache.this.edit(this.key, this.sequenceNumber);
    }
    
    public long getLength(int paramInt)
    {
      return this.lengths[paramInt];
    }
    
    public Source getSource(int paramInt)
    {
      return this.sources[paramInt];
    }
    
    public String key()
    {
      return this.key;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okhttp3\internal\cache\DiskLruCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */