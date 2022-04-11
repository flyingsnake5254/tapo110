package b.d.a0.a;

import com.tplink.libtpappcommonmedia.bean.DeviceModel;
import com.tplink.libtpappcommonmedia.bean.TPMediaDevice;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpstreampreconnect.bean.BaseConnection;
import com.tplink.libtpstreampreconnect.bean.NatBean;

public class c
{
  public static void b(final String paramString, int paramInt, long paramLong1, long paramLong2, final e parame)
  {
    Object localObject = b.d.d.d.c.c(paramString);
    if (localObject == null)
    {
      parame.j(paramString);
      return;
    }
    localObject = new d(paramString, DeviceModel.fromValue(((TPMediaDevice)localObject).getModel()));
    ((BaseConnection)localObject).setBitStreamType(BitStreamType.MAIN_HD);
    ((BaseConnection)localObject).setConnectionType(paramInt);
    ((BaseConnection)localObject).setStartTime(paramLong1);
    ((BaseConnection)localObject).setEndTime(paramLong2);
    b.d.t.a.c().a((BaseConnection)localObject, new a((d)localObject, parame, paramString));
  }
  
  private static void c(d paramd, NatBean paramNatBean)
  {
    paramd.setIp(paramNatBean.getIp());
    paramd.setPort(paramNatBean.getPort());
  }
  
  class a
    implements b.d.t.c.a
  {
    a(e parame, String paramString) {}
    
    public void a(NatBean paramNatBean)
    {
      c.a(c.this, paramNatBean);
      paramNatBean = parame;
      if (paramNatBean != null) {
        paramNatBean.q(c.this);
      }
    }
    
    public void b(NatBean paramNatBean)
    {
      c.a(c.this, paramNatBean);
      paramNatBean = parame;
      if (paramNatBean != null)
      {
        paramNatBean.l(c.this);
        parame.j(paramString);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\a0\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */