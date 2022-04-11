package com.tplink.libtpnetwork.cameranetwork.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import kotlin.jvm.internal.j;

public final class Wifi
  implements Parcelable
{
  public static final CREATOR CREATOR = new CREATOR(null);
  private final int auth;
  private final String bssid;
  private final Integer encryption;
  private final String password;
  private final int rssi;
  private final String ssid;
  
  public Wifi(Parcel paramParcel)
  {
    this(str1, str2, i, Integer.valueOf(j), k, paramParcel);
  }
  
  public Wifi(String paramString1, String paramString2, int paramInt1, Integer paramInteger, int paramInt2, String paramString3)
  {
    this.ssid = paramString1;
    this.bssid = paramString2;
    this.auth = paramInt1;
    this.encryption = paramInteger;
    this.rssi = paramInt2;
    this.password = paramString3;
  }
  
  public final String component1()
  {
    return this.ssid;
  }
  
  public final String component2()
  {
    return this.bssid;
  }
  
  public final int component3()
  {
    return this.auth;
  }
  
  public final Integer component4()
  {
    return this.encryption;
  }
  
  public final int component5()
  {
    return this.rssi;
  }
  
  public final String component6()
  {
    return this.password;
  }
  
  public final Wifi connectWithPassword(String paramString)
  {
    j.e(paramString, "password");
    return copy$default(this, null, null, 0, null, 0, paramString, 31, null);
  }
  
  public final Wifi copy(String paramString1, String paramString2, int paramInt1, Integer paramInteger, int paramInt2, String paramString3)
  {
    j.e(paramString1, "ssid");
    j.e(paramString3, "password");
    return new Wifi(paramString1, paramString2, paramInt1, paramInteger, paramInt2, paramString3);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof Wifi))
      {
        paramObject = (Wifi)paramObject;
        if ((j.a(this.ssid, ((Wifi)paramObject).ssid)) && (j.a(this.bssid, ((Wifi)paramObject).bssid)) && (this.auth == ((Wifi)paramObject).auth) && (j.a(this.encryption, ((Wifi)paramObject).encryption)) && (this.rssi == ((Wifi)paramObject).rssi) && (j.a(this.password, ((Wifi)paramObject).password))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final int getAuth()
  {
    return this.auth;
  }
  
  public final String getBssid()
  {
    return this.bssid;
  }
  
  public final Integer getEncryption()
  {
    return this.encryption;
  }
  
  public final String getPassword()
  {
    return this.password;
  }
  
  public final int getRssi()
  {
    return this.rssi;
  }
  
  public final String getSsid()
  {
    return this.ssid;
  }
  
  public int hashCode()
  {
    Object localObject = this.ssid;
    int i = 0;
    int j;
    if (localObject != null) {
      j = localObject.hashCode();
    } else {
      j = 0;
    }
    localObject = this.bssid;
    int k;
    if (localObject != null) {
      k = localObject.hashCode();
    } else {
      k = 0;
    }
    int m = this.auth;
    localObject = this.encryption;
    int n;
    if (localObject != null) {
      n = localObject.hashCode();
    } else {
      n = 0;
    }
    int i1 = this.rssi;
    localObject = this.password;
    if (localObject != null) {
      i = localObject.hashCode();
    }
    return ((((j * 31 + k) * 31 + m) * 31 + n) * 31 + i1) * 31 + i;
  }
  
  public final boolean isCommon()
  {
    boolean bool;
    if ((!isWEP()) && (!isWPA3())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public final boolean isWEP()
  {
    int i = this.auth;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public final boolean isWPA3()
  {
    boolean bool;
    if (this.auth == 5) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Wifi(ssid=");
    localStringBuilder.append(this.ssid);
    localStringBuilder.append(", bssid=");
    localStringBuilder.append(this.bssid);
    localStringBuilder.append(", auth=");
    localStringBuilder.append(this.auth);
    localStringBuilder.append(", encryption=");
    localStringBuilder.append(this.encryption);
    localStringBuilder.append(", rssi=");
    localStringBuilder.append(this.rssi);
    localStringBuilder.append(", password=");
    localStringBuilder.append(this.password);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.e(paramParcel, "parcel");
    paramParcel.writeString(this.ssid);
    paramParcel.writeString(this.bssid);
    paramParcel.writeInt(this.auth);
    Integer localInteger = this.encryption;
    if (localInteger != null) {
      paramInt = localInteger.intValue();
    } else {
      paramInt = 3;
    }
    paramParcel.writeInt(paramInt);
    paramParcel.writeInt(this.rssi);
    paramParcel.writeString(this.password);
  }
  
  public static final class CREATOR
    implements Parcelable.Creator<Wifi>
  {
    public Wifi createFromParcel(Parcel paramParcel)
    {
      j.e(paramParcel, "parcel");
      return new Wifi(paramParcel);
    }
    
    public Wifi[] newArray(int paramInt)
    {
      return new Wifi[paramInt];
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\Wifi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */