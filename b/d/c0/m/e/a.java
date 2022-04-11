package b.d.c0.m.e;

import java.io.UnsupportedEncodingException;

public class a
  extends b
{
  private short d;
  private int e = -1;
  
  public a(byte[] paramArrayOfByte)
  {
    this.a = paramArrayOfByte;
    this.e = (paramArrayOfByte.length - 1);
  }
  
  private short j()
  {
    byte[] arrayOfByte = new byte[2];
    System.arraycopy(this.a, this.b, arrayOfByte, 0, 2);
    this.b += 2;
    return w(arrayOfByte);
  }
  
  private boolean p(byte[] paramArrayOfByte)
  {
    int i = q(paramArrayOfByte);
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  private byte q(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 1)) {
      return paramArrayOfByte[0];
    }
    return 0;
  }
  
  private char r(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 2)) {
      return b.d.c0.m.b.b(paramArrayOfByte);
    }
    return '\000';
  }
  
  private double s(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 8)) {
      return b.d.c0.m.b.c(paramArrayOfByte);
    }
    return 0.0D;
  }
  
  private float t(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 4)) {
      return b.d.c0.m.b.d(paramArrayOfByte);
    }
    return 0.0F;
  }
  
  private int u(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 4)) {
      return b.d.c0.m.b.e(paramArrayOfByte);
    }
    return 0;
  }
  
  private long v(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 8)) {
      return b.d.c0.m.b.f(paramArrayOfByte);
    }
    return 0L;
  }
  
  private short w(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length >= 2)) {
      return b.d.c0.m.b.g(paramArrayOfByte);
    }
    return 0;
  }
  
  private String x(byte[] paramArrayOfByte)
  {
    String str1 = "";
    if (paramArrayOfByte == null) {
      return "";
    }
    try
    {
      String str2 = new java/lang/String;
      str2.<init>(paramArrayOfByte, "UTF-8");
      paramArrayOfByte = str2;
    }
    catch (UnsupportedEncodingException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      paramArrayOfByte = str1;
    }
    return paramArrayOfByte;
  }
  
  private void y(short paramShort)
  {
    this.b += 4 - (paramShort & 0x3);
  }
  
  public short a()
  {
    byte[] arrayOfByte = new byte[2];
    System.arraycopy(this.a, this.b, arrayOfByte, 0, 2);
    return w(arrayOfByte);
  }
  
  public boolean b()
  {
    int i = this.c;
    boolean bool = true;
    if (i == 1) {
      o();
    }
    if (this.b >= this.e) {
      bool = false;
    }
    return bool;
  }
  
  public short c()
  {
    return this.d;
  }
  
  public Boolean d()
  {
    return Boolean.valueOf(p(o()));
  }
  
  public Byte e()
  {
    return Byte.valueOf(q(o()));
  }
  
  public Character f()
  {
    return Character.valueOf(r(o()));
  }
  
  public Double g()
  {
    return Double.valueOf(s(o()));
  }
  
  public Float h()
  {
    return Float.valueOf(t(o()));
  }
  
  public Integer i()
  {
    return Integer.valueOf(u(o()));
  }
  
  public Long k()
  {
    return Long.valueOf(v(o()));
  }
  
  public Short l()
  {
    return Short.valueOf(w(o()));
  }
  
  public String m()
  {
    return x(o());
  }
  
  public short n()
  {
    if (this.c == 1) {
      o();
    }
    byte[] arrayOfByte = new byte[2];
    System.arraycopy(this.a, this.b, arrayOfByte, 0, 2);
    this.b += 2;
    this.c = ((byte)1);
    short s = w(arrayOfByte);
    this.d = s;
    return s;
  }
  
  public byte[] o()
  {
    if (this.c == 0) {
      n();
    }
    int i = j();
    byte[] arrayOfByte = new byte[i];
    if (i != 0)
    {
      System.arraycopy(this.a, this.b, arrayOfByte, 0, i);
      this.b += i;
    }
    y(i);
    this.c = ((byte)0);
    return arrayOfByte;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\c0\m\e\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */