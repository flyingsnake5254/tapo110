package com.google.android.gms.common.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@KeepForSdk
public class WorkSourceUtil
{
  private static final int zzhj = ;
  private static final Method zzhk = zzx();
  private static final Method zzhl = zzy();
  private static final Method zzhm = zzz();
  private static final Method zzhn = zzaa();
  private static final Method zzho = zzab();
  private static final Method zzhp = zzac();
  private static final Method zzhq = zzad();
  
  @Nullable
  @KeepForSdk
  public static WorkSource fromPackage(Context paramContext, @Nullable String paramString)
  {
    if ((paramContext != null) && (paramContext.getPackageManager() != null) && (paramString != null)) {
      try
      {
        paramContext = Wrappers.packageManager(paramContext).getApplicationInfo(paramString, 0);
        if (paramContext == null)
        {
          if (paramString.length() != 0) {
            paramContext = "Could not get applicationInfo from package: ".concat(paramString);
          } else {
            paramContext = new String("Could not get applicationInfo from package: ");
          }
          Log.e("WorkSourceUtil", paramContext);
          return null;
        }
        return zza(paramContext.uid, paramString);
      }
      catch (PackageManager.NameNotFoundException paramContext)
      {
        if (paramString.length() != 0) {
          paramContext = "Could not find package: ".concat(paramString);
        } else {
          paramContext = new String("Could not find package: ");
        }
        Log.e("WorkSourceUtil", paramContext);
      }
    }
    return null;
  }
  
  @KeepForSdk
  public static WorkSource fromPackageAndModuleExperimentalPi(Context paramContext, String paramString1, String paramString2)
  {
    if ((paramContext != null) && (paramContext.getPackageManager() != null) && (paramString2 != null) && (paramString1 != null))
    {
      int i = zzd(paramContext, paramString1);
      if (i < 0) {
        return null;
      }
      paramContext = new WorkSource();
      Object localObject = zzhp;
      if (localObject != null)
      {
        Method localMethod = zzhq;
        if (localMethod != null) {
          try
          {
            localObject = ((Method)localObject).invoke(paramContext, new Object[0]);
            int j = zzhj;
            if (i != j) {
              localMethod.invoke(localObject, new Object[] { Integer.valueOf(i), paramString1 });
            }
            localMethod.invoke(localObject, new Object[] { Integer.valueOf(j), paramString2 });
          }
          catch (Exception paramString1)
          {
            Log.w("WorkSourceUtil", "Unable to assign chained blame through WorkSource", paramString1);
          }
        }
      }
      zza(paramContext, i, paramString1);
      return paramContext;
    }
    Log.w("WorkSourceUtil", "Unexpected null arguments");
    return null;
  }
  
  @KeepForSdk
  public static List<String> getNames(@Nullable WorkSource paramWorkSource)
  {
    int i = 0;
    int j;
    if (paramWorkSource == null) {
      j = 0;
    } else {
      j = zza(paramWorkSource);
    }
    if (j == 0) {
      return Collections.emptyList();
    }
    ArrayList localArrayList = new ArrayList();
    while (i < j)
    {
      String str = zza(paramWorkSource, i);
      if (!Strings.isEmptyOrWhitespace(str)) {
        localArrayList.add(str);
      }
      i++;
    }
    return localArrayList;
  }
  
  @KeepForSdk
  public static boolean hasWorkSourcePermission(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (paramContext.getPackageManager() == null) {
      return false;
    }
    return Wrappers.packageManager(paramContext).checkPermission("android.permission.UPDATE_DEVICE_STATS", paramContext.getPackageName()) == 0;
  }
  
  private static int zza(WorkSource paramWorkSource)
  {
    Method localMethod = zzhm;
    if (localMethod != null) {
      try
      {
        int i = ((Integer)localMethod.invoke(paramWorkSource, new Object[0])).intValue();
        return i;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
      }
    }
    return 0;
  }
  
  private static WorkSource zza(int paramInt, String paramString)
  {
    WorkSource localWorkSource = new WorkSource();
    zza(localWorkSource, paramInt, paramString);
    return localWorkSource;
  }
  
  @Nullable
  private static String zza(WorkSource paramWorkSource, int paramInt)
  {
    Method localMethod = zzho;
    if (localMethod != null) {
      try
      {
        paramWorkSource = (String)localMethod.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt) });
        return paramWorkSource;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
      }
    }
    return null;
  }
  
  private static void zza(WorkSource paramWorkSource, int paramInt, @Nullable String paramString)
  {
    Method localMethod = zzhl;
    if (localMethod != null)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      try
      {
        localMethod.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt), str });
        return;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
        return;
      }
    }
    paramString = zzhk;
    if (paramString != null) {
      try
      {
        paramString.invoke(paramWorkSource, new Object[] { Integer.valueOf(paramInt) });
        return;
      }
      catch (Exception paramWorkSource)
      {
        Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", paramWorkSource);
      }
    }
  }
  
  private static Method zzaa()
  {
    Method localMethod2;
    try
    {
      Method localMethod1 = WorkSource.class.getMethod("get", new Class[] { Integer.TYPE });
    }
    catch (Exception localException)
    {
      localMethod2 = null;
    }
    return localMethod2;
  }
  
  private static Method zzab()
  {
    if (PlatformVersion.isAtLeastJellyBeanMR2()) {}
    try
    {
      localMethod = WorkSource.class.getMethod("getName", new Class[] { Integer.TYPE });
    }
    catch (Exception localException)
    {
      Method localMethod;
      for (;;) {}
    }
    localMethod = null;
    return localMethod;
  }
  
  private static final Method zzac()
  {
    Method localMethod2;
    if (PlatformVersion.isAtLeastP()) {
      try
      {
        Method localMethod1 = WorkSource.class.getMethod("createWorkChain", new Class[0]);
      }
      catch (Exception localException)
      {
        Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", localException);
      }
    } else {
      localMethod2 = null;
    }
    return localMethod2;
  }
  
  @SuppressLint({"PrivateApi"})
  private static final Method zzad()
  {
    Method localMethod2;
    if (PlatformVersion.isAtLeastP()) {
      try
      {
        Method localMethod1 = Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", new Class[] { Integer.TYPE, String.class });
      }
      catch (Exception localException)
      {
        Log.w("WorkSourceUtil", "Missing WorkChain class", localException);
      }
    } else {
      localMethod2 = null;
    }
    return localMethod2;
  }
  
  private static int zzd(Context paramContext, String paramString)
  {
    try
    {
      paramContext = Wrappers.packageManager(paramContext).getApplicationInfo(paramString, 0);
      if (paramContext == null)
      {
        paramContext = String.valueOf(paramString);
        if (paramContext.length() != 0) {
          paramContext = "Could not get applicationInfo from package: ".concat(paramContext);
        } else {
          paramContext = new String("Could not get applicationInfo from package: ");
        }
        Log.e("WorkSourceUtil", paramContext);
        return -1;
      }
      return paramContext.uid;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      paramContext = String.valueOf(paramString);
      if (paramContext.length() != 0) {
        paramContext = "Could not find package: ".concat(paramContext);
      } else {
        paramContext = new String("Could not find package: ");
      }
      Log.e("WorkSourceUtil", paramContext);
    }
    return -1;
  }
  
  private static Method zzx()
  {
    Method localMethod2;
    try
    {
      Method localMethod1 = WorkSource.class.getMethod("add", new Class[] { Integer.TYPE });
    }
    catch (Exception localException)
    {
      localMethod2 = null;
    }
    return localMethod2;
  }
  
  private static Method zzy()
  {
    if (PlatformVersion.isAtLeastJellyBeanMR2()) {}
    try
    {
      localMethod = WorkSource.class.getMethod("add", new Class[] { Integer.TYPE, String.class });
    }
    catch (Exception localException)
    {
      Method localMethod;
      for (;;) {}
    }
    localMethod = null;
    return localMethod;
  }
  
  private static Method zzz()
  {
    Method localMethod2;
    try
    {
      Method localMethod1 = WorkSource.class.getMethod("size", new Class[0]);
    }
    catch (Exception localException)
    {
      localMethod2 = null;
    }
    return localMethod2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\util\WorkSourceUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */