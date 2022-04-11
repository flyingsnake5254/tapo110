package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.p;
import com.google.gson.stream.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class ObjectTypeAdapter
  extends TypeAdapter<Object>
{
  public static final p a = new p()
  {
    public <T> TypeAdapter<T> a(Gson paramAnonymousGson, com.google.gson.r.a<T> paramAnonymousa)
    {
      if (paramAnonymousa.getRawType() == Object.class) {
        return new ObjectTypeAdapter(paramAnonymousGson);
      }
      return null;
    }
  };
  private final Gson b;
  
  ObjectTypeAdapter(Gson paramGson)
  {
    this.b = paramGson;
  }
  
  public Object read(com.google.gson.stream.a parama)
    throws IOException
  {
    Object localObject = parama.G();
    switch (a.a[localObject.ordinal()])
    {
    default: 
      throw new IllegalStateException();
    case 6: 
      parama.C();
      return null;
    case 5: 
      return Boolean.valueOf(parama.w());
    case 4: 
      return Double.valueOf(parama.x());
    case 3: 
      return parama.E();
    case 2: 
      localObject = new LinkedTreeMap();
      parama.c();
      while (parama.s()) {
        ((Map)localObject).put(parama.A(), read(parama));
      }
      parama.k();
      return localObject;
    }
    localObject = new ArrayList();
    parama.a();
    while (parama.s()) {
      ((List)localObject).add(read(parama));
    }
    parama.j();
    return localObject;
  }
  
  public void write(b paramb, Object paramObject)
    throws IOException
  {
    if (paramObject == null)
    {
      paramb.w();
      return;
    }
    TypeAdapter localTypeAdapter = this.b.o(paramObject.getClass());
    if ((localTypeAdapter instanceof ObjectTypeAdapter))
    {
      paramb.g();
      paramb.k();
      return;
    }
    localTypeAdapter.write(paramb, paramObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\bind\ObjectTypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */