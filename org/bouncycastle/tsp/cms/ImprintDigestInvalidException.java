package org.bouncycastle.tsp.cms;

import org.bouncycastle.tsp.a;

public class ImprintDigestInvalidException
  extends Exception
{
  private a token;
  
  public ImprintDigestInvalidException(String paramString, a parama)
  {
    super(paramString);
  }
  
  public a getTimeStampToken()
  {
    return this.token;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\tsp\cms\ImprintDigestInvalidException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */