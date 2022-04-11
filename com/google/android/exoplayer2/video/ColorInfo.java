package com.google.android.exoplayer2.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;
import org.checkerframework.dataflow.qual.Pure;

public final class ColorInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ColorInfo> CREATOR = new a();
  public final int c;
  public final int d;
  public final int f;
  @Nullable
  public final byte[] q;
  private int x;
  
  public ColorInfo(int paramInt1, int paramInt2, int paramInt3, @Nullable byte[] paramArrayOfByte)
  {
    this.c = paramInt1;
    this.d = paramInt2;
    this.f = paramInt3;
    this.q = paramArrayOfByte;
  }
  
  ColorInfo(Parcel paramParcel)
  {
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.f = paramParcel.readInt();
    if (o0.A0(paramParcel)) {
      paramParcel = paramParcel.createByteArray();
    } else {
      paramParcel = null;
    }
    this.q = paramParcel;
  }
  
  @Pure
  public static int a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 9)
      {
        if ((paramInt != 4) && (paramInt != 5) && (paramInt != 6) && (paramInt != 7)) {
          return -1;
        }
        return 2;
      }
      return 6;
    }
    return 1;
  }
  
  @Pure
  public static int b(int paramInt)
  {
    if (paramInt != 1) {
      if (paramInt != 16)
      {
        if (paramInt != 18)
        {
          if ((paramInt != 6) && (paramInt != 7)) {
            return -1;
          }
        }
        else {
          return 7;
        }
      }
      else {
        return 6;
      }
    }
    return 3;
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
    if ((paramObject != null) && (ColorInfo.class == paramObject.getClass()))
    {
      paramObject = (ColorInfo)paramObject;
      if ((this.c != ((ColorInfo)paramObject).c) || (this.d != ((ColorInfo)paramObject).d) || (this.f != ((ColorInfo)paramObject).f) || (!Arrays.equals(this.q, ((ColorInfo)paramObject).q))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    if (this.x == 0) {
      this.x = ((((527 + this.c) * 31 + this.d) * 31 + this.f) * 31 + Arrays.hashCode(this.q));
    }
    return this.x;
  }
  
  public String toString()
  {
    int i = this.c;
    int j = this.d;
    int k = this.f;
    boolean bool;
    if (this.q != null) {
      bool = true;
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder(55);
    localStringBuilder.append("ColorInfo(");
    localStringBuilder.append(i);
    localStringBuilder.append(", ");
    localStringBuilder.append(j);
    localStringBuilder.append(", ");
    localStringBuilder.append(k);
    localStringBuilder.append(", ");
    localStringBuilder.append(bool);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.f);
    boolean bool;
    if (this.q != null) {
      bool = true;
    } else {
      bool = false;
    }
    o0.N0(paramParcel, bool);
    byte[] arrayOfByte = this.q;
    if (arrayOfByte != null) {
      paramParcel.writeByteArray(arrayOfByte);
    }
  }
  
  class a
    implements Parcelable.Creator<ColorInfo>
  {
    public ColorInfo a(Parcel paramParcel)
    {
      return new ColorInfo(paramParcel);
    }
    
    public ColorInfo[] b(int paramInt)
    {
      return new ColorInfo[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\video\ColorInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */