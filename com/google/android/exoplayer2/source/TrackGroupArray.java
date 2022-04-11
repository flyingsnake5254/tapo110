package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import java.util.Arrays;

public final class TrackGroupArray
  implements Parcelable
{
  public static final Parcelable.Creator<TrackGroupArray> CREATOR = new a();
  public static final TrackGroupArray c = new TrackGroupArray(new TrackGroup[0]);
  public final int d;
  private final TrackGroup[] f;
  private int q;
  
  TrackGroupArray(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    this.d = i;
    this.f = new TrackGroup[i];
    for (i = 0; i < this.d; i++) {
      this.f[i] = ((TrackGroup)paramParcel.readParcelable(TrackGroup.class.getClassLoader()));
    }
  }
  
  public TrackGroupArray(TrackGroup... paramVarArgs)
  {
    this.f = paramVarArgs;
    this.d = paramVarArgs.length;
  }
  
  public TrackGroup a(int paramInt)
  {
    return this.f[paramInt];
  }
  
  public int b(TrackGroup paramTrackGroup)
  {
    for (int i = 0; i < this.d; i++) {
      if (this.f[i] == paramTrackGroup) {
        return i;
      }
    }
    return -1;
  }
  
  public boolean c()
  {
    boolean bool;
    if (this.d == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
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
    if ((paramObject != null) && (TrackGroupArray.class == paramObject.getClass()))
    {
      paramObject = (TrackGroupArray)paramObject;
      if ((this.d != ((TrackGroupArray)paramObject).d) || (!Arrays.equals(this.f, ((TrackGroupArray)paramObject).f))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    if (this.q == 0) {
      this.q = Arrays.hashCode(this.f);
    }
    return this.q;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.d);
    for (paramInt = 0; paramInt < this.d; paramInt++) {
      paramParcel.writeParcelable(this.f[paramInt], 0);
    }
  }
  
  class a
    implements Parcelable.Creator<TrackGroupArray>
  {
    public TrackGroupArray a(Parcel paramParcel)
    {
      return new TrackGroupArray(paramParcel);
    }
    
    public TrackGroupArray[] b(int paramInt)
    {
      return new TrackGroupArray[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\TrackGroupArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */