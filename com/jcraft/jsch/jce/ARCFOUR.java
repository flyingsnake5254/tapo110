package com.jcraft.jsch.jce;

public class ARCFOUR
  implements com.jcraft.jsch.Cipher
{
  private static final int bsize = 16;
  private static final int ivsize = 8;
  private javax.crypto.Cipher cipher;
  
  public int getBlockSize()
  {
    return 16;
  }
  
  public int getIVSize()
  {
    return 8;
  }
  
  /* Error */
  public void init(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws Exception
  {
    // Byte code:
    //   0: aload_2
    //   1: astore_3
    //   2: aload_2
    //   3: arraylength
    //   4: bipush 16
    //   6: if_icmple +17 -> 23
    //   9: bipush 16
    //   11: newarray <illegal type>
    //   13: astore_3
    //   14: aload_2
    //   15: iconst_0
    //   16: aload_3
    //   17: iconst_0
    //   18: bipush 16
    //   20: invokestatic 31	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   23: aload_0
    //   24: ldc 33
    //   26: invokestatic 39	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   29: putfield 41	com/jcraft/jsch/jce/ARCFOUR:cipher	Ljavax/crypto/Cipher;
    //   32: new 43	javax/crypto/spec/SecretKeySpec
    //   35: astore_2
    //   36: aload_2
    //   37: aload_3
    //   38: ldc 33
    //   40: invokespecial 46	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   43: ldc 35
    //   45: monitorenter
    //   46: aload_0
    //   47: getfield 41	com/jcraft/jsch/jce/ARCFOUR:cipher	Ljavax/crypto/Cipher;
    //   50: astore_3
    //   51: iload_1
    //   52: ifne +8 -> 60
    //   55: iconst_1
    //   56: istore_1
    //   57: goto +5 -> 62
    //   60: iconst_2
    //   61: istore_1
    //   62: aload_3
    //   63: iload_1
    //   64: aload_2
    //   65: invokevirtual 49	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   68: ldc 35
    //   70: monitorexit
    //   71: return
    //   72: astore_2
    //   73: ldc 35
    //   75: monitorexit
    //   76: aload_2
    //   77: athrow
    //   78: astore_2
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield 41	com/jcraft/jsch/jce/ARCFOUR:cipher	Ljavax/crypto/Cipher;
    //   84: aload_2
    //   85: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	86	0	this	ARCFOUR
    //   0	86	1	paramInt	int
    //   0	86	2	paramArrayOfByte1	byte[]
    //   0	86	3	paramArrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   46	51	72	finally
    //   62	71	72	finally
    //   73	76	72	finally
    //   23	46	78	java/lang/Exception
    //   76	78	78	java/lang/Exception
  }
  
  public boolean isCBC()
  {
    return false;
  }
  
  public void update(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws Exception
  {
    this.cipher.update(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, paramInt3);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jce\ARCFOUR.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */