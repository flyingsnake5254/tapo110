package com.bumptech.glide;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Pools.Pool;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.e.a;
import com.bumptech.glide.load.engine.i;
import com.bumptech.glide.load.engine.s;
import com.bumptech.glide.load.engine.u;
import com.bumptech.glide.load.g;
import com.bumptech.glide.load.h;
import com.bumptech.glide.load.j.n;
import com.bumptech.glide.load.j.o;
import com.bumptech.glide.load.j.p;
import com.bumptech.glide.n.b;
import com.bumptech.glide.n.c;
import com.bumptech.glide.n.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Registry
{
  private final p a;
  private final com.bumptech.glide.n.a b;
  private final com.bumptech.glide.n.e c;
  private final com.bumptech.glide.n.f d;
  private final com.bumptech.glide.load.data.f e;
  private final com.bumptech.glide.load.k.g.f f;
  private final b g;
  private final d h = new d();
  private final c i = new c();
  private final Pools.Pool<List<Throwable>> j;
  
  public Registry()
  {
    Pools.Pool localPool = com.bumptech.glide.util.k.a.e();
    this.j = localPool;
    this.a = new p(localPool);
    this.b = new com.bumptech.glide.n.a();
    this.c = new com.bumptech.glide.n.e();
    this.d = new com.bumptech.glide.n.f();
    this.e = new com.bumptech.glide.load.data.f();
    this.f = new com.bumptech.glide.load.k.g.f();
    this.g = new b();
    s(Arrays.asList(new String[] { "Gif", "Bitmap", "BitmapDrawable" }));
  }
  
  @NonNull
  private <Data, TResource, Transcode> List<i<Data, TResource, Transcode>> f(@NonNull Class<Data> paramClass, @NonNull Class<TResource> paramClass1, @NonNull Class<Transcode> paramClass2)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.c.d(paramClass, paramClass1).iterator();
    while (localIterator1.hasNext())
    {
      paramClass1 = (Class)localIterator1.next();
      Iterator localIterator2 = this.f.b(paramClass1, paramClass2).iterator();
      while (localIterator2.hasNext())
      {
        Class localClass = (Class)localIterator2.next();
        localArrayList.add(new i(paramClass, paramClass1, localClass, this.c.b(paramClass, paramClass1), this.f.a(paramClass1, localClass), this.j));
      }
    }
    return localArrayList;
  }
  
  @NonNull
  public <Data> Registry a(@NonNull Class<Data> paramClass, @NonNull com.bumptech.glide.load.a<Data> parama)
  {
    this.b.a(paramClass, parama);
    return this;
  }
  
  @NonNull
  public <TResource> Registry b(@NonNull Class<TResource> paramClass, @NonNull h<TResource> paramh)
  {
    this.d.a(paramClass, paramh);
    return this;
  }
  
  @NonNull
  public <Data, TResource> Registry c(@NonNull Class<Data> paramClass, @NonNull Class<TResource> paramClass1, @NonNull g<Data, TResource> paramg)
  {
    e("legacy_append", paramClass, paramClass1, paramg);
    return this;
  }
  
  @NonNull
  public <Model, Data> Registry d(@NonNull Class<Model> paramClass, @NonNull Class<Data> paramClass1, @NonNull o<Model, Data> paramo)
  {
    this.a.a(paramClass, paramClass1, paramo);
    return this;
  }
  
  @NonNull
  public <Data, TResource> Registry e(@NonNull String paramString, @NonNull Class<Data> paramClass, @NonNull Class<TResource> paramClass1, @NonNull g<Data, TResource> paramg)
  {
    this.c.a(paramString, paramg, paramClass, paramClass1);
    return this;
  }
  
  @NonNull
  public List<ImageHeaderParser> g()
  {
    List localList = this.g.b();
    if (!localList.isEmpty()) {
      return localList;
    }
    throw new NoImageHeaderParserException();
  }
  
  @Nullable
  public <Data, TResource, Transcode> s<Data, TResource, Transcode> h(@NonNull Class<Data> paramClass, @NonNull Class<TResource> paramClass1, @NonNull Class<Transcode> paramClass2)
  {
    s locals = this.i.a(paramClass, paramClass1, paramClass2);
    if (this.i.c(locals)) {
      return null;
    }
    Object localObject = locals;
    if (locals == null)
    {
      localObject = f(paramClass, paramClass1, paramClass2);
      if (((List)localObject).isEmpty()) {
        localObject = null;
      } else {
        localObject = new s(paramClass, paramClass1, paramClass2, (List)localObject, this.j);
      }
      this.i.d(paramClass, paramClass1, paramClass2, (s)localObject);
    }
    return (s<Data, TResource, Transcode>)localObject;
  }
  
  @NonNull
  public <Model> List<n<Model, ?>> i(@NonNull Model paramModel)
  {
    return this.a.d(paramModel);
  }
  
  @NonNull
  public <Model, TResource, Transcode> List<Class<?>> j(@NonNull Class<Model> paramClass, @NonNull Class<TResource> paramClass1, @NonNull Class<Transcode> paramClass2)
  {
    Object localObject1 = this.h.a(paramClass, paramClass1, paramClass2);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = new ArrayList();
      localObject1 = this.a.c(paramClass).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject3 = (Class)((Iterator)localObject1).next();
        localObject3 = this.c.d((Class)localObject3, paramClass1).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Class localClass = (Class)((Iterator)localObject3).next();
          if ((!this.f.b(localClass, paramClass2).isEmpty()) && (!((List)localObject2).contains(localClass))) {
            ((List)localObject2).add(localClass);
          }
        }
      }
      this.h.b(paramClass, paramClass1, paramClass2, Collections.unmodifiableList((List)localObject2));
    }
    return (List<Class<?>>)localObject2;
  }
  
  @NonNull
  public <X> h<X> k(@NonNull u<X> paramu)
    throws Registry.NoResultEncoderAvailableException
  {
    h localh = this.d.b(paramu.e());
    if (localh != null) {
      return localh;
    }
    throw new NoResultEncoderAvailableException(paramu.e());
  }
  
  @NonNull
  public <X> com.bumptech.glide.load.data.e<X> l(@NonNull X paramX)
  {
    return this.e.a(paramX);
  }
  
  @NonNull
  public <X> com.bumptech.glide.load.a<X> m(@NonNull X paramX)
    throws Registry.NoSourceEncoderAvailableException
  {
    com.bumptech.glide.load.a locala = this.b.b(paramX.getClass());
    if (locala != null) {
      return locala;
    }
    throw new NoSourceEncoderAvailableException(paramX.getClass());
  }
  
  public boolean n(@NonNull u<?> paramu)
  {
    boolean bool;
    if (this.d.b(paramu.e()) != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  @NonNull
  public Registry o(@NonNull ImageHeaderParser paramImageHeaderParser)
  {
    this.g.a(paramImageHeaderParser);
    return this;
  }
  
  @NonNull
  public Registry p(@NonNull e.a<?> parama)
  {
    this.e.b(parama);
    return this;
  }
  
  @NonNull
  public <TResource, Transcode> Registry q(@NonNull Class<TResource> paramClass, @NonNull Class<Transcode> paramClass1, @NonNull com.bumptech.glide.load.k.g.e<TResource, Transcode> parame)
  {
    this.f.c(paramClass, paramClass1, parame);
    return this;
  }
  
  @NonNull
  public <Model, Data> Registry r(@NonNull Class<Model> paramClass, @NonNull Class<Data> paramClass1, @NonNull o<? extends Model, ? extends Data> paramo)
  {
    this.a.f(paramClass, paramClass1, paramo);
    return this;
  }
  
  @NonNull
  public final Registry s(@NonNull List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    localArrayList.add("legacy_prepend_all");
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add((String)paramList.next());
    }
    localArrayList.add("legacy_append");
    this.c.e(localArrayList);
    return this;
  }
  
  public static class MissingComponentException
    extends RuntimeException
  {
    public MissingComponentException(@NonNull String paramString)
    {
      super();
    }
  }
  
  public static final class NoImageHeaderParserException
    extends Registry.MissingComponentException
  {
    public NoImageHeaderParserException()
    {
      super();
    }
  }
  
  public static class NoModelLoaderAvailableException
    extends Registry.MissingComponentException
  {
    public NoModelLoaderAvailableException(@NonNull Class<?> paramClass1, @NonNull Class<?> paramClass2)
    {
      super();
    }
    
    public NoModelLoaderAvailableException(@NonNull Object paramObject)
    {
      super();
    }
    
    public <M> NoModelLoaderAvailableException(@NonNull M paramM, @NonNull List<n<M, ?>> paramList)
    {
      super();
    }
  }
  
  public static class NoResultEncoderAvailableException
    extends Registry.MissingComponentException
  {
    public NoResultEncoderAvailableException(@NonNull Class<?> paramClass)
    {
      super();
    }
  }
  
  public static class NoSourceEncoderAvailableException
    extends Registry.MissingComponentException
  {
    public NoSourceEncoderAvailableException(@NonNull Class<?> paramClass)
    {
      super();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\Registry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */