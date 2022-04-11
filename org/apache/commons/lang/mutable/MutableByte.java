package org.apache.commons.lang.mutable;

public class MutableByte
  extends Number
  implements Comparable
{
  private static final long serialVersionUID = -1585823265L;
  private byte value;
  
  public MutableByte() {}
  
  public MutableByte(byte paramByte)
  {
    this.value = ((byte)paramByte);
  }
  
  public MutableByte(Number paramNumber)
  {
    this.value = paramNumber.byteValue();
  }
  
  public MutableByte(String paramString)
    throws NumberFormatException
  {
    this.value = Byte.parseByte(paramString);
  }
  
  public void add(byte paramByte)
  {
    this.value = ((byte)(byte)(this.value + paramByte));
  }
  
  public void add(Number paramNumber)
  {
    this.value = ((byte)(byte)(this.value + paramNumber.byteValue()));
  }
  
  public byte byteValue()
  {
    return this.value;
  }
  
  public int compareTo(Object paramObject)
  {
    int i = ((MutableByte)paramObject).value;
    int j = this.value;
    if (j < i) {
      j = -1;
    } else if (j == i) {
      j = 0;
    } else {
      j = 1;
    }
    return j;
  }
  
  public void decrement()
  {
    this.value = ((byte)(byte)(this.value - 1));
  }
  
  public double doubleValue()
  {
    return this.value;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof MutableByte;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      bool3 = bool2;
      if (this.value == ((MutableByte)paramObject).byteValue()) {
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
    return new Byte(this.value);
  }
  
  public int hashCode()
  {
    return this.value;
  }
  
  public void increment()
  {
    this.value = ((byte)(byte)(this.value + 1));
  }
  
  public int intValue()
  {
    return this.value;
  }
  
  public long longValue()
  {
    return this.value;
  }
  
  public void setValue(byte paramByte)
  {
    this.value = ((byte)paramByte);
  }
  
  public void setValue(Object paramObject)
  {
    setValue(((Number)paramObject).byteValue());
  }
  
  public void subtract(byte paramByte)
  {
    this.value = ((byte)(byte)(this.value - paramByte));
  }
  
  public void subtract(Number paramNumber)
  {
    this.value = ((byte)(byte)(this.value - paramNumber.byteValue()));
  }
  
  public Byte toByte()
  {
    return new Byte(byteValue());
  }
  
  public String toString()
  {
    return String.valueOf(this.value);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\mutable\MutableByte.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */