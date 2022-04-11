package com.google.android.datatransport.cct.internal;

import android.util.SparseArray;
import androidx.annotation.Nullable;

public enum QosTier
{
  private static final SparseArray<QosTier> valueMap;
  private final int value;
  
  static
  {
    QosTier localQosTier1 = new QosTier("DEFAULT", 0, 0);
    DEFAULT = localQosTier1;
    QosTier localQosTier2 = new QosTier("UNMETERED_ONLY", 1, 1);
    UNMETERED_ONLY = localQosTier2;
    QosTier localQosTier3 = new QosTier("UNMETERED_OR_DAILY", 2, 2);
    UNMETERED_OR_DAILY = localQosTier3;
    QosTier localQosTier4 = new QosTier("FAST_IF_RADIO_AWAKE", 3, 3);
    FAST_IF_RADIO_AWAKE = localQosTier4;
    QosTier localQosTier5 = new QosTier("NEVER", 4, 4);
    NEVER = localQosTier5;
    QosTier localQosTier6 = new QosTier("UNRECOGNIZED", 5, -1);
    UNRECOGNIZED = localQosTier6;
    $VALUES = new QosTier[] { localQosTier1, localQosTier2, localQosTier3, localQosTier4, localQosTier5, localQosTier6 };
    SparseArray localSparseArray = new SparseArray();
    valueMap = localSparseArray;
    localSparseArray.put(0, localQosTier1);
    localSparseArray.put(1, localQosTier2);
    localSparseArray.put(2, localQosTier3);
    localSparseArray.put(3, localQosTier4);
    localSparseArray.put(4, localQosTier5);
    localSparseArray.put(-1, localQosTier6);
  }
  
  private QosTier(int paramInt)
  {
    this.value = paramInt;
  }
  
  @Nullable
  public static QosTier forNumber(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return null;
            }
            return NEVER;
          }
          return FAST_IF_RADIO_AWAKE;
        }
        return UNMETERED_OR_DAILY;
      }
      return UNMETERED_ONLY;
    }
    return DEFAULT;
  }
  
  public final int getNumber()
  {
    return this.value;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\cct\internal\QosTier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */