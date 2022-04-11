package org.apache.commons.lang.mutable;

import java.io.Serializable;

public class MutableObject
  implements Serializable
{
  private static final long serialVersionUID = 86241875189L;
  private Object value;
  
  public MutableObject() {}
  
  public MutableObject(Object paramObject)
  {
    this.value = paramObject;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof MutableObject;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramObject = ((MutableObject)paramObject).value;
      Object localObject = this.value;
      if (localObject != paramObject)
      {
        bool3 = bool2;
        if (localObject != null)
        {
          bool3 = bool2;
          if (!localObject.equals(paramObject)) {}
        }
      }
      else
      {
        bool3 = true;
      }
    }
    return bool3;
  }
  
  public Object getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    Object localObject = this.value;
    int i;
    if (localObject == null) {
      i = 0;
    } else {
      i = localObject.hashCode();
    }
    return i;
  }
  
  public void setValue(Object paramObject)
  {
    this.value = paramObject;
  }
  
  public String toString()
  {
    Object localObject = this.value;
    if (localObject == null) {
      localObject = "null";
    } else {
      localObject = localObject.toString();
    }
    return (String)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\mutable\MutableObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */