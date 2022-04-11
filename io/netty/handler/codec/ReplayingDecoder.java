package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.Signal;
import io.netty.util.internal.StringUtil;
import java.util.List;

public abstract class ReplayingDecoder<S>
  extends ByteToMessageDecoder
{
  static final Signal REPLAY = Signal.valueOf(ReplayingDecoder.class, "REPLAY");
  private int checkpoint = -1;
  private final ReplayingDecoderByteBuf replayable = new ReplayingDecoderByteBuf();
  private S state;
  
  protected ReplayingDecoder()
  {
    this(null);
  }
  
  protected ReplayingDecoder(S paramS)
  {
    this.state = paramS;
  }
  
  protected void callDecode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
  {
    this.replayable.setCumulation(paramByteBuf);
    try
    {
      while (paramByteBuf.isReadable())
      {
        int i = paramByteBuf.readerIndex();
        this.checkpoint = i;
        int j = paramList.size();
        int k = j;
        if (j > 0)
        {
          ByteToMessageDecoder.fireChannelRead(paramChannelHandlerContext, paramList, j);
          paramList.clear();
          if (!paramChannelHandlerContext.isRemoved()) {
            k = 0;
          }
        }
        else
        {
          Object localObject = this.state;
          j = paramByteBuf.readableBytes();
          try
          {
            decodeRemovalReentryProtection(paramChannelHandlerContext, this.replayable, paramList);
            if (!paramChannelHandlerContext.isRemoved()) {
              if (k == paramList.size())
              {
                if ((j == paramByteBuf.readableBytes()) && (localObject == this.state))
                {
                  localObject = new io/netty/handler/codec/DecoderException;
                  paramList = new java/lang/StringBuilder;
                  paramList.<init>();
                  paramList.append(StringUtil.simpleClassName(getClass()));
                  paramList.append(".decode() must consume the inbound data or change its state if it did not decode anything.");
                  ((DecoderException)localObject).<init>(paramList.toString());
                  throw ((Throwable)localObject);
                }
              }
              else
              {
                if ((i == paramByteBuf.readerIndex()) && (localObject == this.state))
                {
                  paramByteBuf = new io/netty/handler/codec/DecoderException;
                  paramChannelHandlerContext = new java/lang/StringBuilder;
                  paramChannelHandlerContext.<init>();
                  paramChannelHandlerContext.append(StringUtil.simpleClassName(getClass()));
                  paramChannelHandlerContext.append(".decode() method must consume the inbound data or change its state if it decoded something.");
                  paramByteBuf.<init>(paramChannelHandlerContext.toString());
                  throw paramByteBuf;
                }
                if (!isSingleDecode()) {
                  break;
                }
              }
            }
          }
          catch (Signal paramList)
          {
            paramList.expect(REPLAY);
            if (!paramChannelHandlerContext.isRemoved())
            {
              k = this.checkpoint;
              if (k >= 0) {
                paramByteBuf.readerIndex(k);
              }
            }
          }
        }
      }
      return;
    }
    catch (Exception paramChannelHandlerContext)
    {
      throw new DecoderException(paramChannelHandlerContext);
    }
    catch (DecoderException paramChannelHandlerContext)
    {
      throw paramChannelHandlerContext;
    }
  }
  
  final void channelInputClosed(ChannelHandlerContext paramChannelHandlerContext, List<Object> paramList)
    throws Exception
  {
    try
    {
      this.replayable.terminate();
      if (this.cumulation != null) {
        callDecode(paramChannelHandlerContext, internalBuffer(), paramList);
      } else {
        this.replayable.setCumulation(Unpooled.EMPTY_BUFFER);
      }
      decodeLast(paramChannelHandlerContext, this.replayable, paramList);
    }
    catch (Signal paramChannelHandlerContext)
    {
      paramChannelHandlerContext.expect(REPLAY);
    }
  }
  
  protected void checkpoint()
  {
    this.checkpoint = internalBuffer().readerIndex();
  }
  
  protected void checkpoint(S paramS)
  {
    checkpoint();
    state(paramS);
  }
  
  protected S state()
  {
    return (S)this.state;
  }
  
  protected S state(S paramS)
  {
    Object localObject = this.state;
    this.state = paramS;
    return (S)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\ReplayingDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */