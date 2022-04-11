package com.tplink.iot.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class TapoCareSubscribeDialog
  extends DialogFragment
{
  public static final String c = TapoCareSubscribeDialog.class.getSimpleName();
  private View.OnClickListener d;
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    getDialog().requestWindowFeature(1);
    paramLayoutInflater = paramLayoutInflater.inflate(2131558824, paramViewGroup, false);
    paramLayoutInflater.findViewById(2131362441).setOnClickListener(new c(this));
    paramLayoutInflater.findViewById(2131362443).setOnClickListener(new d(this));
    return paramLayoutInflater;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\widget\TapoCareSubscribeDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */