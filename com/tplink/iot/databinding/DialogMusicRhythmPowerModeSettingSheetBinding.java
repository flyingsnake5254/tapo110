package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class DialogMusicRhythmPowerModeSettingSheetBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final SeekBar d;
  @NonNull
  public final RecyclerView f;
  @NonNull
  public final TextView q;
  @NonNull
  public final TextView x;
  
  protected DialogMusicRhythmPowerModeSettingSheetBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView, SeekBar paramSeekBar, RecyclerView paramRecyclerView, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView;
    this.d = paramSeekBar;
    this.f = paramRecyclerView;
    this.q = paramTextView1;
    this.x = paramTextView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\DialogMusicRhythmPowerModeSettingSheetBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */