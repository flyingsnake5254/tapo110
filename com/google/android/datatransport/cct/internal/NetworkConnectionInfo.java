package com.google.android.datatransport.cct.internal;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import com.google.auto.value.AutoValue.Builder;

@AutoValue
public abstract class NetworkConnectionInfo
{
  @NonNull
  public static a a()
  {
    return new i.b();
  }
  
  @Nullable
  public abstract MobileSubtype b();
  
  @Nullable
  public abstract NetworkType c();
  
  public static enum MobileSubtype
  {
    private static final SparseArray<MobileSubtype> valueMap;
    private final int value;
    
    static
    {
      MobileSubtype localMobileSubtype1 = new MobileSubtype("UNKNOWN_MOBILE_SUBTYPE", 0, 0);
      UNKNOWN_MOBILE_SUBTYPE = localMobileSubtype1;
      MobileSubtype localMobileSubtype2 = new MobileSubtype("GPRS", 1, 1);
      GPRS = localMobileSubtype2;
      MobileSubtype localMobileSubtype3 = new MobileSubtype("EDGE", 2, 2);
      EDGE = localMobileSubtype3;
      MobileSubtype localMobileSubtype4 = new MobileSubtype("UMTS", 3, 3);
      UMTS = localMobileSubtype4;
      MobileSubtype localMobileSubtype5 = new MobileSubtype("CDMA", 4, 4);
      CDMA = localMobileSubtype5;
      MobileSubtype localMobileSubtype6 = new MobileSubtype("EVDO_0", 5, 5);
      EVDO_0 = localMobileSubtype6;
      MobileSubtype localMobileSubtype7 = new MobileSubtype("EVDO_A", 6, 6);
      EVDO_A = localMobileSubtype7;
      MobileSubtype localMobileSubtype8 = new MobileSubtype("RTT", 7, 7);
      RTT = localMobileSubtype8;
      MobileSubtype localMobileSubtype9 = new MobileSubtype("HSDPA", 8, 8);
      HSDPA = localMobileSubtype9;
      MobileSubtype localMobileSubtype10 = new MobileSubtype("HSUPA", 9, 9);
      HSUPA = localMobileSubtype10;
      MobileSubtype localMobileSubtype11 = new MobileSubtype("HSPA", 10, 10);
      HSPA = localMobileSubtype11;
      MobileSubtype localMobileSubtype12 = new MobileSubtype("IDEN", 11, 11);
      IDEN = localMobileSubtype12;
      MobileSubtype localMobileSubtype13 = new MobileSubtype("EVDO_B", 12, 12);
      EVDO_B = localMobileSubtype13;
      MobileSubtype localMobileSubtype14 = new MobileSubtype("LTE", 13, 13);
      LTE = localMobileSubtype14;
      MobileSubtype localMobileSubtype15 = new MobileSubtype("EHRPD", 14, 14);
      EHRPD = localMobileSubtype15;
      MobileSubtype localMobileSubtype16 = new MobileSubtype("HSPAP", 15, 15);
      HSPAP = localMobileSubtype16;
      MobileSubtype localMobileSubtype17 = new MobileSubtype("GSM", 16, 16);
      GSM = localMobileSubtype17;
      MobileSubtype localMobileSubtype18 = new MobileSubtype("TD_SCDMA", 17, 17);
      TD_SCDMA = localMobileSubtype18;
      MobileSubtype localMobileSubtype19 = new MobileSubtype("IWLAN", 18, 18);
      IWLAN = localMobileSubtype19;
      MobileSubtype localMobileSubtype20 = new MobileSubtype("LTE_CA", 19, 19);
      LTE_CA = localMobileSubtype20;
      Object localObject = new MobileSubtype("COMBINED", 20, 100);
      COMBINED = (MobileSubtype)localObject;
      $VALUES = new MobileSubtype[] { localMobileSubtype1, localMobileSubtype2, localMobileSubtype3, localMobileSubtype4, localMobileSubtype5, localMobileSubtype6, localMobileSubtype7, localMobileSubtype8, localMobileSubtype9, localMobileSubtype10, localMobileSubtype11, localMobileSubtype12, localMobileSubtype13, localMobileSubtype14, localMobileSubtype15, localMobileSubtype16, localMobileSubtype17, localMobileSubtype18, localMobileSubtype19, localMobileSubtype20, localObject };
      localObject = new SparseArray();
      valueMap = (SparseArray)localObject;
      ((SparseArray)localObject).put(0, localMobileSubtype1);
      ((SparseArray)localObject).put(1, localMobileSubtype2);
      ((SparseArray)localObject).put(2, localMobileSubtype3);
      ((SparseArray)localObject).put(3, localMobileSubtype4);
      ((SparseArray)localObject).put(4, localMobileSubtype5);
      ((SparseArray)localObject).put(5, localMobileSubtype6);
      ((SparseArray)localObject).put(6, localMobileSubtype7);
      ((SparseArray)localObject).put(7, localMobileSubtype8);
      ((SparseArray)localObject).put(8, localMobileSubtype9);
      ((SparseArray)localObject).put(9, localMobileSubtype10);
      ((SparseArray)localObject).put(10, localMobileSubtype11);
      ((SparseArray)localObject).put(11, localMobileSubtype12);
      ((SparseArray)localObject).put(12, localMobileSubtype13);
      ((SparseArray)localObject).put(13, localMobileSubtype14);
      ((SparseArray)localObject).put(14, localMobileSubtype15);
      ((SparseArray)localObject).put(15, localMobileSubtype16);
      ((SparseArray)localObject).put(16, localMobileSubtype17);
      ((SparseArray)localObject).put(17, localMobileSubtype18);
      ((SparseArray)localObject).put(18, localMobileSubtype19);
      ((SparseArray)localObject).put(19, localMobileSubtype20);
    }
    
    private MobileSubtype(int paramInt)
    {
      this.value = paramInt;
    }
    
    @Nullable
    public static MobileSubtype forNumber(int paramInt)
    {
      return (MobileSubtype)valueMap.get(paramInt);
    }
    
    public int getValue()
    {
      return this.value;
    }
  }
  
  public static enum NetworkType
  {
    private static final SparseArray<NetworkType> valueMap;
    private final int value;
    
    static
    {
      NetworkType localNetworkType1 = new NetworkType("MOBILE", 0, 0);
      MOBILE = localNetworkType1;
      NetworkType localNetworkType2 = new NetworkType("WIFI", 1, 1);
      WIFI = localNetworkType2;
      NetworkType localNetworkType3 = new NetworkType("MOBILE_MMS", 2, 2);
      MOBILE_MMS = localNetworkType3;
      NetworkType localNetworkType4 = new NetworkType("MOBILE_SUPL", 3, 3);
      MOBILE_SUPL = localNetworkType4;
      NetworkType localNetworkType5 = new NetworkType("MOBILE_DUN", 4, 4);
      MOBILE_DUN = localNetworkType5;
      NetworkType localNetworkType6 = new NetworkType("MOBILE_HIPRI", 5, 5);
      MOBILE_HIPRI = localNetworkType6;
      NetworkType localNetworkType7 = new NetworkType("WIMAX", 6, 6);
      WIMAX = localNetworkType7;
      NetworkType localNetworkType8 = new NetworkType("BLUETOOTH", 7, 7);
      BLUETOOTH = localNetworkType8;
      NetworkType localNetworkType9 = new NetworkType("DUMMY", 8, 8);
      DUMMY = localNetworkType9;
      NetworkType localNetworkType10 = new NetworkType("ETHERNET", 9, 9);
      ETHERNET = localNetworkType10;
      NetworkType localNetworkType11 = new NetworkType("MOBILE_FOTA", 10, 10);
      MOBILE_FOTA = localNetworkType11;
      NetworkType localNetworkType12 = new NetworkType("MOBILE_IMS", 11, 11);
      MOBILE_IMS = localNetworkType12;
      NetworkType localNetworkType13 = new NetworkType("MOBILE_CBS", 12, 12);
      MOBILE_CBS = localNetworkType13;
      NetworkType localNetworkType14 = new NetworkType("WIFI_P2P", 13, 13);
      WIFI_P2P = localNetworkType14;
      NetworkType localNetworkType15 = new NetworkType("MOBILE_IA", 14, 14);
      MOBILE_IA = localNetworkType15;
      NetworkType localNetworkType16 = new NetworkType("MOBILE_EMERGENCY", 15, 15);
      MOBILE_EMERGENCY = localNetworkType16;
      NetworkType localNetworkType17 = new NetworkType("PROXY", 16, 16);
      PROXY = localNetworkType17;
      NetworkType localNetworkType18 = new NetworkType("VPN", 17, 17);
      VPN = localNetworkType18;
      NetworkType localNetworkType19 = new NetworkType("NONE", 18, -1);
      NONE = localNetworkType19;
      $VALUES = new NetworkType[] { localNetworkType1, localNetworkType2, localNetworkType3, localNetworkType4, localNetworkType5, localNetworkType6, localNetworkType7, localNetworkType8, localNetworkType9, localNetworkType10, localNetworkType11, localNetworkType12, localNetworkType13, localNetworkType14, localNetworkType15, localNetworkType16, localNetworkType17, localNetworkType18, localNetworkType19 };
      SparseArray localSparseArray = new SparseArray();
      valueMap = localSparseArray;
      localSparseArray.put(0, localNetworkType1);
      localSparseArray.put(1, localNetworkType2);
      localSparseArray.put(2, localNetworkType3);
      localSparseArray.put(3, localNetworkType4);
      localSparseArray.put(4, localNetworkType5);
      localSparseArray.put(5, localNetworkType6);
      localSparseArray.put(6, localNetworkType7);
      localSparseArray.put(7, localNetworkType8);
      localSparseArray.put(8, localNetworkType9);
      localSparseArray.put(9, localNetworkType10);
      localSparseArray.put(10, localNetworkType11);
      localSparseArray.put(11, localNetworkType12);
      localSparseArray.put(12, localNetworkType13);
      localSparseArray.put(13, localNetworkType14);
      localSparseArray.put(14, localNetworkType15);
      localSparseArray.put(15, localNetworkType16);
      localSparseArray.put(16, localNetworkType17);
      localSparseArray.put(17, localNetworkType18);
      localSparseArray.put(-1, localNetworkType19);
    }
    
    private NetworkType(int paramInt)
    {
      this.value = paramInt;
    }
    
    @Nullable
    public static NetworkType forNumber(int paramInt)
    {
      return (NetworkType)valueMap.get(paramInt);
    }
    
    public int getValue()
    {
      return this.value;
    }
  }
  
  @AutoValue.Builder
  public static abstract class a
  {
    @NonNull
    public abstract NetworkConnectionInfo a();
    
    @NonNull
    public abstract a b(@Nullable NetworkConnectionInfo.MobileSubtype paramMobileSubtype);
    
    @NonNull
    public abstract a c(@Nullable NetworkConnectionInfo.NetworkType paramNetworkType);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\cct\internal\NetworkConnectionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */