package androidx.databinding.adapters;

import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethods;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethods;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
@BindingMethods({@androidx.databinding.BindingMethod(attribute="android:buttonTint", method="setButtonTintList", type=CompoundButton.class), @androidx.databinding.BindingMethod(attribute="android:onCheckedChanged", method="setOnCheckedChangeListener", type=CompoundButton.class)})
@InverseBindingMethods({@androidx.databinding.InverseBindingMethod(attribute="android:checked", type=CompoundButton.class)})
public class CompoundButtonBindingAdapter
{
  @BindingAdapter({"android:checked"})
  public static void setChecked(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (paramCompoundButton.isChecked() != paramBoolean) {
      paramCompoundButton.setChecked(paramBoolean);
    }
  }
  
  @BindingAdapter(requireAll=false, value={"android:onCheckedChanged", "android:checkedAttrChanged"})
  public static void setListeners(CompoundButton paramCompoundButton, CompoundButton.OnCheckedChangeListener paramOnCheckedChangeListener, final InverseBindingListener paramInverseBindingListener)
  {
    if (paramInverseBindingListener == null) {
      paramCompoundButton.setOnCheckedChangeListener(paramOnCheckedChangeListener);
    } else {
      paramCompoundButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
      {
        public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
        {
          CompoundButton.OnCheckedChangeListener localOnCheckedChangeListener = this.val$listener;
          if (localOnCheckedChangeListener != null) {
            localOnCheckedChangeListener.onCheckedChanged(paramAnonymousCompoundButton, paramAnonymousBoolean);
          }
          paramInverseBindingListener.onChange();
        }
      });
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\adapters\CompoundButtonBindingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */