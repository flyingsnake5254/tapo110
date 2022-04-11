package com.tplink.iot.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.base.g;
import com.tplink.iot.view.ipcamera.widget.calendar.WeekdayView;
import com.tplink.iot.view.ipcamera.widget.calendar.b;
import com.tplink.iot.view.ipcamera.widget.calendar.c;
import com.tplink.iot.view.ipcamera.widget.calendar.scrollCalendar.ScrollCalendar;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;

public abstract class LayoutPlayBackFullscreenCalendarBinding
  extends ViewDataBinding
{
  @NonNull
  public final TextView c;
  @NonNull
  public final ImageView d;
  @NonNull
  public final ImageView f;
  @Bindable
  protected b p0;
  @Bindable
  protected PlayBackControlViewModel p1;
  @Bindable
  protected c p2;
  @NonNull
  public final TextView q;
  @NonNull
  public final ScrollCalendar x;
  @NonNull
  public final WeekdayView y;
  @Bindable
  protected g z;
  
  protected LayoutPlayBackFullscreenCalendarBinding(Object paramObject, View paramView, int paramInt, TextView paramTextView1, ImageView paramImageView1, ImageView paramImageView2, TextView paramTextView2, ScrollCalendar paramScrollCalendar, WeekdayView paramWeekdayView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramTextView1;
    this.d = paramImageView1;
    this.f = paramImageView2;
    this.q = paramTextView2;
    this.x = paramScrollCalendar;
    this.y = paramWeekdayView;
  }
  
  public abstract void h(@Nullable b paramb);
  
  public abstract void i(@Nullable c paramc);
  
  public abstract void l(@Nullable g paramg);
  
  public abstract void m(@Nullable PlayBackControlViewModel paramPlayBackControlViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\LayoutPlayBackFullscreenCalendarBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */