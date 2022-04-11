package b.d.m.a;

import b.d.p.d;
import b.d.t.e.e;
import com.tplink.libtpappcommonmedia.bean.DeviceModel;
import com.tplink.libtpappcommonmedia.bean.TPMediaDevice;
import com.tplink.libtpstreampreconnect.bean.BaseConnection;
import com.tplink.libtpstreampreconnect.bean.NatBean;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class c
{
  private static final String a = "c";
  private final Map<String, NatBean> b = new HashMap(2);
  private final Map<String, NatBean> c = new HashMap(2);
  private final AtomicInteger d = new AtomicInteger(0);
  private b e;
  private final Set<String> f = new HashSet();
  private final Map<String, Integer> g = new HashMap();
  
  private void j(final TPMediaDevice paramTPMediaDevice, int paramInt)
  {
    paramTPMediaDevice = new a(paramTPMediaDevice.getDeviceIdMd5(), DeviceModel.fromValue(paramTPMediaDevice.getModel()));
    paramTPMediaDevice.setConnectionType(paramInt);
    b.d.t.a.c().a(paramTPMediaDevice, new a(paramTPMediaDevice));
  }
  
  private void k(final TPMediaDevice paramTPMediaDevice)
  {
    this.d.set(0);
    final String str = paramTPMediaDevice.getDeviceIdMd5();
    DeviceModel localDeviceModel = DeviceModel.fromValue(paramTPMediaDevice.getModel());
    if ((b.d.d.a.a.h()) && (!n(str)))
    {
      paramTPMediaDevice = new a(str, localDeviceModel);
      paramTPMediaDevice.setConnectionType(16);
      b.d.t.a.c().a(paramTPMediaDevice, new b(paramTPMediaDevice, str));
    }
    if (b.d.d.a.a.i())
    {
      paramTPMediaDevice = new a(str, localDeviceModel);
      paramTPMediaDevice.setConnectionType(0);
      b.d.t.a.c().a(paramTPMediaDevice, new c(paramTPMediaDevice, str));
    }
  }
  
  public static c m()
  {
    return d.a;
  }
  
  private boolean n(String paramString)
  {
    Integer localInteger = (Integer)this.g.get(paramString);
    if ((localInteger != null) && (localInteger.intValue() >= 2))
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deviceIdMD5 ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" expCount ");
      localStringBuilder.append(localInteger);
      localStringBuilder.append(" skip P2P");
      d.c(str, localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  public void g(String paramString)
  {
    Integer localInteger = (Integer)this.g.get(paramString);
    if (localInteger == null) {
      localInteger = Integer.valueOf(1);
    } else {
      localInteger = Integer.valueOf(localInteger.intValue() + 1);
    }
    this.g.put(paramString, localInteger);
  }
  
  public void h()
  {
    this.g.clear();
  }
  
  public void i(String paramString)
  {
    this.g.remove(paramString);
  }
  
  public void l(String paramString)
  {
    p(paramString);
    this.f.remove(paramString);
    Object localObject = b.d.d.d.c.c(paramString);
    if (localObject == null)
    {
      paramString = new a(paramString, DeviceModel.CAMERA_OTHER);
      localObject = this.e;
      if (localObject != null) {
        ((b)localObject).n(Collections.singletonList(paramString));
      }
      return;
    }
    if (b.d.d.d.c.i(paramString)) {
      j((TPMediaDevice)localObject, 256);
    } else if ((e.g(paramString)) && (e.h(paramString))) {
      j((TPMediaDevice)localObject, 17);
    } else {
      k((TPMediaDevice)localObject);
    }
  }
  
  public void o()
  {
    Object localObject1 = this.b.entrySet().iterator();
    Object localObject2;
    Object localObject4;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (NatBean)((Map.Entry)((Iterator)localObject1).next()).getValue();
      localObject3 = a;
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("DoubleTalk P2P needs destroy ");
      ((StringBuilder)localObject4).append(((NatBean)localObject2).toString());
      d.c((String)localObject3, ((StringBuilder)localObject4).toString());
      b.d.t.a.c().b(((NatBean)localObject2).getPortId(), ((NatBean)localObject2).getDeviceModel());
    }
    this.b.clear();
    Object localObject3 = this.c.entrySet().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      localObject1 = (NatBean)((Map.Entry)((Iterator)localObject3).next()).getValue();
      localObject4 = a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("DoubleTalk Relay needs destroy ");
      ((StringBuilder)localObject2).append(((NatBean)localObject1).toString());
      d.c((String)localObject4, ((StringBuilder)localObject2).toString());
      b.d.t.a.c().b(((NatBean)localObject1).getPortId(), ((NatBean)localObject1).getDeviceModel());
    }
    this.c.clear();
    this.e = null;
  }
  
  public void p(String paramString)
  {
    String str = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("release ");
    localStringBuilder.append(paramString);
    d.c(str, localStringBuilder.toString());
    this.f.add(paramString);
    NatBean localNatBean = (NatBean)this.b.remove(paramString);
    if (localNatBean != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DoubleTalk P2P needs destroy ");
      localStringBuilder.append(localNatBean.toString());
      d.c(str, localStringBuilder.toString());
      b.d.t.a.c().b(localNatBean.getPortId(), localNatBean.getDeviceModel());
    }
    paramString = (NatBean)this.c.remove(paramString);
    if (paramString != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("DoubleTalk Relay needs destroy ");
      localStringBuilder.append(paramString.toString());
      d.c(str, localStringBuilder.toString());
      b.d.t.a.c().b(paramString.getPortId(), paramString.getDeviceModel());
    }
  }
  
  public void q(b paramb)
  {
    this.e = paramb;
  }
  
  class a
    implements b.d.t.c.a
  {
    a(a parama) {}
    
    public void a(NatBean paramNatBean)
    {
      if (c.a(c.this) != null) {
        c.a(c.this).b(paramTPMediaDevice);
      }
    }
    
    public void b(NatBean paramNatBean)
    {
      if (c.a(c.this) != null) {
        c.a(c.this).n(Collections.singletonList(paramTPMediaDevice));
      }
    }
  }
  
  class b
    implements b.d.t.c.a
  {
    b(a parama, String paramString) {}
    
    public void a(NatBean paramNatBean)
    {
      Object localObject1 = c.b();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Download P2P creates successfully ");
      ((StringBuilder)localObject2).append(paramNatBean.toString());
      d.c((String)localObject1, ((StringBuilder)localObject2).toString());
      if (c.c(c.this).contains(paramNatBean.getDeviceIdMD5()))
      {
        localObject2 = c.b();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Download P2P needs destroy ");
        ((StringBuilder)localObject1).append(paramNatBean.toString());
        d.c((String)localObject2, ((StringBuilder)localObject1).toString());
        b.d.t.a.c().b(paramNatBean.getPortId(), paramNatBean.getDeviceModel());
        if (c.a(c.this) != null) {
          c.a(c.this).e(paramTPMediaDevice);
        }
        return;
      }
      if (c.d(c.this).get() == 1)
      {
        localObject2 = c.b();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Download P2P needs destroy ");
        ((StringBuilder)localObject1).append(paramNatBean.toString());
        d.c((String)localObject2, ((StringBuilder)localObject1).toString());
        b.d.t.a.c().b(paramNatBean.getPortId(), paramNatBean.getDeviceModel());
        if (c.a(c.this) != null) {
          c.a(c.this).e(paramTPMediaDevice);
        }
      }
      else
      {
        c.d(c.this).set(1);
        c.e(c.this).put(str, paramNatBean);
        if (c.a(c.this) != null)
        {
          c.a(c.this).b(paramTPMediaDevice);
        }
        else
        {
          localObject2 = c.b();
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Download P2P needs destroy ");
          ((StringBuilder)localObject1).append(paramNatBean.toString());
          d.c((String)localObject2, ((StringBuilder)localObject1).toString());
          b.d.t.a.c().b(paramNatBean.getPortId(), paramNatBean.getDeviceModel());
        }
      }
    }
    
    public void b(NatBean paramNatBean)
    {
      String str = c.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Download P2P creates failed ");
      localStringBuilder.append(paramNatBean.toString());
      d.c(str, localStringBuilder.toString());
      if (c.d(c.this).get() == 2)
      {
        if (c.a(c.this) != null) {
          c.a(c.this).n(Collections.singletonList(paramTPMediaDevice));
        }
      }
      else if (c.d(c.this).get() == 0) {
        c.d(c.this).set(2);
      }
      if (c.a(c.this) != null) {
        c.a(c.this).e(paramTPMediaDevice);
      }
    }
  }
  
  class c
    implements b.d.t.c.a
  {
    c(a parama, String paramString) {}
    
    public void a(NatBean paramNatBean)
    {
      Object localObject1 = c.b();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Download Relay creates successfully ");
      ((StringBuilder)localObject2).append(paramNatBean.toString());
      d.c((String)localObject1, ((StringBuilder)localObject2).toString());
      if (c.c(c.this).contains(paramNatBean.getDeviceIdMD5()))
      {
        localObject1 = c.b();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Download Relay needs destroy ");
        ((StringBuilder)localObject2).append(paramNatBean.toString());
        d.c((String)localObject1, ((StringBuilder)localObject2).toString());
        b.d.t.a.c().b(paramNatBean.getPortId(), paramNatBean.getDeviceModel());
        if (c.a(c.this) != null) {
          c.a(c.this).e(paramTPMediaDevice);
        }
        return;
      }
      if (c.d(c.this).get() == 1)
      {
        localObject2 = c.b();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Download Relay needs destroy ");
        ((StringBuilder)localObject1).append(paramNatBean.toString());
        d.c((String)localObject2, ((StringBuilder)localObject1).toString());
        b.d.t.a.c().b(paramNatBean.getPortId(), paramNatBean.getDeviceModel());
        if (c.a(c.this) != null) {
          c.a(c.this).e(paramTPMediaDevice);
        }
      }
      else
      {
        c.d(c.this).set(1);
        c.f(c.this).put(str, paramNatBean);
        if (c.a(c.this) != null)
        {
          c.a(c.this).b(paramTPMediaDevice);
        }
        else
        {
          localObject1 = c.b();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("Download Relay needs destroy ");
          ((StringBuilder)localObject2).append(paramNatBean.toString());
          d.c((String)localObject1, ((StringBuilder)localObject2).toString());
          b.d.t.a.c().b(paramNatBean.getPortId(), paramNatBean.getDeviceModel());
        }
      }
    }
    
    public void b(NatBean paramNatBean)
    {
      String str = c.b();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Download Relay creates failed ");
      localStringBuilder.append(paramNatBean.toString());
      d.c(str, localStringBuilder.toString());
      if (c.d(c.this).get() == 2)
      {
        if (c.a(c.this) != null) {
          c.a(c.this).n(Collections.singletonList(paramTPMediaDevice));
        }
      }
      else if (c.d(c.this).get() == 0) {
        c.d(c.this).set(2);
      }
      if (c.a(c.this) != null) {
        c.a(c.this).e(paramTPMediaDevice);
      }
    }
  }
  
  private static class d
  {
    public static final c a = new c(null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\m\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */