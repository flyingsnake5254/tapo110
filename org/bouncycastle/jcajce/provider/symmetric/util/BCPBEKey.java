package org.bouncycastle.jcajce.provider.symmetric.util;

import java.security.spec.KeySpec;
import javax.crypto.interfaces.PBEKey;
import javax.crypto.spec.PBEKeySpec;
import org.bouncycastle.asn1.m;
import org.bouncycastle.crypto.e;
import org.bouncycastle.crypto.k;
import org.bouncycastle.crypto.w.a0;
import org.bouncycastle.crypto.w.b0;

public class BCPBEKey
  implements PBEKey
{
  String algorithm;
  int digest;
  int ivSize;
  int keySize;
  m oid;
  e param;
  PBEKeySpec pbeKeySpec;
  boolean tryWrong = false;
  int type;
  
  public BCPBEKey(String paramString, KeySpec paramKeySpec, e parame)
  {
    this.algorithm = paramString;
    this.param = parame;
  }
  
  public BCPBEKey(String paramString, m paramm, int paramInt1, int paramInt2, int paramInt3, int paramInt4, PBEKeySpec paramPBEKeySpec, e parame)
  {
    this.algorithm = paramString;
    this.oid = paramm;
    this.type = paramInt1;
    this.digest = paramInt2;
    this.keySize = paramInt3;
    this.ivSize = paramInt4;
    this.pbeKeySpec = paramPBEKeySpec;
    this.param = parame;
  }
  
  public String getAlgorithm()
  {
    return this.algorithm;
  }
  
  int getDigest()
  {
    return this.digest;
  }
  
  public byte[] getEncoded()
  {
    e locale1 = this.param;
    if (locale1 != null)
    {
      e locale2 = locale1;
      if ((locale1 instanceof b0)) {
        locale2 = ((b0)locale1).b();
      }
      return ((a0)locale2).a();
    }
    int i = this.type;
    if (i == 2) {
      return k.a(this.pbeKeySpec.getPassword());
    }
    if (i == 5) {
      return k.c(this.pbeKeySpec.getPassword());
    }
    return k.b(this.pbeKeySpec.getPassword());
  }
  
  public String getFormat()
  {
    return "RAW";
  }
  
  public int getIterationCount()
  {
    return this.pbeKeySpec.getIterationCount();
  }
  
  public int getIvSize()
  {
    return this.ivSize;
  }
  
  int getKeySize()
  {
    return this.keySize;
  }
  
  public m getOID()
  {
    return this.oid;
  }
  
  public e getParam()
  {
    return this.param;
  }
  
  public char[] getPassword()
  {
    return this.pbeKeySpec.getPassword();
  }
  
  public byte[] getSalt()
  {
    return this.pbeKeySpec.getSalt();
  }
  
  int getType()
  {
    return this.type;
  }
  
  public void setTryWrongPKCS12Zero(boolean paramBoolean)
  {
    this.tryWrong = paramBoolean;
  }
  
  boolean shouldTryWrongPKCS12()
  {
    return this.tryWrong;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\provider\symmetric\util\BCPBEKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */