package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.collection.SimpleArrayMap;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class FragmentFactory
{
  private static final SimpleArrayMap<String, Class<?>> sClassMap = new SimpleArrayMap();
  
  static boolean isFragmentClass(@NonNull ClassLoader paramClassLoader, @NonNull String paramString)
  {
    try
    {
      boolean bool = Fragment.class.isAssignableFrom(loadClass(paramClassLoader, paramString));
      return bool;
    }
    catch (ClassNotFoundException paramClassLoader) {}
    return false;
  }
  
  @NonNull
  private static Class<?> loadClass(@NonNull ClassLoader paramClassLoader, @NonNull String paramString)
    throws ClassNotFoundException
  {
    SimpleArrayMap localSimpleArrayMap = sClassMap;
    Class localClass1 = (Class)localSimpleArrayMap.get(paramString);
    Class localClass2 = localClass1;
    if (localClass1 == null)
    {
      localClass2 = Class.forName(paramString, false, paramClassLoader);
      localSimpleArrayMap.put(paramString, localClass2);
    }
    return localClass2;
  }
  
  @NonNull
  public static Class<? extends Fragment> loadFragmentClass(@NonNull ClassLoader paramClassLoader, @NonNull String paramString)
  {
    try
    {
      paramClassLoader = loadClass(paramClassLoader, paramString);
      return paramClassLoader;
    }
    catch (ClassCastException paramClassLoader)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unable to instantiate fragment ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(": make sure class is a valid subclass of Fragment");
      throw new Fragment.InstantiationException(localStringBuilder.toString(), paramClassLoader);
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      paramClassLoader = new StringBuilder();
      paramClassLoader.append("Unable to instantiate fragment ");
      paramClassLoader.append(paramString);
      paramClassLoader.append(": make sure class name exists");
      throw new Fragment.InstantiationException(paramClassLoader.toString(), localClassNotFoundException);
    }
  }
  
  @NonNull
  public Fragment instantiate(@NonNull ClassLoader paramClassLoader, @NonNull String paramString)
  {
    try
    {
      paramClassLoader = (Fragment)loadFragmentClass(paramClassLoader, paramString).getConstructor(new Class[0]).newInstance(new Object[0]);
      return paramClassLoader;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      paramClassLoader = new StringBuilder();
      paramClassLoader.append("Unable to instantiate fragment ");
      paramClassLoader.append(paramString);
      paramClassLoader.append(": calling Fragment constructor caused an exception");
      throw new Fragment.InstantiationException(paramClassLoader.toString(), localInvocationTargetException);
    }
    catch (NoSuchMethodException paramClassLoader)
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("Unable to instantiate fragment ");
      localStringBuilder1.append(paramString);
      localStringBuilder1.append(": could not find Fragment constructor");
      throw new Fragment.InstantiationException(localStringBuilder1.toString(), paramClassLoader);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      paramClassLoader = new StringBuilder();
      paramClassLoader.append("Unable to instantiate fragment ");
      paramClassLoader.append(paramString);
      paramClassLoader.append(": make sure class name exists, is public, and has an empty constructor that is public");
      throw new Fragment.InstantiationException(paramClassLoader.toString(), localIllegalAccessException);
    }
    catch (InstantiationException paramClassLoader)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("Unable to instantiate fragment ");
      localStringBuilder2.append(paramString);
      localStringBuilder2.append(": make sure class name exists, is public, and has an empty constructor that is public");
      throw new Fragment.InstantiationException(localStringBuilder2.toString(), paramClassLoader);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\fragment\app\FragmentFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */