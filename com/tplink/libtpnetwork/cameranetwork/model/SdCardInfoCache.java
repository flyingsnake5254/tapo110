package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class SdCardInfoCache
{
  private String detectStatus;
  private String freeSpace;
  private boolean loopEnable;
  private String realTotalSpace;
  private SdCardStatus status;
  private String totalSpace;
  private String usedSpace;
  
  public SdCardInfoCache(SdCardStatus paramSdCardStatus, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5)
  {
    this.status = paramSdCardStatus;
    this.detectStatus = paramString1;
    this.totalSpace = paramString2;
    this.usedSpace = paramString3;
    this.freeSpace = paramString4;
    this.loopEnable = paramBoolean;
    this.realTotalSpace = paramString5;
  }
  
  public final SdCardStatus component1()
  {
    return this.status;
  }
  
  public final String component2()
  {
    return this.detectStatus;
  }
  
  public final String component3()
  {
    return this.totalSpace;
  }
  
  public final String component4()
  {
    return this.usedSpace;
  }
  
  public final String component5()
  {
    return this.freeSpace;
  }
  
  public final boolean component6()
  {
    return this.loopEnable;
  }
  
  public final String component7()
  {
    return this.realTotalSpace;
  }
  
  public final SdCardInfoCache copy(SdCardStatus paramSdCardStatus, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5)
  {
    return new SdCardInfoCache(paramSdCardStatus, paramString1, paramString2, paramString3, paramString4, paramBoolean, paramString5);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof SdCardInfoCache))
      {
        paramObject = (SdCardInfoCache)paramObject;
        if ((j.a(this.status, ((SdCardInfoCache)paramObject).status)) && (j.a(this.detectStatus, ((SdCardInfoCache)paramObject).detectStatus)) && (j.a(this.totalSpace, ((SdCardInfoCache)paramObject).totalSpace)) && (j.a(this.usedSpace, ((SdCardInfoCache)paramObject).usedSpace)) && (j.a(this.freeSpace, ((SdCardInfoCache)paramObject).freeSpace)) && (this.loopEnable == ((SdCardInfoCache)paramObject).loopEnable) && (j.a(this.realTotalSpace, ((SdCardInfoCache)paramObject).realTotalSpace))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getDetectStatus()
  {
    return this.detectStatus;
  }
  
  public final String getFreeSpace()
  {
    return this.freeSpace;
  }
  
  public final boolean getLoopEnable()
  {
    return this.loopEnable;
  }
  
  public final String getRealTotalSpace()
  {
    return this.realTotalSpace;
  }
  
  public final SdCardStatus getStatus()
  {
    return this.status;
  }
  
  public final String getTotalSpace()
  {
    return this.totalSpace;
  }
  
  public final String getUsedSpace()
  {
    return this.usedSpace;
  }
  
  public int hashCode()
  {
    Object localObject = this.status;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.detectStatus;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    localObject = this.totalSpace;
    int m;
    if (localObject != null) {
      m = localObject.hashCode();
    } else {
      m = 0;
    }
    localObject = this.usedSpace;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    localObject = this.freeSpace;
    int i1;
    if (localObject != null) {
      i1 = localObject.hashCode();
    } else {
      i1 = 0;
    }
    int i2 = this.loopEnable;
    int i3 = i2;
    if (i2 != 0) {
      i3 = 1;
    }
    localObject = this.realTotalSpace;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return (((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i3) * 31 + i;
  }
  
  public final void setDetectStatus(String paramString)
  {
    this.detectStatus = paramString;
  }
  
  public final void setFreeSpace(String paramString)
  {
    this.freeSpace = paramString;
  }
  
  public final void setLoopEnable(boolean paramBoolean)
  {
    this.loopEnable = paramBoolean;
  }
  
  public final void setRealTotalSpace(String paramString)
  {
    this.realTotalSpace = paramString;
  }
  
  public final void setStatus(SdCardStatus paramSdCardStatus)
  {
    this.status = paramSdCardStatus;
  }
  
  public final void setTotalSpace(String paramString)
  {
    this.totalSpace = paramString;
  }
  
  public final void setUsedSpace(String paramString)
  {
    this.usedSpace = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SdCardInfoCache(status=");
    localStringBuilder.append(this.status);
    localStringBuilder.append(", detectStatus=");
    localStringBuilder.append(this.detectStatus);
    localStringBuilder.append(", totalSpace=");
    localStringBuilder.append(this.totalSpace);
    localStringBuilder.append(", usedSpace=");
    localStringBuilder.append(this.usedSpace);
    localStringBuilder.append(", freeSpace=");
    localStringBuilder.append(this.freeSpace);
    localStringBuilder.append(", loopEnable=");
    localStringBuilder.append(this.loopEnable);
    localStringBuilder.append(", realTotalSpace=");
    localStringBuilder.append(this.realTotalSpace);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\SdCardInfoCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */