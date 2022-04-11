package com.tplink.iot.devices.lightstrip.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.tplink.iot.databinding.ActivityLightStripSoftApResetHintBinding;
import com.tplink.iot.devicecommon.feature.LottieAnimationViewFeature;
import com.tplink.iot.devicecommon.feature.LottieAnimationViewFeature.a;
import com.tplink.iot.devicecommon.view.IoTMVVMBaseActivity;
import com.tplink.iot.g.b.c.c;
import kotlin.jvm.internal.j;

public final class LightStripSoftApResetHintActivity
  extends IoTMVVMBaseActivity<ActivityLightStripSoftApResetHintBinding>
{
  public static final a p0 = new a(null);
  private String p1;
  
  private final void n1()
  {
    Object localObject = getIntent();
    if (localObject != null) {
      localObject = ((Intent)localObject).getStringExtra("DeviceModel");
    } else {
      localObject = null;
    }
    this.p1 = ((String)localObject);
  }
  
  private final void o1()
  {
    ((ActivityLightStripSoftApResetHintBinding)f1()).q.setText(2131952960);
    Object localObject = ((ActivityLightStripSoftApResetHintBinding)f1()).d;
    ((ImageView)localObject).setImageResource(0);
    ((View)localObject).setVisibility(8);
    LottieAnimationViewFeature.a locala = LottieAnimationViewFeature.c;
    localObject = ((ActivityLightStripSoftApResetHintBinding)f1()).f;
    j.d(localObject, "mBinding.lottieAnimationView");
    locala.a(this, (LottieAnimationView)localObject, 2131886084);
  }
  
  private final void p1()
  {
    Object localObject = ((ActivityLightStripSoftApResetHintBinding)f1()).d;
    j.d(localObject, "mBinding.ivReset");
    localObject = ((ImageView)localObject).getDrawable();
    if ((localObject instanceof AnimationDrawable)) {
      ((AnimationDrawable)localObject).start();
    }
  }
  
  private final void q1()
  {
    Object localObject = ((ActivityLightStripSoftApResetHintBinding)f1()).d;
    j.d(localObject, "mBinding.ivReset");
    localObject = ((ImageView)localObject).getDrawable();
    if ((localObject instanceof AnimationDrawable)) {
      ((AnimationDrawable)localObject).stop();
    }
  }
  
  public int e1()
  {
    return 2131558567;
  }
  
  public void j1()
  {
    n1();
    if (c.j(this.p1)) {
      o1();
    }
    p1();
  }
  
  protected void onStart()
  {
    super.onStart();
    p1();
  }
  
  protected void onStop()
  {
    q1();
    super.onStop();
  }
  
  public static final class a
  {
    public final void a(Context paramContext, String paramString)
    {
      j.e(paramContext, "context");
      Intent localIntent = new Intent(paramContext, LightStripSoftApResetHintActivity.class);
      localIntent.putExtra("DeviceModel", paramString);
      paramContext.startActivity(localIntent);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\view\LightStripSoftApResetHintActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */