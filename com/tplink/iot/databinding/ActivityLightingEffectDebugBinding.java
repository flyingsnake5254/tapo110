package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.ChipGroup;
import com.tplink.iot.devices.lightstrip.view.effects.LightingEffectDebugViewModel;

public abstract class ActivityLightingEffectDebugBinding
  extends ViewDataBinding
{
  @NonNull
  public final SeekBar H3;
  @NonNull
  public final SeekBar I3;
  @NonNull
  public final SeekBar J3;
  @NonNull
  public final SeekBar K3;
  @NonNull
  public final SeekBar L3;
  @NonNull
  public final SeekBar M3;
  @NonNull
  public final SeekBar N3;
  @NonNull
  public final AppCompatSpinner O3;
  @NonNull
  public final AppCompatSpinner P3;
  @NonNull
  public final AppCompatSpinner Q3;
  @NonNull
  public final TextView R3;
  @Bindable
  protected View.OnClickListener S3;
  @Bindable
  protected LightingEffectDebugViewModel T3;
  @NonNull
  public final Button c;
  @NonNull
  public final Button d;
  @NonNull
  public final Button f;
  @NonNull
  public final RecyclerView p0;
  @NonNull
  public final RecyclerView p1;
  @NonNull
  public final RecyclerView p2;
  @NonNull
  public final RecyclerView p3;
  @NonNull
  public final Button q;
  @NonNull
  public final Button x;
  @NonNull
  public final Button y;
  @NonNull
  public final ChipGroup z;
  
  protected ActivityLightingEffectDebugBinding(Object paramObject, View paramView, int paramInt, Button paramButton1, Button paramButton2, Button paramButton3, Button paramButton4, Button paramButton5, Button paramButton6, ChipGroup paramChipGroup, RecyclerView paramRecyclerView1, RecyclerView paramRecyclerView2, RecyclerView paramRecyclerView3, RecyclerView paramRecyclerView4, SeekBar paramSeekBar1, SeekBar paramSeekBar2, SeekBar paramSeekBar3, SeekBar paramSeekBar4, SeekBar paramSeekBar5, SeekBar paramSeekBar6, SeekBar paramSeekBar7, AppCompatSpinner paramAppCompatSpinner1, AppCompatSpinner paramAppCompatSpinner2, AppCompatSpinner paramAppCompatSpinner3, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramButton1;
    this.d = paramButton2;
    this.f = paramButton3;
    this.q = paramButton4;
    this.x = paramButton5;
    this.y = paramButton6;
    this.z = paramChipGroup;
    this.p0 = paramRecyclerView1;
    this.p1 = paramRecyclerView2;
    this.p2 = paramRecyclerView3;
    this.p3 = paramRecyclerView4;
    this.H3 = paramSeekBar1;
    this.I3 = paramSeekBar2;
    this.J3 = paramSeekBar3;
    this.K3 = paramSeekBar4;
    this.L3 = paramSeekBar5;
    this.M3 = paramSeekBar6;
    this.N3 = paramSeekBar7;
    this.O3 = paramAppCompatSpinner1;
    this.P3 = paramAppCompatSpinner2;
    this.Q3 = paramAppCompatSpinner3;
    this.R3 = paramTextView;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
  
  public abstract void i(@Nullable LightingEffectDebugViewModel paramLightingEffectDebugViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityLightingEffectDebugBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */