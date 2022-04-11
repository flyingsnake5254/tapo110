package com.tplink.iot.view.ipcamera.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.BindingAdapter;
import com.tplink.iot.Utils.c0;

public class ScheduleWeekdayTextView
  extends AppCompatTextView
{
  public ScheduleWeekdayTextView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ScheduleWeekdayTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ScheduleWeekdayTextView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  @BindingAdapter({"android:days"})
  public static void b(ScheduleWeekdayTextView paramScheduleWeekdayTextView, int paramInt)
  {
    paramScheduleWeekdayTextView.setDays(paramInt);
  }
  
  public void setDays(int paramInt)
  {
    setText(c0.b(getContext(), paramInt, true));
    if (paramInt == 0) {
      setTextColor(51968);
    } else {
      setTextColor(-13421773);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\ipcamera\widget\ScheduleWeekdayTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */