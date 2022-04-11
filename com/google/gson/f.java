package com.google.gson;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class f
  extends i
  implements Iterable<i>
{
  private final List<i> c = new ArrayList();
  
  public int a()
  {
    if (this.c.size() == 1) {
      return ((i)this.c.get(0)).a();
    }
    throw new IllegalStateException();
  }
  
  public String e()
  {
    if (this.c.size() == 1) {
      return ((i)this.c.get(0)).e();
    }
    throw new IllegalStateException();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool;
    if ((paramObject != this) && ((!(paramObject instanceof f)) || (!((f)paramObject).c.equals(this.c)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public int hashCode()
  {
    return this.c.hashCode();
  }
  
  public Iterator<i> iterator()
  {
    return this.c.iterator();
  }
  
  public void j(i parami)
  {
    Object localObject = parami;
    if (parami == null) {
      localObject = j.a;
    }
    this.c.add(localObject);
  }
  
  public void k(Number paramNumber)
  {
    List localList = this.c;
    if (paramNumber == null) {
      paramNumber = j.a;
    } else {
      paramNumber = new m(paramNumber);
    }
    localList.add(paramNumber);
  }
  
  public boolean l(i parami)
  {
    return this.c.contains(parami);
  }
  
  public int size()
  {
    return this.c.size();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */