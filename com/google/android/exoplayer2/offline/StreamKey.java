package com.google.android.exoplayer2.offline;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;

public final class StreamKey
  implements Comparable<StreamKey>, Parcelable
{
  public static final Parcelable.Creator<StreamKey> CREATOR = new a();
  public final int c;
  public final int d;
  public final int f;
  
  StreamKey(Parcel paramParcel)
  {
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.f = paramParcel.readInt();
  }
  
  public int a(StreamKey paramStreamKey)
  {
    int i = this.c - paramStreamKey.c;
    int j = i;
    if (i == 0)
    {
      i = this.d - paramStreamKey.d;
      j = i;
      if (i == 0) {
        j = this.f - paramStreamKey.f;
      }
    }
    return j;
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
    if ((paramObject != null) && (StreamKey.class == paramObject.getClass()))
    {
      paramObject = (StreamKey)paramObject;
      if ((this.c != ((StreamKey)paramObject).c) || (this.d != ((StreamKey)paramObject).d) || (this.f != ((StreamKey)paramObject).f)) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return (this.c * 31 + this.d) * 31 + this.f;
  }
  
  public String toString()
  {
    int i = this.c;
    int j = this.d;
    int k = this.f;
    StringBuilder localStringBuilder = new StringBuilder(35);
    localStringBuilder.append(i);
    localStringBuilder.append(".");
    localStringBuilder.append(j);
    localStringBuilder.append(".");
    localStringBuilder.append(k);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.f);
  }
  
  class a
    implements Parcelable.Creator<StreamKey>
  {
    public StreamKey a(Parcel paramParcel)
    {
      return new StreamKey(paramParcel);
    }
    
    public StreamKey[] b(int paramInt)
    {
      return new StreamKey[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\offline\StreamKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */