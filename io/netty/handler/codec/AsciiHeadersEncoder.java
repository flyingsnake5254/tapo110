package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.Map.Entry;

public final class AsciiHeadersEncoder
{
  private final ByteBuf buf;
  private final NewlineType newlineType;
  private final SeparatorType separatorType;
  
  public AsciiHeadersEncoder(ByteBuf paramByteBuf)
  {
    this(paramByteBuf, SeparatorType.COLON_SPACE, NewlineType.CRLF);
  }
  
  public AsciiHeadersEncoder(ByteBuf paramByteBuf, SeparatorType paramSeparatorType, NewlineType paramNewlineType)
  {
    this.buf = ((ByteBuf)ObjectUtil.checkNotNull(paramByteBuf, "buf"));
    this.separatorType = ((SeparatorType)ObjectUtil.checkNotNull(paramSeparatorType, "separatorType"));
    this.newlineType = ((NewlineType)ObjectUtil.checkNotNull(paramNewlineType, "newlineType"));
  }
  
  private static void writeAscii(ByteBuf paramByteBuf, int paramInt, CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof AsciiString)) {
      ByteBufUtil.copy((AsciiString)paramCharSequence, 0, paramByteBuf, paramInt, paramCharSequence.length());
    } else {
      paramByteBuf.setCharSequence(paramInt, paramCharSequence, CharsetUtil.US_ASCII);
    }
  }
  
  public void encode(Map.Entry<CharSequence, CharSequence> paramEntry)
  {
    CharSequence localCharSequence = (CharSequence)paramEntry.getKey();
    paramEntry = (CharSequence)paramEntry.getValue();
    ByteBuf localByteBuf = this.buf;
    int i = localCharSequence.length();
    int j = paramEntry.length();
    int k = localByteBuf.writerIndex();
    localByteBuf.ensureWritable(i + j + 4);
    writeAscii(localByteBuf, k, localCharSequence);
    i = k + i;
    k = 1.$SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$SeparatorType[this.separatorType.ordinal()];
    if (k != 1)
    {
      if (k == 2)
      {
        k = i + 1;
        localByteBuf.setByte(i, 58);
        i = k + 1;
        localByteBuf.setByte(k, 32);
      }
      else
      {
        throw new Error();
      }
    }
    else
    {
      localByteBuf.setByte(i, 58);
      i++;
    }
    writeAscii(localByteBuf, i, paramEntry);
    i += j;
    j = 1.$SwitchMap$io$netty$handler$codec$AsciiHeadersEncoder$NewlineType[this.newlineType.ordinal()];
    if (j != 1)
    {
      if (j == 2)
      {
        j = i + 1;
        localByteBuf.setByte(i, 13);
        i = j + 1;
        localByteBuf.setByte(j, 10);
      }
      else
      {
        throw new Error();
      }
    }
    else
    {
      localByteBuf.setByte(i, 10);
      i++;
    }
    localByteBuf.writerIndex(i);
  }
  
  public static enum NewlineType
  {
    static
    {
      NewlineType localNewlineType1 = new NewlineType("LF", 0);
      LF = localNewlineType1;
      NewlineType localNewlineType2 = new NewlineType("CRLF", 1);
      CRLF = localNewlineType2;
      $VALUES = new NewlineType[] { localNewlineType1, localNewlineType2 };
    }
  }
  
  public static enum SeparatorType
  {
    static
    {
      SeparatorType localSeparatorType1 = new SeparatorType("COLON", 0);
      COLON = localSeparatorType1;
      SeparatorType localSeparatorType2 = new SeparatorType("COLON_SPACE", 1);
      COLON_SPACE = localSeparatorType2;
      $VALUES = new SeparatorType[] { localSeparatorType1, localSeparatorType2 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\AsciiHeadersEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */