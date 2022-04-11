package org.bouncycastle.jcajce;

import org.bouncycastle.crypto.d;
import org.bouncycastle.util.a;

public class PBKDF2Key
  implements PBKDFKey
{
  private final d converter;
  private final char[] password;
  
  public PBKDF2Key(char[] paramArrayOfChar, d paramd)
  {
    this.password = a.h(paramArrayOfChar);
    this.converter = paramd;
  }
  
  public String getAlgorithm()
  {
    return "PBKDF2";
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


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\jcajce\PBKDF2Key.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */