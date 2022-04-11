package io.netty.handler.codec.http;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.MessageAggregator;
import io.netty.util.AsciiString;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class HttpServerUpgradeHandler
  extends HttpObjectAggregator
{
  private boolean handlingUpgrade;
  private final SourceCodec sourceCodec;
  private final UpgradeCodecFactory upgradeCodecFactory;
  
  public HttpServerUpgradeHandler(SourceCodec paramSourceCodec, UpgradeCodecFactory paramUpgradeCodecFactory)
  {
    this(paramSourceCodec, paramUpgradeCodecFactory, 0);
  }
  
  public HttpServerUpgradeHandler(SourceCodec paramSourceCodec, UpgradeCodecFactory paramUpgradeCodecFactory, int paramInt)
  {
    super(paramInt);
    this.sourceCodec = ((SourceCodec)ObjectUtil.checkNotNull(paramSourceCodec, "sourceCodec"));
    this.upgradeCodecFactory = ((UpgradeCodecFactory)ObjectUtil.checkNotNull(paramUpgradeCodecFactory, "upgradeCodecFactory"));
  }
  
  private static FullHttpResponse createUpgradeResponse(CharSequence paramCharSequence)
  {
    DefaultFullHttpResponse localDefaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.SWITCHING_PROTOCOLS, Unpooled.EMPTY_BUFFER, false);
    localDefaultFullHttpResponse.headers().add(HttpHeaderNames.CONNECTION, HttpHeaderValues.UPGRADE);
    localDefaultFullHttpResponse.headers().add(HttpHeaderNames.UPGRADE, paramCharSequence);
    return localDefaultFullHttpResponse;
  }
  
  private static boolean isUpgradeRequest(HttpObject paramHttpObject)
  {
    boolean bool;
    if (((paramHttpObject instanceof HttpRequest)) && (((HttpRequest)paramHttpObject).headers().get(HttpHeaderNames.UPGRADE) != null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private static List<CharSequence> splitHeader(CharSequence paramCharSequence)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramCharSequence.length());
    ArrayList localArrayList = new ArrayList(4);
    for (int i = 0; i < paramCharSequence.length(); i++)
    {
      char c = paramCharSequence.charAt(i);
      if (!Character.isWhitespace(c)) {
        if (c == ',')
        {
          localArrayList.add(localStringBuilder.toString());
          localStringBuilder.setLength(0);
        }
        else
        {
          localStringBuilder.append(c);
        }
      }
    }
    if (localStringBuilder.length() > 0) {
      localArrayList.add(localStringBuilder.toString());
    }
    return localArrayList;
  }
  
  private boolean upgrade(ChannelHandlerContext paramChannelHandlerContext, FullHttpRequest paramFullHttpRequest)
  {
    Object localObject1 = splitHeader(paramFullHttpRequest.headers().get(HttpHeaderNames.UPGRADE));
    int i = ((List)localObject1).size();
    UpgradeCodec localUpgradeCodec;
    for (int j = 0;; j++)
    {
      localUpgradeCodec = null;
      if (j >= i) {
        break;
      }
      localObject2 = (CharSequence)((List)localObject1).get(j);
      localUpgradeCodec = this.upgradeCodecFactory.newUpgradeCodec((CharSequence)localObject2);
      if (localUpgradeCodec != null) {
        break label80;
      }
    }
    Object localObject2 = null;
    label80:
    if (localUpgradeCodec == null) {
      return false;
    }
    Object localObject3 = paramFullHttpRequest.headers().getAll(HttpHeaderNames.CONNECTION);
    if (localObject3 == null) {
      return false;
    }
    localObject1 = new StringBuilder(((List)localObject3).size() * 10);
    localObject3 = ((List)localObject3).iterator();
    while (((Iterator)localObject3).hasNext())
    {
      ((StringBuilder)localObject1).append((CharSequence)((Iterator)localObject3).next());
      ((StringBuilder)localObject1).append(',');
    }
    ((StringBuilder)localObject1).setLength(((StringBuilder)localObject1).length() - 1);
    localObject3 = localUpgradeCodec.requiredUpgradeHeaders();
    localObject1 = splitHeader((CharSequence)localObject1);
    if ((AsciiString.containsContentEqualsIgnoreCase((Collection)localObject1, HttpHeaderNames.UPGRADE)) && (AsciiString.containsAllContentEqualsIgnoreCase((Collection)localObject1, (Collection)localObject3)))
    {
      localObject3 = ((Collection)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject1 = (CharSequence)((Iterator)localObject3).next();
        if (!paramFullHttpRequest.headers().contains((CharSequence)localObject1)) {
          return false;
        }
      }
      localObject1 = createUpgradeResponse((CharSequence)localObject2);
      if (!localUpgradeCodec.prepareUpgradeResponse(paramChannelHandlerContext, paramFullHttpRequest, ((HttpMessage)localObject1).headers())) {
        return false;
      }
      localObject2 = new UpgradeEvent((CharSequence)localObject2, paramFullHttpRequest);
      try
      {
        localObject1 = paramChannelHandlerContext.writeAndFlush(localObject1);
        this.sourceCodec.upgradeFrom(paramChannelHandlerContext);
        localUpgradeCodec.upgradeTo(paramChannelHandlerContext, paramFullHttpRequest);
        paramChannelHandlerContext.pipeline().remove(this);
        paramChannelHandlerContext.fireUserEventTriggered(((UpgradeEvent)localObject2).retain());
        ((ChannelFuture)localObject1).addListener(ChannelFutureListener.CLOSE_ON_FAILURE);
        return true;
      }
      finally
      {
        ((UpgradeEvent)localObject2).release();
      }
    }
    return false;
  }
  
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, HttpObject paramHttpObject, List<Object> paramList)
    throws Exception
  {
    boolean bool = this.handlingUpgrade | isUpgradeRequest(paramHttpObject);
    this.handlingUpgrade = bool;
    if (!bool)
    {
      ReferenceCountUtil.retain(paramHttpObject);
      paramList.add(paramHttpObject);
      return;
    }
    if ((paramHttpObject instanceof FullHttpRequest))
    {
      FullHttpRequest localFullHttpRequest = (FullHttpRequest)paramHttpObject;
      ReferenceCountUtil.retain(paramHttpObject);
      paramList.add(paramHttpObject);
      paramHttpObject = localFullHttpRequest;
    }
    else
    {
      super.decode(paramChannelHandlerContext, paramHttpObject, paramList);
      if (paramList.isEmpty()) {
        return;
      }
      this.handlingUpgrade = false;
      paramHttpObject = (FullHttpRequest)paramList.get(0);
    }
    if (upgrade(paramChannelHandlerContext, paramHttpObject)) {
      paramList.clear();
    }
  }
  
  public static abstract interface SourceCodec
  {
    public abstract void upgradeFrom(ChannelHandlerContext paramChannelHandlerContext);
  }
  
  public static abstract interface UpgradeCodec
  {
    public abstract boolean prepareUpgradeResponse(ChannelHandlerContext paramChannelHandlerContext, FullHttpRequest paramFullHttpRequest, HttpHeaders paramHttpHeaders);
    
    public abstract Collection<CharSequence> requiredUpgradeHeaders();
    
    public abstract void upgradeTo(ChannelHandlerContext paramChannelHandlerContext, FullHttpRequest paramFullHttpRequest);
  }
  
  public static abstract interface UpgradeCodecFactory
  {
    public abstract HttpServerUpgradeHandler.UpgradeCodec newUpgradeCodec(CharSequence paramCharSequence);
  }
  
  public static final class UpgradeEvent
    implements ReferenceCounted
  {
    private final CharSequence protocol;
    private final FullHttpRequest upgradeRequest;
    
    UpgradeEvent(CharSequence paramCharSequence, FullHttpRequest paramFullHttpRequest)
    {
      this.protocol = paramCharSequence;
      this.upgradeRequest = paramFullHttpRequest;
    }
    
    public CharSequence protocol()
    {
      return this.protocol;
    }
    
    public int refCnt()
    {
      return this.upgradeRequest.refCnt();
    }
    
    public boolean release()
    {
      return this.upgradeRequest.release();
    }
    
    public boolean release(int paramInt)
    {
      return this.upgradeRequest.release(paramInt);
    }
    
    public UpgradeEvent retain()
    {
      this.upgradeRequest.retain();
      return this;
    }
    
    public UpgradeEvent retain(int paramInt)
    {
      this.upgradeRequest.retain(paramInt);
      return this;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("UpgradeEvent [protocol=");
      localStringBuilder.append(this.protocol);
      localStringBuilder.append(", upgradeRequest=");
      localStringBuilder.append(this.upgradeRequest);
      localStringBuilder.append(']');
      return localStringBuilder.toString();
    }
    
    public UpgradeEvent touch()
    {
      this.upgradeRequest.touch();
      return this;
    }
    
    public UpgradeEvent touch(Object paramObject)
    {
      this.upgradeRequest.touch(paramObject);
      return this;
    }
    
    public FullHttpRequest upgradeRequest()
    {
      return this.upgradeRequest;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpServerUpgradeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */