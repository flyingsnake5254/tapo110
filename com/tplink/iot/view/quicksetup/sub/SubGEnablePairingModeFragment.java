package com.tplink.iot.view.quicksetup.sub;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.databinding.FragmentSubgEnablePairingModeBinding;
import com.tplink.iot.devicecommon.widget.VariousImageViewLayout;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.view.quicksetup.sub.common.SubDeviceModel;
import com.tplink.iot.view.quicksetup.sub.common.e;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGCheckStatusViewModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;

public class SubGEnablePairingModeFragment
  extends SubGBaseFragment<FragmentSubgEnablePairingModeBinding, SubGCheckStatusViewModel>
{
  private void H0()
  {
    if (this.q.u() == SubDeviceModel.BUTTON_S200B) {
      ((FragmentSubgEnablePairingModeBinding)this.c).f.b(getViewLifecycleOwner(), new b(this));
    } else {
      ((FragmentSubgEnablePairingModeBinding)this.c).f.a(getViewLifecycleOwner(), this.q.z().l());
    }
  }
  
  public int B0()
  {
    return 2131558974;
  }
  
  public SubGCheckStatusViewModel G0()
  {
    return (SubGCheckStatusViewModel)ViewModelProviders.of(this).get(SubGCheckStatusViewModel.class);
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
      this.f.e0("SubGSearchingDeviceFragment.TAG", null);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    H0();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    d0.h((TextView)paramView.findViewById(2131364354), getString(2131954141), ContextCompat.getColor(requireContext(), 2131099811), new c(this));
    ((FragmentSubgEnablePairingModeBinding)this.c).z.setText(this.q.z().m());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\sub\SubGEnablePairingModeFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */