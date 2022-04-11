package org.bouncycastle.jcajce;

import org.bouncycastle.crypto.d;

public class PBKDF1Key
  implements PBKDFKey
{
  private final d converter;
  private final char[] password;
  
  public PBKDF1Key(char[] paramArrayOfChar, d paramd)
  {
    char[] arrayOfChar = new char[paramArrayOfChar.length];
    this.password = arrayOfChar;
    this.converter = paramd;
    System.arraycopy(paramArrayOfChar, 0, arrayOfChar, 0, paramArrayOfChar.length);
  }
  
  public String getAlgorithm()
  {
    return "PBKDF1";
  }
  
  public byte[] getEncoded()
  {
    return this.converter.convert(this.password);
  }
  
  public String getFormat()
  {
    return this.converter.getType();
  }
  
  public char[] getPassword()
  {
    return this.password;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\PBKDF1Key.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */