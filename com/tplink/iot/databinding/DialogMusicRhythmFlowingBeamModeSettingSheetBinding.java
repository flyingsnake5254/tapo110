package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class DialogMusicRhythmFlowingBeamModeSettingSheetBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final RecyclerView d;
  @NonNull
  public final TextView f;
  @NonNull
  public final TextView q;
  
  protected DialogMusicRhythmFlowingBeamModeSettingSheetBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView, RecyclerView paramRecyclerView, TextView paramTextView1, TextView paramTextView2)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView;
    this.d = paramRecyclerView;
    this.f = paramTextView1;
    this.q = paramTextView2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\DialogMusicRhythmFlowingBeamModeSettingSheetBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */