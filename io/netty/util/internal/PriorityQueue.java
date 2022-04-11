package io.netty.util.internal;

import java.util.Queue;

public abstract interface PriorityQueue<T>
  extends Queue<T>
{
  public abstract void clearIgnoringIndexes();
  
  public abstract boolean containsTyped(T paramT);
  
  public abstract void priorityChanged(T paramT);
  
  public abstract boolean removeTyped(T paramT);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\PriorityQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */