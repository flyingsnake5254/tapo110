package com.tplink.iot.view.ipcamera.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import b.d.w.c.a;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.databinding.FragmentDevicePasswordSettingBinding;
import com.tplink.iot.viewmodel.ipcamera.setting.PasswordSettingViewModel;
import com.tplink.libtpcontrols.materialnormalcompat.edittext.MaterialEditText;
import io.reactivex.q;

public class DevicePasswordSettingFragment
  extends BaseFragment
  implements View.OnClickListener
{
  private FragmentDevicePasswordSettingBinding q;
  private PasswordSettingViewModel x;
  
  private void H0(EditText paramEditText)
  {
    paramEditText.setFocusable(true);
    paramEditText.setFocusableInTouchMode(true);
    paramEditText.requestFocus();
    ((InputMethodManager)paramEditText.getContext().getSystemService("input_method")).showSoftInput(paramEditText, 0);
  }
  
  public void R0(String paramString1, String paramString2)
  {
    this.x.f(paramString1, paramString2).H0(new l1(this), new j1(this));
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.x = ((PasswordSettingActivity)paramContext).e1();
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362186)
    {
      if (i == 2131363954)
      {
        paramView = new StringBuilder();
        paramView.append("username:");
        paramView.append(this.q.y.getText().toString());
        a.e("PasswordSettingFragment", paramView.toString());
        paramView = new StringBuilder();
        paramView.append("password:");
        paramView.append(this.q.d.getText().toString());
        a.e("PasswordSettingFragment", paramView.toString());
        paramView = this.x.g(this.q.y.getText().toString());
        String str = this.x.g(this.q.d.getText().toString());
        if ((paramView == null) && (str == null))
        {
          this.q.y.setError(null);
          this.q.d.setError(null);
          this.x.a.set(true);
          R0(this.q.y.getText().toString(), this.q.d.getText().toString());
        }
        else if (paramView != null)
        {
          this.q.y.setError(paramView);
        }
        else
        {
          this.q.y.setError(null);
          if (str != null) {
            this.q.d.setError(str);
          } else {
            this.q.d.setError(null);
          }
        }
      }
    }
    else {
      this.x.e.set(null);
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = (FragmentDevicePasswordSettingBinding)DataBindingUtil.inflate(paramLayoutInflater, 2131558917, paramViewGroup, false);
    this.q = paramLayoutInflater;
    paramLayoutInflater.i(this.x);
    this.q.h(this);
    this.q.x.setNavigationOnClickListener(new k1(this));
    paramLayoutInflater = this.x;
    if ((paramLayoutInflater != null) && (paramLayoutInflater.j() != null)) {
      this.q.d.post(new m1(this));
    }
    return this.q.getRoot();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\DevicePasswordSettingFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */