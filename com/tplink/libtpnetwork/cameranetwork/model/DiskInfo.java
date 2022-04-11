package com.tplink.libtpnetwork.cameranetwork.model;

import com.google.gson.q.c;
import kotlin.jvm.internal.j;

public final class DiskInfo
{
  public static final Companion Companion = new Companion(null);
  private static final DiskInfo singletonDisk = new DiskInfo("1");
  @c("disk_name")
  private final String name;
  
  public DiskInfo(String paramString)
  {
    this.name = paramString;
  }
  
  public static final DiskInfo getSingletonDisk()
  {
    return singletonDisk;
  }
  
  public final String component1()
  {
    return this.name;
  }
  
  public final DiskInfo copy(String paramString)
  {
    j.e(paramString, "name");
    return new DiskInfo(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof DiskInfo))
      {
        paramObject = (DiskInfo)paramObject;
        if (j.a(this.name, ((DiskInfo)paramObject).name)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public int hashCode()
  {
    String str = this.name;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DiskInfo(name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static final class Companion
  {
    public final DiskInfo getSingletonDisk()
    {
      return DiskInfo.access$getSingletonDisk$cp();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\DiskInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */