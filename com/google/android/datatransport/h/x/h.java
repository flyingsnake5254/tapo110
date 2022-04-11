package com.google.android.datatransport.h.x;

import android.content.Context;
import android.os.Build.VERSION;
import com.google.android.datatransport.h.x.j.y;
import com.google.android.datatransport.h.y.a;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.m;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.p;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.u;

public abstract class h
{
  static u a(Context paramContext, y paramy, SchedulerConfig paramSchedulerConfig, a parama)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return new p(paramContext, paramy, paramSchedulerConfig);
    }
    return new m(paramContext, paramy, parama, paramSchedulerConfig);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\h\x\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */