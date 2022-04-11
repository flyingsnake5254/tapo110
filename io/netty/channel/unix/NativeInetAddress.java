package io.netty.channel.unix;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

public final class NativeInetAddress
{
  private static final byte[] IPV4_MAPPED_IPV6_PREFIX = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1 };
  final byte[] address;
  final int scopeId;
  
  public NativeInetAddress(byte[] paramArrayOfByte)
  {
    this(paramArrayOfByte, 0);
  }
  
  public NativeInetAddress(byte[] paramArrayOfByte, int paramInt)
  {
    this.address = paramArrayOfByte;
    this.scopeId = paramInt;
  }
  
  public static InetSocketAddress address(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt1 + paramInt2;
    int j = decodeInt(paramArrayOfByte, i - 4);
    if ((paramInt2 == 8) || (paramInt2 == 24)) {}
    try
    {
      byte[] arrayOfByte = new byte[16];
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, 16);
      paramArrayOfByte = Inet6Address.getByAddress(null, arrayOfByte, decodeInt(paramArrayOfByte, i - 8));
      break label89;
      paramArrayOfByte = new java/lang/Error;
      paramArrayOfByte.<init>();
      throw paramArrayOfByte;
      arrayOfByte = new byte[4];
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, 4);
      paramArrayOfByte = InetAddress.getByAddress(arrayOfByte);
      label89:
      paramArrayOfByte = new InetSocketAddress(paramArrayOfByte, j);
      return paramArrayOfByte;
    }
    catch (UnknownHostException paramArrayOfByte)
    {
      throw new Error("Should never happen", paramArrayOfByte);
    }
  }
  
  public static void copyIpv4MappedIpv6Address(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = IPV4_MAPPED_IPV6_PREFIX;
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte2, 0, arrayOfByte.length);
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte2, 12, paramArrayOfByte1.length);
  }
  
  static int decodeInt(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte[paramInt];
    int j = paramArrayOfByte[(paramInt + 1)];
    int k = paramArrayOfByte[(paramInt + 2)];
    return paramArrayOfByte[(paramInt + 3)] & 0xFF | (i & 0xFF) << 24 | (j & 0xFF) << 16 | (k & 0xFF) << 8;
  }
  
  public static byte[] ipv4MappedIpv6Address(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[16];
    copyIpv4MappedIpv6Address(paramArrayOfByte, arrayOfByte);
    return arrayOfByte;
  }
  
  public static NativeInetAddress newInstance(InetAddress paramInetAddress)
  {
    byte[] arrayOfByte = paramInetAddress.getAddress();
    if ((paramInetAddress instanceof Inet6Address)) {
      return new NativeInetAddress(arrayOfByte, ((Inet6Address)paramInetAddress).getScopeId());
    }
    return new NativeInetAddress(ipv4MappedIpv6Address(arrayOfByte));
  }
  
  public byte[] address()
  {
    return this.address;
  }
  
  public int scopeId()
  {
    return this.scopeId;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\unix\NativeInetAddress.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */