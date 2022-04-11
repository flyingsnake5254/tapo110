package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.o0;

public final class PrivateCommand
  extends SpliceCommand
{
  public static final Parcelable.Creator<PrivateCommand> CREATOR = new a();
  public final long c;
  public final long d;
  public final byte[] f;
  
  private PrivateCommand(long paramLong1, byte[] paramArrayOfByte, long paramLong2)
  {
    this.c = paramLong2;
    this.d = paramLong1;
    this.f = paramArrayOfByte;
  }
  
  private PrivateCommand(Parcel paramParcel)
  {
    this.c = paramParcel.readLong();
    this.d = paramParcel.readLong();
    this.f = ((byte[])o0.i(paramParcel.createByteArray()));
  }
  
  static PrivateCommand a(d0 paramd0, int paramInt, long paramLong)
  {
    long l = paramd0.F();
    paramInt -= 4;
    byte[] arrayOfByte = new byte[paramInt];
    paramd0.j(arrayOfByte, 0, paramInt);
    return new PrivateCommand(l, arrayOfByte, paramLong);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.c);
    paramParcel.writeLong(this.d);
    paramParcel.writeByteArray(this.f);
  }
  
  class a
    implements Parcelable.Creator<PrivateCommand>
  {
    public PrivateCommand a(Parcel paramParcel)
    {
      return new PrivateCommand(paramParcel, null);
    }
    
    public PrivateCommand[] b(int paramInt)
    {
      return new PrivateCommand[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\scte35\PrivateCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */