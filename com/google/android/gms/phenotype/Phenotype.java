package com.google.android.gms.phenotype;

import android.net.Uri;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.internal.phenotype.zzd;
import com.google.android.gms.internal.phenotype.zze;

@KeepForSdk
public final class Phenotype
{
  @Deprecated
  private static final Api<Api.ApiOptions.NoOptions> API;
  private static final Api.AbstractClientBuilder<zze, Api.ApiOptions.NoOptions> CLIENT_BUILDER;
  private static final Api.ClientKey<zze> CLIENT_KEY;
  @Deprecated
  private static final zzm zzaj = new zzd();
  
  static
  {
    Api.ClientKey localClientKey = new Api.ClientKey();
    CLIENT_KEY = localClientKey;
    zzl localzzl = new zzl();
    CLIENT_BUILDER = localzzl;
    API = new Api("Phenotype.API", localzzl, localClientKey);
  }
  
  @KeepForSdk
  public static Uri getContentProviderUri(String paramString)
  {
    paramString = String.valueOf(Uri.encode(paramString));
    if (paramString.length() != 0) {
      paramString = "content://com.google.android.gms.phenotype/".concat(paramString);
    } else {
      paramString = new String("content://com.google.android.gms.phenotype/");
    }
    return Uri.parse(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\phenotype\Phenotype.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */