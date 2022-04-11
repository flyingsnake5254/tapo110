package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;

public final class PrivFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<PrivFrame> CREATOR = new a();
  public final String d;
  public final byte[] f;
  
  PrivFrame(Parcel paramParcel)
  {
    super("PRIV");
    this.d = ((String)o0.i(paramParcel.readString()));
    this.f = ((byte[])o0.i(paramParcel.createByteArray()));
  }
  
  public PrivFrame(String paramString, byte[] paramArrayOfByte)
  {
    super("PRIV");
    this.d = paramString;
    this.f = paramArrayOfByte;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (PrivFrame.class == paramObject.getClass()))
    {
      paramObject = (PrivFrame)paramObject;
      if ((!o0.b(this.d, ((PrivFrame)paramObject).d)) || (!Arrays.equals(this.f, ((PrivFrame)paramObject).f))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.d;
    int i;
    if (str != null) {
      i = str.hashCode();
    } else {
      i = 0;
    }
    return (527 + i) * 31 + Arrays.hashCode(this.f);
  }
  
  public String toString()
  {
    String str1 = this.c;
    String str2 = this.d;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 8 + String.valueOf(str2).length());
    localStringBuilder.append(str1);
    localStringBuilder.append(": owner=");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.d);
    paramParcel.writeByteArray(this.f);
  }
  
  class a
    implements Parcelable.Creator<PrivFrame>
  {
    public PrivFrame a(Parcel paramParcel)
    {
      return new PrivFrame(paramParcel);
    }
    
    public PrivFrame[] b(int paramInt)
    {
      return new PrivFrame[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\id3\PrivFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */