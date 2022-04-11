package com.tplink.iot.viewmodel.ipcamera.setting;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import com.tplink.iot.databinding.FragmentRecordTypeDialogBinding;

public class RecordTypeDialogFragment
  extends DialogFragment
{
  private a c;
  private int d = 1;
  
  private void B0(RadioGroup paramRadioGroup, int paramInt)
  {
    if (paramInt == 2131362979) {
      this.d = 1;
    } else {
      this.d = 2;
    }
  }
  
  public void onAttach(Context paramContext)
  {
    super.onAttach(paramContext);
    if ((paramContext instanceof a))
    {
      this.c = ((a)paramContext);
      return;
    }
    throw new IllegalStateException("Calling page must implement OnSelectedCallback interface");
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131362188)
    {
      if (i == 2131363582)
      {
        this.c.Y(this.d);
        dismiss();
      }
    }
    else {
      dismiss();
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    getDialog().requestWindowFeature(1);
    paramLayoutInflater = (FragmentRecordTypeDialogBinding)DataBindingUtil.inflate(paramLayoutInflater, 2131558949, paramViewGroup, false);
    paramLayoutInflater.i(new e4(this));
    paramLayoutInflater.h(new p7(this));
    return paramLayoutInflater.getRoot();
  }
  
  public static abstract interface a
  {
    public abstract void Y(int paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\setting\RecordTypeDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */