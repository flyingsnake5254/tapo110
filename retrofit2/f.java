package retrofit2;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public abstract interface f<F, T>
{
  @Nullable
  public abstract T convert(F paramF)
    throws IOException;
  
  public static abstract class a
  {
    protected static Type a(int paramInt, ParameterizedType paramParameterizedType)
    {
      return v.h(paramInt, paramParameterizedType);
    }
    
    protected static Class<?> b(Type paramType)
    {
      return v.i(paramType);
    }
    
    @Nullable
    public f<?, RequestBody> c(Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2, r paramr)
    {
      return null;
    }
    
    @Nullable
    public f<ResponseBody, ?> d(Type paramType, Annotation[] paramArrayOfAnnotation, r paramr)
    {
      return null;
    }
    
    @Nullable
    public f<?, String> e(Type paramType, Annotation[] paramArrayOfAnnotation, r paramr)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */