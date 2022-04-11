package androidx.databinding.adapters;

import android.os.Build.VERSION;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingAdapter;
import androidx.databinding.InverseBindingListener;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class TimePickerBindingAdapter
{
  @InverseBindingAdapter(attribute="android:hour")
  public static int getHour(TimePicker paramTimePicker)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramTimePicker.getHour();
    }
    paramTimePicker = paramTimePicker.getCurrentHour();
    if (paramTimePicker == null) {
      return 0;
    }
    return paramTimePicker.intValue();
  }
  
  @InverseBindingAdapter(attribute="android:minute")
  public static int getMinute(TimePicker paramTimePicker)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramTimePicker.getMinute();
    }
    paramTimePicker = paramTimePicker.getCurrentMinute();
    if (paramTimePicker == null) {
      return 0;
    }
    return paramTimePicker.intValue();
  }
  
  @BindingAdapter({"android:hour"})
  public static void setHour(TimePicker paramTimePicker, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (paramTimePicker.getHour() != paramInt) {
        paramTimePicker.setHour(paramInt);
      }
    }
    else if (paramTimePicker.getCurrentHour().intValue() != paramInt) {
      paramTimePicker.setCurrentHour(Integer.valueOf(paramInt));
    }
  }
  
  @BindingAdapter(requireAll=false, value={"android:onTimeChanged", "android:hourAttrChanged", "android:minuteAttrChanged"})
  public static void setListeners(TimePicker paramTimePicker, TimePicker.OnTimeChangedListener paramOnTimeChangedListener, final InverseBindingListener paramInverseBindingListener1, final InverseBindingListener paramInverseBindingListener2)
  {
    if ((paramInverseBindingListener1 == null) && (paramInverseBindingListener2 == null)) {
      paramTimePicker.setOnTimeChangedListener(paramOnTimeChangedListener);
    } else {
      paramTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener()
      {
        public void onTimeChanged(TimePicker paramAnonymousTimePicker, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          TimePicker.OnTimeChangedListener localOnTimeChangedListener = this.val$listener;
          if (localOnTimeChangedListener != null) {
            localOnTimeChangedListener.onTimeChanged(paramAnonymousTimePicker, paramAnonymousInt1, paramAnonymousInt2);
          }
          paramAnonymousTimePicker = paramInverseBindingListener1;
          if (paramAnonymousTimePicker != null) {
            paramAnonymousTimePicker.onChange();
          }
          paramAnonymousTimePicker = paramInverseBindingListener2;
          if (paramAnonymousTimePicker != null) {
            paramAnonymousTimePicker.onChange();
          }
        }
      });
    }
  }
  
  @BindingAdapter({"android:minute"})
  public static void setMinute(TimePicker paramTimePicker, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (paramTimePicker.getMinute() != paramInt) {
        paramTimePicker.setMinute(paramInt);
      }
    }
    else if (paramTimePicker.getCurrentMinute().intValue() != paramInt) {
      paramTimePicker.setCurrentHour(Integer.valueOf(paramInt));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\adapters\TimePickerBindingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */