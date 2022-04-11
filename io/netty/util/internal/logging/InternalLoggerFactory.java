package io.netty.util.internal.logging;

import io.netty.util.internal.ObjectUtil;

public abstract class InternalLoggerFactory
{
  private static volatile InternalLoggerFactory defaultFactory;
  
  public static InternalLoggerFactory getDefaultFactory()
  {
    if (defaultFactory == null) {
      defaultFactory = newDefaultFactory(InternalLoggerFactory.class.getName());
    }
    return defaultFactory;
  }
  
  public static InternalLogger getInstance(Class<?> paramClass)
  {
    return getInstance(paramClass.getName());
  }
  
  public static InternalLogger getInstance(String paramString)
  {
    return getDefaultFactory().newInstance(paramString);
  }
  
  /* Error */
  private static InternalLoggerFactory newDefaultFactory(String paramString)
  {
    // Byte code:
    //   0: new 39	io/netty/util/internal/logging/Slf4JLoggerFactory
    //   3: astore_1
    //   4: aload_1
    //   5: iconst_1
    //   6: invokespecial 42	io/netty/util/internal/logging/Slf4JLoggerFactory:<init>	(Z)V
    //   9: aload_1
    //   10: aload_0
    //   11: invokevirtual 37	io/netty/util/internal/logging/InternalLoggerFactory:newInstance	(Ljava/lang/String;)Lio/netty/util/internal/logging/InternalLogger;
    //   14: ldc 44
    //   16: invokeinterface 50 2 0
    //   21: aload_1
    //   22: astore_0
    //   23: goto +66 -> 89
    //   26: astore_1
    //   27: getstatic 55	io/netty/util/internal/logging/Log4J2LoggerFactory:INSTANCE	Lio/netty/util/internal/logging/InternalLoggerFactory;
    //   30: astore_1
    //   31: aload_1
    //   32: aload_0
    //   33: invokevirtual 37	io/netty/util/internal/logging/InternalLoggerFactory:newInstance	(Ljava/lang/String;)Lio/netty/util/internal/logging/InternalLogger;
    //   36: ldc 57
    //   38: invokeinterface 50 2 0
    //   43: aload_1
    //   44: astore_0
    //   45: goto +44 -> 89
    //   48: astore_1
    //   49: getstatic 60	io/netty/util/internal/logging/Log4JLoggerFactory:INSTANCE	Lio/netty/util/internal/logging/InternalLoggerFactory;
    //   52: astore_1
    //   53: aload_1
    //   54: aload_0
    //   55: invokevirtual 37	io/netty/util/internal/logging/InternalLoggerFactory:newInstance	(Ljava/lang/String;)Lio/netty/util/internal/logging/InternalLogger;
    //   58: ldc 62
    //   60: invokeinterface 50 2 0
    //   65: aload_1
    //   66: astore_0
    //   67: goto +22 -> 89
    //   70: astore_1
    //   71: getstatic 65	io/netty/util/internal/logging/JdkLoggerFactory:INSTANCE	Lio/netty/util/internal/logging/InternalLoggerFactory;
    //   74: astore_1
    //   75: aload_1
    //   76: aload_0
    //   77: invokevirtual 37	io/netty/util/internal/logging/InternalLoggerFactory:newInstance	(Ljava/lang/String;)Lio/netty/util/internal/logging/InternalLogger;
    //   80: ldc 67
    //   82: invokeinterface 50 2 0
    //   87: aload_1
    //   88: astore_0
    //   89: aload_0
    //   90: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	paramString	String
    //   3	19	1	localSlf4JLoggerFactory	Slf4JLoggerFactory
    //   26	1	1	localObject1	Object
    //   30	14	1	localInternalLoggerFactory1	InternalLoggerFactory
    //   48	1	1	localObject2	Object
    //   52	14	1	localInternalLoggerFactory2	InternalLoggerFactory
    //   70	1	1	localObject3	Object
    //   74	14	1	localInternalLoggerFactory3	InternalLoggerFactory
    // Exception table:
    //   from	to	target	type
    //   0	21	26	finally
    //   27	43	48	finally
    //   49	65	70	finally
  }
  
  public static void setDefaultFactory(InternalLoggerFactory paramInternalLoggerFactory)
  {
    defaultFactory = (InternalLoggerFactory)ObjectUtil.checkNotNull(paramInternalLoggerFactory, "defaultFactory");
  }
  
  protected abstract InternalLogger newInstance(String paramString);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\logging\InternalLoggerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */