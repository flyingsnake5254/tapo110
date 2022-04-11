package com.jcraft.jsch.jce;

public class ARCFOUR256
  implements com.jcraft.jsch.Cipher
{
  private static final int bsize = 32;
  private static final int ivsize = 8;
  private static final int skip = 1536;
  private javax.crypto.Cipher cipher;
  
  public int getBlockSize()
  {
    return 32;
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
    //   1: arraylength
    //   2: istore 4
    //   4: iconst_0
    //   5: istore 5
    //   7: aload_2
    //   8: astore_3
    //   9: iload 4
    //   11: bipush 32
    //   13: if_icmple +17 -> 30
    //   16: bipush 32
    //   18: newarray <illegal type>
    //   20: astore_3
    //   21: aload_2
    //   22: iconst_0
    //   23: aload_3
    //   24: iconst_0
    //   25: bipush 32
    //   27: invokestatic 33	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   30: aload_0
    //   31: ldc 35
    //   33: invokestatic 41	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   36: putfield 43	com/jcraft/jsch/jce/ARCFOUR256:cipher	Ljavax/crypto/Cipher;
    //   39: new 45	javax/crypto/spec/SecretKeySpec
    //   42: astore_2
    //   43: aload_2
    //   44: aload_3
    //   45: ldc 35
    //   47: invokespecial 48	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   50: ldc 37
    //   52: monitorenter
    //   53: aload_0
    //   54: getfield 43	com/jcraft/jsch/jce/ARCFOUR256:cipher	Ljavax/crypto/Cipher;
    //   57: astore_3
    //   58: iload_1
    //   59: ifne +8 -> 67
    //   62: iconst_1
    //   63: istore_1
    //   64: goto +5 -> 69
    //   67: iconst_2
    //   68: istore_1
    //   69: aload_3
    //   70: iload_1
    //   71: aload_2
    //   72: invokevirtual 51	javax/crypto/Cipher:init	(ILjava/security/Key;)V
    //   75: ldc 37
    //   77: monitorexit
    //   78: iconst_1
    //   79: newarray <illegal type>
    //   81: astore_2
    //   82: iload 5
    //   84: istore_1
    //   85: iload_1
    //   86: sipush 1536
    //   89: if_icmpge +22 -> 111
    //   92: aload_0
    //   93: getfield 43	com/jcraft/jsch/jce/ARCFOUR256:cipher	Ljavax/crypto/Cipher;
    //   96: aload_2
    //   97: iconst_0
    //   98: iconst_1
    //   99: aload_2
    //   100: iconst_0
    //   101: invokevirtual 55	javax/crypto/Cipher:update	([BII[BI)I
    //   104: pop
    //   105: iinc 1 1
    //   108: goto -23 -> 85
    //   111: return
    //   112: astore_2
    //   113: ldc 37
    //   115: monitorexit
    //   116: aload_2
    //   117: athrow
    //   118: astore_2
    //   119: aload_0
    //   120: aconst_null
    //   121: putfield 43	com/jcraft/jsch/jce/ARCFOUR256:cipher	Ljavax/crypto/Cipher;
    //   124: aload_2
    //   125: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	126	0	this	ARCFOUR256
    //   0	126	1	paramInt	int
    //   0	126	2	paramArrayOfByte1	byte[]
    //   0	126	3	paramArrayOfByte2	byte[]
    //   2	12	4	i	int
    //   5	78	5	j	int
    // Exception table:
    //   from	to	target	type
    //   53	58	112	finally
    //   69	78	112	finally
    //   113	116	112	finally
    //   30	53	118	java/lang/Exception
    //   78	82	118	java/lang/Exception
    //   92	105	118	java/lang/Exception
    //   116	118	118	java/lang/Exception
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jce\ARCFOUR256.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */