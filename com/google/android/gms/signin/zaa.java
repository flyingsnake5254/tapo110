package com.google.android.gms.signin;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ClientKey;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.signin.internal.SignInClientImpl;

public final class zaa
{
  public static final Api<SignInOptions> API;
  private static final Api.ClientKey<SignInClientImpl> CLIENT_KEY;
  public static final Api.AbstractClientBuilder<SignInClientImpl, SignInOptions> zaph;
  private static final Scope zar;
  @ShowFirstParty
  private static final Api.ClientKey<SignInClientImpl> zars;
  private static final Api.AbstractClientBuilder<SignInClientImpl, Object> zart;
  private static final Api<Object> zaru;
  private static final Scope zas;
  
  static
  {
    Api.ClientKey localClientKey1 = new Api.ClientKey();
    CLIENT_KEY = localClientKey1;
    Api.ClientKey localClientKey2 = new Api.ClientKey();
    zars = localClientKey2;
    zab localzab = new zab();
    zaph = localzab;
    zac localzac = new zac();
    zart = localzac;
    zar = new Scope("profile");
    zas = new Scope("email");
    API = new Api("SignIn.API", localzab, localClientKey1);
    zaru = new Api("SignIn.INTERNAL_API", localzac, localClientKey2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\signin\zaa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */