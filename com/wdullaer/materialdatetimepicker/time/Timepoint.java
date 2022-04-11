package com.wdullaer.materialdatetimepicker.time;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;

public class Timepoint
  implements Parcelable, Comparable<Timepoint>
{
  public static final Parcelable.Creator<Timepoint> CREATOR = new a();
  private int c;
  private int d;
  private int f;
  
  public Timepoint(@IntRange(from=0L, to=23L) int paramInt1, @IntRange(from=0L, to=59L) int paramInt2, @IntRange(from=0L, to=59L) int paramInt3)
  {
    this.c = (paramInt1 % 24);
    this.d = (paramInt2 % 60);
    this.f = (paramInt3 % 60);
  }
  
  public Timepoint(Parcel paramParcel)
  {
    this.c = paramParcel.readInt();
    this.d = paramParcel.readInt();
    this.f = paramParcel.readInt();
  }
  
  public Timepoint(Timepoint paramTimepoint)
  {
    this(paramTimepoint.c, paramTimepoint.d, paramTimepoint.f);
  }
  
  public int a(@NonNull Timepoint paramTimepoint)
  {
    return hashCode() - paramTimepoint.hashCode();
  }
  
  @IntRange(from=0L, to=23L)
  public int b()
  {
    return this.c;
  }
  
  @IntRange(from=0L, to=59L)
  public int c()
  {
    return this.d;
  }
  
  @IntRange(from=0L, to=59L)
  public int d()
  {
    return this.f;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean e()
  {
    boolean bool;
    if (this.c < 12) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (getClass() == paramObject.getClass()))
    {
      paramObject = (Timepoint)paramObject;
      if (hashCode() != ((Timepoint)paramObject).hashCode()) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public boolean f()
  {
    return e() ^ true;
  }
  
  public void h()
  {
    int i = this.c;
    if (i >= 12) {
      this.c = (i % 12);
    }
  }
  
  public int hashCode()
  {
    return l();
  }
  
  public void i()
  {
    int i = this.c;
    if (i < 12) {
      this.c = ((i + 12) % 24);
    }
  }
  
  public int l()
  {
    return this.c * 3600 + this.d * 60 + this.f;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.c);
    localStringBuilder.append("h ");
    localStringBuilder.append(this.d);
    localStringBuilder.append("m ");
    localStringBuilder.append(this.f);
    localStringBuilder.append("s");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.c);
    paramParcel.writeInt(this.d);
    paramParcel.writeInt(this.f);
  }
  
  public static enum TYPE
  {
    static
    {
      TYPE localTYPE1 = new TYPE("HOUR", 0);
      HOUR = localTYPE1;
      TYPE localTYPE2 = new TYPE("MINUTE", 1);
      MINUTE = localTYPE2;
      TYPE localTYPE3 = new TYPE("SECOND", 2);
      SECOND = localTYPE3;
      $VALUES = new TYPE[] { localTYPE1, localTYPE2, localTYPE3 };
    }
  }
  
  static final class a
    implements Parcelable.Creator<Timepoint>
  {
    public Timepoint a(Parcel paramParcel)
    {
      return new Timepoint(paramParcel);
    }
    
    public Timepoint[] b(int paramInt)
    {
      return new Timepoint[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\wdullaer\materialdatetimepicker\time\Timepoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */