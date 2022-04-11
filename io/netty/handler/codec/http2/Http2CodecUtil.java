package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.DefaultChannelPromise;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.DefaultPromise;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Promise;
import java.util.concurrent.TimeUnit;

public final class Http2CodecUtil
{
  private static final ByteBuf CONNECTION_PREFACE = Unpooled.unreleasableBuffer(Unpooled.directBuffer(24).writeBytes("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n".getBytes(CharsetUtil.UTF_8))).asReadOnly();
  public static final int CONNECTION_STREAM_ID = 0;
  public static final int CONTINUATION_FRAME_HEADER_LENGTH = 10;
  public static final int DATA_FRAME_HEADER_LENGTH = 10;
  public static final long DEFAULT_GRACEFUL_SHUTDOWN_TIMEOUT_MILLIS = TimeUnit.MILLISECONDS.convert(30L, TimeUnit.SECONDS);
  public static final long DEFAULT_HEADER_LIST_SIZE = 8192L;
  public static final int DEFAULT_HEADER_TABLE_SIZE = 4096;
  public static final int DEFAULT_MAX_FRAME_SIZE = 16384;
  public static final int DEFAULT_MAX_QUEUED_CONTROL_FRAMES = 10000;
  static final int DEFAULT_MAX_RESERVED_STREAMS = 100;
  static final int DEFAULT_MIN_ALLOCATION_CHUNK = 1024;
  public static final short DEFAULT_PRIORITY_WEIGHT = 16;
  public static final int DEFAULT_WINDOW_SIZE = 65535;
  public static final int FRAME_HEADER_LENGTH = 9;
  public static final int GO_AWAY_FRAME_HEADER_LENGTH = 17;
  public static final int HEADERS_FRAME_HEADER_LENGTH = 15;
  public static final CharSequence HTTP_UPGRADE_PROTOCOL_NAME;
  public static final CharSequence HTTP_UPGRADE_SETTINGS_HEADER = AsciiString.cached("HTTP2-Settings");
  public static final int HTTP_UPGRADE_STREAM_ID = 1;
  public static final int INT_FIELD_LENGTH = 4;
  public static final long MAX_CONCURRENT_STREAMS = 4294967295L;
  public static final int MAX_FRAME_SIZE_LOWER_BOUND = 16384;
  public static final int MAX_FRAME_SIZE_UPPER_BOUND = 16777215;
  public static final long MAX_HEADER_LIST_SIZE = 4294967295L;
  public static final long MAX_HEADER_TABLE_SIZE = 4294967295L;
  public static final int MAX_INITIAL_WINDOW_SIZE = Integer.MAX_VALUE;
  public static final int MAX_PADDING = 256;
  private static final int MAX_PADDING_LENGTH_LENGTH = 1;
  public static final short MAX_UNSIGNED_BYTE = 255;
  public static final long MAX_UNSIGNED_INT = 4294967295L;
  public static final short MAX_WEIGHT = 256;
  public static final long MIN_CONCURRENT_STREAMS = 0L;
  public static final long MIN_HEADER_LIST_SIZE = 0L;
  public static final long MIN_HEADER_TABLE_SIZE = 0L;
  public static final int MIN_INITIAL_WINDOW_SIZE = 0;
  public static final short MIN_WEIGHT = 1;
  public static final int NUM_STANDARD_SETTINGS = 6;
  public static final int PING_FRAME_PAYLOAD_LENGTH = 8;
  public static final int PRIORITY_ENTRY_LENGTH = 5;
  public static final int PRIORITY_FRAME_LENGTH = 14;
  public static final int PUSH_PROMISE_FRAME_HEADER_LENGTH = 14;
  public static final int RST_STREAM_FRAME_LENGTH = 13;
  public static final char SETTINGS_ENABLE_PUSH = '\002';
  public static final char SETTINGS_HEADER_TABLE_SIZE = '\001';
  public static final char SETTINGS_INITIAL_WINDOW_SIZE = '\004';
  public static final char SETTINGS_MAX_CONCURRENT_STREAMS = '\003';
  public static final char SETTINGS_MAX_FRAME_SIZE = '\005';
  public static final char SETTINGS_MAX_HEADER_LIST_SIZE = '\006';
  public static final int SETTING_ENTRY_LENGTH = 6;
  public static final int SMALLEST_MAX_CONCURRENT_STREAMS = 100;
  public static final CharSequence TLS_UPGRADE_PROTOCOL_NAME;
  public static final int WINDOW_UPDATE_FRAME_LENGTH = 13;
  
  static
  {
    HTTP_UPGRADE_PROTOCOL_NAME = "h2c";
    TLS_UPGRADE_PROTOCOL_NAME = "h2";
  }
  
  public static long calculateMaxHeaderListSizeGoAway(long paramLong)
  {
    return paramLong + (paramLong >>> 2);
  }
  
  public static ByteBuf connectionPrefaceBuf()
  {
    return CONNECTION_PREFACE.retainedDuplicate();
  }
  
  public static Http2Exception getEmbeddedHttp2Exception(Throwable paramThrowable)
  {
    while (paramThrowable != null)
    {
      if ((paramThrowable instanceof Http2Exception)) {
        return (Http2Exception)paramThrowable;
      }
      paramThrowable = paramThrowable.getCause();
    }
    return null;
  }
  
  public static void headerListSizeExceeded(int paramInt, long paramLong, boolean paramBoolean)
    throws Http2Exception
  {
    throw Http2Exception.headerListSizeError(paramInt, Http2Error.PROTOCOL_ERROR, paramBoolean, "Header size exceeded max allowed size (%d)", new Object[] { Long.valueOf(paramLong) });
  }
  
  public static void headerListSizeExceeded(long paramLong)
    throws Http2Exception
  {
    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header size exceeded max allowed size (%d)", new Object[] { Long.valueOf(paramLong) });
  }
  
  public static boolean isMaxFrameSizeValid(int paramInt)
  {
    boolean bool;
    if ((paramInt >= 16384) && (paramInt <= 16777215)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public static boolean isOutboundStream(boolean paramBoolean, int paramInt)
  {
    boolean bool1 = false;
    boolean bool2;
    if ((paramInt & 0x1) == 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3 = bool1;
    if (paramInt > 0)
    {
      bool3 = bool1;
      if (paramBoolean == bool2) {
        bool3 = true;
      }
    }
    return bool3;
  }
  
  public static boolean isStreamIdValid(int paramInt)
  {
    boolean bool;
    if (paramInt >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  static boolean isStreamIdValid(int paramInt, boolean paramBoolean)
  {
    boolean bool1 = isStreamIdValid(paramInt);
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      if ((paramInt & 0x1) == 0) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool3 = bool2;
      if (paramBoolean == bool1) {
        bool3 = true;
      }
    }
    return bool3;
  }
  
  public static int readUnsignedInt(ByteBuf paramByteBuf)
  {
    return paramByteBuf.readInt() & 0x7FFFFFFF;
  }
  
  public static int streamableBytes(StreamByteDistributor.StreamState paramStreamState)
  {
    return Math.max(0, (int)Math.min(paramStreamState.pendingBytes(), paramStreamState.windowSize()));
  }
  
  public static ByteBuf toByteBuf(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
  {
    if ((paramThrowable != null) && (paramThrowable.getMessage() != null)) {
      return ByteBufUtil.writeUtf8(paramChannelHandlerContext.alloc(), paramThrowable.getMessage());
    }
    return Unpooled.EMPTY_BUFFER;
  }
  
  public static void verifyPadding(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt <= 256)) {
      return;
    }
    throw new IllegalArgumentException(String.format("Invalid padding '%d'. Padding must be between 0 and %d (inclusive).", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(256) }));
  }
  
  public static void writeFrameHeader(ByteBuf paramByteBuf, int paramInt1, byte paramByte, Http2Flags paramHttp2Flags, int paramInt2)
  {
    paramByteBuf.ensureWritable(paramInt1 + 9);
    writeFrameHeaderInternal(paramByteBuf, paramInt1, paramByte, paramHttp2Flags, paramInt2);
  }
  
  static void writeFrameHeaderInternal(ByteBuf paramByteBuf, int paramInt1, byte paramByte, Http2Flags paramHttp2Flags, int paramInt2)
  {
    paramByteBuf.writeMedium(paramInt1);
    paramByteBuf.writeByte(paramByte);
    paramByteBuf.writeByte(paramHttp2Flags.value());
    paramByteBuf.writeInt(paramInt2);
  }
  
  static final class SimpleChannelPromiseAggregator
    extends DefaultChannelPromise
  {
    private boolean doneAllocating;
    private int doneCount;
    private int expectedCount;
    private Throwable lastFailure;
    private final ChannelPromise promise;
    
    SimpleChannelPromiseAggregator(ChannelPromise paramChannelPromise, Channel paramChannel, EventExecutor paramEventExecutor)
    {
      super(paramEventExecutor);
      this.promise = paramChannelPromise;
    }
    
    private boolean allPromisesDone()
    {
      boolean bool;
      if ((this.doneCount == this.expectedCount) && (this.doneAllocating)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    private boolean allowFailure()
    {
      boolean bool;
      if ((!awaitingPromises()) && (this.expectedCount != 0)) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
    
    private boolean awaitingPromises()
    {
      boolean bool;
      if (this.doneCount < this.expectedCount) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    private ChannelPromise setPromise()
    {
      Throwable localThrowable = this.lastFailure;
      if (localThrowable == null)
      {
        this.promise.setSuccess();
        return super.setSuccess(null);
      }
      this.promise.setFailure(localThrowable);
      return super.setFailure(this.lastFailure);
    }
    
    private boolean tryPromise()
    {
      Throwable localThrowable = this.lastFailure;
      if (localThrowable == null)
      {
        this.promise.trySuccess();
        return super.trySuccess(null);
      }
      this.promise.tryFailure(localThrowable);
      return super.tryFailure(this.lastFailure);
    }
    
    public ChannelPromise doneAllocatingPromises()
    {
      if (!this.doneAllocating)
      {
        this.doneAllocating = true;
        int i = this.doneCount;
        int j = this.expectedCount;
        if ((i == j) || (j == 0)) {
          return setPromise();
        }
      }
      return this;
    }
    
    public ChannelPromise newPromise()
    {
      this.expectedCount += 1;
      return this;
    }
    
    public ChannelPromise setFailure(Throwable paramThrowable)
    {
      if (allowFailure())
      {
        this.doneCount += 1;
        this.lastFailure = paramThrowable;
        if (allPromisesDone()) {
          return setPromise();
        }
      }
      return this;
    }
    
    public ChannelPromise setSuccess(Void paramVoid)
    {
      if (awaitingPromises())
      {
        this.doneCount += 1;
        if (allPromisesDone()) {
          setPromise();
        }
      }
      return this;
    }
    
    public boolean tryFailure(Throwable paramThrowable)
    {
      if (allowFailure())
      {
        this.doneCount += 1;
        this.lastFailure = paramThrowable;
        if (allPromisesDone()) {
          return tryPromise();
        }
        return true;
      }
      return false;
    }
    
    public boolean trySuccess(Void paramVoid)
    {
      if (awaitingPromises())
      {
        this.doneCount += 1;
        if (allPromisesDone()) {
          return tryPromise();
        }
        return true;
      }
      return false;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\Http2CodecUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */