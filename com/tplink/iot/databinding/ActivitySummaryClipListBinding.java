package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.exoplayer2.ui.PlayerView;
import com.tplink.iot.dailysummary.viewmodel.SummaryClipListViewModel;

public abstract class ActivitySummaryClipListBinding
  extends ViewDataBinding
{
  @Nullable
  public final ImageView c;
  @Nullable
  public final ImageView d;
  @Nullable
  public final ImageView f;
  @NonNull
  public final PlayerView p0;
  @Nullable
  public final RecyclerView p1;
  @Bindable
  protected SummaryClipListViewModel p2;
  @Nullable
  public final ImageView q;
  @NonNull
  public final ConstraintLayout x;
  @Nullable
  public final ConstraintLayout y;
  @Nullable
  public final LinearLayout z;
  
  protected ActivitySummaryClipListBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3, ImageView paramImageView4, ConstraintLayout paramConstraintLayout1, ConstraintLayout paramConstraintLayout2, LinearLayout paramLinearLayout, PlayerView paramPlayerView, RecyclerView paramRecyclerView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramImageView2;
    this.f = paramImageView3;
    this.q = paramImageView4;
    this.x = paramConstraintLayout1;
    this.y = paramConstraintLayout2;
    this.z = paramLinearLayout;
    this.p0 = paramPlayerView;
    this.p1 = paramRecyclerView;
  }
  
  public abstract void h(@Nullable SummaryClipListViewModel paramSummaryClipListViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivitySummaryClipListBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */