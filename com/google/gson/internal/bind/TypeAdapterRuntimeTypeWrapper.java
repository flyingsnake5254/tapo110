package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.b;
import java.io.IOException;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

final class TypeAdapterRuntimeTypeWrapper<T>
  extends TypeAdapter<T>
{
  private final Gson a;
  private final TypeAdapter<T> b;
  private final Type c;
  
  TypeAdapterRuntimeTypeWrapper(Gson paramGson, TypeAdapter<T> paramTypeAdapter, Type paramType)
  {
    this.a = paramGson;
    this.b = paramTypeAdapter;
    this.c = paramType;
  }
  
  private Type a(Type paramType, Object paramObject)
  {
    Object localObject = paramType;
    if (paramObject != null) {
      if ((paramType != Object.class) && (!(paramType instanceof TypeVariable)))
      {
        localObject = paramType;
        if (!(paramType instanceof Class)) {}
      }
      else
      {
        localObject = paramObject.getClass();
      }
    }
    return (Type)localObject;
  }
  
  public T read(com.google.gson.stream.a parama)
    throws IOException
  {
    return (T)this.b.read(parama);
  }
  
  public void write(b paramb, T paramT)
    throws IOException
  {
    Object localObject1 = this.b;
    Object localObject2 = a(this.c, paramT);
    if (localObject2 != this.c)
    {
      localObject1 = this.a.n(com.google.gson.r.a.get((Type)localObject2));
      if ((localObject1 instanceof ReflectiveTypeAdapterFactory.Adapter))
      {
        localObject2 = this.b;
        if (!(localObject2 instanceof ReflectiveTypeAdapterFactory.Adapter)) {
          localObject1 = localObject2;
        }
      }
    }
    ((TypeAdapter)localObject1).write(paramb, paramT);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\bind\TypeAdapterRuntimeTypeWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */