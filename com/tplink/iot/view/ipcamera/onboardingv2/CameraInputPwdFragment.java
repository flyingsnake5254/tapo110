package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.TPMaterialDialogV2;
import com.tplink.iot.Utils.TPMaterialDialogV2.Builder;
import com.tplink.iot.databinding.FragmentCameraV2InputPwdBinding;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.InputPwdViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpnetwork.cameranetwork.model.Wifi;

public class CameraInputPwdFragment
  extends OnBoardingFragment<FragmentCameraV2InputPwdBinding, InputPwdViewModel>
{
  private TPMaterialDialogV2 x;
  
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
    ((FragmentCameraV2InputPwdBinding)this.c).f.getEditText().addTextChangedListener(new a());
    if ((this.q.z() != null) && (this.q.z().getAuth() == 0)) {
      ((InputPwdViewModel)this.d).a.set(true);
    }
  }
  
  private void Q0()
  {
    Object localObject = (String)this.q.a.get();
    String str = (String)this.q.b.get();
    View localView = LayoutInflater.from(requireActivity()).inflate(2131559183, null, false);
    ((TextView)localView.findViewById(2131364644)).setText((CharSequence)localObject);
    ((TextView)localView.findViewById(2131364567)).setText(str);
    localObject = new TPMaterialDialogV2.Builder(requireActivity()).w(localView).l(2131952391, 2131099804, null).o(2131952438, 2131099808, new a0(this)).g(8, 8).a();
    this.x = ((TPMaterialDialogV2)localObject);
    ((TPMaterialDialogV2)localObject).show();
  }
  
  private void R0()
  {
    View localView = LayoutInflater.from(getContext()).inflate(2131558776, null);
    if (!this.q.k.get()) {
      localView.findViewById(2131364728).setVisibility(0);
    }
    new TPMaterialDialogV2.Builder(getContext()).r(2131951973).w(localView).g(8, 8).o(2131952441, 2131099808, null).y();
  }
  
  public int A0()
  {
    return 2131558875;
  }
  
  public InputPwdViewModel H0()
  {
    return (InputPwdViewModel)ViewModelProviders.of(this).get(InputPwdViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362037)
    {
      if (i == 2131364618) {
        this.f.e0("CameraWifiListFragment.TAG", null);
      }
    }
    else {
      Q0();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    I0();
    this.q.A().observe(this, new c0(this));
    CameraOnBoardingViewModel localCameraOnBoardingViewModel = this.q;
    ObservableBoolean localObservableBoolean = localCameraOnBoardingViewModel.d;
    boolean bool;
    if (localCameraOnBoardingViewModel.z() != null) {
      bool = true;
    } else {
      bool = false;
    }
    localObservableBoolean.set(bool);
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ((InputPwdViewModel)this.d).g(this.q);
    ((FragmentCameraV2InputPwdBinding)this.c).x.setNavigationOnClickListener(new b0(this));
  }
  
  class a
    implements TextWatcher
  {
    a() {}
    
    public void afterTextChanged(Editable paramEditable) {}
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      Object localObject = CameraInputPwdFragment.this;
      ObservableBoolean localObservableBoolean = ((InputPwdViewModel)((OnBoardingFragment)localObject).d).a;
      localObject = ((OnBoardingFragment)localObject).q;
      paramCharSequence = paramCharSequence.toString();
      if (CameraInputPwdFragment.this.q.z() == null) {
        paramInt1 = 1;
      } else {
        paramInt1 = CameraInputPwdFragment.this.q.z().getAuth();
      }
      localObservableBoolean.set(((CameraOnBoardingViewModel)localObject).c0(paramCharSequence, paramInt1) ^ true);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraInputPwdFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */