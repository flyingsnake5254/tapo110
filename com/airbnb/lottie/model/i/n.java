package com.airbnb.lottie.model.i;

import com.airbnb.lottie.w.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

abstract class n<V, O>
  implements m<V, O>
{
  final List<a<V>> a;
  
  n(V paramV)
  {
    this(Collections.singletonList(new a(paramV)));
  }
  
  n(List<a<V>> paramList)
  {
    this.a = paramList;
  }
  
  public List<a<V>> b()
  {
    return this.a;
  }
  
  public boolean c()
  {
    boolean bool1 = this.a.isEmpty();
    boolean bool2 = false;
    if (!bool1)
    {
      bool1 = bool2;
      if (this.a.size() == 1)
      {
        bool1 = bool2;
        if (!((a)this.a.get(0)).h()) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (!this.a.isEmpty())
    {
      localStringBuilder.append("values=");
      localStringBuilder.append(Arrays.toString(this.a.toArray()));
    }
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\i\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */