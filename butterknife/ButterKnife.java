package butterknife;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.annotation.VisibleForTesting;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ButterKnife
{
  private static boolean a = false;
  @VisibleForTesting
  static final Map<Class<?>, Constructor<? extends Unbinder>> b = new LinkedHashMap();
  
  private ButterKnife()
  {
    throw new AssertionError("No instances.");
  }
  
  @NonNull
  @UiThread
  public static Unbinder a(@NonNull Activity paramActivity)
  {
    return b(paramActivity, paramActivity.getWindow().getDecorView());
  }
  
  @NonNull
  @UiThread
  public static Unbinder b(@NonNull Object paramObject, @NonNull View paramView)
  {
    Object localObject = paramObject.getClass();
    if (a)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Looking up binding for ");
      localStringBuilder.append(((Class)localObject).getName());
      Log.d("ButterKnife", localStringBuilder.toString());
    }
    localObject = c((Class)localObject);
    if (localObject == null) {
      return Unbinder.a;
    }
    try
    {
      paramObject = (Unbinder)((Constructor)localObject).newInstance(new Object[] { paramObject, paramView });
      return (Unbinder)paramObject;
    }
    catch (InvocationTargetException paramObject)
    {
      paramObject = ((InvocationTargetException)paramObject).getCause();
      if (!(paramObject instanceof RuntimeException))
      {
        if ((paramObject instanceof Error)) {
          throw ((Error)paramObject);
        }
        throw new RuntimeException("Unable to create binding instance.", (Throwable)paramObject);
      }
      throw ((RuntimeException)paramObject);
    }
    catch (InstantiationException paramView)
    {
      paramObject = new StringBuilder();
      ((StringBuilder)paramObject).append("Unable to invoke ");
      ((StringBuilder)paramObject).append(localObject);
      throw new RuntimeException(((StringBuilder)paramObject).toString(), paramView);
    }
    catch (IllegalAccessException paramObject)
    {
      paramView = new StringBuilder();
      paramView.append("Unable to invoke ");
      paramView.append(localObject);
      throw new RuntimeException(paramView.toString(), (Throwable)paramObject);
    }
  }
  
  @CheckResult
  @Nullable
  @UiThread
  private static Constructor<? extends Unbinder> c(Class<?> paramClass)
  {
    Object localObject1 = b;
    Object localObject2 = (Constructor)((Map)localObject1).get(paramClass);
    Object localObject3;
    if ((localObject2 == null) && (!((Map)localObject1).containsKey(paramClass)))
    {
      String str = paramClass.getName();
      if ((!str.startsWith("android.")) && (!str.startsWith("java.")) && (!str.startsWith("androidx.")))
      {
        try
        {
          localObject1 = paramClass.getClassLoader();
          localObject2 = new java/lang/StringBuilder;
          ((StringBuilder)localObject2).<init>();
          ((StringBuilder)localObject2).append(str);
          ((StringBuilder)localObject2).append("_ViewBinding");
          localObject1 = ((ClassLoader)localObject1).loadClass(((StringBuilder)localObject2).toString()).getConstructor(new Class[] { paramClass, View.class });
          localObject2 = localObject1;
          if (a)
          {
            Log.d("ButterKnife", "HIT: Loaded binding class and constructor.");
            localObject2 = localObject1;
          }
        }
        catch (NoSuchMethodException paramClass)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Unable to find binding constructor for ");
          ((StringBuilder)localObject2).append(str);
          throw new RuntimeException(((StringBuilder)localObject2).toString(), paramClass);
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          if (a)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("Not found. Trying superclass ");
            ((StringBuilder)localObject3).append(paramClass.getSuperclass().getName());
            Log.d("ButterKnife", ((StringBuilder)localObject3).toString());
          }
          localObject3 = c(paramClass.getSuperclass());
        }
        b.put(paramClass, localObject3);
        return (Constructor<? extends Unbinder>)localObject3;
      }
      if (a) {
        Log.d("ButterKnife", "MISS: Reached framework class. Abandoning search.");
      }
      return null;
    }
    if (a) {
      Log.d("ButterKnife", "HIT: Cached in binding map.");
    }
    return (Constructor<? extends Unbinder>)localObject3;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\butterknife\ButterKnife.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */