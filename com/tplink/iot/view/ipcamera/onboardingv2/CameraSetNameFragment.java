package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ObservableBoolean;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import b.d.b.f.b;
import b.d.s.a.a;
import com.tplink.iot.cloud.bean.family.common.FamilyInfo;
import com.tplink.iot.databinding.FragmentCameraV2NameBinding;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraOnBoardingViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraSetNameViewModel;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.OnBoardingFragmentViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTClientManager;
import java.util.List;

public class CameraSetNameFragment
  extends OnBoardingFragment<FragmentCameraV2NameBinding, CameraSetNameViewModel>
{
  private void H0()
  {
    if (this.q.g0())
    {
      Object localObject = (TPIoTClientManager)b.a(a.f(), TPIoTClientManager.class);
      if (((TPIoTClientManager)localObject).Q1() != null) {
        localObject = ((TPIoTClientManager)localObject).Q1().getRooms();
      } else {
        localObject = null;
      }
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        this.f.e0("CameraRoomSelectFragment.TAG", null);
      } else {
        this.f.e0("CameraRoomCustomFragment.TAG", null);
      }
      return;
    }
    this.f.e0("CameraSetLocationFragment.TAG", null);
  }
  
  private void I0()
  {
    ((FragmentCameraV2NameBinding)this.c).d.getEditText().addTextChangedListener(new a());
  }
  
  public int A0()
  {
    return 2131558887;
  }
  
  public CameraSetNameViewModel G0()
  {
    return (CameraSetNameViewModel)ViewModelProviders.of(this).get(CameraSetNameViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362037) {
      H0();
    }
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.f.q0();
    ((FragmentCameraV2NameBinding)this.c).q.setNavigationOnClickListener(new c1(this));
    this.q.R1();
    I0();
  }
  
  class a
    implements TextWatcher
  {
    a() {}
    
    public void afterTextChanged(Editable paramEditable) {}
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      OnBoardingFragmentViewModel localOnBoardingFragmentViewModel = CameraSetNameFragment.this.d;
      ((CameraSetNameViewModel)localOnBoardingFragmentViewModel).a.set(((CameraSetNameViewModel)localOnBoardingFragmentViewModel).f(paramCharSequence.toString()));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraSetNameFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */