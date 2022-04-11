package com.bumptech.glide.load.engine.z;

import android.util.Log;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public final class j
  implements b
{
  private final h<a, Object> a = new h();
  private final b b = new b();
  private final Map<Class<?>, NavigableMap<Integer, Integer>> c = new HashMap();
  private final Map<Class<?>, a<?>> d = new HashMap();
  private final int e;
  private int f;
  
  public j(int paramInt)
  {
    this.e = paramInt;
  }
  
  private void f(int paramInt, Class<?> paramClass)
  {
    NavigableMap localNavigableMap = m(paramClass);
    paramClass = (Integer)localNavigableMap.get(Integer.valueOf(paramInt));
    if (paramClass != null)
    {
      if (paramClass.intValue() == 1) {
        localNavigableMap.remove(Integer.valueOf(paramInt));
      } else {
        localNavigableMap.put(Integer.valueOf(paramInt), Integer.valueOf(paramClass.intValue() - 1));
      }
      return;
    }
    paramClass = new StringBuilder();
    paramClass.append("Tried to decrement empty size, size: ");
    paramClass.append(paramInt);
    paramClass.append(", this: ");
    paramClass.append(this);
    throw new NullPointerException(paramClass.toString());
  }
  
  private void g()
  {
    h(this.e);
  }
  
  private void h(int paramInt)
  {
    while (this.f > paramInt)
    {
      Object localObject = this.a.f();
      com.bumptech.glide.util.i.d(localObject);
      a locala = i(localObject);
      this.f -= locala.b(localObject) * locala.a();
      f(locala.b(localObject), localObject.getClass());
      if (Log.isLoggable(locala.getTag(), 2))
      {
        String str = locala.getTag();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("evicted: ");
        localStringBuilder.append(locala.b(localObject));
        Log.v(str, localStringBuilder.toString());
      }
    }
  }
  
  private <T> a<T> i(T paramT)
  {
    return j(paramT.getClass());
  }
  
  private <T> a<T> j(Class<T> paramClass)
  {
    a locala = (a)this.d.get(paramClass);
    Object localObject = locala;
    if (locala == null)
    {
      if (paramClass.equals(int[].class))
      {
        localObject = new i();
      }
      else
      {
        if (!paramClass.equals(byte[].class)) {
          break label72;
        }
        localObject = new g();
      }
      this.d.put(paramClass, localObject);
      return (a<T>)localObject;
      label72:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No array pool found for: ");
      ((StringBuilder)localObject).append(paramClass.getSimpleName());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    return (a<T>)localObject;
  }
  
  @Nullable
  private <T> T k(a parama)
  {
    return (T)this.a.a(parama);
  }
  
  private <T> T l(a parama, Class<T> paramClass)
  {
    a locala = j(paramClass);
    Object localObject = k(parama);
    if (localObject != null)
    {
      this.f -= locala.b(localObject) * locala.a();
      f(locala.b(localObject), paramClass);
    }
    paramClass = (Class<T>)localObject;
    if (localObject == null)
    {
      if (Log.isLoggable(locala.getTag(), 2))
      {
        paramClass = locala.getTag();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Allocated ");
        ((StringBuilder)localObject).append(parama.b);
        ((StringBuilder)localObject).append(" bytes");
        Log.v(paramClass, ((StringBuilder)localObject).toString());
      }
      paramClass = locala.newArray(parama.b);
    }
    return paramClass;
  }
  
  private NavigableMap<Integer, Integer> m(Class<?> paramClass)
  {
    NavigableMap localNavigableMap = (NavigableMap)this.c.get(paramClass);
    Object localObject = localNavigableMap;
    if (localNavigableMap == null)
    {
      localObject = new TreeMap();
      this.c.put(paramClass, localObject);
    }
    return (NavigableMap<Integer, Integer>)localObject;
  }
  
  private boolean n()
  {
    int i = this.f;
    boolean bool;
    if ((i != 0) && (this.e / i < 2)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private boolean o(int paramInt)
  {
    boolean bool;
    if (paramInt <= this.e / 2) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean p(int paramInt, Integer paramInteger)
  {
    boolean bool;
    if ((paramInteger != null) && ((n()) || (paramInteger.intValue() <= paramInt * 8))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public void a(int paramInt)
  {
    if (paramInt >= 40) {
      try
      {
        b();
      }
      finally
      {
        break label44;
      }
    } else if ((paramInt >= 20) || (paramInt == 15)) {
      h(this.e / 2);
    }
    return;
    label44:
    throw ((Throwable)localObject);
  }
  
  public void b()
  {
    try
    {
      h(0);
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public <T> T c(int paramInt, Class<T> paramClass)
  {
    try
    {
      Object localObject = (Integer)m(paramClass).ceilingKey(Integer.valueOf(paramInt));
      if (p(paramInt, (Integer)localObject)) {
        localObject = this.b.e(((Integer)localObject).intValue(), paramClass);
      } else {
        localObject = this.b.e(paramInt, paramClass);
      }
      paramClass = l((a)localObject, paramClass);
      return paramClass;
    }
    finally {}
  }
  
  public <T> T d(int paramInt, Class<T> paramClass)
  {
    try
    {
      paramClass = l(this.b.e(paramInt, paramClass), paramClass);
      return paramClass;
    }
    finally
    {
      paramClass = finally;
      throw paramClass;
    }
  }
  
  public <T> void e(T paramT)
  {
    try
    {
      Object localObject1 = paramT.getClass();
      Object localObject2 = j((Class)localObject1);
      int i = ((a)localObject2).b(paramT);
      int j = ((a)localObject2).a() * i;
      boolean bool = o(j);
      if (!bool) {
        return;
      }
      localObject2 = this.b.e(i, (Class)localObject1);
      this.a.d((m)localObject2, paramT);
      paramT = m((Class)localObject1);
      localObject1 = (Integer)paramT.get(Integer.valueOf(((a)localObject2).b));
      int k = ((a)localObject2).b;
      i = 1;
      if (localObject1 != null) {
        i = 1 + ((Integer)localObject1).intValue();
      }
      paramT.put(Integer.valueOf(k), Integer.valueOf(i));
      this.f += j;
      g();
      return;
    }
    finally {}
  }
  
  private static final class a
    implements m
  {
    private final j.b a;
    int b;
    private Class<?> c;
    
    a(j.b paramb)
    {
      this.a = paramb;
    }
    
    public void a()
    {
      this.a.c(this);
    }
    
    void b(int paramInt, Class<?> paramClass)
    {
      this.b = paramInt;
      this.c = paramClass;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool1 = paramObject instanceof a;
      boolean bool2 = false;
      boolean bool3 = bool2;
      if (bool1)
      {
        paramObject = (a)paramObject;
        bool3 = bool2;
        if (this.b == ((a)paramObject).b)
        {
          bool3 = bool2;
          if (this.c == ((a)paramObject).c) {
            bool3 = true;
          }
        }
      }
      return bool3;
    }
    
    public int hashCode()
    {
      int i = this.b;
      Class localClass = this.c;
      int j;
      if (localClass != null) {
        j = localClass.hashCode();
      } else {
        j = 0;
      }
      return i * 31 + j;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Key{size=");
      localStringBuilder.append(this.b);
      localStringBuilder.append("array=");
      localStringBuilder.append(this.c);
      localStringBuilder.append('}');
      return localStringBuilder.toString();
    }
  }
  
  private static final class b
    extends d<j.a>
  {
    protected j.a d()
    {
      return new j.a(this);
    }
    
    j.a e(int paramInt, Class<?> paramClass)
    {
      j.a locala = (j.a)b();
      locala.b(paramInt, paramClass);
      return locala;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\engine\z\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */