package io.netty.handler.codec.serialization;

class ClassLoaderClassResolver
  implements ClassResolver
{
  private final ClassLoader classLoader;
  
  ClassLoaderClassResolver(ClassLoader paramClassLoader)
  {
    this.classLoader = paramClassLoader;
  }
  
  public Class<?> resolve(String paramString)
    throws ClassNotFoundException
  {
    try
    {
      Class localClass = this.classLoader.loadClass(paramString);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return Class.forName(paramString, false, this.classLoader);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\serialization\ClassLoaderClassResolver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */