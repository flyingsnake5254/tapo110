package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

public abstract class FragmentCameraV2IntroduceVideoplayItemBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final LinearLayout d;
  @NonNull
  public final TextView f;
  @NonNull
  public final TextView q;
  @NonNull
  public final TextView x;
  
  protected FragmentCameraV2IntroduceVideoplayItemBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView, LinearLayout paramLinearLayout, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView;
    this.d = paramLinearLayout;
    this.f = paramTextView1;
    this.q = paramTextView2;
    this.x = paramTextView3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentCameraV2IntroduceVideoplayItemBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */