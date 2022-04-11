package com.bumptech.glide.load.data;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.i;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class f
{
  private static final e.a<?> a = new a();
  private final Map<Class<?>, e.a<?>> b = new HashMap();
  
  @NonNull
  public <T> e<T> a(@NonNull T paramT)
  {
    try
    {
      i.d(paramT);
      Object localObject1 = (e.a)this.b.get(paramT.getClass());
      Object localObject2 = localObject1;
      if (localObject1 == null)
      {
        Iterator localIterator = this.b.values().iterator();
        do
        {
          localObject2 = localObject1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject2 = (e.a)localIterator.next();
        } while (!((e.a)localObject2).a().isAssignableFrom(paramT.getClass()));
      }
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = a;
      }
      paramT = ((e.a)localObject1).b(paramT);
      return paramT;
    }
    finally {}
  }
  
  public void b(@NonNull e.a<?> parama)
  {
    try
    {
      this.b.put(parama.a(), parama);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  class a
    implements e.a<Object>
  {
    @NonNull
    public Class<Object> a()
    {
      throw new UnsupportedOperationException("Not implemented");
    }
    
    @NonNull
    public e<Object> b(@NonNull Object paramObject)
    {
      return new f.b(paramObject);
    }
  }
  
  private static final class b
    implements e<Object>
  {
    private final Object a;
    
    b(@NonNull Object paramObject)
    {
      this.a = paramObject;
    }
    
    @NonNull
    public Object a()
    {
      return this.a;
    }
    
    public void b() {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\load\data\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */