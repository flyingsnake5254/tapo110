package kotlinx.coroutines.scheduling;

public abstract class h
  implements Runnable
{
  public long c;
  public i d;
  
  public h()
  {
    this(0L, g.d);
  }
  
  public h(long paramLong, i parami)
  {
    this.c = paramLong;
    this.d = parami;
  }
  
  public final TaskMode a()
  {
    return this.d.e();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\scheduling\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */