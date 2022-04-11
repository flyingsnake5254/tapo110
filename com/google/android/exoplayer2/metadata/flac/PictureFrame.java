package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1.b;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;

public final class PictureFrame
  implements Metadata.Entry
{
  public static final Parcelable.Creator<PictureFrame> CREATOR = new a();
  public final int c;
  public final String d;
  public final String f;
  public final byte[] p0;
  public final int q;
  public final int x;
  public final int y;
  public final int z;
  
  public PictureFrame(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3, int paramInt4, int paramInt5, byte[] paramArrayOfByte)
  {
    this.c = paramInt1;
    this.d = paramString1;
    this.f = paramString2;
    this.q = paramInt2;
    this.x = paramInt3;
    this.y = paramInt4;
    this.z = paramInt5;
    this.p0 = paramArrayOfByte;
  }
  
  PictureFrame(Parcel paramParcel)
  {
    this.c = paramParcel.readInt();
    this.d = ((String)o0.i(paramParcel.readString()));
    this.f = ((String)o0.i(paramParcel.readString()));
    this.q = paramParcel.readInt();
    this.x = paramParcel.readInt();
    this.y = paramParcel.readInt();
    this.z = paramParcel.readInt();
    this.p0 = ((byte[])o0.i(paramParcel.createByteArray()));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (PictureFrame.class == paramObject.getClass()))
    {
      paramObject = (PictureFrame)paramObject;
      if ((this.c != ((PictureFrame)paramObject).c) || (!this.d.equals(((PictureFrame)paramObject).d)) || (!this.f.equals(((PictureFrame)paramObject).f)) || (this.q != ((PictureFrame)paramObject).q) || (this.x != ((PictureFrame)paramObject).x) || (this.y != ((PictureFrame)paramObject).y) || (this.z != ((PictureFrame)paramObject).z) || (!Arrays.equals(this.p0, ((PictureFrame)paramObject).p0))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return (((((((527 + this.c) * 31 + this.d.hashCode()) * 31 + this.f.hashCode()) * 31 + this.q) * 31 + this.x) * 31 + this.y) * 31 + this.z) * 31 + Arrays.hashCode(this.p0);
  }
  
  public void j(m1.b paramb)
  {
    paramb.G(this.p0, this.c);
  }
  
  public String toString()
  {
    String str1 = this.d;
    String str2 = this.f;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 32 + String.valueOf(str2).length());
    localStringBuilder.append("Picture: mimeType=");
    localStringBuilder.append(str1);
    localStringBuilder.append(", description=");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.f);
    paramParcel.writeInt(this.q);
    paramParcel.writeInt(this.x);
    paramParcel.writeInt(this.y);
    paramParcel.writeInt(this.z);
    paramParcel.writeByteArray(this.p0);
  }
  
  class a
    implements Parcelable.Creator<PictureFrame>
  {
    public PictureFrame a(Parcel paramParcel)
    {
      return new PictureFrame(paramParcel);
    }
    
    public PictureFrame[] b(int paramInt)
    {
      return new PictureFrame[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\flac\PictureFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */