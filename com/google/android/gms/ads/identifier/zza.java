package com.google.android.gms.ads.identifier;

import android.net.Uri;
import android.net.Uri.Builder;
import android.util.Log;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class zza
  extends Thread
{
  zza(AdvertisingIdClient paramAdvertisingIdClient, Map paramMap) {}
  
  public final void run()
  {
    new zzc();
    Object localObject1 = this.zzl;
    localObject2 = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
    Object localObject3 = ((Map)localObject1).keySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      str2 = (String)((Iterator)localObject3).next();
      ((Uri.Builder)localObject2).appendQueryParameter(str2, (String)((Map)localObject1).get(str2));
    }
    str3 = ((Uri.Builder)localObject2).build().toString();
    try
    {
      try
      {
        localObject1 = new java/net/URL;
        ((URL)localObject1).<init>(str3);
        localObject1 = (HttpURLConnection)((URL)localObject1).openConnection();
        try
        {
          int i = ((HttpURLConnection)localObject1).getResponseCode();
          if ((i < 200) || (i >= 300))
          {
            int j = String.valueOf(str3).length();
            localObject3 = new java/lang/StringBuilder;
            ((StringBuilder)localObject3).<init>(j + 65);
            ((StringBuilder)localObject3).append("Received non-success response code ");
            ((StringBuilder)localObject3).append(i);
            ((StringBuilder)localObject3).append(" from pinging URL: ");
            ((StringBuilder)localObject3).append(str3);
            Log.w("HttpUrlPinger", ((StringBuilder)localObject3).toString());
          }
          return;
        }
        finally
        {
          ((HttpURLConnection)localObject1).disconnect();
        }
        str2 = localIOException.getMessage();
      }
      catch (RuntimeException localRuntimeException) {}catch (IOException localIOException) {}
      localObject2 = new StringBuilder(String.valueOf(str3).length() + 27 + String.valueOf(str2).length());
      str1 = "Error while pinging URL: ";
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      for (;;)
      {
        str2 = localIndexOutOfBoundsException.getMessage();
        localObject2 = new StringBuilder(String.valueOf(str3).length() + 32 + String.valueOf(str2).length());
        String str1 = "Error while parsing ping URL: ";
      }
    }
    ((StringBuilder)localObject2).append(str1);
    ((StringBuilder)localObject2).append(str3);
    ((StringBuilder)localObject2).append(". ");
    ((StringBuilder)localObject2).append(str2);
    Log.w("HttpUrlPinger", ((StringBuilder)localObject2).toString(), localIOException);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\ads\identifier\zza.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */