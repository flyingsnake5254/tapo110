package com.tplink.iot.view.quicksetup.ble;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.iot.view.quicksetup.base.c;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.common.CommonQuickSetupBean;
import com.tplink.iot.view.quicksetup.common.SetupSuccessActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.QuickSetupViewModel;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;

public class FindDeviceFailedActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private boolean H3;
  private TPMaterialDialogV2 I3;
  private long J3 = 0L;
  private TPRefreshableButton p0;
  private QuickSetupViewModel p1;
  private String p2;
  private boolean p3;
  private QuickSetupInfoBean y;
  private QuickSetupDeviceInfoBean z;
  
  private void g1()
  {
    TPRefreshableButton localTPRefreshableButton = this.p0;
    if (localTPRefreshableButton != null)
    {
      localTPRefreshableButton.setText(getString(2131954363));
      this.p0.h();
    }
  }
  
  private void h1()
  {
    this.J3 = System.currentTimeMillis();
    this.p1.P(this.y.getResultDeviceIdMD5(), this.p3, this.H3);
  }
  
  private void i1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null)
      {
        this.y = ((QuickSetupInfoBean)((Bundle)localObject).getSerializable("device_info_bean"));
        this.z = ((QuickSetupDeviceInfoBean)((Bundle)localObject).getSerializable("device_info"));
      }
    }
  }
  
  private void j1()
  {
    Object localObject = this.y;
    if (localObject != null)
    {
      if (this.p3) {
        ((QuickSetupInfoBean)localObject).setDeviceIdMD5(((QuickSetupInfoBean)localObject).getResultDeviceIdMD5());
      }
      localObject = new CommonQuickSetupBean(this.y.getDeviceIdMD5(), this.y.getComponentResult());
    }
    else
    {
      localObject = null;
    }
    SetupSuccessActivity.p1(this, (CommonQuickSetupBean)localObject, this.z, 0L);
    l1();
    finish();
  }
  
  private void k1()
  {
    Object localObject1 = d.q(this.y);
    d.c0(this, (TextView)findViewById(2131364385), (String)localObject1);
    ((ImageView)findViewById(2131362827)).setImageResource(c.M((String)localObject1));
    ((ImageView)findViewById(2131362831)).setOnClickListener(this);
    TextView localTextView = (TextView)findViewById(2131362619);
    localObject1 = this.y;
    if (localObject1 != null) {
      localObject1 = ((QuickSetupInfoBean)localObject1).getSsid();
    } else {
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = "";
    }
    d0.a(localTextView, getString(2131953512, new Object[] { localObject2 }), (String)localObject2, ContextCompat.getColor(this, 2131099811));
    localObject1 = (TPRefreshableButton)findViewById(2131362037);
    this.p0 = ((TPRefreshableButton)localObject1);
    ((TPRefreshableButton)localObject1).setText(getString(2131954363));
    this.p0.setOnClickListener(this);
  }
  
  private void l1()
  {
    if (this.y != null)
    {
      int i = (int)((System.currentTimeMillis() - this.J3) / 1000L);
      r.u(this.y.getDeviceType(), this.y.getDeviceModel(), this.y.getDeviceIdMD5(), i);
    }
  }
  
  public static void m1(Context paramContext, QuickSetupInfoBean paramQuickSetupInfoBean, QuickSetupDeviceInfoBean paramQuickSetupDeviceInfoBean)
  {
    Intent localIntent = new Intent(paramContext, FindDeviceFailedActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putSerializable("device_info_bean", paramQuickSetupInfoBean);
    localBundle.putSerializable("device_info", paramQuickSetupDeviceInfoBean);
    localIntent.putExtras(localBundle);
    paramContext.startActivity(localIntent);
  }
  
  private void n1()
  {
    this.p1.b0().observe(this, new a());
  }
  
  public void o1()
  {
    this.I3 = d.g0(this);
  }
  
  public void onBackPressed()
  {
    o1();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362037)
    {
      if (i == 2131362831) {
        o1();
      }
    }
    else {
      h1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558517);
    i1();
    paramBundle = this.y;
    if (paramBundle != null) {
      this.p2 = paramBundle.getDeviceIdMD5();
    }
    this.p3 = d.L(this.y);
    this.H3 = d.W(this.y);
    if (this.p3)
    {
      paramBundle = this.y;
      if (paramBundle == null) {
        paramBundle = "";
      } else {
        paramBundle = paramBundle.getDeviceIdMD5();
      }
      this.p1 = ((QuickSetupViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(QuickSetupViewModel.class));
    }
    else
    {
      this.p1 = ((QuickSetupViewModel)ViewModelProviders.of(this).get(QuickSetupViewModel.class));
    }
    k1();
    n1();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (o.a() == 0) {
      return;
    }
    TPMaterialDialogV2 localTPMaterialDialogV2 = this.I3;
    if ((localTPMaterialDialogV2 != null) && (localTPMaterialDialogV2.isShowing())) {
      this.I3.dismiss();
    }
    this.p1.F();
    if (this.p3) {
      this.p1.F0(this.p2);
    }
    g1();
  }
  
  class a
    implements Observer<Boolean>
  {
    a() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
        FindDeviceFailedActivity.e1(FindDeviceFailedActivity.this);
      } else {
        FindDeviceFailedActivity.f1(FindDeviceFailedActivity.this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\ble\FindDeviceFailedActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */