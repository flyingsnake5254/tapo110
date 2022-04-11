package com.google.common.util.concurrent;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicLong;

public class AtomicDouble
  extends Number
  implements Serializable
{
  private static final long serialVersionUID = 0L;
  private transient AtomicLong value;
  
  public AtomicDouble()
  {
    this(0.0D);
  }
  
  public AtomicDouble(double paramDouble)
  {
    this.value = new AtomicLong(Double.doubleToRawLongBits(paramDouble));
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
    throws IOException, ClassNotFoundException
  {
    paramObjectInputStream.defaultReadObject();
    this.value = new AtomicLong();
    set(paramObjectInputStream.readDouble());
  }
  
  private void writeObject(ObjectOutputStream paramObjectOutputStream)
    throws IOException
  {
    paramObjectOutputStream.defaultWriteObject();
    paramObjectOutputStream.writeDouble(get());
  }
  
  @CanIgnoreReturnValue
  public final double addAndGet(double paramDouble)
  {
    long l1;
    double d;
    long l2;
    do
    {
      l1 = this.value.get();
      d = Double.longBitsToDouble(l1) + paramDouble;
      l2 = Double.doubleToRawLongBits(d);
    } while (!this.value.compareAndSet(l1, l2));
    return d;
  }
  
  public final boolean compareAndSet(double paramDouble1, double paramDouble2)
  {
    return this.value.compareAndSet(Double.doubleToRawLongBits(paramDouble1), Double.doubleToRawLongBits(paramDouble2));
  }
  
  public double doubleValue()
  {
    return get();
  }
  
  public float floatValue()
  {
    return (float)get();
  }
  
  public final double get()
  {
    return Double.longBitsToDouble(this.value.get());
  }
  
  @CanIgnoreReturnValue
  public final double getAndAdd(double paramDouble)
  {
    long l1;
    double d;
    long l2;
    do
    {
      l1 = this.value.get();
      d = Double.longBitsToDouble(l1);
      l2 = Double.doubleToRawLongBits(d + paramDouble);
    } while (!this.value.compareAndSet(l1, l2));
    return d;
  }
  
  public final double getAndSet(double paramDouble)
  {
    long l = Double.doubleToRawLongBits(paramDouble);
    return Double.longBitsToDouble(this.value.getAndSet(l));
  }
  
  public int intValue()
  {
    return (int)get();
  }
  
  public final void lazySet(double paramDouble)
  {
    long l = Double.doubleToRawLongBits(paramDouble);
    this.value.lazySet(l);
  }
  
  public long longValue()
  {
    return get();
  }
  
  public final void set(double paramDouble)
  {
    long l = Double.doubleToRawLongBits(paramDouble);
    this.value.set(l);
  }
  
  public String toString()
  {
    return Double.toString(get());
  }
  
  public final boolean weakCompareAndSet(double paramDouble1, double paramDouble2)
  {
    return this.value.weakCompareAndSet(Double.doubleToRawLongBits(paramDouble1), Double.doubleToRawLongBits(paramDouble2));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\util\concurrent\AtomicDouble.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */