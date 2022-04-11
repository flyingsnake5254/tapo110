package com.tplink.libtpnetwork.cameranetwork.model;

import kotlin.jvm.internal.j;

public final class AESEncryptKey
{
  private final String aes_iv;
  private final String aes_key;
  
  public AESEncryptKey(String paramString1, String paramString2)
  {
    this.aes_key = paramString1;
    this.aes_iv = paramString2;
  }
  
  public final String component1()
  {
    return this.aes_key;
  }
  
  public final String component2()
  {
    return this.aes_iv;
  }
  
  public final AESEncryptKey copy(String paramString1, String paramString2)
  {
    j.e(paramString1, "aes_key");
    j.e(paramString2, "aes_iv");
    return new AESEncryptKey(paramString1, paramString2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this != paramObject) {
      if ((paramObject instanceof AESEncryptKey))
      {
        paramObject = (AESEncryptKey)paramObject;
        if ((j.a(this.aes_key, ((AESEncryptKey)paramObject).aes_key)) && (j.a(this.aes_iv, ((AESEncryptKey)paramObject).aes_iv))) {}
      }
      else
      {
        return false;
      }
    }
    return true;
  }
  
  public final String getAes_iv()
  {
    return this.aes_iv;
  }
  
  public final String getAes_key()
  {
    return this.aes_key;
  }
  
  public int hashCode()
  {
    String str = this.aes_key;
    int i = 0;
    int j;
    if (str != null) {
      j = str.hashCode();
    } else {
      j = 0;
    }
    str = this.aes_iv;
    if (str != null) {
      i = str.hashCode();
    }
    return j * 31 + i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AESEncryptKey(aes_key=");
    localStringBuilder.append(this.aes_key);
    localStringBuilder.append(", aes_iv=");
    localStringBuilder.append(this.aes_iv);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\model\AESEncryptKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */