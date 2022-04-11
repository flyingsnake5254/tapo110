package org.bouncycastle.crypto;

public enum PasswordConverter
  implements d
{
  static
  {
    a locala = new a("ASCII", 0);
    ASCII = locala;
    b localb = new b("UTF8", 1);
    UTF8 = localb;
    c localc = new c("PKCS12", 2);
    PKCS12 = localc;
    $VALUES = new PasswordConverter[] { locala, localb, localc };
  }
  
  static enum a
  {
    a()
    {
      super(paramInt, null);
    }
    
    public byte[] convert(char[] paramArrayOfChar)
    {
      return k.b(paramArrayOfChar);
    }
    
    public String getType()
    {
      return "ASCII";
    }
  }
  
  static enum b
  {
    b()
    {
      super(paramInt, null);
    }
    
    public byte[] convert(char[] paramArrayOfChar)
    {
      return k.c(paramArrayOfChar);
    }
    
    public String getType()
    {
      return "UTF8";
    }
  }
  
  static enum c
  {
    c()
    {
      super(paramInt, null);
    }
    
    public byte[] convert(char[] paramArrayOfChar)
    {
      return k.a(paramArrayOfChar);
    }
    
    public String getType()
    {
      return "PKCS12";
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\PasswordConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */