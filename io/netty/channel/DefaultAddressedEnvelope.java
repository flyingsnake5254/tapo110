package io.netty.channel;

import io.netty.util.ReferenceCountUtil;
import io.netty.util.ReferenceCounted;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;
import java.net.SocketAddress;
import java.util.Objects;

public class DefaultAddressedEnvelope<M, A extends SocketAddress>
  implements AddressedEnvelope<M, A>
{
  private final M message;
  private final A recipient;
  private final A sender;
  
  public DefaultAddressedEnvelope(M paramM, A paramA)
  {
    this(paramM, paramA, null);
  }
  
  public DefaultAddressedEnvelope(M paramM, A paramA1, A paramA2)
  {
    ObjectUtil.checkNotNull(paramM, "message");
    if (paramA1 == null) {
      Objects.requireNonNull(paramA2, "recipient and sender");
    }
    this.message = paramM;
    this.sender = paramA2;
    this.recipient = paramA1;
  }
  
  public M content()
  {
    return (M)this.message;
  }
  
  public A recipient()
  {
    return this.recipient;
  }
  
  public int refCnt()
  {
    Object localObject = this.message;
    if ((localObject instanceof ReferenceCounted)) {
      return ((ReferenceCounted)localObject).refCnt();
    }
    return 1;
  }
  
  public boolean release()
  {
    return ReferenceCountUtil.release(this.message);
  }
  
  public boolean release(int paramInt)
  {
    return ReferenceCountUtil.release(this.message, paramInt);
  }
  
  public AddressedEnvelope<M, A> retain()
  {
    ReferenceCountUtil.retain(this.message);
    return this;
  }
  
  public AddressedEnvelope<M, A> retain(int paramInt)
  {
    ReferenceCountUtil.retain(this.message, paramInt);
    return this;
  }
  
  public A sender()
  {
    return this.sender;
  }
  
  public String toString()
  {
    if (this.sender != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(StringUtil.simpleClassName(this));
      localStringBuilder.append('(');
      localStringBuilder.append(this.sender);
      localStringBuilder.append(" => ");
      localStringBuilder.append(this.recipient);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.message);
      localStringBuilder.append(')');
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append("(=> ");
    localStringBuilder.append(this.recipient);
    localStringBuilder.append(", ");
    localStringBuilder.append(this.message);
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public AddressedEnvelope<M, A> touch()
  {
    ReferenceCountUtil.touch(this.message);
    return this;
  }
  
  public AddressedEnvelope<M, A> touch(Object paramObject)
  {
    ReferenceCountUtil.touch(this.message, paramObject);
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\DefaultAddressedEnvelope.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */