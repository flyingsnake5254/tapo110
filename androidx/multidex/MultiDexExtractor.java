package androidx.multidex;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

final class MultiDexExtractor
  implements Closeable
{
  private static final int BUFFER_SIZE = 16384;
  private static final String DEX_PREFIX = "classes";
  static final String DEX_SUFFIX = ".dex";
  private static final String EXTRACTED_NAME_EXT = ".classes";
  static final String EXTRACTED_SUFFIX = ".zip";
  private static final String KEY_CRC = "crc";
  private static final String KEY_DEX_CRC = "dex.crc.";
  private static final String KEY_DEX_NUMBER = "dex.number";
  private static final String KEY_DEX_TIME = "dex.time.";
  private static final String KEY_TIME_STAMP = "timestamp";
  private static final String LOCK_FILENAME = "MultiDex.lock";
  private static final int MAX_EXTRACT_ATTEMPTS = 3;
  private static final long NO_VALUE = -1L;
  private static final String PREFS_FILE = "multidex.version";
  private static final String TAG = "MultiDex";
  private final FileLock cacheLock;
  private final File dexDir;
  private final FileChannel lockChannel;
  private final RandomAccessFile lockRaf;
  private final File sourceApk;
  private final long sourceCrc;
  
  MultiDexExtractor(File paramFile1, File paramFile2)
    throws IOException
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("MultiDexExtractor(");
    ((StringBuilder)localObject).append(paramFile1.getPath());
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramFile2.getPath());
    ((StringBuilder)localObject).append(")");
    Log.i("MultiDex", ((StringBuilder)localObject).toString());
    this.sourceApk = paramFile1;
    this.dexDir = paramFile2;
    this.sourceCrc = getZipCrc(paramFile1);
    paramFile1 = new File(paramFile2, "MultiDex.lock");
    paramFile2 = new RandomAccessFile(paramFile1, "rw");
    this.lockRaf = paramFile2;
    try
    {
      localObject = paramFile2.getChannel();
      this.lockChannel = ((FileChannel)localObject);
      try
      {
        paramFile2 = new java/lang/StringBuilder;
        paramFile2.<init>();
        paramFile2.append("Blocking on lock ");
        paramFile2.append(paramFile1.getPath());
        Log.i("MultiDex", paramFile2.toString());
        this.cacheLock = ((FileChannel)localObject).lock();
        paramFile2 = new java/lang/StringBuilder;
        paramFile2.<init>();
        paramFile2.append(paramFile1.getPath());
        paramFile2.append(" locked");
        Log.i("MultiDex", paramFile2.toString());
        return;
      }
      catch (Error paramFile1) {}catch (RuntimeException paramFile1) {}catch (IOException paramFile1) {}
      closeQuietly(this.lockChannel);
      throw paramFile1;
    }
    catch (Error paramFile1) {}catch (RuntimeException paramFile1) {}catch (IOException paramFile1) {}
    closeQuietly(this.lockRaf);
    throw paramFile1;
  }
  
  private void clearDexDir()
  {
    File[] arrayOfFile = this.dexDir.listFiles(new FileFilter()
    {
      public boolean accept(File paramAnonymousFile)
      {
        return paramAnonymousFile.getName().equals("MultiDex.lock") ^ true;
      }
    });
    Object localObject;
    if (arrayOfFile == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Failed to list secondary dex dir content (");
      ((StringBuilder)localObject).append(this.dexDir.getPath());
      ((StringBuilder)localObject).append(").");
      Log.w("MultiDex", ((StringBuilder)localObject).toString());
      return;
    }
    int i = arrayOfFile.length;
    for (int j = 0; j < i; j++)
    {
      localObject = arrayOfFile[j];
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Trying to delete old file ");
      localStringBuilder.append(((File)localObject).getPath());
      localStringBuilder.append(" of size ");
      localStringBuilder.append(((File)localObject).length());
      Log.i("MultiDex", localStringBuilder.toString());
      if (!((File)localObject).delete())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to delete old file ");
        localStringBuilder.append(((File)localObject).getPath());
        Log.w("MultiDex", localStringBuilder.toString());
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Deleted old file ");
        localStringBuilder.append(((File)localObject).getPath());
        Log.i("MultiDex", localStringBuilder.toString());
      }
    }
  }
  
  private static void closeQuietly(Closeable paramCloseable)
  {
    try
    {
      paramCloseable.close();
    }
    catch (IOException paramCloseable)
    {
      Log.w("MultiDex", "Failed to close resource", paramCloseable);
    }
  }
  
  /* Error */
  private static void extract(ZipFile paramZipFile, ZipEntry paramZipEntry, File paramFile, String paramString)
    throws IOException, java.io.FileNotFoundException
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 202	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   5: astore_0
    //   6: new 80	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   13: astore 4
    //   15: aload 4
    //   17: ldc -52
    //   19: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: pop
    //   23: aload 4
    //   25: aload_3
    //   26: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: pop
    //   30: aload 4
    //   32: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   35: ldc 27
    //   37: aload_2
    //   38: invokevirtual 208	java/io/File:getParentFile	()Ljava/io/File;
    //   41: invokestatic 212	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   44: astore_3
    //   45: new 80	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   52: astore 4
    //   54: aload 4
    //   56: ldc -42
    //   58: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 4
    //   64: aload_3
    //   65: invokevirtual 93	java/io/File:getPath	()Ljava/lang/String;
    //   68: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: ldc 57
    //   74: aload 4
    //   76: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   79: invokestatic 106	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   82: pop
    //   83: new 216	java/util/zip/ZipOutputStream
    //   86: astore 4
    //   88: new 218	java/io/BufferedOutputStream
    //   91: astore 5
    //   93: new 220	java/io/FileOutputStream
    //   96: astore 6
    //   98: aload 6
    //   100: aload_3
    //   101: invokespecial 223	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   104: aload 5
    //   106: aload 6
    //   108: invokespecial 226	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   111: aload 4
    //   113: aload 5
    //   115: invokespecial 227	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   118: new 229	java/util/zip/ZipEntry
    //   121: astore 6
    //   123: aload 6
    //   125: ldc -25
    //   127: invokespecial 234	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   130: aload 6
    //   132: aload_1
    //   133: invokevirtual 237	java/util/zip/ZipEntry:getTime	()J
    //   136: invokevirtual 241	java/util/zip/ZipEntry:setTime	(J)V
    //   139: aload 4
    //   141: aload 6
    //   143: invokevirtual 245	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   146: sipush 16384
    //   149: newarray <illegal type>
    //   151: astore_1
    //   152: aload_0
    //   153: aload_1
    //   154: invokevirtual 251	java/io/InputStream:read	([B)I
    //   157: istore 7
    //   159: iload 7
    //   161: iconst_m1
    //   162: if_icmpeq +22 -> 184
    //   165: aload 4
    //   167: aload_1
    //   168: iconst_0
    //   169: iload 7
    //   171: invokevirtual 255	java/util/zip/ZipOutputStream:write	([BII)V
    //   174: aload_0
    //   175: aload_1
    //   176: invokevirtual 251	java/io/InputStream:read	([B)I
    //   179: istore 7
    //   181: goto -22 -> 159
    //   184: aload 4
    //   186: invokevirtual 258	java/util/zip/ZipOutputStream:closeEntry	()V
    //   189: aload 4
    //   191: invokevirtual 259	java/util/zip/ZipOutputStream:close	()V
    //   194: aload_3
    //   195: invokevirtual 262	java/io/File:setReadOnly	()Z
    //   198: ifeq +132 -> 330
    //   201: new 80	java/lang/StringBuilder
    //   204: astore_1
    //   205: aload_1
    //   206: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   209: aload_1
    //   210: ldc_w 264
    //   213: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: pop
    //   217: aload_1
    //   218: aload_2
    //   219: invokevirtual 93	java/io/File:getPath	()Ljava/lang/String;
    //   222: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: ldc 57
    //   228: aload_1
    //   229: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   232: invokestatic 106	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   235: pop
    //   236: aload_3
    //   237: aload_2
    //   238: invokevirtual 268	java/io/File:renameTo	(Ljava/io/File;)Z
    //   241: istore 8
    //   243: iload 8
    //   245: ifeq +13 -> 258
    //   248: aload_0
    //   249: invokestatic 148	androidx/multidex/MultiDexExtractor:closeQuietly	(Ljava/io/Closeable;)V
    //   252: aload_3
    //   253: invokevirtual 180	java/io/File:delete	()Z
    //   256: pop
    //   257: return
    //   258: new 71	java/io/IOException
    //   261: astore_1
    //   262: new 80	java/lang/StringBuilder
    //   265: astore 4
    //   267: aload 4
    //   269: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   272: aload 4
    //   274: ldc_w 270
    //   277: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 4
    //   283: aload_3
    //   284: invokevirtual 273	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   287: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: pop
    //   291: aload 4
    //   293: ldc_w 275
    //   296: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   299: pop
    //   300: aload 4
    //   302: aload_2
    //   303: invokevirtual 273	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   306: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: pop
    //   310: aload 4
    //   312: ldc_w 277
    //   315: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: pop
    //   319: aload_1
    //   320: aload 4
    //   322: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   325: invokespecial 278	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   328: aload_1
    //   329: athrow
    //   330: new 71	java/io/IOException
    //   333: astore_1
    //   334: new 80	java/lang/StringBuilder
    //   337: astore 4
    //   339: aload 4
    //   341: invokespecial 81	java/lang/StringBuilder:<init>	()V
    //   344: aload 4
    //   346: ldc_w 280
    //   349: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 4
    //   355: aload_3
    //   356: invokevirtual 273	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   359: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   362: pop
    //   363: aload 4
    //   365: ldc_w 282
    //   368: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: pop
    //   372: aload 4
    //   374: aload_2
    //   375: invokevirtual 273	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   378: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: pop
    //   382: aload 4
    //   384: ldc_w 284
    //   387: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload_1
    //   392: aload 4
    //   394: invokevirtual 100	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokespecial 278	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   400: aload_1
    //   401: athrow
    //   402: astore_1
    //   403: aload 4
    //   405: invokevirtual 259	java/util/zip/ZipOutputStream:close	()V
    //   408: aload_1
    //   409: athrow
    //   410: astore_1
    //   411: aload_0
    //   412: invokestatic 148	androidx/multidex/MultiDexExtractor:closeQuietly	(Ljava/io/Closeable;)V
    //   415: aload_3
    //   416: invokevirtual 180	java/io/File:delete	()Z
    //   419: pop
    //   420: aload_1
    //   421: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	422	0	paramZipFile	ZipFile
    //   0	422	1	paramZipEntry	ZipEntry
    //   0	422	2	paramFile	File
    //   0	422	3	paramString	String
    //   13	391	4	localObject1	Object
    //   91	23	5	localBufferedOutputStream	java.io.BufferedOutputStream
    //   96	46	6	localObject2	Object
    //   157	23	7	i	int
    //   241	3	8	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   118	159	402	finally
    //   165	181	402	finally
    //   184	189	402	finally
    //   83	118	410	finally
    //   189	243	410	finally
    //   258	330	410	finally
    //   330	402	410	finally
    //   403	410	410	finally
  }
  
  private static SharedPreferences getMultiDexPreferences(Context paramContext)
  {
    int i;
    if (Build.VERSION.SDK_INT < 11) {
      i = 0;
    } else {
      i = 4;
    }
    return paramContext.getSharedPreferences("multidex.version", i);
  }
  
  private static long getTimeStamp(File paramFile)
  {
    long l1 = paramFile.lastModified();
    long l2 = l1;
    if (l1 == -1L) {
      l2 = l1 - 1L;
    }
    return l2;
  }
  
  private static long getZipCrc(File paramFile)
    throws IOException
  {
    long l1 = ZipUtil.getZipCrc(paramFile);
    long l2 = l1;
    if (l1 == -1L) {
      l2 = l1 - 1L;
    }
    return l2;
  }
  
  private static boolean isModified(Context paramContext, File paramFile, long paramLong, String paramString)
  {
    paramContext = getMultiDexPreferences(paramContext);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("timestamp");
    if (paramContext.getLong(localStringBuilder.toString(), -1L) == getTimeStamp(paramFile))
    {
      paramFile = new StringBuilder();
      paramFile.append(paramString);
      paramFile.append("crc");
      if (paramContext.getLong(paramFile.toString(), -1L) == paramLong)
      {
        bool = false;
        break label104;
      }
    }
    boolean bool = true;
    label104:
    return bool;
  }
  
  private List<ExtractedDex> loadExistingExtractions(Context paramContext, String paramString)
    throws IOException
  {
    Log.i("MultiDex", "loading existing secondary dex files");
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.sourceApk.getName());
    ((StringBuilder)localObject1).append(".classes");
    localObject1 = ((StringBuilder)localObject1).toString();
    paramContext = getMultiDexPreferences(paramContext);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append("dex.number");
    int i = paramContext.getInt(((StringBuilder)localObject2).toString(), 1);
    localObject2 = new ArrayList(i - 1);
    int j = 2;
    while (j <= i)
    {
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append((String)localObject1);
      ((StringBuilder)localObject3).append(j);
      ((StringBuilder)localObject3).append(".zip");
      localObject3 = ((StringBuilder)localObject3).toString();
      localObject3 = new ExtractedDex(this.dexDir, (String)localObject3);
      if (((File)localObject3).isFile())
      {
        ((ExtractedDex)localObject3).crc = getZipCrc((File)localObject3);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("dex.crc.");
        localStringBuilder.append(j);
        long l1 = paramContext.getLong(localStringBuilder.toString(), -1L);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("dex.time.");
        localStringBuilder.append(j);
        long l2 = paramContext.getLong(localStringBuilder.toString(), -1L);
        long l3 = ((File)localObject3).lastModified();
        if ((l2 == l3) && (l1 == ((ExtractedDex)localObject3).crc))
        {
          ((List)localObject2).add(localObject3);
          j++;
        }
        else
        {
          paramContext = new StringBuilder();
          paramContext.append("Invalid extracted dex: ");
          paramContext.append(localObject3);
          paramContext.append(" (key \"");
          paramContext.append(paramString);
          paramContext.append("\"), expected modification time: ");
          paramContext.append(l2);
          paramContext.append(", modification time: ");
          paramContext.append(l3);
          paramContext.append(", expected crc: ");
          paramContext.append(l1);
          paramContext.append(", file crc: ");
          paramContext.append(((ExtractedDex)localObject3).crc);
          throw new IOException(paramContext.toString());
        }
      }
      else
      {
        paramContext = new StringBuilder();
        paramContext.append("Missing extracted secondary dex file '");
        paramContext.append(((File)localObject3).getPath());
        paramContext.append("'");
        throw new IOException(paramContext.toString());
      }
    }
    return (List<ExtractedDex>)localObject2;
  }
  
  private List<ExtractedDex> performExtractions()
    throws IOException
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(this.sourceApk.getName());
    ((StringBuilder)localObject1).append(".classes");
    String str = ((StringBuilder)localObject1).toString();
    clearDexDir();
    ArrayList localArrayList = new ArrayList();
    ZipFile localZipFile = new ZipFile(this.sourceApk);
    try
    {
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      ((StringBuilder)localObject1).append("classes");
      ((StringBuilder)localObject1).append(2);
      ((StringBuilder)localObject1).append(".dex");
      localObject1 = localZipFile.getEntry(((StringBuilder)localObject1).toString());
      int i = 2;
      while (localObject1 != null)
      {
        Object localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>();
        ((StringBuilder)localObject3).append(str);
        ((StringBuilder)localObject3).append(i);
        ((StringBuilder)localObject3).append(".zip");
        localObject3 = ((StringBuilder)localObject3).toString();
        ExtractedDex localExtractedDex = new androidx/multidex/MultiDexExtractor$ExtractedDex;
        localExtractedDex.<init>(this.dexDir, (String)localObject3);
        localArrayList.add(localExtractedDex);
        localObject3 = new java/lang/StringBuilder;
        ((StringBuilder)localObject3).<init>();
        ((StringBuilder)localObject3).append("Extraction is needed for file ");
        ((StringBuilder)localObject3).append(localExtractedDex);
        Log.i("MultiDex", ((StringBuilder)localObject3).toString());
        int j = 0;
        int k = 0;
        while ((j < 3) && (k == 0))
        {
          extract(localZipFile, (ZipEntry)localObject1, localExtractedDex, str);
          try
          {
            localExtractedDex.crc = getZipCrc(localExtractedDex);
            k = 1;
          }
          catch (IOException localIOException3)
          {
            localObject3 = new java/lang/StringBuilder;
            ((StringBuilder)localObject3).<init>();
            ((StringBuilder)localObject3).append("Failed to read crc from ");
            ((StringBuilder)localObject3).append(localExtractedDex.getAbsolutePath());
            Log.w("MultiDex", ((StringBuilder)localObject3).toString(), localIOException3);
            k = 0;
          }
          StringBuilder localStringBuilder = new java/lang/StringBuilder;
          localStringBuilder.<init>();
          localStringBuilder.append("Extraction ");
          if (k != 0) {
            localObject3 = "succeeded";
          } else {
            localObject3 = "failed";
          }
          localStringBuilder.append((String)localObject3);
          localStringBuilder.append(" '");
          localStringBuilder.append(localExtractedDex.getAbsolutePath());
          localStringBuilder.append("': length ");
          localStringBuilder.append(localExtractedDex.length());
          localStringBuilder.append(" - crc: ");
          localStringBuilder.append(localExtractedDex.crc);
          Log.i("MultiDex", localStringBuilder.toString());
          if (k == 0)
          {
            localExtractedDex.delete();
            if (localExtractedDex.exists())
            {
              localObject3 = new java/lang/StringBuilder;
              ((StringBuilder)localObject3).<init>();
              ((StringBuilder)localObject3).append("Failed to delete corrupted secondary dex '");
              ((StringBuilder)localObject3).append(localExtractedDex.getPath());
              ((StringBuilder)localObject3).append("'");
              Log.w("MultiDex", ((StringBuilder)localObject3).toString());
            }
          }
          j++;
        }
        if (k != 0)
        {
          i++;
          localObject1 = new java/lang/StringBuilder;
          ((StringBuilder)localObject1).<init>();
          ((StringBuilder)localObject1).append("classes");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append(".dex");
          localObject1 = localZipFile.getEntry(((StringBuilder)localObject1).toString());
        }
        else
        {
          localObject1 = new java/io/IOException;
          localObject3 = new java/lang/StringBuilder;
          ((StringBuilder)localObject3).<init>();
          ((StringBuilder)localObject3).append("Could not create zip file ");
          ((StringBuilder)localObject3).append(localExtractedDex.getAbsolutePath());
          ((StringBuilder)localObject3).append(" for secondary dex (");
          ((StringBuilder)localObject3).append(i);
          ((StringBuilder)localObject3).append(")");
          ((IOException)localObject1).<init>(((StringBuilder)localObject3).toString());
          throw ((Throwable)localObject1);
        }
      }
      return localArrayList;
    }
    finally
    {
      try
      {
        localZipFile.close();
      }
      catch (IOException localIOException2)
      {
        Log.w("MultiDex", "Failed to close resource", localIOException2);
      }
    }
  }
  
  private static void putStoredApkInfo(Context paramContext, String paramString, long paramLong1, long paramLong2, List<ExtractedDex> paramList)
  {
    paramContext = getMultiDexPreferences(paramContext).edit();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("timestamp");
    paramContext.putLong(((StringBuilder)localObject).toString(), paramLong1);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("crc");
    paramContext.putLong(((StringBuilder)localObject).toString(), paramLong2);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("dex.number");
    paramContext.putInt(((StringBuilder)localObject).toString(), paramList.size() + 1);
    localObject = paramList.iterator();
    for (int i = 2; ((Iterator)localObject).hasNext(); i++)
    {
      paramList = (ExtractedDex)((Iterator)localObject).next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("dex.crc.");
      localStringBuilder.append(i);
      paramContext.putLong(localStringBuilder.toString(), paramList.crc);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("dex.time.");
      localStringBuilder.append(i);
      paramContext.putLong(localStringBuilder.toString(), paramList.lastModified());
    }
    paramContext.commit();
  }
  
  public void close()
    throws IOException
  {
    this.cacheLock.release();
    this.lockChannel.close();
    this.lockRaf.close();
  }
  
  List<? extends File> load(Context paramContext, String paramString, boolean paramBoolean)
    throws IOException
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("MultiDexExtractor.load(");
    ((StringBuilder)localObject).append(this.sourceApk.getPath());
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(")");
    Log.i("MultiDex", ((StringBuilder)localObject).toString());
    if (this.cacheLock.isValid())
    {
      List localList;
      if ((!paramBoolean) && (!isModified(paramContext, this.sourceApk, this.sourceCrc, paramString)))
      {
        try
        {
          localObject = loadExistingExtractions(paramContext, paramString);
          paramContext = (Context)localObject;
        }
        catch (IOException localIOException)
        {
          Log.w("MultiDex", "Failed to reload existing extracted secondary dex files, falling back to fresh extraction", localIOException);
          localList = performExtractions();
          putStoredApkInfo(paramContext, paramString, getTimeStamp(this.sourceApk), this.sourceCrc, localList);
          paramContext = localList;
        }
      }
      else
      {
        if (paramBoolean) {
          Log.i("MultiDex", "Forced extraction must be performed.");
        } else {
          Log.i("MultiDex", "Detected that extraction must be performed.");
        }
        localList = performExtractions();
        putStoredApkInfo(paramContext, paramString, getTimeStamp(this.sourceApk), this.sourceCrc, localList);
        paramContext = localList;
      }
      paramString = new StringBuilder();
      paramString.append("load found ");
      paramString.append(paramContext.size());
      paramString.append(" secondary dex files");
      Log.i("MultiDex", paramString.toString());
      return paramContext;
    }
    throw new IllegalStateException("MultiDexExtractor was closed");
  }
  
  private static class ExtractedDex
    extends File
  {
    public long crc = -1L;
    
    public ExtractedDex(File paramFile, String paramString)
    {
      super(paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\multidex\MultiDexExtractor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */