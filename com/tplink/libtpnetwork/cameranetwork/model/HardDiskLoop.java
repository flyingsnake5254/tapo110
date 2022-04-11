package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class HardDiskLoop
{
  private final String loop;
  
  public HardDiskLoop(String paramString)
  {
    this.loop = paramString;
  }
  
  public final String component1()
  {
    return this.loop;
  }
  
  public final HardDiskLoop copy(String paramString)
  {
    j.e(paramString, "loop");
    return new HardDiskLoop(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof HardDiskLoop))
      {
        paramObject = (HardDiskLoop)paramObject;
        if (j.a(this.loop, ((HardDiskLoop)paramObject).loop)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getLoop()
  {
    return this.loop;
  }
  
  public int hashCode()
  {
    String str = this.loop;
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
    localStringBuilder.append("HardDiskLoop(loop=");
    localStringBuilder.append(this.loop);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\HardDiskLoop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */