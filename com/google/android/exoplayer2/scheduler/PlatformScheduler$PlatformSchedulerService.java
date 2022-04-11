package com.google.android.exoplayer2.scheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.os.PersistableBundle;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;

public final class PlatformScheduler$PlatformSchedulerService
  extends JobService
{
  public boolean onStartJob(JobParameters paramJobParameters)
  {
    Object localObject = paramJobParameters.getExtras();
    int i = new Requirements(((PersistableBundle)localObject).getInt("requirements")).b(this);
    if (i == 0)
    {
      paramJobParameters = (String)g.e(((PersistableBundle)localObject).getString("service_action"));
      localObject = (String)g.e(((PersistableBundle)localObject).getString("service_package"));
      o0.H0(this, new Intent(paramJobParameters).setPackage((String)localObject));
    }
    else
    {
      localObject = new StringBuilder(33);
      ((StringBuilder)localObject).append("Requirements not met: ");
      ((StringBuilder)localObject).append(i);
      u.h("PlatformScheduler", ((StringBuilder)localObject).toString());
      jobFinished(paramJobParameters, true);
    }
    return false;
  }
  
  public boolean onStopJob(JobParameters paramJobParameters)
  {
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\scheduler\PlatformScheduler$PlatformSchedulerService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */