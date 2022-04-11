package com.tplink.iot.view.quicksetup.sub;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.ObservableField;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import com.tplink.iot.databinding.FragmentSubGSetupNameBinding;
import com.tplink.iot.view.ipcamera.onboardingv2.z1;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGSetupNameViewModel;
import com.tplink.iot.viewmodel.quicksetup.subg.SubGViewModel;
import com.tplink.iot.widget.DrawableEditText;
import java.util.List;

public class SubGSetupNameFragment
  extends SubGBaseFragment<FragmentSubGSetupNameBinding, SubGSetupNameViewModel>
{
  private CharSequence x;
  
  private void J0()
  {
    Object localObject = ((FragmentSubGSetupNameBinding)this.c).d.getText().toString();
    this.q.m.set(localObject);
    localObject = this.q.s();
    if ((localObject != null) && (!((List)localObject).isEmpty())) {
      this.f.e0("SubGSetupLocationSelectFragment.TAG", null);
    } else {
      this.f.e0("SubGSetupLocationCustomFragment.TAG", null);
    }
  }
  
  private void K0()
  {
    ((FragmentSubGSetupNameBinding)this.c).d.f(new a());
  }
  
  public int B0()
  {
    return 2131558973;
  }
  
  public SubGSetupNameViewModel I0()
  {
    return (SubGSetupNameViewModel)ViewModelProviders.of(this).get(SubGSetupNameViewModel.class);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362037) {
      J0();
    }
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.f.q0();
    this.q.s0();
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
        paramEditable.delete(SubGSetupNameFragment.G0(SubGSetupNameFragment.this).length() - 1, SubGSetupNameFragment.G0(SubGSetupNameFragment.this).length());
        ((FragmentSubGSetupNameBinding)SubGSetupNameFragment.this.c).d.setText(paramEditable);
        ((FragmentSubGSetupNameBinding)SubGSetupNameFragment.this.c).d.setSelection(paramEditable.length());
      }
      ((FragmentSubGSetupNameBinding)SubGSetupNameFragment.this.c).c.setEnabled(TextUtils.isEmpty(paramEditable) ^ true);
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      SubGSetupNameFragment.H0(SubGSetupNameFragment.this, paramCharSequence);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\quicksetup\sub\SubGSetupNameFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */