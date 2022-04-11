package io.netty.handler.codec;

import io.netty.util.Signal;
import io.netty.util.internal.ObjectUtil;

public class DecoderResult
{
  protected static final Signal SIGNAL_SUCCESS;
  protected static final Signal SIGNAL_UNFINISHED;
  public static final DecoderResult SUCCESS;
  public static final DecoderResult UNFINISHED;
  private final Throwable cause;
  
  static
  {
    Signal localSignal1 = Signal.valueOf(DecoderResult.class, "UNFINISHED");
    SIGNAL_UNFINISHED = localSignal1;
    Signal localSignal2 = Signal.valueOf(DecoderResult.class, "SUCCESS");
    SIGNAL_SUCCESS = localSignal2;
    UNFINISHED = new DecoderResult(localSignal1);
    SUCCESS = new DecoderResult(localSignal2);
  }
  
  protected DecoderResult(Throwable paramThrowable)
  {
    this.cause = ((Throwable)ObjectUtil.checkNotNull(paramThrowable, "cause"));
  }
  
  public static DecoderResult failure(Throwable paramThrowable)
  {
    return new DecoderResult((Throwable)ObjectUtil.checkNotNull(paramThrowable, "cause"));
  }
  
  public Throwable cause()
  {
    if (isFailure()) {
      return this.cause;
    }
    return null;
  }
  
  public boolean isFailure()
  {
    Throwable localThrowable = this.cause;
    boolean bool;
    if ((localThrowable != SIGNAL_SUCCESS) && (localThrowable != SIGNAL_UNFINISHED)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isFinished()
  {
    boolean bool;
    if (this.cause != SIGNAL_UNFINISHED) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isSuccess()
  {
    boolean bool;
    if (this.cause == SIGNAL_SUCCESS) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public String toString()
  {
    if (isFinished())
    {
      if (isSuccess()) {
        return "success";
      }
      String str = cause().toString();
      StringBuilder localStringBuilder = new StringBuilder(str.length() + 17);
      localStringBuilder.append("failure(");
      localStringBuilder.append(str);
      localStringBuilder.append(')');
      return localStringBuilder.toString();
    }
    return "unfinished";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\DecoderResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */