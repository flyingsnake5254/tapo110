package com.tplink.iot.view.ipcamera.play;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import b.d.w.f.a;
import com.tplink.iot.databinding.DialogMicrophoneControlBinding;

public class MicrophoneControlDialogFragment
  extends CameraAudioDialogFragment
{
  private DialogMicrophoneControlBinding I3;
  private ObservableBoolean J3 = new ObservableBoolean(true);
  
  public static MicrophoneControlDialogFragment S0(boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isFullScreen", paramBoolean);
    MicrophoneControlDialogFragment localMicrophoneControlDialogFragment = new MicrophoneControlDialogFragment();
    localMicrophoneControlDialogFragment.setArguments(localBundle);
    return localMicrophoneControlDialogFragment;
  }
  
  public void onActivityCreated(@Nullable Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    this.I3.i(this.p2);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = (DialogMicrophoneControlBinding)DataBindingUtil.inflate(paramLayoutInflater, 2131558809, paramViewGroup, false);
    this.I3 = paramLayoutInflater;
    paramLayoutInflater.h(this.J3);
    getDialog().requestWindowFeature(1);
    R0(this.I3.c);
    this.I3.f.setOnTouchListener(this.H3);
    return this.I3.getRoot();
  }
  
  public void onStart()
  {
    super.onStart();
    Window localWindow = getDialog().getWindow();
    if (localWindow != null)
    {
      Context localContext = localWindow.getContext();
      localWindow.setBackgroundDrawable(new ColorDrawable(Integer.MIN_VALUE));
      localWindow.setDimAmount(0.0F);
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.gravity = 8388659;
      localLayoutParams.width = a.a(localContext, 240.0F);
      int i = a.a(localContext, 72.0F);
      localLayoutParams.height = i;
      localLayoutParams.x = (this.p0 - localLayoutParams.width);
      int j = this.z;
      if (j == -1) {
        localLayoutParams.y = (this.p1 - i);
      } else {
        localLayoutParams.y = j;
      }
      localWindow.setAttributes(localLayoutParams);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\play\MicrophoneControlDialogFragment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */