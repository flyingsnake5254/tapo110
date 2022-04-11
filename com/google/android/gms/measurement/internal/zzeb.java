package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.measurement.zzbm;
import com.google.android.gms.internal.measurement.zzbo;
import java.util.List;

public final class zzeb
  extends zzbm
  implements zzed
{
  zzeb(IBinder paramIBinder)
  {
    super(paramIBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
  }
  
  public final void zzd(zzas paramzzas, zzp paramzzp)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzbo.zzd(localParcel, paramzzas);
    zzbo.zzd(localParcel, paramzzp);
    zzc(1, localParcel);
  }
  
  public final void zze(zzkq paramzzkq, zzp paramzzp)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzbo.zzd(localParcel, paramzzkq);
    zzbo.zzd(localParcel, paramzzp);
    zzc(2, localParcel);
  }
  
  public final void zzf(zzp paramzzp)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzbo.zzd(localParcel, paramzzp);
    zzc(4, localParcel);
  }
  
  public final void zzg(zzas paramzzas, String paramString1, String paramString2)
    throws RemoteException
  {
    throw null;
  }
  
  public final void zzh(zzp paramzzp)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzbo.zzd(localParcel, paramzzp);
    zzc(6, localParcel);
  }
  
  public final List<zzkq> zzi(zzp paramzzp, boolean paramBoolean)
    throws RemoteException
  {
    Object localObject = zza();
    zzbo.zzd((Parcel)localObject, paramzzp);
    zzbo.zzb((Parcel)localObject, paramBoolean);
    paramzzp = zzC(7, (Parcel)localObject);
    localObject = paramzzp.createTypedArrayList(zzkq.CREATOR);
    paramzzp.recycle();
    return (List<zzkq>)localObject;
  }
  
  public final byte[] zzj(zzas paramzzas, String paramString)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzbo.zzd(localParcel, paramzzas);
    localParcel.writeString(paramString);
    paramString = zzC(9, localParcel);
    paramzzas = paramString.createByteArray();
    paramString.recycle();
    return paramzzas;
  }
  
  public final void zzk(long paramLong, String paramString1, String paramString2, String paramString3)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeLong(paramLong);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    localParcel.writeString(paramString3);
    zzc(10, localParcel);
  }
  
  public final String zzl(zzp paramzzp)
    throws RemoteException
  {
    Object localObject = zza();
    zzbo.zzd((Parcel)localObject, paramzzp);
    paramzzp = zzC(11, (Parcel)localObject);
    localObject = paramzzp.readString();
    paramzzp.recycle();
    return (String)localObject;
  }
  
  public final void zzm(zzaa paramzzaa, zzp paramzzp)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzbo.zzd(localParcel, paramzzaa);
    zzbo.zzd(localParcel, paramzzp);
    zzc(12, localParcel);
  }
  
  public final void zzn(zzaa paramzzaa)
    throws RemoteException
  {
    throw null;
  }
  
  public final List<zzkq> zzo(String paramString1, String paramString2, boolean paramBoolean, zzp paramzzp)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzbo.zzb(localParcel, paramBoolean);
    zzbo.zzd(localParcel, paramzzp);
    paramString1 = zzC(14, localParcel);
    paramString2 = paramString1.createTypedArrayList(zzkq.CREATOR);
    paramString1.recycle();
    return paramString2;
  }
  
  public final List<zzkq> zzp(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    throws RemoteException
  {
    paramString1 = zza();
    paramString1.writeString(null);
    paramString1.writeString(paramString2);
    paramString1.writeString(paramString3);
    zzbo.zzb(paramString1, paramBoolean);
    paramString1 = zzC(15, paramString1);
    paramString2 = paramString1.createTypedArrayList(zzkq.CREATOR);
    paramString1.recycle();
    return paramString2;
  }
  
  public final List<zzaa> zzq(String paramString1, String paramString2, zzp paramzzp)
    throws RemoteException
  {
    Parcel localParcel = zza();
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzbo.zzd(localParcel, paramzzp);
    paramString2 = zzC(16, localParcel);
    paramString1 = paramString2.createTypedArrayList(zzaa.CREATOR);
    paramString2.recycle();
    return paramString1;
  }
  
  public final List<zzaa> zzr(String paramString1, String paramString2, String paramString3)
    throws RemoteException
  {
    paramString1 = zza();
    paramString1.writeString(null);
    paramString1.writeString(paramString2);
    paramString1.writeString(paramString3);
    paramString1 = zzC(17, paramString1);
    paramString2 = paramString1.createTypedArrayList(zzaa.CREATOR);
    paramString1.recycle();
    return paramString2;
  }
  
  public final void zzs(zzp paramzzp)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzbo.zzd(localParcel, paramzzp);
    zzc(18, localParcel);
  }
  
  public final void zzt(Bundle paramBundle, zzp paramzzp)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzbo.zzd(localParcel, paramBundle);
    zzbo.zzd(localParcel, paramzzp);
    zzc(19, localParcel);
  }
  
  public final void zzu(zzp paramzzp)
    throws RemoteException
  {
    Parcel localParcel = zza();
    zzbo.zzd(localParcel, paramzzp);
    zzc(20, localParcel);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\measurement\internal\zzeb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */