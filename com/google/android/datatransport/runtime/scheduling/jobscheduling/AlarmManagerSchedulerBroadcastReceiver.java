package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import com.google.android.datatransport.h.n;
import com.google.android.datatransport.h.n.a;
import com.google.android.datatransport.h.r;

public class AlarmManagerSchedulerBroadcastReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str1 = paramIntent.getData().getQueryParameter("backendName");
    String str2 = paramIntent.getData().getQueryParameter("extras");
    int i = Integer.valueOf(paramIntent.getData().getQueryParameter("priority")).intValue();
    int j = paramIntent.getExtras().getInt("attemptNumber");
    r.f(paramContext);
    paramContext = n.a().b(str1).d(com.google.android.datatransport.h.z.a.b(i));
    if (str2 != null) {
      paramContext.c(Base64.decode(str2, 0));
    }
    r.c().e().q(paramContext.a(), j, a.c);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\runtime\scheduling\jobscheduling\AlarmManagerSchedulerBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */