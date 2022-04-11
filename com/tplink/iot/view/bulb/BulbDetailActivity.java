package com.tplink.iot.view.bulb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.Utils.k;
import com.tplink.iot.Utils.z0.g;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.cloud.bean.thing.common.ThingUsage;
import com.tplink.iot.view.bulb.settings.BulbSettingsActivity;
import com.tplink.iot.view.cloudconnect.CloudConnectGetStateActivity;
import com.tplink.iot.view.deviceshare.ShareDeviceUserListActivity;
import com.tplink.iot.view.feature.AwayModeActivity;
import com.tplink.iot.view.feature.ScheduleListActivity;
import com.tplink.iot.view.feature.TimerActivity;
import com.tplink.iot.view.feedback.EnumFeedbackCategory;
import com.tplink.iot.view.feedback.HelpAndFeedbackActivity;
import com.tplink.iot.viewmodel.home.u;
import com.tplink.iot.viewmodel.iotbulb.BulbDetailViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.BulbPresetsView;
import com.tplink.iot.widget.BulbPresetsView.c;
import com.tplink.iot.widget.businessview.ThingNextEventView;
import com.tplink.iot.widget.businessview.ThingUsageView;
import com.tplink.iot.widget.colorbulb.SimpleTextSwitcher;
import com.tplink.iot.widget.colorbulb.light.LightBgAnimView;
import com.tplink.iot.widget.colorbulb.light.LightBulbView;
import com.tplink.iot.widget.colorbulb.light.LightBulbView.d;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.IoTBulbDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.result.BulbNextEvent;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.DeviceManagerInfoBean;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.yinglan.scrolllayout.ScrollLayout;
import com.yinglan.scrolllayout.ScrollLayout.Status;
import com.yinglan.scrolllayout.ScrollLayout.g;
import java.util.List;

public class BulbDetailActivity
  extends BaseActivity
  implements View.OnClickListener, LightBulbView.d
{
  private TextView H3;
  private TextView I3;
  private TextView J3;
  private View K3;
  private SimpleTextSwitcher L3;
  private LightBulbView M3;
  private BulbPresetsView N3;
  private TPSwitchCompat O3;
  private ScrollLayout P3;
  private View Q3;
  private View R3;
  private ThingNextEventView S3;
  private ThingUsageView T3;
  private View U3;
  private String V3;
  private BulbDetailViewModel W3;
  private IoTBulbDevice X3;
  private BaseALIoTDevice Y3;
  private ImageView p0;
  private ImageView p1;
  private CardView p2;
  private CardView p3;
  private ImageView y;
  private ImageView z;
  
  public static void D1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, BulbDetailActivity.class);
    localIntent.putExtra("device_id_md5", paramString);
    paramContext.startActivity(localIntent);
  }
  
  private void E1(CloudConnectStateResult paramCloudConnectStateResult)
  {
    if (paramCloudConnectStateResult == null) {
      return;
    }
    int i = paramCloudConnectStateResult.getStatus();
    int j = 8;
    if (i == 0)
    {
      this.p2.setVisibility(8);
    }
    else
    {
      paramCloudConnectStateResult = this.p2;
      if (x1()) {
        j = 0;
      }
      paramCloudConnectStateResult.setVisibility(j);
    }
  }
  
  private void F1()
  {
    u.p(this, s1());
  }
  
  private void G1()
  {
    ThingContext localThingContext = TPIoTClientManager.k2(this.V3);
    if ((localThingContext != null) && (localThingContext.getIoTDevice() != null)) {
      if (localThingContext.getIoTDevice().isUserRoleTypeDevice())
      {
        this.p3.setVisibility(0);
      }
      else
      {
        this.p3.setVisibility(8);
        H1();
      }
    }
  }
  
  private void H1()
  {
    if ((com.tplink.iot.Utils.w0.a.d(this.V3)) && (x1())) {
      this.W3.x();
    } else {
      this.p2.setVisibility(8);
    }
  }
  
  private void I1()
  {
    this.y.setImageResource(2131689849);
    this.z.setImageDrawable(getResources().getDrawable(2131689837));
    this.H3.setTextColor(getResources().getColor(2131100206));
    this.I3.setTextColor(getResources().getColor(2131100206));
    this.I3.setCompoundDrawablesRelativeWithIntrinsicBounds(ResourcesCompat.getDrawable(getResources(), 2131689785, null), null, null, null);
    this.M3.r(false, 0, g.g());
  }
  
  private void J1(IoTBulbDevice paramIoTBulbDevice)
  {
    this.y.setImageResource(2131689776);
    this.z.setImageDrawable(getResources().getDrawable(2131689835));
    this.H3.setTextColor(getResources().getColor(2131099799));
    this.I3.setTextColor(getResources().getColor(2131099799));
    this.I3.setCompoundDrawablesRelativeWithIntrinsicBounds(ResourcesCompat.getDrawable(getResources(), 2131689784, null), null, null, null);
    this.M3.r(true, paramIoTBulbDevice.getBrightness(), g.g());
  }
  
  private void K1()
  {
    this.W3.u().observe(this, new f());
    this.W3.t().observe(this, new g());
    this.W3.F().observe(this, new h());
    this.W3.C().observe(this, new i());
    this.W3.r().observe(this, new j());
    this.W3.D().observe(this, new k());
    if (com.tplink.iot.Utils.w0.a.d(this.V3))
    {
      this.W3.v().observe(this, new a());
      this.W3.w().observe(this, new b());
    }
  }
  
  private void L1(BaseALIoTDevice paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice == null) {
      return;
    }
    this.Y3 = paramBaseALIoTDevice;
    this.H3.setText(l.d(this, paramBaseALIoTDevice.getDeviceType(), paramBaseALIoTDevice.getDeviceName()));
    paramBaseALIoTDevice = l.h(this.Y3);
    boolean bool = TextUtils.isEmpty(paramBaseALIoTDevice);
    int i = 8;
    if (bool)
    {
      this.I3.setVisibility(8);
    }
    else
    {
      this.I3.setVisibility(0);
      this.I3.setText(paramBaseALIoTDevice);
    }
    this.O3.setChecked(this.Y3.isCommonDevice());
    int j = t1();
    this.J3.setText(String.valueOf(j));
    paramBaseALIoTDevice = this.Q3;
    if (!y1()) {
      i = 0;
    }
    paramBaseALIoTDevice.setVisibility(i);
    if (!this.Y3.isSupportIoTCloud())
    {
      this.O3.setEnabled(false);
      this.R3.setAlpha(0.5F);
    }
    else
    {
      this.O3.setEnabled(true);
      this.R3.setAlpha(1.0F);
    }
    if ((this.Y3.isSupportIoTCloud()) && (this.Y3.getCloudIoTDevice() != null) && (!y1()))
    {
      this.H3.setEnabled(true);
      this.I3.setEnabled(true);
      this.Q3.setEnabled(true);
      this.Q3.setAlpha(1.0F);
    }
    else
    {
      this.H3.setEnabled(false);
      this.I3.setEnabled(false);
      this.Q3.setEnabled(false);
      this.Q3.setAlpha(0.5F);
    }
  }
  
  private void M1(List<Integer> paramList)
  {
    this.N3.setPresets(paramList);
  }
  
  private void N1(IoTBulbDevice paramIoTBulbDevice)
  {
    if (paramIoTBulbDevice != null)
    {
      if (paramIoTBulbDevice.isDeviceOn()) {
        J1(paramIoTBulbDevice);
      } else {
        I1();
      }
      this.N3.d();
    }
  }
  
  private String s1()
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
  
  private int t1()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.Y3;
    int i;
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.getDeviceManagerInfo() != null) && (this.Y3.getDeviceManagerInfo().getUserInfo() != null) && (this.Y3.getDeviceManagerInfo().getUserInfo().size() > 1)) {
      i = this.Y3.getDeviceManagerInfo().getUserInfo().size() - 1;
    } else {
      i = 0;
    }
    return i;
  }
  
  private void u1()
  {
    if (this.Y3 != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://www.tapo.com/app/#/faqList2?categoryType=");
      localStringBuilder.append(getString(2131951844));
      localStringBuilder.append(com.tplink.iot.model.about.d.a());
      HelpAndFeedbackActivity.k1(this, localStringBuilder.toString(), getString(2131952867), this.Y3.getDeviceType(), this.Y3.getDeviceModel(), EnumFeedbackCategory.BULB);
    }
  }
  
  private void v1()
  {
    this.N3.setOnPresetItemCheckListener(new d());
    this.O3.setOnSwitchCheckedChangeListener(new e());
  }
  
  private void w1()
  {
    Object localObject = (LightBgAnimView)findViewById(2131362154);
    this.y = ((ImageView)findViewById(2131363002));
    this.z = ((ImageView)findViewById(2131363121));
    this.p0 = ((ImageView)findViewById(2131363106));
    this.p2 = ((CardView)findViewById(2131362192));
    this.p3 = ((CardView)findViewById(2131362196));
    this.H3 = ((TextView)findViewById(2131364536));
    this.I3 = ((TextView)findViewById(2131364515));
    this.L3 = ((SimpleTextSwitcher)findViewById(2131362030));
    this.M3 = ((LightBulbView)findViewById(2131362157));
    this.N3 = ((BulbPresetsView)findViewById(2131363851));
    this.K3 = findViewById(2131363330);
    this.S3 = ((ThingNextEventView)findViewById(2131363543));
    this.T3 = ((ThingUsageView)findViewById(2131362421));
    this.O3 = ((TPSwitchCompat)findViewById(2131364126));
    this.P3 = ((ScrollLayout)findViewById(2131363972));
    this.R3 = findViewById(2131363879);
    this.Q3 = findViewById(2131362908);
    this.J3 = ((TextView)findViewById(2131364573));
    this.p1 = ((ImageView)findViewById(2131363103));
    this.U3 = findViewById(2131364819);
    this.M3.m((LightBgAnimView)localObject, this.N3, this.L3);
    int i = k.a(this, 50.0F) + com.tplink.iot.view.quicksetup.base.d.A(this);
    localObject = this.U3.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = i;
    this.U3.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.P3.setMinOffset(i);
    this.P3.setOnScrollChangedListener(new c());
    this.K3.post(new b(this));
    this.S3.setOnNextEventCallback(new a(this));
    this.M3.setOnBulbOperationListener(this);
    this.y.setOnClickListener(this);
    this.z.setOnClickListener(this);
    this.p2.setOnClickListener(this);
    findViewById(2131363113).setOnClickListener(this);
    findViewById(2131363000).setOnClickListener(this);
    findViewById(2131363144).setOnClickListener(this);
    findViewById(2131364615).setOnClickListener(this);
    findViewById(2131364348).setOnClickListener(this);
    findViewById(2131364673).setOnClickListener(this);
    findViewById(2131363103).setOnClickListener(this);
    this.Q3.setOnClickListener(this);
    findViewById(2131362913).setOnClickListener(this);
    v1();
  }
  
  private boolean x1()
  {
    ALIoTDevice localALIoTDevice = com.tplink.iot.Utils.w0.a.b(this.V3);
    boolean bool;
    if ((localALIoTDevice != null) && (localALIoTDevice.getThingDevice() == null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean y1()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.Y3;
    boolean bool;
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.isUserRoleTypeDevice())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void J(int paramInt, boolean paramBoolean)
  {
    this.W3.O(paramInt);
    if (paramBoolean) {
      com.tplink.iot.Utils.x0.i.D(this.V3, paramInt);
    }
  }
  
  public void L(int paramInt)
  {
    this.L3.a(true, paramInt, false);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131363144: 
    case 2131364673: 
      X0(TimerActivity.class, this.V3);
      break;
    case 2131363121: 
      X0(BulbSettingsActivity.class, this.V3);
      break;
    case 2131363113: 
    case 2131364615: 
      ScheduleListActivity.o1(this, this.V3, false);
      break;
    case 2131363103: 
      if (this.P3.getCurrentStatus() == ScrollLayout.Status.CLOSED) {
        this.P3.o();
      } else if (this.P3.getCurrentStatus() == ScrollLayout.Status.OPENED) {
        this.P3.m();
      }
      break;
    case 2131363002: 
      onBackPressed();
      break;
    case 2131363000: 
    case 2131364348: 
      X0(AwayModeActivity.class, this.V3);
      break;
    case 2131362913: 
      u1();
      com.tplink.iot.Utils.x0.i.w();
      break;
    case 2131362908: 
      ShareDeviceUserListActivity.v1(this, this.Y3.getDeviceIdMD5());
      com.tplink.iot.Utils.x0.i.C();
      break;
    case 2131362192: 
      CloudConnectGetStateActivity.j1(this, this.V3);
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558462);
    com.tplink.iot.view.quicksetup.base.d.J(this, findViewById(2131363353));
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.V3 = paramBundle;
    this.W3 = ((BulbDetailViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(BulbDetailViewModel.class));
    w1();
    K1();
    G1();
    com.tplink.iot.Utils.x0.i.s();
  }
  
  protected void onDestroy()
  {
    Object localObject = this.S3;
    if (localObject != null) {
      ((ThingNextEventView)localObject).e();
    }
    localObject = this.M3;
    if (localObject != null) {
      ((LightBulbView)localObject).p();
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    this.W3.U();
    this.W3.T();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.W3.S();
    this.W3.R();
    this.W3.B();
    this.W3.G();
  }
  
  public void w0(boolean paramBoolean)
  {
    this.W3.P(paramBoolean);
    com.tplink.iot.Utils.x0.i.e(this.V3, paramBoolean);
  }
  
  class a
    implements Observer<Boolean>
  {
    a() {}
    
    public void a(@Nullable Boolean paramBoolean)
    {
      if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
        BulbDetailActivity.h1(BulbDetailActivity.this).setVisibility(8);
      }
    }
  }
  
  class b
    implements Observer<com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult>>
  {
    b() {}
    
    public void a(@Nullable com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult> parami)
    {
      if ((parami != null) && (parami.b() == 0)) {
        BulbDetailActivity.i1(BulbDetailActivity.this, (CloudConnectStateResult)parami.a());
      }
    }
  }
  
  class c
    implements ScrollLayout.g
  {
    c() {}
    
    public void a(ScrollLayout.Status paramStatus)
    {
      if (paramStatus == ScrollLayout.Status.OPENED) {
        BulbDetailActivity.e1(BulbDetailActivity.this).setImageResource(2131689831);
      } else if (paramStatus == ScrollLayout.Status.CLOSED) {
        BulbDetailActivity.e1(BulbDetailActivity.this).setImageResource(2131689830);
      }
    }
    
    public void b(float paramFloat) {}
    
    public void c(int paramInt) {}
  }
  
  class d
    implements BulbPresetsView.c
  {
    d() {}
    
    public void a(int paramInt)
    {
      BulbDetailActivity.this.J(paramInt, false);
      com.tplink.iot.Utils.x0.i.d(BulbDetailActivity.f1(BulbDetailActivity.this), paramInt);
    }
  }
  
  class e
    implements TPSwitchCompat.a
  {
    e() {}
    
    public void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean2)
      {
        BulbDetailActivity.j1(BulbDetailActivity.this).n(paramBoolean1);
        com.tplink.iot.Utils.x0.i.x(BulbDetailActivity.f1(BulbDetailActivity.this), paramBoolean1);
        if (!paramBoolean1) {
          BulbDetailActivity.k1(BulbDetailActivity.this);
        }
      }
    }
  }
  
  class f
    implements Observer<IoTBulbDevice>
  {
    f() {}
    
    public void a(@Nullable IoTBulbDevice paramIoTBulbDevice)
    {
      BulbDetailActivity.m1(BulbDetailActivity.this, paramIoTBulbDevice);
      paramIoTBulbDevice = BulbDetailActivity.this;
      BulbDetailActivity.n1(paramIoTBulbDevice, BulbDetailActivity.l1(paramIoTBulbDevice));
    }
  }
  
  class g
    implements Observer<List<Integer>>
  {
    g() {}
    
    public void a(@Nullable List<Integer> paramList)
    {
      BulbDetailActivity.o1(BulbDetailActivity.this, paramList);
    }
  }
  
  class h
    implements Observer<BulbNextEvent>
  {
    h() {}
    
    public void a(@Nullable BulbNextEvent paramBulbNextEvent)
    {
      BulbDetailActivity.p1(BulbDetailActivity.this).r(paramBulbNextEvent, BulbDetailActivity.j1(BulbDetailActivity.this).z());
    }
  }
  
  class i
    implements Observer<ThingUsage>
  {
    i() {}
    
    public void a(@Nullable ThingUsage paramThingUsage)
    {
      BulbDetailActivity.q1(BulbDetailActivity.this).o(paramThingUsage);
      com.tplink.iot.Utils.x0.i.t(BulbDetailActivity.f1(BulbDetailActivity.this), paramThingUsage);
    }
  }
  
  class j
    implements Observer<BaseALIoTDevice>
  {
    j() {}
    
    public void a(@Nullable BaseALIoTDevice paramBaseALIoTDevice)
    {
      BulbDetailActivity.r1(BulbDetailActivity.this, paramBaseALIoTDevice);
    }
  }
  
  class k
    implements Observer<ThingFirmware>
  {
    k() {}
    
    public void a(@Nullable ThingFirmware paramThingFirmware)
    {
      ImageView localImageView = BulbDetailActivity.g1(BulbDetailActivity.this);
      int i;
      if ((paramThingFirmware != null) && (paramThingFirmware.isNeedToUpgrade())) {
        i = 0;
      } else {
        i = 8;
      }
      localImageView.setVisibility(i);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\bulb\BulbDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */