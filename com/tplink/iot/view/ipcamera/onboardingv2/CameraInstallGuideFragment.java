package com.tplink.iot.view.ipcamera.onboardingv2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.t0;
import com.tplink.iot.databinding.FragmentCameraV2InstallGuideBinding;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraInstallGuideViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;

public class CameraInstallGuideFragment
  extends OnBoardingFragment<FragmentCameraV2InstallGuideBinding, CameraInstallGuideViewModel>
{
  @SuppressLint({"SetTextI18n"})
  private void H0(DeviceModel paramDeviceModel)
  {
    boolean bool = c.t(paramDeviceModel);
    int i = 1;
    int j = 1;
    int k = i;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    Object localObject5;
    if (!bool) {
      if (c.u(paramDeviceModel))
      {
        k = i;
      }
      else
      {
        if (!c.v(paramDeviceModel)) {
          return;
        }
        for (k = j; k < 4; k++)
        {
          localObject1 = View.inflate(getContext(), 2131558877, null);
          localObject2 = (TextView)((View)localObject1).findViewById(2131362863);
          localObject3 = (TextView)((View)localObject1).findViewById(2131364386);
          localObject4 = (ImageView)((View)localObject1).findViewById(2131363021);
          localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append("");
          ((StringBuilder)localObject5).append(k);
          ((TextView)localObject2).setText(((StringBuilder)localObject5).toString());
          ((TextView)localObject3).setText(((CameraInstallGuideViewModel)this.d).m(k, paramDeviceModel));
          ((ImageView)localObject4).setImageResource(((CameraInstallGuideViewModel)this.d).l(k, paramDeviceModel));
          ((FragmentCameraV2InstallGuideBinding)this.c).d.addView((View)localObject1);
        }
        paramDeviceModel = View.inflate(getContext(), 2131558878, null);
        localObject5 = (TextView)paramDeviceModel.findViewById(2131362172);
        ((TextView)localObject5).getPaint().setFlags(8);
        ((TextView)localObject5).setOnClickListener(this);
        ((FragmentCameraV2InstallGuideBinding)this.c).d.addView(paramDeviceModel);
        return;
      }
    }
    while (k < 5)
    {
      localObject3 = View.inflate(getContext(), 2131558877, null);
      localObject5 = (TextView)((View)localObject3).findViewById(2131362863);
      localObject1 = (TextView)((View)localObject3).findViewById(2131364386);
      localObject2 = (ImageView)((View)localObject3).findViewById(2131363021);
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("");
      ((StringBuilder)localObject4).append(k);
      ((TextView)localObject5).setText(((StringBuilder)localObject4).toString());
      ((TextView)localObject1).setText(((CameraInstallGuideViewModel)this.d).m(k, paramDeviceModel));
      ((ImageView)localObject2).setImageResource(((CameraInstallGuideViewModel)this.d).l(k, paramDeviceModel));
      ((FragmentCameraV2InstallGuideBinding)this.c).d.addView((View)localObject3);
      k++;
    }
  }
  
  public int A0()
  {
    return 2131558876;
  }
  
  public CameraInstallGuideViewModel G0()
  {
    return (CameraInstallGuideViewModel)ViewModelProviders.of(this).get(CameraInstallGuideViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362172)
    {
      if (i != 2131363744)
      {
        if (i == 2131364787) {
          this.f.e0("CameraInstallPreviewFragment.TAG", null);
        }
      }
      else {
        this.f.e0("CameraCompleteFragment.TAG", null);
      }
    }
    else {
      t0.f(getActivity(), "saLrhG94Fmg");
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ((FragmentCameraV2InstallGuideBinding)this.c).q.setNavigationOnClickListener(new d0(this));
    H0(this.q.D());
    if (c.u(this.q.D()))
    {
      ((FragmentCameraV2InstallGuideBinding)this.c).c.setVisibility(0);
      ((FragmentCameraV2InstallGuideBinding)this.c).c.setText(2131951893);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraInstallGuideFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */