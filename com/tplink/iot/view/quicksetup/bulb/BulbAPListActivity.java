package com.tplink.iot.view.quicksetup.bulb;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialog;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.d0.g;
import com.tplink.iot.Utils.g0;
import com.tplink.iot.Utils.x0.r;
import com.tplink.iot.adapter.quicksetup.PlugScanAPListAdapter;
import com.tplink.iot.adapter.quicksetup.f;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.view.quicksetup.base.e;
import com.tplink.iot.view.quicksetup.bulb.utils.QuickSetupInfoBundle;
import com.tplink.iot.view.quicksetup.bulb.utils.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.params.WirelessInfoParams;
import com.tplink.libtpnetwork.IoTNetwork.bean.quicksetup.result.WirelessScanInfoBean;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class BulbAPListActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TPMaterialDialogV2 p0;
  private e p1;
  private WirelessScanInfoBean p2;
  private QuickSetupInfoBundle y;
  private List<WirelessScanInfoBean> z = new ArrayList();
  
  private void h1()
  {
    Object localObject1 = getIntent();
    if (localObject1 != null)
    {
      localObject1 = ((Intent)localObject1).getExtras();
      if (localObject1 != null)
      {
        this.y = ((QuickSetupInfoBundle)((Bundle)localObject1).getSerializable("quick_setup_bundle"));
        Object localObject2 = (List)((Bundle)localObject1).getSerializable("ap_ssid_list");
        if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
        {
          localObject1 = new ArrayList();
          Iterator localIterator = ((List)localObject2).iterator();
          while (localIterator.hasNext())
          {
            localObject2 = (WirelessScanInfoBean)localIterator.next();
            if ("wep".equalsIgnoreCase(((WirelessScanInfoBean)localObject2).getKeyType())) {
              ((List)localObject1).add(localObject2);
            } else {
              this.z.add(localObject2);
            }
          }
          u1(this.z);
          u1((List)localObject1);
          this.z.addAll((Collection)localObject1);
        }
        o1();
      }
    }
  }
  
  private WirelessInfoParams i1()
  {
    Object localObject = this.p2;
    if (localObject != null) {
      localObject = new WirelessInfoParams(((WirelessScanInfoBean)localObject).getSsid(), this.p2.getKeyType());
    } else {
      localObject = null;
    }
    return (WirelessInfoParams)localObject;
  }
  
  private void j1()
  {
    BulbApPasswordInputActivity.o1(this, this.y, i1());
    r.q(this.y.getDeviceType(), this.y.getDeviceModel(), this.y.getDeviceIdMD5(), this.p2.getSignalLevel(), this.p2.getKeyType());
  }
  
  private void k1()
  {
    BulbApNamePasswordInputActivity.q1(this, this.y);
    r.f(this.y.getDeviceType(), this.y.getDeviceModel(), this.y.getDeviceIdMD5());
  }
  
  private void l1()
  {
    SoftAPBulbConnectAPActivity.y1(this, this.y, i1());
    r.q(this.y.getDeviceType(), this.y.getDeviceModel(), this.y.getDeviceIdMD5(), this.p2.getSignalLevel(), this.p2.getKeyType());
  }
  
  private void m1()
  {
    BulbInheritBeforeSetQsInfoActivity.h1(this, this.y, i1());
  }
  
  private void n1()
  {
    BulbApNoFindAPActivity.i1(this, this.y);
  }
  
  private void o1()
  {
    Object localObject = com.tplink.libtpnetwork.Utils.o.h0().z();
    if ((!this.z.isEmpty()) && (localObject != null) && (!((List)localObject).isEmpty()))
    {
      WirelessInfoParams localWirelessInfoParams;
      do
      {
        Iterator localIterator1 = ((List)localObject).iterator();
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localWirelessInfoParams = (WirelessInfoParams)localIterator1.next();
          localIterator2 = this.z.iterator();
        }
        localObject = (WirelessScanInfoBean)localIterator2.next();
      } while ((!TextUtils.equals(((WirelessScanInfoBean)localObject).getSsid(), localWirelessInfoParams.getSsid())) || (TextUtils.isEmpty(localWirelessInfoParams.getPassword())));
      r.p(this.y.getDeviceType(), this.y.getDeviceModel(), this.y.getDeviceIdMD5(), true);
      this.p2 = ((WirelessScanInfoBean)localObject);
      j1();
      return;
      r.p(this.y.getDeviceType(), this.y.getDeviceModel(), this.y.getDeviceIdMD5(), false);
    }
  }
  
  private void p1()
  {
    this.p1 = new e(this);
    ((ImageView)findViewById(2131362325)).setOnClickListener(this);
    ((TextView)findViewById(2131364603)).setOnClickListener(this);
    PlugScanAPListAdapter localPlugScanAPListAdapter = new PlugScanAPListAdapter(this, this.z);
    RecyclerView localRecyclerView = (RecyclerView)findViewById(2131364095);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    localRecyclerView.setItemAnimator(new DefaultItemAnimator());
    localRecyclerView.setAdapter(localPlugScanAPListAdapter);
    localPlugScanAPListAdapter.o(new a());
    d0.h((TextView)findViewById(2131364549), getString(2131953493), ContextCompat.getColor(this, 2131099811), new b());
  }
  
  private void q1(int paramInt)
  {
    if (paramInt >= this.z.size())
    {
      k1();
    }
    else
    {
      WirelessScanInfoBean localWirelessScanInfoBean = (WirelessScanInfoBean)this.z.get(paramInt);
      this.p2 = localWirelessScanInfoBean;
      if ("none".equals(localWirelessScanInfoBean.getKeyType())) {
        t1();
      } else {
        j1();
      }
    }
  }
  
  private void r1()
  {
    if (a.f(this, this.y)) {
      l1();
    } else {
      this.p1.d(this.y.getBulbSSID());
    }
  }
  
  private void s1()
  {
    a.h(this, this.y.getDeviceType(), this.y.getDeviceModel(), "ChooseWiFiPage");
  }
  
  private void t1()
  {
    TPMaterialDialogV2 localTPMaterialDialogV2 = new TPMaterialDialogV2.Builder(this).h(2131953503).l(2131952391, 2131099804, null).o(2131953504, 2131099808, new d()).g(8, 8).a();
    this.p0 = localTPMaterialDialogV2;
    localTPMaterialDialogV2.show();
  }
  
  private void u1(List<WirelessScanInfoBean> paramList)
  {
    if ((paramList != null) && (paramList.size() > 1)) {
      g0.a(paramList, new c());
    }
  }
  
  private void v1()
  {
    if (this.y.inNeedDisplayInherit()) {
      m1();
    } else {
      r1();
    }
  }
  
  public void onBackPressed()
  {
    s1();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362325)
    {
      if (i == 2131364603)
      {
        setResult(-1);
        finish();
      }
    }
    else {
      s1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (com.tplink.iot.core.o.a() == 0) {
      return;
    }
    setContentView(2131558666);
    h1();
    p1();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.p0;
    if (localObject != null)
    {
      ((AppCompatDialog)localObject).dismiss();
      this.p0 = null;
    }
    localObject = this.p1;
    if (localObject != null) {
      ((e)localObject).b();
    }
  }
  
  class a
    implements f
  {
    a() {}
    
    public void a(View paramView, int paramInt)
    {
      BulbAPListActivity.e1(BulbAPListActivity.this, paramInt);
    }
  }
  
  class b
    implements d0.g
  {
    b() {}
    
    public void a()
    {
      BulbAPListActivity.f1(BulbAPListActivity.this);
    }
  }
  
  class c
    implements Comparator<WirelessScanInfoBean>
  {
    c() {}
    
    public int a(WirelessScanInfoBean paramWirelessScanInfoBean1, WirelessScanInfoBean paramWirelessScanInfoBean2)
    {
      return paramWirelessScanInfoBean2.getSignalLevel() - paramWirelessScanInfoBean1.getSignalLevel();
    }
  }
  
  class d
    implements TPMaterialDialogV2.d
  {
    d() {}
    
    public void onClick(View paramView)
    {
      BulbAPListActivity.g1(BulbAPListActivity.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\bulb\BulbAPListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */