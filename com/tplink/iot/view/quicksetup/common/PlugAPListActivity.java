package com.tplink.iot.view.quicksetup.common;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.d0.g;
import com.tplink.iot.Utils.g0;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.adapter.quicksetup.PlugScanAPListAdapter;
import com.tplink.iot.adapter.quicksetup.f;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.base.QuickSetupInfoBean;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.ble.BlePlugConnectAPActivity;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.WirelessScanInfoBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class PlugAPListActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TPMaterialDialogV2 p0;
  private boolean p1;
  private QuickSetupInfoBean y;
  private List<WirelessScanInfoBean> z = new ArrayList();
  
  private void j1()
  {
    Object localObject1 = getIntent();
    if (localObject1 != null)
    {
      localObject1 = ((Intent)localObject1).getExtras();
      if (localObject1 != null)
      {
        this.y = ((QuickSetupInfoBean)((Bundle)localObject1).getSerializable("device_info_bean"));
        Object localObject2 = (List)((Bundle)localObject1).getSerializable("ap_ssid_list");
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          localObject1 = new ArrayList();
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            WirelessScanInfoBean localWirelessScanInfoBean = (WirelessScanInfoBean)((Iterator)localObject2).next();
            if ("wep".equalsIgnoreCase(localWirelessScanInfoBean.getKeyType())) {
              ((List)localObject1).add(localWirelessScanInfoBean);
            } else {
              this.z.add(localWirelessScanInfoBean);
            }
          }
          y1(this.z);
          y1((List)localObject1);
          this.z.addAll((Collection)localObject1);
        }
      }
    }
  }
  
  private void k1(WirelessScanInfoBean paramWirelessScanInfoBean)
  {
    WirelessInfoParams localWirelessInfoParams = new WirelessInfoParams(paramWirelessScanInfoBean.getSsid(), paramWirelessScanInfoBean.getKeyType());
    d.D(this, ApPasswordInputActivity.class, this.y, localWirelessInfoParams);
    v1(paramWirelessScanInfoBean);
  }
  
  private void l1()
  {
    d.D(this, ApNamePasswordInputActivity.class, this.y, null);
    t1();
  }
  
  private void m1()
  {
    d.D(this, NoFindAPActivity.class, this.y, null);
  }
  
  private void n1(WirelessScanInfoBean paramWirelessScanInfoBean)
  {
    WirelessInfoParams localWirelessInfoParams = new WirelessInfoParams(paramWirelessScanInfoBean.getSsid(), paramWirelessScanInfoBean.getKeyType());
    d.E(this, BlePlugConnectAPActivity.class, this.y, localWirelessInfoParams, 160);
    v1(paramWirelessScanInfoBean);
  }
  
  private void o1()
  {
    ((ImageView)findViewById(2131362325)).setOnClickListener(this);
    ((TextView)findViewById(2131364603)).setOnClickListener(this);
  }
  
  private void p1()
  {
    PlugScanAPListAdapter localPlugScanAPListAdapter = new PlugScanAPListAdapter(this, this.z);
    RecyclerView localRecyclerView = (RecyclerView)findViewById(2131364095);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    localRecyclerView.setItemAnimator(new DefaultItemAnimator());
    localRecyclerView.setAdapter(localPlugScanAPListAdapter);
    localPlugScanAPListAdapter.o(new a());
    d0.h((TextView)findViewById(2131364549), getString(2131953493), ContextCompat.getColor(this, 2131099811), new b());
  }
  
  private void q1()
  {
    ((Button)findViewById(2131362037)).setOnClickListener(this);
    ((Button)findViewById(2131362084)).setOnClickListener(this);
    d0.h((TextView)findViewById(2131364353), getString(2131953493), ContextCompat.getColor(this, 2131099811), new c());
  }
  
  private void r1()
  {
    View localView1 = findViewById(2131364790);
    View localView2 = findViewById(2131364797);
    o1();
    List localList = this.z;
    if ((localList != null) && (!localList.isEmpty()))
    {
      localView1.setVisibility(0);
      localView2.setVisibility(8);
      p1();
    }
    else
    {
      localView2.setVisibility(0);
      localView1.setVisibility(8);
      q1();
    }
  }
  
  private void s1(int paramInt)
  {
    if (paramInt >= this.z.size())
    {
      l1();
    }
    else
    {
      WirelessScanInfoBean localWirelessScanInfoBean = (WirelessScanInfoBean)this.z.get(paramInt);
      if ("none".equals(localWirelessScanInfoBean.getKeyType())) {
        x1(localWirelessScanInfoBean);
      } else {
        k1(localWirelessScanInfoBean);
      }
    }
  }
  
  private void t1()
  {
    QuickSetupInfoBean localQuickSetupInfoBean = this.y;
    if (localQuickSetupInfoBean != null) {
      r.f(localQuickSetupInfoBean.getDeviceType(), this.y.getDeviceModel(), this.y.getDeviceIdMD5());
    }
  }
  
  private void u1()
  {
    QuickSetupInfoBean localQuickSetupInfoBean = this.y;
    if (localQuickSetupInfoBean != null) {
      r.n(localQuickSetupInfoBean.getDeviceType(), this.y.getDeviceModel(), this.y.getDeviceIdMD5());
    }
  }
  
  private void v1(WirelessScanInfoBean paramWirelessScanInfoBean)
  {
    QuickSetupInfoBean localQuickSetupInfoBean = this.y;
    if (localQuickSetupInfoBean != null) {
      r.q(localQuickSetupInfoBean.getDeviceType(), this.y.getDeviceModel(), this.y.getDeviceIdMD5(), paramWirelessScanInfoBean.getSignalLevel(), paramWirelessScanInfoBean.getKeyType());
    }
  }
  
  private void w1()
  {
    d.e0(this, new f());
  }
  
  private void x1(final WirelessScanInfoBean paramWirelessScanInfoBean)
  {
    paramWirelessScanInfoBean = new TPMaterialDialogV2.Builder(this).h(2131953503).l(2131952391, 2131099804, null).o(2131953504, 2131099808, new e(paramWirelessScanInfoBean)).g(8, 8).a();
    this.p0 = paramWirelessScanInfoBean;
    paramWirelessScanInfoBean.show();
  }
  
  private void y1(List<WirelessScanInfoBean> paramList)
  {
    if ((paramList != null) && (paramList.size() > 1)) {
      g0.a(paramList, new d());
    }
  }
  
  private void z1(WirelessScanInfoBean paramWirelessScanInfoBean)
  {
    n1(paramWirelessScanInfoBean);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 != 160)
    {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
      return;
    }
    switch (paramInt2)
    {
    default: 
      break;
    case -1703: 
      s0.r(this, getString(2131953520), 5000L);
      break;
    case -1704: 
      s0.r(this, getString(2131953508), 5000L);
      break;
    case -1705: 
      s0.r(this, getString(2131953525), 5000L);
    }
  }
  
  public void onBackPressed()
  {
    w1();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131362325: 
      w1();
      break;
    case 2131362084: 
      l1();
      break;
    case 2131362037: 
    case 2131364603: 
      setResult(-1);
      u1();
      finish();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558599);
    j1();
    r1();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    TPMaterialDialogV2 localTPMaterialDialogV2 = this.p0;
    if (localTPMaterialDialogV2 != null)
    {
      localTPMaterialDialogV2.dismiss();
      this.p0 = null;
    }
    s0.g();
    if (this.p1) {
      d.h(this.y);
    }
  }
  
  class a
    implements f
  {
    a() {}
    
    public void a(View paramView, int paramInt)
    {
      PlugAPListActivity.e1(PlugAPListActivity.this, paramInt);
    }
  }
  
  class b
    implements d0.g
  {
    b() {}
    
    public void a()
    {
      PlugAPListActivity.f1(PlugAPListActivity.this);
    }
  }
  
  class c
    implements d0.g
  {
    c() {}
    
    public void a()
    {
      PlugAPListActivity.f1(PlugAPListActivity.this);
    }
  }
  
  class d
    implements Comparator<WirelessScanInfoBean>
  {
    d() {}
    
    public int a(WirelessScanInfoBean paramWirelessScanInfoBean1, WirelessScanInfoBean paramWirelessScanInfoBean2)
    {
      return paramWirelessScanInfoBean2.getSignalLevel() - paramWirelessScanInfoBean1.getSignalLevel();
    }
  }
  
  class e
    implements TPMaterialDialogV2.d
  {
    e(WirelessScanInfoBean paramWirelessScanInfoBean) {}
    
    public void onClick(View paramView)
    {
      PlugAPListActivity.g1(PlugAPListActivity.this, paramWirelessScanInfoBean);
    }
  }
  
  class f
    implements TPMaterialDialogV2.d
  {
    f() {}
    
    public void onClick(View paramView)
    {
      PlugAPListActivity.h1(PlugAPListActivity.this, true);
      d.Z(PlugAPListActivity.i1(PlugAPListActivity.this), "ChooseWiFiPage");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\common\PlugAPListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */