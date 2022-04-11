package com.google.android.material.slider;

import androidx.annotation.NonNull;
import java.util.Locale;

public final class BasicLabelFormatter
  implements LabelFormatter
{
  private static final int BILLION = 1000000000;
  private static final int MILLION = 1000000;
  private static final int THOUSAND = 1000;
  private static final long TRILLION = 1000000000000L;
  
  @NonNull
  public String getFormattedValue(float paramFloat)
  {
    if (paramFloat >= 1.0E12F) {
      return String.format(Locale.US, "%.1fT", new Object[] { Float.valueOf(paramFloat / 1.0E12F) });
    }
    if (paramFloat >= 1.0E9F) {
      return String.format(Locale.US, "%.1fB", new Object[] { Float.valueOf(paramFloat / 1.0E9F) });
    }
    if (paramFloat >= 1000000.0F) {
      return String.format(Locale.US, "%.1fM", new Object[] { Float.valueOf(paramFloat / 1000000.0F) });
    }
    if (paramFloat >= 1000.0F) {
      return String.format(Locale.US, "%.1fK", new Object[] { Float.valueOf(paramFloat / 1000.0F) });
    }
    return String.format(Locale.US, "%.0f", new Object[] { Float.valueOf(paramFloat) });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\slider\BasicLabelFormatter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */