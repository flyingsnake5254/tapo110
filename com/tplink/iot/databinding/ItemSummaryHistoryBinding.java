package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.dailysummary.model.b;
import com.tplink.iot.dailysummary.viewmodel.SummaryHistoryViewModel;

public abstract class ItemSummaryHistoryBinding
  extends ViewDataBinding
{
  @Bindable
  protected b H3;
  @NonNull
  public final TextView c;
  @NonNull
  public final TextView d;
  @NonNull
  public final TextView f;
  @NonNull
  public final TextView p0;
  @NonNull
  public final TextView p1;
  @NonNull
  public final TextView p2;
  @Bindable
  protected SummaryHistoryViewModel p3;
  @NonNull
  public final CardView q;
  @NonNull
  public final Guideline x;
  @NonNull
  public final ImageView y;
  @NonNull
  public final CardView z;
  
  protected ItemSummaryHistoryBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3, CardView paramCardView1, Guideline paramGuideline, ImageView paramImageView, CardView paramCardView2, TextView paramTextView4, TextView paramTextView5, TextView paramTextView6)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView1;
    this.d = paramTextView2;
    this.f = paramTextView3;
    this.q = paramCardView1;
    this.x = paramGuideline;
    this.y = paramImageView;
    this.z = paramCardView2;
    this.p0 = paramTextView4;
    this.p1 = paramTextView5;
    this.p2 = paramTextView6;
  }
  
  public abstract void h(@Nullable b paramb);
  
  public abstract void i(@Nullable SummaryHistoryViewModel paramSummaryHistoryViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemSummaryHistoryBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */