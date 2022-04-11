package f.a.f.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.TypedValue;
import androidx.annotation.RequiresApi;
import androidx.appcompat.R.attr;
import androidx.core.graphics.ColorUtils;

public class e
{
  private static final ThreadLocal<TypedValue> a = new ThreadLocal();
  static final int[] b = { -16842910 };
  static final int[] c = { 16842910 };
  static final int[] d = { 16842909 };
  static final int[] e = { 16842908 };
  static final int[] f = { 16843518 };
  static final int[] g = { 16843547 };
  static final int[] h = { 16843623 };
  static final int[] i = { 16843624 };
  static final int[] j = { 16843625 };
  static final int[] k = { 16842919 };
  static final int[] l = { 16842912 };
  static final int[] m = { 16842913 };
  static final int[] n = { -16842919, -16842908 };
  static final int[] o = new int[0];
  private static final int[] p = new int[1];
  private static final int[] q = { R.attr.colorPrimary };
  private static final int[] r = { R.attr.colorPrimaryDark };
  private static final int[] s = { R.attr.colorAccent };
  
  public static int a(Context paramContext)
  {
    return c(paramContext, r);
  }
  
  public static int b(Context paramContext, int paramInt)
  {
    Object localObject = g(paramContext, paramInt);
    if ((localObject != null) && (((ColorStateList)localObject).isStateful())) {
      return ((ColorStateList)localObject).getColorForState(b, ((ColorStateList)localObject).getDefaultColor());
    }
    localObject = h();
    paramContext.getTheme().resolveAttribute(16842803, (TypedValue)localObject, true);
    return f(paramContext, paramInt, ((TypedValue)localObject).getFloat());
  }
  
  private static int c(Context paramContext, int[] paramArrayOfInt)
  {
    paramContext = paramContext.obtainStyledAttributes(paramArrayOfInt);
    int i1 = paramContext.getResourceId(0, 0);
    paramContext.recycle();
    return i1;
  }
  
  @RequiresApi(api=21)
  public static int d(Context paramContext)
  {
    return c(paramContext, new int[] { 16843857 });
  }
  
  public static int e(Context paramContext, int paramInt)
  {
    Object localObject = p;
    localObject[0] = paramInt;
    localObject = paramContext.obtainStyledAttributes(null, (int[])localObject);
    try
    {
      paramInt = ((TypedArray)localObject).getResourceId(0, 0);
      if (paramInt != 0)
      {
        paramInt = d.a(paramContext, paramInt);
        return paramInt;
      }
      return 0;
    }
    finally
    {
      ((TypedArray)localObject).recycle();
    }
  }
  
  static int f(Context paramContext, int paramInt, float paramFloat)
  {
    paramInt = e(paramContext, paramInt);
    return ColorUtils.setAlphaComponent(paramInt, Math.round(Color.alpha(paramInt) * paramFloat));
  }
  
  public static ColorStateList g(Context paramContext, int paramInt)
  {
    Object localObject = p;
    localObject[0] = paramInt;
    localObject = paramContext.obtainStyledAttributes(null, (int[])localObject);
    try
    {
      paramInt = ((TypedArray)localObject).getResourceId(0, 0);
      if (paramInt != 0)
      {
        paramContext = d.b(paramContext, paramInt);
        return paramContext;
      }
      return null;
    }
    finally
    {
      ((TypedArray)localObject).recycle();
    }
  }
  
  private static TypedValue h()
  {
    ThreadLocal localThreadLocal = a;
    TypedValue localTypedValue1 = (TypedValue)localThreadLocal.get();
    TypedValue localTypedValue2 = localTypedValue1;
    if (localTypedValue1 == null)
    {
      localTypedValue2 = new TypedValue();
      localThreadLocal.set(localTypedValue2);
    }
    return localTypedValue2;
  }
  
  public static int i(Context paramContext)
  {
    return c(paramContext, new int[] { 16842836 });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\f\a\f\a\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */