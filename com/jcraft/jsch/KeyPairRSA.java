package com.jcraft.jsch;

import java.math.BigInteger;

public class KeyPairRSA
  extends KeyPair
{
  private static final byte[] begin = Util.str2byte("-----BEGIN RSA PRIVATE KEY-----");
  private static final byte[] end = Util.str2byte("-----END RSA PRIVATE KEY-----");
  private static final byte[] sshrsa = Util.str2byte("ssh-rsa");
  private byte[] c_array;
  private byte[] ep_array;
  private byte[] eq_array;
  private int key_size = 1024;
  private byte[] n_array;
  private byte[] p_array;
  private byte[] prv_array;
  private byte[] pub_array;
  private byte[] q_array;
  
  public KeyPairRSA(JSch paramJSch)
  {
    this(paramJSch, null, null, null);
  }
  
  public KeyPairRSA(JSch paramJSch, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    super(paramJSch);
    this.n_array = paramArrayOfByte1;
    this.pub_array = paramArrayOfByte2;
    this.prv_array = paramArrayOfByte3;
    if (paramArrayOfByte1 != null) {
      this.key_size = new BigInteger(paramArrayOfByte1).bitLength();
    }
  }
  
  static KeyPair fromSSHAgent(JSch paramJSch, Buffer paramBuffer)
    throws JSchException
  {
    paramBuffer = paramBuffer.getBytes(8, "invalid key format");
    paramJSch = new KeyPairRSA(paramJSch, paramBuffer[1], paramBuffer[2], paramBuffer[3]);
    paramJSch.c_array = paramBuffer[4];
    paramJSch.p_array = paramBuffer[5];
    paramJSch.q_array = paramBuffer[6];
    paramJSch.publicKeyComment = new String(paramBuffer[7]);
    paramJSch.vendor = 0;
    return paramJSch;
  }
  
  private byte[] getCArray()
  {
    if (this.c_array == null) {
      this.c_array = new BigInteger(this.q_array).modInverse(new BigInteger(this.p_array)).toByteArray();
    }
    return this.c_array;
  }
  
  private byte[] getEPArray()
  {
    if (this.ep_array == null) {
      this.ep_array = new BigInteger(this.prv_array).mod(new BigInteger(this.p_array).subtract(BigInteger.ONE)).toByteArray();
    }
    return this.ep_array;
  }
  
  private byte[] getEQArray()
  {
    if (this.eq_array == null) {
      this.eq_array = new BigInteger(this.prv_array).mod(new BigInteger(this.q_array).subtract(BigInteger.ONE)).toByteArray();
    }
    return this.eq_array;
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
      localBuffer.putString(sshrsa);
      localBuffer.putString(this.n_array);
      localBuffer.putString(this.pub_array);
      localBuffer.putString(this.prv_array);
      localBuffer.putString(getCArray());
      localBuffer.putString(this.p_array);
      localBuffer.putString(this.q_array);
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
      KeyPairGenRSA localKeyPairGenRSA = (KeyPairGenRSA)Class.forName(JSch.getConfig("keypairgen.rsa")).newInstance();
      localKeyPairGenRSA.init(paramInt);
      this.pub_array = localKeyPairGenRSA.getE();
      this.prv_array = localKeyPairGenRSA.getD();
      this.n_array = localKeyPairGenRSA.getN();
      this.p_array = localKeyPairGenRSA.getP();
      this.q_array = localKeyPairGenRSA.getQ();
      this.ep_array = localKeyPairGenRSA.getEP();
      this.eq_array = localKeyPairGenRSA.getEQ();
      this.c_array = localKeyPairGenRSA.getC();
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
    return 2;
  }
  
  byte[] getKeyTypeName()
  {
    return sshrsa;
  }
  
  byte[] getPrivateKey()
  {
    int i = countLength(1) + 1 + 1 + 1 + countLength(this.n_array.length) + this.n_array.length + 1 + countLength(this.pub_array.length) + this.pub_array.length + 1 + countLength(this.prv_array.length) + this.prv_array.length + 1 + countLength(this.p_array.length) + this.p_array.length + 1 + countLength(this.q_array.length) + this.q_array.length + 1 + countLength(this.ep_array.length) + this.ep_array.length + 1 + countLength(this.eq_array.length) + this.eq_array.length + 1 + countLength(this.c_array.length) + this.c_array.length;
    byte[] arrayOfByte = new byte[countLength(i) + 1 + i];
    writeINTEGER(arrayOfByte, writeINTEGER(arrayOfByte, writeINTEGER(arrayOfByte, writeINTEGER(arrayOfByte, writeINTEGER(arrayOfByte, writeINTEGER(arrayOfByte, writeINTEGER(arrayOfByte, writeINTEGER(arrayOfByte, writeINTEGER(arrayOfByte, writeSEQUENCE(arrayOfByte, 0, i), new byte[1]), this.n_array), this.pub_array), this.prv_array), this.p_array), this.q_array), this.ep_array), this.eq_array), this.c_array);
    return arrayOfByte;
  }
  
  public byte[] getPublicKeyBlob()
  {
    byte[] arrayOfByte = super.getPublicKeyBlob();
    if (arrayOfByte != null) {
      return arrayOfByte;
    }
    arrayOfByte = this.pub_array;
    if (arrayOfByte == null) {
      return null;
    }
    return Buffer.fromBytes(new byte[][] { sshrsa, arrayOfByte, this.n_array }).buffer;
  }
  
  public byte[] getSignature(byte[] paramArrayOfByte)
  {
    try
    {
      SignatureRSA localSignatureRSA = (SignatureRSA)Class.forName(JSch.getConfig("signature.rsa")).newInstance();
      localSignatureRSA.init();
      localSignatureRSA.setPrvKey(this.prv_array, this.n_array);
      localSignatureRSA.update(paramArrayOfByte);
      paramArrayOfByte = localSignatureRSA.sign();
      paramArrayOfByte = Buffer.fromBytes(new byte[][] { sshrsa, paramArrayOfByte }).buffer;
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public Signature getVerifier()
  {
    try
    {
      SignatureRSA localSignatureRSA = (SignatureRSA)Class.forName(JSch.getConfig("signature.rsa")).newInstance();
      localSignatureRSA.init();
      if ((this.pub_array == null) && (this.n_array == null) && (getPublicKeyBlob() != null))
      {
        Buffer localBuffer = new com/jcraft/jsch/Buffer;
        localBuffer.<init>(getPublicKeyBlob());
        localBuffer.getString();
        this.pub_array = localBuffer.getString();
        this.n_array = localBuffer.getString();
      }
      localSignatureRSA.setPubKey(this.pub_array, this.n_array);
      return localSignatureRSA;
    }
    catch (Exception localException) {}
    return null;
  }
  
  boolean parse(byte[] paramArrayOfByte)
  {
    try
    {
      int i = this.vendor;
      if (i == 2)
      {
        localObject = new com/jcraft/jsch/Buffer;
        ((Buffer)localObject).<init>(paramArrayOfByte);
        ((Buffer)localObject).skip(paramArrayOfByte.length);
        try
        {
          paramArrayOfByte = ((Buffer)localObject).getBytes(4, "");
          this.prv_array = paramArrayOfByte[0];
          this.p_array = paramArrayOfByte[1];
          this.q_array = paramArrayOfByte[2];
          this.c_array = paramArrayOfByte[3];
          getEPArray();
          getEQArray();
          return true;
        }
        catch (JSchException paramArrayOfByte)
        {
          return false;
        }
      }
      if (i == 1)
      {
        if (paramArrayOfByte[0] != 48)
        {
          localObject = new com/jcraft/jsch/Buffer;
          ((Buffer)localObject).<init>(paramArrayOfByte);
          this.pub_array = ((Buffer)localObject).getMPIntBits();
          this.prv_array = ((Buffer)localObject).getMPIntBits();
          this.n_array = ((Buffer)localObject).getMPIntBits();
          ((Buffer)localObject).getMPIntBits();
          this.p_array = ((Buffer)localObject).getMPIntBits();
          this.q_array = ((Buffer)localObject).getMPIntBits();
          if (this.n_array != null)
          {
            paramArrayOfByte = new java/math/BigInteger;
            paramArrayOfByte.<init>(this.n_array);
            this.key_size = paramArrayOfByte.bitLength();
          }
          getEPArray();
          getEQArray();
          getCArray();
          return true;
        }
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
      this.n_array = ((byte[])localObject);
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
      this.p_array = ((byte[])localObject);
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
      this.q_array = ((byte[])localObject);
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
      this.ep_array = ((byte[])localObject);
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
      this.eq_array = ((byte[])localObject);
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
      this.c_array = ((byte[])localObject);
      System.arraycopy(paramArrayOfByte, k, localObject, 0, j);
      if (this.n_array != null)
      {
        paramArrayOfByte = new java/math/BigInteger;
        paramArrayOfByte.<init>(this.n_array);
        this.key_size = paramArrayOfByte.bitLength();
      }
      return true;
    }
    catch (Exception paramArrayOfByte) {}
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\KeyPairRSA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */