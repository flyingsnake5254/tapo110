package io.netty.handler.codec.json;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.handler.codec.TooLongFrameException;
import java.util.List;

public class JsonObjectDecoder
  extends ByteToMessageDecoder
{
  private static final int ST_CORRUPTED = -1;
  private static final int ST_DECODING_ARRAY_STREAM = 2;
  private static final int ST_DECODING_NORMAL = 1;
  private static final int ST_INIT = 0;
  private int idx;
  private boolean insideString;
  private int lastReaderIndex;
  private final int maxObjectLength;
  private int openBraces;
  private int state;
  private final boolean streamArrayElements;
  
  public JsonObjectDecoder()
  {
    this(1048576);
  }
  
  public JsonObjectDecoder(int paramInt)
  {
    this(paramInt, false);
  }
  
  public JsonObjectDecoder(int paramInt, boolean paramBoolean)
  {
    if (paramInt >= 1)
    {
      this.maxObjectLength = paramInt;
      this.streamArrayElements = paramBoolean;
      return;
    }
    throw new IllegalArgumentException("maxObjectLength must be a positive int");
  }
  
  public JsonObjectDecoder(boolean paramBoolean)
  {
    this(1048576, paramBoolean);
  }
  
  private void decodeByte(byte paramByte, ByteBuf paramByteBuf, int paramInt)
  {
    if (((paramByte == 123) || (paramByte == 91)) && (!this.insideString)) {
      this.openBraces += 1;
    } else if (((paramByte == 125) || (paramByte == 93)) && (!this.insideString)) {
      this.openBraces -= 1;
    } else if (paramByte == 34) {
      if (!this.insideString)
      {
        this.insideString = true;
      }
      else
      {
        paramByte = paramInt - 1;
        paramInt = 0;
        while ((paramByte >= 0) && (paramByteBuf.getByte(paramByte) == 92))
        {
          paramInt++;
          paramByte--;
        }
        if (paramInt % 2 == 0) {
          this.insideString = false;
        }
      }
    }
  }
  
  private void initDecoding(byte paramByte)
  {
    this.openBraces = 1;
    if ((paramByte == 91) && (this.streamArrayElements)) {
      this.state = 2;
    } else {
      this.state = 1;
    }
  }
  
  private void reset()
  {
    this.insideString = false;
    this.state = 0;
    this.openBraces = 0;
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    if (this.state == -1)
    {
      paramByteBuf.skipBytes(paramByteBuf.readableBytes());
      return;
    }
    if ((this.idx > paramByteBuf.readerIndex()) && (this.lastReaderIndex != paramByteBuf.readerIndex())) {
      this.idx = (paramByteBuf.readerIndex() + (this.idx - this.lastReaderIndex));
    }
    int i = this.idx;
    int j = paramByteBuf.writerIndex();
    if (j <= this.maxObjectLength)
    {
      while (i < j)
      {
        byte b = paramByteBuf.getByte(i);
        int k = this.state;
        ByteBuf localByteBuf;
        if (k == 1)
        {
          decodeByte(b, paramByteBuf, i);
          if (this.openBraces == 0)
          {
            int m = paramByteBuf.readerIndex();
            k = i + 1;
            localByteBuf = extractObject(paramChannelHandlerContext, paramByteBuf, m, k - paramByteBuf.readerIndex());
            if (localByteBuf != null) {
              paramList.add(localByteBuf);
            }
            paramByteBuf.readerIndex(k);
            reset();
          }
        }
        else if (k == 2)
        {
          decodeByte(b, paramByteBuf, i);
          if (!this.insideString)
          {
            k = this.openBraces;
            if (((k == 1) && (b == 44)) || ((k == 0) && (b == 93)))
            {
              for (k = paramByteBuf.readerIndex(); Character.isWhitespace(paramByteBuf.getByte(k)); k++) {
                paramByteBuf.skipBytes(1);
              }
              for (k = i - 1; (k >= paramByteBuf.readerIndex()) && (Character.isWhitespace(paramByteBuf.getByte(k))); k--) {}
              localByteBuf = extractObject(paramChannelHandlerContext, paramByteBuf, paramByteBuf.readerIndex(), k + 1 - paramByteBuf.readerIndex());
              if (localByteBuf != null) {
                paramList.add(localByteBuf);
              }
              paramByteBuf.readerIndex(i + 1);
              if (b == 93) {
                reset();
              }
            }
          }
        }
        else if ((b != 123) && (b != 91))
        {
          if (Character.isWhitespace(b))
          {
            paramByteBuf.skipBytes(1);
          }
          else
          {
            this.state = -1;
            paramChannelHandlerContext = new StringBuilder();
            paramChannelHandlerContext.append("invalid JSON received at byte position ");
            paramChannelHandlerContext.append(i);
            paramChannelHandlerContext.append(": ");
            paramChannelHandlerContext.append(ByteBufUtil.hexDump(paramByteBuf));
            throw new CorruptedFrameException(paramChannelHandlerContext.toString());
          }
        }
        else
        {
          initDecoding(b);
          if (this.state == 2) {
            paramByteBuf.skipBytes(1);
          }
        }
        i++;
      }
      if (paramByteBuf.readableBytes() == 0) {
        this.idx = 0;
      } else {
        this.idx = i;
      }
      this.lastReaderIndex = paramByteBuf.readerIndex();
      return;
    }
    paramByteBuf.skipBytes(paramByteBuf.readableBytes());
    reset();
    paramChannelHandlerContext = new StringBuilder();
    paramChannelHandlerContext.append("object length exceeds ");
    paramChannelHandlerContext.append(this.maxObjectLength);
    paramChannelHandlerContext.append(": ");
    paramChannelHandlerContext.append(j);
    paramChannelHandlerContext.append(" bytes discarded");
    throw new TooLongFrameException(paramChannelHandlerContext.toString());
  }
  
  protected ByteBuf extractObject(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    return paramByteBuf.retainedSlice(paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\json\JsonObjectDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */