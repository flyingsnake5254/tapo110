package io.netty.util;

import java.util.concurrent.atomic.AtomicLong;

public abstract class AbstractConstant<T extends AbstractConstant<T>>
  implements Constant<T>
{
  private static final AtomicLong uniqueIdGenerator = new AtomicLong();
  private final int id;
  private final String name;
  private final long uniquifier;
  
  protected AbstractConstant(int paramInt, String paramString)
  {
    this.id = paramInt;
    this.name = paramString;
    this.uniquifier = uniqueIdGenerator.getAndIncrement();
  }
  
  public final int compareTo(T paramT)
  {
    if (this == paramT) {
      return 0;
    }
    int i = hashCode() - paramT.hashCode();
    if (i != 0) {
      return i;
    }
    long l1 = this.uniquifier;
    long l2 = paramT.uniquifier;
    if (l1 < l2) {
      return -1;
    }
    if (l1 > l2) {
      return 1;
    }
    throw new Error("failed to compare two different constants");
  }
  
  public final boolean equals(Object paramObject)
  {
    return super.equals(paramObject);
  }
  
  public final int hashCode()
  {
    return super.hashCode();
  }
  
  public final int id()
  {
    return this.id;
  }
  
  public final String name()
  {
    return this.name;
  }
  
  public final String toString()
  {
    return name();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\AbstractConstant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */