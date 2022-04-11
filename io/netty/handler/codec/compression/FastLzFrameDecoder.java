package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.EmptyArrays;
import java.util.List;
import java.util.zip.Adler32;
import java.util.zip.Checksum;

public class FastLzFrameDecoder
  extends ByteToMessageDecoder
{
  private final Checksum checksum;
  private int chunkLength;
  private int currentChecksum;
  private State currentState = State.INIT_BLOCK;
  private boolean hasChecksum;
  private boolean isCompressed;
  private int originalLength;
  
  public FastLzFrameDecoder()
  {
    this(false);
  }
  
  public FastLzFrameDecoder(Checksum paramChecksum)
  {
    this.checksum = paramChecksum;
  }
  
  public FastLzFrameDecoder(boolean paramBoolean)
  {
    this(localAdler32);
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    try
    {
      int i = 1.$SwitchMap$io$netty$handler$codec$compression$FastLzFrameDecoder$State[this.currentState.ordinal()];
      int j = 4;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            break label258;
          }
          if (i == 4)
          {
            paramByteBuf.skipBytes(paramByteBuf.readableBytes());
            break label607;
          }
          paramChannelHandlerContext = new java/lang/IllegalStateException;
          paramChannelHandlerContext.<init>();
          throw paramChannelHandlerContext;
        }
      }
      else
      {
        if (paramByteBuf.readableBytes() < 4) {
          break label607;
        }
        if (paramByteBuf.readUnsignedMedium() != 4607066) {
          break label622;
        }
        i = paramByteBuf.readByte();
        if ((i & 0x1) == 1) {
          bool = true;
        } else {
          bool = false;
        }
        this.isCompressed = bool;
        if ((i & 0x10) == 16) {
          bool = true;
        } else {
          bool = false;
        }
        this.hasChecksum = bool;
        this.currentState = State.INIT_BLOCK_PARAMS;
      }
      int k = paramByteBuf.readableBytes();
      if (this.isCompressed) {
        i = 2;
      } else {
        i = 0;
      }
      boolean bool = this.hasChecksum;
      if (!bool) {
        j = 0;
      }
      label258:
      int m;
      byte[] arrayOfByte;
      if (k >= i + 2 + j)
      {
        if (bool) {
          i = paramByteBuf.readInt();
        } else {
          i = 0;
        }
        this.currentChecksum = i;
        i = paramByteBuf.readUnsignedShort();
        this.chunkLength = i;
        if (this.isCompressed) {
          i = paramByteBuf.readUnsignedShort();
        }
        this.originalLength = i;
        this.currentState = State.DECOMPRESS_DATA;
        k = this.chunkLength;
        if (paramByteBuf.readableBytes() >= k)
        {
          j = paramByteBuf.readerIndex();
          m = this.originalLength;
          if (m != 0)
          {
            paramChannelHandlerContext = paramChannelHandlerContext.alloc().heapBuffer(m, m);
            arrayOfByte = paramChannelHandlerContext.array();
            int n = paramChannelHandlerContext.arrayOffset();
            i = paramChannelHandlerContext.writerIndex();
            i = n + i;
          }
          else
          {
            arrayOfByte = EmptyArrays.EMPTY_BYTES;
            paramChannelHandlerContext = null;
            i = 0;
          }
        }
      }
      try
      {
        if (this.isCompressed)
        {
          if (paramByteBuf.hasArray())
          {
            localObject = paramByteBuf.array();
            j = paramByteBuf.arrayOffset() + j;
          }
          else
          {
            localObject = new byte[k];
            paramByteBuf.getBytes(j, (byte[])localObject);
            j = 0;
          }
          j = FastLz.decompress((byte[])localObject, j, k, arrayOfByte, i, m);
          if (m != j)
          {
            paramByteBuf = new io/netty/handler/codec/compression/DecompressionException;
            paramByteBuf.<init>(String.format("stream corrupted: originalLength(%d) and actual length(%d) mismatch", new Object[] { Integer.valueOf(m), Integer.valueOf(j) }));
            throw paramByteBuf;
          }
        }
        else
        {
          paramByteBuf.getBytes(j, arrayOfByte, i, k);
        }
        Object localObject = this.checksum;
        if ((this.hasChecksum) && (localObject != null))
        {
          ((Checksum)localObject).reset();
          ((Checksum)localObject).update(arrayOfByte, i, m);
          i = (int)((Checksum)localObject).getValue();
          if (i != this.currentChecksum)
          {
            paramByteBuf = new io/netty/handler/codec/compression/DecompressionException;
            paramByteBuf.<init>(String.format("stream corrupted: mismatching checksum: %d (expected: %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(this.currentChecksum) }));
            throw paramByteBuf;
          }
        }
        if (paramChannelHandlerContext != null)
        {
          paramChannelHandlerContext.writerIndex(paramChannelHandlerContext.writerIndex() + m);
          paramList.add(paramChannelHandlerContext);
        }
        paramByteBuf.skipBytes(k);
        this.currentState = State.INIT_BLOCK;
        label607:
        return;
      }
      finally
      {
        if (paramChannelHandlerContext != null) {
          paramChannelHandlerContext.release();
        }
      }
      label622:
      paramChannelHandlerContext = new io/netty/handler/codec/compression/DecompressionException;
      paramChannelHandlerContext.<init>("unexpected block identifier");
      throw paramChannelHandlerContext;
    }
    catch (Exception paramChannelHandlerContext)
    {
      this.currentState = State.CORRUPTED;
      throw paramChannelHandlerContext;
    }
  }
  
  private static enum State
  {
    static
    {
      State localState1 = new State("INIT_BLOCK", 0);
      INIT_BLOCK = localState1;
      State localState2 = new State("INIT_BLOCK_PARAMS", 1);
      INIT_BLOCK_PARAMS = localState2;
      State localState3 = new State("DECOMPRESS_DATA", 2);
      DECOMPRESS_DATA = localState3;
      State localState4 = new State("CORRUPTED", 3);
      CORRUPTED = localState4;
      $VALUES = new State[] { localState1, localState2, localState3, localState4 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\FastLzFrameDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */