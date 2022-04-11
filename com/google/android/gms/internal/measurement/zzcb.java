package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;

public abstract class zzcb
  extends zzbn
  implements zzcc
{
  public zzcb()
  {
    super("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
  }
  
  public static zzcc asInterface(IBinder paramIBinder)
  {
    if (paramIBinder == null) {
      return null;
    }
    IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IAppMeasurementDynamiteService");
    if ((localIInterface instanceof zzcc)) {
      return (zzcc)localIInterface;
    }
    return new zzca(paramIBinder);
  }
  
  protected final boolean zza(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    Object localObject1 = null;
    Object localObject2 = null;
    Object localObject3 = null;
    Object localObject4 = null;
    Object localObject5 = null;
    String str = null;
    Object localObject6 = null;
    Object localObject7 = null;
    Object localObject8 = null;
    Object localObject9 = null;
    Object localObject10 = null;
    Object localObject11 = null;
    Object localObject12 = null;
    Object localObject13 = null;
    IBinder localIBinder = null;
    Object localObject14 = null;
    Object localObject15 = null;
    switch (paramInt1)
    {
    case 41: 
    default: 
      return false;
    case 45: 
      setConsentThirdParty((Bundle)zzbo.zzc(paramParcel1, Bundle.CREATOR), paramParcel1.readLong());
      break;
    case 44: 
      setConsent((Bundle)zzbo.zzc(paramParcel1, Bundle.CREATOR), paramParcel1.readLong());
      break;
    case 43: 
      clearMeasurementEnabled(paramParcel1.readLong());
      break;
    case 42: 
      setDefaultEventParameters((Bundle)zzbo.zzc(paramParcel1, Bundle.CREATOR));
      break;
    case 40: 
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject15;
      }
      else
      {
        localObject13 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject13 instanceof zzcf)) {
          paramParcel1 = (zzcf)localObject13;
        } else {
          paramParcel1 = new zzcd(paramParcel1);
        }
      }
      isDataCollectionEnabled(paramParcel1);
      break;
    case 39: 
      setDataCollectionEnabled(zzbo.zza(paramParcel1));
      break;
    case 38: 
      localObject13 = paramParcel1.readStrongBinder();
      if (localObject13 == null)
      {
        localObject13 = localObject1;
      }
      else
      {
        localObject14 = ((IBinder)localObject13).queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject14 instanceof zzcf)) {
          localObject13 = (zzcf)localObject14;
        } else {
          localObject13 = new zzcd((IBinder)localObject13);
        }
      }
      getTestFlag((zzcf)localObject13, paramParcel1.readInt());
      break;
    case 37: 
      initForTests(zzbo.zzf(paramParcel1));
      break;
    case 36: 
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject2;
      }
      else
      {
        localObject13 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
        if ((localObject13 instanceof zzci)) {
          paramParcel1 = (zzci)localObject13;
        } else {
          paramParcel1 = new zzcg(paramParcel1);
        }
      }
      unregisterOnMeasurementEventListener(paramParcel1);
      break;
    case 35: 
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject3;
      }
      else
      {
        localObject13 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
        if ((localObject13 instanceof zzci)) {
          paramParcel1 = (zzci)localObject13;
        } else {
          paramParcel1 = new zzcg(paramParcel1);
        }
      }
      registerOnMeasurementEventListener(paramParcel1);
      break;
    case 34: 
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject4;
      }
      else
      {
        localObject13 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
        if ((localObject13 instanceof zzci)) {
          paramParcel1 = (zzci)localObject13;
        } else {
          paramParcel1 = new zzcg(paramParcel1);
        }
      }
      setEventInterceptor(paramParcel1);
      break;
    case 33: 
      logHealthData(paramParcel1.readInt(), paramParcel1.readString(), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()));
      break;
    case 32: 
      localObject14 = (Bundle)zzbo.zzc(paramParcel1, Bundle.CREATOR);
      localObject13 = paramParcel1.readStrongBinder();
      if (localObject13 == null)
      {
        localObject13 = localObject5;
      }
      else
      {
        localObject5 = ((IBinder)localObject13).queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject5 instanceof zzcf)) {
          localObject13 = (zzcf)localObject5;
        } else {
          localObject13 = new zzcd((IBinder)localObject13);
        }
      }
      performAction((Bundle)localObject14, (zzcf)localObject13, paramParcel1.readLong());
      break;
    case 31: 
      localObject14 = IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder());
      localObject13 = paramParcel1.readStrongBinder();
      if (localObject13 == null)
      {
        localObject13 = str;
      }
      else
      {
        localObject5 = ((IBinder)localObject13).queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject5 instanceof zzcf)) {
          localObject13 = (zzcf)localObject5;
        } else {
          localObject13 = new zzcd((IBinder)localObject13);
        }
      }
      onActivitySaveInstanceState((IObjectWrapper)localObject14, (zzcf)localObject13, paramParcel1.readLong());
      break;
    case 30: 
      onActivityResumed(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readLong());
      break;
    case 29: 
      onActivityPaused(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readLong());
      break;
    case 28: 
      onActivityDestroyed(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readLong());
      break;
    case 27: 
      onActivityCreated(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), (Bundle)zzbo.zzc(paramParcel1, Bundle.CREATOR), paramParcel1.readLong());
      break;
    case 26: 
      onActivityStopped(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readLong());
      break;
    case 25: 
      onActivityStarted(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readLong());
      break;
    case 24: 
      endAdUnitExposure(paramParcel1.readString(), paramParcel1.readLong());
      break;
    case 23: 
      beginAdUnitExposure(paramParcel1.readString(), paramParcel1.readLong());
      break;
    case 22: 
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject6;
      }
      else
      {
        localObject13 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject13 instanceof zzcf)) {
          paramParcel1 = (zzcf)localObject13;
        } else {
          paramParcel1 = new zzcd(paramParcel1);
        }
      }
      generateEventId(paramParcel1);
      break;
    case 21: 
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject7;
      }
      else
      {
        localObject13 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject13 instanceof zzcf)) {
          paramParcel1 = (zzcf)localObject13;
        } else {
          paramParcel1 = new zzcd(paramParcel1);
        }
      }
      getGmpAppId(paramParcel1);
      break;
    case 20: 
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject8;
      }
      else
      {
        localObject13 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject13 instanceof zzcf)) {
          paramParcel1 = (zzcf)localObject13;
        } else {
          paramParcel1 = new zzcd(paramParcel1);
        }
      }
      getAppInstanceId(paramParcel1);
      break;
    case 19: 
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject9;
      }
      else
      {
        localObject13 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject13 instanceof zzcf)) {
          paramParcel1 = (zzcf)localObject13;
        } else {
          paramParcel1 = new zzcd(paramParcel1);
        }
      }
      getCachedAppInstanceId(paramParcel1);
      break;
    case 18: 
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject10;
      }
      else
      {
        localObject13 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IStringProvider");
        if ((localObject13 instanceof zzck)) {
          paramParcel1 = (zzck)localObject13;
        } else {
          paramParcel1 = new zzcj(paramParcel1);
        }
      }
      setInstanceIdProvider(paramParcel1);
      break;
    case 17: 
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject11;
      }
      else
      {
        localObject13 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject13 instanceof zzcf)) {
          paramParcel1 = (zzcf)localObject13;
        } else {
          paramParcel1 = new zzcd(paramParcel1);
        }
      }
      getCurrentScreenClass(paramParcel1);
      break;
    case 16: 
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject12;
      }
      else
      {
        localObject13 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject13 instanceof zzcf)) {
          paramParcel1 = (zzcf)localObject13;
        } else {
          paramParcel1 = new zzcd(paramParcel1);
        }
      }
      getCurrentScreenName(paramParcel1);
      break;
    case 15: 
      setCurrentScreen(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), paramParcel1.readString(), paramParcel1.readString(), paramParcel1.readLong());
      break;
    case 14: 
      setSessionTimeoutDuration(paramParcel1.readLong());
      break;
    case 13: 
      setMinimumSessionDuration(paramParcel1.readLong());
      break;
    case 12: 
      resetAnalyticsData(paramParcel1.readLong());
      break;
    case 11: 
      setMeasurementEnabled(zzbo.zza(paramParcel1), paramParcel1.readLong());
      break;
    case 10: 
      localObject14 = paramParcel1.readString();
      localObject5 = paramParcel1.readString();
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject13;
      }
      else
      {
        localObject13 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject13 instanceof zzcf)) {
          paramParcel1 = (zzcf)localObject13;
        } else {
          paramParcel1 = new zzcd(paramParcel1);
        }
      }
      getConditionalUserProperties((String)localObject14, (String)localObject5, paramParcel1);
      break;
    case 9: 
      clearConditionalUserProperty(paramParcel1.readString(), paramParcel1.readString(), (Bundle)zzbo.zzc(paramParcel1, Bundle.CREATOR));
      break;
    case 8: 
      setConditionalUserProperty((Bundle)zzbo.zzc(paramParcel1, Bundle.CREATOR), paramParcel1.readLong());
      break;
    case 7: 
      setUserId(paramParcel1.readString(), paramParcel1.readLong());
      break;
    case 6: 
      localObject13 = paramParcel1.readString();
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = localIBinder;
      }
      else
      {
        localObject14 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject14 instanceof zzcf)) {
          paramParcel1 = (zzcf)localObject14;
        } else {
          paramParcel1 = new zzcd(paramParcel1);
        }
      }
      getMaxUserProperties((String)localObject13, paramParcel1);
      break;
    case 5: 
      localObject5 = paramParcel1.readString();
      localObject13 = paramParcel1.readString();
      boolean bool = zzbo.zza(paramParcel1);
      paramParcel1 = paramParcel1.readStrongBinder();
      if (paramParcel1 == null)
      {
        paramParcel1 = (Parcel)localObject14;
      }
      else
      {
        localObject14 = paramParcel1.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject14 instanceof zzcf)) {
          paramParcel1 = (zzcf)localObject14;
        } else {
          paramParcel1 = new zzcd(paramParcel1);
        }
      }
      getUserProperties((String)localObject5, (String)localObject13, bool, paramParcel1);
      break;
    case 4: 
      setUserProperty(paramParcel1.readString(), paramParcel1.readString(), IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), zzbo.zza(paramParcel1), paramParcel1.readLong());
      break;
    case 3: 
      str = paramParcel1.readString();
      localObject14 = paramParcel1.readString();
      localObject5 = (Bundle)zzbo.zzc(paramParcel1, Bundle.CREATOR);
      localIBinder = paramParcel1.readStrongBinder();
      if (localIBinder == null)
      {
        localObject13 = null;
      }
      else
      {
        localObject13 = localIBinder.queryLocalInterface("com.google.android.gms.measurement.api.internal.IBundleReceiver");
        if ((localObject13 instanceof zzcf)) {
          localObject13 = (zzcf)localObject13;
        } else {
          localObject13 = new zzcd(localIBinder);
        }
      }
      logEventAndBundle(str, (String)localObject14, (Bundle)localObject5, (zzcf)localObject13, paramParcel1.readLong());
      break;
    case 2: 
      logEvent(paramParcel1.readString(), paramParcel1.readString(), (Bundle)zzbo.zzc(paramParcel1, Bundle.CREATOR), zzbo.zza(paramParcel1), zzbo.zza(paramParcel1), paramParcel1.readLong());
      break;
    case 1: 
      initialize(IObjectWrapper.Stub.asInterface(paramParcel1.readStrongBinder()), (zzcl)zzbo.zzc(paramParcel1, zzcl.CREATOR), paramParcel1.readLong());
    }
    paramParcel2.writeNoException();
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\measurement\zzcb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */