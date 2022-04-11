package retrofit2;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

abstract class s<T>
{
  static <T> s<T> b(r paramr, Method paramMethod)
  {
    p localp = p.b(paramr, paramMethod);
    Type localType = paramMethod.getGenericReturnType();
    if (!v.k(localType))
    {
      if (localType != Void.TYPE) {
        return h.f(paramr, paramMethod, localp);
      }
      throw v.n(paramMethod, "Service methods cannot return void.", new Object[0]);
    }
    throw v.n(paramMethod, "Method return type must not include a type variable or wildcard: %s", new Object[] { localType });
  }
  
  @Nullable
  abstract T a(Object[] paramArrayOfObject);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */