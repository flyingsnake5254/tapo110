package com.jcraft.jsch;

import java.io.PrintStream;

public class HostKey
{
  public static final int ECDSA256 = 3;
  public static final int ECDSA384 = 4;
  public static final int ECDSA521 = 5;
  protected static final int GUESS = 0;
  public static final int SSHDSS = 1;
  public static final int SSHRSA = 2;
  static final int UNKNOWN = 6;
  private static final byte[][] names = { Util.str2byte("ssh-dss"), Util.str2byte("ssh-rsa"), Util.str2byte("ecdsa-sha2-nistp256"), Util.str2byte("ecdsa-sha2-nistp384"), Util.str2byte("ecdsa-sha2-nistp521") };
  protected String comment;
  protected String host;
  protected byte[] key;
  protected String marker;
  protected int type;
  
  public HostKey(String paramString, int paramInt, byte[] paramArrayOfByte)
    throws JSchException
  {
    this(paramString, paramInt, paramArrayOfByte, null);
  }
  
  public HostKey(String paramString1, int paramInt, byte[] paramArrayOfByte, String paramString2)
    throws JSchException
  {
    this("", paramString1, paramInt, paramArrayOfByte, paramString2);
  }
  
  public HostKey(String paramString1, String paramString2, int paramInt, byte[] paramArrayOfByte, String paramString3)
    throws JSchException
  {
    this.marker = paramString1;
    this.host = paramString2;
    if (paramInt == 0)
    {
      if (paramArrayOfByte[8] == 100) {
        this.type = 1;
      } else if (paramArrayOfByte[8] == 114) {
        this.type = 2;
      } else if ((paramArrayOfByte[8] == 97) && (paramArrayOfByte[20] == 50)) {
        this.type = 3;
      } else if ((paramArrayOfByte[8] == 97) && (paramArrayOfByte[20] == 51)) {
        this.type = 4;
      } else if ((paramArrayOfByte[8] == 97) && (paramArrayOfByte[20] == 53)) {
        this.type = 5;
      } else {
        throw new JSchException("invalid key type");
      }
    }
    else {
      this.type = paramInt;
    }
    this.key = paramArrayOfByte;
    this.comment = paramString3;
  }
  
  public HostKey(String paramString, byte[] paramArrayOfByte)
    throws JSchException
  {
    this(paramString, 0, paramArrayOfByte);
  }
  
  private boolean isIncluded(String paramString)
  {
    String str = this.host;
    int i = str.length();
    int j = paramString.length();
    int m;
    for (int k = 0; k < i; k = m + 1)
    {
      m = str.indexOf(',', k);
      if (m == -1)
      {
        if (j != i - k) {
          return false;
        }
        return str.regionMatches(true, k, paramString, 0, j);
      }
      if ((j == m - k) && (str.regionMatches(true, k, paramString, 0, j))) {
        return true;
      }
    }
    return false;
  }
  
  protected static int name2type(String paramString)
  {
    for (int i = 0;; i++)
    {
      byte[][] arrayOfByte = names;
      if (i >= arrayOfByte.length) {
        break;
      }
      if (Util.byte2str(arrayOfByte[i]).equals(paramString)) {
        return i + 1;
      }
    }
    return 6;
  }
  
  public String getComment()
  {
    return this.comment;
  }
  
  public String getFingerPrint(JSch paramJSch)
  {
    try
    {
      paramJSch = (HASH)Class.forName(JSch.getConfig("md5")).newInstance();
    }
    catch (Exception paramJSch)
    {
      PrintStream localPrintStream = System.err;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getFingerPrint: ");
      localStringBuilder.append(paramJSch);
      localPrintStream.println(localStringBuilder.toString());
      paramJSch = null;
    }
    return Util.getFingerPrint(paramJSch, this.key);
  }
  
  public String getHost()
  {
    return this.host;
  }
  
  public String getKey()
  {
    byte[] arrayOfByte = this.key;
    return Util.byte2str(Util.toBase64(arrayOfByte, 0, arrayOfByte.length));
  }
  
  public String getMarker()
  {
    return this.marker;
  }
  
  public String getType()
  {
    int i = this.type;
    if ((i != 1) && (i != 2) && (i != 3) && (i != 4) && (i != 5)) {
      return "UNKNOWN";
    }
    return Util.byte2str(names[(i - 1)]);
  }
  
  boolean isMatched(String paramString)
  {
    return isIncluded(paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\HostKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */