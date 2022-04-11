package com.google.gson.internal;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.p;
import com.google.gson.q.d;
import com.google.gson.q.e;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class Excluder
  implements p, Cloneable
{
  public static final Excluder c = new Excluder();
  private double d = -1.0D;
  private int f = 136;
  private boolean q = true;
  private boolean x;
  private List<com.google.gson.a> y = Collections.emptyList();
  private List<com.google.gson.a> z = Collections.emptyList();
  
  private boolean d(Class<?> paramClass)
  {
    if ((this.d != -1.0D) && (!m((d)paramClass.getAnnotation(d.class), (e)paramClass.getAnnotation(e.class)))) {
      return true;
    }
    if ((!this.q) && (h(paramClass))) {
      return true;
    }
    return g(paramClass);
  }
  
  private boolean e(Class<?> paramClass, boolean paramBoolean)
  {
    if (paramBoolean) {
      localObject = this.y;
    } else {
      localObject = this.z;
    }
    Object localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((com.google.gson.a)((Iterator)localObject).next()).b(paramClass)) {
        return true;
      }
    }
    return false;
  }
  
  private boolean g(Class<?> paramClass)
  {
    boolean bool;
    if ((!Enum.class.isAssignableFrom(paramClass)) && ((paramClass.isAnonymousClass()) || (paramClass.isLocalClass()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean h(Class<?> paramClass)
  {
    boolean bool;
    if ((paramClass.isMemberClass()) && (!j(paramClass))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean j(Class<?> paramClass)
  {
    boolean bool;
    if ((paramClass.getModifiers() & 0x8) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean k(d paramd)
  {
    return (paramd == null) || (paramd.value() <= this.d);
  }
  
  private boolean l(e parame)
  {
    return (parame == null) || (parame.value() > this.d);
  }
  
  private boolean m(d paramd, e parame)
  {
    boolean bool;
    if ((k(paramd)) && (l(parame))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public <T> TypeAdapter<T> a(final Gson paramGson, final com.google.gson.r.a<T> parama)
  {
    Class localClass = parama.getRawType();
    final boolean bool1 = d(localClass);
    final boolean bool2;
    if ((!bool1) && (!e(localClass, true))) {
      bool2 = false;
    } else {
      bool2 = true;
    }
    if ((!bool1) && (!e(localClass, false))) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    if ((!bool2) && (!bool1)) {
      return null;
    }
    new TypeAdapter()
    {
      private TypeAdapter<T> a;
      
      private TypeAdapter<T> a()
      {
        TypeAdapter localTypeAdapter = this.a;
        if (localTypeAdapter == null)
        {
          localTypeAdapter = paramGson.p(Excluder.this, parama);
          this.a = localTypeAdapter;
        }
        return localTypeAdapter;
      }
      
      public T read(com.google.gson.stream.a paramAnonymousa)
        throws IOException
      {
        if (bool1)
        {
          paramAnonymousa.Q();
          return null;
        }
        return (T)a().read(paramAnonymousa);
      }
      
      public void write(com.google.gson.stream.b paramAnonymousb, T paramAnonymousT)
        throws IOException
      {
        if (bool2)
        {
          paramAnonymousb.w();
          return;
        }
        a().write(paramAnonymousb, paramAnonymousT);
      }
    };
  }
  
  protected Excluder b()
  {
    try
    {
      Excluder localExcluder = (Excluder)super.clone();
      return localExcluder;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      throw new AssertionError(localCloneNotSupportedException);
    }
  }
  
  public boolean c(Class<?> paramClass, boolean paramBoolean)
  {
    if ((!d(paramClass)) && (!e(paramClass, paramBoolean))) {
      paramBoolean = false;
    } else {
      paramBoolean = true;
    }
    return paramBoolean;
  }
  
  public boolean f(Field paramField, boolean paramBoolean)
  {
    if ((this.f & paramField.getModifiers()) != 0) {
      return true;
    }
    if ((this.d != -1.0D) && (!m((d)paramField.getAnnotation(d.class), (e)paramField.getAnnotation(e.class)))) {
      return true;
    }
    if (paramField.isSynthetic()) {
      return true;
    }
    Object localObject;
    if (this.x)
    {
      localObject = (com.google.gson.q.a)paramField.getAnnotation(com.google.gson.q.a.class);
      if ((localObject == null) || (paramBoolean ? !((com.google.gson.q.a)localObject).serialize() : !((com.google.gson.q.a)localObject).deserialize())) {
        return true;
      }
    }
    if ((!this.q) && (h(paramField.getType()))) {
      return true;
    }
    if (g(paramField.getType())) {
      return true;
    }
    if (paramBoolean) {
      localObject = this.y;
    } else {
      localObject = this.z;
    }
    if (!((List)localObject).isEmpty())
    {
      paramField = new com.google.gson.b(paramField);
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((com.google.gson.a)((Iterator)localObject).next()).a(paramField)) {
          return true;
        }
      }
    }
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\gson\internal\Excluder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */