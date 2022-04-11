package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.databinding.FragmentCameraV2SsidListBinding;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraSSIDListViewModel;

public class CameraSSIDListFragment
  extends OnBoardingFragment<FragmentCameraV2SsidListBinding, CameraSSIDListViewModel>
{
  private CameraSSIDAdapter x;
  
  private void H0()
  {
    this.x = new CameraSSIDAdapter(new x0(this));
    ((FragmentCameraV2SsidListBinding)this.c).f.setLayoutManager(new LinearLayoutManager(getActivity()));
    ((FragmentCameraV2SsidListBinding)this.c).f.setAdapter(this.x);
  }
  
  public int A0()
  {
    return 2131558900;
  }
  
  public CameraSSIDListViewModel G0()
  {
    return (CameraSSIDListViewModel)ViewModelProviders.of(this).get(CameraSSIDListViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362803) {
      this.f.e0("CameraIdentifyFragment.TAG", null);
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    H0();
    ((FragmentCameraV2SsidListBinding)this.c).q.setNavigationOnClickListener(new w0(this));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraSSIDListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */