package com.tplink.iot.view.quicksetup.sub;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableInt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.databinding.FragmentSubGSaveSettingBinding;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGSaveSettingViewModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.libtpcontrols.TPRippleBackground;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;

@Deprecated
public class SubGSaveSettingFragment
  extends SubGBaseFragment<FragmentSubGSaveSettingBinding, SubGSaveSettingViewModel>
{
  private Handler x = new Handler();
  
  private void G0()
  {
    ((FragmentSubGSaveSettingBinding)this.c).q.f();
  }
  
  private void I0()
  {
    this.q.v.observe(this, new a());
  }
  
  public int B0()
  {
    return 2131558968;
  }
  
  public SubGSaveSettingViewModel H0()
  {
    return (SubGSaveSettingViewModel)ViewModelProviders.of(this).get(SubGSaveSettingViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362831)
    {
      if (!isAdded()) {
        return;
      }
      this.q.E0(20001);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    this.x.removeCallbacksAndMessages(null);
    G0();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.f.q0();
    ((FragmentSubGSaveSettingBinding)this.c).q.e();
    I0();
  }
  
  class a
    implements Observer<a<Boolean>>
  {
    a() {}
    
    public void a(a<Boolean> parama)
    {
      parama = (Boolean)parama.a();
      if (parama == null) {
        return;
      }
      if (parama.booleanValue())
      {
        SubGSaveSettingFragment.this.f.e0("SubGCompleteFragment.TAG", null);
      }
      else
      {
        int i = SubGSaveSettingFragment.this.q.q.get();
        SubGSaveSettingFragment.this.q.q.set(i + 1);
        SubGSaveSettingFragment.this.q.t.setValue(new a(Boolean.TRUE));
        SubGSaveSettingFragment.this.f.e0("SubGSetupAvatarFragment.TAG", null);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\sub\SubGSaveSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */