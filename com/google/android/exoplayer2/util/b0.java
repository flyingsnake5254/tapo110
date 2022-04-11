package com.google.android.exoplayer2.util;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import androidx.annotation.StringRes;

@SuppressLint({"InlinedApi"})
public final class b0
{
  public static void a(Context paramContext, String paramString, @StringRes int paramInt1, @StringRes int paramInt2, int paramInt3)
  {
    if (o0.a >= 26)
    {
      NotificationManager localNotificationManager = (NotificationManager)g.e((NotificationManager)paramContext.getSystemService("notification"));
      paramString = new NotificationChannel(paramString, paramContext.getString(paramInt1), paramInt3);
      if (paramInt2 != 0) {
        paramString.setDescription(paramContext.getString(paramInt2));
      }
      localNotificationManager.createNotificationChannel(paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\util\b0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */