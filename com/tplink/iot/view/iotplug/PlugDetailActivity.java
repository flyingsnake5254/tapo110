package com.tplink.iot.view.iotplug;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.Utils.k;
import com.tplink.iot.Utils.u0;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.iot.cloud.bean.thing.common.ThingUsageDetail;
import com.tplink.iot.view.cloudconnect.CloudConnectGetStateActivity;
import com.tplink.iot.view.deviceshare.ShareDeviceUserListActivity;
import com.tplink.iot.view.feature.AwayModeActivity;
import com.tplink.iot.view.feature.ScheduleListActivity;
import com.tplink.iot.view.feature.TimerActivity;
import com.tplink.iot.view.feedback.EnumFeedbackCategory;
import com.tplink.iot.view.feedback.HelpAndFeedbackActivity;
import com.tplink.iot.view.iotplug.settings.PlugSettingsActivity;
import com.tplink.iot.viewmodel.home.u;
import com.tplink.iot.viewmodel.iotplug.PlugDetailViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.DiffuseView;
import com.tplink.iot.widget.businessview.ThingNextEventView;
import com.tplink.iot.widget.businessview.ThingNextEventView.d;
import com.tplink.iot.widget.businessview.ThingUsageView;
import com.tplink.iot.widget.plug.EnergyMonitoringView;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.IoTPlugDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.EnergyUsageResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.plug.result.PlugNextEvent;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.DeviceManagerInfoBean;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import com.yinglan.scrolllayout.ScrollLayout;
import com.yinglan.scrolllayout.ScrollLayout.Status;
import com.yinglan.scrolllayout.ScrollLayout.g;
import java.util.List;

public class PlugDetailActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView H3;
  private TextView I3;
  private TextView J3;
  private ThingUsageView K3;
  private ImageView L3;
  private ImageView M3;
  private ImageView N3;
  private ThingNextEventView O3;
  private View P3;
  private View Q3;
  private CardView R3;
  private CardView S3;
  private EnergyMonitoringView T3;
  private boolean U3;
  private PlugDetailViewModel V3;
  private String W3;
  private BaseALIoTDevice X3;
  private ThingUsage Y3;
  private EnergyUsageResult Z3;
  private TPSwitchCompat a4;
  private long b4 = 0L;
  private ImageView p0;
  private View p1;
  private TextView p2;
  private TextView p3;
  private DiffuseView y;
  private ScrollLayout z;
  
  private void A1()
  {
    Object localObject = this.X3;
    if (localObject != null)
    {
      if (TextUtils.equals(((BaseALIoTDevice)localObject).getDeviceModel(), getString(2131953120)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://www.tapo.com/app/#/faqList2?categoryType=");
        ((StringBuilder)localObject).append(getString(2131953386));
        ((StringBuilder)localObject).append(com.tplink.iot.model.about.d.a());
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://www.tapo.com/app/#/faqList2?categoryType=");
        ((StringBuilder)localObject).append(getString(2131953386));
        ((StringBuilder)localObject).append(com.tplink.iot.model.about.d.a());
        localObject = ((StringBuilder)localObject).toString();
      }
      HelpAndFeedbackActivity.k1(this, (String)localObject, getString(2131952881), this.X3.getDeviceType(), this.X3.getDeviceModel(), EnumFeedbackCategory.PLUG);
    }
  }
  
  private void B1()
  {
    this.M3 = ((ImageView)findViewById(2131363003));
    this.N3 = ((ImageView)findViewById(2131363106));
    this.z = ((ScrollLayout)findViewById(2131363972));
    this.R3 = ((CardView)findViewById(2131362192));
    this.S3 = ((CardView)findViewById(2131362196));
    this.y = ((DiffuseView)findViewById(2131362450));
    this.p0 = ((ImageView)findViewById(2131363103));
    this.p1 = findViewById(2131363330);
    this.p2 = ((TextView)findViewById(2131364536));
    this.p3 = ((TextView)findViewById(2131364515));
    this.L3 = ((ImageView)findViewById(2131363139));
    this.K3 = ((ThingUsageView)findViewById(2131364209));
    this.H3 = ((TextView)findViewById(2131364563));
    this.I3 = ((TextView)findViewById(2131364564));
    this.a4 = ((TPSwitchCompat)findViewById(2131364126));
    this.O3 = ((ThingNextEventView)findViewById(2131364208));
    this.T3 = ((EnergyMonitoringView)findViewById(2131362542));
    this.Q3 = findViewById(2131363879);
    this.P3 = findViewById(2131362908);
    this.J3 = ((TextView)findViewById(2131364573));
    findViewById(2131363343).setOnClickListener(this);
    this.p0.setOnClickListener(this);
    findViewById(2131363002).setOnClickListener(this);
    findViewById(2131362675).setOnClickListener(this);
    findViewById(2131363113).setOnClickListener(this);
    findViewById(2131363000).setOnClickListener(this);
    findViewById(2131363144).setOnClickListener(this);
    findViewById(2131364615).setOnClickListener(this);
    findViewById(2131364673).setOnClickListener(this);
    findViewById(2131364348).setOnClickListener(this);
    this.L3.setOnClickListener(this);
    findViewById(2131362908).setOnClickListener(this);
    findViewById(2131362913).setOnClickListener(this);
    findViewById(2131362192).setOnClickListener(this);
    if (com.tplink.iot.Utils.w0.a.g(this.W3, EnumIoTComponent.ENERGY_MONITORING))
    {
      this.K3.setVisibility(8);
      this.T3.setVisibility(0);
    }
    else
    {
      this.K3.setVisibility(0);
      this.T3.setVisibility(8);
    }
    this.T3.setOnItemClickListener(new b(this));
    this.y.setIsAutoStop(true);
    this.z.setMinOffset(k.a(this, 50.0F) + com.tplink.iot.view.quicksetup.base.d.A(this));
    this.p1.post(new a(this));
    this.z.setOnScrollChangedListener(new i());
    this.a4.setOnSwitchCheckedChangeListener(new j());
    this.O3.setOnNextEventCallback(new a());
  }
  
  private boolean C1()
  {
    ALIoTDevice localALIoTDevice = com.tplink.iot.Utils.w0.a.b(this.W3);
    boolean bool;
    if ((localALIoTDevice != null) && (localALIoTDevice.getCloudIoTDevice() == null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean D1()
  {
    if (com.tplink.iot.Utils.w0.a.i(this.W3)) {
      return E1();
    }
    return C1();
  }
  
  private boolean E1()
  {
    ALIoTDevice localALIoTDevice = com.tplink.iot.Utils.w0.a.b(this.W3);
    boolean bool;
    if ((localALIoTDevice != null) && (localALIoTDevice.getThingDevice() == null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean F1()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.X3;
    boolean bool;
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.isUserRoleTypeDevice())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static void K1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, PlugDetailActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private void L1(CloudConnectStateResult paramCloudConnectStateResult)
  {
    if (paramCloudConnectStateResult == null) {
      return;
    }
    int i = paramCloudConnectStateResult.getStatus();
    int j = 8;
    if (i == 0)
    {
      this.R3.setVisibility(8);
    }
    else
    {
      paramCloudConnectStateResult = this.R3;
      if (D1()) {
        j = 0;
      }
      paramCloudConnectStateResult.setVisibility(j);
    }
  }
  
  private void M1()
  {
    u.p(this, y1());
  }
  
  private void N1()
  {
    ThingContext localThingContext = TPIoTClientManager.k2(this.W3);
    if ((localThingContext != null) && (localThingContext.getIoTDevice() != null)) {
      if (localThingContext.getIoTDevice().isUserRoleTypeDevice())
      {
        this.S3.setVisibility(0);
      }
      else
      {
        this.S3.setVisibility(8);
        O1();
      }
    }
  }
  
  private void O1()
  {
    if ((com.tplink.iot.Utils.w0.a.d(this.W3)) && (D1())) {
      this.V3.t();
    } else {
      this.R3.setVisibility(8);
    }
  }
  
  private void P1()
  {
    this.V3.u().observe(this, new b());
    this.V3.D().observe(this, new c());
    this.V3.z().observe(this, new d());
    this.V3.B().observe(this, new e());
    this.V3.r().observe(this, new f());
    this.V3.s().observe(this, new g());
    this.V3.E().observe(this, new h());
  }
  
  private void Q1(BaseALIoTDevice paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice == null) {
      return;
    }
    this.X3 = paramBaseALIoTDevice;
    this.a4.setChecked(paramBaseALIoTDevice.isCommonDevice());
    int i = z1();
    this.J3.setText(String.valueOf(i));
    paramBaseALIoTDevice = com.tplink.iot.Utils.z0.q.e(this.X3);
    boolean bool = TextUtils.isEmpty(paramBaseALIoTDevice);
    int j = 8;
    if (bool)
    {
      this.p3.setVisibility(8);
    }
    else
    {
      this.p3.setVisibility(0);
      this.p3.setText(paramBaseALIoTDevice);
    }
    paramBaseALIoTDevice = this.P3;
    if (F1()) {
      i = 8;
    } else {
      i = 0;
    }
    paramBaseALIoTDevice.setVisibility(i);
    paramBaseALIoTDevice = this.Q3;
    i = j;
    if (com.tplink.iot.Utils.w0.a.i(this.W3)) {
      i = 0;
    }
    paramBaseALIoTDevice.setVisibility(i);
    if (!this.X3.isSupportIoTCloud())
    {
      this.a4.setEnabled(false);
      this.Q3.setAlpha(0.5F);
    }
    else
    {
      this.a4.setEnabled(true);
      this.Q3.setAlpha(1.0F);
    }
    if (((!this.X3.isSupportIoTCloud()) && (this.X3.getCloudIoTDevice() == null)) || (F1()))
    {
      this.P3.setEnabled(false);
      this.P3.setAlpha(0.5F);
    }
    else
    {
      this.P3.setEnabled(true);
      this.P3.setAlpha(1.0F);
    }
  }
  
  private String y1()
  {
    if ((b.d.s.a.a.f() != null) && (b.d.s.a.a.f().c() != null))
    {
      localObject = b.d.s.a.a.f().c();
      if ((localObject != null) && (((TCAccountBean)localObject).getCloudUserName() != null)) {
        return ((TCAccountBean)localObject).getCloudUserName();
      }
    }
    Object localObject = "";
    return (String)localObject;
  }
  
  private int z1()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.X3;
    int i;
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.getDeviceManagerInfo() != null) && (this.X3.getDeviceManagerInfo().getUserInfo() != null) && (this.X3.getDeviceManagerInfo().getUserInfo().size() > 1)) {
      i = this.X3.getDeviceManagerInfo().getUserInfo().size() - 1;
    } else {
      i = 0;
    }
    return i;
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131363144: 
    case 2131364673: 
      X0(TimerActivity.class, this.W3);
      break;
    case 2131363139: 
    case 2131363343: 
      long l = System.currentTimeMillis();
      if (l - this.b4 < 500L) {
        return;
      }
      this.b4 = l;
      u0.a(this, 200L);
      if (this.U3)
      {
        this.L3.setImageResource(2131689827);
        this.M3.setBackground(getResources().getDrawable(2131690258));
        if (this.y.b()) {
          this.y.d();
        }
        this.H3.setText(2131952440);
        this.I3.setText(2131954217);
        this.U3 = false;
      }
      else
      {
        this.L3.setImageResource(2131689828);
        com.tplink.iot.Utils.q.a(this, this.M3, 2131690258, 2131690259, 800);
        this.y.c();
        this.H3.setText(2131952442);
        this.I3.setText(2131954216);
        this.U3 = true;
      }
      this.V3.I(this.U3);
      com.tplink.iot.Utils.x0.i.y(this.W3, this.U3);
      break;
    case 2131363113: 
    case 2131364615: 
      ScheduleListActivity.o1(this, this.W3, false);
      break;
    case 2131363103: 
      if (this.z.getCurrentStatus() == ScrollLayout.Status.CLOSED) {
        this.z.o();
      } else if (this.z.getCurrentStatus() == ScrollLayout.Status.OPENED) {
        this.z.m();
      }
      break;
    case 2131363002: 
      onBackPressed();
      break;
    case 2131363000: 
    case 2131364348: 
      X0(AwayModeActivity.class, this.W3);
      break;
    case 2131362913: 
      A1();
      com.tplink.iot.Utils.x0.i.w();
      break;
    case 2131362908: 
      paramView = this.X3;
      if (paramView != null) {
        ShareDeviceUserListActivity.v1(this, paramView.getDeviceIdMD5());
      }
      com.tplink.iot.Utils.x0.i.C();
      break;
    case 2131362675: 
      X0(PlugSettingsActivity.class, this.W3);
      break;
    case 2131362192: 
      CloudConnectGetStateActivity.j1(this, this.W3);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558603);
    com.tplink.iot.view.quicksetup.base.d.J(this, findViewById(2131363353));
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.W3 = paramBundle;
    this.V3 = ((PlugDetailViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(PlugDetailViewModel.class));
    B1();
    P1();
    N1();
    com.tplink.iot.Utils.x0.i.s();
  }
  
  protected void onDestroy()
  {
    ThingNextEventView localThingNextEventView = this.O3;
    if (localThingNextEventView != null) {
      localThingNextEventView.e();
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    this.y.d();
    this.V3.M();
    this.V3.L();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.V3.K();
    this.V3.J();
    if (this.V3.G()) {
      this.V3.A();
    } else if (this.V3.F()) {
      this.V3.y();
    }
  }
  
  class a
    implements ThingNextEventView.d
  {
    a() {}
    
    public void a()
    {
      PlugDetailActivity.e1(PlugDetailActivity.this).H();
    }
  }
  
  class b
    implements Observer<IoTPlugDevice>
  {
    b() {}
    
    public void a(@Nullable IoTPlugDevice paramIoTPlugDevice)
    {
      if (paramIoTPlugDevice != null)
      {
        ThingUsage localThingUsage = new ThingUsage();
        Object localObject = new ThingUsageDetail();
        ((ThingUsageDetail)localObject).setToday(paramIoTPlugDevice.getTimeUsageToday());
        ((ThingUsageDetail)localObject).setPast7(paramIoTPlugDevice.getTimeUsagePast7());
        ((ThingUsageDetail)localObject).setPast30(paramIoTPlugDevice.getTimeUsagePast30());
        localThingUsage.setTimeUsage((ThingUsageDetail)localObject);
        PlugDetailActivity.f1(PlugDetailActivity.this).setText(l.d(PlugDetailActivity.this, EnumDeviceType.PLUG.getDeviceType(), PlugDetailActivity.e1(PlugDetailActivity.this).v()));
        if (!PlugDetailActivity.e1(PlugDetailActivity.this).F())
        {
          PlugDetailActivity.p1(PlugDetailActivity.this).o(localThingUsage);
          com.tplink.iot.Utils.x0.i.t(PlugDetailActivity.q1(PlugDetailActivity.this), localThingUsage);
        }
        PlugDetailActivity.s1(PlugDetailActivity.this, paramIoTPlugDevice.isDeviceOn());
        paramIoTPlugDevice = PlugDetailActivity.t1(PlugDetailActivity.this);
        int i;
        if (PlugDetailActivity.r1(PlugDetailActivity.this)) {
          i = 2131689828;
        } else {
          i = 2131689827;
        }
        paramIoTPlugDevice.setImageResource(i);
        paramIoTPlugDevice = PlugDetailActivity.u1(PlugDetailActivity.this);
        localObject = PlugDetailActivity.this.getResources();
        if (PlugDetailActivity.r1(PlugDetailActivity.this)) {
          i = 2131690259;
        } else {
          i = 2131690258;
        }
        paramIoTPlugDevice.setBackground(((Resources)localObject).getDrawable(i));
        paramIoTPlugDevice = PlugDetailActivity.v1(PlugDetailActivity.this);
        if (PlugDetailActivity.r1(PlugDetailActivity.this)) {
          i = 2131952442;
        } else {
          i = 2131952440;
        }
        paramIoTPlugDevice.setText(i);
        paramIoTPlugDevice = PlugDetailActivity.w1(PlugDetailActivity.this);
        if (PlugDetailActivity.r1(PlugDetailActivity.this)) {
          i = 2131954216;
        } else {
          i = 2131954217;
        }
        paramIoTPlugDevice.setText(i);
      }
    }
  }
  
  class c
    implements Observer<PlugNextEvent>
  {
    c() {}
    
    public void a(@Nullable PlugNextEvent paramPlugNextEvent)
    {
      PlugDetailActivity.x1(PlugDetailActivity.this).r(paramPlugNextEvent, PlugDetailActivity.e1(PlugDetailActivity.this).w());
    }
  }
  
  class d
    implements Observer<ThingUsage>
  {
    d() {}
    
    public void a(@Nullable ThingUsage paramThingUsage)
    {
      PlugDetailActivity.h1(PlugDetailActivity.this, paramThingUsage);
      if (PlugDetailActivity.e1(PlugDetailActivity.this).F())
      {
        PlugDetailActivity.p1(PlugDetailActivity.this).o(PlugDetailActivity.g1(PlugDetailActivity.this));
        com.tplink.iot.Utils.x0.i.t(PlugDetailActivity.q1(PlugDetailActivity.this), paramThingUsage);
      }
    }
  }
  
  class e
    implements Observer<EnergyUsageResult>
  {
    e() {}
    
    public void a(@Nullable EnergyUsageResult paramEnergyUsageResult)
    {
      if (PlugDetailActivity.e1(PlugDetailActivity.this).G())
      {
        PlugDetailActivity.i1(PlugDetailActivity.this, paramEnergyUsageResult);
        PlugDetailActivity.j1(PlugDetailActivity.this).j(paramEnergyUsageResult);
      }
    }
  }
  
  class f
    implements Observer<BaseALIoTDevice>
  {
    f() {}
    
    public void a(@Nullable BaseALIoTDevice paramBaseALIoTDevice)
    {
      PlugDetailActivity.k1(PlugDetailActivity.this, paramBaseALIoTDevice);
    }
  }
  
  class g
    implements Observer<com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult>>
  {
    g() {}
    
    public void a(@Nullable com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult> parami)
    {
      if ((parami != null) && (parami.b() == 0)) {
        PlugDetailActivity.l1(PlugDetailActivity.this, (CloudConnectStateResult)parami.a());
      }
    }
  }
  
  class h
    implements Observer<Boolean>
  {
    h() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      if (PlugDetailActivity.m1(PlugDetailActivity.this) != null)
      {
        ImageView localImageView = PlugDetailActivity.m1(PlugDetailActivity.this);
        int i;
        if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
          i = 0;
        } else {
          i = 8;
        }
        localImageView.setVisibility(i);
      }
    }
  }
  
  class i
    implements ScrollLayout.g
  {
    i() {}
    
    public void a(ScrollLayout.Status paramStatus)
    {
      if (paramStatus == ScrollLayout.Status.OPENED) {
        PlugDetailActivity.n1(PlugDetailActivity.this).setImageResource(2131689831);
      } else if (paramStatus == ScrollLayout.Status.CLOSED) {
        PlugDetailActivity.n1(PlugDetailActivity.this).setImageResource(2131689830);
      }
    }
    
    public void b(float paramFloat) {}
    
    public void c(int paramInt) {}
  }
  
  class j
    implements TPSwitchCompat.a
  {
    j() {}
    
    public void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean2)
      {
        PlugDetailActivity.e1(PlugDetailActivity.this).o(paramBoolean1);
        com.tplink.iot.Utils.x0.i.x(PlugDetailActivity.q1(PlugDetailActivity.this), paramBoolean1);
        if (!paramBoolean1) {
          PlugDetailActivity.o1(PlugDetailActivity.this);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotplug\PlugDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */