package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.progressbar.MultiColorSeekBar;
import com.tplink.iot.view.ipcamera.widget.touchlayout.TouchListenerConstraintLayout;
import com.tplink.iot.viewmodel.ipcamera.play.TalkViewModel;

public abstract class DialogMicrophoneControlBinding
  extends ViewDataBinding
{
  @NonNull
  public final TouchListenerConstraintLayout c;
  @NonNull
  public final TextView d;
  @NonNull
  public final MultiColorSeekBar f;
  @NonNull
  public final TextView q;
  @Bindable
  protected ObservableBoolean x;
  @Bindable
  protected TalkViewModel y;
  
  protected DialogMicrophoneControlBinding(Object paramObject, View paramView, int paramInt, TouchListenerConstraintLayout paramTouchListenerConstraintLayout, TextView paramTextView1, MultiColorSeekBar paramMultiColorSeekBar, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTouchListenerConstraintLayout;
    this.d = paramTextView1;
    this.f = paramMultiColorSeekBar;
    this.q = paramTextView2;
  }
  
  public abstract void h(@Nullable ObservableBoolean paramObservableBoolean);
  
  public abstract void i(@Nullable TalkViewModel paramTalkViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\DialogMicrophoneControlBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */