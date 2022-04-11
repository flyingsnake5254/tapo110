package io.netty.handler.codec.compression;

import com.ning.compress.BufferRecycler;
import com.ning.compress.lzf.ChunkDecoder;
import com.ning.compress.lzf.util.ChunkDecoderFactory;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.ReferenceCounted;
import java.util.List;

public class LzfDecoder
  extends ByteToMessageDecoder
{
  private static final short MAGIC_NUMBER = 23126;
  private int chunkLength;
  private State currentState = State.INIT_BLOCK;
  private ChunkDecoder decoder;
  private boolean isCompressed;
  private int originalLength;
  private BufferRecycler recycler;
  
  public LzfDecoder()
  {
    this(false);
  }
  
  public LzfDecoder(boolean paramBoolean)
  {
    ChunkDecoder localChunkDecoder;
    if (paramBoolean) {
      localChunkDecoder = ChunkDecoderFactory.safeInstance();
    } else {
      localChunkDecoder = ChunkDecoderFactory.optimalInstance();
    }
    this.decoder = localChunkDecoder;
    this.recycler = BufferRecycler.instance();
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    try
    {
      int i = 1.$SwitchMap$io$netty$handler$codec$compression$LzfDecoder$State[this.currentState.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3) {
            break label208;
          }
          if (i == 4)
          {
            paramByteBuf.skipBytes(paramByteBuf.readableBytes());
            break label438;
          }
          paramChannelHandlerContext = new java/lang/IllegalStateException;
          paramChannelHandlerContext.<init>();
          throw paramChannelHandlerContext;
        }
      }
      else
      {
        if (paramByteBuf.readableBytes() < 5) {
          break label438;
        }
        if (paramByteBuf.readUnsignedShort() != 23126) {
          break label439;
        }
        i = paramByteBuf.readByte();
        if (i != 0)
        {
          if (i == 1)
          {
            this.isCompressed = true;
            this.currentState = State.INIT_ORIGINAL_LENGTH;
          }
          else
          {
            paramChannelHandlerContext = new io/netty/handler/codec/compression/DecompressionException;
            paramChannelHandlerContext.<init>(String.format("unknown type of chunk: %d (expected: %d or %d)", new Object[] { Integer.valueOf(i), Integer.valueOf(0), Integer.valueOf(1) }));
            throw paramChannelHandlerContext;
          }
        }
        else
        {
          this.isCompressed = false;
          this.currentState = State.DECOMPRESS_DATA;
        }
        this.chunkLength = paramByteBuf.readUnsignedShort();
        if (i != 1) {
          break label438;
        }
      }
      if (paramByteBuf.readableBytes() >= 2)
      {
        this.originalLength = paramByteBuf.readUnsignedShort();
        this.currentState = State.DECOMPRESS_DATA;
        label208:
        int j = this.chunkLength;
        if (paramByteBuf.readableBytes() >= j)
        {
          int k = this.originalLength;
          byte[] arrayOfByte1;
          byte[] arrayOfByte2;
          int m;
          if (this.isCompressed)
          {
            i = paramByteBuf.readerIndex();
            if (paramByteBuf.hasArray())
            {
              arrayOfByte1 = paramByteBuf.array();
              i += paramByteBuf.arrayOffset();
            }
            else
            {
              arrayOfByte1 = this.recycler.allocInputBuffer(j);
              paramByteBuf.getBytes(i, arrayOfByte1, 0, j);
              i = 0;
            }
            paramChannelHandlerContext = paramChannelHandlerContext.alloc().heapBuffer(k, k);
            arrayOfByte2 = paramChannelHandlerContext.array();
            m = paramChannelHandlerContext.arrayOffset();
            int n = paramChannelHandlerContext.writerIndex();
            m += n;
          }
          try
          {
            this.decoder.decodeChunk(arrayOfByte1, i, arrayOfByte2, m, m + k);
            paramChannelHandlerContext.writerIndex(paramChannelHandlerContext.writerIndex() + k);
            paramList.add(paramChannelHandlerContext);
            paramByteBuf.skipBytes(j);
            if (paramByteBuf.hasArray()) {
              break label431;
            }
            this.recycler.releaseInputBuffer(arrayOfByte1);
          }
          finally
          {
            paramChannelHandlerContext.release();
          }
          paramList.add(paramByteBuf.readRetainedSlice(j));
          label431:
          this.currentState = State.INIT_BLOCK;
        }
      }
      label438:
      return;
      label439:
      paramChannelHandlerContext = new io/netty/handler/codec/compression/DecompressionException;
      paramChannelHandlerContext.<init>("unexpected block identifier");
      throw paramChannelHandlerContext;
    }
    catch (Exception paramChannelHandlerContext)
    {
      this.currentState = State.CORRUPTED;
      this.decoder = null;
      this.recycler = null;
      throw paramChannelHandlerContext;
    }
  }
  
  private static enum State
  {
    static
    {
      State localState1 = new State("INIT_BLOCK", 0);
      INIT_BLOCK = localState1;
      State localState2 = new State("INIT_ORIGINAL_LENGTH", 1);
      INIT_ORIGINAL_LENGTH = localState2;
      State localState3 = new State("DECOMPRESS_DATA", 2);
      DECOMPRESS_DATA = localState3;
      State localState4 = new State("CORRUPTED", 3);
      CORRUPTED = localState4;
      $VALUES = new State[] { localState1, localState2, localState3, localState4 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\LzfDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */