package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

public final class TimeoutCancellationException
  extends CancellationException
{
  public final d1 coroutine;
  
  public TimeoutCancellationException(String paramString)
  {
    this(paramString, null);
  }
  
  public TimeoutCancellationException(String paramString, d1 paramd1)
  {
    super(paramString);
    this.coroutine = paramd1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\TimeoutCancellationException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */