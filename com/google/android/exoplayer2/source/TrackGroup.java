package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.u;
import java.util.Arrays;

public final class TrackGroup
  implements Parcelable
{
  public static final Parcelable.Creator<TrackGroup> CREATOR = new a();
  public final int c;
  private final Format[] d;
  private int f;
  
  TrackGroup(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    this.c = i;
    this.d = new Format[i];
    for (i = 0; i < this.c; i++) {
      this.d[i] = ((Format)paramParcel.readParcelable(Format.class.getClassLoader()));
    }
  }
  
  public TrackGroup(Format... paramVarArgs)
  {
    boolean bool;
    if (paramVarArgs.length > 0) {
      bool = true;
    } else {
      bool = false;
    }
    g.g(bool);
    this.d = paramVarArgs;
    this.c = paramVarArgs.length;
    f();
  }
  
  private static void c(String paramString1, @Nullable String paramString2, @Nullable String paramString3, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString1).length() + 78 + String.valueOf(paramString2).length() + String.valueOf(paramString3).length());
    localStringBuilder.append("Different ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" combined in one TrackGroup: '");
    localStringBuilder.append(paramString2);
    localStringBuilder.append("' (track 0) and '");
    localStringBuilder.append(paramString3);
    localStringBuilder.append("' (track ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(")");
    u.d("TrackGroup", "", new IllegalStateException(localStringBuilder.toString()));
  }
  
  private static String d(@Nullable String paramString)
  {
    String str;
    if (paramString != null)
    {
      str = paramString;
      if (!paramString.equals("und")) {}
    }
    else
    {
      str = "";
    }
    return str;
  }
  
  private static int e(int paramInt)
  {
    return paramInt | 0x4000;
  }
  
  private void f()
  {
    String str = d(this.d[0].f);
    int i = e(this.d[0].x);
    for (int j = 1;; j++)
    {
      Format[] arrayOfFormat = this.d;
      if (j >= arrayOfFormat.length) {
        break;
      }
      if (!str.equals(d(arrayOfFormat[j].f)))
      {
        arrayOfFormat = this.d;
        c("languages", arrayOfFormat[0].f, arrayOfFormat[j].f, j);
        return;
      }
      if (i != e(this.d[j].x))
      {
        c("role flags", Integer.toBinaryString(this.d[0].x), Integer.toBinaryString(this.d[j].x), j);
        return;
      }
    }
  }
  
  public Format a(int paramInt)
  {
    return this.d[paramInt];
  }
  
  public int b(Format paramFormat)
  {
    for (int i = 0;; i++)
    {
      Format[] arrayOfFormat = this.d;
      if (i >= arrayOfFormat.length) {
        break;
      }
      if (paramFormat == arrayOfFormat[i]) {
        return i;
      }
    }
    return -1;
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
    if ((paramObject != null) && (TrackGroup.class == paramObject.getClass()))
    {
      paramObject = (TrackGroup)paramObject;
      if ((this.c != ((TrackGroup)paramObject).c) || (!Arrays.equals(this.d, ((TrackGroup)paramObject).d))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    if (this.f == 0) {
      this.f = (527 + Arrays.hashCode(this.d));
    }
    return this.f;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.c);
    for (paramInt = 0; paramInt < this.c; paramInt++) {
      paramParcel.writeParcelable(this.d[paramInt], 0);
    }
  }
  
  class a
    implements Parcelable.Creator<TrackGroup>
  {
    public TrackGroup a(Parcel paramParcel)
    {
      return new TrackGroup(paramParcel);
    }
    
    public TrackGroup[] b(int paramInt)
    {
      return new TrackGroup[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\TrackGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */