package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.PersistableBundle;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import com.google.android.datatransport.h.n;
import com.google.android.datatransport.h.n.a;
import com.google.android.datatransport.h.r;
import com.google.android.datatransport.h.z.a;

@RequiresApi(api=21)
public class JobInfoSchedulerService
  extends JobService
{
  public boolean onStartJob(JobParameters paramJobParameters)
  {
    Object localObject = paramJobParameters.getExtras().getString("backendName");
    String str = paramJobParameters.getExtras().getString("extras");
    int i = paramJobParameters.getExtras().getInt("priority");
    int j = paramJobParameters.getExtras().getInt("attemptNumber");
    r.f(getApplicationContext());
    localObject = n.a().b((String)localObject).d(a.b(i));
    if (str != null) {
      ((n.a)localObject).c(Base64.decode(str, 0));
    }
    r.c().e().q(((n.a)localObject).a(), j, new c(this, paramJobParameters));
    return true;
  }
  
  public boolean onStopJob(JobParameters paramJobParameters)
  {
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\runtime\scheduling\jobscheduling\JobInfoSchedulerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */