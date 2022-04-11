package org.apache.commons.lang.mutable;

import java.io.Serializable;
import org.apache.commons.lang.b;

public class MutableBoolean
  implements Serializable, Comparable
{
  private static final long serialVersionUID = -4830728138360036487L;
  private boolean value;
  
  public MutableBoolean() {}
  
  public MutableBoolean(Boolean paramBoolean)
  {
    this.value = paramBoolean.booleanValue();
  }
  
  public MutableBoolean(boolean paramBoolean)
  {
    this.value = paramBoolean;
  }
  
  public boolean booleanValue()
  {
    return this.value;
  }
  
  public int compareTo(Object paramObject)
  {
    boolean bool1 = ((MutableBoolean)paramObject).value;
    boolean bool2 = this.value;
    int i;
    if (bool2 == bool1) {
      i = 0;
    } else if (bool2) {
      i = 1;
    } else {
      i = -1;
    }
    return i;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof MutableBoolean;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      bool3 = bool2;
      if (this.value == ((MutableBoolean)paramObject).booleanValue()) {
        bool3 = true;
      }
    }
    return bool3;
  }
  
  public Object getValue()
  {
    return b.c(this.value);
  }
  
  public int hashCode()
  {
    Boolean localBoolean;
    if (this.value) {
      localBoolean = Boolean.TRUE;
    } else {
      localBoolean = Boolean.FALSE;
    }
    return localBoolean.hashCode();
  }
  
  public boolean isFalse()
  {
    return this.value ^ true;
  }
  
  public boolean isTrue()
  {
    boolean bool1 = this.value;
    boolean bool2 = true;
    if (bool1 != true) {
      bool2 = false;
    }
    return bool2;
  }
  
  public void setValue(Object paramObject)
  {
    setValue(((Boolean)paramObject).booleanValue());
  }
  
  public void setValue(boolean paramBoolean)
  {
    this.value = paramBoolean;
  }
  
  public Boolean toBoolean()
  {
    return b.c(this.value);
  }
  
  public String toString()
  {
    return String.valueOf(this.value);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\mutable\MutableBoolean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */