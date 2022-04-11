package com.jcraft.jsch;

public class SftpStatVFS
{
  int atime;
  private long bavail;
  private long bfree;
  private long blocks;
  private long bsize;
  String[] extended = null;
  private long favail;
  private long ffree;
  private long files;
  private long flag;
  int flags = 0;
  private long frsize;
  private long fsid;
  int gid;
  int mtime;
  private long namemax;
  int permissions;
  long size;
  int uid;
  
  static SftpStatVFS getStatVFS(Buffer paramBuffer)
  {
    SftpStatVFS localSftpStatVFS = new SftpStatVFS();
    localSftpStatVFS.bsize = paramBuffer.getLong();
    localSftpStatVFS.frsize = paramBuffer.getLong();
    localSftpStatVFS.blocks = paramBuffer.getLong();
    localSftpStatVFS.bfree = paramBuffer.getLong();
    localSftpStatVFS.bavail = paramBuffer.getLong();
    localSftpStatVFS.files = paramBuffer.getLong();
    localSftpStatVFS.ffree = paramBuffer.getLong();
    localSftpStatVFS.favail = paramBuffer.getLong();
    localSftpStatVFS.fsid = paramBuffer.getLong();
    int i = (int)paramBuffer.getLong();
    localSftpStatVFS.namemax = paramBuffer.getLong();
    long l1 = 0L;
    long l2;
    if ((i & 0x1) != 0) {
      l2 = 1L;
    } else {
      l2 = 0L;
    }
    localSftpStatVFS.flag = l2;
    if ((i & 0x2) != 0) {
      l1 = 2L;
    }
    localSftpStatVFS.flag = (l2 | l1);
    return localSftpStatVFS;
  }
  
  public long getAvail()
  {
    return getFragmentSize() * getFreeBlocks() / 1024L;
  }
  
  public long getAvailBlocks()
  {
    return this.bavail;
  }
  
  public long getAvailForNonRoot()
  {
    return getFragmentSize() * getAvailBlocks() / 1024L;
  }
  
  public long getAvailINodes()
  {
    return this.favail;
  }
  
  public long getBlockSize()
  {
    return this.bsize;
  }
  
  public long getBlocks()
  {
    return this.blocks;
  }
  
  public int getCapacity()
  {
    return (int)((getBlocks() - getFreeBlocks()) * 100L / getBlocks());
  }
  
  public long getFileSystemID()
  {
    return this.fsid;
  }
  
  public long getFragmentSize()
  {
    return this.frsize;
  }
  
  public long getFreeBlocks()
  {
    return this.bfree;
  }
  
  public long getFreeINodes()
  {
    return this.ffree;
  }
  
  public long getINodes()
  {
    return this.files;
  }
  
  public long getMaximumFilenameLength()
  {
    return this.namemax;
  }
  
  public long getMountFlag()
  {
    return this.flag;
  }
  
  public long getSize()
  {
    return getFragmentSize() * getBlocks() / 1024L;
  }
  
  public long getUsed()
  {
    return getFragmentSize() * (getBlocks() - getFreeBlocks()) / 1024L;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\SftpStatVFS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */