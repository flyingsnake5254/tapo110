package f.a.f.a;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import f.a.h.a;

class c
{
  public static boolean a(@NonNull Drawable paramDrawable)
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
          if (!a(paramDrawable[i])) {
            return false;
          }
        }
      }
    }
    else
    {
      if (a.c(paramDrawable)) {
        return a(a.a(paramDrawable));
      }
      if (a.d(paramDrawable)) {
        return a(a.b(paramDrawable));
      }
      if ((paramDrawable instanceof DrawableWrapper)) {
        return a(((DrawableWrapper)paramDrawable).getWrappedDrawable());
      }
      if ((paramDrawable instanceof ScaleDrawable)) {
        paramDrawable = ((ScaleDrawable)paramDrawable).getDrawable();
      }
    }
    try
    {
      boolean bool = a(paramDrawable);
      return bool;
    }
    finally {}
    return true;
  }
  
  static void b(@NonNull Drawable paramDrawable)
  {
    if ((Build.VERSION.SDK_INT == 21) && ("android.graphics.drawable.VectorDrawable".equals(paramDrawable.getClass().getName()))) {
      c(paramDrawable);
    }
  }
  
  private static void c(Drawable paramDrawable)
  {
    int[] arrayOfInt = paramDrawable.getState();
    if ((arrayOfInt != null) && (arrayOfInt.length != 0)) {
      paramDrawable.setState(e.o);
    } else {
      paramDrawable.setState(e.l);
    }
    paramDrawable.setState(arrayOfInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\f\a\f\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */