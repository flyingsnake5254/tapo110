package com.tplink.iot.view.ipcamera.onboardingv2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Recycler;
import androidx.recyclerview.widget.RecyclerView.State;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.d0.g;
import com.tplink.iot.Utils.x0.f;
import com.tplink.iot.databinding.FragmentCameraV2WifiListBinding;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraWifiListViewModel;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.iot.widget.UniversalDialog.a;
import com.tplink.libtpnetwork.cameranetwork.model.Wifi;

public class CameraWifiListFragment
  extends OnBoardingFragment<FragmentCameraV2WifiListBinding, CameraWifiListViewModel>
{
  private CameraWifiListAdapter x;
  
  private void G0()
  {
    if (this.q.j.get()) {
      this.f.e0("CameraWiredConnectApFragment.TAG", null);
    } else {
      this.f.e0("CameraConnectApFragment.TAG", null);
    }
  }
  
  private void I0()
  {
    this.x = new CameraWifiListAdapter(new h1(this));
    ((FragmentCameraV2WifiListBinding)this.c).q.setLayoutManager(new b(getActivity()));
    ((FragmentCameraV2WifiListBinding)this.c).q.setAdapter(this.x);
  }
  
  private void J0()
  {
    TextView localTextView = ((FragmentCameraV2WifiListBinding)this.c).p1;
    int i;
    if (this.q.j.get()) {
      i = 2131952018;
    } else {
      i = 2131953574;
    }
    localTextView.setText(i);
  }
  
  private void R0(Wifi paramWifi)
  {
    if (!isAdded()) {
      return;
    }
    new UniversalDialog.a().q(getString(2131953503)).u(getString(2131952397)).s(getString(2131951757)).t(new g1(this, paramWifi)).l().show(getChildFragmentManager(), "");
  }
  
  public int A0()
  {
    return 2131558902;
  }
  
  public CameraWifiListViewModel H0()
  {
    return (CameraWifiListViewModel)ViewModelProviders.of(this).get(CameraWifiListViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362037) {
      if (i != 2131362084)
      {
        if (i != 2131364605) {
          return;
        }
      }
      else
      {
        this.f.e0("CameraManualInputPwdFragment.TAG", null);
        return;
      }
    }
    if (this.q.j.get())
    {
      paramView = new Bundle();
      paramView.putString("rescan_op", "rescan");
      this.f.e0("CameraWiredCompleteFragment.TAG", paramView);
    }
    else
    {
      this.f.e0("CameraRescanWifiFragment.TAG", null);
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    I0();
    return paramLayoutInflater;
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.f.q0();
    ((FragmentCameraV2WifiListBinding)this.c).x.setNavigationOnClickListener(new f1(this));
    d0.h(((FragmentCameraV2WifiListBinding)this.c).z, getString(2131953493), ContextCompat.getColor(requireContext(), 2131099811), new a());
    J0();
  }
  
  class a
    implements d0.g
  {
    a() {}
    
    public void a()
    {
      f.A(CameraWifiListFragment.this.q.B());
      CameraWifiListFragment.this.f.e0("CameraCannotFindFragment.TAG", null);
    }
  }
  
  class b
    extends LinearLayoutManager
  {
    b(Context paramContext)
    {
      super();
    }
    
    public void onLayoutChildren(RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
    {
      try
      {
        super.onLayoutChildren(paramRecycler, paramState);
      }
      catch (IndexOutOfBoundsException paramRecycler)
      {
        paramRecycler.printStackTrace();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraWifiListFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */