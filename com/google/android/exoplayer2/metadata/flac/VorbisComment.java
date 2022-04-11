package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.m1.b;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.util.o0;

public final class VorbisComment
  implements Metadata.Entry
{
  public static final Parcelable.Creator<VorbisComment> CREATOR = new a();
  public final String c;
  public final String d;
  
  VorbisComment(Parcel paramParcel)
  {
    this.c = ((String)o0.i(paramParcel.readString()));
    this.d = ((String)o0.i(paramParcel.readString()));
  }
  
  public VorbisComment(String paramString1, String paramString2)
  {
    this.c = paramString1;
    this.d = paramString2;
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
    if ((paramObject != null) && (VorbisComment.class == paramObject.getClass()))
    {
      paramObject = (VorbisComment)paramObject;
      if ((!this.c.equals(((VorbisComment)paramObject).c)) || (!this.d.equals(((VorbisComment)paramObject).d))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    return (527 + this.c.hashCode()) * 31 + this.d.hashCode();
  }
  
  public void j(m1.b paramb)
  {
    String str = this.c;
    str.hashCode();
    int i = str.hashCode();
    int j = -1;
    switch (i)
    {
    default: 
      break;
    case 1939198791: 
      if (str.equals("ARTIST")) {
        j = 4;
      }
      break;
    case 1746739798: 
      if (str.equals("ALBUMARTIST")) {
        j = 3;
      }
      break;
    case 428414940: 
      if (str.equals("DESCRIPTION")) {
        j = 2;
      }
      break;
    case 79833656: 
      if (str.equals("TITLE")) {
        j = 1;
      }
      break;
    case 62359119: 
      if (str.equals("ALBUM")) {
        j = 0;
      }
      break;
    }
    switch (j)
    {
    default: 
      break;
    case 4: 
      paramb.L(this.d);
      break;
    case 3: 
      paramb.J(this.d);
      break;
    case 2: 
      paramb.O(this.d);
      break;
    case 1: 
      paramb.V(this.d);
      break;
    case 0: 
      paramb.K(this.d);
    }
  }
  
  public String toString()
  {
    String str1 = this.c;
    String str2 = this.d;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 5 + String.valueOf(str2).length());
    localStringBuilder.append("VC: ");
    localStringBuilder.append(str1);
    localStringBuilder.append("=");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.c);
    paramParcel.writeString(this.d);
  }
  
  class a
    implements Parcelable.Creator<VorbisComment>
  {
    public VorbisComment a(Parcel paramParcel)
    {
      return new VorbisComment(paramParcel);
    }
    
    public VorbisComment[] b(int paramInt)
    {
      return new VorbisComment[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\flac\VorbisComment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */