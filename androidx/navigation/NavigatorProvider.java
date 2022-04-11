package androidx.navigation;

import android.annotation.SuppressLint;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"TypeParameterUnusedInFormals"})
public class NavigatorProvider
{
  private static final HashMap<Class<?>, String> sAnnotationNames = new HashMap();
  private final HashMap<String, Navigator<? extends NavDestination>> mNavigators = new HashMap();
  
  @NonNull
  static String getNameForNavigator(@NonNull Class<? extends Navigator> paramClass)
  {
    HashMap localHashMap = sAnnotationNames;
    String str = (String)localHashMap.get(paramClass);
    Object localObject = str;
    if (str == null)
    {
      localObject = (Navigator.Name)paramClass.getAnnotation(Navigator.Name.class);
      if (localObject != null) {
        localObject = ((Navigator.Name)localObject).value();
      } else {
        localObject = null;
      }
      if (validateName((String)localObject))
      {
        localHashMap.put(paramClass, localObject);
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("No @Navigator.Name annotation found for ");
        ((StringBuilder)localObject).append(paramClass.getSimpleName());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    return (String)localObject;
  }
  
  private static boolean validateName(String paramString)
  {
    boolean bool;
    if ((paramString != null) && (!paramString.isEmpty())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @Nullable
  public final Navigator<? extends NavDestination> addNavigator(@NonNull Navigator<? extends NavDestination> paramNavigator)
  {
    return addNavigator(getNameForNavigator(paramNavigator.getClass()), paramNavigator);
  }
  
  @CallSuper
  @Nullable
  public Navigator<? extends NavDestination> addNavigator(@NonNull String paramString, @NonNull Navigator<? extends NavDestination> paramNavigator)
  {
    if (validateName(paramString)) {
      return (Navigator)this.mNavigators.put(paramString, paramNavigator);
    }
    throw new IllegalArgumentException("navigator name cannot be an empty string");
  }
  
  @NonNull
  public final <T extends Navigator<?>> T getNavigator(@NonNull Class<T> paramClass)
  {
    return getNavigator(getNameForNavigator(paramClass));
  }
  
  @CallSuper
  @NonNull
  public <T extends Navigator<?>> T getNavigator(@NonNull String paramString)
  {
    if (validateName(paramString))
    {
      Object localObject = (Navigator)this.mNavigators.get(paramString);
      if (localObject != null) {
        return (T)localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Could not find Navigator with name \"");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("\". You must call NavController.addNavigator() for each navigation type.");
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    throw new IllegalArgumentException("navigator name cannot be an empty string");
  }
  
  Map<String, Navigator<? extends NavDestination>> getNavigators()
  {
    return this.mNavigators;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\NavigatorProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */