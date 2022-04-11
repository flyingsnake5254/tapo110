package androidx.databinding.adapters;

import androidx.annotation.RestrictTo;
import androidx.appcompat.widget.SwitchCompat;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethods;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
@BindingMethods({@androidx.databinding.BindingMethod(attribute="android:thumb", method="setThumbDrawable", type=SwitchCompat.class), @androidx.databinding.BindingMethod(attribute="android:track", method="setTrackDrawable", type=SwitchCompat.class)})
public class SwitchCompatBindingAdapter
{
  @BindingAdapter({"android:switchTextAppearance"})
  public static void setSwitchTextAppearance(SwitchCompat paramSwitchCompat, int paramInt)
  {
    paramSwitchCompat.setSwitchTextAppearance(null, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\adapters\SwitchCompatBindingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */