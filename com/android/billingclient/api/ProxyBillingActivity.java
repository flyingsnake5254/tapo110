package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zza;

public class ProxyBillingActivity
  extends Activity
{
  @Nullable
  private ResultReceiver c;
  private boolean d;
  
  private final Intent a()
  {
    Intent localIntent = new Intent("com.android.vending.billing.PURCHASES_UPDATED");
    localIntent.setPackage(getApplicationContext().getPackageName());
    return localIntent;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 100)
    {
      int i = zza.zzc(paramIntent, "ProxyBillingActivity").a();
      paramInt1 = paramInt2;
      if (paramInt2 == -1) {
        if (i != 0)
        {
          paramInt1 = -1;
        }
        else
        {
          paramInt1 = 0;
          break label101;
        }
      }
      Object localObject = new StringBuilder(85);
      ((StringBuilder)localObject).append("Activity finished with resultCode ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" and billing's responseCode: ");
      ((StringBuilder)localObject).append(i);
      zza.zzb("ProxyBillingActivity", ((StringBuilder)localObject).toString());
      paramInt1 = i;
      label101:
      localObject = this.c;
      if (localObject != null)
      {
        if (paramIntent == null) {
          paramIntent = null;
        } else {
          paramIntent = paramIntent.getExtras();
        }
        ((ResultReceiver)localObject).send(paramInt1, paramIntent);
      }
      else
      {
        localObject = a();
        if (paramIntent != null) {
          ((Intent)localObject).putExtras(paramIntent.getExtras());
        }
        sendBroadcast((Intent)localObject);
      }
    }
    else
    {
      paramIntent = new StringBuilder(69);
      paramIntent.append("Got onActivityResult with wrong requestCode: ");
      paramIntent.append(paramInt1);
      paramIntent.append("; skipping...");
      zza.zzb("ProxyBillingActivity", paramIntent.toString());
    }
    this.d = false;
    finish();
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null)
    {
      zza.zza("ProxyBillingActivity", "Launching Play Store billing flow");
      if (getIntent().hasExtra("BUY_INTENT"))
      {
        paramBundle = (PendingIntent)getIntent().getParcelableExtra("BUY_INTENT");
      }
      else if (getIntent().hasExtra("SUBS_MANAGEMENT_INTENT"))
      {
        paramBundle = (PendingIntent)getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT");
        this.c = ((ResultReceiver)getIntent().getParcelableExtra("result_receiver"));
      }
      else
      {
        paramBundle = null;
      }
      try
      {
        this.d = true;
        localObject = paramBundle.getIntentSender();
        paramBundle = new android/content/Intent;
        paramBundle.<init>();
        startIntentSenderForResult((IntentSender)localObject, 100, paramBundle, 0, 0, 0);
        return;
      }
      catch (IntentSender.SendIntentException paramBundle)
      {
        paramBundle = String.valueOf(paramBundle);
        Object localObject = new StringBuilder(paramBundle.length() + 53);
        ((StringBuilder)localObject).append("Got exception while trying to start a purchase flow: ");
        ((StringBuilder)localObject).append(paramBundle);
        zza.zzb("ProxyBillingActivity", ((StringBuilder)localObject).toString());
        paramBundle = this.c;
        if (paramBundle != null)
        {
          paramBundle.send(6, null);
        }
        else
        {
          paramBundle = a();
          paramBundle.putExtra("RESPONSE_CODE", 6);
          paramBundle.putExtra("DEBUG_MESSAGE", "An internal error occurred.");
          sendBroadcast(paramBundle);
        }
        this.d = false;
        finish();
        return;
      }
    }
    zza.zza("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
    this.d = paramBundle.getBoolean("send_cancelled_broadcast_if_finished", false);
    if (paramBundle.containsKey("result_receiver")) {
      this.c = ((ResultReceiver)paramBundle.getParcelable("result_receiver"));
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (!isFinishing()) {
      return;
    }
    if (!this.d) {
      return;
    }
    Intent localIntent = a();
    localIntent.putExtra("RESPONSE_CODE", 1);
    localIntent.putExtra("DEBUG_MESSAGE", "Billing dialog closed.");
    sendBroadcast(localIntent);
  }
  
  protected void onSaveInstanceState(@NonNull Bundle paramBundle)
  {
    ResultReceiver localResultReceiver = this.c;
    if (localResultReceiver != null) {
      paramBundle.putParcelable("result_receiver", localResultReceiver);
    }
    paramBundle.putBoolean("send_cancelled_broadcast_if_finished", this.d);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\android\billingclient\api\ProxyBillingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */