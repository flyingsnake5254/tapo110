package io.netty.channel;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.util.internal.ObjectUtil;

public final class DefaultMessageSizeEstimator
  implements MessageSizeEstimator
{
  public static final MessageSizeEstimator DEFAULT = new DefaultMessageSizeEstimator(8);
  private final MessageSizeEstimator.Handle handle;
  
  public DefaultMessageSizeEstimator(int paramInt)
  {
    ObjectUtil.checkPositiveOrZero(paramInt, "unknownSize");
    this.handle = new HandleImpl(paramInt, null);
  }
  
  public MessageSizeEstimator.Handle newHandle()
  {
    return this.handle;
  }
  
  private static final class HandleImpl
    implements MessageSizeEstimator.Handle
  {
    private final int unknownSize;
    
    private HandleImpl(int paramInt)
    {
      this.unknownSize = paramInt;
    }
    
    public int size(Object paramObject)
    {
      if ((paramObject instanceof ByteBuf)) {
        return ((ByteBuf)paramObject).readableBytes();
      }
      if ((paramObject instanceof ByteBufHolder)) {
        return ((ByteBufHolder)paramObject).content().readableBytes();
      }
      if ((paramObject instanceof FileRegion)) {
        return 0;
      }
      return this.unknownSize;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\DefaultMessageSizeEstimator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */