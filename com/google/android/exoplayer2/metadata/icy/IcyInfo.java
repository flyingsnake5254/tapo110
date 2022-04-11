package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1.b;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.util.g;
import java.util.Arrays;

public final class IcyInfo
  implements Metadata.Entry
{
  public static final Parcelable.Creator<IcyInfo> CREATOR = new a();
  public final byte[] c;
  @Nullable
  public final String d;
  @Nullable
  public final String f;
  
  IcyInfo(Parcel paramParcel)
  {
    this.c = ((byte[])g.e(paramParcel.createByteArray()));
    this.d = paramParcel.readString();
    this.f = paramParcel.readString();
  }
  
  public IcyInfo(byte[] paramArrayOfByte, @Nullable String paramString1, @Nullable String paramString2)
  {
    this.c = paramArrayOfByte;
    this.d = paramString1;
    this.f = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (IcyInfo.class == paramObject.getClass()))
    {
      paramObject = (IcyInfo)paramObject;
      return Arrays.equals(this.c, ((IcyInfo)paramObject).c);
    }
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.c);
  }
  
  public void j(m1.b paramb)
  {
    String str = this.d;
    if (str != null) {
      paramb.V(str);
    }
  }
  
  public String toString()
  {
    return String.format("ICY: title=\"%s\", url=\"%s\", rawMetadata.length=\"%s\"", new Object[] { this.d, this.f, Integer.valueOf(this.c.length) });
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeByteArray(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.f);
  }
  
  class a
    implements Parcelable.Creator<IcyInfo>
  {
    public IcyInfo a(Parcel paramParcel)
    {
      return new IcyInfo(paramParcel);
    }
    
    public IcyInfo[] b(int paramInt)
    {
      return new IcyInfo[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\icy\IcyInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */