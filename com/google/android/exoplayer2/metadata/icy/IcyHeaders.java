package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import java.util.List;
import java.util.Map;

public final class IcyHeaders
  implements Metadata.Entry
{
  public static final Parcelable.Creator<IcyHeaders> CREATOR = new a();
  public final int c;
  @Nullable
  public final String d;
  @Nullable
  public final String f;
  @Nullable
  public final String q;
  public final boolean x;
  public final int y;
  
  public IcyHeaders(int paramInt1, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, boolean paramBoolean, int paramInt2)
  {
    boolean bool;
    if ((paramInt2 != -1) && (paramInt2 <= 0)) {
      bool = false;
    } else {
      bool = true;
    }
    g.a(bool);
    this.c = paramInt1;
    this.d = paramString1;
    this.f = paramString2;
    this.q = paramString3;
    this.x = paramBoolean;
    this.y = paramInt2;
  }
  
  IcyHeaders(Parcel paramParcel)
  {
    this.c = paramParcel.readInt();
    this.d = paramParcel.readString();
    this.f = paramParcel.readString();
    this.q = paramParcel.readString();
    this.x = o0.A0(paramParcel);
    this.y = paramParcel.readInt();
  }
  
  @Nullable
  public static IcyHeaders a(Map<String, List<String>> paramMap)
  {
    Object localObject1 = (List)paramMap.get("icy-br");
    int i = -1;
    int j = 1;
    int k;
    int m;
    if (localObject1 != null)
    {
      localObject3 = (String)((List)localObject1).get(0);
      try
      {
        k = Integer.parseInt((String)localObject3);
        m = k * 1000;
        if (m > 0) {
          k = 1;
        }
        try
        {
          localObject1 = String.valueOf(localObject3);
          if (((String)localObject1).length() != 0) {
            localObject1 = "Invalid bitrate: ".concat((String)localObject1);
          } else {
            localObject1 = new String("Invalid bitrate: ");
          }
          u.h("IcyHeaders", (String)localObject1);
          k = 0;
          m = -1;
        }
        catch (NumberFormatException localNumberFormatException1)
        {
          k = m;
        }
        localObject2 = String.valueOf(localObject3);
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        k = -1;
      }
      if (((String)localObject2).length() != 0) {
        localObject2 = "Invalid bitrate header: ".concat((String)localObject2);
      } else {
        localObject2 = new String("Invalid bitrate header: ");
      }
      u.h("IcyHeaders", (String)localObject2);
      m = k;
      k = 0;
    }
    else
    {
      k = 0;
      m = -1;
    }
    Object localObject2 = (List)paramMap.get("icy-genre");
    Object localObject4 = null;
    if (localObject2 != null)
    {
      localObject2 = (String)((List)localObject2).get(0);
      k = 1;
    }
    else
    {
      localObject2 = null;
    }
    Object localObject3 = (List)paramMap.get("icy-name");
    if (localObject3 != null)
    {
      localObject3 = (String)((List)localObject3).get(0);
      k = 1;
    }
    else
    {
      localObject3 = null;
    }
    Object localObject5 = (List)paramMap.get("icy-url");
    if (localObject5 != null)
    {
      localObject5 = (String)((List)localObject5).get(0);
      k = 1;
    }
    else
    {
      localObject5 = null;
    }
    Object localObject6 = (List)paramMap.get("icy-pub");
    boolean bool;
    if (localObject6 != null)
    {
      bool = ((String)((List)localObject6).get(0)).equals("1");
      k = 1;
    }
    else
    {
      bool = false;
    }
    paramMap = (List)paramMap.get("icy-metaint");
    int n = k;
    int i1 = i;
    if (paramMap != null)
    {
      localObject6 = (String)paramMap.get(0);
      try
      {
        i1 = Integer.parseInt((String)localObject6);
        if (i1 > 0)
        {
          i = i1;
          k = j;
        }
        try
        {
          paramMap = String.valueOf(localObject6);
          if (paramMap.length() != 0) {
            paramMap = "Invalid metadata interval: ".concat(paramMap);
          } else {
            paramMap = new String("Invalid metadata interval: ");
          }
          u.h("IcyHeaders", paramMap);
          n = k;
          i1 = i;
        }
        catch (NumberFormatException paramMap)
        {
          i = i1;
        }
        paramMap = String.valueOf(localObject6);
      }
      catch (NumberFormatException paramMap) {}
      if (paramMap.length() != 0) {
        paramMap = "Invalid metadata interval: ".concat(paramMap);
      } else {
        paramMap = new String("Invalid metadata interval: ");
      }
      u.h("IcyHeaders", paramMap);
      i1 = i;
      n = k;
    }
    paramMap = (Map<String, List<String>>)localObject4;
    if (n != 0) {
      paramMap = new IcyHeaders(m, (String)localObject2, (String)localObject3, (String)localObject5, bool, i1);
    }
    return paramMap;
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
    if ((paramObject != null) && (IcyHeaders.class == paramObject.getClass()))
    {
      paramObject = (IcyHeaders)paramObject;
      if ((this.c != ((IcyHeaders)paramObject).c) || (!o0.b(this.d, ((IcyHeaders)paramObject).d)) || (!o0.b(this.f, ((IcyHeaders)paramObject).f)) || (!o0.b(this.q, ((IcyHeaders)paramObject).q)) || (this.x != ((IcyHeaders)paramObject).x) || (this.y != ((IcyHeaders)paramObject).y)) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = this.c;
    String str = this.d;
    int j = 0;
    int k;
    if (str != null) {
      k = str.hashCode();
    } else {
      k = 0;
    }
    str = this.f;
    int m;
    if (str != null) {
      m = str.hashCode();
    } else {
      m = 0;
    }
    str = this.q;
    if (str != null) {
      j = str.hashCode();
    }
    return (((((527 + i) * 31 + k) * 31 + m) * 31 + j) * 31 + this.x) * 31 + this.y;
  }
  
  public String toString()
  {
    String str1 = this.f;
    String str2 = this.d;
    int i = this.c;
    int j = this.y;
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 80 + String.valueOf(str2).length());
    localStringBuilder.append("IcyHeaders: name=\"");
    localStringBuilder.append(str1);
    localStringBuilder.append("\", genre=\"");
    localStringBuilder.append(str2);
    localStringBuilder.append("\", bitrate=");
    localStringBuilder.append(i);
    localStringBuilder.append(", metadataInterval=");
    localStringBuilder.append(j);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.c);
    paramParcel.writeString(this.d);
    paramParcel.writeString(this.f);
    paramParcel.writeString(this.q);
    o0.N0(paramParcel, this.x);
    paramParcel.writeInt(this.y);
  }
  
  class a
    implements Parcelable.Creator<IcyHeaders>
  {
    public IcyHeaders a(Parcel paramParcel)
    {
      return new IcyHeaders(paramParcel);
    }
    
    public IcyHeaders[] b(int paramInt)
    {
      return new IcyHeaders[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\metadata\icy\IcyHeaders.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */