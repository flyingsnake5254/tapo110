package com.jcraft.jsch;

public class KeyPairECDSA
  extends KeyPair
{
  private static final byte[] begin = Util.str2byte("-----BEGIN EC PRIVATE KEY-----");
  private static final byte[] end = Util.str2byte("-----END EC PRIVATE KEY-----");
  private static String[] names;
  private static byte[][] oids = { { 6, 8, 42, -122, 72, -50, 61, 3, 1, 7 }, { 6, 5, 43, -127, 4, 0, 34 }, { 6, 5, 43, -127, 4, 0, 35 } };
  private int key_size;
  private byte[] name = Util.str2byte(names[0]);
  private byte[] prv_array;
  private byte[] r_array;
  private byte[] s_array;
  
  static
  {
    names = new String[] { "nistp256", "nistp384", "nistp521" };
  }
  
  public KeyPairECDSA(JSch paramJSch)
  {
    this(paramJSch, null, null, null, null);
  }
  
  public KeyPairECDSA(JSch paramJSch, byte[] paramArrayOfByte)
  {
    this(paramJSch, null, null, null, null);
    if (paramArrayOfByte != null)
    {
      paramJSch = new byte[8];
      System.arraycopy(paramArrayOfByte, 11, paramJSch, 0, 8);
      if (Util.array_equals(paramJSch, Util.str2byte("nistp384")))
      {
        this.key_size = 384;
        this.name = paramJSch;
      }
      if (Util.array_equals(paramJSch, Util.str2byte("nistp521")))
      {
        this.key_size = 521;
        this.name = paramJSch;
      }
    }
  }
  
  public KeyPairECDSA(JSch paramJSch, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4)
  {
    super(paramJSch);
    int i = 256;
    this.key_size = 256;
    if (paramArrayOfByte1 != null) {
      this.name = paramArrayOfByte1;
    }
    this.r_array = paramArrayOfByte2;
    this.s_array = paramArrayOfByte3;
    this.prv_array = paramArrayOfByte4;
    if (paramArrayOfByte4 != null)
    {
      if (paramArrayOfByte4.length >= 64) {
        i = 521;
      } else if (paramArrayOfByte4.length >= 48) {
        i = 384;
      }
      this.key_size = i;
    }
  }
  
  static byte[][] fromPoint(byte[] paramArrayOfByte)
  {
    for (int i = 0; paramArrayOfByte[i] != 4; i++) {}
    int j = i + 1;
    int k = (paramArrayOfByte.length - j) / 2;
    byte[] arrayOfByte1 = new byte[k];
    i = (paramArrayOfByte.length - j) / 2;
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(paramArrayOfByte, j, arrayOfByte1, 0, k);
    System.arraycopy(paramArrayOfByte, j + k, arrayOfByte2, 0, i);
    return new byte[][] { arrayOfByte1, arrayOfByte2 };
  }
  
  static KeyPair fromSSHAgent(JSch paramJSch, Buffer paramBuffer)
    throws JSchException
  {
    paramBuffer = paramBuffer.getBytes(5, "invalid key format");
    byte[] arrayOfByte = paramBuffer[1];
    byte[][] arrayOfByte1 = fromPoint(paramBuffer[2]);
    paramJSch = new KeyPairECDSA(paramJSch, arrayOfByte, arrayOfByte1[0], arrayOfByte1[1], paramBuffer[3]);
    paramJSch.publicKeyComment = new String(paramBuffer[4]);
    paramJSch.vendor = 0;
    return paramJSch;
  }
  
  static byte[] toPoint(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + 1 + paramArrayOfByte2.length];
    arrayOfByte[0] = ((byte)4);
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 1, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length + 1, paramArrayOfByte2.length);
    return arrayOfByte;
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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ecdsa-sha2-");
      ((StringBuilder)localObject).append(new String(this.name));
      localBuffer.putString(Util.str2byte(((StringBuilder)localObject).toString()));
      localBuffer.putString(this.name);
      localBuffer.putString(toPoint(this.r_array, this.s_array));
      localBuffer.putString(this.prv_array);
      localBuffer.putString(Util.str2byte(this.publicKeyComment));
      int i = localBuffer.getLength();
      localObject = new byte[i];
      localBuffer.getByte((byte[])localObject, 0, i);
      return (byte[])localObject;
    }
    throw new JSchException("key is encrypted.");
  }
  
  void generate(int paramInt)
    throws JSchException
  {
    this.key_size = paramInt;
    try
    {
      Object localObject = (KeyPairGenECDSA)Class.forName(JSch.getConfig("keypairgen.ecdsa")).newInstance();
      ((KeyPairGenECDSA)localObject).init(paramInt);
      this.prv_array = ((KeyPairGenECDSA)localObject).getD();
      this.r_array = ((KeyPairGenECDSA)localObject).getR();
      this.s_array = ((KeyPairGenECDSA)localObject).getS();
      localObject = names;
      byte[] arrayOfByte = this.prv_array;
      if (arrayOfByte.length >= 64) {
        paramInt = 2;
      } else if (arrayOfByte.length >= 48) {
        paramInt = 1;
      } else {
        paramInt = 0;
      }
      this.name = Util.str2byte(localObject[paramInt]);
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
    return 3;
  }
  
  byte[] getKeyTypeName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ecdsa-sha2-");
    localStringBuilder.append(new String(this.name));
    return Util.str2byte(localStringBuilder.toString());
  }
  
  byte[] getPrivateKey()
  {
    Object localObject = oids;
    byte[] arrayOfByte1 = this.r_array;
    if (arrayOfByte1.length >= 64) {
      i = 2;
    } else if (arrayOfByte1.length >= 48) {
      i = 1;
    } else {
      i = 0;
    }
    localObject = localObject[i];
    byte[] arrayOfByte2 = toPoint(arrayOfByte1, this.s_array);
    if ((arrayOfByte2.length + 1 & 0x80) == 0) {
      i = 3;
    } else {
      i = 4;
    }
    int j = arrayOfByte2.length + i;
    arrayOfByte1 = new byte[j];
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, i, arrayOfByte2.length);
    arrayOfByte1[0] = ((byte)3);
    if (i == 3)
    {
      arrayOfByte1[1] = ((byte)(byte)(arrayOfByte2.length + 1));
    }
    else
    {
      arrayOfByte1[1] = ((byte)-127);
      arrayOfByte1[2] = ((byte)(byte)(arrayOfByte2.length + 1));
    }
    int i = countLength(1) + 1 + 1 + 1 + countLength(this.prv_array.length) + this.prv_array.length + 1 + countLength(localObject.length) + localObject.length + 1 + countLength(j) + j;
    arrayOfByte2 = new byte[countLength(i) + 1 + i];
    writeDATA(arrayOfByte2, (byte)-95, writeDATA(arrayOfByte2, (byte)-96, writeOCTETSTRING(arrayOfByte2, writeINTEGER(arrayOfByte2, writeSEQUENCE(arrayOfByte2, 0, i), new byte[] { 1 }), this.prv_array), (byte[])localObject), arrayOfByte1);
    return arrayOfByte2;
  }
  
  public byte[] getPublicKeyBlob()
  {
    Object localObject1 = super.getPublicKeyBlob();
    if (localObject1 != null) {
      return (byte[])localObject1;
    }
    if (this.r_array == null) {
      return null;
    }
    localObject1 = new byte[3][];
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("ecdsa-sha2-");
    ((StringBuilder)localObject2).append(new String(this.name));
    localObject1[0] = Util.str2byte(((StringBuilder)localObject2).toString());
    localObject1[1] = this.name;
    localObject2 = this.r_array;
    localObject1[2] = new byte[localObject2.length + 1 + this.s_array.length];
    localObject1[2][0] = ((byte)4);
    System.arraycopy(localObject2, 0, localObject1[2], 1, localObject2.length);
    localObject2 = this.s_array;
    System.arraycopy(localObject2, 0, localObject1[2], this.r_array.length + 1, localObject2.length);
    return Buffer.fromBytes((byte[][])localObject1).buffer;
  }
  
  public byte[] getSignature(byte[] paramArrayOfByte)
  {
    try
    {
      Object localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append("ecdsa-sha2-");
      String str = new java/lang/String;
      str.<init>(this.name);
      ((StringBuilder)localObject).append(str);
      localObject = (SignatureECDSA)Class.forName(JSch.getConfig(((StringBuilder)localObject).toString())).newInstance();
      ((Signature)localObject).init();
      ((SignatureECDSA)localObject).setPrvKey(this.prv_array);
      ((Signature)localObject).update(paramArrayOfByte);
      paramArrayOfByte = ((Signature)localObject).sign();
      localObject = new java/lang/StringBuilder;
      ((StringBuilder)localObject).<init>();
      ((StringBuilder)localObject).append("ecdsa-sha2-");
      str = new java/lang/String;
      str.<init>(this.name);
      ((StringBuilder)localObject).append(str);
      paramArrayOfByte = Buffer.fromBytes(new byte[][] { Util.str2byte(((StringBuilder)localObject).toString()), paramArrayOfByte }).buffer;
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public Signature getVerifier()
  {
    try
    {
      Object localObject1 = new java/lang/StringBuilder;
      ((StringBuilder)localObject1).<init>();
      ((StringBuilder)localObject1).append("ecdsa-sha2-");
      Object localObject2 = new java/lang/String;
      ((String)localObject2).<init>(this.name);
      ((StringBuilder)localObject1).append((String)localObject2);
      localObject2 = (SignatureECDSA)Class.forName(JSch.getConfig(((StringBuilder)localObject1).toString())).newInstance();
      ((Signature)localObject2).init();
      if ((this.r_array == null) && (this.s_array == null) && (getPublicKeyBlob() != null))
      {
        localObject1 = new com/jcraft/jsch/Buffer;
        ((Buffer)localObject1).<init>(getPublicKeyBlob());
        ((Buffer)localObject1).getString();
        ((Buffer)localObject1).getString();
        localObject1 = fromPoint(((Buffer)localObject1).getString());
        this.r_array = localObject1[0];
        this.s_array = localObject1[1];
      }
      ((SignatureECDSA)localObject2).setPubKey(this.r_array, this.s_array);
      return (Signature)localObject2;
    }
    catch (Exception localException) {}
    return null;
  }
  
  boolean parse(byte[] paramArrayOfByte)
  {
    try
    {
      int i = this.vendor;
      if (i == 1) {
        return false;
      }
      if (i == 2) {
        return false;
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
      byte[] arrayOfByte = new byte[j];
      System.arraycopy(paramArrayOfByte, k, arrayOfByte, 0, j);
      for (i = 0;; i++)
      {
        localObject = oids;
        if (i >= localObject.length) {
          break;
        }
        if (Util.array_equals(localObject[i], arrayOfByte))
        {
          this.name = Util.str2byte(names[i]);
          break;
        }
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
      localObject = new byte[k];
      System.arraycopy(paramArrayOfByte, j, localObject, 0, k);
      paramArrayOfByte = fromPoint((byte[])localObject);
      this.r_array = paramArrayOfByte[0];
      this.s_array = paramArrayOfByte[1];
      paramArrayOfByte = this.prv_array;
      if (paramArrayOfByte != null)
      {
        if (paramArrayOfByte.length >= 64) {
          i = 521;
        } else if (paramArrayOfByte.length >= 48) {
          i = 384;
        } else {
          i = 256;
        }
        this.key_size = i;
      }
      return true;
    }
    catch (Exception paramArrayOfByte) {}
    return false;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\KeyPairECDSA.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */