package io.netty.handler.flow;

import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.ObjectPool;
import io.netty.util.internal.ObjectPool.Handle;
import io.netty.util.internal.ObjectPool.ObjectCreator;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.util.ArrayDeque;

public class FlowControlHandler
  extends ChannelDuplexHandler
{
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(FlowControlHandler.class);
  private ChannelConfig config;
  private RecyclableArrayDeque queue;
  private int readRequestCount;
  private final boolean releaseMessages;
  
  public FlowControlHandler()
  {
    this(true);
  }
  
  public FlowControlHandler(boolean paramBoolean)
  {
    this.releaseMessages = paramBoolean;
  }
  
  private int dequeue(ChannelHandlerContext paramChannelHandlerContext, int paramInt)
  {
    int i = 0;
    while ((this.queue != null) && ((i < paramInt) || (this.config.isAutoRead())))
    {
      localObject = this.queue.poll();
      if (localObject == null) {
        break;
      }
      i++;
      paramChannelHandlerContext.fireChannelRead(localObject);
    }
    Object localObject = this.queue;
    if ((localObject != null) && (((ArrayDeque)localObject).isEmpty()))
    {
      this.queue.recycle();
      this.queue = null;
      if (i > 0) {
        paramChannelHandlerContext.fireChannelReadComplete();
      }
    }
    return i;
  }
  
  private void destroy()
  {
    Object localObject = this.queue;
    if (localObject != null)
    {
      if (!((ArrayDeque)localObject).isEmpty())
      {
        logger.trace("Non-empty queue: {}", this.queue);
        if (this.releaseMessages) {
          for (;;)
          {
            localObject = this.queue.poll();
            if (localObject == null) {
              break;
            }
            ReferenceCountUtil.safeRelease(localObject);
          }
        }
      }
      this.queue.recycle();
      this.queue = null;
    }
  }
  
  public void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    destroy();
    paramChannelHandlerContext.fireChannelInactive();
  }
  
  public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    if (this.queue == null) {
      this.queue = RecyclableArrayDeque.newInstance();
    }
    this.queue.offer(paramObject);
    int i = Math.min(this.readRequestCount, this.queue.size());
    this.readRequestCount -= i;
    dequeue(paramChannelHandlerContext, i);
  }
  
  public void channelReadComplete(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (isQueueEmpty()) {
      paramChannelHandlerContext.fireChannelReadComplete();
    }
  }
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.config = paramChannelHandlerContext.channel().config();
  }
  
  public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    super.handlerRemoved(paramChannelHandlerContext);
    if (!isQueueEmpty()) {
      dequeue(paramChannelHandlerContext, this.queue.size());
    }
    destroy();
  }
  
  boolean isQueueEmpty()
  {
    RecyclableArrayDeque localRecyclableArrayDeque = this.queue;
    boolean bool;
    if ((localRecyclableArrayDeque != null) && (!localRecyclableArrayDeque.isEmpty())) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public void read(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (dequeue(paramChannelHandlerContext, 1) == 0)
    {
      this.readRequestCount += 1;
      paramChannelHandlerContext.read();
    }
  }
  
  private static final class RecyclableArrayDeque
    extends ArrayDeque<Object>
  {
    private static final int DEFAULT_NUM_ELEMENTS = 2;
    private static final ObjectPool<RecyclableArrayDeque> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator()
    {
      public FlowControlHandler.RecyclableArrayDeque newObject(ObjectPool.Handle<FlowControlHandler.RecyclableArrayDeque> paramAnonymousHandle)
      {
        return new FlowControlHandler.RecyclableArrayDeque(2, paramAnonymousHandle, null);
      }
    });
    private static final long serialVersionUID = 0L;
    private final ObjectPool.Handle<RecyclableArrayDeque> handle;
    
    private RecyclableArrayDeque(int paramInt, ObjectPool.Handle<RecyclableArrayDeque> paramHandle)
    {
      super();
      this.handle = paramHandle;
    }
    
    public static RecyclableArrayDeque newInstance()
    {
      return (RecyclableArrayDeque)RECYCLER.get();
    }
    
    public void recycle()
    {
      clear();
      this.handle.recycle(this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\flow\FlowControlHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */