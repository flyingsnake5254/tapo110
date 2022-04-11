package com.tplink.iot.view.ipcamera.setting;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.tplink.iot.base.BaseFragment;
import com.tplink.iot.view.ipcamera.base.c;
import com.tplink.iot.viewmodel.ipcamera.setting.PasswordSettingViewModel;
import com.tplink.libtpnetwork.cameranetwork.bean.DeviceModel;

public class DeviceResetFragment
  extends BaseFragment
{
  public DeviceModel q;
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    this.q = ((PasswordSettingActivity)paramContext).e1().i();
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getActivity()).inflate(2131558918, paramViewGroup, false);
    ((Toolbar)paramLayoutInflater.findViewById(2131364275)).setNavigationOnClickListener(new n1(this));
    ((ImageView)paramLayoutInflater.findViewById(2131362810)).setImageResource(c.m(this.q));
    ((TextView)paramLayoutInflater.findViewById(2131364176)).setText(c.p(this.q));
    return paramLayoutInflater;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\DeviceResetFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */