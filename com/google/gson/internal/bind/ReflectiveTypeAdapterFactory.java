package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.f;
import com.google.gson.internal.h;
import com.google.gson.p;
import com.google.gson.r.a<*>;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class ReflectiveTypeAdapterFactory
  implements p
{
  private final com.google.gson.internal.c c;
  private final com.google.gson.c d;
  private final Excluder f;
  private final JsonAdapterAnnotationTypeAdapterFactory q;
  private final com.google.gson.internal.k.b x = com.google.gson.internal.k.b.a();
  
  public ReflectiveTypeAdapterFactory(com.google.gson.internal.c paramc, com.google.gson.c paramc1, Excluder paramExcluder, JsonAdapterAnnotationTypeAdapterFactory paramJsonAdapterAnnotationTypeAdapterFactory)
  {
    this.c = paramc;
    this.d = paramc1;
    this.f = paramExcluder;
    this.q = paramJsonAdapterAnnotationTypeAdapterFactory;
  }
  
  private b b(final Gson paramGson, final Field paramField, String paramString, final com.google.gson.r.a<?> parama, boolean paramBoolean1, boolean paramBoolean2)
  {
    final boolean bool1 = h.a(parama.getRawType());
    Object localObject1 = (com.google.gson.q.b)paramField.getAnnotation(com.google.gson.q.b.class);
    if (localObject1 != null) {
      localObject1 = this.q.b(this.c, paramGson, parama, (com.google.gson.q.b)localObject1);
    } else {
      localObject1 = null;
    }
    final boolean bool2;
    if (localObject1 != null) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    final Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = paramGson.n(parama);
    }
    return new a(paramString, paramBoolean1, paramBoolean2, paramField, bool2, (TypeAdapter)localObject2, paramGson, parama, bool1);
  }
  
  static boolean d(Field paramField, boolean paramBoolean, Excluder paramExcluder)
  {
    if ((!paramExcluder.c(paramField.getType(), paramBoolean)) && (!paramExcluder.f(paramField, paramBoolean))) {
      paramBoolean = true;
    } else {
      paramBoolean = false;
    }
    return paramBoolean;
  }
  
  private Map<String, b> e(Gson paramGson, com.google.gson.r.a<?> parama, Class<?> paramClass)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    if (paramClass.isInterface()) {
      return localLinkedHashMap;
    }
    Type localType1 = parama.getType();
    Object localObject1 = parama;
    while (paramClass != Object.class)
    {
      Field[] arrayOfField = paramClass.getDeclaredFields();
      int i = arrayOfField.length;
      int j = 0;
      while (j < i)
      {
        Field localField = arrayOfField[j];
        boolean bool1 = c(localField, true);
        boolean bool2 = c(localField, false);
        if ((bool1) || (bool2))
        {
          this.x.b(localField);
          Type localType2 = com.google.gson.internal.b.p(((com.google.gson.r.a)localObject1).getType(), paramClass, localField.getGenericType());
          List localList = f(localField);
          int k = localList.size();
          parama = null;
          for (int m = 0; m < k; m++)
          {
            Object localObject2 = (String)localList.get(m);
            if (m != 0) {
              bool1 = false;
            }
            localObject2 = (b)localLinkedHashMap.put(localObject2, b(paramGson, localField, (String)localObject2, com.google.gson.r.a.get(localType2), bool1, bool2));
            if (parama == null) {
              parama = (com.google.gson.r.a<?>)localObject2;
            }
          }
          if (parama != null) {}
        }
        else
        {
          j++;
          continue;
        }
        paramGson = new StringBuilder();
        paramGson.append(localType1);
        paramGson.append(" declares multiple JSON fields named ");
        paramGson.append(parama.a);
        throw new IllegalArgumentException(paramGson.toString());
      }
      localObject1 = com.google.gson.r.a.get(com.google.gson.internal.b.p(((com.google.gson.r.a)localObject1).getType(), paramClass, paramClass.getGenericSuperclass()));
      paramClass = ((com.google.gson.r.a)localObject1).getRawType();
    }
    return localLinkedHashMap;
  }
  
  private List<String> f(Field paramField)
  {
    Object localObject = (com.google.gson.q.c)paramField.getAnnotation(com.google.gson.q.c.class);
    if (localObject == null) {
      return Collections.singletonList(this.d.translateName(paramField));
    }
    paramField = ((com.google.gson.q.c)localObject).value();
    String[] arrayOfString = ((com.google.gson.q.c)localObject).alternate();
    if (arrayOfString.length == 0) {
      return Collections.singletonList(paramField);
    }
    localObject = new ArrayList(arrayOfString.length + 1);
    ((List)localObject).add(paramField);
    int i = arrayOfString.length;
    for (int j = 0; j < i; j++) {
      ((List)localObject).add(arrayOfString[j]);
    }
    return (List<String>)localObject;
  }
  
  public <T> TypeAdapter<T> a(Gson paramGson, com.google.gson.r.a<T> parama)
  {
    Class localClass = parama.getRawType();
    if (!Object.class.isAssignableFrom(localClass)) {
      return null;
    }
    return new Adapter(this.c.a(parama), e(paramGson, parama, localClass));
  }
  
  public boolean c(Field paramField, boolean paramBoolean)
  {
    return d(paramField, paramBoolean, this.f);
  }
  
  public static final class Adapter<T>
    extends TypeAdapter<T>
  {
    private final f<T> a;
    private final Map<String, ReflectiveTypeAdapterFactory.b> b;
    
    Adapter(f<T> paramf, Map<String, ReflectiveTypeAdapterFactory.b> paramMap)
    {
      this.a = paramf;
      this.b = paramMap;
    }
    
    public T read(com.google.gson.stream.a parama)
      throws IOException
    {
      if (parama.G() == JsonToken.NULL)
      {
        parama.C();
        return null;
      }
      Object localObject1 = this.a.a();
      try
      {
        parama.c();
        while (parama.s())
        {
          Object localObject2 = parama.A();
          localObject2 = (ReflectiveTypeAdapterFactory.b)this.b.get(localObject2);
          if ((localObject2 != null) && (((ReflectiveTypeAdapterFactory.b)localObject2).c)) {
            ((ReflectiveTypeAdapterFactory.b)localObject2).a(parama, localObject1);
          } else {
            parama.Q();
          }
        }
        parama.k();
        return (T)localObject1;
      }
      catch (IllegalAccessException parama)
      {
        throw new AssertionError(parama);
      }
      catch (IllegalStateException parama)
      {
        throw new JsonSyntaxException(parama);
      }
    }
    
    public void write(com.google.gson.stream.b paramb, T paramT)
      throws IOException
    {
      if (paramT == null)
      {
        paramb.w();
        return;
      }
      paramb.g();
      try
      {
        Iterator localIterator = this.b.values().iterator();
        while (localIterator.hasNext())
        {
          ReflectiveTypeAdapterFactory.b localb = (ReflectiveTypeAdapterFactory.b)localIterator.next();
          if (localb.c(paramT))
          {
            paramb.u(localb.a);
            localb.b(paramb, paramT);
          }
        }
        paramb.k();
        return;
      }
      catch (IllegalAccessException paramb)
      {
        throw new AssertionError(paramb);
      }
    }
  }
  
  class a
    extends ReflectiveTypeAdapterFactory.b
  {
    a(String paramString, boolean paramBoolean1, boolean paramBoolean2, Field paramField, boolean paramBoolean3, TypeAdapter paramTypeAdapter, Gson paramGson, com.google.gson.r.a parama, boolean paramBoolean4)
    {
      super(paramBoolean1, paramBoolean2);
    }
    
    void a(com.google.gson.stream.a parama, Object paramObject)
      throws IOException, IllegalAccessException
    {
      parama = localObject2.read(parama);
      if ((parama != null) || (!bool1)) {
        paramField.set(paramObject, parama);
      }
    }
    
    void b(com.google.gson.stream.b paramb, Object paramObject)
      throws IOException, IllegalAccessException
    {
      Object localObject = paramField.get(paramObject);
      if (bool2) {
        paramObject = localObject2;
      } else {
        paramObject = new TypeAdapterRuntimeTypeWrapper(paramGson, localObject2, parama.getType());
      }
      ((TypeAdapter)paramObject).write(paramb, localObject);
    }
    
    public boolean c(Object paramObject)
      throws IOException, IllegalAccessException
    {
      boolean bool1 = this.b;
      boolean bool2 = false;
      if (!bool1) {
        return false;
      }
      if (paramField.get(paramObject) != paramObject) {
        bool2 = true;
      }
      return bool2;
    }
  }
  
  static abstract class b
  {
    final String a;
    final boolean b;
    final boolean c;
    
    protected b(String paramString, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.a = paramString;
      this.b = paramBoolean1;
      this.c = paramBoolean2;
    }
    
    abstract void a(com.google.gson.stream.a parama, Object paramObject)
      throws IOException, IllegalAccessException;
    
    abstract void b(com.google.gson.stream.b paramb, Object paramObject)
      throws IOException, IllegalAccessException;
    
    abstract boolean c(Object paramObject)
      throws IOException, IllegalAccessException;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\bind\ReflectiveTypeAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */