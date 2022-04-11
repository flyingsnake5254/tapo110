package com.tplink.iot.dailysummary.view.viewhodlder;

import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.dailysummary.model.SummaryClipItem;
import com.tplink.iot.databinding.ItemSummaryClipVideoBinding;
import kotlin.jvm.internal.j;

public final class SummaryClipVideoViewHolder
  extends RecyclerView.ViewHolder
{
  private final ItemSummaryClipVideoBinding a;
  
  public SummaryClipVideoViewHolder(ItemSummaryClipVideoBinding paramItemSummaryClipVideoBinding)
  {
    super(paramItemSummaryClipVideoBinding.getRoot());
    this.a = paramItemSummaryClipVideoBinding;
  }
  
  public final void c(SummaryClipItem paramSummaryClipItem)
  {
    j.e(paramSummaryClipItem, "clipItem");
    ItemSummaryClipVideoBinding localItemSummaryClipVideoBinding = this.a;
    localItemSummaryClipVideoBinding.h(paramSummaryClipItem);
    localItemSummaryClipVideoBinding.executePendingBindings();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\view\viewhodlder\SummaryClipVideoViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */