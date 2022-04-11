package com.tplink.iot.view.quicksetup.sub;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGBaseViewModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;

public abstract class SubGBaseFragment<VDB extends ViewDataBinding, VM extends SubGBaseViewModel>
  extends Fragment
  implements g
{
  protected VDB c;
  protected VM d;
  protected z1 f;
  protected SubGViewModel q;
  
  protected void A0()
  {
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  @LayoutRes
  public abstract int B0();
  
  public abstract VM C0();
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    if ((getActivity() instanceof z1)) {
      this.f = ((z1)getActivity());
    }
  }
  
  @NonNull
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.c = DataBindingUtil.inflate(paramLayoutInflater, B0(), paramViewGroup, false);
    this.q = ((SubGViewModel)ViewModelProviders.of(requireActivity()).get(SubGViewModel.class));
    paramViewGroup = this.d;
    paramLayoutInflater = paramViewGroup;
    if (paramViewGroup == null) {
      paramLayoutInflater = C0();
    }
    this.d = paramLayoutInflater;
    this.c.setVariable(103, paramLayoutInflater);
    this.c.setVariable(94, this.q);
    this.c.setVariable(79, this);
    return this.c.getRoot();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\sub\SubGBaseFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */