package com.tplink.iot.devicecommon.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.annotation.CallSuper;
import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.context.b;
import com.tplink.iot.Utils.k;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityBaseIotDeviceDetailBinding;
import com.tplink.iot.databinding.ActivityBaseIotDeviceDetailBottomBinding;
import com.tplink.iot.devicecommon.viewmodel.IoTDetailBaseViewModel;
import com.tplink.iot.view.cloudconnect.CloudConnectGetStateActivity;
import com.tplink.iot.view.deviceshare.ShareDeviceUserListActivity;
import com.tplink.iot.view.feedback.EnumFeedbackCategory;
import com.tplink.iot.view.feedback.HelpAndFeedbackActivity;
import com.tplink.iot.viewmodel.home.u;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.result.CloudConnectStateResult;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.yinglan.scrolllayout.ScrollLayout;
import com.yinglan.scrolllayout.ScrollLayout.Status;
import com.yinglan.scrolllayout.ScrollLayout.g;
import java.util.Objects;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

public abstract class IoTDetailBaseActivity<ContentExtVDB extends ViewDataBinding, BottomExtVDB extends ViewDataBinding, VM extends IoTDetailBaseViewModel>
  extends BaseActivity
  implements View.OnClickListener
{
  private BaseALIoTDevice<?> H3;
  private final f I3;
  private final f J3;
  protected ActivityBaseIotDeviceDetailBinding p0;
  private final f p1 = h.b(new b(this));
  private String p2 = "";
  private final f p3;
  protected ContentExtVDB y;
  protected BottomExtVDB z;
  
  public IoTDetailBaseActivity(final Class<VM> paramClass)
  {
    this.p3 = h.b(new c(this, paramClass));
    this.I3 = h.b(new a(this));
    this.J3 = h.b(new d(this));
  }
  
  private final void E1()
  {
    ActivityBaseIotDeviceDetailBinding localActivityBaseIotDeviceDetailBinding = this.p0;
    if (localActivityBaseIotDeviceDetailBinding == null) {
      j.t("mBinding");
    }
    localActivityBaseIotDeviceDetailBinding.q.f.setOnSwitchCheckedChangeListener(new e(this));
  }
  
  private final void F1()
  {
    final int i = k.a(this, 50.0F) + com.tplink.iot.view.quicksetup.base.d.A(this);
    Object localObject = r1().p3;
    j.d(localObject, "mBottomBinding.viewWhiteStub");
    ViewGroup.LayoutParams localLayoutParams = ((View)localObject).getLayoutParams();
    Objects.requireNonNull(localLayoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    localLayoutParams.height = i;
    ((View)localObject).setLayoutParams(localLayoutParams);
    localObject = w1();
    ((ScrollLayout)localObject).setMinOffset(i);
    o1().post(new f((ScrollLayout)localObject, this, i));
    ((ScrollLayout)localObject).setOnScrollChangedListener(new g(this, i));
  }
  
  private final void G1()
  {
    Object localObject = b.d.s.a.a.f();
    if (localObject != null)
    {
      localObject = ((b)localObject).c();
      if (localObject != null)
      {
        localObject = ((TCAccountBean)localObject).getCloudUserName();
        if (localObject != null) {
          break label32;
        }
      }
    }
    localObject = "";
    label32:
    u.p(this, (String)localObject);
  }
  
  private final void H1()
  {
    if (v1().D())
    {
      localObject = this.p0;
      if (localObject == null) {
        j.t("mBinding");
      }
      localObject = ((ActivityBaseIotDeviceDetailBinding)localObject).d;
      j.d(localObject, "mBinding.cardUserDevice");
      ((FrameLayout)localObject).setVisibility(0);
    }
    else
    {
      localObject = this.p0;
      if (localObject == null) {
        j.t("mBinding");
      }
      localObject = ((ActivityBaseIotDeviceDetailBinding)localObject).d;
      j.d(localObject, "mBinding.cardUserDevice");
      ((FrameLayout)localObject).setVisibility(8);
      I1();
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("IoTDetail showLocalOnlyOrUserDeviceTips isUserRoleTypeDevice: ");
    ((StringBuilder)localObject).append(v1().D());
    b.d.w.c.a.a(((StringBuilder)localObject).toString());
  }
  
  private final void I1()
  {
    if ((v1().B()) && (v1().y()))
    {
      v1().h();
    }
    else
    {
      localObject = this.p0;
      if (localObject == null) {
        j.t("mBinding");
      }
      localObject = ((ActivityBaseIotDeviceDetailBinding)localObject).c;
      j.d(localObject, "mBinding.cardLocalOnly");
      ((FrameLayout)localObject).setVisibility(8);
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("IoTDetail showLocalView isNoCloud: ");
    ((StringBuilder)localObject).append(v1().y());
    b.d.w.c.a.a(((StringBuilder)localObject).toString());
  }
  
  private final void K1()
  {
    ScrollLayout localScrollLayout = w1();
    if (localScrollLayout.getCurrentStatus() == ScrollLayout.Status.OPENED) {
      localScrollLayout.m();
    } else if (localScrollLayout.getCurrentStatus() == ScrollLayout.Status.CLOSED) {
      localScrollLayout.o();
    }
  }
  
  private final ImageView o1()
  {
    return (ImageView)this.I3.getValue();
  }
  
  private final ScrollLayout w1()
  {
    return (ScrollLayout)this.J3.getValue();
  }
  
  private final void x1()
  {
    BaseALIoTDevice localBaseALIoTDevice = this.H3;
    if (localBaseALIoTDevice != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("https://www.tapo.com/app/#/faqList2?categoryType=");
      localStringBuilder.append(l1());
      localStringBuilder.append(com.tplink.iot.model.about.d.a());
      HelpAndFeedbackActivity.k1(this, localStringBuilder.toString(), m1(), localBaseALIoTDevice.getDeviceType(), localBaseALIoTDevice.getDeviceModel(), n1(localBaseALIoTDevice));
    }
  }
  
  private final void z1()
  {
    Object localObject = DataBindingUtil.setContentView(this, 2131558452);
    j.d(localObject, "DataBindingUtil.setConte…y_base_iot_device_detail)");
    localObject = (ActivityBaseIotDeviceDetailBinding)localObject;
    this.p0 = ((ActivityBaseIotDeviceDetailBinding)localObject);
    if (localObject == null) {
      j.t("mBinding");
    }
    ((ActivityBaseIotDeviceDetailBinding)localObject).h(v1());
    ((ActivityBaseIotDeviceDetailBinding)localObject).i(this);
    ((ViewDataBinding)localObject).setLifecycleOwner(this);
    localObject = getLayoutInflater();
    int i = j1();
    ActivityBaseIotDeviceDetailBinding localActivityBaseIotDeviceDetailBinding = this.p0;
    if (localActivityBaseIotDeviceDetailBinding == null) {
      j.t("mBinding");
    }
    localObject = DataBindingUtil.inflate((LayoutInflater)localObject, i, localActivityBaseIotDeviceDetailBinding.x, true);
    j.d(localObject, "DataBindingUtil.inflate(…nding.flContentExt, true)");
    this.y = ((ViewDataBinding)localObject);
    if (localObject == null) {
      j.t("mContentExtBinding");
    }
    ((ViewDataBinding)localObject).setVariable(15, v1());
    ((ViewDataBinding)localObject).setVariable(69, this);
    ((ViewDataBinding)localObject).setLifecycleOwner(this);
    localObject = DataBindingUtil.inflate(getLayoutInflater(), h1(), r1().q, true);
    j.d(localObject, "DataBindingUtil.inflate(…inding.flBottomExt, true)");
    this.z = ((ViewDataBinding)localObject);
    if (localObject == null) {
      j.t("mBottomExtBinding");
    }
    ((ViewDataBinding)localObject).setVariable(15, v1());
    ((ViewDataBinding)localObject).setVariable(69, this);
    ((ViewDataBinding)localObject).setLifecycleOwner(this);
  }
  
  @CallSuper
  public void A1()
  {
    ActivityBaseIotDeviceDetailBinding localActivityBaseIotDeviceDetailBinding = this.p0;
    if (localActivityBaseIotDeviceDetailBinding == null) {
      j.t("mBinding");
    }
    com.tplink.iot.view.quicksetup.base.d.J(this, localActivityBaseIotDeviceDetailBinding.J3);
    F1();
    E1();
    H1();
  }
  
  public void B1() {}
  
  protected void C1(com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult> parami)
  {
    int i = 8;
    if (parami != null)
    {
      parami = (CloudConnectStateResult)parami.a();
      if ((parami != null) && (parami.getStatus() == 0))
      {
        parami = this.p0;
        if (parami == null) {
          j.t("mBinding");
        }
        parami = parami.c;
        j.d(parami, "mBinding.cardLocalOnly");
        parami.setVisibility(8);
        return;
      }
    }
    parami = this.p0;
    if (parami == null) {
      j.t("mBinding");
    }
    parami = parami.c;
    j.d(parami, "mBinding.cardLocalOnly");
    if (v1().y()) {
      i = 0;
    }
    parami.setVisibility(i);
  }
  
  protected final void D1(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    this.H3 = paramBaseALIoTDevice;
  }
  
  @CallSuper
  public void J1()
  {
    v1().i().observe(this, new h(this));
    v1().k().observe(this, new i(this));
  }
  
  @LayoutRes
  public abstract int h1();
  
  public abstract int i1();
  
  @LayoutRes
  public abstract int j1();
  
  public abstract Class<? extends AppCompatActivity> k1();
  
  public abstract String l1();
  
  public abstract String m1();
  
  public abstract EnumFeedbackCategory n1(BaseALIoTDevice<?> paramBaseALIoTDevice);
  
  @CallSuper
  public void onClick(View paramView)
  {
    if (paramView != null) {
      paramView = Integer.valueOf(paramView.getId());
    } else {
      paramView = null;
    }
    if ((paramView != null) && (paramView.intValue() == 2131363103))
    {
      K1();
    }
    else if ((paramView != null) && (paramView.intValue() == 2131363002))
    {
      onBackPressed();
    }
    else if ((paramView != null) && (paramView.intValue() == 2131362675))
    {
      X0(k1(), this.p2);
    }
    else if ((paramView != null) && (paramView.intValue() == 2131362192))
    {
      if (v1().B()) {
        CloudConnectGetStateActivity.j1(this, this.p2);
      }
    }
    else if ((paramView != null) && (paramView.intValue() == 2131362908))
    {
      ShareDeviceUserListActivity.v1(this, this.p2);
      com.tplink.iot.Utils.x0.i.C();
    }
    else if ((paramView != null) && (paramView.intValue() == 2131362913))
    {
      x1();
      com.tplink.iot.Utils.x0.i.w();
    }
  }
  
  @CallSuper
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y1();
    z1();
    A1();
    J1();
    B1();
  }
  
  @CallSuper
  protected void onPause()
  {
    v1().H();
    super.onPause();
  }
  
  @CallSuper
  protected void onResume()
  {
    super.onResume();
    v1().G();
  }
  
  protected final BaseALIoTDevice<?> p1()
  {
    return this.H3;
  }
  
  protected final ActivityBaseIotDeviceDetailBinding q1()
  {
    ActivityBaseIotDeviceDetailBinding localActivityBaseIotDeviceDetailBinding = this.p0;
    if (localActivityBaseIotDeviceDetailBinding == null) {
      j.t("mBinding");
    }
    return localActivityBaseIotDeviceDetailBinding;
  }
  
  protected final ActivityBaseIotDeviceDetailBottomBinding r1()
  {
    return (ActivityBaseIotDeviceDetailBottomBinding)this.p1.getValue();
  }
  
  protected final BottomExtVDB s1()
  {
    ViewDataBinding localViewDataBinding = this.z;
    if (localViewDataBinding == null) {
      j.t("mBottomExtBinding");
    }
    return localViewDataBinding;
  }
  
  protected final ContentExtVDB t1()
  {
    ViewDataBinding localViewDataBinding = this.y;
    if (localViewDataBinding == null) {
      j.t("mContentExtBinding");
    }
    return localViewDataBinding;
  }
  
  protected final String u1()
  {
    return this.p2;
  }
  
  protected final VM v1()
  {
    return (IoTDetailBaseViewModel)this.p3.getValue();
  }
  
  @CallSuper
  public void y1()
  {
    Object localObject = getIntent();
    if (localObject != null)
    {
      localObject = ((Intent)localObject).getStringExtra("device_id_md5");
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    this.p2 = ((String)localObject);
  }
  
  static final class a
    extends Lambda
    implements kotlin.jvm.b.a<ImageView>
  {
    a(IoTDetailBaseActivity paramIoTDetailBaseActivity)
    {
      super();
    }
    
    public final ImageView a()
    {
      return this.c.q1().q.z;
    }
  }
  
  static final class b
    extends Lambda
    implements kotlin.jvm.b.a<ActivityBaseIotDeviceDetailBottomBinding>
  {
    b(IoTDetailBaseActivity paramIoTDetailBaseActivity)
    {
      super();
    }
    
    public final ActivityBaseIotDeviceDetailBottomBinding a()
    {
      ActivityBaseIotDeviceDetailBottomBinding localActivityBaseIotDeviceDetailBottomBinding = this.c.q1().q;
      j.d(localActivityBaseIotDeviceDetailBottomBinding, "mBinding.detailBottom");
      return localActivityBaseIotDeviceDetailBottomBinding;
    }
  }
  
  static final class c
    extends Lambda
    implements kotlin.jvm.b.a<VM>
  {
    c(IoTDetailBaseActivity paramIoTDetailBaseActivity, Class paramClass)
    {
      super();
    }
    
    public final VM a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((FragmentActivity)localObject, ((IoTDetailBaseActivity)localObject).u1())).get(paramClass);
      j.d(localObject, "ViewModelProvider(this, …mDeviceIdMD5)).get(vmClz)");
      return (IoTDetailBaseViewModel)localObject;
    }
  }
  
  static final class d
    extends Lambda
    implements kotlin.jvm.b.a<ScrollLayout>
  {
    d(IoTDetailBaseActivity paramIoTDetailBaseActivity)
    {
      super();
    }
    
    public final ScrollLayout a()
    {
      return this.c.q1().K3;
    }
  }
  
  static final class e
    implements TPSwitchCompat.a
  {
    e(IoTDetailBaseActivity paramIoTDetailBaseActivity) {}
    
    public final void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean2)
      {
        this.a.v1().g(paramBoolean1);
        com.tplink.iot.Utils.x0.i.x(this.a.u1(), paramBoolean1);
        if (!paramBoolean1) {
          IoTDetailBaseActivity.g1(this.a);
        }
      }
    }
  }
  
  static final class f
    implements Runnable
  {
    f(ScrollLayout paramScrollLayout, IoTDetailBaseActivity paramIoTDetailBaseActivity, int paramInt) {}
    
    public final void run()
    {
      Object localObject = jdField_this.q1().getRoot();
      j.d(localObject, "mBinding.root");
      int i = ((View)localObject).getMeasuredHeight();
      localObject = IoTDetailBaseActivity.f1(jdField_this);
      j.d(localObject, "scrollDownLayout");
      int j = ((ScrollLayout)localObject).getScreenHeight();
      localObject = IoTDetailBaseActivity.e1(jdField_this);
      j.d(localObject, "ivPullUpDown");
      int k = ((ImageView)localObject).getMeasuredHeight();
      int m = jdField_this.i1();
      if ((k > 0) && (m > 0))
      {
        this.c.setMaxOffset(k + m - (i - j));
        this.c.r();
      }
      j = k + m;
      localObject = jdField_this.q1().f;
      j.d(localObject, "mBinding.contentScrollView");
      localObject = ((ScrollView)localObject).getLayoutParams();
      Objects.requireNonNull(localObject, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      if (((ViewGroup.MarginLayoutParams)localObject).bottomMargin < j)
      {
        localObject = jdField_this.q1().f;
        j.d(localObject, "mBinding.contentScrollView");
        localObject = ((ScrollView)localObject).getLayoutParams();
        Objects.requireNonNull(localObject, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = j;
        jdField_this.q1().f.requestLayout();
      }
    }
  }
  
  public static final class g
    implements ScrollLayout.g
  {
    g(IoTDetailBaseActivity paramIoTDetailBaseActivity, int paramInt) {}
    
    public void a(ScrollLayout.Status paramStatus)
    {
      j.e(paramStatus, "currentStatus");
      if (paramStatus == ScrollLayout.Status.OPENED) {
        IoTDetailBaseActivity.e1(this.a).setImageResource(2131689831);
      } else if (paramStatus == ScrollLayout.Status.CLOSED) {
        IoTDetailBaseActivity.e1(this.a).setImageResource(2131689830);
      }
    }
    
    public void b(float paramFloat) {}
    
    public void c(int paramInt) {}
  }
  
  static final class h<T>
    implements Observer<BaseALIoTDevice<?>>
  {
    h(IoTDetailBaseActivity paramIoTDetailBaseActivity) {}
    
    public final void a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      this.a.D1(paramBaseALIoTDevice);
    }
  }
  
  static final class i<T>
    implements Observer<com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult>>
  {
    i(IoTDetailBaseActivity paramIoTDetailBaseActivity) {}
    
    public final void a(com.tplink.iot.viewmodel.quicksetup.i<CloudConnectStateResult> parami)
    {
      this.a.C1(parami);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devicecommon\view\IoTDetailBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */