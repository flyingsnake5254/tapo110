package com.bumptech.glide.load.k.e;

import android.content.Context;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

public final class a
{
  private static volatile boolean a = true;
  
  public static Drawable a(Context paramContext, @DrawableRes int paramInt, @Nullable Resources.Theme paramTheme)
  {
    return c(paramContext, paramContext, paramInt, paramTheme);
  }
  
  public static Drawable b(Context paramContext1, Context paramContext2, @DrawableRes int paramInt)
  {
    return c(paramContext1, paramContext2, paramInt, null);
  }
  
  private static Drawable c(Context paramContext1, Context paramContext2, @DrawableRes int paramInt, @Nullable Resources.Theme paramTheme)
  {
    try
    {
      if (a)
      {
        Drawable localDrawable = e(paramContext2, paramInt, paramTheme);
        return localDrawable;
      }
    }
    catch (Resources.NotFoundException paramContext1) {}catch (IllegalStateException paramTheme)
    {
      if (!paramContext1.getPackageName().equals(paramContext2.getPackageName())) {
        return ContextCompat.getDrawable(paramContext2, paramInt);
      }
      throw paramTheme;
    }
    catch (NoClassDefFoundError paramContext1)
    {
      a = false;
    }
    if (paramTheme == null) {
      paramTheme = paramContext2.getTheme();
    }
    return d(paramContext2, paramInt, paramTheme);
  }
  
  private static Drawable d(Context paramContext, @DrawableRes int paramInt, @Nullable Resources.Theme paramTheme)
  {
    return ResourcesCompat.getDrawable(paramContext.getResources(), paramInt, paramTheme);
  }
  
  private static Drawable e(Context paramContext, @DrawableRes int paramInt, @Nullable Resources.Theme paramTheme)
  {
    Object localObject = paramContext;
    if (paramTheme != null) {
      localObject = new ContextThemeWrapper(paramContext, paramTheme);
    }
    return AppCompatResources.getDrawable((Context)localObject, paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\k\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */