package io.netty.handler.codec.serialization;

import java.util.Map;

class CachingClassResolver
  implements ClassResolver
{
  private final Map<String, Class<?>> classCache;
  private final ClassResolver delegate;
  
  CachingClassResolver(ClassResolver paramClassResolver, Map<String, Class<?>> paramMap)
  {
    this.delegate = paramClassResolver;
    this.classCache = paramMap;
  }
  
  public Class<?> resolve(String paramString)
    throws ClassNotFoundException
  {
    Class localClass = (Class)this.classCache.get(paramString);
    if (localClass != null) {
      return localClass;
    }
    localClass = this.delegate.resolve(paramString);
    this.classCache.put(paramString, localClass);
    return localClass;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\serialization\CachingClassResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */