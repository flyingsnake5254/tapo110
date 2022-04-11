package com.tplink.iot.view.quicksetup.common;

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
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.Utils.x0.u;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.c;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.firmware.QuickSetupFirmwareActivity;
import com.tplink.iot.view.quicksetup.firmware.QuickSetupFirmwareSuccessActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.QsFirmwareViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;

public class SetupSuccessActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private EnumDeviceType H3;
  private String I3;
  private long J3 = 0L;
  private TextView p0;
  private CommonQuickSetupBean p1;
  private QuickSetupDeviceInfoBean p2;
  private QsFirmwareViewModel p3;
  private TPRefreshableButton y;
  private ImageView z;
  
  private void h1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null)
      {
        this.p1 = ((CommonQuickSetupBean)((Bundle)localObject).getSerializable("common_quick_setup_bean"));
        this.p2 = ((QuickSetupDeviceInfoBean)((Bundle)localObject).getSerializable("device_info"));
        this.J3 = ((Bundle)localObject).getLong("obStartTimeExtra");
      }
    }
  }
  
  private QuickSetupDeviceInfoBean i1()
  {
    Object localObject = this.p2;
    if (localObject != null)
    {
      QuickSetupDeviceInfoBean localQuickSetupDeviceInfoBean = new QuickSetupDeviceInfoBean(((QuickSetupDeviceInfoBean)localObject).getNickname(), this.p2.getAvatar());
      localObject = localQuickSetupDeviceInfoBean;
      if (!d.X(this.p1))
      {
        localQuickSetupDeviceInfoBean.setLocation(this.p2.getLocation());
        localObject = localQuickSetupDeviceInfoBean;
      }
    }
    else
    {
      localObject = null;
    }
    return (QuickSetupDeviceInfoBean)localObject;
  }
  
  private void j1()
  {
    QuickSetupFirmwareActivity.i1(this, this.p1);
    finish();
  }
  
  private void k1()
  {
    QuickSetupFirmwareSuccessActivity.l1(this, this.p1);
    finish();
  }
  
  private void l1()
  {
    Object localObject = (TPRefreshableButton)findViewById(2131363741);
    this.y = ((TPRefreshableButton)localObject);
    ((TPRefreshableButton)localObject).setOnClickListener(this);
    this.z = ((ImageView)findViewById(2131362818));
    this.H3 = d.s(this.p1);
    localObject = d.r(this.p1);
    this.I3 = ((String)localObject);
    this.z.setImageResource(c.i0(this.H3, (String)localObject));
    localObject = (TextView)findViewById(2131364681);
    this.p0 = ((TextView)localObject);
    ((TextView)localObject).setVisibility(8);
  }
  
  private void m1(String paramString, boolean paramBoolean)
  {
    Object localObject1 = this.p1;
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = ((CommonQuickSetupBean)localObject1).getDeviceIdMD5();
    }
    Object localObject2 = this.H3;
    if (localObject2 != null) {
      localObject2 = ((EnumDeviceType)localObject2).getDeviceType();
    } else {
      localObject2 = null;
    }
    r.i((String)localObject2, this.I3, (String)localObject1, paramString, paramBoolean);
  }
  
  private void n1()
  {
    Object localObject1 = this.p1;
    String str1;
    if (localObject1 == null) {
      str1 = "";
    } else {
      str1 = ((CommonQuickSetupBean)localObject1).getDeviceIdMD5();
    }
    Object localObject2;
    Object localObject3;
    if (this.p1 != null)
    {
      localObject1 = this.p3.r(str1);
      localObject2 = this.p3.p(str1);
      localObject3 = this.p3.o(str1);
    }
    else
    {
      String str2 = "";
      localObject1 = str2;
      localObject3 = localObject1;
      localObject2 = localObject1;
      localObject1 = str2;
    }
    u.c(str1, "", (String)localObject1, (String)localObject2, (String)localObject3);
  }
  
  private void o1()
  {
    Object localObject1 = this.p1;
    if (localObject1 == null) {
      localObject1 = "";
    } else {
      localObject1 = ((CommonQuickSetupBean)localObject1).getDeviceIdMD5();
    }
    int i = (int)((System.currentTimeMillis() - this.J3) / 1000L);
    Object localObject2 = this.H3;
    if (localObject2 != null) {
      localObject2 = ((EnumDeviceType)localObject2).getDeviceType();
    } else {
      localObject2 = null;
    }
    r.h((String)localObject2, this.I3, (String)localObject1, i);
  }
  
  public static void p1(Context paramContext, CommonQuickSetupBean paramCommonQuickSetupBean, QuickSetupDeviceInfoBean paramQuickSetupDeviceInfoBean, long paramLong)
  {
    Intent localIntent = new Intent(paramContext, SetupSuccessActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("common_quick_setup_bean", paramCommonQuickSetupBean);
    localBundle.putSerializable("device_info", paramQuickSetupDeviceInfoBean);
    localBundle.putLong("obStartTimeExtra", paramLong);
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  private void q1()
  {
    this.p3.u().observe(this, new a());
  }
  
  public void onBackPressed() {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363741)
    {
      this.p0.setVisibility(0);
      this.z.setImageResource(c.X(this.H3, this.I3));
      paramView = this.p1;
      int i;
      if (paramView != null) {
        i = d.x(paramView.getComponentResult());
      } else {
        i = 1;
      }
      this.p3.s(i1(), i);
      n1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558656);
    h1();
    paramBundle = this.p1;
    if (paramBundle == null) {
      paramBundle = "";
    } else {
      paramBundle = paramBundle.getDeviceIdMD5();
    }
    this.p3 = ((QsFirmwareViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(QsFirmwareViewModel.class));
    l1();
    q1();
    o1();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    TPRefreshableButton localTPRefreshableButton = this.y;
    if (localTPRefreshableButton != null) {
      localTPRefreshableButton.h();
    }
  }
  
  class a
    implements Observer<i<ThingFirmware>>
  {
    a() {}
    
    public void a(@Nullable i<ThingFirmware> parami)
    {
      if ((parami != null) && (parami.b() == 0))
      {
        if (((ThingFirmware)parami.a()).isNeedToUpgrade()) {
          SetupSuccessActivity.e1(SetupSuccessActivity.this);
        } else {
          SetupSuccessActivity.f1(SetupSuccessActivity.this);
        }
        SetupSuccessActivity.g1(SetupSuccessActivity.this, ((ThingFirmware)parami.a()).getFwVer(), ((ThingFirmware)parami.a()).isNeedToUpgrade());
      }
      else
      {
        SetupSuccessActivity.f1(SetupSuccessActivity.this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\common\SetupSuccessActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */