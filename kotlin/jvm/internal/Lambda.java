package kotlin.jvm.internal;

import java.io.Serializable;

public abstract class Lambda<R>
  implements h<R>, Serializable
{
  private final int arity;
  
  public Lambda(int paramInt)
  {
    this.arity = paramInt;
  }
  
  public int getArity()
  {
    return this.arity;
  }
  
  public String toString()
  {
    String str = m.k(this);
    j.d(str, "Reflection.renderLambdaToString(this)");
    return str;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\Lambda.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */