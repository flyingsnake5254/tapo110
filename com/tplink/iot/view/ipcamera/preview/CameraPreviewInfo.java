package com.tplink.iot.view.ipcamera.preview;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tplink.iot.adapter.databinding.c;
import kotlin.jvm.internal.j;

public final class CameraPreviewInfo
  implements c, Parcelable
{
  public static final Parcelable.Creator<CameraPreviewInfo> CREATOR = new a();
  public static final b c = new b(null);
  private final String d;
  private final String f;
  private final String p0;
  private final String q;
  private boolean x;
  private final boolean y;
  private String z;
  
  public CameraPreviewInfo(Parcel paramParcel)
  {
    this(str1, str2, str3, bool2, bool1, str4, paramParcel);
  }
  
  public CameraPreviewInfo(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4, String paramString5)
  {
    this.d = paramString1;
    this.f = paramString2;
    this.q = paramString3;
    this.x = paramBoolean1;
    this.y = paramBoolean2;
    this.z = paramString4;
    this.p0 = paramString5;
  }
  
  public Object a()
  {
    return c(this, null, null, null, false, false, null, null, 127, null);
  }
  
  public final CameraPreviewInfo b(String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4, String paramString5)
  {
    j.e(paramString1, "deviceIdMD5");
    j.e(paramString2, "name");
    j.e(paramString3, "info");
    j.e(paramString5, "location");
    return new CameraPreviewInfo(paramString1, paramString2, paramString3, paramBoolean1, paramBoolean2, paramString4, paramString5);
  }
  
  public final String d()
  {
    return this.d;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String e()
  {
    return this.z;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof CameraPreviewInfo))
      {
        paramObject = (CameraPreviewInfo)paramObject;
        if ((j.a(this.d, ((CameraPreviewInfo)paramObject).d)) && (j.a(this.f, ((CameraPreviewInfo)paramObject).f)) && (j.a(this.q, ((CameraPreviewInfo)paramObject).q)) && (this.x == ((CameraPreviewInfo)paramObject).x) && (this.y == ((CameraPreviewInfo)paramObject).y) && (j.a(this.z, ((CameraPreviewInfo)paramObject).z)) && (j.a(this.p0, ((CameraPreviewInfo)paramObject).p0))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String f()
  {
    return this.q;
  }
  
  public final boolean h()
  {
    return this.y;
  }
  
  public int hashCode()
  {
    String str = this.d;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.f;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.q;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    int n = this.x;
    int i2 = 1;
    int i3 = n;
    if (n != 0) {
      i3 = 1;
    }
    n = this.y;
    if (n == 0) {
      i2 = n;
    }
    str = this.z;
    int i1;
    if (str != null) {
      i1 = str.hashCode();
    } else {
      i1 = 0;
    }
    str = this.p0;
    if (str != null) {
      i = str.hashCode();
    }
    return (((((j * 31 + k) * 31 + m) * 31 + i3) * 31 + i2) * 31 + i1) * 31 + i;
  }
  
  public final String i()
  {
    return this.p0;
  }
  
  public final String l()
  {
    return this.f;
  }
  
  public final boolean m()
  {
    return this.x;
  }
  
  public final void n(String paramString)
  {
    this.z = paramString;
  }
  
  public final void o(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CameraPreviewInfo(deviceIdMD5=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", name=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", info=");
    localStringBuilder.append(this.q);
    localStringBuilder.append(", online=");
    localStringBuilder.append(this.x);
    localStringBuilder.append(", initialing=");
    localStringBuilder.append(this.y);
    localStringBuilder.append(", imageUrl=");
    localStringBuilder.append(this.z);
    localStringBuilder.append(", location=");
    localStringBuilder.append(this.p0);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.e(paramParcel, "dest");
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.q);
    paramParcel.writeInt(this.x);
    paramParcel.writeInt(this.y);
    paramParcel.writeString(this.z);
    paramParcel.writeString(this.p0);
  }
  
  public static final class a
    implements Parcelable.Creator<CameraPreviewInfo>
  {
    public CameraPreviewInfo a(Parcel paramParcel)
    {
      j.e(paramParcel, "source");
      return new CameraPreviewInfo(paramParcel);
    }
    
    public CameraPreviewInfo[] b(int paramInt)
    {
      return new CameraPreviewInfo[paramInt];
    }
  }
  
  public static final class b {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\preview\CameraPreviewInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */