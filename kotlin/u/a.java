package kotlin.u;

import java.util.Random;

public abstract class a
  extends c
{
  public int b(int paramInt)
  {
    return d.d(e().nextInt(), paramInt);
  }
  
  public int c()
  {
    return e().nextInt();
  }
  
  public abstract Random e();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\u\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */