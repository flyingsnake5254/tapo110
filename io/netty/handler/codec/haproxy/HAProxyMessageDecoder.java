package io.netty.handler.codec.haproxy;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.ProtocolDetectionResult;
import io.netty.util.CharsetUtil;
import java.util.List;

public class HAProxyMessageDecoder
  extends ByteToMessageDecoder
{
  private static final int BINARY_PREFIX_LENGTH = HAProxyConstants.BINARY_PREFIX.length;
  private static final ProtocolDetectionResult<HAProxyProtocolVersion> DETECTION_RESULT_V1 = ProtocolDetectionResult.detected(HAProxyProtocolVersion.V1);
  private static final ProtocolDetectionResult<HAProxyProtocolVersion> DETECTION_RESULT_V2 = ProtocolDetectionResult.detected(HAProxyProtocolVersion.V2);
  private static final int V1_MAX_LENGTH = 108;
  private static final int V2_MAX_LENGTH = 65551;
  private static final int V2_MAX_TLV = 65319;
  private static final int V2_MIN_LENGTH = 232;
  private int discardedBytes;
  private boolean discarding;
  private final boolean failFast;
  private boolean finished;
  private HeaderExtractor headerExtractor;
  private final int v2MaxHeaderSize;
  private int version = -1;
  
  public HAProxyMessageDecoder()
  {
    this(true);
  }
  
  public HAProxyMessageDecoder(int paramInt)
  {
    this(paramInt, true);
  }
  
  public HAProxyMessageDecoder(int paramInt, boolean paramBoolean)
  {
    if (paramInt < 1)
    {
      this.v2MaxHeaderSize = 232;
    }
    else if (paramInt > 65319)
    {
      this.v2MaxHeaderSize = 65551;
    }
    else
    {
      paramInt += 232;
      if (paramInt > 65551) {
        this.v2MaxHeaderSize = 65551;
      } else {
        this.v2MaxHeaderSize = paramInt;
      }
    }
    this.failFast = paramBoolean;
  }
  
  public HAProxyMessageDecoder(boolean paramBoolean)
  {
    this.v2MaxHeaderSize = 65551;
    this.failFast = paramBoolean;
  }
  
  private ByteBuf decodeLine(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf)
    throws Exception
  {
    if (this.headerExtractor == null) {
      this.headerExtractor = new LineHeaderExtractor(108);
    }
    return this.headerExtractor.extract(paramChannelHandlerContext, paramByteBuf);
  }
  
  private ByteBuf decodeStruct(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf)
    throws Exception
  {
    if (this.headerExtractor == null) {
      this.headerExtractor = new StructHeaderExtractor(this.v2MaxHeaderSize);
    }
    return this.headerExtractor.extract(paramChannelHandlerContext, paramByteBuf);
  }
  
  public static ProtocolDetectionResult<HAProxyProtocolVersion> detectProtocol(ByteBuf paramByteBuf)
  {
    if (paramByteBuf.readableBytes() < 12) {
      return ProtocolDetectionResult.needsMoreData();
    }
    int i = paramByteBuf.readerIndex();
    if (match(HAProxyConstants.BINARY_PREFIX, paramByteBuf, i)) {
      return DETECTION_RESULT_V2;
    }
    if (match(HAProxyConstants.TEXT_PREFIX, paramByteBuf, i)) {
      return DETECTION_RESULT_V1;
    }
    return ProtocolDetectionResult.invalid();
  }
  
  private void fail(ChannelHandlerContext paramChannelHandlerContext, String paramString, Exception paramException)
  {
    this.finished = true;
    paramChannelHandlerContext.close();
    if ((paramString != null) && (paramException != null)) {
      paramChannelHandlerContext = new HAProxyProtocolException(paramString, paramException);
    } else if (paramString == null)
    {
      if (paramException != null) {
        paramChannelHandlerContext = new HAProxyProtocolException(paramException);
      } else {
        paramChannelHandlerContext = new HAProxyProtocolException();
      }
    }
    else {
      paramChannelHandlerContext = new HAProxyProtocolException(paramString);
    }
    throw paramChannelHandlerContext;
  }
  
  private void failOverLimit(ChannelHandlerContext paramChannelHandlerContext, int paramInt)
  {
    failOverLimit(paramChannelHandlerContext, String.valueOf(paramInt));
  }
  
  private void failOverLimit(ChannelHandlerContext paramChannelHandlerContext, String paramString)
  {
    int i;
    if (this.version == 1) {
      i = 108;
    } else {
      i = this.v2MaxHeaderSize;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("header length (");
    localStringBuilder.append(paramString);
    localStringBuilder.append(") exceeds the allowed maximum (");
    localStringBuilder.append(i);
    localStringBuilder.append(')');
    fail(paramChannelHandlerContext, localStringBuilder.toString(), null);
  }
  
  private static int findEndOfHeader(ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.readableBytes();
    if (i < 16) {
      return -1;
    }
    int j = paramByteBuf.getUnsignedShort(paramByteBuf.readerIndex() + 14) + 16;
    if (i >= j) {
      return j;
    }
    return -1;
  }
  
  private static int findEndOfLine(ByteBuf paramByteBuf)
  {
    int i = paramByteBuf.writerIndex();
    for (int j = paramByteBuf.readerIndex(); j < i; j++) {
      if ((paramByteBuf.getByte(j) == 13) && (j < i - 1) && (paramByteBuf.getByte(j + 1) == 10)) {
        return j;
      }
    }
    return -1;
  }
  
  private static int findVersion(ByteBuf paramByteBuf)
  {
    if (paramByteBuf.readableBytes() < 13) {
      return -1;
    }
    int i = paramByteBuf.readerIndex();
    if (match(HAProxyConstants.BINARY_PREFIX, paramByteBuf, i)) {
      i = paramByteBuf.getByte(i + BINARY_PREFIX_LENGTH);
    } else {
      i = 1;
    }
    return i;
  }
  
  private static boolean match(byte[] paramArrayOfByte, ByteBuf paramByteBuf, int paramInt)
  {
    for (int i = 0; i < paramArrayOfByte.length; i++) {
      if (paramByteBuf.getByte(paramInt + i) != paramArrayOfByte[i]) {
        return false;
      }
    }
    return true;
  }
  
  public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    super.channelRead(paramChannelHandlerContext, paramObject);
    if (this.finished) {
      paramChannelHandlerContext.pipeline().remove(this);
    }
  }
  
  protected final void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    if (this.version == -1)
    {
      int i = findVersion(paramByteBuf);
      this.version = i;
      if (i == -1) {
        return;
      }
    }
    if (this.version == 1) {
      paramByteBuf = decodeLine(paramChannelHandlerContext, paramByteBuf);
    } else {
      paramByteBuf = decodeStruct(paramChannelHandlerContext, paramByteBuf);
    }
    if (paramByteBuf != null)
    {
      this.finished = true;
      try
      {
        if (this.version == 1) {
          paramList.add(HAProxyMessage.decodeHeader(paramByteBuf.toString(CharsetUtil.US_ASCII)));
        } else {
          paramList.add(HAProxyMessage.decodeHeader(paramByteBuf));
        }
      }
      catch (HAProxyProtocolException paramByteBuf)
      {
        fail(paramChannelHandlerContext, null, paramByteBuf);
      }
    }
  }
  
  public boolean isSingleDecode()
  {
    return true;
  }
  
  private abstract class HeaderExtractor
  {
    private final int maxHeaderSize;
    
    protected HeaderExtractor(int paramInt)
    {
      this.maxHeaderSize = paramInt;
    }
    
    protected abstract int delimiterLength(ByteBuf paramByteBuf, int paramInt);
    
    public ByteBuf extract(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf)
      throws Exception
    {
      int i = findEndOfHeader(paramByteBuf);
      int j;
      Object localObject;
      if (!HAProxyMessageDecoder.this.discarding)
      {
        if (i >= 0)
        {
          j = i - paramByteBuf.readerIndex();
          if (j > this.maxHeaderSize)
          {
            paramByteBuf.readerIndex(i + delimiterLength(paramByteBuf, i));
            HAProxyMessageDecoder.this.failOverLimit(paramChannelHandlerContext, j);
            return null;
          }
          paramChannelHandlerContext = paramByteBuf.readSlice(j);
          paramByteBuf.skipBytes(delimiterLength(paramByteBuf, i));
          return paramChannelHandlerContext;
        }
        i = paramByteBuf.readableBytes();
        if (i > this.maxHeaderSize)
        {
          HAProxyMessageDecoder.access$202(HAProxyMessageDecoder.this, i);
          paramByteBuf.skipBytes(i);
          HAProxyMessageDecoder.access$002(HAProxyMessageDecoder.this, true);
          if (HAProxyMessageDecoder.this.failFast)
          {
            paramByteBuf = HAProxyMessageDecoder.this;
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("over ");
            ((StringBuilder)localObject).append(HAProxyMessageDecoder.this.discardedBytes);
            paramByteBuf.failOverLimit(paramChannelHandlerContext, ((StringBuilder)localObject).toString());
          }
        }
        return null;
      }
      if (i >= 0)
      {
        int k = HAProxyMessageDecoder.this.discardedBytes;
        j = paramByteBuf.readerIndex();
        paramByteBuf.readerIndex(i + delimiterLength(paramByteBuf, i));
        HAProxyMessageDecoder.access$202(HAProxyMessageDecoder.this, 0);
        HAProxyMessageDecoder.access$002(HAProxyMessageDecoder.this, false);
        if (!HAProxyMessageDecoder.this.failFast)
        {
          localObject = HAProxyMessageDecoder.this;
          paramByteBuf = new StringBuilder();
          paramByteBuf.append("over ");
          paramByteBuf.append(k + i - j);
          ((HAProxyMessageDecoder)localObject).failOverLimit(paramChannelHandlerContext, paramByteBuf.toString());
        }
      }
      else
      {
        paramChannelHandlerContext = HAProxyMessageDecoder.this;
        HAProxyMessageDecoder.access$202(paramChannelHandlerContext, paramChannelHandlerContext.discardedBytes + paramByteBuf.readableBytes());
        paramByteBuf.skipBytes(paramByteBuf.readableBytes());
      }
      return null;
    }
    
    protected abstract int findEndOfHeader(ByteBuf paramByteBuf);
  }
  
  private final class LineHeaderExtractor
    extends HAProxyMessageDecoder.HeaderExtractor
  {
    LineHeaderExtractor(int paramInt)
    {
      super(paramInt);
    }
    
    protected int delimiterLength(ByteBuf paramByteBuf, int paramInt)
    {
      if (paramByteBuf.getByte(paramInt) == 13) {
        paramInt = 2;
      } else {
        paramInt = 1;
      }
      return paramInt;
    }
    
    protected int findEndOfHeader(ByteBuf paramByteBuf)
    {
      return HAProxyMessageDecoder.findEndOfLine(paramByteBuf);
    }
  }
  
  private final class StructHeaderExtractor
    extends HAProxyMessageDecoder.HeaderExtractor
  {
    StructHeaderExtractor(int paramInt)
    {
      super(paramInt);
    }
    
    protected int delimiterLength(ByteBuf paramByteBuf, int paramInt)
    {
      return 0;
    }
    
    protected int findEndOfHeader(ByteBuf paramByteBuf)
    {
      return HAProxyMessageDecoder.findEndOfHeader(paramByteBuf);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\haproxy\HAProxyMessageDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */