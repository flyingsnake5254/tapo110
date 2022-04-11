package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.internal.TypeParameterMatcher;
import java.util.List;

public abstract class ByteToMessageCodec<I>
  extends ChannelDuplexHandler
{
  private final ByteToMessageDecoder decoder = new ByteToMessageDecoder()
  {
    public void decode(ChannelHandlerContext paramAnonymousChannelHandlerContext, ByteBuf paramAnonymousByteBuf, List<Object> paramAnonymousList)
      throws Exception
    {
      ByteToMessageCodec.this.decode(paramAnonymousChannelHandlerContext, paramAnonymousByteBuf, paramAnonymousList);
    }
    
    protected void decodeLast(ChannelHandlerContext paramAnonymousChannelHandlerContext, ByteBuf paramAnonymousByteBuf, List<Object> paramAnonymousList)
      throws Exception
    {
      ByteToMessageCodec.this.decodeLast(paramAnonymousChannelHandlerContext, paramAnonymousByteBuf, paramAnonymousList);
    }
  };
  private final MessageToByteEncoder<I> encoder;
  private final TypeParameterMatcher outboundMsgMatcher;
  
  protected ByteToMessageCodec()
  {
    this(true);
  }
  
  protected ByteToMessageCodec(Class<? extends I> paramClass)
  {
    this(paramClass, true);
  }
  
  protected ByteToMessageCodec(Class<? extends I> paramClass, boolean paramBoolean)
  {
    ensureNotSharable();
    this.outboundMsgMatcher = TypeParameterMatcher.get(paramClass);
    this.encoder = new Encoder(paramBoolean);
  }
  
  protected ByteToMessageCodec(boolean paramBoolean)
  {
    ensureNotSharable();
    this.outboundMsgMatcher = TypeParameterMatcher.find(this, ByteToMessageCodec.class, "I");
    this.encoder = new Encoder(paramBoolean);
  }
  
  public boolean acceptOutboundMessage(Object paramObject)
    throws Exception
  {
    return this.outboundMsgMatcher.match(paramObject);
  }
  
  public void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.decoder.channelInactive(paramChannelHandlerContext);
  }
  
  public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    this.decoder.channelRead(paramChannelHandlerContext, paramObject);
  }
  
  public void channelReadComplete(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    this.decoder.channelReadComplete(paramChannelHandlerContext);
  }
  
  protected abstract void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception;
  
  protected void decodeLast(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Object> paramList)
    throws Exception
  {
    if (paramByteBuf.isReadable()) {
      decode(paramChannelHandlerContext, paramByteBuf, paramList);
    }
  }
  
  protected abstract void encode(ChannelHandlerContext paramChannelHandlerContext, I paramI, ByteBuf paramByteBuf)
    throws Exception;
  
  public void handlerAdded(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    try
    {
      this.decoder.handlerAdded(paramChannelHandlerContext);
      return;
    }
    finally
    {
      this.encoder.handlerAdded(paramChannelHandlerContext);
    }
  }
  
  public void handlerRemoved(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    try
    {
      this.decoder.handlerRemoved(paramChannelHandlerContext);
      return;
    }
    finally
    {
      this.encoder.handlerRemoved(paramChannelHandlerContext);
    }
  }
  
  public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
    throws Exception
  {
    this.encoder.write(paramChannelHandlerContext, paramObject, paramChannelPromise);
  }
  
  private final class Encoder
    extends MessageToByteEncoder<I>
  {
    Encoder(boolean paramBoolean)
    {
      super();
    }
    
    public boolean acceptOutboundMessage(Object paramObject)
      throws Exception
    {
      return ByteToMessageCodec.this.acceptOutboundMessage(paramObject);
    }
    
    protected void encode(ChannelHandlerContext paramChannelHandlerContext, I paramI, ByteBuf paramByteBuf)
      throws Exception
    {
      ByteToMessageCodec.this.encode(paramChannelHandlerContext, paramI, paramByteBuf);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\ByteToMessageCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */