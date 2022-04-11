package com.tplink.tdp.tlv.adapter;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class TLVStructureAdapterFactory
  implements d
{
  private a a;
  
  public TLVStructureAdapterFactory(a parama)
  {
    this.a = parama;
  }
  
  private b b(b.d.c0.m.a parama, short paramShort, final Field paramField)
  {
    Class localClass = paramField.getType();
    e locale = new e(localClass, paramField.getGenericType());
    b.d.c0.m.d.a locala;
    if (paramField.isAnnotationPresent(b.d.c0.m.d.a.class)) {
      locala = (b.d.c0.m.d.a)paramField.getAnnotation(b.d.c0.m.d.a.class);
    } else {
      locala = null;
    }
    return new a(paramShort, localClass.isAnnotationPresent(b.d.c0.m.d.b.class), c(parama, locale, locala), paramField);
  }
  
  private c<?> c(b.d.c0.m.a parama, e<?> parame, b.d.c0.m.d.a parama1)
  {
    if (parama1 != null)
    {
      parama1 = this.a.a(new e(parama1.value())).a();
      if ((parama1 instanceof c))
      {
        parama1 = (c)parama1;
        break label69;
      }
      if ((parama1 instanceof d))
      {
        parama1 = ((d)parama1).a(parama, parame);
        break label69;
      }
    }
    parama1 = null;
    label69:
    Object localObject = parama1;
    if (parama1 == null) {
      localObject = parama.b(parame);
    }
    return (c<?>)localObject;
  }
  
  private Map<Short, b> d(b.d.c0.m.a parama, e parame)
  {
    HashMap localHashMap = new HashMap();
    for (parame = parame.a(); parame != Object.class; parame = f.c(parame))
    {
      Field[] arrayOfField = parame.getDeclaredFields();
      short[] arrayOfShort = parama.c();
      int i = 0;
      int j;
      if ((arrayOfShort != null) && (arrayOfShort.length > 0)) {
        j = 1;
      } else {
        j = 0;
      }
      int k = arrayOfField.length;
      while (i < k)
      {
        Field localField = arrayOfField[i];
        if (localField.isAnnotationPresent(b.d.c0.m.d.c.class))
        {
          localField.setAccessible(true);
          short s = ((b.d.c0.m.d.c)localField.getAnnotation(b.d.c0.m.d.c.class)).value();
          if ((j == 0) || (!e(arrayOfShort, s))) {
            localHashMap.put(Short.valueOf(s), b(parama, s, localField));
          }
        }
        i++;
      }
    }
    return localHashMap;
  }
  
  private boolean e(short[] paramArrayOfShort, short paramShort)
  {
    int i = paramArrayOfShort.length;
    for (int j = 0; j < i; j++) {
      if (paramArrayOfShort[j] == paramShort) {
        return true;
      }
    }
    return false;
  }
  
  public <T> c<T> a(b.d.c0.m.a parama, e<T> parame)
  {
    if (!Object.class.isAssignableFrom(parame.a())) {
      return null;
    }
    return new Adapter(this.a.a(parame), d(parama, parame));
  }
  
  static final class Adapter<T>
    extends c<T>
  {
    private b<T> a;
    private Map<Short, TLVStructureAdapterFactory.b> b;
    
    Adapter(b<T> paramb, Map<Short, TLVStructureAdapterFactory.b> paramMap)
    {
      this.a = paramb;
      this.b = paramMap;
    }
    
    public T a(b.d.c0.m.e.a parama)
    {
      try
      {
        Object localObject = this.a.a();
        while (parama.b())
        {
          short s = parama.n();
          TLVStructureAdapterFactory.b localb = (TLVStructureAdapterFactory.b)this.b.get(Short.valueOf(s));
          if (localb == null) {
            parama.o();
          } else {
            localb.a(parama, localObject);
          }
        }
        return (T)localObject;
      }
      catch (IllegalAccessException parama)
      {
        parama.printStackTrace();
      }
      return null;
    }
  }
  
  class a
    extends TLVStructureAdapterFactory.b
  {
    a(short paramShort, boolean paramBoolean, c paramc, Field paramField)
    {
      super(paramBoolean);
    }
    
    public void a(b.d.c0.m.e.a parama, Object paramObject)
      throws IllegalAccessException
    {
      c localc = this.c;
      if (localc == null) {
        return;
      }
      if (this.b)
      {
        parama = new b.d.c0.m.e.a(parama.o());
        parama = this.c.a(parama);
        paramField.set(paramObject, parama);
      }
      else
      {
        parama = localc.a(parama);
        paramField.set(paramObject, parama);
      }
    }
  }
  
  static abstract class b
  {
    final short a;
    final boolean b;
    
    b(short paramShort, boolean paramBoolean)
    {
      this.a = ((short)paramShort);
      this.b = paramBoolean;
    }
    
    public abstract void a(b.d.c0.m.e.a parama, Object paramObject)
      throws IllegalAccessException;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\tdp\tlv\adapter\TLVStructureAdapterFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */