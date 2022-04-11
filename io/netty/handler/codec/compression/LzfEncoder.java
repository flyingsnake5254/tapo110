package io.netty.handler.codec.compression;

import com.ning.compress.BufferRecycler;
import com.ning.compress.lzf.ChunkEncoder;
import com.ning.compress.lzf.LZFChunk;
import com.ning.compress.lzf.LZFEncoder;
import com.ning.compress.lzf.util.ChunkEncoderFactory;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class LzfEncoder
  extends MessageToByteEncoder<ByteBuf>
{
  private static final int MIN_BLOCK_TO_COMPRESS = 16;
  private final int compressThreshold;
  private final ChunkEncoder encoder;
  private final BufferRecycler recycler;
  
  public LzfEncoder()
  {
    this(false);
  }
  
  public LzfEncoder(int paramInt)
  {
    this(false, paramInt);
  }
  
  public LzfEncoder(boolean paramBoolean)
  {
    this(paramBoolean, 65535);
  }
  
  public LzfEncoder(boolean paramBoolean, int paramInt)
  {
    this(paramBoolean, paramInt, 16);
  }
  
  public LzfEncoder(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    super(false);
    if ((paramInt1 >= 16) && (paramInt1 <= 65535))
    {
      if (paramInt2 >= 16)
      {
        this.compressThreshold = paramInt2;
        if (paramBoolean) {
          localObject = ChunkEncoderFactory.safeNonAllocatingInstance(paramInt1);
        } else {
          localObject = ChunkEncoderFactory.optimalNonAllocatingInstance(paramInt1);
        }
        this.encoder = ((ChunkEncoder)localObject);
        this.recycler = BufferRecycler.instance();
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("compressThreshold:");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" expected >=");
      ((StringBuilder)localObject).append(16);
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("totalLength: ");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" (expected: ");
    ((StringBuilder)localObject).append(16);
    ((StringBuilder)localObject).append('-');
    ((StringBuilder)localObject).append(65535);
    ((StringBuilder)localObject).append(')');
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  private int encodeCompress(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    return LZFEncoder.appendEncoded(this.encoder, paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, paramInt3) - paramInt3;
  }
  
  private static int encodeNonCompress(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    return lzfEncodeNonCompress(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, paramInt3) - paramInt3;
  }
  
  private static int lzfEncodeNonCompress(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    int i = Math.min(65535, paramInt2);
    int j = LZFChunk.appendNonCompressed(paramArrayOfByte1, paramInt1, i, paramArrayOfByte2, paramInt3);
    paramInt3 = paramInt2 - i;
    if (paramInt3 < 1) {
      return j;
    }
    i = paramInt1 + i;
    paramInt2 = j;
    paramInt1 = paramInt3;
    paramInt3 = i;
    do
    {
      i = Math.min(paramInt1, 65535);
      j = LZFChunk.appendNonCompressed(paramArrayOfByte1, paramInt3, i, paramArrayOfByte2, paramInt2);
      paramInt3 += i;
      i = paramInt1 - i;
      paramInt1 = i;
      paramInt2 = j;
    } while (i > 0);
    return j;
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf1, ByteBuf paramByteBuf2)
    throws Exception
  {
    int i = paramByteBuf1.readableBytes();
    int j = paramByteBuf1.readerIndex();
    boolean bool = paramByteBuf1.hasArray();
    int k = 0;
    if (bool)
    {
      paramChannelHandlerContext = paramByteBuf1.array();
      k = paramByteBuf1.arrayOffset() + j;
    }
    else
    {
      paramChannelHandlerContext = this.recycler.allocInputBuffer(i);
      paramByteBuf1.getBytes(j, paramChannelHandlerContext, 0, i);
    }
    paramByteBuf2.ensureWritable(LZFEncoder.estimateMaxWorkspaceSize(i));
    byte[] arrayOfByte = paramByteBuf2.array();
    j = paramByteBuf2.arrayOffset() + paramByteBuf2.writerIndex();
    if (i >= this.compressThreshold) {
      k = encodeCompress(paramChannelHandlerContext, k, i, arrayOfByte, j);
    } else {
      k = encodeNonCompress(paramChannelHandlerContext, k, i, arrayOfByte, j);
    }
    paramByteBuf2.writerIndex(paramByteBuf2.writerIndex() + k);
    paramByteBuf1.skipBytes(i);
    if (!paramByteBuf1.hasArray()) {
      this.recycler.releaseInputBuffer(paramChannelHandlerContext);
    }
  }
  
  public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.encoder.close();
    super.handlerRemoved(paramChannelHandlerContext);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\compression\LzfEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */