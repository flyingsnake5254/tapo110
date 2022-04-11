package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class zzes
  extends zzke
{
  private final SSLSocketFactory zza;
  
  public zzes(zzkn paramzzkn)
  {
    super(paramzzkn);
    if (Build.VERSION.SDK_INT < 19) {
      paramzzkn = new zzkw(HttpsURLConnection.getDefaultSSLSocketFactory());
    } else {
      paramzzkn = null;
    }
    this.zza = paramzzkn;
  }
  
  protected final boolean zzaA()
  {
    return false;
  }
  
  public final boolean zzb()
  {
    zzZ();
    ConnectivityManager localConnectivityManager = (ConnectivityManager)this.zzs.zzax().getSystemService("connectivity");
    Object localObject1 = null;
    Object localObject2 = localObject1;
    Object localObject3;
    if (localConnectivityManager != null) {
      try
      {
        localObject2 = localConnectivityManager.getActiveNetworkInfo();
      }
      catch (SecurityException localSecurityException)
      {
        localObject3 = localObject1;
      }
    }
    return (localObject3 != null) && (((NetworkInfo)localObject3).isConnected());
  }
  
  @WorkerThread
  @VisibleForTesting
  protected final HttpURLConnection zzc(URL paramURL)
    throws IOException
  {
    URLConnection localURLConnection = paramURL.openConnection();
    if ((localURLConnection instanceof HttpURLConnection))
    {
      paramURL = this.zza;
      if ((paramURL != null) && ((localURLConnection instanceof HttpsURLConnection))) {
        ((HttpsURLConnection)localURLConnection).setSSLSocketFactory(paramURL);
      }
      paramURL = (HttpURLConnection)localURLConnection;
      paramURL.setDefaultUseCaches(false);
      this.zzs.zzc();
      paramURL.setConnectTimeout(60000);
      this.zzs.zzc();
      paramURL.setReadTimeout(61000);
      paramURL.setInstanceFollowRedirects(false);
      paramURL.setDoInput(true);
      return paramURL;
    }
    throw new IOException("Failed to obtain HTTP connection");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */