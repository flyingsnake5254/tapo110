package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;

public final class MlltFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<MlltFrame> CREATOR = new a();
  public final int d;
  public final int f;
  public final int q;
  public final int[] x;
  public final int[] y;
  
  public MlltFrame(int paramInt1, int paramInt2, int paramInt3, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    super("MLLT");
    this.d = paramInt1;
    this.f = paramInt2;
    this.q = paramInt3;
    this.x = paramArrayOfInt1;
    this.y = paramArrayOfInt2;
  }
  
  MlltFrame(Parcel paramParcel)
  {
    super("MLLT");
    this.d = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.q = paramParcel.readInt();
    this.x = ((int[])o0.i(paramParcel.createIntArray()));
    this.y = ((int[])o0.i(paramParcel.createIntArray()));
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
    if ((paramObject != null) && (MlltFrame.class == paramObject.getClass()))
    {
      paramObject = (MlltFrame)paramObject;
      if ((this.d != ((MlltFrame)paramObject).d) || (this.f != ((MlltFrame)paramObject).f) || (this.q != ((MlltFrame)paramObject).q) || (!Arrays.equals(this.x, ((MlltFrame)paramObject).x)) || (!Arrays.equals(this.y, ((MlltFrame)paramObject).y))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return ((((527 + this.d) * 31 + this.f) * 31 + this.q) * 31 + Arrays.hashCode(this.x)) * 31 + Arrays.hashCode(this.y);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.q);
    paramParcel.writeIntArray(this.x);
    paramParcel.writeIntArray(this.y);
  }
  
  class a
    implements Parcelable.Creator<MlltFrame>
  {
    public MlltFrame a(Parcel paramParcel)
    {
      return new MlltFrame(paramParcel);
    }
    
    public MlltFrame[] b(int paramInt)
    {
      return new MlltFrame[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\id3\MlltFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */