package androidx.databinding.adapters;

import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethods;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
@InverseBindingMethods({@androidx.databinding.InverseBindingMethod(attribute="android:checkedButton", method="getCheckedRadioButtonId", type=RadioGroup.class)})
public class RadioGroupBindingAdapter
{
  @BindingAdapter({"android:checkedButton"})
  public static void setCheckedButton(RadioGroup paramRadioGroup, int paramInt)
  {
    if (paramInt != paramRadioGroup.getCheckedRadioButtonId()) {
      paramRadioGroup.check(paramInt);
    }
  }
  
  @BindingAdapter(requireAll=false, value={"android:onCheckedChanged", "android:checkedButtonAttrChanged"})
  public static void setListeners(RadioGroup paramRadioGroup, RadioGroup.OnCheckedChangeListener paramOnCheckedChangeListener, final InverseBindingListener paramInverseBindingListener)
  {
    if (paramInverseBindingListener == null) {
      paramRadioGroup.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    } else {
      paramRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
      {
        public void onCheckedChanged(RadioGroup paramAnonymousRadioGroup, int paramAnonymousInt)
        {
          RadioGroup.OnCheckedChangeListener localOnCheckedChangeListener = this.val$listener;
          if (localOnCheckedChangeListener != null) {
            localOnCheckedChangeListener.onCheckedChanged(paramAnonymousRadioGroup, paramAnonymousInt);
          }
          paramInverseBindingListener.onChange();
        }
      });
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\adapters\RadioGroupBindingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */