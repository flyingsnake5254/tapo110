package com.tplink.iot.devices.lightstrip.view;

import android.app.Activity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tplink.iot.Utils.w0.a;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.LayoutLightStripSettingsFeatureExtBinding;
import com.tplink.iot.databinding.LayoutLightStripSettingsOtherExtBinding;
import com.tplink.iot.devicecommon.view.IoTSettingsBaseActivity;
import com.tplink.iot.devices.lightstrip.viewmodel.LightStripSettingsViewModel;
import com.tplink.iot.widget.ItemSettingLayout;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat;
import com.tplink.libtpcontrols.materialnormalcompat.swicth.TPSwitchCompat.a;
import com.tplink.libtpnetwork.IoTNetwork.bean.bulb.DefaultStatesBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.LocalIoTBaseDevice;
import com.tplink.libtpnetwork.IoTNetwork.bean.lightstrip.IoTLightStripDevice;
import com.tplink.libtpnetwork.IoTNetwork.common.BaseALIoTDevice;
import com.tplink.libtpnetwork.enumerate.EnumIoTComponent;
import kotlin.jvm.internal.j;

public final class LightStripSettingsActivity
  extends IoTSettingsBaseActivity<LightStripSettingsViewModel>
{
  private LayoutLightStripSettingsFeatureExtBinding p3;
  
  public LightStripSettingsActivity()
  {
    super(LightStripSettingsViewModel.class);
  }
  
  private final void H1(IoTLightStripDevice paramIoTLightStripDevice)
  {
    paramIoTLightStripDevice = paramIoTLightStripDevice.getDefaultStates();
    if (paramIoTLightStripDevice != null)
    {
      Object localObject = this.p3;
      if (localObject == null) {
        j.t("mFeatureExtBinding");
      }
      localObject = ((LayoutLightStripSettingsFeatureExtBinding)localObject).c;
      if (j.a(paramIoTLightStripDevice.getType(), "custom")) {
        paramIoTLightStripDevice = getString(2131952399);
      } else {
        paramIoTLightStripDevice = getString(2131952892);
      }
      ((ItemSettingLayout)localObject).setItemInfo(paramIoTLightStripDevice);
    }
  }
  
  public void D1()
  {
    super.D1();
    ((LightStripSettingsViewModel)n1()).A().observe(this, new b(this));
  }
  
  public void i1(FrameLayout paramFrameLayout)
  {
    j.e(paramFrameLayout, "flFeatureExt");
    paramFrameLayout = DataBindingUtil.inflate(getLayoutInflater(), 2131559175, paramFrameLayout, true);
    j.d(paramFrameLayout, "DataBindingUtil.inflate(…_ext, flFeatureExt, true)");
    paramFrameLayout = (LayoutLightStripSettingsFeatureExtBinding)paramFrameLayout;
    this.p3 = paramFrameLayout;
    if (paramFrameLayout == null) {
      j.t("mFeatureExtBinding");
    }
    z1(paramFrameLayout);
    x1(true);
  }
  
  public void j1(FrameLayout paramFrameLayout)
  {
    j.e(paramFrameLayout, "flOtherExt");
    z1((LayoutLightStripSettingsOtherExtBinding)DataBindingUtil.inflate(getLayoutInflater(), 2131559176, paramFrameLayout, true));
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    if (paramView != null) {
      localObject = Integer.valueOf(paramView.getId());
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((Integer)localObject).intValue() == 2131362901)) {
      X0(LightStripSetDefaultStateActivity.class, m1());
    } else if ((localObject != null) && (((Integer)localObject).intValue() == 2131362968)) {
      X0(LightStripSetLengthActivity.class, m1());
    } else if ((localObject == null) || (((Integer)localObject).intValue() != 2131362914)) {
      if ((localObject != null) && (((Integer)localObject).intValue() == 2131362943))
      {
        localObject = LightStripPlacementGuideActivity.y;
        paramView = k1();
        if (paramView != null)
        {
          paramView = paramView.getDeviceModel();
          if (paramView != null) {}
        }
        else
        {
          paramView = "";
        }
        ((LightStripPlacementGuideActivity.a)localObject).a(this, paramView, false);
      }
      else
      {
        super.onClick(paramView);
      }
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    if (j.a((Boolean)((LightStripSettingsViewModel)n1()).G().getValue(), Boolean.TRUE)) {
      ((LightStripSettingsViewModel)n1()).E();
    }
    if (((LightStripSettingsViewModel)n1()).H()) {
      ((LightStripSettingsViewModel)n1()).B();
    }
  }
  
  public void u1()
  {
    super.u1();
    Object localObject = this.p3;
    if (localObject == null) {
      j.t("mFeatureExtBinding");
    }
    ((LayoutLightStripSettingsFeatureExtBinding)localObject).x.setOnSwitchCheckedChangeListener(new a(this));
    localObject = this.p3;
    if (localObject == null) {
      j.t("mFeatureExtBinding");
    }
    localObject = ((LayoutLightStripSettingsFeatureExtBinding)localObject).c;
    j.d(localObject, "mFeatureExtBinding.itemDefaultState");
    boolean bool = a.g(m1(), EnumIoTComponent.DEFAULT_STATES);
    int i = 0;
    int j;
    if (bool) {
      j = 0;
    } else {
      j = 8;
    }
    ((View)localObject).setVisibility(j);
    localObject = this.p3;
    if (localObject == null) {
      j.t("mFeatureExtBinding");
    }
    localObject = ((LayoutLightStripSettingsFeatureExtBinding)localObject).q;
    j.d(localObject, "mFeatureExtBinding.itemStripLength");
    if (a.g(m1(), EnumIoTComponent.SEGMENT)) {
      j = i;
    } else {
      j = 8;
    }
    ((View)localObject).setVisibility(j);
  }
  
  static final class a
    implements TPSwitchCompat.a
  {
    a(LightStripSettingsActivity paramLightStripSettingsActivity) {}
    
    public final void c(CompoundButton paramCompoundButton, boolean paramBoolean1, boolean paramBoolean2)
    {
      if (paramBoolean2) {
        LightStripSettingsActivity.F1(this.a).K(paramBoolean1);
      }
    }
  }
  
  static final class b<T>
    implements Observer<IoTLightStripDevice>
  {
    b(LightStripSettingsActivity paramLightStripSettingsActivity) {}
    
    public final void a(IoTLightStripDevice paramIoTLightStripDevice)
    {
      if (paramIoTLightStripDevice != null) {
        LightStripSettingsActivity.G1(this.a, paramIoTLightStripDevice);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\view\LightStripSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */