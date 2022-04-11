package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.selects.c;

public abstract interface r<E>
{
  public abstract void a(CancellationException paramCancellationException);
  
  public abstract c<E> e();
  
  public abstract h<E> iterator();
  
  public static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\channels\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */