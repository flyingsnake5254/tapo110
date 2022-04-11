package com.tplink.iot.view.ipcamera.setting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DetectionCloseDialog
  extends DialogFragment
{
  private a c;
  private TextView d;
  private TextView f;
  
  public void H0(a parama)
  {
    this.c = parama;
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558781, paramViewGroup);
    this.d = ((TextView)paramLayoutInflater.findViewById(2131363599));
    this.f = ((TextView)paramLayoutInflater.findViewById(2131362186));
    this.d.setOnClickListener(new z0(this));
    this.f.setOnClickListener(new a1(this));
    return paramLayoutInflater;
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\DetectionCloseDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */