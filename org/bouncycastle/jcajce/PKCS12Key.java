package org.bouncycastle.jcajce;

import org.bouncycastle.crypto.k;

public class PKCS12Key
  implements PBKDFKey
{
  private final char[] password;
  private final boolean useWrongZeroLengthConversion;
  
  public PKCS12Key(char[] paramArrayOfChar)
  {
    this(paramArrayOfChar, false);
  }
  
  public PKCS12Key(char[] paramArrayOfChar, boolean paramBoolean)
  {
    char[] arrayOfChar = paramArrayOfChar;
    if (paramArrayOfChar == null) {
      arrayOfChar = new char[0];
    }
    paramArrayOfChar = new char[arrayOfChar.length];
    this.password = paramArrayOfChar;
    this.useWrongZeroLengthConversion = paramBoolean;
    System.arraycopy(arrayOfChar, 0, paramArrayOfChar, 0, arrayOfChar.length);
  }
  
  public String getAlgorithm()
  {
    return "PKCS12";
  }
  
  public byte[] getEncoded()
  {
    if ((this.useWrongZeroLengthConversion) && (this.password.length == 0)) {
      return new byte[2];
    }
    return k.a(this.password);
  }
  
  public String getFormat()
  {
    return "PKCS12";
  }
  
  public char[] getPassword()
  {
    return this.password;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\PKCS12Key.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */