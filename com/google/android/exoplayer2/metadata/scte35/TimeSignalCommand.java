package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.util.d0;
import com.google.android.exoplayer2.util.l0;

public final class TimeSignalCommand
  extends SpliceCommand
{
  public static final Parcelable.Creator<TimeSignalCommand> CREATOR = new a();
  public final long c;
  public final long d;
  
  private TimeSignalCommand(long paramLong1, long paramLong2)
  {
    this.c = paramLong1;
    this.d = paramLong2;
  }
  
  static TimeSignalCommand a(d0 paramd0, long paramLong, l0 paraml0)
  {
    paramLong = b(paramd0, paramLong);
    return new TimeSignalCommand(paramLong, paraml0.b(paramLong));
  }
  
  static long b(d0 paramd0, long paramLong)
  {
    long l = paramd0.D();
    if ((0x80 & l) != 0L) {
      paramLong = 0x1FFFFFFFF & ((l & 1L) << 32 | paramd0.F()) + paramLong;
    } else {
      paramLong = -9223372036854775807L;
    }
    return paramLong;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.c);
    paramParcel.writeLong(this.d);
  }
  
  class a
    implements Parcelable.Creator<TimeSignalCommand>
  {
    public TimeSignalCommand a(Parcel paramParcel)
    {
      return new TimeSignalCommand(paramParcel.readLong(), paramParcel.readLong(), null);
    }
    
    public TimeSignalCommand[] b(int paramInt)
    {
      return new TimeSignalCommand[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\scte35\TimeSignalCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */