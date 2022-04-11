package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.o0;

public final class UrlLinkFrame
  extends Id3Frame
{
  public static final Parcelable.Creator<UrlLinkFrame> CREATOR = new a();
  @Nullable
  public final String d;
  public final String f;
  
  UrlLinkFrame(Parcel paramParcel)
  {
    super((String)o0.i(paramParcel.readString()));
    this.d = paramParcel.readString();
    this.f = ((String)o0.i(paramParcel.readString()));
  }
  
  public UrlLinkFrame(String paramString1, @Nullable String paramString2, String paramString3)
  {
    super(paramString1);
    this.d = paramString2;
    this.f = paramString3;
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (UrlLinkFrame.class == paramObject.getClass()))
    {
      paramObject = (UrlLinkFrame)paramObject;
      if ((!this.c.equals(((Id3Frame)paramObject).c)) || (!o0.b(this.d, ((UrlLinkFrame)paramObject).d)) || (!o0.b(this.f, ((UrlLinkFrame)paramObject).f))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = this.c.hashCode();
    String str = this.d;
    int j = 0;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.f;
    if (str != null) {
      j = str.hashCode();
    }
    return ((527 + i) * 31 + k) * 31 + j;
  }
  
  public String toString()
  {
    String str1 = this.c;
    String str2 = this.f;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 6 + String.valueOf(str2).length());
    localStringBuilder.append(str1);
    localStringBuilder.append(": url=");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.f);
  }
  
  class a
    implements Parcelable.Creator<UrlLinkFrame>
  {
    public UrlLinkFrame a(Parcel paramParcel)
    {
      return new UrlLinkFrame(paramParcel);
    }
    
    public UrlLinkFrame[] b(int paramInt)
    {
      return new UrlLinkFrame[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\id3\UrlLinkFrame.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */