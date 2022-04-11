package org.bouncycastle.crypto.tls;

public class s
{
  public static String a(short paramShort)
  {
    switch (paramShort)
    {
    default: 
      return "UNKNOWN";
    case 6: 
      return "sha512";
    case 5: 
      return "sha384";
    case 4: 
      return "sha256";
    case 3: 
      return "sha224";
    case 2: 
      return "sha1";
    case 1: 
      return "md5";
    }
    return "none";
  }
  
  public static String b(short paramShort)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramShort));
    localStringBuilder.append("(");
    localStringBuilder.append(paramShort);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static boolean c(short paramShort)
  {
    boolean bool;
    if ((224 <= paramShort) && (paramShort <= 255)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\tls\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */