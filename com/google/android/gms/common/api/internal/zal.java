package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zap;
import java.util.concurrent.atomic.AtomicReference;

public abstract class zal
  extends LifecycleCallback
  implements DialogInterface.OnCancelListener
{
  protected volatile boolean mStarted;
  protected final GoogleApiAvailability zacd;
  protected final AtomicReference<zam> zadf = new AtomicReference(null);
  private final Handler zadg = new zap(Looper.getMainLooper());
  
  protected zal(LifecycleFragment paramLifecycleFragment)
  {
    this(paramLifecycleFragment, GoogleApiAvailability.getInstance());
  }
  
  @VisibleForTesting
  private zal(LifecycleFragment paramLifecycleFragment, GoogleApiAvailability paramGoogleApiAvailability)
  {
    super(paramLifecycleFragment);
    this.zacd = paramGoogleApiAvailability;
  }
  
  private static int zaa(@Nullable zam paramzam)
  {
    if (paramzam == null) {
      return -1;
    }
    return paramzam.zar();
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    zam localzam1 = (zam)this.zadf.get();
    int i = 1;
    int j = 1;
    zam localzam2;
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        localzam2 = localzam1;
      }
      else
      {
        i = this.zacd.isGooglePlayServicesAvailable(getActivity());
        if (i == 0) {
          paramInt2 = j;
        } else {
          paramInt2 = 0;
        }
        if (localzam1 == null) {
          return;
        }
        localzam2 = localzam1;
        paramInt1 = paramInt2;
        if (localzam1.getConnectionResult().getErrorCode() != 18) {
          break label173;
        }
        localzam2 = localzam1;
        paramInt1 = paramInt2;
        if (i != 18) {
          break label173;
        }
      }
    }
    else
    {
      if (paramInt2 == -1)
      {
        localzam2 = localzam1;
        paramInt1 = i;
        break label173;
      }
      localzam2 = localzam1;
      if (paramInt2 == 0)
      {
        paramInt1 = 13;
        if (paramIntent != null) {
          paramInt1 = paramIntent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13);
        }
        localzam2 = new zam(new ConnectionResult(paramInt1, null), zaa(localzam1));
        this.zadf.set(localzam2);
      }
    }
    paramInt1 = 0;
    label173:
    if (paramInt1 != 0)
    {
      zaq();
      return;
    }
    if (localzam2 != null) {
      zaa(localzam2.getConnectionResult(), localzam2.zar());
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    zaa(new ConnectionResult(13, null), zaa((zam)this.zadf.get()));
    zaq();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      AtomicReference localAtomicReference = this.zadf;
      if (paramBundle.getBoolean("resolving_error", false)) {
        paramBundle = new zam(new ConnectionResult(paramBundle.getInt("failed_status"), (PendingIntent)paramBundle.getParcelable("failed_resolution")), paramBundle.getInt("failed_client_id", -1));
      } else {
        paramBundle = null;
      }
      localAtomicReference.set(paramBundle);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    zam localzam = (zam)this.zadf.get();
    if (localzam != null)
    {
      paramBundle.putBoolean("resolving_error", true);
      paramBundle.putInt("failed_client_id", localzam.zar());
      paramBundle.putInt("failed_status", localzam.getConnectionResult().getErrorCode());
      paramBundle.putParcelable("failed_resolution", localzam.getConnectionResult().getResolution());
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.mStarted = true;
  }
  
  public void onStop()
  {
    super.onStop();
    this.mStarted = false;
  }
  
  protected abstract void zaa(ConnectionResult paramConnectionResult, int paramInt);
  
  public final void zab(ConnectionResult paramConnectionResult, int paramInt)
  {
    paramConnectionResult = new zam(paramConnectionResult, paramInt);
    if (this.zadf.compareAndSet(null, paramConnectionResult)) {
      this.zadg.post(new zan(this, paramConnectionResult));
    }
  }
  
  protected abstract void zao();
  
  protected final void zaq()
  {
    this.zadf.set(null);
    zao();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\api\internal\zal.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */