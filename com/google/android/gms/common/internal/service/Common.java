package com.google.android.gms.common.internal.service;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;

public final class Common
{
  @KeepForSdk
  public static final Api<Api.ApiOptions.NoOptions> API;
  @KeepForSdk
  public static final Api.ClientKey<zai> CLIENT_KEY;
  private static final Api.AbstractClientBuilder<zai, Api.ApiOptions.NoOptions> zaph;
  public static final zac zapi = new zad();
  
  static
  {
    Api.ClientKey localClientKey = new Api.ClientKey();
    CLIENT_KEY = localClientKey;
    zab localzab = new zab();
    zaph = localzab;
    API = new Api("Common.API", localzab, localClientKey);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\internal\service\Common.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */