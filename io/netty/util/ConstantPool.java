package io.netty.util;

import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.PlatformDependent;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class ConstantPool<T extends Constant<T>>
{
  private final ConcurrentMap<String, T> constants = PlatformDependent.newConcurrentHashMap();
  private final AtomicInteger nextId = new AtomicInteger(1);
  
  private static String checkNotNullAndNotEmpty(String paramString)
  {
    ObjectUtil.checkNotNull(paramString, "name");
    if (!paramString.isEmpty()) {
      return paramString;
    }
    throw new IllegalArgumentException("empty name");
  }
  
  private T createOrThrow(String paramString)
  {
    if ((Constant)this.constants.get(paramString) == null)
    {
      Constant localConstant = newConstant(nextId(), paramString);
      if ((Constant)this.constants.putIfAbsent(paramString, localConstant) == null) {
        return localConstant;
      }
    }
    throw new IllegalArgumentException(String.format("'%s' is already in use", new Object[] { paramString }));
  }
  
  private T getOrCreate(String paramString)
  {
    Constant localConstant1 = (Constant)this.constants.get(paramString);
    Constant localConstant2 = localConstant1;
    if (localConstant1 == null)
    {
      localConstant1 = newConstant(nextId(), paramString);
      localConstant2 = (Constant)this.constants.putIfAbsent(paramString, localConstant1);
      if (localConstant2 == null) {
        return localConstant1;
      }
    }
    return localConstant2;
  }
  
  public boolean exists(String paramString)
  {
    checkNotNullAndNotEmpty(paramString);
    return this.constants.containsKey(paramString);
  }
  
  protected abstract T newConstant(int paramInt, String paramString);
  
  public T newInstance(String paramString)
  {
    checkNotNullAndNotEmpty(paramString);
    return createOrThrow(paramString);
  }
  
  @Deprecated
  public final int nextId()
  {
    return this.nextId.getAndIncrement();
  }
  
  public T valueOf(Class<?> paramClass, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((Class)ObjectUtil.checkNotNull(paramClass, "firstNameComponent")).getName());
    localStringBuilder.append('#');
    localStringBuilder.append((String)ObjectUtil.checkNotNull(paramString, "secondNameComponent"));
    return valueOf(localStringBuilder.toString());
  }
  
  public T valueOf(String paramString)
  {
    checkNotNullAndNotEmpty(paramString);
    return getOrCreate(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\ConstantPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */