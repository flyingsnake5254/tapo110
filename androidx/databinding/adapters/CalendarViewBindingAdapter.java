package androidx.databinding.adapters;

import android.widget.CalendarView;
import android.widget.CalendarView.OnDateChangeListener;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethods;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
@InverseBindingMethods({@androidx.databinding.InverseBindingMethod(attribute="android:date", type=CalendarView.class)})
public class CalendarViewBindingAdapter
{
  @BindingAdapter({"android:date"})
  public static void setDate(CalendarView paramCalendarView, long paramLong)
  {
    if (paramCalendarView.getDate() != paramLong) {
      paramCalendarView.setDate(paramLong);
    }
  }
  
  @BindingAdapter(requireAll=false, value={"android:onSelectedDayChange", "android:dateAttrChanged"})
  public static void setListeners(CalendarView paramCalendarView, CalendarView.OnDateChangeListener paramOnDateChangeListener, final InverseBindingListener paramInverseBindingListener)
  {
    if (paramInverseBindingListener == null) {
      paramCalendarView.setOnDateChangeListener(paramOnDateChangeListener);
    } else {
      paramCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener()
      {
        public void onSelectedDayChange(CalendarView paramAnonymousCalendarView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          CalendarView.OnDateChangeListener localOnDateChangeListener = this.val$onDayChange;
          if (localOnDateChangeListener != null) {
            localOnDateChangeListener.onSelectedDayChange(paramAnonymousCalendarView, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3);
          }
          paramInverseBindingListener.onChange();
        }
      });
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\adapters\CalendarViewBindingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */