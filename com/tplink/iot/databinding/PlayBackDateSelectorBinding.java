package com.tplink.iot.databinding;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.ViewDataBinding;
import com.tplink.iot.view.ipcamera.widget.calendar.WeekdayView;
import com.tplink.iot.view.ipcamera.widget.calendar.b;
import com.tplink.iot.view.ipcamera.widget.calendar.c;
import com.tplink.iot.view.ipcamera.widget.calendar.scrollCalendar.ScrollCalendar;
import com.tplink.iot.viewmodel.ipcamera.play.PlayBackControlViewModel;

public abstract class PlayBackDateSelectorBinding
  extends ViewDataBinding
{
  @NonNull
  public final ScrollCalendar c;
  @NonNull
  public final WeekdayView d;
  @Bindable
  protected b f;
  @Bindable
  protected PlayBackControlViewModel q;
  @Bindable
  protected c x;
  
  protected PlayBackDateSelectorBinding(Object paramObject, View paramView, int paramInt, ScrollCalendar paramScrollCalendar, WeekdayView paramWeekdayView)
  {
    super(paramObject, paramView, paramInt);
    this.c = paramScrollCalendar;
    this.d = paramWeekdayView;
  }
  
  public abstract void h(@Nullable b paramb);
  
  public abstract void i(@Nullable c paramc);
  
  public abstract void l(@Nullable PlayBackControlViewModel paramPlayBackControlViewModel);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\databinding\PlayBackDateSelectorBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */