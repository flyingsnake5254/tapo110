package com.tplink.iot.view.quicksetup.bulb;

import android.app.Activity;
import android.content.Intent;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.iot.Utils.g0;
import com.tplink.iot.adapter.quicksetup.BulbSSIDAdapter;
import com.tplink.iot.adapter.quicksetup.f;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.libtpwifi.TPWifiScanReceiver;
import com.tplink.libtpwifi.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class SoftAPBulbSSIDListActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private Handler p0;
  private TPWifiScanReceiver p1;
  private QuickSetupInfoBundle p2;
  private BulbSSIDAdapter y;
  private List<ScanResult> z = new ArrayList();
  
  private void i1()
  {
    if (!com.tplink.iot.view.quicksetup.base.wifi.d.a(this))
    {
      k1();
      return;
    }
    Object localObject = this.p1;
    if (localObject == null)
    {
      k1();
      return;
    }
    localObject = ((TPWifiScanReceiver)localObject).a();
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      localObject = com.tplink.iot.view.quicksetup.base.d.z((List)localObject, this.p2.getDeviceModel());
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        this.z.clear();
        this.z.addAll((Collection)localObject);
        n1();
      }
      else
      {
        k1();
      }
      return;
    }
    k1();
  }
  
  private void j1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      Bundle localBundle = ((Intent)localObject).getExtras();
      if (localBundle != null)
      {
        localObject = (List)localBundle.getSerializable("bulb_ssid_list");
        if ((localObject != null) && (!((List)localObject).isEmpty())) {
          this.z.addAll((Collection)localObject);
        }
        this.p2 = ((QuickSetupInfoBundle)localBundle.getSerializable("quick_setup_bundle"));
      }
    }
  }
  
  private void k1()
  {
    SoftAPBulbSSIDEmptyActivity.n1(this, this.p2);
    finish();
  }
  
  private void l1()
  {
    this.p0 = new Handler();
    findViewById(2131363002).setOnClickListener(this);
    findViewById(2131364602).setOnClickListener(this);
    this.y = new BulbSSIDAdapter(this, this.z);
    Object localObject = (RecyclerView)findViewById(2131364095);
    ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager(this));
    ((RecyclerView)localObject).setItemAnimator(new DefaultItemAnimator());
    ((RecyclerView)localObject).setAdapter(this.y);
    this.y.o(new a());
    localObject = this.z;
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      n1();
    } else {
      k1();
    }
  }
  
  private void m1()
  {
    if (this.p1 == null)
    {
      TPWifiScanReceiver localTPWifiScanReceiver = new TPWifiScanReceiver();
      this.p1 = localTPWifiScanReceiver;
      registerReceiver(localTPWifiScanReceiver, TPWifiScanReceiver.b());
    }
  }
  
  private void n1()
  {
    o1();
    this.y.notifyDataSetChanged();
  }
  
  private void o1()
  {
    List localList = this.z;
    if ((localList != null) && (localList.size() > 1)) {
      g0.a(this.z, new c());
    }
  }
  
  private void p1()
  {
    TPWifiScanReceiver localTPWifiScanReceiver = this.p1;
    if (localTPWifiScanReceiver != null)
    {
      unregisterReceiver(localTPWifiScanReceiver);
      this.p1 = null;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131363002)
    {
      if (i == 2131364602) {
        if (com.tplink.iot.view.quicksetup.base.wifi.d.a(this))
        {
          b.k().s();
          this.p0.postDelayed(new b(), 10000L);
        }
        else
        {
          k1();
        }
      }
    }
    else {
      onBackPressed();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558677);
    j1();
    m1();
    l1();
  }
  
  public void onDestroy()
  {
    Handler localHandler = this.p0;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    p1();
    super.onDestroy();
  }
  
  class a
    implements f
  {
    a() {}
    
    public void a(View paramView, int paramInt)
    {
      if (com.tplink.iot.view.quicksetup.base.wifi.d.a(SoftAPBulbSSIDListActivity.this))
      {
        paramView = (ScanResult)SoftAPBulbSSIDListActivity.e1(SoftAPBulbSSIDListActivity.this).get(paramInt);
        SoftAPBulbSSIDListActivity localSoftAPBulbSSIDListActivity = SoftAPBulbSSIDListActivity.this;
        SoftAPConnectBulbActivity.q2(localSoftAPBulbSSIDListActivity, paramView.SSID, SoftAPBulbSSIDListActivity.f1(localSoftAPBulbSSIDListActivity));
      }
      else
      {
        SoftAPBulbSSIDListActivity.g1(SoftAPBulbSSIDListActivity.this);
      }
    }
  }
  
  class b
    implements Runnable
  {
    b() {}
    
    public void run()
    {
      if (SoftAPBulbSSIDListActivity.this.isDestroyed()) {
        return;
      }
      SoftAPBulbSSIDListActivity.h1(SoftAPBulbSSIDListActivity.this);
    }
  }
  
  class c
    implements Comparator<ScanResult>
  {
    c() {}
    
    public int a(ScanResult paramScanResult1, ScanResult paramScanResult2)
    {
      return paramScanResult1.level - paramScanResult2.level;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\bulb\SoftAPBulbSSIDListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */