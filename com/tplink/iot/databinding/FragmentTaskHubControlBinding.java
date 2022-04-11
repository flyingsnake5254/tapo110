package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class FragmentTaskHubControlBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView H3;
  @NonNull
  public final ImageView c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final LinearLayout p0;
  @NonNull
  public final RecyclerView p1;
  @NonNull
  public final TextView p2;
  @NonNull
  public final TextView p3;
  @NonNull
  public final RelativeLayout q;
  @NonNull
  public final RelativeLayout x;
  @NonNull
  public final RelativeLayout y;
  @NonNull
  public final FrameLayout z;
  
  protected FragmentTaskHubControlBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3, RelativeLayout paramRelativeLayout1, RelativeLayout paramRelativeLayout2, RelativeLayout paramRelativeLayout3, FrameLayout paramFrameLayout, LinearLayout paramLinearLayout, RecyclerView paramRecyclerView, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramImageView2;
    this.f = paramImageView3;
    this.q = paramRelativeLayout1;
    this.x = paramRelativeLayout2;
    this.y = paramRelativeLayout3;
    this.z = paramFrameLayout;
    this.p0 = paramLinearLayout;
    this.p1 = paramRecyclerView;
    this.p2 = paramTextView1;
    this.p3 = paramTextView2;
    this.H3 = paramTextView3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\FragmentTaskHubControlBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */