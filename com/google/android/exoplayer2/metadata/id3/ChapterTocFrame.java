package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;

public final class ChapterTocFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<ChapterTocFrame> CREATOR = new a();
  public final String d;
  public final boolean f;
  public final boolean q;
  public final String[] x;
  private final Id3Frame[] y;
  
  ChapterTocFrame(Parcel paramParcel)
  {
    super("CTOC");
    this.d = ((String)o0.i(paramParcel.readString()));
    int i = paramParcel.readByte();
    boolean bool1 = true;
    int j = 0;
    boolean bool2;
    if (i != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.f = bool2;
    if (paramParcel.readByte() != 0) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    this.q = bool2;
    this.x = ((String[])o0.i(paramParcel.createStringArray()));
    i = paramParcel.readInt();
    this.y = new Id3Frame[i];
    while (j < i)
    {
      this.y[j] = ((Id3Frame)paramParcel.readParcelable(Id3Frame.class.getClassLoader()));
      j++;
    }
  }
  
  public ChapterTocFrame(String paramString, boolean paramBoolean1, boolean paramBoolean2, String[] paramArrayOfString, Id3Frame[] paramArrayOfId3Frame)
  {
    super("CTOC");
    this.d = paramString;
    this.f = paramBoolean1;
    this.q = paramBoolean2;
    this.x = paramArrayOfString;
    this.y = paramArrayOfId3Frame;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (ChapterTocFrame.class == paramObject.getClass()))
    {
      paramObject = (ChapterTocFrame)paramObject;
      if ((this.f != ((ChapterTocFrame)paramObject).f) || (this.q != ((ChapterTocFrame)paramObject).q) || (!o0.b(this.d, ((ChapterTocFrame)paramObject).d)) || (!Arrays.equals(this.x, ((ChapterTocFrame)paramObject).x)) || (!Arrays.equals(this.y, ((ChapterTocFrame)paramObject).y))) {
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
    String str = this.d;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    return ((527 + i) * 31 + j) * 31 + k;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.d);
    paramParcel.writeByte((byte)this.f);
    paramParcel.writeByte((byte)this.q);
    paramParcel.writeStringArray(this.x);
    paramParcel.writeInt(this.y.length);
    Id3Frame[] arrayOfId3Frame = this.y;
    int i = arrayOfId3Frame.length;
    for (paramInt = 0; paramInt < i; paramInt++) {
      paramParcel.writeParcelable(arrayOfId3Frame[paramInt], 0);
    }
  }
  
  class a
    implements Parcelable.Creator<ChapterTocFrame>
  {
    public ChapterTocFrame a(Parcel paramParcel)
    {
      return new ChapterTocFrame(paramParcel);
    }
    
    public ChapterTocFrame[] b(int paramInt)
    {
      return new ChapterTocFrame[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\id3\ChapterTocFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */