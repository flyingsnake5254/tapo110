package com.google.android.gms.auth.api.signin.internal;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.VisibleForTesting;

public class HashAccumulator
{
  @VisibleForTesting
  private static int zaah = 31;
  private int zaai = 1;
  
  @KeepForSdk
  public HashAccumulator addObject(Object paramObject)
  {
    int i = zaah;
    int j = this.zaai;
    int k;
    if (paramObject == null) {
      k = 0;
    } else {
      k = paramObject.hashCode();
    }
    this.zaai = (i * j + k);
    return this;
  }
  
  @KeepForSdk
  public int hash()
  {
    return this.zaai;
  }
  
  public final HashAccumulator zaa(boolean paramBoolean)
  {
    this.zaai = (zaah * this.zaai + paramBoolean);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\auth\api\signin\internal\HashAccumulator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */