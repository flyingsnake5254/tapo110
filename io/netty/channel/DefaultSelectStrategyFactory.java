package io.netty.channel;

public final class DefaultSelectStrategyFactory
  implements SelectStrategyFactory
{
  public static final SelectStrategyFactory INSTANCE = new DefaultSelectStrategyFactory();
  
  public SelectStrategy newSelectStrategy()
  {
    return DefaultSelectStrategy.INSTANCE;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\DefaultSelectStrategyFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */