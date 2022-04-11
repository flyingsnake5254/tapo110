package com.tplink.iot.databinding;

import android.view.View;
import android.view.View.OnClickListener;
import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.devices.lightstrip.viewmodel.LightStripDetailViewModel;
import com.tplink.iot.widget.businessview.ThingNextEventView;
import com.tplink.iot.widget.businessview.ThingUsageView;
import com.tplink.iot.widget.viewgroup.MultiFeaturesGridView;

public abstract class LayoutLightStripDetailBottomExtBinding
  extends ViewDataBinding
{
  @NonNull
  public final MultiFeaturesGridView c;
  @NonNull
  public final ThingNextEventView d;
  @NonNull
  public final ThingUsageView f;
  @Bindable
  protected View.OnClickListener q;
  @Bindable
  protected LightStripDetailViewModel x;
  
  protected LayoutLightStripDetailBottomExtBinding(Object paramObject, View paramView, int paramInt, MultiFeaturesGridView paramMultiFeaturesGridView, ThingNextEventView paramThingNextEventView, ThingUsageView paramThingUsageView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramMultiFeaturesGridView;
    this.d = paramThingNextEventView;
    this.f = paramThingUsageView;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutLightStripDetailBottomExtBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */