package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;

public final class InternalFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<InternalFrame> CREATOR = new a();
  public final String d;
  public final String f;
  public final String q;
  
  InternalFrame(Parcel paramParcel)
  {
    super("----");
    this.d = ((String)o0.i(paramParcel.readString()));
    this.f = ((String)o0.i(paramParcel.readString()));
    this.q = ((String)o0.i(paramParcel.readString()));
  }
  
  public InternalFrame(String paramString1, String paramString2, String paramString3)
  {
    super("----");
    this.d = paramString1;
    this.f = paramString2;
    this.q = paramString3;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (InternalFrame.class == paramObject.getClass()))
    {
      paramObject = (InternalFrame)paramObject;
      if ((!o0.b(this.f, ((InternalFrame)paramObject).f)) || (!o0.b(this.d, ((InternalFrame)paramObject).d)) || (!o0.b(this.q, ((InternalFrame)paramObject).q))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.d;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.f;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.q;
    if (str != null) {
      i = str.hashCode();
    }
    return ((527 + j) * 31 + k) * 31 + i;
  }
  
  public String toString()
  {
    String str1 = this.c;
    String str2 = this.d;
    String str3 = this.f;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 23 + String.valueOf(str2).length() + String.valueOf(str3).length());
    localStringBuilder.append(str1);
    localStringBuilder.append(": domain=");
    localStringBuilder.append(str2);
    localStringBuilder.append(", description=");
    localStringBuilder.append(str3);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.q);
  }
  
  class a
    implements Parcelable.Creator<InternalFrame>
  {
    public InternalFrame a(Parcel paramParcel)
    {
      return new InternalFrame(paramParcel);
    }
    
    public InternalFrame[] b(int paramInt)
    {
      return new InternalFrame[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\id3\InternalFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */