package io.netty.channel.pool;

public abstract interface ChannelPoolMap<K, P extends ChannelPool>
{
  public abstract boolean contains(K paramK);
  
  public abstract P get(K paramK);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\pool\ChannelPoolMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */