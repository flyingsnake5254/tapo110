package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.c;
import com.google.gson.internal.f;
import com.google.gson.p;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

public final class CollectionTypeAdapterFactory
  implements p
{
  private final c c;
  
  public CollectionTypeAdapterFactory(c paramc)
  {
    this.c = paramc;
  }
  
  public <T> TypeAdapter<T> a(Gson paramGson, com.google.gson.r.a<T> parama)
  {
    Type localType = parama.getType();
    Class localClass = parama.getRawType();
    if (!Collection.class.isAssignableFrom(localClass)) {
      return null;
    }
    localType = com.google.gson.internal.b.h(localType, localClass);
    return new Adapter(paramGson, localType, paramGson.n(com.google.gson.r.a.get(localType)), this.c.a(parama));
  }
  
  private static final class Adapter<E>
    extends TypeAdapter<Collection<E>>
  {
    private final TypeAdapter<E> a;
    private final f<? extends Collection<E>> b;
    
    public Adapter(Gson paramGson, Type paramType, TypeAdapter<E> paramTypeAdapter, f<? extends Collection<E>> paramf)
    {
      this.a = new TypeAdapterRuntimeTypeWrapper(paramGson, paramTypeAdapter, paramType);
      this.b = paramf;
    }
    
    public Collection<E> a(com.google.gson.stream.a parama)
      throws IOException
    {
      if (parama.G() == JsonToken.NULL)
      {
        parama.C();
        return null;
      }
      Collection localCollection = (Collection)this.b.a();
      parama.a();
      while (parama.s()) {
        localCollection.add(this.a.read(parama));
      }
      parama.j();
      return localCollection;
    }
    
    public void b(com.google.gson.stream.b paramb, Collection<E> paramCollection)
      throws IOException
    {
      if (paramCollection == null)
      {
        paramb.w();
        return;
      }
      paramb.e();
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        paramCollection = localIterator.next();
        this.a.write(paramb, paramCollection);
      }
      paramb.j();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\bind\CollectionTypeAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */