package com.tplink.iot.view.ipcamera.onboardingv2;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.databinding.FragmentCameraV2RoomCustomBinding;
import com.tplink.iot.model.iot.EnumDeviceNicknameType;
import com.tplink.iot.view.quicksetup.base.d;
import com.tplink.iot.viewmodel.ipcamera.onboardingv2.CameraRoomCustomViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.iot.widget.FlowTagLayout;
import com.tplink.iot.widget.FlowTagLayout.c;
import java.util.ArrayList;

public class CameraRoomCustomFragment
  extends OnBoardingFragment<FragmentCameraV2RoomCustomBinding, CameraRoomCustomViewModel>
  implements FlowTagLayout.c
{
  private CharSequence x;
  
  private ArrayList<String> I0()
  {
    ArrayList localArrayList = new ArrayList();
    for (EnumDeviceNicknameType localEnumDeviceNicknameType : EnumDeviceNicknameType.values()) {
      if (localEnumDeviceNicknameType != EnumDeviceNicknameType.CUSTOM) {
        localArrayList.add(EnumDeviceNicknameType.fromType(localEnumDeviceNicknameType));
      }
    }
    return localArrayList;
  }
  
  private void K0()
  {
    ((FragmentCameraV2RoomCustomBinding)this.c).x.setNavigationOnClickListener(new s0(this));
    ((FragmentCameraV2RoomCustomBinding)this.c).q.setText(2131952438);
    ((FragmentCameraV2RoomCustomBinding)this.c).d.f(new a());
    ((FragmentCameraV2RoomCustomBinding)this.c).d.m();
    ViewDataBinding localViewDataBinding = this.c;
    ((FragmentCameraV2RoomCustomBinding)localViewDataBinding).d.setText(((FragmentCameraV2RoomCustomBinding)localViewDataBinding).d.getText().toString());
    ((FragmentCameraV2RoomCustomBinding)this.c).f.c(I0(), this);
  }
  
  public int A0()
  {
    return 2131558895;
  }
  
  public void G(String paramString)
  {
    l.m(((FragmentCameraV2RoomCustomBinding)this.c).d, paramString);
    d.I(getActivity());
  }
  
  public CameraRoomCustomViewModel J0()
  {
    return (CameraRoomCustomViewModel)ViewModelProviders.of(this).get(CameraRoomCustomViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131363541)
    {
      paramView = ((FragmentCameraV2RoomCustomBinding)this.c).d.getText().toString();
      this.q.X = paramView;
      this.f.e0("CameraSetLocationFragment.TAG", null);
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    d.I(getActivity());
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    K0();
  }
  
  class a
    implements TextWatcher
  {
    a() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      if (paramEditable.toString().getBytes().length > 64)
      {
        paramEditable.delete(CameraRoomCustomFragment.G0(CameraRoomCustomFragment.this).length() - 1, CameraRoomCustomFragment.G0(CameraRoomCustomFragment.this).length());
        ((FragmentCameraV2RoomCustomBinding)CameraRoomCustomFragment.this.c).d.setText(paramEditable);
        ((FragmentCameraV2RoomCustomBinding)CameraRoomCustomFragment.this.c).d.setSelection(paramEditable.length());
      }
      ((FragmentCameraV2RoomCustomBinding)CameraRoomCustomFragment.this.c).q.setEnabled(TextUtils.isEmpty(paramEditable) ^ true);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      CameraRoomCustomFragment.H0(CameraRoomCustomFragment.this, paramCharSequence);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\CameraRoomCustomFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */