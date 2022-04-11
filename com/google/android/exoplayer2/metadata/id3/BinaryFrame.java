package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;

public final class BinaryFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<BinaryFrame> CREATOR = new a();
  public final byte[] d;
  
  BinaryFrame(Parcel paramParcel)
  {
    super((String)o0.i(paramParcel.readString()));
    this.d = ((byte[])o0.i(paramParcel.createByteArray()));
  }
  
  public BinaryFrame(String paramString, byte[] paramArrayOfByte)
  {
    super(paramString);
    this.d = paramArrayOfByte;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (BinaryFrame.class == paramObject.getClass()))
    {
      paramObject = (BinaryFrame)paramObject;
      if ((!this.c.equals(((Id3Frame)paramObject).c)) || (!Arrays.equals(this.d, ((BinaryFrame)paramObject).d))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return (527 + this.c.hashCode()) * 31 + Arrays.hashCode(this.d);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.c);
    paramParcel.writeByteArray(this.d);
  }
  
  class a
    implements Parcelable.Creator<BinaryFrame>
  {
    public BinaryFrame a(Parcel paramParcel)
    {
      return new BinaryFrame(paramParcel);
    }
    
    public BinaryFrame[] b(int paramInt)
    {
      return new BinaryFrame[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\id3\BinaryFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */