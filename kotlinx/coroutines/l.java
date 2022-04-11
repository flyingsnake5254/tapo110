package kotlinx.coroutines;

public final class l
  extends e1<d1>
{
  public final i<?> x;
  
  public l(d1 paramd1, i<?> parami)
  {
    super(paramd1);
    this.x = parami;
  }
  
  public void L(Throwable paramThrowable)
  {
    paramThrowable = this.x;
    paramThrowable.l(paramThrowable.o(this.q));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ChildContinuation[");
    localStringBuilder.append(this.x);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */