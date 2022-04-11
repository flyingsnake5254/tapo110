package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;

public abstract class ItemSummaryClipTitleBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  
  protected ItemSummaryClipTitleBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ItemSummaryClipTitleBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */