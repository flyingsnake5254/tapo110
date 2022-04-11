package com.jcraft.jsch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Hashtable;
import java.util.Vector;

public abstract class KeyPair
{
  public static final int DSA = 1;
  public static final int ECDSA = 3;
  public static final int ERROR = 0;
  public static final int RSA = 2;
  public static final int UNKNOWN = 4;
  static final int VENDOR_FSECURE = 1;
  static final int VENDOR_OPENSSH = 0;
  static final int VENDOR_PKCS8 = 3;
  static final int VENDOR_PUTTY = 2;
  private static final byte[] cr = Util.str2byte("\n");
  static byte[][] header = { Util.str2byte("Proc-Type: 4,ENCRYPTED"), Util.str2byte("DEK-Info: DES-EDE3-CBC,") };
  private static final String[] header1 = { "PuTTY-User-Key-File-2: ", "Encryption: ", "Comment: ", "Public-Lines: " };
  private static final String[] header2 = { "Private-Lines: " };
  private static final String[] header3 = { "Private-MAC: " };
  private static byte[] space = Util.str2byte(" ");
  private Cipher cipher;
  protected byte[] data = null;
  protected boolean encrypted = false;
  private HASH hash;
  private byte[] iv = null;
  JSch jsch = null;
  private byte[] passphrase;
  protected String publicKeyComment = "no comment";
  private byte[] publickeyblob = null;
  private Random random;
  int vendor = 0;
  
  public KeyPair(JSch paramJSch)
  {
    this.jsch = paramJSch;
  }
  
  private static byte a2b(byte paramByte)
  {
    if ((48 <= paramByte) && (paramByte <= 57)) {
      paramByte -= 48;
    }
    for (;;)
    {
      return (byte)paramByte;
      paramByte = paramByte - 97 + 10;
    }
  }
  
  private static byte b2a(byte paramByte)
  {
    if ((paramByte >= 0) && (paramByte <= 9)) {
      paramByte += 48;
    }
    for (;;)
    {
      return (byte)paramByte;
      paramByte = paramByte - 10 + 65;
    }
  }
  
  private byte[] decrypt(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    try
    {
      paramArrayOfByte2 = genKey(paramArrayOfByte2, paramArrayOfByte3);
      this.cipher.init(1, paramArrayOfByte2, paramArrayOfByte3);
      Util.bzero(paramArrayOfByte2);
      paramArrayOfByte2 = new byte[paramArrayOfByte1.length];
      this.cipher.update(paramArrayOfByte1, 0, paramArrayOfByte1.length, paramArrayOfByte2, 0);
      return paramArrayOfByte2;
    }
    catch (Exception paramArrayOfByte1) {}
    return null;
  }
  
  private byte[] encrypt(byte[] paramArrayOfByte1, byte[][] paramArrayOfByte, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte2 == null) {
      return paramArrayOfByte1;
    }
    if (this.cipher == null) {
      this.cipher = genCipher();
    }
    int i = this.cipher.getIVSize();
    byte[] arrayOfByte = new byte[i];
    paramArrayOfByte[0] = arrayOfByte;
    if (this.random == null) {
      this.random = genRandom();
    }
    this.random.fill(arrayOfByte, 0, i);
    paramArrayOfByte2 = genKey(paramArrayOfByte2, arrayOfByte);
    i = this.cipher.getIVSize();
    int j = (paramArrayOfByte1.length / i + 1) * i;
    paramArrayOfByte = new byte[j];
    System.arraycopy(paramArrayOfByte1, 0, paramArrayOfByte, 0, paramArrayOfByte1.length);
    int k = i - paramArrayOfByte1.length % i;
    for (i = j - 1; j - k <= i; i--) {
      paramArrayOfByte[i] = ((byte)(byte)k);
    }
    try
    {
      this.cipher.init(0, paramArrayOfByte2, arrayOfByte);
      this.cipher.update(paramArrayOfByte, 0, j, paramArrayOfByte, 0);
      Util.bzero(paramArrayOfByte2);
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte1)
    {
      for (;;) {}
    }
  }
  
  private Cipher genCipher()
  {
    try
    {
      this.cipher = ((Cipher)Class.forName(JSch.getConfig("3des-cbc")).newInstance());
      return this.cipher;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  private HASH genHash()
  {
    try
    {
      HASH localHASH = (HASH)Class.forName(JSch.getConfig("md5")).newInstance();
      this.hash = localHASH;
      localHASH.init();
      return this.hash;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public static KeyPair genKeyPair(JSch paramJSch, int paramInt)
    throws JSchException
  {
    return genKeyPair(paramJSch, paramInt, 1024);
  }
  
  public static KeyPair genKeyPair(JSch paramJSch, int paramInt1, int paramInt2)
    throws JSchException
  {
    if (paramInt1 == 1) {
      paramJSch = new KeyPairDSA(paramJSch);
    } else if (paramInt1 == 2) {
      paramJSch = new KeyPairRSA(paramJSch);
    } else if (paramInt1 == 3) {
      paramJSch = new KeyPairECDSA(paramJSch);
    } else {
      paramJSch = null;
    }
    if (paramJSch != null) {
      paramJSch.generate(paramInt2);
    }
    return paramJSch;
  }
  
  private Random genRandom()
  {
    if (this.random == null) {
      try
      {
        this.random = ((Random)Class.forName(JSch.getConfig("random")).newInstance());
      }
      catch (Exception localException)
      {
        PrintStream localPrintStream = System.err;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("connect: random ");
        localStringBuilder.append(localException);
        localPrintStream.println(localStringBuilder.toString());
      }
    }
    return this.random;
  }
  
  public static KeyPair load(JSch paramJSch, String paramString)
    throws JSchException
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(".pub");
    String str = ((StringBuilder)localObject).toString();
    localObject = str;
    if (!new File(str).exists()) {
      localObject = null;
    }
    return load(paramJSch, paramString, (String)localObject);
  }
  
  public static KeyPair load(JSch paramJSch, String paramString1, String paramString2)
    throws JSchException
  {
    try
    {
      byte[] arrayOfByte = Util.fromFile(paramString1);
      if (paramString2 == null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString1);
        localStringBuilder.append(".pub");
        paramString1 = localStringBuilder.toString();
      }
      else
      {
        paramString1 = paramString2;
      }
      try
      {
        paramString1 = Util.fromFile(paramString1);
      }
      catch (IOException paramString1)
      {
        if (paramString2 != null) {
          break label79;
        }
      }
      paramString1 = null;
      try
      {
        paramJSch = load(paramJSch, arrayOfByte, paramString1);
        return paramJSch;
      }
      finally
      {
        Util.bzero(arrayOfByte);
      }
      label79:
      throw new JSchException(paramString1.toString(), paramString1);
    }
    catch (IOException paramJSch)
    {
      throw new JSchException(paramJSch.toString(), paramJSch);
    }
  }
  
  public static KeyPair load(JSch paramJSch, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws JSchException
  {
    Object localObject1 = new byte[8];
    if ((paramArrayOfByte2 == null) && (paramArrayOfByte1 != null) && (paramArrayOfByte1.length > 11) && (paramArrayOfByte1[0] == 0) && (paramArrayOfByte1[1] == 0) && (paramArrayOfByte1[2] == 0) && ((paramArrayOfByte1[3] == 7) || (paramArrayOfByte1[3] == 19)))
    {
      paramArrayOfByte2 = new Buffer(paramArrayOfByte1);
      paramArrayOfByte2.skip(paramArrayOfByte1.length);
      localObject2 = new String(paramArrayOfByte2.getString());
      paramArrayOfByte2.rewind();
      if (((String)localObject2).equals("ssh-rsa"))
      {
        paramJSch = KeyPairRSA.fromSSHAgent(paramJSch, paramArrayOfByte2);
      }
      else if (((String)localObject2).equals("ssh-dss"))
      {
        paramJSch = KeyPairDSA.fromSSHAgent(paramJSch, paramArrayOfByte2);
      }
      else
      {
        if ((!((String)localObject2).equals("ecdsa-sha2-nistp256")) && (!((String)localObject2).equals("ecdsa-sha2-nistp384")) && (!((String)localObject2).equals("ecdsa-sha2-nistp521")))
        {
          paramJSch = new StringBuilder();
          paramJSch.append("privatekey: invalid key ");
          paramJSch.append(new String(paramArrayOfByte1, 4, 7));
          throw new JSchException(paramJSch.toString());
        }
        paramJSch = KeyPairECDSA.fromSSHAgent(paramJSch, paramArrayOfByte2);
      }
      return paramJSch;
    }
    if (paramArrayOfByte1 != null) {
      try
      {
        localObject2 = loadPPK(paramJSch, paramArrayOfByte1);
        if (localObject2 != null) {
          return (KeyPair)localObject2;
        }
      }
      catch (Exception paramJSch) {}
    }
    int i;
    if (paramArrayOfByte1 != null) {
      i = paramArrayOfByte1.length;
    } else {
      i = 0;
    }
    for (j = 0; j < i; j++) {
      if (paramArrayOfByte1[j] == 45)
      {
        k = j + 4;
        if ((k < i) && (paramArrayOfByte1[(j + 1)] == 45) && (paramArrayOfByte1[(j + 2)] == 45) && (paramArrayOfByte1[(j + 3)] == 45))
        {
          k = paramArrayOfByte1[k];
          if (k == 45) {
            break;
          }
        }
      }
    }
    int m = 0;
    int k = 0;
    boolean bool1 = true;
    boolean bool2;
    int i1;
    int i2;
    label834:
    int i3;
    for (Object localObject4 = null;; localObject4 = localObject5)
    {
      n = j;
      bool2 = bool1;
      if (j >= i) {
        break;
      }
      if (paramArrayOfByte1[j] == 66)
      {
        n = j + 3;
        if ((n < i) && (paramArrayOfByte1[(j + 1)] == 69) && (paramArrayOfByte1[(j + 2)] == 71) && (paramArrayOfByte1[n] == 73))
        {
          n = j + 6;
          i1 = n + 2;
          if (i1 < i)
          {
            if ((paramArrayOfByte1[n] == 68) && (paramArrayOfByte1[(n + 1)] == 83) && (paramArrayOfByte1[i1] == 65))
            {
              k = 1;
              j = m;
            }
            else if ((paramArrayOfByte1[n] == 82) && (paramArrayOfByte1[(n + 1)] == 83) && (paramArrayOfByte1[i1] == 65))
            {
              k = 2;
              j = m;
            }
            else if ((paramArrayOfByte1[n] == 69) && (paramArrayOfByte1[(n + 1)] == 67))
            {
              k = 3;
              j = m;
            }
            else
            {
              if ((paramArrayOfByte1[n] == 83) && (paramArrayOfByte1[(n + 1)] == 83) && (paramArrayOfByte1[i1] == 72)) {}
              for (j = 1;; j = 3)
              {
                k = 4;
                break;
                j = n + 6;
                if ((j < i) && (paramArrayOfByte1[n] == 80) && (paramArrayOfByte1[(n + 1)] == 82) && (paramArrayOfByte1[i1] == 73))
                {
                  k = n + 3;
                  if ((paramArrayOfByte1[k] == 86) && (paramArrayOfByte1[(n + 4)] == 65) && (paramArrayOfByte1[(n + 5)] == 84) && (paramArrayOfByte1[j] == 69))
                  {
                    n = k;
                    j = 3;
                    k = 4;
                    bool1 = false;
                    break;
                  }
                }
                m = n + 8;
                if ((m >= i) || (paramArrayOfByte1[n] != 69) || (paramArrayOfByte1[(n + 1)] != 78) || (paramArrayOfByte1[i1] != 67) || (paramArrayOfByte1[(n + 3)] != 82) || (paramArrayOfByte1[(n + 4)] != 89)) {
                  break label834;
                }
                k = n + 5;
                if ((paramArrayOfByte1[k] != 80) || (paramArrayOfByte1[j] != 84) || (paramArrayOfByte1[(n + 7)] != 69) || (paramArrayOfByte1[m] != 68)) {
                  break label834;
                }
                n = k;
              }
            }
            n += 3;
            localObject2 = localObject1;
            i1 = j;
            i2 = k;
            bool2 = bool1;
            localObject5 = localObject4;
            break label1884;
            paramJSch = new com/jcraft/jsch/JSchException;
            paramArrayOfByte2 = new java/lang/StringBuilder;
            paramArrayOfByte2.<init>();
            paramArrayOfByte2.append("invalid privatekey: ");
            paramArrayOfByte2.append(paramArrayOfByte1);
            paramJSch.<init>(paramArrayOfByte2.toString());
            throw paramJSch;
          }
          paramJSch = new com/jcraft/jsch/JSchException;
          paramArrayOfByte2 = new java/lang/StringBuilder;
          paramArrayOfByte2.<init>();
          paramArrayOfByte2.append("invalid privatekey: ");
          paramArrayOfByte2.append(paramArrayOfByte1);
          paramJSch.<init>(paramArrayOfByte2.toString());
          throw paramJSch;
        }
      }
      if (paramArrayOfByte1[j] == 65)
      {
        n = j + 7;
        if ((n < i) && (paramArrayOfByte1[(j + 1)] == 69) && (paramArrayOfByte1[(j + 2)] == 83) && (paramArrayOfByte1[(j + 3)] == 45) && (paramArrayOfByte1[(j + 4)] == 50) && (paramArrayOfByte1[(j + 5)] == 53) && (paramArrayOfByte1[(j + 6)] == 54) && (paramArrayOfByte1[n] == 45))
        {
          n = j + 8;
          if (Session.checkCipher(JSch.getConfig("aes256-cbc")))
          {
            localObject5 = (Cipher)Class.forName(JSch.getConfig("aes256-cbc")).newInstance();
            localObject2 = new byte[((Cipher)localObject5).getIVSize()];
            i1 = m;
            i2 = k;
            bool2 = bool1;
            break label1884;
          }
          paramArrayOfByte2 = new com/jcraft/jsch/JSchException;
          paramJSch = new java/lang/StringBuilder;
          paramJSch.<init>();
          paramJSch.append("privatekey: aes256-cbc is not available ");
          paramJSch.append(paramArrayOfByte1);
          paramArrayOfByte2.<init>(paramJSch.toString());
          throw paramArrayOfByte2;
        }
      }
      if (paramArrayOfByte1[j] == 65)
      {
        n = j + 7;
        if ((n < i) && (paramArrayOfByte1[(j + 1)] == 69) && (paramArrayOfByte1[(j + 2)] == 83) && (paramArrayOfByte1[(j + 3)] == 45) && (paramArrayOfByte1[(j + 4)] == 49) && (paramArrayOfByte1[(j + 5)] == 57) && (paramArrayOfByte1[(j + 6)] == 50) && (paramArrayOfByte1[n] == 45))
        {
          n = j + 8;
          if (Session.checkCipher(JSch.getConfig("aes192-cbc")))
          {
            localObject5 = (Cipher)Class.forName(JSch.getConfig("aes192-cbc")).newInstance();
            localObject2 = new byte[((Cipher)localObject5).getIVSize()];
            i1 = m;
            i2 = k;
            bool2 = bool1;
            break label1884;
          }
          paramArrayOfByte2 = new com/jcraft/jsch/JSchException;
          paramJSch = new java/lang/StringBuilder;
          paramJSch.<init>();
          paramJSch.append("privatekey: aes192-cbc is not available ");
          paramJSch.append(paramArrayOfByte1);
          paramArrayOfByte2.<init>(paramJSch.toString());
          throw paramArrayOfByte2;
        }
      }
      if (paramArrayOfByte1[j] == 65)
      {
        n = j + 7;
        if ((n < i) && (paramArrayOfByte1[(j + 1)] == 69) && (paramArrayOfByte1[(j + 2)] == 83) && (paramArrayOfByte1[(j + 3)] == 45) && (paramArrayOfByte1[(j + 4)] == 49) && (paramArrayOfByte1[(j + 5)] == 50) && (paramArrayOfByte1[(j + 6)] == 56) && (paramArrayOfByte1[n] == 45))
        {
          n = j + 8;
          if (Session.checkCipher(JSch.getConfig("aes128-cbc")))
          {
            localObject5 = (Cipher)Class.forName(JSch.getConfig("aes128-cbc")).newInstance();
            localObject2 = new byte[((Cipher)localObject5).getIVSize()];
            i1 = m;
            i2 = k;
            bool2 = bool1;
            break label1884;
          }
          paramJSch = new com/jcraft/jsch/JSchException;
          paramArrayOfByte2 = new java/lang/StringBuilder;
          paramArrayOfByte2.<init>();
          paramArrayOfByte2.append("privatekey: aes128-cbc is not available ");
          paramArrayOfByte2.append(paramArrayOfByte1);
          paramJSch.<init>(paramArrayOfByte2.toString());
          throw paramJSch;
        }
      }
      if (paramArrayOfByte1[j] == 67)
      {
        n = j + 3;
        if ((n < i) && (paramArrayOfByte1[(j + 1)] == 66) && (paramArrayOfByte1[(j + 2)] == 67) && (paramArrayOfByte1[n] == 44))
        {
          j += 4;
          for (i3 = 0;; i3++)
          {
            localObject2 = localObject1;
            n = j;
            i1 = m;
            i2 = k;
            bool2 = bool1;
            localObject5 = localObject4;
            if (i3 >= localObject1.length) {
              break;
            }
            n = j + 1;
            i1 = a2b(paramArrayOfByte1[j]);
            j = n + 1;
            localObject1[i3] = ((byte)(byte)((i1 << 4 & 0xF0) + (a2b(paramArrayOfByte1[n]) & 0xF)));
          }
        }
      }
      if (paramArrayOfByte1[j] == 13)
      {
        n = j + 1;
        if ((n < paramArrayOfByte1.length) && (paramArrayOfByte1[n] == 10))
        {
          localObject2 = localObject1;
          i1 = m;
          i2 = k;
          bool2 = bool1;
          localObject5 = localObject4;
          break label1884;
        }
      }
      if (paramArrayOfByte1[j] == 10)
      {
        n = j + 1;
        if (n < paramArrayOfByte1.length)
        {
          if (paramArrayOfByte1[n] == 10)
          {
            n = j + 2;
            bool2 = bool1;
            break;
          }
          if (paramArrayOfByte1[n] == 13)
          {
            i1 = j + 2;
            if ((i1 < paramArrayOfByte1.length) && (paramArrayOfByte1[i1] == 10))
            {
              n = j + 3;
              bool2 = bool1;
              break;
            }
          }
          for (i1 = n; (i1 < paramArrayOfByte1.length) && (paramArrayOfByte1[i1] != 10); i1++) {
            if (paramArrayOfByte1[i1] == 58)
            {
              i1 = 1;
              break label1826;
            }
          }
          i1 = 0;
          label1826:
          if (i1 == 0)
          {
            j = n;
            n = j;
            bool2 = bool1;
            if (m == 3) {
              break;
            }
            bool2 = false;
            n = j;
            break;
          }
        }
      }
      n = j + 1;
      localObject5 = localObject4;
      bool2 = bool1;
      i2 = k;
      i1 = m;
      localObject2 = localObject1;
      label1884:
      localObject1 = localObject2;
      j = n;
      m = i1;
      k = i2;
      bool1 = bool2;
    }
    if (paramArrayOfByte1 != null)
    {
      if (k != 0)
      {
        for (j = n; (j < i) && (paramArrayOfByte1[j] != 45); j++) {}
        if (i - j != 0)
        {
          i = j - n;
          if (i != 0)
          {
            localObject5 = new byte[i];
            System.arraycopy(paramArrayOfByte1, n, localObject5, 0, i);
            j = 0;
            n = i;
            while (j < n) {
              if (localObject5[j] == 10)
              {
                if (localObject5[(j - 1)] == 13) {
                  i = 1;
                } else {
                  i = 0;
                }
                i3 = j + 1;
                if (i != 0) {
                  i1 = 1;
                } else {
                  i1 = 0;
                }
                System.arraycopy(localObject5, i3, localObject5, j - i1, n - i3);
                i1 = n;
                if (i != 0) {
                  i1 = n - 1;
                }
                n = i1 - 1;
              }
              else
              {
                if (localObject5[j] == 45) {
                  break;
                }
                j++;
              }
            }
            n = j - 0;
            if (n > 0) {
              localObject2 = Util.fromBase64((byte[])localObject5, 0, n);
            } else {
              localObject2 = null;
            }
            Util.bzero((byte[])localObject5);
            break label2222;
          }
        }
        paramArrayOfByte2 = new com/jcraft/jsch/JSchException;
        paramJSch = new java/lang/StringBuilder;
        paramJSch.<init>();
        paramJSch.append("invalid privatekey: ");
        paramJSch.append(paramArrayOfByte1);
        paramArrayOfByte2.<init>(paramJSch.toString());
        throw paramArrayOfByte2;
      }
      else
      {
        paramArrayOfByte2 = new com/jcraft/jsch/JSchException;
        paramJSch = new java/lang/StringBuilder;
        paramJSch.<init>();
        paramJSch.append("invalid privatekey: ");
        paramJSch.append(paramArrayOfByte1);
        paramArrayOfByte2.<init>(paramJSch.toString());
        throw paramArrayOfByte2;
      }
    }
    else {
      localObject2 = null;
    }
    label2222:
    if ((localObject2 != null) && (localObject2.length > 4) && (localObject2[0] == 63) && (localObject2[1] == 111) && (localObject2[2] == -7) && (localObject2[3] == -21))
    {
      localObject5 = new com/jcraft/jsch/Buffer;
      ((Buffer)localObject5).<init>((byte[])localObject2);
      ((Buffer)localObject5).getInt();
      ((Buffer)localObject5).getInt();
      ((Buffer)localObject5).getString();
      localObject6 = Util.byte2str(((Buffer)localObject5).getString());
      if (!((String)localObject6).equals("3des-cbc"))
      {
        if (((String)localObject6).equals("none"))
        {
          ((Buffer)localObject5).getInt();
          ((Buffer)localObject5).getInt();
          localObject7 = new byte[localObject2.length - ((Buffer)localObject5).getOffSet()];
          ((Buffer)localObject5).getByte((byte[])localObject7);
          bool1 = false;
          break label2460;
        }
      }
      else
      {
        ((Buffer)localObject5).getInt();
        ((Buffer)localObject5).getByte(new byte[localObject2.length - ((Buffer)localObject5).getOffSet()]);
        paramJSch = new com/jcraft/jsch/JSchException;
        paramArrayOfByte2 = new java/lang/StringBuilder;
        paramArrayOfByte2.<init>();
        paramArrayOfByte2.append("unknown privatekey format: ");
        paramArrayOfByte2.append(paramArrayOfByte1);
        paramJSch.<init>(paramArrayOfByte2.toString());
        throw paramJSch;
        if (!(paramJSch instanceof JSchException)) {
          throw new JSchException(paramJSch.toString(), paramJSch);
        }
        throw ((JSchException)paramJSch);
      }
    }
    bool1 = bool2;
    Object localObject7 = localObject2;
    label2460:
    Object localObject2 = "";
    if (paramArrayOfByte2 != null) {
      localObject5 = localObject2;
    }
    for (;;)
    {
      try
      {
        i2 = paramArrayOfByte2.length;
        localObject5 = localObject2;
        if ((paramArrayOfByte2.length > 4) && (paramArrayOfByte2[0] == 45) && (paramArrayOfByte2[1] == 45) && (paramArrayOfByte2[2] == 45) && (paramArrayOfByte2[3] == 45))
        {
          n = 0;
          i = n + 1;
          localObject5 = localObject2;
          if (paramArrayOfByte2.length > i)
          {
            n = i;
            if (paramArrayOfByte2[i] != 10) {
              continue;
            }
          }
          localObject5 = localObject2;
          if (paramArrayOfByte2.length <= i) {
            n = 0;
          } else {
            n = 1;
          }
          if (n != 0)
          {
            if (paramArrayOfByte2[i] == 10)
            {
              j = i + 1;
              i1 = j;
              localObject5 = localObject2;
              if (i1 < paramArrayOfByte2.length)
              {
                i3 = paramArrayOfByte2[i1];
                localObject5 = localObject2;
                if (i3 != 10)
                {
                  if (paramArrayOfByte2[i1] == 58)
                  {
                    i1 = 1;
                    continue;
                  }
                  i1++;
                  localObject2 = localObject5;
                  continue;
                }
              }
              i1 = 0;
              localObject5 = localObject2;
              if (i1 == 0)
              {
                i = j;
                continue;
              }
            }
            else
            {
              localObject5 = localObject2;
            }
            i++;
            localObject2 = localObject5;
            continue;
          }
          i1 = n;
          j = k;
          localObject5 = localObject2;
        }
      }
      catch (Exception localException1)
      {
        Object localObject8;
        n = k;
      }
      try
      {
        if (paramArrayOfByte2.length <= i) {
          i1 = 0;
        }
        i3 = i;
        n = i2;
        if ((i1 != 0) && (i3 < n))
        {
          if (paramArrayOfByte2[i3] == 10)
          {
            j = k;
            localObject5 = localObject2;
            System.arraycopy(paramArrayOfByte2, i3 + 1, paramArrayOfByte2, i3, n - i3 - 1);
            n--;
            continue;
          }
          if (paramArrayOfByte2[i3] != 45)
          {
            i3++;
            continue;
          }
        }
        n = k;
        localObject5 = localObject2;
        if (i1 == 0) {
          break label3606;
        }
        j = k;
        localObject5 = localObject2;
        localObject8 = Util.fromBase64(paramArrayOfByte2, i, i3 - i);
        if (paramArrayOfByte1 != null)
        {
          localObject5 = localObject8;
          n = k;
          localObject6 = localObject2;
          if (k != 4) {}
        }
        else if (localObject8[8] == 100)
        {
          n = 1;
          localObject5 = localObject8;
          localObject6 = localObject2;
        }
        else
        {
          j = localObject8[8];
          localObject5 = localObject8;
          n = k;
          localObject6 = localObject2;
          if (j == 114)
          {
            n = 2;
            localObject5 = localObject8;
            localObject6 = localObject2;
          }
        }
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          n = j;
        }
      }
    }
    localObject2 = "";
    if ((paramArrayOfByte2[0] == 115) && (paramArrayOfByte2[1] == 115) && (paramArrayOfByte2[2] == 104) && (paramArrayOfByte2[3] == 45))
    {
      n = k;
      if (paramArrayOfByte1 == null)
      {
        n = k;
        j = k;
        localObject5 = localObject2;
        if (paramArrayOfByte2.length > 7) {
          if (paramArrayOfByte2[4] == 100)
          {
            n = 1;
          }
          else
          {
            n = k;
            if (paramArrayOfByte2[4] == 114) {
              n = 2;
            }
          }
        }
      }
      for (k = 0; (k < i2) && (paramArrayOfByte2[k] != 32); k++) {}
      i = k + 1;
      if (i < i2)
      {
        for (k = i; (k < i2) && (paramArrayOfByte2[k] != 32); k++) {}
        j = n;
        localObject5 = localObject2;
        localObject6 = Util.fromBase64(paramArrayOfByte2, i, k - i);
        localObject5 = localObject6;
        i = k;
      }
      else
      {
        localObject5 = null;
      }
      i1 = i + 1;
      localObject8 = localObject5;
      k = n;
      localObject6 = localObject2;
      if (i < i2) {
        for (k = i1; (k < i2) && (paramArrayOfByte2[k] != 10); k++) {}
      }
    }
    for (;;)
    {
      localObject5 = localObject8;
      n = k;
      break label3617;
      j = k;
      if (k > 0)
      {
        j = k;
        if (paramArrayOfByte2[(k - 1)] == 13) {
          j = k - 1;
        }
      }
      if (i1 < j)
      {
        localObject8 = localObject5;
        k = n;
      }
      try
      {
        localObject6 = new java/lang/String;
        localObject8 = localObject5;
        k = n;
        ((String)localObject6).<init>(paramArrayOfByte2, i1, j - i1);
        localObject2 = localObject6;
        localObject8 = localObject5;
        k = n;
        localObject6 = localObject2;
      }
      catch (Exception localException3)
      {
        Object localObject3;
        localObject6 = localException2;
      }
      n = k;
      localObject5 = localObject2;
      if (paramArrayOfByte2[0] != 101) {
        break;
      }
      n = k;
      localObject5 = localObject2;
      if (paramArrayOfByte2[1] != 99) {
        break;
      }
      n = k;
      localObject5 = localObject2;
      if (paramArrayOfByte2[2] != 100) {
        break;
      }
      n = k;
      localObject5 = localObject2;
      if (paramArrayOfByte2[3] != 115) {
        break;
      }
      n = k;
      if (paramArrayOfByte1 == null)
      {
        n = k;
        j = k;
        localObject5 = localObject2;
        if (paramArrayOfByte2.length > 7) {
          n = 3;
        }
      }
      for (k = 0; (k < i2) && (paramArrayOfByte2[k] != 32); k++) {}
      i = k + 1;
      if (i < i2)
      {
        for (k = i; (k < i2) && (paramArrayOfByte2[k] != 32); k++) {}
        j = n;
        localObject5 = localObject2;
        localObject6 = Util.fromBase64(paramArrayOfByte2, i, k - i);
        localObject5 = localObject6;
        i = k;
      }
      else
      {
        localObject5 = null;
      }
      i1 = i + 1;
      localObject8 = localObject5;
      k = n;
      localObject6 = localObject2;
      if (i < i2)
      {
        for (k = i1; (k < i2) && (paramArrayOfByte2[k] != 10); k++) {}
        j = k;
        if (k > 0)
        {
          j = k;
          if (paramArrayOfByte2[(k - 1)] == 13) {
            j = k - 1;
          }
        }
        localObject8 = localObject5;
        k = n;
        localObject6 = localObject2;
        if (i1 < j)
        {
          localObject8 = localObject5;
          k = n;
          localObject6 = new String(paramArrayOfByte2, i1, j - i1);
          localObject8 = localObject5;
          k = n;
        }
      }
    }
    label3606:
    localObject3 = null;
    localObject6 = localObject5;
    Object localObject5 = localObject3;
    label3617:
    localObject3 = localObject6;
    k = n;
    break label3636;
    localObject3 = "";
    localObject5 = null;
    label3636:
    if (k == 1) {
      paramJSch = new KeyPairDSA(paramJSch);
    } else if (k == 2) {
      paramJSch = new KeyPairRSA(paramJSch);
    } else if (k == 3) {
      paramJSch = new KeyPairECDSA(paramJSch, paramArrayOfByte2);
    } else if (m == 3) {
      paramJSch = new KeyPairPKCS8(paramJSch);
    } else {
      paramJSch = null;
    }
    if (paramJSch != null)
    {
      paramJSch.encrypted = bool1;
      paramJSch.publickeyblob = ((byte[])localObject5);
      paramJSch.vendor = m;
      paramJSch.publicKeyComment = ((String)localObject3);
      paramJSch.cipher = ((Cipher)localObject4);
      if (bool1)
      {
        paramJSch.encrypted = true;
        paramJSch.iv = ((byte[])localObject1);
        paramJSch.data = ((byte[])localObject7);
      }
      else
      {
        if (paramJSch.parse((byte[])localObject7))
        {
          paramJSch.encrypted = false;
          return paramJSch;
        }
        paramJSch = new StringBuilder();
        paramJSch.append("invalid privatekey: ");
        paramJSch.append(paramArrayOfByte1);
        throw new JSchException(paramJSch.toString());
      }
    }
    return paramJSch;
  }
  
  static KeyPair loadPPK(JSch paramJSch, byte[] paramArrayOfByte)
    throws JSchException
  {
    Object localObject1 = new Buffer(paramArrayOfByte);
    paramArrayOfByte = new Hashtable();
    while (parseHeader((Buffer)localObject1, paramArrayOfByte)) {}
    Object localObject2 = (String)paramArrayOfByte.get("PuTTY-User-Key-File-2");
    if (localObject2 == null) {
      return null;
    }
    byte[] arrayOfByte1 = parseLines((Buffer)localObject1, Integer.parseInt((String)paramArrayOfByte.get("Public-Lines")));
    while (parseHeader((Buffer)localObject1, paramArrayOfByte)) {}
    byte[] arrayOfByte2 = parseLines((Buffer)localObject1, Integer.parseInt((String)paramArrayOfByte.get("Private-Lines")));
    while (parseHeader((Buffer)localObject1, paramArrayOfByte)) {}
    arrayOfByte2 = Util.fromBase64(arrayOfByte2, 0, arrayOfByte2.length);
    arrayOfByte1 = Util.fromBase64(arrayOfByte1, 0, arrayOfByte1.length);
    if (((String)localObject2).equals("ssh-rsa"))
    {
      localObject2 = new Buffer(arrayOfByte1);
      ((Buffer)localObject2).skip(arrayOfByte1.length);
      ((Buffer)localObject2).getByte(new byte[((Buffer)localObject2).getInt()]);
      localObject1 = new byte[((Buffer)localObject2).getInt()];
      ((Buffer)localObject2).getByte((byte[])localObject1);
      arrayOfByte1 = new byte[((Buffer)localObject2).getInt()];
      ((Buffer)localObject2).getByte(arrayOfByte1);
      paramJSch = new KeyPairRSA(paramJSch, arrayOfByte1, (byte[])localObject1, null);
    }
    else
    {
      if (!((String)localObject2).equals("ssh-dss")) {
        break label442;
      }
      localObject2 = new Buffer(arrayOfByte1);
      ((Buffer)localObject2).skip(arrayOfByte1.length);
      ((Buffer)localObject2).getByte(new byte[((Buffer)localObject2).getInt()]);
      localObject1 = new byte[((Buffer)localObject2).getInt()];
      ((Buffer)localObject2).getByte((byte[])localObject1);
      byte[] arrayOfByte3 = new byte[((Buffer)localObject2).getInt()];
      ((Buffer)localObject2).getByte(arrayOfByte3);
      arrayOfByte1 = new byte[((Buffer)localObject2).getInt()];
      ((Buffer)localObject2).getByte(arrayOfByte1);
      byte[] arrayOfByte4 = new byte[((Buffer)localObject2).getInt()];
      ((Buffer)localObject2).getByte(arrayOfByte4);
      paramJSch = new KeyPairDSA(paramJSch, (byte[])localObject1, arrayOfByte3, arrayOfByte1, arrayOfByte4, null);
    }
    paramJSch.encrypted = (paramArrayOfByte.get("Encryption").equals("none") ^ true);
    paramJSch.vendor = 2;
    paramJSch.publicKeyComment = ((String)paramArrayOfByte.get("Comment"));
    if (paramJSch.encrypted)
    {
      if (Session.checkCipher(JSch.getConfig("aes256-cbc"))) {
        try
        {
          paramArrayOfByte = (Cipher)Class.forName(JSch.getConfig("aes256-cbc")).newInstance();
          paramJSch.cipher = paramArrayOfByte;
          paramJSch.iv = new byte[paramArrayOfByte.getIVSize()];
          paramJSch.data = arrayOfByte2;
        }
        catch (Exception paramJSch)
        {
          throw new JSchException("The cipher 'aes256-cbc' is required, but it is not available.");
        }
      } else {
        throw new JSchException("The cipher 'aes256-cbc' is required, but it is not available.");
      }
    }
    else
    {
      paramJSch.data = arrayOfByte2;
      paramJSch.parse(arrayOfByte2);
    }
    return paramJSch;
    label442:
    return null;
  }
  
  private static boolean parseHeader(Buffer paramBuffer, Hashtable paramHashtable)
  {
    byte[] arrayOfByte = paramBuffer.buffer;
    int i = paramBuffer.index;
    int k;
    Object localObject1;
    boolean bool;
    for (int j = i;; j++)
    {
      k = arrayOfByte.length;
      localObject1 = null;
      bool = true;
      if ((j >= k) || (arrayOfByte[j] == 13)) {
        break;
      }
      if (arrayOfByte[j] == 58)
      {
        str = new String(arrayOfByte, i, j - i);
        j++;
        i = j;
        if (j < arrayOfByte.length)
        {
          i = j;
          if (arrayOfByte[j] == 32) {
            i = j + 1;
          }
        }
        break label108;
      }
    }
    String str = null;
    label108:
    if (str == null) {
      return false;
    }
    Object localObject2;
    for (j = i;; j++)
    {
      k = i;
      localObject2 = localObject1;
      if (j >= arrayOfByte.length) {
        break;
      }
      if (arrayOfByte[j] == 13)
      {
        localObject2 = new String(arrayOfByte, i, j - i);
        j++;
        i = j;
        if (j < arrayOfByte.length)
        {
          i = j;
          if (arrayOfByte[j] == 10) {
            i = j + 1;
          }
        }
        k = i;
        break;
      }
    }
    if (localObject2 != null)
    {
      paramHashtable.put(str, localObject2);
      paramBuffer.index = k;
    }
    if (localObject2 == null) {
      bool = false;
    }
    return bool;
  }
  
  private static byte[] parseLines(Buffer paramBuffer, int paramInt)
  {
    byte[] arrayOfByte1 = paramBuffer.buffer;
    int i = paramBuffer.index;
    Object localObject1 = null;
    int j = paramInt;
    paramInt = i;
    while (j > 0)
    {
      Object localObject2;
      int k;
      for (i = paramInt;; i = k)
      {
        localObject2 = localObject1;
        k = i;
        if (arrayOfByte1.length <= i) {
          break;
        }
        k = i + 1;
        if (arrayOfByte1[i] == 13)
        {
          if (localObject1 == null)
          {
            i = k - paramInt - 1;
            localObject2 = new byte[i];
            System.arraycopy(arrayOfByte1, paramInt, localObject2, 0, i);
            break;
          }
          byte[] arrayOfByte2 = new byte[localObject1.length + k - paramInt - 1];
          System.arraycopy(localObject1, 0, arrayOfByte2, 0, localObject1.length);
          System.arraycopy(arrayOfByte1, paramInt, arrayOfByte2, localObject1.length, k - paramInt - 1);
          for (paramInt = 0;; paramInt++)
          {
            localObject2 = arrayOfByte2;
            if (paramInt >= localObject1.length) {
              break;
            }
            localObject1[paramInt] = ((byte)0);
          }
        }
      }
      paramInt = k;
      if (arrayOfByte1[k] == 10) {
        paramInt = k + 1;
      }
      j--;
      localObject1 = localObject2;
    }
    if (localObject1 != null) {
      paramBuffer.index = paramInt;
    }
    return (byte[])localObject1;
  }
  
  void copy(KeyPair paramKeyPair)
  {
    this.publickeyblob = paramKeyPair.publickeyblob;
    this.vendor = paramKeyPair.vendor;
    this.publicKeyComment = paramKeyPair.publicKeyComment;
    this.cipher = paramKeyPair.cipher;
  }
  
  int countLength(int paramInt)
  {
    int i = 1;
    int j = paramInt;
    if (paramInt <= 127) {
      return 1;
    }
    while (j > 0)
    {
      j >>>= 8;
      i++;
    }
    return i;
  }
  
  public boolean decrypt(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0)) {
      return decrypt(Util.str2byte(paramString));
    }
    return this.encrypted ^ true;
  }
  
  public boolean decrypt(byte[] paramArrayOfByte)
  {
    boolean bool = this.encrypted;
    if (!bool) {
      return true;
    }
    if (paramArrayOfByte == null) {
      return bool ^ true;
    }
    int i = paramArrayOfByte.length;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, i);
    paramArrayOfByte = decrypt(this.data, arrayOfByte, this.iv);
    Util.bzero(arrayOfByte);
    if (parse(paramArrayOfByte)) {
      this.encrypted = false;
    }
    return this.encrypted ^ true;
  }
  
  public void dispose()
  {
    Util.bzero(this.passphrase);
  }
  
  public void finalize()
  {
    dispose();
  }
  
  public abstract byte[] forSSHAgent()
    throws JSchException;
  
  /* Error */
  byte[] genKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 128	com/jcraft/jsch/KeyPair:cipher	Lcom/jcraft/jsch/Cipher;
    //   6: ifnonnull +11 -> 17
    //   9: aload_0
    //   10: aload_0
    //   11: invokespecial 148	com/jcraft/jsch/KeyPair:genCipher	()Lcom/jcraft/jsch/Cipher;
    //   14: putfield 128	com/jcraft/jsch/KeyPair:cipher	Lcom/jcraft/jsch/Cipher;
    //   17: aload_0
    //   18: getfield 196	com/jcraft/jsch/KeyPair:hash	Lcom/jcraft/jsch/HASH;
    //   21: ifnonnull +11 -> 32
    //   24: aload_0
    //   25: aload_0
    //   26: invokespecial 444	com/jcraft/jsch/KeyPair:genHash	()Lcom/jcraft/jsch/HASH;
    //   29: putfield 196	com/jcraft/jsch/KeyPair:hash	Lcom/jcraft/jsch/HASH;
    //   32: aload_0
    //   33: getfield 128	com/jcraft/jsch/KeyPair:cipher	Lcom/jcraft/jsch/Cipher;
    //   36: invokeinterface 447 1 0
    //   41: istore_3
    //   42: iload_3
    //   43: newarray <illegal type>
    //   45: astore 4
    //   47: aload_0
    //   48: getfield 196	com/jcraft/jsch/KeyPair:hash	Lcom/jcraft/jsch/HASH;
    //   51: invokeinterface 448 1 0
    //   56: istore 5
    //   58: iload_3
    //   59: iload 5
    //   61: idiv
    //   62: istore 6
    //   64: iload_3
    //   65: iload 5
    //   67: irem
    //   68: ifne +9 -> 77
    //   71: iconst_0
    //   72: istore 7
    //   74: goto +7 -> 81
    //   77: iload 5
    //   79: istore 7
    //   81: iload 6
    //   83: iload 5
    //   85: imul
    //   86: iload 7
    //   88: iadd
    //   89: istore 8
    //   91: iload 8
    //   93: newarray <illegal type>
    //   95: astore 9
    //   97: aconst_null
    //   98: astore 10
    //   100: aconst_null
    //   101: astore 11
    //   103: aload 4
    //   105: astore 12
    //   107: aload_0
    //   108: getfield 101	com/jcraft/jsch/KeyPair:vendor	I
    //   111: istore 7
    //   113: iload 7
    //   115: ifne +180 -> 295
    //   118: iconst_0
    //   119: istore 7
    //   121: iload 7
    //   123: iload 5
    //   125: iadd
    //   126: iload 8
    //   128: if_icmpgt +146 -> 274
    //   131: aload 11
    //   133: ifnull +22 -> 155
    //   136: aload 4
    //   138: astore 12
    //   140: aload_0
    //   141: getfield 196	com/jcraft/jsch/KeyPair:hash	Lcom/jcraft/jsch/HASH;
    //   144: aload 11
    //   146: iconst_0
    //   147: aload 11
    //   149: arraylength
    //   150: invokeinterface 450 4 0
    //   155: aload 4
    //   157: astore 12
    //   159: aload_0
    //   160: getfield 196	com/jcraft/jsch/KeyPair:hash	Lcom/jcraft/jsch/HASH;
    //   163: aload_1
    //   164: iconst_0
    //   165: aload_1
    //   166: arraylength
    //   167: invokeinterface 450 4 0
    //   172: aload 4
    //   174: astore 12
    //   176: aload_0
    //   177: getfield 196	com/jcraft/jsch/KeyPair:hash	Lcom/jcraft/jsch/HASH;
    //   180: astore 11
    //   182: aload 4
    //   184: astore 12
    //   186: aload_2
    //   187: arraylength
    //   188: istore 13
    //   190: bipush 8
    //   192: istore 6
    //   194: iload 13
    //   196: bipush 8
    //   198: if_icmple +6 -> 204
    //   201: goto +11 -> 212
    //   204: aload 4
    //   206: astore 12
    //   208: aload_2
    //   209: arraylength
    //   210: istore 6
    //   212: aload 4
    //   214: astore 12
    //   216: aload 11
    //   218: aload_2
    //   219: iconst_0
    //   220: iload 6
    //   222: invokeinterface 450 4 0
    //   227: aload 4
    //   229: astore 12
    //   231: aload_0
    //   232: getfield 196	com/jcraft/jsch/KeyPair:hash	Lcom/jcraft/jsch/HASH;
    //   235: invokeinterface 453 1 0
    //   240: astore 11
    //   242: aload 4
    //   244: astore 12
    //   246: aload 11
    //   248: iconst_0
    //   249: aload 9
    //   251: iload 7
    //   253: aload 11
    //   255: arraylength
    //   256: invokestatic 170	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   259: aload 4
    //   261: astore 12
    //   263: iload 7
    //   265: aload 11
    //   267: arraylength
    //   268: iadd
    //   269: istore 7
    //   271: goto -150 -> 121
    //   274: aload 4
    //   276: astore 12
    //   278: aload 9
    //   280: iconst_0
    //   281: aload 4
    //   283: iconst_0
    //   284: iload_3
    //   285: invokestatic 170	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   288: aload 4
    //   290: astore 12
    //   292: goto +270 -> 562
    //   295: iload 7
    //   297: iconst_1
    //   298: if_icmpne +121 -> 419
    //   301: iconst_0
    //   302: istore 7
    //   304: aload 10
    //   306: astore_2
    //   307: iload 7
    //   309: iload 5
    //   311: iadd
    //   312: iload 8
    //   314: if_icmpgt +84 -> 398
    //   317: aload_2
    //   318: ifnull +20 -> 338
    //   321: aload 4
    //   323: astore 12
    //   325: aload_0
    //   326: getfield 196	com/jcraft/jsch/KeyPair:hash	Lcom/jcraft/jsch/HASH;
    //   329: aload_2
    //   330: iconst_0
    //   331: aload_2
    //   332: arraylength
    //   333: invokeinterface 450 4 0
    //   338: aload 4
    //   340: astore 12
    //   342: aload_0
    //   343: getfield 196	com/jcraft/jsch/KeyPair:hash	Lcom/jcraft/jsch/HASH;
    //   346: aload_1
    //   347: iconst_0
    //   348: aload_1
    //   349: arraylength
    //   350: invokeinterface 450 4 0
    //   355: aload 4
    //   357: astore 12
    //   359: aload_0
    //   360: getfield 196	com/jcraft/jsch/KeyPair:hash	Lcom/jcraft/jsch/HASH;
    //   363: invokeinterface 453 1 0
    //   368: astore_2
    //   369: aload 4
    //   371: astore 12
    //   373: aload_2
    //   374: iconst_0
    //   375: aload 9
    //   377: iload 7
    //   379: aload_2
    //   380: arraylength
    //   381: invokestatic 170	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   384: aload 4
    //   386: astore 12
    //   388: iload 7
    //   390: aload_2
    //   391: arraylength
    //   392: iadd
    //   393: istore 7
    //   395: goto -88 -> 307
    //   398: aload 4
    //   400: astore 12
    //   402: aload 9
    //   404: iconst_0
    //   405: aload 4
    //   407: iconst_0
    //   408: iload_3
    //   409: invokestatic 170	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   412: aload 4
    //   414: astore 12
    //   416: goto +146 -> 562
    //   419: aload 4
    //   421: astore 12
    //   423: iload 7
    //   425: iconst_2
    //   426: if_icmpne +136 -> 562
    //   429: aload 4
    //   431: astore 12
    //   433: ldc_w 455
    //   436: invokestatic 178	com/jcraft/jsch/JSch:getConfig	(Ljava/lang/String;)Ljava/lang/String;
    //   439: invokestatic 184	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   442: invokevirtual 188	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   445: checkcast 194	com/jcraft/jsch/HASH
    //   448: astore 11
    //   450: aload 4
    //   452: astore 12
    //   454: iconst_4
    //   455: newarray <illegal type>
    //   457: astore 10
    //   459: aload 4
    //   461: astore 12
    //   463: bipush 40
    //   465: newarray <illegal type>
    //   467: astore_2
    //   468: iconst_0
    //   469: istore 7
    //   471: aload_2
    //   472: astore 12
    //   474: iload 7
    //   476: iconst_2
    //   477: if_icmpge +85 -> 562
    //   480: aload_2
    //   481: astore 12
    //   483: aload 11
    //   485: invokeinterface 198 1 0
    //   490: aload 10
    //   492: iconst_3
    //   493: iload 7
    //   495: i2b
    //   496: i2b
    //   497: bastore
    //   498: aload_2
    //   499: astore 12
    //   501: aload 11
    //   503: aload 10
    //   505: iconst_0
    //   506: iconst_4
    //   507: invokeinterface 450 4 0
    //   512: aload_2
    //   513: astore 12
    //   515: aload 11
    //   517: aload_1
    //   518: iconst_0
    //   519: aload_1
    //   520: arraylength
    //   521: invokeinterface 450 4 0
    //   526: aload_2
    //   527: astore 12
    //   529: aload 11
    //   531: invokeinterface 453 1 0
    //   536: iconst_0
    //   537: aload_2
    //   538: iload 7
    //   540: bipush 20
    //   542: imul
    //   543: bipush 20
    //   545: invokestatic 170	java/lang/System:arraycopy	(Ljava/lang/Object;ILjava/lang/Object;II)V
    //   548: iinc 7 1
    //   551: goto -80 -> 471
    //   554: astore_1
    //   555: getstatic 225	java/lang/System:err	Ljava/io/PrintStream;
    //   558: aload_1
    //   559: invokevirtual 458	java/io/PrintStream:println	(Ljava/lang/Object;)V
    //   562: aload_0
    //   563: monitorexit
    //   564: aload 12
    //   566: areturn
    //   567: astore_1
    //   568: aload_0
    //   569: monitorexit
    //   570: aload_1
    //   571: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	572	0	this	KeyPair
    //   0	572	1	paramArrayOfByte1	byte[]
    //   0	572	2	paramArrayOfByte2	byte[]
    //   41	368	3	i	int
    //   45	415	4	arrayOfByte1	byte[]
    //   56	256	5	j	int
    //   62	159	6	k	int
    //   72	477	7	m	int
    //   89	226	8	n	int
    //   95	308	9	arrayOfByte2	byte[]
    //   98	406	10	arrayOfByte3	byte[]
    //   101	429	11	localObject	Object
    //   105	460	12	arrayOfByte4	byte[]
    //   188	11	13	i1	int
    // Exception table:
    //   from	to	target	type
    //   107	113	554	java/lang/Exception
    //   140	155	554	java/lang/Exception
    //   159	172	554	java/lang/Exception
    //   176	182	554	java/lang/Exception
    //   186	190	554	java/lang/Exception
    //   208	212	554	java/lang/Exception
    //   216	227	554	java/lang/Exception
    //   231	242	554	java/lang/Exception
    //   246	259	554	java/lang/Exception
    //   263	271	554	java/lang/Exception
    //   278	288	554	java/lang/Exception
    //   325	338	554	java/lang/Exception
    //   342	355	554	java/lang/Exception
    //   359	369	554	java/lang/Exception
    //   373	384	554	java/lang/Exception
    //   388	395	554	java/lang/Exception
    //   402	412	554	java/lang/Exception
    //   433	450	554	java/lang/Exception
    //   454	459	554	java/lang/Exception
    //   463	468	554	java/lang/Exception
    //   483	490	554	java/lang/Exception
    //   501	512	554	java/lang/Exception
    //   515	526	554	java/lang/Exception
    //   529	548	554	java/lang/Exception
    //   2	17	567	finally
    //   17	32	567	finally
    //   32	64	567	finally
    //   91	97	567	finally
    //   107	113	567	finally
    //   140	155	567	finally
    //   159	172	567	finally
    //   176	182	567	finally
    //   186	190	567	finally
    //   208	212	567	finally
    //   216	227	567	finally
    //   231	242	567	finally
    //   246	259	567	finally
    //   263	271	567	finally
    //   278	288	567	finally
    //   325	338	567	finally
    //   342	355	567	finally
    //   359	369	567	finally
    //   373	384	567	finally
    //   388	395	567	finally
    //   402	412	567	finally
    //   433	450	567	finally
    //   454	459	567	finally
    //   463	468	567	finally
    //   483	490	567	finally
    //   501	512	567	finally
    //   515	526	567	finally
    //   529	548	567	finally
    //   555	562	567	finally
  }
  
  abstract void generate(int paramInt)
    throws JSchException;
  
  abstract byte[] getBegin();
  
  abstract byte[] getEnd();
  
  public String getFingerPrint()
  {
    if (this.hash == null) {
      this.hash = genHash();
    }
    byte[] arrayOfByte = getPublicKeyBlob();
    if (arrayOfByte == null) {
      return null;
    }
    return Util.getFingerPrint(this.hash, arrayOfByte);
  }
  
  abstract int getKeySize();
  
  public abstract int getKeyType();
  
  abstract byte[] getKeyTypeName();
  
  abstract byte[] getPrivateKey();
  
  public byte[] getPublicKeyBlob()
  {
    return this.publickeyblob;
  }
  
  public String getPublicKeyComment()
  {
    return this.publicKeyComment;
  }
  
  public abstract byte[] getSignature(byte[] paramArrayOfByte);
  
  public abstract Signature getVerifier();
  
  public boolean isEncrypted()
  {
    return this.encrypted;
  }
  
  abstract boolean parse(byte[] paramArrayOfByte);
  
  public void setPassphrase(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0)) {
      setPassphrase(Util.str2byte(paramString));
    } else {
      setPassphrase(null);
    }
  }
  
  public void setPassphrase(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = paramArrayOfByte;
    if (paramArrayOfByte != null)
    {
      arrayOfByte = paramArrayOfByte;
      if (paramArrayOfByte.length == 0) {
        arrayOfByte = null;
      }
    }
    this.passphrase = arrayOfByte;
  }
  
  public void setPublicKeyComment(String paramString)
  {
    this.publicKeyComment = paramString;
  }
  
  int writeDATA(byte[] paramArrayOfByte1, byte paramByte, int paramInt, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte1[paramInt] = ((byte)paramByte);
    paramByte = writeLength(paramArrayOfByte1, paramInt + 1, paramArrayOfByte2.length);
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramByte, paramArrayOfByte2.length);
    return paramByte + paramArrayOfByte2.length;
  }
  
  int writeINTEGER(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte1[paramInt] = ((byte)2);
    paramInt = writeLength(paramArrayOfByte1, paramInt + 1, paramArrayOfByte2.length);
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt, paramArrayOfByte2.length);
    return paramInt + paramArrayOfByte2.length;
  }
  
  int writeLength(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = countLength(paramInt2) - 1;
    if (i == 0)
    {
      paramArrayOfByte[paramInt1] = ((byte)(byte)paramInt2);
      return paramInt1 + 1;
    }
    int j = paramInt1 + 1;
    paramArrayOfByte[paramInt1] = ((byte)(byte)(i | 0x80));
    for (paramInt1 = i; paramInt1 > 0; paramInt1--)
    {
      paramArrayOfByte[(j + paramInt1 - 1)] = ((byte)(byte)(paramInt2 & 0xFF));
      paramInt2 >>>= 8;
    }
    return j + i;
  }
  
  int writeOCTETSTRING(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    paramArrayOfByte1[paramInt] = ((byte)4);
    paramInt = writeLength(paramArrayOfByte1, paramInt + 1, paramArrayOfByte2.length);
    System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, paramInt, paramArrayOfByte2.length);
    return paramInt + paramArrayOfByte2.length;
  }
  
  public void writePrivateKey(OutputStream paramOutputStream)
  {
    writePrivateKey(paramOutputStream, null);
  }
  
  public void writePrivateKey(OutputStream paramOutputStream, byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = paramArrayOfByte;
    if (paramArrayOfByte == null) {
      arrayOfByte1 = this.passphrase;
    }
    paramArrayOfByte = getPrivateKey();
    Object localObject = new byte[1][];
    byte[] arrayOfByte2 = encrypt(paramArrayOfByte, (byte[][])localObject, arrayOfByte1);
    if (arrayOfByte2 != paramArrayOfByte) {
      Util.bzero(paramArrayOfByte);
    }
    int i = 0;
    paramArrayOfByte = localObject[0];
    arrayOfByte2 = Util.toBase64(arrayOfByte2, 0, arrayOfByte2.length);
    try
    {
      paramOutputStream.write(getBegin());
      localObject = cr;
      paramOutputStream.write((byte[])localObject);
      int j = i;
      if (arrayOfByte1 != null)
      {
        paramOutputStream.write(header[0]);
        paramOutputStream.write((byte[])localObject);
        paramOutputStream.write(header[1]);
        for (j = 0; j < paramArrayOfByte.length; j++)
        {
          paramOutputStream.write(b2a((byte)(paramArrayOfByte[j] >>> 4 & 0xF)));
          paramOutputStream.write(b2a((byte)(paramArrayOfByte[j] & 0xF)));
        }
        paramArrayOfByte = cr;
        paramOutputStream.write(paramArrayOfByte);
        paramOutputStream.write(paramArrayOfByte);
        j = i;
      }
      while (j < arrayOfByte2.length)
      {
        i = j + 64;
        if (i < arrayOfByte2.length)
        {
          paramOutputStream.write(arrayOfByte2, j, 64);
          paramOutputStream.write(cr);
          j = i;
        }
        else
        {
          paramOutputStream.write(arrayOfByte2, j, arrayOfByte2.length - j);
          paramOutputStream.write(cr);
        }
      }
      paramOutputStream.write(getEnd());
      paramOutputStream.write(cr);
      return;
    }
    catch (Exception paramOutputStream)
    {
      for (;;) {}
    }
  }
  
  public void writePrivateKey(String paramString)
    throws FileNotFoundException, IOException
  {
    writePrivateKey(paramString, null);
  }
  
  public void writePrivateKey(String paramString, byte[] paramArrayOfByte)
    throws FileNotFoundException, IOException
  {
    paramString = new FileOutputStream(paramString);
    writePrivateKey(paramString, paramArrayOfByte);
    paramString.close();
  }
  
  public void writePublicKey(OutputStream paramOutputStream, String paramString)
  {
    byte[] arrayOfByte = getPublicKeyBlob();
    arrayOfByte = Util.toBase64(arrayOfByte, 0, arrayOfByte.length);
    try
    {
      paramOutputStream.write(getKeyTypeName());
      paramOutputStream.write(space);
      paramOutputStream.write(arrayOfByte, 0, arrayOfByte.length);
      paramOutputStream.write(space);
      paramOutputStream.write(Util.str2byte(paramString));
      paramOutputStream.write(cr);
      return;
    }
    catch (Exception paramOutputStream)
    {
      for (;;) {}
    }
  }
  
  public void writePublicKey(String paramString1, String paramString2)
    throws FileNotFoundException, IOException
  {
    paramString1 = new FileOutputStream(paramString1);
    writePublicKey(paramString1, paramString2);
    paramString1.close();
  }
  
  public void writeSECSHPublicKey(OutputStream paramOutputStream, String paramString)
  {
    byte[] arrayOfByte1 = getPublicKeyBlob();
    int i = arrayOfByte1.length;
    int j = 0;
    arrayOfByte1 = Util.toBase64(arrayOfByte1, 0, i);
    try
    {
      paramOutputStream.write(Util.str2byte("---- BEGIN SSH2 PUBLIC KEY ----"));
      byte[] arrayOfByte2 = cr;
      paramOutputStream.write(arrayOfByte2);
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append("Comment: \"");
      localStringBuilder.append(paramString);
      localStringBuilder.append("\"");
      paramOutputStream.write(Util.str2byte(localStringBuilder.toString()));
      paramOutputStream.write(arrayOfByte2);
      while (j < arrayOfByte1.length)
      {
        i = 70;
        if (arrayOfByte1.length - j < 70) {
          i = arrayOfByte1.length - j;
        }
        paramOutputStream.write(arrayOfByte1, j, i);
        paramOutputStream.write(cr);
        j += i;
      }
      paramOutputStream.write(Util.str2byte("---- END SSH2 PUBLIC KEY ----"));
      paramOutputStream.write(cr);
      return;
    }
    catch (Exception paramOutputStream)
    {
      for (;;) {}
    }
  }
  
  public void writeSECSHPublicKey(String paramString1, String paramString2)
    throws FileNotFoundException, IOException
  {
    paramString1 = new FileOutputStream(paramString1);
    writeSECSHPublicKey(paramString1, paramString2);
    paramString1.close();
  }
  
  int writeSEQUENCE(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    paramArrayOfByte[paramInt1] = ((byte)48);
    return writeLength(paramArrayOfByte, paramInt1 + 1, paramInt2);
  }
  
  class ASN1
  {
    byte[] buf;
    int length;
    int start;
    
    ASN1(byte[] paramArrayOfByte)
      throws KeyPair.ASN1Exception
    {
      this(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    
    ASN1(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws KeyPair.ASN1Exception
    {
      this.buf = paramArrayOfByte;
      this.start = paramInt1;
      this.length = paramInt2;
      if (paramInt1 + paramInt2 <= paramArrayOfByte.length) {
        return;
      }
      throw new KeyPair.ASN1Exception(KeyPair.this);
    }
    
    private int getLength(int[] paramArrayOfInt)
    {
      int i = paramArrayOfInt[0];
      byte[] arrayOfByte = this.buf;
      int j = i + 1;
      int k = arrayOfByte[i] & 0xFF;
      int m = k;
      i = j;
      if ((k & 0x80) != 0)
      {
        m = k & 0x7F;
        i = 0;
        while (m > 0)
        {
          i = (this.buf[j] & 0xFF) + (i << 8);
          m--;
          j++;
        }
        m = i;
        i = j;
      }
      paramArrayOfInt[0] = i;
      return m;
    }
    
    byte[] getContent()
    {
      Object localObject = new int[1];
      localObject[0] = (this.start + 1);
      int i = getLength((int[])localObject);
      int j = localObject[0];
      localObject = new byte[i];
      System.arraycopy(this.buf, j, localObject, 0, i);
      return (byte[])localObject;
    }
    
    ASN1[] getContents()
      throws KeyPair.ASN1Exception
    {
      Object localObject1 = this.buf;
      int i = this.start;
      int j = localObject1[i];
      Object localObject2 = new int[1];
      int k = 0;
      localObject2[0] = (i + 1);
      i = getLength((int[])localObject2);
      if (j == 5) {
        return new ASN1[0];
      }
      j = localObject2[0];
      localObject1 = new Vector();
      while (i > 0)
      {
        j++;
        localObject2[0] = j;
        int m = getLength((int[])localObject2);
        int n = localObject2[0];
        int i1 = n - j;
        ((Vector)localObject1).addElement(new ASN1(KeyPair.this, this.buf, j - 1, i1 + 1 + m));
        j = n + m;
        i = i - 1 - i1 - m;
      }
      localObject2 = new ASN1[((Vector)localObject1).size()];
      for (i = k; i < ((Vector)localObject1).size(); i++) {
        localObject2[i] = ((ASN1)((Vector)localObject1).elementAt(i));
      }
      return (ASN1[])localObject2;
    }
    
    int getType()
    {
      return this.buf[this.start] & 0xFF;
    }
    
    boolean isINTEGER()
    {
      boolean bool;
      if (getType() == 2) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    boolean isOBJECT()
    {
      boolean bool;
      if (getType() == 6) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    boolean isOCTETSTRING()
    {
      boolean bool;
      if (getType() == 4) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    boolean isSEQUENCE()
    {
      boolean bool;
      if (getType() == 48) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  class ASN1Exception
    extends Exception
  {
    ASN1Exception() {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\KeyPair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */