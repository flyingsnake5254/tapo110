package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

public abstract interface c<R, T>
{
  public abstract Type a();
  
  public abstract T b(b<R> paramb);
  
  public static abstract class a
  {
    protected static Type b(int paramInt, ParameterizedType paramParameterizedType)
    {
      return v.h(paramInt, paramParameterizedType);
    }
    
    protected static Class<?> c(Type paramType)
    {
      return v.i(paramType);
    }
    
    @Nullable
    public abstract c<?, ?> a(Type paramType, Annotation[] paramArrayOfAnnotation, r paramr);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */