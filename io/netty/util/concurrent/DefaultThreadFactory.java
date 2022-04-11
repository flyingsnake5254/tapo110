package io.netty.util.concurrent;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class DefaultThreadFactory
  implements ThreadFactory
{
  private static final AtomicInteger poolId = new AtomicInteger();
  private final boolean daemon;
  private final AtomicInteger nextId = new AtomicInteger();
  private final String prefix;
  private final int priority;
  protected final ThreadGroup threadGroup;
  
  public DefaultThreadFactory(Class<?> paramClass)
  {
    this(paramClass, false, 5);
  }
  
  public DefaultThreadFactory(Class<?> paramClass, int paramInt)
  {
    this(paramClass, false, paramInt);
  }
  
  public DefaultThreadFactory(Class<?> paramClass, boolean paramBoolean)
  {
    this(paramClass, paramBoolean, 5);
  }
  
  public DefaultThreadFactory(Class<?> paramClass, boolean paramBoolean, int paramInt)
  {
    this(toPoolName(paramClass), paramBoolean, paramInt);
  }
  
  public DefaultThreadFactory(String paramString)
  {
    this(paramString, false, 5);
  }
  
  public DefaultThreadFactory(String paramString, int paramInt)
  {
    this(paramString, false, paramInt);
  }
  
  public DefaultThreadFactory(String paramString, boolean paramBoolean)
  {
    this(paramString, paramBoolean, 5);
  }
  
  public DefaultThreadFactory(String paramString, boolean paramBoolean, int paramInt)
  {
    this(paramString, paramBoolean, paramInt, localThreadGroup);
  }
  
  public DefaultThreadFactory(String paramString, boolean paramBoolean, int paramInt, ThreadGroup paramThreadGroup)
  {
    ObjectUtil.checkNotNull(paramString, "poolName");
    if ((paramInt >= 1) && (paramInt <= 10))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append('-');
      localStringBuilder.append(poolId.incrementAndGet());
      localStringBuilder.append('-');
      this.prefix = localStringBuilder.toString();
      this.daemon = paramBoolean;
      this.priority = paramInt;
      this.threadGroup = paramThreadGroup;
      return;
    }
    paramString = new StringBuilder();
    paramString.append("priority: ");
    paramString.append(paramInt);
    paramString.append(" (expected: Thread.MIN_PRIORITY <= priority <= Thread.MAX_PRIORITY)");
    throw new IllegalArgumentException(paramString.toString());
  }
  
  public static String toPoolName(Class<?> paramClass)
  {
    ObjectUtil.checkNotNull(paramClass, "poolType");
    String str = StringUtil.simpleClassName(paramClass);
    int i = str.length();
    if (i != 0)
    {
      if (i != 1)
      {
        paramClass = str;
        if (Character.isUpperCase(str.charAt(0)))
        {
          paramClass = str;
          if (Character.isLowerCase(str.charAt(1)))
          {
            paramClass = new StringBuilder();
            paramClass.append(Character.toLowerCase(str.charAt(0)));
            paramClass.append(str.substring(1));
            paramClass = paramClass.toString();
          }
        }
        return paramClass;
      }
      return str.toLowerCase(Locale.US);
    }
    return "unknown";
  }
  
  public Thread newThread(Runnable paramRunnable)
  {
    Object localObject = FastThreadLocalRunnable.wrap(paramRunnable);
    paramRunnable = new StringBuilder();
    paramRunnable.append(this.prefix);
    paramRunnable.append(this.nextId.incrementAndGet());
    localObject = newThread((Runnable)localObject, paramRunnable.toString());
    try
    {
      boolean bool1 = ((Thread)localObject).isDaemon();
      boolean bool2 = this.daemon;
      if (bool1 != bool2) {
        ((Thread)localObject).setDaemon(bool2);
      }
      int i = ((Thread)localObject).getPriority();
      int j = this.priority;
      if (i != j) {
        ((Thread)localObject).setPriority(j);
      }
    }
    catch (Exception paramRunnable)
    {
      for (;;) {}
    }
    return (Thread)localObject;
  }
  
  protected Thread newThread(Runnable paramRunnable, String paramString)
  {
    return new FastThreadLocalThread(this.threadGroup, paramRunnable, paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\DefaultThreadFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */