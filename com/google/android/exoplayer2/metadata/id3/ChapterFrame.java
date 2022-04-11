package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;

public final class ChapterFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<ChapterFrame> CREATOR = new a();
  public final String d;
  public final int f;
  public final int q;
  public final long x;
  public final long y;
  private final Id3Frame[] z;
  
  ChapterFrame(Parcel paramParcel)
  {
    super("CHAP");
    this.d = ((String)o0.i(paramParcel.readString()));
    this.f = paramParcel.readInt();
    this.q = paramParcel.readInt();
    this.x = paramParcel.readLong();
    this.y = paramParcel.readLong();
    int i = paramParcel.readInt();
    this.z = new Id3Frame[i];
    for (int j = 0; j < i; j++) {
      this.z[j] = ((Id3Frame)paramParcel.readParcelable(Id3Frame.class.getClassLoader()));
    }
  }
  
  public ChapterFrame(String paramString, int paramInt1, int paramInt2, long paramLong1, long paramLong2, Id3Frame[] paramArrayOfId3Frame)
  {
    super("CHAP");
    this.d = paramString;
    this.f = paramInt1;
    this.q = paramInt2;
    this.x = paramLong1;
    this.y = paramLong2;
    this.z = paramArrayOfId3Frame;
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
    if ((paramObject != null) && (ChapterFrame.class == paramObject.getClass()))
    {
      paramObject = (ChapterFrame)paramObject;
      if ((this.f != ((ChapterFrame)paramObject).f) || (this.q != ((ChapterFrame)paramObject).q) || (this.x != ((ChapterFrame)paramObject).x) || (this.y != ((ChapterFrame)paramObject).y) || (!o0.b(this.d, ((ChapterFrame)paramObject).d)) || (!Arrays.equals(this.z, ((ChapterFrame)paramObject).z))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = this.f;
    int j = this.q;
    int k = (int)this.x;
    int m = (int)this.y;
    String str = this.d;
    int n;
    if (str != null) {
      n = str.hashCode();
    } else {
      n = 0;
    }
    return ((((527 + i) * 31 + j) * 31 + k) * 31 + m) * 31 + n;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.d);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.q);
    paramParcel.writeLong(this.x);
    paramParcel.writeLong(this.y);
    paramParcel.writeInt(this.z.length);
    Id3Frame[] arrayOfId3Frame = this.z;
    int i = arrayOfId3Frame.length;
    for (paramInt = 0; paramInt < i; paramInt++) {
      paramParcel.writeParcelable(arrayOfId3Frame[paramInt], 0);
    }
  }
  
  class a
    implements Parcelable.Creator<ChapterFrame>
  {
    public ChapterFrame a(Parcel paramParcel)
    {
      return new ChapterFrame(paramParcel);
    }
    
    public ChapterFrame[] b(int paramInt)
    {
      return new ChapterFrame[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\id3\ChapterFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */