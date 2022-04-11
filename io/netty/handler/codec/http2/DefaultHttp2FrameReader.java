package io.netty.handler.codec.http2;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.PlatformDependent;

public class DefaultHttp2FrameReader
  implements Http2FrameReader, Http2FrameSizePolicy, Http2FrameReader.Configuration
{
  private Http2Flags flags;
  private byte frameType;
  private HeadersContinuation headersContinuation;
  private final Http2HeadersDecoder headersDecoder;
  private int maxFrameSize;
  private int payloadLength;
  private boolean readError;
  private boolean readingHeaders = true;
  private int streamId;
  
  public DefaultHttp2FrameReader()
  {
    this(true);
  }
  
  public DefaultHttp2FrameReader(Http2HeadersDecoder paramHttp2HeadersDecoder)
  {
    this.headersDecoder = paramHttp2HeadersDecoder;
    this.maxFrameSize = 16384;
  }
  
  public DefaultHttp2FrameReader(boolean paramBoolean)
  {
    this(new DefaultHttp2HeadersDecoder(paramBoolean));
  }
  
  private void closeHeadersContinuation()
  {
    HeadersContinuation localHeadersContinuation = this.headersContinuation;
    if (localHeadersContinuation != null)
    {
      localHeadersContinuation.close();
      this.headersContinuation = null;
    }
  }
  
  private static int lengthWithoutTrailingPadding(int paramInt1, int paramInt2)
  {
    if (paramInt2 != 0) {
      paramInt1 -= paramInt2 - 1;
    }
    return paramInt1;
  }
  
  private void processHeaderState(ByteBuf paramByteBuf)
    throws Http2Exception
  {
    if (paramByteBuf.readableBytes() < 9) {
      return;
    }
    int i = paramByteBuf.readUnsignedMedium();
    this.payloadLength = i;
    if (i <= this.maxFrameSize)
    {
      this.frameType = paramByteBuf.readByte();
      this.flags = new Http2Flags(paramByteBuf.readUnsignedByte());
      this.streamId = Http2CodecUtil.readUnsignedInt(paramByteBuf);
      this.readingHeaders = false;
      switch (this.frameType)
      {
      default: 
        verifyUnknownFrame();
        break;
      case 9: 
        verifyContinuationFrame();
        break;
      case 8: 
        verifyWindowUpdateFrame();
        break;
      case 7: 
        verifyGoAwayFrame();
        break;
      case 6: 
        verifyPingFrame();
        break;
      case 5: 
        verifyPushPromiseFrame();
        break;
      case 4: 
        verifySettingsFrame();
        break;
      case 3: 
        verifyRstStreamFrame();
        break;
      case 2: 
        verifyPriorityFrame();
        break;
      case 1: 
        verifyHeadersFrame();
        break;
      case 0: 
        verifyDataFrame();
      }
      return;
    }
    throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Frame length: %d exceeds maximum: %d", new Object[] { Integer.valueOf(i), Integer.valueOf(this.maxFrameSize) });
  }
  
  private void processPayloadState(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, Http2FrameListener paramHttp2FrameListener)
    throws Http2Exception
  {
    if (paramByteBuf.readableBytes() < this.payloadLength) {
      return;
    }
    int i = paramByteBuf.readerIndex() + this.payloadLength;
    this.readingHeaders = true;
    switch (this.frameType)
    {
    default: 
      readUnknownFrame(paramChannelHandlerContext, paramByteBuf, i, paramHttp2FrameListener);
      break;
    case 9: 
      readContinuationFrame(paramByteBuf, i, paramHttp2FrameListener);
      break;
    case 8: 
      readWindowUpdateFrame(paramChannelHandlerContext, paramByteBuf, paramHttp2FrameListener);
      break;
    case 7: 
      readGoAwayFrame(paramChannelHandlerContext, paramByteBuf, i, paramHttp2FrameListener);
      break;
    case 6: 
      readPingFrame(paramChannelHandlerContext, paramByteBuf.readLong(), paramHttp2FrameListener);
      break;
    case 5: 
      readPushPromiseFrame(paramChannelHandlerContext, paramByteBuf, i, paramHttp2FrameListener);
      break;
    case 4: 
      readSettingsFrame(paramChannelHandlerContext, paramByteBuf, paramHttp2FrameListener);
      break;
    case 3: 
      readRstStreamFrame(paramChannelHandlerContext, paramByteBuf, paramHttp2FrameListener);
      break;
    case 2: 
      readPriorityFrame(paramChannelHandlerContext, paramByteBuf, paramHttp2FrameListener);
      break;
    case 1: 
      readHeadersFrame(paramChannelHandlerContext, paramByteBuf, i, paramHttp2FrameListener);
      break;
    case 0: 
      readDataFrame(paramChannelHandlerContext, paramByteBuf, i, paramHttp2FrameListener);
    }
    paramByteBuf.readerIndex(i);
  }
  
  private void readContinuationFrame(ByteBuf paramByteBuf, int paramInt, Http2FrameListener paramHttp2FrameListener)
    throws Http2Exception
  {
    this.headersContinuation.processFragment(this.flags.endOfHeaders(), paramByteBuf, paramInt - paramByteBuf.readerIndex(), paramHttp2FrameListener);
    resetHeadersContinuationIfEnd(this.flags.endOfHeaders());
  }
  
  private void readDataFrame(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, int paramInt, Http2FrameListener paramHttp2FrameListener)
    throws Http2Exception
  {
    int i = readPadding(paramByteBuf);
    verifyPadding(i);
    paramByteBuf = paramByteBuf.readSlice(lengthWithoutTrailingPadding(paramInt - paramByteBuf.readerIndex(), i));
    paramHttp2FrameListener.onDataRead(paramChannelHandlerContext, this.streamId, paramByteBuf, i, this.flags.endOfStream());
  }
  
  private static void readGoAwayFrame(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, int paramInt, Http2FrameListener paramHttp2FrameListener)
    throws Http2Exception
  {
    paramHttp2FrameListener.onGoAwayRead(paramChannelHandlerContext, Http2CodecUtil.readUnsignedInt(paramByteBuf), paramByteBuf.readUnsignedInt(), paramByteBuf.readSlice(paramInt - paramByteBuf.readerIndex()));
  }
  
  private void readHeadersFrame(final ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, int paramInt, Http2FrameListener paramHttp2FrameListener)
    throws Http2Exception
  {
    final int i = this.streamId;
    final Http2Flags localHttp2Flags = this.flags;
    final int j = readPadding(paramByteBuf);
    verifyPadding(j);
    if (this.flags.priorityPresent())
    {
      long l = paramByteBuf.readUnsignedInt();
      final boolean bool;
      if ((0x80000000 & l) != 0L) {
        bool = true;
      } else {
        bool = false;
      }
      final int k = (int)(l & 0x7FFFFFFF);
      int m = this.streamId;
      if (k != m)
      {
        short s = (short)(paramByteBuf.readUnsignedByte() + 1);
        paramInt = lengthWithoutTrailingPadding(paramInt - paramByteBuf.readerIndex(), j);
        paramChannelHandlerContext = new HeadersContinuation(i, paramChannelHandlerContext)
        {
          public int getStreamId()
          {
            return i;
          }
          
          public void processFragment(boolean paramAnonymousBoolean, ByteBuf paramAnonymousByteBuf, int paramAnonymousInt, Http2FrameListener paramAnonymousHttp2FrameListener)
            throws Http2Exception
          {
            DefaultHttp2FrameReader.HeadersBlockBuilder localHeadersBlockBuilder = headersBlockBuilder();
            localHeadersBlockBuilder.addFragment(paramAnonymousByteBuf, paramAnonymousInt, paramChannelHandlerContext.alloc(), paramAnonymousBoolean);
            if (paramAnonymousBoolean) {
              paramAnonymousHttp2FrameListener.onHeadersRead(paramChannelHandlerContext, i, localHeadersBlockBuilder.headers(), k, this.val$weight, bool, j, localHttp2Flags.endOfStream());
            }
          }
        };
        this.headersContinuation = paramChannelHandlerContext;
        paramChannelHandlerContext.processFragment(this.flags.endOfHeaders(), paramByteBuf, paramInt, paramHttp2FrameListener);
        resetHeadersContinuationIfEnd(this.flags.endOfHeaders());
        return;
      }
      throw Http2Exception.streamError(m, Http2Error.PROTOCOL_ERROR, "A stream cannot depend on itself.", new Object[0]);
    }
    this.headersContinuation = new HeadersContinuation(i, paramChannelHandlerContext)
    {
      public int getStreamId()
      {
        return i;
      }
      
      public void processFragment(boolean paramAnonymousBoolean, ByteBuf paramAnonymousByteBuf, int paramAnonymousInt, Http2FrameListener paramAnonymousHttp2FrameListener)
        throws Http2Exception
      {
        DefaultHttp2FrameReader.HeadersBlockBuilder localHeadersBlockBuilder = headersBlockBuilder();
        localHeadersBlockBuilder.addFragment(paramAnonymousByteBuf, paramAnonymousInt, paramChannelHandlerContext.alloc(), paramAnonymousBoolean);
        if (paramAnonymousBoolean) {
          paramAnonymousHttp2FrameListener.onHeadersRead(paramChannelHandlerContext, i, localHeadersBlockBuilder.headers(), j, localHttp2Flags.endOfStream());
        }
      }
    };
    paramInt = lengthWithoutTrailingPadding(paramInt - paramByteBuf.readerIndex(), j);
    this.headersContinuation.processFragment(this.flags.endOfHeaders(), paramByteBuf, paramInt, paramHttp2FrameListener);
    resetHeadersContinuationIfEnd(this.flags.endOfHeaders());
  }
  
  private int readPadding(ByteBuf paramByteBuf)
  {
    if (!this.flags.paddingPresent()) {
      return 0;
    }
    return paramByteBuf.readUnsignedByte() + 1;
  }
  
  private void readPingFrame(ChannelHandlerContext paramChannelHandlerContext, long paramLong, Http2FrameListener paramHttp2FrameListener)
    throws Http2Exception
  {
    if (this.flags.ack()) {
      paramHttp2FrameListener.onPingAckRead(paramChannelHandlerContext, paramLong);
    } else {
      paramHttp2FrameListener.onPingRead(paramChannelHandlerContext, paramLong);
    }
  }
  
  private void readPriorityFrame(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, Http2FrameListener paramHttp2FrameListener)
    throws Http2Exception
  {
    long l = paramByteBuf.readUnsignedInt();
    boolean bool;
    if ((0x80000000 & l) != 0L) {
      bool = true;
    } else {
      bool = false;
    }
    int i = (int)(l & 0x7FFFFFFF);
    int j = this.streamId;
    if (i != j)
    {
      short s = (short)(paramByteBuf.readUnsignedByte() + 1);
      paramHttp2FrameListener.onPriorityRead(paramChannelHandlerContext, this.streamId, i, s, bool);
      return;
    }
    throw Http2Exception.streamError(j, Http2Error.PROTOCOL_ERROR, "A stream cannot depend on itself.", new Object[0]);
  }
  
  private void readPushPromiseFrame(final ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, int paramInt, Http2FrameListener paramHttp2FrameListener)
    throws Http2Exception
  {
    final int i = this.streamId;
    final int j = readPadding(paramByteBuf);
    verifyPadding(j);
    this.headersContinuation = new HeadersContinuation(i, paramChannelHandlerContext)
    {
      public int getStreamId()
      {
        return i;
      }
      
      public void processFragment(boolean paramAnonymousBoolean, ByteBuf paramAnonymousByteBuf, int paramAnonymousInt, Http2FrameListener paramAnonymousHttp2FrameListener)
        throws Http2Exception
      {
        headersBlockBuilder().addFragment(paramAnonymousByteBuf, paramAnonymousInt, paramChannelHandlerContext.alloc(), paramAnonymousBoolean);
        if (paramAnonymousBoolean) {
          paramAnonymousHttp2FrameListener.onPushPromiseRead(paramChannelHandlerContext, i, this.val$promisedStreamId, headersBlockBuilder().headers(), j);
        }
      }
    };
    paramInt = lengthWithoutTrailingPadding(paramInt - paramByteBuf.readerIndex(), j);
    this.headersContinuation.processFragment(this.flags.endOfHeaders(), paramByteBuf, paramInt, paramHttp2FrameListener);
    resetHeadersContinuationIfEnd(this.flags.endOfHeaders());
  }
  
  private void readRstStreamFrame(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, Http2FrameListener paramHttp2FrameListener)
    throws Http2Exception
  {
    long l = paramByteBuf.readUnsignedInt();
    paramHttp2FrameListener.onRstStreamRead(paramChannelHandlerContext, this.streamId, l);
  }
  
  private void readSettingsFrame(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, Http2FrameListener paramHttp2FrameListener)
    throws Http2Exception
  {
    if (this.flags.ack())
    {
      paramHttp2FrameListener.onSettingsAckRead(paramChannelHandlerContext);
    }
    else
    {
      int i = this.payloadLength / 6;
      Http2Settings localHttp2Settings = new Http2Settings();
      int j = 0;
      while (j < i)
      {
        char c = (char)paramByteBuf.readUnsignedShort();
        long l = paramByteBuf.readUnsignedInt();
        try
        {
          localHttp2Settings.put(c, Long.valueOf(l));
          j++;
        }
        catch (IllegalArgumentException paramChannelHandlerContext)
        {
          if (c != '\004')
          {
            if (c != '\005') {
              throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, paramChannelHandlerContext, paramChannelHandlerContext.getMessage(), new Object[0]);
            }
            throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, paramChannelHandlerContext, paramChannelHandlerContext.getMessage(), new Object[0]);
          }
          throw Http2Exception.connectionError(Http2Error.FLOW_CONTROL_ERROR, paramChannelHandlerContext, paramChannelHandlerContext.getMessage(), new Object[0]);
        }
      }
      paramHttp2FrameListener.onSettingsRead(paramChannelHandlerContext, localHttp2Settings);
    }
  }
  
  private void readUnknownFrame(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, int paramInt, Http2FrameListener paramHttp2FrameListener)
    throws Http2Exception
  {
    paramByteBuf = paramByteBuf.readSlice(paramInt - paramByteBuf.readerIndex());
    paramHttp2FrameListener.onUnknownFrame(paramChannelHandlerContext, this.frameType, this.streamId, this.flags, paramByteBuf);
  }
  
  private void readWindowUpdateFrame(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, Http2FrameListener paramHttp2FrameListener)
    throws Http2Exception
  {
    int i = Http2CodecUtil.readUnsignedInt(paramByteBuf);
    if (i != 0)
    {
      paramHttp2FrameListener.onWindowUpdateRead(paramChannelHandlerContext, this.streamId, i);
      return;
    }
    i = this.streamId;
    throw Http2Exception.streamError(i, Http2Error.PROTOCOL_ERROR, "Received WINDOW_UPDATE with delta 0 for stream: %d", new Object[] { Integer.valueOf(i) });
  }
  
  private void resetHeadersContinuationIfEnd(boolean paramBoolean)
  {
    if (paramBoolean) {
      closeHeadersContinuation();
    }
  }
  
  private void verifyAssociatedWithAStream()
    throws Http2Exception
  {
    if (this.streamId != 0) {
      return;
    }
    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Frame of type %s must be associated with a stream.", new Object[] { Byte.valueOf(this.frameType) });
  }
  
  private void verifyContinuationFrame()
    throws Http2Exception
  {
    verifyAssociatedWithAStream();
    verifyPayloadLength(this.payloadLength);
    HeadersContinuation localHeadersContinuation = this.headersContinuation;
    if (localHeadersContinuation != null)
    {
      if (this.streamId == localHeadersContinuation.getStreamId())
      {
        if (this.payloadLength >= this.flags.getPaddingPresenceFieldLength()) {
          return;
        }
        throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Frame length %d too small for padding.", new Object[] { Integer.valueOf(this.payloadLength) });
      }
      throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Continuation stream ID does not match pending headers. Expected %d, but received %d.", new Object[] { Integer.valueOf(this.headersContinuation.getStreamId()), Integer.valueOf(this.streamId) });
    }
    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Received %s frame but not currently processing headers.", new Object[] { Byte.valueOf(this.frameType) });
  }
  
  private void verifyDataFrame()
    throws Http2Exception
  {
    verifyAssociatedWithAStream();
    verifyNotProcessingHeaders();
    verifyPayloadLength(this.payloadLength);
    if (this.payloadLength >= this.flags.getPaddingPresenceFieldLength()) {
      return;
    }
    throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Frame length %d too small.", new Object[] { Integer.valueOf(this.payloadLength) });
  }
  
  private void verifyGoAwayFrame()
    throws Http2Exception
  {
    verifyNotProcessingHeaders();
    verifyPayloadLength(this.payloadLength);
    if (this.streamId == 0)
    {
      int i = this.payloadLength;
      if (i >= 8) {
        return;
      }
      throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Frame length %d too small.", new Object[] { Integer.valueOf(i) });
    }
    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "A stream ID must be zero.", new Object[0]);
  }
  
  private void verifyHeadersFrame()
    throws Http2Exception
  {
    verifyAssociatedWithAStream();
    verifyNotProcessingHeaders();
    verifyPayloadLength(this.payloadLength);
    int i = this.flags.getPaddingPresenceFieldLength();
    int j = this.flags.getNumPriorityBytes();
    if (this.payloadLength >= i + j) {
      return;
    }
    i = this.streamId;
    Http2Error localHttp2Error = Http2Error.FRAME_SIZE_ERROR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Frame length too small.");
    localStringBuilder.append(this.payloadLength);
    throw Http2Exception.streamError(i, localHttp2Error, localStringBuilder.toString(), new Object[0]);
  }
  
  private void verifyNotProcessingHeaders()
    throws Http2Exception
  {
    if (this.headersContinuation == null) {
      return;
    }
    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Received frame of type %s while processing headers on stream %d.", new Object[] { Byte.valueOf(this.frameType), Integer.valueOf(this.headersContinuation.getStreamId()) });
  }
  
  private void verifyPadding(int paramInt)
    throws Http2Exception
  {
    if (lengthWithoutTrailingPadding(this.payloadLength, paramInt) >= 0) {
      return;
    }
    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Frame payload too small for padding.", new Object[0]);
  }
  
  private void verifyPayloadLength(int paramInt)
    throws Http2Exception
  {
    if (paramInt <= this.maxFrameSize) {
      return;
    }
    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "Total payload length %d exceeds max frame length.", new Object[] { Integer.valueOf(paramInt) });
  }
  
  private void verifyPingFrame()
    throws Http2Exception
  {
    verifyNotProcessingHeaders();
    if (this.streamId == 0)
    {
      int i = this.payloadLength;
      if (i == 8) {
        return;
      }
      throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Frame length %d incorrect size for ping.", new Object[] { Integer.valueOf(i) });
    }
    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "A stream ID must be zero.", new Object[0]);
  }
  
  private void verifyPriorityFrame()
    throws Http2Exception
  {
    verifyAssociatedWithAStream();
    verifyNotProcessingHeaders();
    int i = this.payloadLength;
    if (i == 5) {
      return;
    }
    throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Invalid frame length %d.", new Object[] { Integer.valueOf(i) });
  }
  
  private void verifyPushPromiseFrame()
    throws Http2Exception
  {
    verifyNotProcessingHeaders();
    verifyPayloadLength(this.payloadLength);
    int i = this.flags.getPaddingPresenceFieldLength();
    int j = this.payloadLength;
    if (j >= i + 4) {
      return;
    }
    throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Frame length %d too small.", new Object[] { Integer.valueOf(j) });
  }
  
  private void verifyRstStreamFrame()
    throws Http2Exception
  {
    verifyAssociatedWithAStream();
    verifyNotProcessingHeaders();
    int i = this.payloadLength;
    if (i == 4) {
      return;
    }
    throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Invalid frame length %d.", new Object[] { Integer.valueOf(i) });
  }
  
  private void verifySettingsFrame()
    throws Http2Exception
  {
    verifyNotProcessingHeaders();
    verifyPayloadLength(this.payloadLength);
    if (this.streamId == 0)
    {
      if ((this.flags.ack()) && (this.payloadLength > 0)) {
        throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Ack settings frame must have an empty payload.", new Object[0]);
      }
      int i = this.payloadLength;
      if (i % 6 <= 0) {
        return;
      }
      throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Frame length %d invalid.", new Object[] { Integer.valueOf(i) });
    }
    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "A stream ID must be zero.", new Object[0]);
  }
  
  private static void verifyStreamOrConnectionId(int paramInt, String paramString)
    throws Http2Exception
  {
    if (paramInt >= 0) {
      return;
    }
    throw Http2Exception.connectionError(Http2Error.PROTOCOL_ERROR, "%s must be >= 0", new Object[] { paramString });
  }
  
  private void verifyUnknownFrame()
    throws Http2Exception
  {
    verifyNotProcessingHeaders();
  }
  
  private void verifyWindowUpdateFrame()
    throws Http2Exception
  {
    verifyNotProcessingHeaders();
    verifyStreamOrConnectionId(this.streamId, "Stream ID");
    int i = this.payloadLength;
    if (i == 4) {
      return;
    }
    throw Http2Exception.connectionError(Http2Error.FRAME_SIZE_ERROR, "Invalid frame length %d.", new Object[] { Integer.valueOf(i) });
  }
  
  public void close()
  {
    closeHeadersContinuation();
  }
  
  public Http2FrameReader.Configuration configuration()
  {
    return this;
  }
  
  public Http2FrameSizePolicy frameSizePolicy()
  {
    return this;
  }
  
  public Http2HeadersDecoder.Configuration headersConfiguration()
  {
    return this.headersDecoder.configuration();
  }
  
  public int maxFrameSize()
  {
    return this.maxFrameSize;
  }
  
  public void maxFrameSize(int paramInt)
    throws Http2Exception
  {
    if (Http2CodecUtil.isMaxFrameSizeValid(paramInt))
    {
      this.maxFrameSize = paramInt;
      return;
    }
    throw Http2Exception.streamError(this.streamId, Http2Error.FRAME_SIZE_ERROR, "Invalid MAX_FRAME_SIZE specified in sent settings: %d", new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void readFrame(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, Http2FrameListener paramHttp2FrameListener)
    throws Http2Exception
  {
    if (this.readError)
    {
      paramByteBuf.skipBytes(paramByteBuf.readableBytes());
      return;
    }
    try
    {
      try
      {
        boolean bool;
        do
        {
          if (this.readingHeaders)
          {
            processHeaderState(paramByteBuf);
            if (this.readingHeaders) {
              return;
            }
          }
          processPayloadState(paramChannelHandlerContext, paramByteBuf, paramHttp2FrameListener);
          if (!this.readingHeaders) {
            return;
          }
          bool = paramByteBuf.isReadable();
        } while (bool);
      }
      finally
      {
        this.readError = true;
        PlatformDependent.throwException(paramChannelHandlerContext);
      }
      return;
    }
    catch (RuntimeException paramChannelHandlerContext)
    {
      this.readError = true;
      throw paramChannelHandlerContext;
    }
    catch (Http2Exception paramChannelHandlerContext)
    {
      this.readError = (Http2Exception.isStreamError(paramChannelHandlerContext) ^ true);
      throw paramChannelHandlerContext;
    }
  }
  
  protected class HeadersBlockBuilder
  {
    private ByteBuf headerBlock;
    
    protected HeadersBlockBuilder() {}
    
    private void headerSizeExceeded()
      throws Http2Exception
    {
      close();
      Http2CodecUtil.headerListSizeExceeded(DefaultHttp2FrameReader.this.headersDecoder.configuration().maxHeaderListSizeGoAway());
    }
    
    final void addFragment(ByteBuf paramByteBuf, int paramInt, ByteBufAllocator paramByteBufAllocator, boolean paramBoolean)
      throws Http2Exception
    {
      if (this.headerBlock == null)
      {
        if (paramInt > DefaultHttp2FrameReader.this.headersDecoder.configuration().maxHeaderListSizeGoAway()) {
          headerSizeExceeded();
        }
        if (paramBoolean) {
          this.headerBlock = paramByteBuf.readRetainedSlice(paramInt);
        } else {
          this.headerBlock = paramByteBufAllocator.buffer(paramInt).writeBytes(paramByteBuf, paramInt);
        }
        return;
      }
      if (DefaultHttp2FrameReader.this.headersDecoder.configuration().maxHeaderListSizeGoAway() - paramInt < this.headerBlock.readableBytes()) {
        headerSizeExceeded();
      }
      if (this.headerBlock.isWritable(paramInt))
      {
        this.headerBlock.writeBytes(paramByteBuf, paramInt);
      }
      else
      {
        paramByteBufAllocator = paramByteBufAllocator.buffer(this.headerBlock.readableBytes() + paramInt);
        paramByteBufAllocator.writeBytes(this.headerBlock).writeBytes(paramByteBuf, paramInt);
        this.headerBlock.release();
        this.headerBlock = paramByteBufAllocator;
      }
    }
    
    void close()
    {
      ByteBuf localByteBuf = this.headerBlock;
      if (localByteBuf != null)
      {
        localByteBuf.release();
        this.headerBlock = null;
      }
      DefaultHttp2FrameReader.access$302(DefaultHttp2FrameReader.this, null);
    }
    
    Http2Headers headers()
      throws Http2Exception
    {
      try
      {
        Http2Headers localHttp2Headers = DefaultHttp2FrameReader.this.headersDecoder.decodeHeaders(DefaultHttp2FrameReader.this.streamId, this.headerBlock);
        return localHttp2Headers;
      }
      finally
      {
        close();
      }
    }
  }
  
  private abstract class HeadersContinuation
  {
    private final DefaultHttp2FrameReader.HeadersBlockBuilder builder = new DefaultHttp2FrameReader.HeadersBlockBuilder(DefaultHttp2FrameReader.this);
    
    private HeadersContinuation() {}
    
    final void close()
    {
      this.builder.close();
    }
    
    abstract int getStreamId();
    
    final DefaultHttp2FrameReader.HeadersBlockBuilder headersBlockBuilder()
    {
      return this.builder;
    }
    
    abstract void processFragment(boolean paramBoolean, ByteBuf paramByteBuf, int paramInt, Http2FrameListener paramHttp2FrameListener)
      throws Http2Exception;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\DefaultHttp2FrameReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */