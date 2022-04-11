package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.dailysummary.model.SummaryClipItem;

public abstract class ItemSummaryClipVideoBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final TextView q;
  @Bindable
  protected SummaryClipItem x;
  
  protected ItemSummaryClipVideoBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramImageView2;
    this.f = paramImageView3;
    this.q = paramTextView;
  }
  
  public abstract void h(@Nullable SummaryClipItem paramSummaryClipItem);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemSummaryClipVideoBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */