package com.jcraft.jsch.jce;

public class TripleDESCTR
  implements com.jcraft.jsch.Cipher
{
  private static final int bsize = 24;
  private static final int ivsize = 8;
  private javax.crypto.Cipher cipher;
  
  public int getBlockSize()
  {
    return 24;
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
    //   0: aload_3
    //   1: astore 4
    //   3: aload_3
    //   4: arraylength
    //   5: bipush 8
    //   7: if_icmple +19 -> 26
    //   10: bipush 8
    //   12: newarray <illegal type>
    //   14: astore 4
    //   16: aload_3
    //   17: iconst_0
    //   18: aload 4
    //   20: iconst_0
    //   21: bipush 8
    //   23: invokestatic 31	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   26: aload_2
    //   27: astore_3
    //   28: aload_2
    //   29: arraylength
    //   30: bipush 24
    //   32: if_icmple +17 -> 49
    //   35: bipush 24
    //   37: newarray <illegal type>
    //   39: astore_3
    //   40: aload_2
    //   41: iconst_0
    //   42: aload_3
    //   43: iconst_0
    //   44: bipush 24
    //   46: invokestatic 31	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   49: new 33	java/lang/StringBuilder
    //   52: astore_2
    //   53: aload_2
    //   54: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   57: aload_2
    //   58: ldc 36
    //   60: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_2
    //   65: ldc 42
    //   67: invokevirtual 40	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_0
    //   72: aload_2
    //   73: invokevirtual 46	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 52	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   79: putfield 54	com/jcraft/jsch/jce/TripleDESCTR:cipher	Ljavax/crypto/Cipher;
    //   82: new 56	javax/crypto/spec/DESedeKeySpec
    //   85: astore_2
    //   86: aload_2
    //   87: aload_3
    //   88: invokespecial 59	javax/crypto/spec/DESedeKeySpec:<init>	([B)V
    //   91: ldc 61
    //   93: invokestatic 66	javax/crypto/SecretKeyFactory:getInstance	(Ljava/lang/String;)Ljavax/crypto/SecretKeyFactory;
    //   96: aload_2
    //   97: invokevirtual 70	javax/crypto/SecretKeyFactory:generateSecret	(Ljava/security/spec/KeySpec;)Ljavax/crypto/SecretKey;
    //   100: astore 5
    //   102: ldc 48
    //   104: monitorenter
    //   105: aload_0
    //   106: getfield 54	com/jcraft/jsch/jce/TripleDESCTR:cipher	Ljavax/crypto/Cipher;
    //   109: astore_3
    //   110: iload_1
    //   111: ifne +8 -> 119
    //   114: iconst_1
    //   115: istore_1
    //   116: goto +5 -> 121
    //   119: iconst_2
    //   120: istore_1
    //   121: new 72	javax/crypto/spec/IvParameterSpec
    //   124: astore_2
    //   125: aload_2
    //   126: aload 4
    //   128: invokespecial 73	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   131: aload_3
    //   132: iload_1
    //   133: aload 5
    //   135: aload_2
    //   136: invokevirtual 76	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   139: ldc 48
    //   141: monitorexit
    //   142: return
    //   143: astore_2
    //   144: ldc 48
    //   146: monitorexit
    //   147: aload_2
    //   148: athrow
    //   149: astore_2
    //   150: aload_0
    //   151: aconst_null
    //   152: putfield 54	com/jcraft/jsch/jce/TripleDESCTR:cipher	Ljavax/crypto/Cipher;
    //   155: aload_2
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	TripleDESCTR
    //   0	157	1	paramInt	int
    //   0	157	2	paramArrayOfByte1	byte[]
    //   0	157	3	paramArrayOfByte2	byte[]
    //   1	126	4	arrayOfByte	byte[]
    //   100	34	5	localSecretKey	javax.crypto.SecretKey
    // Exception table:
    //   from	to	target	type
    //   105	110	143	finally
    //   121	142	143	finally
    //   144	147	143	finally
    //   49	105	149	java/lang/Exception
    //   147	149	149	java/lang/Exception
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jce\TripleDESCTR.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */