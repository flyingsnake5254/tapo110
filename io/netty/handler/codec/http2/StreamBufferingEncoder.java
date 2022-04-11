package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class StreamBufferingEncoder
  extends DecoratingHttp2ConnectionEncoder
{
  private boolean closed;
  private int maxConcurrentStreams;
  private final TreeMap<Integer, PendingStream> pendingStreams = new TreeMap();
  
  public StreamBufferingEncoder(Http2ConnectionEncoder paramHttp2ConnectionEncoder)
  {
    this(paramHttp2ConnectionEncoder, 100);
  }
  
  public StreamBufferingEncoder(Http2ConnectionEncoder paramHttp2ConnectionEncoder, int paramInt)
  {
    super(paramHttp2ConnectionEncoder);
    this.maxConcurrentStreams = paramInt;
    connection().addListener(new Http2ConnectionAdapter()
    {
      public void onGoAwayReceived(int paramAnonymousInt, long paramAnonymousLong, ByteBuf paramAnonymousByteBuf)
      {
        StreamBufferingEncoder.this.cancelGoAwayStreams(paramAnonymousInt, paramAnonymousLong, paramAnonymousByteBuf);
      }
      
      public void onStreamClosed(Http2Stream paramAnonymousHttp2Stream)
      {
        StreamBufferingEncoder.this.tryCreatePendingStreams();
      }
    });
  }
  
  private boolean canCreateStream()
  {
    boolean bool;
    if (connection().local().numActiveStreams() < this.maxConcurrentStreams) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private void cancelGoAwayStreams(int paramInt, long paramLong, ByteBuf paramByteBuf)
  {
    Iterator localIterator = this.pendingStreams.values().iterator();
    paramByteBuf = new Http2GoAwayException(paramInt, paramLong, ByteBufUtil.getBytes(paramByteBuf));
    while (localIterator.hasNext())
    {
      PendingStream localPendingStream = (PendingStream)localIterator.next();
      if (localPendingStream.streamId > paramInt)
      {
        localIterator.remove();
        localPendingStream.close(paramByteBuf);
      }
    }
  }
  
  private boolean isExistingStream(int paramInt)
  {
    boolean bool;
    if (paramInt <= connection().local().lastStreamCreated()) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  /* Error */
  private void tryCreatePendingStreams()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 46	io/netty/handler/codec/http2/StreamBufferingEncoder:pendingStreams	Ljava/util/TreeMap;
    //   4: invokevirtual 129	java/util/TreeMap:isEmpty	()Z
    //   7: ifne +42 -> 49
    //   10: aload_0
    //   11: invokespecial 131	io/netty/handler/codec/http2/StreamBufferingEncoder:canCreateStream	()Z
    //   14: ifeq +35 -> 49
    //   17: aload_0
    //   18: getfield 46	io/netty/handler/codec/http2/StreamBufferingEncoder:pendingStreams	Ljava/util/TreeMap;
    //   21: invokevirtual 135	java/util/TreeMap:pollFirstEntry	()Ljava/util/Map$Entry;
    //   24: invokeinterface 140 1 0
    //   29: checkcast 23	io/netty/handler/codec/http2/StreamBufferingEncoder$PendingStream
    //   32: astore_1
    //   33: aload_1
    //   34: invokevirtual 143	io/netty/handler/codec/http2/StreamBufferingEncoder$PendingStream:sendFrames	()V
    //   37: goto -37 -> 0
    //   40: astore_2
    //   41: aload_1
    //   42: aload_2
    //   43: invokevirtual 121	io/netty/handler/codec/http2/StreamBufferingEncoder$PendingStream:close	(Ljava/lang/Throwable;)V
    //   46: goto -46 -> 0
    //   49: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	50	0	this	StreamBufferingEncoder
    //   32	10	1	localPendingStream	PendingStream
    //   40	3	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   33	37	40	finally
  }
  
  public void close()
  {
    try
    {
      if (!this.closed)
      {
        this.closed = true;
        Http2ChannelClosedException localHttp2ChannelClosedException = new io/netty/handler/codec/http2/StreamBufferingEncoder$Http2ChannelClosedException;
        localHttp2ChannelClosedException.<init>();
        while (!this.pendingStreams.isEmpty()) {
          ((PendingStream)this.pendingStreams.pollFirstEntry().getValue()).close(localHttp2ChannelClosedException);
        }
      }
      return;
    }
    finally
    {
      super.close();
    }
  }
  
  public int numBufferedStreams()
  {
    return this.pendingStreams.size();
  }
  
  public void remoteSettings(Http2Settings paramHttp2Settings)
    throws Http2Exception
  {
    super.remoteSettings(paramHttp2Settings);
    this.maxConcurrentStreams = connection().local().maxActiveStreams();
    tryCreatePendingStreams();
  }
  
  public ChannelFuture writeData(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, ByteBuf paramByteBuf, int paramInt2, boolean paramBoolean, ChannelPromise paramChannelPromise)
  {
    if (isExistingStream(paramInt1)) {
      return super.writeData(paramChannelHandlerContext, paramInt1, paramByteBuf, paramInt2, paramBoolean, paramChannelPromise);
    }
    paramChannelHandlerContext = (PendingStream)this.pendingStreams.get(Integer.valueOf(paramInt1));
    if (paramChannelHandlerContext != null)
    {
      paramChannelHandlerContext.frames.add(new DataFrame(paramByteBuf, paramInt2, paramBoolean, paramChannelPromise));
    }
    else
    {
      ReferenceCountUtil.safeRelease(paramByteBuf);
      paramChannelPromise.setFailure(Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream does not exist %d", new Object[] { Integer.valueOf(paramInt1) }));
    }
    return paramChannelPromise;
  }
  
  public ChannelFuture writeHeaders(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, short paramShort, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, ChannelPromise paramChannelPromise)
  {
    if (this.closed) {
      return paramChannelPromise.setFailure(new Http2ChannelClosedException());
    }
    if ((!isExistingStream(paramInt1)) && (!connection().goAwayReceived()))
    {
      if (canCreateStream()) {
        return super.writeHeaders(paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramInt2, paramShort, paramBoolean1, paramInt3, paramBoolean2, paramChannelPromise);
      }
      PendingStream localPendingStream1 = (PendingStream)this.pendingStreams.get(Integer.valueOf(paramInt1));
      PendingStream localPendingStream2 = localPendingStream1;
      if (localPendingStream1 == null)
      {
        localPendingStream2 = new PendingStream(paramChannelHandlerContext, paramInt1);
        this.pendingStreams.put(Integer.valueOf(paramInt1), localPendingStream2);
      }
      localPendingStream2.frames.add(new HeadersFrame(paramHttp2Headers, paramInt2, paramShort, paramBoolean1, paramInt3, paramBoolean2, paramChannelPromise));
      return paramChannelPromise;
    }
    return super.writeHeaders(paramChannelHandlerContext, paramInt1, paramHttp2Headers, paramInt2, paramShort, paramBoolean1, paramInt3, paramBoolean2, paramChannelPromise);
  }
  
  public ChannelFuture writeHeaders(ChannelHandlerContext paramChannelHandlerContext, int paramInt1, Http2Headers paramHttp2Headers, int paramInt2, boolean paramBoolean, ChannelPromise paramChannelPromise)
  {
    return writeHeaders(paramChannelHandlerContext, paramInt1, paramHttp2Headers, 0, (short)16, false, paramInt2, paramBoolean, paramChannelPromise);
  }
  
  public ChannelFuture writeRstStream(ChannelHandlerContext paramChannelHandlerContext, int paramInt, long paramLong, ChannelPromise paramChannelPromise)
  {
    if (isExistingStream(paramInt)) {
      return super.writeRstStream(paramChannelHandlerContext, paramInt, paramLong, paramChannelPromise);
    }
    paramChannelHandlerContext = (PendingStream)this.pendingStreams.remove(Integer.valueOf(paramInt));
    if (paramChannelHandlerContext != null)
    {
      paramChannelHandlerContext.close(null);
      paramChannelPromise.setSuccess();
    }
    else
    {
      paramChannelPromise.setFailure(Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Stream does not exist %d", new Object[] { Integer.valueOf(paramInt) }));
    }
    return paramChannelPromise;
  }
  
  private final class DataFrame
    extends StreamBufferingEncoder.Frame
  {
    final ByteBuf data;
    final boolean endOfStream;
    final int padding;
    
    DataFrame(ByteBuf paramByteBuf, int paramInt, boolean paramBoolean, ChannelPromise paramChannelPromise)
    {
      super();
      this.data = paramByteBuf;
      this.padding = paramInt;
      this.endOfStream = paramBoolean;
    }
    
    void release(Throwable paramThrowable)
    {
      super.release(paramThrowable);
      ReferenceCountUtil.safeRelease(this.data);
    }
    
    void send(ChannelHandlerContext paramChannelHandlerContext, int paramInt)
    {
      StreamBufferingEncoder.this.writeData(paramChannelHandlerContext, paramInt, this.data, this.padding, this.endOfStream, this.promise);
    }
  }
  
  private static abstract class Frame
  {
    final ChannelPromise promise;
    
    Frame(ChannelPromise paramChannelPromise)
    {
      this.promise = paramChannelPromise;
    }
    
    void release(Throwable paramThrowable)
    {
      if (paramThrowable == null) {
        this.promise.setSuccess();
      } else {
        this.promise.setFailure(paramThrowable);
      }
    }
    
    abstract void send(ChannelHandlerContext paramChannelHandlerContext, int paramInt);
  }
  
  private final class HeadersFrame
    extends StreamBufferingEncoder.Frame
  {
    final boolean endOfStream;
    final boolean exclusive;
    final Http2Headers headers;
    final int padding;
    final int streamDependency;
    final short weight;
    
    HeadersFrame(Http2Headers paramHttp2Headers, int paramInt1, short paramShort, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, ChannelPromise paramChannelPromise)
    {
      super();
      this.headers = paramHttp2Headers;
      this.streamDependency = paramInt1;
      this.weight = ((short)paramShort);
      this.exclusive = paramBoolean1;
      this.padding = paramInt2;
      this.endOfStream = paramBoolean2;
    }
    
    void send(ChannelHandlerContext paramChannelHandlerContext, int paramInt)
    {
      StreamBufferingEncoder.this.writeHeaders(paramChannelHandlerContext, paramInt, this.headers, this.streamDependency, this.weight, this.exclusive, this.padding, this.endOfStream, this.promise);
    }
  }
  
  public static final class Http2ChannelClosedException
    extends Http2Exception
  {
    private static final long serialVersionUID = 4768543442094476971L;
    
    public Http2ChannelClosedException()
    {
      super("Connection closed");
    }
  }
  
  public static final class Http2GoAwayException
    extends Http2Exception
  {
    private static final long serialVersionUID = 1326785622777291198L;
    private final byte[] debugData;
    private final long errorCode;
    private final int lastStreamId;
    
    public Http2GoAwayException(int paramInt, long paramLong, byte[] paramArrayOfByte)
    {
      super();
      this.lastStreamId = paramInt;
      this.errorCode = paramLong;
      this.debugData = paramArrayOfByte;
    }
    
    public byte[] debugData()
    {
      return this.debugData;
    }
    
    public long errorCode()
    {
      return this.errorCode;
    }
    
    public int lastStreamId()
    {
      return this.lastStreamId;
    }
  }
  
  private static final class PendingStream
  {
    final ChannelHandlerContext ctx;
    final Queue<StreamBufferingEncoder.Frame> frames = new ArrayDeque(2);
    final int streamId;
    
    PendingStream(ChannelHandlerContext paramChannelHandlerContext, int paramInt)
    {
      this.ctx = paramChannelHandlerContext;
      this.streamId = paramInt;
    }
    
    void close(Throwable paramThrowable)
    {
      Iterator localIterator = this.frames.iterator();
      while (localIterator.hasNext()) {
        ((StreamBufferingEncoder.Frame)localIterator.next()).release(paramThrowable);
      }
    }
    
    void sendFrames()
    {
      Iterator localIterator = this.frames.iterator();
      while (localIterator.hasNext()) {
        ((StreamBufferingEncoder.Frame)localIterator.next()).send(this.ctx, this.streamId);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\StreamBufferingEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */