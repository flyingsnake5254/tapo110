package com.tplink.iot.dailysummary.view.viewhodlder;

import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.tplink.iot.databinding.ItemSummaryClipTitleBinding;
import kotlin.jvm.internal.j;

public final class SummaryClipTitleViewHolder
  extends RecyclerView.ViewHolder
{
  private final ItemSummaryClipTitleBinding a;
  private final TextView b;
  
  public SummaryClipTitleViewHolder(ItemSummaryClipTitleBinding paramItemSummaryClipTitleBinding)
  {
    super(paramItemSummaryClipTitleBinding.getRoot());
    this.a = paramItemSummaryClipTitleBinding;
    paramItemSummaryClipTitleBinding = paramItemSummaryClipTitleBinding.c;
    j.d(paramItemSummaryClipTitleBinding, "mBinding.tvTitle");
    this.b = paramItemSummaryClipTitleBinding;
  }
  
  public final void c(String paramString)
  {
    j.e(paramString, "title");
    this.b.setText(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\dailysummary\view\viewhodlder\SummaryClipTitleViewHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */