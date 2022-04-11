package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteOrder;
import java.util.List;

public class WebSocket08FrameDecoder
  extends ByteToMessageDecoder
  implements a
{
  private static final byte OPCODE_BINARY = 2;
  private static final byte OPCODE_CLOSE = 8;
  private static final byte OPCODE_CONT = 0;
  private static final byte OPCODE_PING = 9;
  private static final byte OPCODE_PONG = 10;
  private static final byte OPCODE_TEXT = 1;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(WebSocket08FrameDecoder.class);
  private final WebSocketDecoderConfig config;
  private int fragmentedFramesCount;
  private boolean frameFinalFlag;
  private boolean frameMasked;
  private int frameOpcode;
  private int framePayloadLen1;
  private long framePayloadLength;
  private int frameRsv;
  private byte[] maskingKey;
  private boolean receivedClosingHandshake;
  private State state = State.READING_FIRST;
  
  public WebSocket08FrameDecoder(WebSocketDecoderConfig paramWebSocketDecoderConfig)
  {
    this.config = ((WebSocketDecoderConfig)ObjectUtil.checkNotNull(paramWebSocketDecoderConfig, "decoderConfig"));
  }
  
  public WebSocket08FrameDecoder(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this(paramBoolean1, paramBoolean2, paramInt, false);
  }
  
  public WebSocket08FrameDecoder(boolean paramBoolean1, boolean paramBoolean2, int paramInt, boolean paramBoolean3)
  {
    this(WebSocketDecoderConfig.newBuilder().expectMaskedFrames(paramBoolean1).allowExtensions(paramBoolean2).maxFramePayloadLength(paramInt).allowMaskMismatch(paramBoolean3).build());
  }
  
  private void protocolViolation(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, CorruptedWebSocketFrameException paramCorruptedWebSocketFrameException)
  {
    this.state = State.CORRUPT;
    int i = paramByteBuf.readableBytes();
    if (i > 0) {
      paramByteBuf.skipBytes(i);
    }
    if ((paramChannelHandlerContext.channel().isActive()) && (this.config.closeOnProtocolViolation()))
    {
      if (!this.receivedClosingHandshake)
      {
        WebSocketCloseStatus localWebSocketCloseStatus = paramCorruptedWebSocketFrameException.closeStatus();
        String str = paramCorruptedWebSocketFrameException.getMessage();
        paramByteBuf = str;
        if (str == null) {
          paramByteBuf = localWebSocketCloseStatus.reasonText();
        }
        paramByteBuf = new CloseWebSocketFrame(localWebSocketCloseStatus, paramByteBuf);
      }
      else
      {
        paramByteBuf = Unpooled.EMPTY_BUFFER;
      }
      paramChannelHandlerContext.writeAndFlush(paramByteBuf).addListener(ChannelFutureListener.CLOSE);
    }
    throw paramCorruptedWebSocketFrameException;
  }
  
  private void protocolViolation(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, WebSocketCloseStatus paramWebSocketCloseStatus, String paramString)
  {
    protocolViolation(paramChannelHandlerContext, paramByteBuf, new CorruptedWebSocketFrameException(paramWebSocketCloseStatus, paramString));
  }
  
  private void protocolViolation(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, String paramString)
  {
    protocolViolation(paramChannelHandlerContext, paramByteBuf, WebSocketCloseStatus.PROTOCOL_ERROR, paramString);
  }
  
  private static int toFrameLength(long paramLong)
  {
    if (paramLong <= 2147483647L) {
      return (int)paramLong;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Length:");
    localStringBuilder.append(paramLong);
    throw new TooLongFrameException(localStringBuilder.toString());
  }
  
  private void unmask(ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.readerIndex();
    int j = paramByteBuf.writerIndex();
    ByteOrder localByteOrder = paramByteBuf.order();
    byte[] arrayOfByte = this.maskingKey;
    int k = arrayOfByte[0];
    int m = arrayOfByte[1];
    int n = arrayOfByte[2];
    k = arrayOfByte[3] & 0xFF | (k & 0xFF) << 24 | (m & 0xFF) << 16 | (n & 0xFF) << 8;
    m = i;
    n = k;
    if (localByteOrder == ByteOrder.LITTLE_ENDIAN) {
      n = Integer.reverseBytes(k);
    }
    for (m = i;; m += 4)
    {
      i = m;
      if (m + 3 >= j) {
        break;
      }
      paramByteBuf.setInt(m, paramByteBuf.getInt(m) ^ n);
    }
    while (i < j)
    {
      paramByteBuf.setByte(i, paramByteBuf.getByte(i) ^ this.maskingKey[(i % 4)]);
      i++;
    }
  }
  
  protected void checkCloseFrameBody(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf)
  {
    if ((paramByteBuf != null) && (paramByteBuf.isReadable()))
    {
      if (paramByteBuf.readableBytes() == 1) {
        protocolViolation(paramChannelHandlerContext, paramByteBuf, WebSocketCloseStatus.INVALID_PAYLOAD_DATA, "Invalid close frame body");
      }
      int i = paramByteBuf.readerIndex();
      paramByteBuf.readerIndex(0);
      int j = paramByteBuf.readShort();
      Object localObject;
      if (!WebSocketCloseStatus.isValidStatusCode(j))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Invalid close frame getStatus code: ");
        ((StringBuilder)localObject).append(j);
        protocolViolation(paramChannelHandlerContext, paramByteBuf, ((StringBuilder)localObject).toString());
      }
      if (paramByteBuf.isReadable()) {
        try
        {
          localObject = new io/netty/handler/codec/http/websocketx/Utf8Validator;
          ((Utf8Validator)localObject).<init>();
          ((Utf8Validator)localObject).check(paramByteBuf);
        }
        catch (CorruptedWebSocketFrameException localCorruptedWebSocketFrameException)
        {
          protocolViolation(paramChannelHandlerContext, paramByteBuf, localCorruptedWebSocketFrameException);
        }
      }
      paramByteBuf.readerIndex(i);
    }
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    if (this.receivedClosingHandshake)
    {
      paramByteBuf.skipBytes(actualReadableBytes());
      return;
    }
    int i;
    boolean bool;
    switch (1.$SwitchMap$io$netty$handler$codec$http$websocketx$WebSocket08FrameDecoder$State[this.state.ordinal()])
    {
    default: 
      throw new Error("Shouldn't reach here.");
    case 6: 
      if (paramByteBuf.isReadable()) {
        paramByteBuf.readByte();
      }
      return;
    case 1: 
      if (!paramByteBuf.isReadable()) {
        return;
      }
      this.framePayloadLength = 0L;
      i = paramByteBuf.readByte();
      if ((i & 0x80) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.frameFinalFlag = bool;
      this.frameRsv = ((i & 0x70) >> 4);
      this.frameOpcode = (i & 0xF);
      localObject = logger;
      if (((InternalLogger)localObject).isTraceEnabled()) {
        ((InternalLogger)localObject).trace("Decoding WebSocket Frame opCode={}", Integer.valueOf(this.frameOpcode));
      }
      this.state = State.READING_SECOND;
    case 2: 
      if (!paramByteBuf.isReadable()) {
        return;
      }
      i = paramByteBuf.readByte();
      if ((i & 0x80) != 0) {
        bool = true;
      } else {
        bool = false;
      }
      this.frameMasked = bool;
      this.framePayloadLen1 = (i & 0x7F);
      if ((this.frameRsv != 0) && (!this.config.allowExtensions()))
      {
        paramList = new StringBuilder();
        paramList.append("RSV != 0 and no extension negotiated, RSV:");
        paramList.append(this.frameRsv);
        protocolViolation(paramChannelHandlerContext, paramByteBuf, paramList.toString());
        return;
      }
      if ((!this.config.allowMaskMismatch()) && (this.config.expectMaskedFrames() != this.frameMasked))
      {
        protocolViolation(paramChannelHandlerContext, paramByteBuf, "received a frame that is not masked as expected");
        return;
      }
      i = this.frameOpcode;
      int j;
      if (i > 7)
      {
        if (!this.frameFinalFlag)
        {
          protocolViolation(paramChannelHandlerContext, paramByteBuf, "fragmented control frame");
          return;
        }
        j = this.framePayloadLen1;
        if (j > 125)
        {
          protocolViolation(paramChannelHandlerContext, paramByteBuf, "control frame with payload length > 125 octets");
          return;
        }
        if ((i != 8) && (i != 9) && (i != 10))
        {
          paramList = new StringBuilder();
          paramList.append("control frame using reserved opcode ");
          paramList.append(this.frameOpcode);
          protocolViolation(paramChannelHandlerContext, paramByteBuf, paramList.toString());
          return;
        }
        if ((i == 8) && (j == 1)) {
          protocolViolation(paramChannelHandlerContext, paramByteBuf, "received close control frame with payload len 1");
        }
      }
      else
      {
        if ((i != 0) && (i != 1) && (i != 2))
        {
          paramList = new StringBuilder();
          paramList.append("data frame using reserved opcode ");
          paramList.append(this.frameOpcode);
          protocolViolation(paramChannelHandlerContext, paramByteBuf, paramList.toString());
          return;
        }
        j = this.fragmentedFramesCount;
        if ((j == 0) && (i == 0))
        {
          protocolViolation(paramChannelHandlerContext, paramByteBuf, "received continuation data frame outside fragmented message");
          return;
        }
        if ((j != 0) && (i != 0) && (i != 9))
        {
          protocolViolation(paramChannelHandlerContext, paramByteBuf, "received non-continuation data frame while inside fragmented message");
          return;
        }
      }
      this.state = State.READING_SIZE;
    case 3: 
      i = this.framePayloadLen1;
      long l;
      if (i == 126)
      {
        if (paramByteBuf.readableBytes() < 2) {
          return;
        }
        l = paramByteBuf.readUnsignedShort();
        this.framePayloadLength = l;
        if (l < 126L) {
          protocolViolation(paramChannelHandlerContext, paramByteBuf, "invalid data frame length (not using minimal length encoding)");
        }
      }
      else if (i == 127)
      {
        if (paramByteBuf.readableBytes() < 8) {
          return;
        }
        l = paramByteBuf.readLong();
        this.framePayloadLength = l;
        if (l < 65536L) {
          protocolViolation(paramChannelHandlerContext, paramByteBuf, "invalid data frame length (not using minimal length encoding)");
        }
      }
      else
      {
        this.framePayloadLength = i;
      }
      if (this.framePayloadLength > this.config.maxFramePayloadLength())
      {
        paramList = WebSocketCloseStatus.MESSAGE_TOO_BIG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Max frame length of ");
        ((StringBuilder)localObject).append(this.config.maxFramePayloadLength());
        ((StringBuilder)localObject).append(" has been exceeded.");
        protocolViolation(paramChannelHandlerContext, paramByteBuf, paramList, ((StringBuilder)localObject).toString());
        return;
      }
      localObject = logger;
      if (((InternalLogger)localObject).isTraceEnabled()) {
        ((InternalLogger)localObject).trace("Decoding WebSocket Frame length={}", Long.valueOf(this.framePayloadLength));
      }
      this.state = State.MASKING_KEY;
    case 4: 
      if (this.frameMasked)
      {
        if (paramByteBuf.readableBytes() < 4) {
          return;
        }
        if (this.maskingKey == null) {
          this.maskingKey = new byte[4];
        }
        paramByteBuf.readBytes(this.maskingKey);
      }
      this.state = State.PAYLOAD;
    }
    if (paramByteBuf.readableBytes() < this.framePayloadLength) {
      return;
    }
    Object localObject = null;
    try
    {
      paramByteBuf = ByteBufUtil.readBytes(paramChannelHandlerContext.alloc(), paramByteBuf, toFrameLength(this.framePayloadLength));
      localObject = paramByteBuf;
      this.state = State.READING_FIRST;
      localObject = paramByteBuf;
      if (this.frameMasked)
      {
        localObject = paramByteBuf;
        unmask(paramByteBuf);
      }
      localObject = paramByteBuf;
      i = this.frameOpcode;
      if (i == 9)
      {
        localObject = paramByteBuf;
        paramChannelHandlerContext = new io/netty/handler/codec/http/websocketx/PingWebSocketFrame;
        localObject = paramByteBuf;
        paramChannelHandlerContext.<init>(this.frameFinalFlag, this.frameRsv, paramByteBuf);
        localObject = paramByteBuf;
        paramList.add(paramChannelHandlerContext);
        return;
      }
      if (i == 10)
      {
        localObject = paramByteBuf;
        paramChannelHandlerContext = new io/netty/handler/codec/http/websocketx/PongWebSocketFrame;
        localObject = paramByteBuf;
        paramChannelHandlerContext.<init>(this.frameFinalFlag, this.frameRsv, paramByteBuf);
        localObject = paramByteBuf;
        paramList.add(paramChannelHandlerContext);
        return;
      }
      if (i == 8)
      {
        localObject = paramByteBuf;
        this.receivedClosingHandshake = true;
        localObject = paramByteBuf;
        checkCloseFrameBody(paramChannelHandlerContext, paramByteBuf);
        localObject = paramByteBuf;
        paramChannelHandlerContext = new io/netty/handler/codec/http/websocketx/CloseWebSocketFrame;
        localObject = paramByteBuf;
        paramChannelHandlerContext.<init>(this.frameFinalFlag, this.frameRsv, paramByteBuf);
        localObject = paramByteBuf;
        paramList.add(paramChannelHandlerContext);
        return;
      }
      localObject = paramByteBuf;
      bool = this.frameFinalFlag;
      if (bool)
      {
        if (i != 9)
        {
          localObject = paramByteBuf;
          this.fragmentedFramesCount = 0;
        }
      }
      else
      {
        localObject = paramByteBuf;
        this.fragmentedFramesCount += 1;
      }
      if (i == 1)
      {
        localObject = paramByteBuf;
        paramChannelHandlerContext = new io/netty/handler/codec/http/websocketx/TextWebSocketFrame;
        localObject = paramByteBuf;
        paramChannelHandlerContext.<init>(bool, this.frameRsv, paramByteBuf);
        localObject = paramByteBuf;
        paramList.add(paramChannelHandlerContext);
        return;
      }
      if (i == 2)
      {
        localObject = paramByteBuf;
        paramChannelHandlerContext = new io/netty/handler/codec/http/websocketx/BinaryWebSocketFrame;
        localObject = paramByteBuf;
        paramChannelHandlerContext.<init>(bool, this.frameRsv, paramByteBuf);
        localObject = paramByteBuf;
        paramList.add(paramChannelHandlerContext);
        return;
      }
      if (i == 0)
      {
        localObject = paramByteBuf;
        paramChannelHandlerContext = new io/netty/handler/codec/http/websocketx/ContinuationWebSocketFrame;
        localObject = paramByteBuf;
        paramChannelHandlerContext.<init>(bool, this.frameRsv, paramByteBuf);
        localObject = paramByteBuf;
        paramList.add(paramChannelHandlerContext);
        return;
      }
      localObject = paramByteBuf;
      paramChannelHandlerContext = new java/lang/UnsupportedOperationException;
      localObject = paramByteBuf;
      paramList = new java/lang/StringBuilder;
      localObject = paramByteBuf;
      paramList.<init>();
      localObject = paramByteBuf;
      paramList.append("Cannot decode web socket frame with opcode: ");
      localObject = paramByteBuf;
      paramList.append(this.frameOpcode);
      localObject = paramByteBuf;
      paramChannelHandlerContext.<init>(paramList.toString());
      localObject = paramByteBuf;
      throw paramChannelHandlerContext;
    }
    finally
    {
      if (localObject != null) {
        ((ReferenceCounted)localObject).release();
      }
    }
  }
  
  static enum State
  {
    static
    {
      State localState1 = new State("READING_FIRST", 0);
      READING_FIRST = localState1;
      State localState2 = new State("READING_SECOND", 1);
      READING_SECOND = localState2;
      State localState3 = new State("READING_SIZE", 2);
      READING_SIZE = localState3;
      State localState4 = new State("MASKING_KEY", 3);
      MASKING_KEY = localState4;
      State localState5 = new State("PAYLOAD", 4);
      PAYLOAD = localState5;
      State localState6 = new State("CORRUPT", 5);
      CORRUPT = localState6;
      $VALUES = new State[] { localState1, localState2, localState3, localState4, localState5, localState6 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocket08FrameDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */