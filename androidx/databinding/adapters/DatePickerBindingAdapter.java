package androidx.databinding.adapters;

import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethods;
import androidx.databinding.library.baseAdapters.R.id;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
@InverseBindingMethods({@androidx.databinding.InverseBindingMethod(attribute="android:year", type=DatePicker.class), @androidx.databinding.InverseBindingMethod(attribute="android:month", type=DatePicker.class), @androidx.databinding.InverseBindingMethod(attribute="android:day", method="getDayOfMonth", type=DatePicker.class)})
public class DatePickerBindingAdapter
{
  @BindingAdapter(requireAll=false, value={"android:year", "android:month", "android:day", "android:onDateChanged", "android:yearAttrChanged", "android:monthAttrChanged", "android:dayAttrChanged"})
  public static void setListeners(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3, DatePicker.OnDateChangedListener paramOnDateChangedListener, InverseBindingListener paramInverseBindingListener1, InverseBindingListener paramInverseBindingListener2, InverseBindingListener paramInverseBindingListener3)
  {
    int i = paramInt1;
    if (paramInt1 == 0) {
      i = paramDatePicker.getYear();
    }
    paramInt1 = paramInt3;
    if (paramInt3 == 0) {
      paramInt1 = paramDatePicker.getDayOfMonth();
    }
    if ((paramInverseBindingListener1 == null) && (paramInverseBindingListener2 == null) && (paramInverseBindingListener3 == null))
    {
      paramDatePicker.init(i, paramInt2, paramInt1, paramOnDateChangedListener);
    }
    else
    {
      paramInt3 = R.id.onDateChanged;
      DateChangedListener localDateChangedListener1 = (DateChangedListener)ListenerUtil.getListener(paramDatePicker, paramInt3);
      DateChangedListener localDateChangedListener2 = localDateChangedListener1;
      if (localDateChangedListener1 == null)
      {
        localDateChangedListener2 = new DateChangedListener(null);
        ListenerUtil.trackListener(paramDatePicker, localDateChangedListener2, paramInt3);
      }
      localDateChangedListener2.setListeners(paramOnDateChangedListener, paramInverseBindingListener1, paramInverseBindingListener2, paramInverseBindingListener3);
      paramDatePicker.init(i, paramInt2, paramInt1, localDateChangedListener2);
    }
  }
  
  private static class DateChangedListener
    implements DatePicker.OnDateChangedListener
  {
    InverseBindingListener mDayChanged;
    DatePicker.OnDateChangedListener mListener;
    InverseBindingListener mMonthChanged;
    InverseBindingListener mYearChanged;
    
    public void onDateChanged(DatePicker paramDatePicker, int paramInt1, int paramInt2, int paramInt3)
    {
      DatePicker.OnDateChangedListener localOnDateChangedListener = this.mListener;
      if (localOnDateChangedListener != null) {
        localOnDateChangedListener.onDateChanged(paramDatePicker, paramInt1, paramInt2, paramInt3);
      }
      paramDatePicker = this.mYearChanged;
      if (paramDatePicker != null) {
        paramDatePicker.onChange();
      }
      paramDatePicker = this.mMonthChanged;
      if (paramDatePicker != null) {
        paramDatePicker.onChange();
      }
      paramDatePicker = this.mDayChanged;
      if (paramDatePicker != null) {
        paramDatePicker.onChange();
      }
    }
    
    public void setListeners(DatePicker.OnDateChangedListener paramOnDateChangedListener, InverseBindingListener paramInverseBindingListener1, InverseBindingListener paramInverseBindingListener2, InverseBindingListener paramInverseBindingListener3)
    {
      this.mListener = paramOnDateChangedListener;
      this.mYearChanged = paramInverseBindingListener1;
      this.mMonthChanged = paramInverseBindingListener2;
      this.mDayChanged = paramInverseBindingListener3;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\adapters\DatePickerBindingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */