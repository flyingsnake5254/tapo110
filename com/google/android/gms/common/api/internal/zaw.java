package com.google.android.gms.common.api.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zad;

public final class zaw<O extends Api.ApiOptions>
  extends GoogleApi<O>
{
  private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zace;
  private final Api.Client zaer;
  private final zaq zaes;
  private final ClientSettings zaet;
  
  public zaw(@NonNull Context paramContext, Api<O> paramApi, Looper paramLooper, @NonNull Api.Client paramClient, @NonNull zaq paramzaq, ClientSettings paramClientSettings, Api.AbstractClientBuilder<? extends zad, SignInOptions> paramAbstractClientBuilder)
  {
    super(paramContext, paramApi, paramLooper);
    this.zaer = paramClient;
    this.zaes = paramzaq;
    this.zaet = paramClientSettings;
    this.zace = paramAbstractClientBuilder;
    this.zabm.zaa(this);
  }
  
  public final Api.Client zaa(Looper paramLooper, GoogleApiManager.zaa<O> paramzaa)
  {
    this.zaes.zaa(paramzaa);
    return this.zaer;
  }
  
  public final zace zaa(Context paramContext, Handler paramHandler)
  {
    return new zace(paramContext, paramHandler, this.zaet, this.zace);
  }
  
  public final Api.Client zaab()
  {
    return this.zaer;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zaw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */