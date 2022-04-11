package b.d.w.h;

import android.util.Base64;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class a
{
  public static String a(String paramString)
  {
    if (b.d(paramString)) {
      return "";
    }
    return new String(Base64.decode(paramString, 2));
  }
  
  public static String b(String paramString)
  {
    if (b.d(paramString)) {
      return "";
    }
    return Base64.encodeToString(paramString.getBytes(), 2);
  }
  
  public static String c(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    return Base64.encodeToString(paramArrayOfByte, 2);
  }
  
  /* Error */
  public static byte[] d(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 43	java/util/zip/Deflater
    //   3: dup
    //   4: invokespecial 46	java/util/zip/Deflater:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: invokevirtual 49	java/util/zip/Deflater:reset	()V
    //   12: aload_1
    //   13: aload_0
    //   14: invokevirtual 52	java/util/zip/Deflater:setInput	([B)V
    //   17: aload_1
    //   18: invokevirtual 55	java/util/zip/Deflater:finish	()V
    //   21: new 57	java/io/ByteArrayOutputStream
    //   24: astore_2
    //   25: aload_2
    //   26: aload_0
    //   27: arraylength
    //   28: invokespecial 60	java/io/ByteArrayOutputStream:<init>	(I)V
    //   31: sipush 1024
    //   34: newarray <illegal type>
    //   36: astore_3
    //   37: aload_1
    //   38: invokevirtual 64	java/util/zip/Deflater:finished	()Z
    //   41: ifne +17 -> 58
    //   44: aload_2
    //   45: aload_3
    //   46: iconst_0
    //   47: aload_1
    //   48: aload_3
    //   49: invokevirtual 68	java/util/zip/Deflater:deflate	([B)I
    //   52: invokevirtual 72	java/io/ByteArrayOutputStream:write	([BII)V
    //   55: goto -18 -> 37
    //   58: aload_2
    //   59: invokevirtual 75	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   62: astore_3
    //   63: aload_2
    //   64: invokevirtual 78	java/io/ByteArrayOutputStream:close	()V
    //   67: aload_3
    //   68: astore_0
    //   69: goto +24 -> 93
    //   72: astore_3
    //   73: aload_3
    //   74: athrow
    //   75: astore 4
    //   77: aload_2
    //   78: invokevirtual 78	java/io/ByteArrayOutputStream:close	()V
    //   81: goto +9 -> 90
    //   84: astore_2
    //   85: aload_3
    //   86: aload_2
    //   87: invokevirtual 84	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   90: aload 4
    //   92: athrow
    //   93: aload_1
    //   94: invokevirtual 87	java/util/zip/Deflater:end	()V
    //   97: aload_0
    //   98: areturn
    //   99: astore_3
    //   100: goto -7 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	103	0	paramArrayOfByte	byte[]
    //   7	87	1	localDeflater	java.util.zip.Deflater
    //   24	54	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   84	3	2	localThrowable	Throwable
    //   36	32	3	arrayOfByte	byte[]
    //   72	14	3	localObject1	Object
    //   99	1	3	localException	Exception
    //   75	16	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   31	37	72	finally
    //   37	55	72	finally
    //   58	63	72	finally
    //   73	75	75	finally
    //   77	81	84	finally
    //   21	31	99	java/lang/Exception
    //   63	67	99	java/lang/Exception
    //   85	90	99	java/lang/Exception
    //   90	93	99	java/lang/Exception
  }
  
  /* Error */
  public static byte[] e(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 90	java/util/zip/Inflater
    //   3: dup
    //   4: invokespecial 91	java/util/zip/Inflater:<init>	()V
    //   7: astore_1
    //   8: aload_1
    //   9: invokevirtual 92	java/util/zip/Inflater:reset	()V
    //   12: aload_1
    //   13: aload_0
    //   14: invokevirtual 93	java/util/zip/Inflater:setInput	([B)V
    //   17: new 57	java/io/ByteArrayOutputStream
    //   20: astore_2
    //   21: aload_2
    //   22: aload_0
    //   23: arraylength
    //   24: invokespecial 60	java/io/ByteArrayOutputStream:<init>	(I)V
    //   27: sipush 1024
    //   30: newarray <illegal type>
    //   32: astore_3
    //   33: aload_1
    //   34: invokevirtual 94	java/util/zip/Inflater:finished	()Z
    //   37: ifne +17 -> 54
    //   40: aload_2
    //   41: aload_3
    //   42: iconst_0
    //   43: aload_1
    //   44: aload_3
    //   45: invokevirtual 97	java/util/zip/Inflater:inflate	([B)I
    //   48: invokevirtual 72	java/io/ByteArrayOutputStream:write	([BII)V
    //   51: goto -18 -> 33
    //   54: aload_2
    //   55: invokevirtual 75	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   58: astore_3
    //   59: aload_2
    //   60: invokevirtual 78	java/io/ByteArrayOutputStream:close	()V
    //   63: aload_3
    //   64: astore_0
    //   65: goto +24 -> 89
    //   68: astore_3
    //   69: aload_3
    //   70: athrow
    //   71: astore 4
    //   73: aload_2
    //   74: invokevirtual 78	java/io/ByteArrayOutputStream:close	()V
    //   77: goto +9 -> 86
    //   80: astore_2
    //   81: aload_3
    //   82: aload_2
    //   83: invokevirtual 84	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   86: aload 4
    //   88: athrow
    //   89: aload_1
    //   90: invokevirtual 98	java/util/zip/Inflater:end	()V
    //   93: aload_0
    //   94: areturn
    //   95: astore_3
    //   96: goto -7 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	paramArrayOfByte	byte[]
    //   7	83	1	localInflater	java.util.zip.Inflater
    //   20	54	2	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   80	3	2	localThrowable	Throwable
    //   32	32	3	arrayOfByte	byte[]
    //   68	14	3	localObject1	Object
    //   95	1	3	localException	Exception
    //   71	16	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   27	33	68	finally
    //   33	51	68	finally
    //   54	59	68	finally
    //   69	71	71	finally
    //   73	77	80	finally
    //   17	27	95	java/lang/Exception
    //   59	63	95	java/lang/Exception
    //   81	86	95	java/lang/Exception
    //   86	89	95	java/lang/Exception
  }
  
  public static byte[] f(byte[] paramArrayOfByte)
    throws NoSuchAlgorithmException
  {
    MessageDigest localMessageDigest = MessageDigest.getInstance("md5");
    localMessageDigest.update(paramArrayOfByte);
    return localMessageDigest.digest();
  }
  
  public static String g(String paramString)
  {
    try
    {
      String str = k(f(paramString.getBytes()));
      return str;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      b.d.w.c.a.d(localNoSuchAlgorithmException.toString());
    }
    return paramString;
  }
  
  public static String h(String paramString)
  {
    return i(paramString.getBytes());
  }
  
  public static String i(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = k(MessageDigest.getInstance("SHA1").digest(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (NoSuchAlgorithmException paramArrayOfByte)
    {
      b.d.w.c.a.d(paramArrayOfByte.toString());
    }
    return "";
  }
  
  public static byte[] j(String paramString)
  {
    int i = paramString.length() / 2;
    byte[] arrayOfByte = new byte[i];
    for (int j = 0; j < i; j++)
    {
      int k = j * 2;
      arrayOfByte[j] = Integer.valueOf(paramString.substring(k, k + 2), 16).byteValue();
    }
    return arrayOfByte;
  }
  
  public static String k(byte[] paramArrayOfByte)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramArrayOfByte.length;
    for (int j = 0; j < i; j++)
    {
      String str = Integer.toHexString(paramArrayOfByte[j] & 0xFF);
      if (str.length() == 1)
      {
        localStringBuilder.append("0");
        localStringBuilder.append(str);
      }
      else
      {
        localStringBuilder.append(str);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String l(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(paramArrayOfByte.length * 2);
    int i = paramArrayOfByte.length;
    for (int j = 0; j < i; j++)
    {
      int k = paramArrayOfByte[j];
      localStringBuilder.append("0123456789ABCDEF".charAt(k >> 4 & 0xF));
      localStringBuilder.append("0123456789ABCDEF".charAt(k & 0xF));
    }
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\w\h\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */