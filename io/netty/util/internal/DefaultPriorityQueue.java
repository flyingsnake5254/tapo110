package io.netty.util.internal;

import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class DefaultPriorityQueue<T extends PriorityQueueNode>
  extends AbstractQueue<T>
  implements PriorityQueue<T>
{
  private static final PriorityQueueNode[] EMPTY_ARRAY = new PriorityQueueNode[0];
  private final Comparator<T> comparator;
  private T[] queue;
  private int size;
  
  public DefaultPriorityQueue(Comparator<T> paramComparator, int paramInt)
  {
    this.comparator = ((Comparator)ObjectUtil.checkNotNull(paramComparator, "comparator"));
    if (paramInt != 0) {
      paramComparator = new PriorityQueueNode[paramInt];
    } else {
      paramComparator = EMPTY_ARRAY;
    }
    this.queue = paramComparator;
  }
  
  private void bubbleDown(int paramInt, T paramT)
  {
    int i = this.size;
    for (int j = paramInt; j < i >>> 1; j = paramInt)
    {
      int k = (j << 1) + 1;
      PriorityQueueNode[] arrayOfPriorityQueueNode = this.queue;
      PriorityQueueNode localPriorityQueueNode1 = arrayOfPriorityQueueNode[k];
      int m = k + 1;
      paramInt = k;
      PriorityQueueNode localPriorityQueueNode2 = localPriorityQueueNode1;
      if (m < this.size)
      {
        paramInt = k;
        localPriorityQueueNode2 = localPriorityQueueNode1;
        if (this.comparator.compare(localPriorityQueueNode1, arrayOfPriorityQueueNode[m]) > 0)
        {
          localPriorityQueueNode2 = this.queue[m];
          paramInt = m;
        }
      }
      if (this.comparator.compare(paramT, localPriorityQueueNode2) <= 0) {
        break;
      }
      this.queue[j] = localPriorityQueueNode2;
      localPriorityQueueNode2.priorityQueueIndex(this, j);
    }
    this.queue[j] = paramT;
    paramT.priorityQueueIndex(this, j);
  }
  
  private void bubbleUp(int paramInt, T paramT)
  {
    while (paramInt > 0)
    {
      int i = paramInt - 1 >>> 1;
      PriorityQueueNode localPriorityQueueNode = this.queue[i];
      if (this.comparator.compare(paramT, localPriorityQueueNode) >= 0) {
        break;
      }
      this.queue[paramInt] = localPriorityQueueNode;
      localPriorityQueueNode.priorityQueueIndex(this, paramInt);
      paramInt = i;
    }
    this.queue[paramInt] = paramT;
    paramT.priorityQueueIndex(this, paramInt);
  }
  
  private boolean contains(PriorityQueueNode paramPriorityQueueNode, int paramInt)
  {
    boolean bool;
    if ((paramInt >= 0) && (paramInt < this.size) && (paramPriorityQueueNode.equals(this.queue[paramInt]))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void clear()
  {
    for (int i = 0; i < this.size; i++)
    {
      PriorityQueueNode localPriorityQueueNode = this.queue[i];
      if (localPriorityQueueNode != null)
      {
        localPriorityQueueNode.priorityQueueIndex(this, -1);
        this.queue[i] = null;
      }
    }
    this.size = 0;
  }
  
  public void clearIgnoringIndexes()
  {
    this.size = 0;
  }
  
  public boolean contains(Object paramObject)
  {
    if (!(paramObject instanceof PriorityQueueNode)) {
      return false;
    }
    paramObject = (PriorityQueueNode)paramObject;
    return contains((PriorityQueueNode)paramObject, ((PriorityQueueNode)paramObject).priorityQueueIndex(this));
  }
  
  public boolean containsTyped(T paramT)
  {
    return contains(paramT, paramT.priorityQueueIndex(this));
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (this.size == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Iterator<T> iterator()
  {
    return new PriorityQueueIterator(null);
  }
  
  public boolean offer(T paramT)
  {
    if (paramT.priorityQueueIndex(this) == -1)
    {
      int i = this.size;
      localObject = this.queue;
      if (i >= localObject.length)
      {
        int j = localObject.length;
        if (localObject.length < 64) {
          i = localObject.length + 2;
        } else {
          i = localObject.length >>> 1;
        }
        this.queue = ((PriorityQueueNode[])Arrays.copyOf((Object[])localObject, j + i));
      }
      i = this.size;
      this.size = (i + 1);
      bubbleUp(i, paramT);
      return true;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("e.priorityQueueIndex(): ");
    ((StringBuilder)localObject).append(paramT.priorityQueueIndex(this));
    ((StringBuilder)localObject).append(" (expected: ");
    ((StringBuilder)localObject).append(-1);
    ((StringBuilder)localObject).append(") + e: ");
    ((StringBuilder)localObject).append(paramT);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public T peek()
  {
    PriorityQueueNode localPriorityQueueNode;
    if (this.size == 0) {
      localPriorityQueueNode = null;
    } else {
      localPriorityQueueNode = this.queue[0];
    }
    return localPriorityQueueNode;
  }
  
  public T poll()
  {
    if (this.size == 0) {
      return null;
    }
    PriorityQueueNode localPriorityQueueNode1 = this.queue[0];
    localPriorityQueueNode1.priorityQueueIndex(this, -1);
    PriorityQueueNode[] arrayOfPriorityQueueNode = this.queue;
    int i = this.size - 1;
    this.size = i;
    PriorityQueueNode localPriorityQueueNode2 = arrayOfPriorityQueueNode[i];
    arrayOfPriorityQueueNode[i] = null;
    if (i != 0) {
      bubbleDown(0, localPriorityQueueNode2);
    }
    return localPriorityQueueNode1;
  }
  
  public void priorityChanged(T paramT)
  {
    int i = paramT.priorityQueueIndex(this);
    if (!contains(paramT, i)) {
      return;
    }
    if (i == 0)
    {
      bubbleDown(i, paramT);
    }
    else
    {
      PriorityQueueNode localPriorityQueueNode = this.queue[(i - 1 >>> 1)];
      if (this.comparator.compare(paramT, localPriorityQueueNode) < 0) {
        bubbleUp(i, paramT);
      } else {
        bubbleDown(i, paramT);
      }
    }
  }
  
  public boolean remove(Object paramObject)
  {
    try
    {
      paramObject = (PriorityQueueNode)paramObject;
      return removeTyped((PriorityQueueNode)paramObject);
    }
    catch (ClassCastException paramObject) {}
    return false;
  }
  
  public boolean removeTyped(T paramT)
  {
    int i = paramT.priorityQueueIndex(this);
    if (!contains(paramT, i)) {
      return false;
    }
    paramT.priorityQueueIndex(this, -1);
    int j = this.size - 1;
    this.size = j;
    if ((j != 0) && (j != i))
    {
      PriorityQueueNode[] arrayOfPriorityQueueNode = this.queue;
      PriorityQueueNode localPriorityQueueNode = arrayOfPriorityQueueNode[j];
      arrayOfPriorityQueueNode[i] = localPriorityQueueNode;
      arrayOfPriorityQueueNode[j] = null;
      if (this.comparator.compare(paramT, localPriorityQueueNode) < 0) {
        bubbleDown(i, localPriorityQueueNode);
      } else {
        bubbleUp(i, localPriorityQueueNode);
      }
      return true;
    }
    this.queue[i] = null;
    return true;
  }
  
  public int size()
  {
    return this.size;
  }
  
  public Object[] toArray()
  {
    return Arrays.copyOf(this.queue, this.size);
  }
  
  public <X> X[] toArray(X[] paramArrayOfX)
  {
    int i = paramArrayOfX.length;
    int j = this.size;
    if (i < j) {
      return Arrays.copyOf(this.queue, j, paramArrayOfX.getClass());
    }
    System.arraycopy(this.queue, 0, paramArrayOfX, 0, j);
    j = paramArrayOfX.length;
    i = this.size;
    if (j > i) {
      paramArrayOfX[i] = null;
    }
    return paramArrayOfX;
  }
  
  private final class PriorityQueueIterator
    implements Iterator<T>
  {
    private int index;
    
    private PriorityQueueIterator() {}
    
    public boolean hasNext()
    {
      boolean bool;
      if (this.index < DefaultPriorityQueue.this.size) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public T next()
    {
      if (this.index < DefaultPriorityQueue.this.size)
      {
        PriorityQueueNode[] arrayOfPriorityQueueNode = DefaultPriorityQueue.this.queue;
        int i = this.index;
        this.index = (i + 1);
        return arrayOfPriorityQueueNode[i];
      }
      throw new NoSuchElementException();
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException("remove");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\DefaultPriorityQueue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */