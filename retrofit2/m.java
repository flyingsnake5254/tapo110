package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;
import okhttp3.Headers;
import okhttp3.MultipartBody.Part;
import okhttp3.RequestBody;

abstract class m<T>
{
  abstract void a(o paramo, @Nullable T paramT)
    throws IOException;
  
  final m<Object> b()
  {
    return new b();
  }
  
  final m<Iterable<T>> c()
  {
    return new a();
  }
  
  class a
    extends m<Iterable<T>>
  {
    a() {}
    
    void d(o paramo, @Nullable Iterable<T> paramIterable)
      throws IOException
    {
      if (paramIterable == null) {
        return;
      }
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext())
      {
        Object localObject = paramIterable.next();
        m.this.a(paramo, localObject);
      }
    }
  }
  
  class b
    extends m<Object>
  {
    b() {}
    
    void a(o paramo, @Nullable Object paramObject)
      throws IOException
    {
      if (paramObject == null) {
        return;
      }
      int i = 0;
      int j = Array.getLength(paramObject);
      while (i < j)
      {
        m.this.a(paramo, Array.get(paramObject, i));
        i++;
      }
    }
  }
  
  static final class c<T>
    extends m<T>
  {
    private final Method a;
    private final int b;
    private final f<T, RequestBody> c;
    
    c(Method paramMethod, int paramInt, f<T, RequestBody> paramf)
    {
      this.a = paramMethod;
      this.b = paramInt;
      this.c = paramf;
    }
    
    void a(o paramo, @Nullable T paramT)
    {
      if (paramT != null) {
        try
        {
          localObject = (RequestBody)this.c.convert(paramT);
          paramo.l((RequestBody)localObject);
          return;
        }
        catch (IOException localIOException)
        {
          paramo = this.a;
          int i = this.b;
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Unable to convert ");
          ((StringBuilder)localObject).append(paramT);
          ((StringBuilder)localObject).append(" to RequestBody");
          throw v.q(paramo, localIOException, i, ((StringBuilder)localObject).toString(), new Object[0]);
        }
      }
      throw v.p(this.a, this.b, "Body parameter value must not be null.", new Object[0]);
    }
  }
  
  static final class d<T>
    extends m<T>
  {
    private final String a;
    private final f<T, String> b;
    private final boolean c;
    
    d(String paramString, f<T, String> paramf, boolean paramBoolean)
    {
      this.a = ((String)v.b(paramString, "name == null"));
      this.b = paramf;
      this.c = paramBoolean;
    }
    
    void a(o paramo, @Nullable T paramT)
      throws IOException
    {
      if (paramT == null) {
        return;
      }
      paramT = (String)this.b.convert(paramT);
      if (paramT == null) {
        return;
      }
      paramo.a(this.a, paramT, this.c);
    }
  }
  
  static final class e<T>
    extends m<Map<String, T>>
  {
    private final Method a;
    private final int b;
    private final f<T, String> c;
    private final boolean d;
    
    e(Method paramMethod, int paramInt, f<T, String> paramf, boolean paramBoolean)
    {
      this.a = paramMethod;
      this.b = paramInt;
      this.c = paramf;
      this.d = paramBoolean;
    }
    
    void d(o paramo, @Nullable Map<String, T> paramMap)
      throws IOException
    {
      if (paramMap != null)
      {
        Object localObject1 = paramMap.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          paramMap = (String)((Map.Entry)localObject2).getKey();
          if (paramMap != null)
          {
            localObject2 = ((Map.Entry)localObject2).getValue();
            int i;
            if (localObject2 != null)
            {
              String str = (String)this.c.convert(localObject2);
              if (str != null)
              {
                paramo.a(paramMap, str, this.d);
              }
              else
              {
                paramo = this.a;
                i = this.b;
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("Field map value '");
                ((StringBuilder)localObject1).append(localObject2);
                ((StringBuilder)localObject1).append("' converted to null by ");
                ((StringBuilder)localObject1).append(this.c.getClass().getName());
                ((StringBuilder)localObject1).append(" for key '");
                ((StringBuilder)localObject1).append(paramMap);
                ((StringBuilder)localObject1).append("'.");
                throw v.p(paramo, i, ((StringBuilder)localObject1).toString(), new Object[0]);
              }
            }
            else
            {
              localObject2 = this.a;
              i = this.b;
              paramo = new StringBuilder();
              paramo.append("Field map contained null value for key '");
              paramo.append(paramMap);
              paramo.append("'.");
              throw v.p((Method)localObject2, i, paramo.toString(), new Object[0]);
            }
          }
          else
          {
            throw v.p(this.a, this.b, "Field map contained null key.", new Object[0]);
          }
        }
        return;
      }
      throw v.p(this.a, this.b, "Field map was null.", new Object[0]);
    }
  }
  
  static final class f<T>
    extends m<T>
  {
    private final String a;
    private final f<T, String> b;
    
    f(String paramString, f<T, String> paramf)
    {
      this.a = ((String)v.b(paramString, "name == null"));
      this.b = paramf;
    }
    
    void a(o paramo, @Nullable T paramT)
      throws IOException
    {
      if (paramT == null) {
        return;
      }
      paramT = (String)this.b.convert(paramT);
      if (paramT == null) {
        return;
      }
      paramo.b(this.a, paramT);
    }
  }
  
  static final class g<T>
    extends m<Map<String, T>>
  {
    private final Method a;
    private final int b;
    private final f<T, String> c;
    
    g(Method paramMethod, int paramInt, f<T, String> paramf)
    {
      this.a = paramMethod;
      this.b = paramInt;
      this.c = paramf;
    }
    
    void d(o paramo, @Nullable Map<String, T> paramMap)
      throws IOException
    {
      if (paramMap != null)
      {
        Object localObject1 = paramMap.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          paramMap = (String)((Map.Entry)localObject2).getKey();
          if (paramMap != null)
          {
            localObject2 = ((Map.Entry)localObject2).getValue();
            if (localObject2 != null)
            {
              paramo.b(paramMap, (String)this.c.convert(localObject2));
            }
            else
            {
              paramo = this.a;
              int i = this.b;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Header map contained null value for key '");
              ((StringBuilder)localObject1).append(paramMap);
              ((StringBuilder)localObject1).append("'.");
              throw v.p(paramo, i, ((StringBuilder)localObject1).toString(), new Object[0]);
            }
          }
          else
          {
            throw v.p(this.a, this.b, "Header map contained null key.", new Object[0]);
          }
        }
        return;
      }
      throw v.p(this.a, this.b, "Header map was null.", new Object[0]);
    }
  }
  
  static final class h
    extends m<Headers>
  {
    private final Method a;
    private final int b;
    
    h(Method paramMethod, int paramInt)
    {
      this.a = paramMethod;
      this.b = paramInt;
    }
    
    void d(o paramo, @Nullable Headers paramHeaders)
    {
      if (paramHeaders != null)
      {
        paramo.c(paramHeaders);
        return;
      }
      throw v.p(this.a, this.b, "Headers parameter must not be null.", new Object[0]);
    }
  }
  
  static final class i<T>
    extends m<T>
  {
    private final Method a;
    private final int b;
    private final Headers c;
    private final f<T, RequestBody> d;
    
    i(Method paramMethod, int paramInt, Headers paramHeaders, f<T, RequestBody> paramf)
    {
      this.a = paramMethod;
      this.b = paramInt;
      this.c = paramHeaders;
      this.d = paramf;
    }
    
    void a(o paramo, @Nullable T paramT)
    {
      if (paramT == null) {
        return;
      }
      try
      {
        localObject = (RequestBody)this.d.convert(paramT);
        paramo.d(this.c, (RequestBody)localObject);
        return;
      }
      catch (IOException paramo)
      {
        Method localMethod = this.a;
        int i = this.b;
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unable to convert ");
        ((StringBuilder)localObject).append(paramT);
        ((StringBuilder)localObject).append(" to RequestBody");
        throw v.p(localMethod, i, ((StringBuilder)localObject).toString(), new Object[] { paramo });
      }
    }
  }
  
  static final class j<T>
    extends m<Map<String, T>>
  {
    private final Method a;
    private final int b;
    private final f<T, RequestBody> c;
    private final String d;
    
    j(Method paramMethod, int paramInt, f<T, RequestBody> paramf, String paramString)
    {
      this.a = paramMethod;
      this.b = paramInt;
      this.c = paramf;
      this.d = paramString;
    }
    
    void d(o paramo, @Nullable Map<String, T> paramMap)
      throws IOException
    {
      if (paramMap != null)
      {
        Object localObject1 = paramMap.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          paramMap = (String)((Map.Entry)localObject2).getKey();
          if (paramMap != null)
          {
            localObject2 = ((Map.Entry)localObject2).getValue();
            if (localObject2 != null)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("form-data; name=\"");
              localStringBuilder.append(paramMap);
              localStringBuilder.append("\"");
              paramo.d(Headers.of(new String[] { "Content-Disposition", localStringBuilder.toString(), "Content-Transfer-Encoding", this.d }), (RequestBody)this.c.convert(localObject2));
            }
            else
            {
              paramo = this.a;
              int i = this.b;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("Part map contained null value for key '");
              ((StringBuilder)localObject1).append(paramMap);
              ((StringBuilder)localObject1).append("'.");
              throw v.p(paramo, i, ((StringBuilder)localObject1).toString(), new Object[0]);
            }
          }
          else
          {
            throw v.p(this.a, this.b, "Part map contained null key.", new Object[0]);
          }
        }
        return;
      }
      throw v.p(this.a, this.b, "Part map was null.", new Object[0]);
    }
  }
  
  static final class k<T>
    extends m<T>
  {
    private final Method a;
    private final int b;
    private final String c;
    private final f<T, String> d;
    private final boolean e;
    
    k(Method paramMethod, int paramInt, String paramString, f<T, String> paramf, boolean paramBoolean)
    {
      this.a = paramMethod;
      this.b = paramInt;
      this.c = ((String)v.b(paramString, "name == null"));
      this.d = paramf;
      this.e = paramBoolean;
    }
    
    void a(o paramo, @Nullable T paramT)
      throws IOException
    {
      if (paramT != null)
      {
        paramo.f(this.c, (String)this.d.convert(paramT), this.e);
        return;
      }
      paramo = this.a;
      int i = this.b;
      paramT = new StringBuilder();
      paramT.append("Path parameter \"");
      paramT.append(this.c);
      paramT.append("\" value must not be null.");
      throw v.p(paramo, i, paramT.toString(), new Object[0]);
    }
  }
  
  static final class l<T>
    extends m<T>
  {
    private final String a;
    private final f<T, String> b;
    private final boolean c;
    
    l(String paramString, f<T, String> paramf, boolean paramBoolean)
    {
      this.a = ((String)v.b(paramString, "name == null"));
      this.b = paramf;
      this.c = paramBoolean;
    }
    
    void a(o paramo, @Nullable T paramT)
      throws IOException
    {
      if (paramT == null) {
        return;
      }
      paramT = (String)this.b.convert(paramT);
      if (paramT == null) {
        return;
      }
      paramo.g(this.a, paramT, this.c);
    }
  }
  
  static final class m<T>
    extends m<Map<String, T>>
  {
    private final Method a;
    private final int b;
    private final f<T, String> c;
    private final boolean d;
    
    m(Method paramMethod, int paramInt, f<T, String> paramf, boolean paramBoolean)
    {
      this.a = paramMethod;
      this.b = paramInt;
      this.c = paramf;
      this.d = paramBoolean;
    }
    
    void d(o paramo, @Nullable Map<String, T> paramMap)
      throws IOException
    {
      if (paramMap != null)
      {
        Object localObject1 = paramMap.entrySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
          paramMap = (String)((Map.Entry)localObject2).getKey();
          if (paramMap != null)
          {
            localObject2 = ((Map.Entry)localObject2).getValue();
            int i;
            if (localObject2 != null)
            {
              String str = (String)this.c.convert(localObject2);
              if (str != null)
              {
                paramo.g(paramMap, str, this.d);
              }
              else
              {
                paramo = this.a;
                i = this.b;
                localObject1 = new StringBuilder();
                ((StringBuilder)localObject1).append("Query map value '");
                ((StringBuilder)localObject1).append(localObject2);
                ((StringBuilder)localObject1).append("' converted to null by ");
                ((StringBuilder)localObject1).append(this.c.getClass().getName());
                ((StringBuilder)localObject1).append(" for key '");
                ((StringBuilder)localObject1).append(paramMap);
                ((StringBuilder)localObject1).append("'.");
                throw v.p(paramo, i, ((StringBuilder)localObject1).toString(), new Object[0]);
              }
            }
            else
            {
              localObject2 = this.a;
              i = this.b;
              paramo = new StringBuilder();
              paramo.append("Query map contained null value for key '");
              paramo.append(paramMap);
              paramo.append("'.");
              throw v.p((Method)localObject2, i, paramo.toString(), new Object[0]);
            }
          }
          else
          {
            throw v.p(this.a, this.b, "Query map contained null key.", new Object[0]);
          }
        }
        return;
      }
      throw v.p(this.a, this.b, "Query map was null", new Object[0]);
    }
  }
  
  static final class n<T>
    extends m<T>
  {
    private final f<T, String> a;
    private final boolean b;
    
    n(f<T, String> paramf, boolean paramBoolean)
    {
      this.a = paramf;
      this.b = paramBoolean;
    }
    
    void a(o paramo, @Nullable T paramT)
      throws IOException
    {
      if (paramT == null) {
        return;
      }
      paramo.g((String)this.a.convert(paramT), null, this.b);
    }
  }
  
  static final class o
    extends m<MultipartBody.Part>
  {
    static final o a = new o();
    
    void d(o paramo, @Nullable MultipartBody.Part paramPart)
    {
      if (paramPart != null) {
        paramo.e(paramPart);
      }
    }
  }
  
  static final class p
    extends m<Object>
  {
    private final Method a;
    private final int b;
    
    p(Method paramMethod, int paramInt)
    {
      this.a = paramMethod;
      this.b = paramInt;
    }
    
    void a(o paramo, @Nullable Object paramObject)
    {
      if (paramObject != null)
      {
        paramo.m(paramObject);
        return;
      }
      throw v.p(this.a, this.b, "@Url parameter is null.", new Object[0]);
    }
  }
  
  static final class q<T>
    extends m<T>
  {
    final Class<T> a;
    
    q(Class<T> paramClass)
    {
      this.a = paramClass;
    }
    
    void a(o paramo, @Nullable T paramT)
    {
      paramo.h(this.a, paramT);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */