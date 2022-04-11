package io.netty.handler.codec.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;

final class HttpHeadersEncoder
{
  private static final int COLON_AND_SPACE_SHORT = 14880;
  
  static void encoderHeader(CharSequence paramCharSequence1, CharSequence paramCharSequence2, ByteBuf paramByteBuf)
  {
    int i = paramCharSequence1.length();
    int j = paramCharSequence2.length();
    paramByteBuf.ensureWritable(i + j + 4);
    int k = paramByteBuf.writerIndex();
    writeAscii(paramByteBuf, k, paramCharSequence1);
    i = k + i;
    ByteBufUtil.setShortBE(paramByteBuf, i, 14880);
    i += 2;
    writeAscii(paramByteBuf, i, paramCharSequence2);
    j = i + j;
    ByteBufUtil.setShortBE(paramByteBuf, j, 3338);
    paramByteBuf.writerIndex(j + 2);
  }
  
  private static void writeAscii(ByteBuf paramByteBuf, int paramInt, CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof AsciiString)) {
      ByteBufUtil.copy((AsciiString)paramCharSequence, 0, paramByteBuf, paramInt, paramCharSequence.length());
    } else {
      paramByteBuf.setCharSequence(paramInt, paramCharSequence, CharsetUtil.US_ASCII);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpHeadersEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */