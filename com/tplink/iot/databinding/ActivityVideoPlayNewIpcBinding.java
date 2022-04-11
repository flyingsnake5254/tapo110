package com.tplink.iot.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.tipsbar.TipsBar;
import com.tplink.iot.viewmodel.ipcamera.play.VideoPlayViewModel;

public abstract class ActivityVideoPlayNewIpcBinding
  extends ViewDataBinding
{
  @NonNull
  public final FrameLayout H3;
  @Bindable
  protected VideoPlayViewModel I3;
  @NonNull
  public final FrameLayout c;
  @NonNull
  public final FrameLayout d;
  @NonNull
  public final FrameLayout f;
  @NonNull
  public final TextView p0;
  @NonNull
  public final TextView p1;
  @NonNull
  public final Toolbar p2;
  @NonNull
  public final View p3;
  @NonNull
  public final TipsBar q;
  @NonNull
  public final RelativeLayout x;
  @NonNull
  public final ConstraintLayout y;
  @NonNull
  public final ImageView z;
  
  protected ActivityVideoPlayNewIpcBinding(Object paramObject, View paramView1, int paramInt, FrameLayout paramFrameLayout1, FrameLayout paramFrameLayout2, FrameLayout paramFrameLayout3, TipsBar paramTipsBar, RelativeLayout paramRelativeLayout, ConstraintLayout paramConstraintLayout, ImageView paramImageView, TextView paramTextView1, TextView paramTextView2, Toolbar paramToolbar, View paramView2, FrameLayout paramFrameLayout4)
  {
    super(paramObject, paramView1, paramInt);
    this.c = paramFrameLayout1;
    this.d = paramFrameLayout2;
    this.f = paramFrameLayout3;
    this.q = paramTipsBar;
    this.x = paramRelativeLayout;
    this.y = paramConstraintLayout;
    this.z = paramImageView;
    this.p0 = paramTextView1;
    this.p1 = paramTextView2;
    this.p2 = paramToolbar;
    this.p3 = paramView2;
    this.H3 = paramFrameLayout4;
  }
  
  public abstract void h(@Nullable VideoPlayViewModel paramVideoPlayViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityVideoPlayNewIpcBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */