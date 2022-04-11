package com.jcraft.jsch;

import java.math.BigInteger;

public class KeyPairDSA
  extends KeyPair
{
  private static final byte[] begin = Util.str2byte("-----BEGIN DSA PRIVATE KEY-----");
  private static final byte[] end = Util.str2byte("-----END DSA PRIVATE KEY-----");
  private static final byte[] sshdss = Util.str2byte("ssh-dss");
  private byte[] G_array;
  private byte[] P_array;
  private byte[] Q_array;
  private int key_size = 1024;
  private byte[] prv_array;
  private byte[] pub_array;
  
  public KeyPairDSA(JSch paramJSch)
  {
    this(paramJSch, null, null, null, null, null);
  }
  
  public KeyPairDSA(JSch paramJSch, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, byte[] paramArrayOfByte5)
  {
    super(paramJSch);
    this.P_array = paramArrayOfByte1;
    this.Q_array = paramArrayOfByte2;
    this.G_array = paramArrayOfByte3;
    this.pub_array = paramArrayOfByte4;
    this.prv_array = paramArrayOfByte5;
    if (paramArrayOfByte1 != null) {
      this.key_size = new BigInteger(paramArrayOfByte1).bitLength();
    }
  }
  
  static KeyPair fromSSHAgent(JSch paramJSch, Buffer paramBuffer)
    throws JSchException
  {
    paramBuffer = paramBuffer.getBytes(7, "invalid key format");
    paramJSch = new KeyPairDSA(paramJSch, paramBuffer[1], paramBuffer[2], paramBuffer[3], paramBuffer[4], paramBuffer[5]);
    paramJSch.publicKeyComment = new String(paramBuffer[6]);
    paramJSch.vendor = 0;
    return paramJSch;
  }
  
  public void dispose()
  {
    super.dispose();
    Util.bzero(this.prv_array);
  }
  
  public byte[] forSSHAgent()
    throws JSchException
  {
    if (!isEncrypted())
    {
      Buffer localBuffer = new Buffer();
      localBuffer.putString(sshdss);
      localBuffer.putString(this.P_array);
      localBuffer.putString(this.Q_array);
      localBuffer.putString(this.G_array);
      localBuffer.putString(this.pub_array);
      localBuffer.putString(this.prv_array);
      localBuffer.putString(Util.str2byte(this.publicKeyComment));
      int i = localBuffer.getLength();
      byte[] arrayOfByte = new byte[i];
      localBuffer.getByte(arrayOfByte, 0, i);
      return arrayOfByte;
    }
    throw new JSchException("key is encrypted.");
  }
  
  void generate(int paramInt)
    throws JSchException
  {
    this.key_size = paramInt;
    try
    {
      KeyPairGenDSA localKeyPairGenDSA = (KeyPairGenDSA)Class.forName(JSch.getConfig("keypairgen.dsa")).newInstance();
      localKeyPairGenDSA.init(paramInt);
      this.P_array = localKeyPairGenDSA.getP();
      this.Q_array = localKeyPairGenDSA.getQ();
      this.G_array = localKeyPairGenDSA.getG();
      this.pub_array = localKeyPairGenDSA.getY();
      this.prv_array = localKeyPairGenDSA.getX();
      return;
    }
    catch (Exception localException)
    {
      throw new JSchException(localException.toString(), localException);
    }
  }
  
  byte[] getBegin()
  {
    return begin;
  }
  
  byte[] getEnd()
  {
    return end;
  }
  
  public int getKeySize()
  {
    return this.key_size;
  }
  
  public int getKeyType()
  {
    return 1;
  }
  
  byte[] getKeyTypeName()
  {
    return sshdss;
  }
  
  byte[] getPrivateKey()
  {
    int i = countLength(1) + 1 + 1 + 1 + countLength(this.P_array.length) + this.P_array.length + 1 + countLength(this.Q_array.length) + this.Q_array.length + 1 + countLength(this.G_array.length) + this.G_array.length + 1 + countLength(this.pub_array.length) + this.pub_array.length + 1 + countLength(this.prv_array.length) + this.prv_array.length;
    byte[] arrayOfByte = new byte[countLength(i) + 1 + i];
    writeINTEGER(arrayOfByte, writeINTEGER(arrayOfByte, writeINTEGER(arrayOfByte, writeINTEGER(arrayOfByte, writeINTEGER(arrayOfByte, writeINTEGER(arrayOfByte, writeSEQUENCE(arrayOfByte, 0, i), new byte[1]), this.P_array), this.Q_array), this.G_array), this.pub_array), this.prv_array);
    return arrayOfByte;
  }
  
  public byte[] getPublicKeyBlob()
  {
    byte[] arrayOfByte = super.getPublicKeyBlob();
    if (arrayOfByte != null) {
      return arrayOfByte;
    }
    arrayOfByte = this.P_array;
    if (arrayOfByte == null) {
      return null;
    }
    return Buffer.fromBytes(new byte[][] { sshdss, arrayOfByte, this.Q_array, this.G_array, this.pub_array }).buffer;
  }
  
  public byte[] getSignature(byte[] paramArrayOfByte)
  {
    try
    {
      SignatureDSA localSignatureDSA = (SignatureDSA)Class.forName(JSch.getConfig("signature.dss")).newInstance();
      localSignatureDSA.init();
      localSignatureDSA.setPrvKey(this.prv_array, this.P_array, this.Q_array, this.G_array);
      localSignatureDSA.update(paramArrayOfByte);
      paramArrayOfByte = localSignatureDSA.sign();
      paramArrayOfByte = Buffer.fromBytes(new byte[][] { sshdss, paramArrayOfByte }).buffer;
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public Signature getVerifier()
  {
    try
    {
      SignatureDSA localSignatureDSA = (SignatureDSA)Class.forName(JSch.getConfig("signature.dss")).newInstance();
      localSignatureDSA.init();
      if ((this.pub_array == null) && (this.P_array == null) && (getPublicKeyBlob() != null))
      {
        Buffer localBuffer = new com/jcraft/jsch/Buffer;
        localBuffer.<init>(getPublicKeyBlob());
        localBuffer.getString();
        this.P_array = localBuffer.getString();
        this.Q_array = localBuffer.getString();
        this.G_array = localBuffer.getString();
        this.pub_array = localBuffer.getString();
      }
      localSignatureDSA.setPubKey(this.pub_array, this.P_array, this.Q_array, this.G_array);
      return localSignatureDSA;
    }
    catch (Exception localException) {}
    return null;
  }
  
  boolean parse(byte[] paramArrayOfByte)
  {
    try
    {
      int i = this.vendor;
      if (i == 1)
      {
        if (paramArrayOfByte[0] != 48)
        {
          localObject = new com/jcraft/jsch/Buffer;
          ((Buffer)localObject).<init>(paramArrayOfByte);
          ((Buffer)localObject).getInt();
          this.P_array = ((Buffer)localObject).getMPIntBits();
          this.G_array = ((Buffer)localObject).getMPIntBits();
          this.Q_array = ((Buffer)localObject).getMPIntBits();
          this.pub_array = ((Buffer)localObject).getMPIntBits();
          this.prv_array = ((Buffer)localObject).getMPIntBits();
          if (this.P_array != null)
          {
            paramArrayOfByte = new java/math/BigInteger;
            paramArrayOfByte.<init>(this.P_array);
            this.key_size = paramArrayOfByte.bitLength();
          }
          return true;
        }
        return false;
      }
      if (i == 2)
      {
        localObject = new com/jcraft/jsch/Buffer;
        ((Buffer)localObject).<init>(paramArrayOfByte);
        ((Buffer)localObject).skip(paramArrayOfByte.length);
        try
        {
          this.prv_array = localObject.getBytes(1, "")[0];
          return true;
        }
        catch (JSchException paramArrayOfByte)
        {
          return false;
        }
      }
      if (paramArrayOfByte[0] != 48) {
        return false;
      }
      i = paramArrayOfByte[1] & 0xFF;
      if ((i & 0x80) != 0)
      {
        j = i & 0x7F;
        i = 2;
        for (;;)
        {
          k = i;
          if (j <= 0) {
            break;
          }
          k = paramArrayOfByte[i];
          i++;
          j--;
        }
      }
      int k = 2;
      if (paramArrayOfByte[k] != 2) {
        return false;
      }
      int j = k + 1;
      i = j + 1;
      int m = paramArrayOfByte[j] & 0xFF;
      k = i;
      j = m;
      if ((m & 0x80) != 0)
      {
        k = m & 0x7F;
        j = 0;
        while (k > 0)
        {
          m = paramArrayOfByte[i];
          k--;
          j = (m & 0xFF) + (j << 8);
          i++;
        }
        k = i;
      }
      j = k + j + 1;
      i = j + 1;
      m = paramArrayOfByte[j] & 0xFF;
      k = m;
      j = i;
      if ((m & 0x80) != 0)
      {
        k = m & 0x7F;
        j = 0;
        while (k > 0)
        {
          m = paramArrayOfByte[i];
          i++;
          j = (j << 8) + (m & 0xFF);
          k--;
        }
        k = j;
        j = i;
      }
      Object localObject = new byte[k];
      this.P_array = ((byte[])localObject);
      System.arraycopy(paramArrayOfByte, j, localObject, 0, k);
      j = j + k + 1;
      i = j + 1;
      m = paramArrayOfByte[j] & 0xFF;
      k = i;
      j = m;
      if ((m & 0x80) != 0)
      {
        k = m & 0x7F;
        j = 0;
        while (k > 0)
        {
          m = paramArrayOfByte[i];
          k--;
          j = (m & 0xFF) + (j << 8);
          i++;
        }
        k = i;
      }
      localObject = new byte[j];
      this.Q_array = ((byte[])localObject);
      System.arraycopy(paramArrayOfByte, k, localObject, 0, j);
      j = k + j + 1;
      i = j + 1;
      m = paramArrayOfByte[j] & 0xFF;
      k = m;
      j = i;
      if ((m & 0x80) != 0)
      {
        k = m & 0x7F;
        j = 0;
        while (k > 0)
        {
          m = paramArrayOfByte[i];
          i++;
          j = (j << 8) + (m & 0xFF);
          k--;
        }
        k = j;
        j = i;
      }
      localObject = new byte[k];
      this.G_array = ((byte[])localObject);
      System.arraycopy(paramArrayOfByte, j, localObject, 0, k);
      j = j + k + 1;
      i = j + 1;
      m = paramArrayOfByte[j] & 0xFF;
      k = i;
      j = m;
      if ((m & 0x80) != 0)
      {
        k = m & 0x7F;
        j = 0;
        while (k > 0)
        {
          m = paramArrayOfByte[i];
          k--;
          j = (m & 0xFF) + (j << 8);
          i++;
        }
        k = i;
      }
      localObject = new byte[j];
      this.pub_array = ((byte[])localObject);
      System.arraycopy(paramArrayOfByte, k, localObject, 0, j);
      j = k + j + 1;
      i = j + 1;
      m = paramArrayOfByte[j] & 0xFF;
      k = m;
      j = i;
      if ((m & 0x80) != 0)
      {
        k = m & 0x7F;
        j = 0;
        while (k > 0)
        {
          m = paramArrayOfByte[i];
          i++;
          j = (j << 8) + (m & 0xFF);
          k--;
        }
        k = j;
        j = i;
      }
      localObject = new byte[k];
      this.prv_array = ((byte[])localObject);
      System.arraycopy(paramArrayOfByte, j, localObject, 0, k);
      if (this.P_array != null)
      {
        paramArrayOfByte = new java/math/BigInteger;
        paramArrayOfByte.<init>(this.P_array);
        this.key_size = paramArrayOfByte.bitLength();
      }
      return true;
    }
    catch (Exception paramArrayOfByte) {}
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\KeyPairDSA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */