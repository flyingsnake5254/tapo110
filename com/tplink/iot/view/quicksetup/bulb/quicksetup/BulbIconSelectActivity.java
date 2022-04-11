package com.tplink.iot.view.quicksetup.bulb.quicksetup;

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
import androidx.recyclerview.widget.RecyclerView.Adapter;
import b.d.w.c.a;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.adapter.quicksetup.IoTIconAdapter;
import com.tplink.iot.adapter.quicksetup.e;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.iot.view.quicksetup.bulb.utils.b;
import com.tplink.iot.view.quicksetup.common.CommonQuickSetupBean;
import com.tplink.iot.view.quicksetup.common.SetupSuccessActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.bulb.BulbQuickSetupViewModel;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.QuickSetupDeviceInfoBean;
import com.tplink.libtpnetwork.enumerate.EnumIoTAvatarType;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BulbIconSelectActivity
  extends BaseActivity
  implements View.OnClickListener
{
  boolean H3 = false;
  private QuickSetupInfoBundle p0;
  private QuickSetupDeviceInfoBean p1;
  private BulbQuickSetupViewModel p2;
  private TPRefreshableButton p3;
  private final String y = "BulbIconSelectActivity";
  private IoTIconAdapter z;
  
  private void f1()
  {
    TPRefreshableButton localTPRefreshableButton = this.p3;
    if (localTPRefreshableButton != null)
    {
      localTPRefreshableButton.setText(getString(2131954363));
      this.p3.h();
    }
  }
  
  private void g1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null)
      {
        this.p0 = ((QuickSetupInfoBundle)((Bundle)localObject).getSerializable("quick_setup_bundle"));
        this.p1 = ((QuickSetupDeviceInfoBean)((Bundle)localObject).getSerializable("device_info"));
      }
    }
  }
  
  private void h1(boolean paramBoolean)
  {
    CommonQuickSetupBean localCommonQuickSetupBean = new CommonQuickSetupBean(this.p0.getDeviceIdMD5(), this.p0.getComponentResult());
    localCommonQuickSetupBean.setFromQuickDiscovery(this.p0.isFromQuickDiscovery());
    QuickSetupDeviceInfoBean localQuickSetupDeviceInfoBean;
    if (paramBoolean) {
      localQuickSetupDeviceInfoBean = this.p1;
    } else {
      localQuickSetupDeviceInfoBean = null;
    }
    SetupSuccessActivity.p1(this, localCommonQuickSetupBean, localQuickSetupDeviceInfoBean, this.p0.getOnboardingStartTime());
    j1(paramBoolean);
    finish();
  }
  
  private void i1()
  {
    ((ImageView)findViewById(2131362826)).setOnClickListener(this);
    TPRefreshableButton localTPRefreshableButton = (TPRefreshableButton)findViewById(2131362037);
    this.p3 = localTPRefreshableButton;
    localTPRefreshableButton.setOnClickListener(this);
    m1();
  }
  
  private void j1(boolean paramBoolean)
  {
    if (paramBoolean) {
      r.l(this.p0.getDeviceType(), this.p0.getDeviceModel(), this.p0.getDeviceIdMD5());
    } else {
      r.m(this.p0.getDeviceType(), this.p0.getDeviceModel(), this.p0.getDeviceIdMD5());
    }
  }
  
  private void k1()
  {
    a.d("setDeviceInfo");
    Object localObject = this.z;
    if (localObject != null) {
      localObject = ((IoTIconAdapter)localObject).o();
    } else {
      localObject = EnumIoTAvatarType.PLUG.getName();
    }
    this.p1.setAvatar((String)localObject);
    this.p2.G0(this.p1, d.x(this.p0.getComponentResult()));
    if (!this.H3)
    {
      a.d("setDeviceInfo setDeviceFamilyAndRoom2Cloud");
      this.p2.A0(this.p1.getLocation());
      this.H3 = true;
    }
  }
  
  private void l1()
  {
    this.p2.b0().observe(this, new a());
  }
  
  private void m1()
  {
    Object localObject1 = new ArrayList();
    Object localObject2 = b.m(this.p0.getDeviceModel()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      new e().c(str);
      ((List)localObject1).add(new e(str, false));
    }
    ((e)((List)localObject1).get(0)).d(true);
    localObject2 = (RecyclerView)findViewById(2131362800);
    ((RecyclerView)localObject2).setLayoutManager(new GridLayoutManager(this, 3));
    ((RecyclerView)localObject2).setItemAnimator(new DefaultItemAnimator());
    localObject1 = new IoTIconAdapter((List)localObject1, b.l(this.p0.getDeviceModel()), this.p0.getDeviceModel());
    this.z = ((IoTIconAdapter)localObject1);
    ((RecyclerView)localObject2).setAdapter((RecyclerView.Adapter)localObject1);
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
    else {
      k1();
    }
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558626);
    g1();
    paramBundle = this.p0;
    if (paramBundle == null) {
      paramBundle = "";
    } else {
      paramBundle = paramBundle.getDeviceIdMD5();
    }
    this.p2 = ((BulbQuickSetupViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(BulbQuickSetupViewModel.class));
    i1();
    l1();
  }
  
  protected void onDestroy()
  {
    f1();
    super.onDestroy();
  }
  
  class a
    implements Observer<i<Boolean>>
  {
    a() {}
    
    public void a(@Nullable i<Boolean> parami)
    {
      boolean bool;
      if ((parami != null) && (parami.b() == 0)) {
        bool = false;
      } else {
        bool = true;
      }
      BulbIconSelectActivity.e1(BulbIconSelectActivity.this, bool);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\bulb\quicksetup\BulbIconSelectActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */