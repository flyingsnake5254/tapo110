package com.tplink.iot.view.quicksetup.sub;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.databinding.FragmentSubGNoFoundBinding;
import com.tplink.iot.devicecommon.widget.VariousImageViewLayout;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.view.quicksetup.sub.common.SubDeviceModel;
import com.tplink.iot.view.quicksetup.sub.common.e;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGNoFoundViewModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.iot.widget.PointTextView;

public class SubGNoFoundFragment
  extends SubGBaseFragment<FragmentSubGNoFoundBinding, SubGNoFoundViewModel>
{
  private void G0()
  {
    SubDeviceModel localSubDeviceModel = this.q.u();
    int i = a.a[localSubDeviceModel.ordinal()];
    if ((i != 1) && (i != 2))
    {
      if (i == 3)
      {
        ((FragmentSubGNoFoundBinding)this.c).p0.setContent(getString(2131954174));
        ((FragmentSubGNoFoundBinding)this.c).p1.setContent(getString(2131954173));
        ((FragmentSubGNoFoundBinding)this.c).p2.setContent(getString(2131954146));
        ((FragmentSubGNoFoundBinding)this.c).p3.setContent(getString(2131954144));
        ((FragmentSubGNoFoundBinding)this.c).H3.setContent(getString(2131954210));
        ((FragmentSubGNoFoundBinding)this.c).H3.setVisibility(0);
      }
    }
    else
    {
      ((FragmentSubGNoFoundBinding)this.c).p0.setContent(getString(2131954174));
      ((FragmentSubGNoFoundBinding)this.c).p1.setContent(getString(2131954173));
      ((FragmentSubGNoFoundBinding)this.c).p2.setContent(getString(2131954146));
      ((FragmentSubGNoFoundBinding)this.c).p3.setContent(getString(2131954144));
      ((FragmentSubGNoFoundBinding)this.c).H3.setContent(getString(2131954210));
      ((FragmentSubGNoFoundBinding)this.c).H3.setVisibility(0);
    }
  }
  
  public int B0()
  {
    return 2131558967;
  }
  
  public SubGNoFoundViewModel H0()
  {
    return (SubGNoFoundViewModel)ViewModelProviders.of(this).get(SubGNoFoundViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362146)
    {
      if (i == 2131362831) {
        this.q.E0(20001);
      }
    }
    else {
      this.f.e0("SubGSearchingDeviceFragment.TAG", null);
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.f.q0();
    d.c0(getActivity(), ((FragmentSubGNoFoundBinding)this.c).y, this.q.u().value());
    ((FragmentSubGNoFoundBinding)this.c).z.setText(this.q.z().c());
    G0();
    if (this.q.u() == SubDeviceModel.BUTTON_S200B) {
      ((FragmentSubGNoFoundBinding)this.c).q.b(getViewLifecycleOwner(), new j(this));
    } else {
      ((FragmentSubGNoFoundBinding)this.c).q.a(getViewLifecycleOwner(), this.q.z().d());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\sub\SubGNoFoundFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */