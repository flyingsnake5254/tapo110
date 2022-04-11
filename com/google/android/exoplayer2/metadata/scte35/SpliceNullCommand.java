package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public final class SpliceNullCommand
  extends SpliceCommand
{
  public static final Parcelable.Creator<SpliceNullCommand> CREATOR = new a();
  
  public void writeToParcel(Parcel paramParcel, int paramInt) {}
  
  class a
    implements Parcelable.Creator<SpliceNullCommand>
  {
    public SpliceNullCommand a(Parcel paramParcel)
    {
      return new SpliceNullCommand();
    }
    
    public SpliceNullCommand[] b(int paramInt)
    {
      return new SpliceNullCommand[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\scte35\SpliceNullCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */