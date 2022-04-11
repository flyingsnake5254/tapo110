package com.jcraft.jsch;

import java.math.BigInteger;
import java.util.Vector;

public class KeyPairPKCS8
  extends KeyPair
{
  private static final byte[] aes128cbc;
  private static final byte[] aes192cbc;
  private static final byte[] aes256cbc;
  private static final byte[] begin = Util.str2byte("-----BEGIN DSA PRIVATE KEY-----");
  private static final byte[] dsaEncryption;
  private static final byte[] end = Util.str2byte("-----END DSA PRIVATE KEY-----");
  private static final byte[] pbeWithMD5AndDESCBC;
  private static final byte[] pbes2;
  private static final byte[] pbkdf2;
  private static final byte[] rsaEncryption = { 42, -122, 72, -122, -9, 13, 1, 1, 1 };
  private KeyPair kpair = null;
  
  static
  {
    dsaEncryption = new byte[] { 42, -122, 72, -50, 56, 4, 1 };
    pbes2 = new byte[] { 42, -122, 72, -122, -9, 13, 1, 5, 13 };
    pbkdf2 = new byte[] { 42, -122, 72, -122, -9, 13, 1, 5, 12 };
    aes128cbc = new byte[] { 96, -122, 72, 1, 101, 3, 4, 1, 2 };
    aes192cbc = new byte[] { 96, -122, 72, 1, 101, 3, 4, 1, 22 };
    aes256cbc = new byte[] { 96, -122, 72, 1, 101, 3, 4, 1, 42 };
    pbeWithMD5AndDESCBC = new byte[] { 42, -122, 72, -122, -9, 13, 1, 5, 3 };
  }
  
  public KeyPairPKCS8(JSch paramJSch)
  {
    super(paramJSch);
  }
  
  public boolean decrypt(byte[] paramArrayOfByte)
  {
    if (!isEncrypted()) {
      return true;
    }
    if (paramArrayOfByte == null) {
      return isEncrypted() ^ true;
    }
    try
    {
      Object localObject1 = new com/jcraft/jsch/KeyPair$ASN1;
      ((KeyPair.ASN1)localObject1).<init>(this, this.data);
      localObject1 = ((KeyPair.ASN1)localObject1).getContents();
      byte[] arrayOfByte = localObject1[1].getContent();
      Object localObject2 = localObject1[0].getContents();
      localObject1 = localObject2[0].getContent();
      localObject2 = localObject2[1];
      if (Util.array_equals((byte[])localObject1, pbes2))
      {
        localObject1 = ((KeyPair.ASN1)localObject2).getContents();
        localObject2 = localObject1[0];
        localObject1 = localObject1[1];
        localObject2 = ((KeyPair.ASN1)localObject2).getContents();
        localObject2[0].getContent();
        Object localObject3 = localObject2[1].getContents();
        localObject2 = localObject3[0].getContent();
        Object localObject4 = new java/math/BigInteger;
        ((BigInteger)localObject4).<init>(localObject3[1].getContent());
        int i = Integer.parseInt(((BigInteger)localObject4).toString());
        localObject3 = ((KeyPair.ASN1)localObject1).getContents();
        localObject1 = localObject3[0].getContent();
        localObject3 = localObject3[1].getContent();
        localObject4 = getCipher((byte[])localObject1);
        if (localObject4 == null) {
          return false;
        }
        localObject1 = null;
        try
        {
          paramArrayOfByte = ((PBKDF)Class.forName(JSch.getConfig("pbkdf")).newInstance()).getKey(paramArrayOfByte, (byte[])localObject2, i, ((Cipher)localObject4).getBlockSize());
        }
        catch (Exception paramArrayOfByte)
        {
          paramArrayOfByte = (byte[])localObject1;
        }
        if (paramArrayOfByte == null) {
          return false;
        }
        ((Cipher)localObject4).init(1, paramArrayOfByte, (byte[])localObject3);
        Util.bzero(paramArrayOfByte);
        paramArrayOfByte = new byte[arrayOfByte.length];
        ((Cipher)localObject4).update(arrayOfByte, 0, arrayOfByte.length, paramArrayOfByte, 0);
        if (parse(paramArrayOfByte))
        {
          this.encrypted = false;
          return true;
        }
      }
      else
      {
        boolean bool = Util.array_equals((byte[])localObject1, pbeWithMD5AndDESCBC);
        if (!bool) {}
      }
    }
    catch (KeyPair.ASN1Exception|Exception paramArrayOfByte)
    {
      for (;;) {}
    }
    return false;
  }
  
  public byte[] forSSHAgent()
    throws JSchException
  {
    return this.kpair.forSSHAgent();
  }
  
  void generate(int paramInt)
    throws JSchException
  {}
  
  byte[] getBegin()
  {
    return begin;
  }
  
  Cipher getCipher(byte[] paramArrayOfByte)
  {
    Object localObject1 = null;
    Object localObject2;
    try
    {
      String str;
      if (Util.array_equals(paramArrayOfByte, aes128cbc)) {
        str = "aes128-cbc";
      } else if (Util.array_equals(paramArrayOfByte, aes192cbc)) {
        str = "aes192-cbc";
      } else if (Util.array_equals(paramArrayOfByte, aes256cbc)) {
        str = "aes256-cbc";
      } else {
        str = null;
      }
      try
      {
        Cipher localCipher = (Cipher)Class.forName(JSch.getConfig(str)).newInstance();
      }
      catch (Exception localException2) {}
      localObject3 = localObject1;
    }
    catch (Exception localException1)
    {
      localObject2 = null;
    }
    Object localObject3;
    if (JSch.getLogger().isEnabled(4))
    {
      if (localObject2 == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("unknown oid: ");
        ((StringBuilder)localObject2).append(Util.toHex(paramArrayOfByte));
        paramArrayOfByte = ((StringBuilder)localObject2).toString();
      }
      else
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("function ");
        paramArrayOfByte.append((String)localObject2);
        paramArrayOfByte.append(" is not supported");
        paramArrayOfByte = paramArrayOfByte.toString();
      }
      localObject2 = JSch.getLogger();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("PKCS8: ");
      ((StringBuilder)localObject3).append(paramArrayOfByte);
      ((Logger)localObject2).log(4, ((StringBuilder)localObject3).toString());
      localObject3 = localObject1;
    }
    return (Cipher)localObject3;
  }
  
  byte[] getEnd()
  {
    return end;
  }
  
  public int getKeySize()
  {
    return this.kpair.getKeySize();
  }
  
  public int getKeyType()
  {
    return this.kpair.getKeyType();
  }
  
  byte[] getKeyTypeName()
  {
    return this.kpair.getKeyTypeName();
  }
  
  byte[] getPrivateKey()
  {
    return null;
  }
  
  public byte[] getPublicKeyBlob()
  {
    return this.kpair.getPublicKeyBlob();
  }
  
  public byte[] getSignature(byte[] paramArrayOfByte)
  {
    return this.kpair.getSignature(paramArrayOfByte);
  }
  
  public Signature getVerifier()
  {
    return this.kpair.getVerifier();
  }
  
  boolean parse(byte[] paramArrayOfByte)
  {
    boolean bool = false;
    try
    {
      Object localObject1 = new java/util/Vector;
      ((Vector)localObject1).<init>();
      Object localObject2 = new com/jcraft/jsch/KeyPair$ASN1;
      ((KeyPair.ASN1)localObject2).<init>(this, paramArrayOfByte);
      paramArrayOfByte = ((KeyPair.ASN1)localObject2).getContents();
      localObject2 = paramArrayOfByte[1];
      paramArrayOfByte = paramArrayOfByte[2];
      Object localObject3 = ((KeyPair.ASN1)localObject2).getContents();
      localObject2 = localObject3[0].getContent();
      localObject3 = localObject3[1].getContents();
      int i;
      if (localObject3.length > 0) {
        for (i = 0; i < localObject3.length; i++) {
          ((Vector)localObject1).addElement(localObject3[i].getContent());
        }
      }
      paramArrayOfByte = paramArrayOfByte.getContent();
      if (Util.array_equals((byte[])localObject2, rsaEncryption))
      {
        localObject1 = new com/jcraft/jsch/KeyPairRSA;
        ((KeyPairRSA)localObject1).<init>(this.jsch);
        ((KeyPair)localObject1).copy(this);
        if (((KeyPair)localObject1).parse(paramArrayOfByte)) {
          this.kpair = ((KeyPair)localObject1);
        }
      }
      else if (Util.array_equals((byte[])localObject2, dsaEncryption))
      {
        localObject2 = new com/jcraft/jsch/KeyPair$ASN1;
        ((KeyPair.ASN1)localObject2).<init>(this, paramArrayOfByte);
        if (((Vector)localObject1).size() == 0)
        {
          localObject2 = ((KeyPair.ASN1)localObject2).getContents();
          paramArrayOfByte = localObject2[1].getContent();
          localObject2 = localObject2[0].getContents();
          for (i = 0; i < localObject2.length; i++) {
            ((Vector)localObject1).addElement(localObject2[i].getContent());
          }
          ((Vector)localObject1).addElement(paramArrayOfByte);
        }
        else
        {
          ((Vector)localObject1).addElement(((KeyPair.ASN1)localObject2).getContent());
        }
        localObject3 = (byte[])((Vector)localObject1).elementAt(0);
        localObject2 = (byte[])((Vector)localObject1).elementAt(1);
        paramArrayOfByte = (byte[])((Vector)localObject1).elementAt(2);
        localObject1 = (byte[])((Vector)localObject1).elementAt(3);
        Object localObject4 = new java/math/BigInteger;
        ((BigInteger)localObject4).<init>(paramArrayOfByte);
        Object localObject5 = new java/math/BigInteger;
        ((BigInteger)localObject5).<init>((byte[])localObject1);
        BigInteger localBigInteger = new java/math/BigInteger;
        localBigInteger.<init>((byte[])localObject3);
        localObject4 = ((BigInteger)localObject4).modPow((BigInteger)localObject5, localBigInteger).toByteArray();
        localObject5 = new com/jcraft/jsch/KeyPairDSA;
        ((KeyPairDSA)localObject5).<init>(this.jsch, (byte[])localObject3, (byte[])localObject2, paramArrayOfByte, (byte[])localObject4, (byte[])localObject1);
        paramArrayOfByte = ((KeyPairDSA)localObject5).getPrivateKey();
        localObject1 = new com/jcraft/jsch/KeyPairDSA;
        ((KeyPairDSA)localObject1).<init>(this.jsch);
        ((KeyPair)localObject1).copy(this);
        if (((KeyPair)localObject1).parse(paramArrayOfByte)) {
          this.kpair = ((KeyPair)localObject1);
        }
      }
      if (this.kpair != null) {
        bool = true;
      }
    }
    catch (KeyPair.ASN1Exception|Exception paramArrayOfByte)
    {
      for (;;) {}
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\KeyPairPKCS8.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */