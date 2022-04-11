package io.reactivex.exceptions;

import io.reactivex.internal.util.e;

public final class a
{
  public static RuntimeException a(Throwable paramThrowable)
  {
    throw e.e(paramThrowable);
  }
  
  public static void b(Throwable paramThrowable)
  {
    if (!(paramThrowable instanceof VirtualMachineError))
    {
      if (!(paramThrowable instanceof ThreadDeath))
      {
        if (!(paramThrowable instanceof LinkageError)) {
          return;
        }
        throw ((LinkageError)paramThrowable);
      }
      throw ((ThreadDeath)paramThrowable);
    }
    throw ((VirtualMachineError)paramThrowable);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\reactivex\exceptions\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */