package androidx.legacy.content;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.util.Log;
import android.util.SparseArray;

@Deprecated
public abstract class WakefulBroadcastReceiver
  extends BroadcastReceiver
{
  private static final String EXTRA_WAKE_LOCK_ID = "androidx.contentpager.content.wakelockid";
  private static int mNextId = 1;
  private static final SparseArray<PowerManager.WakeLock> sActiveWakeLocks = new SparseArray();
  
  public static boolean completeWakefulIntent(Intent arg0)
  {
    int i = ???.getIntExtra("androidx.contentpager.content.wakelockid", 0);
    if (i == 0) {
      return false;
    }
    synchronized (sActiveWakeLocks)
    {
      Object localObject1 = (PowerManager.WakeLock)???.get(i);
      if (localObject1 != null)
      {
        ((PowerManager.WakeLock)localObject1).release();
        ???.remove(i);
        return true;
      }
      localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      ((StringBuilder)localObject1).append("No active wake lock id #");
      ((StringBuilder)localObject1).append(i);
      Log.w("WakefulBroadcastReceiv.", ((StringBuilder)localObject1).toString());
      return true;
    }
  }
  
  public static ComponentName startWakefulService(Context paramContext, Intent paramIntent)
  {
    synchronized (sActiveWakeLocks)
    {
      int i = mNextId;
      int j = i + 1;
      mNextId = j;
      if (j <= 0) {
        mNextId = 1;
      }
      paramIntent.putExtra("androidx.contentpager.content.wakelockid", i);
      paramIntent = paramContext.startService(paramIntent);
      if (paramIntent == null) {
        return null;
      }
      paramContext = (PowerManager)paramContext.getSystemService("power");
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append("androidx.core:wake:");
      localStringBuilder.append(paramIntent.flattenToShortString());
      paramContext = paramContext.newWakeLock(1, localStringBuilder.toString());
      paramContext.setReferenceCounted(false);
      paramContext.acquire(60000L);
      ???.put(i, paramContext);
      return paramIntent;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\legacy\content\WakefulBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */