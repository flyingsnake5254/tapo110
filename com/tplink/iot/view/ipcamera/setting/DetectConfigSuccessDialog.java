package com.tplink.iot.view.ipcamera.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;

public class DetectConfigSuccessDialog
  extends DialogFragment
{
  a c;
  private TextView d;
  private TextView f;
  private String q;
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramViewGroup = paramLayoutInflater.inflate(2131558782, paramViewGroup, false);
    this.d = ((TextView)paramViewGroup.findViewById(2131363468));
    paramLayoutInflater = (TextView)paramViewGroup.findViewById(2131363469);
    this.f = paramLayoutInflater;
    paramLayoutInflater.setText(this.q);
    this.d.setOnClickListener(new y0(this));
    return paramViewGroup;
  }
  
  public static abstract interface a
  {
    public abstract void a();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\DetectConfigSuccessDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */