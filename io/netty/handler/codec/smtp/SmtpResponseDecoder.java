package io.netty.handler.codec.smtp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCounted;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class SmtpResponseDecoder
  extends LineBasedFrameDecoder
{
  private List<CharSequence> details;
  
  public SmtpResponseDecoder(int paramInt)
  {
    super(paramInt);
  }
  
  private static DecoderException newDecoderException(ByteBuf paramByteBuf, int paramInt1, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Received invalid line: '");
    localStringBuilder.append(paramByteBuf.toString(paramInt1, paramInt2, CharsetUtil.US_ASCII));
    localStringBuilder.append('\'');
    return new DecoderException(localStringBuilder.toString());
  }
  
  private static int parseCode(ByteBuf paramByteBuf)
  {
    return parseNumber(paramByteBuf.readByte()) * 100 + parseNumber(paramByteBuf.readByte()) * 10 + parseNumber(paramByteBuf.readByte());
  }
  
  private static int parseNumber(byte paramByte)
  {
    return Character.digit((char)paramByte, 10);
  }
  
  protected SmtpResponse decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf)
    throws Exception
  {
    ByteBuf localByteBuf = (ByteBuf)super.decode(paramChannelHandlerContext, paramByteBuf);
    if (localByteBuf == null) {
      return null;
    }
    try
    {
      int i = localByteBuf.readableBytes();
      int j = localByteBuf.readerIndex();
      if (i >= 3)
      {
        int k = parseCode(localByteBuf);
        int m = localByteBuf.readByte();
        String str;
        if (localByteBuf.isReadable()) {
          str = localByteBuf.toString(CharsetUtil.US_ASCII);
        } else {
          str = null;
        }
        List localList = this.details;
        if (m != 32)
        {
          if (m == 45)
          {
            if (str != null)
            {
              paramChannelHandlerContext = localList;
              if (localList == null)
              {
                paramChannelHandlerContext = new java/util/ArrayList;
                paramChannelHandlerContext.<init>(4);
                this.details = paramChannelHandlerContext;
              }
              paramChannelHandlerContext.add(str);
            }
            return null;
          }
          throw newDecoderException(paramByteBuf, j, i);
        }
        this.details = null;
        if (localList != null)
        {
          paramChannelHandlerContext = localList;
          if (str != null)
          {
            localList.add(str);
            paramChannelHandlerContext = localList;
          }
        }
        else if (str == null)
        {
          paramChannelHandlerContext = Collections.emptyList();
        }
        else
        {
          paramChannelHandlerContext = Collections.singletonList(str);
        }
        paramChannelHandlerContext = new DefaultSmtpResponse(k, paramChannelHandlerContext);
        return paramChannelHandlerContext;
      }
      throw newDecoderException(paramByteBuf, j, i);
    }
    finally
    {
      localByteBuf.release();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\smtp\SmtpResponseDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */