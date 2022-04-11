package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devices.trv.viewmodel.TRVDetailViewModel;
import com.tplink.iot.widget.businessview.ThingNextEventView;

public abstract class LayoutTrvDetailBottomExtBinding
  extends ViewDataBinding
{
  @NonNull
  public final ImageView c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final ImageView f;
  @NonNull
  public final TextView p0;
  @NonNull
  public final TextView p1;
  @Bindable
  protected View.OnClickListener p2;
  @Bindable
  protected TRVDetailViewModel p3;
  @NonNull
  public final LinearLayout q;
  @NonNull
  public final LinearLayout x;
  @NonNull
  public final ThingNextEventView y;
  @NonNull
  public final TextView z;
  
  protected LayoutTrvDetailBottomExtBinding(Object paramObject, View paramView, int paramInt, ImageView paramImageView1, ImageView paramImageView2, ImageView paramImageView3, LinearLayout paramLinearLayout1, LinearLayout paramLinearLayout2, ThingNextEventView paramThingNextEventView, TextView paramTextView1, TextView paramTextView2, TextView paramTextView3)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramImageView1;
    this.d = paramImageView2;
    this.f = paramImageView3;
    this.q = paramLinearLayout1;
    this.x = paramLinearLayout2;
    this.y = paramThingNextEventView;
    this.z = paramTextView1;
    this.p0 = paramTextView2;
    this.p1 = paramTextView3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutTrvDetailBottomExtBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */