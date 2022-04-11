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
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
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
import com.tplink.iot.Utils.TPMaterialDialogV3;
import com.tplink.iot.Utils.TPMaterialDialogV3.Builder;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.q;
import com.tplink.iot.Utils.z0.g;
import com.tplink.iot.adapter.deviceshare.DeviceShareOwnerSharedAdapter;
import com.tplink.iot.adapter.deviceshare.DeviceShareOwnerSharedAdapter.d;
import com.tplink.iot.adapter.deviceshare.DeviceShareOwnerUnsharedAdapter;
import com.tplink.iot.adapter.deviceshare.DeviceSharePullingAdapter;
import com.tplink.iot.adapter.deviceshare.DeviceSharePullingAdapter.d;
import com.tplink.iot.adapter.deviceshare.DeviceShareUserDeviceAdapter;
import com.tplink.iot.adapter.deviceshare.DeviceShareUserDeviceAdapter.d;
import com.tplink.iot.adapter.quicksetup.f;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.share.EnumDeviceShareAction;
import com.tplink.iot.cloud.bean.share.params.DeviceShareActionListParams;
import com.tplink.iot.cloud.bean.share.params.DeviceShareActionParams;
import com.tplink.iot.cloud.bean.share.result.ShareDeviceResult;
import com.tplink.iot.core.o;
import com.tplink.iot.devices.switches.view.SwitchDetailActivity;
import com.tplink.iot.view.iothub.HubDetailActivity;
import com.tplink.iot.view.iotplug.PlugDetailActivity;
import com.tplink.iot.view.iotsensor.SensorDetailActivity;
import com.tplink.iot.view.ipcamera.play.VideoPlayActivity;
import com.tplink.iot.viewmodel.deviceshare.DeviceShareViewModel;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.DeviceManagerInfoBean;
import com.tplink.libtpnetwork.TPCloudNetwork.device.TCDeviceUserInfoBean;
import com.tplink.libtpnetwork.enumerate.EnumUserRole;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class ShareDeviceActivity
  extends BaseActivity
  implements View.OnClickListener, DeviceSharePullingAdapter.d
{
  private ViewGroup H3;
  private ViewGroup I3;
  private ViewGroup J3;
  private ViewGroup K3;
  private ViewGroup L3;
  private ViewGroup M3;
  private RecyclerView N3;
  private DeviceShareViewModel O3;
  private List<BaseALIoTDevice> P3 = new ArrayList();
  private List<BaseALIoTDevice> Q3 = new ArrayList();
  private List<BaseALIoTDevice> R3 = new ArrayList();
  private List<ShareDeviceResult> S3 = new ArrayList();
  private DeviceShareOwnerSharedAdapter T3;
  private DeviceShareOwnerUnsharedAdapter U3;
  private DeviceShareUserDeviceAdapter V3;
  private DeviceSharePullingAdapter W3;
  private boolean X3;
  private TextView p0;
  private View p1;
  private ViewGroup p2;
  private ViewGroup p3;
  private TextView y;
  private View z;
  
  private void A1()
  {
    b1(2131953929);
    ((LinearLayout)findViewById(2131363351)).setOnClickListener(this);
    this.y = ((TextView)findViewById(2131364691));
    this.z = findViewById(2131363243);
    ((LinearLayout)findViewById(2131363352)).setOnClickListener(this);
    this.p0 = ((TextView)findViewById(2131364692));
    this.p1 = findViewById(2131363244);
    this.p2 = ((ViewGroup)findViewById(2131363316));
    this.p3 = ((ViewGroup)findViewById(2131363317));
    this.J3 = ((ViewGroup)findViewById(2131363318));
    this.H3 = ((ViewGroup)findViewById(2131363319));
    this.I3 = ((ViewGroup)findViewById(2131363320));
    this.K3 = ((ViewGroup)findViewById(2131363363));
    this.L3 = ((ViewGroup)findViewById(2131363364));
    this.M3 = ((ViewGroup)findViewById(2131363365));
    L1(this.P3);
    this.T3 = new DeviceShareOwnerSharedAdapter(this, this.P3);
    Object localObject = (RecyclerView)findViewById(2131363811);
    ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager(this));
    ((RecyclerView)localObject).setItemAnimator(new DefaultItemAnimator());
    ((RecyclerView)localObject).setAdapter(this.T3);
    this.T3.o(new d());
    L1(this.Q3);
    this.U3 = new DeviceShareOwnerUnsharedAdapter(this, this.Q3);
    localObject = (RecyclerView)findViewById(2131363812);
    ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager(this));
    ((RecyclerView)localObject).setItemAnimator(new DefaultItemAnimator());
    ((RecyclerView)localObject).setAdapter(this.U3);
    this.U3.n(new e());
    L1(this.R3);
    this.V3 = new DeviceShareUserDeviceAdapter(this, this.R3);
    localObject = (RecyclerView)findViewById(2131363815);
    ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager(this));
    ((RecyclerView)localObject).setItemAnimator(new DefaultItemAnimator());
    ((RecyclerView)localObject).setAdapter(this.V3);
    this.V3.o(new f());
    localObject = new DeviceSharePullingAdapter(this, this.S3);
    this.W3 = ((DeviceSharePullingAdapter)localObject);
    ((DeviceSharePullingAdapter)localObject).s(this);
    localObject = (RecyclerView)findViewById(2131363813);
    this.N3 = ((RecyclerView)localObject);
    ((RecyclerView)localObject).setLayoutManager(new LinearLayoutManager(this, 0, false));
    this.N3.setItemAnimator(new DefaultItemAnimator());
    this.N3.setAdapter(this.W3);
    x1();
    if (this.X3) {
      K1();
    } else {
      G1();
    }
  }
  
  public static void B1(Context paramContext, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, ShareDeviceActivity.class);
    localIntent.putExtra("share_push_msg", paramBoolean);
    paramContext.startActivity(localIntent);
  }
  
  private void C1()
  {
    s0.p(this, getString(2131952444));
  }
  
  private void D1(BaseALIoTDevice paramBaseALIoTDevice, List<String> paramList)
  {
    s0.l(this);
    this.O3.S(paramBaseALIoTDevice.getDeviceId(), paramList, paramBaseALIoTDevice.isSubDevice());
  }
  
  private void E1()
  {
    this.O3.F().observe(this, new j());
    this.O3.u().observe(this, new k());
    this.O3.I().observe(this, new l());
    this.O3.K().observe(this, new a());
    this.O3.E().observe(this, new b());
  }
  
  private void F1(final BaseALIoTDevice paramBaseALIoTDevice)
  {
    new TPMaterialDialogV2.Builder(this).j(getString(2131953910)).l(2131952391, 2131099804, null).o(2131952451, 2131099812, new i(paramBaseALIoTDevice)).g(8, 8).b(false).c(false).a().show();
  }
  
  private void G1()
  {
    this.y.setTextColor(ContextCompat.getColor(this, 2131099808));
    this.z.setVisibility(0);
    this.p0.setTextColor(ContextCompat.getColor(this, 2131099804));
    this.p1.setVisibility(4);
    this.p2.setVisibility(0);
    this.K3.setVisibility(8);
  }
  
  private void H1(final BaseALIoTDevice paramBaseALIoTDevice)
  {
    final ArrayList localArrayList = new ArrayList();
    Object localObject;
    if ((paramBaseALIoTDevice.getDeviceManagerInfo() != null) && (paramBaseALIoTDevice.getDeviceManagerInfo().getUserInfo() != null)) {
      localObject = paramBaseALIoTDevice.getDeviceManagerInfo().getUserInfo();
    } else {
      localObject = null;
    }
    b.d.w.c.a.e("testShare", com.tplink.libtpnetwork.Utils.i.h(localArrayList));
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        TCDeviceUserInfoBean localTCDeviceUserInfoBean = (TCDeviceUserInfoBean)((Iterator)localObject).next();
        if (localTCDeviceUserInfoBean.getRole() == EnumUserRole.ROLE_USER) {
          localArrayList.add(localTCDeviceUserInfoBean.getCloudUserName());
        }
      }
    }
    if ((!localArrayList.isEmpty()) && (localArrayList.size() != 1))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localArrayList.size());
      ((StringBuilder)localObject).append("");
      localObject = getString(2131953927, new Object[] { ((StringBuilder)localObject).toString() });
    }
    else
    {
      localObject = getString(2131953926, new Object[] { "1" });
    }
    new TPMaterialDialogV2.Builder(this).j((String)localObject).l(2131952391, 2131099804, null).o(2131953919, 2131099812, new h(paramBaseALIoTDevice, localArrayList)).g(8, 8).b(false).c(false).a().show();
  }
  
  private void I1()
  {
    new TPMaterialDialogV3.Builder(this).f(getString(2131952567)).b(false).c(false).i(null, 2131099804, null).j(2131951761, 2131099808, null).a().show();
  }
  
  private void J1(final BaseALIoTDevice paramBaseALIoTDevice)
  {
    TPMaterialDialogV2.Builder localBuilder = new TPMaterialDialogV2.Builder(this);
    localBuilder.r(2131953924);
    localBuilder.h(2131953925);
    localBuilder.c(false);
    localBuilder.b(false);
    localBuilder.o(2131953908, 2131099808, new g(paramBaseALIoTDevice));
    localBuilder.l(2131953902, 2131099804, null);
    localBuilder.g(8, 8);
    localBuilder.a().show();
  }
  
  private void K1()
  {
    this.p0.setTextColor(ContextCompat.getColor(this, 2131099808));
    this.p1.setVisibility(0);
    this.y.setTextColor(ContextCompat.getColor(this, 2131099804));
    this.z.setVisibility(4);
    this.K3.setVisibility(0);
    this.p2.setVisibility(8);
  }
  
  private void L1(List<BaseALIoTDevice> paramList)
  {
    Collections.sort(paramList, new c());
  }
  
  private void M1(List<BaseALIoTDevice> paramList)
  {
    this.P3.clear();
    this.Q3.clear();
    this.R3.clear();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        BaseALIoTDevice localBaseALIoTDevice = (BaseALIoTDevice)localIterator.next();
        if (localBaseALIoTDevice.isUserRoleTypeDevice())
        {
          this.R3.add(localBaseALIoTDevice);
        }
        else
        {
          paramList = localBaseALIoTDevice.getDeviceManagerInfo();
          if ((paramList != null) && (paramList.getUserInfo() != null) && (paramList.getUserInfo().size() > 1)) {
            this.P3.add(localBaseALIoTDevice);
          } else {
            this.Q3.add(localBaseALIoTDevice);
          }
        }
      }
    }
    L1(this.P3);
    L1(this.Q3);
    L1(this.R3);
    boolean bool = this.R3.isEmpty();
    int i = 8;
    if (bool)
    {
      paramList = this.S3;
      if ((paramList == null) || (paramList.isEmpty()))
      {
        this.L3.setVisibility(8);
        this.M3.setVisibility(0);
        break label250;
      }
    }
    this.V3.notifyDataSetChanged();
    this.L3.setVisibility(0);
    this.M3.setVisibility(8);
    label250:
    if ((this.P3.isEmpty()) && (this.Q3.isEmpty()))
    {
      this.p3.setVisibility(8);
      this.J3.setVisibility(0);
    }
    else
    {
      this.p3.setVisibility(0);
      this.J3.setVisibility(8);
      this.T3.notifyDataSetChanged();
      this.U3.notifyDataSetChanged();
      paramList = this.H3;
      int j;
      if (this.P3.isEmpty()) {
        j = 8;
      } else {
        j = 0;
      }
      paramList.setVisibility(j);
      paramList = this.I3;
      if (this.Q3.isEmpty()) {
        j = i;
      } else {
        j = 0;
      }
      paramList.setVisibility(j);
    }
  }
  
  private void e1(BaseALIoTDevice paramBaseALIoTDevice)
  {
    s0.l(this);
    this.O3.f(paramBaseALIoTDevice.getDeviceId());
  }
  
  private void x1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getExtras();
      if (localObject != null) {
        this.X3 = ((Bundle)localObject).getBoolean("share_push_msg");
      }
    }
  }
  
  private void y1(BaseALIoTDevice paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice == null) {
      return;
    }
    if (paramBaseALIoTDevice.isCamera())
    {
      Intent localIntent = new Intent(this, VideoPlayActivity.class);
      localIntent.putExtra("device_id_md5", paramBaseALIoTDevice.getDeviceIdMD5());
      startActivity(localIntent);
    }
    else if (paramBaseALIoTDevice.isBulb())
    {
      g.h(this, paramBaseALIoTDevice.getDeviceIdMD5());
    }
    else if (paramBaseALIoTDevice.isPlug())
    {
      PlugDetailActivity.K1(this, paramBaseALIoTDevice.getDeviceIdMD5());
    }
    else if (paramBaseALIoTDevice.isHub())
    {
      HubDetailActivity.K1(this, paramBaseALIoTDevice.getDeviceIdMD5());
    }
    else if (paramBaseALIoTDevice.isSensor())
    {
      SensorDetailActivity.D1(this, paramBaseALIoTDevice.getDeviceIdMD5());
    }
    else if (paramBaseALIoTDevice.isSwitch())
    {
      SwitchDetailActivity.R1(this, paramBaseALIoTDevice.getDeviceIdMD5());
    }
  }
  
  private void z1(BaseALIoTDevice paramBaseALIoTDevice)
  {
    ShareDeviceUserListActivity.v1(this, paramBaseALIoTDevice.getDeviceIdMD5());
  }
  
  public void L0(ShareDeviceResult paramShareDeviceResult)
  {
    s0.l(this);
    DeviceShareActionListParams localDeviceShareActionListParams = new DeviceShareActionListParams();
    DeviceShareActionParams localDeviceShareActionParams = new DeviceShareActionParams();
    localDeviceShareActionParams.setAction(EnumDeviceShareAction.REJECT);
    localDeviceShareActionParams.setShareId(paramShareDeviceResult.getShareId());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localDeviceShareActionParams);
    localDeviceShareActionListParams.setShareList(localArrayList);
    this.O3.L(localDeviceShareActionListParams, paramShareDeviceResult.getDeviceType());
  }
  
  public void S(ShareDeviceResult paramShareDeviceResult)
  {
    s0.l(this);
    DeviceShareActionListParams localDeviceShareActionListParams = new DeviceShareActionListParams();
    DeviceShareActionParams localDeviceShareActionParams = new DeviceShareActionParams();
    localDeviceShareActionParams.setAction(EnumDeviceShareAction.ACCEPT);
    localDeviceShareActionParams.setShareId(paramShareDeviceResult.getShareId());
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localDeviceShareActionParams);
    localDeviceShareActionListParams.setShareList(localArrayList);
    this.O3.L(localDeviceShareActionListParams, paramShareDeviceResult.getDeviceType());
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131363352: 
      K1();
      break;
    case 2131363351: 
      G1();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (o.a() == 0) {
      return;
    }
    setContentView(2131558502);
    this.O3 = ((DeviceShareViewModel)ViewModelProviders.of(this).get(DeviceShareViewModel.class));
    A1();
    E1();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(2131623948, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 2131362296)
    {
      W0(DeviceShareBlacklistActivity.class);
      q.q();
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  protected void onResume()
  {
    super.onResume();
    this.O3.B();
    this.O3.x();
  }
  
  class a
    implements Observer<List<ShareDeviceResult>>
  {
    a() {}
    
    public void a(List<ShareDeviceResult> paramList)
    {
      ShareDeviceActivity.k1(ShareDeviceActivity.this).clear();
      if ((paramList != null) && (!paramList.isEmpty()))
      {
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          paramList = (ShareDeviceResult)localIterator.next();
          if (!paramList.getExpired().booleanValue()) {
            ShareDeviceActivity.k1(ShareDeviceActivity.this).add(paramList);
          }
        }
      }
      ShareDeviceActivity.l1(ShareDeviceActivity.this).r(ShareDeviceActivity.k1(ShareDeviceActivity.this));
      if ((ShareDeviceActivity.k1(ShareDeviceActivity.this) != null) && (!ShareDeviceActivity.k1(ShareDeviceActivity.this).isEmpty()))
      {
        ShareDeviceActivity.n1(ShareDeviceActivity.this).setVisibility(8);
        ShareDeviceActivity.o1(ShareDeviceActivity.this).setVisibility(0);
        ShareDeviceActivity.m1(ShareDeviceActivity.this).setVisibility(0);
      }
      else
      {
        ShareDeviceActivity.m1(ShareDeviceActivity.this).setVisibility(8);
      }
    }
  }
  
  class b
    implements Observer<com.tplink.iot.viewmodel.quicksetup.i<String>>
  {
    b() {}
    
    public void a(@Nullable com.tplink.iot.viewmodel.quicksetup.i<String> parami)
    {
      
      if (parami != null) {
        if (parami.b() == 0)
        {
          s0.B(ShareDeviceActivity.this, null);
        }
        else if (parami.b() == 45028)
        {
          parami = a.a(ShareDeviceActivity.this, (String)parami.a());
          s0.p(ShareDeviceActivity.this, parami);
        }
        else if (parami.b() == 38535)
        {
          s0.n(ShareDeviceActivity.this, 2131952444);
        }
        else
        {
          ShareDeviceActivity.j1(ShareDeviceActivity.this);
        }
      }
    }
  }
  
  class c
    implements Comparator<BaseALIoTDevice>
  {
    c() {}
    
    public int a(BaseALIoTDevice paramBaseALIoTDevice1, BaseALIoTDevice paramBaseALIoTDevice2)
    {
      if ((paramBaseALIoTDevice1 != null) && (!TextUtils.isEmpty(paramBaseALIoTDevice1.getDeviceName())) && (paramBaseALIoTDevice2 != null) && (!TextUtils.isEmpty(paramBaseALIoTDevice2.getDeviceName()))) {
        return paramBaseALIoTDevice1.getDeviceName().compareToIgnoreCase(paramBaseALIoTDevice2.getDeviceName());
      }
      return 1;
    }
  }
  
  class d
    implements DeviceShareOwnerSharedAdapter.d
  {
    d() {}
    
    public void a(View paramView, int paramInt)
    {
      paramView = ShareDeviceActivity.this;
      ShareDeviceActivity.p1(paramView, (BaseALIoTDevice)ShareDeviceActivity.f1(paramView).get(paramInt));
    }
    
    public void b(View paramView, int paramInt)
    {
      paramView = (BaseALIoTDevice)ShareDeviceActivity.f1(ShareDeviceActivity.this).get(paramInt);
      ShareDeviceActivity.g1(ShareDeviceActivity.this, paramView);
    }
  }
  
  class e
    implements f
  {
    e() {}
    
    public void a(View paramView, int paramInt)
    {
      paramView = (BaseALIoTDevice)ShareDeviceActivity.q1(ShareDeviceActivity.this).get(paramInt);
      if (!paramView.isSupportDeviceShare()) {
        ShareDeviceActivity.r1(ShareDeviceActivity.this);
      } else if (paramView.isHasThingOrCloudDevice()) {
        ShareDeviceActivity.p1(ShareDeviceActivity.this, paramView);
      } else {
        ShareDeviceActivity.s1(ShareDeviceActivity.this, paramView);
      }
    }
  }
  
  class f
    implements DeviceShareUserDeviceAdapter.d
  {
    f() {}
    
    public void a(View paramView, int paramInt)
    {
      paramView = ShareDeviceActivity.this;
      ShareDeviceActivity.v1(paramView, (BaseALIoTDevice)ShareDeviceActivity.t1(paramView).get(paramInt));
    }
    
    public void b(View paramView, int paramInt)
    {
      paramView = (BaseALIoTDevice)ShareDeviceActivity.t1(ShareDeviceActivity.this).get(paramInt);
      ShareDeviceActivity.u1(ShareDeviceActivity.this, paramView);
    }
  }
  
  class g
    implements TPMaterialDialogV2.d
  {
    g(BaseALIoTDevice paramBaseALIoTDevice) {}
    
    public void onClick(View paramView)
    {
      paramView = new ArrayList();
      BaseALIoTDevice localBaseALIoTDevice = paramBaseALIoTDevice;
      if (localBaseALIoTDevice != null) {
        paramView.add(localBaseALIoTDevice);
      }
      DeviceShareHelpActivity.h1(ShareDeviceActivity.this, paramView, 3);
    }
  }
  
  class h
    implements TPMaterialDialogV2.d
  {
    h(BaseALIoTDevice paramBaseALIoTDevice, List paramList) {}
    
    public void onClick(View paramView)
    {
      ShareDeviceActivity.w1(ShareDeviceActivity.this, paramBaseALIoTDevice, localArrayList);
    }
  }
  
  class i
    implements TPMaterialDialogV2.d
  {
    i(BaseALIoTDevice paramBaseALIoTDevice) {}
    
    public void onClick(View paramView)
    {
      q.o();
      ShareDeviceActivity.h1(ShareDeviceActivity.this, paramBaseALIoTDevice);
    }
  }
  
  class j
    implements Observer<List<BaseALIoTDevice>>
  {
    j() {}
    
    public void a(@Nullable List<BaseALIoTDevice> paramList)
    {
      ShareDeviceActivity.i1(ShareDeviceActivity.this, paramList);
    }
  }
  
  class k
    implements Observer<com.tplink.iot.viewmodel.quicksetup.i<String>>
  {
    k() {}
    
    public void a(@Nullable com.tplink.iot.viewmodel.quicksetup.i<String> parami)
    {
      
      if ((parami == null) || (parami.b() != 0)) {
        ShareDeviceActivity.j1(ShareDeviceActivity.this);
      }
    }
  }
  
  class l
    implements Observer<com.tplink.iot.viewmodel.quicksetup.i<CloudResult<Void>>>
  {
    l() {}
    
    public void a(@Nullable com.tplink.iot.viewmodel.quicksetup.i<CloudResult<Void>> parami)
    {
      
      if ((parami == null) || (parami.b() != 0)) {
        ShareDeviceActivity.j1(ShareDeviceActivity.this);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\deviceshare\ShareDeviceActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */