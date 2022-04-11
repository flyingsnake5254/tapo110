package com.tplink.iot.view.ipcamera.onboardingv2;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialog;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.databinding.FragmentCameraConnectRouterBinding;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.view.quicksetup.base.wifi.d;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraConnectRouterViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public class CameraConnectRouterFragment
  extends OnBoardingFragment<FragmentCameraConnectRouterBinding, CameraConnectRouterViewModel>
{
  private TPMaterialDialogV2 x;
  private Activity y;
  
  private void O0()
  {
    ((FragmentCameraConnectRouterBinding)this.c).c.setImageResource(c.d(this.q.D()));
  }
  
  public int A0()
  {
    return 2131558862;
  }
  
  public CameraConnectRouterViewModel I0()
  {
    return (CameraConnectRouterViewModel)ViewModelProviders.of(this).get(CameraConnectRouterViewModel.class);
  }
  
  void P0()
  {
    Object localObject = this.x;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      return;
    }
    localObject = LayoutInflater.from(this.y).inflate(2131559250, null, false);
    ((View)localObject).findViewById(2131364572).setOnClickListener(new a());
    ((View)localObject).findViewById(2131364571).setOnClickListener(new b());
    TPMaterialDialogV2.Builder localBuilder = new TPMaterialDialogV2.Builder(this.y);
    localBuilder.e((View)localObject);
    localBuilder.c(false);
    localBuilder.b(false);
    localBuilder.g(8, 8);
    localObject = localBuilder.a();
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
    if (paramView.getId() == 2131363742)
    {
      if (!d.e(this.y))
      {
        ((FragmentCameraConnectRouterBinding)this.c).q.h();
        P0();
        return;
      }
      ((FragmentCameraConnectRouterBinding)this.c).q.h();
      this.f.e0("CameraWiredConnectingFragment.TAG", null);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    O0();
    ((FragmentCameraConnectRouterBinding)this.c).z.setNavigationOnClickListener(new l(this));
    d0.h(((FragmentCameraConnectRouterBinding)this.c).p0, getString(2131951966), ContextCompat.getColor(requireActivity(), 2131099811), new k(this));
  }
  
  class a
    implements View.OnClickListener
  {
    a() {}
    
    public void onClick(View paramView)
    {
      if (CameraConnectRouterFragment.G0(CameraConnectRouterFragment.this) != null) {
        CameraConnectRouterFragment.G0(CameraConnectRouterFragment.this).dismiss();
      }
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b() {}
    
    public void onClick(View paramView)
    {
      d.f(CameraConnectRouterFragment.H0(CameraConnectRouterFragment.this));
      if (CameraConnectRouterFragment.G0(CameraConnectRouterFragment.this) != null) {
        CameraConnectRouterFragment.G0(CameraConnectRouterFragment.this).dismiss();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraConnectRouterFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */