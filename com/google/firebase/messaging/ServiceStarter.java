package com.google.firebase.messaging;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public class ServiceStarter
{
  @KeepForSdk
  public static final int ERROR_UNKNOWN = 500;
  public static final int SUCCESS = -1;
  private static ServiceStarter instance;
  @Nullable
  @GuardedBy("this")
  private String firebaseMessagingServiceClassName = null;
  private Boolean hasAccessNetworkStatePermission = null;
  private Boolean hasWakeLockPermission = null;
  private final Queue<Intent> messagingEvents = new ArrayDeque();
  
  private int doStartService(Context paramContext, Intent paramIntent)
  {
    String str1 = resolveServiceClassName(paramContext, paramIntent);
    if (str1 != null)
    {
      if (Log.isLoggable("FirebaseMessaging", 3))
      {
        String str2;
        if (str1.length() != 0) {
          str2 = "Restricting intent to a specific service: ".concat(str1);
        } else {
          str2 = new String("Restricting intent to a specific service: ");
        }
        Log.d("FirebaseMessaging", str2);
      }
      paramIntent.setClassName(paramContext.getPackageName(), str1);
    }
    try
    {
      if (hasWakeLockPermission(paramContext))
      {
        paramContext = WakeLockHolder.startWakefulService(paramContext, paramIntent);
      }
      else
      {
        paramContext = paramContext.startService(paramIntent);
        Log.d("FirebaseMessaging", "Missing wake lock permission, service start may be delayed");
      }
      if (paramContext == null)
      {
        Log.e("FirebaseMessaging", "Error while delivering the message: ServiceIntent not found.");
        return 404;
      }
      return -1;
    }
    catch (IllegalStateException paramContext)
    {
      paramIntent = String.valueOf(paramContext);
      paramContext = new StringBuilder(paramIntent.length() + 45);
      paramContext.append("Failed to start service while in background: ");
      paramContext.append(paramIntent);
      Log.e("FirebaseMessaging", paramContext.toString());
      return 402;
    }
    catch (SecurityException paramContext)
    {
      Log.e("FirebaseMessaging", "Error while delivering the message to the serviceIntent", paramContext);
    }
    return 401;
  }
  
  static ServiceStarter getInstance()
  {
    try
    {
      if (instance == null)
      {
        localServiceStarter = new com/google/firebase/messaging/ServiceStarter;
        localServiceStarter.<init>();
        instance = localServiceStarter;
      }
      ServiceStarter localServiceStarter = instance;
      return localServiceStarter;
    }
    finally {}
  }
  
  @Nullable
  private String resolveServiceClassName(Context paramContext, Intent paramIntent)
  {
    try
    {
      String str = this.firebaseMessagingServiceClassName;
      if (str != null) {
        return str;
      }
      paramIntent = paramContext.getPackageManager().resolveService(paramIntent, 0);
      if (paramIntent != null)
      {
        paramIntent = paramIntent.serviceInfo;
        if (paramIntent != null)
        {
          if (paramContext.getPackageName().equals(paramIntent.packageName))
          {
            str = paramIntent.name;
            if (str != null)
            {
              if (str.startsWith("."))
              {
                paramContext = String.valueOf(paramContext.getPackageName());
                paramIntent = String.valueOf(paramIntent.name);
                if (paramIntent.length() != 0) {
                  paramContext = paramContext.concat(paramIntent);
                } else {
                  paramContext = new String(paramContext);
                }
                this.firebaseMessagingServiceClassName = paramContext;
              }
              else
              {
                this.firebaseMessagingServiceClassName = paramIntent.name;
              }
              paramContext = this.firebaseMessagingServiceClassName;
              return paramContext;
            }
          }
          paramContext = paramIntent.packageName;
          str = paramIntent.name;
          int i = String.valueOf(paramContext).length();
          int j = String.valueOf(str).length();
          paramIntent = new java/lang/StringBuilder;
          paramIntent.<init>(i + 94 + j);
          paramIntent.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
          paramIntent.append(paramContext);
          paramIntent.append("/");
          paramIntent.append(str);
          Log.e("FirebaseMessaging", paramIntent.toString());
          return null;
        }
      }
      Log.e("FirebaseMessaging", "Failed to resolve target intent service, skipping classname enforcement");
      return null;
    }
    finally {}
  }
  
  @VisibleForTesting
  public static void setForTesting(@NonNull ServiceStarter paramServiceStarter)
  {
    instance = paramServiceStarter;
  }
  
  @MainThread
  Intent getMessagingEvent()
  {
    return (Intent)this.messagingEvents.poll();
  }
  
  boolean hasAccessNetworkStatePermission(Context paramContext)
  {
    if (this.hasAccessNetworkStatePermission == null)
    {
      boolean bool;
      if (paramContext.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.hasAccessNetworkStatePermission = Boolean.valueOf(bool);
    }
    if ((!this.hasWakeLockPermission.booleanValue()) && (Log.isLoggable("FirebaseMessaging", 3))) {
      Log.d("FirebaseMessaging", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
    }
    return this.hasAccessNetworkStatePermission.booleanValue();
  }
  
  boolean hasWakeLockPermission(Context paramContext)
  {
    if (this.hasWakeLockPermission == null)
    {
      boolean bool;
      if (paramContext.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.hasWakeLockPermission = Boolean.valueOf(bool);
    }
    if ((!this.hasWakeLockPermission.booleanValue()) && (Log.isLoggable("FirebaseMessaging", 3))) {
      Log.d("FirebaseMessaging", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
    }
    return this.hasWakeLockPermission.booleanValue();
  }
  
  @MainThread
  public int startMessagingService(@NonNull Context paramContext, @NonNull Intent paramIntent)
  {
    if (Log.isLoggable("FirebaseMessaging", 3)) {
      Log.d("FirebaseMessaging", "Starting service");
    }
    this.messagingEvents.offer(paramIntent);
    paramIntent = new Intent("com.google.firebase.MESSAGING_EVENT");
    paramIntent.setPackage(paramContext.getPackageName());
    return doStartService(paramContext, paramIntent);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\firebase\messaging\ServiceStarter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */