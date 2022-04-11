package com.tplink.iot.view.ipcamera.play;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.SeekBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import b.d.w.f.a;
import com.tplink.iot.databinding.DialogVolumeControlBinding;
import com.tplink.iot.databinding.DialogVolumeControlFullScreenBinding;
import java.util.Objects;

public class VolumeControlDialogFragment
  extends CameraAudioDialogFragment
{
  private DialogVolumeControlBinding I3;
  private DialogVolumeControlFullScreenBinding J3;
  
  public static VolumeControlDialogFragment S0(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isFullScreen", paramBoolean);
    VolumeControlDialogFragment localVolumeControlDialogFragment = new VolumeControlDialogFragment();
    localVolumeControlDialogFragment.setArguments(localBundle);
    return localVolumeControlDialogFragment;
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    if (this.c) {
      this.J3.h(this.p2);
    } else {
      this.I3.h(this.p2);
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramBundle = getArguments();
    Objects.requireNonNull(paramBundle);
    boolean bool = ((Bundle)paramBundle).getBoolean("isFullScreen");
    this.c = bool;
    if (bool)
    {
      paramLayoutInflater = (DialogVolumeControlFullScreenBinding)DataBindingUtil.inflate(paramLayoutInflater, 2131558831, paramViewGroup, false);
      this.J3 = paramLayoutInflater;
      R0(paramLayoutInflater.c);
      this.J3.d.setOnTouchListener(this.H3);
      this.J3.f.setOnTouchListener(this.H3);
      return this.J3.getRoot();
    }
    paramLayoutInflater = (DialogVolumeControlBinding)DataBindingUtil.inflate(paramLayoutInflater, 2131558830, paramViewGroup, false);
    this.I3 = paramLayoutInflater;
    R0(paramLayoutInflater.c);
    this.I3.d.setOnTouchListener(this.H3);
    this.I3.f.setOnTouchListener(this.H3);
    return this.I3.getRoot();
  }
  
  public void onStart()
  {
    super.onStart();
    Window localWindow = getDialog().getWindow();
    if (this.c) {
      i = 0;
    } else {
      i = -1;
    }
    localWindow.setBackgroundDrawable(new ColorDrawable(i));
    localWindow.setDimAmount(0.0F);
    Object localObject = new DisplayMetrics();
    getActivity().getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
    localObject = localWindow.getAttributes();
    if (!this.c)
    {
      ((WindowManager.LayoutParams)localObject).width = a.a(getActivity(), 296.0F);
      ((WindowManager.LayoutParams)localObject).height = a.a(getActivity(), 140.0F);
    }
    else
    {
      ((WindowManager.LayoutParams)localObject).width = a.a(getActivity(), 234.0F);
      ((WindowManager.LayoutParams)localObject).height = a.a(getActivity(), 124.0F);
    }
    ((WindowManager.LayoutParams)localObject).gravity = 8388659;
    ((WindowManager.LayoutParams)localObject).x = (this.p0 - ((WindowManager.LayoutParams)localObject).width);
    int i = this.z;
    if (i == -1) {
      ((WindowManager.LayoutParams)localObject).y = (this.p1 - ((WindowManager.LayoutParams)localObject).height);
    } else {
      ((WindowManager.LayoutParams)localObject).y = i;
    }
    localWindow.setAttributes((WindowManager.LayoutParams)localObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\VolumeControlDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */