package io.netty.handler.codec.haproxy;

public enum HAProxyCommand
{
  private static final byte COMMAND_MASK = 15;
  private final byte byteValue;
  
  static
  {
    HAProxyCommand localHAProxyCommand1 = new HAProxyCommand("LOCAL", 0, (byte)0);
    LOCAL = localHAProxyCommand1;
    HAProxyCommand localHAProxyCommand2 = new HAProxyCommand("PROXY", 1, (byte)1);
    PROXY = localHAProxyCommand2;
    $VALUES = new HAProxyCommand[] { localHAProxyCommand1, localHAProxyCommand2 };
  }
  
  private HAProxyCommand(byte paramByte)
  {
    this.byteValue = ((byte)paramByte);
  }
  
  public static HAProxyCommand valueOf(byte paramByte)
  {
    int i = paramByte & 0xF;
    paramByte = (byte)i;
    if (paramByte != 0)
    {
      if (paramByte == 1) {
        return PROXY;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unknown command: ");
      localStringBuilder.append(i);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return LOCAL;
  }
  
  public byte byteValue()
  {
    return this.byteValue;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\haproxy\HAProxyCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */