package androidx.databinding.adapters;

import android.widget.AutoCompleteTextView;
import android.widget.AutoCompleteTextView.Validator;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethods;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
@BindingMethods({@androidx.databinding.BindingMethod(attribute="android:completionThreshold", method="setThreshold", type=AutoCompleteTextView.class), @androidx.databinding.BindingMethod(attribute="android:popupBackground", method="setDropDownBackgroundDrawable", type=AutoCompleteTextView.class), @androidx.databinding.BindingMethod(attribute="android:onDismiss", method="setOnDismissListener", type=AutoCompleteTextView.class), @androidx.databinding.BindingMethod(attribute="android:onItemClick", method="setOnItemClickListener", type=AutoCompleteTextView.class)})
public class AutoCompleteTextViewBindingAdapter
{
  @BindingAdapter(requireAll=false, value={"android:onItemSelected", "android:onNothingSelected"})
  public static void setOnItemSelectedListener(AutoCompleteTextView paramAutoCompleteTextView, AdapterViewBindingAdapter.OnItemSelected paramOnItemSelected, AdapterViewBindingAdapter.OnNothingSelected paramOnNothingSelected)
  {
    if ((paramOnItemSelected == null) && (paramOnNothingSelected == null)) {
      paramAutoCompleteTextView.setOnItemSelectedListener(null);
    } else {
      paramAutoCompleteTextView.setOnItemSelectedListener(new AdapterViewBindingAdapter.OnItemSelectedComponentListener(paramOnItemSelected, paramOnNothingSelected, null));
    }
  }
  
  @BindingAdapter(requireAll=false, value={"android:fixText", "android:isValid"})
  public static void setValidator(AutoCompleteTextView paramAutoCompleteTextView, final FixText paramFixText, IsValid paramIsValid)
  {
    if ((paramFixText == null) && (paramIsValid == null)) {
      paramAutoCompleteTextView.setValidator(null);
    } else {
      paramAutoCompleteTextView.setValidator(new AutoCompleteTextView.Validator()
      {
        public CharSequence fixText(CharSequence paramAnonymousCharSequence)
        {
          AutoCompleteTextViewBindingAdapter.FixText localFixText = paramFixText;
          CharSequence localCharSequence = paramAnonymousCharSequence;
          if (localFixText != null) {
            localCharSequence = localFixText.fixText(paramAnonymousCharSequence);
          }
          return localCharSequence;
        }
        
        public boolean isValid(CharSequence paramAnonymousCharSequence)
        {
          AutoCompleteTextViewBindingAdapter.IsValid localIsValid = this.val$isValid;
          if (localIsValid != null) {
            return localIsValid.isValid(paramAnonymousCharSequence);
          }
          return true;
        }
      });
    }
  }
  
  public static abstract interface FixText
  {
    public abstract CharSequence fixText(CharSequence paramCharSequence);
  }
  
  public static abstract interface IsValid
  {
    public abstract boolean isValid(CharSequence paramCharSequence);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\adapters\AutoCompleteTextViewBindingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */