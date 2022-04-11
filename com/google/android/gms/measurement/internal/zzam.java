package com.google.android.gms.measurement.internal;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;
import com.google.android.gms.common.util.Clock;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class zzam
  extends zzgo
{
  private long zza;
  private String zzb;
  private AccountManager zzc;
  private Boolean zzd;
  private long zze;
  
  zzam(zzfu paramzzfu)
  {
    super(paramzzfu);
  }
  
  protected final boolean zza()
  {
    Object localObject1 = Calendar.getInstance();
    this.zza = TimeUnit.MINUTES.convert(((Calendar)localObject1).get(15) + ((Calendar)localObject1).get(16), TimeUnit.MILLISECONDS);
    Object localObject2 = Locale.getDefault();
    localObject1 = ((Locale)localObject2).getLanguage();
    Object localObject3 = Locale.ENGLISH;
    localObject1 = ((String)localObject1).toLowerCase((Locale)localObject3);
    localObject3 = ((Locale)localObject2).getCountry().toLowerCase((Locale)localObject3);
    localObject2 = new StringBuilder(String.valueOf(localObject1).length() + 1 + String.valueOf(localObject3).length());
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("-");
    ((StringBuilder)localObject2).append((String)localObject3);
    this.zzb = ((StringBuilder)localObject2).toString();
    return false;
  }
  
  public final long zzb()
  {
    zzv();
    return this.zza;
  }
  
  public final String zzc()
  {
    zzv();
    return this.zzb;
  }
  
  @WorkerThread
  final long zzd()
  {
    zzg();
    return this.zze;
  }
  
  @WorkerThread
  final void zze()
  {
    zzg();
    this.zzd = null;
    this.zze = 0L;
  }
  
  @WorkerThread
  final boolean zzf()
  {
    zzg();
    long l = this.zzs.zzay().currentTimeMillis();
    if (l - this.zze > 86400000L) {
      this.zzd = null;
    }
    Object localObject = this.zzd;
    if (localObject == null)
    {
      if (ContextCompat.checkSelfPermission(this.zzs.zzax(), "android.permission.GET_ACCOUNTS") != 0)
      {
        this.zzs.zzau().zzf().zza("Permission error checking for dasher/unicorn accounts");
        this.zze = l;
        this.zzd = Boolean.FALSE;
        return false;
      }
      if (this.zzc == null) {
        this.zzc = AccountManager.get(this.zzs.zzax());
      }
      try
      {
        localObject = (Account[])this.zzc.getAccountsByTypeAndFeatures("com.google", new String[] { "service_HOSTED" }, null, null).getResult();
        if ((localObject != null) && (localObject.length > 0))
        {
          this.zzd = Boolean.TRUE;
          this.zze = l;
          return true;
        }
        localObject = (Account[])this.zzc.getAccountsByTypeAndFeatures("com.google", new String[] { "service_uca" }, null, null).getResult();
        if ((localObject == null) || (localObject.length <= 0)) {
          break label238;
        }
        this.zzd = Boolean.TRUE;
        this.zze = l;
        return true;
      }
      catch (OperationCanceledException localOperationCanceledException) {}catch (IOException localIOException) {}catch (AuthenticatorException localAuthenticatorException) {}
      this.zzs.zzau().zzc().zzb("Exception checking account types", localAuthenticatorException);
      label238:
      this.zze = l;
      this.zzd = Boolean.FALSE;
      return false;
    }
    return localAuthenticatorException.booleanValue();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzam.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */