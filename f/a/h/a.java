package f.a.h;

import android.graphics.drawable.Drawable;
import java.lang.reflect.Method;

public final class a
{
  private static Class<?> a;
  private static Method b;
  private static Method c;
  private static Class<?> d;
  private static Method e;
  private static Method f;
  
  static
  {
    try
    {
      d = Class.forName("androidx.core.graphics.drawable.WrappedDrawable");
    }
    catch (ClassNotFoundException localClassNotFoundException1)
    {
      if (c.a) {
        c.a("SkinCompatUtils", "hasWrappedDrawable = false");
      }
    }
    try
    {
      a = Class.forName("androidx.core.graphics.drawable.DrawableWrapper");
    }
    catch (ClassNotFoundException localClassNotFoundException2)
    {
      if (c.a) {
        c.a("SkinCompatUtils", "hasDrawableWrapper = false");
      }
    }
  }
  
  public static Drawable a(Drawable paramDrawable)
  {
    Object localObject1 = a;
    if (localObject1 != null)
    {
      if (b == null) {
        try
        {
          localObject1 = ((Class)localObject1).getDeclaredMethod("getWrappedDrawable", new Class[0]);
          b = (Method)localObject1;
          ((Method)localObject1).setAccessible(true);
        }
        catch (Exception localException1)
        {
          if (c.a) {
            c.a("SkinCompatUtils", "getV4DrawableWrapperWrappedDrawable No Such Method");
          }
        }
      }
      Object localObject2 = b;
      if (localObject2 != null) {
        try
        {
          localObject2 = (Drawable)((Method)localObject2).invoke(paramDrawable, new Object[0]);
          return (Drawable)localObject2;
        }
        catch (Exception localException2)
        {
          if (c.a)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("getV4DrawableWrapperWrappedDrawable invoke error: ");
            localStringBuilder.append(localException2);
            c.a("SkinCompatUtils", localStringBuilder.toString());
          }
        }
      }
    }
    return paramDrawable;
  }
  
  public static Drawable b(Drawable paramDrawable)
  {
    Object localObject1 = d;
    if (localObject1 != null)
    {
      if (e == null) {
        try
        {
          localObject1 = ((Class)localObject1).getDeclaredMethod("getWrappedDrawable", new Class[0]);
          e = (Method)localObject1;
          ((Method)localObject1).setAccessible(true);
        }
        catch (Exception localException1)
        {
          if (c.a) {
            c.a("SkinCompatUtils", "getV4WrappedDrawableWrappedDrawable No Such Method");
          }
        }
      }
      Object localObject2 = e;
      if (localObject2 != null) {
        try
        {
          localObject2 = (Drawable)((Method)localObject2).invoke(paramDrawable, new Object[0]);
          return (Drawable)localObject2;
        }
        catch (Exception localException2)
        {
          if (c.a)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("getV4WrappedDrawableWrappedDrawable invoke error: ");
            localStringBuilder.append(localException2);
            c.a("SkinCompatUtils", localStringBuilder.toString());
          }
        }
      }
    }
    return paramDrawable;
  }
  
  public static boolean c(Drawable paramDrawable)
  {
    Class localClass = a;
    boolean bool;
    if ((localClass != null) && (localClass.isAssignableFrom(paramDrawable.getClass()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean d(Drawable paramDrawable)
  {
    Class localClass = d;
    boolean bool;
    if ((localClass != null) && (localClass.isAssignableFrom(paramDrawable.getClass()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static void e(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    Object localObject = a;
    if (localObject != null)
    {
      if (c == null) {
        try
        {
          localObject = ((Class)localObject).getDeclaredMethod("setWrappedDrawable", new Class[] { Drawable.class });
          c = (Method)localObject;
          ((Method)localObject).setAccessible(true);
        }
        catch (Exception localException)
        {
          if (c.a) {
            c.a("SkinCompatUtils", "setV4DrawableWrapperWrappedDrawable No Such Method");
          }
        }
      }
      Method localMethod = c;
      if (localMethod != null) {
        try
        {
          localMethod.invoke(paramDrawable1, new Object[] { paramDrawable2 });
        }
        catch (Exception paramDrawable1)
        {
          if (c.a)
          {
            paramDrawable2 = new StringBuilder();
            paramDrawable2.append("setV4DrawableWrapperWrappedDrawable invoke error: ");
            paramDrawable2.append(paramDrawable1);
            c.a("SkinCompatUtils", paramDrawable2.toString());
          }
        }
      }
    }
  }
  
  public static void f(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    Object localObject = d;
    if (localObject != null)
    {
      if (f == null) {
        try
        {
          localObject = ((Class)localObject).getDeclaredMethod("setWrappedDrawable", new Class[] { Drawable.class });
          f = (Method)localObject;
          ((Method)localObject).setAccessible(true);
        }
        catch (Exception localException)
        {
          if (c.a) {
            c.a("SkinCompatUtils", "setV4WrappedDrawableWrappedDrawable No Such Method");
          }
        }
      }
      Method localMethod = f;
      if (localMethod != null) {
        try
        {
          localMethod.invoke(paramDrawable1, new Object[] { paramDrawable2 });
        }
        catch (Exception paramDrawable2)
        {
          if (c.a)
          {
            paramDrawable1 = new StringBuilder();
            paramDrawable1.append("setV4WrappedDrawableWrappedDrawable invoke error: ");
            paramDrawable1.append(paramDrawable2);
            c.a("SkinCompatUtils", paramDrawable1.toString());
          }
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\f\a\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */