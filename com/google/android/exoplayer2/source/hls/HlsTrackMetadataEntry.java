package com.google.android.exoplayer2.source.hls;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class HlsTrackMetadataEntry
  implements Metadata.Entry
{
  public static final Parcelable.Creator<HlsTrackMetadataEntry> CREATOR = new a();
  @Nullable
  public final String c;
  @Nullable
  public final String d;
  public final List<VariantInfo> f;
  
  HlsTrackMetadataEntry(Parcel paramParcel)
  {
    this.c = paramParcel.readString();
    this.d = paramParcel.readString();
    int i = paramParcel.readInt();
    ArrayList localArrayList = new ArrayList(i);
    for (int j = 0; j < i; j++) {
      localArrayList.add((VariantInfo)paramParcel.readParcelable(VariantInfo.class.getClassLoader()));
    }
    this.f = Collections.unmodifiableList(localArrayList);
  }
  
  public HlsTrackMetadataEntry(@Nullable String paramString1, @Nullable String paramString2, List<VariantInfo> paramList)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.f = Collections.unmodifiableList(new ArrayList(paramList));
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
    if ((paramObject != null) && (HlsTrackMetadataEntry.class == paramObject.getClass()))
    {
      paramObject = (HlsTrackMetadataEntry)paramObject;
      if ((!TextUtils.equals(this.c, ((HlsTrackMetadataEntry)paramObject).c)) || (!TextUtils.equals(this.d, ((HlsTrackMetadataEntry)paramObject).d)) || (!this.f.equals(((HlsTrackMetadataEntry)paramObject).f))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.c;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.d;
    if (str != null) {
      i = str.hashCode();
    }
    return (j * 31 + i) * 31 + this.f.hashCode();
  }
  
  public String toString()
  {
    String str1 = this.c;
    if (str1 != null)
    {
      String str2 = this.d;
      StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 5 + String.valueOf(str2).length());
      localStringBuilder.append(" [");
      localStringBuilder.append(str1);
      localStringBuilder.append(", ");
      localStringBuilder.append(str2);
      localStringBuilder.append("]");
      str1 = localStringBuilder.toString();
    }
    else
    {
      str1 = "";
    }
    str1 = String.valueOf(str1);
    if (str1.length() != 0) {
      str1 = "HlsTrackMetadataEntry".concat(str1);
    } else {
      str1 = new String("HlsTrackMetadataEntry");
    }
    return str1;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    int i = this.f.size();
    paramParcel.writeInt(i);
    for (paramInt = 0; paramInt < i; paramInt++) {
      paramParcel.writeParcelable((Parcelable)this.f.get(paramInt), 0);
    }
  }
  
  public static final class VariantInfo
    implements Parcelable
  {
    public static final Parcelable.Creator<VariantInfo> CREATOR = new a();
    public final int c;
    public final int d;
    @Nullable
    public final String f;
    @Nullable
    public final String q;
    @Nullable
    public final String x;
    @Nullable
    public final String y;
    
    public VariantInfo(int paramInt1, int paramInt2, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @Nullable String paramString4)
    {
      this.c = paramInt1;
      this.d = paramInt2;
      this.f = paramString1;
      this.q = paramString2;
      this.x = paramString3;
      this.y = paramString4;
    }
    
    VariantInfo(Parcel paramParcel)
    {
      this.c = paramParcel.readInt();
      this.d = paramParcel.readInt();
      this.f = paramParcel.readString();
      this.q = paramParcel.readString();
      this.x = paramParcel.readString();
      this.y = paramParcel.readString();
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
      if ((paramObject != null) && (VariantInfo.class == paramObject.getClass()))
      {
        paramObject = (VariantInfo)paramObject;
        if ((this.c != ((VariantInfo)paramObject).c) || (this.d != ((VariantInfo)paramObject).d) || (!TextUtils.equals(this.f, ((VariantInfo)paramObject).f)) || (!TextUtils.equals(this.q, ((VariantInfo)paramObject).q)) || (!TextUtils.equals(this.x, ((VariantInfo)paramObject).x)) || (!TextUtils.equals(this.y, ((VariantInfo)paramObject).y))) {
          bool = false;
        }
        return bool;
      }
      return false;
    }
    
    public int hashCode()
    {
      int i = this.c;
      int j = this.d;
      String str = this.f;
      int k = 0;
      int m;
      if (str != null) {
        m = str.hashCode();
      } else {
        m = 0;
      }
      str = this.q;
      int n;
      if (str != null) {
        n = str.hashCode();
      } else {
        n = 0;
      }
      str = this.x;
      int i1;
      if (str != null) {
        i1 = str.hashCode();
      } else {
        i1 = 0;
      }
      str = this.y;
      if (str != null) {
        k = str.hashCode();
      }
      return ((((i * 31 + j) * 31 + m) * 31 + n) * 31 + i1) * 31 + k;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeInt(this.c);
      paramParcel.writeInt(this.d);
      paramParcel.writeString(this.f);
      paramParcel.writeString(this.q);
      paramParcel.writeString(this.x);
      paramParcel.writeString(this.y);
    }
    
    class a
      implements Parcelable.Creator<HlsTrackMetadataEntry.VariantInfo>
    {
      public HlsTrackMetadataEntry.VariantInfo a(Parcel paramParcel)
      {
        return new HlsTrackMetadataEntry.VariantInfo(paramParcel);
      }
      
      public HlsTrackMetadataEntry.VariantInfo[] b(int paramInt)
      {
        return new HlsTrackMetadataEntry.VariantInfo[paramInt];
      }
    }
  }
  
  class a
    implements Parcelable.Creator<HlsTrackMetadataEntry>
  {
    public HlsTrackMetadataEntry a(Parcel paramParcel)
    {
      return new HlsTrackMetadataEntry(paramParcel);
    }
    
    public HlsTrackMetadataEntry[] b(int paramInt)
    {
      return new HlsTrackMetadataEntry[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\source\hls\HlsTrackMetadataEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */