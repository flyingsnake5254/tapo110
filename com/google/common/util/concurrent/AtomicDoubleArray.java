package com.google.common.util.concurrent;

import com.google.common.primitives.ImmutableLongArray;
import com.google.common.primitives.ImmutableLongArray.c;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLongArray;

public class AtomicDoubleArray
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  private transient AtomicLongArray longs;
  
  public AtomicDoubleArray(int paramInt)
  {
    this.longs = new AtomicLongArray(paramInt);
  }
  
  public AtomicDoubleArray(double[] paramArrayOfDouble)
  {
    int i = paramArrayOfDouble.length;
    long[] arrayOfLong = new long[i];
    for (int j = 0; j < i; j++) {
      arrayOfLong[j] = Double.doubleToRawLongBits(paramArrayOfDouble[j]);
    }
    this.longs = new AtomicLongArray(arrayOfLong);
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    int i = paramObjectInputStream.readInt();
    ImmutableLongArray.c localc = ImmutableLongArray.builder();
    for (int j = 0; j < i; j++) {
      localc.a(Double.doubleToRawLongBits(paramObjectInputStream.readDouble()));
    }
    this.longs = new AtomicLongArray(localc.d().toArray());
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    int i = length();
    paramObjectOutputStream.writeInt(i);
    for (int j = 0; j < i; j++) {
      paramObjectOutputStream.writeDouble(get(j));
    }
  }
  
  @CanIgnoreReturnValue
  public double addAndGet(int paramInt, double paramDouble)
  {
    long l1;
    double d;
    long l2;
    do
    {
      l1 = this.longs.get(paramInt);
      d = Double.longBitsToDouble(l1) + paramDouble;
      l2 = Double.doubleToRawLongBits(d);
    } while (!this.longs.compareAndSet(paramInt, l1, l2));
    return d;
  }
  
  public final boolean compareAndSet(int paramInt, double paramDouble1, double paramDouble2)
  {
    return this.longs.compareAndSet(paramInt, Double.doubleToRawLongBits(paramDouble1), Double.doubleToRawLongBits(paramDouble2));
  }
  
  public final double get(int paramInt)
  {
    return Double.longBitsToDouble(this.longs.get(paramInt));
  }
  
  @CanIgnoreReturnValue
  public final double getAndAdd(int paramInt, double paramDouble)
  {
    long l1;
    double d;
    long l2;
    do
    {
      l1 = this.longs.get(paramInt);
      d = Double.longBitsToDouble(l1);
      l2 = Double.doubleToRawLongBits(d + paramDouble);
    } while (!this.longs.compareAndSet(paramInt, l1, l2));
    return d;
  }
  
  public final double getAndSet(int paramInt, double paramDouble)
  {
    long l = Double.doubleToRawLongBits(paramDouble);
    return Double.longBitsToDouble(this.longs.getAndSet(paramInt, l));
  }
  
  public final void lazySet(int paramInt, double paramDouble)
  {
    long l = Double.doubleToRawLongBits(paramDouble);
    this.longs.lazySet(paramInt, l);
  }
  
  public final int length()
  {
    return this.longs.length();
  }
  
  public final void set(int paramInt, double paramDouble)
  {
    long l = Double.doubleToRawLongBits(paramDouble);
    this.longs.set(paramInt, l);
  }
  
  public String toString()
  {
    int i = length() - 1;
    if (i == -1) {
      return "[]";
    }
    StringBuilder localStringBuilder = new StringBuilder((i + 1) * 19);
    localStringBuilder.append('[');
    for (int j = 0;; j++)
    {
      localStringBuilder.append(Double.longBitsToDouble(this.longs.get(j)));
      if (j == i)
      {
        localStringBuilder.append(']');
        return localStringBuilder.toString();
      }
      localStringBuilder.append(',');
      localStringBuilder.append(' ');
    }
  }
  
  public final boolean weakCompareAndSet(int paramInt, double paramDouble1, double paramDouble2)
  {
    return this.longs.weakCompareAndSet(paramInt, Double.doubleToRawLongBits(paramDouble1), Double.doubleToRawLongBits(paramDouble2));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\util\concurrent\AtomicDoubleArray.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */