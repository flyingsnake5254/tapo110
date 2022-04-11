package com.google.android.exoplayer2.metadata.emsg;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format.b;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.util.o0;
import java.util.Arrays;

public final class EventMessage
  implements Metadata.Entry
{
  public static final Parcelable.Creator<EventMessage> CREATOR = new a();
  private static final Format c = new Format.b().e0("application/id3").E();
  private static final Format d = new Format.b().e0("application/x-scte35").E();
  public final String f;
  private int p0;
  public final String q;
  public final long x;
  public final long y;
  public final byte[] z;
  
  EventMessage(Parcel paramParcel)
  {
    this.f = ((String)o0.i(paramParcel.readString()));
    this.q = ((String)o0.i(paramParcel.readString()));
    this.x = paramParcel.readLong();
    this.y = paramParcel.readLong();
    this.z = ((byte[])o0.i(paramParcel.createByteArray()));
  }
  
  public EventMessage(String paramString1, String paramString2, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    this.f = paramString1;
    this.q = paramString2;
    this.x = paramLong1;
    this.y = paramLong2;
    this.z = paramArrayOfByte;
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
    if ((paramObject != null) && (EventMessage.class == paramObject.getClass()))
    {
      paramObject = (EventMessage)paramObject;
      if ((this.x != ((EventMessage)paramObject).x) || (this.y != ((EventMessage)paramObject).y) || (!o0.b(this.f, ((EventMessage)paramObject).f)) || (!o0.b(this.q, ((EventMessage)paramObject).q)) || (!Arrays.equals(this.z, ((EventMessage)paramObject).z))) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  @Nullable
  public Format g()
  {
    String str = this.f;
    str.hashCode();
    int i = str.hashCode();
    int j = -1;
    switch (i)
    {
    default: 
      break;
    case 1303648457: 
      if (str.equals("https://developer.apple.com/streaming/emsg-id3")) {
        j = 2;
      }
      break;
    case -795945609: 
      if (str.equals("https://aomedia.org/emsg/ID3")) {
        j = 1;
      }
      break;
    case -1468477611: 
      if (str.equals("urn:scte:scte35:2014:bin")) {
        j = 0;
      }
      break;
    }
    switch (j)
    {
    default: 
      return null;
    case 1: 
    case 2: 
      return c;
    }
    return d;
  }
  
  public int hashCode()
  {
    if (this.p0 == 0)
    {
      String str = this.f;
      int i = 0;
      int j;
      if (str != null) {
        j = str.hashCode();
      } else {
        j = 0;
      }
      str = this.q;
      if (str != null) {
        i = str.hashCode();
      }
      long l = this.x;
      int k = (int)(l ^ l >>> 32);
      l = this.y;
      this.p0 = (((((527 + j) * 31 + i) * 31 + k) * 31 + (int)(l ^ l >>> 32)) * 31 + Arrays.hashCode(this.z));
    }
    return this.p0;
  }
  
  @Nullable
  public byte[] k()
  {
    byte[] arrayOfByte;
    if (g() != null) {
      arrayOfByte = this.z;
    } else {
      arrayOfByte = null;
    }
    return arrayOfByte;
  }
  
  public String toString()
  {
    String str1 = this.f;
    long l1 = this.y;
    long l2 = this.x;
    String str2 = this.q;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 79 + String.valueOf(str2).length());
    localStringBuilder.append("EMSG: scheme=");
    localStringBuilder.append(str1);
    localStringBuilder.append(", id=");
    localStringBuilder.append(l1);
    localStringBuilder.append(", durationMs=");
    localStringBuilder.append(l2);
    localStringBuilder.append(", value=");
    localStringBuilder.append(str2);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.q);
    paramParcel.writeLong(this.x);
    paramParcel.writeLong(this.y);
    paramParcel.writeByteArray(this.z);
  }
  
  class a
    implements Parcelable.Creator<EventMessage>
  {
    public EventMessage a(Parcel paramParcel)
    {
      return new EventMessage(paramParcel);
    }
    
    public EventMessage[] b(int paramInt)
    {
      return new EventMessage[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\emsg\EventMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */