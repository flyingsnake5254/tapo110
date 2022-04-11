package b.d.v.a;

import b.d.p.d;
import b.d.t.e.e;
import com.tplink.libtpappcommonmedia.bean.DeviceModel;
import com.tplink.libtpappcommonmedia.bean.TPMediaDevice;
import com.tplink.libtpstreampreconnect.bean.BaseConnection;
import com.tplink.libtpstreampreconnect.bean.NatBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class c
{
  private final Map<String, NatBean> a = new HashMap(2);
  private final Map<String, NatBean> b = new HashMap(2);
  private b c;
  private final Set<String> d = new HashSet();
  private final Map<String, Integer> e = new HashMap();
  
  private void h(final String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt)
  {
    paramString1 = new a(paramString1, DeviceModel.fromValue(paramString2));
    paramString1.setTalkMode(paramString3);
    paramString1.setMediaType(2);
    paramString1.setConnectionType(paramInt);
    paramString1.d(paramBoolean);
    b.d.t.a.c().a(paramString1, new a(paramString1));
  }
  
  private void i(final String paramString1, final String paramString2, boolean paramBoolean, String paramString3)
  {
    final Object localObject = DeviceModel.fromValue(paramString2);
    final ArrayList localArrayList = new ArrayList();
    paramString2 = new AtomicInteger(0);
    if ((b.d.d.a.a.f()) && (!l(paramString1)) && ("half_duplex".equals(paramString3)))
    {
      final a locala = new a(paramString1, (DeviceModel)localObject);
      locala.setTalkMode(paramString3);
      locala.setMediaType(2);
      locala.setConnectionType(16);
      locala.d(paramBoolean);
      b.d.t.a.c().a(locala, new b(locala, paramString2, paramString1, localArrayList));
    }
    if (b.d.d.a.a.g())
    {
      localObject = new a(paramString1, (DeviceModel)localObject);
      ((BaseConnection)localObject).setTalkMode(paramString3);
      ((BaseConnection)localObject).setMediaType(2);
      ((BaseConnection)localObject).setConnectionType(0);
      ((a)localObject).d(paramBoolean);
      b.d.t.a.c().a((BaseConnection)localObject, new c((a)localObject, paramString2, paramString1, localArrayList));
    }
  }
  
  public static c k()
  {
    return d.a;
  }
  
  private boolean l(String paramString)
  {
    Integer localInteger = (Integer)this.e.get(paramString);
    if ((localInteger != null) && (localInteger.intValue() >= 2))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("deviceIdMD5 ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" expCount ");
      localStringBuilder.append(localInteger);
      localStringBuilder.append(" skip P2P");
      d.c("DoubleTalkConnectionManager", localStringBuilder.toString());
      return true;
    }
    return false;
  }
  
  public void e(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("deviceIdMD5 ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" addDoubleTalkP2PException ");
    d.c("DoubleTalkConnectionManager", ((StringBuilder)localObject).toString());
    localObject = (Integer)this.e.get(paramString);
    if (localObject == null) {
      localObject = Integer.valueOf(1);
    } else {
      localObject = Integer.valueOf(((Integer)localObject).intValue() + 1);
    }
    this.e.put(paramString, localObject);
  }
  
  public void f()
  {
    this.e.clear();
  }
  
  public void g(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("deviceIdMD5 ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" cleanDoubleTalkP2PException ");
    d.c("DoubleTalkConnectionManager", localStringBuilder.toString());
    this.e.remove(paramString);
  }
  
  public void j(String paramString1, String paramString2)
  {
    n(paramString1);
    this.d.remove(paramString1);
    TPMediaDevice localTPMediaDevice = b.d.d.d.c.c(paramString1);
    if (localTPMediaDevice == null)
    {
      paramString1 = new a(paramString1, DeviceModel.CAMERA_OTHER);
      paramString1.setTalkMode(paramString2);
      paramString1.setMediaType(2);
      paramString2 = this.c;
      if (paramString2 != null) {
        paramString2.s(Collections.singletonList(paramString1));
      }
      return;
    }
    if (b.d.d.d.c.i(paramString1)) {
      h(paramString1, localTPMediaDevice.getModel(), true, paramString2, 256);
    } else if ((e.g(paramString1)) && (e.h(paramString1))) {
      h(paramString1, localTPMediaDevice.getModel(), true, paramString2, 17);
    } else {
      i(paramString1, localTPMediaDevice.getModel(), true, paramString2);
    }
  }
  
  public void m()
  {
    Object localObject1 = this.a;
    Object localObject2;
    Object localObject3;
    if (localObject1 != null)
    {
      localObject2 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (NatBean)((Map.Entry)((Iterator)localObject2).next()).getValue();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("DoubleTalk P2P needs destroy ");
        ((StringBuilder)localObject1).append(((NatBean)localObject3).toString());
        d.c("DoubleTalkConnectionManager", ((StringBuilder)localObject1).toString());
        b.d.t.a.c().b(((NatBean)localObject3).getPortId(), ((NatBean)localObject3).getDeviceModel());
      }
      this.a.clear();
    }
    localObject1 = this.b;
    if (localObject1 != null)
    {
      localObject3 = ((Map)localObject1).entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject2 = (NatBean)((Map.Entry)((Iterator)localObject3).next()).getValue();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("DoubleTalk Relay needs destroy ");
        ((StringBuilder)localObject1).append(((NatBean)localObject2).toString());
        d.c("DoubleTalkConnectionManager", ((StringBuilder)localObject1).toString());
        b.d.t.a.c().b(((NatBean)localObject2).getPortId(), ((NatBean)localObject2).getDeviceModel());
      }
      this.b.clear();
    }
    this.c = null;
  }
  
  public void n(String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("release ");
    ((StringBuilder)localObject).append(paramString);
    d.c("DoubleTalkConnectionManager", ((StringBuilder)localObject).toString());
    this.d.add(paramString);
    localObject = this.a;
    if (localObject != null)
    {
      localObject = (NatBean)((Map)localObject).remove(paramString);
      if (localObject != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("DoubleTalk P2P needs destroy ");
        localStringBuilder.append(((NatBean)localObject).toString());
        d.c("DoubleTalkConnectionManager", localStringBuilder.toString());
        b.d.t.a.c().b(((NatBean)localObject).getPortId(), ((NatBean)localObject).getDeviceModel());
      }
    }
    localObject = this.b;
    if (localObject != null)
    {
      localObject = (NatBean)((Map)localObject).remove(paramString);
      if (localObject != null)
      {
        paramString = new StringBuilder();
        paramString.append("DoubleTalk Relay needs destroy ");
        paramString.append(((NatBean)localObject).toString());
        d.c("DoubleTalkConnectionManager", paramString.toString());
        b.d.t.a.c().b(((NatBean)localObject).getPortId(), ((NatBean)localObject).getDeviceModel());
      }
    }
  }
  
  public void o(b paramb)
  {
    this.c = paramb;
  }
  
  class a
    implements b.d.t.c.a
  {
    a(a parama) {}
    
    public void a(NatBean paramNatBean)
    {
      if (c.a(c.this) != null)
      {
        paramString1.c(0);
        c.a(c.this).h(paramString1);
      }
    }
    
    public void b(NatBean paramNatBean)
    {
      if (c.a(c.this) != null)
      {
        paramString1.c(2);
        paramNatBean = new ArrayList();
        paramNatBean.add(paramString1);
        c.a(c.this).s(paramNatBean);
      }
    }
  }
  
  class b
    implements b.d.t.c.a
  {
    b(a parama, AtomicInteger paramAtomicInteger, String paramString, List paramList) {}
    
    public void a(NatBean paramNatBean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DoubleTalk P2P creates successfully ");
      localStringBuilder.append(paramNatBean.toString());
      d.c("DoubleTalkConnectionManager", localStringBuilder.toString());
      if (c.b(c.this).contains(paramNatBean.getDeviceIdMD5()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("DoubleTalk P2P needs destroy ");
        localStringBuilder.append(paramNatBean.toString());
        d.c("DoubleTalkConnectionManager", localStringBuilder.toString());
        b.d.t.a.c().b(paramNatBean.getPortId(), paramNatBean.getDeviceModel());
        if (c.a(c.this) != null)
        {
          locala.c(0);
          c.a(c.this).p(locala);
        }
        return;
      }
      if (paramString2.get() == 1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("DoubleTalk P2P needs destroy ");
        localStringBuilder.append(paramNatBean.toString());
        d.c("DoubleTalkConnectionManager", localStringBuilder.toString());
        b.d.t.a.c().b(paramNatBean.getPortId(), paramNatBean.getDeviceModel());
        if (c.a(c.this) != null)
        {
          locala.c(0);
          c.a(c.this).p(locala);
        }
      }
      else
      {
        locala.c(0);
        paramString2.set(1);
        c.c(c.this).put(paramString1, paramNatBean);
        if (c.a(c.this) != null)
        {
          c.a(c.this).h(locala);
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("DoubleTalk P2P needs destroy ");
          localStringBuilder.append(paramNatBean.toString());
          d.c("DoubleTalkConnectionManager", localStringBuilder.toString());
          b.d.t.a.c().b(paramNatBean.getPortId(), paramNatBean.getDeviceModel());
        }
      }
    }
    
    public void b(NatBean paramNatBean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DoubleTalk P2P creates failed ");
      localStringBuilder.append(paramNatBean.toString());
      d.c("DoubleTalkConnectionManager", localStringBuilder.toString());
      locala.c(2);
      localArrayList.add(locala);
      if (paramString2.get() == 2)
      {
        if (c.a(c.this) != null) {
          c.a(c.this).s(localArrayList);
        }
      }
      else if (paramString2.get() == 0) {
        paramString2.set(2);
      }
      if (c.a(c.this) != null) {
        c.a(c.this).p(locala);
      }
    }
  }
  
  class c
    implements b.d.t.c.a
  {
    c(a parama, AtomicInteger paramAtomicInteger, String paramString, List paramList) {}
    
    public void a(NatBean paramNatBean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DoubleTalk Relay creates successfully ");
      localStringBuilder.append(paramNatBean.toString());
      d.c("DoubleTalkConnectionManager", localStringBuilder.toString());
      if (c.b(c.this).contains(paramNatBean.getDeviceIdMD5()))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("DoubleTalk Relay needs destroy ");
        localStringBuilder.append(paramNatBean.toString());
        d.c("DoubleTalkConnectionManager", localStringBuilder.toString());
        b.d.t.a.c().b(paramNatBean.getPortId(), paramNatBean.getDeviceModel());
        if (c.a(c.this) != null)
        {
          localObject.c(0);
          c.a(c.this).p(localObject);
        }
        return;
      }
      if (paramString2.get() == 1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("DoubleTalk Relay needs destroy ");
        localStringBuilder.append(paramNatBean.toString());
        d.c("DoubleTalkConnectionManager", localStringBuilder.toString());
        b.d.t.a.c().b(paramNatBean.getPortId(), paramNatBean.getDeviceModel());
        if (c.a(c.this) != null)
        {
          localObject.c(0);
          c.a(c.this).p(localObject);
        }
      }
      else
      {
        paramString2.set(1);
        c.d(c.this).put(paramString1, paramNatBean);
        if (c.a(c.this) != null)
        {
          c.a(c.this).h(localObject);
        }
        else
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("DoubleTalk Relay needs destroy ");
          localStringBuilder.append(paramNatBean.toString());
          d.c("DoubleTalkConnectionManager", localStringBuilder.toString());
          b.d.t.a.c().b(paramNatBean.getPortId(), paramNatBean.getDeviceModel());
        }
      }
    }
    
    public void b(NatBean paramNatBean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DoubleTalk Relay creates failed ");
      localStringBuilder.append(paramNatBean.toString());
      d.c("DoubleTalkConnectionManager", localStringBuilder.toString());
      localObject.c(2);
      localArrayList.add(localObject);
      if (paramString2.get() == 2)
      {
        if (c.a(c.this) != null) {
          c.a(c.this).s(localArrayList);
        }
      }
      else if (paramString2.get() == 0) {
        paramString2.set(2);
      }
      if (c.a(c.this) != null) {
        c.a(c.this).p(localObject);
      }
    }
  }
  
  private static class d
  {
    public static final c a = new c(null);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\v\a\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */