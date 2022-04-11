package com.tplink.iot.view.ipcamera.setting.firmware;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.w.c.a;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.databinding.FragmentFirmwareUpdateNewIpcBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.viewmodel.ipcamera.setting.FirmwareUpdateViewModel;
import io.reactivex.e0.b;

public class FirmwareUpgradeFragment
  extends BaseFragment
  implements View.OnClickListener, g
{
  private FirmwareUpdateViewModel q;
  private FirmwareUpdateNewIpcActivity x;
  
  public void L0()
  {
    a.c("FirmwareUpgradeFragment", "startUpgrade");
    this.q.b.set(true);
    this.x.h1(true);
    this.q.G();
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.x = ((FirmwareUpdateNewIpcActivity)paramContext);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362062)
    {
      L0();
      this.q.D();
    }
    else if (paramView.getId() == 2131362826)
    {
      this.x.onBackPressed();
    }
    else if (paramView.getId() == 2131362887)
    {
      paramView = this.x;
      paramView.X0(AutoUpdateSettingActivity.class, paramView.e1());
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramBundle = (FirmwareUpdateViewModel)ViewModelProviders.of(this.x).get(FirmwareUpdateViewModel.class);
    this.q = paramBundle;
    paramBundle.h(this.x.e1());
    paramLayoutInflater = (FragmentFirmwareUpdateNewIpcBinding)DataBindingUtil.inflate(paramLayoutInflater, 2131558923, paramViewGroup, false);
    paramLayoutInflater.i(this.q);
    paramLayoutInflater.h(this);
    this.q.j.observe(this, new e(this));
    if (this.x.f1()) {
      L0();
    }
    return paramLayoutInflater.getRoot();
  }
  
  public void onDestroyView()
  {
    this.q.k.dispose();
    super.onDestroyView();
  }
  
  public void onStart()
  {
    super.onStart();
    FirmwareUpdateViewModel localFirmwareUpdateViewModel = this.q;
    if (localFirmwareUpdateViewModel != null) {
      localFirmwareUpdateViewModel.H();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\firmware\FirmwareUpgradeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */