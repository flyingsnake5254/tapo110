package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.common.base.k;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public final class SlowMotionData
  implements Metadata.Entry
{
  public static final Parcelable.Creator<SlowMotionData> CREATOR = new a();
  public final List<Segment> c;
  
  public SlowMotionData(List<Segment> paramList)
  {
    this.c = paramList;
    g.a(a(paramList) ^ true);
  }
  
  private static boolean a(List<Segment> paramList)
  {
    if (paramList.isEmpty()) {
      return false;
    }
    long l = ((Segment)paramList.get(0)).f;
    for (int i = 1; i < paramList.size(); i++)
    {
      if (((Segment)paramList.get(i)).d < l) {
        return true;
      }
      l = ((Segment)paramList.get(i)).f;
    }
    return false;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (SlowMotionData.class == paramObject.getClass()))
    {
      paramObject = (SlowMotionData)paramObject;
      return this.c.equals(((SlowMotionData)paramObject).c);
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.c.hashCode();
  }
  
  public String toString()
  {
    String str = String.valueOf(this.c);
    StringBuilder localStringBuilder = new StringBuilder(str.length() + 21);
    localStringBuilder.append("SlowMotion: segments=");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.c);
  }
  
  public static final class Segment
    implements Parcelable
  {
    public static final Parcelable.Creator<Segment> CREATOR = new a();
    public static final Comparator<Segment> c = a.c;
    public final long d;
    public final long f;
    public final int q;
    
    public Segment(long paramLong1, long paramLong2, int paramInt)
    {
      boolean bool;
      if (paramLong1 < paramLong2) {
        bool = true;
      } else {
        bool = false;
      }
      g.a(bool);
      this.d = paramLong1;
      this.f = paramLong2;
      this.q = paramInt;
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
      if ((paramObject != null) && (Segment.class == paramObject.getClass()))
      {
        paramObject = (Segment)paramObject;
        if ((this.d != ((Segment)paramObject).d) || (this.f != ((Segment)paramObject).f) || (this.q != ((Segment)paramObject).q)) {
          bool = false;
        }
        return bool;
      }
      return false;
    }
    
    public int hashCode()
    {
      return k.b(new Object[] { Long.valueOf(this.d), Long.valueOf(this.f), Integer.valueOf(this.q) });
    }
    
    public String toString()
    {
      return o0.A("Segment: startTimeMs=%d, endTimeMs=%d, speedDivisor=%d", new Object[] { Long.valueOf(this.d), Long.valueOf(this.f), Integer.valueOf(this.q) });
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeLong(this.d);
      paramParcel.writeLong(this.f);
      paramParcel.writeInt(this.q);
    }
    
    class a
      implements Parcelable.Creator<SlowMotionData.Segment>
    {
      public SlowMotionData.Segment a(Parcel paramParcel)
      {
        return new SlowMotionData.Segment(paramParcel.readLong(), paramParcel.readLong(), paramParcel.readInt());
      }
      
      public SlowMotionData.Segment[] b(int paramInt)
      {
        return new SlowMotionData.Segment[paramInt];
      }
    }
  }
  
  class a
    implements Parcelable.Creator<SlowMotionData>
  {
    public SlowMotionData a(Parcel paramParcel)
    {
      ArrayList localArrayList = new ArrayList();
      paramParcel.readList(localArrayList, SlowMotionData.Segment.class.getClassLoader());
      return new SlowMotionData(localArrayList);
    }
    
    public SlowMotionData[] b(int paramInt)
    {
      return new SlowMotionData[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\mp4\SlowMotionData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */