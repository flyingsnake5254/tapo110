package com.google.android.gms.cloudmessaging;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.concurrent.GuardedBy;

public class Rpc
{
  private static int zza;
  private static PendingIntent zzb;
  private static final Executor zzc = zzz.zza;
  @GuardedBy("responseCallbacks")
  private final SimpleArrayMap<String, TaskCompletionSource<Bundle>> zzd = new SimpleArrayMap();
  private final Context zze;
  private final zzr zzf;
  private final ScheduledExecutorService zzg;
  private Messenger zzh;
  private Messenger zzi;
  private zza zzj;
  
  public Rpc(@NonNull Context paramContext)
  {
    this.zze = paramContext;
    this.zzf = new zzr(paramContext);
    this.zzh = new Messenger(new zzy(this, Looper.getMainLooper()));
    paramContext = new ScheduledThreadPoolExecutor(1);
    paramContext.setKeepAliveTime(60L, TimeUnit.SECONDS);
    paramContext.allowCoreThreadTimeOut(true);
    this.zzg = paramContext;
  }
  
  private static String zza()
  {
    try
    {
      int i = zza;
      zza = i + 1;
      String str = Integer.toString(i);
      return str;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  private static void zza(Context paramContext, Intent paramIntent)
  {
    try
    {
      if (zzb == null)
      {
        Intent localIntent = new android/content/Intent;
        localIntent.<init>();
        localIntent.setPackage("com.google.example.invalidpackage");
        zzb = PendingIntent.getBroadcast(paramContext, 0, localIntent, 0);
      }
      paramIntent.putExtra("app", zzb);
      return;
    }
    finally {}
  }
  
  private final void zza(Message paramMessage)
  {
    if (paramMessage != null)
    {
      Object localObject1 = paramMessage.obj;
      if ((localObject1 instanceof Intent))
      {
        localObject1 = (Intent)localObject1;
        ((Intent)localObject1).setExtrasClassLoader(new zza.zza());
        if (((Intent)localObject1).hasExtra("google.messenger"))
        {
          localObject1 = ((Intent)localObject1).getParcelableExtra("google.messenger");
          if ((localObject1 instanceof zza)) {
            this.zzj = ((zza)localObject1);
          }
          if ((localObject1 instanceof Messenger)) {
            this.zzi = ((Messenger)localObject1);
          }
        }
        Object localObject4 = (Intent)paramMessage.obj;
        paramMessage = ((Intent)localObject4).getAction();
        if (!"com.google.android.c2dm.intent.REGISTRATION".equals(paramMessage))
        {
          if (Log.isLoggable("Rpc", 3))
          {
            paramMessage = String.valueOf(paramMessage);
            if (paramMessage.length() != 0) {
              paramMessage = "Unexpected response action: ".concat(paramMessage);
            } else {
              paramMessage = new String("Unexpected response action: ");
            }
            Log.d("Rpc", paramMessage);
          }
          return;
        }
        localObject1 = ((Intent)localObject4).getStringExtra("registration_id");
        paramMessage = (Message)localObject1;
        if (localObject1 == null) {
          paramMessage = ((Intent)localObject4).getStringExtra("unregistered");
        }
        if (paramMessage == null)
        {
          localObject1 = ((Intent)localObject4).getStringExtra("error");
          if (localObject1 == null)
          {
            localObject1 = String.valueOf(((Intent)localObject4).getExtras());
            paramMessage = new StringBuilder(((String)localObject1).length() + 49);
            paramMessage.append("Unexpected response, no error or registration id ");
            paramMessage.append((String)localObject1);
            Log.w("Rpc", paramMessage.toString());
            return;
          }
          if (Log.isLoggable("Rpc", 3))
          {
            if (((String)localObject1).length() != 0) {
              paramMessage = "Received InstanceID error ".concat((String)localObject1);
            } else {
              paramMessage = new String("Received InstanceID error ");
            }
            Log.d("Rpc", paramMessage);
          }
          if (((String)localObject1).startsWith("|"))
          {
            paramMessage = ((String)localObject1).split("\\|");
            if ((paramMessage.length > 2) && ("ID".equals(paramMessage[1])))
            {
              String str = paramMessage[2];
              localObject1 = paramMessage[3];
              paramMessage = (Message)localObject1;
              if (((String)localObject1).startsWith(":")) {
                paramMessage = ((String)localObject1).substring(1);
              }
              zza(str, ((Intent)localObject4).putExtra("error", paramMessage).getExtras());
              return;
            }
            if (((String)localObject1).length() != 0) {
              paramMessage = "Unexpected structured response ".concat((String)localObject1);
            } else {
              paramMessage = new String("Unexpected structured response ");
            }
            Log.w("Rpc", paramMessage);
            return;
          }
          paramMessage = this.zzd;
          int i = 0;
          try
          {
            while (i < this.zzd.size())
            {
              zza((String)this.zzd.keyAt(i), ((Intent)localObject4).getExtras());
              i++;
            }
            return;
          }
          finally {}
        }
        Object localObject3 = Pattern.compile("\\|ID\\|([^|]+)\\|:?+(.*)").matcher(paramMessage);
        if (!((Matcher)localObject3).matches())
        {
          if (Log.isLoggable("Rpc", 3))
          {
            if (paramMessage.length() != 0) {
              paramMessage = "Unexpected response string: ".concat(paramMessage);
            } else {
              paramMessage = new String("Unexpected response string: ");
            }
            Log.d("Rpc", paramMessage);
          }
          return;
        }
        paramMessage = ((Matcher)localObject3).group(1);
        localObject3 = ((Matcher)localObject3).group(2);
        if (paramMessage != null)
        {
          localObject4 = ((Intent)localObject4).getExtras();
          ((Bundle)localObject4).putString("registration_id", (String)localObject3);
          zza(paramMessage, (Bundle)localObject4);
        }
        return;
      }
    }
    Log.w("Rpc", "Dropping invalid message");
  }
  
  private final void zza(String paramString, @Nullable Bundle paramBundle)
  {
    synchronized (this.zzd)
    {
      TaskCompletionSource localTaskCompletionSource = (TaskCompletionSource)this.zzd.remove(paramString);
      if (localTaskCompletionSource == null)
      {
        paramString = String.valueOf(paramString);
        if (paramString.length() != 0) {
          paramString = "Missing callback for ".concat(paramString);
        } else {
          paramString = new String("Missing callback for ");
        }
        Log.w("Rpc", paramString);
        return;
      }
      localTaskCompletionSource.setResult(paramBundle);
      return;
    }
  }
  
  private static boolean zzb(Bundle paramBundle)
  {
    return (paramBundle != null) && (paramBundle.containsKey("google.messenger"));
  }
  
  @AnyThread
  private final Task<Bundle> zzc(Bundle paramBundle)
  {
    String str = zza();
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    synchronized (this.zzd)
    {
      this.zzd.put(str, localTaskCompletionSource);
      ??? = new Intent();
      ((Intent)???).setPackage("com.google.android.gms");
      if (this.zzf.zza() == 2) {
        ((Intent)???).setAction("com.google.iid.TOKEN_REQUEST");
      } else {
        ((Intent)???).setAction("com.google.android.c2dm.intent.REGISTER");
      }
      ((Intent)???).putExtras(paramBundle);
      zza(this.zze, (Intent)???);
      paramBundle = new StringBuilder(String.valueOf(str).length() + 5);
      paramBundle.append("|ID|");
      paramBundle.append(str);
      paramBundle.append("|");
      ((Intent)???).putExtra("kid", paramBundle.toString());
      Object localObject2;
      if (Log.isLoggable("Rpc", 3))
      {
        localObject2 = String.valueOf(((Intent)???).getExtras());
        paramBundle = new StringBuilder(((String)localObject2).length() + 8);
        paramBundle.append("Sending ");
        paramBundle.append((String)localObject2);
        Log.d("Rpc", paramBundle.toString());
      }
      ((Intent)???).putExtra("google.messenger", this.zzh);
      if ((this.zzi != null) || (this.zzj != null))
      {
        localObject2 = Message.obtain();
        ((Message)localObject2).obj = ???;
        try
        {
          paramBundle = this.zzi;
          if (paramBundle != null) {
            paramBundle.send((Message)localObject2);
          } else {
            this.zzj.zza((Message)localObject2);
          }
        }
        catch (RemoteException paramBundle)
        {
          if (Log.isLoggable("Rpc", 3)) {
            Log.d("Rpc", "Messenger failed, fallback to startService");
          }
        }
      }
      if (this.zzf.zza() == 2) {
        this.zze.sendBroadcast((Intent)???);
      } else {
        this.zze.startService((Intent)???);
      }
      paramBundle = this.zzg.schedule(new zzu(localTaskCompletionSource), 30L, TimeUnit.SECONDS);
      localTaskCompletionSource.getTask().addOnCompleteListener(zzc, new zzx(this, str, paramBundle));
      return localTaskCompletionSource.getTask();
    }
  }
  
  @NonNull
  public Task<Bundle> send(@NonNull Bundle paramBundle)
  {
    int i = this.zzf.zzb();
    int j = 1;
    if (i >= 12000000) {
      return zze.zza(this.zze).zzb(1, paramBundle).continueWith(zzc, zzt.zza);
    }
    if (this.zzf.zza() == 0) {
      j = 0;
    }
    if (j == 0) {
      return Tasks.forException(new IOException("MISSING_INSTANCEID_SERVICE"));
    }
    return zzc(paramBundle).continueWithTask(zzc, new zzv(this, paramBundle));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\cloudmessaging\Rpc.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */