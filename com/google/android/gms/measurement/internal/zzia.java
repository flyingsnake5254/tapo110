package com.google.android.gms.measurement.internal;

import android.os.Build.VERSION;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public final class zzia
  extends zzgo
{
  private final SSLSocketFactory zza;
  
  zzia(zzfu paramzzfu)
  {
    super(paramzzfu);
    if (Build.VERSION.SDK_INT < 19) {
      paramzzfu = new zzkw(HttpsURLConnection.getDefaultSSLSocketFactory());
    } else {
      paramzzfu = null;
    }
    this.zza = paramzzfu;
  }
  
  protected final boolean zza()
  {
    return false;
  }
  
  @WorkerThread
  @VisibleForTesting
  protected final HttpURLConnection zzd(URL paramURL)
    throws IOException
  {
    paramURL = paramURL.openConnection();
    if ((paramURL instanceof HttpURLConnection))
    {
      SSLSocketFactory localSSLSocketFactory = this.zza;
      if ((localSSLSocketFactory != null) && ((paramURL instanceof HttpsURLConnection))) {
        ((HttpsURLConnection)paramURL).setSSLSocketFactory(localSSLSocketFactory);
      }
      paramURL = (HttpURLConnection)paramURL;
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzia.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */