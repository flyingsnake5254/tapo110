package com.samskivert.mustache;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class g
{
  public static final Object a = new String("<no fetcher found>");
  protected static f.v b = new b();
  protected final f[] c;
  protected final f.f d;
  protected final Map<e, f.v> e;
  protected final e f;
  
  protected g(f[] paramArrayOff, f.f paramf, e parame)
  {
    this.c = paramArrayOff;
    this.d = paramf;
    this.e = paramf.j.b();
    this.f = parame;
  }
  
  protected static boolean l(String paramString)
  {
    boolean bool;
    if ((!".".equals(paramString)) && (!"this".equals(paramString))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  protected Object a(String paramString, int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramObject == a)
    {
      if (paramBoolean) {
        return null;
      }
      paramObject = new StringBuilder();
      ((StringBuilder)paramObject).append("No method or field with name '");
      ((StringBuilder)paramObject).append(paramString);
      ((StringBuilder)paramObject).append("' on line ");
      ((StringBuilder)paramObject).append(paramInt);
      throw new MustacheException.Context(((StringBuilder)paramObject).toString(), paramString, paramInt);
    }
    return paramObject;
  }
  
  protected d b(final f[] paramArrayOff, final c paramc)
  {
    return new a(paramc, paramArrayOff);
  }
  
  public String c(Object paramObject)
    throws MustacheException
  {
    StringWriter localStringWriter = new StringWriter();
    d(paramObject, localStringWriter);
    return localStringWriter.toString();
  }
  
  public void d(Object paramObject, Writer paramWriter)
    throws MustacheException
  {
    e(new c(paramObject, null, 0, false, false), paramWriter);
  }
  
  protected void e(c paramc, Writer paramWriter)
    throws MustacheException
  {
    f[] arrayOff = this.c;
    int i = arrayOff.length;
    for (int j = 0; j < i; j++) {
      arrayOff[j].a(this, paramc, paramWriter);
    }
  }
  
  protected Object f(c paramc, String paramString, int paramInt, boolean paramBoolean)
  {
    String[] arrayOfString = paramString.split("\\.");
    paramc = i(paramc, arrayOfString[0], paramInt, paramBoolean);
    for (int i = 1; i < arrayOfString.length; i++)
    {
      if (paramc == a)
      {
        if (paramBoolean) {
          return null;
        }
        paramc = new StringBuilder();
        paramc.append("Missing context for compound variable '");
        paramc.append(paramString);
        paramc.append("' on line ");
        paramc.append(paramInt);
        paramc.append(". '");
        paramc.append(arrayOfString[(i - 1)]);
        paramc.append("' was not found.");
        throw new MustacheException.Context(paramc.toString(), paramString, paramInt);
      }
      if (paramc == null) {
        return null;
      }
      paramc = j(paramc, arrayOfString[i], paramInt);
    }
    return a(paramString, paramInt, paramBoolean, paramc);
  }
  
  protected Object g(c paramc, d paramd, int paramInt)
  {
    Object localObject1 = i(paramc, paramd.a(), paramInt, true);
    if ((localObject1 instanceof f.k)) {
      try
      {
        ArrayList localArrayList = new java/util/ArrayList;
        localArrayList.<init>();
        paramd = paramd.b().iterator();
        while (paramd.hasNext())
        {
          Object localObject2 = paramd.next();
          Object localObject3;
          if ((localObject2 instanceof d))
          {
            localObject3 = g(paramc, (d)localObject2, paramInt);
            if (localObject3 != null) {
              localArrayList.add(localObject3);
            }
          }
          else if ((localObject2 instanceof String))
          {
            localObject3 = i(paramc, (String)localObject2, paramInt, true);
            if (localObject3 == null) {
              localArrayList.add(localObject2);
            } else {
              localArrayList.add(localObject3);
            }
          }
        }
        paramc = ((f.k)localObject1).a(paramc.a, localArrayList);
        return paramc;
      }
      catch (Exception paramc)
      {
        throw new MustacheException(paramc);
      }
    }
    return null;
  }
  
  protected Object h(c paramc, String paramString, int paramInt)
  {
    paramString = i(paramc, paramString, paramInt, this.d.b ^ true);
    paramc = paramString;
    if (paramString == null) {
      paramc = Collections.emptyList();
    }
    return paramc;
  }
  
  protected Object i(c paramc, String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString.equals("@first")) {
      return Boolean.valueOf(paramc.d);
    }
    if (paramString.equals("@last")) {
      return Boolean.valueOf(paramc.e);
    }
    if (paramString.equals("@index")) {
      return Integer.valueOf(paramc.c);
    }
    if (paramString.equals("@indexPlusOne")) {
      return Integer.valueOf(paramc.c + 1);
    }
    if (this.d.a) {
      return a(paramString, paramInt, paramBoolean, j(paramc.a, paramString, paramInt));
    }
    if ((this.f.b(paramString)) && (!this.f.a(paramString)))
    {
      localObject1 = this.f.c(paramString);
      if (localObject1 != null) {
        return g(paramc, (d)localObject1, paramInt);
      }
      throw new MustacheException.Context("Could not parse function", paramString, paramInt);
    }
    for (Object localObject1 = paramc; localObject1 != null; localObject1 = ((c)localObject1).b)
    {
      Object localObject2 = j(((c)localObject1).a, paramString, paramInt);
      if (localObject2 != a) {
        return localObject2;
      }
    }
    if ((!paramString.equals(".")) && (paramString.indexOf(".") != -1)) {
      return f(paramc, paramString, paramInt, paramBoolean);
    }
    if (this.f.b(paramString))
    {
      localObject1 = this.f.c(paramString);
      if (localObject1 != null) {
        return g(paramc, (d)localObject1, paramInt);
      }
      throw new MustacheException.Context("Could not parse function", paramString, paramInt);
    }
    return a(paramString, paramInt, paramBoolean, a);
  }
  
  protected Object j(Object paramObject, String paramString, int paramInt)
  {
    if (l(paramString)) {
      return paramObject;
    }
    if (paramObject != null)
    {
      e locale = new e(paramObject.getClass(), paramString);
      Object localObject = (f.v)this.e.get(locale);
      f.v localv1;
      if (localObject != null) {
        try
        {
          localObject = ((f.v)localObject).a(paramObject, paramString);
          return localObject;
        }
        catch (Exception localException1)
        {
          localv1 = this.d.j.c(paramObject, locale.b);
        }
      } else {
        localv1 = this.d.j.c(paramObject, locale.b);
      }
      f.v localv2 = localv1;
      if (localv1 == null) {
        localv2 = b;
      }
      try
      {
        paramObject = localv2.a(paramObject, paramString);
        this.e.put(locale, localv2);
        return paramObject;
      }
      catch (Exception localException2)
      {
        paramObject = new StringBuilder();
        ((StringBuilder)paramObject).append("Failure fetching variable '");
        ((StringBuilder)paramObject).append(paramString);
        ((StringBuilder)paramObject).append("' on line ");
        ((StringBuilder)paramObject).append(paramInt);
        throw new MustacheException.Context(((StringBuilder)paramObject).toString(), paramString, paramInt, localException2);
      }
    }
    paramObject = new StringBuilder();
    ((StringBuilder)paramObject).append("Null context for variable '");
    ((StringBuilder)paramObject).append(paramString);
    ((StringBuilder)paramObject).append("' on line ");
    ((StringBuilder)paramObject).append(paramInt);
    throw new NullPointerException(((StringBuilder)paramObject).toString());
  }
  
  protected Object k(c paramc, String paramString, int paramInt)
  {
    Object localObject = i(paramc, paramString, paramInt, this.d.d);
    paramc = (c)localObject;
    if (localObject == null) {
      paramc = this.d.c(paramString);
    }
    return paramc;
  }
  
  class a
    extends g.d
  {
    a(g.c paramc, g.f[] paramArrayOff)
    {
      super();
    }
  }
  
  static final class b
    implements f.v
  {
    public Object a(Object paramObject, String paramString)
      throws Exception
    {
      return g.a;
    }
  }
  
  protected static class c
  {
    public final Object a;
    public final c b;
    public final int c;
    public final boolean d;
    public final boolean e;
    
    public c(Object paramObject, c paramc, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      this.a = paramObject;
      this.b = paramc;
      this.c = paramInt;
      this.d = paramBoolean1;
      this.e = paramBoolean2;
    }
    
    public c a(Object paramObject)
    {
      return new c(paramObject, this, this.c, this.d, this.e);
    }
    
    public c b(Object paramObject, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
    {
      return new c(paramObject, this, paramInt, paramBoolean1, paramBoolean2);
    }
  }
  
  public abstract class d
  {
    public d() {}
  }
  
  protected static class e
  {
    public final Class<?> a;
    public final String b;
    
    public e(Class<?> paramClass, String paramString)
    {
      this.a = paramClass;
      this.b = paramString;
    }
    
    public boolean equals(Object paramObject)
    {
      paramObject = (e)paramObject;
      boolean bool;
      if ((((e)paramObject).a == this.a) && (((e)paramObject).b.equals(this.b))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public int hashCode()
    {
      return this.a.hashCode() * 31 + this.b.hashCode();
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a.getName());
      localStringBuilder.append(":");
      localStringBuilder.append(this.b);
      return localStringBuilder.toString();
    }
  }
  
  protected static abstract class f
  {
    protected static void b(Writer paramWriter, String paramString)
    {
      try
      {
        paramWriter.write(paramString);
        return;
      }
      catch (IOException paramWriter)
      {
        throw new MustacheException(paramWriter);
      }
    }
    
    abstract void a(g paramg, g.c paramc, Writer paramWriter);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\samskivert\mustache\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */