package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import okhttp3.Call.Factory;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public final class r
{
  private final Map<Method, s<?>> a = new ConcurrentHashMap();
  final Call.Factory b;
  final HttpUrl c;
  final List<f.a> d;
  final List<c.a> e;
  @Nullable
  final Executor f;
  final boolean g;
  
  r(Call.Factory paramFactory, HttpUrl paramHttpUrl, List<f.a> paramList, List<c.a> paramList1, @Nullable Executor paramExecutor, boolean paramBoolean)
  {
    this.b = paramFactory;
    this.c = paramHttpUrl;
    this.d = paramList;
    this.e = paramList1;
    this.f = paramExecutor;
    this.g = paramBoolean;
  }
  
  private void c(Class<?> paramClass)
  {
    n localn = n.f();
    for (paramClass : paramClass.getDeclaredMethods()) {
      if ((!localn.h(paramClass)) && (!Modifier.isStatic(paramClass.getModifiers()))) {
        d(paramClass);
      }
    }
  }
  
  public c<?, ?> a(Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    return e(null, paramType, paramArrayOfAnnotation);
  }
  
  public <T> T b(final Class<T> paramClass)
  {
    v.v(paramClass);
    if (this.g) {
      c(paramClass);
    }
    ClassLoader localClassLoader = paramClass.getClassLoader();
    a locala = new a(paramClass);
    return (T)Proxy.newProxyInstance(localClassLoader, new Class[] { paramClass }, locala);
  }
  
  s<?> d(Method paramMethod)
  {
    Object localObject = (s)this.a.get(paramMethod);
    if (localObject != null) {
      return (s<?>)localObject;
    }
    synchronized (this.a)
    {
      s locals = (s)this.a.get(paramMethod);
      localObject = locals;
      if (locals == null)
      {
        localObject = s.b(this, paramMethod);
        this.a.put(paramMethod, localObject);
      }
      return (s<?>)localObject;
    }
  }
  
  public c<?, ?> e(@Nullable c.a parama, Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    v.b(paramType, "returnType == null");
    v.b(paramArrayOfAnnotation, "annotations == null");
    int i = this.e.indexOf(parama) + 1;
    int j = this.e.size();
    for (int k = i; k < j; k++)
    {
      c localc = ((c.a)this.e.get(k)).a(paramType, paramArrayOfAnnotation, this);
      if (localc != null) {
        return localc;
      }
    }
    paramArrayOfAnnotation = new StringBuilder("Could not locate call adapter for ");
    paramArrayOfAnnotation.append(paramType);
    paramArrayOfAnnotation.append(".\n");
    if (parama != null)
    {
      paramArrayOfAnnotation.append("  Skipped:");
      for (k = 0; k < i; k++)
      {
        paramArrayOfAnnotation.append("\n   * ");
        paramArrayOfAnnotation.append(((c.a)this.e.get(k)).getClass().getName());
      }
      paramArrayOfAnnotation.append('\n');
    }
    paramArrayOfAnnotation.append("  Tried:");
    k = this.e.size();
    while (i < k)
    {
      paramArrayOfAnnotation.append("\n   * ");
      paramArrayOfAnnotation.append(((c.a)this.e.get(i)).getClass().getName());
      i++;
    }
    throw new IllegalArgumentException(paramArrayOfAnnotation.toString());
  }
  
  public <T> f<T, RequestBody> f(@Nullable f.a parama, Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2)
  {
    v.b(paramType, "type == null");
    v.b(paramArrayOfAnnotation1, "parameterAnnotations == null");
    v.b(paramArrayOfAnnotation2, "methodAnnotations == null");
    int i = this.d.indexOf(parama) + 1;
    int j = this.d.size();
    for (int k = i; k < j; k++)
    {
      f localf = ((f.a)this.d.get(k)).c(paramType, paramArrayOfAnnotation1, paramArrayOfAnnotation2, this);
      if (localf != null) {
        return localf;
      }
    }
    paramArrayOfAnnotation1 = new StringBuilder("Could not locate RequestBody converter for ");
    paramArrayOfAnnotation1.append(paramType);
    paramArrayOfAnnotation1.append(".\n");
    if (parama != null)
    {
      paramArrayOfAnnotation1.append("  Skipped:");
      for (k = 0; k < i; k++)
      {
        paramArrayOfAnnotation1.append("\n   * ");
        paramArrayOfAnnotation1.append(((f.a)this.d.get(k)).getClass().getName());
      }
      paramArrayOfAnnotation1.append('\n');
    }
    paramArrayOfAnnotation1.append("  Tried:");
    k = this.d.size();
    while (i < k)
    {
      paramArrayOfAnnotation1.append("\n   * ");
      paramArrayOfAnnotation1.append(((f.a)this.d.get(i)).getClass().getName());
      i++;
    }
    throw new IllegalArgumentException(paramArrayOfAnnotation1.toString());
  }
  
  public <T> f<ResponseBody, T> g(@Nullable f.a parama, Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    v.b(paramType, "type == null");
    v.b(paramArrayOfAnnotation, "annotations == null");
    int i = this.d.indexOf(parama) + 1;
    int j = this.d.size();
    for (int k = i; k < j; k++)
    {
      f localf = ((f.a)this.d.get(k)).d(paramType, paramArrayOfAnnotation, this);
      if (localf != null) {
        return localf;
      }
    }
    paramArrayOfAnnotation = new StringBuilder("Could not locate ResponseBody converter for ");
    paramArrayOfAnnotation.append(paramType);
    paramArrayOfAnnotation.append(".\n");
    if (parama != null)
    {
      paramArrayOfAnnotation.append("  Skipped:");
      for (k = 0; k < i; k++)
      {
        paramArrayOfAnnotation.append("\n   * ");
        paramArrayOfAnnotation.append(((f.a)this.d.get(k)).getClass().getName());
      }
      paramArrayOfAnnotation.append('\n');
    }
    paramArrayOfAnnotation.append("  Tried:");
    k = this.d.size();
    while (i < k)
    {
      paramArrayOfAnnotation.append("\n   * ");
      paramArrayOfAnnotation.append(((f.a)this.d.get(i)).getClass().getName());
      i++;
    }
    throw new IllegalArgumentException(paramArrayOfAnnotation.toString());
  }
  
  public <T> f<T, RequestBody> h(Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2)
  {
    return f(null, paramType, paramArrayOfAnnotation1, paramArrayOfAnnotation2);
  }
  
  public <T> f<ResponseBody, T> i(Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    return g(null, paramType, paramArrayOfAnnotation);
  }
  
  public <T> f<T, String> j(Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    v.b(paramType, "type == null");
    v.b(paramArrayOfAnnotation, "annotations == null");
    int i = this.d.size();
    for (int j = 0; j < i; j++)
    {
      f localf = ((f.a)this.d.get(j)).e(paramType, paramArrayOfAnnotation, this);
      if (localf != null) {
        return localf;
      }
    }
    return a.d.a;
  }
  
  class a
    implements InvocationHandler
  {
    private final n a = n.f();
    private final Object[] b = new Object[0];
    
    a(Class paramClass) {}
    
    @Nullable
    public Object invoke(Object paramObject, Method paramMethod, @Nullable Object[] paramArrayOfObject)
      throws Throwable
    {
      if (paramMethod.getDeclaringClass() == Object.class) {
        return paramMethod.invoke(this, paramArrayOfObject);
      }
      if (this.a.h(paramMethod)) {
        return this.a.g(paramMethod, paramClass, paramObject, paramArrayOfObject);
      }
      paramObject = r.this.d(paramMethod);
      if (paramArrayOfObject == null) {
        paramArrayOfObject = this.b;
      }
      return ((s)paramObject).a(paramArrayOfObject);
    }
  }
  
  public static final class b
  {
    private final n a;
    @Nullable
    private Call.Factory b;
    @Nullable
    private HttpUrl c;
    private final List<f.a> d = new ArrayList();
    private final List<c.a> e = new ArrayList();
    @Nullable
    private Executor f;
    private boolean g;
    
    public b()
    {
      this(n.f());
    }
    
    b(n paramn)
    {
      this.a = paramn;
    }
    
    public b a(c.a parama)
    {
      this.e.add(v.b(parama, "factory == null"));
      return this;
    }
    
    public b b(f.a parama)
    {
      this.d.add(v.b(parama, "factory == null"));
      return this;
    }
    
    public b c(String paramString)
    {
      v.b(paramString, "baseUrl == null");
      return d(HttpUrl.get(paramString));
    }
    
    public b d(HttpUrl paramHttpUrl)
    {
      v.b(paramHttpUrl, "baseUrl == null");
      Object localObject = paramHttpUrl.pathSegments();
      if ("".equals(((List)localObject).get(((List)localObject).size() - 1)))
      {
        this.c = paramHttpUrl;
        return this;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("baseUrl must end in /: ");
      ((StringBuilder)localObject).append(paramHttpUrl);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    
    public r e()
    {
      if (this.c != null)
      {
        Object localObject1 = this.b;
        Object localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new OkHttpClient();
        }
        Object localObject3 = this.f;
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = this.a.b();
        }
        ArrayList localArrayList = new ArrayList(this.e);
        localArrayList.addAll(this.a.a((Executor)localObject1));
        localObject3 = new ArrayList(this.d.size() + 1 + this.a.d());
        ((List)localObject3).add(new a());
        ((List)localObject3).addAll(this.d);
        ((List)localObject3).addAll(this.a.c());
        return new r((Call.Factory)localObject2, this.c, Collections.unmodifiableList((List)localObject3), Collections.unmodifiableList(localArrayList), (Executor)localObject1, this.g);
      }
      throw new IllegalStateException("Base URL required.");
    }
    
    public b f(Call.Factory paramFactory)
    {
      this.b = ((Call.Factory)v.b(paramFactory, "factory == null"));
      return this;
    }
    
    public b g(OkHttpClient paramOkHttpClient)
    {
      return f((Call.Factory)v.b(paramOkHttpClient, "client == null"));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */