package com.google.android.gms.internal.measurement;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.UserHandle;
import android.util.Log;
import androidx.annotation.Nullable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Objects;

@TargetApi(24)
public final class zzbt
{
  @Nullable
  private static final Method zza;
  @Nullable
  private static final Method zzb;
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    Object localObject1 = null;
    if (i >= 24) {
      try
      {
        Method localMethod = JobScheduler.class.getDeclaredMethod("scheduleAsPackage", new Class[] { JobInfo.class, String.class, Integer.TYPE, String.class });
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        if (Log.isLoggable("JobSchedulerCompat", 6)) {
          Log.e("JobSchedulerCompat", "No scheduleAsPackage method available, falling back to schedule");
        }
      }
    } else {
      localObject2 = null;
    }
    zza = (Method)localObject2;
    Object localObject2 = localObject1;
    Object localObject3;
    if (Build.VERSION.SDK_INT >= 24) {
      try
      {
        localObject2 = UserHandle.class.getDeclaredMethod("myUserId", new Class[0]);
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        localObject3 = localObject1;
        if (Log.isLoggable("JobSchedulerCompat", 6))
        {
          Log.e("JobSchedulerCompat", "No myUserId method available");
          localObject3 = localObject1;
        }
      }
    }
    zzb = (Method)localObject3;
  }
  
  public static int zza(Context paramContext, JobInfo paramJobInfo, String paramString1, String paramString2)
  {
    paramString1 = (JobScheduler)paramContext.getSystemService("jobscheduler");
    Objects.requireNonNull(paramString1);
    if ((zza != null) && (paramContext.checkSelfPermission("android.permission.UPDATE_DEVICE_STATS") == 0))
    {
      paramContext = zzb;
      int i = 0;
      if (paramContext != null)
      {
        try
        {
          paramContext = (Integer)paramContext.invoke(UserHandle.class, new Object[0]);
          if (paramContext == null) {
            break label95;
          }
          j = paramContext.intValue();
        }
        catch (InvocationTargetException paramContext) {}catch (IllegalAccessException paramContext) {}
        if (Log.isLoggable("JobSchedulerCompat", 6)) {
          Log.e("JobSchedulerCompat", "myUserId invocation illegal", paramContext);
        }
      }
      label95:
      int j = 0;
      paramContext = zza;
      if (paramContext != null)
      {
        try
        {
          paramContext = (Integer)paramContext.invoke(paramString1, new Object[] { paramJobInfo, "com.google.android.gms", Integer.valueOf(j), "UploadAlarm" });
          j = i;
          if (paramContext == null) {
            break label179;
          }
          j = paramContext.intValue();
        }
        catch (InvocationTargetException paramContext) {}catch (IllegalAccessException paramContext) {}
        Log.e("UploadAlarm", "error calling scheduleAsPackage", paramContext);
      }
      else
      {
        j = paramString1.schedule(paramJobInfo);
      }
      label179:
      return j;
    }
    return paramString1.schedule(paramJobInfo);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzbt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */