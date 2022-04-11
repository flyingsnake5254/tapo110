package com.jcraft.jsch.jce;

public class AES128CBC
  implements com.jcraft.jsch.Cipher
{
  private static final int bsize = 16;
  private static final int ivsize = 16;
  private javax.crypto.Cipher cipher;
  
  public int getBlockSize()
  {
    return 16;
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
    //   23: invokestatic 30	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   26: aload_2
    //   27: astore_3
    //   28: aload_2
    //   29: arraylength
    //   30: bipush 16
    //   32: if_icmple +17 -> 49
    //   35: bipush 16
    //   37: newarray <illegal type>
    //   39: astore_3
    //   40: aload_2
    //   41: iconst_0
    //   42: aload_3
    //   43: iconst_0
    //   44: bipush 16
    //   46: invokestatic 30	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   49: new 32	javax/crypto/spec/SecretKeySpec
    //   52: astore_2
    //   53: aload_2
    //   54: aload_3
    //   55: ldc 34
    //   57: invokespecial 37	javax/crypto/spec/SecretKeySpec:<init>	([BLjava/lang/String;)V
    //   60: new 39	java/lang/StringBuilder
    //   63: astore_3
    //   64: aload_3
    //   65: invokespecial 40	java/lang/StringBuilder:<init>	()V
    //   68: aload_3
    //   69: ldc 42
    //   71: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: pop
    //   75: aload_3
    //   76: ldc 48
    //   78: invokevirtual 46	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload_0
    //   83: aload_3
    //   84: invokevirtual 52	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokestatic 58	javax/crypto/Cipher:getInstance	(Ljava/lang/String;)Ljavax/crypto/Cipher;
    //   90: putfield 60	com/jcraft/jsch/jce/AES128CBC:cipher	Ljavax/crypto/Cipher;
    //   93: ldc 54
    //   95: monitorenter
    //   96: aload_0
    //   97: getfield 60	com/jcraft/jsch/jce/AES128CBC:cipher	Ljavax/crypto/Cipher;
    //   100: astore_3
    //   101: iload_1
    //   102: ifne +8 -> 110
    //   105: iconst_1
    //   106: istore_1
    //   107: goto +5 -> 112
    //   110: iconst_2
    //   111: istore_1
    //   112: new 62	javax/crypto/spec/IvParameterSpec
    //   115: astore 5
    //   117: aload 5
    //   119: aload 4
    //   121: invokespecial 65	javax/crypto/spec/IvParameterSpec:<init>	([B)V
    //   124: aload_3
    //   125: iload_1
    //   126: aload_2
    //   127: aload 5
    //   129: invokevirtual 68	javax/crypto/Cipher:init	(ILjava/security/Key;Ljava/security/spec/AlgorithmParameterSpec;)V
    //   132: ldc 54
    //   134: monitorexit
    //   135: return
    //   136: astore_2
    //   137: ldc 54
    //   139: monitorexit
    //   140: aload_2
    //   141: athrow
    //   142: astore_2
    //   143: aload_0
    //   144: aconst_null
    //   145: putfield 60	com/jcraft/jsch/jce/AES128CBC:cipher	Ljavax/crypto/Cipher;
    //   148: aload_2
    //   149: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	AES128CBC
    //   0	150	1	paramInt	int
    //   0	150	2	paramArrayOfByte1	byte[]
    //   0	150	3	paramArrayOfByte2	byte[]
    //   1	119	4	arrayOfByte	byte[]
    //   115	13	5	localIvParameterSpec	javax.crypto.spec.IvParameterSpec
    // Exception table:
    //   from	to	target	type
    //   96	101	136	finally
    //   112	135	136	finally
    //   137	140	136	finally
    //   49	96	142	java/lang/Exception
    //   140	142	142	java/lang/Exception
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\jce\AES128CBC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */