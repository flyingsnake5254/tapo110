package io.netty.handler.codec.stomp;

import io.netty.handler.codec.DecoderResult;
import io.netty.util.internal.ObjectUtil;

public class DefaultStompHeadersSubframe
  implements StompHeadersSubframe
{
  protected final StompCommand command;
  protected DecoderResult decoderResult = DecoderResult.SUCCESS;
  protected final DefaultStompHeaders headers;
  
  public DefaultStompHeadersSubframe(StompCommand paramStompCommand)
  {
    this(paramStompCommand, null);
  }
  
  DefaultStompHeadersSubframe(StompCommand paramStompCommand, DefaultStompHeaders paramDefaultStompHeaders)
  {
    this.command = ((StompCommand)ObjectUtil.checkNotNull(paramStompCommand, "command"));
    paramStompCommand = paramDefaultStompHeaders;
    if (paramDefaultStompHeaders == null) {
      paramStompCommand = new DefaultStompHeaders();
    }
    this.headers = paramStompCommand;
  }
  
  public StompCommand command()
  {
    return this.command;
  }
  
  public DecoderResult decoderResult()
  {
    return this.decoderResult;
  }
  
  public StompHeaders headers()
  {
    return this.headers;
  }
  
  public void setDecoderResult(DecoderResult paramDecoderResult)
  {
    this.decoderResult = paramDecoderResult;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StompFrame{command=");
    localStringBuilder.append(this.command);
    localStringBuilder.append(", headers=");
    localStringBuilder.append(this.headers);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\stomp\DefaultStompHeadersSubframe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */