package com.tplink.iot.devices.lightstrip.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityLightStripPlacementGuideBinding;
import com.tplink.iot.view.quicksetup.lightstrip.LightStripUserGuideActivity;
import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class LightStripPlacementGuideActivity
  extends BaseActivity
{
  public static final a y = new a(null);
  private String p0;
  private boolean p1;
  private boolean p2;
  private ActivityLightStripPlacementGuideBinding z;
  
  private final void f1()
  {
    Object localObject = getIntent();
    if (localObject != null) {
      localObject = ((Intent)localObject).getStringExtra("device_model");
    } else {
      localObject = null;
    }
    this.p0 = ((String)localObject);
    localObject = getIntent();
    boolean bool1 = false;
    if (localObject != null) {
      bool2 = ((Intent)localObject).getBooleanExtra("ExtraIsOnboarding", false);
    } else {
      bool2 = false;
    }
    this.p1 = bool2;
    localObject = getIntent();
    boolean bool2 = bool1;
    if (localObject != null) {
      bool2 = ((Intent)localObject).getBooleanExtra("ExtraIsFromDiscovery", false);
    }
    this.p2 = bool2;
  }
  
  private final void g1()
  {
    Object localObject = this.p0;
    if ((localObject != null) && (!m.A((String)localObject, "L930", false, 2, null)))
    {
      localObject = this.z;
      if (localObject == null) {
        j.t("mBinding");
      }
      ((ActivityLightStripPlacementGuideBinding)localObject).q.setText(2131952971);
    }
    else
    {
      localObject = this.z;
      if (localObject == null) {
        j.t("mBinding");
      }
      ((ActivityLightStripPlacementGuideBinding)localObject).q.setText(2131952969);
    }
    localObject = this.z;
    if (localObject == null) {
      j.t("mBinding");
    }
    ((ActivityLightStripPlacementGuideBinding)localObject).d.setOnClickListener(new b(this));
    if (this.p1)
    {
      localObject = this.z;
      if (localObject == null) {
        j.t("mBinding");
      }
      localObject = ((ActivityLightStripPlacementGuideBinding)localObject).c;
      j.d(localObject, "mBinding.btnDone");
      ((Button)localObject).setVisibility(0);
      localObject = this.z;
      if (localObject == null) {
        j.t("mBinding");
      }
      ((ActivityLightStripPlacementGuideBinding)localObject).c.setOnClickListener(new c(this));
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = DataBindingUtil.setContentView(this, 2131558564);
    j.d(paramBundle, "DataBindingUtil.setConte…ht_strip_placement_guide)");
    this.z = ((ActivityLightStripPlacementGuideBinding)paramBundle);
    f1();
    g1();
  }
  
  public static final class a
  {
    public final void a(Context paramContext, String paramString, boolean paramBoolean)
    {
      j.e(paramContext, "context");
      j.e(paramString, "deviceModel");
      b(paramContext, paramString, paramBoolean, false);
    }
    
    public final void b(Context paramContext, String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      j.e(paramContext, "context");
      j.e(paramString, "deviceModel");
      Intent localIntent = new Intent(paramContext, LightStripPlacementGuideActivity.class);
      localIntent.putExtra("device_model", paramString);
      localIntent.putExtra("ExtraIsOnboarding", paramBoolean1);
      localIntent.putExtra("ExtraIsFromDiscovery", paramBoolean2);
      paramContext.startActivity(localIntent);
    }
  }
  
  static final class b
    implements View.OnClickListener
  {
    b(LightStripPlacementGuideActivity paramLightStripPlacementGuideActivity) {}
    
    public final void onClick(View paramView)
    {
      this.c.finish();
    }
  }
  
  static final class c
    implements View.OnClickListener
  {
    c(LightStripPlacementGuideActivity paramLightStripPlacementGuideActivity) {}
    
    public final void onClick(View paramView)
    {
      paramView = this.c;
      LightStripUserGuideActivity.g1(paramView, LightStripPlacementGuideActivity.e1(paramView));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\view\LightStripPlacementGuideActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */