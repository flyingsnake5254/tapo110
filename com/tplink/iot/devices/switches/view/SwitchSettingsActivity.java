package com.tplink.iot.devices.switches.view;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.ActivityBaseIotDeviceSettingsBinding;
import com.tplink.iot.databinding.LayoutSwitchSettingsFeatureExtBinding;
import com.tplink.iot.devicecommon.view.IoTSettingsBaseActivity;
import com.tplink.iot.devices.switches.viewmodel.SwitchSettingsViewModel;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.libtpnetwork.IoTNetwork.bean.sub.params.DelayActionInfoBean;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import kotlin.jvm.internal.j;
import kotlin.text.m;

public final class SwitchSettingsActivity
  extends IoTSettingsBaseActivity<SwitchSettingsViewModel>
{
  private LayoutSwitchSettingsFeatureExtBinding p3;
  
  public SwitchSettingsActivity()
  {
    super(SwitchSettingsViewModel.class);
  }
  
  private final void G1(DelayActionInfoBean paramDelayActionInfoBean)
  {
    if (paramDelayActionInfoBean.getEnabled())
    {
      LayoutSwitchSettingsFeatureExtBinding localLayoutSwitchSettingsFeatureExtBinding = this.p3;
      if (localLayoutSwitchSettingsFeatureExtBinding == null) {
        j.t("mFeatureExtBinding");
      }
      localLayoutSwitchSettingsFeatureExtBinding.c.setItemInfo(getString(2131954293, new Object[] { Integer.valueOf(paramDelayActionInfoBean.getTime()) }));
    }
    else
    {
      paramDelayActionInfoBean = this.p3;
      if (paramDelayActionInfoBean == null) {
        j.t("mFeatureExtBinding");
      }
      paramDelayActionInfoBean.c.setItemInfo(getString(2131952885));
    }
  }
  
  public void D1()
  {
    super.D1();
    ((SwitchSettingsViewModel)n1()).B().observe(this, new a(this));
  }
  
  public void i1(FrameLayout paramFrameLayout)
  {
    j.e(paramFrameLayout, "flFeatureExt");
    paramFrameLayout = DataBindingUtil.inflate(getLayoutInflater(), 2131559237, paramFrameLayout, true);
    j.d(paramFrameLayout, "DataBindingUtil.inflate(…_ext, flFeatureExt, true)");
    paramFrameLayout = (LayoutSwitchSettingsFeatureExtBinding)paramFrameLayout;
    this.p3 = paramFrameLayout;
    if (paramFrameLayout == null) {
      j.t("mFeatureExtBinding");
    }
    z1(paramFrameLayout);
    x1(true);
  }
  
  public String o1()
  {
    Object localObject = k1();
    if (localObject != null)
    {
      localObject = ((BaseALIoTDevice)localObject).getDeviceModel();
      if ((localObject != null) && (m.A((String)localObject, "S220", false, 2, null) == true))
      {
        localObject = getString(2131954202);
        j.d(localObject, "getString(R.string.switc…ove_button_no_longer_tip)");
        return (String)localObject;
      }
    }
    return super.o1();
  }
  
  public void onClick(View paramView)
  {
    Integer localInteger;
    if (paramView != null) {
      localInteger = Integer.valueOf(paramView.getId());
    } else {
      localInteger = null;
    }
    if ((localInteger != null) && (localInteger.intValue() == 2131362902)) {
      X0(SwitchSetDelayOffActivity.class, m1());
    } else if ((localInteger != null) && (localInteger.intValue() == 2131362909)) {
      X0(SwitchSetDoubleClickActivity.class, m1());
    } else {
      super.onClick(paramView);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (((SwitchSettingsViewModel)n1()).F()) {
      ((SwitchSettingsViewModel)n1()).A();
    }
    if (((SwitchSettingsViewModel)n1()).G()) {
      ((SwitchSettingsViewModel)n1()).C();
    }
  }
  
  public void u1()
  {
    super.u1();
    Object localObject1 = this.p3;
    if (localObject1 == null) {
      j.t("mFeatureExtBinding");
    }
    localObject1 = ((LayoutSwitchSettingsFeatureExtBinding)localObject1).c;
    j.d(localObject1, "mFeatureExtBinding.itemDelayOff");
    boolean bool = ((SwitchSettingsViewModel)n1()).F();
    int i = 8;
    if (bool) {
      j = 0;
    } else {
      j = 8;
    }
    ((View)localObject1).setVisibility(j);
    localObject1 = this.p3;
    if (localObject1 == null) {
      j.t("mFeatureExtBinding");
    }
    localObject1 = ((LayoutSwitchSettingsFeatureExtBinding)localObject1).d;
    j.d(localObject1, "mFeatureExtBinding.itemDoubleClick");
    if (((SwitchSettingsViewModel)n1()).G()) {
      j = 0;
    } else {
      j = 8;
    }
    ((View)localObject1).setVisibility(j);
    localObject1 = l1().d;
    j.d(localObject1, "mBinding.featureExtDivider");
    Object localObject2 = this.p3;
    if (localObject2 == null) {
      j.t("mFeatureExtBinding");
    }
    localObject2 = ((LayoutSwitchSettingsFeatureExtBinding)localObject2).c;
    j.d(localObject2, "mFeatureExtBinding.itemDelayOff");
    int j = ((View)localObject2).getVisibility();
    int k = 1;
    if (j == 0) {
      m = 1;
    } else {
      m = 0;
    }
    j = k;
    if (m == 0)
    {
      localObject2 = this.p3;
      if (localObject2 == null) {
        j.t("mFeatureExtBinding");
      }
      localObject2 = ((LayoutSwitchSettingsFeatureExtBinding)localObject2).d;
      j.d(localObject2, "mFeatureExtBinding.itemDoubleClick");
      if (((View)localObject2).getVisibility() == 0) {
        j = 1;
      } else {
        j = 0;
      }
      if (j != 0) {
        j = k;
      } else {
        j = 0;
      }
    }
    int m = i;
    if (j != 0) {
      m = 0;
    }
    ((View)localObject1).setVisibility(m);
  }
  
  static final class a<T>
    implements Observer<DelayActionInfoBean>
  {
    a(SwitchSettingsActivity paramSwitchSettingsActivity) {}
    
    public final void a(DelayActionInfoBean paramDelayActionInfoBean)
    {
      if (paramDelayActionInfoBean != null) {
        SwitchSettingsActivity.F1(this.a, paramDelayActionInfoBean);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\switches\view\SwitchSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */