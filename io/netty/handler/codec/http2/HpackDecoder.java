package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.Headers;
import io.netty.util.AsciiString;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.ThrowableUtil;

final class HpackDecoder
{
  private static final Http2Exception DECODE_ILLEGAL_INDEX_VALUE;
  private static final Http2Exception DECODE_ULE_128_DECOMPRESSION_EXCEPTION;
  private static final Http2Exception DECODE_ULE_128_TO_INT_DECOMPRESSION_EXCEPTION;
  private static final Http2Exception DECODE_ULE_128_TO_LONG_DECOMPRESSION_EXCEPTION;
  private static final Http2Exception INDEX_HEADER_ILLEGAL_INDEX_VALUE;
  private static final Http2Exception INVALID_MAX_DYNAMIC_TABLE_SIZE;
  private static final Http2Exception MAX_DYNAMIC_TABLE_SIZE_CHANGE_REQUIRED;
  private static final byte READ_HEADER_REPRESENTATION = 0;
  private static final byte READ_INDEXED_HEADER = 2;
  private static final byte READ_INDEXED_HEADER_NAME = 3;
  private static final byte READ_LITERAL_HEADER_NAME = 6;
  private static final byte READ_LITERAL_HEADER_NAME_LENGTH = 5;
  private static final byte READ_LITERAL_HEADER_NAME_LENGTH_PREFIX = 4;
  private static final byte READ_LITERAL_HEADER_VALUE = 9;
  private static final byte READ_LITERAL_HEADER_VALUE_LENGTH = 8;
  private static final byte READ_LITERAL_HEADER_VALUE_LENGTH_PREFIX = 7;
  private static final byte READ_MAX_DYNAMIC_TABLE_SIZE = 1;
  private static final Http2Exception READ_NAME_ILLEGAL_INDEX_VALUE;
  private long encoderMaxDynamicTableSize;
  private final HpackDynamicTable hpackDynamicTable;
  private final HpackHuffmanDecoder huffmanDecoder = new HpackHuffmanDecoder();
  private long maxDynamicTableSize;
  private boolean maxDynamicTableSizeChangeRequired;
  private long maxHeaderListSize;
  
  static
  {
    Http2Error localHttp2Error = Http2Error.COMPRESSION_ERROR;
    Http2Exception.ShutdownHint localShutdownHint = Http2Exception.ShutdownHint.HARD_SHUTDOWN;
    DECODE_ULE_128_DECOMPRESSION_EXCEPTION = (Http2Exception)ThrowableUtil.unknownStackTrace(Http2Exception.newStatic(localHttp2Error, "HPACK - decompression failure", localShutdownHint), HpackDecoder.class, "decodeULE128(..)");
    DECODE_ULE_128_TO_LONG_DECOMPRESSION_EXCEPTION = (Http2Exception)ThrowableUtil.unknownStackTrace(Http2Exception.newStatic(localHttp2Error, "HPACK - long overflow", localShutdownHint), HpackDecoder.class, "decodeULE128(..)");
    DECODE_ULE_128_TO_INT_DECOMPRESSION_EXCEPTION = (Http2Exception)ThrowableUtil.unknownStackTrace(Http2Exception.newStatic(localHttp2Error, "HPACK - int overflow", localShutdownHint), HpackDecoder.class, "decodeULE128ToInt(..)");
    DECODE_ILLEGAL_INDEX_VALUE = (Http2Exception)ThrowableUtil.unknownStackTrace(Http2Exception.newStatic(localHttp2Error, "HPACK - illegal index value", localShutdownHint), HpackDecoder.class, "decode(..)");
    INDEX_HEADER_ILLEGAL_INDEX_VALUE = (Http2Exception)ThrowableUtil.unknownStackTrace(Http2Exception.newStatic(localHttp2Error, "HPACK - illegal index value", localShutdownHint), HpackDecoder.class, "indexHeader(..)");
    READ_NAME_ILLEGAL_INDEX_VALUE = (Http2Exception)ThrowableUtil.unknownStackTrace(Http2Exception.newStatic(localHttp2Error, "HPACK - illegal index value", localShutdownHint), HpackDecoder.class, "readName(..)");
    INVALID_MAX_DYNAMIC_TABLE_SIZE = (Http2Exception)ThrowableUtil.unknownStackTrace(Http2Exception.newStatic(localHttp2Error, "HPACK - invalid max dynamic table size", localShutdownHint), HpackDecoder.class, "setDynamicTableSize(..)");
    MAX_DYNAMIC_TABLE_SIZE_CHANGE_REQUIRED = (Http2Exception)ThrowableUtil.unknownStackTrace(Http2Exception.newStatic(localHttp2Error, "HPACK - max dynamic table size change required", localShutdownHint), HpackDecoder.class, "decode(..)");
  }
  
  HpackDecoder(long paramLong)
  {
    this(paramLong, 4096);
  }
  
  HpackDecoder(long paramLong, int paramInt)
  {
    this.maxHeaderListSize = ObjectUtil.checkPositive(paramLong, "maxHeaderListSize");
    paramLong = paramInt;
    this.encoderMaxDynamicTableSize = paramLong;
    this.maxDynamicTableSize = paramLong;
    this.maxDynamicTableSizeChangeRequired = false;
    this.hpackDynamicTable = new HpackDynamicTable(paramLong);
  }
  
  private void decode(ByteBuf paramByteBuf, Sink paramSink)
    throws Http2Exception
  {
    Object localObject1 = HpackUtil.IndexType.NONE;
    Object localObject2 = null;
    boolean bool = false;
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    if (paramByteBuf.isReadable())
    {
      int n;
      label228:
      label239:
      Object localObject3;
      switch (i)
      {
      default: 
        paramByteBuf = new StringBuilder();
        paramByteBuf.append("should not reach here state: ");
        paramByteBuf.append(i);
        throw new Error(paramByteBuf.toString());
      case 9: 
        if (paramByteBuf.readableBytes() >= m) {
          insertHeader(paramSink, (CharSequence)localObject2, readStringLiteral(paramByteBuf, m, bool), (HpackUtil.IndexType)localObject1);
        } else {
          throw notEnoughDataException(paramByteBuf);
        }
        break;
      case 8: 
        n = decodeULE128(paramByteBuf, j);
      case 7: 
        for (;;)
        {
          i = 9;
          m = n;
          break;
          i = paramByteBuf.readByte();
          if ((i & 0x80) == 128) {
            bool = true;
          } else {
            bool = false;
          }
          i &= 0x7F;
          if (i == 0) {
            break label239;
          }
          if (i == 127) {
            break label228;
          }
          n = i;
          j = i;
        }
        n = 8;
        j = i;
        break;
        insertHeader(paramSink, (CharSequence)localObject2, AsciiString.EMPTY_STRING, (HpackUtil.IndexType)localObject1);
        j = i;
        break;
      case 6: 
        if (paramByteBuf.readableBytes() >= k) {
          localObject3 = readStringLiteral(paramByteBuf, k, bool);
        } else {
          throw notEnoughDataException(paramByteBuf);
        }
        break;
      case 5: 
      case 4: 
        for (k = decodeULE128(paramByteBuf, j);; k = j)
        {
          i = 6;
          break;
          i = paramByteBuf.readByte();
          if ((i & 0x80) == 128) {
            bool = true;
          } else {
            bool = false;
          }
          j = i & 0x7F;
          if (j == 127)
          {
            n = 5;
            i = n;
            break;
          }
        }
      case 3: 
        localObject3 = readName(decodeULE128(paramByteBuf, j));
        k = ((CharSequence)localObject3).length();
      }
      for (;;)
      {
        i = 7;
        localObject2 = localObject3;
        break;
        localObject3 = getIndexedHeader(decodeULE128(paramByteBuf, j));
        paramSink.appendToHeaderList(((HpackHeaderField)localObject3).name, ((HpackHeaderField)localObject3).value);
        break label432;
        setDynamicTableSize(decodeULE128(paramByteBuf, j));
        label432:
        i = 0;
        break;
        j = paramByteBuf.readByte();
        if ((this.maxDynamicTableSizeChangeRequired) && ((j & 0xE0) != 32)) {
          throw MAX_DYNAMIC_TABLE_SIZE_CHANGE_REQUIRED;
        }
        if (j < 0)
        {
          j &= 0x7F;
          if (j != 0)
          {
            if (j != 127)
            {
              localObject3 = getIndexedHeader(j);
              paramSink.appendToHeaderList(((HpackHeaderField)localObject3).name, ((HpackHeaderField)localObject3).value);
              break;
            }
            i = 2;
            break;
          }
          throw DECODE_ILLEGAL_INDEX_VALUE;
        }
        if ((j & 0x40) == 64)
        {
          localObject3 = HpackUtil.IndexType.INCREMENTAL;
          i = j & 0x3F;
          localObject1 = localObject3;
          j = i;
          if (i != 0)
          {
            localObject1 = localObject3;
            j = i;
            if (i != 63)
            {
              localObject2 = readName(i);
              k = ((CharSequence)localObject2).length();
              localObject1 = localObject3;
              localObject3 = localObject2;
              j = i;
              continue;
            }
          }
        }
        do
        {
          i = 3;
          break;
          do
          {
            i = 4;
            break;
            if ((j & 0x20) == 32)
            {
              j &= 0x1F;
              if (j == 31)
              {
                i = 1;
                break;
              }
              setDynamicTableSize(j);
              break label432;
            }
            if ((j & 0x10) == 16) {
              localObject3 = HpackUtil.IndexType.NEVER;
            } else {
              localObject3 = HpackUtil.IndexType.NONE;
            }
            i = j & 0xF;
            localObject1 = localObject3;
            j = i;
          } while (i == 0);
          localObject1 = localObject3;
          j = i;
        } while (i == 15);
        localObject2 = readName(i);
        k = ((CharSequence)localObject2).length();
        localObject1 = localObject3;
        localObject3 = localObject2;
        j = i;
      }
    }
    if (i == 0) {
      return;
    }
    throw Http2Exception.connectionError(Http2Error.COMPRESSION_ERROR, "Incomplete header block fragment.", new Object[0]);
  }
  
  static int decodeULE128(ByteBuf paramByteBuf, int paramInt)
    throws Http2Exception
  {
    int i = paramByteBuf.readerIndex();
    long l = decodeULE128(paramByteBuf, paramInt);
    if (l <= 2147483647L) {
      return (int)l;
    }
    paramByteBuf.readerIndex(i);
    throw DECODE_ULE_128_TO_INT_DECOMPRESSION_EXCEPTION;
  }
  
  static long decodeULE128(ByteBuf paramByteBuf, long paramLong)
    throws Http2Exception
  {
    int i = 0;
    int j;
    if (paramLong == 0L) {
      j = 1;
    } else {
      j = 0;
    }
    int k = paramByteBuf.writerIndex();
    int m = paramByteBuf.readerIndex();
    while (m < k)
    {
      int n = paramByteBuf.getByte(m);
      if ((i == 56) && (((n & 0x80) != 0) || ((n == 127) && (j == 0)))) {
        throw DECODE_ULE_128_TO_LONG_DECOMPRESSION_EXCEPTION;
      }
      if ((n & 0x80) == 0)
      {
        paramByteBuf.readerIndex(m + 1);
        return paramLong + ((n & 0x7F) << i);
      }
      paramLong += ((n & 0x7F) << i);
      m++;
      i += 7;
    }
    throw DECODE_ULE_128_DECOMPRESSION_EXCEPTION;
  }
  
  private HpackHeaderField getIndexedHeader(int paramInt)
    throws Http2Exception
  {
    int i = HpackStaticTable.length;
    if (paramInt <= i) {
      return HpackStaticTable.getEntry(paramInt);
    }
    if (paramInt - i <= this.hpackDynamicTable.length()) {
      return this.hpackDynamicTable.getEntry(paramInt - i);
    }
    throw INDEX_HEADER_ILLEGAL_INDEX_VALUE;
  }
  
  private void insertHeader(Sink paramSink, CharSequence paramCharSequence1, CharSequence paramCharSequence2, HpackUtil.IndexType paramIndexType)
  {
    paramSink.appendToHeaderList(paramCharSequence1, paramCharSequence2);
    int i = 1.$SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType[paramIndexType.ordinal()];
    if ((i != 1) && (i != 2)) {
      if (i == 3) {
        this.hpackDynamicTable.add(new HpackHeaderField(paramCharSequence1, paramCharSequence2));
      } else {
        throw new Error("should not reach here");
      }
    }
  }
  
  private static IllegalArgumentException notEnoughDataException(ByteBuf paramByteBuf)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("decode only works with an entire header block! ");
    localStringBuilder.append(paramByteBuf);
    return new IllegalArgumentException(localStringBuilder.toString());
  }
  
  private CharSequence readName(int paramInt)
    throws Http2Exception
  {
    int i = HpackStaticTable.length;
    if (paramInt <= i) {
      return HpackStaticTable.getEntry(paramInt).name;
    }
    if (paramInt - i <= this.hpackDynamicTable.length()) {
      return this.hpackDynamicTable.getEntry(paramInt - i).name;
    }
    throw READ_NAME_ILLEGAL_INDEX_VALUE;
  }
  
  private CharSequence readStringLiteral(ByteBuf paramByteBuf, int paramInt, boolean paramBoolean)
    throws Http2Exception
  {
    if (paramBoolean) {
      return this.huffmanDecoder.decode(paramByteBuf, paramInt);
    }
    byte[] arrayOfByte = new byte[paramInt];
    paramByteBuf.readBytes(arrayOfByte);
    return new AsciiString(arrayOfByte, false);
  }
  
  private void setDynamicTableSize(long paramLong)
    throws Http2Exception
  {
    if (paramLong <= this.maxDynamicTableSize)
    {
      this.encoderMaxDynamicTableSize = paramLong;
      this.maxDynamicTableSizeChangeRequired = false;
      this.hpackDynamicTable.setCapacity(paramLong);
      return;
    }
    throw INVALID_MAX_DYNAMIC_TABLE_SIZE;
  }
  
  private static HeaderType validate(int paramInt, CharSequence paramCharSequence, HeaderType paramHeaderType)
    throws Http2Exception
  {
    if (Http2Headers.PseudoHeaderName.hasPseudoHeaderFormat(paramCharSequence))
    {
      if (paramHeaderType != HeaderType.REGULAR_HEADER)
      {
        Http2Headers.PseudoHeaderName localPseudoHeaderName = Http2Headers.PseudoHeaderName.getPseudoHeader(paramCharSequence);
        if (localPseudoHeaderName != null)
        {
          if (localPseudoHeaderName.isRequestOnly()) {
            paramCharSequence = HeaderType.REQUEST_PSEUDO_HEADER;
          } else {
            paramCharSequence = HeaderType.RESPONSE_PSEUDO_HEADER;
          }
          if ((paramHeaderType != null) && (paramCharSequence != paramHeaderType)) {
            throw Http2Exception.streamError(paramInt, Http2Error.PROTOCOL_ERROR, "Mix of request and response pseudo-headers.", new Object[0]);
          }
          return paramCharSequence;
        }
        throw Http2Exception.streamError(paramInt, Http2Error.PROTOCOL_ERROR, "Invalid HTTP/2 pseudo-header '%s' encountered.", new Object[] { paramCharSequence });
      }
      throw Http2Exception.streamError(paramInt, Http2Error.PROTOCOL_ERROR, "Pseudo-header field '%s' found after regular header.", new Object[] { paramCharSequence });
    }
    return HeaderType.REGULAR_HEADER;
  }
  
  public void decode(int paramInt, ByteBuf paramByteBuf, Http2Headers paramHttp2Headers, boolean paramBoolean)
    throws Http2Exception
  {
    paramHttp2Headers = new Http2HeadersSink(paramInt, paramHttp2Headers, this.maxHeaderListSize, paramBoolean);
    decode(paramByteBuf, paramHttp2Headers);
    paramHttp2Headers.finish();
  }
  
  HpackHeaderField getHeaderField(int paramInt)
  {
    return this.hpackDynamicTable.getEntry(paramInt + 1);
  }
  
  public long getMaxHeaderListSize()
  {
    return this.maxHeaderListSize;
  }
  
  public long getMaxHeaderTableSize()
  {
    return this.hpackDynamicTable.capacity();
  }
  
  int length()
  {
    return this.hpackDynamicTable.length();
  }
  
  public void setMaxHeaderListSize(long paramLong)
    throws Http2Exception
  {
    if ((paramLong >= 0L) && (paramLong <= 4294967295L))
    {
      this.maxHeaderListSize = paramLong;
      return;
    }
    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header List Size must be >= %d and <= %d but was %d", new Object[] { Long.valueOf(0L), Long.valueOf(4294967295L), Long.valueOf(paramLong) });
  }
  
  @Deprecated
  public void setMaxHeaderListSize(long paramLong1, long paramLong2)
    throws Http2Exception
  {
    setMaxHeaderListSize(paramLong1);
  }
  
  public void setMaxHeaderTableSize(long paramLong)
    throws Http2Exception
  {
    if ((paramLong >= 0L) && (paramLong <= 4294967295L))
    {
      this.maxDynamicTableSize = paramLong;
      if (paramLong < this.encoderMaxDynamicTableSize)
      {
        this.maxDynamicTableSizeChangeRequired = true;
        this.hpackDynamicTable.setCapacity(paramLong);
      }
      return;
    }
    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header Table Size must be >= %d and <= %d but was %d", new Object[] { Long.valueOf(0L), Long.valueOf(4294967295L), Long.valueOf(paramLong) });
  }
  
  long size()
  {
    return this.hpackDynamicTable.size();
  }
  
  private static enum HeaderType
  {
    static
    {
      HeaderType localHeaderType1 = new HeaderType("REGULAR_HEADER", 0);
      REGULAR_HEADER = localHeaderType1;
      HeaderType localHeaderType2 = new HeaderType("REQUEST_PSEUDO_HEADER", 1);
      REQUEST_PSEUDO_HEADER = localHeaderType2;
      HeaderType localHeaderType3 = new HeaderType("RESPONSE_PSEUDO_HEADER", 2);
      RESPONSE_PSEUDO_HEADER = localHeaderType3;
      $VALUES = new HeaderType[] { localHeaderType1, localHeaderType2, localHeaderType3 };
    }
  }
  
  private static final class Http2HeadersSink
    implements HpackDecoder.Sink
  {
    private boolean exceededMaxLength;
    private final Http2Headers headers;
    private long headersLength;
    private final long maxHeaderListSize;
    private HpackDecoder.HeaderType previousType;
    private final int streamId;
    private final boolean validate;
    private Http2Exception validationException;
    
    Http2HeadersSink(int paramInt, Http2Headers paramHttp2Headers, long paramLong, boolean paramBoolean)
    {
      this.headers = paramHttp2Headers;
      this.maxHeaderListSize = paramLong;
      this.streamId = paramInt;
      this.validate = paramBoolean;
    }
    
    public void appendToHeaderList(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
    {
      long l = this.headersLength + HpackHeaderField.sizeOf(paramCharSequence1, paramCharSequence2);
      this.headersLength = l;
      boolean bool1 = this.exceededMaxLength;
      boolean bool2;
      if (l > this.maxHeaderListSize) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      bool1 = bool2 | bool1;
      this.exceededMaxLength = bool1;
      if ((!bool1) && (this.validationException == null))
      {
        if (this.validate) {
          try
          {
            this.previousType = HpackDecoder.validate(this.streamId, paramCharSequence1, this.previousType);
          }
          catch (Http2Exception paramCharSequence1)
          {
            this.validationException = paramCharSequence1;
            return;
          }
        }
        this.headers.add(paramCharSequence1, paramCharSequence2);
      }
    }
    
    public void finish()
      throws Http2Exception
    {
      Http2Exception localHttp2Exception;
      if (this.exceededMaxLength)
      {
        Http2CodecUtil.headerListSizeExceeded(this.streamId, this.maxHeaderListSize, true);
      }
      else
      {
        localHttp2Exception = this.validationException;
        if (localHttp2Exception != null) {
          break label32;
        }
      }
      return;
      label32:
      throw localHttp2Exception;
    }
  }
  
  private static abstract interface Sink
  {
    public abstract void appendToHeaderList(CharSequence paramCharSequence1, CharSequence paramCharSequence2);
    
    public abstract void finish()
      throws Http2Exception;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\HpackDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */