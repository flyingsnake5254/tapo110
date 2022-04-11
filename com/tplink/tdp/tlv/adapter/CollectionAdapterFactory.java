package com.tplink.tdp.tlv.adapter;

import java.lang.reflect.Type;
import java.util.Collection;

public class CollectionAdapterFactory
  implements d
{
  private a a;
  
  public CollectionAdapterFactory(a parama)
  {
    this.a = parama;
  }
  
  public <T> c<T> a(b.d.c0.m.a parama, e<T> parame)
  {
    boolean bool = Collection.class.isAssignableFrom(parame.a());
    Object localObject1 = null;
    if (!bool) {
      return null;
    }
    Type[] arrayOfType = parame.b();
    Object localObject2 = localObject1;
    if (arrayOfType != null) {
      if (arrayOfType.length < 1)
      {
        localObject2 = localObject1;
      }
      else
      {
        localObject2 = arrayOfType[0];
        if (!(localObject2 instanceof Class)) {
          return null;
        }
        parama = parama.b(new e((Type)localObject2));
        localObject2 = new Adapter(this.a.a(parame), parama, ((Class)localObject2).isAnnotationPresent(b.d.c0.m.d.b.class));
      }
    }
    return (c<T>)localObject2;
  }
  
  static final class Adapter<E>
    extends c<Collection<E>>
  {
    private final b<? extends Collection> a;
    private final c<E> b;
    private boolean c;
    
    Adapter(b<? extends Collection> paramb, c<E> paramc, boolean paramBoolean)
    {
      this.a = paramb;
      this.b = paramc;
      this.c = paramBoolean;
    }
    
    public Collection<E> b(b.d.c0.m.e.a parama)
    {
      Collection localCollection = (Collection)this.a.a();
      do
      {
        if (this.c)
        {
          b.d.c0.m.e.a locala = new b.d.c0.m.e.a(parama.o());
          localCollection.add(this.b.a(locala));
        }
        else
        {
          localCollection.add(this.b.a(parama));
        }
      } while ((parama.b()) && (parama.a() == parama.c()));
      return localCollection;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tdp\tlv\adapter\CollectionAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */