package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.databinding.FragmentCameraV2ManualInputPwdBinding;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraManualInputPwdViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.iot.widget.UniversalDialog;
import com.tplink.iot.widget.UniversalDialog.a;

public class CameraManualInputPwdFragment
  extends OnBoardingFragment<FragmentCameraV2ManualInputPwdBinding, CameraManualInputPwdViewModel>
{
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
    ((FragmentCameraV2ManualInputPwdBinding)this.c).d.getEditText().addTextChangedListener(new a());
    ((FragmentCameraV2ManualInputPwdBinding)this.c).f.getEditText().addTextChangedListener(new b());
  }
  
  private void O0()
  {
    if (!isAdded()) {
      return;
    }
    new UniversalDialog.a().q(getString(2131953503)).u(getString(2131952397)).s(getString(2131951757)).t(new m0(this)).l().show(getChildFragmentManager(), "");
  }
  
  public int A0()
  {
    return 2131558886;
  }
  
  public CameraManualInputPwdViewModel H0()
  {
    return (CameraManualInputPwdViewModel)ViewModelProviders.of(this).get(CameraManualInputPwdViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362037)
    {
      ((CameraManualInputPwdViewModel)this.d).f();
      if (TextUtils.isEmpty((CharSequence)this.q.b.get())) {
        O0();
      } else {
        this.f.e0("CameraInputPwdFragment.TAG", null);
      }
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.q.a.set("");
    this.q.b.set("");
    ((CameraManualInputPwdViewModel)this.d).h(this.q);
    I0();
    return paramLayoutInflater;
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    ((FragmentCameraV2ManualInputPwdBinding)this.c).x.setNavigationOnClickListener(new l0(this));
  }
  
  class a
    implements TextWatcher
  {
    a() {}
    
    public void afterTextChanged(Editable paramEditable) {}
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      CameraManualInputPwdFragment localCameraManualInputPwdFragment = CameraManualInputPwdFragment.this;
      ObservableBoolean localObservableBoolean = ((CameraManualInputPwdViewModel)localCameraManualInputPwdFragment.d).b;
      if (!localCameraManualInputPwdFragment.q.e0(paramCharSequence.toString()))
      {
        paramCharSequence = CameraManualInputPwdFragment.this;
        if (!((CameraManualInputPwdViewModel)paramCharSequence.d).g((String)paramCharSequence.q.b.get()))
        {
          bool = true;
          break label76;
        }
      }
      boolean bool = false;
      label76:
      localObservableBoolean.set(bool);
    }
  }
  
  class b
    implements TextWatcher
  {
    b() {}
    
    public void afterTextChanged(Editable paramEditable) {}
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      Object localObject = CameraManualInputPwdFragment.this;
      ObservableBoolean localObservableBoolean = ((CameraManualInputPwdViewModel)((OnBoardingFragment)localObject).d).b;
      localObject = ((OnBoardingFragment)localObject).q;
      boolean bool;
      if ((!((CameraOnBoardingViewModel)localObject).e0((String)((CameraOnBoardingViewModel)localObject).a.get())) && (!((CameraManualInputPwdViewModel)CameraManualInputPwdFragment.this.d).g(paramCharSequence.toString()))) {
        bool = true;
      } else {
        bool = false;
      }
      localObservableBoolean.set(bool);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraManualInputPwdFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */