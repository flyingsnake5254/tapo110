package io.netty.util;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public abstract interface Timer
{
  public abstract Timeout newTimeout(TimerTask paramTimerTask, long paramLong, TimeUnit paramTimeUnit);
  
  public abstract Set<Timeout> stop();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\Timer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */