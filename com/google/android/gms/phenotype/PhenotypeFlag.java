package com.google.android.gms.phenotype;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.UserManager;
import android.util.Log;
import androidx.core.content.PermissionChecker;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.phenotype.zzh;
import javax.annotation.Nullable;

@Deprecated
@KeepForSdk
public abstract class PhenotypeFlag<T>
{
  private static final Object zzak = new Object();
  @SuppressLint({"StaticFieldLeak"})
  private static Context zzal;
  private static boolean zzam = false;
  private static Boolean zzan;
  private final Factory zzao;
  final String zzap;
  private final String zzaq;
  private final T zzar;
  private T zzas = null;
  
  private PhenotypeFlag(Factory paramFactory, String paramString, T paramT)
  {
    if ((Factory.zza(paramFactory) == null) && (Factory.zzb(paramFactory) == null)) {
      throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }
    if ((Factory.zza(paramFactory) != null) && (Factory.zzb(paramFactory) != null)) {
      throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
    }
    this.zzao = paramFactory;
    String str1 = String.valueOf(Factory.zzc(paramFactory));
    String str2 = String.valueOf(paramString);
    if (str2.length() != 0) {
      str1 = str1.concat(str2);
    } else {
      str1 = new String(str1);
    }
    this.zzaq = str1;
    paramFactory = String.valueOf(Factory.zzd(paramFactory));
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      paramFactory = paramFactory.concat(paramString);
    } else {
      paramFactory = new String(paramFactory);
    }
    this.zzap = paramFactory;
    this.zzar = paramT;
  }
  
  @KeepForSdk
  public static void maybeInit(Context paramContext)
  {
    zzh.maybeInit(paramContext);
    if (zzal == null)
    {
      zzh.init(paramContext);
      synchronized (zzak)
      {
        if ((Build.VERSION.SDK_INT < 24) || (!paramContext.isDeviceProtectedStorage()))
        {
          Context localContext = paramContext.getApplicationContext();
          if (localContext != null) {
            paramContext = localContext;
          }
        }
        if (zzal != paramContext) {
          zzan = null;
        }
        zzal = paramContext;
        zzam = false;
      }
    }
  }
  
  private static PhenotypeFlag<String> zza(Factory paramFactory, String paramString1, String paramString2)
  {
    return new zzs(paramFactory, paramString1, paramString2);
  }
  
  private static <V> V zza(zza<V> paramzza)
  {
    long l;
    try
    {
      Object localObject = paramzza.zzh();
      paramzza = (zza<V>)localObject;
    }
    catch (SecurityException localSecurityException)
    {
      l = Binder.clearCallingIdentity();
    }
    try
    {
      paramzza = paramzza.zzh();
      return paramzza;
    }
    finally
    {
      Binder.restoreCallingIdentity(l);
    }
  }
  
  static boolean zza(String paramString, boolean paramBoolean)
  {
    if (zzf()) {
      return ((Boolean)zza(new zzq(paramString, false))).booleanValue();
    }
    return false;
  }
  
  @Nullable
  @TargetApi(24)
  private final T zzd()
  {
    Object localObject;
    if (!zza("gms:phenotype:phenotype_flag:debug_bypass_phenotype", false))
    {
      if (Factory.zzb(this.zzao) != null)
      {
        localObject = (String)zza(new zzo(this, zza.zza(zzal.getContentResolver(), Factory.zzb(this.zzao))));
        if (localObject != null) {
          return (T)zza((String)localObject);
        }
      }
      else if (Factory.zza(this.zzao) != null)
      {
        if ((Build.VERSION.SDK_INT >= 24) && (!zzal.isDeviceProtectedStorage()) && (!((UserManager)zzal.getSystemService(UserManager.class)).isUserUnlocked())) {
          return null;
        }
        localObject = zzal.getSharedPreferences(Factory.zza(this.zzao), 0);
        if (((SharedPreferences)localObject).contains(this.zzap)) {
          return (T)zza((SharedPreferences)localObject);
        }
      }
    }
    else
    {
      localObject = String.valueOf(this.zzap);
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
  private final T zze()
  {
    if ((!Factory.zzf(this.zzao)) && (zzf()))
    {
      String str = (String)zza(new zzp(this));
      if (str != null) {
        return (T)zza(str);
      }
    }
    return null;
  }
  
  private static boolean zzf()
  {
    if (zzan == null)
    {
      Context localContext = zzal;
      boolean bool = false;
      if (localContext != null)
      {
        if (PermissionChecker.checkCallingOrSelfPermission(localContext, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0) {
          bool = true;
        }
        zzan = Boolean.valueOf(bool);
      }
      else
      {
        return false;
      }
    }
    return zzan.booleanValue();
  }
  
  @KeepForSdk
  public T get()
  {
    if (zzal != null)
    {
      Object localObject;
      if (Factory.zze(this.zzao))
      {
        localObject = zze();
        if (localObject != null) {
          return (T)localObject;
        }
        localObject = zzd();
        if (localObject != null) {
          return (T)localObject;
        }
      }
      else
      {
        localObject = zzd();
        if (localObject != null) {
          return (T)localObject;
        }
        localObject = zze();
        if (localObject != null) {
          return (T)localObject;
        }
      }
      return (T)this.zzar;
    }
    throw new IllegalStateException("Must call PhenotypeFlag.init() first");
  }
  
  public abstract T zza(SharedPreferences paramSharedPreferences);
  
  public abstract T zza(String paramString);
  
  @KeepForSdk
  public static class Factory
  {
    private final String zzax;
    private final Uri zzay;
    private final String zzaz;
    private final String zzba;
    private final boolean zzbb;
    private final boolean zzbc;
    
    @KeepForSdk
    public Factory(Uri paramUri)
    {
      this(null, paramUri, "", "", false, false);
    }
    
    private Factory(String paramString1, Uri paramUri, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.zzax = paramString1;
      this.zzay = paramUri;
      this.zzaz = paramString2;
      this.zzba = paramString3;
      this.zzbb = paramBoolean1;
      this.zzbc = paramBoolean2;
    }
    
    @KeepForSdk
    public PhenotypeFlag<String> createFlag(String paramString1, String paramString2)
    {
      return PhenotypeFlag.zzb(this, paramString1, paramString2);
    }
    
    @KeepForSdk
    public Factory withGservicePrefix(String paramString)
    {
      boolean bool = this.zzbb;
      if (!bool) {
        return new Factory(this.zzax, this.zzay, paramString, this.zzba, bool, this.zzbc);
      }
      throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }
    
    @KeepForSdk
    public Factory withPhenotypePrefix(String paramString)
    {
      return new Factory(this.zzax, this.zzay, this.zzaz, paramString, this.zzbb, this.zzbc);
    }
  }
  
  static abstract interface zza<V>
  {
    public abstract V zzh();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\phenotype\PhenotypeFlag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */