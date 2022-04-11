package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.util.AsciiString;
import io.netty.util.ByteProcessor;
import io.netty.util.internal.PlatformDependent;

final class HpackHuffmanEncoder
{
  private final int[] codes;
  private final EncodeProcessor encodeProcessor = new EncodeProcessor(null);
  private final EncodedLengthProcessor encodedLengthProcessor = new EncodedLengthProcessor(null);
  private final byte[] lengths;
  
  HpackHuffmanEncoder()
  {
    this(HpackUtil.HUFFMAN_CODES, HpackUtil.HUFFMAN_CODE_LENGTHS);
  }
  
  private HpackHuffmanEncoder(int[] paramArrayOfInt, byte[] paramArrayOfByte)
  {
    this.codes = paramArrayOfInt;
    this.lengths = paramArrayOfByte;
  }
  
  private void encodeSlowPath(ByteBuf paramByteBuf, CharSequence paramCharSequence)
  {
    int i = 0;
    long l = 0L;
    int j = 0;
    while (i < paramCharSequence.length())
    {
      int k = paramCharSequence.charAt(i) & 0xFF;
      int m = this.codes[k];
      k = this.lengths[k];
      l = l << k | m;
      j += k;
      while (j >= 8)
      {
        j -= 8;
        paramByteBuf.writeByte((int)(l >> j));
      }
      i++;
    }
    if (j > 0) {
      paramByteBuf.writeByte((int)(255 >>> j | l << 8 - j));
    }
  }
  
  private int getEncodedLengthSlowPath(CharSequence paramCharSequence)
  {
    long l = 0L;
    for (int i = 0; i < paramCharSequence.length(); i++) {
      l += this.lengths[(paramCharSequence.charAt(i) & 0xFF)];
    }
    return (int)(l + 7L >> 3);
  }
  
  /* Error */
  public void encode(ByteBuf paramByteBuf, CharSequence paramCharSequence)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 79
    //   3: invokestatic 85	io/netty/util/internal/ObjectUtil:checkNotNull	(Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/Object;
    //   6: pop
    //   7: aload_2
    //   8: instanceof 87
    //   11: ifeq +55 -> 66
    //   14: aload_2
    //   15: checkcast 87	io/netty/util/AsciiString
    //   18: astore_3
    //   19: aload_0
    //   20: getfield 44	io/netty/handler/codec/http2/HpackHuffmanEncoder:encodeProcessor	Lio/netty/handler/codec/http2/HpackHuffmanEncoder$EncodeProcessor;
    //   23: astore_2
    //   24: aload_2
    //   25: aload_1
    //   26: putfield 90	io/netty/handler/codec/http2/HpackHuffmanEncoder$EncodeProcessor:out	Lio/netty/buffer/ByteBuf;
    //   29: aload_3
    //   30: aload_2
    //   31: invokevirtual 94	io/netty/util/AsciiString:forEachByte	(Lio/netty/util/ByteProcessor;)I
    //   34: pop
    //   35: goto +12 -> 47
    //   38: astore_1
    //   39: goto +18 -> 57
    //   42: astore_1
    //   43: aload_1
    //   44: invokestatic 100	io/netty/util/internal/PlatformDependent:throwException	(Ljava/lang/Throwable;)V
    //   47: aload_0
    //   48: getfield 44	io/netty/handler/codec/http2/HpackHuffmanEncoder:encodeProcessor	Lio/netty/handler/codec/http2/HpackHuffmanEncoder$EncodeProcessor;
    //   51: invokevirtual 103	io/netty/handler/codec/http2/HpackHuffmanEncoder$EncodeProcessor:end	()V
    //   54: goto +18 -> 72
    //   57: aload_0
    //   58: getfield 44	io/netty/handler/codec/http2/HpackHuffmanEncoder:encodeProcessor	Lio/netty/handler/codec/http2/HpackHuffmanEncoder$EncodeProcessor;
    //   61: invokevirtual 103	io/netty/handler/codec/http2/HpackHuffmanEncoder$EncodeProcessor:end	()V
    //   64: aload_1
    //   65: athrow
    //   66: aload_0
    //   67: aload_1
    //   68: aload_2
    //   69: invokespecial 105	io/netty/handler/codec/http2/HpackHuffmanEncoder:encodeSlowPath	(Lio/netty/buffer/ByteBuf;Ljava/lang/CharSequence;)V
    //   72: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	73	0	this	HpackHuffmanEncoder
    //   0	73	1	paramByteBuf	ByteBuf
    //   0	73	2	paramCharSequence	CharSequence
    //   18	12	3	localAsciiString	AsciiString
    // Exception table:
    //   from	to	target	type
    //   19	35	38	finally
    //   43	47	38	finally
    //   19	35	42	java/lang/Exception
  }
  
  int getEncodedLength(CharSequence paramCharSequence)
  {
    if ((paramCharSequence instanceof AsciiString))
    {
      paramCharSequence = (AsciiString)paramCharSequence;
      try
      {
        this.encodedLengthProcessor.reset();
        paramCharSequence.forEachByte(this.encodedLengthProcessor);
        int i = this.encodedLengthProcessor.length();
        return i;
      }
      catch (Exception paramCharSequence)
      {
        PlatformDependent.throwException(paramCharSequence);
        return -1;
      }
    }
    return getEncodedLengthSlowPath(paramCharSequence);
  }
  
  private final class EncodeProcessor
    implements ByteProcessor
  {
    private long current;
    private int n;
    ByteBuf out;
    
    private EncodeProcessor() {}
    
    void end()
    {
      try
      {
        int i = this.n;
        if (i > 0)
        {
          long l = this.current << 8 - i;
          this.current = l;
          l |= 255 >>> i;
          this.current = l;
          this.out.writeByte((int)l);
        }
        return;
      }
      finally
      {
        this.out = null;
        this.current = 0L;
        this.n = 0;
      }
    }
    
    public boolean process(byte paramByte)
    {
      paramByte &= 0xFF;
      int i = HpackHuffmanEncoder.this.lengths[paramByte];
      long l = this.current << i;
      this.current = l;
      this.current = (l | HpackHuffmanEncoder.this.codes[paramByte]);
      this.n += i;
      for (;;)
      {
        paramByte = this.n;
        if (paramByte < 8) {
          break;
        }
        paramByte -= 8;
        this.n = paramByte;
        this.out.writeByte((int)(this.current >> paramByte));
      }
      return true;
    }
  }
  
  private final class EncodedLengthProcessor
    implements ByteProcessor
  {
    private long len;
    
    private EncodedLengthProcessor() {}
    
    int length()
    {
      return (int)(this.len + 7L >> 3);
    }
    
    public boolean process(byte paramByte)
    {
      this.len += HpackHuffmanEncoder.this.lengths[(paramByte & 0xFF)];
      return true;
    }
    
    void reset()
    {
      this.len = 0L;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\HpackHuffmanEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */