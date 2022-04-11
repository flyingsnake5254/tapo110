package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.Utils.x0.f;
import com.tplink.iot.databinding.FragmentCameraV2LocationSetBinding;
import com.tplink.iot.view.ipcamera.setting.LocationSettingAdapter;
import com.tplink.iot.view.ipcamera.setting.LocationSettingAdapter.b;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraLocationSetViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.libtpnetwork.cameranetwork.bean.CameraAvatarInfo;
import com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a;

public class CameraSetLocationFragment
  extends OnBoardingFragment<FragmentCameraV2LocationSetBinding, CameraLocationSetViewModel>
  implements LocationSettingAdapter.b
{
  private LocationSettingAdapter x;
  
  private void H0()
  {
    LocationSettingAdapter localLocationSettingAdapter = new LocationSettingAdapter(getActivity(), this.q.g0());
    this.x = localLocationSettingAdapter;
    localLocationSettingAdapter.v(this);
    ((FragmentCameraV2LocationSetBinding)this.c).q.setLayoutManager(new GridLayoutManager(getActivity(), 3));
    ((FragmentCameraV2LocationSetBinding)this.c).q.setAdapter(this.x);
    this.x.x(this.q.g.get());
  }
  
  public int A0()
  {
    return 2131558885;
  }
  
  public CameraLocationSetViewModel G0()
  {
    return (CameraLocationSetViewModel)ViewModelProviders.of(this).get(CameraLocationSetViewModel.class);
  }
  
  public void a(View paramView, int paramInt)
  {
    if (!this.x.r(paramInt))
    {
      ((FragmentCameraV2LocationSetBinding)this.c).z.setEnabled(true);
      this.x.x(paramInt);
    }
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362332)
    {
      if (i == 2131363541)
      {
        i = this.x.p();
        CameraAvatarInfo localCameraAvatarInfo = new CameraAvatarInfo();
        paramView = Boolean.TRUE;
        localCameraAvatarInfo.setAvatarDefault(paramView);
        localCameraAvatarInfo.setAvatarName(this.x.n(i));
        localCameraAvatarInfo.setAvatarNameModified(paramView);
        this.q.b2(localCameraAvatarInfo);
        this.f.e0("CameraSaveSettingFragment.TAG", null);
        this.q.l2(localCameraAvatarInfo.getAvatarName());
        f.p(this.q.B(), this.q.z(), this.q.P(), (String)this.q.c.get());
      }
    }
    else
    {
      paramView = this.q;
      paramView.T1((String)paramView.c.get(), this.q.x());
      if (this.q.j.get()) {
        this.f.e0("CameraWiredCompleteFragment.TAG", null);
      } else {
        this.f.e0("CameraCompleteFragment.TAG", null);
      }
    }
  }
  
  public void onResume()
  {
    super.onResume();
    this.q.O().observe(this, new a());
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    H0();
    ((FragmentCameraV2LocationSetBinding)this.c).p0.setNavigationOnClickListener(new b1(this));
  }
  
  class a
    implements Observer<a<Boolean>>
  {
    a() {}
    
    public void a(@Nullable a<Boolean> parama)
    {
      parama = (Boolean)parama.a();
      if ((parama != null) && (parama.booleanValue()))
      {
        if (!CameraSetLocationFragment.this.isAdded()) {
          return;
        }
        s0.r(CameraSetLocationFragment.this.getActivity(), CameraSetLocationFragment.this.getString(2131953313), 5000L);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraSetLocationFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */