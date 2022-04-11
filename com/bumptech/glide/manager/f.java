package com.bumptech.glide.manager;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

public class f
  implements d
{
  @NonNull
  public c a(@NonNull Context paramContext, @NonNull c.a parama)
  {
    int i;
    if (ContextCompat.checkSelfPermission(paramContext, "android.permission.ACCESS_NETWORK_STATE") == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (Log.isLoggable("ConnectivityMonitor", 3))
    {
      String str;
      if (i != 0) {
        str = "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor";
      } else {
        str = "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor";
      }
      Log.d("ConnectivityMonitor", str);
    }
    if (i != 0) {
      paramContext = new e(paramContext, parama);
    } else {
      paramContext = new n();
    }
    return paramContext;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\manager\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */