package com.google.android.gms.measurement.internal;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

public final class zzem
  extends zzgo
{
  private char zza = (char)0;
  private long zzb = -1L;
  @GuardedBy("this")
  private String zzc;
  private final zzek zzd = new zzek(this, 6, false, false);
  private final zzek zze = new zzek(this, 6, true, false);
  private final zzek zzf = new zzek(this, 6, false, true);
  private final zzek zzg = new zzek(this, 5, false, false);
  private final zzek zzh = new zzek(this, 5, true, false);
  private final zzek zzi = new zzek(this, 5, false, true);
  private final zzek zzj = new zzek(this, 4, false, false);
  private final zzek zzk = new zzek(this, 3, false, false);
  private final zzek zzl = new zzek(this, 2, false, false);
  
  zzem(zzfu paramzzfu)
  {
    super(paramzzfu);
  }
  
  protected static Object zzl(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return new zzel(paramString);
  }
  
  static String zzo(boolean paramBoolean, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    String str1 = "";
    String str2 = paramString;
    if (paramString == null) {
      str2 = "";
    }
    String str3 = zzp(paramBoolean, paramObject1);
    String str4 = zzp(paramBoolean, paramObject2);
    String str5 = zzp(paramBoolean, paramObject3);
    paramObject3 = new StringBuilder();
    paramString = str1;
    if (!TextUtils.isEmpty(str2))
    {
      ((StringBuilder)paramObject3).append(str2);
      paramString = ": ";
    }
    paramBoolean = TextUtils.isEmpty(str3);
    paramObject2 = ", ";
    paramObject1 = paramString;
    if (!paramBoolean)
    {
      ((StringBuilder)paramObject3).append(paramString);
      ((StringBuilder)paramObject3).append(str3);
      paramObject1 = ", ";
    }
    if (!TextUtils.isEmpty(str4))
    {
      ((StringBuilder)paramObject3).append((String)paramObject1);
      ((StringBuilder)paramObject3).append(str4);
      paramString = (String)paramObject2;
    }
    else
    {
      paramString = (String)paramObject1;
    }
    if (!TextUtils.isEmpty(str5))
    {
      ((StringBuilder)paramObject3).append(paramString);
      ((StringBuilder)paramObject3).append(str5);
    }
    return ((StringBuilder)paramObject3).toString();
  }
  
  @VisibleForTesting
  static String zzp(boolean paramBoolean, Object paramObject)
  {
    Object localObject1 = "";
    if (paramObject == null) {
      return "";
    }
    Object localObject2 = paramObject;
    if ((paramObject instanceof Integer)) {
      localObject2 = Long.valueOf(((Integer)paramObject).intValue());
    }
    boolean bool = localObject2 instanceof Long;
    int i = 0;
    Object localObject3;
    if (bool)
    {
      if (!paramBoolean) {
        return String.valueOf(localObject2);
      }
      localObject3 = (Long)localObject2;
      if (Math.abs(((Long)localObject3).longValue()) < 100L) {
        return String.valueOf(localObject2);
      }
      paramObject = localObject1;
      if (String.valueOf(localObject2).charAt(0) == '-') {
        paramObject = "-";
      }
      localObject2 = String.valueOf(Math.abs(((Long)localObject3).longValue()));
      long l1 = Math.round(Math.pow(10.0D, ((String)localObject2).length() - 1));
      long l2 = Math.round(Math.pow(10.0D, ((String)localObject2).length()) - 1.0D);
      localObject2 = new StringBuilder(((String)paramObject).length() + 43 + ((String)paramObject).length());
      ((StringBuilder)localObject2).append((String)paramObject);
      ((StringBuilder)localObject2).append(l1);
      ((StringBuilder)localObject2).append("...");
      ((StringBuilder)localObject2).append((String)paramObject);
      ((StringBuilder)localObject2).append(l2);
      return ((StringBuilder)localObject2).toString();
    }
    if ((localObject2 instanceof Boolean)) {
      return String.valueOf(localObject2);
    }
    if ((localObject2 instanceof Throwable))
    {
      localObject2 = (Throwable)localObject2;
      if (paramBoolean) {
        paramObject = localObject2.getClass().getName();
      } else {
        paramObject = ((Throwable)localObject2).toString();
      }
      localObject1 = new StringBuilder((String)paramObject);
      paramObject = zzz(zzfu.class.getCanonicalName());
      localObject3 = ((Throwable)localObject2).getStackTrace();
      int j = localObject3.length;
      while (i < j)
      {
        localObject2 = localObject3[i];
        if (!((StackTraceElement)localObject2).isNativeMethod())
        {
          String str = ((StackTraceElement)localObject2).getClassName();
          if ((str != null) && (zzz(str).equals(paramObject)))
          {
            ((StringBuilder)localObject1).append(": ");
            ((StringBuilder)localObject1).append(localObject2);
            break;
          }
        }
        i++;
      }
      return ((StringBuilder)localObject1).toString();
    }
    if ((localObject2 instanceof zzel)) {
      return zzel.zza((zzel)localObject2);
    }
    if (paramBoolean) {
      return "-";
    }
    return String.valueOf(localObject2);
  }
  
  private static String zzz(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    int i = paramString.lastIndexOf('.');
    if (i == -1) {
      return paramString;
    }
    return paramString.substring(0, i);
  }
  
  protected final boolean zza()
  {
    return false;
  }
  
  public final zzek zzb()
  {
    return this.zzd;
  }
  
  public final zzek zzc()
  {
    return this.zze;
  }
  
  public final zzek zzd()
  {
    return this.zzf;
  }
  
  public final zzek zze()
  {
    return this.zzg;
  }
  
  public final zzek zzf()
  {
    return this.zzh;
  }
  
  public final zzek zzh()
  {
    return this.zzi;
  }
  
  public final zzek zzi()
  {
    return this.zzj;
  }
  
  public final zzek zzj()
  {
    return this.zzk;
  }
  
  public final zzek zzk()
  {
    return this.zzl;
  }
  
  protected final void zzm(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    Object localObject;
    if ((!paramBoolean1) && (Log.isLoggable(zzn(), paramInt)))
    {
      localObject = zzo(false, paramString, paramObject1, paramObject2, paramObject3);
      Log.println(paramInt, zzn(), (String)localObject);
    }
    if ((!paramBoolean2) && (paramInt >= 5))
    {
      Preconditions.checkNotNull(paramString);
      localObject = this.zzs.zzj();
      if (localObject == null)
      {
        Log.println(6, zzn(), "Scheduler not set. Not logging error/warn");
        return;
      }
      if (!((zzgo)localObject).zzu())
      {
        Log.println(6, zzn(), "Scheduler not initialized. Not logging error/warn");
        return;
      }
      if (paramInt >= 9) {
        paramInt = 8;
      }
      ((zzfr)localObject).zzh(new zzej(this, paramInt, paramString, paramObject1, paramObject2, paramObject3));
    }
  }
  
  @EnsuresNonNull({"logTagDoNotUseDirectly"})
  @VisibleForTesting
  protected final String zzn()
  {
    try
    {
      if (this.zzc == null) {
        if (this.zzs.zzt() != null) {
          this.zzc = this.zzs.zzt();
        } else {
          this.zzc = this.zzs.zzc().zzb();
        }
      }
      Preconditions.checkNotNull(this.zzc);
      String str = this.zzc;
      return str;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */