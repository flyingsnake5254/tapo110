package androidx.databinding.adapters;

import android.annotation.TargetApi;
import android.widget.Switch;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethods;

@TargetApi(14)
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
@BindingMethods({@androidx.databinding.BindingMethod(attribute="android:thumb", method="setThumbDrawable", type=Switch.class), @androidx.databinding.BindingMethod(attribute="android:track", method="setTrackDrawable", type=Switch.class)})
public class SwitchBindingAdapter
{
  @BindingAdapter({"android:switchTextAppearance"})
  public static void setSwitchTextAppearance(Switch paramSwitch, int paramInt)
  {
    paramSwitch.setSwitchTextAppearance(null, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\adapters\SwitchBindingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */