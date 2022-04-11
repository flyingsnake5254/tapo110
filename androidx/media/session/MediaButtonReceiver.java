package androidx.media.session;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Build.VERSION;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.MediaBrowserCompat.ConnectionCallback;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.RestrictTo;
import java.util.List;

public class MediaButtonReceiver
  extends BroadcastReceiver
{
  private static final String TAG = "MediaButtonReceiver";
  
  public static PendingIntent buildMediaButtonPendingIntent(Context paramContext, long paramLong)
  {
    ComponentName localComponentName = getMediaButtonReceiverComponent(paramContext);
    if (localComponentName == null)
    {
      Log.w("MediaButtonReceiver", "A unique media button receiver could not be found in the given context, so couldn't build a pending intent.");
      return null;
    }
    return buildMediaButtonPendingIntent(paramContext, localComponentName, paramLong);
  }
  
  @SuppressLint({"WrongConstant"})
  public static PendingIntent buildMediaButtonPendingIntent(Context paramContext, ComponentName paramComponentName, long paramLong)
  {
    if (paramComponentName == null)
    {
      Log.w("MediaButtonReceiver", "The component name of media button receiver should be provided.");
      return null;
    }
    int i = PlaybackStateCompat.toKeyCode(paramLong);
    if (i == 0)
    {
      paramContext = new StringBuilder();
      paramContext.append("Cannot build a media button pending intent with the given action: ");
      paramContext.append(paramLong);
      Log.w("MediaButtonReceiver", paramContext.toString());
      return null;
    }
    Intent localIntent = new Intent("android.intent.action.MEDIA_BUTTON");
    localIntent.setComponent(paramComponentName);
    localIntent.putExtra("android.intent.extra.KEY_EVENT", new KeyEvent(0, i));
    if (Build.VERSION.SDK_INT >= 16) {
      localIntent.addFlags(268435456);
    }
    return PendingIntent.getBroadcast(paramContext, i, localIntent, MediaSessionCompat.PENDING_INTENT_FLAG_MUTABLE);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
  public static ComponentName getMediaButtonReceiverComponent(Context paramContext)
  {
    Intent localIntent = new Intent("android.intent.action.MEDIA_BUTTON");
    localIntent.setPackage(paramContext.getPackageName());
    paramContext = paramContext.getPackageManager().queryBroadcastReceivers(localIntent, 0);
    if (paramContext.size() == 1)
    {
      paramContext = ((ResolveInfo)paramContext.get(0)).activityInfo;
      return new ComponentName(paramContext.packageName, paramContext.name);
    }
    if (paramContext.size() > 1) {
      Log.w("MediaButtonReceiver", "More than one BroadcastReceiver that handles android.intent.action.MEDIA_BUTTON was found, returning null.");
    }
    return null;
  }
  
  private static ComponentName getServiceComponentByAction(Context paramContext, String paramString)
  {
    PackageManager localPackageManager = paramContext.getPackageManager();
    Object localObject = new Intent(paramString);
    ((Intent)localObject).setPackage(paramContext.getPackageName());
    paramContext = localPackageManager.queryIntentServices((Intent)localObject, 0);
    if (paramContext.size() == 1)
    {
      paramContext = ((ResolveInfo)paramContext.get(0)).serviceInfo;
      return new ComponentName(paramContext.packageName, paramContext.name);
    }
    if (paramContext.isEmpty()) {
      return null;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Expected 1 service that handles ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(", found ");
    ((StringBuilder)localObject).append(paramContext.size());
    throw new IllegalStateException(((StringBuilder)localObject).toString());
  }
  
  public static KeyEvent handleIntent(MediaSessionCompat paramMediaSessionCompat, Intent paramIntent)
  {
    if ((paramMediaSessionCompat != null) && (paramIntent != null) && ("android.intent.action.MEDIA_BUTTON".equals(paramIntent.getAction())) && (paramIntent.hasExtra("android.intent.extra.KEY_EVENT")))
    {
      paramIntent = (KeyEvent)paramIntent.getParcelableExtra("android.intent.extra.KEY_EVENT");
      paramMediaSessionCompat.getController().dispatchMediaButtonEvent(paramIntent);
      return paramIntent;
    }
    return null;
  }
  
  private static void startForegroundService(Context paramContext, Intent paramIntent)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      paramContext.startForegroundService(paramIntent);
    } else {
      paramContext.startService(paramIntent);
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && ("android.intent.action.MEDIA_BUTTON".equals(paramIntent.getAction())) && (paramIntent.hasExtra("android.intent.extra.KEY_EVENT")))
    {
      ComponentName localComponentName = getServiceComponentByAction(paramContext, "android.intent.action.MEDIA_BUTTON");
      if (localComponentName != null)
      {
        paramIntent.setComponent(localComponentName);
        startForegroundService(paramContext, paramIntent);
        return;
      }
      localComponentName = getServiceComponentByAction(paramContext, "android.media.browse.MediaBrowserService");
      if (localComponentName != null)
      {
        BroadcastReceiver.PendingResult localPendingResult = goAsync();
        paramContext = paramContext.getApplicationContext();
        paramIntent = new MediaButtonConnectionCallback(paramContext, paramIntent, localPendingResult);
        paramContext = new MediaBrowserCompat(paramContext, localComponentName, paramIntent, null);
        paramIntent.setMediaBrowser(paramContext);
        paramContext.connect();
        return;
      }
      throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
    }
    paramContext = new StringBuilder();
    paramContext.append("Ignore unsupported intent: ");
    paramContext.append(paramIntent);
    Log.d("MediaButtonReceiver", paramContext.toString());
  }
  
  private static class MediaButtonConnectionCallback
    extends MediaBrowserCompat.ConnectionCallback
  {
    private final Context mContext;
    private final Intent mIntent;
    private MediaBrowserCompat mMediaBrowser;
    private final BroadcastReceiver.PendingResult mPendingResult;
    
    MediaButtonConnectionCallback(Context paramContext, Intent paramIntent, BroadcastReceiver.PendingResult paramPendingResult)
    {
      this.mContext = paramContext;
      this.mIntent = paramIntent;
      this.mPendingResult = paramPendingResult;
    }
    
    private void finish()
    {
      this.mMediaBrowser.disconnect();
      this.mPendingResult.finish();
    }
    
    public void onConnected()
    {
      new MediaControllerCompat(this.mContext, this.mMediaBrowser.getSessionToken()).dispatchMediaButtonEvent((KeyEvent)this.mIntent.getParcelableExtra("android.intent.extra.KEY_EVENT"));
      finish();
    }
    
    public void onConnectionFailed()
    {
      finish();
    }
    
    public void onConnectionSuspended()
    {
      finish();
    }
    
    void setMediaBrowser(MediaBrowserCompat paramMediaBrowserCompat)
    {
      this.mMediaBrowser = paramMediaBrowserCompat;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\media\session\MediaButtonReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */