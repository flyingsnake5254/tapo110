package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.lang.reflect.Constructor;

public abstract class ResourceLeakDetectorFactory
{
  private static volatile ResourceLeakDetectorFactory factoryInstance = new DefaultResourceLeakDetectorFactory();
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(ResourceLeakDetectorFactory.class);
  
  public static ResourceLeakDetectorFactory instance()
  {
    return factoryInstance;
  }
  
  public static void setResourceLeakDetectorFactory(ResourceLeakDetectorFactory paramResourceLeakDetectorFactory)
  {
    factoryInstance = (ResourceLeakDetectorFactory)ObjectUtil.checkNotNull(paramResourceLeakDetectorFactory, "factory");
  }
  
  public final <T> ResourceLeakDetector<T> newResourceLeakDetector(Class<T> paramClass)
  {
    return newResourceLeakDetector(paramClass, ResourceLeakDetector.SAMPLING_INTERVAL);
  }
  
  public <T> ResourceLeakDetector<T> newResourceLeakDetector(Class<T> paramClass, int paramInt)
  {
    ObjectUtil.checkPositive(paramInt, "samplingInterval");
    return newResourceLeakDetector(paramClass, paramInt, Long.MAX_VALUE);
  }
  
  @Deprecated
  public abstract <T> ResourceLeakDetector<T> newResourceLeakDetector(Class<T> paramClass, int paramInt, long paramLong);
  
  private static final class DefaultResourceLeakDetectorFactory
    extends ResourceLeakDetectorFactory
  {
    private final Constructor<?> customClassConstructor;
    private final Constructor<?> obsoleteCustomClassConstructor;
    
    /* Error */
    DefaultResourceLeakDetectorFactory()
    {
      // Byte code:
      //   0: aload_0
      //   1: invokespecial 13	io/netty/util/ResourceLeakDetectorFactory:<init>	()V
      //   4: ldc 15
      //   6: invokestatic 21	io/netty/util/internal/SystemPropertyUtil:get	(Ljava/lang/String;)Ljava/lang/String;
      //   9: astore_1
      //   10: goto +17 -> 27
      //   13: astore_1
      //   14: invokestatic 25	io/netty/util/ResourceLeakDetectorFactory:access$000	()Lio/netty/util/internal/logging/InternalLogger;
      //   17: ldc 27
      //   19: aload_1
      //   20: invokeinterface 33 3 0
      //   25: aconst_null
      //   26: astore_1
      //   27: aload_1
      //   28: ifnonnull +16 -> 44
      //   31: aload_0
      //   32: aconst_null
      //   33: putfield 35	io/netty/util/ResourceLeakDetectorFactory$DefaultResourceLeakDetectorFactory:customClassConstructor	Ljava/lang/reflect/Constructor;
      //   36: aload_0
      //   37: aconst_null
      //   38: putfield 37	io/netty/util/ResourceLeakDetectorFactory$DefaultResourceLeakDetectorFactory:obsoleteCustomClassConstructor	Ljava/lang/reflect/Constructor;
      //   41: goto +19 -> 60
      //   44: aload_0
      //   45: aload_1
      //   46: invokestatic 40	io/netty/util/ResourceLeakDetectorFactory$DefaultResourceLeakDetectorFactory:obsoleteCustomClassConstructor	(Ljava/lang/String;)Ljava/lang/reflect/Constructor;
      //   49: putfield 37	io/netty/util/ResourceLeakDetectorFactory$DefaultResourceLeakDetectorFactory:obsoleteCustomClassConstructor	Ljava/lang/reflect/Constructor;
      //   52: aload_0
      //   53: aload_1
      //   54: invokestatic 42	io/netty/util/ResourceLeakDetectorFactory$DefaultResourceLeakDetectorFactory:customClassConstructor	(Ljava/lang/String;)Ljava/lang/reflect/Constructor;
      //   57: putfield 35	io/netty/util/ResourceLeakDetectorFactory$DefaultResourceLeakDetectorFactory:customClassConstructor	Ljava/lang/reflect/Constructor;
      //   60: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	61	0	this	DefaultResourceLeakDetectorFactory
      //   9	1	1	str1	String
      //   13	7	1	localThrowable	Throwable
      //   26	28	1	str2	String
      // Exception table:
      //   from	to	target	type
      //   4	10	13	finally
    }
    
    private static Constructor<?> customClassConstructor(String paramString)
    {
      try
      {
        Class localClass = Class.forName(paramString, true, PlatformDependent.getSystemClassLoader());
        if (ResourceLeakDetector.class.isAssignableFrom(localClass)) {
          return localClass.getConstructor(new Class[] { Class.class, Integer.TYPE });
        }
        ResourceLeakDetectorFactory.logger.error("Class {} does not inherit from ResourceLeakDetector.", paramString);
      }
      finally
      {
        ResourceLeakDetectorFactory.logger.error("Could not load custom resource leak detector class provided: {}", paramString, localObject);
      }
      return null;
    }
    
    private static Constructor<?> obsoleteCustomClassConstructor(String paramString)
    {
      try
      {
        Class localClass = Class.forName(paramString, true, PlatformDependent.getSystemClassLoader());
        if (ResourceLeakDetector.class.isAssignableFrom(localClass)) {
          return localClass.getConstructor(new Class[] { Class.class, Integer.TYPE, Long.TYPE });
        }
        ResourceLeakDetectorFactory.logger.error("Class {} does not inherit from ResourceLeakDetector.", paramString);
      }
      finally
      {
        ResourceLeakDetectorFactory.logger.error("Could not load custom resource leak detector class provided: {}", paramString, localObject);
      }
      return null;
    }
    
    public <T> ResourceLeakDetector<T> newResourceLeakDetector(Class<T> paramClass, int paramInt)
    {
      Object localObject1 = this.customClassConstructor;
      if (localObject1 != null) {
        try
        {
          localObject1 = (ResourceLeakDetector)((Constructor)localObject1).newInstance(new Object[] { paramClass, Integer.valueOf(paramInt) });
          ResourceLeakDetectorFactory.logger.debug("Loaded custom ResourceLeakDetector: {}", this.customClassConstructor.getDeclaringClass().getName());
          return (ResourceLeakDetector<T>)localObject1;
        }
        finally
        {
          ResourceLeakDetectorFactory.logger.error("Could not load custom resource leak detector provided: {} with the given resource: {}", new Object[] { this.customClassConstructor.getDeclaringClass().getName(), paramClass, localObject2 });
        }
      }
      paramClass = new ResourceLeakDetector(paramClass, paramInt);
      ResourceLeakDetectorFactory.logger.debug("Loaded default ResourceLeakDetector: {}", paramClass);
      return paramClass;
    }
    
    public <T> ResourceLeakDetector<T> newResourceLeakDetector(Class<T> paramClass, int paramInt, long paramLong)
    {
      Object localObject1 = this.obsoleteCustomClassConstructor;
      if (localObject1 != null) {
        try
        {
          localObject1 = (ResourceLeakDetector)((Constructor)localObject1).newInstance(new Object[] { paramClass, Integer.valueOf(paramInt), Long.valueOf(paramLong) });
          ResourceLeakDetectorFactory.logger.debug("Loaded custom ResourceLeakDetector: {}", this.obsoleteCustomClassConstructor.getDeclaringClass().getName());
          return (ResourceLeakDetector<T>)localObject1;
        }
        finally
        {
          ResourceLeakDetectorFactory.logger.error("Could not load custom resource leak detector provided: {} with the given resource: {}", new Object[] { this.obsoleteCustomClassConstructor.getDeclaringClass().getName(), paramClass, localObject2 });
        }
      }
      paramClass = new ResourceLeakDetector(paramClass, paramInt, paramLong);
      ResourceLeakDetectorFactory.logger.debug("Loaded default ResourceLeakDetector: {}", paramClass);
      return paramClass;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\ResourceLeakDetectorFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */