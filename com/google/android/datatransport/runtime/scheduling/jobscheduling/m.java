package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri.Builder;
import android.util.Base64;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.h.n;
import com.google.android.datatransport.h.x.j.y;

public class m
  implements u
{
  private final Context a;
  private final y b;
  private AlarmManager c;
  private final SchedulerConfig d;
  private final com.google.android.datatransport.h.y.a e;
  
  @VisibleForTesting
  m(Context paramContext, y paramy, AlarmManager paramAlarmManager, com.google.android.datatransport.h.y.a parama, SchedulerConfig paramSchedulerConfig)
  {
    this.a = paramContext;
    this.b = paramy;
    this.c = paramAlarmManager;
    this.e = parama;
    this.d = paramSchedulerConfig;
  }
  
  public m(Context paramContext, y paramy, com.google.android.datatransport.h.y.a parama, SchedulerConfig paramSchedulerConfig)
  {
    this(paramContext, paramy, (AlarmManager)paramContext.getSystemService("alarm"), parama, paramSchedulerConfig);
  }
  
  public void a(n paramn, int paramInt)
  {
    b(paramn, paramInt, false);
  }
  
  public void b(n paramn, int paramInt, boolean paramBoolean)
  {
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.appendQueryParameter("backendName", paramn.b());
    localBuilder.appendQueryParameter("priority", String.valueOf(com.google.android.datatransport.h.z.a.a(paramn.d())));
    if (paramn.c() != null) {
      localBuilder.appendQueryParameter("extras", Base64.encodeToString(paramn.c(), 0));
    }
    Intent localIntent = new Intent(this.a, AlarmManagerSchedulerBroadcastReceiver.class);
    localIntent.setData(localBuilder.build());
    localIntent.putExtra("attemptNumber", paramInt);
    if ((!paramBoolean) && (c(localIntent)))
    {
      com.google.android.datatransport.h.v.a.a("AlarmManagerScheduler", "Upload for context %s is already scheduled. Returning...", paramn);
      return;
    }
    long l1 = this.b.m(paramn);
    long l2 = this.d.g(paramn.d(), l1, paramInt);
    com.google.android.datatransport.h.v.a.b("AlarmManagerScheduler", "Scheduling upload for context %s in %dms(Backend next call timestamp %d). Attempt %d", new Object[] { paramn, Long.valueOf(l2), Long.valueOf(l1), Integer.valueOf(paramInt) });
    paramn = PendingIntent.getBroadcast(this.a, 0, localIntent, 0);
    this.c.set(3, this.e.a() + l2, paramn);
  }
  
  @VisibleForTesting
  boolean c(Intent paramIntent)
  {
    Context localContext = this.a;
    boolean bool = false;
    if (PendingIntent.getBroadcast(localContext, 0, paramIntent, 536870912) != null) {
      bool = true;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\runtime\scheduling\jobscheduling\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */