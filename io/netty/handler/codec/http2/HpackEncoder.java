package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.MathUtil;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;

final class HpackEncoder
{
  static final int HUFF_CODE_THRESHOLD = 512;
  private final byte hashMask;
  private final HeaderEntry head;
  private final HeaderEntry[] headerFields;
  private final HpackHuffmanEncoder hpackHuffmanEncoder;
  private final int huffCodeThreshold;
  private final boolean ignoreMaxHeaderListSize;
  private long maxHeaderListSize;
  private long maxHeaderTableSize;
  private long size;
  
  HpackEncoder()
  {
    this(false);
  }
  
  HpackEncoder(boolean paramBoolean)
  {
    this(paramBoolean, 16, 512);
  }
  
  HpackEncoder(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    Object localObject = AsciiString.EMPTY_STRING;
    localObject = new HeaderEntry(-1, (CharSequence)localObject, (CharSequence)localObject, Integer.MAX_VALUE, null);
    this.head = ((HeaderEntry)localObject);
    this.hpackHuffmanEncoder = new HpackHuffmanEncoder();
    this.ignoreMaxHeaderListSize = paramBoolean;
    this.maxHeaderTableSize = 4096L;
    this.maxHeaderListSize = 4294967295L;
    HeaderEntry[] arrayOfHeaderEntry = new HeaderEntry[MathUtil.findNextPositivePowerOfTwo(Math.max(2, Math.min(paramInt1, 128)))];
    this.headerFields = arrayOfHeaderEntry;
    this.hashMask = ((byte)(byte)(arrayOfHeaderEntry.length - 1));
    ((HeaderEntry)localObject).after = ((HeaderEntry)localObject);
    ((HeaderEntry)localObject).before = ((HeaderEntry)localObject);
    this.huffCodeThreshold = paramInt2;
  }
  
  private void add(CharSequence paramCharSequence1, CharSequence paramCharSequence2, long paramLong)
  {
    if (paramLong > this.maxHeaderTableSize)
    {
      clear();
      return;
    }
    while (this.maxHeaderTableSize - this.size < paramLong) {
      remove();
    }
    int i = AsciiString.hashCode(paramCharSequence1);
    int j = index(i);
    HeaderEntry localHeaderEntry = this.headerFields[j];
    paramCharSequence1 = new HeaderEntry(i, paramCharSequence1, paramCharSequence2, this.head.before.index - 1, localHeaderEntry);
    this.headerFields[j] = paramCharSequence1;
    paramCharSequence1.addBefore(this.head);
    this.size += paramLong;
  }
  
  private void clear()
  {
    Arrays.fill(this.headerFields, null);
    HeaderEntry localHeaderEntry = this.head;
    localHeaderEntry.after = localHeaderEntry;
    localHeaderEntry.before = localHeaderEntry;
    this.size = 0L;
  }
  
  private void encodeHeader(ByteBuf paramByteBuf, CharSequence paramCharSequence1, CharSequence paramCharSequence2, boolean paramBoolean, long paramLong)
  {
    int i;
    if (paramBoolean)
    {
      i = getNameIndex(paramCharSequence1);
      encodeLiteral(paramByteBuf, paramCharSequence1, paramCharSequence2, HpackUtil.IndexType.NEVER, i);
      return;
    }
    long l = this.maxHeaderTableSize;
    if (l == 0L)
    {
      i = HpackStaticTable.getIndexInsensitive(paramCharSequence1, paramCharSequence2);
      if (i == -1)
      {
        i = HpackStaticTable.getIndex(paramCharSequence1);
        encodeLiteral(paramByteBuf, paramCharSequence1, paramCharSequence2, HpackUtil.IndexType.NONE, i);
      }
      else
      {
        encodeInteger(paramByteBuf, 128, 7, i);
      }
      return;
    }
    if (paramLong > l)
    {
      i = getNameIndex(paramCharSequence1);
      encodeLiteral(paramByteBuf, paramCharSequence1, paramCharSequence2, HpackUtil.IndexType.NONE, i);
      return;
    }
    HeaderEntry localHeaderEntry = getEntryInsensitive(paramCharSequence1, paramCharSequence2);
    if (localHeaderEntry != null)
    {
      encodeInteger(paramByteBuf, 128, 7, getIndex(localHeaderEntry.index) + HpackStaticTable.length);
    }
    else
    {
      i = HpackStaticTable.getIndexInsensitive(paramCharSequence1, paramCharSequence2);
      if (i != -1)
      {
        encodeInteger(paramByteBuf, 128, 7, i);
      }
      else
      {
        ensureCapacity(paramLong);
        encodeLiteral(paramByteBuf, paramCharSequence1, paramCharSequence2, HpackUtil.IndexType.INCREMENTAL, getNameIndex(paramCharSequence1));
        add(paramCharSequence1, paramCharSequence2, paramLong);
      }
    }
  }
  
  private void encodeHeadersEnforceMaxHeaderListSize(int paramInt, ByteBuf paramByteBuf, Http2Headers paramHttp2Headers, Http2HeadersEncoder.SensitivityDetector paramSensitivityDetector)
    throws Http2Exception
  {
    Iterator localIterator = paramHttp2Headers.iterator();
    long l1 = 0L;
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      long l2 = l1 + HpackHeaderField.sizeOf((CharSequence)localEntry.getKey(), (CharSequence)localEntry.getValue());
      long l3 = this.maxHeaderListSize;
      l1 = l2;
      if (l2 > l3)
      {
        Http2CodecUtil.headerListSizeExceeded(paramInt, l3, false);
        l1 = l2;
      }
    }
    encodeHeadersIgnoreMaxHeaderListSize(paramByteBuf, paramHttp2Headers, paramSensitivityDetector);
  }
  
  private void encodeHeadersIgnoreMaxHeaderListSize(ByteBuf paramByteBuf, Http2Headers paramHttp2Headers, Http2HeadersEncoder.SensitivityDetector paramSensitivityDetector)
    throws Http2Exception
  {
    Iterator localIterator = paramHttp2Headers.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      paramHttp2Headers = (CharSequence)((Map.Entry)localObject).getKey();
      localObject = (CharSequence)((Map.Entry)localObject).getValue();
      encodeHeader(paramByteBuf, paramHttp2Headers, (CharSequence)localObject, paramSensitivityDetector.isSensitive(paramHttp2Headers, (CharSequence)localObject), HpackHeaderField.sizeOf(paramHttp2Headers, (CharSequence)localObject));
    }
  }
  
  private static void encodeInteger(ByteBuf paramByteBuf, int paramInt1, int paramInt2, int paramInt3)
  {
    encodeInteger(paramByteBuf, paramInt1, paramInt2, paramInt3);
  }
  
  private static void encodeInteger(ByteBuf paramByteBuf, int paramInt1, int paramInt2, long paramLong)
  {
    paramInt2 = 255 >>> 8 - paramInt2;
    long l = paramInt2;
    if (paramLong < l)
    {
      paramByteBuf.writeByte((int)(paramInt1 | paramLong));
    }
    else
    {
      paramByteBuf.writeByte(paramInt1 | paramInt2);
      for (paramLong -= l; (0xFFFFFFFFFFFFFF80 & paramLong) != 0L; paramLong >>>= 7) {
        paramByteBuf.writeByte((int)(0x7F & paramLong | 0x80));
      }
      paramByteBuf.writeByte((int)paramLong);
    }
  }
  
  private void encodeLiteral(ByteBuf paramByteBuf, CharSequence paramCharSequence1, CharSequence paramCharSequence2, HpackUtil.IndexType paramIndexType, int paramInt)
  {
    int i;
    if (paramInt != -1) {
      i = 1;
    } else {
      i = 0;
    }
    int j = 1.$SwitchMap$io$netty$handler$codec$http2$HpackUtil$IndexType[paramIndexType.ordinal()];
    if (j != 1)
    {
      if (j != 2)
      {
        if (j == 3)
        {
          if (i == 0) {
            paramInt = 0;
          }
          encodeInteger(paramByteBuf, 16, 4, paramInt);
        }
        else
        {
          throw new Error("should not reach here");
        }
      }
      else
      {
        if (i == 0) {
          paramInt = 0;
        }
        encodeInteger(paramByteBuf, 0, 4, paramInt);
      }
    }
    else
    {
      if (i == 0) {
        paramInt = 0;
      }
      encodeInteger(paramByteBuf, 64, 6, paramInt);
    }
    if (i == 0) {
      encodeStringLiteral(paramByteBuf, paramCharSequence1);
    }
    encodeStringLiteral(paramByteBuf, paramCharSequence2);
  }
  
  private void encodeStringLiteral(ByteBuf paramByteBuf, CharSequence paramCharSequence)
  {
    if (paramCharSequence.length() >= this.huffCodeThreshold)
    {
      int i = this.hpackHuffmanEncoder.getEncodedLength(paramCharSequence);
      if (i < paramCharSequence.length())
      {
        encodeInteger(paramByteBuf, 128, 7, i);
        this.hpackHuffmanEncoder.encode(paramByteBuf, paramCharSequence);
        return;
      }
    }
    encodeInteger(paramByteBuf, 0, 7, paramCharSequence.length());
    if ((paramCharSequence instanceof AsciiString))
    {
      paramCharSequence = (AsciiString)paramCharSequence;
      paramByteBuf.writeBytes(paramCharSequence.array(), paramCharSequence.arrayOffset(), paramCharSequence.length());
    }
    else
    {
      paramByteBuf.writeCharSequence(paramCharSequence, CharsetUtil.ISO_8859_1);
    }
  }
  
  private void ensureCapacity(long paramLong)
  {
    while ((this.maxHeaderTableSize - this.size < paramLong) && (length() != 0)) {
      remove();
    }
  }
  
  private HeaderEntry getEntryInsensitive(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if ((length() != 0) && (paramCharSequence1 != null) && (paramCharSequence2 != null))
    {
      int i = AsciiString.hashCode(paramCharSequence1);
      int j = index(i);
      for (HeaderEntry localHeaderEntry = this.headerFields[j]; localHeaderEntry != null; localHeaderEntry = localHeaderEntry.next) {
        if ((localHeaderEntry.hash == i) && (HpackUtil.equalsVariableTime(paramCharSequence2, localHeaderEntry.value)) && (HpackUtil.equalsVariableTime(paramCharSequence1, localHeaderEntry.name))) {
          return localHeaderEntry;
        }
      }
    }
    return null;
  }
  
  private int getIndex(int paramInt)
  {
    int i = -1;
    if (paramInt == -1) {
      paramInt = i;
    } else {
      paramInt = paramInt - this.head.before.index + 1;
    }
    return paramInt;
  }
  
  private int getIndex(CharSequence paramCharSequence)
  {
    if ((length() != 0) && (paramCharSequence != null))
    {
      int i = AsciiString.hashCode(paramCharSequence);
      int j = index(i);
      for (HeaderEntry localHeaderEntry = this.headerFields[j]; localHeaderEntry != null; localHeaderEntry = localHeaderEntry.next) {
        if ((localHeaderEntry.hash == i) && (HpackUtil.equalsConstantTime(paramCharSequence, localHeaderEntry.name) != 0)) {
          return getIndex(localHeaderEntry.index);
        }
      }
    }
    return -1;
  }
  
  private int getNameIndex(CharSequence paramCharSequence)
  {
    int i = HpackStaticTable.getIndex(paramCharSequence);
    int j = i;
    if (i == -1)
    {
      i = getIndex(paramCharSequence);
      j = i;
      if (i >= 0) {
        j = i + HpackStaticTable.length;
      }
    }
    return j;
  }
  
  private int index(int paramInt)
  {
    return paramInt & this.hashMask;
  }
  
  private HpackHeaderField remove()
  {
    if (this.size == 0L) {
      return null;
    }
    HeaderEntry localHeaderEntry1 = this.head.after;
    int i = index(localHeaderEntry1.hash);
    Object localObject1 = this.headerFields[i];
    Object localObject2 = localObject1;
    while (localObject1 != null)
    {
      HeaderEntry localHeaderEntry2 = ((HeaderEntry)localObject1).next;
      if (localObject1 == localHeaderEntry1)
      {
        if (localObject2 == localHeaderEntry1) {
          this.headerFields[i] = localHeaderEntry2;
        } else {
          ((HeaderEntry)localObject2).next = localHeaderEntry2;
        }
        localHeaderEntry1.remove();
        this.size -= localHeaderEntry1.size();
        return localHeaderEntry1;
      }
      localObject2 = localObject1;
      localObject1 = localHeaderEntry2;
    }
    return null;
  }
  
  public void encodeHeaders(int paramInt, ByteBuf paramByteBuf, Http2Headers paramHttp2Headers, Http2HeadersEncoder.SensitivityDetector paramSensitivityDetector)
    throws Http2Exception
  {
    if (this.ignoreMaxHeaderListSize) {
      encodeHeadersIgnoreMaxHeaderListSize(paramByteBuf, paramHttp2Headers, paramSensitivityDetector);
    } else {
      encodeHeadersEnforceMaxHeaderListSize(paramInt, paramByteBuf, paramHttp2Headers, paramSensitivityDetector);
    }
  }
  
  HpackHeaderField getHeaderField(int paramInt)
  {
    HeaderEntry localHeaderEntry = this.head;
    while (paramInt >= 0)
    {
      localHeaderEntry = localHeaderEntry.before;
      paramInt--;
    }
    return localHeaderEntry;
  }
  
  public long getMaxHeaderListSize()
  {
    return this.maxHeaderListSize;
  }
  
  public long getMaxHeaderTableSize()
  {
    return this.maxHeaderTableSize;
  }
  
  int length()
  {
    int i;
    if (this.size == 0L)
    {
      i = 0;
    }
    else
    {
      HeaderEntry localHeaderEntry = this.head;
      i = localHeaderEntry.after.index - localHeaderEntry.before.index + 1;
    }
    return i;
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
  
  public void setMaxHeaderTableSize(ByteBuf paramByteBuf, long paramLong)
    throws Http2Exception
  {
    if ((paramLong >= 0L) && (paramLong <= 4294967295L))
    {
      if (this.maxHeaderTableSize == paramLong) {
        return;
      }
      this.maxHeaderTableSize = paramLong;
      ensureCapacity(0L);
      encodeInteger(paramByteBuf, 32, 5, paramLong);
      return;
    }
    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Header Table Size must be >= %d and <= %d but was %d", new Object[] { Long.valueOf(0L), Long.valueOf(4294967295L), Long.valueOf(paramLong) });
  }
  
  long size()
  {
    return this.size;
  }
  
  private static final class HeaderEntry
    extends HpackHeaderField
  {
    HeaderEntry after;
    HeaderEntry before;
    int hash;
    int index;
    HeaderEntry next;
    
    HeaderEntry(int paramInt1, CharSequence paramCharSequence1, CharSequence paramCharSequence2, int paramInt2, HeaderEntry paramHeaderEntry)
    {
      super(paramCharSequence2);
      this.index = paramInt2;
      this.hash = paramInt1;
      this.next = paramHeaderEntry;
    }
    
    private void addBefore(HeaderEntry paramHeaderEntry)
    {
      this.after = paramHeaderEntry;
      paramHeaderEntry = paramHeaderEntry.before;
      this.before = paramHeaderEntry;
      paramHeaderEntry.after = this;
      this.after.before = this;
    }
    
    private void remove()
    {
      HeaderEntry localHeaderEntry = this.before;
      localHeaderEntry.after = this.after;
      this.after.before = localHeaderEntry;
      this.before = null;
      this.after = null;
      this.next = null;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\HpackEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */