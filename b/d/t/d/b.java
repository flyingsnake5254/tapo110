package b.d.t.d;

import com.tplink.libtpstreampreconnect.bean.BaseConnection;
import com.tplink.libtpstreampreconnect.bean.NatBean;
import java.util.concurrent.Callable;

public abstract class b
  implements a, Callable<Boolean>
{
  BaseConnection c;
  NatBean d;
  protected b.d.t.c.a f;
  
  b(BaseConnection paramBaseConnection, b.d.t.c.a parama)
  {
    this.c = paramBaseConnection;
    this.f = parama;
  }
  
  public Boolean b()
    throws Exception
  {
    Object localObject = new NatBean();
    this.d = ((NatBean)localObject);
    ((NatBean)localObject).setDeviceIdMD5(this.c.getDeviceIdMD5());
    this.d.setIp(a());
    int i = getPort();
    this.d.setPort(i);
    this.d.setDeviceModel(this.c.getDeviceModel());
    boolean bool;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    }
    this.c.setIp(this.d.getIp());
    this.c.setPort(this.d.getPort());
    this.c.setPortId(this.d.getPortId());
    this.c.setStatistics(this.d.getStatistics());
    localObject = this.f;
    if (localObject == null)
    {
      if (this.d.getPortId() >= 0) {
        b.d.t.b.a(this.d.getPortId(), this.d.getDeviceModel());
      }
    }
    else if (bool) {
      ((b.d.t.c.a)localObject).a(this.d);
    } else {
      ((b.d.t.c.a)localObject).b(this.d);
    }
    return Boolean.valueOf(bool);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\t\d\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */