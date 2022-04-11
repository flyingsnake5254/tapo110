package org.apache.commons.lang.mutable;

public class MutableShort
  extends Number
  implements Comparable
{
  private static final long serialVersionUID = -2135791679L;
  private short value;
  
  public MutableShort() {}
  
  public MutableShort(Number paramNumber)
  {
    this.value = paramNumber.shortValue();
  }
  
  public MutableShort(String paramString)
    throws NumberFormatException
  {
    this.value = Short.parseShort(paramString);
  }
  
  public MutableShort(short paramShort)
  {
    this.value = ((short)paramShort);
  }
  
  public void add(Number paramNumber)
  {
    this.value = ((short)(short)(this.value + paramNumber.shortValue()));
  }
  
  public void add(short paramShort)
  {
    this.value = ((short)(short)(this.value + paramShort));
  }
  
  public int compareTo(Object paramObject)
  {
    int i = ((MutableShort)paramObject).value;
    int j = this.value;
    if (j < i) {
      i = -1;
    } else if (j == i) {
      i = 0;
    } else {
      i = 1;
    }
    return i;
  }
  
  public void decrement()
  {
    this.value = ((short)(short)(this.value - 1));
  }
  
  public double doubleValue()
  {
    return this.value;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof MutableShort;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      bool3 = bool2;
      if (this.value == ((MutableShort)paramObject).shortValue()) {
        bool3 = true;
      }
    }
    return bool3;
  }
  
  public float floatValue()
  {
    return this.value;
  }
  
  public Object getValue()
  {
    return new Short(this.value);
  }
  
  public int hashCode()
  {
    return this.value;
  }
  
  public void increment()
  {
    this.value = ((short)(short)(this.value + 1));
  }
  
  public int intValue()
  {
    return this.value;
  }
  
  public long longValue()
  {
    return this.value;
  }
  
  public void setValue(Object paramObject)
  {
    setValue(((Number)paramObject).shortValue());
  }
  
  public void setValue(short paramShort)
  {
    this.value = ((short)paramShort);
  }
  
  public short shortValue()
  {
    return this.value;
  }
  
  public void subtract(Number paramNumber)
  {
    this.value = ((short)(short)(this.value - paramNumber.shortValue()));
  }
  
  public void subtract(short paramShort)
  {
    this.value = ((short)(short)(this.value - paramShort));
  }
  
  public Short toShort()
  {
    return new Short(shortValue());
  }
  
  public String toString()
  {
    return String.valueOf(this.value);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\mutable\MutableShort.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */