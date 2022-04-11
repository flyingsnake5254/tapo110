package com.jcraft.jsch;

import java.io.UnsupportedEncodingException;

class IdentityFile
  implements Identity
{
  private String identity;
  private JSch jsch;
  private KeyPair kpair;
  
  private IdentityFile(JSch paramJSch, String paramString, KeyPair paramKeyPair)
    throws JSchException
  {
    this.jsch = paramJSch;
    this.identity = paramString;
    this.kpair = paramKeyPair;
  }
  
  static IdentityFile newInstance(String paramString1, String paramString2, JSch paramJSch)
    throws JSchException
  {
    return new IdentityFile(paramJSch, paramString1, KeyPair.load(paramJSch, paramString1, paramString2));
  }
  
  static IdentityFile newInstance(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, JSch paramJSch)
    throws JSchException
  {
    return new IdentityFile(paramJSch, paramString, KeyPair.load(paramJSch, paramArrayOfByte1, paramArrayOfByte2));
  }
  
  public void clear()
  {
    this.kpair.dispose();
    this.kpair = null;
  }
  
  public boolean decrypt()
  {
    throw new RuntimeException("not implemented");
  }
  
  public String getAlgName()
  {
    byte[] arrayOfByte = this.kpair.getKeyTypeName();
    try
    {
      String str = new String(arrayOfByte, "UTF-8");
      return str;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException) {}
    return new String(arrayOfByte);
  }
  
  public KeyPair getKeyPair()
  {
    return this.kpair;
  }
  
  public String getName()
  {
    return this.identity;
  }
  
  public byte[] getPublicKeyBlob()
  {
    return this.kpair.getPublicKeyBlob();
  }
  
  public byte[] getSignature(byte[] paramArrayOfByte)
  {
    return this.kpair.getSignature(paramArrayOfByte);
  }
  
  public boolean isEncrypted()
  {
    return this.kpair.isEncrypted();
  }
  
  public boolean setPassphrase(byte[] paramArrayOfByte)
    throws JSchException
  {
    return this.kpair.decrypt(paramArrayOfByte);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\jcraft\jsch\IdentityFile.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */