package com.tplink.iot.view.iothub;

import android.annotation.SuppressLint;
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
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.Utils.TPLongMaterialDialogV2.Builder;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.u0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.devices.featuredactions.view.FeaturedActionHostActivity;
import com.tplink.iot.view.cloudconnect.CloudConnectGetStateActivity;
import com.tplink.iot.view.deviceshare.ShareDeviceUserListActivity;
import com.tplink.iot.view.feedback.EnumFeedbackCategory;
import com.tplink.iot.view.feedback.HelpAndFeedbackActivity;
import com.tplink.iot.view.iothub.guardmode.GuardModeActivity;
import com.tplink.iot.viewmodel.home.u;
import com.tplink.iot.viewmodel.iothub.HubDetailViewModel;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.widget.DiffuseView;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import com.tplink.libtpnetwork.IoTNetwork.ThingContext;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.hub.IoTHubDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.ALIoTDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.TPCloudNetwork.device.DeviceManagerInfoBean;
import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode;
import com.tplink.libtpnetwork.enumerate.EnumGuardMode.a;
import com.yinglan.scrolllayout.ScrollLayout;
import com.yinglan.scrolllayout.ScrollLayout.Status;
import com.yinglan.scrolllayout.ScrollLayout.g;
import java.util.List;

public class HubDetailActivity
  extends BaseActivity
  implements View.OnClickListener
{
  private TextView H3;
  private TextView I3;
  private ImageView J3;
  private ImageView K3;
  private ImageView L3;
  private ImageView M3;
  private ImageView N3;
  private View O3;
  private View P3;
  private View Q3;
  private View R3;
  private View S3;
  private View T3;
  private CardView U3;
  private CardView V3;
  private RadioGroup W3;
  private View X3;
  private q Y3;
  private boolean Z3;
  private EnumGuardMode a4 = EnumGuardMode.HOME;
  private HubDetailViewModel b4;
  private String c4;
  private BaseALIoTDevice d4;
  private TPSwitchCompat e4;
  private long f4 = 0L;
  private ImageView p0;
  private TextView p1;
  private TextView p2;
  private TextView p3;
  private DiffuseView y;
  private ScrollLayout z;
  
  public static void K1(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, HubDetailActivity.class);
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
      this.U3.setVisibility(8);
    }
    else
    {
      paramCloudConnectStateResult = this.U3;
      if (q1()) {
        j = 0;
      }
      paramCloudConnectStateResult.setVisibility(j);
    }
  }
  
  private void M1(EnumGuardMode paramEnumGuardMode)
  {
    if (this.a4 != paramEnumGuardMode)
    {
      this.a4 = paramEnumGuardMode;
      this.b4.D(paramEnumGuardMode.getValue(), true);
    }
  }
  
  private void N1()
  {
    new TPLongMaterialDialogV2.Builder(this).e(2131952799).i(2131951774, 2131099804, new o(this)).l(2131954370, 2131099808, new l(this)).t();
  }
  
  private void O1()
  {
    u.p(this, i1());
  }
  
  private void P1()
  {
    ThingContext localThingContext = TPIoTClientManager.k2(this.c4);
    if ((localThingContext != null) && (localThingContext.getIoTDevice() != null)) {
      if (localThingContext.getIoTDevice().isUserRoleTypeDevice())
      {
        this.V3.setVisibility(0);
      }
      else
      {
        this.V3.setVisibility(8);
        Q1();
      }
    }
  }
  
  private void Q1()
  {
    if ((com.tplink.iot.Utils.w0.a.d(this.c4)) && (q1())) {
      this.b4.s();
    } else {
      this.U3.setVisibility(8);
    }
  }
  
  private void R1()
  {
    this.b4.r().observe(this, new h(this));
    this.b4.p().observe(this, new m(this));
    this.b4.t().observe(this, new i(this));
    this.b4.x().observe(this, new k(this));
    this.b4.w().observe(this, new n(this));
  }
  
  private void S1()
  {
    com.tplink.iot.Utils.q.a(this, this.J3, 2131690258, 2131690259, 800);
    this.y.c();
    this.p3.setText(k1(this.a4, true));
    this.H3.setText(l1(true));
    U1(this.a4, true);
    this.Z3 = true;
    this.b4.D(this.a4.getValue(), this.Z3);
    com.tplink.iot.Utils.x0.i.y(this.c4, this.Z3);
  }
  
  private void T1(BaseALIoTDevice paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice == null) {
      return;
    }
    this.d4 = paramBaseALIoTDevice;
    this.e4.setChecked(paramBaseALIoTDevice.isCommonDevice());
    int i = j1();
    this.I3.setText(String.valueOf(i));
    paramBaseALIoTDevice = com.tplink.iot.Utils.z0.l.h(this.d4);
    boolean bool = TextUtils.isEmpty(paramBaseALIoTDevice);
    int j = 8;
    if (bool)
    {
      this.p2.setVisibility(8);
    }
    else
    {
      this.p2.setVisibility(0);
      this.p2.setText(paramBaseALIoTDevice);
    }
    paramBaseALIoTDevice = this.O3;
    if (s1()) {
      i = 8;
    } else {
      i = 0;
    }
    paramBaseALIoTDevice.setVisibility(i);
    paramBaseALIoTDevice = this.P3;
    i = j;
    if (com.tplink.iot.Utils.w0.a.i(this.c4)) {
      i = 0;
    }
    paramBaseALIoTDevice.setVisibility(i);
    if (!this.d4.isSupportIoTCloud())
    {
      this.e4.setEnabled(false);
      this.P3.setAlpha(0.5F);
      this.T3.setEnabled(false);
      this.T3.setAlpha(0.5F);
    }
    else
    {
      this.e4.setEnabled(true);
      this.P3.setAlpha(1.0F);
      this.T3.setEnabled(true);
      this.T3.setAlpha(1.0F);
    }
    if (((!this.d4.isSupportIoTCloud()) && (this.d4.getCloudIoTDevice() == null)) || (s1()))
    {
      this.O3.setEnabled(false);
      this.O3.setAlpha(0.5F);
    }
    else
    {
      this.O3.setEnabled(true);
      this.O3.setAlpha(1.0F);
    }
    if (s1())
    {
      this.Q3.setEnabled(false);
      this.Q3.setAlpha(0.5F);
    }
    else
    {
      this.Q3.setEnabled(true);
      this.Q3.setAlpha(1.0F);
    }
  }
  
  private void U1(EnumGuardMode paramEnumGuardMode, boolean paramBoolean)
  {
    ImageView localImageView = this.N3;
    int i = 4;
    if (paramBoolean) {
      j = 4;
    } else {
      j = 0;
    }
    localImageView.setVisibility(j);
    localImageView = this.M3;
    int j = i;
    if (paramBoolean) {
      j = 0;
    }
    localImageView.setVisibility(j);
    if (paramBoolean)
    {
      j = b.a[paramEnumGuardMode.ordinal()];
      if (j != 1)
      {
        if (j != 2)
        {
          if (j == 3) {
            this.L3.setImageResource(2131689737);
          }
        }
        else {
          this.L3.setImageResource(2131689732);
        }
      }
      else {
        this.L3.setImageResource(2131689735);
      }
    }
    else
    {
      this.L3.setImageResource(2131689736);
    }
  }
  
  @SuppressLint({"UseCompatLoadingForDrawables"})
  private void V1(IoTHubDevice paramIoTHubDevice)
  {
    if (paramIoTHubDevice != null)
    {
      this.p1.setText(com.tplink.iot.Utils.z0.l.e(this, EnumDeviceType.HUB.getDeviceType(), this.b4.u(), paramIoTHubDevice.getModel()));
      this.Z3 = org.apache.commons.lang.b.b(Boolean.valueOf(paramIoTHubDevice.isGuardOn()));
      Object localObject1 = EnumGuardMode.Companion;
      if (paramIoTHubDevice.getGuardMode() == null) {
        localObject2 = "";
      } else {
        localObject2 = paramIoTHubDevice.getGuardMode();
      }
      Object localObject2 = ((EnumGuardMode.a)localObject1).a((String)localObject2);
      this.a4 = ((EnumGuardMode)localObject2);
      this.W3.check(h1((EnumGuardMode)localObject2, this.Z3));
      localObject2 = this.W3;
      boolean bool = this.Z3;
      int i = 0;
      int j;
      if (bool) {
        j = 0;
      } else {
        j = 4;
      }
      ((RadioGroup)localObject2).setVisibility(j);
      localObject1 = this.J3;
      localObject2 = getResources();
      if (this.Z3) {
        j = 2131690259;
      } else {
        j = 2131690258;
      }
      ((ImageView)localObject1).setBackground(((Resources)localObject2).getDrawable(j));
      U1(this.a4, this.Z3);
      this.p3.setText(k1(this.a4, this.Z3));
      this.H3.setText(l1(this.Z3));
      localObject2 = this.S3;
      if (paramIoTHubDevice.isInAlarm()) {
        j = i;
      } else {
        j = 8;
      }
      ((View)localObject2).setVisibility(j);
    }
  }
  
  private int h1(EnumGuardMode paramEnumGuardMode, boolean paramBoolean)
  {
    if ((paramEnumGuardMode != null) && (paramBoolean))
    {
      int i = b.a[paramEnumGuardMode.ordinal()];
      if (i != 2)
      {
        if (i != 3) {
          return 2131362922;
        }
        return 2131362964;
      }
      return 2131362889;
    }
    return -1;
  }
  
  private String i1()
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
  
  private int j1()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.d4;
    int i;
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.isHasThingOrCloudDevice()) && (this.d4.getDeviceManagerInfo() != null) && (this.d4.getDeviceManagerInfo().getUserInfo() != null) && (this.d4.getDeviceManagerInfo().getUserInfo().size() > 1)) {
      i = this.d4.getDeviceManagerInfo().getUserInfo().size() - 1;
    } else {
      i = 0;
    }
    return i;
  }
  
  private String k1(EnumGuardMode paramEnumGuardMode, boolean paramBoolean)
  {
    int i = 2131951888;
    int j = i;
    if (paramEnumGuardMode != null)
    {
      j = b.a[paramEnumGuardMode.ordinal()];
      if (j != 2)
      {
        if (j != 3) {
          j = i;
        } else {
          j = 2131952805;
        }
      }
      else {
        j = 2131953372;
      }
    }
    if (paramBoolean) {
      paramEnumGuardMode = getString(2131953101, new Object[] { getString(j) });
    } else {
      paramEnumGuardMode = getString(2131952795);
    }
    return paramEnumGuardMode;
  }
  
  private String l1(boolean paramBoolean)
  {
    String str;
    if (paramBoolean) {
      str = getString(2131952801);
    } else {
      str = getString(2131952802);
    }
    return str;
  }
  
  private void m1()
  {
    if (this.d4 != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://www.tapo.com/app/#/faqList2?categoryType=");
      localStringBuilder.append(getString(2131952857));
      localStringBuilder.append(com.tplink.iot.model.about.d.a());
      HelpAndFeedbackActivity.k1(this, localStringBuilder.toString(), getString(2131952874), this.d4.getDeviceType(), this.d4.getDeviceModel(), EnumFeedbackCategory.HUB);
    }
  }
  
  private void n1(@Nullable com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean> parama)
  {
    
    if (parama == null) {
      return;
    }
    parama = (Boolean)parama.a();
    if (parama != null) {
      if (parama.booleanValue()) {
        N1();
      } else {
        S1();
      }
    }
  }
  
  private void o1()
  {
    this.J3 = ((ImageView)findViewById(2131363003));
    this.K3 = ((ImageView)findViewById(2131363106));
    this.z = ((ScrollLayout)findViewById(2131363972));
    this.U3 = ((CardView)findViewById(2131362192));
    this.V3 = ((CardView)findViewById(2131362196));
    this.y = ((DiffuseView)findViewById(2131362450));
    this.p0 = ((ImageView)findViewById(2131363103));
    this.L3 = ((ImageView)findViewById(2131363060));
    this.N3 = ((ImageView)findViewById(2131363058));
    this.M3 = ((ImageView)findViewById(2131363059));
    this.p1 = ((TextView)findViewById(2131364536));
    this.p2 = ((TextView)findViewById(2131364515));
    this.p3 = ((TextView)findViewById(2131364563));
    this.H3 = ((TextView)findViewById(2131364564));
    this.S3 = findViewById(2131363340);
    this.e4 = ((TPSwitchCompat)findViewById(2131364126));
    this.P3 = findViewById(2131363879);
    this.O3 = findViewById(2131362908);
    this.I3 = ((TextView)findViewById(2131364573));
    this.Q3 = findViewById(2131362920);
    this.R3 = findViewById(2131362885);
    this.T3 = findViewById(2131362966);
    this.W3 = ((RadioGroup)findViewById(2131362731));
    this.X3 = findViewById(2131364819);
    Object localObject = new q(this);
    this.Y3 = ((q)localObject);
    ((q)localObject).k(new p(this));
    findViewById(2131363343).setOnClickListener(this);
    this.p0.setOnClickListener(this);
    findViewById(2131363002).setOnClickListener(this);
    findViewById(2131362675).setOnClickListener(this);
    findViewById(2131362663).setOnClickListener(this);
    findViewById(2131362111).setOnClickListener(this);
    this.Q3.setOnClickListener(this);
    this.R3.setOnClickListener(this);
    findViewById(2131362894).setOnClickListener(this);
    this.T3.setOnClickListener(this);
    findViewById(2131362908).setOnClickListener(this);
    findViewById(2131362913).setOnClickListener(this);
    findViewById(2131362192).setOnClickListener(this);
    findViewById(2131362922).setOnClickListener(this);
    findViewById(2131362889).setOnClickListener(this);
    findViewById(2131362964).setOnClickListener(this);
    this.y.setIsAutoStop(true);
    int i = com.tplink.iot.Utils.k.a(this, 50.0F) + com.tplink.iot.view.quicksetup.base.d.A(this);
    localObject = this.X3.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height = i;
    this.X3.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.z.setMinOffset(i);
    this.z.setOnScrollChangedListener(new a());
    this.p0.post(new g(this));
    this.e4.setOnSwitchCheckedChangeListener(new j(this));
    this.Y3.m(this.Q3);
  }
  
  private boolean p1()
  {
    ALIoTDevice localALIoTDevice = com.tplink.iot.Utils.w0.a.b(this.c4);
    boolean bool;
    if ((localALIoTDevice != null) && (localALIoTDevice.getCloudIoTDevice() == null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean q1()
  {
    if (com.tplink.iot.Utils.w0.a.i(this.c4)) {
      return r1();
    }
    return p1();
  }
  
  private boolean r1()
  {
    ALIoTDevice localALIoTDevice = com.tplink.iot.Utils.w0.a.b(this.c4);
    boolean bool;
    if ((localALIoTDevice != null) && (localALIoTDevice.getThingDevice() == null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean s1()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.d4;
    boolean bool;
    if ((localBaseALIoTDevice != null) && (localBaseALIoTDevice.isUserRoleTypeDevice())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void onBackPressed()
  {
    if (this.Y3.i())
    {
      this.Y3.e();
      return;
    }
    super.onBackPressed();
  }
  
  @SuppressLint({"NonConstantResourceId"})
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
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
    case 2131362966: 
      paramView = this.d4;
      if (paramView != null) {
        paramView = paramView.getDeviceModel();
      } else {
        paramView = "";
      }
      FeaturedActionHostActivity.o1(this, this.c4, EnumDeviceType.HUB.getDeviceType(), paramView);
      break;
    case 2131362964: 
      M1(EnumGuardMode.SLEEP);
      break;
    case 2131362922: 
      M1(EnumGuardMode.HOME);
      break;
    case 2131362920: 
      X0(GuardModeActivity.class, this.c4);
      break;
    case 2131362913: 
      m1();
      com.tplink.iot.Utils.x0.i.w();
      break;
    case 2131362908: 
      paramView = this.d4;
      if (paramView != null) {
        ShareDeviceUserListActivity.v1(this, paramView.getDeviceIdMD5());
      }
      com.tplink.iot.Utils.x0.i.C();
      break;
    case 2131362894: 
      X0(HubChildDeviceListActivity.class, this.c4);
      break;
    case 2131362889: 
      M1(EnumGuardMode.AWAY);
      break;
    case 2131362885: 
      X0(HubAlarmLogActivity.class, this.c4);
      break;
    case 2131362675: 
      X0(HubSettingsActivity.class, this.c4);
      break;
    case 2131362663: 
    case 2131363139: 
    case 2131363343: 
      long l = System.currentTimeMillis();
      if (l - this.f4 < 500L) {
        return;
      }
      this.f4 = l;
      u0.a(this, 200L);
      if (this.Z3)
      {
        this.J3.setBackground(ContextCompat.getDrawable(this, 2131690258));
        if (this.y.b()) {
          this.y.d();
        }
        this.p3.setText(k1(this.a4, false));
        this.H3.setText(l1(false));
        U1(this.a4, false);
        this.Z3 = false;
        this.b4.D(this.a4.getValue(), this.Z3);
        com.tplink.iot.Utils.x0.i.y(this.c4, this.Z3);
      }
      else
      {
        s0.l(this);
        this.b4.n();
      }
      break;
    case 2131362192: 
      CloudConnectGetStateActivity.j1(this, this.c4);
      break;
    case 2131362111: 
      this.b4.F();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131558541);
    com.tplink.iot.view.quicksetup.base.d.J(this, findViewById(2131363353));
    paramBundle = getIntent().getStringExtra("device_id_md5");
    this.c4 = paramBundle;
    this.b4 = ((HubDetailViewModel)ViewModelProviders.of(this, new IoTViewModelFactory(this, paramBundle)).get(HubDetailViewModel.class));
    o1();
    R1();
    P1();
    com.tplink.iot.Utils.x0.i.s();
    this.b4.y();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    this.y.d();
    this.b4.G();
  }
  
  protected void onResume()
  {
    super.onResume();
    this.b4.E();
  }
  
  class a
    implements ScrollLayout.g
  {
    a() {}
    
    public void a(ScrollLayout.Status paramStatus)
    {
      if (paramStatus == ScrollLayout.Status.OPENED) {
        HubDetailActivity.e1(HubDetailActivity.this).setImageResource(2131689831);
      } else if (paramStatus == ScrollLayout.Status.CLOSED) {
        HubDetailActivity.e1(HubDetailActivity.this).setImageResource(2131689830);
      }
      HubDetailActivity.g1(HubDetailActivity.this).j(HubDetailActivity.f1(HubDetailActivity.this));
    }
    
    public void b(float paramFloat) {}
    
    public void c(int paramInt) {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iothub\HubDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */