package com.google.android.exoplayer2.metadata;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.m1.b;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;
import java.util.List;

public final class Metadata
  implements Parcelable
{
  public static final Parcelable.Creator<Metadata> CREATOR = new a();
  private final Entry[] c;
  
  Metadata(Parcel paramParcel)
  {
    this.c = new Entry[paramParcel.readInt()];
    for (int i = 0;; i++)
    {
      Entry[] arrayOfEntry = this.c;
      if (i >= arrayOfEntry.length) {
        break;
      }
      arrayOfEntry[i] = ((Entry)paramParcel.readParcelable(Entry.class.getClassLoader()));
    }
  }
  
  public Metadata(List<? extends Entry> paramList)
  {
    this.c = ((Entry[])paramList.toArray(new Entry[0]));
  }
  
  public Metadata(Entry... paramVarArgs)
  {
    this.c = paramVarArgs;
  }
  
  public Metadata a(Entry... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return this;
    }
    return new Metadata((Entry[])o0.v0(this.c, paramVarArgs));
  }
  
  public Metadata b(@Nullable Metadata paramMetadata)
  {
    if (paramMetadata == null) {
      return this;
    }
    return a(paramMetadata.c);
  }
  
  public Entry c(int paramInt)
  {
    return this.c[paramInt];
  }
  
  public int d()
  {
    return this.c.length;
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
    if ((paramObject != null) && (Metadata.class == paramObject.getClass()))
    {
      paramObject = (Metadata)paramObject;
      return Arrays.equals(this.c, ((Metadata)paramObject).c);
    }
    return false;
  }
  
  public int hashCode()
  {
    return Arrays.hashCode(this.c);
  }
  
  public String toString()
  {
    String str = String.valueOf(Arrays.toString(this.c));
    if (str.length() != 0) {
      str = "entries=".concat(str);
    } else {
      str = new String("entries=");
    }
    return str;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.c.length);
    Entry[] arrayOfEntry = this.c;
    int i = arrayOfEntry.length;
    for (paramInt = 0; paramInt < i; paramInt++) {
      paramParcel.writeParcelable(arrayOfEntry[paramInt], 0);
    }
  }
  
  public static abstract interface Entry
    extends Parcelable
  {
    @Nullable
    public abstract Format g();
    
    public abstract void j(m1.b paramb);
    
    @Nullable
    public abstract byte[] k();
  }
  
  class a
    implements Parcelable.Creator<Metadata>
  {
    public Metadata a(Parcel paramParcel)
    {
      return new Metadata(paramParcel);
    }
    
    public Metadata[] b(int paramInt)
    {
      return new Metadata[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\Metadata.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */