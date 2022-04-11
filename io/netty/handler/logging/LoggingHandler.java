package io.netty.handler.logging;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelDuplexHandler;
import io.netty.channel.ChannelHandler.a;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundInvoker;
import io.netty.channel.ChannelPromise;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import io.netty.util.internal.logging.InternalLogLevel;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.SocketAddress;

@ChannelHandler.a
public class LoggingHandler
  extends ChannelDuplexHandler
{
  private static final LogLevel DEFAULT_LEVEL = LogLevel.DEBUG;
  private final ByteBufFormat byteBufFormat;
  protected final InternalLogLevel internalLevel;
  private final LogLevel level;
  protected final InternalLogger logger;
  
  public LoggingHandler()
  {
    this(DEFAULT_LEVEL);
  }
  
  public LoggingHandler(LogLevel paramLogLevel)
  {
    this(paramLogLevel, ByteBufFormat.HEX_DUMP);
  }
  
  public LoggingHandler(LogLevel paramLogLevel, ByteBufFormat paramByteBufFormat)
  {
    this.level = ((LogLevel)ObjectUtil.checkNotNull(paramLogLevel, "level"));
    this.byteBufFormat = ((ByteBufFormat)ObjectUtil.checkNotNull(paramByteBufFormat, "byteBufFormat"));
    this.logger = InternalLoggerFactory.getInstance(getClass());
    this.internalLevel = paramLogLevel.toInternalLevel();
  }
  
  public LoggingHandler(Class<?> paramClass)
  {
    this(paramClass, DEFAULT_LEVEL);
  }
  
  public LoggingHandler(Class<?> paramClass, LogLevel paramLogLevel)
  {
    this(paramClass, paramLogLevel, ByteBufFormat.HEX_DUMP);
  }
  
  public LoggingHandler(Class<?> paramClass, LogLevel paramLogLevel, ByteBufFormat paramByteBufFormat)
  {
    ObjectUtil.checkNotNull(paramClass, "clazz");
    this.level = ((LogLevel)ObjectUtil.checkNotNull(paramLogLevel, "level"));
    this.byteBufFormat = ((ByteBufFormat)ObjectUtil.checkNotNull(paramByteBufFormat, "byteBufFormat"));
    this.logger = InternalLoggerFactory.getInstance(paramClass);
    this.internalLevel = paramLogLevel.toInternalLevel();
  }
  
  public LoggingHandler(String paramString)
  {
    this(paramString, DEFAULT_LEVEL);
  }
  
  public LoggingHandler(String paramString, LogLevel paramLogLevel)
  {
    this(paramString, paramLogLevel, ByteBufFormat.HEX_DUMP);
  }
  
  public LoggingHandler(String paramString, LogLevel paramLogLevel, ByteBufFormat paramByteBufFormat)
  {
    ObjectUtil.checkNotNull(paramString, "name");
    this.level = ((LogLevel)ObjectUtil.checkNotNull(paramLogLevel, "level"));
    this.byteBufFormat = ((ByteBufFormat)ObjectUtil.checkNotNull(paramByteBufFormat, "byteBufFormat"));
    this.logger = InternalLoggerFactory.getInstance(paramString);
    this.internalLevel = paramLogLevel.toInternalLevel();
  }
  
  private String formatByteBuf(ChannelHandlerContext paramChannelHandlerContext, String paramString, ByteBuf paramByteBuf)
  {
    paramChannelHandlerContext = paramChannelHandlerContext.channel().toString();
    int i = paramByteBuf.readableBytes();
    int j = 1;
    if (i == 0)
    {
      paramByteBuf = new StringBuilder(paramChannelHandlerContext.length() + 1 + paramString.length() + 4);
      paramByteBuf.append(paramChannelHandlerContext);
      paramByteBuf.append(' ');
      paramByteBuf.append(paramString);
      paramByteBuf.append(": 0B");
      return paramByteBuf.toString();
    }
    int k = paramChannelHandlerContext.length() + 1 + paramString.length() + 2 + 10 + 1;
    Object localObject = this.byteBufFormat;
    ByteBufFormat localByteBufFormat = ByteBufFormat.HEX_DUMP;
    int m = k;
    if (localObject == localByteBufFormat)
    {
      int n = i / 16;
      m = j;
      if (i % 15 == 0) {
        m = 0;
      }
      m = k + ((n + m + 4) * 80 + 2);
    }
    localObject = new StringBuilder(m);
    ((StringBuilder)localObject).append(paramChannelHandlerContext);
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(": ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append('B');
    if (this.byteBufFormat == localByteBufFormat)
    {
      ((StringBuilder)localObject).append(StringUtil.NEWLINE);
      ByteBufUtil.appendPrettyHexDump((StringBuilder)localObject, paramByteBuf);
    }
    return ((StringBuilder)localObject).toString();
  }
  
  private String formatByteBufHolder(ChannelHandlerContext paramChannelHandlerContext, String paramString, ByteBufHolder paramByteBufHolder)
  {
    paramChannelHandlerContext = paramChannelHandlerContext.channel().toString();
    String str = paramByteBufHolder.toString();
    paramByteBufHolder = paramByteBufHolder.content();
    int i = paramByteBufHolder.readableBytes();
    int j = 1;
    if (i == 0)
    {
      paramByteBufHolder = new StringBuilder(paramChannelHandlerContext.length() + 1 + paramString.length() + 2 + str.length() + 4);
      paramByteBufHolder.append(paramChannelHandlerContext);
      paramByteBufHolder.append(' ');
      paramByteBufHolder.append(paramString);
      paramByteBufHolder.append(", ");
      paramByteBufHolder.append(str);
      paramByteBufHolder.append(", 0B");
      return paramByteBufHolder.toString();
    }
    int k = paramChannelHandlerContext.length() + 1 + paramString.length() + 2 + str.length() + 2 + 10 + 1;
    Object localObject = this.byteBufFormat;
    ByteBufFormat localByteBufFormat = ByteBufFormat.HEX_DUMP;
    int m = k;
    if (localObject == localByteBufFormat)
    {
      int n = i / 16;
      m = j;
      if (i % 15 == 0) {
        m = 0;
      }
      m = k + ((n + m + 4) * 80 + 2);
    }
    localObject = new StringBuilder(m);
    ((StringBuilder)localObject).append(paramChannelHandlerContext);
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(": ");
    ((StringBuilder)localObject).append(str);
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append('B');
    if (this.byteBufFormat == localByteBufFormat)
    {
      ((StringBuilder)localObject).append(StringUtil.NEWLINE);
      ByteBufUtil.appendPrettyHexDump((StringBuilder)localObject, paramByteBufHolder);
    }
    return ((StringBuilder)localObject).toString();
  }
  
  private static String formatSimple(ChannelHandlerContext paramChannelHandlerContext, String paramString, Object paramObject)
  {
    paramChannelHandlerContext = paramChannelHandlerContext.channel().toString();
    paramObject = String.valueOf(paramObject);
    StringBuilder localStringBuilder = new StringBuilder(paramChannelHandlerContext.length() + 1 + paramString.length() + 2 + ((String)paramObject).length());
    localStringBuilder.append(paramChannelHandlerContext);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramString);
    localStringBuilder.append(": ");
    localStringBuilder.append((String)paramObject);
    return localStringBuilder.toString();
  }
  
  public void bind(ChannelHandlerContext paramChannelHandlerContext, SocketAddress paramSocketAddress, ChannelPromise paramChannelPromise)
    throws Exception
  {
    if (this.logger.isEnabled(this.internalLevel)) {
      this.logger.log(this.internalLevel, format(paramChannelHandlerContext, "BIND", paramSocketAddress));
    }
    paramChannelHandlerContext.bind(paramSocketAddress, paramChannelPromise);
  }
  
  public ByteBufFormat byteBufFormat()
  {
    return this.byteBufFormat;
  }
  
  public void channelActive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (this.logger.isEnabled(this.internalLevel)) {
      this.logger.log(this.internalLevel, format(paramChannelHandlerContext, "ACTIVE"));
    }
    paramChannelHandlerContext.fireChannelActive();
  }
  
  public void channelInactive(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (this.logger.isEnabled(this.internalLevel)) {
      this.logger.log(this.internalLevel, format(paramChannelHandlerContext, "INACTIVE"));
    }
    paramChannelHandlerContext.fireChannelInactive();
  }
  
  public void channelRead(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    if (this.logger.isEnabled(this.internalLevel)) {
      this.logger.log(this.internalLevel, format(paramChannelHandlerContext, "READ", paramObject));
    }
    paramChannelHandlerContext.fireChannelRead(paramObject);
  }
  
  public void channelReadComplete(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (this.logger.isEnabled(this.internalLevel)) {
      this.logger.log(this.internalLevel, format(paramChannelHandlerContext, "READ COMPLETE"));
    }
    paramChannelHandlerContext.fireChannelReadComplete();
  }
  
  public void channelRegistered(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (this.logger.isEnabled(this.internalLevel)) {
      this.logger.log(this.internalLevel, format(paramChannelHandlerContext, "REGISTERED"));
    }
    paramChannelHandlerContext.fireChannelRegistered();
  }
  
  public void channelUnregistered(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (this.logger.isEnabled(this.internalLevel)) {
      this.logger.log(this.internalLevel, format(paramChannelHandlerContext, "UNREGISTERED"));
    }
    paramChannelHandlerContext.fireChannelUnregistered();
  }
  
  public void channelWritabilityChanged(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (this.logger.isEnabled(this.internalLevel)) {
      this.logger.log(this.internalLevel, format(paramChannelHandlerContext, "WRITABILITY CHANGED"));
    }
    paramChannelHandlerContext.fireChannelWritabilityChanged();
  }
  
  public void close(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    if (this.logger.isEnabled(this.internalLevel)) {
      this.logger.log(this.internalLevel, format(paramChannelHandlerContext, "CLOSE"));
    }
    paramChannelHandlerContext.close(paramChannelPromise);
  }
  
  public void connect(ChannelHandlerContext paramChannelHandlerContext, SocketAddress paramSocketAddress1, SocketAddress paramSocketAddress2, ChannelPromise paramChannelPromise)
    throws Exception
  {
    if (this.logger.isEnabled(this.internalLevel)) {
      this.logger.log(this.internalLevel, format(paramChannelHandlerContext, "CONNECT", paramSocketAddress1, paramSocketAddress2));
    }
    paramChannelHandlerContext.connect(paramSocketAddress1, paramSocketAddress2, paramChannelPromise);
  }
  
  public void deregister(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    if (this.logger.isEnabled(this.internalLevel)) {
      this.logger.log(this.internalLevel, format(paramChannelHandlerContext, "DEREGISTER"));
    }
    paramChannelHandlerContext.deregister(paramChannelPromise);
  }
  
  public void disconnect(ChannelHandlerContext paramChannelHandlerContext, ChannelPromise paramChannelPromise)
    throws Exception
  {
    if (this.logger.isEnabled(this.internalLevel)) {
      this.logger.log(this.internalLevel, format(paramChannelHandlerContext, "DISCONNECT"));
    }
    paramChannelHandlerContext.disconnect(paramChannelPromise);
  }
  
  public void exceptionCaught(ChannelHandlerContext paramChannelHandlerContext, Throwable paramThrowable)
    throws Exception
  {
    if (this.logger.isEnabled(this.internalLevel)) {
      this.logger.log(this.internalLevel, format(paramChannelHandlerContext, "EXCEPTION", paramThrowable), paramThrowable);
    }
    paramChannelHandlerContext.fireExceptionCaught(paramThrowable);
  }
  
  public void flush(ChannelHandlerContext paramChannelHandlerContext)
    throws Exception
  {
    if (this.logger.isEnabled(this.internalLevel)) {
      this.logger.log(this.internalLevel, format(paramChannelHandlerContext, "FLUSH"));
    }
    paramChannelHandlerContext.flush();
  }
  
  protected String format(ChannelHandlerContext paramChannelHandlerContext, String paramString)
  {
    paramChannelHandlerContext = paramChannelHandlerContext.channel().toString();
    StringBuilder localStringBuilder = new StringBuilder(paramChannelHandlerContext.length() + 1 + paramString.length());
    localStringBuilder.append(paramChannelHandlerContext);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  protected String format(ChannelHandlerContext paramChannelHandlerContext, String paramString, Object paramObject)
  {
    if ((paramObject instanceof ByteBuf)) {
      return formatByteBuf(paramChannelHandlerContext, paramString, (ByteBuf)paramObject);
    }
    if ((paramObject instanceof ByteBufHolder)) {
      return formatByteBufHolder(paramChannelHandlerContext, paramString, (ByteBufHolder)paramObject);
    }
    return formatSimple(paramChannelHandlerContext, paramString, paramObject);
  }
  
  protected String format(ChannelHandlerContext paramChannelHandlerContext, String paramString, Object paramObject1, Object paramObject2)
  {
    if (paramObject2 == null) {
      return formatSimple(paramChannelHandlerContext, paramString, paramObject1);
    }
    paramChannelHandlerContext = paramChannelHandlerContext.channel().toString();
    paramObject1 = String.valueOf(paramObject1);
    paramObject2 = paramObject2.toString();
    StringBuilder localStringBuilder = new StringBuilder(paramChannelHandlerContext.length() + 1 + paramString.length() + 2 + ((String)paramObject1).length() + 2 + ((String)paramObject2).length());
    localStringBuilder.append(paramChannelHandlerContext);
    localStringBuilder.append(' ');
    localStringBuilder.append(paramString);
    localStringBuilder.append(": ");
    localStringBuilder.append((String)paramObject1);
    localStringBuilder.append(", ");
    localStringBuilder.append((String)paramObject2);
    return localStringBuilder.toString();
  }
  
  public LogLevel level()
  {
    return this.level;
  }
  
  public void userEventTriggered(ChannelHandlerContext paramChannelHandlerContext, Object paramObject)
    throws Exception
  {
    if (this.logger.isEnabled(this.internalLevel)) {
      this.logger.log(this.internalLevel, format(paramChannelHandlerContext, "USER_EVENT", paramObject));
    }
    paramChannelHandlerContext.fireUserEventTriggered(paramObject);
  }
  
  public void write(ChannelHandlerContext paramChannelHandlerContext, Object paramObject, ChannelPromise paramChannelPromise)
    throws Exception
  {
    if (this.logger.isEnabled(this.internalLevel)) {
      this.logger.log(this.internalLevel, format(paramChannelHandlerContext, "WRITE", paramObject));
    }
    paramChannelHandlerContext.write(paramObject, paramChannelPromise);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\logging\LoggingHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */