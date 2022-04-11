package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class Camera
{
  private final String id;
  private final String ip;
  private final String name;
  private final int port;
  private final String url;
  
  public Camera(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    this.id = paramString1;
    this.name = paramString2;
    this.ip = paramString3;
    this.port = paramInt;
    paramString1 = new StringBuilder();
    paramString1.append("https://");
    paramString1.append(paramString3);
    paramString1.append(':');
    paramString1.append(paramInt);
    this.url = paramString1.toString();
  }
  
  public final String component1()
  {
    return this.id;
  }
  
  public final String component2()
  {
    return this.name;
  }
  
  public final String component3()
  {
    return this.ip;
  }
  
  public final int component4()
  {
    return this.port;
  }
  
  public final Camera copy(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    j.e(paramString1, "id");
    j.e(paramString2, "name");
    j.e(paramString3, "ip");
    return new Camera(paramString1, paramString2, paramString3, paramInt);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Camera))
      {
        paramObject = (Camera)paramObject;
        if ((j.a(this.id, ((Camera)paramObject).id)) && (j.a(this.name, ((Camera)paramObject).name)) && (j.a(this.ip, ((Camera)paramObject).ip)) && (this.port == ((Camera)paramObject).port)) {}
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
  
  public final String getIp()
  {
    return this.ip;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final int getPort()
  {
    return this.port;
  }
  
  public final String getUrl()
  {
    return this.url;
  }
  
  public int hashCode()
  {
    String str = this.id;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.name;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.ip;
    if (str != null) {
      i = str.hashCode();
    }
    return ((j * 31 + k) * 31 + i) * 31 + this.port;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Camera(id=");
    localStringBuilder.append(this.id);
    localStringBuilder.append(", name=");
    localStringBuilder.append(this.name);
    localStringBuilder.append(", ip=");
    localStringBuilder.append(this.ip);
    localStringBuilder.append(", port=");
    localStringBuilder.append(this.port);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\Camera.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */