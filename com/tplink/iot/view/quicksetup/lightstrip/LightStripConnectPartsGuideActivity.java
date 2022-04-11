package com.tplink.iot.view.quicksetup.lightstrip;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.databinding.DataBindingUtil;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityLightStripConnectPartsGuideBinding;
import com.tplink.iot.view.quicksetup.softap.common.SoftApCommonGuideActivity;
import com.tplink.iot.view.quicksetup.softap.common.SoftApCommonGuideActivity.a;
import kotlin.jvm.internal.j;

public final class LightStripConnectPartsGuideActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final a y = new a(null);
  private String p0 = "";
  private ActivityLightStripConnectPartsGuideBinding z;
  
  private final void e1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getStringExtra("device_model");
      if (localObject != null) {}
    }
    else
    {
      localObject = "L900";
    }
    this.p0 = ((String)localObject);
  }
  
  private final void f1()
  {
    ActivityLightStripConnectPartsGuideBinding localActivityLightStripConnectPartsGuideBinding = this.z;
    if (localActivityLightStripConnectPartsGuideBinding == null) {
      j.t("mBinding");
    }
    localActivityLightStripConnectPartsGuideBinding.h(this);
  }
  
  public static final void g1(Context paramContext, String paramString)
  {
    y.a(paramContext, paramString);
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {
      paramView = Integer.valueOf(paramView.getId());
    } else {
      paramView = null;
    }
    if ((paramView != null) && (paramView.intValue() == 2131362826)) {
      finish();
    } else if ((paramView != null) && (paramView.intValue() == 2131362037)) {
      SoftApCommonGuideActivity.y.a(this, this.p0);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = DataBindingUtil.setContentView(this, 2131558562);
    j.d(paramBundle, "DataBindingUtil.setConte…trip_connect_parts_guide)");
    this.z = ((ActivityLightStripConnectPartsGuideBinding)paramBundle);
    e1();
    f1();
  }
  
  public static final class a
  {
    public final void a(Context paramContext, String paramString)
    {
      j.e(paramContext, "activity");
      Intent localIntent = new Intent(paramContext, LightStripConnectPartsGuideActivity.class);
      localIntent.putExtra("device_model", paramString);
      paramContext.startActivity(localIntent);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\lightstrip\LightStripConnectPartsGuideActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */