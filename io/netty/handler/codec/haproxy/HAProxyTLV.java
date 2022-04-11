package io.netty.handler.codec.haproxy;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.util.internal.ObjectUtil;
import io.netty.util.internal.StringUtil;

public class HAProxyTLV
  extends DefaultByteBufHolder
{
  private final Type type;
  private final byte typeByteValue;
  
  public HAProxyTLV(byte paramByte, ByteBuf paramByteBuf)
  {
    this(Type.typeForByteValue(paramByte), paramByte, paramByteBuf);
  }
  
  HAProxyTLV(Type paramType, byte paramByte, ByteBuf paramByteBuf)
  {
    super(paramByteBuf);
    this.type = ((Type)ObjectUtil.checkNotNull(paramType, "type"));
    this.typeByteValue = ((byte)paramByte);
  }
  
  public HAProxyTLV(Type paramType, ByteBuf paramByteBuf)
  {
    this(paramType, Type.byteValueForType(paramType), paramByteBuf);
  }
  
  int contentNumBytes()
  {
    return content().readableBytes();
  }
  
  public HAProxyTLV copy()
  {
    return replace(content().copy());
  }
  
  public HAProxyTLV duplicate()
  {
    return replace(content().duplicate());
  }
  
  public HAProxyTLV replace(ByteBuf paramByteBuf)
  {
    return new HAProxyTLV(this.type, this.typeByteValue, paramByteBuf);
  }
  
  public HAProxyTLV retain()
  {
    super.retain();
    return this;
  }
  
  public HAProxyTLV retain(int paramInt)
  {
    super.retain(paramInt);
    return this;
  }
  
  public HAProxyTLV retainedDuplicate()
  {
    return replace(content().retainedDuplicate());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(StringUtil.simpleClassName(this));
    localStringBuilder.append("(type: ");
    localStringBuilder.append(type());
    localStringBuilder.append(", typeByteValue: ");
    localStringBuilder.append(typeByteValue());
    localStringBuilder.append(", content: ");
    localStringBuilder.append(contentToString());
    localStringBuilder.append(')');
    return localStringBuilder.toString();
  }
  
  int totalNumBytes()
  {
    return contentNumBytes() + 3;
  }
  
  public HAProxyTLV touch()
  {
    super.touch();
    return this;
  }
  
  public HAProxyTLV touch(Object paramObject)
  {
    super.touch(paramObject);
    return this;
  }
  
  public Type type()
  {
    return this.type;
  }
  
  public byte typeByteValue()
  {
    return this.typeByteValue;
  }
  
  public static enum Type
  {
    static
    {
      Type localType1 = new Type("PP2_TYPE_ALPN", 0);
      PP2_TYPE_ALPN = localType1;
      Type localType2 = new Type("PP2_TYPE_AUTHORITY", 1);
      PP2_TYPE_AUTHORITY = localType2;
      Type localType3 = new Type("PP2_TYPE_SSL", 2);
      PP2_TYPE_SSL = localType3;
      Type localType4 = new Type("PP2_TYPE_SSL_VERSION", 3);
      PP2_TYPE_SSL_VERSION = localType4;
      Type localType5 = new Type("PP2_TYPE_SSL_CN", 4);
      PP2_TYPE_SSL_CN = localType5;
      Type localType6 = new Type("PP2_TYPE_NETNS", 5);
      PP2_TYPE_NETNS = localType6;
      Type localType7 = new Type("OTHER", 6);
      OTHER = localType7;
      $VALUES = new Type[] { localType1, localType2, localType3, localType4, localType5, localType6, localType7 };
    }
    
    public static byte byteValueForType(Type paramType)
    {
      switch (HAProxyTLV.1.$SwitchMap$io$netty$handler$codec$haproxy$HAProxyTLV$Type[paramType.ordinal()])
      {
      default: 
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("unknown type: ");
        localStringBuilder.append(paramType);
        throw new IllegalArgumentException(localStringBuilder.toString());
      case 6: 
        return 48;
      case 5: 
        return 34;
      case 4: 
        return 33;
      case 3: 
        return 32;
      case 2: 
        return 2;
      }
      return 1;
    }
    
    public static Type typeForByteValue(byte paramByte)
    {
      if (paramByte != 1)
      {
        if (paramByte != 2)
        {
          if (paramByte != 48)
          {
            switch (paramByte)
            {
            default: 
              return OTHER;
            case 34: 
              return PP2_TYPE_SSL_CN;
            case 33: 
              return PP2_TYPE_SSL_VERSION;
            }
            return PP2_TYPE_SSL;
          }
          return PP2_TYPE_NETNS;
        }
        return PP2_TYPE_AUTHORITY;
      }
      return PP2_TYPE_ALPN;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\haproxy\HAProxyTLV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */