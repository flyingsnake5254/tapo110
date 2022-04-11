package io.netty.handler.ssl;

import io.netty.internal.tcnative.SessionTicketKey;

public final class OpenSslSessionTicketKey
{
  public static final int AES_KEY_SIZE = 16;
  public static final int HMAC_KEY_SIZE = 16;
  public static final int NAME_SIZE = 16;
  public static final int TICKET_KEY_SIZE = 48;
  final SessionTicketKey key;
  
  public OpenSslSessionTicketKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    this.key = new SessionTicketKey((byte[])paramArrayOfByte1.clone(), (byte[])paramArrayOfByte2.clone(), (byte[])paramArrayOfByte3.clone());
  }
  
  public byte[] aesKey()
  {
    return (byte[])this.key.getAesKey().clone();
  }
  
  public byte[] hmacKey()
  {
    return (byte[])this.key.getHmacKey().clone();
  }
  
  public byte[] name()
  {
    return (byte[])this.key.getName().clone();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\ssl\OpenSslSessionTicketKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */