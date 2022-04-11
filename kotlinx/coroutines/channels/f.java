package kotlinx.coroutines.channels;

import kotlinx.coroutines.internal.u;

public abstract interface f<E>
  extends v<E>, r<E>
{
  public static final a i = a.b;
  
  public static final class a
  {
    private static final int a = u.b("kotlinx.coroutines.channels.defaultBuffer", 64, 1, 2147483646);
    
    public final int a()
    {
      return a;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\channels\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */