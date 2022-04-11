package com.tplink.iot.view.quicksetup.discovery;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import androidx.databinding.DataBindingUtil;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityDiscoveryDevicePairingFailedBinding;
import com.tplink.iot.view.quicksetup.bulb.utils.a;
import com.tplink.iot.view.quicksetup.bulb.utils.b;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import kotlin.jvm.internal.j;

public final class DiscoveryDevicePairingFailedActivity
  extends BaseActivity
{
  public static final a y = new a(null);
  private String p0 = "";
  private ActivityDiscoveryDevicePairingFailedBinding z;
  
  private final void f1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getStringExtra("device_model");
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    this.p0 = ((String)localObject);
  }
  
  private final void g1()
  {
    ActivityDiscoveryDevicePairingFailedBinding localActivityDiscoveryDevicePairingFailedBinding = this.z;
    if (localActivityDiscoveryDevicePairingFailedBinding == null) {
      j.t("mBinding");
    }
    localActivityDiscoveryDevicePairingFailedBinding.c.setOnClickListener(new b(this));
    localActivityDiscoveryDevicePairingFailedBinding = this.z;
    if (localActivityDiscoveryDevicePairingFailedBinding == null) {
      j.t("mBinding");
    }
    localActivityDiscoveryDevicePairingFailedBinding.d.setOnClickListener(new c(this));
  }
  
  public static final void h1(Activity paramActivity, String paramString, int paramInt)
  {
    y.a(paramActivity, paramString, paramInt);
  }
  
  private final void i1()
  {
    EnumDeviceType localEnumDeviceType = b.l(this.p0);
    j.d(localEnumDeviceType, "SoftApOnboardingUtils.ge…TypeByModel(mDeviceModel)");
    a.h(this, localEnumDeviceType.getDeviceType(), this.p0, "PairingFailedPage");
  }
  
  public void onBackPressed()
  {
    i1();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = DataBindingUtil.setContentView(this, 2131558512);
    j.d(paramBundle, "DataBindingUtil.setConte…ry_device_pairing_failed)");
    this.z = ((ActivityDiscoveryDevicePairingFailedBinding)paramBundle);
    f1();
    g1();
  }
  
  public static final class a
  {
    public final void a(Activity paramActivity, String paramString, int paramInt)
    {
      j.e(paramActivity, "activity");
      Intent localIntent = new Intent(paramActivity, DiscoveryDevicePairingFailedActivity.class);
      Bundle localBundle = new Bundle();
      localBundle.putString("device_model", paramString);
      localIntent.putExtras(localBundle);
      paramActivity.startActivityForResult(localIntent, paramInt);
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(DiscoveryDevicePairingFailedActivity paramDiscoveryDevicePairingFailedActivity) {}
    
    public final void onClick(View paramView)
    {
      this.c.setResult(-1);
      this.c.finish();
    }
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(DiscoveryDevicePairingFailedActivity paramDiscoveryDevicePairingFailedActivity) {}
    
    public final void onClick(View paramView)
    {
      DiscoveryDevicePairingFailedActivity.e1(this.c);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\discovery\DiscoveryDevicePairingFailedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */