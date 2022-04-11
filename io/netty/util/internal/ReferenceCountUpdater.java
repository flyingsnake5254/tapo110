package io.netty.util.internal;

import io.netty.util.IllegalReferenceCountException;
import io.netty.util.ReferenceCounted;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public abstract class ReferenceCountUpdater<T extends ReferenceCounted>
{
  public static long getUnsafeOffset(Class<? extends ReferenceCounted> paramClass, String paramString)
  {
    try
    {
      if (PlatformDependent.hasUnsafe())
      {
        long l = PlatformDependent.objectFieldOffset(paramClass.getDeclaredField(paramString));
        return l;
      }
    }
    finally
    {
      for (;;) {}
    }
    return -1L;
  }
  
  private boolean nonFinalRelease0(T paramT, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 < paramInt3) && (updater().compareAndSet(paramT, paramInt2, paramInt2 - (paramInt1 << 1)))) {
      return false;
    }
    return retryRelease0(paramT, paramInt1);
  }
  
  private int nonVolatileRawCnt(T paramT)
  {
    long l = unsafeOffset();
    int i;
    if (l != -1L) {
      i = PlatformDependent.getInt(paramT, l);
    } else {
      i = updater().get(paramT);
    }
    return i;
  }
  
  private static int realRefCnt(int paramInt)
  {
    if ((paramInt != 2) && (paramInt != 4) && ((paramInt & 0x1) != 0)) {
      paramInt = 0;
    } else {
      paramInt >>>= 1;
    }
    return paramInt;
  }
  
  private T retain0(T paramT, int paramInt1, int paramInt2)
  {
    int i = updater().getAndAdd(paramT, paramInt2);
    if ((i != 2) && (i != 4) && ((i & 0x1) != 0)) {
      throw new IllegalReferenceCountException(0, paramInt1);
    }
    if (((i <= 0) && (i + paramInt2 >= 0)) || ((i >= 0) && (i + paramInt2 < i)))
    {
      updater().getAndAdd(paramT, -paramInt2);
      throw new IllegalReferenceCountException(realRefCnt(i), paramInt1);
    }
    return paramT;
  }
  
  private boolean retryRelease0(T paramT, int paramInt)
  {
    int j;
    for (;;)
    {
      int i = updater().get(paramT);
      j = toLiveRealRefCnt(i, paramInt);
      if (paramInt == j)
      {
        if (tryFinalRelease0(paramT, i)) {
          return true;
        }
      }
      else
      {
        if (paramInt >= j) {
          break;
        }
        if (updater().compareAndSet(paramT, i, i - (paramInt << 1))) {
          return false;
        }
      }
      Thread.yield();
    }
    throw new IllegalReferenceCountException(j, -paramInt);
  }
  
  private static int toLiveRealRefCnt(int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 2) && (paramInt1 != 4) && ((paramInt1 & 0x1) != 0)) {
      throw new IllegalReferenceCountException(0, -paramInt2);
    }
    return paramInt1 >>> 1;
  }
  
  private boolean tryFinalRelease0(T paramT, int paramInt)
  {
    return updater().compareAndSet(paramT, paramInt, 1);
  }
  
  public final int initialValue()
  {
    return 2;
  }
  
  public final boolean isLiveNonVolatile(T paramT)
  {
    long l = unsafeOffset();
    int i;
    if (l != -1L) {
      i = PlatformDependent.getInt(paramT, l);
    } else {
      i = updater().get(paramT);
    }
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (i != 2)
    {
      bool2 = bool1;
      if (i != 4)
      {
        bool2 = bool1;
        if (i != 6)
        {
          bool2 = bool1;
          if (i != 8) {
            if ((i & 0x1) == 0) {
              bool2 = bool1;
            } else {
              bool2 = false;
            }
          }
        }
      }
    }
    return bool2;
  }
  
  public final int refCnt(T paramT)
  {
    return realRefCnt(updater().get(paramT));
  }
  
  public final boolean release(T paramT)
  {
    int i = nonVolatileRawCnt(paramT);
    boolean bool1 = true;
    boolean bool2;
    if (i == 2)
    {
      bool2 = bool1;
      if (!tryFinalRelease0(paramT, 2)) {
        if (retryRelease0(paramT, 1)) {
          bool2 = bool1;
        } else {
          bool2 = false;
        }
      }
    }
    else
    {
      bool2 = nonFinalRelease0(paramT, 1, i, toLiveRealRefCnt(i, 1));
    }
    return bool2;
  }
  
  public final boolean release(T paramT, int paramInt)
  {
    int i = nonVolatileRawCnt(paramT);
    int j = toLiveRealRefCnt(i, ObjectUtil.checkPositive(paramInt, "decrement"));
    boolean bool;
    if (paramInt == j)
    {
      if ((!tryFinalRelease0(paramT, i)) && (!retryRelease0(paramT, paramInt))) {
        bool = false;
      } else {
        bool = true;
      }
    }
    else {
      bool = nonFinalRelease0(paramT, paramInt, i, j);
    }
    return bool;
  }
  
  public final void resetRefCnt(T paramT)
  {
    updater().set(paramT, initialValue());
  }
  
  public final T retain(T paramT)
  {
    return retain0(paramT, 1, 2);
  }
  
  public final T retain(T paramT, int paramInt)
  {
    return retain0(paramT, paramInt, ObjectUtil.checkPositive(paramInt, "increment") << 1);
  }
  
  public final void setRefCnt(T paramT, int paramInt)
  {
    AtomicIntegerFieldUpdater localAtomicIntegerFieldUpdater = updater();
    int i = 1;
    if (paramInt > 0) {
      i = paramInt << 1;
    }
    localAtomicIntegerFieldUpdater.set(paramT, i);
  }
  
  protected abstract long unsafeOffset();
  
  protected abstract AtomicIntegerFieldUpdater<T> updater();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\ReferenceCountUpdater.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */