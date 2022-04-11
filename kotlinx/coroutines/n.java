package kotlinx.coroutines;

import kotlin.jvm.internal.j;

public final class n
  extends e1<j1>
  implements m
{
  public final o x;
  
  public n(j1 paramj1, o paramo)
  {
    super(paramj1);
    this.x = paramo;
  }
  
  public void L(Throwable paramThrowable)
  {
    this.x.j((q1)this.q);
  }
  
  public boolean c(Throwable paramThrowable)
  {
    j.f(paramThrowable, "cause");
    return ((j1)this.q).A(paramThrowable);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChildHandle[");
    localStringBuilder.append(this.x);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */