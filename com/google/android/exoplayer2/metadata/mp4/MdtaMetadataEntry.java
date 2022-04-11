package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;

public final class MdtaMetadataEntry
  implements Metadata.Entry
{
  public static final Parcelable.Creator<MdtaMetadataEntry> CREATOR = new a();
  public final String c;
  public final byte[] d;
  public final int f;
  public final int q;
  
  private MdtaMetadataEntry(Parcel paramParcel)
  {
    this.c = ((String)o0.i(paramParcel.readString()));
    this.d = ((byte[])o0.i(paramParcel.createByteArray()));
    this.f = paramParcel.readInt();
    this.q = paramParcel.readInt();
  }
  
  public MdtaMetadataEntry(String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.c = paramString;
    this.d = paramArrayOfByte;
    this.f = paramInt1;
    this.q = paramInt2;
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
    if ((paramObject != null) && (MdtaMetadataEntry.class == paramObject.getClass()))
    {
      paramObject = (MdtaMetadataEntry)paramObject;
      if ((!this.c.equals(((MdtaMetadataEntry)paramObject).c)) || (!Arrays.equals(this.d, ((MdtaMetadataEntry)paramObject).d)) || (this.f != ((MdtaMetadataEntry)paramObject).f) || (this.q != ((MdtaMetadataEntry)paramObject).q)) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return (((527 + this.c.hashCode()) * 31 + Arrays.hashCode(this.d)) * 31 + this.f) * 31 + this.q;
  }
  
  public String toString()
  {
    String str = String.valueOf(this.c);
    if (str.length() != 0) {
      str = "mdta: key=".concat(str);
    } else {
      str = new String("mdta: key=");
    }
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.c);
    paramParcel.writeByteArray(this.d);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.q);
  }
  
  class a
    implements Parcelable.Creator<MdtaMetadataEntry>
  {
    public MdtaMetadataEntry a(Parcel paramParcel)
    {
      return new MdtaMetadataEntry(paramParcel, null);
    }
    
    public MdtaMetadataEntry[] b(int paramInt)
    {
      return new MdtaMetadataEntry[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\mp4\MdtaMetadataEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */