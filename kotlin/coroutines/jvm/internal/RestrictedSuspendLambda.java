package kotlin.coroutines.jvm.internal;

import kotlin.coroutines.c;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.m;

public abstract class RestrictedSuspendLambda
  extends RestrictedContinuationImpl
  implements h<Object>
{
  private final int arity;
  
  public RestrictedSuspendLambda(int paramInt)
  {
    this(paramInt, null);
  }
  
  public RestrictedSuspendLambda(int paramInt, c<Object> paramc)
  {
    super(paramc);
    this.arity = paramInt;
  }
  
  public int getArity()
  {
    return this.arity;
  }
  
  public String toString()
  {
    String str;
    if (getCompletion() == null)
    {
      str = m.j(this);
      j.d(str, "Reflection.renderLambdaToString(this)");
    }
    else
    {
      str = super.toString();
    }
    return str;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\coroutines\jvm\internal\RestrictedSuspendLambda.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */