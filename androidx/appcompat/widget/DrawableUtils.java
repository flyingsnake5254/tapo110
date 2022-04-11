package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.graphics.Insets;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build.VERSION;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.WrappedDrawable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@SuppressLint({"RestrictedAPI"})
@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class DrawableUtils
{
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  private static final int[] EMPTY_STATE_SET = new int[0];
  public static final Rect INSETS_NONE = new Rect();
  private static final String TAG = "DrawableUtils";
  private static final String VECTOR_DRAWABLE_CLAZZ_NAME = "android.graphics.drawable.VectorDrawable";
  private static Class<?> sInsetsClazz;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 18) {}
    try
    {
      sInsetsClazz = Class.forName("android.graphics.Insets");
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      for (;;) {}
    }
  }
  
  public static boolean canSafelyMutateDrawable(@NonNull Drawable paramDrawable)
  {
    int i = Build.VERSION.SDK_INT;
    if ((i < 15) && ((paramDrawable instanceof InsetDrawable))) {
      return false;
    }
    if ((i < 15) && ((paramDrawable instanceof GradientDrawable))) {
      return false;
    }
    if ((i < 17) && ((paramDrawable instanceof LayerDrawable))) {
      return false;
    }
    if ((paramDrawable instanceof DrawableContainer))
    {
      paramDrawable = paramDrawable.getConstantState();
      if ((paramDrawable instanceof DrawableContainer.DrawableContainerState))
      {
        paramDrawable = ((DrawableContainer.DrawableContainerState)paramDrawable).getChildren();
        int j = paramDrawable.length;
        for (i = 0; i < j; i++) {
          if (!canSafelyMutateDrawable(paramDrawable[i])) {
            return false;
          }
        }
      }
    }
    else
    {
      if ((paramDrawable instanceof WrappedDrawable)) {
        return canSafelyMutateDrawable(((WrappedDrawable)paramDrawable).getWrappedDrawable());
      }
      if ((paramDrawable instanceof DrawableWrapper)) {
        return canSafelyMutateDrawable(((DrawableWrapper)paramDrawable).getWrappedDrawable());
      }
      if ((paramDrawable instanceof ScaleDrawable)) {
        return canSafelyMutateDrawable(((ScaleDrawable)paramDrawable).getDrawable());
      }
    }
    return true;
  }
  
  static void fixDrawable(@NonNull Drawable paramDrawable)
  {
    if ((Build.VERSION.SDK_INT == 21) && ("android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName()))) {
      fixVectorDrawableTinting(paramDrawable);
    }
  }
  
  private static void fixVectorDrawableTinting(Drawable paramDrawable)
  {
    int[] arrayOfInt = paramDrawable.getState();
    if ((arrayOfInt != null) && (arrayOfInt.length != 0)) {
      paramDrawable.setState(EMPTY_STATE_SET);
    } else {
      paramDrawable.setState(CHECKED_STATE_SET);
    }
    paramDrawable.setState(arrayOfInt);
  }
  
  public static Rect getOpticalBounds(Drawable paramDrawable)
  {
    Object localObject1;
    if (Build.VERSION.SDK_INT >= 29)
    {
      paramDrawable = paramDrawable.getOpticalInsets();
      localObject1 = new Rect();
      ((Rect)localObject1).left = paramDrawable.left;
      ((Rect)localObject1).right = paramDrawable.right;
      ((Rect)localObject1).top = paramDrawable.top;
      ((Rect)localObject1).bottom = paramDrawable.bottom;
      return (Rect)localObject1;
    }
    if (sInsetsClazz != null) {
      try
      {
        paramDrawable = DrawableCompat.unwrap(paramDrawable);
        paramDrawable = paramDrawable.getClass().getMethod("getOpticalInsets", new Class[0]).invoke(paramDrawable, new Object[0]);
        if (paramDrawable != null)
        {
          Rect localRect = new android/graphics/Rect;
          localRect.<init>();
          for (Object localObject2 : sInsetsClazz.getFields())
          {
            String str = ((Field)localObject2).getName();
            int k = -1;
            switch (str.hashCode())
            {
            default: 
              break;
            case 108511772: 
              if (str.equals("right")) {
                k = 2;
              }
              break;
            case 3317767: 
              if (str.equals("left")) {
                k = 0;
              }
              break;
            case 115029: 
              if (str.equals("top")) {
                k = 1;
              }
              break;
            case -1383228885: 
              if (str.equals("bottom")) {
                k = 3;
              }
              break;
            }
            if (k != 0)
            {
              if (k != 1)
              {
                if (k != 2)
                {
                  if (k == 3) {
                    localRect.bottom = ((Field)localObject2).getInt(paramDrawable);
                  }
                }
                else {
                  localRect.right = ((Field)localObject2).getInt(paramDrawable);
                }
              }
              else {
                localRect.top = ((Field)localObject2).getInt(paramDrawable);
              }
            }
            else {
              localRect.left = ((Field)localObject2).getInt(paramDrawable);
            }
          }
          return localRect;
        }
      }
      catch (Exception paramDrawable)
      {
        Log.e("DrawableUtils", "Couldn't obtain the optical insets. Ignoring.");
      }
    }
    return INSETS_NONE;
  }
  
  public static PorterDuff.Mode parseTintMode(int paramInt, PorterDuff.Mode paramMode)
  {
    if (paramInt != 3)
    {
      if (paramInt != 5)
      {
        if (paramInt != 9)
        {
          switch (paramInt)
          {
          default: 
            return paramMode;
          case 16: 
            return PorterDuff.Mode.ADD;
          case 15: 
            return PorterDuff.Mode.SCREEN;
          }
          return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_ATOP;
      }
      return PorterDuff.Mode.SRC_IN;
    }
    return PorterDuff.Mode.SRC_OVER;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\DrawableUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */