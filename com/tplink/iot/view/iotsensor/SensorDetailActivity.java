package com.tplink.iot.view.iotsensor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.scwang.smart.refresh.layout.c.e;
import com.scwang.smart.refresh.layout.c.g;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.context.b;
import com.tplink.iot.Utils.TPMaterialDialogV3.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV3.d;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.d0.g;
import com.tplink.iot.Utils.k;
import com.tplink.iot.Utils.z0.r;
import com.tplink.iot.adapter.iotsensor.SensorTriggerLogAdapter;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivitySensorDetailBinding;
import com.tplink.iot.databinding.ActivitySensorDetailBottomBinding;
import com.tplink.iot.databinding.ActivitySensorDetailContentBinding;
import com.tplink.iot.devicecommon.adapter.GeneralAdapter;
import com.tplink.iot.devices.featuredactions.view.FeaturedActionHostActivity;
import com.tplink.iot.devices.featuredactions.view.FeaturedActionHostActivity.a;
import com.tplink.iot.view.deviceshare.ShareDeviceUserListActivity;
import com.tplink.iot.view.feedback.EnumFeedbackCategory;
import com.tplink.iot.view.feedback.HelpAndFeedbackActivity;
import com.tplink.iot.viewmodel.home.u;
import com.tplink.iot.viewmodel.iotsensor.SensorDetailViewModel;
import com.tplink.iot.widget.refreshlayout.SmartRefreshFooter;
import com.tplink.iot.widget.refreshlayout.SmartRefreshHeader;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumNotificationMsgType;
import com.yinglan.scrolllayout.ScrollLayout;
import com.yinglan.scrolllayout.ScrollLayout.Status;
import com.yinglan.scrolllayout.ScrollLayout.g;
import java.util.List;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class SensorDetailActivity
  extends SensorBaseActivity<SensorDetailViewModel>
  implements View.OnClickListener
{
  public static final a p0 = new a(null);
  private final kotlin.f H3 = h.b(new e(this));
  private BaseALIoTDevice<?> I3;
  private SensorTriggerLogAdapter J3;
  private boolean K3;
  private String L3;
  private boolean M3;
  private ActivitySensorDetailBinding p1;
  private final kotlin.f p2 = h.b(new d(this));
  private final kotlin.f p3 = h.b(new f(this));
  
  public SensorDetailActivity()
  {
    super(SensorDetailViewModel.class);
  }
  
  private final void A1()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.I3;
    if (localBaseALIoTDevice != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://www.tapo.com/app/#/faqList2?categoryType=");
      localStringBuilder.append(v1());
      localStringBuilder.append(com.tplink.iot.model.about.d.a());
      HelpAndFeedbackActivity.k1(this, localStringBuilder.toString(), u1(), localBaseALIoTDevice.getDeviceType(), localBaseALIoTDevice.getDeviceModel(), w1());
    }
  }
  
  private final void B1()
  {
    String str1 = ((SensorDetailViewModel)f1()).v();
    FeaturedActionHostActivity.a locala = FeaturedActionHostActivity.p0;
    String str2 = e1();
    Object localObject = this.I3;
    if (localObject != null) {
      localObject = ((BaseALIoTDevice)localObject).getDeviceType();
    } else {
      localObject = null;
    }
    locala.a(this, str2, (String)localObject, str1);
  }
  
  private final boolean C1()
  {
    String str = ((SensorDetailViewModel)f1()).v();
    boolean bool;
    if ((!j.a(str, "S200B")) && (!j.a(str, "T100")) && (!j.a(str, "T110"))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static final void D1(Context paramContext, String paramString)
  {
    p0.a(paramContext, paramString);
  }
  
  public static final void E1(Context paramContext, String paramString1, String paramString2)
  {
    p0.b(paramContext, paramString1, paramString2);
  }
  
  private final void F1(com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult> parami)
  {
    if (parami != null)
    {
      parami = (CloudConnectStateResult)parami.a();
      if (parami != null)
      {
        int i = parami.getStatus();
        int j = 8;
        if (i == 0)
        {
          parami = this.p1;
          if (parami == null) {
            j.t("mBinding");
          }
          parami = parami.q.c;
          j.d(parami, "mBinding.sensorDetailContent.cardLocalOnly");
          parami.setVisibility(8);
        }
        else
        {
          parami = this.p1;
          if (parami == null) {
            j.t("mBinding");
          }
          parami = parami.q.c;
          j.d(parami, "mBinding.sensorDetailContent.cardLocalOnly");
          if (((SensorDetailViewModel)f1()).J()) {
            j = 0;
          }
          parami.setVisibility(j);
        }
      }
    }
  }
  
  private final void G1()
  {
    final boolean bool = C1();
    ScrollLayout localScrollLayout = z1();
    localScrollLayout.setMinOffset(k.a(this, 50.0F) + com.tplink.iot.view.quicksetup.base.d.A(this));
    x1().post(new g(localScrollLayout, this, bool));
    localScrollLayout.setOnScrollChangedListener(new h(this, bool));
  }
  
  private final void H1()
  {
    TPSmartRefreshLayout localTPSmartRefreshLayout = y1();
    localTPSmartRefreshLayout.Q(new SmartRefreshHeader(this));
    localTPSmartRefreshLayout.O(new SmartRefreshFooter(this));
    localTPSmartRefreshLayout.G(true);
    localTPSmartRefreshLayout.E(true);
    localTPSmartRefreshLayout.F(true);
    localTPSmartRefreshLayout.N(new i(this));
    localTPSmartRefreshLayout.L(new j(this));
  }
  
  private final void I1()
  {
    Object localObject = b.d.s.a.a.f();
    if (localObject != null)
    {
      localObject = ((b)localObject).c();
      if (localObject != null)
      {
        localObject = ((TCAccountBean)localObject).getCloudUserName();
        if (localObject != null) {
          break label33;
        }
      }
    }
    localObject = "";
    label33:
    u.p(this, (String)localObject);
  }
  
  private final void J1()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Sensor showLocalOnlyOrUserDeviceTips: ");
    ((StringBuilder)localObject).append(((SensorDetailViewModel)f1()).O());
    b.d.w.c.a.a(((StringBuilder)localObject).toString());
    if (((SensorDetailViewModel)f1()).O())
    {
      localObject = this.p1;
      if (localObject == null) {
        j.t("mBinding");
      }
      localObject = ((ActivitySensorDetailBinding)localObject).q.d;
      j.d(localObject, "mBinding.sensorDetailContent.cardUserDevice");
      ((FrameLayout)localObject).setVisibility(0);
    }
    else
    {
      localObject = this.p1;
      if (localObject == null) {
        j.t("mBinding");
      }
      localObject = ((ActivitySensorDetailBinding)localObject).q.d;
      j.d(localObject, "mBinding.sensorDetailContent.cardUserDevice");
      ((FrameLayout)localObject).setVisibility(8);
      K1();
    }
  }
  
  private final void K1()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Sensor showLocalView: ");
    ((StringBuilder)localObject).append(((SensorDetailViewModel)f1()).J());
    b.d.w.c.a.a(((StringBuilder)localObject).toString());
    if (((SensorDetailViewModel)f1()).J())
    {
      localObject = this.p1;
      if (localObject == null) {
        j.t("mBinding");
      }
      localObject = ((ActivitySensorDetailBinding)localObject).q.c;
      j.d(localObject, "mBinding.sensorDetailContent.cardLocalOnly");
      ((FrameLayout)localObject).setVisibility(0);
    }
    else
    {
      localObject = this.p1;
      if (localObject == null) {
        j.t("mBinding");
      }
      localObject = ((ActivitySensorDetailBinding)localObject).q.c;
      j.d(localObject, "mBinding.sensorDetailContent.cardLocalOnly");
      ((FrameLayout)localObject).setVisibility(8);
    }
  }
  
  private final void L1()
  {
    r.n(getSupportFragmentManager(), this.I3);
  }
  
  private final void M1()
  {
    String str = this.L3;
    if (str != null)
    {
      Object localObject = this.I3;
      if ((localObject != null) && (EnumNotificationMsgType.fromString(str) == EnumNotificationMsgType.TAPO_SENSOR_FREQUENTLY_TRIGGERED) && (!this.M3))
      {
        this.M3 = true;
        localObject = getString(2131953779, new Object[] { com.tplink.iot.Utils.z0.l.c(this, (BaseALIoTDevice)localObject) });
        j.d(localObject, "getString(R.string.senso…DeviceName(this, device))");
        new TPMaterialDialogV3.Builder(this).f((String)localObject).j(2131952441, 2131099808, new k(this)).t();
      }
    }
  }
  
  private final void N1()
  {
    ScrollLayout localScrollLayout = z1();
    if (localScrollLayout.getCurrentStatus() == ScrollLayout.Status.OPENED) {
      localScrollLayout.m();
    } else if (localScrollLayout.getCurrentStatus() == ScrollLayout.Status.CLOSED) {
      localScrollLayout.o();
    }
  }
  
  private final void O1()
  {
    Object localObject = this.I3;
    if (localObject != null) {
      localObject = ((BaseALIoTDevice)localObject).getDeviceModel();
    } else {
      localObject = null;
    }
    if (j.a(localObject, "T110"))
    {
      localObject = this.p1;
      if (localObject == null) {
        j.t("mBinding");
      }
      ((ActivitySensorDetailBinding)localObject).q.p0.setImageResource(((SensorDetailViewModel)f1()).V());
    }
  }
  
  private final void P1(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    if (paramBaseALIoTDevice != null)
    {
      Object localObject = this.J3;
      if (localObject == null) {
        j.t("mTriggerLogAdapter");
      }
      String str = paramBaseALIoTDevice.getDeviceRegion();
      j.d(str, "deviceRegion");
      ((SensorTriggerLogAdapter)localObject).I(str);
      localObject = p.a;
    }
    else
    {
      paramBaseALIoTDevice = null;
    }
    this.I3 = paramBaseALIoTDevice;
    M1();
    O1();
  }
  
  private final String u1()
  {
    String str;
    if (r.l(this.I3))
    {
      str = getString(2131952878);
      j.d(str, "getString(R.string.iot_motion_sensors)");
    }
    else if (r.k(this.I3))
    {
      str = getString(2131952872);
      j.d(str, "getString(R.string.iot_contact_sensors)");
    }
    else if (r.j(this.I3))
    {
      str = getString(2131952868);
      j.d(str, "getString(R.string.iot_buttons)");
    }
    else
    {
      str = getString(2131952882);
      j.d(str, "getString(R.string.iot_sensors)");
    }
    return str;
  }
  
  private final String v1()
  {
    String str;
    if (r.l(this.I3))
    {
      str = getString(2131953130);
      j.d(str, "getString(R.string.motion_sensor_param)");
    }
    else if (r.k(this.I3))
    {
      str = getString(2131952471);
      j.d(str, "getString(R.string.contact_sensor_param)");
    }
    else if (r.j(this.I3))
    {
      str = getString(2131951847);
      j.d(str, "getString(R.string.button_param)");
    }
    else
    {
      str = getString(2131953130);
      j.d(str, "getString(R.string.motion_sensor_param)");
    }
    return str;
  }
  
  private final EnumFeedbackCategory w1()
  {
    EnumFeedbackCategory localEnumFeedbackCategory;
    if (r.l(this.I3)) {
      localEnumFeedbackCategory = EnumFeedbackCategory.MOTION_SENSOR;
    } else if (r.k(this.I3)) {
      localEnumFeedbackCategory = EnumFeedbackCategory.CONTACT_SENSOR;
    } else if (r.j(this.I3)) {
      localEnumFeedbackCategory = EnumFeedbackCategory.BUTTON;
    } else {
      localEnumFeedbackCategory = EnumFeedbackCategory.MOTION_SENSOR;
    }
    return localEnumFeedbackCategory;
  }
  
  private final ImageView x1()
  {
    return (ImageView)this.p2.getValue();
  }
  
  private final TPSmartRefreshLayout y1()
  {
    return (TPSmartRefreshLayout)this.H3.getValue();
  }
  
  private final ScrollLayout z1()
  {
    return (ScrollLayout)this.p3.getValue();
  }
  
  protected void g1()
  {
    super.g1();
    Object localObject = getIntent();
    if (localObject != null) {
      localObject = ((Intent)localObject).getStringExtra("NotificationMsgTypeExtra");
    } else {
      localObject = null;
    }
    this.L3 = ((String)localObject);
    M1();
  }
  
  public void h1()
  {
    Object localObject1 = DataBindingUtil.setContentView(this, 2131558648);
    j.d(localObject1, "DataBindingUtil.setConte…t.activity_sensor_detail)");
    localObject1 = (ActivitySensorDetailBinding)localObject1;
    this.p1 = ((ActivitySensorDetailBinding)localObject1);
    if (localObject1 == null) {
      j.t("mBinding");
    }
    ((ActivitySensorDetailBinding)localObject1).h((SensorDetailViewModel)f1());
    ((ActivitySensorDetailBinding)localObject1).i(this);
    ((ViewDataBinding)localObject1).setLifecycleOwner(this);
    com.tplink.iot.view.quicksetup.base.d.J(this, findViewById(2131363353));
    G1();
    J1();
    H1();
    boolean bool = C1();
    localObject1 = this.p1;
    if (localObject1 == null) {
      j.t("mBinding");
    }
    localObject1 = ((ActivitySensorDetailBinding)localObject1).f.p0;
    j.d(localObject1, "mBinding.sensorDetailBottom.itemSmartScene");
    int i = 0;
    int j;
    if (bool) {
      j = 0;
    } else {
      j = 8;
    }
    ((View)localObject1).setVisibility(j);
    localObject1 = this.p1;
    if (localObject1 == null) {
      j.t("mBinding");
    }
    localObject1 = ((ActivitySensorDetailBinding)localObject1).f.q;
    j.d(localObject1, "mBinding.sensorDetailBottom.dividerLine");
    if (bool) {
      j = i;
    } else {
      j = 8;
    }
    ((View)localObject1).setVisibility(j);
    localObject1 = this.p1;
    if (localObject1 == null) {
      j.t("mBinding");
    }
    ((ActivitySensorDetailBinding)localObject1).f.x.setOnSwitchCheckedChangeListener(new b(this));
    localObject1 = this.p1;
    if (localObject1 == null) {
      j.t("mBinding");
    }
    d0.h(((ActivitySensorDetailBinding)localObject1).q.J3, getString(2131954179), ContextCompat.getColor(this, 2131099811), new c(this));
    localObject1 = new SensorTriggerLogAdapter(this, kotlin.collections.l.d());
    Object localObject2 = this.p1;
    if (localObject2 == null) {
      j.t("mBinding");
    }
    localObject2 = ((ActivitySensorDetailBinding)localObject2).q.H3;
    j.d(localObject2, "mBinding.sensorDetailContent.rvTriggerLogs");
    ((RecyclerView)localObject2).setAdapter((RecyclerView.Adapter)localObject1);
    localObject2 = p.a;
    this.J3 = ((SensorTriggerLogAdapter)localObject1);
  }
  
  public void i1()
  {
    com.tplink.iot.Utils.x0.i.s();
    ((SensorDetailViewModel)f1()).P();
  }
  
  public void j1()
  {
    ((SensorDetailViewModel)f1()).p().observe(this, new l(this));
    ((SensorDetailViewModel)f1()).s().observe(this, new m(this));
    ((SensorDetailViewModel)f1()).F().observe(this, new n(this));
    ((SensorDetailViewModel)f1()).r().observe(this, new o(this));
    ((SensorDetailViewModel)f1()).z().observe(this, new p(this));
  }
  
  public void onClick(View paramView)
  {
    j.e(paramView, "v");
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131363103: 
      N1();
      break;
    case 2131363002: 
      finish();
      break;
    case 2131362966: 
      B1();
      break;
    case 2131362913: 
      A1();
      com.tplink.iot.Utils.x0.i.w();
      break;
    case 2131362908: 
      ShareDeviceUserListActivity.v1(this, e1());
      com.tplink.iot.Utils.x0.i.C();
      break;
    case 2131362675: 
      X0(SensorSettingsActivity.class, e1());
    }
  }
  
  protected void onPause()
  {
    super.onPause();
    ((SensorDetailViewModel)f1()).X();
  }
  
  protected void onResume()
  {
    super.onResume();
    ((SensorDetailViewModel)f1()).W();
    if (!this.K3)
    {
      this.K3 = true;
      y1().j();
    }
  }
  
  public static final class a
  {
    public final void a(Context paramContext, String paramString)
    {
      j.e(paramContext, "context");
      j.e(paramString, "deviceIdMD5");
      Intent localIntent = new Intent(paramContext, SensorDetailActivity.class);
      localIntent.putExtra("device_id_md5", paramString);
      paramContext.startActivity(localIntent);
    }
    
    public final void b(Context paramContext, String paramString1, String paramString2)
    {
      j.e(paramContext, "context");
      j.e(paramString1, "deviceIdMD5");
      j.e(paramString2, "notificationMsgType");
      Intent localIntent = new Intent(paramContext, SensorDetailActivity.class);
      localIntent.putExtra("device_id_md5", paramString1);
      localIntent.putExtra("NotificationMsgTypeExtra", paramString2);
      paramContext.startActivity(localIntent);
    }
  }
  
  static final class b
    implements TPSwitchCompat.a
  {
    b(SensorDetailActivity paramSensorDetailActivity) {}
    
    public final void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean2)
      {
        ((SensorDetailViewModel)this.a.f1()).o(paramBoolean1);
        com.tplink.iot.Utils.x0.i.x(this.a.e1(), paramBoolean1);
        if (!paramBoolean1) {
          SensorDetailActivity.q1(this.a);
        }
      }
    }
  }
  
  static final class c
    implements d0.g
  {
    c(SensorDetailActivity paramSensorDetailActivity) {}
    
    public final void a()
    {
      SensorDetailActivity.r1(this.a);
    }
  }
  
  static final class d
    extends Lambda
    implements kotlin.jvm.b.a<ImageView>
  {
    d(SensorDetailActivity paramSensorDetailActivity)
    {
      super();
    }
    
    public final ImageView a()
    {
      return SensorDetailActivity.l1(this.c).f.p1;
    }
  }
  
  static final class e
    extends Lambda
    implements kotlin.jvm.b.a<TPSmartRefreshLayout>
  {
    e(SensorDetailActivity paramSensorDetailActivity)
    {
      super();
    }
    
    public final TPSmartRefreshLayout a()
    {
      TPSmartRefreshLayout localTPSmartRefreshLayout = SensorDetailActivity.l1(this.c).q.p3;
      j.d(localTPSmartRefreshLayout, "mBinding.sensorDetailContent.refreshLayout");
      return localTPSmartRefreshLayout;
    }
  }
  
  static final class f
    extends Lambda
    implements kotlin.jvm.b.a<ScrollLayout>
  {
    f(SensorDetailActivity paramSensorDetailActivity)
    {
      super();
    }
    
    public final ScrollLayout a()
    {
      return SensorDetailActivity.l1(this.c).d;
    }
  }
  
  static final class g
    implements Runnable
  {
    g(ScrollLayout paramScrollLayout, SensorDetailActivity paramSensorDetailActivity, boolean paramBoolean) {}
    
    public final void run()
    {
      Object localObject = SensorDetailActivity.l1(jdField_this).getRoot();
      j.d(localObject, "mBinding.root");
      int i = ((View)localObject).getMeasuredHeight();
      localObject = SensorDetailActivity.o1(jdField_this);
      j.d(localObject, "scrollDownLayout");
      int j = ((ScrollLayout)localObject).getScreenHeight();
      localObject = SensorDetailActivity.k1(jdField_this);
      j.d(localObject, "ivPullUpDown");
      int k = ((ImageView)localObject).getMeasuredHeight();
      int m;
      if (bool)
      {
        localObject = SensorDetailActivity.l1(jdField_this).f.p0;
        j.d(localObject, "mBinding.sensorDetailBottom.itemSmartScene");
        m = ((RelativeLayout)localObject).getMeasuredHeight();
      }
      else
      {
        localObject = SensorDetailActivity.l1(jdField_this).f.p2;
        j.d(localObject, "mBinding.sensorDetailBottom.rlCommonDevice");
        m = ((RelativeLayout)localObject).getMeasuredHeight();
      }
      if ((k > 0) && (m > 0))
      {
        this.c.setMaxOffset(k + m - (i - j));
        this.c.r();
      }
    }
  }
  
  public static final class h
    implements ScrollLayout.g
  {
    h(SensorDetailActivity paramSensorDetailActivity, boolean paramBoolean) {}
    
    public void a(ScrollLayout.Status paramStatus)
    {
      j.e(paramStatus, "currentStatus");
      if (paramStatus == ScrollLayout.Status.OPENED) {
        SensorDetailActivity.k1(this.a).setImageResource(2131689831);
      } else if (paramStatus == ScrollLayout.Status.CLOSED) {
        SensorDetailActivity.k1(this.a).setImageResource(2131689830);
      }
    }
    
    public void b(float paramFloat) {}
    
    public void c(int paramInt) {}
  }
  
  static final class i
    implements g
  {
    i(SensorDetailActivity paramSensorDetailActivity) {}
    
    public final void m(com.scwang.smart.refresh.layout.a.f paramf)
    {
      j.e(paramf, "it");
      ((SensorDetailViewModel)this.c.f1()).U();
    }
  }
  
  static final class j
    implements e
  {
    j(SensorDetailActivity paramSensorDetailActivity) {}
    
    public final void q(com.scwang.smart.refresh.layout.a.f paramf)
    {
      j.e(paramf, "it");
      ((SensorDetailViewModel)this.c.f1()).Q();
    }
  }
  
  static final class k
    implements TPMaterialDialogV3.d
  {
    k(SensorDetailActivity paramSensorDetailActivity) {}
    
    public final void onClick(View paramView)
    {
      ((SensorDetailViewModel)this.a.f1()).R();
    }
  }
  
  static final class l<T>
    implements Observer<BaseALIoTDevice<?>>
  {
    l(SensorDetailActivity paramSensorDetailActivity) {}
    
    public final void a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      SensorDetailActivity.t1(this.a, paramBaseALIoTDevice);
    }
  }
  
  static final class m<T>
    implements Observer<com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult>>
  {
    m(SensorDetailActivity paramSensorDetailActivity) {}
    
    public final void a(com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult> parami)
    {
      SensorDetailActivity.p1(this.a, parami);
    }
  }
  
  static final class n<T>
    implements Observer<List<? extends com.tplink.iot.adapter.iotsensor.a>>
  {
    n(SensorDetailActivity paramSensorDetailActivity) {}
    
    public final void a(List<com.tplink.iot.adapter.iotsensor.a> paramList)
    {
      if (paramList != null) {
        SensorDetailActivity.m1(this.a).y(paramList);
      }
      SensorDetailActivity.s1(this.a);
    }
  }
  
  static final class o<T>
    implements Observer<Boolean>
  {
    o(SensorDetailActivity paramSensorDetailActivity) {}
    
    public final void a(Boolean paramBoolean)
    {
      TPSmartRefreshLayout localTPSmartRefreshLayout = SensorDetailActivity.n1(this.a);
      boolean bool;
      if (paramBoolean != null) {
        bool = paramBoolean.booleanValue();
      } else {
        bool = false;
      }
      localTPSmartRefreshLayout.E(bool);
    }
  }
  
  static final class p<T>
    implements Observer<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean>>
  {
    p(SensorDetailActivity paramSensorDetailActivity) {}
    
    public final void a(com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Boolean> parama)
    {
      if ((parama != null) && ((Boolean)parama.a() != null))
      {
        SensorDetailActivity.n1(this.a).q();
        SensorDetailActivity.n1(this.a).l();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\iotsensor\SensorDetailActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */