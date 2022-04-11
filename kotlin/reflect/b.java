package kotlin.reflect;

import java.util.List;
import java.util.Map;

public abstract interface b<R>
  extends a
{
  public abstract R call(Object... paramVarArgs);
  
  public abstract R callBy(Map<?, ? extends Object> paramMap);
  
  public abstract List<?> getParameters();
  
  public abstract n getReturnType();
  
  public abstract List<?> getTypeParameters();
  
  public abstract KVisibility getVisibility();
  
  public abstract boolean isAbstract();
  
  public abstract boolean isFinal();
  
  public abstract boolean isOpen();
  
  public abstract boolean isSuspend();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\reflect\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */