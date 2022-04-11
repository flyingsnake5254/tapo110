package retrofit2.w.a;

import com.google.gson.Gson;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.f;
import retrofit2.f.a;
import retrofit2.r;

public final class a
  extends f.a
{
  private final Gson a;
  
  private a(Gson paramGson)
  {
    this.a = paramGson;
  }
  
  public static a f()
  {
    return g(new Gson());
  }
  
  public static a g(Gson paramGson)
  {
    Objects.requireNonNull(paramGson, "gson == null");
    return new a(paramGson);
  }
  
  public f<?, RequestBody> c(Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2, r paramr)
  {
    paramType = this.a.n(com.google.gson.r.a.get(paramType));
    return new b(this.a, paramType);
  }
  
  public f<ResponseBody, ?> d(Type paramType, Annotation[] paramArrayOfAnnotation, r paramr)
  {
    paramType = this.a.n(com.google.gson.r.a.get(paramType));
    return new c(this.a, paramType);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\w\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */