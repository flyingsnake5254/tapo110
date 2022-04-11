package com.tplink.iot.view.quicksetup.softap.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentActivity;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivitySoftApResetHintBinding;
import com.tplink.iot.view.quicksetup.bulb.utils.b;
import kotlin.jvm.internal.j;

public final class SoftApResetHintActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final a y = new a(null);
  private String p0;
  private ActivitySoftApResetHintBinding z;
  
  private final void e1()
  {
    Object localObject = getIntent();
    if (localObject != null) {
      localObject = ((Intent)localObject).getStringExtra("device_model");
    } else {
      localObject = null;
    }
    this.p0 = ((String)localObject);
    localObject = this.z;
    if (localObject == null) {
      j.t("binding");
    }
    ((ActivitySoftApResetHintBinding)localObject).h(this);
  }
  
  private final void f1()
  {
    Object localObject = this.z;
    if (localObject == null) {
      j.t("binding");
    }
    ((ActivitySoftApResetHintBinding)localObject).q.setText(b.g(this.p0));
    localObject = this.z;
    if (localObject == null) {
      j.t("binding");
    }
    localObject = ((ActivitySoftApResetHintBinding)localObject).f;
    j.d(localObject, "binding.tvResetHint");
    ((TextView)localObject).setText(b.e(this.p0));
    localObject = this.z;
    if (localObject == null) {
      j.t("binding");
    }
    ((ActivitySoftApResetHintBinding)localObject).c.setImageResource(b.f(this.p0));
  }
  
  public void onClick(View paramView)
  {
    if (paramView != null) {
      paramView = Integer.valueOf(paramView.getId());
    } else {
      paramView = null;
    }
    if ((paramView != null) && (paramView.intValue() == 2131362826)) {
      onBackPressed();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = DataBindingUtil.setContentView(this, 2131558665);
    j.d(paramBundle, "DataBindingUtil.setConte…ivity_soft_ap_reset_hint)");
    this.z = ((ActivitySoftApResetHintBinding)paramBundle);
    e1();
    f1();
  }
  
  protected void onResume()
  {
    super.onResume();
    Object localObject = this.z;
    if (localObject == null) {
      j.t("binding");
    }
    localObject = ((ActivitySoftApResetHintBinding)localObject).c;
    j.d(localObject, "binding.imageReset");
    localObject = ((ImageView)localObject).getDrawable();
    j.d(localObject, "binding.imageReset.drawable");
    if ((localObject instanceof AnimationDrawable)) {
      ((AnimationDrawable)localObject).start();
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    Object localObject = this.z;
    if (localObject == null) {
      j.t("binding");
    }
    localObject = ((ActivitySoftApResetHintBinding)localObject).c;
    j.d(localObject, "binding.imageReset");
    localObject = ((ImageView)localObject).getDrawable();
    j.d(localObject, "binding.imageReset.drawable");
    if ((localObject instanceof AnimationDrawable)) {
      ((AnimationDrawable)localObject).stop();
    }
  }
  
  public static final class a
  {
    public final void a(Context paramContext, String paramString)
    {
      j.e(paramContext, "context");
      Intent localIntent = new Intent(paramContext, SoftApResetHintActivity.class);
      localIntent.putExtra("device_model", paramString);
      paramContext.startActivity(localIntent);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\softap\common\SoftApResetHintActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */