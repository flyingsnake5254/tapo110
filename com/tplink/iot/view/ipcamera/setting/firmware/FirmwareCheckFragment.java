package com.tplink.iot.view.ipcamera.setting.firmware;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.base.BaseActivity;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.databinding.FragmentFirmwareCheckBinding;
import com.tplink.iot.viewmodel.ipcamera.setting.FirmwareCheckViewModel;
import io.reactivex.q;

public class FirmwareCheckFragment
  extends BaseFragment
  implements View.OnClickListener
{
  private FirmwareCheckViewModel q;
  private FirmwareUpdateNewIpcActivity x;
  private FragmentFirmwareCheckBinding y;
  private io.reactivex.e0.b z = new io.reactivex.e0.b();
  
  private void O0(int paramInt)
  {
    this.q.d.set(paramInt);
    if (paramInt == 1)
    {
      this.q.b.set(getString(2131952690));
      this.q.c.set(getString(2131952691));
      this.y.y.setImageResource(2131231218);
    }
    else if (paramInt == 0)
    {
      this.q.b.set(getString(2131952702));
      this.q.c.set(getString(2131952690));
      this.y.y.setImageResource(2131231217);
    }
    else
    {
      this.q.b.set(getString(2131953824));
      this.q.c.set(getString(2131952693));
      this.y.y.setImageResource(2131231216);
    }
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.x = ((FirmwareUpdateNewIpcActivity)paramContext);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362061)
    {
      O0(1);
      this.z.b(this.q.f().L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).H0(new b(this), new a(this)));
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
    paramBundle = (FirmwareCheckViewModel)ViewModelProviders.of(this.x).get(FirmwareCheckViewModel.class);
    this.q = paramBundle;
    paramBundle.g(this.x.e1());
    paramLayoutInflater = (FragmentFirmwareCheckBinding)DataBindingUtil.inflate(paramLayoutInflater, 2131558922, paramViewGroup, false);
    this.y = paramLayoutInflater;
    paramLayoutInflater.i(this.q);
    this.y.z.setNavigationOnClickListener(new c(this));
    this.y.h(this);
    O0(0);
    return this.y.getRoot();
  }
  
  public void onStart()
  {
    super.onStart();
    FirmwareCheckViewModel localFirmwareCheckViewModel = this.q;
    if (localFirmwareCheckViewModel != null) {
      localFirmwareCheckViewModel.k();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\firmware\FirmwareCheckFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */