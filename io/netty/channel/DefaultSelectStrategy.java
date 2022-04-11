package io.netty.channel;

import io.netty.util.IntSupplier;

final class DefaultSelectStrategy
  implements SelectStrategy
{
  static final SelectStrategy INSTANCE = new DefaultSelectStrategy();
  
  public int calculateStrategy(IntSupplier paramIntSupplier, boolean paramBoolean)
    throws Exception
  {
    int i;
    if (paramBoolean) {
      i = paramIntSupplier.get();
    } else {
      i = -1;
    }
    return i;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\DefaultSelectStrategy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */