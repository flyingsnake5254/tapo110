package com.tplink.iot.devicecommon.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tplink.cloud.bean.common.CloudResult;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.TPMaterialDialogV2.d;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.cloud.bean.thing.common.ThingFirmware;
import com.tplink.iot.databinding.ActivityBaseIotDeviceSettingsBinding;
import com.tplink.iot.devicecommon.viewmodel.IoTSettingsBaseViewModel;
import com.tplink.iot.view.iotcommon.IoTFirmwareUpdateActivity;
import com.tplink.iot.view.iotcommon.IoTSettingAvatarActivity;
import com.tplink.iot.view.iotcommon.IoTSettingLocationSelectActivity;
import com.tplink.iot.view.iotcommon.IoTSettingNameActivity;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.quicksetup.i;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import kotlin.f;
import kotlin.h;
import kotlin.jvm.b.a;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import kotlin.p;

public abstract class IoTSettingsBaseActivity<VM extends IoTSettingsBaseViewModel>
  extends BaseActivity
  implements View.OnClickListener
{
  private final f p0;
  private BaseALIoTDevice<?> p1;
  private boolean p2;
  protected ActivityBaseIotDeviceSettingsBinding y;
  private String z = "";
  
  public IoTSettingsBaseActivity(final Class<VM> paramClass)
  {
    this.p0 = h.b(new a(this, paramClass));
    this.p2 = true;
  }
  
  private final void A1()
  {
    if (n1().w()) {
      C1();
    } else {
      B1();
    }
  }
  
  private final void B1()
  {
    int i = n1().n();
    String str;
    if (i <= 0)
    {
      str = o1();
    }
    else if (i == 1)
    {
      str = getString(2131953923, new Object[] { String.valueOf(i) });
      j.d(str, "getString(R.string.share…e_user, count.toString())");
    }
    else
    {
      str = getString(2131953922, new Object[] { String.valueOf(i) });
      j.d(str, "getString(R.string.share…eletes, count.toString())");
    }
    new TPMaterialDialogV2.Builder(this).j(str).l(2131952391, 2131099804, null).o(2131952451, 2131099812, new b(this)).g(8, 8).b(false).c(false).y();
  }
  
  private final void C1()
  {
    new TPMaterialDialogV2.Builder(this).j(p1()).l(2131952391, 2131099804, null).o(2131952451, 2131099812, new c(this)).g(8, 8).b(false).c(false).y();
  }
  
  private final void E1()
  {
    s0.l(this);
    n1().z(this.z);
  }
  
  private final void e1()
  {
    s0.l(this);
    n1().f(this.z);
  }
  
  private final void r1(i<?> parami)
  {
    
    if ((parami != null) && (parami.b() == 0)) {
      Y0();
    } else {
      w1();
    }
  }
  
  private final void t1()
  {
    Object localObject = DataBindingUtil.setContentView(this, 2131558455);
    j.d(localObject, "DataBindingUtil.setConte…base_iot_device_settings)");
    localObject = (ActivityBaseIotDeviceSettingsBinding)localObject;
    this.y = ((ActivityBaseIotDeviceSettingsBinding)localObject);
    if (localObject == null) {
      j.t("mBinding");
    }
    ((ActivityBaseIotDeviceSettingsBinding)localObject).i(n1());
    ((ActivityBaseIotDeviceSettingsBinding)localObject).h(this);
    ((ViewDataBinding)localObject).setLifecycleOwner(this);
  }
  
  private final void w1()
  {
    s0.p(this, getString(2131952444));
  }
  
  @CallSuper
  public void D1()
  {
    n1().j().observe(this, new d(this));
    n1().p().observe(this, new e(this));
    n1().i().observe(this, new f(this));
    n1().v().observe(this, new g(this));
  }
  
  public void i1(FrameLayout paramFrameLayout)
  {
    j.e(paramFrameLayout, "flFeatureExt");
  }
  
  public void j1(FrameLayout paramFrameLayout)
  {
    j.e(paramFrameLayout, "flOtherExt");
  }
  
  protected final BaseALIoTDevice<?> k1()
  {
    return this.p1;
  }
  
  protected final ActivityBaseIotDeviceSettingsBinding l1()
  {
    ActivityBaseIotDeviceSettingsBinding localActivityBaseIotDeviceSettingsBinding = this.y;
    if (localActivityBaseIotDeviceSettingsBinding == null) {
      j.t("mBinding");
    }
    return localActivityBaseIotDeviceSettingsBinding;
  }
  
  protected final String m1()
  {
    return this.z;
  }
  
  protected final VM n1()
  {
    return (IoTSettingsBaseViewModel)this.p0.getValue();
  }
  
  public String o1()
  {
    String str = getString(2131953910);
    j.d(str, "getString(R.string.share…e_share_device_no_longer)");
    return str;
  }
  
  @CallSuper
  public void onClick(View paramView)
  {
    if (paramView != null) {
      paramView = Integer.valueOf(paramView.getId());
    } else {
      paramView = null;
    }
    if ((paramView != null) && (paramView.intValue() == 2131362888))
    {
      X0(IoTSettingAvatarActivity.class, this.z);
    }
    else if ((paramView != null) && (paramView.intValue() == 2131362936))
    {
      X0(IoTSettingNameActivity.class, this.z);
    }
    else if ((paramView != null) && (paramView.intValue() == 2131362930))
    {
      paramView = this.p1;
      if (paramView != null)
      {
        paramView = paramView.getDeviceId();
        if (paramView != null) {
          IoTSettingLocationSelectActivity.o1(this, paramView);
        }
      }
    }
    else if ((paramView != null) && (paramView.intValue() == 2131362906))
    {
      X0(IoTDeviceInfoCommonActivity.class, this.z);
    }
    else if ((paramView != null) && (paramView.intValue() == 2131362917))
    {
      q1();
    }
    else if ((paramView != null) && (paramView.intValue() == 2131362097))
    {
      A1();
    }
  }
  
  @CallSuper
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    s1();
    t1();
    u1();
    D1();
    v1();
  }
  
  @CallSuper
  protected void onResume()
  {
    super.onResume();
    n1().m();
    if (this.p2)
    {
      this.p2 = false;
      n1().o();
    }
  }
  
  public String p1()
  {
    String str = getString(2131953910);
    j.d(str, "getString(R.string.share…e_share_device_no_longer)");
    return str;
  }
  
  public void q1()
  {
    X0(IoTFirmwareUpdateActivity.class, this.z);
  }
  
  @CallSuper
  public void s1()
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
    this.z = ((String)localObject);
  }
  
  @CallSuper
  public void u1()
  {
    b1(2131952403);
    Object localObject = this.y;
    if (localObject == null) {
      j.t("mBinding");
    }
    localObject = ((ActivityBaseIotDeviceSettingsBinding)localObject).f;
    j.d(localObject, "mBinding.flFeatureExt");
    i1((FrameLayout)localObject);
    localObject = this.y;
    if (localObject == null) {
      j.t("mBinding");
    }
    localObject = ((ActivityBaseIotDeviceSettingsBinding)localObject).q;
    j.d(localObject, "mBinding.flOtherExt");
    j1((FrameLayout)localObject);
  }
  
  public void v1() {}
  
  protected final void x1(boolean paramBoolean)
  {
    Object localObject = this.y;
    if (localObject == null) {
      j.t("mBinding");
    }
    localObject = ((ActivityBaseIotDeviceSettingsBinding)localObject).d;
    j.d(localObject, "mBinding.featureExtDivider");
    int i;
    if (paramBoolean) {
      i = 0;
    } else {
      i = 8;
    }
    ((View)localObject).setVisibility(i);
  }
  
  protected final void y1(BaseALIoTDevice<?> paramBaseALIoTDevice)
  {
    this.p1 = paramBaseALIoTDevice;
  }
  
  protected final void z1(ViewDataBinding paramViewDataBinding)
  {
    if (paramViewDataBinding != null)
    {
      paramViewDataBinding.setVariable(89, n1());
      paramViewDataBinding.setVariable(69, this);
      paramViewDataBinding.setLifecycleOwner(this);
    }
  }
  
  static final class a
    extends Lambda
    implements a<VM>
  {
    a(IoTSettingsBaseActivity paramIoTSettingsBaseActivity, Class paramClass)
    {
      super();
    }
    
    public final VM a()
    {
      Object localObject = this.c;
      localObject = new ViewModelProvider((ViewModelStoreOwner)localObject, new IoTViewModelFactory((FragmentActivity)localObject, ((IoTSettingsBaseActivity)localObject).m1())).get(paramClass);
      j.d(localObject, "ViewModelProvider(this, …mDeviceIdMD5)).get(vmClz)");
      return (IoTSettingsBaseViewModel)localObject;
    }
  }
  
  static final class b
    implements TPMaterialDialogV2.d
  {
    b(IoTSettingsBaseActivity paramIoTSettingsBaseActivity) {}
    
    public final void onClick(View paramView)
    {
      IoTSettingsBaseActivity.h1(this.a);
    }
  }
  
  static final class c
    implements TPMaterialDialogV2.d
  {
    c(IoTSettingsBaseActivity paramIoTSettingsBaseActivity) {}
    
    public final void onClick(View paramView)
    {
      IoTSettingsBaseActivity.f1(this.a);
    }
  }
  
  static final class d<T>
    implements Observer<BaseALIoTDevice<?>>
  {
    d(IoTSettingsBaseActivity paramIoTSettingsBaseActivity) {}
    
    public final void a(BaseALIoTDevice<?> paramBaseALIoTDevice)
    {
      this.a.y1(paramBaseALIoTDevice);
    }
  }
  
  static final class e<T>
    implements Observer<ThingFirmware>
  {
    e(IoTSettingsBaseActivity paramIoTSettingsBaseActivity) {}
    
    public final void a(ThingFirmware paramThingFirmware)
    {
      ItemSettingLayout localItemSettingLayout = this.a.l1().z;
      boolean bool = true;
      if ((paramThingFirmware == null) || (paramThingFirmware.isNeedToUpgrade() != true)) {
        bool = false;
      }
      localItemSettingLayout.setNotificationVisible(bool);
    }
  }
  
  static final class f<T>
    implements Observer<i<CloudResult<Void>>>
  {
    f(IoTSettingsBaseActivity paramIoTSettingsBaseActivity) {}
    
    public final void a(i<CloudResult<Void>> parami)
    {
      IoTSettingsBaseActivity.g1(this.a, parami);
    }
  }
  
  static final class g<T>
    implements Observer<i<p>>
  {
    g(IoTSettingsBaseActivity paramIoTSettingsBaseActivity) {}
    
    public final void a(i<p> parami)
    {
      IoTSettingsBaseActivity.g1(this.a, parami);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devicecommon\view\IoTSettingsBaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */