package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.viewmodel.iotsensor.SensorDetailViewModel;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;

public abstract class ActivitySensorDetailContentBinding
  extends ViewDataBinding
{
  @NonNull
  public final RecyclerView H3;
  @NonNull
  public final TextView I3;
  @NonNull
  public final TextView J3;
  @NonNull
  public final TextView K3;
  @NonNull
  public final TextView L3;
  @Bindable
  protected View.OnClickListener M3;
  @Bindable
  protected SensorDetailViewModel N3;
  @NonNull
  public final CardView c;
  @NonNull
  public final CardView d;
  @NonNull
  public final FrameLayout f;
  @NonNull
  public final ImageView p0;
  @NonNull
  public final LinearLayout p1;
  @NonNull
  public final LinearLayout p2;
  @NonNull
  public final TPSmartRefreshLayout p3;
  @NonNull
  public final FrameLayout q;
  @NonNull
  public final ImageView x;
  @NonNull
  public final ImageView y;
  @NonNull
  public final ImageView z;
  
  protected ActivitySensorDetailContentBinding(Object paramObject, View paramView, int paramInt, CardView paramCardView1, CardView paramCardView2, FrameLayout paramFrameLayout1, FrameLayout paramFrameLayout2, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3, ImageView paramImageView4, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2, TPSmartRefreshLayout paramTPSmartRefreshLayout, RecyclerView paramRecyclerView, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, TextView paramTextView4)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramCardView1;
    this.d = paramCardView2;
    this.f = paramFrameLayout1;
    this.q = paramFrameLayout2;
    this.x = paramImageView1;
    this.y = paramImageView2;
    this.z = paramImageView3;
    this.p0 = paramImageView4;
    this.p1 = paramLinearLayout1;
    this.p2 = paramLinearLayout2;
    this.p3 = paramTPSmartRefreshLayout;
    this.H3 = paramRecyclerView;
    this.I3 = paramTextView1;
    this.J3 = paramTextView2;
    this.K3 = paramTextView3;
    this.L3 = paramTextView4;
  }
  
  public abstract void h(@Nullable SensorDetailViewModel paramSensorDetailViewModel);
  
  public abstract void i(@Nullable View.OnClickListener paramOnClickListener);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySensorDetailContentBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */