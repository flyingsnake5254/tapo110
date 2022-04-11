package com.tplink.iot.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.iot.widget.refreshlayout.TPSmartRefreshLayout;

public abstract class ActivityHubAlarmLogBinding
  extends ViewDataBinding
{
  @NonNull
  public final RecyclerView c;
  @NonNull
  public final TPSmartRefreshLayout d;
  @NonNull
  public final TextView f;
  
  protected ActivityHubAlarmLogBinding(Object paramObject, View paramView, int paramInt, RecyclerView paramRecyclerView, TPSmartRefreshLayout paramTPSmartRefreshLayout, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramRecyclerView;
    this.d = paramTPSmartRefreshLayout;
    this.f = paramTextView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityHubAlarmLogBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */