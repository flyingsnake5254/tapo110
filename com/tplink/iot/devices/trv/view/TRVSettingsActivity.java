package com.tplink.iot.devices.trv.view;

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.databinding.LayoutTrvSettingsFeatureExtBinding;
import com.tplink.iot.devicecommon.view.IoTSettingsBaseActivity;
import com.tplink.iot.devices.trv.viewmodel.TRVSettingsViewModel;
import com.tplink.iot.view.iotcommon.IoTFirmwareUpdateActivity;
import kotlin.jvm.internal.j;

public final class TRVSettingsActivity
  extends IoTSettingsBaseActivity<TRVSettingsViewModel>
{
  private LayoutTrvSettingsFeatureExtBinding p3;
  
  public TRVSettingsActivity()
  {
    super(TRVSettingsViewModel.class);
  }
  
  private final void F1()
  {
    if (((TRVSettingsViewModel)n1()).g0()) {
      ((TRVSettingsViewModel)n1()).L();
    }
    if (((TRVSettingsViewModel)n1()).f0()) {
      ((TRVSettingsViewModel)n1()).G();
    }
    if (((TRVSettingsViewModel)n1()).j0()) {
      ((TRVSettingsViewModel)n1()).c0();
    }
    if (((TRVSettingsViewModel)n1()).i0()) {
      ((TRVSettingsViewModel)n1()).V();
    }
    if (((TRVSettingsViewModel)n1()).h0()) {
      ((TRVSettingsViewModel)n1()).Q();
    }
  }
  
  private final void G1(Class<? extends AppCompatActivity> paramClass)
  {
    X0(paramClass, m1());
  }
  
  public void i1(FrameLayout paramFrameLayout)
  {
    j.e(paramFrameLayout, "flFeatureExt");
    paramFrameLayout = DataBindingUtil.inflate(getLayoutInflater(), 2131559242, paramFrameLayout, true);
    j.d(paramFrameLayout, "DataBindingUtil.inflate(…_ext, flFeatureExt, true)");
    paramFrameLayout = (LayoutTrvSettingsFeatureExtBinding)paramFrameLayout;
    this.p3 = paramFrameLayout;
    if (paramFrameLayout == null) {
      j.t("mFeatureExtBinding");
    }
    z1(paramFrameLayout);
    x1(true);
  }
  
  public void onClick(View paramView)
  {
    Integer localInteger;
    if (paramView != null) {
      localInteger = Integer.valueOf(paramView.getId());
    } else {
      localInteger = null;
    }
    if ((localInteger != null) && (localInteger.intValue() == 2131362916)) {
      G1(TRVSetFrostProtectionActivity.class);
    } else if ((localInteger != null) && (localInteger.intValue() == 2131362895)) {
      G1(TRVSetChildProtectionActivity.class);
    } else if ((localInteger != null) && (localInteger.intValue() == 2131362977)) {
      G1(TRVSetTemperatureUnitActivity.class);
    } else if ((localInteger != null) && (localInteger.intValue() == 2131362976)) {
      G1(TRVSetTemperatureRangeActivity.class);
    } else if ((localInteger != null) && (localInteger.intValue() == 2131362975)) {
      G1(TRVSetTemperatureOffsetActivity.class);
    } else if ((localInteger != null) && (localInteger.intValue() == 2131362991)) {
      G1(TRVSetWindowOpenActivity.class);
    } else if ((localInteger != null) && (localInteger.intValue() == 2131362949)) {
      G1(TRVSetRemoveScaleActivity.class);
    } else if ((localInteger != null) && (localInteger.intValue() == 2131362962)) {
      TRVSetShutdownModeActivity.p0.a(this, m1(), false);
    } else if ((localInteger != null) && (localInteger.intValue() == 2131362946)) {
      G1(TRVSetProgressCalibrationActivity.class);
    } else {
      super.onClick(paramView);
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    F1();
  }
  
  public void q1()
  {
    G1(IoTFirmwareUpdateActivity.class);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\trv\view\TRVSettingsActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */