package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devicecommon.widget.VariousImageViewLayout;
import com.tplink.iot.widget.PointTextView;

public abstract class FragmentSubgLedNotBlinkingHelpBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final VariousImageViewLayout d;
  @NonNull
  public final LinearLayout f;
  @NonNull
  public final PointTextView p0;
  @NonNull
  public final LinearLayout q;
  @NonNull
  public final TextView x;
  @NonNull
  public final PointTextView y;
  @NonNull
  public final PointTextView z;
  
  protected FragmentSubgLedNotBlinkingHelpBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView, VariousImageViewLayout paramVariousImageViewLayout, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2, TextView paramTextView, PointTextView paramPointTextView1, PointTextView paramPointTextView2, PointTextView paramPointTextView3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView;
    this.d = paramVariousImageViewLayout;
    this.f = paramLinearLayout1;
    this.q = paramLinearLayout2;
    this.x = paramTextView;
    this.y = paramPointTextView1;
    this.z = paramPointTextView2;
    this.p0 = paramPointTextView3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentSubgLedNotBlinkingHelpBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */