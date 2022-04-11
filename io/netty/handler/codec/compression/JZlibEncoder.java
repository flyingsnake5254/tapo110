package io.netty.handler.codec.compression;

import com.jcraft.jzlib.Deflater;
import com.jcraft.jzlib.JZlib;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ChannelPromiseNotifier;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.EventExecutorGroup;
import io.netty.util.internal.EmptyArrays;
import io.netty.util.internal.ObjectUtil;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class JZlibEncoder
  extends ZlibEncoder
{
  private volatile ChannelHandlerContext ctx;
  private volatile boolean finished;
  private final int wrapperOverhead;
  private final Deflater z;
  
  public JZlibEncoder()
  {
    this(6);
  }
  
  public JZlibEncoder(int paramInt)
  {
    this(ZlibWrapper.ZLIB, paramInt);
  }
  
  public JZlibEncoder(int paramInt1, int paramInt2, int paramInt3, byte[] paramArrayOfByte)
  {
    Deflater localDeflater = new Deflater();
    this.z = localDeflater;
    if ((paramInt1 >= 0) && (paramInt1 <= 9))
    {
      if ((paramInt2 >= 9) && (paramInt2 <= 15))
      {
        if ((paramInt3 >= 1) && (paramInt3 <= 9))
        {
          ObjectUtil.checkNotNull(paramArrayOfByte, "dictionary");
          paramInt1 = localDeflater.deflateInit(paramInt1, paramInt2, paramInt3, JZlib.W_ZLIB);
          if (paramInt1 != 0)
          {
            ZlibUtil.fail(localDeflater, "initialization failure", paramInt1);
          }
          else
          {
            paramInt1 = localDeflater.deflateSetDictionary(paramArrayOfByte, paramArrayOfByte.length);
            if (paramInt1 != 0) {
              ZlibUtil.fail(localDeflater, "failed to set the dictionary", paramInt1);
            }
          }
          this.wrapperOverhead = ZlibUtil.wrapperOverhead(ZlibWrapper.ZLIB);
          return;
        }
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("memLevel: ");
        paramArrayOfByte.append(paramInt3);
        paramArrayOfByte.append(" (expected: 1-9)");
        throw new IllegalArgumentException(paramArrayOfByte.toString());
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("windowBits: ");
      paramArrayOfByte.append(paramInt2);
      paramArrayOfByte.append(" (expected: 9-15)");
      throw new IllegalArgumentException(paramArrayOfByte.toString());
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("compressionLevel: ");
    paramArrayOfByte.append(paramInt1);
    paramArrayOfByte.append(" (expected: 0-9)");
    throw new IllegalArgumentException(paramArrayOfByte.toString());
  }
  
  public JZlibEncoder(int paramInt, byte[] paramArrayOfByte)
  {
    this(paramInt, 15, 8, paramArrayOfByte);
  }
  
  public JZlibEncoder(ZlibWrapper paramZlibWrapper)
  {
    this(paramZlibWrapper, 6);
  }
  
  public JZlibEncoder(ZlibWrapper paramZlibWrapper, int paramInt)
  {
    this(paramZlibWrapper, paramInt, 15, 8);
  }
  
  public JZlibEncoder(ZlibWrapper paramZlibWrapper, int paramInt1, int paramInt2, int paramInt3)
  {
    Deflater localDeflater = new Deflater();
    this.z = localDeflater;
    if ((paramInt1 >= 0) && (paramInt1 <= 9))
    {
      if ((paramInt2 >= 9) && (paramInt2 <= 15))
      {
        if ((paramInt3 >= 1) && (paramInt3 <= 9))
        {
          ObjectUtil.checkNotNull(paramZlibWrapper, "wrapper");
          ZlibWrapper localZlibWrapper = ZlibWrapper.ZLIB_OR_NONE;
          if (paramZlibWrapper != localZlibWrapper)
          {
            paramInt1 = localDeflater.init(paramInt1, paramInt2, paramInt3, ZlibUtil.convertWrapperType(paramZlibWrapper));
            if (paramInt1 != 0) {
              ZlibUtil.fail(localDeflater, "initialization failure", paramInt1);
            }
            this.wrapperOverhead = ZlibUtil.wrapperOverhead(paramZlibWrapper);
            return;
          }
          paramZlibWrapper = new StringBuilder();
          paramZlibWrapper.append("wrapper '");
          paramZlibWrapper.append(localZlibWrapper);
          paramZlibWrapper.append("' is not allowed for compression.");
          throw new IllegalArgumentException(paramZlibWrapper.toString());
        }
        paramZlibWrapper = new StringBuilder();
        paramZlibWrapper.append("memLevel: ");
        paramZlibWrapper.append(paramInt3);
        paramZlibWrapper.append(" (expected: 1-9)");
        throw new IllegalArgumentException(paramZlibWrapper.toString());
      }
      paramZlibWrapper = new StringBuilder();
      paramZlibWrapper.append("windowBits: ");
      paramZlibWrapper.append(paramInt2);
      paramZlibWrapper.append(" (expected: 9-15)");
      throw new IllegalArgumentException(paramZlibWrapper.toString());
    }
    paramZlibWrapper = new StringBuilder();
    paramZlibWrapper.append("compressionLevel: ");
    paramZlibWrapper.append(paramInt1);
    paramZlibWrapper.append(" (expected: 0-9)");
    throw new IllegalArgumentException(paramZlibWrapper.toString());
  }
  
  public JZlibEncoder(byte[] paramArrayOfByte)
  {
    this(6, paramArrayOfByte);
  }
  
  private ChannelHandlerContext ctx()
  {
    ChannelHandlerContext localChannelHandlerContext = this.ctx;
    if (localChannelHandlerContext != null) {
      return localChannelHandlerContext;
    }
    throw new IllegalStateException("not added to a pipeline");
  }
  
  private ChannelFuture finishEncode(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
  {
    if (this.finished)
    {
      paramChannelPromise.setSuccess();
      return paramChannelPromise;
    }
    this.finished = true;
    try
    {
      this.z.next_in = EmptyArrays.EMPTY_BYTES;
      this.z.next_in_index = 0;
      this.z.avail_in = 0;
      Object localObject = new byte[32];
      this.z.next_out = ((byte[])localObject);
      this.z.next_out_index = 0;
      this.z.avail_out = 32;
      int i = this.z.deflate(4);
      if ((i != 0) && (i != 1))
      {
        paramChannelPromise.setFailure(ZlibUtil.deflaterException(this.z, "compression failure", i));
        return paramChannelPromise;
      }
      if (this.z.next_out_index != 0) {
        localObject = Unpooled.wrappedBuffer((byte[])localObject, 0, this.z.next_out_index);
      } else {
        localObject = Unpooled.EMPTY_BUFFER;
      }
      return paramChannelHandlerContext.writeAndFlush(localObject, paramChannelPromise);
    }
    finally
    {
      this.z.deflateEnd();
      this.z.next_in = null;
      this.z.next_out = null;
    }
  }
  
  public ChannelFuture close()
  {
    return close(ctx().channel().newPromise());
  }
  
  public ChannelFuture close(final ChannelPromise paramChannelPromise)
  {
    final Object localObject = ctx();
    EventExecutor localEventExecutor = ((ChannelHandlerContext)localObject).executor();
    if (localEventExecutor.inEventLoop()) {
      return finishEncode((ChannelHandlerContext)localObject, paramChannelPromise);
    }
    localObject = ((ChannelOutboundInvoker)localObject).newPromise();
    localEventExecutor.execute(new Runnable()
    {
      public void run()
      {
        JZlibEncoder localJZlibEncoder = JZlibEncoder.this;
        localJZlibEncoder.finishEncode(JZlibEncoder.access$000(localJZlibEncoder), localObject).addListener(new ChannelPromiseNotifier(new ChannelPromise[] { paramChannelPromise }));
      }
    });
    return (ChannelFuture)localObject;
  }
  
  public void close(final ChannelHandlerContext paramChannelHandlerContext, final ChannelPromise paramChannelPromise)
  {
    ChannelFuture localChannelFuture = finishEncode(paramChannelHandlerContext, paramChannelHandlerContext.newPromise());
    localChannelFuture.addListener(new ChannelFutureListener()
    {
      public void operationComplete(ChannelFuture paramAnonymousChannelFuture)
        throws Exception
      {
        paramChannelHandlerContext.close(paramChannelPromise);
      }
    });
    if (!localChannelFuture.isDone()) {
      paramChannelHandlerContext.executor().schedule(new Runnable()
      {
        public void run()
        {
          paramChannelHandlerContext.close(paramChannelPromise);
        }
      }, 10L, TimeUnit.SECONDS);
    }
  }
  
  /* Error */
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, io.netty.buffer.ByteBuf paramByteBuf1, io.netty.buffer.ByteBuf paramByteBuf2)
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 158	io/netty/handler/codec/compression/JZlibEncoder:finished	Z
    //   4: ifeq +10 -> 14
    //   7: aload_3
    //   8: aload_2
    //   9: invokevirtual 295	io/netty/buffer/ByteBuf:writeBytes	(Lio/netty/buffer/ByteBuf;)Lio/netty/buffer/ByteBuf;
    //   12: pop
    //   13: return
    //   14: aload_2
    //   15: invokevirtual 298	io/netty/buffer/ByteBuf:readableBytes	()I
    //   18: istore 4
    //   20: iload 4
    //   22: ifne +4 -> 26
    //   25: return
    //   26: aload_2
    //   27: invokevirtual 301	io/netty/buffer/ByteBuf:hasArray	()Z
    //   30: istore 5
    //   32: aload_0
    //   33: getfield 41	io/netty/handler/codec/compression/JZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   36: iload 4
    //   38: putfield 179	com/jcraft/jzlib/Deflater:avail_in	I
    //   41: iload 5
    //   43: ifeq +33 -> 76
    //   46: aload_0
    //   47: getfield 41	io/netty/handler/codec/compression/JZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   50: aload_2
    //   51: invokevirtual 305	io/netty/buffer/ByteBuf:array	()[B
    //   54: putfield 173	com/jcraft/jzlib/Deflater:next_in	[B
    //   57: aload_0
    //   58: getfield 41	io/netty/handler/codec/compression/JZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   61: aload_2
    //   62: invokevirtual 308	io/netty/buffer/ByteBuf:arrayOffset	()I
    //   65: aload_2
    //   66: invokevirtual 311	io/netty/buffer/ByteBuf:readerIndex	()I
    //   69: iadd
    //   70: putfield 176	com/jcraft/jzlib/Deflater:next_in_index	I
    //   73: goto +34 -> 107
    //   76: iload 4
    //   78: newarray <illegal type>
    //   80: astore_1
    //   81: aload_2
    //   82: aload_2
    //   83: invokevirtual 311	io/netty/buffer/ByteBuf:readerIndex	()I
    //   86: aload_1
    //   87: invokevirtual 315	io/netty/buffer/ByteBuf:getBytes	(I[B)Lio/netty/buffer/ByteBuf;
    //   90: pop
    //   91: aload_0
    //   92: getfield 41	io/netty/handler/codec/compression/JZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   95: aload_1
    //   96: putfield 173	com/jcraft/jzlib/Deflater:next_in	[B
    //   99: aload_0
    //   100: getfield 41	io/netty/handler/codec/compression/JZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   103: iconst_0
    //   104: putfield 176	com/jcraft/jzlib/Deflater:next_in_index	I
    //   107: aload_0
    //   108: getfield 41	io/netty/handler/codec/compression/JZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   111: getfield 176	com/jcraft/jzlib/Deflater:next_in_index	I
    //   114: istore 6
    //   116: iload 4
    //   118: i2d
    //   119: ldc2_w 316
    //   122: dmul
    //   123: invokestatic 323	java/lang/Math:ceil	(D)D
    //   126: d2i
    //   127: bipush 12
    //   129: iadd
    //   130: aload_0
    //   131: getfield 78	io/netty/handler/codec/compression/JZlibEncoder:wrapperOverhead	I
    //   134: iadd
    //   135: istore 4
    //   137: aload_3
    //   138: iload 4
    //   140: invokevirtual 327	io/netty/buffer/ByteBuf:ensureWritable	(I)Lio/netty/buffer/ByteBuf;
    //   143: pop
    //   144: aload_0
    //   145: getfield 41	io/netty/handler/codec/compression/JZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   148: iload 4
    //   150: putfield 188	com/jcraft/jzlib/Deflater:avail_out	I
    //   153: aload_0
    //   154: getfield 41	io/netty/handler/codec/compression/JZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   157: aload_3
    //   158: invokevirtual 305	io/netty/buffer/ByteBuf:array	()[B
    //   161: putfield 182	com/jcraft/jzlib/Deflater:next_out	[B
    //   164: aload_0
    //   165: getfield 41	io/netty/handler/codec/compression/JZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   168: aload_3
    //   169: invokevirtual 308	io/netty/buffer/ByteBuf:arrayOffset	()I
    //   172: aload_3
    //   173: invokevirtual 330	io/netty/buffer/ByteBuf:writerIndex	()I
    //   176: iadd
    //   177: putfield 185	com/jcraft/jzlib/Deflater:next_out_index	I
    //   180: aload_0
    //   181: getfield 41	io/netty/handler/codec/compression/JZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   184: getfield 185	com/jcraft/jzlib/Deflater:next_out_index	I
    //   187: istore 4
    //   189: aload_0
    //   190: getfield 41	io/netty/handler/codec/compression/JZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   193: iconst_2
    //   194: invokevirtual 192	com/jcraft/jzlib/Deflater:deflate	(I)I
    //   197: istore 7
    //   199: aload_2
    //   200: aload_0
    //   201: getfield 41	io/netty/handler/codec/compression/JZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   204: getfield 176	com/jcraft/jzlib/Deflater:next_in_index	I
    //   207: iload 6
    //   209: isub
    //   210: invokevirtual 333	io/netty/buffer/ByteBuf:skipBytes	(I)Lio/netty/buffer/ByteBuf;
    //   213: pop
    //   214: iload 7
    //   216: ifeq +14 -> 230
    //   219: aload_0
    //   220: getfield 41	io/netty/handler/codec/compression/JZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   223: ldc -62
    //   225: iload 7
    //   227: invokestatic 67	io/netty/handler/codec/compression/ZlibUtil:fail	(Lcom/jcraft/jzlib/Deflater;Ljava/lang/String;I)V
    //   230: aload_0
    //   231: getfield 41	io/netty/handler/codec/compression/JZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   234: getfield 185	com/jcraft/jzlib/Deflater:next_out_index	I
    //   237: iload 4
    //   239: isub
    //   240: istore 6
    //   242: iload 6
    //   244: ifle +15 -> 259
    //   247: aload_3
    //   248: aload_3
    //   249: invokevirtual 330	io/netty/buffer/ByteBuf:writerIndex	()I
    //   252: iload 6
    //   254: iadd
    //   255: invokevirtual 335	io/netty/buffer/ByteBuf:writerIndex	(I)Lio/netty/buffer/ByteBuf;
    //   258: pop
    //   259: aload_0
    //   260: getfield 41	io/netty/handler/codec/compression/JZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   263: aconst_null
    //   264: putfield 173	com/jcraft/jzlib/Deflater:next_in	[B
    //   267: aload_0
    //   268: getfield 41	io/netty/handler/codec/compression/JZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   271: aconst_null
    //   272: putfield 182	com/jcraft/jzlib/Deflater:next_out	[B
    //   275: return
    //   276: astore_1
    //   277: aload_2
    //   278: aload_0
    //   279: getfield 41	io/netty/handler/codec/compression/JZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   282: getfield 176	com/jcraft/jzlib/Deflater:next_in_index	I
    //   285: iload 6
    //   287: isub
    //   288: invokevirtual 333	io/netty/buffer/ByteBuf:skipBytes	(I)Lio/netty/buffer/ByteBuf;
    //   291: pop
    //   292: aload_1
    //   293: athrow
    //   294: astore_1
    //   295: aload_0
    //   296: getfield 41	io/netty/handler/codec/compression/JZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   299: aconst_null
    //   300: putfield 173	com/jcraft/jzlib/Deflater:next_in	[B
    //   303: aload_0
    //   304: getfield 41	io/netty/handler/codec/compression/JZlibEncoder:z	Lcom/jcraft/jzlib/Deflater;
    //   307: aconst_null
    //   308: putfield 182	com/jcraft/jzlib/Deflater:next_out	[B
    //   311: aload_1
    //   312: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	313	0	this	JZlibEncoder
    //   0	313	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	313	2	paramByteBuf1	io.netty.buffer.ByteBuf
    //   0	313	3	paramByteBuf2	io.netty.buffer.ByteBuf
    //   18	222	4	i	int
    //   30	12	5	bool	boolean
    //   114	174	6	j	int
    //   197	29	7	k	int
    // Exception table:
    //   from	to	target	type
    //   189	199	276	finally
    //   26	41	294	finally
    //   46	73	294	finally
    //   76	107	294	finally
    //   107	189	294	finally
    //   199	214	294	finally
    //   219	230	294	finally
    //   230	242	294	finally
    //   247	259	294	finally
    //   277	294	294	finally
  }
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.ctx = paramChannelHandlerContext;
  }
  
  public boolean isClosed()
  {
    return this.finished;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\JZlibEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */