package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.common.primitives.e;

public final class MotionPhotoMetadata
  implements Metadata.Entry
{
  public static final Parcelable.Creator<MotionPhotoMetadata> CREATOR = new a();
  public final long c;
  public final long d;
  public final long f;
  public final long q;
  public final long x;
  
  public MotionPhotoMetadata(long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5)
  {
    this.c = paramLong1;
    this.d = paramLong2;
    this.f = paramLong3;
    this.q = paramLong4;
    this.x = paramLong5;
  }
  
  private MotionPhotoMetadata(Parcel paramParcel)
  {
    this.c = paramParcel.readLong();
    this.d = paramParcel.readLong();
    this.f = paramParcel.readLong();
    this.q = paramParcel.readLong();
    this.x = paramParcel.readLong();
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
    if ((paramObject != null) && (MotionPhotoMetadata.class == paramObject.getClass()))
    {
      paramObject = (MotionPhotoMetadata)paramObject;
      if ((this.c != ((MotionPhotoMetadata)paramObject).c) || (this.d != ((MotionPhotoMetadata)paramObject).d) || (this.f != ((MotionPhotoMetadata)paramObject).f) || (this.q != ((MotionPhotoMetadata)paramObject).q) || (this.x != ((MotionPhotoMetadata)paramObject).x)) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return ((((527 + e.e(this.c)) * 31 + e.e(this.d)) * 31 + e.e(this.f)) * 31 + e.e(this.q)) * 31 + e.e(this.x);
  }
  
  public String toString()
  {
    long l1 = this.c;
    long l2 = this.d;
    long l3 = this.f;
    long l4 = this.q;
    long l5 = this.x;
    StringBuilder localStringBuilder = new StringBuilder(218);
    localStringBuilder.append("Motion photo metadata: photoStartPosition=");
    localStringBuilder.append(l1);
    localStringBuilder.append(", photoSize=");
    localStringBuilder.append(l2);
    localStringBuilder.append(", photoPresentationTimestampUs=");
    localStringBuilder.append(l3);
    localStringBuilder.append(", videoStartPosition=");
    localStringBuilder.append(l4);
    localStringBuilder.append(", videoSize=");
    localStringBuilder.append(l5);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.c);
    paramParcel.writeLong(this.d);
    paramParcel.writeLong(this.f);
    paramParcel.writeLong(this.q);
    paramParcel.writeLong(this.x);
  }
  
  class a
    implements Parcelable.Creator<MotionPhotoMetadata>
  {
    public MotionPhotoMetadata a(Parcel paramParcel)
    {
      return new MotionPhotoMetadata(paramParcel, null);
    }
    
    public MotionPhotoMetadata[] b(int paramInt)
    {
      return new MotionPhotoMetadata[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\mp4\MotionPhotoMetadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */