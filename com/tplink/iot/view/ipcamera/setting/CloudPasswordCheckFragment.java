package com.tplink.iot.view.ipcamera.setting;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import com.tplink.iot.Utils.d0;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.databinding.FragmentCloudPasswordCheckBinding;
import com.tplink.iot.view.ipcamera.widget.topsnackbar.TSnackbar;
import com.tplink.iot.viewmodel.ipcamera.setting.PasswordSettingViewModel;
import com.tplink.libtpcontrols.materialnormalcompat.edittext.MaterialEditText;

public class CloudPasswordCheckFragment
  extends BaseFragment
  implements View.OnClickListener
{
  private FragmentCloudPasswordCheckBinding q;
  private PasswordSettingViewModel x;
  
  private void L0()
  {
    d0.d(getContext(), this.q.c, 2131952723, getString(2131952724), new w0(this));
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
      if (i == 2131363954) {
        if (this.x.h(this.q.d.getText().toString()))
        {
          this.q.d.setError(null);
          ((PasswordSettingActivity)getActivity()).f1(0);
        }
        else
        {
          TSnackbar.B(this, 2131952546, -1).J(getResources().getColor(2131099812)).N();
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
    paramLayoutInflater = (FragmentCloudPasswordCheckBinding)DataBindingUtil.inflate(paramLayoutInflater, 2131558908, paramViewGroup, false);
    this.q = paramLayoutInflater;
    paramLayoutInflater.i(this.x);
    this.q.h(this);
    this.q.q.setNavigationOnClickListener(new x0(this));
    L0();
    return this.q.getRoot();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\CloudPasswordCheckFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */