package com.google.android.material.drawable;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.XmlRes;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public final class DrawableUtils
{
  @NonNull
  public static AttributeSet parseDrawableXml(@NonNull Context paramContext, @XmlRes int paramInt, @NonNull CharSequence paramCharSequence)
  {
    try
    {
      paramContext = paramContext.getResources().getXml(paramInt);
      int i;
      do
      {
        i = paramContext.next();
      } while ((i != 2) && (i != 1));
      if (i == 2)
      {
        if (TextUtils.equals(paramContext.getName(), paramCharSequence)) {
          return Xml.asAttributeSet(paramContext);
        }
        paramContext = new org/xmlpull/v1/XmlPullParserException;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append("Must have a <");
        localStringBuilder.append(paramCharSequence);
        localStringBuilder.append("> start tag");
        paramContext.<init>(localStringBuilder.toString());
        throw paramContext;
      }
      paramContext = new org/xmlpull/v1/XmlPullParserException;
      paramContext.<init>("No start tag found");
      throw paramContext;
    }
    catch (IOException paramContext) {}catch (XmlPullParserException paramContext) {}
    paramCharSequence = new StringBuilder();
    paramCharSequence.append("Can't load badge resource ID #0x");
    paramCharSequence.append(Integer.toHexString(paramInt));
    paramCharSequence = new Resources.NotFoundException(paramCharSequence.toString());
    paramCharSequence.initCause(paramContext);
    throw paramCharSequence;
  }
  
  @TargetApi(21)
  public static void setRippleDrawableRadius(@Nullable RippleDrawable paramRippleDrawable, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      paramRippleDrawable.setRadius(paramInt);
    }
    try
    {
      RippleDrawable.class.getDeclaredMethod("setMaxRadius", new Class[] { Integer.TYPE }).invoke(paramRippleDrawable, new Object[] { Integer.valueOf(paramInt) });
      return;
    }
    catch (IllegalAccessException paramRippleDrawable) {}catch (InvocationTargetException paramRippleDrawable) {}catch (NoSuchMethodException paramRippleDrawable) {}
    throw new IllegalStateException("Couldn't set RippleDrawable radius", paramRippleDrawable);
  }
  
  @Nullable
  public static PorterDuffColorFilter updateTintFilter(@NonNull Drawable paramDrawable, @Nullable ColorStateList paramColorStateList, @Nullable PorterDuff.Mode paramMode)
  {
    if ((paramColorStateList != null) && (paramMode != null)) {
      return new PorterDuffColorFilter(paramColorStateList.getColorForState(paramDrawable.getState(), 0), paramMode);
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\material\drawable\DrawableUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */