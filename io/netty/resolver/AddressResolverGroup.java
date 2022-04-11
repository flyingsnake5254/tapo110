package io.netty.resolver;

import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.a;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.io.Closeable;
import java.net.SocketAddress;
import java.util.IdentityHashMap;
import java.util.Map;

public abstract class AddressResolverGroup<T extends SocketAddress>
  implements Closeable
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(AddressResolverGroup.class);
  private final Map<EventExecutor, GenericFutureListener<Future<Object>>> executorTerminationListeners = new IdentityHashMap();
  private final Map<EventExecutor, AddressResolver<T>> resolvers = new IdentityHashMap();
  
  /* Error */
  public void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 35	io/netty/resolver/AddressResolverGroup:resolvers	Ljava/util/Map;
    //   4: astore_1
    //   5: aload_1
    //   6: monitorenter
    //   7: aload_0
    //   8: getfield 35	io/netty/resolver/AddressResolverGroup:resolvers	Ljava/util/Map;
    //   11: invokeinterface 47 1 0
    //   16: astore_2
    //   17: iconst_0
    //   18: istore_3
    //   19: aload_2
    //   20: iconst_0
    //   21: anewarray 49	io/netty/resolver/AddressResolver
    //   24: invokeinterface 55 2 0
    //   29: checkcast 57	[Lio/netty/resolver/AddressResolver;
    //   32: astore_2
    //   33: aload_0
    //   34: getfield 35	io/netty/resolver/AddressResolverGroup:resolvers	Ljava/util/Map;
    //   37: invokeinterface 60 1 0
    //   42: aload_0
    //   43: getfield 37	io/netty/resolver/AddressResolverGroup:executorTerminationListeners	Ljava/util/Map;
    //   46: invokeinterface 64 1 0
    //   51: iconst_0
    //   52: anewarray 66	java/util/Map$Entry
    //   55: invokeinterface 69 2 0
    //   60: checkcast 71	[Ljava/util/Map$Entry;
    //   63: astore 4
    //   65: aload_0
    //   66: getfield 37	io/netty/resolver/AddressResolverGroup:executorTerminationListeners	Ljava/util/Map;
    //   69: invokeinterface 60 1 0
    //   74: aload_1
    //   75: monitorexit
    //   76: aload 4
    //   78: arraylength
    //   79: istore 5
    //   81: iconst_0
    //   82: istore 6
    //   84: iload 6
    //   86: iload 5
    //   88: if_icmpge +44 -> 132
    //   91: aload 4
    //   93: iload 6
    //   95: aaload
    //   96: astore_1
    //   97: aload_1
    //   98: invokeinterface 75 1 0
    //   103: checkcast 77	io/netty/util/concurrent/EventExecutor
    //   106: invokeinterface 83 1 0
    //   111: aload_1
    //   112: invokeinterface 86 1 0
    //   117: checkcast 88	io/netty/util/concurrent/GenericFutureListener
    //   120: invokeinterface 94 2 0
    //   125: pop
    //   126: iinc 6 1
    //   129: goto -45 -> 84
    //   132: aload_2
    //   133: arraylength
    //   134: istore 5
    //   136: iload_3
    //   137: istore 6
    //   139: iload 6
    //   141: iload 5
    //   143: if_icmpge +35 -> 178
    //   146: aload_2
    //   147: iload 6
    //   149: aaload
    //   150: astore_1
    //   151: aload_1
    //   152: invokeinterface 96 1 0
    //   157: goto +15 -> 172
    //   160: astore_1
    //   161: getstatic 26	io/netty/resolver/AddressResolverGroup:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   164: ldc 98
    //   166: aload_1
    //   167: invokeinterface 104 3 0
    //   172: iinc 6 1
    //   175: goto -36 -> 139
    //   178: return
    //   179: astore_2
    //   180: aload_1
    //   181: monitorexit
    //   182: aload_2
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	AddressResolverGroup
    //   4	148	1	localMap	Map
    //   160	21	1	localThrowable	Throwable
    //   16	131	2	localObject1	Object
    //   179	4	2	localObject2	Object
    //   18	119	3	i	int
    //   63	29	4	arrayOfEntry	java.util.Map.Entry[]
    //   79	65	5	j	int
    //   82	91	6	k	int
    // Exception table:
    //   from	to	target	type
    //   151	157	160	finally
    //   7	17	179	finally
    //   19	76	179	finally
    //   180	182	179	finally
  }
  
  public AddressResolver<T> getResolver(EventExecutor paramEventExecutor)
  {
    ObjectUtil.checkNotNull(paramEventExecutor, "executor");
    if (!paramEventExecutor.isShuttingDown()) {
      synchronized (this.resolvers)
      {
        Object localObject1 = (AddressResolver)this.resolvers.get(paramEventExecutor);
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          try
          {
            localObject2 = newResolver(paramEventExecutor);
            this.resolvers.put(paramEventExecutor, localObject2);
            localObject1 = new io/netty/resolver/AddressResolverGroup$1;
            ((1)localObject1).<init>(this, paramEventExecutor, (AddressResolver)localObject2);
            this.executorTerminationListeners.put(paramEventExecutor, localObject1);
            paramEventExecutor.terminationFuture().addListener((GenericFutureListener)localObject1);
          }
          catch (Exception localException)
          {
            paramEventExecutor = new java/lang/IllegalStateException;
            paramEventExecutor.<init>("failed to create a new resolver", localException);
            throw paramEventExecutor;
          }
        }
        return localException;
      }
    }
    throw new IllegalStateException("executor not accepting a task");
  }
  
  protected abstract AddressResolver<T> newResolver(EventExecutor paramEventExecutor)
    throws Exception;
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\resolver\AddressResolverGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */