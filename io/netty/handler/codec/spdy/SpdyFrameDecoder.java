package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.ObjectUtil;

public class SpdyFrameDecoder
{
  private final SpdyFrameDecoderDelegate delegate;
  private byte flags;
  private int length;
  private final int maxChunkSize;
  private int numSettings;
  private final int spdyVersion;
  private State state;
  private int streamId;
  
  public SpdyFrameDecoder(SpdyVersion paramSpdyVersion, SpdyFrameDecoderDelegate paramSpdyFrameDecoderDelegate)
  {
    this(paramSpdyVersion, paramSpdyFrameDecoderDelegate, 8192);
  }
  
  public SpdyFrameDecoder(SpdyVersion paramSpdyVersion, SpdyFrameDecoderDelegate paramSpdyFrameDecoderDelegate, int paramInt)
  {
    this.spdyVersion = ((SpdyVersion)ObjectUtil.checkNotNull(paramSpdyVersion, "spdyVersion")).getVersion();
    this.delegate = ((SpdyFrameDecoderDelegate)ObjectUtil.checkNotNull(paramSpdyFrameDecoderDelegate, "delegate"));
    this.maxChunkSize = ObjectUtil.checkPositive(paramInt, "maxChunkSize");
    this.state = State.READ_COMMON_HEADER;
  }
  
  private static State getNextState(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case 5: 
    default: 
      if (paramInt2 != 0) {
        return State.DISCARD_FRAME;
      }
      break;
    case 9: 
      return State.READ_WINDOW_UPDATE_FRAME;
    case 8: 
      return State.READ_HEADERS_FRAME;
    case 7: 
      return State.READ_GOAWAY_FRAME;
    case 6: 
      return State.READ_PING_FRAME;
    case 4: 
      return State.READ_SETTINGS_FRAME;
    case 3: 
      return State.READ_RST_STREAM_FRAME;
    case 2: 
      return State.READ_SYN_REPLY_FRAME;
    case 1: 
      return State.READ_SYN_STREAM_FRAME;
    case 0: 
      return State.READ_DATA_FRAME;
    }
    return State.READ_COMMON_HEADER;
  }
  
  private static boolean hasFlag(byte paramByte1, byte paramByte2)
  {
    boolean bool;
    if ((paramByte1 & paramByte2) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static boolean isValidFrameHeader(int paramInt1, int paramInt2, byte paramByte, int paramInt3)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    boolean bool5 = false;
    boolean bool6 = false;
    boolean bool7 = false;
    boolean bool8 = false;
    boolean bool9 = false;
    switch (paramInt2)
    {
    case 5: 
    default: 
      return true;
    case 9: 
      if (paramInt3 == 8) {
        bool9 = true;
      }
      return bool9;
    case 8: 
      bool9 = bool1;
      if (paramInt3 >= 4) {
        bool9 = true;
      }
      return bool9;
    case 7: 
      bool9 = bool2;
      if (paramInt3 == 8) {
        bool9 = true;
      }
      return bool9;
    case 6: 
      bool9 = bool3;
      if (paramInt3 == 4) {
        bool9 = true;
      }
      return bool9;
    case 4: 
      bool9 = bool4;
      if (paramInt3 >= 4) {
        bool9 = true;
      }
      return bool9;
    case 3: 
      bool9 = bool5;
      if (paramByte == 0)
      {
        bool9 = bool5;
        if (paramInt3 == 8) {
          bool9 = true;
        }
      }
      return bool9;
    case 2: 
      bool9 = bool6;
      if (paramInt3 >= 4) {
        bool9 = true;
      }
      return bool9;
    case 1: 
      bool9 = bool7;
      if (paramInt3 >= 10) {
        bool9 = true;
      }
      return bool9;
    }
    bool9 = bool8;
    if (paramInt1 != 0) {
      bool9 = true;
    }
    return bool9;
  }
  
  public void decode(ByteBuf paramByteBuf)
  {
    for (;;)
    {
      int i = 1.$SwitchMap$io$netty$handler$codec$spdy$SpdyFrameDecoder$State[this.state.ordinal()];
      int j = 0;
      boolean bool1 = false;
      int k = 1;
      ByteBuf localByteBuf;
      boolean bool2;
      byte b;
      switch (i)
      {
      default: 
        throw new Error("Shouldn't reach here.");
      case 14: 
        paramByteBuf.skipBytes(paramByteBuf.readableBytes());
        return;
      case 13: 
        k = Math.min(paramByteBuf.readableBytes(), this.length);
        paramByteBuf.skipBytes(k);
        k = this.length - k;
        this.length = k;
        if (k == 0) {
          this.state = State.READ_COMMON_HEADER;
        } else {
          return;
        }
        break;
      case 12: 
        if (this.length == 0)
        {
          this.state = State.READ_COMMON_HEADER;
          this.delegate.readHeaderBlockEnd();
        }
        else
        {
          if (!paramByteBuf.isReadable()) {
            return;
          }
          k = Math.min(paramByteBuf.readableBytes(), this.length);
          localByteBuf = paramByteBuf.alloc().buffer(k);
          localByteBuf.writeBytes(paramByteBuf, k);
          this.length -= k;
          this.delegate.readHeaderBlock(localByteBuf);
        }
        break;
      case 11: 
        if (paramByteBuf.readableBytes() < 8) {
          return;
        }
        this.streamId = SpdyCodecUtil.getUnsignedInt(paramByteBuf, paramByteBuf.readerIndex());
        k = SpdyCodecUtil.getUnsignedInt(paramByteBuf, paramByteBuf.readerIndex() + 4);
        paramByteBuf.skipBytes(8);
        if (k == 0)
        {
          this.state = State.FRAME_ERROR;
          this.delegate.readFrameError("Invalid WINDOW_UPDATE Frame");
        }
        else
        {
          this.state = State.READ_COMMON_HEADER;
          this.delegate.readWindowUpdateFrame(this.streamId, k);
        }
        break;
      case 10: 
        if (paramByteBuf.readableBytes() < 4) {
          return;
        }
        this.streamId = SpdyCodecUtil.getUnsignedInt(paramByteBuf, paramByteBuf.readerIndex());
        bool2 = hasFlag(this.flags, (byte)1);
        paramByteBuf.skipBytes(4);
        this.length -= 4;
        k = this.streamId;
        if (k == 0)
        {
          this.state = State.FRAME_ERROR;
          this.delegate.readFrameError("Invalid HEADERS Frame");
        }
        else
        {
          this.state = State.READ_HEADER_BLOCK;
          this.delegate.readHeadersFrame(k, bool2);
        }
        break;
      case 9: 
        if (paramByteBuf.readableBytes() < 8) {
          return;
        }
        k = SpdyCodecUtil.getUnsignedInt(paramByteBuf, paramByteBuf.readerIndex());
        i = SpdyCodecUtil.getSignedInt(paramByteBuf, paramByteBuf.readerIndex() + 4);
        paramByteBuf.skipBytes(8);
        this.state = State.READ_COMMON_HEADER;
        this.delegate.readGoAwayFrame(k, i);
        break;
      case 8: 
        if (paramByteBuf.readableBytes() < 4) {
          return;
        }
        k = SpdyCodecUtil.getSignedInt(paramByteBuf, paramByteBuf.readerIndex());
        paramByteBuf.skipBytes(4);
        this.state = State.READ_COMMON_HEADER;
        this.delegate.readPingFrame(k);
        break;
      case 7: 
        if (this.numSettings == 0)
        {
          this.state = State.READ_COMMON_HEADER;
          this.delegate.readSettingsEnd();
        }
        else
        {
          if (paramByteBuf.readableBytes() < 8) {
            return;
          }
          b = paramByteBuf.getByte(paramByteBuf.readerIndex());
          i = SpdyCodecUtil.getUnsignedMedium(paramByteBuf, paramByteBuf.readerIndex() + 1);
          k = SpdyCodecUtil.getSignedInt(paramByteBuf, paramByteBuf.readerIndex() + 4);
          bool2 = hasFlag(b, (byte)1);
          bool1 = hasFlag(b, (byte)2);
          paramByteBuf.skipBytes(8);
          this.numSettings -= 1;
          this.delegate.readSetting(i, k, bool2, bool1);
        }
        break;
      case 6: 
        if (paramByteBuf.readableBytes() < 4) {
          return;
        }
        bool2 = hasFlag(this.flags, (byte)1);
        this.numSettings = SpdyCodecUtil.getUnsignedInt(paramByteBuf, paramByteBuf.readerIndex());
        paramByteBuf.skipBytes(4);
        k = this.length - 4;
        this.length = k;
        if (((k & 0x7) == 0) && (k >> 3 == this.numSettings))
        {
          this.state = State.READ_SETTING;
          this.delegate.readSettingsFrame(bool2);
        }
        else
        {
          this.state = State.FRAME_ERROR;
          this.delegate.readFrameError("Invalid SETTINGS Frame");
        }
        break;
      case 5: 
        if (paramByteBuf.readableBytes() < 8) {
          return;
        }
        this.streamId = SpdyCodecUtil.getUnsignedInt(paramByteBuf, paramByteBuf.readerIndex());
        k = SpdyCodecUtil.getSignedInt(paramByteBuf, paramByteBuf.readerIndex() + 4);
        paramByteBuf.skipBytes(8);
        i = this.streamId;
        if ((i != 0) && (k != 0))
        {
          this.state = State.READ_COMMON_HEADER;
          this.delegate.readRstStreamFrame(i, k);
        }
        else
        {
          this.state = State.FRAME_ERROR;
          this.delegate.readFrameError("Invalid RST_STREAM Frame");
        }
        break;
      case 4: 
        if (paramByteBuf.readableBytes() < 4) {
          return;
        }
        this.streamId = SpdyCodecUtil.getUnsignedInt(paramByteBuf, paramByteBuf.readerIndex());
        bool2 = hasFlag(this.flags, (byte)1);
        paramByteBuf.skipBytes(4);
        this.length -= 4;
        k = this.streamId;
        if (k == 0)
        {
          this.state = State.FRAME_ERROR;
          this.delegate.readFrameError("Invalid SYN_REPLY Frame");
        }
        else
        {
          this.state = State.READ_HEADER_BLOCK;
          this.delegate.readSynReplyFrame(k, bool2);
        }
        break;
      case 3: 
        if (paramByteBuf.readableBytes() < 10) {
          return;
        }
        i = paramByteBuf.readerIndex();
        this.streamId = SpdyCodecUtil.getUnsignedInt(paramByteBuf, i);
        k = SpdyCodecUtil.getUnsignedInt(paramByteBuf, i + 4);
        b = (byte)(paramByteBuf.getByte(i + 8) >> 5 & 0x7);
        bool2 = hasFlag(this.flags, (byte)1);
        bool1 = hasFlag(this.flags, (byte)2);
        paramByteBuf.skipBytes(10);
        this.length -= 10;
        i = this.streamId;
        if (i == 0)
        {
          this.state = State.FRAME_ERROR;
          this.delegate.readFrameError("Invalid SYN_STREAM Frame");
        }
        else
        {
          this.state = State.READ_HEADER_BLOCK;
          this.delegate.readSynStreamFrame(i, k, b, bool2, bool1);
        }
        break;
      case 2: 
        k = this.length;
        if (k == 0)
        {
          this.state = State.READ_COMMON_HEADER;
          this.delegate.readDataFrame(this.streamId, hasFlag(this.flags, (byte)1), Unpooled.buffer(0));
        }
        else
        {
          k = Math.min(this.maxChunkSize, k);
          if (paramByteBuf.readableBytes() < k) {
            return;
          }
          localByteBuf = paramByteBuf.alloc().buffer(k);
          localByteBuf.writeBytes(paramByteBuf, k);
          k = this.length - k;
          this.length = k;
          if (k == 0) {
            this.state = State.READ_COMMON_HEADER;
          }
          bool2 = bool1;
          if (k == 0)
          {
            bool2 = bool1;
            if (hasFlag(this.flags, (byte)1)) {
              bool2 = true;
            }
          }
          this.delegate.readDataFrame(this.streamId, bool2, localByteBuf);
        }
        break;
      case 1: 
        if (paramByteBuf.readableBytes() < 8) {
          return;
        }
        int m = paramByteBuf.readerIndex();
        paramByteBuf.skipBytes(8);
        if ((paramByteBuf.getByte(m) & 0x80) == 0) {
          k = 0;
        }
        if (k != 0)
        {
          i = SpdyCodecUtil.getUnsignedShort(paramByteBuf, m) & 0x7FFF;
          k = SpdyCodecUtil.getUnsignedShort(paramByteBuf, m + 2);
          this.streamId = 0;
        }
        else
        {
          i = this.spdyVersion;
          this.streamId = SpdyCodecUtil.getUnsignedInt(paramByteBuf, m);
          k = j;
        }
        this.flags = paramByteBuf.getByte(m + 4);
        j = SpdyCodecUtil.getUnsignedMedium(paramByteBuf, m + 5);
        this.length = j;
        if (i != this.spdyVersion)
        {
          this.state = State.FRAME_ERROR;
          this.delegate.readFrameError("Invalid SPDY Version");
        }
        else if (!isValidFrameHeader(this.streamId, k, this.flags, j))
        {
          this.state = State.FRAME_ERROR;
          this.delegate.readFrameError("Invalid Frame Error");
        }
        else
        {
          this.state = getNextState(k, this.length);
        }
        break;
      }
    }
  }
  
  private static enum State
  {
    static
    {
      State localState1 = new State("READ_COMMON_HEADER", 0);
      READ_COMMON_HEADER = localState1;
      State localState2 = new State("READ_DATA_FRAME", 1);
      READ_DATA_FRAME = localState2;
      State localState3 = new State("READ_SYN_STREAM_FRAME", 2);
      READ_SYN_STREAM_FRAME = localState3;
      State localState4 = new State("READ_SYN_REPLY_FRAME", 3);
      READ_SYN_REPLY_FRAME = localState4;
      State localState5 = new State("READ_RST_STREAM_FRAME", 4);
      READ_RST_STREAM_FRAME = localState5;
      State localState6 = new State("READ_SETTINGS_FRAME", 5);
      READ_SETTINGS_FRAME = localState6;
      State localState7 = new State("READ_SETTING", 6);
      READ_SETTING = localState7;
      State localState8 = new State("READ_PING_FRAME", 7);
      READ_PING_FRAME = localState8;
      State localState9 = new State("READ_GOAWAY_FRAME", 8);
      READ_GOAWAY_FRAME = localState9;
      State localState10 = new State("READ_HEADERS_FRAME", 9);
      READ_HEADERS_FRAME = localState10;
      State localState11 = new State("READ_WINDOW_UPDATE_FRAME", 10);
      READ_WINDOW_UPDATE_FRAME = localState11;
      State localState12 = new State("READ_HEADER_BLOCK", 11);
      READ_HEADER_BLOCK = localState12;
      State localState13 = new State("DISCARD_FRAME", 12);
      DISCARD_FRAME = localState13;
      State localState14 = new State("FRAME_ERROR", 13);
      FRAME_ERROR = localState14;
      $VALUES = new State[] { localState1, localState2, localState3, localState4, localState5, localState6, localState7, localState8, localState9, localState10, localState11, localState12, localState13, localState14 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdyFrameDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */