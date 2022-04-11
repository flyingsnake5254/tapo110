package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;

public final class GeobFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<GeobFrame> CREATOR = new a();
  public final String d;
  public final String f;
  public final String q;
  public final byte[] x;
  
  GeobFrame(Parcel paramParcel)
  {
    super("GEOB");
    this.d = ((String)o0.i(paramParcel.readString()));
    this.f = ((String)o0.i(paramParcel.readString()));
    this.q = ((String)o0.i(paramParcel.readString()));
    this.x = ((byte[])o0.i(paramParcel.createByteArray()));
  }
  
  public GeobFrame(String paramString1, String paramString2, String paramString3, byte[] paramArrayOfByte)
  {
    super("GEOB");
    this.d = paramString1;
    this.f = paramString2;
    this.q = paramString3;
    this.x = paramArrayOfByte;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (GeobFrame.class == paramObject.getClass()))
    {
      paramObject = (GeobFrame)paramObject;
      if ((!o0.b(this.d, ((GeobFrame)paramObject).d)) || (!o0.b(this.f, ((GeobFrame)paramObject).f)) || (!o0.b(this.q, ((GeobFrame)paramObject).q)) || (!Arrays.equals(this.x, ((GeobFrame)paramObject).x))) {
        bool = false;
      }
      return bool;
    }
    return false;
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
    if (str != null) {
      i = str.hashCode();
    }
    return (((527 + j) * 31 + k) * 31 + i) * 31 + Arrays.hashCode(this.x);
  }
  
  public String toString()
  {
    String str1 = this.c;
    String str2 = this.d;
    String str3 = this.f;
    String str4 = this.q;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 36 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
    localStringBuilder.append(str1);
    localStringBuilder.append(": mimeType=");
    localStringBuilder.append(str2);
    localStringBuilder.append(", filename=");
    localStringBuilder.append(str3);
    localStringBuilder.append(", description=");
    localStringBuilder.append(str4);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.q);
    paramParcel.writeByteArray(this.x);
  }
  
  class a
    implements Parcelable.Creator<GeobFrame>
  {
    public GeobFrame a(Parcel paramParcel)
    {
      return new GeobFrame(paramParcel);
    }
    
    public GeobFrame[] b(int paramInt)
    {
      return new GeobFrame[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\id3\GeobFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */