package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.Call.Factory;
import okhttp3.Response;
import okhttp3.ResponseBody;

abstract class h<ResponseT, ReturnT>
  extends s<ReturnT>
{
  private final p a;
  private final Call.Factory b;
  private final f<ResponseBody, ResponseT> c;
  
  h(p paramp, Call.Factory paramFactory, f<ResponseBody, ResponseT> paramf)
  {
    this.a = paramp;
    this.b = paramFactory;
    this.c = paramf;
  }
  
  private static <ResponseT, ReturnT> c<ResponseT, ReturnT> d(r paramr, Method paramMethod, Type paramType, Annotation[] paramArrayOfAnnotation)
  {
    try
    {
      paramr = paramr.a(paramType, paramArrayOfAnnotation);
      return paramr;
    }
    catch (RuntimeException paramr)
    {
      throw v.o(paramMethod, paramr, "Unable to create call adapter for %s", new Object[] { paramType });
    }
  }
  
  private static <ResponseT> f<ResponseBody, ResponseT> e(r paramr, Method paramMethod, Type paramType)
  {
    Annotation[] arrayOfAnnotation = paramMethod.getAnnotations();
    try
    {
      paramr = paramr.i(paramType, arrayOfAnnotation);
      return paramr;
    }
    catch (RuntimeException paramr)
    {
      throw v.o(paramMethod, paramr, "Unable to create converter for %s", new Object[] { paramType });
    }
  }
  
  static <ResponseT, ReturnT> h<ResponseT, ReturnT> f(r paramr, Method paramMethod, p paramp)
  {
    boolean bool = paramp.k;
    Annotation[] arrayOfAnnotation = paramMethod.getAnnotations();
    int i;
    if (bool)
    {
      localObject1 = paramMethod.getGenericParameterTypes();
      localObject1 = v.g(0, (ParameterizedType)localObject1[(localObject1.length - 1)]);
      if ((v.i((Type)localObject1) == q.class) && ((localObject1 instanceof ParameterizedType)))
      {
        localObject1 = v.h(0, (ParameterizedType)localObject1);
        i = 1;
      }
      else
      {
        i = 0;
      }
      localObject2 = new v.b(null, b.class, new Type[] { localObject1 });
      localObject1 = u.a(arrayOfAnnotation);
    }
    else
    {
      localObject2 = paramMethod.getGenericReturnType();
      i = 0;
      localObject1 = arrayOfAnnotation;
    }
    Object localObject1 = d(paramr, paramMethod, (Type)localObject2, (Annotation[])localObject1);
    Object localObject2 = ((c)localObject1).a();
    if (localObject2 != Response.class)
    {
      if (localObject2 != q.class)
      {
        if ((paramp.c.equals("HEAD")) && (!Void.class.equals(localObject2))) {
          throw v.n(paramMethod, "HEAD method must use Void as response type.", new Object[0]);
        }
        paramMethod = e(paramr, paramMethod, (Type)localObject2);
        paramr = paramr.b;
        if (!bool) {
          return new a(paramp, paramr, paramMethod, (c)localObject1);
        }
        if (i != 0) {
          return new c(paramp, paramr, paramMethod, (c)localObject1);
        }
        return new b(paramp, paramr, paramMethod, (c)localObject1, false);
      }
      throw v.n(paramMethod, "Response must include generic type (e.g., Response<String>)", new Object[0]);
    }
    paramr = new StringBuilder();
    paramr.append("'");
    paramr.append(v.i((Type)localObject2).getName());
    paramr.append("' is not a valid response body type. Did you mean ResponseBody?");
    throw v.n(paramMethod, paramr.toString(), new Object[0]);
  }
  
  @Nullable
  final ReturnT a(Object[] paramArrayOfObject)
  {
    return (ReturnT)c(new k(this.a, paramArrayOfObject, this.b, this.c), paramArrayOfObject);
  }
  
  @Nullable
  protected abstract ReturnT c(b<ResponseT> paramb, Object[] paramArrayOfObject);
  
  static final class a<ResponseT, ReturnT>
    extends h<ResponseT, ReturnT>
  {
    private final c<ResponseT, ReturnT> d;
    
    a(p paramp, Call.Factory paramFactory, f<ResponseBody, ResponseT> paramf, c<ResponseT, ReturnT> paramc)
    {
      super(paramFactory, paramf);
      this.d = paramc;
    }
    
    protected ReturnT c(b<ResponseT> paramb, Object[] paramArrayOfObject)
    {
      return (ReturnT)this.d.b(paramb);
    }
  }
  
  static final class b<ResponseT>
    extends h<ResponseT, Object>
  {
    private final c<ResponseT, b<ResponseT>> d;
    private final boolean e;
    
    b(p paramp, Call.Factory paramFactory, f<ResponseBody, ResponseT> paramf, c<ResponseT, b<ResponseT>> paramc, boolean paramBoolean)
    {
      super(paramFactory, paramf);
      this.d = paramc;
      this.e = paramBoolean;
    }
    
    protected Object c(b<ResponseT> paramb, Object[] paramArrayOfObject)
    {
      paramb = (b)this.d.b(paramb);
      paramArrayOfObject = (kotlin.coroutines.c)paramArrayOfObject[(paramArrayOfObject.length - 1)];
      try
      {
        if (this.e) {
          paramb = j.b(paramb, paramArrayOfObject);
        } else {
          paramb = j.a(paramb, paramArrayOfObject);
        }
        return paramb;
      }
      catch (Exception paramb) {}
      return j.d(paramb, paramArrayOfObject);
    }
  }
  
  static final class c<ResponseT>
    extends h<ResponseT, Object>
  {
    private final c<ResponseT, b<ResponseT>> d;
    
    c(p paramp, Call.Factory paramFactory, f<ResponseBody, ResponseT> paramf, c<ResponseT, b<ResponseT>> paramc)
    {
      super(paramFactory, paramf);
      this.d = paramc;
    }
    
    protected Object c(b<ResponseT> paramb, Object[] paramArrayOfObject)
    {
      b localb = (b)this.d.b(paramb);
      paramb = (kotlin.coroutines.c)paramArrayOfObject[(paramArrayOfObject.length - 1)];
      try
      {
        paramArrayOfObject = j.c(localb, paramb);
        return paramArrayOfObject;
      }
      catch (Exception paramArrayOfObject) {}
      return j.d(paramArrayOfObject, paramb);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */