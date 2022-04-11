package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.google.gson.TypeAdapter;
import com.google.gson.g;
import com.google.gson.h;
import com.google.gson.n;
import com.google.gson.o;
import com.google.gson.p;
import com.google.gson.stream.b;
import java.io.IOException;
import java.lang.reflect.Type;

public final class TreeTypeAdapter<T>
  extends TypeAdapter<T>
{
  private final o<T> a;
  private final h<T> b;
  final Gson c;
  private final com.google.gson.r.a<T> d;
  private final p e;
  private final TreeTypeAdapter<T>.b f = new b(null);
  private TypeAdapter<T> g;
  
  public TreeTypeAdapter(o<T> paramo, h<T> paramh, Gson paramGson, com.google.gson.r.a<T> parama, p paramp)
  {
    this.a = paramo;
    this.b = paramh;
    this.c = paramGson;
    this.d = parama;
    this.e = paramp;
  }
  
  private TypeAdapter<T> a()
  {
    TypeAdapter localTypeAdapter = this.g;
    if (localTypeAdapter == null)
    {
      localTypeAdapter = this.c.p(this.e, this.d);
      this.g = localTypeAdapter;
    }
    return localTypeAdapter;
  }
  
  public static p b(com.google.gson.r.a<?> parama, Object paramObject)
  {
    boolean bool;
    if (parama.getType() == parama.getRawType()) {
      bool = true;
    } else {
      bool = false;
    }
    return new SingleTypeFactory(paramObject, parama, bool, null);
  }
  
  public T read(com.google.gson.stream.a parama)
    throws IOException
  {
    if (this.b == null) {
      return (T)a().read(parama);
    }
    parama = com.google.gson.internal.i.a(parama);
    if (parama.g()) {
      return null;
    }
    return (T)this.b.deserialize(parama, this.d.getType(), this.f);
  }
  
  public void write(b paramb, T paramT)
    throws IOException
  {
    o localo = this.a;
    if (localo == null)
    {
      a().write(paramb, paramT);
      return;
    }
    if (paramT == null)
    {
      paramb.w();
      return;
    }
    com.google.gson.internal.i.b(localo.serialize(paramT, this.d.getType(), this.f), paramb);
  }
  
  private static final class SingleTypeFactory
    implements p
  {
    private final com.google.gson.r.a<?> c;
    private final boolean d;
    private final Class<?> f;
    private final o<?> q;
    private final h<?> x;
    
    SingleTypeFactory(Object paramObject, com.google.gson.r.a<?> parama, boolean paramBoolean, Class<?> paramClass)
    {
      boolean bool = paramObject instanceof o;
      h localh = null;
      o localo;
      if (bool) {
        localo = (o)paramObject;
      } else {
        localo = null;
      }
      this.q = localo;
      if ((paramObject instanceof h)) {
        localh = (h)paramObject;
      }
      this.x = localh;
      if ((localo == null) && (localh == null)) {
        bool = false;
      } else {
        bool = true;
      }
      com.google.gson.internal.a.a(bool);
      this.c = parama;
      this.d = paramBoolean;
      this.f = paramClass;
    }
    
    public <T> TypeAdapter<T> a(Gson paramGson, com.google.gson.r.a<T> parama)
    {
      com.google.gson.r.a locala = this.c;
      boolean bool;
      if (locala != null)
      {
        if ((!locala.equals(parama)) && ((!this.d) || (this.c.getType() != parama.getRawType()))) {
          bool = false;
        } else {
          bool = true;
        }
      }
      else {
        bool = this.f.isAssignableFrom(parama.getRawType());
      }
      if (bool) {
        paramGson = new TreeTypeAdapter(this.q, this.x, paramGson, parama, this);
      } else {
        paramGson = null;
      }
      return paramGson;
    }
  }
  
  private final class b
    implements n, g
  {
    private b() {}
    
    public com.google.gson.i a(Object paramObject, Type paramType)
    {
      return TreeTypeAdapter.this.c.B(paramObject, paramType);
    }
    
    public <R> R b(com.google.gson.i parami, Type paramType)
      throws JsonParseException
    {
      return (R)TreeTypeAdapter.this.c.h(parami, paramType);
    }
    
    public com.google.gson.i c(Object paramObject)
    {
      return TreeTypeAdapter.this.c.A(paramObject);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\bind\TreeTypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */