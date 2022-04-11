package butterknife.internal;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import androidx.annotation.IdRes;

public final class c
{
  private static final TypedValue a = new TypedValue();
  
  public static <T> T a(Object paramObject, String paramString1, int paramInt1, String paramString2, int paramInt2, Class<T> paramClass)
  {
    try
    {
      paramObject = paramClass.cast(paramObject);
      return (T)paramObject;
    }
    catch (ClassCastException paramClass)
    {
      paramObject = new StringBuilder();
      ((StringBuilder)paramObject).append("Parameter #");
      ((StringBuilder)paramObject).append(paramInt1 + 1);
      ((StringBuilder)paramObject).append(" of method '");
      ((StringBuilder)paramObject).append(paramString1);
      ((StringBuilder)paramObject).append("' was of the wrong type for parameter #");
      ((StringBuilder)paramObject).append(paramInt2 + 1);
      ((StringBuilder)paramObject).append(" of method '");
      ((StringBuilder)paramObject).append(paramString2);
      ((StringBuilder)paramObject).append("'. See cause for more info.");
      throw new IllegalStateException(((StringBuilder)paramObject).toString(), paramClass);
    }
  }
  
  public static <T> T b(View paramView, @IdRes int paramInt, String paramString, Class<T> paramClass)
  {
    try
    {
      paramClass = paramClass.cast(paramView);
      return paramClass;
    }
    catch (ClassCastException paramClass)
    {
      paramView = e(paramView, paramInt);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("View '");
      localStringBuilder.append(paramView);
      localStringBuilder.append("' with ID ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" for ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" was of the wrong type. See cause for more info.");
      throw new IllegalStateException(localStringBuilder.toString(), paramClass);
    }
  }
  
  public static View c(View paramView, @IdRes int paramInt, String paramString)
  {
    Object localObject = paramView.findViewById(paramInt);
    if (localObject != null) {
      return (View)localObject;
    }
    localObject = e(paramView, paramInt);
    paramView = new StringBuilder();
    paramView.append("Required view '");
    paramView.append((String)localObject);
    paramView.append("' with ID ");
    paramView.append(paramInt);
    paramView.append(" for ");
    paramView.append(paramString);
    paramView.append(" was not found. If this view is optional add '@Nullable' (fields) or '@Optional' (methods) annotation.");
    throw new IllegalStateException(paramView.toString());
  }
  
  public static <T> T d(View paramView, @IdRes int paramInt, String paramString, Class<T> paramClass)
  {
    return (T)b(c(paramView, paramInt, paramString), paramInt, paramString, paramClass);
  }
  
  private static String e(View paramView, @IdRes int paramInt)
  {
    if (paramView.isInEditMode()) {
      return "<unavailable while editing>";
    }
    return paramView.getContext().getResources().getResourceEntryName(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\butterknife\internal\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */