package com.google.android.gms.internal.clearcut;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.UserManager;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import javax.annotation.Nullable;

public abstract class zzae<T>
{
  private static final Object zzdn = new Object();
  private static boolean zzdo = false;
  private static volatile Boolean zzdp;
  private static volatile Boolean zzdq;
  @SuppressLint({"StaticFieldLeak"})
  private static Context zzh;
  private final zzao zzdr;
  final String zzds;
  private final String zzdt;
  private final T zzdu;
  private T zzdv = null;
  private volatile zzab zzdw = null;
  private volatile SharedPreferences zzdx = null;
  
  private zzae(zzao paramzzao, String paramString, T paramT)
  {
    if ((zzao.zza(paramzzao) == null) && (zzao.zzb(paramzzao) == null)) {
      throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }
    if ((zzao.zza(paramzzao) != null) && (zzao.zzb(paramzzao) != null)) {
      throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
    }
    this.zzdr = paramzzao;
    String str1 = String.valueOf(zzao.zzc(paramzzao));
    String str2 = String.valueOf(paramString);
    if (str2.length() != 0) {
      str2 = str1.concat(str2);
    } else {
      str2 = new String(str1);
    }
    this.zzdt = str2;
    paramzzao = String.valueOf(zzao.zzd(paramzzao));
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramzzao = paramzzao.concat(paramString);
    } else {
      paramzzao = new String(paramzzao);
    }
    this.zzds = paramzzao;
    this.zzdu = paramT;
  }
  
  public static void maybeInit(Context paramContext)
  {
    if (zzh == null) {
      synchronized (zzdn)
      {
        if ((Build.VERSION.SDK_INT < 24) || (!paramContext.isDeviceProtectedStorage()))
        {
          Context localContext = paramContext.getApplicationContext();
          if (localContext != null) {
            paramContext = localContext;
          }
        }
        if (zzh != paramContext) {
          zzdp = null;
        }
        zzh = paramContext;
        zzdo = false;
      }
    }
  }
  
  private static <T> zzae<T> zza(zzao paramzzao, String paramString, T paramT, zzan<T> paramzzan)
  {
    return new zzal(paramzzao, paramString, paramT, paramzzan);
  }
  
  private static zzae<String> zza(zzao paramzzao, String paramString1, String paramString2)
  {
    return new zzak(paramzzao, paramString1, paramString2);
  }
  
  private static zzae<Boolean> zza(zzao paramzzao, String paramString, boolean paramBoolean)
  {
    return new zzaj(paramzzao, paramString, Boolean.valueOf(paramBoolean));
  }
  
  private static <V> V zza(zzam<V> paramzzam)
  {
    long l;
    try
    {
      Object localObject = paramzzam.zzp();
      paramzzam = (zzam<V>)localObject;
    }
    catch (SecurityException localSecurityException)
    {
      l = Binder.clearCallingIdentity();
    }
    try
    {
      paramzzam = paramzzam.zzp();
      return paramzzam;
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
  }
  
  static boolean zza(String paramString, boolean paramBoolean)
  {
    if (zzn()) {
      return ((Boolean)zza(new zzah(paramString, false))).booleanValue();
    }
    return false;
  }
  
  @Nullable
  @TargetApi(24)
  private final T zzl()
  {
    Object localObject;
    if (!zza("gms:phenotype:phenotype_flag:debug_bypass_phenotype", false))
    {
      if (zzao.zzb(this.zzdr) != null)
      {
        if (this.zzdw == null) {
          this.zzdw = zzab.zza(zzh.getContentResolver(), zzao.zzb(this.zzdr));
        }
        localObject = (String)zza(new zzaf(this, this.zzdw));
        if (localObject != null) {
          return (T)zzb((String)localObject);
        }
      }
      else if (zzao.zza(this.zzdr) != null)
      {
        boolean bool;
        if ((Build.VERSION.SDK_INT >= 24) && (!zzh.isDeviceProtectedStorage()))
        {
          if ((zzdq == null) || (!zzdq.booleanValue())) {
            zzdq = Boolean.valueOf(((UserManager)zzh.getSystemService(UserManager.class)).isUserUnlocked());
          }
          bool = zzdq.booleanValue();
        }
        else
        {
          bool = true;
        }
        if (!bool) {
          return null;
        }
        if (this.zzdx == null) {
          this.zzdx = zzh.getSharedPreferences(zzao.zza(this.zzdr), 0);
        }
        localObject = this.zzdx;
        if (((SharedPreferences)localObject).contains(this.zzds)) {
          return (T)zza((SharedPreferences)localObject);
        }
      }
    }
    else
    {
      localObject = String.valueOf(this.zzds);
      if (((String)localObject).length() != 0) {
        localObject = "Bypass reading Phenotype values for flag: ".concat((String)localObject);
      } else {
        localObject = new String("Bypass reading Phenotype values for flag: ");
      }
      Log.w("PhenotypeFlag", (String)localObject);
    }
    return null;
  }
  
  @Nullable
  private final T zzm()
  {
    if ((!zzao.zzf(this.zzdr)) && (zzn()))
    {
      String str = (String)zza(new zzag(this));
      if (str != null) {
        return (T)zzb(str);
      }
    }
    return null;
  }
  
  private static boolean zzn()
  {
    if (zzdp == null)
    {
      Context localContext = zzh;
      boolean bool = false;
      if (localContext != null)
      {
        if (PermissionChecker.checkCallingOrSelfPermission(localContext, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
          bool = true;
        }
        zzdp = Boolean.valueOf(bool);
      }
      else
      {
        return false;
      }
    }
    return zzdp.booleanValue();
  }
  
  public final T get()
  {
    if (zzh != null)
    {
      Object localObject;
      if (zzao.zze(this.zzdr))
      {
        localObject = zzm();
        if (localObject != null) {
          return (T)localObject;
        }
        localObject = zzl();
        if (localObject != null) {
          return (T)localObject;
        }
      }
      else
      {
        localObject = zzl();
        if (localObject != null) {
          return (T)localObject;
        }
        localObject = zzm();
        if (localObject != null) {
          return (T)localObject;
        }
      }
      return (T)this.zzdu;
    }
    throw new IllegalStateException("Must call PhenotypeFlag.init() first");
  }
  
  protected abstract T zza(SharedPreferences paramSharedPreferences);
  
  protected abstract T zzb(String paramString);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\clearcut\zzae.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */