package com.tplink.iot.view.deviceshare;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.q;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.adapter.deviceshare.DeviceShareUserAdapter;
import com.tplink.iot.adapter.deviceshare.DeviceShareUserAdapter.d;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.core.o;
import com.tplink.iot.viewmodel.deviceshare.DeviceShareViewModel;
import com.tplink.iot.viewmodel.home.u;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.DeviceManagerInfoBean;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceUserInfoBean;
import com.tplink.libtpnetwork.enumerate.EnumUserRole;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ShareDeviceUserListActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private MenuItem H3;
  private DeviceShareViewModel p0;
  private List<TCDeviceUserInfoBean> p1 = new ArrayList();
  private DeviceShareUserAdapter p2;
  private BaseALIoTDevice p3;
  private LinearLayout y;
  private LinearLayout z;
  
  private void A1()
  {
    this.p0.F().observe(this, new d());
    this.p0.I().observe(this, new e());
  }
  
  private void B1()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.p3;
    if (localBaseALIoTDevice == null) {
      return;
    }
    if (localBaseALIoTDevice.isCamera()) {
      u.h(this, new f());
    } else {
      o1();
    }
  }
  
  private void C1()
  {
    TPMaterialDialogV2.Builder localBuilder = new TPMaterialDialogV2.Builder(this);
    localBuilder.h(2131953898);
    localBuilder.c(false);
    localBuilder.b(false);
    localBuilder.o(2131953897, 2131099812, new c());
    localBuilder.l(2131952391, 2131099804, null);
    localBuilder.g(8, 8);
    localBuilder.a().show();
  }
  
  private void D1(final int paramInt)
  {
    TPMaterialDialogV2.Builder localBuilder = new TPMaterialDialogV2.Builder(this);
    localBuilder.h(2131953899);
    localBuilder.c(false);
    localBuilder.b(false);
    localBuilder.o(2131952517, 2131099812, new b(paramInt));
    localBuilder.l(2131952391, 2131099804, null);
    localBuilder.g(8, 8);
    localBuilder.a().show();
  }
  
  private void E1()
  {
    Collections.sort(this.p1, new g());
  }
  
  private void F1(List<BaseALIoTDevice> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Object localObject = this.p3;
      if ((localObject != null) && (((BaseALIoTDevice)localObject).isHasThingOrCloudDevice()))
      {
        localObject = paramList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          paramList = (BaseALIoTDevice)((Iterator)localObject).next();
          if ((paramList.isHasThingOrCloudDevice()) && (!TextUtils.isEmpty(paramList.getDeviceId())) && (paramList.getDeviceId().equals(this.p3.getDeviceId())))
          {
            this.p3 = paramList;
            s1();
          }
        }
      }
    }
    G1();
  }
  
  private void G1()
  {
    q1();
    r1();
    if (this.p1.isEmpty())
    {
      this.y.setVisibility(8);
      this.z.setVisibility(0);
    }
    else
    {
      this.y.setVisibility(0);
      this.z.setVisibility(8);
      this.p2.notifyDataSetChanged();
    }
  }
  
  private String m1()
  {
    Object localObject = this.p3;
    if (localObject != null) {
      localObject = ((BaseALIoTDevice)localObject).getDeviceType();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  private void n1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = TPIoTClientManager.I1(((Intent)localObject).getStringExtra("device_id_md5"));
      if (localObject != null) {
        this.p3 = ((BaseALIoTDevice)localObject);
      }
    }
  }
  
  private void o1()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.p3);
    AddShareDeviceActivity.D1(this, localArrayList);
  }
  
  private void p1(TCDeviceUserInfoBean paramTCDeviceUserInfoBean)
  {
    ShareDeviceUserDetailActivity.j1(this, this.p3.getDeviceId(), paramTCDeviceUserInfoBean, this.p3.isSubDevice());
  }
  
  private void q1()
  {
    MenuItem localMenuItem = this.H3;
    if (localMenuItem == null) {
      return;
    }
    List localList = this.p1;
    boolean bool;
    if ((localList != null) && (!localList.isEmpty())) {
      bool = true;
    } else {
      bool = false;
    }
    localMenuItem.setEnabled(bool);
  }
  
  private void r1()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.p3;
    if (localBaseALIoTDevice != null) {
      c1(l.e(this, localBaseALIoTDevice.getDeviceType(), this.p3.getDeviceName(), this.p3.getDeviceModel()));
    } else {
      b1(2131953929);
    }
  }
  
  private void s1()
  {
    Object localObject;
    if (this.p3.getDeviceManagerInfo() != null) {
      localObject = this.p3.getDeviceManagerInfo().getUserInfo();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      this.p1.clear();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TCDeviceUserInfoBean localTCDeviceUserInfoBean = (TCDeviceUserInfoBean)((Iterator)localObject).next();
        if ((localTCDeviceUserInfoBean != null) && (localTCDeviceUserInfoBean.getRole() == EnumUserRole.ROLE_USER)) {
          this.p1.add(localTCDeviceUserInfoBean);
        }
      }
      E1();
      this.p0.Z(this.p1);
      this.p0.Y(this.p1);
    }
  }
  
  private void t1()
  {
    r1();
    this.y = ((LinearLayout)findViewById(2131363277));
    this.z = ((LinearLayout)findViewById(2131363285));
    findViewById(2131364414).setOnClickListener(this);
    E1();
    this.p2 = new DeviceShareUserAdapter(this, this.p1);
    RecyclerView localRecyclerView = (RecyclerView)findViewById(2131363815);
    localRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    localRecyclerView.setItemAnimator(new DefaultItemAnimator());
    localRecyclerView.setAdapter(this.p2);
    this.p2.o(new a());
  }
  
  private boolean u1()
  {
    boolean bool;
    if (this.p1.size() >= a.d(m1())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static void v1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, ShareDeviceUserListActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private void w1()
  {
    s0.p(this, getString(2131952444));
  }
  
  private void x1(List<String> paramList)
  {
    s0.l(this);
    this.p0.S(this.p3.getDeviceId(), paramList, this.p3.isSubDevice());
  }
  
  private void y1()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.p1.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(((TCDeviceUserInfoBean)localIterator.next()).getCloudUserName());
    }
    x1(localArrayList);
  }
  
  private void z1(int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(((TCDeviceUserInfoBean)this.p1.get(paramInt)).getCloudUserName());
    x1(localArrayList);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364414) {
      if (u1()) {
        s0.p(this, a.a(this, m1()));
      } else {
        B1();
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558507);
    this.p0 = ((DeviceShareViewModel)ViewModelProviders.of(this).get(DeviceShareViewModel.class));
    n1();
    t1();
    A1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623953, paramMenu);
    this.H3 = paramMenu.findItem(2131361884);
    q1();
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131361884) {
      C1();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onResume()
  {
    super.onResume();
    BaseALIoTDevice localBaseALIoTDevice = this.p3;
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.isHasThingOrCloudDevice())) {
      this.p0.A(this.p3.getDeviceId(), this.p3.isSubDevice());
    }
  }
  
  class a
    implements DeviceShareUserAdapter.d
  {
    a() {}
    
    public void a(View paramView, int paramInt)
    {
      paramView = ShareDeviceUserListActivity.this;
      ShareDeviceUserListActivity.f1(paramView, (TCDeviceUserInfoBean)ShareDeviceUserListActivity.e1(paramView).get(paramInt));
    }
    
    public void b(View paramView, int paramInt)
    {
      ShareDeviceUserListActivity.g1(ShareDeviceUserListActivity.this, paramInt);
    }
  }
  
  class b
    implements TPMaterialDialogV2.d
  {
    b(int paramInt) {}
    
    public void onClick(View paramView)
    {
      ShareDeviceUserListActivity.h1(ShareDeviceUserListActivity.this, paramInt);
      q.s();
    }
  }
  
  class c
    implements TPMaterialDialogV2.d
  {
    c() {}
    
    public void onClick(View paramView)
    {
      ShareDeviceUserListActivity.i1(ShareDeviceUserListActivity.this);
      q.r();
    }
  }
  
  class d
    implements Observer<List<BaseALIoTDevice>>
  {
    d() {}
    
    public void a(@Nullable List<BaseALIoTDevice> paramList)
    {
      ShareDeviceUserListActivity.j1(ShareDeviceUserListActivity.this, paramList);
    }
  }
  
  class e
    implements Observer<i<CloudResult<Void>>>
  {
    e() {}
    
    public void a(@Nullable i<CloudResult<Void>> parami)
    {
      
      if ((parami == null) || (parami.b() != 0)) {
        ShareDeviceUserListActivity.k1(ShareDeviceUserListActivity.this);
      }
    }
  }
  
  class f
    implements TPMaterialDialogV2.d
  {
    f() {}
    
    public void onClick(View paramView)
    {
      ShareDeviceUserListActivity.l1(ShareDeviceUserListActivity.this);
    }
  }
  
  class g
    implements Comparator<TCDeviceUserInfoBean>
  {
    g() {}
    
    public int a(TCDeviceUserInfoBean paramTCDeviceUserInfoBean1, TCDeviceUserInfoBean paramTCDeviceUserInfoBean2)
    {
      if (paramTCDeviceUserInfoBean1 == null) {
        return 1;
      }
      paramTCDeviceUserInfoBean1 = a.c(paramTCDeviceUserInfoBean1);
      if (TextUtils.isEmpty(paramTCDeviceUserInfoBean1)) {
        return 1;
      }
      if (paramTCDeviceUserInfoBean2 == null) {
        return -1;
      }
      paramTCDeviceUserInfoBean2 = a.c(paramTCDeviceUserInfoBean2);
      if (TextUtils.isEmpty(paramTCDeviceUserInfoBean2)) {
        return -1;
      }
      return paramTCDeviceUserInfoBean1.compareToIgnoreCase(paramTCDeviceUserInfoBean2);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\deviceshare\ShareDeviceUserListActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */