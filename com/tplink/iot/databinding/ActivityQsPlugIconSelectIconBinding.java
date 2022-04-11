package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.tplink.libtpcontrols.tprefreshablebutton.TPRefreshableButton;

public abstract class ActivityQsPlugIconSelectIconBinding
  extends ViewDataBinding
{
  @NonNull
  public final TPRefreshableButton c;
  @NonNull
  public final RecyclerView d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final LinearLayout q;
  @NonNull
  public final TextView x;
  
  protected ActivityQsPlugIconSelectIconBinding(Object paramObject, View paramView, int paramInt, TPRefreshableButton paramTPRefreshableButton, RecyclerView paramRecyclerView, ImageView paramImageView, LinearLayout paramLinearLayout, TextView paramTextView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTPRefreshableButton;
    this.d = paramRecyclerView;
    this.f = paramImageView;
    this.q = paramLinearLayout;
    this.x = paramTextView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\ActivityQsPlugIconSelectIconBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */