package com.tplink.libtputility.log.tiny.bean;

import android.util.Base64;
import com.tplink.libtputility.security.PlainEncryptKeyDelegate;
import com.tplink.libtputility.security.c;
import com.tplink.libtputility.security.c.b;
import javax.crypto.SecretKey;

public class a
{
  private static volatile com.tplink.libtputility.security.a a = new com.tplink.libtputility.security.a("AES/ECB/PKCS7Padding");
  private static final c b = new c.b().b(PlainEncryptKeyDelegate.e()).a();
  private String c;
  private String d;
  private int e;
  private byte[] f;
  
  public a(String paramString)
    throws Exception
  {
    this.f = b(b.d.w.h.a.d(paramString.getBytes("UTF-8")));
    this.d = c(a.f());
    paramString = this.f;
    if (paramString != null) {
      this.e = paramString.length;
    }
    paramString = new StringBuilder();
    paramString.append("block_");
    paramString.append(System.currentTimeMillis());
    paramString.append(".dat");
    this.c = paramString.toString();
  }
  
  public a(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte)
  {
    this.c = paramString1;
    this.d = paramString2;
    this.e = paramInt;
    this.f = paramArrayOfByte;
  }
  
  private static int a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 4))
    {
      int i = paramArrayOfByte[0];
      int j = paramArrayOfByte[1];
      int k = paramArrayOfByte[2];
      return paramArrayOfByte[3] & 0xFF | i << 32 & 0xFF000000 | j << 16 & 0xFF0000 | k << 8 & 0xFF00;
    }
    return 0;
  }
  
  private byte[] b(byte[] paramArrayOfByte)
    throws Exception
  {
    if (a != null)
    {
      SecretKey localSecretKey = a.e();
      a.i(localSecretKey);
      return a.d(paramArrayOfByte);
    }
    return null;
  }
  
  private String c(byte[] paramArrayOfByte)
    throws Exception
  {
    c localc = b;
    if (localc != null) {
      paramArrayOfByte = new String(Base64.encode(localc.e(paramArrayOfByte), 2), "UTF-8");
    } else {
      paramArrayOfByte = "";
    }
    return paramArrayOfByte;
  }
  
  /* Error */
  public static a d(java.io.File paramFile)
  {
    // Byte code:
    //   0: new 133	java/io/FileInputStream
    //   3: astore_1
    //   4: aload_1
    //   5: aload_0
    //   6: invokespecial 136	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   9: aload_0
    //   10: invokevirtual 141	java/io/File:length	()J
    //   13: l2i
    //   14: newarray <illegal type>
    //   16: astore_2
    //   17: sipush 1024
    //   20: newarray <illegal type>
    //   22: astore_3
    //   23: iconst_0
    //   24: istore 4
    //   26: aload_1
    //   27: aload_3
    //   28: invokevirtual 144	java/io/FileInputStream:read	([B)I
    //   31: istore 5
    //   33: iload 5
    //   35: iconst_m1
    //   36: if_icmpeq +23 -> 59
    //   39: aload_3
    //   40: iconst_0
    //   41: aload_2
    //   42: iload 4
    //   44: iload 5
    //   46: invokestatic 148	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   49: iload 4
    //   51: iload 5
    //   53: iadd
    //   54: istore 4
    //   56: goto -30 -> 26
    //   59: aload_1
    //   60: invokevirtual 151	java/io/FileInputStream:close	()V
    //   63: iconst_4
    //   64: newarray <illegal type>
    //   66: astore_3
    //   67: aload_2
    //   68: iconst_0
    //   69: aload_3
    //   70: iconst_0
    //   71: iconst_4
    //   72: invokestatic 148	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   75: aload_3
    //   76: invokestatic 153	com/tplink/libtputility/log/tiny/bean/a:a	([B)I
    //   79: istore 5
    //   81: iload 5
    //   83: newarray <illegal type>
    //   85: astore 6
    //   87: aload_2
    //   88: iconst_4
    //   89: aload 6
    //   91: iconst_0
    //   92: iload 5
    //   94: invokestatic 148	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   97: new 52	java/lang/String
    //   100: astore_3
    //   101: aload_3
    //   102: aload 6
    //   104: ldc 50
    //   106: invokespecial 128	java/lang/String:<init>	([BLjava/lang/String;)V
    //   109: aload_0
    //   110: invokevirtual 141	java/io/File:length	()J
    //   113: iload 5
    //   115: i2l
    //   116: lsub
    //   117: ldc2_w 154
    //   120: lsub
    //   121: l2i
    //   122: istore 4
    //   124: iload 4
    //   126: newarray <illegal type>
    //   128: astore 6
    //   130: aload_2
    //   131: iload 5
    //   133: iconst_4
    //   134: iadd
    //   135: aload 6
    //   137: iconst_0
    //   138: iload 4
    //   140: invokestatic 148	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   143: new 2	com/tplink/libtputility/log/tiny/bean/a
    //   146: dup
    //   147: aload_0
    //   148: invokevirtual 158	java/io/File:getName	()Ljava/lang/String;
    //   151: aload_3
    //   152: iload 4
    //   154: aload 6
    //   156: invokespecial 160	com/tplink/libtputility/log/tiny/bean/a:<init>	(Ljava/lang/String;Ljava/lang/String;I[B)V
    //   159: astore_0
    //   160: aload_1
    //   161: invokevirtual 151	java/io/FileInputStream:close	()V
    //   164: aload_0
    //   165: areturn
    //   166: astore_0
    //   167: aload_0
    //   168: athrow
    //   169: astore_2
    //   170: aload_1
    //   171: invokevirtual 151	java/io/FileInputStream:close	()V
    //   174: goto +9 -> 183
    //   177: astore_1
    //   178: aload_0
    //   179: aload_1
    //   180: invokevirtual 166	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   183: aload_2
    //   184: athrow
    //   185: astore_0
    //   186: aconst_null
    //   187: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	paramFile	java.io.File
    //   3	168	1	localFileInputStream	java.io.FileInputStream
    //   177	3	1	localThrowable	Throwable
    //   16	115	2	arrayOfByte1	byte[]
    //   169	15	2	localObject1	Object
    //   22	130	3	localObject2	Object
    //   24	129	4	i	int
    //   31	104	5	j	int
    //   85	70	6	arrayOfByte2	byte[]
    // Exception table:
    //   from	to	target	type
    //   9	23	166	finally
    //   26	33	166	finally
    //   39	49	166	finally
    //   59	160	166	finally
    //   167	169	169	finally
    //   170	174	177	finally
    //   0	9	185	java/lang/Exception
    //   160	164	185	java/lang/Exception
    //   178	183	185	java/lang/Exception
    //   183	185	185	java/lang/Exception
  }
  
  private static byte[] i(int paramInt)
  {
    return new byte[] { (byte)(paramInt >> 32 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt & 0xFF) };
  }
  
  public String e()
  {
    return this.d;
  }
  
  public String f()
  {
    return this.c;
  }
  
  public int g()
  {
    return this.e;
  }
  
  public byte[] h()
  {
    return this.f;
  }
  
  /* Error */
  public void j(String paramString)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 176	b/d/w/b/b:d	(Ljava/lang/String;)Z
    //   4: pop
    //   5: new 178	java/io/FileOutputStream
    //   8: astore_2
    //   9: new 138	java/io/File
    //   12: astore_3
    //   13: aload_3
    //   14: aload_1
    //   15: aload_0
    //   16: getfield 101	com/tplink/libtputility/log/tiny/bean/a:c	Ljava/lang/String;
    //   19: invokespecial 181	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_2
    //   23: aload_3
    //   24: invokespecial 182	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   27: aload_0
    //   28: getfield 73	com/tplink/libtputility/log/tiny/bean/a:d	Ljava/lang/String;
    //   31: ldc 50
    //   33: invokevirtual 56	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   36: astore_1
    //   37: aload_1
    //   38: arraylength
    //   39: istore 4
    //   41: aload_0
    //   42: getfield 65	com/tplink/libtputility/log/tiny/bean/a:f	[B
    //   45: arraylength
    //   46: istore 5
    //   48: iload 4
    //   50: invokestatic 184	com/tplink/libtputility/log/tiny/bean/a:i	(I)[B
    //   53: astore_3
    //   54: iload 4
    //   56: iconst_4
    //   57: iadd
    //   58: istore 6
    //   60: iload 6
    //   62: iload 5
    //   64: iadd
    //   65: newarray <illegal type>
    //   67: astore 7
    //   69: aload_3
    //   70: iconst_0
    //   71: aload 7
    //   73: iconst_0
    //   74: iconst_4
    //   75: invokestatic 148	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   78: aload_1
    //   79: iconst_0
    //   80: aload 7
    //   82: iconst_4
    //   83: iload 4
    //   85: invokestatic 148	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   88: aload_0
    //   89: getfield 65	com/tplink/libtputility/log/tiny/bean/a:f	[B
    //   92: iconst_0
    //   93: aload 7
    //   95: iload 6
    //   97: iload 5
    //   99: invokestatic 148	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   102: aload_2
    //   103: aload 7
    //   105: invokevirtual 188	java/io/FileOutputStream:write	([B)V
    //   108: aload_2
    //   109: invokevirtual 191	java/io/FileOutputStream:flush	()V
    //   112: aload_2
    //   113: invokevirtual 192	java/io/FileOutputStream:close	()V
    //   116: goto +22 -> 138
    //   119: astore_1
    //   120: aload_1
    //   121: athrow
    //   122: astore_3
    //   123: aload_2
    //   124: invokevirtual 192	java/io/FileOutputStream:close	()V
    //   127: goto +9 -> 136
    //   130: astore_2
    //   131: aload_1
    //   132: aload_2
    //   133: invokevirtual 166	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   136: aload_3
    //   137: athrow
    //   138: return
    //   139: astore_1
    //   140: goto -2 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	a
    //   0	143	1	paramString	String
    //   8	116	2	localFileOutputStream	java.io.FileOutputStream
    //   130	3	2	localThrowable	Throwable
    //   12	58	3	localObject1	Object
    //   122	15	3	localObject2	Object
    //   39	45	4	i	int
    //   46	52	5	j	int
    //   58	38	6	k	int
    //   67	37	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   27	54	119	finally
    //   60	112	119	finally
    //   120	122	122	finally
    //   123	127	130	finally
    //   5	27	139	java/lang/Exception
    //   112	116	139	java/lang/Exception
    //   131	136	139	java/lang/Exception
    //   136	138	139	java/lang/Exception
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtputility\log\tiny\bean\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */