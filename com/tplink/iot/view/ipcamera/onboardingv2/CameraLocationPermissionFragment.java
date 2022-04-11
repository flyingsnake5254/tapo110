package com.tplink.iot.view.ipcamera.onboardingv2;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.databinding.FragmentCameraV2LocationPermissionBinding;
import com.tplink.iot.view.quicksetup.base.e;
import com.tplink.iot.view.quicksetup.base.wifi.b;
import com.tplink.iot.view.quicksetup.base.wifi.d;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraLocationPermissionViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.libtpnetwork.Utils.o;

public class CameraLocationPermissionFragment
  extends OnBoardingFragment<FragmentCameraV2LocationPermissionBinding, CameraLocationPermissionViewModel>
{
  private e p0;
  private TPMaterialDialogV2 p1;
  private Activity x;
  private TPMaterialDialogV2 y;
  private TPMaterialDialogV2 z;
  
  private void L0()
  {
    if (!d.c(this.x))
    {
      b.d(this);
      return;
    }
    if (!d.d(this.x))
    {
      P0();
      return;
    }
    if (!d.e(this.x))
    {
      Q0();
      return;
    }
    this.q.i2(true);
    this.f.e0("CameraCheckStatusFragment.TAG", null);
  }
  
  private void O0()
  {
    this.q.i2(false);
    o.h0().h("has_refused_location_permission", true);
    this.f.e0("CameraInstructionFragment.TAG", null);
  }
  
  public int A0()
  {
    return 2131558884;
  }
  
  public CameraLocationPermissionViewModel N0()
  {
    return (CameraLocationPermissionViewModel)ViewModelProviders.of(this).get(CameraLocationPermissionViewModel.class);
  }
  
  void P0()
  {
    Object localObject = this.z;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      return;
    }
    View localView = LayoutInflater.from(this.x).inflate(2131559100, null, false);
    localView.findViewById(2131364572).setOnClickListener(new b());
    localView.findViewById(2131364571).setOnClickListener(new c());
    localObject = new TPMaterialDialogV2.Builder(this.x);
    ((TPMaterialDialogV2.Builder)localObject).e(localView);
    ((TPMaterialDialogV2.Builder)localObject).c(false);
    ((TPMaterialDialogV2.Builder)localObject).b(false);
    ((TPMaterialDialogV2.Builder)localObject).g(8, 8);
    localObject = ((TPMaterialDialogV2.Builder)localObject).a();
    this.z = ((TPMaterialDialogV2)localObject);
    ((TPMaterialDialogV2)localObject).show();
  }
  
  void Q0()
  {
    Object localObject = this.p1;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      return;
    }
    View localView = LayoutInflater.from(this.x).inflate(2131559250, null, false);
    localView.findViewById(2131364572).setOnClickListener(new d());
    localView.findViewById(2131364571).setOnClickListener(new e());
    localObject = new TPMaterialDialogV2.Builder(this.x);
    ((TPMaterialDialogV2.Builder)localObject).e(localView);
    ((TPMaterialDialogV2.Builder)localObject).c(false);
    ((TPMaterialDialogV2.Builder)localObject).b(false);
    ((TPMaterialDialogV2.Builder)localObject).g(8, 8);
    localObject = ((TPMaterialDialogV2.Builder)localObject).a();
    this.p1 = ((TPMaterialDialogV2)localObject);
    ((TPMaterialDialogV2)localObject).show();
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.x = ((Activity)paramContext);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362037)
    {
      if (i == 2131362826) {
        this.q.o2(20002);
      }
    }
    else {
      L0();
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    TPMaterialDialogV2 localTPMaterialDialogV2 = this.y;
    if (localTPMaterialDialogV2 != null)
    {
      localTPMaterialDialogV2.dismiss();
      this.y = null;
    }
    localTPMaterialDialogV2 = this.z;
    if (localTPMaterialDialogV2 != null)
    {
      localTPMaterialDialogV2.dismiss();
      this.z = null;
    }
    this.p0.b();
  }
  
  public void onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    b.a(paramInt, paramArrayOfString, paramArrayOfInt, new a());
  }
  
  public void onResume()
  {
    super.onResume();
    if (((CameraLocationPermissionViewModel)this.d).f()) {
      if (!d.d(this.x)) {
        O0();
      } else {
        L0();
      }
    }
    if (d.a(this.x))
    {
      this.q.i2(true);
      this.f.e0("CameraCheckStatusFragment.TAG", null);
    }
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.p0 = new e(this.x);
  }
  
  class a
    implements com.tplink.iot.view.quicksetup.base.wifi.a
  {
    a() {}
    
    public void a()
    {
      CameraLocationPermissionFragment.H0(CameraLocationPermissionFragment.this);
    }
    
    public void b()
    {
      CameraLocationPermissionFragment.G0(CameraLocationPermissionFragment.this);
    }
  }
  
  class b
    implements View.OnClickListener
  {
    b() {}
    
    public void onClick(View paramView)
    {
      if (CameraLocationPermissionFragment.I0(CameraLocationPermissionFragment.this) != null)
      {
        CameraLocationPermissionFragment.I0(CameraLocationPermissionFragment.this).dismiss();
        CameraLocationPermissionFragment.H0(CameraLocationPermissionFragment.this);
      }
    }
  }
  
  class c
    implements View.OnClickListener
  {
    c() {}
    
    public void onClick(View paramView)
    {
      if (CameraLocationPermissionFragment.I0(CameraLocationPermissionFragment.this) != null) {
        CameraLocationPermissionFragment.I0(CameraLocationPermissionFragment.this).dismiss();
      }
      ((CameraLocationPermissionViewModel)CameraLocationPermissionFragment.this.d).g(true);
      CameraLocationPermissionFragment.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
    }
  }
  
  class d
    implements View.OnClickListener
  {
    d() {}
    
    public void onClick(View paramView)
    {
      if (CameraLocationPermissionFragment.J0(CameraLocationPermissionFragment.this) != null) {
        CameraLocationPermissionFragment.J0(CameraLocationPermissionFragment.this).dismiss();
      }
      CameraLocationPermissionFragment.H0(CameraLocationPermissionFragment.this);
    }
  }
  
  class e
    implements View.OnClickListener
  {
    e() {}
    
    public void onClick(View paramView)
    {
      d.f(CameraLocationPermissionFragment.K0(CameraLocationPermissionFragment.this));
      if (CameraLocationPermissionFragment.J0(CameraLocationPermissionFragment.this) != null) {
        CameraLocationPermissionFragment.J0(CameraLocationPermissionFragment.this).dismiss();
      }
      CameraLocationPermissionFragment.this.q.i2(true);
      CameraLocationPermissionFragment.this.f.e0("CameraCheckStatusFragment.TAG", null);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraLocationPermissionFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */