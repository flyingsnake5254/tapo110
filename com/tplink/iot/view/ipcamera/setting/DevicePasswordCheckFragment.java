package com.tplink.iot.view.ipcamera.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.databinding.FragmentDevicePasswordCheckBinding;
import com.tplink.iot.viewmodel.ipcamera.setting.PasswordSettingViewModel;
import com.tplink.libtpcontrols.materialnormalcompat.edittext.MaterialEditText;
import io.reactivex.q;

public class DevicePasswordCheckFragment
  extends BaseFragment
  implements View.OnClickListener
{
  private FragmentDevicePasswordCheckBinding q;
  private PasswordSettingViewModel x;
  
  public void O0(String paramString1, String paramString2)
  {
    this.x.a.set(true);
    this.x.m(paramString1, paramString2).H0(new h1(this), new i1(this));
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
      if (i != 2131362686)
      {
        if (i == 2131363954)
        {
          paramView = this.x.g(this.q.f.getText().toString());
          if (paramView == null)
          {
            this.q.f.setError(null);
            O0(this.q.y.getText().toString(), this.q.f.getText().toString());
          }
          else
          {
            this.q.f.setError(paramView);
          }
        }
      }
      else {
        ((PasswordSettingActivity)getActivity()).f1(2);
      }
    }
    else {
      this.x.e.set(null);
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = (FragmentDevicePasswordCheckBinding)DataBindingUtil.inflate(paramLayoutInflater, 2131558916, paramViewGroup, false);
    this.q = paramLayoutInflater;
    paramLayoutInflater.i(this.x);
    this.q.h(this);
    this.q.x.setNavigationOnClickListener(new g1(this));
    return this.q.getRoot();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\DevicePasswordCheckFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */