package kotlinx.coroutines;

import kotlinx.coroutines.internal.i;

final class r1
  extends f
{
  private final i c;
  
  public r1(i parami)
  {
    this.c = parami;
  }
  
  public void a(Throwable paramThrowable)
  {
    this.c.I();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RemoveOnCancel[");
    localStringBuilder.append(this.c);
    localStringBuilder.append(']');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\r1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */