package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

public final class zzb
  extends zze
  implements zzd
{
  zzb(IBinder paramIBinder)
  {
    super(paramIBinder, "com.android.vending.billing.IInAppBillingService");
  }
  
  public final int zza(int paramInt, String paramString1, String paramString2)
    throws RemoteException
  {
    Parcel localParcel = zzo();
    localParcel.writeInt(paramInt);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    paramString1 = zzp(1, localParcel);
    paramInt = paramString1.readInt();
    paramString1.recycle();
    return paramInt;
  }
  
  public final Bundle zzb(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = zzo();
    localParcel.writeInt(3);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzg.zzb(localParcel, paramBundle);
    paramString2 = zzp(2, localParcel);
    paramString1 = (Bundle)zzg.zza(paramString2, Bundle.CREATOR);
    paramString2.recycle();
    return paramString1;
  }
  
  public final Bundle zzc(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
    throws RemoteException
  {
    paramString4 = zzo();
    paramString4.writeInt(3);
    paramString4.writeString(paramString1);
    paramString4.writeString(paramString2);
    paramString4.writeString(paramString3);
    paramString4.writeString(null);
    paramString2 = zzp(3, paramString4);
    paramString1 = (Bundle)zzg.zza(paramString2, Bundle.CREATOR);
    paramString2.recycle();
    return paramString1;
  }
  
  public final Bundle zzd(int paramInt, String paramString1, String paramString2, String paramString3)
    throws RemoteException
  {
    Parcel localParcel = zzo();
    localParcel.writeInt(3);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    localParcel.writeString(paramString3);
    paramString2 = zzp(4, localParcel);
    paramString1 = (Bundle)zzg.zza(paramString2, Bundle.CREATOR);
    paramString2.recycle();
    return paramString1;
  }
  
  public final int zze(int paramInt, String paramString1, String paramString2)
    throws RemoteException
  {
    Parcel localParcel = zzo();
    localParcel.writeInt(3);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    paramString1 = zzp(5, localParcel);
    paramInt = paramString1.readInt();
    paramString1.recycle();
    return paramInt;
  }
  
  public final Bundle zzf(int paramInt, String paramString1, List<String> paramList, String paramString2, String paramString3, String paramString4)
    throws RemoteException
  {
    paramString3 = zzo();
    paramString3.writeInt(5);
    paramString3.writeString(paramString1);
    paramString3.writeStringList(paramList);
    paramString3.writeString(paramString2);
    paramString3.writeString("subs");
    paramString3.writeString(null);
    paramList = zzp(7, paramString3);
    paramString1 = (Bundle)zzg.zza(paramList, Bundle.CREATOR);
    paramList.recycle();
    return paramString1;
  }
  
  public final Bundle zzg(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, Bundle paramBundle)
    throws RemoteException
  {
    paramString4 = zzo();
    paramString4.writeInt(paramInt);
    paramString4.writeString(paramString1);
    paramString4.writeString(paramString2);
    paramString4.writeString(paramString3);
    paramString4.writeString(null);
    zzg.zzb(paramString4, paramBundle);
    paramString1 = zzp(8, paramString4);
    paramString2 = (Bundle)zzg.zza(paramString1, Bundle.CREATOR);
    paramString1.recycle();
    return paramString2;
  }
  
  public final Bundle zzh(int paramInt, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = zzo();
    localParcel.writeInt(6);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    localParcel.writeString(paramString3);
    zzg.zzb(localParcel, paramBundle);
    paramString2 = zzp(9, localParcel);
    paramString1 = (Bundle)zzg.zza(paramString2, Bundle.CREATOR);
    paramString2.recycle();
    return paramString1;
  }
  
  public final int zzi(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = zzo();
    localParcel.writeInt(7);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzg.zzb(localParcel, paramBundle);
    paramString1 = zzp(10, localParcel);
    paramInt = paramString1.readInt();
    paramString1.recycle();
    return paramInt;
  }
  
  public final Bundle zzj(int paramInt, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
    throws RemoteException
  {
    paramString3 = zzo();
    paramString3.writeInt(8);
    paramString3.writeString(paramString1);
    paramString3.writeString(paramString2);
    paramString3.writeString("subs");
    zzg.zzb(paramString3, paramBundle);
    paramString2 = zzp(801, paramString3);
    paramString1 = (Bundle)zzg.zza(paramString2, Bundle.CREATOR);
    paramString2.recycle();
    return paramString1;
  }
  
  public final Bundle zzk(int paramInt, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = zzo();
    localParcel.writeInt(9);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    localParcel.writeString(paramString3);
    zzg.zzb(localParcel, paramBundle);
    paramString2 = zzp(11, localParcel);
    paramString1 = (Bundle)zzg.zza(paramString2, Bundle.CREATOR);
    paramString2.recycle();
    return paramString1;
  }
  
  public final Bundle zzl(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = zzo();
    localParcel.writeInt(9);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzg.zzb(localParcel, paramBundle);
    paramString1 = zzp(12, localParcel);
    paramString2 = (Bundle)zzg.zza(paramString1, Bundle.CREATOR);
    paramString1.recycle();
    return paramString2;
  }
  
  public final Bundle zzm(int paramInt, String paramString1, String paramString2, Bundle paramBundle1, Bundle paramBundle2)
    throws RemoteException
  {
    Parcel localParcel = zzo();
    localParcel.writeInt(10);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzg.zzb(localParcel, paramBundle1);
    zzg.zzb(localParcel, paramBundle2);
    paramString1 = zzp(901, localParcel);
    paramString2 = (Bundle)zzg.zza(paramString1, Bundle.CREATOR);
    paramString1.recycle();
    return paramString2;
  }
  
  public final Bundle zzn(int paramInt, String paramString1, String paramString2, Bundle paramBundle)
    throws RemoteException
  {
    Parcel localParcel = zzo();
    localParcel.writeInt(9);
    localParcel.writeString(paramString1);
    localParcel.writeString(paramString2);
    zzg.zzb(localParcel, paramBundle);
    paramString2 = zzp(902, localParcel);
    paramString1 = (Bundle)zzg.zza(paramString2, Bundle.CREATOR);
    paramString2.recycle();
    return paramString1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\play_billing\zzb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */