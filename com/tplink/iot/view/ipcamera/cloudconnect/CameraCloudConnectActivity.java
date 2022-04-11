package com.tplink.iot.view.ipcamera.cloudconnect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.databinding.ActivityCameraCloudConnectBinding;
import com.tplink.iot.viewmodel.cloudconnect.CameraCloudConnectViewModel;
import com.tplink.iot.viewmodel.ipcamera.factory.CameraViewModelFactory;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public class CameraCloudConnectActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private CameraCloudConnectViewModel p0;
  private TPRefreshableButton y;
  private String z;
  
  private void e1()
  {
    this.y.setText(getString(2131952393));
    this.y.h();
  }
  
  private void f1()
  {
    W0(CameraCloudConnectSuccessActivity.class);
    finish();
  }
  
  private void g1()
  {
    Intent localIntent = getIntent();
    if (localIntent != null) {
      this.z = localIntent.getStringExtra("device_id_md5");
    }
  }
  
  private void h1()
  {
    TPRefreshableButton localTPRefreshableButton = (TPRefreshableButton)findViewById(2131362042);
    this.y = localTPRefreshableButton;
    localTPRefreshableButton.setOnClickListener(this);
    ((ImageView)findViewById(2131362826)).setOnClickListener(this);
  }
  
  public static void k1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, CameraCloudConnectActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private void l1()
  {
    this.p0.g().observe(this, new a(this));
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362042)
    {
      if (i == 2131362826) {
        finish();
      }
    }
    else {
      this.p0.i();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    ActivityCameraCloudConnectBinding localActivityCameraCloudConnectBinding = (ActivityCameraCloudConnectBinding)DataBindingUtil.setContentView(this, 2131558470);
    localActivityCameraCloudConnectBinding.setLifecycleOwner(this);
    g1();
    paramBundle = (CameraCloudConnectViewModel)ViewModelProviders.of(this, new CameraViewModelFactory(this, this.z)).get(CameraCloudConnectViewModel.class);
    this.p0 = paramBundle;
    localActivityCameraCloudConnectBinding.h(paramBundle.h());
    h1();
    l1();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.y;
    if (localObject != null) {
      ((TPRefreshableButton)localObject).h();
    }
    localObject = this.p0;
    if (localObject != null) {
      ((CameraCloudConnectViewModel)localObject).j();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\cloudconnect\CameraCloudConnectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */