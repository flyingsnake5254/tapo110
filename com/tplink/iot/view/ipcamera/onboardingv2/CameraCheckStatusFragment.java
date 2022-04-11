package com.tplink.iot.view.ipcamera.onboardingv2;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.databinding.ObservableInt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.Utils.x0.f;
import com.tplink.iot.Utils.y;
import com.tplink.iot.databinding.FragmentCameraV2CheckStatusBinding;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CheckStatusViewModel;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import com.tplink.libtpnetwork.Utils.o;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;
import com.tplink.libtpwifi.b;
import java.util.List;

public class CameraCheckStatusFragment
  extends OnBoardingFragment<FragmentCameraV2CheckStatusBinding, CheckStatusViewModel>
{
  private BroadcastReceiver x;
  
  private void I0()
  {
    ((FragmentCameraV2CheckStatusBinding)this.c).c.setImageResource(c.c(this.q.D()));
    Drawable localDrawable = ((FragmentCameraV2CheckStatusBinding)this.c).c.getDrawable();
    if ((localDrawable instanceof AnimationDrawable)) {
      ((AnimationDrawable)localDrawable).start();
    }
  }
  
  private void J0()
  {
    this.x = new a();
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.net.wifi.SCAN_RESULTS");
    if (getActivity() != null) {
      getActivity().registerReceiver(this.x, localIntentFilter);
    }
  }
  
  private void K0()
  {
    if ((!DeviceModel.CAMERA_C310.equals(this.q.D())) && (!DeviceModel.CAMERA_TC65.equals(this.q.D()))) {
      ((FragmentCameraV2CheckStatusBinding)this.c).p0.setText(2131953569);
    } else {
      ((FragmentCameraV2CheckStatusBinding)this.c).p0.setText(2131951951);
    }
  }
  
  private void Q0()
  {
    if (!((FragmentCameraV2CheckStatusBinding)this.c).q.b()) {
      return;
    }
    ((FragmentCameraV2CheckStatusBinding)this.c).q.h();
    this.q.h.clear();
    this.q.h.addAll(((CheckStatusViewModel)this.d).f(b.k().m().getScanResults()));
    if (((CheckStatusViewModel)this.d).a.get() <= 0)
    {
      this.f.e0("CameraInstructionFragment.TAG", null);
    }
    else if (((CheckStatusViewModel)this.d).a.get() == 1)
    {
      CameraOnBoardingViewModel localCameraOnBoardingViewModel = this.q;
      localCameraOnBoardingViewModel.m2(((ScanResult)localCameraOnBoardingViewModel.h.get(0)).SSID);
      y.a(this.q.Q(), null, null);
      this.f.e0("CameraConnectingFragment.TAG", null);
    }
    else
    {
      this.f.e0("CameraSSIDListFragment.TAG", null);
    }
  }
  
  public int A0()
  {
    return 2131558868;
  }
  
  public CheckStatusViewModel H0()
  {
    return (CheckStatusViewModel)ViewModelProviders.of(this).get(CheckStatusViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363742)
    {
      boolean bool = o.h0().c("has_refused_location_permission", false);
      if (com.tplink.iot.view.quicksetup.base.wifi.d.a(getActivity()))
      {
        this.q.i2(true);
        f.j();
        b.k().s();
      }
      else
      {
        f.i();
        if (bool)
        {
          this.q.i2(false);
          this.f.e0("CameraInstructionFragment.TAG", null);
          return;
        }
        ((FragmentCameraV2CheckStatusBinding)this.c).q.h();
        this.f.e0("CameraLocationPermissionFragment.TAG", null);
      }
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    J0();
    return paramLayoutInflater;
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    if ((getActivity() != null) && (this.x != null)) {
      getActivity().unregisterReceiver(this.x);
    }
  }
  
  public void onResume()
  {
    super.onResume();
    I0();
  }
  
  public void onStop()
  {
    super.onStop();
    Drawable localDrawable = ((FragmentCameraV2CheckStatusBinding)this.c).c.getDrawable();
    if ((localDrawable instanceof AnimationDrawable)) {
      ((AnimationDrawable)localDrawable).stop();
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    d0.h(((FragmentCameraV2CheckStatusBinding)this.c).z, getString(2131953306), ContextCompat.getColor(requireActivity(), 2131099811), new e(this));
    ((FragmentCameraV2CheckStatusBinding)this.c).y.setNavigationOnClickListener(new d(this));
    this.q.S1();
    K0();
  }
  
  class a
    extends BroadcastReceiver
  {
    a() {}
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      try
      {
        if ("android.net.wifi.SCAN_RESULTS".equals(paramIntent.getAction())) {
          CameraCheckStatusFragment.G0(CameraCheckStatusFragment.this);
        }
      }
      catch (Exception paramContext)
      {
        paramIntent = new StringBuilder();
        paramIntent.append("Exception: ");
        paramIntent.append(paramContext.toString());
        b.d.w.c.a.e("OnBoardingActivity", paramIntent.toString());
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraCheckStatusFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */