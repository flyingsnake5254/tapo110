package com.tplink.iot.view.quicksetup.sub;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.databinding.FragmentSubgPowerUpDeviceBinding;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.view.quicksetup.sub.common.e;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGGuideFirstViewModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;

public class SubGPowerUpDeviceFragment
  extends SubGBaseFragment<FragmentSubgPowerUpDeviceBinding, SubGGuideFirstViewModel>
{
  private void H0()
  {
    ((FragmentSubgPowerUpDeviceBinding)this.c).f.setImageResource(this.q.z().e());
    Drawable localDrawable = ((FragmentSubgPowerUpDeviceBinding)this.c).f.getDrawable();
    if ((localDrawable instanceof AnimationDrawable)) {
      ((AnimationDrawable)localDrawable).start();
    }
  }
  
  private void I0()
  {
    ((FragmentSubgPowerUpDeviceBinding)this.c).y.setText(this.q.z().n());
  }
  
  public int B0()
  {
    return 2131558976;
  }
  
  public SubGGuideFirstViewModel G0()
  {
    return (SubGGuideFirstViewModel)ViewModelProviders.of(this).get(SubGGuideFirstViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362083)
    {
      if (i == 2131362826) {
        this.q.E0(20002);
      }
    }
    else {
      this.f.e0("SubGCheckStatusFragment.TAG", null);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    H0();
  }
  
  public void onStop()
  {
    super.onStop();
    Drawable localDrawable = ((FragmentSubgPowerUpDeviceBinding)this.c).f.getDrawable();
    if ((localDrawable instanceof AnimationDrawable)) {
      ((AnimationDrawable)localDrawable).stop();
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    I0();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\sub\SubGPowerUpDeviceFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */