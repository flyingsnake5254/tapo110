package org.bouncycastle.util.io.pem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class b
  implements c
{
  private static final List a = Collections.unmodifiableList(new ArrayList());
  private String b;
  private List c;
  private byte[] d;
  
  public b(String paramString, List paramList, byte[] paramArrayOfByte)
  {
    this.b = paramString;
    this.c = Collections.unmodifiableList(paramList);
    this.d = paramArrayOfByte;
  }
  
  public b(String paramString, byte[] paramArrayOfByte)
  {
    this(paramString, a, paramArrayOfByte);
  }
  
  public b a()
    throws PemGenerationException
  {
    return this;
  }
  
  public byte[] b()
  {
    return this.d;
  }
  
  public List c()
  {
    return this.c;
  }
  
  public String d()
  {
    return this.b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\util\io\pem\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */