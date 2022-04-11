package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import javax.annotation.Nullable;
import okhttp3.ResponseBody;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@IgnoreJRERequirement
final class l
  extends f.a
{
  static final f.a a = new l();
  
  @Nullable
  public f<ResponseBody, ?> d(Type paramType, Annotation[] paramArrayOfAnnotation, r paramr)
  {
    if (f.a.b(paramType) != Optional.class) {
      return null;
    }
    return new a(paramr.i(f.a.a(0, (ParameterizedType)paramType), paramArrayOfAnnotation));
  }
  
  @IgnoreJRERequirement
  static final class a<T>
    implements f<ResponseBody, Optional<T>>
  {
    final f<ResponseBody, T> a;
    
    a(f<ResponseBody, T> paramf)
    {
      this.a = paramf;
    }
    
    public Optional<T> a(ResponseBody paramResponseBody)
      throws IOException
    {
      return Optional.ofNullable(this.a.convert(paramResponseBody));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */