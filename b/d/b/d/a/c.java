package b.d.b.d.a;

import retrofit2.r;

public class c
{
  private final a a;
  private final e b;
  
  public c(e parame, a parama)
  {
    this.a = parama;
    this.b = parame;
  }
  
  public r a(String paramString)
  {
    Object localObject1 = this.a.toString();
    if (paramString != null)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append((String)localObject1);
      paramString = ((StringBuilder)localObject2).toString();
    }
    else
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(paramString);
      ((StringBuilder)localObject2).append(this.a.getClass().getCanonicalName());
      paramString = ((StringBuilder)localObject2).toString();
    }
    localObject1 = this.b.a(paramString);
    Object localObject2 = localObject1;
    if (localObject1 == null)
    {
      localObject2 = this.a.c();
      this.b.b(paramString, (r)localObject2);
    }
    return (r)localObject2;
  }
  
  public static abstract interface a
  {
    public abstract r c();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\b\d\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */