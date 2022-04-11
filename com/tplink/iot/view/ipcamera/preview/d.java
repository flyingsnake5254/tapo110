package com.tplink.iot.view.ipcamera.preview;

import kotlin.jvm.internal.j;

public final class d
{
  private CameraPreviewInfo a;
  private boolean b;
  
  public d(CameraPreviewInfo paramCameraPreviewInfo, boolean paramBoolean)
  {
    this.a = paramCameraPreviewInfo;
    this.b = paramBoolean;
  }
  
  public final CameraPreviewInfo a()
  {
    return this.a;
  }
  
  public final boolean b()
  {
    return this.b;
  }
  
  public final boolean c()
  {
    return this.b;
  }
  
  public final CameraPreviewInfo d()
  {
    return this.a;
  }
  
  public final void e(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof d))
      {
        paramObject = (d)paramObject;
        if ((j.a(this.a, ((d)paramObject).a)) && (this.b == ((d)paramObject).b)) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final void f(CameraPreviewInfo paramCameraPreviewInfo)
  {
    j.e(paramCameraPreviewInfo, "<set-?>");
    this.a = paramCameraPreviewInfo;
  }
  
  public int hashCode()
  {
    CameraPreviewInfo localCameraPreviewInfo = this.a;
    int i;
    if (localCameraPreviewInfo != null) {
      i = localCameraPreviewInfo.hashCode();
    } else {
      i = 0;
    }
    int j = this.b;
    int k = j;
    if (j != 0) {
      k = 1;
    }
    return i * 31 + k;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CameraPreviewInfoWithConnectionError(info=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", connectionError=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\preview\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */