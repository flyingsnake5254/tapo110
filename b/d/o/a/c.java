package b.d.o.a;

import androidx.annotation.NonNull;
import com.tplink.libtpappcommonmedia.bean.DeviceModel;
import com.tplink.libtpappcommonmedia.bean.TPMediaDevice;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpstreampreconnect.bean.BaseConnection;
import com.tplink.libtpstreampreconnect.bean.NatBean;
import java.util.ArrayList;
import java.util.List;

public class c
{
  public static void a(String paramString, int paramInt, e parame, BitStreamType paramBitStreamType)
  {
    b(paramString, paramInt, parame, paramBitStreamType);
  }
  
  private static void b(final String paramString, int paramInt, @NonNull final e parame, BitStreamType paramBitStreamType)
  {
    TPMediaDevice localTPMediaDevice = b.d.d.d.c.c(paramString);
    if (localTPMediaDevice == null)
    {
      parame.f(paramString);
      return;
    }
    d locald = new d(paramString, paramInt, 1, DeviceModel.fromValue(localTPMediaDevice.getModel()));
    BitStreamType localBitStreamType = paramBitStreamType;
    if (paramBitStreamType == null) {
      localBitStreamType = b.d.d.e.a.b(paramString);
    }
    if (localTPMediaDevice.isForceMainStream())
    {
      localBitStreamType = BitStreamType.MAIN_HD;
      b.d.d.e.a.c(paramString, localBitStreamType);
    }
    locald.setBitStreamType(localBitStreamType);
    b.d.t.a.c().a(locald, new a(locald, parame, paramString));
  }
  
  class a
    implements b.d.t.c.a
  {
    a(e parame, String paramString) {}
    
    public void a(NatBean paramNatBean)
    {
      c.this.setUrl("http://".concat(paramNatBean.getIp()).concat(":").concat(String.valueOf(paramNatBean.getPort())).concat("/stream"));
      c.this.setIp(paramNatBean.getIp());
      c.this.setPort(paramNatBean.getPort());
      paramNatBean = new ArrayList();
      paramNatBean.add(c.this);
      parame.k(paramNatBean);
    }
    
    public void b(NatBean paramNatBean)
    {
      paramNatBean = new ArrayList();
      paramNatBean.add(c.this);
      parame.f(paramString);
      parame.d(paramNatBean);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\o\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */