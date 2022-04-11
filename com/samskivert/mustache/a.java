package com.samskivert.mustache;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

public abstract class a
  implements f.e
{
  protected static final f.v a = new g();
  protected static final f.v b = new h();
  protected static final f.v c = new i();
  protected static final f.v d = new j();
  protected static final o e = new k();
  protected static final o f = new l();
  protected static final o g = new m();
  protected static final o h = new n();
  protected static final o i = new a();
  protected static final o j = new b();
  protected static final o k = new c();
  protected static final o l = new d();
  protected static final o m = new e();
  
  protected static o d(Object paramObject)
  {
    if ((paramObject instanceof Object[])) {
      return e;
    }
    if ((paramObject instanceof boolean[])) {
      return f;
    }
    if ((paramObject instanceof byte[])) {
      return g;
    }
    if ((paramObject instanceof char[])) {
      return h;
    }
    if ((paramObject instanceof short[])) {
      return i;
    }
    if ((paramObject instanceof int[])) {
      return j;
    }
    if ((paramObject instanceof long[])) {
      return k;
    }
    if ((paramObject instanceof float[])) {
      return l;
    }
    if ((paramObject instanceof double[])) {
      return m;
    }
    return null;
  }
  
  public Iterator<?> a(final Object paramObject)
  {
    if ((paramObject instanceof Iterable)) {
      return ((Iterable)paramObject).iterator();
    }
    if ((paramObject instanceof Iterator)) {
      return (Iterator)paramObject;
    }
    if (paramObject.getClass().isArray()) {
      return new f(d(paramObject), paramObject);
    }
    return null;
  }
  
  public f.v c(Object paramObject, String paramString)
  {
    if ((paramObject instanceof f.g)) {
      return a;
    }
    if ((paramObject instanceof Map)) {
      return b;
    }
    int n = paramString.charAt(0);
    if ((n >= 48) && (n <= 57))
    {
      if ((paramObject instanceof List)) {
        return c;
      }
      if ((paramObject instanceof Iterator)) {
        return d;
      }
      if (paramObject.getClass().isArray()) {
        return d(paramObject);
      }
    }
    return null;
  }
  
  static final class a
    extends a.o
  {
    protected Object b(Object paramObject, int paramInt)
    {
      return Short.valueOf(((short[])paramObject)[paramInt]);
    }
    
    public int c(Object paramObject)
    {
      return ((short[])paramObject).length;
    }
  }
  
  static final class b
    extends a.o
  {
    protected Object b(Object paramObject, int paramInt)
    {
      return Integer.valueOf(((int[])paramObject)[paramInt]);
    }
    
    public int c(Object paramObject)
    {
      return ((int[])paramObject).length;
    }
  }
  
  static final class c
    extends a.o
  {
    protected Object b(Object paramObject, int paramInt)
    {
      return Long.valueOf(((long[])paramObject)[paramInt]);
    }
    
    public int c(Object paramObject)
    {
      return ((long[])paramObject).length;
    }
  }
  
  static final class d
    extends a.o
  {
    protected Object b(Object paramObject, int paramInt)
    {
      return Float.valueOf(((float[])paramObject)[paramInt]);
    }
    
    public int c(Object paramObject)
    {
      return ((float[])paramObject).length;
    }
  }
  
  static final class e
    extends a.o
  {
    protected Object b(Object paramObject, int paramInt)
    {
      return Double.valueOf(((double[])paramObject)[paramInt]);
    }
    
    public int c(Object paramObject)
    {
      return ((double[])paramObject).length;
    }
  }
  
  class f
    implements Iterator<Object>
  {
    private int c;
    private int d;
    
    f(a.o paramo, Object paramObject)
    {
      this.c = paramo.c(paramObject);
    }
    
    public boolean hasNext()
    {
      boolean bool;
      if (this.d < this.c) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public Object next()
    {
      a.o localo = this.f;
      Object localObject = paramObject;
      int i = this.d;
      this.d = (i + 1);
      return localo.b(localObject, i);
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
  
  static final class g
    implements f.v
  {
    public Object a(Object paramObject, String paramString)
      throws Exception
    {
      paramString = ((f.g)paramObject).get(paramString);
      paramObject = paramString;
      if (paramString == null) {
        paramObject = g.a;
      }
      return paramObject;
    }
    
    public String toString()
    {
      return "CUSTOM_FETCHER";
    }
  }
  
  static final class h
    implements f.v
  {
    public Object a(Object paramObject, String paramString)
      throws Exception
    {
      paramObject = (Map)paramObject;
      if (((Map)paramObject).containsKey(paramString)) {
        return ((Map)paramObject).get(paramString);
      }
      if ("entrySet".equals(paramString)) {
        return ((Map)paramObject).entrySet();
      }
      return g.a;
    }
    
    public String toString()
    {
      return "MAP_FETCHER";
    }
  }
  
  static final class i
    implements f.v
  {
    public Object a(Object paramObject, String paramString)
      throws Exception
    {
      try
      {
        paramObject = ((List)paramObject).get(Integer.parseInt(paramString));
        return paramObject;
      }
      catch (IndexOutOfBoundsException paramObject)
      {
        return g.a;
      }
      catch (NumberFormatException paramObject) {}
      return g.a;
    }
    
    public String toString()
    {
      return "LIST_FETCHER";
    }
  }
  
  static final class j
    implements f.v
  {
    public Object a(Object paramObject, String paramString)
      throws Exception
    {
      try
      {
        paramObject = (Iterator)paramObject;
        int i = 0;
        int j = Integer.parseInt(paramString);
        while (i < j)
        {
          ((Iterator)paramObject).next();
          i++;
        }
        paramObject = ((Iterator)paramObject).next();
        return paramObject;
      }
      catch (NoSuchElementException paramObject)
      {
        return g.a;
      }
      catch (NumberFormatException paramObject) {}
      return g.a;
    }
    
    public String toString()
    {
      return "ITER_FETCHER";
    }
  }
  
  static final class k
    extends a.o
  {
    protected Object b(Object paramObject, int paramInt)
    {
      return ((Object[])paramObject)[paramInt];
    }
    
    public int c(Object paramObject)
    {
      return ((Object[])paramObject).length;
    }
  }
  
  static final class l
    extends a.o
  {
    protected Object b(Object paramObject, int paramInt)
    {
      return Boolean.valueOf(((boolean[])paramObject)[paramInt]);
    }
    
    public int c(Object paramObject)
    {
      return ((boolean[])paramObject).length;
    }
  }
  
  static final class m
    extends a.o
  {
    protected Object b(Object paramObject, int paramInt)
    {
      return Byte.valueOf(((byte[])paramObject)[paramInt]);
    }
    
    public int c(Object paramObject)
    {
      return ((byte[])paramObject).length;
    }
  }
  
  static final class n
    extends a.o
  {
    protected Object b(Object paramObject, int paramInt)
    {
      return Character.valueOf(((char[])paramObject)[paramInt]);
    }
    
    public int c(Object paramObject)
    {
      return ((char[])paramObject).length;
    }
  }
  
  protected static abstract class o
    implements f.v
  {
    public Object a(Object paramObject, String paramString)
      throws Exception
    {
      try
      {
        paramObject = b(paramObject, Integer.parseInt(paramString));
        return paramObject;
      }
      catch (ArrayIndexOutOfBoundsException paramObject)
      {
        return g.a;
      }
      catch (NumberFormatException paramObject) {}
      return g.a;
    }
    
    protected abstract Object b(Object paramObject, int paramInt);
    
    public abstract int c(Object paramObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\samskivert\mustache\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */