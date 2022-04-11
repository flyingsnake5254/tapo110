package androidx.core.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.annotation.AnyRes;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleableRes;
import org.xmlpull.v1.XmlPullParser;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class TypedArrayUtils
{
  private static final String NAMESPACE = "http://schemas.android.com/apk/res/android";
  
  public static int getAttr(@NonNull Context paramContext, int paramInt1, int paramInt2)
  {
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(paramInt1, localTypedValue, true);
    if (localTypedValue.resourceId != 0) {
      return paramInt1;
    }
    return paramInt2;
  }
  
  public static boolean getBoolean(@NonNull TypedArray paramTypedArray, @StyleableRes int paramInt1, @StyleableRes int paramInt2, boolean paramBoolean)
  {
    return paramTypedArray.getBoolean(paramInt1, paramTypedArray.getBoolean(paramInt2, paramBoolean));
  }
  
  @Nullable
  public static Drawable getDrawable(@NonNull TypedArray paramTypedArray, @StyleableRes int paramInt1, @StyleableRes int paramInt2)
  {
    Drawable localDrawable1 = paramTypedArray.getDrawable(paramInt1);
    Drawable localDrawable2 = localDrawable1;
    if (localDrawable1 == null) {
      localDrawable2 = paramTypedArray.getDrawable(paramInt2);
    }
    return localDrawable2;
  }
  
  public static int getInt(@NonNull TypedArray paramTypedArray, @StyleableRes int paramInt1, @StyleableRes int paramInt2, int paramInt3)
  {
    return paramTypedArray.getInt(paramInt1, paramTypedArray.getInt(paramInt2, paramInt3));
  }
  
  public static boolean getNamedBoolean(@NonNull TypedArray paramTypedArray, @NonNull XmlPullParser paramXmlPullParser, @NonNull String paramString, @StyleableRes int paramInt, boolean paramBoolean)
  {
    if (!hasAttribute(paramXmlPullParser, paramString)) {
      return paramBoolean;
    }
    return paramTypedArray.getBoolean(paramInt, paramBoolean);
  }
  
  @ColorInt
  public static int getNamedColor(@NonNull TypedArray paramTypedArray, @NonNull XmlPullParser paramXmlPullParser, @NonNull String paramString, @StyleableRes int paramInt1, @ColorInt int paramInt2)
  {
    if (!hasAttribute(paramXmlPullParser, paramString)) {
      return paramInt2;
    }
    return paramTypedArray.getColor(paramInt1, paramInt2);
  }
  
  @Nullable
  public static ColorStateList getNamedColorStateList(@NonNull TypedArray paramTypedArray, @NonNull XmlPullParser paramXmlPullParser, @Nullable Resources.Theme paramTheme, @NonNull String paramString, @StyleableRes int paramInt)
  {
    if (hasAttribute(paramXmlPullParser, paramString))
    {
      paramXmlPullParser = new TypedValue();
      paramTypedArray.getValue(paramInt, paramXmlPullParser);
      int i = paramXmlPullParser.type;
      if (i != 2)
      {
        if ((i >= 28) && (i <= 31)) {
          return getNamedColorStateListFromInt(paramXmlPullParser);
        }
        return ColorStateListInflaterCompat.inflate(paramTypedArray.getResources(), paramTypedArray.getResourceId(paramInt, 0), paramTheme);
      }
      paramTypedArray = new StringBuilder();
      paramTypedArray.append("Failed to resolve attribute at index ");
      paramTypedArray.append(paramInt);
      paramTypedArray.append(": ");
      paramTypedArray.append(paramXmlPullParser);
      throw new UnsupportedOperationException(paramTypedArray.toString());
    }
    return null;
  }
  
  @NonNull
  private static ColorStateList getNamedColorStateListFromInt(@NonNull TypedValue paramTypedValue)
  {
    return ColorStateList.valueOf(paramTypedValue.data);
  }
  
  public static ComplexColorCompat getNamedComplexColor(@NonNull TypedArray paramTypedArray, @NonNull XmlPullParser paramXmlPullParser, @Nullable Resources.Theme paramTheme, @NonNull String paramString, @StyleableRes int paramInt1, @ColorInt int paramInt2)
  {
    if (hasAttribute(paramXmlPullParser, paramString))
    {
      paramXmlPullParser = new TypedValue();
      paramTypedArray.getValue(paramInt1, paramXmlPullParser);
      int i = paramXmlPullParser.type;
      if ((i >= 28) && (i <= 31)) {
        return ComplexColorCompat.from(paramXmlPullParser.data);
      }
      paramTypedArray = ComplexColorCompat.inflate(paramTypedArray.getResources(), paramTypedArray.getResourceId(paramInt1, 0), paramTheme);
      if (paramTypedArray != null) {
        return paramTypedArray;
      }
    }
    return ComplexColorCompat.from(paramInt2);
  }
  
  public static float getNamedFloat(@NonNull TypedArray paramTypedArray, @NonNull XmlPullParser paramXmlPullParser, @NonNull String paramString, @StyleableRes int paramInt, float paramFloat)
  {
    if (!hasAttribute(paramXmlPullParser, paramString)) {
      return paramFloat;
    }
    return paramTypedArray.getFloat(paramInt, paramFloat);
  }
  
  public static int getNamedInt(@NonNull TypedArray paramTypedArray, @NonNull XmlPullParser paramXmlPullParser, @NonNull String paramString, @StyleableRes int paramInt1, int paramInt2)
  {
    if (!hasAttribute(paramXmlPullParser, paramString)) {
      return paramInt2;
    }
    return paramTypedArray.getInt(paramInt1, paramInt2);
  }
  
  @AnyRes
  public static int getNamedResourceId(@NonNull TypedArray paramTypedArray, @NonNull XmlPullParser paramXmlPullParser, @NonNull String paramString, @StyleableRes int paramInt1, @AnyRes int paramInt2)
  {
    if (!hasAttribute(paramXmlPullParser, paramString)) {
      return paramInt2;
    }
    return paramTypedArray.getResourceId(paramInt1, paramInt2);
  }
  
  @Nullable
  public static String getNamedString(@NonNull TypedArray paramTypedArray, @NonNull XmlPullParser paramXmlPullParser, @NonNull String paramString, @StyleableRes int paramInt)
  {
    if (!hasAttribute(paramXmlPullParser, paramString)) {
      return null;
    }
    return paramTypedArray.getString(paramInt);
  }
  
  @AnyRes
  public static int getResourceId(@NonNull TypedArray paramTypedArray, @StyleableRes int paramInt1, @StyleableRes int paramInt2, @AnyRes int paramInt3)
  {
    return paramTypedArray.getResourceId(paramInt1, paramTypedArray.getResourceId(paramInt2, paramInt3));
  }
  
  @Nullable
  public static String getString(@NonNull TypedArray paramTypedArray, @StyleableRes int paramInt1, @StyleableRes int paramInt2)
  {
    String str1 = paramTypedArray.getString(paramInt1);
    String str2 = str1;
    if (str1 == null) {
      str2 = paramTypedArray.getString(paramInt2);
    }
    return str2;
  }
  
  @Nullable
  public static CharSequence getText(@NonNull TypedArray paramTypedArray, @StyleableRes int paramInt1, @StyleableRes int paramInt2)
  {
    CharSequence localCharSequence1 = paramTypedArray.getText(paramInt1);
    CharSequence localCharSequence2 = localCharSequence1;
    if (localCharSequence1 == null) {
      localCharSequence2 = paramTypedArray.getText(paramInt2);
    }
    return localCharSequence2;
  }
  
  @Nullable
  public static CharSequence[] getTextArray(@NonNull TypedArray paramTypedArray, @StyleableRes int paramInt1, @StyleableRes int paramInt2)
  {
    CharSequence[] arrayOfCharSequence1 = paramTypedArray.getTextArray(paramInt1);
    CharSequence[] arrayOfCharSequence2 = arrayOfCharSequence1;
    if (arrayOfCharSequence1 == null) {
      arrayOfCharSequence2 = paramTypedArray.getTextArray(paramInt2);
    }
    return arrayOfCharSequence2;
  }
  
  public static boolean hasAttribute(@NonNull XmlPullParser paramXmlPullParser, @NonNull String paramString)
  {
    boolean bool;
    if (paramXmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", paramString) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @NonNull
  public static TypedArray obtainAttributes(@NonNull Resources paramResources, @Nullable Resources.Theme paramTheme, @NonNull AttributeSet paramAttributeSet, @NonNull int[] paramArrayOfInt)
  {
    if (paramTheme == null) {
      return paramResources.obtainAttributes(paramAttributeSet, paramArrayOfInt);
    }
    return paramTheme.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt, 0, 0);
  }
  
  @Nullable
  public static TypedValue peekNamedValue(@NonNull TypedArray paramTypedArray, @NonNull XmlPullParser paramXmlPullParser, @NonNull String paramString, int paramInt)
  {
    if (!hasAttribute(paramXmlPullParser, paramString)) {
      return null;
    }
    return paramTypedArray.peekValue(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\content\res\TypedArrayUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */