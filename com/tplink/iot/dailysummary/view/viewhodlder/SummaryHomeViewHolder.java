package com.tplink.iot.dailysummary.view.viewhodlder;

import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.dailysummary.model.b;
import com.tplink.iot.dailysummary.viewmodel.DailySummaryViewModel;
import com.tplink.iot.databinding.ItemSummaryHomeBinding;
import kotlin.jvm.internal.j;

public final class SummaryHomeViewHolder
  extends RecyclerView.ViewHolder
{
  private ItemSummaryHomeBinding a;
  
  public SummaryHomeViewHolder(View paramView)
  {
    super(paramView);
  }
  
  public SummaryHomeViewHolder(ItemSummaryHomeBinding paramItemSummaryHomeBinding)
  {
    this(localView);
    this.a = paramItemSummaryHomeBinding;
  }
  
  public final void c(b paramb, DailySummaryViewModel paramDailySummaryViewModel)
  {
    j.e(paramb, "summary");
    j.e(paramDailySummaryViewModel, "viewModel");
    ItemSummaryHomeBinding localItemSummaryHomeBinding = this.a;
    if (localItemSummaryHomeBinding != null)
    {
      localItemSummaryHomeBinding.h(paramb);
      localItemSummaryHomeBinding.i(paramDailySummaryViewModel);
      localItemSummaryHomeBinding.executePendingBindings();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\view\viewhodlder\SummaryHomeViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */