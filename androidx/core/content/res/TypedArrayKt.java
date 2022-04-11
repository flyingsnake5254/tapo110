package androidx.core.content.res;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.RequiresApi;
import androidx.annotation.StyleableRes;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;

public final class TypedArrayKt
{
  private static final void checkAttribute(TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    if (paramTypedArray.hasValue(paramInt)) {
      return;
    }
    throw new IllegalArgumentException("Attribute not defined in set.");
  }
  
  public static final boolean getBooleanOrThrow(TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    j.f(paramTypedArray, "$this$getBooleanOrThrow");
    checkAttribute(paramTypedArray, paramInt);
    return paramTypedArray.getBoolean(paramInt, false);
  }
  
  @ColorInt
  public static final int getColorOrThrow(TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    j.f(paramTypedArray, "$this$getColorOrThrow");
    checkAttribute(paramTypedArray, paramInt);
    return paramTypedArray.getColor(paramInt, 0);
  }
  
  public static final ColorStateList getColorStateListOrThrow(TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    j.f(paramTypedArray, "$this$getColorStateListOrThrow");
    checkAttribute(paramTypedArray, paramInt);
    paramTypedArray = paramTypedArray.getColorStateList(paramInt);
    if (paramTypedArray != null) {
      return paramTypedArray;
    }
    throw new IllegalStateException("Attribute value was not a color or color state list.".toString());
  }
  
  public static final float getDimensionOrThrow(TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    j.f(paramTypedArray, "$this$getDimensionOrThrow");
    checkAttribute(paramTypedArray, paramInt);
    return paramTypedArray.getDimension(paramInt, 0.0F);
  }
  
  @Dimension
  public static final int getDimensionPixelOffsetOrThrow(TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    j.f(paramTypedArray, "$this$getDimensionPixelOffsetOrThrow");
    checkAttribute(paramTypedArray, paramInt);
    return paramTypedArray.getDimensionPixelOffset(paramInt, 0);
  }
  
  @Dimension
  public static final int getDimensionPixelSizeOrThrow(TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    j.f(paramTypedArray, "$this$getDimensionPixelSizeOrThrow");
    checkAttribute(paramTypedArray, paramInt);
    return paramTypedArray.getDimensionPixelSize(paramInt, 0);
  }
  
  public static final Drawable getDrawableOrThrow(TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    j.f(paramTypedArray, "$this$getDrawableOrThrow");
    checkAttribute(paramTypedArray, paramInt);
    paramTypedArray = paramTypedArray.getDrawable(paramInt);
    if (paramTypedArray == null) {
      j.n();
    }
    return paramTypedArray;
  }
  
  public static final float getFloatOrThrow(TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    j.f(paramTypedArray, "$this$getFloatOrThrow");
    checkAttribute(paramTypedArray, paramInt);
    return paramTypedArray.getFloat(paramInt, 0.0F);
  }
  
  @RequiresApi(26)
  public static final Typeface getFontOrThrow(TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    j.f(paramTypedArray, "$this$getFontOrThrow");
    checkAttribute(paramTypedArray, paramInt);
    paramTypedArray = paramTypedArray.getFont(paramInt);
    if (paramTypedArray == null) {
      j.n();
    }
    return paramTypedArray;
  }
  
  public static final int getIntOrThrow(TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    j.f(paramTypedArray, "$this$getIntOrThrow");
    checkAttribute(paramTypedArray, paramInt);
    return paramTypedArray.getInt(paramInt, 0);
  }
  
  public static final int getIntegerOrThrow(TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    j.f(paramTypedArray, "$this$getIntegerOrThrow");
    checkAttribute(paramTypedArray, paramInt);
    return paramTypedArray.getInteger(paramInt, 0);
  }
  
  @AnyRes
  public static final int getResourceIdOrThrow(TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    j.f(paramTypedArray, "$this$getResourceIdOrThrow");
    checkAttribute(paramTypedArray, paramInt);
    return paramTypedArray.getResourceId(paramInt, 0);
  }
  
  public static final String getStringOrThrow(TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    j.f(paramTypedArray, "$this$getStringOrThrow");
    checkAttribute(paramTypedArray, paramInt);
    paramTypedArray = paramTypedArray.getString(paramInt);
    if (paramTypedArray != null) {
      return paramTypedArray;
    }
    throw new IllegalStateException("Attribute value could not be coerced to String.".toString());
  }
  
  public static final CharSequence[] getTextArrayOrThrow(TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    j.f(paramTypedArray, "$this$getTextArrayOrThrow");
    checkAttribute(paramTypedArray, paramInt);
    paramTypedArray = paramTypedArray.getTextArray(paramInt);
    j.b(paramTypedArray, "getTextArray(index)");
    return paramTypedArray;
  }
  
  public static final CharSequence getTextOrThrow(TypedArray paramTypedArray, @StyleableRes int paramInt)
  {
    j.f(paramTypedArray, "$this$getTextOrThrow");
    checkAttribute(paramTypedArray, paramInt);
    paramTypedArray = paramTypedArray.getText(paramInt);
    if (paramTypedArray != null) {
      return paramTypedArray;
    }
    throw new IllegalStateException("Attribute value could not be coerced to CharSequence.".toString());
  }
  
  public static final <R> R use(TypedArray paramTypedArray, l<? super TypedArray, ? extends R> paraml)
  {
    j.f(paramTypedArray, "$this$use");
    j.f(paraml, "block");
    paraml = paraml.invoke(paramTypedArray);
    paramTypedArray.recycle();
    return paraml;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\content\res\TypedArrayKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */