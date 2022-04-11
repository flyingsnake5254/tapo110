package com.tplink.iot.databinding;

import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.colorbulb.TPCircleColorView;

public abstract class DialogMusicRhythmColorPickerSheetBinding
  extends ViewDataBinding
{
  @NonNull
  public final TPCircleColorView c;
  @NonNull
  public final FrameLayout d;
  @NonNull
  public final CheckBox f;
  @NonNull
  public final TextView q;
  @NonNull
  public final TextView x;
  
  protected DialogMusicRhythmColorPickerSheetBinding(Object paramObject, View paramView, int paramInt, TPCircleColorView paramTPCircleColorView, FrameLayout paramFrameLayout, CheckBox paramCheckBox, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTPCircleColorView;
    this.d = paramFrameLayout;
    this.f = paramCheckBox;
    this.q = paramTextView1;
    this.x = paramTextView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\DialogMusicRhythmColorPickerSheetBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */