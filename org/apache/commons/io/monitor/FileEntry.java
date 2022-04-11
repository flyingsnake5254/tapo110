package org.apache.commons.io.monitor;

import java.io.File;
import java.io.Serializable;

public class FileEntry
  implements Serializable
{
  static final FileEntry[] EMPTY_ENTRIES = new FileEntry[0];
  private static final long serialVersionUID = -2505664948818681153L;
  private FileEntry[] children;
  private boolean directory;
  private boolean exists;
  private final File file;
  private long lastModified;
  private long length;
  private String name;
  private final FileEntry parent;
  
  public FileEntry(File paramFile)
  {
    this(null, paramFile);
  }
  
  public FileEntry(FileEntry paramFileEntry, File paramFile)
  {
    if (paramFile != null)
    {
      this.file = paramFile;
      this.parent = paramFileEntry;
      this.name = paramFile.getName();
      return;
    }
    throw new IllegalArgumentException("File is missing");
  }
  
  public FileEntry[] getChildren()
  {
    FileEntry[] arrayOfFileEntry = this.children;
    if (arrayOfFileEntry == null) {
      arrayOfFileEntry = EMPTY_ENTRIES;
    }
    return arrayOfFileEntry;
  }
  
  public File getFile()
  {
    return this.file;
  }
  
  public long getLastModified()
  {
    return this.lastModified;
  }
  
  public long getLength()
  {
    return this.length;
  }
  
  public int getLevel()
  {
    FileEntry localFileEntry = this.parent;
    int i;
    if (localFileEntry == null) {
      i = 0;
    } else {
      i = localFileEntry.getLevel() + 1;
    }
    return i;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public FileEntry getParent()
  {
    return this.parent;
  }
  
  public boolean isDirectory()
  {
    return this.directory;
  }
  
  public boolean isExists()
  {
    return this.exists;
  }
  
  public FileEntry newChildInstance(File paramFile)
  {
    return new FileEntry(this, paramFile);
  }
  
  public boolean refresh(File paramFile)
  {
    boolean bool1 = this.exists;
    long l1 = this.lastModified;
    boolean bool2 = this.directory;
    long l2 = this.length;
    this.name = paramFile.getName();
    boolean bool3 = paramFile.exists();
    this.exists = bool3;
    boolean bool4 = true;
    if ((bool3) && (paramFile.isDirectory())) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    this.directory = bool3;
    bool3 = this.exists;
    long l3 = 0L;
    if (bool3) {
      l4 = paramFile.lastModified();
    } else {
      l4 = 0L;
    }
    this.lastModified = l4;
    long l4 = l3;
    if (this.exists)
    {
      l4 = l3;
      if (!this.directory) {
        l4 = paramFile.length();
      }
    }
    this.length = l4;
    bool3 = bool4;
    if (this.exists == bool1)
    {
      bool3 = bool4;
      if (this.lastModified == l1)
      {
        bool3 = bool4;
        if (this.directory == bool2) {
          if (l4 != l2) {
            bool3 = bool4;
          } else {
            bool3 = false;
          }
        }
      }
    }
    return bool3;
  }
  
  public void setChildren(FileEntry[] paramArrayOfFileEntry)
  {
    this.children = paramArrayOfFileEntry;
  }
  
  public void setDirectory(boolean paramBoolean)
  {
    this.directory = paramBoolean;
  }
  
  public void setExists(boolean paramBoolean)
  {
    this.exists = paramBoolean;
  }
  
  public void setLastModified(long paramLong)
  {
    this.lastModified = paramLong;
  }
  
  public void setLength(long paramLong)
  {
    this.length = paramLong;
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\io\monitor\FileEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */