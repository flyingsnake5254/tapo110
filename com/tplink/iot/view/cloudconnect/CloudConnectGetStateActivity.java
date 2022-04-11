package com.tplink.iot.view.cloudconnect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.s0.h;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.viewmodel.cloudconnect.CloudConnectViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import io.reactivex.d0.b.a;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.concurrent.TimeUnit;

public class CloudConnectGetStateActivity
  extends BaseActivity
{
  private String y;
  private CloudConnectViewModel z;
  
  private void f1()
  {
    Intent localIntent = getIntent();
    if (localIntent != null) {
      this.y = localIntent.getStringExtra("device_id_md5");
    }
  }
  
  private void g1()
  {
    s0.o(this, 2131952444, new b());
  }
  
  private void h1(CloudConnectStateResult paramCloudConnectStateResult)
  {
    if (paramCloudConnectStateResult == null)
    {
      g1();
      return;
    }
    int i = paramCloudConnectStateResult.getStatus();
    if (i != 0)
    {
      if (i != 2)
      {
        CloudConnectActivity.k1(this, this.y, paramCloudConnectStateResult.getStatus());
        finish();
      }
      else
      {
        CloudConnectingActivity.l1(this, this.y);
        finish();
      }
    }
    else
    {
      W0(CloudConnectSuccessActivity.class);
      finish();
    }
  }
  
  private void i1(i<CloudConnectStateResult> parami)
  {
    
    if ((parami != null) && (parami.b() == 0)) {
      h1((CloudConnectStateResult)parami.a());
    } else {
      g1();
    }
  }
  
  public static void j1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, CloudConnectGetStateActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private void k1()
  {
    this.z.j().observe(this, new a());
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558479);
    f1();
    this.z = ((CloudConnectViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, this.y)).get(CloudConnectViewModel.class));
    k1();
    s0.l(this);
    this.z.k();
  }
  
  class a
    implements Observer<i<CloudConnectStateResult>>
  {
    a() {}
    
    public void a(@Nullable final i<CloudConnectStateResult> parami)
    {
      q.W0(2L, TimeUnit.SECONDS).l0(a.a()).E(new a(parami)).F0();
    }
    
    class a
      implements g<Long>
    {
      a(i parami) {}
      
      public void a(Long paramLong)
        throws Exception
      {
        CloudConnectGetStateActivity.e1(CloudConnectGetStateActivity.this, parami);
      }
    }
  }
  
  class b
    implements s0.h
  {
    b() {}
    
    public void onDismiss()
    {
      CloudConnectGetStateActivity.this.finish();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\cloudconnect\CloudConnectGetStateActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */