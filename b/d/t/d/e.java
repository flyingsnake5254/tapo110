package b.d.t.d;

import b.d.t.c.a;
import com.tplink.libtpstreampreconnect.bean.BaseConnection;

public class e
  extends b
{
  public e(BaseConnection paramBaseConnection, a parama)
  {
    super(paramBaseConnection, parama);
  }
  
  public String a()
  {
    return b.d.t.e.e.d(this.c.getDeviceIdMD5());
  }
  
  public int getPort()
  {
    this.c.setPortId(-1);
    return b.d.t.e.e.e(this.c.getDeviceIdMD5());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\t\d\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */