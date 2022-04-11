package androidx.core.graphics;

import android.graphics.Color;
import android.graphics.ColorSpace;
import android.graphics.ColorSpace.Named;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.j;

public final class ColorKt
{
  @RequiresApi(26)
  public static final float component1(long paramLong)
  {
    return Color.red(paramLong);
  }
  
  @RequiresApi(26)
  public static final float component1(Color paramColor)
  {
    j.f(paramColor, "$this$component1");
    return paramColor.getComponent(0);
  }
  
  public static final int component1(@ColorInt int paramInt)
  {
    return paramInt >> 24 & 0xFF;
  }
  
  @RequiresApi(26)
  public static final float component2(long paramLong)
  {
    return Color.green(paramLong);
  }
  
  @RequiresApi(26)
  public static final float component2(Color paramColor)
  {
    j.f(paramColor, "$this$component2");
    return paramColor.getComponent(1);
  }
  
  public static final int component2(@ColorInt int paramInt)
  {
    return paramInt >> 16 & 0xFF;
  }
  
  @RequiresApi(26)
  public static final float component3(long paramLong)
  {
    return Color.blue(paramLong);
  }
  
  @RequiresApi(26)
  public static final float component3(Color paramColor)
  {
    j.f(paramColor, "$this$component3");
    return paramColor.getComponent(2);
  }
  
  public static final int component3(@ColorInt int paramInt)
  {
    return paramInt >> 8 & 0xFF;
  }
  
  @RequiresApi(26)
  public static final float component4(long paramLong)
  {
    return Color.alpha(paramLong);
  }
  
  @RequiresApi(26)
  public static final float component4(Color paramColor)
  {
    j.f(paramColor, "$this$component4");
    return paramColor.getComponent(3);
  }
  
  public static final int component4(@ColorInt int paramInt)
  {
    return paramInt & 0xFF;
  }
  
  @RequiresApi(26)
  public static final long convertTo(@ColorInt int paramInt, ColorSpace.Named paramNamed)
  {
    j.f(paramNamed, "colorSpace");
    return Color.convert(paramInt, ColorSpace.get(paramNamed));
  }
  
  @RequiresApi(26)
  public static final long convertTo(@ColorInt int paramInt, ColorSpace paramColorSpace)
  {
    j.f(paramColorSpace, "colorSpace");
    return Color.convert(paramInt, paramColorSpace);
  }
  
  @RequiresApi(26)
  public static final long convertTo(long paramLong, ColorSpace.Named paramNamed)
  {
    j.f(paramNamed, "colorSpace");
    return Color.convert(paramLong, ColorSpace.get(paramNamed));
  }
  
  @RequiresApi(26)
  public static final long convertTo(long paramLong, ColorSpace paramColorSpace)
  {
    j.f(paramColorSpace, "colorSpace");
    return Color.convert(paramLong, paramColorSpace);
  }
  
  @RequiresApi(26)
  public static final Color convertTo(Color paramColor, ColorSpace.Named paramNamed)
  {
    j.f(paramColor, "$this$convertTo");
    j.f(paramNamed, "colorSpace");
    paramColor = paramColor.convert(ColorSpace.get(paramNamed));
    j.b(paramColor, "convert(ColorSpace.get(colorSpace))");
    return paramColor;
  }
  
  @RequiresApi(26)
  public static final Color convertTo(Color paramColor, ColorSpace paramColorSpace)
  {
    j.f(paramColor, "$this$convertTo");
    j.f(paramColorSpace, "colorSpace");
    paramColor = paramColor.convert(paramColorSpace);
    j.b(paramColor, "convert(colorSpace)");
    return paramColor;
  }
  
  @RequiresApi(26)
  public static final float getAlpha(long paramLong)
  {
    return Color.alpha(paramLong);
  }
  
  public static final int getAlpha(@ColorInt int paramInt)
  {
    return paramInt >> 24 & 0xFF;
  }
  
  @RequiresApi(26)
  public static final float getBlue(long paramLong)
  {
    return Color.blue(paramLong);
  }
  
  public static final int getBlue(@ColorInt int paramInt)
  {
    return paramInt & 0xFF;
  }
  
  @RequiresApi(26)
  public static final ColorSpace getColorSpace(long paramLong)
  {
    ColorSpace localColorSpace = Color.colorSpace(paramLong);
    j.b(localColorSpace, "Color.colorSpace(this)");
    return localColorSpace;
  }
  
  @RequiresApi(26)
  public static final float getGreen(long paramLong)
  {
    return Color.green(paramLong);
  }
  
  public static final int getGreen(@ColorInt int paramInt)
  {
    return paramInt >> 8 & 0xFF;
  }
  
  @RequiresApi(26)
  public static final float getLuminance(@ColorInt int paramInt)
  {
    return Color.luminance(paramInt);
  }
  
  @RequiresApi(26)
  public static final float getLuminance(long paramLong)
  {
    return Color.luminance(paramLong);
  }
  
  @RequiresApi(26)
  public static final float getRed(long paramLong)
  {
    return Color.red(paramLong);
  }
  
  public static final int getRed(@ColorInt int paramInt)
  {
    return paramInt >> 16 & 0xFF;
  }
  
  @RequiresApi(26)
  public static final boolean isSrgb(long paramLong)
  {
    return Color.isSrgb(paramLong);
  }
  
  @RequiresApi(26)
  public static final boolean isWideGamut(long paramLong)
  {
    return Color.isWideGamut(paramLong);
  }
  
  @RequiresApi(26)
  public static final Color plus(Color paramColor1, Color paramColor2)
  {
    j.f(paramColor1, "$this$plus");
    j.f(paramColor2, "c");
    paramColor1 = ColorUtils.compositeColors(paramColor2, paramColor1);
    j.b(paramColor1, "ColorUtils.compositeColors(c, this)");
    return paramColor1;
  }
  
  @RequiresApi(26)
  public static final Color toColor(@ColorInt int paramInt)
  {
    Color localColor = Color.valueOf(paramInt);
    j.b(localColor, "Color.valueOf(this)");
    return localColor;
  }
  
  @RequiresApi(26)
  public static final Color toColor(long paramLong)
  {
    Color localColor = Color.valueOf(paramLong);
    j.b(localColor, "Color.valueOf(this)");
    return localColor;
  }
  
  @ColorInt
  @RequiresApi(26)
  public static final int toColorInt(long paramLong)
  {
    return Color.toArgb(paramLong);
  }
  
  @ColorInt
  public static final int toColorInt(String paramString)
  {
    j.f(paramString, "$this$toColorInt");
    return Color.parseColor(paramString);
  }
  
  @RequiresApi(26)
  public static final long toColorLong(@ColorInt int paramInt)
  {
    return Color.pack(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\ColorKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */