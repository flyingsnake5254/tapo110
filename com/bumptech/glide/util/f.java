package com.bumptech.glide.util;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class f<T, Y>
{
  private final Map<T, a<Y>> a = new LinkedHashMap(100, 0.75F, true);
  private final long b;
  private long c;
  private long d;
  
  public f(long paramLong)
  {
    this.b = paramLong;
    this.c = paramLong;
  }
  
  private void f()
  {
    m(this.c);
  }
  
  public void b()
  {
    m(0L);
  }
  
  @Nullable
  public Y g(@NonNull T paramT)
  {
    try
    {
      paramT = (a)this.a.get(paramT);
      if (paramT != null) {
        paramT = paramT.a;
      } else {
        paramT = null;
      }
      return paramT;
    }
    finally {}
  }
  
  public long h()
  {
    try
    {
      long l = this.c;
      return l;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  protected int i(@Nullable Y paramY)
  {
    return 1;
  }
  
  protected void j(@NonNull T paramT, @Nullable Y paramY) {}
  
  @Nullable
  public Y k(@NonNull T paramT, @Nullable Y paramY)
  {
    try
    {
      int i = i(paramY);
      long l1 = i;
      long l2 = this.c;
      Object localObject = null;
      if (l1 >= l2)
      {
        j(paramT, paramY);
        return null;
      }
      if (paramY != null) {
        this.d += l1;
      }
      Map localMap = this.a;
      if (paramY == null) {
        locala = null;
      } else {
        locala = new a(paramY, i);
      }
      a locala = (a)localMap.put(paramT, locala);
      if (locala != null)
      {
        this.d -= locala.b;
        if (!locala.a.equals(paramY)) {
          j(paramT, locala.a);
        }
      }
      f();
      paramT = (T)localObject;
      if (locala != null) {
        paramT = locala.a;
      }
      return paramT;
    }
    finally {}
  }
  
  @Nullable
  public Y l(@NonNull T paramT)
  {
    try
    {
      paramT = (a)this.a.remove(paramT);
      if (paramT == null) {
        return null;
      }
      this.d -= paramT.b;
      paramT = paramT.a;
      return paramT;
    }
    finally {}
  }
  
  protected void m(long paramLong)
  {
    try
    {
      while (this.d > paramLong)
      {
        Iterator localIterator = this.a.entrySet().iterator();
        Object localObject2 = (Map.Entry)localIterator.next();
        a locala = (a)((Map.Entry)localObject2).getValue();
        this.d -= locala.b;
        localObject2 = ((Map.Entry)localObject2).getKey();
        localIterator.remove();
        j(localObject2, locala.a);
      }
      return;
    }
    finally
    {
      localObject1 = finally;
      throw ((Throwable)localObject1);
    }
  }
  
  static final class a<Y>
  {
    final Y a;
    final int b;
    
    a(Y paramY, int paramInt)
    {
      this.a = paramY;
      this.b = paramInt;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\util\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */