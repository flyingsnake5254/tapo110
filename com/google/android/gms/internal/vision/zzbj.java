package com.google.android.gms.internal.vision;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;

public abstract class zzbj<T>
{
  @SuppressLint({"StaticFieldLeak"})
  private static volatile Context zzg;
  private static final Object zzgg = new Object();
  private static volatile boolean zzgh = false;
  private static final AtomicReference<Collection<zzbj<?>>> zzgi = new AtomicReference();
  private static volatile zzcz<zzcs<zzbf>> zzgj;
  private static final AtomicInteger zzgm = new AtomicInteger();
  private final String name;
  private final zzbp zzgk;
  private final T zzgl;
  private volatile int zzgn = -1;
  private volatile T zzgo;
  private final boolean zzgp;
  
  private zzbj(zzbp paramzzbp, String paramString, T paramT, boolean paramBoolean)
  {
    String str = paramzzbp.zzgu;
    if ((str == null) && (paramzzbp.zzgv == null)) {
      throw new IllegalArgumentException("Must pass a valid SharedPreferences file name or ContentProvider URI");
    }
    if ((str != null) && (paramzzbp.zzgv != null)) {
      throw new IllegalArgumentException("Must pass one of SharedPreferences file name or ContentProvider URI");
    }
    this.zzgk = paramzzbp;
    this.name = paramString;
    this.zzgl = paramT;
    this.zzgp = paramBoolean;
  }
  
  public static void init(Context paramContext)
  {
    synchronized (zzgg)
    {
      Context localContext = paramContext.getApplicationContext();
      if (localContext != null) {
        paramContext = localContext;
      }
      if (zzg != paramContext)
      {
        zzav.zzy();
        zzbo.zzy();
        zzba.zzab();
        zzgj = zzdc.zza(zzbi.zzgf);
        zzg = paramContext;
        zzgm.incrementAndGet();
      }
      return;
    }
  }
  
  public static void maybeInit(Context paramContext)
  {
    if (zzg != null) {
      return;
    }
    synchronized (zzgg)
    {
      if (zzg == null) {
        init(paramContext);
      }
      return;
    }
  }
  
  private static zzbj<Long> zza(zzbp paramzzbp, String paramString, long paramLong, boolean paramBoolean)
  {
    return new zzbl(paramzzbp, paramString, Long.valueOf(paramLong), true);
  }
  
  private static <T> zzbj<T> zza(zzbp paramzzbp, String paramString, T paramT, zzbm<T> paramzzbm, boolean paramBoolean)
  {
    return new zzbn(paramzzbp, paramString, paramT, true, paramzzbm);
  }
  
  private static zzbj<Boolean> zza(zzbp paramzzbp, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    return new zzbk(paramzzbp, paramString, Boolean.valueOf(paramBoolean1), true);
  }
  
  static void zzac()
  {
    zzgm.incrementAndGet();
  }
  
  @Nullable
  private final T zzae()
  {
    boolean bool = this.zzgk.zzha;
    int i = 0;
    int j = i;
    Object localObject;
    if (!bool)
    {
      localObject = (String)zzba.zze(zzg).zzb("gms:phenotype:phenotype_flag:debug_bypass_phenotype");
      int k;
      if ((localObject != null) && (zzaq.zzfc.matcher((CharSequence)localObject).matches())) {
        k = 1;
      } else {
        k = 0;
      }
      j = i;
      if (k != 0) {
        j = 1;
      }
    }
    if (j == 0)
    {
      if (this.zzgk.zzgv != null)
      {
        if (zzbh.zza(zzg, this.zzgk.zzgv))
        {
          if (this.zzgk.zzhb)
          {
            localObject = zzg.getContentResolver();
            String str1 = this.zzgk.zzgv.getLastPathSegment();
            String str2 = zzg.getPackageName();
            StringBuilder localStringBuilder = new StringBuilder(String.valueOf(str1).length() + 1 + String.valueOf(str2).length());
            localStringBuilder.append(str1);
            localStringBuilder.append("#");
            localStringBuilder.append(str2);
            localObject = zzav.zza((ContentResolver)localObject, zzbg.getContentProviderUri(localStringBuilder.toString()));
          }
          else
          {
            localObject = zzav.zza(zzg.getContentResolver(), this.zzgk.zzgv);
          }
        }
        else {
          localObject = null;
        }
      }
      else {
        localObject = zzbo.zzb(zzg, this.zzgk.zzgu);
      }
      if (localObject != null)
      {
        localObject = ((zzaz)localObject).zzb(zzad());
        if (localObject != null) {
          return (T)zza(localObject);
        }
      }
    }
    else if (Log.isLoggable("PhenotypeFlag", 3))
    {
      localObject = String.valueOf(zzad());
      if (((String)localObject).length() != 0) {
        localObject = "Bypass reading Phenotype values for flag: ".concat((String)localObject);
      } else {
        localObject = new String("Bypass reading Phenotype values for flag: ");
      }
      Log.d("PhenotypeFlag", (String)localObject);
    }
    return null;
  }
  
  @Nullable
  private final T zzaf()
  {
    Object localObject = this.zzgk;
    if (!((zzbp)localObject).zzgy)
    {
      localObject = ((zzbp)localObject).zzhc;
      if ((localObject == null) || (((Boolean)((zzcq)localObject).apply(zzg)).booleanValue()))
      {
        zzba localzzba = zzba.zze(zzg);
        localObject = this.zzgk;
        if (((zzbp)localObject).zzgy) {
          localObject = null;
        } else {
          localObject = zze(((zzbp)localObject).zzgw);
        }
        localObject = localzzba.zzb((String)localObject);
        if (localObject != null) {
          return (T)zza(localObject);
        }
      }
    }
    return null;
  }
  
  private final String zze(String paramString)
  {
    if ((paramString != null) && (paramString.isEmpty())) {
      return this.name;
    }
    paramString = String.valueOf(paramString);
    String str = String.valueOf(this.name);
    if (str.length() != 0) {
      return paramString.concat(str);
    }
    return new String(paramString);
  }
  
  public final T get()
  {
    int i = zzgm.get();
    if (this.zzgn < i) {
      try
      {
        if (this.zzgn < i)
        {
          Object localObject1;
          if (zzg != null)
          {
            if (this.zzgk.zzgz)
            {
              localObject1 = zzaf();
              if (localObject1 != null) {
                break label94;
              }
              localObject1 = zzae();
              if (localObject1 != null) {
                break label94;
              }
            }
            else
            {
              localObject1 = zzae();
              if (localObject1 != null) {
                break label94;
              }
              localObject1 = zzaf();
              if (localObject1 != null) {
                break label94;
              }
            }
            localObject1 = this.zzgl;
            label94:
            Object localObject3 = (zzcs)zzgj.get();
            if (((zzcs)localObject3).isPresent())
            {
              localObject1 = (zzbf)((zzcs)localObject3).get();
              localObject3 = this.zzgk;
              localObject1 = ((zzbf)localObject1).zza(((zzbp)localObject3).zzgv, ((zzbp)localObject3).zzgu, ((zzbp)localObject3).zzgx, this.name);
              if (localObject1 == null) {
                localObject1 = this.zzgl;
              } else {
                localObject1 = zza(localObject1);
              }
            }
            this.zzgo = localObject1;
            this.zzgn = i;
          }
          else
          {
            localObject1 = new java/lang/IllegalStateException;
            ((IllegalStateException)localObject1).<init>("Must call PhenotypeFlag.init() first");
            throw ((Throwable)localObject1);
          }
        }
      }
      finally {}
    }
    return (T)this.zzgo;
  }
  
  abstract T zza(Object paramObject);
  
  public final String zzad()
  {
    return zze(this.zzgk.zzgx);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\vision\zzbj.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */