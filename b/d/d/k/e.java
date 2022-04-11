package b.d.d.k;

import b.d.d.k.f.b;
import org.bouncycastle.crypto.tls.c1;

public class e
  implements c1
{
  private String a;
  private String b;
  
  e(b paramb)
  {
    if (paramb != null)
    {
      this.a = paramb.a();
      this.b = paramb.b();
    }
  }
  
  public byte[] a()
  {
    String str = this.a;
    if (str == null) {
      return new byte[0];
    }
    return str.getBytes();
  }
  
  public void b() {}
  
  public void c(byte[] paramArrayOfByte) {}
  
  public byte[] d()
  {
    String str = this.b;
    if (str == null) {
      return new byte[0];
    }
    return str.getBytes();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d\k\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */