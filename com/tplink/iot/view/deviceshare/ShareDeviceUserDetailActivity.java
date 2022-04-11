package com.tplink.iot.view.deviceshare;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.q;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.viewmodel.deviceshare.DeviceShareViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpcontrols.TPCircleMaskView;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceUserInfoBean;
import java.util.ArrayList;
import java.util.List;

public class ShareDeviceUserDetailActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private String p0;
  private boolean p1 = false;
  private DeviceShareViewModel y;
  private TCDeviceUserInfoBean z;
  
  private void g1()
  {
    s0.l(this);
    new ArrayList().add(this.p0);
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.z.getCloudUserName())) {
      localArrayList.add(this.z.getCloudUserName());
    }
    this.y.S(this.p0, localArrayList, this.p1);
  }
  
  private void h1()
  {
    Intent localIntent = getIntent();
    if (localIntent != null)
    {
      this.p0 = localIntent.getStringExtra("device_id");
      this.z = ((TCDeviceUserInfoBean)localIntent.getSerializableExtra("device_user"));
      this.p1 = localIntent.getBooleanExtra("sub_device", false);
    }
  }
  
  private void i1()
  {
    ((ImageView)findViewById(2131362831)).setOnClickListener(this);
    ((TPCircleMaskView)findViewById(2131362837)).g(this.z.getAvatarUrl(), 2131689624);
    ((TextView)findViewById(2131364544)).setText(a.c(this.z));
    ((TextView)findViewById(2131364713)).setText(this.z.getCloudUserName());
    TextView localTextView = (TextView)findViewById(2131364670);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(com.tplink.iot.view.iotplug.c.a.b(this.z.getBindingTime()));
    localStringBuilder.append(" ");
    localStringBuilder.append(getString(2131951625));
    localTextView.setText(localStringBuilder.toString());
    ((Button)findViewById(2131362046)).setOnClickListener(this);
  }
  
  public static void j1(Context paramContext, String paramString, TCDeviceUserInfoBean paramTCDeviceUserInfoBean, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, ShareDeviceUserDetailActivity.class);
    localIntent.putExtra("device_id", paramString);
    localIntent.putExtra("device_user", paramTCDeviceUserInfoBean);
    localIntent.putExtra("sub_device", paramBoolean);
    paramContext.startActivity(localIntent);
  }
  
  private void k1()
  {
    s0.p(this, getString(2131952444));
  }
  
  private void l1()
  {
    this.y.I().observe(this, new b());
  }
  
  private void m1()
  {
    TPMaterialDialogV2.Builder localBuilder = new TPMaterialDialogV2.Builder(this);
    localBuilder.h(2131953899);
    localBuilder.c(false);
    localBuilder.b(false);
    localBuilder.o(2131952517, 2131099812, new a());
    localBuilder.l(2131952391, 2131099804, null);
    localBuilder.g(8, 8);
    localBuilder.a().show();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362046)
    {
      if (i == 2131362831) {
        finish();
      }
    }
    else
    {
      m1();
      q.s();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558506);
    this.y = ((DeviceShareViewModel)ViewModelProviders.of(this).get(DeviceShareViewModel.class));
    h1();
    i1();
    l1();
  }
  
  class a
    implements TPMaterialDialogV2.d
  {
    a() {}
    
    public void onClick(View paramView)
    {
      ShareDeviceUserDetailActivity.e1(ShareDeviceUserDetailActivity.this);
    }
  }
  
  class b
    implements Observer<i<CloudResult<Void>>>
  {
    b() {}
    
    public void a(@Nullable i<CloudResult<Void>> parami)
    {
      
      if ((parami != null) && (parami.b() == 0)) {
        ShareDeviceUserDetailActivity.this.finish();
      } else {
        ShareDeviceUserDetailActivity.f1(ShareDeviceUserDetailActivity.this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\deviceshare\ShareDeviceUserDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */