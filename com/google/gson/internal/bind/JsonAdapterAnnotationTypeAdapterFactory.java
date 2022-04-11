package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.h;
import com.google.gson.internal.c;
import com.google.gson.internal.f;
import com.google.gson.o;
import com.google.gson.p;
import com.google.gson.q.b;
import com.google.gson.r.a;

public final class JsonAdapterAnnotationTypeAdapterFactory
  implements p
{
  private final c c;
  
  public JsonAdapterAnnotationTypeAdapterFactory(c paramc)
  {
    this.c = paramc;
  }
  
  public <T> TypeAdapter<T> a(Gson paramGson, a<T> parama)
  {
    b localb = (b)parama.getRawType().getAnnotation(b.class);
    if (localb == null) {
      return null;
    }
    return b(this.c, paramGson, parama, localb);
  }
  
  TypeAdapter<?> b(c paramc, Gson paramGson, a<?> parama, b paramb)
  {
    Object localObject = paramc.a(a.get(paramb.value())).a();
    if ((localObject instanceof TypeAdapter))
    {
      paramc = (TypeAdapter)localObject;
    }
    else if ((localObject instanceof p))
    {
      paramc = ((p)localObject).a(paramGson, parama);
    }
    else
    {
      boolean bool = localObject instanceof o;
      if ((!bool) && (!(localObject instanceof h)))
      {
        paramc = new StringBuilder();
        paramc.append("Invalid attempt to bind an instance of ");
        paramc.append(localObject.getClass().getName());
        paramc.append(" as a @JsonAdapter for ");
        paramc.append(parama.toString());
        paramc.append(". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
        throw new IllegalArgumentException(paramc.toString());
      }
      h localh = null;
      if (bool) {
        paramc = (o)localObject;
      } else {
        paramc = null;
      }
      if ((localObject instanceof h)) {
        localh = (h)localObject;
      }
      paramc = new TreeTypeAdapter(paramc, localh, paramGson, parama, null);
    }
    paramGson = paramc;
    if (paramc != null)
    {
      paramGson = paramc;
      if (paramb.nullSafe()) {
        paramGson = paramc.nullSafe();
      }
    }
    return paramGson;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\bind\JsonAdapterAnnotationTypeAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */