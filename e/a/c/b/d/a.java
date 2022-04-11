package e.a.c.b.d;

public class a
{
  private int a;
  private int b;
  private int c;
  private short[][][] d;
  private short[][][] e;
  private short[][] f;
  private short[] g;
  
  public a(byte paramByte1, byte paramByte2, short[][][] paramArrayOfShort1, short[][][] paramArrayOfShort2, short[][] paramArrayOfShort, short[] paramArrayOfShort3)
  {
    paramByte1 &= 0xFF;
    this.a = paramByte1;
    paramByte2 &= 0xFF;
    this.b = paramByte2;
    this.c = (paramByte2 - paramByte1);
    this.d = paramArrayOfShort1;
    this.e = paramArrayOfShort2;
    this.f = paramArrayOfShort;
    this.g = paramArrayOfShort3;
  }
  
  public short[][][] a()
  {
    return this.d;
  }
  
  public short[][][] b()
  {
    return this.e;
  }
  
  public short[] c()
  {
    return this.g;
  }
  
  public short[][] d()
  {
    return this.f;
  }
  
  public int e()
  {
    return this.c;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramObject != null) {
      if (!(paramObject instanceof a))
      {
        bool2 = bool1;
      }
      else
      {
        paramObject = (a)paramObject;
        bool2 = bool1;
        if (this.a == ((a)paramObject).f())
        {
          bool2 = bool1;
          if (this.b == ((a)paramObject).g())
          {
            bool2 = bool1;
            if (this.c == ((a)paramObject).e())
            {
              bool2 = bool1;
              if (e.a.c.b.d.f.a.k(this.d, ((a)paramObject).a()))
              {
                bool2 = bool1;
                if (e.a.c.b.d.f.a.k(this.e, ((a)paramObject).b()))
                {
                  bool2 = bool1;
                  if (e.a.c.b.d.f.a.j(this.f, ((a)paramObject).d()))
                  {
                    bool2 = bool1;
                    if (e.a.c.b.d.f.a.i(this.g, ((a)paramObject).c())) {
                      bool2 = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool2;
  }
  
  public int f()
  {
    return this.a;
  }
  
  public int g()
  {
    return this.b;
  }
  
  public int hashCode()
  {
    return (((((this.a * 37 + this.b) * 37 + this.c) * 37 + org.bouncycastle.util.a.D(this.d)) * 37 + org.bouncycastle.util.a.D(this.e)) * 37 + org.bouncycastle.util.a.C(this.f)) * 37 + org.bouncycastle.util.a.B(this.g);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\e\a\c\b\d\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */