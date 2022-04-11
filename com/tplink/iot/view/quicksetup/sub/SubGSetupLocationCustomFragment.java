package com.tplink.iot.view.quicksetup.sub;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableField;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.Utils.z0.l;
import com.tplink.iot.databinding.FragmentSubGSetupLocationCustomBinding;
import com.tplink.iot.model.iot.EnumDeviceNicknameType;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGSetupLocationSelectViewModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.iot.widget.DrawableEditText;
import com.tplink.iot.widget.FlowTagLayout;
import com.tplink.iot.widget.FlowTagLayout.c;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;
import java.util.ArrayList;

public class SubGSetupLocationCustomFragment
  extends SubGBaseFragment<FragmentSubGSetupLocationCustomBinding, SubGSetupLocationSelectViewModel>
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
    ((FragmentSubGSetupLocationCustomBinding)this.c).c.h();
    String str = ((FragmentSubGSetupLocationCustomBinding)this.c).d.getText().toString();
    this.q.n.set(str);
    this.f.e0("SubGSetupAvatarFragment.TAG", null);
  }
  
  private void L0(View paramView)
  {
    ((FragmentSubGSetupLocationCustomBinding)this.c).c.setEnabled(false);
    ((FragmentSubGSetupLocationCustomBinding)this.c).d.f(new a());
    ((FragmentSubGSetupLocationCustomBinding)this.c).d.m();
    ((FragmentSubGSetupLocationCustomBinding)this.c).f.c(I0(), this);
  }
  
  public int B0()
  {
    return 2131558971;
  }
  
  public void G(String paramString)
  {
    l.m(((FragmentSubGSetupLocationCustomBinding)this.c).d, paramString);
  }
  
  public SubGSetupLocationSelectViewModel J0()
  {
    return (SubGSetupLocationSelectViewModel)ViewModelProviders.of(this).get(SubGSetupLocationSelectViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362037)
    {
      if (i == 2131362826) {
        this.q.E0(20002);
      }
    }
    else {
      K0();
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    L0(paramView);
  }
  
  class a
    implements TextWatcher
  {
    a() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      if (paramEditable.toString().getBytes().length > 64)
      {
        paramEditable.delete(SubGSetupLocationCustomFragment.G0(SubGSetupLocationCustomFragment.this).length() - 1, SubGSetupLocationCustomFragment.G0(SubGSetupLocationCustomFragment.this).length());
        ((FragmentSubGSetupLocationCustomBinding)SubGSetupLocationCustomFragment.this.c).d.setText(paramEditable);
        ((FragmentSubGSetupLocationCustomBinding)SubGSetupLocationCustomFragment.this.c).d.setSelection(paramEditable.length());
      }
      ((FragmentSubGSetupLocationCustomBinding)SubGSetupLocationCustomFragment.this.c).c.setEnabled(TextUtils.isEmpty(paramEditable) ^ true);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      SubGSetupLocationCustomFragment.H0(SubGSetupLocationCustomFragment.this, paramCharSequence);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\sub\SubGSetupLocationCustomFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */