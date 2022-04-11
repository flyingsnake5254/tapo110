package b.d.t.d;

import android.text.TextUtils;
import com.tplink.libtpstreampreconnect.bean.BaseConnection;
import com.tplink.libtpstreampreconnect.bean.NatBean;
import com.tplink.libtpstreampreconnect.bean.NatStatistics;

public class d
  extends b
{
  public d(BaseConnection paramBaseConnection, b.d.t.c.a parama)
  {
    super(paramBaseConnection, parama);
  }
  
  public String a()
  {
    return "127.0.0.1";
  }
  
  public int getPort()
  {
    int i = 0;
    int j = -1;
    int k;
    for (;;)
    {
      k = j;
      if (i >= 3) {
        break;
      }
      if (TextUtils.isEmpty(b.d.d.a.a.c()))
      {
        k = j;
        break;
      }
      NatStatistics localNatStatistics = new NatStatistics();
      long l1 = System.currentTimeMillis();
      k = b.d.t.b.j(this.c);
      if (k < 0)
      {
        localNatStatistics.setFailureReason(-1);
        localNatStatistics.setPenetrationTime(-1L);
        this.d.addStatistics(localNatStatistics);
        b.d.t.b.a(k, this.c.getDeviceModel());
      }
      long l2;
      for (;;)
      {
        k = 0;
        break label221;
        if (this.f == null)
        {
          b.d.t.b.a(k, this.c.getDeviceModel());
          return -1;
        }
        j = b.d.t.b.f(this.c, k);
        l2 = System.currentTimeMillis();
        if (j >= 0) {
          break;
        }
        int m = b.d.t.b.b(this.c, k);
        k = m;
        if (m == 0) {
          k = -1;
        }
        localNatStatistics.setFailureReason(k);
        localNatStatistics.setPenetrationTime(l2 - l1);
        this.d.addStatistics(localNatStatistics);
      }
      this.c.setCreateTime(System.currentTimeMillis());
      this.d.setPortId(k);
      localNatStatistics.setFailureReason(0);
      localNatStatistics.setPenetrationTime(l2 - l1);
      this.d.addStatistics(localNatStatistics);
      k = 1;
      label221:
      if (k != 0)
      {
        k = j;
        break;
      }
      i++;
    }
    return k;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\t\d\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */