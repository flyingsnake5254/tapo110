package com.tplink.iot.view.ipcamera.setting;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import com.tplink.libtpnetwork.cameranetwork.util.e;

public class NotificationCloseDialog
  extends DialogFragment
{
  private a c;
  
  public void H0(a parama)
  {
    this.c = parama;
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.inflate(2131558818, null);
    paramLayoutInflater.findViewById(2131363600).setOnClickListener(new i3(this));
    paramLayoutInflater.findViewById(2131362186).setOnClickListener(new j3(this));
    return paramLayoutInflater;
  }
  
  public void onStart()
  {
    getDialog().getWindow().setLayout(e.a(340, getContext()), -2);
    super.onStart();
  }
  
  public static abstract interface a
  {
    public abstract void a();
    
    public abstract void b();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\setting\NotificationCloseDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */