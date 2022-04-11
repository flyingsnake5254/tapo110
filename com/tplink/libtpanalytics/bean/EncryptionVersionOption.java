package com.tplink.libtpanalytics.bean;

import androidx.annotation.NonNull;
import com.google.gson.q.c;

public class EncryptionVersionOption
{
  @c("evoi")
  private String encryptionVersionOptionId;
  private String key;
  @c("ks")
  private int keySize;
  @c("transformation")
  private String transformation;
  
  public String getEncryptionVersionOptionId()
  {
    return this.encryptionVersionOptionId;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public int getKeySize()
  {
    return this.keySize;
  }
  
  public String getTransformation()
  {
    return this.transformation;
  }
  
  public void setEncryptionVersionOptionId(String paramString)
  {
    this.encryptionVersionOptionId = paramString;
  }
  
  public void setKey(@NonNull String paramString)
  {
    this.key = paramString;
  }
  
  public void setKeySize(int paramInt)
  {
    this.keySize = paramInt;
  }
  
  public void setTransformation(@NonNull String paramString)
  {
    this.transformation = paramString;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\bean\EncryptionVersionOption.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */