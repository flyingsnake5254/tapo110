package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import kotlin.p;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.x.w;

final class a
  extends f.a
{
  private boolean a = true;
  
  @Nullable
  public f<?, RequestBody> c(Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2, r paramr)
  {
    if (RequestBody.class.isAssignableFrom(v.i(paramType))) {
      return b.a;
    }
    return null;
  }
  
  @Nullable
  public f<ResponseBody, ?> d(Type paramType, Annotation[] paramArrayOfAnnotation, r paramr)
  {
    if (paramType == ResponseBody.class)
    {
      if (v.m(paramArrayOfAnnotation, w.class)) {
        paramType = c.a;
      } else {
        paramType = a.a;
      }
      return paramType;
    }
    if (paramType == Void.class) {
      return f.a;
    }
    if ((this.a) && (paramType == p.class)) {
      try
      {
        paramType = e.a;
        return paramType;
      }
      catch (NoClassDefFoundError paramType)
      {
        this.a = false;
      }
    }
    return null;
  }
  
  static final class a
    implements f<ResponseBody, ResponseBody>
  {
    static final a a = new a();
    
    public ResponseBody a(ResponseBody paramResponseBody)
      throws IOException
    {
      try
      {
        ResponseBody localResponseBody = v.a(paramResponseBody);
        return localResponseBody;
      }
      finally
      {
        paramResponseBody.close();
      }
    }
  }
  
  static final class b
    implements f<RequestBody, RequestBody>
  {
    static final b a = new b();
    
    public RequestBody a(RequestBody paramRequestBody)
    {
      return paramRequestBody;
    }
  }
  
  static final class c
    implements f<ResponseBody, ResponseBody>
  {
    static final c a = new c();
    
    public ResponseBody a(ResponseBody paramResponseBody)
    {
      return paramResponseBody;
    }
  }
  
  static final class d
    implements f<Object, String>
  {
    static final d a = new d();
    
    public String a(Object paramObject)
    {
      return paramObject.toString();
    }
  }
  
  static final class e
    implements f<ResponseBody, p>
  {
    static final e a = new e();
    
    public p a(ResponseBody paramResponseBody)
    {
      paramResponseBody.close();
      return p.a;
    }
  }
  
  static final class f
    implements f<ResponseBody, Void>
  {
    static final f a = new f();
    
    public Void a(ResponseBody paramResponseBody)
    {
      paramResponseBody.close();
      return null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */