package io.netty.handler.codec.spdy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.handler.codec.Headers;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;

public class SpdyHeaderBlockRawDecoder
  extends SpdyHeaderBlockDecoder
{
  private static final int LENGTH_FIELD_SIZE = 4;
  private ByteBuf cumulation;
  private int headerSize;
  private int length;
  private final int maxHeaderSize;
  private String name;
  private int numHeaders;
  private State state;
  
  public SpdyHeaderBlockRawDecoder(SpdyVersion paramSpdyVersion, int paramInt)
  {
    ObjectUtil.checkNotNull(paramSpdyVersion, "spdyVersion");
    this.maxHeaderSize = paramInt;
    this.state = State.READ_NUM_HEADERS;
  }
  
  private static int readLengthField(ByteBuf paramByteBuf)
  {
    int i = SpdyCodecUtil.getSignedInt(paramByteBuf, paramByteBuf.readerIndex());
    paramByteBuf.skipBytes(4);
    return i;
  }
  
  private void releaseBuffer()
  {
    ByteBuf localByteBuf = this.cumulation;
    if (localByteBuf != null)
    {
      localByteBuf.release();
      this.cumulation = null;
    }
  }
  
  void decode(ByteBufAllocator paramByteBufAllocator, ByteBuf paramByteBuf, SpdyHeadersFrame paramSpdyHeadersFrame)
    throws Exception
  {
    ObjectUtil.checkNotNull(paramByteBuf, "headerBlock");
    ObjectUtil.checkNotNull(paramSpdyHeadersFrame, "frame");
    ByteBuf localByteBuf = this.cumulation;
    if (localByteBuf == null)
    {
      decodeHeaderBlock(paramByteBuf, paramSpdyHeadersFrame);
      if (paramByteBuf.isReadable())
      {
        paramByteBufAllocator = paramByteBufAllocator.buffer(paramByteBuf.readableBytes());
        this.cumulation = paramByteBufAllocator;
        paramByteBufAllocator.writeBytes(paramByteBuf);
      }
    }
    else
    {
      localByteBuf.writeBytes(paramByteBuf);
      decodeHeaderBlock(this.cumulation, paramSpdyHeadersFrame);
      if (this.cumulation.isReadable()) {
        this.cumulation.discardReadBytes();
      } else {
        releaseBuffer();
      }
    }
  }
  
  protected void decodeHeaderBlock(ByteBuf paramByteBuf, SpdyHeadersFrame paramSpdyHeadersFrame)
    throws Exception
  {
    while (paramByteBuf.isReadable())
    {
      int i;
      int j;
      int k;
      switch (1.$SwitchMap$io$netty$handler$codec$spdy$SpdyHeaderBlockRawDecoder$State[this.state.ordinal()])
      {
      default: 
        throw new Error("Shouldn't reach here.");
      case 9: 
        paramByteBuf.skipBytes(paramByteBuf.readableBytes());
        return;
      case 8: 
        this.state = State.ERROR;
        paramSpdyHeadersFrame.setInvalid();
        break;
      case 7: 
        i = Math.min(paramByteBuf.readableBytes(), this.length);
        paramByteBuf.skipBytes(i);
        i = this.length - i;
        this.length = i;
        if (i == 0)
        {
          i = this.numHeaders - 1;
          this.numHeaders = i;
          if (i == 0) {
            this.state = State.END_HEADER_BLOCK;
          } else {
            this.state = State.READ_NAME_LENGTH;
          }
        }
        break;
      case 6: 
        i = paramByteBuf.readableBytes();
        j = this.length;
        if (i < j) {
          return;
        }
        byte[] arrayOfByte1 = new byte[j];
        paramByteBuf.readBytes(arrayOfByte1);
        i = 0;
        if (arrayOfByte1[0] == 0)
        {
          this.state = State.ERROR;
          paramSpdyHeadersFrame.setInvalid();
        }
        else
        {
          k = 0;
          while (i < this.length)
          {
            while ((i < j) && (arrayOfByte1[i] != 0)) {
              i++;
            }
            if (i < j)
            {
              int m = i + 1;
              if ((m == j) || (arrayOfByte1[m] == 0))
              {
                this.state = State.ERROR;
                paramSpdyHeadersFrame.setInvalid();
                break;
              }
            }
            String str = new String(arrayOfByte1, k, i - k, "UTF-8");
            try
            {
              paramSpdyHeadersFrame.headers().add(this.name, str);
              k = i + 1;
              i = k;
            }
            catch (IllegalArgumentException localIllegalArgumentException)
            {
              this.state = State.ERROR;
              paramSpdyHeadersFrame.setInvalid();
            }
          }
          this.name = null;
          if (this.state != State.ERROR)
          {
            i = this.numHeaders - 1;
            this.numHeaders = i;
            if (i == 0) {
              this.state = State.END_HEADER_BLOCK;
            } else {
              this.state = State.READ_NAME_LENGTH;
            }
          }
        }
        break;
      case 5: 
        if (paramByteBuf.readableBytes() < 4) {
          return;
        }
        j = readLengthField(paramByteBuf);
        this.length = j;
        if (j < 0)
        {
          this.state = State.ERROR;
          paramSpdyHeadersFrame.setInvalid();
        }
        else if (j == 0)
        {
          if (!paramSpdyHeadersFrame.isTruncated()) {
            paramSpdyHeadersFrame.headers().add(this.name, "");
          }
          this.name = null;
          i = this.numHeaders - 1;
          this.numHeaders = i;
          if (i == 0) {
            this.state = State.END_HEADER_BLOCK;
          } else {
            this.state = State.READ_NAME_LENGTH;
          }
        }
        else
        {
          i = this.maxHeaderSize;
          if (j <= i)
          {
            k = this.headerSize;
            if (k <= i - j)
            {
              this.headerSize = (k + j);
              this.state = State.READ_VALUE;
              continue;
            }
          }
          this.headerSize = (i + 1);
          this.name = null;
          this.state = State.SKIP_VALUE;
          paramSpdyHeadersFrame.setTruncated();
        }
        break;
      case 4: 
        i = Math.min(paramByteBuf.readableBytes(), this.length);
        paramByteBuf.skipBytes(i);
        i = this.length - i;
        this.length = i;
        if (i == 0) {
          this.state = State.READ_VALUE_LENGTH;
        }
        break;
      case 3: 
        i = paramByteBuf.readableBytes();
        k = this.length;
        if (i < k) {
          return;
        }
        byte[] arrayOfByte2 = new byte[k];
        paramByteBuf.readBytes(arrayOfByte2);
        this.name = new String(arrayOfByte2, "UTF-8");
        if (paramSpdyHeadersFrame.headers().contains(this.name))
        {
          this.state = State.ERROR;
          paramSpdyHeadersFrame.setInvalid();
        }
        else
        {
          this.state = State.READ_VALUE_LENGTH;
        }
        break;
      case 2: 
        if (paramByteBuf.readableBytes() < 4) {
          return;
        }
        j = readLengthField(paramByteBuf);
        this.length = j;
        if (j <= 0)
        {
          this.state = State.ERROR;
          paramSpdyHeadersFrame.setInvalid();
        }
        else
        {
          i = this.maxHeaderSize;
          if (j <= i)
          {
            k = this.headerSize;
            if (k <= i - j)
            {
              this.headerSize = (k + j);
              this.state = State.READ_NAME;
              continue;
            }
          }
          this.headerSize = (i + 1);
          this.state = State.SKIP_NAME;
          paramSpdyHeadersFrame.setTruncated();
        }
        break;
      case 1: 
        if (paramByteBuf.readableBytes() < 4) {
          return;
        }
        i = readLengthField(paramByteBuf);
        this.numHeaders = i;
        if (i < 0)
        {
          this.state = State.ERROR;
          paramSpdyHeadersFrame.setInvalid();
        }
        else if (i == 0)
        {
          this.state = State.END_HEADER_BLOCK;
        }
        else
        {
          this.state = State.READ_NAME_LENGTH;
        }
        break;
      }
    }
  }
  
  void end()
  {
    releaseBuffer();
  }
  
  void endHeaderBlock(SpdyHeadersFrame paramSpdyHeadersFrame)
    throws Exception
  {
    if (this.state != State.END_HEADER_BLOCK) {
      paramSpdyHeadersFrame.setInvalid();
    }
    releaseBuffer();
    this.headerSize = 0;
    this.name = null;
    this.state = State.READ_NUM_HEADERS;
  }
  
  private static enum State
  {
    static
    {
      State localState1 = new State("READ_NUM_HEADERS", 0);
      READ_NUM_HEADERS = localState1;
      State localState2 = new State("READ_NAME_LENGTH", 1);
      READ_NAME_LENGTH = localState2;
      State localState3 = new State("READ_NAME", 2);
      READ_NAME = localState3;
      State localState4 = new State("SKIP_NAME", 3);
      SKIP_NAME = localState4;
      State localState5 = new State("READ_VALUE_LENGTH", 4);
      READ_VALUE_LENGTH = localState5;
      State localState6 = new State("READ_VALUE", 5);
      READ_VALUE = localState6;
      State localState7 = new State("SKIP_VALUE", 6);
      SKIP_VALUE = localState7;
      State localState8 = new State("END_HEADER_BLOCK", 7);
      END_HEADER_BLOCK = localState8;
      State localState9 = new State("ERROR", 8);
      ERROR = localState9;
      $VALUES = new State[] { localState1, localState2, localState3, localState4, localState5, localState6, localState7, localState8, localState9 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\spdy\SpdyHeaderBlockRawDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */