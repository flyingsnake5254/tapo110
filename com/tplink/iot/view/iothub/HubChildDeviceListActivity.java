package com.tplink.iot.view.iothub;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.iot.Utils.TPLongMaterialDialogV2;
import com.tplink.iot.Utils.TPLongMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPLongMaterialDialogV2.d;
import com.tplink.iot.Utils.extension.i;
import com.tplink.iot.adapter.home.HomeMainAdapter;
import com.tplink.iot.adapter.home.h;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.devicecommon.feature.a;
import com.tplink.iot.devices.switches.view.SwitchDetailActivity;
import com.tplink.iot.devices.trv.view.TRVDetailActivity;
import com.tplink.iot.g.d.a.b;
import com.tplink.iot.model.home.k;
import com.tplink.iot.view.iotsensor.SensorDetailActivity;
import com.tplink.iot.viewmodel.home.u;
import com.tplink.iot.viewmodel.iothub.HubChildDeviceViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HubChildDeviceListActivity
  extends BaseActivity
  implements View.OnClickListener, h
{
  private HubChildDeviceViewModel H3;
  private Toolbar I3;
  private String J3;
  private a K3;
  private TextView p0;
  private TextView p1;
  private RecyclerView p2;
  private HomeMainAdapter p3;
  private View y;
  private View z;
  
  private void f1()
  {
    int i = this.p3.n().size();
    this.I3.setNavigationIcon(2131689570);
    this.I3.setTitle(getResources().getString(2131952843, new Object[] { Integer.valueOf(i) }));
    this.p0.setVisibility(8);
    this.p1.setVisibility(0);
    w1(i);
  }
  
  private void g1()
  {
    this.I3.setNavigationIcon(2131689501);
    this.I3.setTitle(2131952072);
    this.p0.setVisibility(0);
    this.p1.setVisibility(8);
  }
  
  private void h1(@Nullable BaseALIoTDevice paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice == null) {
      return;
    }
    if (paramBaseALIoTDevice.isSensor()) {
      SensorDetailActivity.D1(this, paramBaseALIoTDevice.getDeviceIdMD5());
    } else if (paramBaseALIoTDevice.isSwitch()) {
      SwitchDetailActivity.R1(this, paramBaseALIoTDevice.getDeviceIdMD5());
    } else if (b.k(paramBaseALIoTDevice)) {
      TRVDetailActivity.e2(this, paramBaseALIoTDevice.getDeviceIdMD5());
    }
  }
  
  private void i1(@Nullable BaseALIoTDevice paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice == null) {
      return;
    }
    if (paramBaseALIoTDevice.isOnline()) {
      h1(paramBaseALIoTDevice);
    } else if (paramBaseALIoTDevice.isDeviceOffLine()) {
      u.j(this, paramBaseALIoTDevice.getDeviceType(), paramBaseALIoTDevice.getDeviceModel(), paramBaseALIoTDevice.getDeviceHwVer());
    }
  }
  
  private void j1(@Nullable BaseALIoTDevice paramBaseALIoTDevice, boolean paramBoolean, int paramInt)
  {
    if (paramBaseALIoTDevice == null) {
      return;
    }
    if (TextUtils.isEmpty(paramBaseALIoTDevice.getDeviceIdMD5())) {
      return;
    }
    this.H3.t(paramBaseALIoTDevice, paramBoolean);
    paramBaseALIoTDevice.setDeviceOn(paramBoolean);
    this.p3.notifyDataSetChanged();
  }
  
  private void k1()
  {
    String str = getIntent().getStringExtra("device_id_md5");
    this.J3 = str;
    this.H3 = ((HubChildDeviceViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, str)).get(HubChildDeviceViewModel.class));
  }
  
  private void l1()
  {
    this.H3.h().observe(this, new f(this));
    this.H3.j().observe(this, new d(this));
    this.H3.i().observe(this, new e(this));
  }
  
  private void m1()
  {
    Object localObject = (Toolbar)findViewById(2131364275);
    this.I3 = ((Toolbar)localObject);
    ((Toolbar)localObject).setContentInsetStartWithNavigation(0);
    this.I3.setTitle(2131952072);
    setSupportActionBar(this.I3);
    this.y = findViewById(2131364448);
    this.z = findViewById(2131362326);
    localObject = (RecyclerView)findViewById(2131363820);
    this.p2 = ((RecyclerView)localObject);
    ((RecyclerView)localObject).setLayoutManager(new GridLayoutManager(this, 2));
    this.p0 = ((TextView)findViewById(2131364332));
    this.p1 = ((TextView)findViewById(2131364399));
    this.p0.setOnClickListener(this);
    this.p1.setOnClickListener(this);
    this.K3 = new a();
    localObject = new HomeMainAdapter(this, true);
    this.p3 = ((HomeMainAdapter)localObject);
    ((HomeMainAdapter)localObject).u(this);
    this.p3.setHasStableIds(true);
    this.p2.setAdapter(this.p3);
    i.g(this.p2);
    this.H3.k();
  }
  
  private void v1()
  {
    Object localObject1 = this.p3.n();
    ArrayList localArrayList = new ArrayList();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (com.tplink.iot.model.home.e)((Iterator)localObject1).next();
      if ((localObject2 instanceof k))
      {
        localObject2 = ((k)localObject2).g();
        if (localObject2 != null) {
          localArrayList.add(localObject2);
        }
      }
    }
    this.H3.s(localArrayList);
  }
  
  private void w1(int paramInt)
  {
    if (paramInt == 0)
    {
      this.p1.setEnabled(false);
      this.p1.setAlpha(0.5F);
    }
    else
    {
      this.p1.setEnabled(true);
      this.p1.setAlpha(1.0F);
    }
  }
  
  private void x1()
  {
    new TPLongMaterialDialogV2.Builder(this).g(getString(2131953655)).i(2131952391, 2131099804, null).l(2131953656, 2131099812, new a()).d(8, 8).b(false).c(false).a().show();
  }
  
  public void b(int paramInt)
  {
    w1(paramInt);
    if (this.p3.a()) {
      this.I3.setTitle(getResources().getString(2131952843, new Object[] { Integer.valueOf(paramInt) }));
    }
  }
  
  public void f(int paramInt1, int paramInt2) {}
  
  public void i(com.tplink.iot.model.home.e parame)
  {
    if ((parame instanceof k)) {
      i1(((k)parame).g());
    }
  }
  
  public void j(com.tplink.iot.model.home.e parame)
  {
    f1();
  }
  
  public void l(int paramInt, com.tplink.iot.model.home.e parame, boolean paramBoolean)
  {
    if ((parame instanceof k)) {
      j1(((k)parame).g(), paramBoolean, paramInt);
    }
  }
  
  public void onBackPressed()
  {
    if (this.p3.a())
    {
      this.p3.c(false);
      g1();
    }
    else
    {
      super.onBackPressed();
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131364332)
    {
      if (i == 2131364399) {
        x1();
      }
    }
    else {
      X0(HubAddChildDeviceActivity.class, this.J3);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558540);
    k1();
    m1();
    l1();
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (16908332 == paramMenuItem.getItemId())
    {
      onBackPressed();
      return false;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  @SuppressLint({"NotifyDataSetChanged"})
  protected void onResume()
  {
    super.onResume();
    this.p3.notifyDataSetChanged();
  }
  
  class a
    implements TPLongMaterialDialogV2.d
  {
    a() {}
    
    public void onClick(View paramView)
    {
      HubChildDeviceListActivity.e1(HubChildDeviceListActivity.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iothub\HubChildDeviceListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */