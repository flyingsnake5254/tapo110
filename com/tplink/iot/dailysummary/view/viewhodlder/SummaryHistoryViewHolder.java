package com.tplink.iot.dailysummary.view.viewhodlder;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.dailysummary.model.b;
import com.tplink.iot.dailysummary.viewmodel.SummaryHistoryViewModel;
import com.tplink.iot.databinding.ItemSummaryHistoryBinding;
import kotlin.jvm.internal.j;

public final class SummaryHistoryViewHolder
  extends RecyclerView.ViewHolder
{
  private ItemSummaryHistoryBinding a;
  
  public SummaryHistoryViewHolder(ItemSummaryHistoryBinding paramItemSummaryHistoryBinding)
  {
    super(paramItemSummaryHistoryBinding.getRoot());
    this.a = paramItemSummaryHistoryBinding;
  }
  
  public final void c(b paramb, SummaryHistoryViewModel paramSummaryHistoryViewModel)
  {
    j.e(paramb, "summary");
    j.e(paramSummaryHistoryViewModel, "viewModel");
    ItemSummaryHistoryBinding localItemSummaryHistoryBinding = this.a;
    localItemSummaryHistoryBinding.h(paramb);
    localItemSummaryHistoryBinding.i(paramSummaryHistoryViewModel);
    localItemSummaryHistoryBinding.executePendingBindings();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\view\viewhodlder\SummaryHistoryViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */