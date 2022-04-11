package com.tplink.iot.view.quicksetup.common;

import android.app.Activity;
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
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.Utils.w;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.Utils.x0.u;
import com.tplink.iot.adapter.quicksetup.PlugIconAdapter;
import com.tplink.iot.adapter.quicksetup.g;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.ble.ConnectWiFiPairActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.QuickSetupViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;
import com.tplink.libtpnetwork.enumerate.EnumIoTAvatarType;
import java.util.ArrayList;
import java.util.List;

public class PlugIconSelectActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TPRefreshableButton H3;
  private String I3;
  private boolean J3;
  private boolean K3;
  private ImageView L3;
  private boolean M3;
  private boolean N3;
  private boolean O3;
  private long P3 = 0L;
  private List<g> p0 = new ArrayList();
  private QuickSetupInfoBean p1;
  private QuickSetupDeviceInfoBean p2;
  private QuickSetupViewModel p3;
  private String y = PlugIconSelectActivity.class.getSimpleName();
  private PlugIconAdapter z = null;
  
  private void A1(boolean paramBoolean)
  {
    if (this.p2 == null) {
      return;
    }
    if (paramBoolean) {
      r.l(this.p1.getDeviceType(), this.p1.getDeviceModel(), this.p1.getDeviceIdMD5());
    } else {
      r.m(this.p1.getDeviceType(), this.p1.getDeviceModel(), this.p1.getDeviceIdMD5());
    }
  }
  
  private void B1()
  {
    Object localObject = this.p1;
    QuickSetupDeviceInfoBean localQuickSetupDeviceInfoBean = null;
    if (localObject != null)
    {
      if (this.J3) {
        ((QuickSetupInfoBean)localObject).setDeviceIdMD5(((QuickSetupInfoBean)localObject).getResultDeviceIdMD5());
      }
      localObject = new CommonQuickSetupBean(this.p1.getDeviceIdMD5(), this.p1.getComponentResult());
    }
    else
    {
      localObject = null;
    }
    if (this.O3) {
      localQuickSetupDeviceInfoBean = this.p2;
    }
    QuickSetupInfoBean localQuickSetupInfoBean = this.p1;
    long l;
    if (localQuickSetupInfoBean != null) {
      l = localQuickSetupInfoBean.getOnboardingStartTime();
    } else {
      l = 0L;
    }
    SetupSuccessActivity.p1(this, (CommonQuickSetupBean)localObject, localQuickSetupDeviceInfoBean, l);
    z1();
    finish();
  }
  
  private void C1()
  {
    Object localObject = this.z.n();
    this.p2.setAvatar(((EnumIoTAvatarType)localObject).getName());
    localObject = this.p1;
    int i;
    if (localObject != null) {
      i = d.x(((QuickSetupInfoBean)localObject).getComponentResult());
    } else {
      i = 1;
    }
    localObject = new QuickSetupDeviceInfoBean(this.p2.getNickname(), this.p2.getAvatar());
    if (!this.K3) {
      ((QuickSetupDeviceInfoBean)localObject).setLocation(this.p2.getLocation());
    }
    this.p3.J0((QuickSetupDeviceInfoBean)localObject, i);
    if (this.K3) {
      this.p3.I0(this.p1.getResultDeviceId(), this.p2.getLocation());
    }
  }
  
  private void D1()
  {
    this.p3.f0().observe(this, new a());
    this.p3.b0().observe(this, new b());
  }
  
  private void q1()
  {
    TPRefreshableButton localTPRefreshableButton = this.H3;
    if (localTPRefreshableButton != null)
    {
      localTPRefreshableButton.setText(getString(2131954363));
      this.H3.h();
    }
  }
  
  private void r1()
  {
    this.P3 = System.currentTimeMillis();
    this.p3.P(this.p1.getResultDeviceIdMD5(), this.J3, this.K3);
  }
  
  private void s1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null)
      {
        this.p1 = ((QuickSetupInfoBean)((Bundle)localObject).getSerializable("device_info_bean"));
        this.p2 = ((QuickSetupDeviceInfoBean)((Bundle)localObject).getSerializable("device_info"));
      }
    }
  }
  
  private void t1()
  {
    QuickSetupInfoBean localQuickSetupInfoBean = this.p1;
    QuickSetupDeviceInfoBean localQuickSetupDeviceInfoBean;
    if (this.O3) {
      localQuickSetupDeviceInfoBean = this.p2;
    } else {
      localQuickSetupDeviceInfoBean = null;
    }
    ConnectWiFiPairActivity.r1(this, localQuickSetupInfoBean, localQuickSetupDeviceInfoBean);
    y1();
    finish();
  }
  
  private void u1()
  {
    if (this.J3) {
      this.N3 = true;
    }
    B1();
  }
  
  private void v1()
  {
    String str = d.q(this.p1);
    for (EnumIoTAvatarType localEnumIoTAvatarType : EnumIoTAvatarType.values()) {
      if ((!w.b()) || (!"P105".equals(str)) || (w.e(localEnumIoTAvatarType)))
      {
        new g().c(localEnumIoTAvatarType);
        this.p0.add(new g(localEnumIoTAvatarType));
      }
    }
    ((g)this.p0.get(0)).d(true);
  }
  
  private void w1()
  {
    Object localObject = (ImageView)findViewById(2131362826);
    this.L3 = ((ImageView)localObject);
    ((ImageView)localObject).setOnClickListener(this);
    localObject = (RecyclerView)findViewById(2131362800);
    ((RecyclerView)localObject).setLayoutManager(new GridLayoutManager(this, 3));
    ((RecyclerView)localObject).setItemAnimator(new DefaultItemAnimator());
    PlugIconAdapter localPlugIconAdapter = new PlugIconAdapter(this, this.p0);
    this.z = localPlugIconAdapter;
    ((RecyclerView)localObject).setAdapter(localPlugIconAdapter);
    localObject = (TPRefreshableButton)findViewById(2131362037);
    this.H3 = ((TPRefreshableButton)localObject);
    ((TPRefreshableButton)localObject).setOnClickListener(this);
  }
  
  private void x1(i<Boolean> parami)
  {
    if ((parami != null) && (parami.b() != 0)) {
      u.g(parami.b());
    }
  }
  
  private void y1()
  {
    if (this.p1 != null)
    {
      int i = (int)((System.currentTimeMillis() - this.P3) / 1000L);
      r.v(this.p1.getDeviceType(), this.p1.getDeviceModel(), this.p1.getDeviceIdMD5(), i);
    }
  }
  
  private void z1()
  {
    if (this.p1 != null)
    {
      int i = (int)((System.currentTimeMillis() - this.P3) / 1000L);
      r.u(this.p1.getDeviceType(), this.p1.getDeviceModel(), this.p1.getDeviceIdMD5(), i);
    }
  }
  
  public void onBackPressed()
  {
    if (!this.M3) {
      super.onBackPressed();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362037)
    {
      if (i == 2131362826) {
        finish();
      }
    }
    else
    {
      this.M3 = true;
      this.L3.setVisibility(4);
      if (this.J3) {
        C1();
      } else {
        r1();
      }
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558626);
    s1();
    paramBundle = this.p1;
    if (paramBundle != null) {
      this.I3 = paramBundle.getDeviceIdMD5();
    }
    this.J3 = d.L(this.p1);
    this.K3 = d.W(this.p1);
    if (this.J3)
    {
      paramBundle = this.p1;
      if (paramBundle == null) {
        paramBundle = "";
      } else {
        paramBundle = paramBundle.getDeviceIdMD5();
      }
      this.p3 = ((QuickSetupViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(QuickSetupViewModel.class));
    }
    else
    {
      this.p3 = ((QuickSetupViewModel)ViewModelProviders.of(this).get(QuickSetupViewModel.class));
    }
    v1();
    w1();
    D1();
  }
  
  protected void onDestroy()
  {
    QuickSetupViewModel localQuickSetupViewModel = this.p3;
    if (localQuickSetupViewModel != null)
    {
      localQuickSetupViewModel.F();
      if (this.N3) {
        this.p3.F0(this.I3);
      }
    }
    q1();
    super.onDestroy();
  }
  
  class a
    implements Observer<i<Boolean>>
  {
    a() {}
    
    public void a(@Nullable i<Boolean> parami)
    {
      PlugIconSelectActivity localPlugIconSelectActivity = PlugIconSelectActivity.this;
      boolean bool;
      if ((parami != null) && (parami.b() == 0)) {
        bool = false;
      } else {
        bool = true;
      }
      PlugIconSelectActivity.f1(localPlugIconSelectActivity, bool);
      localPlugIconSelectActivity = PlugIconSelectActivity.this;
      PlugIconSelectActivity.g1(localPlugIconSelectActivity, PlugIconSelectActivity.e1(localPlugIconSelectActivity));
      if (PlugIconSelectActivity.i1(PlugIconSelectActivity.this))
      {
        if (PlugIconSelectActivity.j1(PlugIconSelectActivity.this)) {
          PlugIconSelectActivity.l1(PlugIconSelectActivity.this).F0(PlugIconSelectActivity.k1(PlugIconSelectActivity.this));
        }
        PlugIconSelectActivity.m1(PlugIconSelectActivity.this);
      }
      else
      {
        PlugIconSelectActivity.n1(PlugIconSelectActivity.this);
        PlugIconSelectActivity.o1(PlugIconSelectActivity.this, parami);
      }
    }
  }
  
  class b
    implements Observer<Boolean>
  {
    b() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      if ((paramBoolean != null) && (paramBoolean.booleanValue()))
      {
        if (PlugIconSelectActivity.i1(PlugIconSelectActivity.this)) {
          PlugIconSelectActivity.n1(PlugIconSelectActivity.this);
        } else {
          PlugIconSelectActivity.p1(PlugIconSelectActivity.this);
        }
      }
      else {
        PlugIconSelectActivity.h1(PlugIconSelectActivity.this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\common\PlugIconSelectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */