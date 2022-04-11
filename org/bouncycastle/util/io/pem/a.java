package org.bouncycastle.util.io.pem;

public class a
{
  private String a;
  private String b;
  
  public a(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  private int a(String paramString)
  {
    if (paramString == null) {
      return 1;
    }
    return paramString.hashCode();
  }
  
  private boolean d(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return true;
    }
    if ((paramString1 != null) && (paramString2 != null)) {
      return paramString1.equals(paramString2);
    }
    return false;
  }
  
  public String b()
  {
    return this.a;
  }
  
  public String c()
  {
    return this.b;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof a;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (a)paramObject;
    if (paramObject != this)
    {
      bool1 = bool2;
      if (d(this.a, ((a)paramObject).a))
      {
        bool1 = bool2;
        if (!d(this.b, ((a)paramObject).b)) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public int hashCode()
  {
    return a(this.a) + a(this.b) * 31;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\util\io\pem\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */