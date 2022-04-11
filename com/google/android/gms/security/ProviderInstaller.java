package com.google.android.gms.security;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources.NotFoundException;
import android.os.AsyncTask;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.DynamiteModule.LoadingException;
import java.lang.reflect.Method;

public class ProviderInstaller
{
  public static final String PROVIDER_NAME = "GmsCore_OpenSSL";
  private static final Object lock = new Object();
  private static final GoogleApiAvailabilityLight zziv = ;
  private static Method zziw = null;
  
  /* Error */
  public static void installIfNeeded(Context paramContext)
    throws com.google.android.gms.common.GooglePlayServicesRepairableException, com.google.android.gms.common.GooglePlayServicesNotAvailableException
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 45
    //   3: invokestatic 51	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   6: pop
    //   7: getstatic 27	com/google/android/gms/security/ProviderInstaller:zziv	Lcom/google/android/gms/common/GoogleApiAvailabilityLight;
    //   10: aload_0
    //   11: ldc 52
    //   13: invokevirtual 56	com/google/android/gms/common/GoogleApiAvailabilityLight:verifyGooglePlayServicesIsAvailable	(Landroid/content/Context;I)V
    //   16: aload_0
    //   17: invokestatic 60	com/google/android/gms/security/ProviderInstaller:zzk	(Landroid/content/Context;)Landroid/content/Context;
    //   20: astore_1
    //   21: aload_1
    //   22: astore_2
    //   23: aload_1
    //   24: ifnonnull +8 -> 32
    //   27: aload_0
    //   28: invokestatic 63	com/google/android/gms/security/ProviderInstaller:zzl	(Landroid/content/Context;)Landroid/content/Context;
    //   31: astore_2
    //   32: aload_2
    //   33: ifnull +172 -> 205
    //   36: getstatic 32	com/google/android/gms/security/ProviderInstaller:lock	Ljava/lang/Object;
    //   39: astore_3
    //   40: aload_3
    //   41: monitorenter
    //   42: getstatic 34	com/google/android/gms/security/ProviderInstaller:zziw	Ljava/lang/reflect/Method;
    //   45: ifnonnull +29 -> 74
    //   48: aload_2
    //   49: invokevirtual 69	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   52: ldc 71
    //   54: invokevirtual 77	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   57: ldc 79
    //   59: iconst_1
    //   60: anewarray 81	java/lang/Class
    //   63: dup
    //   64: iconst_0
    //   65: ldc 65
    //   67: aastore
    //   68: invokevirtual 85	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   71: putstatic 34	com/google/android/gms/security/ProviderInstaller:zziw	Ljava/lang/reflect/Method;
    //   74: getstatic 34	com/google/android/gms/security/ProviderInstaller:zziw	Ljava/lang/reflect/Method;
    //   77: aconst_null
    //   78: iconst_1
    //   79: anewarray 4	java/lang/Object
    //   82: dup
    //   83: iconst_0
    //   84: aload_2
    //   85: aastore
    //   86: invokevirtual 91	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   89: pop
    //   90: aload_3
    //   91: monitorexit
    //   92: return
    //   93: astore_0
    //   94: goto +107 -> 201
    //   97: astore_2
    //   98: aload_2
    //   99: invokevirtual 95	java/lang/Exception:getCause	()Ljava/lang/Throwable;
    //   102: astore 4
    //   104: ldc 97
    //   106: bipush 6
    //   108: invokestatic 103	android/util/Log:isLoggable	(Ljava/lang/String;I)Z
    //   111: ifeq +61 -> 172
    //   114: aload 4
    //   116: ifnonnull +11 -> 127
    //   119: aload_2
    //   120: invokevirtual 107	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   123: astore_1
    //   124: goto +9 -> 133
    //   127: aload 4
    //   129: invokevirtual 110	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   132: astore_1
    //   133: aload_1
    //   134: invokestatic 116	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   137: astore_1
    //   138: aload_1
    //   139: invokevirtual 120	java/lang/String:length	()I
    //   142: ifeq +13 -> 155
    //   145: ldc 122
    //   147: aload_1
    //   148: invokevirtual 126	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   151: astore_1
    //   152: goto +13 -> 165
    //   155: new 112	java/lang/String
    //   158: dup
    //   159: ldc 122
    //   161: invokespecial 129	java/lang/String:<init>	(Ljava/lang/String;)V
    //   164: astore_1
    //   165: ldc 97
    //   167: aload_1
    //   168: invokestatic 133	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   171: pop
    //   172: aload 4
    //   174: ifnonnull +6 -> 180
    //   177: goto +6 -> 183
    //   180: aload 4
    //   182: astore_2
    //   183: aload_0
    //   184: aload_2
    //   185: invokestatic 139	com/google/android/gms/common/util/CrashUtils:addDynamiteErrorToDropBox	(Landroid/content/Context;Ljava/lang/Throwable;)Z
    //   188: pop
    //   189: new 41	com/google/android/gms/common/GooglePlayServicesNotAvailableException
    //   192: astore_0
    //   193: aload_0
    //   194: bipush 8
    //   196: invokespecial 142	com/google/android/gms/common/GooglePlayServicesNotAvailableException:<init>	(I)V
    //   199: aload_0
    //   200: athrow
    //   201: aload_3
    //   202: monitorexit
    //   203: aload_0
    //   204: athrow
    //   205: ldc 97
    //   207: ldc -112
    //   209: invokestatic 133	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   212: pop
    //   213: new 41	com/google/android/gms/common/GooglePlayServicesNotAvailableException
    //   216: dup
    //   217: bipush 8
    //   219: invokespecial 142	com/google/android/gms/common/GooglePlayServicesNotAvailableException:<init>	(I)V
    //   222: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	paramContext	Context
    //   20	148	1	localObject1	Object
    //   22	63	2	localObject2	Object
    //   97	23	2	localException	Exception
    //   182	3	2	localObject3	Object
    //   39	163	3	localObject4	Object
    //   102	79	4	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   42	74	93	finally
    //   74	90	93	finally
    //   90	92	93	finally
    //   98	114	93	finally
    //   119	124	93	finally
    //   127	133	93	finally
    //   133	152	93	finally
    //   155	165	93	finally
    //   165	172	93	finally
    //   183	201	93	finally
    //   201	203	93	finally
    //   42	74	97	java/lang/Exception
    //   74	90	97	java/lang/Exception
  }
  
  public static void installIfNeededAsync(Context paramContext, ProviderInstallListener paramProviderInstallListener)
  {
    Preconditions.checkNotNull(paramContext, "Context must not be null");
    Preconditions.checkNotNull(paramProviderInstallListener, "Listener must not be null");
    Preconditions.checkMainThread("Must be called on the UI thread");
    new zza(paramContext, paramProviderInstallListener).execute(new Void[0]);
  }
  
  @Nullable
  private static Context zzk(Context paramContext)
  {
    try
    {
      paramContext = DynamiteModule.load(paramContext, DynamiteModule.PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING, "providerinstaller").getModuleContext();
      return paramContext;
    }
    catch (DynamiteModule.LoadingException paramContext)
    {
      paramContext = String.valueOf(paramContext.getMessage());
      if (paramContext.length() != 0) {
        paramContext = "Failed to load providerinstaller module: ".concat(paramContext);
      } else {
        paramContext = new String("Failed to load providerinstaller module: ");
      }
      Log.w("ProviderInstaller", paramContext);
    }
    return null;
  }
  
  @Nullable
  private static Context zzl(Context paramContext)
  {
    try
    {
      localObject = GooglePlayServicesUtilLight.getRemoteContext(paramContext);
      return (Context)localObject;
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      Object localObject = String.valueOf(localNotFoundException.getMessage());
      if (((String)localObject).length() != 0) {
        localObject = "Failed to load GMS Core context for providerinstaller: ".concat((String)localObject);
      } else {
        localObject = new String("Failed to load GMS Core context for providerinstaller: ");
      }
      Log.w("ProviderInstaller", (String)localObject);
      CrashUtils.addDynamiteErrorToDropBox(paramContext, localNotFoundException);
    }
    return null;
  }
  
  public static abstract interface ProviderInstallListener
  {
    public abstract void onProviderInstallFailed(int paramInt, Intent paramIntent);
    
    public abstract void onProviderInstalled();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\security\ProviderInstaller.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */