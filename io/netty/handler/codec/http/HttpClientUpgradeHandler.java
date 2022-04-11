package io.netty.handler.codec.http;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandler;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.util.internal.ObjectUtil;
import java.net.SocketAddress;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class HttpClientUpgradeHandler
  extends HttpObjectAggregator
  implements ChannelOutboundHandler
{
  private final SourceCodec sourceCodec;
  private final UpgradeCodec upgradeCodec;
  private boolean upgradeRequested;
  
  public HttpClientUpgradeHandler(SourceCodec paramSourceCodec, UpgradeCodec paramUpgradeCodec, int paramInt)
  {
    super(paramInt);
    this.sourceCodec = ((SourceCodec)ObjectUtil.checkNotNull(paramSourceCodec, "sourceCodec"));
    this.upgradeCodec = ((UpgradeCodec)ObjectUtil.checkNotNull(paramUpgradeCodec, "upgradeCodec"));
  }
  
  private static void removeThisHandler(ChannelHandlerContext paramChannelHandlerContext)
  {
    paramChannelHandlerContext.pipeline().remove(paramChannelHandlerContext.name());
  }
  
  private void setUpgradeRequestHeaders(ChannelHandlerContext paramChannelHandlerContext, HttpRequest paramHttpRequest)
  {
    paramHttpRequest.headers().set(HttpHeaderNames.UPGRADE, this.upgradeCodec.protocol());
    Object localObject = new LinkedHashSet(2);
    ((Set)localObject).addAll(this.upgradeCodec.setUpgradeHeaders(paramChannelHandlerContext, paramHttpRequest));
    paramChannelHandlerContext = new StringBuilder();
    localObject = ((Set)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramChannelHandlerContext.append((CharSequence)((Iterator)localObject).next());
      paramChannelHandlerContext.append(',');
    }
    paramChannelHandlerContext.append(HttpHeaderValues.UPGRADE);
    paramHttpRequest.headers().add(HttpHeaderNames.CONNECTION, paramChannelHandlerContext.toString());
  }
  
  public void bind(ChannelHandlerContext paramChannelHandlerContext, SocketAddress paramSocketAddress, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.bind(paramSocketAddress, paramChannelPromise);
  }
  
  public void close(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.close(paramChannelPromise);
  }
  
  public void connect(ChannelHandlerContext paramChannelHandlerContext, SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.connect(paramSocketAddress1, paramSocketAddress2, paramChannelPromise);
  }
  
  /* Error */
  protected void decode(ChannelHandlerContext paramChannelHandlerContext, HttpObject paramHttpObject, java.util.List<Object> paramList)
    throws Exception
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aload 4
    //   5: astore 5
    //   7: aload_0
    //   8: getfield 161	io/netty/handler/codec/http/HttpClientUpgradeHandler:upgradeRequested	Z
    //   11: ifeq +353 -> 364
    //   14: aload 4
    //   16: astore 5
    //   18: aload_2
    //   19: instanceof 163
    //   22: ifeq +68 -> 90
    //   25: aload 4
    //   27: astore 5
    //   29: aload_2
    //   30: checkcast 163	io/netty/handler/codec/http/HttpResponse
    //   33: astore 6
    //   35: aload 4
    //   37: astore 5
    //   39: getstatic 169	io/netty/handler/codec/http/HttpResponseStatus:SWITCHING_PROTOCOLS	Lio/netty/handler/codec/http/HttpResponseStatus;
    //   42: aload 6
    //   44: invokeinterface 173 1 0
    //   49: invokevirtual 177	io/netty/handler/codec/http/HttpResponseStatus:equals	(Ljava/lang/Object;)Z
    //   52: ifne +38 -> 90
    //   55: aload 4
    //   57: astore 5
    //   59: aload_1
    //   60: getstatic 181	io/netty/handler/codec/http/HttpClientUpgradeHandler$UpgradeEvent:UPGRADE_REJECTED	Lio/netty/handler/codec/http/HttpClientUpgradeHandler$UpgradeEvent;
    //   63: invokeinterface 185 2 0
    //   68: pop
    //   69: aload 4
    //   71: astore 5
    //   73: aload_1
    //   74: invokestatic 187	io/netty/handler/codec/http/HttpClientUpgradeHandler:removeThisHandler	(Lio/netty/channel/ChannelHandlerContext;)V
    //   77: aload 4
    //   79: astore 5
    //   81: aload_1
    //   82: aload_2
    //   83: invokeinterface 190 2 0
    //   88: pop
    //   89: return
    //   90: aload 4
    //   92: astore 5
    //   94: aload_2
    //   95: instanceof 192
    //   98: ifeq +34 -> 132
    //   101: aload 4
    //   103: astore 5
    //   105: aload_2
    //   106: checkcast 192	io/netty/handler/codec/http/FullHttpResponse
    //   109: astore_2
    //   110: aload_2
    //   111: invokeinterface 196 1 0
    //   116: pop
    //   117: aload_3
    //   118: aload_2
    //   119: invokeinterface 200 2 0
    //   124: pop
    //   125: goto +50 -> 175
    //   128: astore_3
    //   129: goto +264 -> 393
    //   132: aload 4
    //   134: astore 5
    //   136: aload_0
    //   137: aload_1
    //   138: aload_2
    //   139: aload_3
    //   140: invokespecial 205	io/netty/handler/codec/MessageAggregator:decode	(Lio/netty/channel/ChannelHandlerContext;Ljava/lang/Object;Ljava/util/List;)V
    //   143: aload 4
    //   145: astore 5
    //   147: aload_3
    //   148: invokeinterface 208 1 0
    //   153: ifeq +4 -> 157
    //   156: return
    //   157: aload 4
    //   159: astore 5
    //   161: aload_3
    //   162: iconst_0
    //   163: invokeinterface 212 2 0
    //   168: checkcast 192	io/netty/handler/codec/http/FullHttpResponse
    //   171: astore_2
    //   172: goto -47 -> 125
    //   175: aload_2
    //   176: astore 5
    //   178: aload_2
    //   179: invokeinterface 69 1 0
    //   184: getstatic 75	io/netty/handler/codec/http/HttpHeaderNames:UPGRADE	Lio/netty/util/AsciiString;
    //   187: invokevirtual 215	io/netty/handler/codec/http/HttpHeaders:get	(Ljava/lang/CharSequence;)Ljava/lang/String;
    //   190: astore 4
    //   192: aload 4
    //   194: ifnull +88 -> 282
    //   197: aload_2
    //   198: astore 5
    //   200: aload_0
    //   201: getfield 43	io/netty/handler/codec/http/HttpClientUpgradeHandler:upgradeCodec	Lio/netty/handler/codec/http/HttpClientUpgradeHandler$UpgradeCodec;
    //   204: invokeinterface 79 1 0
    //   209: aload 4
    //   211: invokestatic 221	io/netty/util/AsciiString:contentEqualsIgnoreCase	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   214: ifeq +6 -> 220
    //   217: goto +65 -> 282
    //   220: aload_2
    //   221: astore 5
    //   223: new 223	java/lang/IllegalStateException
    //   226: astore_3
    //   227: aload_2
    //   228: astore 5
    //   230: new 100	java/lang/StringBuilder
    //   233: astore 6
    //   235: aload_2
    //   236: astore 5
    //   238: aload 6
    //   240: invokespecial 102	java/lang/StringBuilder:<init>	()V
    //   243: aload_2
    //   244: astore 5
    //   246: aload 6
    //   248: ldc -31
    //   250: invokevirtual 228	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: pop
    //   254: aload_2
    //   255: astore 5
    //   257: aload 6
    //   259: aload 4
    //   261: invokevirtual 231	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload_2
    //   266: astore 5
    //   268: aload_3
    //   269: aload 6
    //   271: invokevirtual 134	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   274: invokespecial 234	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   277: aload_2
    //   278: astore 5
    //   280: aload_3
    //   281: athrow
    //   282: aload_2
    //   283: astore 5
    //   285: aload_0
    //   286: getfield 40	io/netty/handler/codec/http/HttpClientUpgradeHandler:sourceCodec	Lio/netty/handler/codec/http/HttpClientUpgradeHandler$SourceCodec;
    //   289: aload_1
    //   290: invokeinterface 237 2 0
    //   295: aload_2
    //   296: astore 5
    //   298: aload_0
    //   299: getfield 43	io/netty/handler/codec/http/HttpClientUpgradeHandler:upgradeCodec	Lio/netty/handler/codec/http/HttpClientUpgradeHandler$UpgradeCodec;
    //   302: aload_1
    //   303: aload_2
    //   304: invokeinterface 241 3 0
    //   309: aload_2
    //   310: astore 5
    //   312: aload_1
    //   313: getstatic 244	io/netty/handler/codec/http/HttpClientUpgradeHandler$UpgradeEvent:UPGRADE_SUCCESSFUL	Lio/netty/handler/codec/http/HttpClientUpgradeHandler$UpgradeEvent;
    //   316: invokeinterface 185 2 0
    //   321: pop
    //   322: aload_2
    //   323: astore 5
    //   325: aload_0
    //   326: getfield 40	io/netty/handler/codec/http/HttpClientUpgradeHandler:sourceCodec	Lio/netty/handler/codec/http/HttpClientUpgradeHandler$SourceCodec;
    //   329: aload_1
    //   330: invokeinterface 247 2 0
    //   335: aload_2
    //   336: astore 5
    //   338: aload_2
    //   339: invokeinterface 252 1 0
    //   344: pop
    //   345: aload_2
    //   346: astore 5
    //   348: aload_3
    //   349: invokeinterface 255 1 0
    //   354: aload_2
    //   355: astore 5
    //   357: aload_1
    //   358: invokestatic 187	io/netty/handler/codec/http/HttpClientUpgradeHandler:removeThisHandler	(Lio/netty/channel/ChannelHandlerContext;)V
    //   361: goto +49 -> 410
    //   364: aload 4
    //   366: astore 5
    //   368: new 223	java/lang/IllegalStateException
    //   371: astore_2
    //   372: aload 4
    //   374: astore 5
    //   376: aload_2
    //   377: ldc_w 257
    //   380: invokespecial 234	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   383: aload 4
    //   385: astore 5
    //   387: aload_2
    //   388: athrow
    //   389: astore_3
    //   390: aload 5
    //   392: astore_2
    //   393: aload_2
    //   394: invokestatic 261	io/netty/util/ReferenceCountUtil:release	(Ljava/lang/Object;)Z
    //   397: pop
    //   398: aload_1
    //   399: aload_3
    //   400: invokeinterface 265 2 0
    //   405: pop
    //   406: aload_1
    //   407: invokestatic 187	io/netty/handler/codec/http/HttpClientUpgradeHandler:removeThisHandler	(Lio/netty/channel/ChannelHandlerContext;)V
    //   410: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	411	0	this	HttpClientUpgradeHandler
    //   0	411	1	paramChannelHandlerContext	ChannelHandlerContext
    //   0	411	2	paramHttpObject	HttpObject
    //   0	411	3	paramList	java.util.List<Object>
    //   1	383	4	str	String
    //   5	386	5	localObject1	Object
    //   33	237	6	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   110	125	128	finally
    //   7	14	389	finally
    //   18	25	389	finally
    //   29	35	389	finally
    //   39	55	389	finally
    //   59	69	389	finally
    //   73	77	389	finally
    //   81	89	389	finally
    //   94	101	389	finally
    //   105	110	389	finally
    //   136	143	389	finally
    //   147	156	389	finally
    //   161	172	389	finally
    //   178	192	389	finally
    //   200	217	389	finally
    //   223	227	389	finally
    //   230	235	389	finally
    //   238	243	389	finally
    //   246	254	389	finally
    //   257	265	389	finally
    //   268	277	389	finally
    //   280	282	389	finally
    //   285	295	389	finally
    //   298	309	389	finally
    //   312	322	389	finally
    //   325	335	389	finally
    //   338	345	389	finally
    //   348	354	389	finally
    //   357	361	389	finally
    //   368	372	389	finally
    //   376	383	389	finally
    //   387	389	389	finally
  }
  
  public void deregister(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.deregister(paramChannelPromise);
  }
  
  public void disconnect(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    paramChannelHandlerContext.disconnect(paramChannelPromise);
  }
  
  public void flush(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext.flush();
  }
  
  public void read(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    paramChannelHandlerContext.read();
  }
  
  public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
    throws Exception
  {
    if (!(paramObject instanceof HttpRequest))
    {
      paramChannelHandlerContext.write(paramObject, paramChannelPromise);
      return;
    }
    if (this.upgradeRequested)
    {
      paramChannelPromise.setFailure(new IllegalStateException("Attempting to write HTTP request with upgrade in progress"));
      return;
    }
    this.upgradeRequested = true;
    setUpgradeRequestHeaders(paramChannelHandlerContext, (HttpRequest)paramObject);
    paramChannelHandlerContext.write(paramObject, paramChannelPromise);
    paramChannelHandlerContext.fireUserEventTriggered(UpgradeEvent.UPGRADE_ISSUED);
  }
  
  public static abstract interface SourceCodec
  {
    public abstract void prepareUpgradeFrom(ChannelHandlerContext paramChannelHandlerContext);
    
    public abstract void upgradeFrom(ChannelHandlerContext paramChannelHandlerContext);
  }
  
  public static abstract interface UpgradeCodec
  {
    public abstract CharSequence protocol();
    
    public abstract Collection<CharSequence> setUpgradeHeaders(ChannelHandlerContext paramChannelHandlerContext, HttpRequest paramHttpRequest);
    
    public abstract void upgradeTo(ChannelHandlerContext paramChannelHandlerContext, FullHttpResponse paramFullHttpResponse)
      throws Exception;
  }
  
  public static enum UpgradeEvent
  {
    static
    {
      UpgradeEvent localUpgradeEvent1 = new UpgradeEvent("UPGRADE_ISSUED", 0);
      UPGRADE_ISSUED = localUpgradeEvent1;
      UpgradeEvent localUpgradeEvent2 = new UpgradeEvent("UPGRADE_SUCCESSFUL", 1);
      UPGRADE_SUCCESSFUL = localUpgradeEvent2;
      UpgradeEvent localUpgradeEvent3 = new UpgradeEvent("UPGRADE_REJECTED", 2);
      UPGRADE_REJECTED = localUpgradeEvent3;
      $VALUES = new UpgradeEvent[] { localUpgradeEvent1, localUpgradeEvent2, localUpgradeEvent3 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http\HttpClientUpgradeHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */