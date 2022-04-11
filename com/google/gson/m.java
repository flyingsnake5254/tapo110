package com.google.gson;

import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.a;
import java.math.BigInteger;

public final class m
  extends i
{
  private final Object a;
  
  public m(Boolean paramBoolean)
  {
    this.a = a.b(paramBoolean);
  }
  
  public m(Number paramNumber)
  {
    this.a = a.b(paramNumber);
  }
  
  public m(String paramString)
  {
    this.a = a.b(paramString);
  }
  
  private static boolean o(m paramm)
  {
    paramm = paramm.a;
    boolean bool1 = paramm instanceof Number;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramm = (Number)paramm;
      if ((!(paramm instanceof BigInteger)) && (!(paramm instanceof Long)) && (!(paramm instanceof Integer)) && (!(paramm instanceof Short)))
      {
        bool3 = bool2;
        if (!(paramm instanceof Byte)) {}
      }
      else
      {
        bool3 = true;
      }
    }
    return bool3;
  }
  
  public int a()
  {
    int i;
    if (p()) {
      i = m().intValue();
    } else {
      i = Integer.parseInt(e());
    }
    return i;
  }
  
  public String e()
  {
    if (p()) {
      return m().toString();
    }
    if (n()) {
      return ((Boolean)this.a).toString();
    }
    return (String)this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3 = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (m.class == paramObject.getClass()))
    {
      paramObject = (m)paramObject;
      if (this.a == null)
      {
        if (((m)paramObject).a != null) {
          bool3 = false;
        }
        return bool3;
      }
      if ((o(this)) && (o((m)paramObject)))
      {
        if (m().longValue() == ((m)paramObject).m().longValue()) {
          bool3 = bool1;
        } else {
          bool3 = false;
        }
        return bool3;
      }
      Object localObject = this.a;
      if (((localObject instanceof Number)) && ((((m)paramObject).a instanceof Number)))
      {
        double d1 = m().doubleValue();
        double d2 = ((m)paramObject).m().doubleValue();
        bool3 = bool2;
        if (d1 != d2) {
          if ((Double.isNaN(d1)) && (Double.isNaN(d2))) {
            bool3 = bool2;
          } else {
            bool3 = false;
          }
        }
        return bool3;
      }
      return localObject.equals(((m)paramObject).a);
    }
    return false;
  }
  
  public int hashCode()
  {
    if (this.a == null) {
      return 31;
    }
    if (o(this)) {}
    Object localObject;
    for (long l = m().longValue();; l = Double.doubleToLongBits(m().doubleValue()))
    {
      return (int)(l >>> 32 ^ l);
      localObject = this.a;
      if (!(localObject instanceof Number)) {
        break;
      }
    }
    return localObject.hashCode();
  }
  
  public boolean j()
  {
    if (n()) {
      return ((Boolean)this.a).booleanValue();
    }
    return Boolean.parseBoolean(e());
  }
  
  public double k()
  {
    double d;
    if (p()) {
      d = m().doubleValue();
    } else {
      d = Double.parseDouble(e());
    }
    return d;
  }
  
  public long l()
  {
    long l;
    if (p()) {
      l = m().longValue();
    } else {
      l = Long.parseLong(e());
    }
    return l;
  }
  
  public Number m()
  {
    Object localObject = this.a;
    if ((localObject instanceof String)) {
      localObject = new LazilyParsedNumber((String)this.a);
    } else {
      localObject = (Number)localObject;
    }
    return (Number)localObject;
  }
  
  public boolean n()
  {
    return this.a instanceof Boolean;
  }
  
  public boolean p()
  {
    return this.a instanceof Number;
  }
  
  public boolean q()
  {
    return this.a instanceof String;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */