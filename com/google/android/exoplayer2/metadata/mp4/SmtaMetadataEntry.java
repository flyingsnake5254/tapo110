package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.common.primitives.c;

public final class SmtaMetadataEntry
  implements Metadata.Entry
{
  public static final Parcelable.Creator<SmtaMetadataEntry> CREATOR = new a();
  public final float c;
  public final int d;
  
  public SmtaMetadataEntry(float paramFloat, int paramInt)
  {
    this.c = paramFloat;
    this.d = paramInt;
  }
  
  private SmtaMetadataEntry(Parcel paramParcel)
  {
    this.c = paramParcel.readFloat();
    this.d = paramParcel.readInt();
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
    if ((paramObject != null) && (SmtaMetadataEntry.class == paramObject.getClass()))
    {
      paramObject = (SmtaMetadataEntry)paramObject;
      if ((this.c != ((SmtaMetadataEntry)paramObject).c) || (this.d != ((SmtaMetadataEntry)paramObject).d)) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return (527 + c.a(this.c)) * 31 + this.d;
  }
  
  public String toString()
  {
    float f = this.c;
    int i = this.d;
    StringBuilder localStringBuilder = new StringBuilder(73);
    localStringBuilder.append("smta: captureFrameRate=");
    localStringBuilder.append(f);
    localStringBuilder.append(", svcTemporalLayerCount=");
    localStringBuilder.append(i);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeFloat(this.c);
    paramParcel.writeInt(this.d);
  }
  
  class a
    implements Parcelable.Creator<SmtaMetadataEntry>
  {
    public SmtaMetadataEntry a(Parcel paramParcel)
    {
      return new SmtaMetadataEntry(paramParcel, null);
    }
    
    public SmtaMetadataEntry[] b(int paramInt)
    {
      return new SmtaMetadataEntry[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\mp4\SmtaMetadataEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */