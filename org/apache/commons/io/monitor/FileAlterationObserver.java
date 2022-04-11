package org.apache.commons.io.monitor;

import java.io.File;
import java.io.FileFilter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.io.IOCase;
import org.apache.commons.io.comparator.NameFileComparator;

public class FileAlterationObserver
  implements Serializable
{
  private static final long serialVersionUID = 1185122225658782848L;
  private final Comparator<File> comparator;
  private final FileFilter fileFilter;
  private final List<a> listeners = new CopyOnWriteArrayList();
  private final FileEntry rootEntry;
  
  public FileAlterationObserver(File paramFile)
  {
    this(paramFile, null);
  }
  
  public FileAlterationObserver(File paramFile, FileFilter paramFileFilter)
  {
    this(paramFile, paramFileFilter, null);
  }
  
  public FileAlterationObserver(File paramFile, FileFilter paramFileFilter, IOCase paramIOCase)
  {
    this(new FileEntry(paramFile), paramFileFilter, paramIOCase);
  }
  
  public FileAlterationObserver(String paramString)
  {
    this(new File(paramString));
  }
  
  public FileAlterationObserver(String paramString, FileFilter paramFileFilter)
  {
    this(new File(paramString), paramFileFilter);
  }
  
  public FileAlterationObserver(String paramString, FileFilter paramFileFilter, IOCase paramIOCase)
  {
    this(new File(paramString), paramFileFilter, paramIOCase);
  }
  
  protected FileAlterationObserver(FileEntry paramFileEntry, FileFilter paramFileFilter, IOCase paramIOCase)
  {
    if (paramFileEntry != null)
    {
      if (paramFileEntry.getFile() != null)
      {
        this.rootEntry = paramFileEntry;
        this.fileFilter = paramFileFilter;
        if ((paramIOCase != null) && (!paramIOCase.equals(IOCase.SYSTEM)))
        {
          if (paramIOCase.equals(IOCase.INSENSITIVE)) {
            this.comparator = NameFileComparator.NAME_INSENSITIVE_COMPARATOR;
          } else {
            this.comparator = NameFileComparator.NAME_COMPARATOR;
          }
        }
        else {
          this.comparator = NameFileComparator.NAME_SYSTEM_COMPARATOR;
        }
        return;
      }
      throw new IllegalArgumentException("Root directory is missing");
    }
    throw new IllegalArgumentException("Root entry is missing");
  }
  
  private void checkAndNotify(FileEntry paramFileEntry, FileEntry[] paramArrayOfFileEntry, File[] paramArrayOfFile)
  {
    FileEntry[] arrayOfFileEntry;
    if (paramArrayOfFile.length > 0) {
      arrayOfFileEntry = new FileEntry[paramArrayOfFile.length];
    } else {
      arrayOfFileEntry = FileEntry.EMPTY_ENTRIES;
    }
    int i = paramArrayOfFileEntry.length;
    int j = 0;
    int k = 0;
    int m;
    for (;;)
    {
      m = k;
      if (j >= i) {
        break;
      }
      FileEntry localFileEntry = paramArrayOfFileEntry[j];
      while ((k < paramArrayOfFile.length) && (this.comparator.compare(localFileEntry.getFile(), paramArrayOfFile[k]) > 0))
      {
        arrayOfFileEntry[k] = createFileEntry(paramFileEntry, paramArrayOfFile[k]);
        doCreate(arrayOfFileEntry[k]);
        k++;
      }
      if ((k < paramArrayOfFile.length) && (this.comparator.compare(localFileEntry.getFile(), paramArrayOfFile[k]) == 0))
      {
        doMatch(localFileEntry, paramArrayOfFile[k]);
        checkAndNotify(localFileEntry, localFileEntry.getChildren(), listFiles(paramArrayOfFile[k]));
        arrayOfFileEntry[k] = localFileEntry;
        k++;
      }
      else
      {
        checkAndNotify(localFileEntry, localFileEntry.getChildren(), org.apache.commons.io.a.i);
        doDelete(localFileEntry);
      }
      j++;
    }
    while (m < paramArrayOfFile.length)
    {
      arrayOfFileEntry[m] = createFileEntry(paramFileEntry, paramArrayOfFile[m]);
      doCreate(arrayOfFileEntry[m]);
      m++;
    }
    paramFileEntry.setChildren(arrayOfFileEntry);
  }
  
  private FileEntry createFileEntry(FileEntry paramFileEntry, File paramFile)
  {
    paramFileEntry = paramFileEntry.newChildInstance(paramFile);
    paramFileEntry.refresh(paramFile);
    paramFileEntry.setChildren(doListFiles(paramFile, paramFileEntry));
    return paramFileEntry;
  }
  
  private void doCreate(FileEntry paramFileEntry)
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramFileEntry.isDirectory()) {
        locala.f(paramFileEntry.getFile());
      } else {
        locala.c(paramFileEntry.getFile());
      }
    }
    paramFileEntry = paramFileEntry.getChildren();
    int i = paramFileEntry.length;
    for (int j = 0; j < i; j++) {
      doCreate(paramFileEntry[j]);
    }
  }
  
  private void doDelete(FileEntry paramFileEntry)
  {
    Iterator localIterator = this.listeners.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (paramFileEntry.isDirectory()) {
        locala.d(paramFileEntry.getFile());
      } else {
        locala.a(paramFileEntry.getFile());
      }
    }
  }
  
  private FileEntry[] doListFiles(File paramFile, FileEntry paramFileEntry)
  {
    File[] arrayOfFile = listFiles(paramFile);
    if (arrayOfFile.length > 0) {
      paramFile = new FileEntry[arrayOfFile.length];
    } else {
      paramFile = FileEntry.EMPTY_ENTRIES;
    }
    for (int i = 0; i < arrayOfFile.length; i++) {
      paramFile[i] = createFileEntry(paramFileEntry, arrayOfFile[i]);
    }
    return paramFile;
  }
  
  private void doMatch(FileEntry paramFileEntry, File paramFile)
  {
    if (paramFileEntry.refresh(paramFile))
    {
      Iterator localIterator = this.listeners.iterator();
      while (localIterator.hasNext())
      {
        a locala = (a)localIterator.next();
        if (paramFileEntry.isDirectory()) {
          locala.e(paramFile);
        } else {
          locala.b(paramFile);
        }
      }
    }
  }
  
  private File[] listFiles(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      localObject = this.fileFilter;
      if (localObject == null) {
        paramFile = paramFile.listFiles();
      } else {
        paramFile = paramFile.listFiles((FileFilter)localObject);
      }
    }
    else
    {
      paramFile = null;
    }
    Object localObject = paramFile;
    if (paramFile == null) {
      localObject = org.apache.commons.io.a.i;
    }
    paramFile = this.comparator;
    if ((paramFile != null) && (localObject.length > 1)) {
      Arrays.sort((Object[])localObject, paramFile);
    }
    return (File[])localObject;
  }
  
  public void addListener(a parama)
  {
    if (parama != null) {
      this.listeners.add(parama);
    }
  }
  
  public void checkAndNotify()
  {
    Object localObject = this.listeners.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).g(this);
    }
    localObject = this.rootEntry.getFile();
    if (((File)localObject).exists())
    {
      FileEntry localFileEntry = this.rootEntry;
      checkAndNotify(localFileEntry, localFileEntry.getChildren(), listFiles((File)localObject));
    }
    else if (this.rootEntry.isExists())
    {
      localObject = this.rootEntry;
      checkAndNotify((FileEntry)localObject, ((FileEntry)localObject).getChildren(), org.apache.commons.io.a.i);
    }
    localObject = this.listeners.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((a)((Iterator)localObject).next()).h(this);
    }
  }
  
  public void destroy()
    throws Exception
  {}
  
  public File getDirectory()
  {
    return this.rootEntry.getFile();
  }
  
  public FileFilter getFileFilter()
  {
    return this.fileFilter;
  }
  
  public Iterable<a> getListeners()
  {
    return this.listeners;
  }
  
  public void initialize()
    throws Exception
  {
    Object localObject = this.rootEntry;
    ((FileEntry)localObject).refresh(((FileEntry)localObject).getFile());
    localObject = doListFiles(this.rootEntry.getFile(), this.rootEntry);
    this.rootEntry.setChildren((FileEntry[])localObject);
  }
  
  public void removeListener(a parama)
  {
    while ((parama != null) && (this.listeners.remove(parama))) {}
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getClass().getSimpleName());
    localStringBuilder.append("[file='");
    localStringBuilder.append(getDirectory().getPath());
    localStringBuilder.append('\'');
    if (this.fileFilter != null)
    {
      localStringBuilder.append(", ");
      localStringBuilder.append(this.fileFilter.toString());
    }
    localStringBuilder.append(", listeners=");
    localStringBuilder.append(this.listeners.size());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\monitor\FileAlterationObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */