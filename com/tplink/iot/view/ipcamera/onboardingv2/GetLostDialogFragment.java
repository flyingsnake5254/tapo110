package com.tplink.iot.view.ipcamera.onboardingv2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.tplink.iot.databinding.FragmentDialogGetLostBinding;
import com.tplink.iot.view.ipcamera.base.g;

public class GetLostDialogFragment
  extends DialogFragment
  implements g
{
  private String c;
  private FragmentDialogGetLostBinding d;
  private View.OnClickListener f;
  private View.OnClickListener q;
  private Dialog x;
  
  private void G0()
  {
    if (getDialog() != null) {
      getDialog().setOnKeyListener(new a());
    }
  }
  
  void A0()
  {
    dismiss();
    startActivity(new Intent("android.settings.WIFI_SETTINGS"));
  }
  
  protected void B0()
  {
    if (getArguments() != null) {
      this.c = getArguments().getString("soft_ap_wifi_SSID");
    } else {
      this.c = "";
    }
  }
  
  protected void C0()
  {
    Dialog localDialog = getDialog();
    localDialog.requestWindowFeature(1);
    localDialog.setContentView(2131558921);
    this.d.x.setText(this.c);
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131363585)
    {
      if (i == 2131363587)
      {
        dismiss();
        this.f.onClick(paramView);
      }
    }
    else
    {
      View.OnClickListener localOnClickListener = this.q;
      if (localOnClickListener != null) {
        localOnClickListener.onClick(paramView);
      }
      A0();
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramBundle = getDialog();
    this.x = paramBundle;
    if (paramBundle != null)
    {
      if (paramBundle.getWindow() != null) {
        this.x.getWindow().requestFeature(1);
      }
      this.x.setCanceledOnTouchOutside(false);
      this.x.setCancelable(false);
    }
    paramLayoutInflater = (FragmentDialogGetLostBinding)DataBindingUtil.inflate(paramLayoutInflater, 2131558921, paramViewGroup, false);
    this.d = paramLayoutInflater;
    paramLayoutInflater.h(this);
    G0();
    return this.d.getRoot();
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
  }
  
  public void onViewCreated(@NonNull View paramView, @Nullable Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    B0();
    C0();
  }
  
  class a
    implements DialogInterface.OnKeyListener
  {
    a() {}
    
    public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
    {
      return paramInt == 4;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\onboardingv2\GetLostDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */