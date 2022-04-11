package org.apache.commons.lang.math;

import java.io.Serializable;

public final class LongRange
  extends b
  implements Serializable
{
  private static final long serialVersionUID = 71849363892720L;
  private transient int hashCode = 0;
  private final long max;
  private transient Long maxObject = null;
  private final long min;
  private transient Long minObject = null;
  private transient String toString = null;
  
  public LongRange(long paramLong)
  {
    this.min = paramLong;
    this.max = paramLong;
  }
  
  public LongRange(long paramLong1, long paramLong2)
  {
    if (paramLong2 < paramLong1)
    {
      this.min = paramLong2;
      this.max = paramLong1;
    }
    else
    {
      this.min = paramLong1;
      this.max = paramLong2;
    }
  }
  
  public LongRange(Number paramNumber)
  {
    if (paramNumber != null)
    {
      this.min = paramNumber.longValue();
      this.max = paramNumber.longValue();
      if ((paramNumber instanceof Long))
      {
        paramNumber = (Long)paramNumber;
        this.minObject = paramNumber;
        this.maxObject = paramNumber;
      }
      return;
    }
    throw new IllegalArgumentException("The number must not be null");
  }
  
  public LongRange(Number paramNumber1, Number paramNumber2)
  {
    if ((paramNumber1 != null) && (paramNumber2 != null))
    {
      long l1 = paramNumber1.longValue();
      long l2 = paramNumber2.longValue();
      if (l2 < l1)
      {
        this.min = l2;
        this.max = l1;
        if ((paramNumber2 instanceof Long)) {
          this.minObject = ((Long)paramNumber2);
        }
        if ((paramNumber1 instanceof Long)) {
          this.maxObject = ((Long)paramNumber1);
        }
      }
      else
      {
        this.min = l1;
        this.max = l2;
        if ((paramNumber1 instanceof Long)) {
          this.minObject = ((Long)paramNumber1);
        }
        if ((paramNumber2 instanceof Long)) {
          this.maxObject = ((Long)paramNumber2);
        }
      }
      return;
    }
    throw new IllegalArgumentException("The numbers must not be null");
  }
  
  public boolean containsLong(long paramLong)
  {
    boolean bool;
    if ((paramLong >= this.min) && (paramLong <= this.max)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean containsNumber(Number paramNumber)
  {
    if (paramNumber == null) {
      return false;
    }
    return containsLong(paramNumber.longValue());
  }
  
  public boolean containsRange(b paramb)
  {
    boolean bool1 = false;
    if (paramb == null) {
      return false;
    }
    boolean bool2 = bool1;
    if (containsLong(paramb.getMinimumLong()))
    {
      bool2 = bool1;
      if (containsLong(paramb.getMaximumLong())) {
        bool2 = true;
      }
    }
    return bool2;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof LongRange)) {
      return false;
    }
    paramObject = (LongRange)paramObject;
    if ((this.min != ((LongRange)paramObject).min) || (this.max != ((LongRange)paramObject).max)) {
      bool = false;
    }
    return bool;
  }
  
  public double getMaximumDouble()
  {
    return this.max;
  }
  
  public float getMaximumFloat()
  {
    return (float)this.max;
  }
  
  public int getMaximumInteger()
  {
    return (int)this.max;
  }
  
  public long getMaximumLong()
  {
    return this.max;
  }
  
  public Number getMaximumNumber()
  {
    if (this.maxObject == null) {
      this.maxObject = new Long(this.max);
    }
    return this.maxObject;
  }
  
  public double getMinimumDouble()
  {
    return this.min;
  }
  
  public float getMinimumFloat()
  {
    return (float)this.min;
  }
  
  public int getMinimumInteger()
  {
    return (int)this.min;
  }
  
  public long getMinimumLong()
  {
    return this.min;
  }
  
  public Number getMinimumNumber()
  {
    if (this.minObject == null) {
      this.minObject = new Long(this.min);
    }
    return this.minObject;
  }
  
  public int hashCode()
  {
    if (this.hashCode == 0)
    {
      this.hashCode = 17;
      int i = 17 * 37 + LongRange.class.hashCode();
      this.hashCode = i;
      long l = this.min;
      i = i * 37 + (int)(l ^ l >> 32);
      this.hashCode = i;
      l = this.max;
      this.hashCode = (i * 37 + (int)(l ^ l >> 32));
    }
    return this.hashCode;
  }
  
  public boolean overlapsRange(b paramb)
  {
    boolean bool = false;
    if (paramb == null) {
      return false;
    }
    if ((paramb.containsLong(this.min)) || (paramb.containsLong(this.max)) || (containsLong(paramb.getMinimumLong()))) {
      bool = true;
    }
    return bool;
  }
  
  public long[] toArray()
  {
    int i = (int)(this.max - this.min + 1L);
    long[] arrayOfLong = new long[i];
    for (int j = 0; j < i; j++) {
      arrayOfLong[j] = (this.min + j);
    }
    return arrayOfLong;
  }
  
  public String toString()
  {
    if (this.toString == null)
    {
      org.apache.commons.lang.text.b localb = new org.apache.commons.lang.text.b(32);
      localb.f("Range[");
      localb.d(this.min);
      localb.a(',');
      localb.d(this.max);
      localb.a(']');
      this.toString = localb.toString();
    }
    return this.toString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\math\LongRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */