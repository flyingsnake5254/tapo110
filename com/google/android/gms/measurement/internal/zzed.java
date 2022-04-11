package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.List;

public abstract interface zzed
  extends IInterface
{
  public abstract void zzd(zzas paramzzas, zzp paramzzp)
    throws RemoteException;
  
  public abstract void zze(zzkq paramzzkq, zzp paramzzp)
    throws RemoteException;
  
  public abstract void zzf(zzp paramzzp)
    throws RemoteException;
  
  public abstract void zzg(zzas paramzzas, String paramString1, @Nullable String paramString2)
    throws RemoteException;
  
  public abstract void zzh(zzp paramzzp)
    throws RemoteException;
  
  @Nullable
  public abstract List<zzkq> zzi(zzp paramzzp, boolean paramBoolean)
    throws RemoteException;
  
  @Nullable
  public abstract byte[] zzj(zzas paramzzas, String paramString)
    throws RemoteException;
  
  public abstract void zzk(long paramLong, @Nullable String paramString1, @Nullable String paramString2, String paramString3)
    throws RemoteException;
  
  @Nullable
  public abstract String zzl(zzp paramzzp)
    throws RemoteException;
  
  public abstract void zzm(zzaa paramzzaa, zzp paramzzp)
    throws RemoteException;
  
  public abstract void zzn(zzaa paramzzaa)
    throws RemoteException;
  
  public abstract List<zzkq> zzo(@Nullable String paramString1, @Nullable String paramString2, boolean paramBoolean, zzp paramzzp)
    throws RemoteException;
  
  public abstract List<zzkq> zzp(String paramString1, @Nullable String paramString2, @Nullable String paramString3, boolean paramBoolean)
    throws RemoteException;
  
  public abstract List<zzaa> zzq(@Nullable String paramString1, @Nullable String paramString2, zzp paramzzp)
    throws RemoteException;
  
  public abstract List<zzaa> zzr(String paramString1, @Nullable String paramString2, @Nullable String paramString3)
    throws RemoteException;
  
  public abstract void zzs(zzp paramzzp)
    throws RemoteException;
  
  public abstract void zzt(Bundle paramBundle, zzp paramzzp)
    throws RemoteException;
  
  public abstract void zzu(zzp paramzzp)
    throws RemoteException;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */