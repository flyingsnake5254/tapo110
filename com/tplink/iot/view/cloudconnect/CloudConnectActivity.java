package com.tplink.iot.view.cloudconnect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.viewmodel.cloudconnect.CloudConnectViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStatus;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;

public class CloudConnectActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private String p0;
  private int p1;
  private CloudConnectViewModel p2;
  private TPRefreshableButton y;
  private TextView z;
  
  private void f1()
  {
    this.z.setVisibility(8);
    this.y.setText(getString(2131954363));
    this.y.h();
  }
  
  private void g1(int paramInt)
  {
    TextView localTextView = this.z;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append("");
    localTextView.setText(getString(2131952086, new Object[] { localStringBuilder.toString() }));
    this.z.setVisibility(0);
    this.y.setText(getString(2131954363));
    this.y.h();
  }
  
  private void h1()
  {
    W0(CloudConnectSuccessActivity.class);
    finish();
  }
  
  private void i1()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.p0 = localIntent.getStringExtra("device_id_md5");
      this.p1 = localIntent.getIntExtra("error_code", 0);
    }
  }
  
  private void j1()
  {
    Object localObject1 = (TextView)findViewById(2131364453);
    this.z = ((TextView)localObject1);
    if (this.p1 == 0)
    {
      ((TextView)localObject1).setVisibility(8);
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.p1);
      ((StringBuilder)localObject2).append("");
      ((TextView)localObject1).setText(getString(2131952086, new Object[] { ((StringBuilder)localObject2).toString() }));
      this.z.setVisibility(0);
    }
    localObject1 = (TPRefreshableButton)findViewById(2131362042);
    this.y = ((TPRefreshableButton)localObject1);
    ((TPRefreshableButton)localObject1).setOnClickListener(this);
    ((ImageView)findViewById(2131362826)).setOnClickListener(this);
    Object localObject2 = findViewById(2131364676);
    localObject1 = this.p2.i();
    if ((localObject1 != null) && (((BaseALIoTDevice)localObject1).isSubDevice())) {
      ((View)localObject2).setVisibility(8);
    }
  }
  
  public static void k1(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, CloudConnectActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    localIntent.putExtra("error_code", paramInt);
    paramContext.startActivity(localIntent);
  }
  
  private void l1(CloudConnectStatus paramCloudConnectStatus)
  {
    if (paramCloudConnectStatus == null)
    {
      f1();
      return;
    }
    if ((paramCloudConnectStatus.getErrorCode() == 1) && ("send_connect_fail".equals(paramCloudConnectStatus.getErrorMsg())))
    {
      f1();
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
  
  private void m1()
  {
    this.p2.n().observe(this, new a());
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
      this.p2.o();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558478);
    i1();
    this.p2 = ((CloudConnectViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, this.p0)).get(CloudConnectViewModel.class));
    j1();
    m1();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.y;
    if (localObject != null) {
      ((TPRefreshableButton)localObject).h();
    }
    localObject = this.p2;
    if (localObject != null) {
      ((CloudConnectViewModel)localObject).r();
    }
  }
  
  class a
    implements Observer<CloudConnectStatus>
  {
    a() {}
    
    public void a(@Nullable CloudConnectStatus paramCloudConnectStatus)
    {
      CloudConnectActivity.e1(CloudConnectActivity.this, paramCloudConnectStatus);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\cloudconnect\CloudConnectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */