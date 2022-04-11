package io.netty.util.concurrent;

import java.util.Arrays;

final class DefaultFutureListeners
{
  private GenericFutureListener<? extends Future<?>>[] listeners;
  private int progressiveSize;
  private int size;
  
  DefaultFutureListeners(GenericFutureListener<? extends Future<?>> paramGenericFutureListener1, GenericFutureListener<? extends Future<?>> paramGenericFutureListener2)
  {
    GenericFutureListener[] arrayOfGenericFutureListener = new GenericFutureListener[2];
    this.listeners = arrayOfGenericFutureListener;
    arrayOfGenericFutureListener[0] = paramGenericFutureListener1;
    arrayOfGenericFutureListener[1] = paramGenericFutureListener2;
    this.size = 2;
    if ((paramGenericFutureListener1 instanceof GenericProgressiveFutureListener)) {
      this.progressiveSize += 1;
    }
    if ((paramGenericFutureListener2 instanceof GenericProgressiveFutureListener)) {
      this.progressiveSize += 1;
    }
  }
  
  public void add(GenericFutureListener<? extends Future<?>> paramGenericFutureListener)
  {
    GenericFutureListener[] arrayOfGenericFutureListener1 = this.listeners;
    int i = this.size;
    GenericFutureListener[] arrayOfGenericFutureListener2 = arrayOfGenericFutureListener1;
    if (i == arrayOfGenericFutureListener1.length)
    {
      arrayOfGenericFutureListener2 = (GenericFutureListener[])Arrays.copyOf(arrayOfGenericFutureListener1, i << 1);
      this.listeners = arrayOfGenericFutureListener2;
    }
    arrayOfGenericFutureListener2[i] = paramGenericFutureListener;
    this.size = (i + 1);
    if ((paramGenericFutureListener instanceof GenericProgressiveFutureListener)) {
      this.progressiveSize += 1;
    }
  }
  
  public GenericFutureListener<? extends Future<?>>[] listeners()
  {
    return this.listeners;
  }
  
  public int progressiveSize()
  {
    return this.progressiveSize;
  }
  
  public void remove(GenericFutureListener<? extends Future<?>> paramGenericFutureListener)
  {
    GenericFutureListener[] arrayOfGenericFutureListener = this.listeners;
    int i = this.size;
    for (int j = 0; j < i; j++) {
      if (arrayOfGenericFutureListener[j] == paramGenericFutureListener)
      {
        int k = i - j - 1;
        if (k > 0) {
          System.arraycopy(arrayOfGenericFutureListener, j + 1, arrayOfGenericFutureListener, j, k);
        }
        j = i - 1;
        arrayOfGenericFutureListener[j] = null;
        this.size = j;
        if ((paramGenericFutureListener instanceof GenericProgressiveFutureListener)) {
          this.progressiveSize -= 1;
        }
        return;
      }
    }
  }
  
  public int size()
  {
    return this.size;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\concurrent\DefaultFutureListeners.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */