package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.p;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.List;

public final class ArrayTypeAdapter<E>
  extends TypeAdapter<Object>
{
  public static final p a = new p()
  {
    public <T> TypeAdapter<T> a(Gson paramAnonymousGson, com.google.gson.r.a<T> paramAnonymousa)
    {
      paramAnonymousa = paramAnonymousa.getType();
      if ((!(paramAnonymousa instanceof GenericArrayType)) && ((!(paramAnonymousa instanceof Class)) || (!((Class)paramAnonymousa).isArray()))) {
        return null;
      }
      paramAnonymousa = com.google.gson.internal.b.g(paramAnonymousa);
      return new ArrayTypeAdapter(paramAnonymousGson, paramAnonymousGson.n(com.google.gson.r.a.get(paramAnonymousa)), com.google.gson.internal.b.k(paramAnonymousa));
    }
  };
  private final Class<E> b;
  private final TypeAdapter<E> c;
  
  public ArrayTypeAdapter(Gson paramGson, TypeAdapter<E> paramTypeAdapter, Class<E> paramClass)
  {
    this.c = new TypeAdapterRuntimeTypeWrapper(paramGson, paramTypeAdapter, paramClass);
    this.b = paramClass;
  }
  
  public Object read(com.google.gson.stream.a parama)
    throws IOException
  {
    if (parama.G() == JsonToken.NULL)
    {
      parama.C();
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    parama.a();
    while (parama.s()) {
      localArrayList.add(this.c.read(parama));
    }
    parama.j();
    int i = localArrayList.size();
    parama = Array.newInstance(this.b, i);
    for (int j = 0; j < i; j++) {
      Array.set(parama, j, localArrayList.get(j));
    }
    return parama;
  }
  
  public void write(com.google.gson.stream.b paramb, Object paramObject)
    throws IOException
  {
    if (paramObject == null)
    {
      paramb.w();
      return;
    }
    paramb.e();
    int i = 0;
    int j = Array.getLength(paramObject);
    while (i < j)
    {
      Object localObject = Array.get(paramObject, i);
      this.c.write(paramb, localObject);
      i++;
    }
    paramb.j();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\bind\ArrayTypeAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */