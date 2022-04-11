package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1.b;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;

public final class ApicFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<ApicFrame> CREATOR = new a();
  public final String d;
  @Nullable
  public final String f;
  public final int q;
  public final byte[] x;
  
  ApicFrame(Parcel paramParcel)
  {
    super("APIC");
    this.d = ((String)o0.i(paramParcel.readString()));
    this.f = paramParcel.readString();
    this.q = paramParcel.readInt();
    this.x = ((byte[])o0.i(paramParcel.createByteArray()));
  }
  
  public ApicFrame(String paramString1, @Nullable String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    super("APIC");
    this.d = paramString1;
    this.f = paramString2;
    this.q = paramInt;
    this.x = paramArrayOfByte;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (ApicFrame.class == paramObject.getClass()))
    {
      paramObject = (ApicFrame)paramObject;
      if ((this.q != ((ApicFrame)paramObject).q) || (!o0.b(this.d, ((ApicFrame)paramObject).d)) || (!o0.b(this.f, ((ApicFrame)paramObject).f)) || (!Arrays.equals(this.x, ((ApicFrame)paramObject).x))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = this.q;
    String str = this.d;
    int j = 0;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.f;
    if (str != null) {
      j = str.hashCode();
    }
    return (((527 + i) * 31 + k) * 31 + j) * 31 + Arrays.hashCode(this.x);
  }
  
  public void j(m1.b paramb)
  {
    paramb.G(this.x, this.q);
  }
  
  public String toString()
  {
    String str1 = this.c;
    String str2 = this.d;
    String str3 = this.f;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 25 + String.valueOf(str2).length() + String.valueOf(str3).length());
    localStringBuilder.append(str1);
    localStringBuilder.append(": mimeType=");
    localStringBuilder.append(str2);
    localStringBuilder.append(", description=");
    localStringBuilder.append(str3);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.f);
    paramParcel.writeInt(this.q);
    paramParcel.writeByteArray(this.x);
  }
  
  class a
    implements Parcelable.Creator<ApicFrame>
  {
    public ApicFrame a(Parcel paramParcel)
    {
      return new ApicFrame(paramParcel);
    }
    
    public ApicFrame[] b(int paramInt)
    {
      return new ApicFrame[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\id3\ApicFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */