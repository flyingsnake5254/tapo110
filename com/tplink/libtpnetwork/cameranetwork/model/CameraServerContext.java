package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class CameraServerContext
{
  private final String id;
  private final boolean isLocalOnline;
  private final boolean isRemoteOnline;
  private final String mac;
  private final String model;
  private final String token;
  private final String url;
  
  public CameraServerContext(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.isLocalOnline = paramBoolean1;
    this.isRemoteOnline = paramBoolean2;
    this.id = paramString1;
    this.mac = paramString2;
    this.url = paramString3;
    this.model = paramString4;
    this.token = paramString5;
  }
  
  public final boolean component1()
  {
    return this.isLocalOnline;
  }
  
  public final boolean component2()
  {
    return this.isRemoteOnline;
  }
  
  public final String component3()
  {
    return this.id;
  }
  
  public final String component4()
  {
    return this.mac;
  }
  
  public final String component5()
  {
    return this.url;
  }
  
  public final String component6()
  {
    return this.model;
  }
  
  public final String component7()
  {
    return this.token;
  }
  
  public final CameraServerContext copy(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    j.e(paramString1, "id");
    j.e(paramString2, "mac");
    return new CameraServerContext(paramBoolean1, paramBoolean2, paramString1, paramString2, paramString3, paramString4, paramString5);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof CameraServerContext))
      {
        paramObject = (CameraServerContext)paramObject;
        if ((this.isLocalOnline == ((CameraServerContext)paramObject).isLocalOnline) && (this.isRemoteOnline == ((CameraServerContext)paramObject).isRemoteOnline) && (j.a(this.id, ((CameraServerContext)paramObject).id)) && (j.a(this.mac, ((CameraServerContext)paramObject).mac)) && (j.a(this.url, ((CameraServerContext)paramObject).url)) && (j.a(this.model, ((CameraServerContext)paramObject).model)) && (j.a(this.token, ((CameraServerContext)paramObject).token))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getId()
  {
    return this.id;
  }
  
  public final String getMac()
  {
    return this.mac;
  }
  
  public final String getModel()
  {
    return this.model;
  }
  
  public final String getToken()
  {
    return this.token;
  }
  
  public final String getUrl()
  {
    return this.url;
  }
  
  public int hashCode()
  {
    int i = this.isLocalOnline;
    int k = 1;
    boolean bool = i;
    if (i != 0) {
      bool = true;
    }
    i = this.isRemoteOnline;
    if (i == 0) {
      k = i;
    }
    String str = this.id;
    int m = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.mac;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    str = this.url;
    int i1;
    if (str != null) {
      i1 = str.hashCode();
    } else {
      i1 = 0;
    }
    str = this.model;
    int i2;
    if (str != null) {
      i2 = str.hashCode();
    } else {
      i2 = 0;
    }
    str = this.token;
    if (str != null) {
      m = str.hashCode();
    }
    return (((((bool * true + k) * 31 + j) * 31 + n) * 31 + i1) * 31 + i2) * 31 + m;
  }
  
  public final boolean isLocalOnline()
  {
    return this.isLocalOnline;
  }
  
  public final boolean isRemoteOnline()
  {
    return this.isRemoteOnline;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CameraServerContext(isLocalOnline=");
    localStringBuilder.append(this.isLocalOnline);
    localStringBuilder.append(", isRemoteOnline=");
    localStringBuilder.append(this.isRemoteOnline);
    localStringBuilder.append(", id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", mac=");
    localStringBuilder.append(this.mac);
    localStringBuilder.append(", url=");
    localStringBuilder.append(this.url);
    localStringBuilder.append(", model=");
    localStringBuilder.append(this.model);
    localStringBuilder.append(", token=");
    localStringBuilder.append(this.token);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\CameraServerContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */