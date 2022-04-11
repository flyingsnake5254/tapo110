package com.jcraft.jsch.jce;

public class AES192CBC
  implements com.jcraft.jsch.Cipher
{
  private static final int bsize = 24;
  private static final int ivsize = 16;
  private javax.crypto.Cipher cipher;
  
  public int getBlockSize()
  {
    return 24;
  }
  
  public int getIVSize()
  {
    return 16;
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
    //   5: bipush 16
    //   7: if_icmple +19 -> 26
    //   10: bipush 16
    //   12: newarray <illegal type>
    //   14: astore 4
    //   16: aload_3
    //   17: iconst_0
    //   18: aload 4
    //   20: iconst_0
    //   21: bipush 16
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
    //   49: new 33	javax/crypto/spec/SecretKeySpec
    //   52: astore_2
    //   53: aload_2
    //   54: aload_3
    //   55: ldc 35
    //   57: invokespecial 38	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   60: new 40	java/lang/StringBuilder
    //   63: astore_3
    //   64: aload_3
    //   65: invokespecial 41	java/lang/StringBuilder:<init>	()V
    //   68: aload_3
    //   69: ldc 43
    //   71: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload_3
    //   76: ldc 49
    //   78: invokevirtual 47	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_0
    //   83: aload_3
    //   84: invokevirtual 53	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 59	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   90: putfield 61	com/jcraft/jsch/jce/AES192CBC:cipher	Ljavax/crypto/Cipher;
    //   93: ldc 55
    //   95: monitorenter
    //   96: aload_0
    //   97: getfield 61	com/jcraft/jsch/jce/AES192CBC:cipher	Ljavax/crypto/Cipher;
    //   100: astore 5
    //   102: iload_1
    //   103: ifne +8 -> 111
    //   106: iconst_1
    //   107: istore_1
    //   108: goto +5 -> 113
    //   111: iconst_2
    //   112: istore_1
    //   113: new 63	javax/crypto/spec/IvParameterSpec
    //   116: astore_3
    //   117: aload_3
    //   118: aload 4
    //   120: invokespecial 66	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   123: aload 5
    //   125: iload_1
    //   126: aload_2
    //   127: aload_3
    //   128: invokevirtual 69	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   131: ldc 55
    //   133: monitorexit
    //   134: return
    //   135: astore_2
    //   136: ldc 55
    //   138: monitorexit
    //   139: aload_2
    //   140: athrow
    //   141: astore_2
    //   142: aload_0
    //   143: aconst_null
    //   144: putfield 61	com/jcraft/jsch/jce/AES192CBC:cipher	Ljavax/crypto/Cipher;
    //   147: aload_2
    //   148: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	149	0	this	AES192CBC
    //   0	149	1	paramInt	int
    //   0	149	2	paramArrayOfByte1	byte[]
    //   0	149	3	paramArrayOfByte2	byte[]
    //   1	118	4	arrayOfByte	byte[]
    //   100	24	5	localCipher	javax.crypto.Cipher
    // Exception table:
    //   from	to	target	type
    //   96	102	135	finally
    //   113	134	135	finally
    //   136	139	135	finally
    //   49	96	141	java/lang/Exception
    //   139	141	141	java/lang/Exception
  }
  
  public boolean isCBC()
  {
    return true;
  }
  
  public void update(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws Exception
  {
    this.cipher.update(paramArrayOfByte1, paramInt1, paramInt2, paramArrayOfByte2, paramInt3);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jce\AES192CBC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */