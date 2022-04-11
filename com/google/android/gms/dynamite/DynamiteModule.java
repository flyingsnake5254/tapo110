package com.google.android.gms.dynamite;

import android.content.Context;
import android.database.Cursor;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.DynamiteApi;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public final class DynamiteModule
{
  @KeepForSdk
  public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzd();
  @KeepForSdk
  public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zze();
  @KeepForSdk
  public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzf();
  @KeepForSdk
  public static final VersionPolicy PREFER_LOCAL;
  @KeepForSdk
  public static final VersionPolicy PREFER_REMOTE;
  @GuardedBy("DynamiteModule.class")
  private static Boolean zzif;
  @GuardedBy("DynamiteModule.class")
  private static zzi zzig;
  @GuardedBy("DynamiteModule.class")
  private static zzk zzih;
  @GuardedBy("DynamiteModule.class")
  private static String zzii;
  @GuardedBy("DynamiteModule.class")
  private static int zzij = -1;
  private static final ThreadLocal<zza> zzik = new ThreadLocal();
  private static final DynamiteModule.VersionPolicy.zza zzil = new zza();
  private static final VersionPolicy zzim = new zzg();
  private final Context zzin;
  
  static
  {
    PREFER_REMOTE = new zzb();
    PREFER_LOCAL = new zzc();
  }
  
  private DynamiteModule(Context paramContext)
  {
    this.zzin = ((Context)Preconditions.checkNotNull(paramContext));
  }
  
  @KeepForSdk
  public static int getLocalVersion(Context paramContext, String paramString)
  {
    try
    {
      Object localObject = paramContext.getApplicationContext().getClassLoader();
      int i = String.valueOf(paramString).length();
      paramContext = new java/lang/StringBuilder;
      paramContext.<init>(i + 61);
      paramContext.append("com.google.android.gms.dynamite.descriptors.");
      paramContext.append(paramString);
      paramContext.append(".ModuleDescriptor");
      localObject = ((ClassLoader)localObject).loadClass(paramContext.toString());
      paramContext = ((Class)localObject).getDeclaredField("MODULE_ID");
      localObject = ((Class)localObject).getDeclaredField("MODULE_VERSION");
      if (!paramContext.get(null).equals(paramString))
      {
        paramContext = String.valueOf(paramContext.get(null));
        i = paramContext.length();
        int j = String.valueOf(paramString).length();
        localObject = new java/lang/StringBuilder;
        ((StringBuilder)localObject).<init>(i + 51 + j);
        ((StringBuilder)localObject).append("Module descriptor id '");
        ((StringBuilder)localObject).append(paramContext);
        ((StringBuilder)localObject).append("' didn't match expected id '");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("'");
        Log.e("DynamiteModule", ((StringBuilder)localObject).toString());
        return 0;
      }
      i = ((Field)localObject).getInt(null);
      return i;
    }
    catch (Exception paramContext)
    {
      paramContext = String.valueOf(paramContext.getMessage());
      if (paramContext.length() != 0) {
        paramContext = "Failed to load module descriptor class: ".concat(paramContext);
      } else {
        paramContext = new String("Failed to load module descriptor class: ");
      }
      Log.e("DynamiteModule", paramContext);
    }
    catch (ClassNotFoundException paramContext)
    {
      paramContext = new StringBuilder(String.valueOf(paramString).length() + 45);
      paramContext.append("Local module descriptor class for ");
      paramContext.append(paramString);
      paramContext.append(" not found.");
      Log.w("DynamiteModule", paramContext.toString());
    }
    return 0;
  }
  
  @KeepForSdk
  public static int getRemoteVersion(Context paramContext, String paramString)
  {
    return zza(paramContext, paramString, false);
  }
  
  @KeepForSdk
  public static DynamiteModule load(Context paramContext, VersionPolicy paramVersionPolicy, String paramString)
    throws DynamiteModule.LoadingException
  {
    Object localObject1 = zzik;
    zza localzza1 = (zza)((ThreadLocal)localObject1).get();
    zza localzza2 = new zza(null);
    ((ThreadLocal)localObject1).set(localzza2);
    try
    {
      DynamiteModule.VersionPolicy.zzb localzzb = paramVersionPolicy.zza(paramContext, paramString, zzil);
      int i = localzzb.zzir;
      int j = localzzb.zzis;
      int k = String.valueOf(paramString).length();
      int m = String.valueOf(paramString).length();
      Object localObject2 = new java/lang/StringBuilder;
      ((StringBuilder)localObject2).<init>(k + 68 + m);
      ((StringBuilder)localObject2).append("Considering local module ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(" and remote module ");
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(":");
      ((StringBuilder)localObject2).append(j);
      Log.i("DynamiteModule", ((StringBuilder)localObject2).toString());
      j = localzzb.zzit;
      if ((j != 0) && ((j != -1) || (localzzb.zzir != 0)) && ((j != 1) || (localzzb.zzis != 0)))
      {
        if (j == -1)
        {
          paramContext = zze(paramContext, paramString);
          paramVersionPolicy = localzza2.zzio;
          if (paramVersionPolicy != null) {
            paramVersionPolicy.close();
          }
          ((ThreadLocal)localObject1).set(localzza1);
          return paramContext;
        }
        if (j == 1) {
          try
          {
            localObject2 = zza(paramContext, paramString, localzzb.zzis);
            paramContext = localzza2.zzio;
            if (paramContext != null) {
              paramContext.close();
            }
            ((ThreadLocal)localObject1).set(localzza1);
            return (DynamiteModule)localObject2;
          }
          catch (LoadingException localLoadingException)
          {
            localObject1 = String.valueOf(localLoadingException.getMessage());
            if (((String)localObject1).length() != 0) {
              localObject1 = "Failed to load remote module: ".concat((String)localObject1);
            } else {
              localObject1 = new String("Failed to load remote module: ");
            }
            Log.w("DynamiteModule", (String)localObject1);
            j = localzzb.zzir;
            if (j != 0)
            {
              localObject1 = new com/google/android/gms/dynamite/DynamiteModule$zzb;
              ((zzb)localObject1).<init>(j, 0);
              if (paramVersionPolicy.zza(paramContext, paramString, (DynamiteModule.VersionPolicy.zza)localObject1).zzit == -1)
              {
                paramContext = zze(paramContext, paramString);
                return paramContext;
              }
            }
            paramContext = new com/google/android/gms/dynamite/DynamiteModule$LoadingException;
            paramContext.<init>("Remote load failed. No local fallback found.", localLoadingException, null);
            throw paramContext;
          }
        }
        paramContext = new com/google/android/gms/dynamite/DynamiteModule$LoadingException;
        j = localzzb.zzit;
        paramVersionPolicy = new java/lang/StringBuilder;
        paramVersionPolicy.<init>(47);
        paramVersionPolicy.append("VersionPolicy returned invalid code:");
        paramVersionPolicy.append(j);
        paramContext.<init>(paramVersionPolicy.toString(), null);
        throw paramContext;
      }
      paramContext = new com/google/android/gms/dynamite/DynamiteModule$LoadingException;
      j = localzzb.zzir;
      i = localzzb.zzis;
      paramVersionPolicy = new java/lang/StringBuilder;
      paramVersionPolicy.<init>(91);
      paramVersionPolicy.append("No acceptable module found. Local version is ");
      paramVersionPolicy.append(j);
      paramVersionPolicy.append(" and remote version is ");
      paramVersionPolicy.append(i);
      paramVersionPolicy.append(".");
      paramContext.<init>(paramVersionPolicy.toString(), null);
      throw paramContext;
    }
    finally
    {
      paramVersionPolicy = localzza2.zzio;
      if (paramVersionPolicy != null) {
        paramVersionPolicy.close();
      }
      zzik.set(localzza1);
    }
  }
  
  /* Error */
  public static int zza(Context paramContext, String paramString, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 297	com/google/android/gms/dynamite/DynamiteModule:zzif	Ljava/lang/Boolean;
    //   6: astore_3
    //   7: aload_3
    //   8: astore 4
    //   10: aload_3
    //   11: ifnonnull +292 -> 303
    //   14: aload_0
    //   15: invokevirtual 119	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   18: invokevirtual 123	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   21: ldc 6
    //   23: invokevirtual 300	java/lang/Class:getName	()Ljava/lang/String;
    //   26: invokevirtual 156	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   29: astore_3
    //   30: aload_3
    //   31: ldc_w 302
    //   34: invokevirtual 164	java/lang/Class:getDeclaredField	(Ljava/lang/String;)Ljava/lang/reflect/Field;
    //   37: astore 4
    //   39: aload_3
    //   40: monitorenter
    //   41: aload 4
    //   43: aconst_null
    //   44: invokevirtual 171	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   47: checkcast 152	java/lang/ClassLoader
    //   50: astore 5
    //   52: aload 5
    //   54: ifnull +32 -> 86
    //   57: aload 5
    //   59: invokestatic 305	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   62: if_acmpne +11 -> 73
    //   65: getstatic 310	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   68: astore 4
    //   70: goto +145 -> 215
    //   73: aload 5
    //   75: invokestatic 313	com/google/android/gms/dynamite/DynamiteModule:zza	(Ljava/lang/ClassLoader;)V
    //   78: getstatic 316	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   81: astore 4
    //   83: goto +132 -> 215
    //   86: ldc_w 318
    //   89: aload_0
    //   90: invokevirtual 119	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   93: invokevirtual 321	android/content/Context:getPackageName	()Ljava/lang/String;
    //   96: invokevirtual 322	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   99: ifeq +20 -> 119
    //   102: aload 4
    //   104: aconst_null
    //   105: invokestatic 305	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   108: invokevirtual 325	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   111: getstatic 310	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   114: astore 4
    //   116: goto +99 -> 215
    //   119: aload_0
    //   120: aload_1
    //   121: iload_2
    //   122: invokestatic 328	com/google/android/gms/dynamite/DynamiteModule:zzc	(Landroid/content/Context;Ljava/lang/String;Z)I
    //   125: istore 6
    //   127: getstatic 330	com/google/android/gms/dynamite/DynamiteModule:zzii	Ljava/lang/String;
    //   130: astore 5
    //   132: aload 5
    //   134: ifnull +57 -> 191
    //   137: aload 5
    //   139: invokevirtual 334	java/lang/String:isEmpty	()Z
    //   142: ifeq +6 -> 148
    //   145: goto +46 -> 191
    //   148: new 336	com/google/android/gms/dynamite/zzh
    //   151: astore 5
    //   153: aload 5
    //   155: getstatic 330	com/google/android/gms/dynamite/DynamiteModule:zzii	Ljava/lang/String;
    //   158: invokestatic 305	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   161: invokespecial 339	com/google/android/gms/dynamite/zzh:<init>	(Ljava/lang/String;Ljava/lang/ClassLoader;)V
    //   164: aload 5
    //   166: invokestatic 313	com/google/android/gms/dynamite/DynamiteModule:zza	(Ljava/lang/ClassLoader;)V
    //   169: aload 4
    //   171: aconst_null
    //   172: aload 5
    //   174: invokevirtual 325	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   177: getstatic 316	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   180: putstatic 297	com/google/android/gms/dynamite/DynamiteModule:zzif	Ljava/lang/Boolean;
    //   183: aload_3
    //   184: monitorexit
    //   185: ldc 2
    //   187: monitorexit
    //   188: iload 6
    //   190: ireturn
    //   191: aload_3
    //   192: monitorexit
    //   193: ldc 2
    //   195: monitorexit
    //   196: iload 6
    //   198: ireturn
    //   199: astore 5
    //   201: aload 4
    //   203: aconst_null
    //   204: invokestatic 305	java/lang/ClassLoader:getSystemClassLoader	()Ljava/lang/ClassLoader;
    //   207: invokevirtual 325	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   210: getstatic 310	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   213: astore 4
    //   215: aload_3
    //   216: monitorexit
    //   217: goto +81 -> 298
    //   220: astore 4
    //   222: aload_3
    //   223: monitorexit
    //   224: aload 4
    //   226: athrow
    //   227: astore 4
    //   229: goto +10 -> 239
    //   232: astore 4
    //   234: goto +5 -> 239
    //   237: astore 4
    //   239: aload 4
    //   241: invokestatic 129	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   244: astore_3
    //   245: aload_3
    //   246: invokevirtual 133	java/lang/String:length	()I
    //   249: istore 6
    //   251: new 135	java/lang/StringBuilder
    //   254: astore 4
    //   256: aload 4
    //   258: iload 6
    //   260: bipush 30
    //   262: iadd
    //   263: invokespecial 138	java/lang/StringBuilder:<init>	(I)V
    //   266: aload 4
    //   268: ldc_w 341
    //   271: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload 4
    //   277: aload_3
    //   278: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: ldc -73
    //   284: aload 4
    //   286: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   289: invokestatic 212	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   292: pop
    //   293: getstatic 310	java/lang/Boolean:FALSE	Ljava/lang/Boolean;
    //   296: astore 4
    //   298: aload 4
    //   300: putstatic 297	com/google/android/gms/dynamite/DynamiteModule:zzif	Ljava/lang/Boolean;
    //   303: ldc 2
    //   305: monitorexit
    //   306: aload 4
    //   308: invokevirtual 344	java/lang/Boolean:booleanValue	()Z
    //   311: istore 7
    //   313: iload 7
    //   315: ifeq +61 -> 376
    //   318: aload_0
    //   319: aload_1
    //   320: iload_2
    //   321: invokestatic 328	com/google/android/gms/dynamite/DynamiteModule:zzc	(Landroid/content/Context;Ljava/lang/String;Z)I
    //   324: istore 6
    //   326: iload 6
    //   328: ireturn
    //   329: astore_1
    //   330: aload_1
    //   331: invokevirtual 196	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   334: invokestatic 129	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   337: astore_1
    //   338: aload_1
    //   339: invokevirtual 133	java/lang/String:length	()I
    //   342: ifeq +14 -> 356
    //   345: ldc_w 346
    //   348: aload_1
    //   349: invokevirtual 202	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   352: astore_1
    //   353: goto +14 -> 367
    //   356: new 125	java/lang/String
    //   359: dup
    //   360: ldc_w 346
    //   363: invokespecial 205	java/lang/String:<init>	(Ljava/lang/String;)V
    //   366: astore_1
    //   367: ldc -73
    //   369: aload_1
    //   370: invokestatic 212	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   373: pop
    //   374: iconst_0
    //   375: ireturn
    //   376: aload_0
    //   377: aload_1
    //   378: iload_2
    //   379: invokestatic 348	com/google/android/gms/dynamite/DynamiteModule:zzb	(Landroid/content/Context;Ljava/lang/String;Z)I
    //   382: istore 6
    //   384: iload 6
    //   386: ireturn
    //   387: astore_1
    //   388: ldc 2
    //   390: monitorexit
    //   391: aload_1
    //   392: athrow
    //   393: astore_1
    //   394: aload_0
    //   395: aload_1
    //   396: invokestatic 354	com/google/android/gms/common/util/CrashUtils:addDynamiteErrorToDropBox	(Landroid/content/Context;Ljava/lang/Throwable;)Z
    //   399: pop
    //   400: aload_1
    //   401: athrow
    //   402: astore 4
    //   404: goto -326 -> 78
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	407	0	paramContext	Context
    //   0	407	1	paramString	String
    //   0	407	2	paramBoolean	boolean
    //   6	272	3	localObject1	Object
    //   8	206	4	localObject2	Object
    //   220	5	4	localObject3	Object
    //   227	1	4	localNoSuchFieldException	NoSuchFieldException
    //   232	1	4	localIllegalAccessException	IllegalAccessException
    //   237	3	4	localClassNotFoundException	ClassNotFoundException
    //   254	53	4	localObject4	Object
    //   402	1	4	localLoadingException1	LoadingException
    //   50	123	5	localObject5	Object
    //   199	1	5	localLoadingException2	LoadingException
    //   125	260	6	i	int
    //   311	3	7	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   119	132	199	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   137	145	199	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   148	183	199	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   41	52	220	finally
    //   57	70	220	finally
    //   73	78	220	finally
    //   78	83	220	finally
    //   86	116	220	finally
    //   119	132	220	finally
    //   137	145	220	finally
    //   148	183	220	finally
    //   183	185	220	finally
    //   191	193	220	finally
    //   201	215	220	finally
    //   215	217	220	finally
    //   222	224	220	finally
    //   14	41	227	java/lang/NoSuchFieldException
    //   224	227	227	java/lang/NoSuchFieldException
    //   14	41	232	java/lang/IllegalAccessException
    //   224	227	232	java/lang/IllegalAccessException
    //   14	41	237	java/lang/ClassNotFoundException
    //   224	227	237	java/lang/ClassNotFoundException
    //   318	326	329	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   3	7	387	finally
    //   14	41	387	finally
    //   185	188	387	finally
    //   193	196	387	finally
    //   224	227	387	finally
    //   239	298	387	finally
    //   298	303	387	finally
    //   303	306	387	finally
    //   388	391	387	finally
    //   0	3	393	finally
    //   306	313	393	finally
    //   318	326	393	finally
    //   330	353	393	finally
    //   356	367	393	finally
    //   367	374	393	finally
    //   376	384	393	finally
    //   391	393	393	finally
    //   73	78	402	com/google/android/gms/dynamite/DynamiteModule$LoadingException
  }
  
  /* Error */
  private static DynamiteModule zza(Context paramContext, String paramString, int paramInt)
    throws DynamiteModule.LoadingException
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 297	com/google/android/gms/dynamite/DynamiteModule:zzif	Ljava/lang/Boolean;
    //   6: astore_3
    //   7: ldc 2
    //   9: monitorexit
    //   10: aload_3
    //   11: ifnull +184 -> 195
    //   14: aload_3
    //   15: invokevirtual 344	java/lang/Boolean:booleanValue	()Z
    //   18: ifeq +10 -> 28
    //   21: aload_0
    //   22: aload_1
    //   23: iload_2
    //   24: invokestatic 358	com/google/android/gms/dynamite/DynamiteModule:zzb	(Landroid/content/Context;Ljava/lang/String;I)Lcom/google/android/gms/dynamite/DynamiteModule;
    //   27: areturn
    //   28: aload_1
    //   29: invokestatic 129	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   32: invokevirtual 133	java/lang/String:length	()I
    //   35: istore 4
    //   37: new 135	java/lang/StringBuilder
    //   40: astore_3
    //   41: aload_3
    //   42: iload 4
    //   44: bipush 51
    //   46: iadd
    //   47: invokespecial 138	java/lang/StringBuilder:<init>	(I)V
    //   50: aload_3
    //   51: ldc_w 360
    //   54: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_3
    //   59: aload_1
    //   60: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_3
    //   65: ldc_w 362
    //   68: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_3
    //   73: iload_2
    //   74: invokevirtual 245	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: ldc -73
    //   80: aload_3
    //   81: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   84: invokestatic 250	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   87: pop
    //   88: aload_0
    //   89: invokestatic 366	com/google/android/gms/dynamite/DynamiteModule:zzj	(Landroid/content/Context;)Lcom/google/android/gms/dynamite/zzi;
    //   92: astore_3
    //   93: aload_3
    //   94: ifnull +87 -> 181
    //   97: aload_3
    //   98: invokeinterface 371 1 0
    //   103: iconst_2
    //   104: if_icmplt +19 -> 123
    //   107: aload_3
    //   108: aload_0
    //   109: invokestatic 377	com/google/android/gms/dynamic/ObjectWrapper:wrap	(Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   112: aload_1
    //   113: iload_2
    //   114: invokeinterface 380 4 0
    //   119: astore_1
    //   120: goto +25 -> 145
    //   123: ldc -73
    //   125: ldc_w 382
    //   128: invokestatic 212	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   131: pop
    //   132: aload_3
    //   133: aload_0
    //   134: invokestatic 377	com/google/android/gms/dynamic/ObjectWrapper:wrap	(Ljava/lang/Object;)Lcom/google/android/gms/dynamic/IObjectWrapper;
    //   137: aload_1
    //   138: iload_2
    //   139: invokeinterface 384 4 0
    //   144: astore_1
    //   145: aload_1
    //   146: invokestatic 388	com/google/android/gms/dynamic/ObjectWrapper:unwrap	(Lcom/google/android/gms/dynamic/IObjectWrapper;)Ljava/lang/Object;
    //   149: ifnull +18 -> 167
    //   152: new 2	com/google/android/gms/dynamite/DynamiteModule
    //   155: dup
    //   156: aload_1
    //   157: invokestatic 388	com/google/android/gms/dynamic/ObjectWrapper:unwrap	(Lcom/google/android/gms/dynamic/IObjectWrapper;)Ljava/lang/Object;
    //   160: checkcast 107	android/content/Context
    //   163: invokespecial 390	com/google/android/gms/dynamite/DynamiteModule:<init>	(Landroid/content/Context;)V
    //   166: areturn
    //   167: new 9	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   170: astore_1
    //   171: aload_1
    //   172: ldc_w 392
    //   175: aconst_null
    //   176: invokespecial 284	com/google/android/gms/dynamite/DynamiteModule$LoadingException:<init>	(Ljava/lang/String;Lcom/google/android/gms/dynamite/zza;)V
    //   179: aload_1
    //   180: athrow
    //   181: new 9	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   184: astore_1
    //   185: aload_1
    //   186: ldc_w 394
    //   189: aconst_null
    //   190: invokespecial 284	com/google/android/gms/dynamite/DynamiteModule$LoadingException:<init>	(Ljava/lang/String;Lcom/google/android/gms/dynamite/zza;)V
    //   193: aload_1
    //   194: athrow
    //   195: new 9	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   198: astore_1
    //   199: aload_1
    //   200: ldc_w 396
    //   203: aconst_null
    //   204: invokespecial 284	com/google/android/gms/dynamite/DynamiteModule$LoadingException:<init>	(Ljava/lang/String;Lcom/google/android/gms/dynamite/zza;)V
    //   207: aload_1
    //   208: athrow
    //   209: astore_1
    //   210: ldc 2
    //   212: monitorexit
    //   213: aload_1
    //   214: athrow
    //   215: astore_1
    //   216: aload_0
    //   217: aload_1
    //   218: invokestatic 354	com/google/android/gms/common/util/CrashUtils:addDynamiteErrorToDropBox	(Landroid/content/Context;Ljava/lang/Throwable;)Z
    //   221: pop
    //   222: new 9	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   225: dup
    //   226: ldc_w 392
    //   229: aload_1
    //   230: aconst_null
    //   231: invokespecial 279	com/google/android/gms/dynamite/DynamiteModule$LoadingException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;Lcom/google/android/gms/dynamite/zza;)V
    //   234: athrow
    //   235: astore_0
    //   236: aload_0
    //   237: athrow
    //   238: astore_0
    //   239: new 9	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   242: dup
    //   243: ldc_w 392
    //   246: aload_0
    //   247: aconst_null
    //   248: invokespecial 279	com/google/android/gms/dynamite/DynamiteModule$LoadingException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;Lcom/google/android/gms/dynamite/zza;)V
    //   251: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	252	0	paramContext	Context
    //   0	252	1	paramString	String
    //   0	252	2	paramInt	int
    //   6	127	3	localObject	Object
    //   35	12	4	i	int
    // Exception table:
    //   from	to	target	type
    //   3	10	209	finally
    //   210	213	209	finally
    //   0	3	215	finally
    //   14	28	215	finally
    //   28	93	215	finally
    //   97	120	215	finally
    //   123	145	215	finally
    //   145	167	215	finally
    //   167	181	215	finally
    //   181	195	215	finally
    //   195	209	215	finally
    //   213	215	215	finally
    //   0	3	235	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   14	28	235	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   28	93	235	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   97	120	235	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   123	145	235	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   145	167	235	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   167	181	235	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   181	195	235	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   195	209	235	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   213	215	235	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   0	3	238	android/os/RemoteException
    //   14	28	238	android/os/RemoteException
    //   28	93	238	android/os/RemoteException
    //   97	120	238	android/os/RemoteException
    //   123	145	238	android/os/RemoteException
    //   145	167	238	android/os/RemoteException
    //   167	181	238	android/os/RemoteException
    //   181	195	238	android/os/RemoteException
    //   195	209	238	android/os/RemoteException
    //   213	215	238	android/os/RemoteException
  }
  
  @GuardedBy("DynamiteModule.class")
  private static void zza(ClassLoader paramClassLoader)
    throws DynamiteModule.LoadingException
  {
    try
    {
      IBinder localIBinder = (IBinder)paramClassLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
      if (localIBinder == null)
      {
        paramClassLoader = null;
      }
      else
      {
        paramClassLoader = localIBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
        if ((paramClassLoader instanceof zzk)) {
          paramClassLoader = (zzk)paramClassLoader;
        } else {
          paramClassLoader = new zzl(localIBinder);
        }
      }
      zzih = paramClassLoader;
      return;
    }
    catch (NoSuchMethodException paramClassLoader) {}catch (InvocationTargetException paramClassLoader) {}catch (InstantiationException paramClassLoader) {}catch (IllegalAccessException paramClassLoader) {}catch (ClassNotFoundException paramClassLoader) {}
    throw new LoadingException("Failed to instantiate dynamite loader", paramClassLoader, null);
  }
  
  private static Boolean zzaj()
  {
    try
    {
      boolean bool;
      if (zzij >= 2) {
        bool = true;
      } else {
        bool = false;
      }
      return Boolean.valueOf(bool);
    }
    finally {}
  }
  
  private static int zzb(Context paramContext, String paramString, boolean paramBoolean)
  {
    zzi localzzi = zzj(paramContext);
    if (localzzi == null) {
      return 0;
    }
    try
    {
      if (localzzi.zzak() >= 2) {
        return localzzi.zzb(ObjectWrapper.wrap(paramContext), paramString, paramBoolean);
      }
      Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
      int i = localzzi.zza(ObjectWrapper.wrap(paramContext), paramString, paramBoolean);
      return i;
    }
    catch (RemoteException paramContext)
    {
      paramContext = String.valueOf(paramContext.getMessage());
      if (paramContext.length() != 0) {
        paramContext = "Failed to retrieve remote module version: ".concat(paramContext);
      } else {
        paramContext = new String("Failed to retrieve remote module version: ");
      }
      Log.w("DynamiteModule", paramContext);
    }
    return 0;
  }
  
  private static DynamiteModule zzb(Context paramContext, String paramString, int paramInt)
    throws DynamiteModule.LoadingException, RemoteException
  {
    Object localObject1 = new StringBuilder(String.valueOf(paramString).length() + 51);
    ((StringBuilder)localObject1).append("Selected remote version of ");
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append(", version >= ");
    ((StringBuilder)localObject1).append(paramInt);
    Log.i("DynamiteModule", ((StringBuilder)localObject1).toString());
    try
    {
      localObject1 = zzih;
      if (localObject1 != null)
      {
        Object localObject2 = (zza)zzik.get();
        if ((localObject2 != null) && (((zza)localObject2).zzio != null))
        {
          paramContext = paramContext.getApplicationContext();
          localObject2 = ((zza)localObject2).zzio;
          ObjectWrapper.wrap(null);
          if (zzaj().booleanValue())
          {
            Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
            paramContext = ((zzk)localObject1).zzb(ObjectWrapper.wrap(paramContext), paramString, paramInt, ObjectWrapper.wrap(localObject2));
          }
          else
          {
            Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
            paramContext = ((zzk)localObject1).zza(ObjectWrapper.wrap(paramContext), paramString, paramInt, ObjectWrapper.wrap(localObject2));
          }
          paramContext = (Context)ObjectWrapper.unwrap(paramContext);
          if (paramContext != null) {
            return new DynamiteModule(paramContext);
          }
          throw new LoadingException("Failed to get module context", null);
        }
        throw new LoadingException("No result cursor", null);
      }
      throw new LoadingException("DynamiteLoaderV2 was not cached.", null);
    }
    finally {}
  }
  
  /* Error */
  private static int zzc(Context paramContext, String paramString, boolean paramBoolean)
    throws DynamiteModule.LoadingException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aload_0
    //   6: invokevirtual 472	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   9: astore 5
    //   11: iload_2
    //   12: ifeq +10 -> 22
    //   15: ldc_w 474
    //   18: astore_0
    //   19: goto +7 -> 26
    //   22: ldc_w 476
    //   25: astore_0
    //   26: aload_0
    //   27: invokevirtual 133	java/lang/String:length	()I
    //   30: istore 6
    //   32: aload_1
    //   33: invokestatic 129	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   36: invokevirtual 133	java/lang/String:length	()I
    //   39: istore 7
    //   41: new 135	java/lang/StringBuilder
    //   44: astore 8
    //   46: aload 8
    //   48: iload 6
    //   50: bipush 42
    //   52: iadd
    //   53: iload 7
    //   55: iadd
    //   56: invokespecial 138	java/lang/StringBuilder:<init>	(I)V
    //   59: aload 8
    //   61: ldc_w 478
    //   64: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload 8
    //   70: aload_0
    //   71: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload 8
    //   77: ldc_w 480
    //   80: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 8
    //   86: aload_1
    //   87: invokevirtual 144	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: pop
    //   91: aload 5
    //   93: aload 8
    //   95: invokevirtual 150	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   98: invokestatic 486	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   101: aconst_null
    //   102: aconst_null
    //   103: aconst_null
    //   104: aconst_null
    //   105: invokevirtual 492	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   108: astore_0
    //   109: aload_0
    //   110: ifnull +120 -> 230
    //   113: aload_0
    //   114: invokeinterface 495 1 0
    //   119: ifeq +111 -> 230
    //   122: aload_0
    //   123: iconst_0
    //   124: invokeinterface 498 2 0
    //   129: istore 6
    //   131: iload 6
    //   133: ifle +84 -> 217
    //   136: ldc 2
    //   138: monitorenter
    //   139: aload_0
    //   140: iconst_2
    //   141: invokeinterface 502 2 0
    //   146: putstatic 330	com/google/android/gms/dynamite/DynamiteModule:zzii	Ljava/lang/String;
    //   149: aload_0
    //   150: ldc_w 504
    //   153: invokeinterface 508 2 0
    //   158: istore 7
    //   160: iload 7
    //   162: iflt +14 -> 176
    //   165: aload_0
    //   166: iload 7
    //   168: invokeinterface 498 2 0
    //   173: putstatic 437	com/google/android/gms/dynamite/DynamiteModule:zzij	I
    //   176: ldc 2
    //   178: monitorexit
    //   179: getstatic 61	com/google/android/gms/dynamite/DynamiteModule:zzik	Ljava/lang/ThreadLocal;
    //   182: invokevirtual 222	java/lang/ThreadLocal:get	()Ljava/lang/Object;
    //   185: checkcast 21	com/google/android/gms/dynamite/DynamiteModule$zza
    //   188: astore_1
    //   189: aload_1
    //   190: ifnull +27 -> 217
    //   193: aload_1
    //   194: getfield 261	com/google/android/gms/dynamite/DynamiteModule$zza:zzio	Landroid/database/Cursor;
    //   197: ifnonnull +20 -> 217
    //   200: aload_1
    //   201: aload_0
    //   202: putfield 261	com/google/android/gms/dynamite/DynamiteModule$zza:zzio	Landroid/database/Cursor;
    //   205: aload 4
    //   207: astore_0
    //   208: goto +9 -> 217
    //   211: astore_1
    //   212: ldc 2
    //   214: monitorexit
    //   215: aload_1
    //   216: athrow
    //   217: aload_0
    //   218: ifnull +9 -> 227
    //   221: aload_0
    //   222: invokeinterface 266 1 0
    //   227: iload 6
    //   229: ireturn
    //   230: ldc -73
    //   232: ldc_w 510
    //   235: invokestatic 212	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   238: pop
    //   239: new 9	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   242: astore_1
    //   243: aload_1
    //   244: ldc_w 512
    //   247: aconst_null
    //   248: invokespecial 284	com/google/android/gms/dynamite/DynamiteModule$LoadingException:<init>	(Ljava/lang/String;Lcom/google/android/gms/dynamite/zza;)V
    //   251: aload_1
    //   252: athrow
    //   253: astore_1
    //   254: goto +41 -> 295
    //   257: astore_1
    //   258: goto +12 -> 270
    //   261: astore_1
    //   262: aload_3
    //   263: astore_0
    //   264: goto +31 -> 295
    //   267: astore_1
    //   268: aconst_null
    //   269: astore_0
    //   270: aload_1
    //   271: instanceof 9
    //   274: ifeq +5 -> 279
    //   277: aload_1
    //   278: athrow
    //   279: new 9	com/google/android/gms/dynamite/DynamiteModule$LoadingException
    //   282: astore_3
    //   283: aload_3
    //   284: ldc_w 514
    //   287: aload_1
    //   288: aconst_null
    //   289: invokespecial 279	com/google/android/gms/dynamite/DynamiteModule$LoadingException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;Lcom/google/android/gms/dynamite/zza;)V
    //   292: aload_3
    //   293: athrow
    //   294: astore_1
    //   295: aload_0
    //   296: ifnull +9 -> 305
    //   299: aload_0
    //   300: invokeinterface 266 1 0
    //   305: aload_1
    //   306: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	307	0	paramContext	Context
    //   0	307	1	paramString	String
    //   0	307	2	paramBoolean	boolean
    //   1	292	3	localLoadingException	LoadingException
    //   3	203	4	localObject	Object
    //   9	83	5	localContentResolver	android.content.ContentResolver
    //   30	198	6	i	int
    //   39	128	7	j	int
    //   44	50	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   139	160	211	finally
    //   165	176	211	finally
    //   176	179	211	finally
    //   212	215	211	finally
    //   113	131	253	finally
    //   136	139	253	finally
    //   179	189	253	finally
    //   193	205	253	finally
    //   215	217	253	finally
    //   230	253	253	finally
    //   113	131	257	java/lang/Exception
    //   136	139	257	java/lang/Exception
    //   179	189	257	java/lang/Exception
    //   193	205	257	java/lang/Exception
    //   215	217	257	java/lang/Exception
    //   230	253	257	java/lang/Exception
    //   5	11	261	finally
    //   26	109	261	finally
    //   5	11	267	java/lang/Exception
    //   26	109	267	java/lang/Exception
    //   270	279	294	finally
    //   279	294	294	finally
  }
  
  private static DynamiteModule zze(Context paramContext, String paramString)
  {
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "Selected local version of ".concat(paramString);
    } else {
      paramString = new String("Selected local version of ");
    }
    Log.i("DynamiteModule", paramString);
    return new DynamiteModule(paramContext.getApplicationContext());
  }
  
  /* Error */
  private static zzi zzj(Context paramContext)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 518	com/google/android/gms/dynamite/DynamiteModule:zzig	Lcom/google/android/gms/dynamite/zzi;
    //   6: astore_1
    //   7: aload_1
    //   8: ifnull +8 -> 16
    //   11: ldc 2
    //   13: monitorexit
    //   14: aload_1
    //   15: areturn
    //   16: invokestatic 524	com/google/android/gms/common/GoogleApiAvailabilityLight:getInstance	()Lcom/google/android/gms/common/GoogleApiAvailabilityLight;
    //   19: aload_0
    //   20: invokevirtual 528	com/google/android/gms/common/GoogleApiAvailabilityLight:isGooglePlayServicesAvailable	(Landroid/content/Context;)I
    //   23: ifeq +8 -> 31
    //   26: ldc 2
    //   28: monitorexit
    //   29: aconst_null
    //   30: areturn
    //   31: aload_0
    //   32: ldc_w 318
    //   35: iconst_3
    //   36: invokevirtual 532	android/content/Context:createPackageContext	(Ljava/lang/String;I)Landroid/content/Context;
    //   39: invokevirtual 123	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   42: ldc_w 534
    //   45: invokevirtual 156	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   48: invokevirtual 536	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   51: checkcast 416	android/os/IBinder
    //   54: astore_1
    //   55: aload_1
    //   56: ifnonnull +8 -> 64
    //   59: aconst_null
    //   60: astore_0
    //   61: goto +37 -> 98
    //   64: aload_1
    //   65: ldc_w 538
    //   68: invokeinterface 422 2 0
    //   73: astore_0
    //   74: aload_0
    //   75: instanceof 368
    //   78: ifeq +11 -> 89
    //   81: aload_0
    //   82: checkcast 368	com/google/android/gms/dynamite/zzi
    //   85: astore_0
    //   86: goto +12 -> 98
    //   89: new 540	com/google/android/gms/dynamite/zzj
    //   92: dup
    //   93: aload_1
    //   94: invokespecial 541	com/google/android/gms/dynamite/zzj:<init>	(Landroid/os/IBinder;)V
    //   97: astore_0
    //   98: aload_0
    //   99: ifnull +57 -> 156
    //   102: aload_0
    //   103: putstatic 518	com/google/android/gms/dynamite/DynamiteModule:zzig	Lcom/google/android/gms/dynamite/zzi;
    //   106: ldc 2
    //   108: monitorexit
    //   109: aload_0
    //   110: areturn
    //   111: astore_0
    //   112: aload_0
    //   113: invokevirtual 196	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   116: invokestatic 129	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   119: astore_0
    //   120: aload_0
    //   121: invokevirtual 133	java/lang/String:length	()I
    //   124: ifeq +14 -> 138
    //   127: ldc_w 543
    //   130: aload_0
    //   131: invokevirtual 202	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   134: astore_0
    //   135: goto +14 -> 149
    //   138: new 125	java/lang/String
    //   141: dup
    //   142: ldc_w 543
    //   145: invokespecial 205	java/lang/String:<init>	(Ljava/lang/String;)V
    //   148: astore_0
    //   149: ldc -73
    //   151: aload_0
    //   152: invokestatic 189	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   155: pop
    //   156: ldc 2
    //   158: monitorexit
    //   159: aconst_null
    //   160: areturn
    //   161: astore_0
    //   162: ldc 2
    //   164: monitorexit
    //   165: aload_0
    //   166: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	paramContext	Context
    //   6	88	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   31	55	111	java/lang/Exception
    //   64	86	111	java/lang/Exception
    //   89	98	111	java/lang/Exception
    //   102	106	111	java/lang/Exception
    //   3	7	161	finally
    //   11	14	161	finally
    //   16	29	161	finally
    //   31	55	161	finally
    //   64	86	161	finally
    //   89	98	161	finally
    //   102	106	161	finally
    //   106	109	161	finally
    //   112	135	161	finally
    //   138	149	161	finally
    //   149	156	161	finally
    //   156	159	161	finally
    //   162	165	161	finally
  }
  
  @KeepForSdk
  public final Context getModuleContext()
  {
    return this.zzin;
  }
  
  @KeepForSdk
  public final IBinder instantiate(String paramString)
    throws DynamiteModule.LoadingException
  {
    try
    {
      IBinder localIBinder = (IBinder)this.zzin.getClassLoader().loadClass(paramString).newInstance();
      return localIBinder;
    }
    catch (IllegalAccessException localIllegalAccessException) {}catch (InstantiationException localInstantiationException) {}catch (ClassNotFoundException localClassNotFoundException) {}
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramString = "Failed to instantiate module class: ".concat(paramString);
    } else {
      paramString = new String("Failed to instantiate module class: ");
    }
    throw new LoadingException(paramString, localClassNotFoundException, null);
  }
  
  @DynamiteApi
  public static class DynamiteLoaderClassLoader
  {
    @GuardedBy("DynamiteLoaderClassLoader.class")
    public static ClassLoader sClassLoader;
  }
  
  @KeepForSdk
  public static class LoadingException
    extends Exception
  {
    private LoadingException(String paramString)
    {
      super();
    }
    
    private LoadingException(String paramString, Throwable paramThrowable)
    {
      super(paramThrowable);
    }
  }
  
  public static abstract interface VersionPolicy
  {
    public abstract zzb zza(Context paramContext, String paramString, zza paramzza)
      throws DynamiteModule.LoadingException;
    
    public static abstract interface zza
    {
      public abstract int getLocalVersion(Context paramContext, String paramString);
      
      public abstract int zza(Context paramContext, String paramString, boolean paramBoolean)
        throws DynamiteModule.LoadingException;
    }
    
    public static final class zzb
    {
      public int zzir = 0;
      public int zzis = 0;
      public int zzit = 0;
    }
  }
  
  private static final class zza
  {
    public Cursor zzio;
  }
  
  private static final class zzb
    implements DynamiteModule.VersionPolicy.zza
  {
    private final int zzip;
    private final int zziq;
    
    public zzb(int paramInt1, int paramInt2)
    {
      this.zzip = paramInt1;
      this.zziq = 0;
    }
    
    public final int getLocalVersion(Context paramContext, String paramString)
    {
      return this.zzip;
    }
    
    public final int zza(Context paramContext, String paramString, boolean paramBoolean)
    {
      return 0;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\dynamite\DynamiteModule.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */