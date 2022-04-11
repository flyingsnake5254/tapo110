package com.tplink.iot.devices.lightstrip.lightingeffect.template;

import androidx.annotation.ColorInt;
import com.tplink.iot.devices.lightstrip.widget.multicolorpalette.c;
import kotlin.jvm.internal.j;

public final class PredefinedEffectsTemplateInputKt
{
  @ColorInt
  public static final int toColorInt(LEColor paramLEColor)
  {
    j.e(paramLEColor, "$this$toColorInt");
    return paramLEColor.toHSB().g();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\devices\lightstrip\lightingeffect\template\PredefinedEffectsTemplateInputKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */