package com.tplink.iot.view.quicksetup.lightstrip;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityLightStripUserGuideBinding;
import com.tplink.iot.view.quicksetup.bulb.utils.a;
import com.tplink.iot.widget.PointTextView;

public class LightStripUserGuideActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ActivityLightStripUserGuideBinding y;
  private boolean z = false;
  
  private void e1()
  {
    if (getIntent() != null) {
      this.z = getIntent().getBooleanExtra("ExtraIsFromDiscovery", false);
    }
  }
  
  private void f1()
  {
    this.y.y.setContent(getString(2131952965, new Object[] { Integer.valueOf(5) }));
    this.y.z.setContent(getString(2131952966, new Object[] { Integer.valueOf(10) }));
    this.y.d.setOnClickListener(this);
    this.y.h(this);
  }
  
  public static void g1(Context paramContext, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, LightStripUserGuideActivity.class);
    localIntent.putExtra("ExtraIsFromDiscovery", paramBoolean);
    paramContext.startActivity(localIntent);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362037) {
      a.d(this, this.z);
    } else if (paramView.getId() == 2131363002) {
      finish();
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.y = ((ActivityLightStripUserGuideBinding)DataBindingUtil.setContentView(this, 2131558568));
    e1();
    f1();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\lightstrip\LightStripUserGuideActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */