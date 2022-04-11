package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.dailysummary.widget.SummaryTimeAxisHorizontalScrollView;
import com.tplink.iot.dailysummary.widget.SummaryTimeAxisScaleView;

public abstract class LayoutSummaryTimeAxisBinding
  extends ViewDataBinding
{
  @NonNull
  public final SummaryTimeAxisScaleView c;
  @NonNull
  public final SummaryTimeAxisHorizontalScrollView d;
  
  protected LayoutSummaryTimeAxisBinding(Object paramObject, View paramView, int paramInt, SummaryTimeAxisScaleView paramSummaryTimeAxisScaleView, SummaryTimeAxisHorizontalScrollView paramSummaryTimeAxisHorizontalScrollView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramSummaryTimeAxisScaleView;
    this.d = paramSummaryTimeAxisHorizontalScrollView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutSummaryTimeAxisBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */