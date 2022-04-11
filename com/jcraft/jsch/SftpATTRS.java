package com.jcraft.jsch;

import java.util.Date;

public class SftpATTRS
{
  public static final int SSH_FILEXFER_ATTR_ACMODTIME = 8;
  public static final int SSH_FILEXFER_ATTR_EXTENDED = Integer.MIN_VALUE;
  public static final int SSH_FILEXFER_ATTR_PERMISSIONS = 4;
  public static final int SSH_FILEXFER_ATTR_SIZE = 1;
  public static final int SSH_FILEXFER_ATTR_UIDGID = 2;
  static final int S_IEXEC = 64;
  static final int S_IFBLK = 24576;
  static final int S_IFCHR = 8192;
  static final int S_IFDIR = 16384;
  static final int S_IFIFO = 4096;
  static final int S_IFLNK = 40960;
  static final int S_IFMT = 61440;
  static final int S_IFREG = 32768;
  static final int S_IFSOCK = 49152;
  static final int S_IREAD = 256;
  static final int S_IRGRP = 32;
  static final int S_IROTH = 4;
  static final int S_IRUSR = 256;
  static final int S_ISGID = 1024;
  static final int S_ISUID = 2048;
  static final int S_ISVTX = 512;
  static final int S_IWGRP = 16;
  static final int S_IWOTH = 2;
  static final int S_IWRITE = 128;
  static final int S_IWUSR = 128;
  static final int S_IXGRP = 8;
  static final int S_IXOTH = 1;
  static final int S_IXUSR = 64;
  private static final int pmask = 4095;
  int atime;
  String[] extended = null;
  int flags = 0;
  int gid;
  int mtime;
  int permissions;
  long size;
  int uid;
  
  static SftpATTRS getATTR(Buffer paramBuffer)
  {
    SftpATTRS localSftpATTRS = new SftpATTRS();
    int i = paramBuffer.getInt();
    localSftpATTRS.flags = i;
    if ((i & 0x1) != 0) {
      localSftpATTRS.size = paramBuffer.getLong();
    }
    if ((localSftpATTRS.flags & 0x2) != 0)
    {
      localSftpATTRS.uid = paramBuffer.getInt();
      localSftpATTRS.gid = paramBuffer.getInt();
    }
    if ((localSftpATTRS.flags & 0x4) != 0) {
      localSftpATTRS.permissions = paramBuffer.getInt();
    }
    if ((localSftpATTRS.flags & 0x8) != 0) {
      localSftpATTRS.atime = paramBuffer.getInt();
    }
    if ((localSftpATTRS.flags & 0x8) != 0) {
      localSftpATTRS.mtime = paramBuffer.getInt();
    }
    if ((localSftpATTRS.flags & 0x80000000) != 0)
    {
      int j = paramBuffer.getInt();
      if (j > 0)
      {
        localSftpATTRS.extended = new String[j * 2];
        for (i = 0; i < j; i++)
        {
          String[] arrayOfString = localSftpATTRS.extended;
          int k = i * 2;
          arrayOfString[k] = Util.byte2str(paramBuffer.getString());
          localSftpATTRS.extended[(k + 1)] = Util.byte2str(paramBuffer.getString());
        }
      }
    }
    return localSftpATTRS;
  }
  
  private boolean isType(int paramInt)
  {
    boolean bool;
    if (((this.flags & 0x4) != 0) && ((this.permissions & 0xF000) == paramInt)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  void dump(Buffer paramBuffer)
  {
    paramBuffer.putInt(this.flags);
    if ((this.flags & 0x1) != 0) {
      paramBuffer.putLong(this.size);
    }
    if ((this.flags & 0x2) != 0)
    {
      paramBuffer.putInt(this.uid);
      paramBuffer.putInt(this.gid);
    }
    if ((this.flags & 0x4) != 0) {
      paramBuffer.putInt(this.permissions);
    }
    if ((this.flags & 0x8) != 0) {
      paramBuffer.putInt(this.atime);
    }
    if ((this.flags & 0x8) != 0) {
      paramBuffer.putInt(this.mtime);
    }
    if ((this.flags & 0x80000000) != 0)
    {
      int i = this.extended.length / 2;
      if (i > 0) {
        for (int j = 0; j < i; j++)
        {
          String[] arrayOfString = this.extended;
          int k = j * 2;
          paramBuffer.putString(Util.str2byte(arrayOfString[k]));
          paramBuffer.putString(Util.str2byte(this.extended[(k + 1)]));
        }
      }
    }
  }
  
  public int getATime()
  {
    return this.atime;
  }
  
  public String getAtimeString()
  {
    return new Date(this.atime * 1000L).toString();
  }
  
  public String[] getExtended()
  {
    return this.extended;
  }
  
  public int getFlags()
  {
    return this.flags;
  }
  
  public int getGId()
  {
    return this.gid;
  }
  
  public int getMTime()
  {
    return this.mtime;
  }
  
  public String getMtimeString()
  {
    return new Date(this.mtime * 1000L).toString();
  }
  
  public int getPermissions()
  {
    return this.permissions;
  }
  
  public String getPermissionsString()
  {
    StringBuffer localStringBuffer = new StringBuffer(10);
    if (isDir()) {
      localStringBuffer.append('d');
    } else if (isLink()) {
      localStringBuffer.append('l');
    } else {
      localStringBuffer.append('-');
    }
    if ((this.permissions & 0x100) != 0) {
      localStringBuffer.append('r');
    } else {
      localStringBuffer.append('-');
    }
    if ((this.permissions & 0x80) != 0) {
      localStringBuffer.append('w');
    } else {
      localStringBuffer.append('-');
    }
    int i = this.permissions;
    if ((i & 0x800) != 0) {
      localStringBuffer.append('s');
    } else if ((i & 0x40) != 0) {
      localStringBuffer.append('x');
    } else {
      localStringBuffer.append('-');
    }
    if ((this.permissions & 0x20) != 0) {
      localStringBuffer.append('r');
    } else {
      localStringBuffer.append('-');
    }
    if ((this.permissions & 0x10) != 0) {
      localStringBuffer.append('w');
    } else {
      localStringBuffer.append('-');
    }
    i = this.permissions;
    if ((i & 0x400) != 0) {
      localStringBuffer.append('s');
    } else if ((i & 0x8) != 0) {
      localStringBuffer.append('x');
    } else {
      localStringBuffer.append('-');
    }
    if ((this.permissions & 0x4) != 0) {
      localStringBuffer.append('r');
    } else {
      localStringBuffer.append('-');
    }
    if ((this.permissions & 0x2) != 0) {
      localStringBuffer.append('w');
    } else {
      localStringBuffer.append('-');
    }
    if ((this.permissions & 0x1) != 0) {
      localStringBuffer.append('x');
    } else {
      localStringBuffer.append('-');
    }
    return localStringBuffer.toString();
  }
  
  public long getSize()
  {
    return this.size;
  }
  
  public int getUId()
  {
    return this.uid;
  }
  
  public boolean isBlk()
  {
    return isType(24576);
  }
  
  public boolean isChr()
  {
    return isType(8192);
  }
  
  public boolean isDir()
  {
    return isType(16384);
  }
  
  public boolean isFifo()
  {
    return isType(4096);
  }
  
  public boolean isLink()
  {
    return isType(40960);
  }
  
  public boolean isReg()
  {
    return isType(32768);
  }
  
  public boolean isSock()
  {
    return isType(49152);
  }
  
  int length()
  {
    int i = this.flags;
    if ((i & 0x1) != 0) {
      j = 12;
    } else {
      j = 4;
    }
    int k = j;
    if ((i & 0x2) != 0) {
      k = j + 8;
    }
    int m = k;
    if ((i & 0x4) != 0) {
      m = k + 4;
    }
    int j = m;
    if ((i & 0x8) != 0) {
      j = m + 8;
    }
    k = j;
    if ((i & 0x80000000) != 0)
    {
      j += 4;
      i = this.extended.length / 2;
      k = j;
      if (i > 0) {
        for (m = 0;; m++)
        {
          k = j;
          if (m >= i) {
            break;
          }
          String[] arrayOfString = this.extended;
          k = m * 2;
          j = j + 4 + arrayOfString[k].length() + 4 + this.extended[(k + 1)].length();
        }
      }
    }
    return k;
  }
  
  public void setACMODTIME(int paramInt1, int paramInt2)
  {
    this.flags |= 0x8;
    this.atime = paramInt1;
    this.mtime = paramInt2;
  }
  
  void setFLAGS(int paramInt)
  {
    this.flags = paramInt;
  }
  
  public void setPERMISSIONS(int paramInt)
  {
    this.flags |= 0x4;
    this.permissions = (paramInt & 0xFFF | this.permissions & 0xF000);
  }
  
  public void setSIZE(long paramLong)
  {
    this.flags |= 0x1;
    this.size = paramLong;
  }
  
  public void setUIDGID(int paramInt1, int paramInt2)
  {
    this.flags |= 0x2;
    this.uid = paramInt1;
    this.gid = paramInt2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getPermissionsString());
    localStringBuilder.append(" ");
    localStringBuilder.append(getUId());
    localStringBuilder.append(" ");
    localStringBuilder.append(getGId());
    localStringBuilder.append(" ");
    localStringBuilder.append(getSize());
    localStringBuilder.append(" ");
    localStringBuilder.append(getMtimeString());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\SftpATTRS.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */