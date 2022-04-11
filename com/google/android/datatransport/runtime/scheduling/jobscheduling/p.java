package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.PersistableBundle;
import android.util.Base64;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.h.n;
import com.google.android.datatransport.h.x.j.y;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.zip.Adler32;

@RequiresApi(api=21)
public class p
  implements u
{
  private final Context a;
  private final y b;
  private final SchedulerConfig c;
  
  public p(Context paramContext, y paramy, SchedulerConfig paramSchedulerConfig)
  {
    this.a = paramContext;
    this.b = paramy;
    this.c = paramSchedulerConfig;
  }
  
  private boolean d(JobScheduler paramJobScheduler, int paramInt1, int paramInt2)
  {
    Iterator localIterator = paramJobScheduler.getAllPendingJobs().iterator();
    boolean bool2;
    int i;
    do
    {
      boolean bool1 = localIterator.hasNext();
      bool2 = false;
      bool3 = bool2;
      if (!bool1) {
        break;
      }
      paramJobScheduler = (JobInfo)localIterator.next();
      i = paramJobScheduler.getExtras().getInt("attemptNumber");
    } while (paramJobScheduler.getId() != paramInt1);
    boolean bool3 = bool2;
    if (i >= paramInt2) {
      bool3 = true;
    }
    return bool3;
  }
  
  public void a(n paramn, int paramInt)
  {
    b(paramn, paramInt, false);
  }
  
  public void b(n paramn, int paramInt, boolean paramBoolean)
  {
    Object localObject = new ComponentName(this.a, JobInfoSchedulerService.class);
    JobScheduler localJobScheduler = (JobScheduler)this.a.getSystemService("jobscheduler");
    int i = c(paramn);
    if ((!paramBoolean) && (d(localJobScheduler, i, paramInt)))
    {
      com.google.android.datatransport.h.v.a.a("JobInfoScheduler", "Upload for context %s is already scheduled. Returning...", paramn);
      return;
    }
    long l = this.b.m(paramn);
    JobInfo.Builder localBuilder = this.c.c(new JobInfo.Builder(i, (ComponentName)localObject), paramn.d(), l, paramInt);
    localObject = new PersistableBundle();
    ((PersistableBundle)localObject).putInt("attemptNumber", paramInt);
    ((PersistableBundle)localObject).putString("backendName", paramn.b());
    ((PersistableBundle)localObject).putInt("priority", com.google.android.datatransport.h.z.a.a(paramn.d()));
    if (paramn.c() != null) {
      ((PersistableBundle)localObject).putString("extras", Base64.encodeToString(paramn.c(), 0));
    }
    localBuilder.setExtras((PersistableBundle)localObject);
    com.google.android.datatransport.h.v.a.b("JobInfoScheduler", "Scheduling upload for context %s with jobId=%d in %dms(Backend next call timestamp %d). Attempt %d", new Object[] { paramn, Integer.valueOf(i), Long.valueOf(this.c.g(paramn.d(), l, paramInt)), Long.valueOf(l), Integer.valueOf(paramInt) });
    localJobScheduler.schedule(localBuilder.build());
  }
  
  @VisibleForTesting
  int c(n paramn)
  {
    Adler32 localAdler32 = new Adler32();
    localAdler32.update(this.a.getPackageName().getBytes(Charset.forName("UTF-8")));
    localAdler32.update(paramn.b().getBytes(Charset.forName("UTF-8")));
    localAdler32.update(ByteBuffer.allocate(4).putInt(com.google.android.datatransport.h.z.a.a(paramn.d())).array());
    if (paramn.c() != null) {
      localAdler32.update(paramn.c());
    }
    return (int)localAdler32.getValue();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\runtime\scheduling\jobscheduling\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */