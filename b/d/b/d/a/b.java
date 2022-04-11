package b.d.b.d.a;

import retrofit2.r;

public abstract class b
  implements c.a
{
  protected final String a;
  protected volatile r b;
  protected c.a c;
  
  public b(String paramString)
  {
    this.a = paramString;
  }
  
  public b(String paramString, c.a parama)
  {
    this.a = paramString;
    this.c = parama;
  }
  
  public void Q1()
  {
    String str = this.a;
    if (str != null) {
      d.a(str);
    }
  }
  
  public final <T> T R1(Class<T> paramClass)
  {
    if (this.b == null) {
      this.b = c();
    }
    if (this.b != null) {
      return (T)this.b.b(paramClass);
    }
    throw new IllegalArgumentException("Must be set Retrofit");
  }
  
  public r c()
  {
    c.a locala = this.c;
    if (locala != null) {
      return d.b(locala).a(this.a);
    }
    return null;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\b\d\a\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */