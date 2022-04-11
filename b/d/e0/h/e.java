package b.d.e0.h;

public class e
{
  private final int a;
  private final int b;
  private final int c;
  
  private e(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public int a()
  {
    return this.b;
  }
  
  public int b()
  {
    return this.c;
  }
  
  public int c()
  {
    return this.a;
  }
  
  public static class b
  {
    private int a;
    private int b;
    private int c;
    
    public e a()
    {
      return new e(this.a, this.b, this.c, null);
    }
    
    public b b(int paramInt)
    {
      this.b = paramInt;
      return this;
    }
    
    public b c(int paramInt)
    {
      this.c = paramInt;
      return this;
    }
    
    public b d(int paramInt)
    {
      this.a = paramInt;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\e0\h\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */