package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.widget.PointTextView;

public abstract class ActivityLightStripUserGuideBinding
  extends ViewDataBinding
{
  @NonNull
  public final Button c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final ImageView f;
  @Bindable
  protected View.OnClickListener p0;
  @NonNull
  public final PointTextView q;
  @NonNull
  public final PointTextView x;
  @NonNull
  public final PointTextView y;
  @NonNull
  public final PointTextView z;
  
  protected ActivityLightStripUserGuideBinding(Object paramObject, View paramView, int paramInt, Button paramButton, ImageView paramImageView1, ImageView paramImageView2, PointTextView paramPointTextView1, PointTextView paramPointTextView2, PointTextView paramPointTextView3, PointTextView paramPointTextView4)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramButton;
    this.d = paramImageView1;
    this.f = paramImageView2;
    this.q = paramPointTextView1;
    this.x = paramPointTextView2;
    this.y = paramPointTextView3;
    this.z = paramPointTextView4;
  }
  
  public abstract void h(@Nullable View.OnClickListener paramOnClickListener);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityLightStripUserGuideBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */