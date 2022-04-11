package io.netty.util.internal;

import java.util.concurrent.atomic.LongAdder;

@SuppressJava6Requirement(reason="Usage guarded by java version check")
final class LongAdderCounter
  extends LongAdder
  implements LongCounter
{
  public long value()
  {
    return longValue();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\LongAdderCounter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */