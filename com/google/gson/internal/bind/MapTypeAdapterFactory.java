package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.c;
import com.google.gson.internal.e;
import com.google.gson.internal.f;
import com.google.gson.m;
import com.google.gson.p;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class MapTypeAdapterFactory
  implements p
{
  private final c c;
  final boolean d;
  
  public MapTypeAdapterFactory(c paramc, boolean paramBoolean)
  {
    this.c = paramc;
    this.d = paramBoolean;
  }
  
  private TypeAdapter<?> b(Gson paramGson, Type paramType)
  {
    if ((paramType != Boolean.TYPE) && (paramType != Boolean.class)) {
      paramGson = paramGson.n(com.google.gson.r.a.get(paramType));
    } else {
      paramGson = TypeAdapters.f;
    }
    return paramGson;
  }
  
  public <T> TypeAdapter<T> a(Gson paramGson, com.google.gson.r.a<T> parama)
  {
    Object localObject = parama.getType();
    if (!Map.class.isAssignableFrom(parama.getRawType())) {
      return null;
    }
    Type[] arrayOfType = com.google.gson.internal.b.j((Type)localObject, com.google.gson.internal.b.k((Type)localObject));
    localObject = b(paramGson, arrayOfType[0]);
    TypeAdapter localTypeAdapter = paramGson.n(com.google.gson.r.a.get(arrayOfType[1]));
    parama = this.c.a(parama);
    return new Adapter(paramGson, arrayOfType[0], (TypeAdapter)localObject, arrayOfType[1], localTypeAdapter, parama);
  }
  
  private final class Adapter<K, V>
    extends TypeAdapter<Map<K, V>>
  {
    private final TypeAdapter<K> a;
    private final TypeAdapter<V> b;
    private final f<? extends Map<K, V>> c;
    
    public Adapter(Type paramType1, TypeAdapter<K> paramTypeAdapter, Type paramType2, TypeAdapter<V> paramTypeAdapter1, f<? extends Map<K, V>> paramf)
    {
      this.a = new TypeAdapterRuntimeTypeWrapper(paramType1, paramType2, paramTypeAdapter);
      this.b = new TypeAdapterRuntimeTypeWrapper(paramType1, paramf, paramTypeAdapter1);
      f localf;
      this.c = localf;
    }
    
    private String a(com.google.gson.i parami)
    {
      if (parami.i())
      {
        parami = parami.d();
        if (parami.p()) {
          return String.valueOf(parami.m());
        }
        if (parami.n()) {
          return Boolean.toString(parami.j());
        }
        if (parami.q()) {
          return parami.e();
        }
        throw new AssertionError();
      }
      if (parami.g()) {
        return "null";
      }
      throw new AssertionError();
    }
    
    public Map<K, V> b(com.google.gson.stream.a parama)
      throws IOException
    {
      Object localObject = parama.G();
      if (localObject == JsonToken.NULL)
      {
        parama.C();
        return null;
      }
      Map localMap = (Map)this.c.a();
      if (localObject == JsonToken.BEGIN_ARRAY)
      {
        parama.a();
        while (parama.s())
        {
          parama.a();
          localObject = this.a.read(parama);
          if (localMap.put(localObject, this.b.read(parama)) == null)
          {
            parama.j();
          }
          else
          {
            parama = new StringBuilder();
            parama.append("duplicate key: ");
            parama.append(localObject);
            throw new JsonSyntaxException(parama.toString());
          }
        }
        parama.j();
      }
      else
      {
        parama.c();
        while (parama.s())
        {
          e.a.a(parama);
          localObject = this.a.read(parama);
          if (localMap.put(localObject, this.b.read(parama)) != null)
          {
            parama = new StringBuilder();
            parama.append("duplicate key: ");
            parama.append(localObject);
            throw new JsonSyntaxException(parama.toString());
          }
        }
        parama.k();
      }
      return localMap;
    }
    
    public void c(com.google.gson.stream.b paramb, Map<K, V> paramMap)
      throws IOException
    {
      if (paramMap == null)
      {
        paramb.w();
        return;
      }
      if (!MapTypeAdapterFactory.this.d)
      {
        paramb.g();
        localObject = paramMap.entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          paramMap = (Map.Entry)((Iterator)localObject).next();
          paramb.u(String.valueOf(paramMap.getKey()));
          this.b.write(paramb, paramMap.getValue());
        }
        paramb.k();
        return;
      }
      Object localObject = new ArrayList(paramMap.size());
      ArrayList localArrayList = new ArrayList(paramMap.size());
      Iterator localIterator = paramMap.entrySet().iterator();
      int i = 0;
      int j = 0;
      int k = 0;
      int m;
      while (localIterator.hasNext())
      {
        paramMap = (Map.Entry)localIterator.next();
        com.google.gson.i locali = this.a.toJsonTree(paramMap.getKey());
        ((List)localObject).add(locali);
        localArrayList.add(paramMap.getValue());
        if ((!locali.f()) && (!locali.h())) {
          m = 0;
        } else {
          m = 1;
        }
        k |= m;
      }
      if (k != 0)
      {
        paramb.e();
        m = ((List)localObject).size();
        for (k = j; k < m; k++)
        {
          paramb.e();
          com.google.gson.internal.i.b((com.google.gson.i)((List)localObject).get(k), paramb);
          this.b.write(paramb, localArrayList.get(k));
          paramb.j();
        }
        paramb.j();
      }
      else
      {
        paramb.g();
        m = ((List)localObject).size();
        for (k = i; k < m; k++)
        {
          paramb.u(a((com.google.gson.i)((List)localObject).get(k)));
          this.b.write(paramb, localArrayList.get(k));
        }
        paramb.k();
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\bind\MapTypeAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */