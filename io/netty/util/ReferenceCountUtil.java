package io.netty.util;

import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;

public final class ReferenceCountUtil
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(ReferenceCountUtil.class);
  
  static
  {
    ResourceLeakDetector.addExclusions(ReferenceCountUtil.class, new String[] { "touch" });
  }
  
  public static int refCnt(Object paramObject)
  {
    int i;
    if ((paramObject instanceof ReferenceCounted)) {
      i = ((ReferenceCounted)paramObject).refCnt();
    } else {
      i = -1;
    }
    return i;
  }
  
  public static boolean release(Object paramObject)
  {
    if ((paramObject instanceof ReferenceCounted)) {
      return ((ReferenceCounted)paramObject).release();
    }
    return false;
  }
  
  public static boolean release(Object paramObject, int paramInt)
  {
    if ((paramObject instanceof ReferenceCounted)) {
      return ((ReferenceCounted)paramObject).release(paramInt);
    }
    return false;
  }
  
  @Deprecated
  public static <T> T releaseLater(T paramT)
  {
    return (T)releaseLater(paramT, 1);
  }
  
  @Deprecated
  public static <T> T releaseLater(T paramT, int paramInt)
  {
    if ((paramT instanceof ReferenceCounted)) {
      ThreadDeathWatcher.watch(Thread.currentThread(), new ReleasingTask((ReferenceCounted)paramT, paramInt));
    }
    return paramT;
  }
  
  public static <T> T retain(T paramT)
  {
    Object localObject = paramT;
    if ((paramT instanceof ReferenceCounted)) {
      localObject = ((ReferenceCounted)paramT).retain();
    }
    return (T)localObject;
  }
  
  public static <T> T retain(T paramT, int paramInt)
  {
    Object localObject = paramT;
    if ((paramT instanceof ReferenceCounted)) {
      localObject = ((ReferenceCounted)paramT).retain(paramInt);
    }
    return (T)localObject;
  }
  
  /* Error */
  public static void safeRelease(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 87	io/netty/util/ReferenceCountUtil:release	(Ljava/lang/Object;)Z
    //   4: pop
    //   5: goto +16 -> 21
    //   8: astore_1
    //   9: getstatic 19	io/netty/util/ReferenceCountUtil:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   12: ldc 89
    //   14: aload_0
    //   15: aload_1
    //   16: invokeinterface 95 4 0
    //   21: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	22	0	paramObject	Object
    //   8	8	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	5	8	finally
  }
  
  /* Error */
  public static void safeRelease(Object paramObject, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: iload_1
    //   2: invokestatic 98	io/netty/util/ReferenceCountUtil:release	(Ljava/lang/Object;I)Z
    //   5: pop
    //   6: goto +44 -> 50
    //   9: astore_2
    //   10: getstatic 19	io/netty/util/ReferenceCountUtil:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   13: invokeinterface 101 1 0
    //   18: ifeq +32 -> 50
    //   21: getstatic 19	io/netty/util/ReferenceCountUtil:logger	Lio/netty/util/internal/logging/InternalLogger;
    //   24: ldc 103
    //   26: iconst_3
    //   27: anewarray 4	java/lang/Object
    //   30: dup
    //   31: iconst_0
    //   32: aload_0
    //   33: aastore
    //   34: dup
    //   35: iconst_1
    //   36: iload_1
    //   37: invokestatic 109	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   40: aastore
    //   41: dup
    //   42: iconst_2
    //   43: aload_2
    //   44: aastore
    //   45: invokeinterface 112 3 0
    //   50: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	51	0	paramObject	Object
    //   0	51	1	paramInt	int
    //   9	35	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	6	9	finally
  }
  
  public static <T> T touch(T paramT)
  {
    Object localObject = paramT;
    if ((paramT instanceof ReferenceCounted)) {
      localObject = ((ReferenceCounted)paramT).touch();
    }
    return (T)localObject;
  }
  
  public static <T> T touch(T paramT, Object paramObject)
  {
    Object localObject = paramT;
    if ((paramT instanceof ReferenceCounted)) {
      localObject = ((ReferenceCounted)paramT).touch(paramObject);
    }
    return (T)localObject;
  }
  
  private static final class ReleasingTask
    implements Runnable
  {
    private final int decrement;
    private final ReferenceCounted obj;
    
    ReleasingTask(ReferenceCounted paramReferenceCounted, int paramInt)
    {
      this.obj = paramReferenceCounted;
      this.decrement = paramInt;
    }
    
    public void run()
    {
      try
      {
        if (!this.obj.release(this.decrement)) {
          ReferenceCountUtil.logger.warn("Non-zero refCnt: {}", this);
        } else {
          ReferenceCountUtil.logger.debug("Released: {}", this);
        }
      }
      catch (Exception localException)
      {
        ReferenceCountUtil.logger.warn("Failed to release an object: {}", this.obj, localException);
      }
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(StringUtil.simpleClassName(this.obj));
      localStringBuilder.append(".release(");
      localStringBuilder.append(this.decrement);
      localStringBuilder.append(") refCnt: ");
      localStringBuilder.append(this.obj.refCnt());
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\ReferenceCountUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */