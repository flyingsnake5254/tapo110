package b.d.c0.l;

import b.d.c0.m.a;
import com.tplink.tdp.bean.BaseTDPDevice;

public class c<T extends BaseTDPDevice>
  implements b<T>
{
  private static final a a = new a();
  private Class<T> b;
  
  public c(Class<T> paramClass)
  {
    this.b = paramClass;
  }
  
  public T a(byte[] paramArrayOfByte)
  {
    return (BaseTDPDevice)a.a(paramArrayOfByte, this.b);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\c0\l\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */