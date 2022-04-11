package androidx.databinding.adapters;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import androidx.databinding.BindingConversion;

public class Converters
{
  @BindingConversion
  public static ColorStateList convertColorToColorStateList(int paramInt)
  {
    return ColorStateList.valueOf(paramInt);
  }
  
  @BindingConversion
  public static ColorDrawable convertColorToDrawable(int paramInt)
  {
    return new ColorDrawable(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\adapters\Converters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */