package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.internal.ObjectUtil;
import java.nio.ByteOrder;
import java.util.List;

@ChannelHandler.a
public class LengthFieldPrepender
  extends MessageToMessageEncoder<ByteBuf>
{
  private final ByteOrder byteOrder;
  private final int lengthAdjustment;
  private final int lengthFieldLength;
  private final boolean lengthIncludesLengthFieldLength;
  
  public LengthFieldPrepender(int paramInt)
  {
    this(paramInt, false);
  }
  
  public LengthFieldPrepender(int paramInt1, int paramInt2)
  {
    this(paramInt1, paramInt2, false);
  }
  
  public LengthFieldPrepender(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this(ByteOrder.BIG_ENDIAN, paramInt1, paramInt2, paramBoolean);
  }
  
  public LengthFieldPrepender(int paramInt, boolean paramBoolean)
  {
    this(paramInt, 0, paramBoolean);
  }
  
  public LengthFieldPrepender(ByteOrder paramByteOrder, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramInt1 != 1) && (paramInt1 != 2) && (paramInt1 != 3) && (paramInt1 != 4) && (paramInt1 != 8))
    {
      paramByteOrder = new StringBuilder();
      paramByteOrder.append("lengthFieldLength must be either 1, 2, 3, 4, or 8: ");
      paramByteOrder.append(paramInt1);
      throw new IllegalArgumentException(paramByteOrder.toString());
    }
    this.byteOrder = ((ByteOrder)ObjectUtil.checkNotNull(paramByteOrder, "byteOrder"));
    this.lengthFieldLength = paramInt1;
    this.lengthIncludesLengthFieldLength = paramBoolean;
    this.lengthAdjustment = paramInt2;
  }
  
  protected void encode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    int i = paramByteBuf.readableBytes() + this.lengthAdjustment;
    int j = i;
    if (this.lengthIncludesLengthFieldLength) {
      j = i + this.lengthFieldLength;
    }
    ObjectUtil.checkPositiveOrZero(j, "length");
    i = this.lengthFieldLength;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 8) {
              paramList.add(paramChannelHandlerContext.alloc().buffer(8).order(this.byteOrder).writeLong(j));
            } else {
              throw new Error("should not reach here");
            }
          }
          else {
            paramList.add(paramChannelHandlerContext.alloc().buffer(4).order(this.byteOrder).writeInt(j));
          }
        }
        else if (j < 16777216)
        {
          paramList.add(paramChannelHandlerContext.alloc().buffer(3).order(this.byteOrder).writeMedium(j));
        }
        else
        {
          paramChannelHandlerContext = new StringBuilder();
          paramChannelHandlerContext.append("length does not fit into a medium integer: ");
          paramChannelHandlerContext.append(j);
          throw new IllegalArgumentException(paramChannelHandlerContext.toString());
        }
      }
      else if (j < 65536)
      {
        paramList.add(paramChannelHandlerContext.alloc().buffer(2).order(this.byteOrder).writeShort((short)j));
      }
      else
      {
        paramChannelHandlerContext = new StringBuilder();
        paramChannelHandlerContext.append("length does not fit into a short integer: ");
        paramChannelHandlerContext.append(j);
        throw new IllegalArgumentException(paramChannelHandlerContext.toString());
      }
    }
    else
    {
      if (j >= 256) {
        break label359;
      }
      paramList.add(paramChannelHandlerContext.alloc().buffer(1).order(this.byteOrder).writeByte((byte)j));
    }
    paramList.add(paramByteBuf.retain());
    return;
    label359:
    paramChannelHandlerContext = new StringBuilder();
    paramChannelHandlerContext.append("length does not fit into a byte: ");
    paramChannelHandlerContext.append(j);
    throw new IllegalArgumentException(paramChannelHandlerContext.toString());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\LengthFieldPrepender.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */