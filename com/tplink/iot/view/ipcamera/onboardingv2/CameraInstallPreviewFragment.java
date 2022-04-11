package com.tplink.iot.view.ipcamera.onboardingv2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.tplink.iot.Utils.s0;
import com.tplink.iot.databinding.FragmentCameraV2InstallPreviewBinding;
import com.tplink.iot.view.ipcamera.play.RelayLimitDialogFragment;
import com.tplink.iot.view.ipcamera.play.RelayLimitDialogFragment.a;
import com.tplink.iot.viewmodel.iotplug.factory.IoTViewModelFactory;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraInstallPreviewViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.widget.cameralive.VideoSurfaceViewLayout;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import io.reactivex.e0.b;
import io.reactivex.g0.g;
import io.reactivex.m0.d;
import io.reactivex.q;

public class CameraInstallPreviewFragment
  extends OnBoardingFragment<FragmentCameraV2InstallPreviewBinding, CameraInstallPreviewViewModel>
{
  b p0 = new b();
  private String p1 = null;
  protected final d<Integer> x = d.n1();
  RelayLimitDialogFragment y;
  private boolean z = false;
  
  private void O0(String paramString)
  {
    if (this.z) {
      return;
    }
    this.z = true;
    RelayLimitDialogFragment localRelayLimitDialogFragment = new RelayLimitDialogFragment();
    this.y = localRelayLimitDialogFragment;
    localRelayLimitDialogFragment.L0(new e());
    this.y.K0(new g0(this));
    this.y.J0(paramString);
    paramString = getActivity();
    if (paramString != null)
    {
      paramString = paramString.getSupportFragmentManager();
      this.y.show(paramString, "main.RelayLimitDialogFragment");
    }
  }
  
  public int A0()
  {
    return 2131558880;
  }
  
  public CameraInstallPreviewViewModel G0()
  {
    if (this.q.B() != null) {
      return (CameraInstallPreviewViewModel)new ViewModelProvider(this, new IoTViewModelFactory(this, this.q.B().getDeviceIdMd5())).get(CameraInstallPreviewViewModel.class);
    }
    return null;
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362085)
    {
      if (i != 2131362866)
      {
        if (i == 2131363744) {
          this.f.e0("CameraCompleteFragment.TAG", null);
        }
      }
      else
      {
        s0.m(getActivity(), getString(2131952466));
        ((CameraInstallPreviewViewModel)this.d).m().H0(new c(), new d());
      }
    }
    else {
      this.f.e0("CameraInstallHelpfulItemsFragment.TAG", null);
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.p0.d();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  @SuppressLint({"CheckResult"})
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    if (this.q.B() != null) {
      this.p1 = this.q.B().getDeviceIdMd5();
    }
    ((FragmentCameraV2InstallPreviewBinding)this.c).x.setNavigationOnClickListener(new f0(this));
    ((FragmentCameraV2InstallPreviewBinding)this.c).d.getPaint().setFlags(8);
    ((FragmentCameraV2InstallPreviewBinding)this.c).c.getPaint().setFlags(8);
    paramView = this.p1;
    if (paramView != null)
    {
      ((FragmentCameraV2InstallPreviewBinding)this.c).p0.setDeviceIdMD5(paramView);
      ((FragmentCameraV2InstallPreviewBinding)this.c).p0.setFullScreen(false);
      ((FragmentCameraV2InstallPreviewBinding)this.c).p0.setIsHQ(true);
      ((FragmentCameraV2InstallPreviewBinding)this.c).p0.setIsFocused(true);
      ((FragmentCameraV2InstallPreviewBinding)this.c).p0.setFullScreen(false);
      ((FragmentCameraV2InstallPreviewBinding)this.c).p0.setMultiScreen(false);
      paramView = this.x.G0(new h0(this));
      this.p0.b(paramView);
      ((FragmentCameraV2InstallPreviewBinding)this.c).h(this.x);
      ((CameraInstallPreviewViewModel)this.d).f().H0(new a(), new b());
    }
  }
  
  class a
    implements g<String>
  {
    a() {}
    
    public void a(String paramString)
      throws Exception
    {
      ((FragmentCameraV2InstallPreviewBinding)CameraInstallPreviewFragment.this.c).i(paramString);
      ((FragmentCameraV2InstallPreviewBinding)CameraInstallPreviewFragment.this.c).p0.b0();
    }
  }
  
  class b
    implements g<Throwable>
  {
    b() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      ((FragmentCameraV2InstallPreviewBinding)CameraInstallPreviewFragment.this.c).i("");
      ((FragmentCameraV2InstallPreviewBinding)CameraInstallPreviewFragment.this.c).p0.b0();
    }
  }
  
  class c
    implements g<Boolean>
  {
    c() {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      s0.g();
      ((FragmentCameraV2InstallPreviewBinding)CameraInstallPreviewFragment.this.c).p0.e0();
      ((FragmentCameraV2InstallPreviewBinding)CameraInstallPreviewFragment.this.c).p0.b0();
    }
  }
  
  class d
    implements g<Throwable>
  {
    d() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      s0.p(CameraInstallPreviewFragment.this.getActivity(), CameraInstallPreviewFragment.this.getContext().getString(2131952444));
    }
  }
  
  class e
    implements RelayLimitDialogFragment.a
  {
    e() {}
    
    public void a() {}
    
    public void b()
    {
      CameraInstallPreviewFragment.this.x.onNext(Integer.valueOf(-1));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraInstallPreviewFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */