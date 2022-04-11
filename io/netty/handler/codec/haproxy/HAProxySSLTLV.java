package io.netty.handler.codec.haproxy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.internal.StringUtil;
import java.util.Collections;
import java.util.List;

public final class HAProxySSLTLV
  extends HAProxyTLV
{
  private final byte clientBitField;
  private final List<HAProxyTLV> tlvs;
  private final int verify;
  
  public HAProxySSLTLV(int paramInt, byte paramByte, List<HAProxyTLV> paramList)
  {
    this(paramInt, paramByte, paramList, Unpooled.EMPTY_BUFFER);
  }
  
  HAProxySSLTLV(int paramInt, byte paramByte, List<HAProxyTLV> paramList, ByteBuf paramByteBuf)
  {
    super(HAProxyTLV.Type.PP2_TYPE_SSL, (byte)32, paramByteBuf);
    this.verify = paramInt;
    this.tlvs = Collections.unmodifiableList(paramList);
    this.clientBitField = ((byte)paramByte);
  }
  
  public byte client()
  {
    return this.clientBitField;
  }
  
  int contentNumBytes()
  {
    int i = 0;
    int j = 0;
    while (i < this.tlvs.size())
    {
      j += ((HAProxyTLV)this.tlvs.get(i)).totalNumBytes();
      i++;
    }
    return j + 5;
  }
  
  public List<HAProxyTLV> encapsulatedTLVs()
  {
    return this.tlvs;
  }
  
  public boolean isPP2ClientCertConn()
  {
    boolean bool;
    if ((this.clientBitField & 0x2) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isPP2ClientCertSess()
  {
    boolean bool;
    if ((this.clientBitField & 0x4) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isPP2ClientSSL()
  {
    int i = this.clientBitField;
    boolean bool = true;
    if ((i & 0x1) == 0) {
      bool = false;
    }
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append("(type: ");
    localStringBuilder.append(type());
    localStringBuilder.append(", typeByteValue: ");
    localStringBuilder.append(typeByteValue());
    localStringBuilder.append(", client: ");
    localStringBuilder.append(client());
    localStringBuilder.append(", verify: ");
    localStringBuilder.append(verify());
    localStringBuilder.append(", numEncapsulatedTlvs: ");
    localStringBuilder.append(this.tlvs.size());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  public int verify()
  {
    return this.verify;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\haproxy\HAProxySSLTLV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */