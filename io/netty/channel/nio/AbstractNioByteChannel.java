package io.netty.channel.nio;

import io.netty.buffer.ByteBuf;
import io.netty.channel.AbstractChannel.AbstractUnsafe;
import io.netty.channel.Channel;
import io.netty.channel.ChannelConfig;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelMetadata;
import io.netty.channel.ChannelOutboundBuffer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.FileRegion;
import io.netty.channel.RecvByteBufAllocator.Handle;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.channel.socket.ChannelInputShutdownReadComplete;
import io.netty.channel.socket.SocketChannelConfig;
import io.netty.util.ReferenceCounted;
import io.netty.util.concurrent.SingleThreadEventExecutor;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;

public abstract class AbstractNioByteChannel
  extends AbstractNioChannel
{
  private static final String EXPECTED_TYPES;
  private static final ChannelMetadata METADATA = new ChannelMetadata(false, 16);
  private final Runnable flushTask = new Runnable()
  {
    public void run()
    {
      ((AbstractNioChannel.AbstractNioUnsafe)AbstractNioByteChannel.this.unsafe()).flush0();
    }
  };
  private boolean inputClosedSeenErrorOnRead;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" (expected: ");
    localStringBuilder.append(StringUtil.simpleClassName(ByteBuf.class));
    localStringBuilder.append(", ");
    localStringBuilder.append(StringUtil.simpleClassName(FileRegion.class));
    localStringBuilder.append(')');
    EXPECTED_TYPES = localStringBuilder.toString();
  }
  
  protected AbstractNioByteChannel(Channel paramChannel, SelectableChannel paramSelectableChannel)
  {
    super(paramChannel, paramSelectableChannel, 1);
  }
  
  private int doWriteInternal(ChannelOutboundBuffer paramChannelOutboundBuffer, Object paramObject)
    throws Exception
  {
    if ((paramObject instanceof ByteBuf))
    {
      paramObject = (ByteBuf)paramObject;
      if (!((ByteBuf)paramObject).isReadable())
      {
        paramChannelOutboundBuffer.remove();
        return 0;
      }
      int i = doWriteBytes((ByteBuf)paramObject);
      if (i > 0)
      {
        paramChannelOutboundBuffer.progress(i);
        if (!((ByteBuf)paramObject).isReadable()) {
          paramChannelOutboundBuffer.remove();
        }
        return 1;
      }
    }
    else
    {
      if (!(paramObject instanceof FileRegion)) {
        break label137;
      }
      paramObject = (FileRegion)paramObject;
      if (((FileRegion)paramObject).transferred() >= ((FileRegion)paramObject).count())
      {
        paramChannelOutboundBuffer.remove();
        return 0;
      }
      long l = doWriteFileRegion((FileRegion)paramObject);
      if (l > 0L)
      {
        paramChannelOutboundBuffer.progress(l);
        if (((FileRegion)paramObject).transferred() >= ((FileRegion)paramObject).count()) {
          paramChannelOutboundBuffer.remove();
        }
        return 1;
      }
    }
    return Integer.MAX_VALUE;
    label137:
    throw new Error();
  }
  
  private static boolean isAllowHalfClosure(ChannelConfig paramChannelConfig)
  {
    boolean bool;
    if (((paramChannelConfig instanceof SocketChannelConfig)) && (((SocketChannelConfig)paramChannelConfig).isAllowHalfClosure())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected final void clearOpWrite()
  {
    SelectionKey localSelectionKey = selectionKey();
    if (!localSelectionKey.isValid()) {
      return;
    }
    int i = localSelectionKey.interestOps();
    if ((i & 0x4) != 0) {
      localSelectionKey.interestOps(i & 0xFFFFFFFB);
    }
  }
  
  protected abstract int doReadBytes(ByteBuf paramByteBuf)
    throws Exception;
  
  protected void doWrite(ChannelOutboundBuffer paramChannelOutboundBuffer)
    throws Exception
  {
    int i = config().getWriteSpinCount();
    int j;
    do
    {
      Object localObject = paramChannelOutboundBuffer.current();
      if (localObject == null)
      {
        clearOpWrite();
        return;
      }
      j = i - doWriteInternal(paramChannelOutboundBuffer, localObject);
      i = j;
    } while (j > 0);
    boolean bool;
    if (j < 0) {
      bool = true;
    } else {
      bool = false;
    }
    incompleteWrite(bool);
  }
  
  protected final int doWrite0(ChannelOutboundBuffer paramChannelOutboundBuffer)
    throws Exception
  {
    if (paramChannelOutboundBuffer.current() == null) {
      return 0;
    }
    return doWriteInternal(paramChannelOutboundBuffer, paramChannelOutboundBuffer.current());
  }
  
  protected abstract int doWriteBytes(ByteBuf paramByteBuf)
    throws Exception;
  
  protected abstract long doWriteFileRegion(FileRegion paramFileRegion)
    throws Exception;
  
  protected final Object filterOutboundMessage(Object paramObject)
  {
    if ((paramObject instanceof ByteBuf))
    {
      localObject = (ByteBuf)paramObject;
      if (((ByteBuf)localObject).isDirect()) {
        return paramObject;
      }
      return newDirectBuffer((ByteBuf)localObject);
    }
    if ((paramObject instanceof FileRegion)) {
      return paramObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unsupported message type: ");
    ((StringBuilder)localObject).append(StringUtil.simpleClassName(paramObject));
    ((StringBuilder)localObject).append(EXPECTED_TYPES);
    throw new UnsupportedOperationException(((StringBuilder)localObject).toString());
  }
  
  protected final void incompleteWrite(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setOpWrite();
    }
    else
    {
      clearOpWrite();
      eventLoop().execute(this.flushTask);
    }
  }
  
  protected boolean isInputShutdown0()
  {
    return false;
  }
  
  public ChannelMetadata metadata()
  {
    return METADATA;
  }
  
  protected AbstractNioChannel.AbstractNioUnsafe newUnsafe()
  {
    return new NioByteUnsafe();
  }
  
  protected final void setOpWrite()
  {
    SelectionKey localSelectionKey = selectionKey();
    if (!localSelectionKey.isValid()) {
      return;
    }
    int i = localSelectionKey.interestOps();
    if ((i & 0x4) == 0) {
      localSelectionKey.interestOps(i | 0x4);
    }
  }
  
  final boolean shouldBreakReadReady(ChannelConfig paramChannelConfig)
  {
    boolean bool;
    if ((isInputShutdown0()) && ((this.inputClosedSeenErrorOnRead) || (!isAllowHalfClosure(paramChannelConfig)))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  protected abstract ChannelFuture shutdownInput();
  
  protected class NioByteUnsafe
    extends AbstractNioChannel.AbstractNioUnsafe
  {
    protected NioByteUnsafe()
    {
      super();
    }
    
    private void closeOnRead(ChannelPipeline paramChannelPipeline)
    {
      if (!AbstractNioByteChannel.this.isInputShutdown0())
      {
        if (AbstractNioByteChannel.isAllowHalfClosure(AbstractNioByteChannel.this.config()))
        {
          AbstractNioByteChannel.this.shutdownInput();
          paramChannelPipeline.fireUserEventTriggered(ChannelInputShutdownEvent.INSTANCE);
        }
        else
        {
          close(voidPromise());
        }
      }
      else
      {
        AbstractNioByteChannel.access$102(AbstractNioByteChannel.this, true);
        paramChannelPipeline.fireUserEventTriggered(ChannelInputShutdownReadComplete.INSTANCE);
      }
    }
    
    private void handleReadException(ChannelPipeline paramChannelPipeline, ByteBuf paramByteBuf, Throwable paramThrowable, boolean paramBoolean, RecvByteBufAllocator.Handle paramHandle)
    {
      if (paramByteBuf != null) {
        if (paramByteBuf.isReadable())
        {
          AbstractNioByteChannel.this.readPending = false;
          paramChannelPipeline.fireChannelRead(paramByteBuf);
        }
        else
        {
          paramByteBuf.release();
        }
      }
      paramHandle.readComplete();
      paramChannelPipeline.fireChannelReadComplete();
      paramChannelPipeline.fireExceptionCaught(paramThrowable);
      if ((paramBoolean) || ((paramThrowable instanceof IOException))) {
        closeOnRead(paramChannelPipeline);
      }
    }
    
    /* Error */
    public final void read()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 13	io/netty/channel/nio/AbstractNioByteChannel$NioByteUnsafe:this$0	Lio/netty/channel/nio/AbstractNioByteChannel;
      //   4: invokeinterface 29 1 0
      //   9: astore_1
      //   10: aload_0
      //   11: getfield 13	io/netty/channel/nio/AbstractNioByteChannel$NioByteUnsafe:this$0	Lio/netty/channel/nio/AbstractNioByteChannel;
      //   14: aload_1
      //   15: invokevirtual 111	io/netty/channel/nio/AbstractNioByteChannel:shouldBreakReadReady	(Lio/netty/channel/ChannelConfig;)Z
      //   18: ifeq +11 -> 29
      //   21: aload_0
      //   22: getfield 13	io/netty/channel/nio/AbstractNioByteChannel$NioByteUnsafe:this$0	Lio/netty/channel/nio/AbstractNioByteChannel;
      //   25: invokevirtual 114	io/netty/channel/nio/AbstractNioChannel:clearReadPending	()V
      //   28: return
      //   29: aload_0
      //   30: getfield 13	io/netty/channel/nio/AbstractNioByteChannel$NioByteUnsafe:this$0	Lio/netty/channel/nio/AbstractNioByteChannel;
      //   33: invokevirtual 119	io/netty/channel/AbstractChannel:pipeline	()Lio/netty/channel/ChannelPipeline;
      //   36: astore_2
      //   37: aload_1
      //   38: invokeinterface 125 1 0
      //   43: astore_3
      //   44: aload_0
      //   45: invokevirtual 129	io/netty/channel/AbstractChannel$AbstractUnsafe:recvBufAllocHandle	()Lio/netty/channel/RecvByteBufAllocator$Handle;
      //   48: astore 4
      //   50: aload 4
      //   52: aload_1
      //   53: invokeinterface 133 2 0
      //   58: iconst_0
      //   59: istore 5
      //   61: aload 4
      //   63: aload_3
      //   64: invokeinterface 137 2 0
      //   69: astore 6
      //   71: aload 4
      //   73: aload_0
      //   74: getfield 13	io/netty/channel/nio/AbstractNioByteChannel$NioByteUnsafe:this$0	Lio/netty/channel/nio/AbstractNioByteChannel;
      //   77: aload 6
      //   79: invokevirtual 141	io/netty/channel/nio/AbstractNioByteChannel:doReadBytes	(Lio/netty/buffer/ByteBuf;)I
      //   82: invokeinterface 145 2 0
      //   87: aload 4
      //   89: invokeinterface 148 1 0
      //   94: istore 7
      //   96: iconst_1
      //   97: istore 8
      //   99: iload 7
      //   101: ifgt +61 -> 162
      //   104: aload 6
      //   106: invokeinterface 89 1 0
      //   111: pop
      //   112: aload 4
      //   114: invokeinterface 148 1 0
      //   119: istore 7
      //   121: iload 7
      //   123: ifge +10 -> 133
      //   126: iload 8
      //   128: istore 5
      //   130: goto +6 -> 136
      //   133: iconst_0
      //   134: istore 5
      //   136: iload 5
      //   138: ifeq +21 -> 159
      //   141: aload_0
      //   142: getfield 13	io/netty/channel/nio/AbstractNioByteChannel$NioByteUnsafe:this$0	Lio/netty/channel/nio/AbstractNioByteChannel;
      //   145: iconst_0
      //   146: putfield 81	io/netty/channel/nio/AbstractNioChannel:readPending	Z
      //   149: goto +10 -> 159
      //   152: astore_3
      //   153: aconst_null
      //   154: astore 6
      //   156: goto +112 -> 268
      //   159: goto +42 -> 201
      //   162: aload 4
      //   164: iconst_1
      //   165: invokeinterface 151 2 0
      //   170: aload_0
      //   171: getfield 13	io/netty/channel/nio/AbstractNioByteChannel$NioByteUnsafe:this$0	Lio/netty/channel/nio/AbstractNioByteChannel;
      //   174: iconst_0
      //   175: putfield 81	io/netty/channel/nio/AbstractNioChannel:readPending	Z
      //   178: aload_2
      //   179: aload 6
      //   181: invokeinterface 84 2 0
      //   186: pop
      //   187: aload 4
      //   189: invokeinterface 154 1 0
      //   194: istore 8
      //   196: iload 8
      //   198: ifne -140 -> 58
      //   201: aload 4
      //   203: invokeinterface 95 1 0
      //   208: aload_2
      //   209: invokeinterface 99 1 0
      //   214: pop
      //   215: iload 5
      //   217: ifeq +8 -> 225
      //   220: aload_0
      //   221: aload_2
      //   222: invokespecial 107	io/netty/channel/nio/AbstractNioByteChannel$NioByteUnsafe:closeOnRead	(Lio/netty/channel/ChannelPipeline;)V
      //   225: aload_0
      //   226: getfield 13	io/netty/channel/nio/AbstractNioByteChannel$NioByteUnsafe:this$0	Lio/netty/channel/nio/AbstractNioByteChannel;
      //   229: getfield 81	io/netty/channel/nio/AbstractNioChannel:readPending	Z
      //   232: ifne +71 -> 303
      //   235: aload_1
      //   236: invokeinterface 157 1 0
      //   241: ifne +62 -> 303
      //   244: goto +55 -> 299
      //   247: astore_3
      //   248: aconst_null
      //   249: astore 6
      //   251: goto +17 -> 268
      //   254: astore_3
      //   255: iconst_0
      //   256: istore 5
      //   258: goto +10 -> 268
      //   261: astore_3
      //   262: aconst_null
      //   263: astore 6
      //   265: iconst_0
      //   266: istore 5
      //   268: aload_0
      //   269: aload_2
      //   270: aload 6
      //   272: aload_3
      //   273: iload 5
      //   275: aload 4
      //   277: invokespecial 159	io/netty/channel/nio/AbstractNioByteChannel$NioByteUnsafe:handleReadException	(Lio/netty/channel/ChannelPipeline;Lio/netty/buffer/ByteBuf;Ljava/lang/Throwable;ZLio/netty/channel/RecvByteBufAllocator$Handle;)V
      //   280: aload_0
      //   281: getfield 13	io/netty/channel/nio/AbstractNioByteChannel$NioByteUnsafe:this$0	Lio/netty/channel/nio/AbstractNioByteChannel;
      //   284: getfield 81	io/netty/channel/nio/AbstractNioChannel:readPending	Z
      //   287: ifne +16 -> 303
      //   290: aload_1
      //   291: invokeinterface 157 1 0
      //   296: ifne +7 -> 303
      //   299: aload_0
      //   300: invokevirtual 162	io/netty/channel/nio/AbstractNioChannel$AbstractNioUnsafe:removeReadOp	()V
      //   303: return
      //   304: astore 6
      //   306: aload_0
      //   307: getfield 13	io/netty/channel/nio/AbstractNioByteChannel$NioByteUnsafe:this$0	Lio/netty/channel/nio/AbstractNioByteChannel;
      //   310: getfield 81	io/netty/channel/nio/AbstractNioChannel:readPending	Z
      //   313: ifne +16 -> 329
      //   316: aload_1
      //   317: invokeinterface 157 1 0
      //   322: ifne +7 -> 329
      //   325: aload_0
      //   326: invokevirtual 162	io/netty/channel/nio/AbstractNioChannel$AbstractNioUnsafe:removeReadOp	()V
      //   329: aload 6
      //   331: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	332	0	this	NioByteUnsafe
      //   9	308	1	localChannelConfig	ChannelConfig
      //   36	234	2	localChannelPipeline	ChannelPipeline
      //   43	21	3	localByteBufAllocator	io.netty.buffer.ByteBufAllocator
      //   152	1	3	localObject1	Object
      //   247	1	3	localObject2	Object
      //   254	1	3	localObject3	Object
      //   261	12	3	localThrowable	Throwable
      //   48	228	4	localHandle	RecvByteBufAllocator.Handle
      //   59	215	5	bool1	boolean
      //   69	202	6	localByteBuf	ByteBuf
      //   304	26	6	localObject4	Object
      //   94	28	7	i	int
      //   97	100	8	bool2	boolean
      // Exception table:
      //   from	to	target	type
      //   141	149	152	finally
      //   201	215	247	finally
      //   220	225	247	finally
      //   71	96	254	finally
      //   104	112	254	finally
      //   162	187	254	finally
      //   61	71	261	finally
      //   112	121	261	finally
      //   187	196	261	finally
      //   268	280	304	finally
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\nio\AbstractNioByteChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */