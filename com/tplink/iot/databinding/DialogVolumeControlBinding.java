package com.tplink.iot.databinding;

import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.touchlayout.TouchListenerConstraintLayout;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;

public abstract class DialogVolumeControlBinding
  extends ViewDataBinding
{
  @NonNull
  public final TouchListenerConstraintLayout c;
  @NonNull
  public final SeekBar d;
  @NonNull
  public final SeekBar f;
  @NonNull
  public final TextView q;
  @NonNull
  public final TextView x;
  @Bindable
  protected TalkViewModel y;
  
  protected DialogVolumeControlBinding(Object paramObject, View paramView, int paramInt, TouchListenerConstraintLayout paramTouchListenerConstraintLayout, SeekBar paramSeekBar1, SeekBar paramSeekBar2, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTouchListenerConstraintLayout;
    this.d = paramSeekBar1;
    this.f = paramSeekBar2;
    this.q = paramTextView1;
    this.x = paramTextView2;
  }
  
  public abstract void h(@Nullable TalkViewModel paramTalkViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\DialogVolumeControlBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */