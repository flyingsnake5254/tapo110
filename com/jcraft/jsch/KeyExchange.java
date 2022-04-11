package com.jcraft.jsch;

import java.io.PrintStream;

public abstract class KeyExchange
{
  static final int PROPOSAL_COMP_ALGS_CTOS = 6;
  static final int PROPOSAL_COMP_ALGS_STOC = 7;
  static final int PROPOSAL_ENC_ALGS_CTOS = 2;
  static final int PROPOSAL_ENC_ALGS_STOC = 3;
  static final int PROPOSAL_KEX_ALGS = 0;
  static final int PROPOSAL_LANG_CTOS = 8;
  static final int PROPOSAL_LANG_STOC = 9;
  static final int PROPOSAL_MAC_ALGS_CTOS = 4;
  static final int PROPOSAL_MAC_ALGS_STOC = 5;
  static final int PROPOSAL_MAX = 10;
  static final int PROPOSAL_SERVER_HOST_KEY_ALGS = 1;
  public static final int STATE_END = 0;
  static String enc_c2s = "blowfish-cbc";
  static String enc_s2c = "blowfish-cbc";
  static String kex = "diffie-hellman-group1-sha1";
  static String lang_c2s = "";
  static String lang_s2c = "";
  static String mac_c2s = "hmac-md5";
  static String mac_s2c = "hmac-md5";
  static String server_host_key = "ssh-rsa,ssh-dss";
  protected final int DSS = 1;
  protected final int ECDSA = 2;
  protected byte[] H = null;
  protected byte[] K = null;
  protected byte[] K_S = null;
  protected final int RSA = 0;
  private String key_alg_name = "";
  protected Session session = null;
  protected HASH sha = null;
  private int type = 0;
  
  protected static String[] guess(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    String[] arrayOfString = new String[10];
    paramArrayOfByte1 = new Buffer(paramArrayOfByte1);
    paramArrayOfByte1.setOffSet(17);
    paramArrayOfByte2 = new Buffer(paramArrayOfByte2);
    paramArrayOfByte2.setOffSet(17);
    int i;
    Object localObject1;
    Object localObject2;
    if (JSch.getLogger().isEnabled(1))
    {
      for (i = 0; i < 10; i++)
      {
        localObject1 = JSch.getLogger();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("kex: server: ");
        ((StringBuilder)localObject2).append(Util.byte2str(paramArrayOfByte1.getString()));
        ((Logger)localObject1).log(1, ((StringBuilder)localObject2).toString());
      }
      for (i = 0; i < 10; i++)
      {
        localObject2 = JSch.getLogger();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("kex: client: ");
        ((StringBuilder)localObject1).append(Util.byte2str(paramArrayOfByte2.getString()));
        ((Logger)localObject2).log(1, ((StringBuilder)localObject1).toString());
      }
      paramArrayOfByte1.setOffSet(17);
      paramArrayOfByte2.setOffSet(17);
    }
    for (int j = 0; j < 10; j++)
    {
      localObject2 = paramArrayOfByte1.getString();
      byte[] arrayOfByte = paramArrayOfByte2.getString();
      i = 0;
      int k = 0;
      int m;
      for (;;)
      {
        m = i;
        if (i >= arrayOfByte.length) {
          break;
        }
        while ((i < arrayOfByte.length) && (arrayOfByte[i] != 44)) {
          i++;
        }
        if (k == i) {
          return null;
        }
        localObject1 = Util.byte2str(arrayOfByte, k, i - k);
        k = 0;
        m = 0;
        while (k < localObject2.length)
        {
          while ((k < localObject2.length) && (localObject2[k] != 44)) {
            k++;
          }
          if (m == k) {
            return null;
          }
          if (((String)localObject1).equals(Util.byte2str((byte[])localObject2, m, k - m)))
          {
            arrayOfString[j] = localObject1;
            m = i;
            break label367;
          }
          m = k + 1;
          k = m;
        }
        k = i + 1;
        i = k;
      }
      label367:
      if (m == 0) {
        arrayOfString[j] = "";
      } else if (arrayOfString[j] == null) {
        return null;
      }
    }
    if (JSch.getLogger().isEnabled(1))
    {
      paramArrayOfByte1 = JSch.getLogger();
      paramArrayOfByte2 = new StringBuilder();
      paramArrayOfByte2.append("kex: server->client ");
      paramArrayOfByte2.append(arrayOfString[3]);
      paramArrayOfByte2.append(" ");
      paramArrayOfByte2.append(arrayOfString[5]);
      paramArrayOfByte2.append(" ");
      paramArrayOfByte2.append(arrayOfString[7]);
      paramArrayOfByte1.log(1, paramArrayOfByte2.toString());
      paramArrayOfByte1 = JSch.getLogger();
      paramArrayOfByte2 = new StringBuilder();
      paramArrayOfByte2.append("kex: client->server ");
      paramArrayOfByte2.append(arrayOfString[2]);
      paramArrayOfByte2.append(" ");
      paramArrayOfByte2.append(arrayOfString[4]);
      paramArrayOfByte2.append(" ");
      paramArrayOfByte2.append(arrayOfString[6]);
      paramArrayOfByte1.log(1, paramArrayOfByte2.toString());
    }
    return arrayOfString;
  }
  
  public String getFingerPrint()
  {
    Object localObject;
    try
    {
      localObject = (HASH)Class.forName(this.session.getConfig("md5")).newInstance();
    }
    catch (Exception localException)
    {
      PrintStream localPrintStream = System.err;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFingerPrint: ");
      ((StringBuilder)localObject).append(localException);
      localPrintStream.println(((StringBuilder)localObject).toString());
      localObject = null;
    }
    return Util.getFingerPrint((HASH)localObject, getHostKey());
  }
  
  byte[] getH()
  {
    return this.H;
  }
  
  HASH getHash()
  {
    return this.sha;
  }
  
  byte[] getHostKey()
  {
    return this.K_S;
  }
  
  byte[] getK()
  {
    return this.K;
  }
  
  public String getKeyAlgorithName()
  {
    return this.key_alg_name;
  }
  
  public String getKeyType()
  {
    int i = this.type;
    if (i == 1) {
      return "DSA";
    }
    if (i == 0) {
      return "RSA";
    }
    return "ECDSA";
  }
  
  public abstract int getState();
  
  public abstract void init(Session paramSession, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
    throws Exception;
  
  public abstract boolean next(Buffer paramBuffer)
    throws Exception;
  
  protected byte[] normalize(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte.length > 1)
    {
      arrayOfByte = paramArrayOfByte;
      if (paramArrayOfByte[0] == 0)
      {
        arrayOfByte = paramArrayOfByte;
        if ((paramArrayOfByte[1] & 0x80) == 0)
        {
          int i = paramArrayOfByte.length - 1;
          arrayOfByte = new byte[i];
          System.arraycopy(paramArrayOfByte, 1, arrayOfByte, 0, i);
          arrayOfByte = normalize(arrayOfByte);
        }
      }
    }
    return arrayOfByte;
  }
  
  protected boolean verify(String paramString, byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
    throws Exception
  {
    boolean bool1 = paramString.equals("ssh-rsa");
    byte[] arrayOfByte1 = null;
    byte[] arrayOfByte2 = null;
    byte[] arrayOfByte3 = null;
    boolean bool2 = false;
    int i;
    int j;
    int k;
    int m;
    if (bool1)
    {
      this.type = 0;
      this.key_alg_name = paramString;
      i = paramInt + 1;
      paramInt = paramArrayOfByte1[paramInt];
      j = i + 1;
      i = paramArrayOfByte1[i];
      k = j + 1;
      m = paramArrayOfByte1[j];
      j = k + 1;
      paramInt = i << 16 & 0xFF0000 | paramInt << 24 & 0xFF000000 | m << 8 & 0xFF00 | paramArrayOfByte1[k] & 0xFF;
      arrayOfByte1 = new byte[paramInt];
      System.arraycopy(paramArrayOfByte1, j, arrayOfByte1, 0, paramInt);
      paramInt = j + paramInt;
      i = paramInt + 1;
      j = paramArrayOfByte1[paramInt];
      paramInt = i + 1;
      k = paramArrayOfByte1[i];
      i = paramInt + 1;
      paramInt = k << 16 & 0xFF0000 | j << 24 & 0xFF000000 | 0xFF00 & paramArrayOfByte1[paramInt] << 8 | paramArrayOfByte1[i] & 0xFF;
      arrayOfByte2 = new byte[paramInt];
      System.arraycopy(paramArrayOfByte1, i + 1, arrayOfByte2, 0, paramInt);
      try
      {
        paramString = (SignatureRSA)Class.forName(this.session.getConfig("signature.rsa")).newInstance();
        try
        {
          paramString.init();
        }
        catch (Exception paramArrayOfByte1) {}
        System.err.println(paramArrayOfByte1);
      }
      catch (Exception paramArrayOfByte1)
      {
        paramString = arrayOfByte3;
      }
      paramString.setPubKey(arrayOfByte1, arrayOfByte2);
      paramString.update(this.H);
      bool1 = paramString.verify(paramArrayOfByte2);
      bool2 = bool1;
      if (JSch.getLogger().isEnabled(1))
      {
        paramString = JSch.getLogger();
        paramArrayOfByte1 = new StringBuilder();
        paramArrayOfByte1.append("ssh_rsa_verify: signature ");
        paramArrayOfByte1.append(bool1);
        paramString.log(1, paramArrayOfByte1.toString());
        bool2 = bool1;
      }
    }
    else if (paramString.equals("ssh-dss"))
    {
      this.type = 1;
      this.key_alg_name = paramString;
      i = paramInt + 1;
      paramInt = paramArrayOfByte1[paramInt];
      k = i + 1;
      i = paramArrayOfByte1[i];
      j = k + 1;
      m = paramArrayOfByte1[k];
      k = j + 1;
      paramInt = i << 16 & 0xFF0000 | paramInt << 24 & 0xFF000000 | m << 8 & 0xFF00 | paramArrayOfByte1[j] & 0xFF;
      byte[] arrayOfByte4 = new byte[paramInt];
      System.arraycopy(paramArrayOfByte1, k, arrayOfByte4, 0, paramInt);
      paramInt = k + paramInt;
      i = paramInt + 1;
      paramInt = paramArrayOfByte1[paramInt];
      k = i + 1;
      j = paramArrayOfByte1[i];
      i = k + 1;
      m = paramArrayOfByte1[k];
      k = i + 1;
      paramInt = j << 16 & 0xFF0000 | paramInt << 24 & 0xFF000000 | m << 8 & 0xFF00 | paramArrayOfByte1[i] & 0xFF;
      arrayOfByte2 = new byte[paramInt];
      System.arraycopy(paramArrayOfByte1, k, arrayOfByte2, 0, paramInt);
      paramInt = k + paramInt;
      i = paramInt + 1;
      paramInt = paramArrayOfByte1[paramInt];
      j = i + 1;
      i = paramArrayOfByte1[i];
      k = j + 1;
      m = paramArrayOfByte1[j];
      j = k + 1;
      paramInt = i << 16 & 0xFF0000 | paramInt << 24 & 0xFF000000 | m << 8 & 0xFF00 | paramArrayOfByte1[k] & 0xFF;
      byte[] arrayOfByte5 = new byte[paramInt];
      System.arraycopy(paramArrayOfByte1, j, arrayOfByte5, 0, paramInt);
      i = j + paramInt;
      paramInt = i + 1;
      i = paramArrayOfByte1[i];
      j = paramInt + 1;
      k = paramArrayOfByte1[paramInt];
      paramInt = j + 1;
      i = k << 16 & 0xFF0000 | 0xFF000000 & i << 24 | 0xFF00 & paramArrayOfByte1[j] << 8 | paramArrayOfByte1[paramInt] & 0xFF;
      arrayOfByte3 = new byte[i];
      System.arraycopy(paramArrayOfByte1, paramInt + 1, arrayOfByte3, 0, i);
      try
      {
        paramString = (SignatureDSA)Class.forName(this.session.getConfig("signature.dss")).newInstance();
        try
        {
          paramString.init();
        }
        catch (Exception paramArrayOfByte1) {}
        System.err.println(paramArrayOfByte1);
      }
      catch (Exception paramArrayOfByte1)
      {
        paramString = arrayOfByte1;
      }
      paramString.setPubKey(arrayOfByte3, arrayOfByte4, arrayOfByte2, arrayOfByte5);
      paramString.update(this.H);
      bool1 = paramString.verify(paramArrayOfByte2);
      bool2 = bool1;
      if (JSch.getLogger().isEnabled(1))
      {
        paramString = JSch.getLogger();
        paramArrayOfByte1 = new StringBuilder();
        paramArrayOfByte1.append("ssh_dss_verify: signature ");
        paramArrayOfByte1.append(bool1);
        paramString.log(1, paramArrayOfByte1.toString());
        bool2 = bool1;
      }
    }
    else if ((!paramString.equals("ecdsa-sha2-nistp256")) && (!paramString.equals("ecdsa-sha2-nistp384")) && (!paramString.equals("ecdsa-sha2-nistp521")))
    {
      System.err.println("unknown alg");
    }
    else
    {
      this.type = 2;
      this.key_alg_name = paramString;
      i = paramInt + 1;
      paramInt = paramArrayOfByte1[paramInt];
      k = i + 1;
      i = paramArrayOfByte1[i];
      j = k + 1;
      m = paramArrayOfByte1[k];
      k = j + 1;
      paramInt = paramInt << 24 & 0xFF000000 | i << 16 & 0xFF0000 | m << 8 & 0xFF00 | paramArrayOfByte1[j] & 0xFF;
      System.arraycopy(paramArrayOfByte1, k, new byte[paramInt], 0, paramInt);
      paramInt = k + paramInt;
      i = paramInt + 1;
      paramInt = paramArrayOfByte1[paramInt];
      k = i + 1;
      i = paramArrayOfByte1[i];
      j = k + 1;
      m = paramArrayOfByte1[k];
      k = paramArrayOfByte1[j];
      j = j + 1 + 1;
      paramInt = ((i << 16 & 0xFF0000 | 0xFF000000 & paramInt << 24 | 0xFF00 & m << 8 | k & 0xFF) - 1) / 2;
      arrayOfByte1 = new byte[paramInt];
      System.arraycopy(paramArrayOfByte1, j, arrayOfByte1, 0, paramInt);
      arrayOfByte3 = new byte[paramInt];
      System.arraycopy(paramArrayOfByte1, j + paramInt, arrayOfByte3, 0, paramInt);
      try
      {
        paramString = (SignatureECDSA)Class.forName(this.session.getConfig(paramString)).newInstance();
        try
        {
          paramString.init();
        }
        catch (Exception paramArrayOfByte1) {}
        System.err.println(paramArrayOfByte1);
      }
      catch (Exception paramArrayOfByte1)
      {
        paramString = arrayOfByte2;
      }
      paramString.setPubKey(arrayOfByte1, arrayOfByte3);
      paramString.update(this.H);
      bool2 = paramString.verify(paramArrayOfByte2);
    }
    return bool2;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\KeyExchange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */