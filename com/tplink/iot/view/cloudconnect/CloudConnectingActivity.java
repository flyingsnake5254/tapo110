package com.tplink.iot.view.cloudconnect;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.w0.a;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.EnumCountry;
import com.tplink.iot.view.quicksetup.base.c;
import com.tplink.iot.viewmodel.cloudconnect.CloudConnectViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStatus;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;

public class CloudConnectingActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private ImageView p0;
  private ValueAnimator p1;
  private TPRefreshableButton p2;
  private String y;
  private CloudConnectViewModel z;
  
  private void g1(int paramInt)
  {
    CloudConnectActivity.k1(this, this.y, paramInt);
  }
  
  private void h1()
  {
    W0(CloudConnectSuccessActivity.class);
  }
  
  private void i1()
  {
    Intent localIntent = getIntent();
    if (localIntent != null) {
      this.y = localIntent.getStringExtra("device_id_md5");
    }
  }
  
  private void j1()
  {
    this.p0 = ((ImageView)findViewById(2131362314));
    Object localObject = (TPRefreshableButton)findViewById(2131362042);
    this.p2 = ((TPRefreshableButton)localObject);
    ((TPRefreshableButton)localObject).g();
    ((ImageView)findViewById(2131362826)).setOnClickListener(this);
    ImageView localImageView = (ImageView)findViewById(2131362818);
    localObject = a.b(this.y);
    if ((localObject != null) && (((BaseALIoTDevice)localObject).isBulb()))
    {
      localImageView.setImageResource(2131689519);
    }
    else
    {
      EnumCountry localEnumCountry = null;
      if (localObject != null)
      {
        localEnumCountry = EnumCountry.fromString(((BaseALIoTDevice)localObject).getSpecs());
        localObject = ((BaseALIoTDevice)localObject).getDeviceModel();
      }
      else
      {
        localObject = null;
      }
      localImageView.setImageResource(c.u(localEnumCountry, (String)localObject));
    }
  }
  
  private void k1()
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F }).setDuration(500L);
    this.p1 = localValueAnimator;
    localValueAnimator.addUpdateListener(new a());
    this.p1.setRepeatCount(-1);
    this.p1.setRepeatMode(2);
    this.p1.start();
  }
  
  public static void l1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, CloudConnectActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private void m1(CloudConnectStatus paramCloudConnectStatus)
  {
    if (paramCloudConnectStatus == null)
    {
      g1(0);
      return;
    }
    if (paramCloudConnectStatus.getErrorCode() == 2) {
      return;
    }
    if (paramCloudConnectStatus.getErrorCode() == 0) {
      h1();
    } else {
      g1(paramCloudConnectStatus.getErrorCode());
    }
  }
  
  private void n1()
  {
    this.z.m().observe(this, new b());
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362826) {
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558481);
    i1();
    this.z = ((CloudConnectViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, this.y)).get(CloudConnectViewModel.class));
    j1();
    k1();
    n1();
    this.z.l();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.p1;
    if (localObject != null)
    {
      ((ValueAnimator)localObject).cancel();
      this.p1.removeAllUpdateListeners();
      this.p1 = null;
    }
    localObject = this.p2;
    if (localObject != null) {
      ((TPRefreshableButton)localObject).h();
    }
    localObject = this.z;
    if (localObject != null) {
      ((CloudConnectViewModel)localObject).p();
    }
  }
  
  class a
    implements ValueAnimator.AnimatorUpdateListener
  {
    a() {}
    
    public void onAnimationUpdate(ValueAnimator paramValueAnimator)
    {
      float f = ((Float)paramValueAnimator.getAnimatedValue()).floatValue();
      CloudConnectingActivity.e1(CloudConnectingActivity.this).setAlpha(f);
    }
  }
  
  class b
    implements Observer<CloudConnectStatus>
  {
    b() {}
    
    public void a(@Nullable CloudConnectStatus paramCloudConnectStatus)
    {
      CloudConnectingActivity.f1(CloudConnectingActivity.this, paramCloudConnectStatus);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\cloudconnect\CloudConnectingActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */