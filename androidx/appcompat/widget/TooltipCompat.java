package androidx.appcompat.widget;

import android.os.Build.VERSION;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class TooltipCompat
{
  public static void setTooltipText(@NonNull View paramView, @Nullable CharSequence paramCharSequence)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      paramView.setTooltipText(paramCharSequence);
    } else {
      TooltipCompatHandler.setTooltipText(paramView, paramCharSequence);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\TooltipCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */