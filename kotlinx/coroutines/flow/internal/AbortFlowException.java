package kotlinx.coroutines.flow.internal;

import java.util.concurrent.CancellationException;
import kotlinx.coroutines.g0;

public final class AbortFlowException
  extends CancellationException
{
  public AbortFlowException()
  {
    super("Flow was aborted, no more elements needed");
  }
  
  public Throwable fillInStackTrace()
  {
    if (g0.c()) {
      super.fillInStackTrace();
    }
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\flow\internal\AbortFlowException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */