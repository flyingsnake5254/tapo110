package io.netty.handler.codec.serialization;

import io.netty.util.internal.PlatformDependent;
import java.util.HashMap;

public final class ClassResolvers
{
  public static ClassResolver cacheDisabled(ClassLoader paramClassLoader)
  {
    return new ClassLoaderClassResolver(defaultClassLoader(paramClassLoader));
  }
  
  static ClassLoader defaultClassLoader(ClassLoader paramClassLoader)
  {
    if (paramClassLoader != null) {
      return paramClassLoader;
    }
    paramClassLoader = PlatformDependent.getContextClassLoader();
    if (paramClassLoader != null) {
      return paramClassLoader;
    }
    return PlatformDependent.getClassLoader(ClassResolvers.class);
  }
  
  public static ClassResolver softCachingConcurrentResolver(ClassLoader paramClassLoader)
  {
    return new CachingClassResolver(new ClassLoaderClassResolver(defaultClassLoader(paramClassLoader)), new SoftReferenceMap(PlatformDependent.newConcurrentHashMap()));
  }
  
  public static ClassResolver softCachingResolver(ClassLoader paramClassLoader)
  {
    return new CachingClassResolver(new ClassLoaderClassResolver(defaultClassLoader(paramClassLoader)), new SoftReferenceMap(new HashMap()));
  }
  
  public static ClassResolver weakCachingConcurrentResolver(ClassLoader paramClassLoader)
  {
    return new CachingClassResolver(new ClassLoaderClassResolver(defaultClassLoader(paramClassLoader)), new WeakReferenceMap(PlatformDependent.newConcurrentHashMap()));
  }
  
  public static ClassResolver weakCachingResolver(ClassLoader paramClassLoader)
  {
    return new CachingClassResolver(new ClassLoaderClassResolver(defaultClassLoader(paramClassLoader)), new WeakReferenceMap(new HashMap()));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\serialization\ClassResolvers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */