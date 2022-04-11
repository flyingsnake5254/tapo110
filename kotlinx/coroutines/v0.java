package kotlinx.coroutines;

import java.util.concurrent.CancellationException;

public final class v0
{
  public static final CancellationException a(String paramString, Throwable paramThrowable)
  {
    paramString = new CancellationException(paramString);
    paramString.initCause(paramThrowable);
    return paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlinx\coroutines\v0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */