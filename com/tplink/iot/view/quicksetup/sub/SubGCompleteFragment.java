package com.tplink.iot.view.quicksetup.sub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.databinding.FragmentSubGCompleteBinding;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.view.main.MainActivity;
import com.tplink.iot.view.quicksetup.sub.common.SubDeviceModel;
import com.tplink.iot.view.quicksetup.sub.common.e;
import com.tplink.iot.view.quicksetup.switches.SubGSwitchInstallGuideFragment;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGCompleteViewModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;

public class SubGCompleteFragment
  extends SubGBaseFragment<FragmentSubGCompleteBinding, SubGCompleteViewModel>
{
  private void H0()
  {
    if (isAdded())
    {
      FragmentActivity localFragmentActivity = getActivity();
      if (localFragmentActivity != null)
      {
        Intent localIntent = new Intent(localFragmentActivity, MainActivity.class);
        localIntent.addFlags(67108864);
        startActivity(localIntent);
        localFragmentActivity.overridePendingTransition(2130772063, 2130772064);
      }
    }
  }
  
  private void I0()
  {
    SubGSwitchInstallGuideFragment.U0(this.q.u().value()).show(getChildFragmentManager(), null);
  }
  
  private void J0()
  {
    int i;
    if ((this.q.u() != SubDeviceModel.SWITCH_S220) && (this.q.u() != SubDeviceModel.SWITCH_S210)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      ((FragmentSubGCompleteBinding)this.c).c.setVisibility(0);
    }
  }
  
  public int B0()
  {
    return 2131558963;
  }
  
  public SubGCompleteViewModel G0()
  {
    return (SubGCompleteViewModel)ViewModelProviders.of(this).get(SubGCompleteViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362074)
    {
      if (i == 2131363741) {
        H0();
      }
    }
    else {
      I0();
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ((FragmentSubGCompleteBinding)this.c).d.setImageResource(this.q.z().o());
    this.f.q0();
    J0();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\sub\SubGCompleteFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */