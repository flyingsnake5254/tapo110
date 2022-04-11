package androidx.databinding.adapters;

import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethods;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethods;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
@BindingMethods({@androidx.databinding.BindingMethod(attribute="android:format", method="setFormatter", type=NumberPicker.class), @androidx.databinding.BindingMethod(attribute="android:onScrollStateChange", method="setOnScrollListener", type=NumberPicker.class)})
@InverseBindingMethods({@androidx.databinding.InverseBindingMethod(attribute="android:value", type=NumberPicker.class)})
public class NumberPickerBindingAdapter
{
  @BindingAdapter(requireAll=false, value={"android:onValueChange", "android:valueAttrChanged"})
  public static void setListeners(NumberPicker paramNumberPicker, NumberPicker.OnValueChangeListener paramOnValueChangeListener, final InverseBindingListener paramInverseBindingListener)
  {
    if (paramInverseBindingListener == null) {
      paramNumberPicker.setOnValueChangedListener(paramOnValueChangeListener);
    } else {
      paramNumberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener()
      {
        public void onValueChange(NumberPicker paramAnonymousNumberPicker, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          NumberPicker.OnValueChangeListener localOnValueChangeListener = this.val$listener;
          if (localOnValueChangeListener != null) {
            localOnValueChangeListener.onValueChange(paramAnonymousNumberPicker, paramAnonymousInt1, paramAnonymousInt2);
          }
          paramInverseBindingListener.onChange();
        }
      });
    }
  }
  
  @BindingAdapter({"android:value"})
  public static void setValue(NumberPicker paramNumberPicker, int paramInt)
  {
    if (paramNumberPicker.getValue() != paramInt) {
      paramNumberPicker.setValue(paramInt);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\adapters\NumberPickerBindingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */