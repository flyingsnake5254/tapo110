package com.tplink.iot.view.ipcamera.onboardingv2;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.databinding.FragmentCameraV2NotFoundBinding;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraNotFoundViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;

public class CameraNotFoundFragment
  extends OnBoardingFragment<FragmentCameraV2NotFoundBinding, CameraNotFoundViewModel>
{
  private TPMaterialDialogV2 x;
  private Activity y;
  
  private void J0()
  {
    if (this.q.j.get())
    {
      ((FragmentCameraV2NotFoundBinding)this.c).d.setVisibility(8);
      ((FragmentCameraV2NotFoundBinding)this.c).f.setVisibility(0);
    }
    else
    {
      ((FragmentCameraV2NotFoundBinding)this.c).d.setVisibility(0);
      ((FragmentCameraV2NotFoundBinding)this.c).f.setVisibility(8);
    }
    DeviceModel localDeviceModel = this.q.D();
    ((FragmentCameraV2NotFoundBinding)this.c).z.setVisibility(0);
    com.tplink.iot.view.quicksetup.base.d.a0(getActivity(), ((FragmentCameraV2NotFoundBinding)this.c).z, localDeviceModel, this.q.B());
  }
  
  public int A0()
  {
    return 2131558888;
  }
  
  public CameraNotFoundViewModel I0()
  {
    return (CameraNotFoundViewModel)ViewModelProviders.of(this).get(CameraNotFoundViewModel.class);
  }
  
  void N0()
  {
    Object localObject = this.x;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      return;
    }
    View localView = LayoutInflater.from(this.y).inflate(2131559250, null, false);
    localView.findViewById(2131364572).setOnClickListener(new a());
    localView.findViewById(2131364571).setOnClickListener(new b());
    localObject = new TPMaterialDialogV2.Builder(this.y);
    ((TPMaterialDialogV2.Builder)localObject).e(localView);
    ((TPMaterialDialogV2.Builder)localObject).c(false);
    ((TPMaterialDialogV2.Builder)localObject).b(false);
    ((TPMaterialDialogV2.Builder)localObject).g(8, 8);
    localObject = ((TPMaterialDialogV2.Builder)localObject).a();
    this.x = ((TPMaterialDialogV2)localObject);
    ((TPMaterialDialogV2)localObject).show();
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.y = ((Activity)paramContext);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362055) {
      if (this.q.j.get())
      {
        if (!com.tplink.iot.view.quicksetup.base.wifi.d.e(this.y))
        {
          N0();
          return;
        }
        this.f.e0("CameraWiredConnectingFragment.TAG", null);
      }
      else
      {
        this.f.e0("CameraCheckStatusFragment.TAG", null);
      }
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.f.q0();
    ((FragmentCameraV2NotFoundBinding)this.c).y.setNavigationOnClickListener(new n0(this));
    J0();
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      if (CameraNotFoundFragment.G0(CameraNotFoundFragment.this) != null) {
        CameraNotFoundFragment.G0(CameraNotFoundFragment.this).dismiss();
      }
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b() {}
    
    public void onClick(View paramView)
    {
      com.tplink.iot.view.quicksetup.base.wifi.d.f(CameraNotFoundFragment.H0(CameraNotFoundFragment.this));
      if (CameraNotFoundFragment.G0(CameraNotFoundFragment.this) != null) {
        CameraNotFoundFragment.G0(CameraNotFoundFragment.this).dismiss();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraNotFoundFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */