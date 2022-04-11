package com.jcraft.jsch;

import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.util.Vector;

class Util
{
  private static final byte[] b64 = str2byte("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=");
  private static String[] chars = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
  static final byte[] empty = str2byte("");
  
  static boolean array_equals(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = paramArrayOfByte1.length;
    if (i != paramArrayOfByte2.length) {
      return false;
    }
    for (int j = 0; j < i; j++) {
      if (paramArrayOfByte1[j] != paramArrayOfByte2[j]) {
        return false;
      }
    }
    return true;
  }
  
  static String byte2str(byte[] paramArrayOfByte)
  {
    return byte2str(paramArrayOfByte, 0, paramArrayOfByte.length, "UTF-8");
  }
  
  static String byte2str(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return byte2str(paramArrayOfByte, paramInt1, paramInt2, "UTF-8");
  }
  
  static String byte2str(byte[] paramArrayOfByte, int paramInt1, int paramInt2, String paramString)
  {
    try
    {
      paramString = new String(paramArrayOfByte, paramInt1, paramInt2, paramString);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString) {}
    return new String(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  static String byte2str(byte[] paramArrayOfByte, String paramString)
  {
    return byte2str(paramArrayOfByte, 0, paramArrayOfByte.length, paramString);
  }
  
  static void bzero(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return;
    }
    for (int i = 0; i < paramArrayOfByte.length; i++) {
      paramArrayOfByte[i] = ((byte)0);
    }
  }
  
  static String checkTilde(String paramString)
  {
    String str1 = paramString;
    try
    {
      if (paramString.startsWith("~")) {
        str1 = paramString.replace("~", System.getProperty("user.home"));
      }
      return str1;
    }
    catch (SecurityException localSecurityException)
    {
      for (;;)
      {
        String str2 = paramString;
      }
    }
  }
  
  static Socket createSocket(final String paramString, final int paramInt1, int paramInt2)
    throws JSchException
  {
    if (paramInt2 == 0) {
      try
      {
        paramString = new Socket(paramString, paramInt1);
        return paramString;
      }
      catch (Exception paramString)
      {
        throw new JSchException(paramString.toString(), paramString);
      }
    }
    Object localObject = new Socket[1];
    final Exception[] arrayOfException = new Exception[1];
    Thread localThread = new Thread(new Runnable()
    {
      public void run()
      {
        Socket[] arrayOfSocket1 = this.val$sockp;
        arrayOfSocket1[0] = null;
        try
        {
          Socket localSocket = new java/net/Socket;
          localSocket.<init>(paramString, paramInt1);
          arrayOfSocket1[0] = localSocket;
        }
        catch (Exception localException1)
        {
          arrayOfException[0] = localException1;
          Socket[] arrayOfSocket2 = this.val$sockp;
          if ((arrayOfSocket2[0] == null) || (!arrayOfSocket2[0].isConnected())) {}
        }
        try
        {
          this.val$sockp[0].close();
          this.val$sockp[0] = null;
          return;
        }
        catch (Exception localException2)
        {
          for (;;) {}
        }
      }
    });
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Opening Socket ");
    localStringBuilder.append(paramString);
    localThread.setName(localStringBuilder.toString());
    localThread.start();
    long l = paramInt2;
    try
    {
      localThread.join(l);
      paramString = "timeout: ";
    }
    catch (InterruptedException paramString)
    {
      paramString = "";
    }
    if ((localObject[0] != null) && (localObject[0].isConnected())) {
      return localObject[0];
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append("socket is not established");
    paramString = ((StringBuilder)localObject).toString();
    if (arrayOfException[0] != null) {
      paramString = arrayOfException[0].toString();
    }
    localThread.interrupt();
    throw new JSchException(paramString, arrayOfException[0]);
  }
  
  static String diffString(String paramString, String[] paramArrayOfString)
  {
    String[] arrayOfString = split(paramString, ",");
    paramString = null;
    label99:
    for (int i = 0; i < arrayOfString.length; i++)
    {
      for (int j = 0; j < paramArrayOfString.length; j++) {
        if (arrayOfString[i].equals(paramArrayOfString[j])) {
          break label99;
        }
      }
      if (paramString == null)
      {
        paramString = arrayOfString[i];
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append(",");
        localStringBuilder.append(arrayOfString[i]);
        paramString = localStringBuilder.toString();
      }
    }
    return paramString;
  }
  
  static byte[] fromBase64(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws JSchException
  {
    try
    {
      byte[] arrayOfByte = new byte[paramInt2];
      int i = paramInt1;
      int j = 0;
      int k;
      for (;;)
      {
        k = j;
        if (i >= paramInt1 + paramInt2) {
          break;
        }
        k = val(paramArrayOfByte[i]);
        int m = i + 1;
        arrayOfByte[j] = ((byte)(byte)(k << 2 | (val(paramArrayOfByte[m]) & 0x30) >>> 4));
        k = i + 2;
        if (paramArrayOfByte[k] == 61)
        {
          k = j + 1;
          break;
        }
        arrayOfByte[(j + 1)] = ((byte)(byte)((val(paramArrayOfByte[m]) & 0xF) << 4 | (val(paramArrayOfByte[k]) & 0x3C) >>> 2));
        m = i + 3;
        if (paramArrayOfByte[m] == 61)
        {
          k = j + 2;
          break;
        }
        arrayOfByte[(j + 2)] = ((byte)(byte)((val(paramArrayOfByte[k]) & 0x3) << 6 | val(paramArrayOfByte[m]) & 0x3F));
        j += 3;
        i += 4;
      }
      paramArrayOfByte = new byte[k];
      System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, k);
      return paramArrayOfByte;
    }
    catch (ArrayIndexOutOfBoundsException paramArrayOfByte)
    {
      throw new JSchException("fromBase64: invalid base64 data", paramArrayOfByte);
    }
  }
  
  /* Error */
  static byte[] fromFile(String paramString)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokestatic 199	com/jcraft/jsch/Util:checkTilde	(Ljava/lang/String;)Ljava/lang/String;
    //   4: astore_0
    //   5: new 201	java/io/File
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 203	java/io/File:<init>	(Ljava/lang/String;)V
    //   13: astore_1
    //   14: new 205	java/io/FileInputStream
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 206	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   22: astore_0
    //   23: aload_1
    //   24: invokevirtual 210	java/io/File:length	()J
    //   27: l2i
    //   28: istore_2
    //   29: iload_2
    //   30: newarray <illegal type>
    //   32: astore_1
    //   33: iconst_0
    //   34: istore_3
    //   35: aload_0
    //   36: aload_1
    //   37: iload_3
    //   38: iload_2
    //   39: iload_3
    //   40: isub
    //   41: invokevirtual 214	java/io/FileInputStream:read	([BII)I
    //   44: istore 4
    //   46: iload 4
    //   48: ifgt +13 -> 61
    //   51: aload_0
    //   52: invokevirtual 217	java/io/FileInputStream:close	()V
    //   55: aload_0
    //   56: invokevirtual 217	java/io/FileInputStream:close	()V
    //   59: aload_1
    //   60: areturn
    //   61: iload_3
    //   62: iload 4
    //   64: iadd
    //   65: istore_3
    //   66: goto -31 -> 35
    //   69: astore_1
    //   70: aload_0
    //   71: invokevirtual 217	java/io/FileInputStream:close	()V
    //   74: aload_1
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	paramString	String
    //   13	47	1	localObject1	Object
    //   69	6	1	localObject2	Object
    //   28	13	2	i	int
    //   34	32	3	j	int
    //   44	21	4	k	int
    // Exception table:
    //   from	to	target	type
    //   23	33	69	finally
    //   35	46	69	finally
    //   51	55	69	finally
  }
  
  static String getFingerPrint(HASH paramHASH, byte[] paramArrayOfByte)
  {
    try
    {
      paramHASH.init();
      int i = paramArrayOfByte.length;
      int j = 0;
      paramHASH.update(paramArrayOfByte, 0, i);
      paramHASH = paramHASH.digest();
      paramArrayOfByte = new java/lang/StringBuffer;
      paramArrayOfByte.<init>();
      while (j < paramHASH.length)
      {
        i = paramHASH[j] & 0xFF;
        paramArrayOfByte.append(chars[(i >>> 4 & 0xF)]);
        paramArrayOfByte.append(chars[(i & 0xF)]);
        i = j + 1;
        j = i;
        if (i < paramHASH.length)
        {
          paramArrayOfByte.append(":");
          j = i;
        }
      }
      paramHASH = paramArrayOfByte.toString();
      return paramHASH;
    }
    catch (Exception paramHASH) {}
    return "???";
  }
  
  private static boolean glob(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int i = paramArrayOfByte1.length;
    boolean bool1 = false;
    if (i == 0) {
      return false;
    }
    int j = paramArrayOfByte2.length;
    int k;
    int m;
    do
    {
      do
      {
        for (;;)
        {
          k = paramInt1;
          m = paramInt2;
          if (paramInt1 >= i) {
            break label392;
          }
          k = paramInt1;
          m = paramInt2;
          if (paramInt2 >= j) {
            break label392;
          }
          if (paramArrayOfByte1[paramInt1] == 92)
          {
            paramInt1++;
            if (paramInt1 == i) {
              return false;
            }
            if (paramArrayOfByte1[paramInt1] != paramArrayOfByte2[paramInt2]) {
              return false;
            }
            paramInt1 += skipUTF8Char(paramArrayOfByte1[paramInt1]);
            k = skipUTF8Char(paramArrayOfByte2[paramInt2]);
          }
          else
          {
            if (paramArrayOfByte1[paramInt1] == 42)
            {
              while ((paramInt1 < i) && (paramArrayOfByte1[paramInt1] == 42)) {
                paramInt1++;
              }
              if (i == paramInt1) {
                return true;
              }
              m = paramArrayOfByte1[paramInt1];
              if (m == 63)
              {
                while (paramInt2 < j)
                {
                  if (glob(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2)) {
                    return true;
                  }
                  paramInt2 += skipUTF8Char(paramArrayOfByte2[paramInt2]);
                }
                return false;
              }
              k = paramInt2;
              if (m == 92)
              {
                paramInt1++;
                if (paramInt1 == i) {
                  return false;
                }
                byte b = paramArrayOfByte1[paramInt1];
                while (paramInt2 < j)
                {
                  if ((b == paramArrayOfByte2[paramInt2]) && (glob(paramArrayOfByte1, skipUTF8Char(b) + paramInt1, paramArrayOfByte2, skipUTF8Char(paramArrayOfByte2[paramInt2]) + paramInt2))) {
                    return true;
                  }
                  paramInt2 += skipUTF8Char(paramArrayOfByte2[paramInt2]);
                }
                return false;
              }
              while (k < j)
              {
                if ((m == paramArrayOfByte2[k]) && (glob(paramArrayOfByte1, paramInt1, paramArrayOfByte2, k))) {
                  return true;
                }
                k += skipUTF8Char(paramArrayOfByte2[k]);
              }
              return false;
            }
            if (paramArrayOfByte1[paramInt1] != 63) {
              break;
            }
            paramInt1++;
            k = skipUTF8Char(paramArrayOfByte2[paramInt2]);
          }
          paramInt2 += k;
        }
        if (paramArrayOfByte1[paramInt1] != paramArrayOfByte2[paramInt2]) {
          return false;
        }
        k = paramInt1 + skipUTF8Char(paramArrayOfByte1[paramInt1]);
        m = paramInt2 + skipUTF8Char(paramArrayOfByte2[paramInt2]);
        paramInt1 = k;
        paramInt2 = m;
      } while (m < j);
      if (k >= i) {
        return true;
      }
      paramInt1 = k;
      paramInt2 = m;
    } while (paramArrayOfByte1[k] != 42);
    label392:
    if ((k == i) && (m == j)) {
      return true;
    }
    boolean bool2 = bool1;
    if (m >= j)
    {
      bool2 = bool1;
      if (paramArrayOfByte1[k] == 42)
      {
        while (k < i)
        {
          if (paramArrayOfByte1[k] != 42)
          {
            bool2 = bool1;
            break label464;
          }
          k++;
        }
        bool2 = true;
      }
    }
    label464:
    return bool2;
  }
  
  static boolean glob(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return glob0(paramArrayOfByte1, 0, paramArrayOfByte2, 0);
  }
  
  private static boolean glob0(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    if ((paramArrayOfByte2.length > 0) && (paramArrayOfByte2[0] == 46))
    {
      if ((paramArrayOfByte1.length > 0) && (paramArrayOfByte1[0] == 46))
      {
        if ((paramArrayOfByte1.length == 2) && (paramArrayOfByte1[1] == 42)) {
          return true;
        }
        return glob(paramArrayOfByte1, paramInt1 + 1, paramArrayOfByte2, paramInt2 + 1);
      }
      return false;
    }
    return glob(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
  }
  
  static String quote(String paramString)
  {
    byte[] arrayOfByte = str2byte(paramString);
    int i = 0;
    int j = 0;
    for (int k = 0; j < arrayOfByte.length; k = n)
    {
      int m = arrayOfByte[j];
      if ((m != 92) && (m != 63))
      {
        n = k;
        if (m != 42) {}
      }
      else
      {
        n = k + 1;
      }
      j++;
    }
    if (k == 0) {
      return paramString;
    }
    paramString = new byte[arrayOfByte.length + k];
    j = 0;
    int n = i;
    while (n < arrayOfByte.length)
    {
      i = arrayOfByte[n];
      if ((i != 92) && (i != 63))
      {
        k = j;
        if (i != 42) {}
      }
      else
      {
        paramString[j] = ((byte)92);
        k = j + 1;
      }
      paramString[k] = ((byte)i);
      n++;
      j = k + 1;
    }
    return byte2str(paramString);
  }
  
  private static int skipUTF8Char(byte paramByte)
  {
    if ((byte)(paramByte & 0x80) == 0) {
      return 1;
    }
    if ((byte)(paramByte & 0xE0) == -64) {
      return 2;
    }
    if ((byte)(paramByte & 0xF0) == -32) {
      return 3;
    }
    return 1;
  }
  
  static String[] split(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    byte[] arrayOfByte = str2byte(paramString1);
    Vector localVector = new Vector();
    int i = 0;
    for (int j = 0;; j = k + 1)
    {
      k = paramString1.indexOf(paramString2, j);
      if (k < 0) {
        break;
      }
      localVector.addElement(byte2str(arrayOfByte, j, k - j));
    }
    localVector.addElement(byte2str(arrayOfByte, j, arrayOfByte.length - j));
    int k = localVector.size();
    paramString1 = new String[k];
    for (j = i; j < k; j++) {
      paramString1[j] = ((String)localVector.elementAt(j));
    }
    return paramString1;
  }
  
  static byte[] str2byte(String paramString)
  {
    return str2byte(paramString, "UTF-8");
  }
  
  static byte[] str2byte(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return null;
    }
    try
    {
      paramString2 = paramString1.getBytes(paramString2);
      return paramString2;
    }
    catch (UnsupportedEncodingException paramString2) {}
    return paramString1.getBytes();
  }
  
  static byte[] toBase64(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte1 = new byte[paramInt2 * 2];
    int i = paramInt2 / 3 * 3 + paramInt1;
    int j = paramInt1;
    int n;
    byte[] arrayOfByte2;
    for (int k = 0; j < i; k = n + 1)
    {
      int m = paramArrayOfByte[j];
      n = k + 1;
      arrayOfByte2 = b64;
      arrayOfByte1[k] = ((byte)arrayOfByte2[(m >>> 2 & 0x3F)]);
      int i1 = paramArrayOfByte[j];
      int i2 = j + 1;
      m = paramArrayOfByte[i2];
      k = n + 1;
      arrayOfByte1[n] = ((byte)arrayOfByte2[((i1 & 0x3) << 4 | m >>> 4 & 0xF)]);
      i2 = paramArrayOfByte[i2];
      m = j + 2;
      i1 = paramArrayOfByte[m];
      n = k + 1;
      arrayOfByte1[k] = ((byte)arrayOfByte2[((i2 & 0xF) << 2 | i1 >>> 6 & 0x3)]);
      arrayOfByte1[n] = ((byte)arrayOfByte2[(paramArrayOfByte[m] & 0x3F)]);
      j += 3;
    }
    paramInt2 = paramInt1 + paramInt2 - i;
    if (paramInt2 == 1)
    {
      paramInt2 = paramArrayOfByte[j];
      paramInt1 = k + 1;
      arrayOfByte2 = b64;
      arrayOfByte1[k] = ((byte)arrayOfByte2[(paramInt2 >>> 2 & 0x3F)]);
      k = paramArrayOfByte[j];
      paramInt2 = paramInt1 + 1;
      arrayOfByte1[paramInt1] = ((byte)arrayOfByte2[((k & 0x3) << 4 & 0x3F)]);
      k = paramInt2 + 1;
      arrayOfByte1[paramInt2] = ((byte)61);
      paramInt1 = k + 1;
      arrayOfByte1[k] = ((byte)61);
    }
    else
    {
      paramInt1 = k;
      if (paramInt2 == 2)
      {
        paramInt2 = paramArrayOfByte[j];
        paramInt1 = k + 1;
        arrayOfByte2 = b64;
        arrayOfByte1[k] = ((byte)arrayOfByte2[(paramInt2 >>> 2 & 0x3F)]);
        k = paramArrayOfByte[j];
        i = j + 1;
        j = paramArrayOfByte[i];
        paramInt2 = paramInt1 + 1;
        arrayOfByte1[paramInt1] = ((byte)arrayOfByte2[((k & 0x3) << 4 | j >>> 4 & 0xF)]);
        paramInt1 = paramArrayOfByte[i];
        k = paramInt2 + 1;
        arrayOfByte1[paramInt2] = ((byte)arrayOfByte2[((paramInt1 & 0xF) << 2 & 0x3F)]);
        paramInt1 = k + 1;
        arrayOfByte1[k] = ((byte)61);
      }
    }
    paramArrayOfByte = new byte[paramInt1];
    System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, 0, paramInt1);
    return paramArrayOfByte;
  }
  
  static String toHex(byte[] paramArrayOfByte)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < paramArrayOfByte.length)
    {
      String str1 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("0x");
      String str2;
      if (str1.length() == 1) {
        str2 = "0";
      } else {
        str2 = "";
      }
      localStringBuilder.append(str2);
      localStringBuilder.append(str1);
      localStringBuffer.append(localStringBuilder.toString());
      int j = i + 1;
      i = j;
      if (j < paramArrayOfByte.length)
      {
        localStringBuffer.append(":");
        i = j;
      }
    }
    return localStringBuffer.toString();
  }
  
  static String unquote(String paramString)
  {
    byte[] arrayOfByte1 = str2byte(paramString);
    byte[] arrayOfByte2 = unquote(arrayOfByte1);
    if (arrayOfByte1.length == arrayOfByte2.length) {
      return paramString;
    }
    return byte2str(arrayOfByte2);
  }
  
  static byte[] unquote(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = 0;
    while (j < i) {
      if (paramArrayOfByte[j] == 92)
      {
        int k = j + 1;
        if (k == i) {
          break;
        }
        System.arraycopy(paramArrayOfByte, k, paramArrayOfByte, j, paramArrayOfByte.length - k);
        i--;
        j = k;
      }
      else
      {
        j++;
      }
    }
    if (i == paramArrayOfByte.length) {
      return paramArrayOfByte;
    }
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  private static byte val(byte paramByte)
  {
    if (paramByte == 61) {
      return 0;
    }
    for (int i = 0;; i++)
    {
      byte[] arrayOfByte = b64;
      if (i >= arrayOfByte.length) {
        break;
      }
      if (paramByte == arrayOfByte[i]) {
        return (byte)i;
      }
    }
    return 0;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */