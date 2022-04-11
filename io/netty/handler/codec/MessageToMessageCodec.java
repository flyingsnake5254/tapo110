package io.netty.handler.codec;

import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.util.internal.TypeParameterMatcher;
import java.util.List;

public abstract class MessageToMessageCodec<INBOUND_IN, OUTBOUND_IN>
  extends ChannelDuplexHandler
{
  private final MessageToMessageDecoder<Object> decoder = new MessageToMessageDecoder()
  {
    public boolean acceptInboundMessage(Object paramAnonymousObject)
      throws Exception
    {
      return MessageToMessageCodec.this.acceptInboundMessage(paramAnonymousObject);
    }
    
    protected void decode(ChannelHandlerContext paramAnonymousChannelHandlerContext, Object paramAnonymousObject, List<Object> paramAnonymousList)
      throws Exception
    {
      MessageToMessageCodec.this.decode(paramAnonymousChannelHandlerContext, paramAnonymousObject, paramAnonymousList);
    }
  };
  private final MessageToMessageEncoder<Object> encoder = new MessageToMessageEncoder()
  {
    public boolean acceptOutboundMessage(Object paramAnonymousObject)
      throws Exception
    {
      return MessageToMessageCodec.this.acceptOutboundMessage(paramAnonymousObject);
    }
    
    protected void encode(ChannelHandlerContext paramAnonymousChannelHandlerContext, Object paramAnonymousObject, List<Object> paramAnonymousList)
      throws Exception
    {
      MessageToMessageCodec.this.encode(paramAnonymousChannelHandlerContext, paramAnonymousObject, paramAnonymousList);
    }
  };
  private final TypeParameterMatcher inboundMsgMatcher;
  private final TypeParameterMatcher outboundMsgMatcher;
  
  protected MessageToMessageCodec()
  {
    this.inboundMsgMatcher = TypeParameterMatcher.find(this, MessageToMessageCodec.class, "INBOUND_IN");
    this.outboundMsgMatcher = TypeParameterMatcher.find(this, MessageToMessageCodec.class, "OUTBOUND_IN");
  }
  
  protected MessageToMessageCodec(Class<? extends INBOUND_IN> paramClass, Class<? extends OUTBOUND_IN> paramClass1)
  {
    this.inboundMsgMatcher = TypeParameterMatcher.get(paramClass);
    this.outboundMsgMatcher = TypeParameterMatcher.get(paramClass1);
  }
  
  public boolean acceptInboundMessage(Object paramObject)
    throws Exception
  {
    return this.inboundMsgMatcher.match(paramObject);
  }
  
  public boolean acceptOutboundMessage(Object paramObject)
    throws Exception
  {
    return this.outboundMsgMatcher.match(paramObject);
  }
  
  public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    this.decoder.channelRead(paramChannelHandlerContext, paramObject);
  }
  
  protected abstract void decode(ChannelHandlerContext paramChannelHandlerContext, INBOUND_IN paramINBOUND_IN, List<Object> paramList)
    throws Exception;
  
  protected abstract void encode(ChannelHandlerContext paramChannelHandlerContext, OUTBOUND_IN paramOUTBOUND_IN, List<Object> paramList)
    throws Exception;
  
  public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
    throws Exception
  {
    this.encoder.write(paramChannelHandlerContext, paramObject, paramChannelPromise);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\MessageToMessageCodec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */