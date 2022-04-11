package retrofit2;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

public final class i
{
  private final Method a;
  private final List<?> b;
  
  i(Method paramMethod, List<?> paramList)
  {
    this.a = paramMethod;
    this.b = Collections.unmodifiableList(paramList);
  }
  
  public Method a()
  {
    return this.a;
  }
  
  public String toString()
  {
    return String.format("%s.%s() %s", new Object[] { this.a.getDeclaringClass().getName(), this.a.getName(), this.b });
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\i.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */