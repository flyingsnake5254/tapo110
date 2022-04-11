package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import io.netty.handler.codec.TooLongFrameException;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

public class WebSocket08FrameEncoder
  extends MessageToMessageEncoder<WebSocketFrame>
  implements b
{
  private static final int GATHERING_WRITE_THRESHOLD = 1024;
  private static final byte OPCODE_BINARY = 2;
  private static final byte OPCODE_CLOSE = 8;
  private static final byte OPCODE_CONT = 0;
  private static final byte OPCODE_PING = 9;
  private static final byte OPCODE_PONG = 10;
  private static final byte OPCODE_TEXT = 1;
  private static final InternalLogger logger = InternalLoggerFactory.getInstance(WebSocket08FrameEncoder.class);
  private final boolean maskPayload;
  
  public WebSocket08FrameEncoder(boolean paramBoolean)
  {
    this.maskPayload = paramBoolean;
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, WebSocketFrame paramWebSocketFrame, List<Object> paramList)
    throws Exception
  {
    ByteBuf localByteBuf = paramWebSocketFrame.content();
    boolean bool = paramWebSocketFrame instanceof TextWebSocketFrame;
    int i = 0;
    int j;
    int k;
    if (bool)
    {
      j = 1;
      k = j;
    }
    else if ((paramWebSocketFrame instanceof PingWebSocketFrame))
    {
      j = 9;
      k = j;
    }
    else if ((paramWebSocketFrame instanceof PongWebSocketFrame))
    {
      j = 10;
      k = j;
    }
    else if ((paramWebSocketFrame instanceof CloseWebSocketFrame))
    {
      j = 8;
      k = j;
    }
    else if ((paramWebSocketFrame instanceof BinaryWebSocketFrame))
    {
      j = 2;
      k = j;
    }
    else
    {
      if (!(paramWebSocketFrame instanceof ContinuationWebSocketFrame)) {
        break label926;
      }
      j = 0;
      k = j;
    }
    int m = localByteBuf.readableBytes();
    Object localObject = logger;
    if (((InternalLogger)localObject).isTraceEnabled()) {
      ((InternalLogger)localObject).trace("Encoding WebSocket Frame opCode={} length={}", Byte.valueOf(k), Integer.valueOf(m));
    }
    if (paramWebSocketFrame.isFinalFragment()) {
      j = 128;
    } else {
      j = 0;
    }
    int n = paramWebSocketFrame.rsv() % 8 << 4 | j | k % 128;
    if ((k == 9) && (m > 125))
    {
      paramChannelHandlerContext = new StringBuilder();
      paramChannelHandlerContext.append("invalid payload for PING (payload length must be <= 125, was ");
      paramChannelHandlerContext.append(m);
      throw new TooLongFrameException(paramChannelHandlerContext.toString());
    }
    try
    {
      bool = this.maskPayload;
      if (bool) {
        j = 4;
      } else {
        j = 0;
      }
      int i1;
      if (m <= 125)
      {
        i1 = j + 2;
        if (!bool)
        {
          j = i1;
          if (m > 1024) {}
        }
        else
        {
          j = i1 + m;
        }
        paramWebSocketFrame = paramChannelHandlerContext.alloc().buffer(j);
        paramChannelHandlerContext = paramWebSocketFrame;
        try
        {
          paramWebSocketFrame.writeByte(n);
          paramChannelHandlerContext = paramWebSocketFrame;
          if (this.maskPayload) {
            j = (byte)m | 0x80;
          } else {
            j = (byte)m;
          }
          paramChannelHandlerContext = paramWebSocketFrame;
          paramWebSocketFrame.writeByte((byte)j);
        }
        finally
        {
          break label913;
        }
      }
      if (m <= 65535)
      {
        i1 = j + 4;
        if (!bool)
        {
          j = i1;
          if (m > 1024) {}
        }
        else
        {
          j = i1 + m;
        }
        paramWebSocketFrame = paramChannelHandlerContext.alloc().buffer(j);
        paramChannelHandlerContext = paramWebSocketFrame;
        paramWebSocketFrame.writeByte(n);
        paramChannelHandlerContext = paramWebSocketFrame;
        if (this.maskPayload) {
          j = 254;
        } else {
          j = 126;
        }
        paramChannelHandlerContext = paramWebSocketFrame;
        paramWebSocketFrame.writeByte(j);
        paramChannelHandlerContext = paramWebSocketFrame;
        paramWebSocketFrame.writeByte(m >>> 8 & 0xFF);
        paramChannelHandlerContext = paramWebSocketFrame;
        paramWebSocketFrame.writeByte(m & 0xFF);
      }
      else
      {
        i1 = j + 10;
        if (!bool)
        {
          j = i1;
          if (m > 1024) {}
        }
        else
        {
          j = i1 + m;
        }
        paramWebSocketFrame = paramChannelHandlerContext.alloc().buffer(j);
        paramChannelHandlerContext = paramWebSocketFrame;
        paramWebSocketFrame.writeByte(n);
        paramChannelHandlerContext = paramWebSocketFrame;
        if (this.maskPayload) {
          j = 255;
        } else {
          j = 127;
        }
        paramChannelHandlerContext = paramWebSocketFrame;
        paramWebSocketFrame.writeByte(j);
        paramChannelHandlerContext = paramWebSocketFrame;
        paramWebSocketFrame.writeLong(m);
      }
      paramChannelHandlerContext = paramWebSocketFrame;
      if (this.maskPayload)
      {
        paramChannelHandlerContext = paramWebSocketFrame;
        j = (int)(Math.random() * 2.147483647E9D);
        paramChannelHandlerContext = paramWebSocketFrame;
        byte[] arrayOfByte = ByteBuffer.allocate(4).putInt(j).array();
        paramChannelHandlerContext = paramWebSocketFrame;
        paramWebSocketFrame.writeBytes(arrayOfByte);
        paramChannelHandlerContext = paramWebSocketFrame;
        ByteOrder localByteOrder = localByteBuf.order();
        paramChannelHandlerContext = paramWebSocketFrame;
        localObject = paramWebSocketFrame.order();
        paramChannelHandlerContext = paramWebSocketFrame;
        n = localByteBuf.readerIndex();
        paramChannelHandlerContext = paramWebSocketFrame;
        int i2 = localByteBuf.writerIndex();
        int i3 = i;
        i1 = n;
        if (localByteOrder == localObject)
        {
          i1 = (arrayOfByte[0] & 0xFF) << 24 | (arrayOfByte[1] & 0xFF) << 16 | (arrayOfByte[2] & 0xFF) << 8 | arrayOfByte[3] & 0xFF;
          paramChannelHandlerContext = paramWebSocketFrame;
          m = i1;
          j = n;
          if (localByteOrder == ByteOrder.LITTLE_ENDIAN)
          {
            paramChannelHandlerContext = paramWebSocketFrame;
            m = Integer.reverseBytes(i1);
          }
          for (j = n;; j += 4)
          {
            i3 = i;
            i1 = j;
            if (j + 3 >= i2) {
              break;
            }
            paramChannelHandlerContext = paramWebSocketFrame;
            paramWebSocketFrame.writeInt(localByteBuf.getInt(j) ^ m);
          }
        }
        while (i1 < i2)
        {
          paramChannelHandlerContext = paramWebSocketFrame;
          paramWebSocketFrame.writeByte(localByteBuf.getByte(i1) ^ arrayOfByte[(i3 % 4)]);
          i1++;
          i3++;
        }
        paramChannelHandlerContext = paramWebSocketFrame;
        paramList.add(paramWebSocketFrame);
      }
      else
      {
        paramChannelHandlerContext = paramWebSocketFrame;
        if (paramWebSocketFrame.writableBytes() >= localByteBuf.readableBytes())
        {
          paramChannelHandlerContext = paramWebSocketFrame;
          paramWebSocketFrame.writeBytes(localByteBuf);
          paramChannelHandlerContext = paramWebSocketFrame;
          paramList.add(paramWebSocketFrame);
        }
        else
        {
          paramChannelHandlerContext = paramWebSocketFrame;
          paramList.add(paramWebSocketFrame);
          paramChannelHandlerContext = paramWebSocketFrame;
          paramList.add(localByteBuf.retain());
        }
      }
      return;
    }
    finally
    {
      paramChannelHandlerContext = null;
      label913:
      if (paramChannelHandlerContext != null) {
        paramChannelHandlerContext.release();
      }
    }
    label926:
    paramChannelHandlerContext = new StringBuilder();
    paramChannelHandlerContext.append("Cannot encode frame of type: ");
    paramChannelHandlerContext.append(paramWebSocketFrame.getClass().getName());
    throw new UnsupportedOperationException(paramChannelHandlerContext.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\websocketx\WebSocket08FrameEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */