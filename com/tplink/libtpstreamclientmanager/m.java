package com.tplink.libtpstreamclientmanager;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import b.d.i.a.b.c.o;
import b.d.m.b.b.a;
import b.d.v.b.d.a;
import com.tplink.libtpappcommonmedia.bean.stream.BitStreamType;
import com.tplink.libtpmediastatistics.ConnectionInfoVO;
import com.tplink.libtpmediastatistics.ConnectionVO;
import com.tplink.libtpmediastatistics.OnceConnectionVO;
import com.tplink.libtpmediastatistics.StatisticsManager;
import com.tplink.libtpmediastatistics.StatisticsStreamType;
import com.tplink.libtpmediastatistics.StopReason;
import com.tplink.libtpstreampreconnect.bean.BaseConnection;
import com.tplink.libtpstreampreconnect.bean.NatStatistics;
import com.tplink.libtpstreampreconnect.bean.Status;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class m
  implements b.d.o.a.e, b.d.o.b.f, b.d.a0.a.e, b.d.a0.b.g, b.d.v.a.b, b.d.v.b.e, b.d.m.a.b, b.d.m.b.d
{
  private static volatile m a;
  private String b = "StreamManager";
  private final b.d.v.a.c c;
  private final b.d.m.a.c d;
  private final Map<String, b.d.o.b.e> e;
  private final Map<String, b.d.a0.b.f> f;
  private final Map<String, b.d.v.b.b> g;
  private final Map<String, b.d.m.b.c> h;
  private final Map<String, o> i;
  private String j;
  private ExecutorService k;
  private Handler l;
  
  private m()
  {
    b.d.o.a.f.m().v(this);
    b.d.a0.a.f.c().i(this);
    Object localObject = b.d.v.a.c.k();
    this.c = ((b.d.v.a.c)localObject);
    ((b.d.v.a.c)localObject).o(this);
    localObject = b.d.m.a.c.m();
    this.d = ((b.d.m.a.c)localObject);
    ((b.d.m.a.c)localObject).q(this);
    this.e = new ConcurrentHashMap();
    this.f = new ConcurrentHashMap();
    this.g = new ConcurrentHashMap(1);
    this.h = new ConcurrentHashMap(1);
    this.i = new ConcurrentHashMap();
    this.l = new Handler(Looper.getMainLooper());
    this.k = Executors.newCachedThreadPool(new a());
  }
  
  private void F(b.d.o.b.d paramd, String paramString)
  {
    paramd = (b.d.v.b.b)this.g.get(paramString);
    if (paramd != null)
    {
      paramd = paramd.a();
      if (paramd != null) {
        paramd.onDoubleTalkClose(paramString);
      }
    }
  }
  
  private void F0(String paramString, byte[] paramArrayOfByte)
  {
    Object localObject = (b.d.v.b.b)this.g.get(paramString);
    if (localObject != null)
    {
      b.d.v.b.d locald = ((b.d.v.b.b)localObject).b();
      localObject = ((b.d.v.b.b)localObject).a();
      if ((locald == null) && (localObject != null)) {
        ((b.d.v.b.c)localObject).onDoubleTalkSendDataFailure(paramString, -1, new Exception("null == connection"));
      } else if (locald != null) {
        locald.t(paramArrayOfByte);
      }
    }
  }
  
  private void G(String paramString1, b.d.v.b.c paramc, String paramString2)
  {
    b.d.v.b.b localb = new b.d.v.b.b();
    localb.c(paramc);
    this.g.put(paramString1, localb);
    this.c.j(paramString1, paramString2);
  }
  
  private void H(final b.d.v.a.a parama, b.d.v.b.b paramb, String paramString)
  {
    final b.d.v.b.c localc = paramb.a();
    b.d.v.b.d locald = new b.d.v.b.d(b.d.i.a.b.a.d(paramString, parama.getTalkMode(), W(paramString).b()));
    locald.h(paramString);
    locald.i(parama.getIp());
    locald.j(parama.getPort());
    locald.v(localc);
    locald.w(this);
    locald.z(W(paramString));
    locald.x(this.k.submit(locald));
    locald.g(parama.getConnectionType());
    locald.A(parama.getTalkMode());
    locald.u(new b(localc, parama));
    paramb.d(locald);
  }
  
  private void I(b.d.m.a.a parama, final b.d.m.b.c paramc, final String paramString)
  {
    final b.d.m.b.a locala = paramc.d();
    final b.d.m.b.b localb = new b.d.m.b.b(b.d.i.a.b.a.a(paramc.c(), paramc.f(), paramc.g(), U(paramString).b()));
    localb.h(paramString);
    localb.i(parama.getIp());
    localb.j(parama.getPort());
    localb.t(locala);
    localb.v(this);
    localb.r(U(paramString));
    localb.w(this.k.submit(localb));
    localb.g(parama.getConnectionType());
    localb.y(paramc.g());
    localb.u(paramc.f());
    localb.s(new c(paramString, localb, locala, paramc));
    paramc.j(localb);
  }
  
  private void J(String paramString1, int paramInt1, int paramInt2, String paramString2, b.d.m.b.a parama)
  {
    b.d.m.b.c localc = new b.d.m.b.c();
    localc.h(paramInt1);
    localc.k(paramInt2);
    localc.l(paramString2);
    localc.i(parama);
    this.h.put(paramString1, localc);
    this.d.l(paramString1);
  }
  
  private void K(b.d.o.a.d paramd, b.d.o.b.e parame, String paramString)
  {
    b.d.o.b.c localc = parame.f();
    if (localc != null)
    {
      b.d.o.b.d locald = new b.d.o.b.d(b.d.i.a.b.a.c(paramString, paramd.getBitStreamType(), null, W(paramString).b()), b.d.i.a.b.a.c(paramString, BitStreamType.MINOR_VGA, null, W(paramString).b()));
      locald.s(localc);
      locald.h(paramd.getDeviceIdMD5());
      locald.t(this);
      locald.k(paramd.getStreamType());
      locald.i(paramd.getIp());
      locald.j(paramd.getPort());
      locald.g(paramd.getConnectionType());
      locald.u(W(paramString));
      locald.v(this.k.submit(locald));
      parame.a(locald);
    }
  }
  
  private void L(b.d.o.a.d paramd, b.d.o.b.e parame, String paramString)
  {
    b.d.o.b.c localc = parame.f();
    if (localc != null)
    {
      b.d.o.b.g localg = new b.d.o.b.g(b.d.i.a.b.a.c(paramString, paramd.getBitStreamType(), null, W(paramString).b()), b.d.i.a.b.a.c(paramString, BitStreamType.MINOR_VGA, null, W(paramString).b()));
      localg.C(b.d.d.d.c.g(paramString));
      localg.B(b.d.d.d.c.f(paramString));
      localg.s(localc);
      localg.h(paramd.getDeviceIdMD5());
      localg.t(this);
      localg.k(paramd.getStreamType());
      localg.i(paramd.getIp());
      localg.j(paramd.getPort());
      localg.g(paramd.getConnectionType());
      localg.u(W(paramString));
      localg.v(this.k.submit(localg));
      parame.a(localg);
    }
  }
  
  private void M(b.d.a0.a.d paramd, b.d.a0.b.f paramf, String paramString)
  {
    b.d.a0.b.d locald = paramf.g();
    o localo = a0(paramString);
    Object localObject = b.d.i.a.b.a.b(paramf.b(), paramf.e(), paramf.d(), paramf.f(), paramf.c(), localo.b());
    if (localObject == null)
    {
      paramd = new StringBuilder();
      paramd.append("start time invalid ");
      paramd.append(paramf.f());
      locald.b(paramString, new Exception(paramd.toString()));
      return;
    }
    localObject = new b.d.a0.b.c((String)localObject);
    ((b.d.a0.b.e)localObject).A(locald);
    ((b.d.a0.b.e)localObject).C(localo);
    ((b.d.a0.b.e)localObject).B(this);
    ((b.d.a0.b.c)localObject).L(b.d.d.d.c.g(paramString));
    ((b.d.a0.b.c)localObject).K(b.d.d.d.c.f(paramString));
    ((b.d.i.a.a.f)localObject).h(paramd.getDeviceIdMD5());
    ((b.d.i.a.a.f)localObject).k(paramd.getStreamType());
    ((b.d.i.a.a.f)localObject).i(paramd.getIp());
    ((b.d.i.a.a.f)localObject).j(paramd.getPort());
    ((b.d.a0.b.e)localObject).F(paramd.getUrl());
    ((b.d.i.a.a.f)localObject).g(paramd.getConnectionType());
    ((b.d.a0.b.e)localObject).D(this.k.submit((Callable)localObject));
    paramf.a((b.d.a0.b.e)localObject);
    paramd = this.b;
    paramf = new StringBuilder();
    paramf.append("设备：");
    paramf.append(paramString);
    paramf.append(" onVodConnectionSuccess()");
    b.d.p.d.a(paramd, paramf.toString());
  }
  
  private void N(b.d.a0.a.d paramd, b.d.a0.b.f paramf, String paramString)
  {
    b.d.a0.b.d locald = paramf.g();
    o localo = a0(paramString);
    Object localObject = b.d.i.a.b.a.b(paramf.b(), paramf.e(), paramf.d(), paramf.f(), paramf.c(), localo.b());
    if (localObject == null)
    {
      paramd = new StringBuilder();
      paramd.append("start time invalid ");
      paramd.append(paramf.f());
      locald.b(paramString, new Exception(paramd.toString()));
      return;
    }
    localObject = new b.d.a0.b.e((String)localObject);
    ((b.d.a0.b.e)localObject).A(locald);
    ((b.d.a0.b.e)localObject).C(localo);
    ((b.d.i.a.a.f)localObject).h(paramd.getDeviceIdMD5());
    ((b.d.a0.b.e)localObject).B(this);
    ((b.d.i.a.a.f)localObject).k(paramd.getStreamType());
    ((b.d.i.a.a.f)localObject).i(paramd.getIp());
    ((b.d.i.a.a.f)localObject).j(paramd.getPort());
    ((b.d.a0.b.e)localObject).F(paramd.getUrl());
    ((b.d.i.a.a.f)localObject).g(paramd.getConnectionType());
    ((b.d.a0.b.e)localObject).D(this.k.submit((Callable)localObject));
    paramf.a((b.d.a0.b.e)localObject);
    paramf = this.b;
    paramd = new StringBuilder();
    paramd.append("设备：");
    paramd.append(paramString);
    paramd.append(" onVodConnectionSuccess()");
    b.d.p.d.a(paramf, paramd.toString());
  }
  
  public static m V()
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          m localm = new com/tplink/libtpstreamclientmanager/m;
          localm.<init>();
          a = localm;
        }
      }
      finally {}
    }
    return a;
  }
  
  private o X(String paramString1, String paramString2)
  {
    String str = Y(paramString1, paramString2);
    paramString2 = (o)this.i.get(str);
    paramString1 = paramString2;
    if (paramString2 == null)
    {
      paramString1 = new o();
      this.i.put(str, paramString1);
    }
    return paramString1;
  }
  
  private String Y(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  private void s0(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.i.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      if ((localEntry.getKey() != null) && (((String)localEntry.getKey()).contains(paramString))) {
        localArrayList.add((String)localEntry.getKey());
      }
    }
    paramString = localArrayList.iterator();
    while (paramString.hasNext())
    {
      localObject = (String)paramString.next();
      this.i.remove(localObject);
    }
  }
  
  public void A(String paramString1, b.d.o.b.c paramc, BitStreamType paramBitStreamType, String paramString2)
  {
    try
    {
      b.d.o.b.e locale = (b.d.o.b.e)this.e.get(paramString1);
      if (locale == null)
      {
        paramc.f(paramString1, paramBitStreamType, false, -1);
        return;
      }
      o localo = W(paramString1);
      Object localObject1 = locale.e();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          b.d.o.b.d locald = (b.d.o.b.d)((Iterator)localObject1).next();
          if (locald != null)
          {
            Object localObject2 = localo.e(locald, paramString1, paramBitStreamType, paramString2);
            Object localObject3 = new com/tplink/libtpstreamclientmanager/k;
            ((k)localObject3).<init>(this, paramc, paramString1, paramBitStreamType);
            localObject3 = ((q)localObject2).E((io.reactivex.g0.g)localObject3);
            localObject2 = new com/tplink/libtpstreamclientmanager/j;
            ((j)localObject2).<init>(paramc, paramString1, paramBitStreamType);
            localObject3 = ((q)localObject3).C((io.reactivex.g0.g)localObject2).F0();
            locale.b(paramString1, locald.a(), (io.reactivex.e0.c)localObject3);
          }
        }
      }
      b.d.p.d.a("resolution", "no connection");
      return;
    }
    finally {}
  }
  
  public void A0(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        x0(paramString);
        B0(paramString);
        u0(paramString);
        C(paramString);
        w0(paramString);
        E(paramString);
        String str = this.b;
        StringBuilder localStringBuilder = new java/lang/StringBuilder;
        localStringBuilder.<init>();
        localStringBuilder.append("设备：");
        localStringBuilder.append(paramString);
        localStringBuilder.append(" vod、Live talk 流被销毁！");
        b.d.p.d.a(str, localStringBuilder.toString());
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void B()
  {
    this.c.f();
  }
  
  public void B0(String paramString)
  {
    try
    {
      b.d.a0.b.f localf = (b.d.a0.b.f)this.f.remove(paramString);
      if (localf != null)
      {
        List localList = localf.h();
        if (localList != null)
        {
          Iterator localIterator = localList.iterator();
          while (localIterator.hasNext())
          {
            b.d.a0.b.e locale = (b.d.a0.b.e)localIterator.next();
            if (locale != null) {
              locale.s();
            }
          }
          localList.clear();
        }
        localf.j();
        localf.r(null);
      }
      b.d.a0.a.f.c().f(paramString);
      return;
    }
    finally {}
  }
  
  public void C(String paramString)
  {
    this.c.g(paramString);
  }
  
  public void C0(String paramString)
  {
    paramString = (o)this.i.remove(Y("vod", paramString));
    if (paramString != null) {
      paramString.E();
    }
  }
  
  public void D()
  {
    this.d.h();
  }
  
  public void D0()
  {
    try
    {
      b.d.p.d.a(this.b, "整个APP的VOD被销毁");
      Iterator localIterator1 = this.f.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        List localList = ((b.d.a0.b.f)localEntry.getValue()).h();
        if (localList != null)
        {
          Iterator localIterator2 = localList.iterator();
          while (localIterator2.hasNext())
          {
            b.d.a0.b.e locale = (b.d.a0.b.e)localIterator2.next();
            if (locale != null) {
              locale.s();
            }
          }
          localList.clear();
        }
        ((b.d.a0.b.f)localEntry.getValue()).j();
        b.d.a0.a.f.c().f((String)localEntry.getKey());
      }
      this.f.clear();
      return;
    }
    finally {}
  }
  
  public void E(String paramString)
  {
    this.d.i(paramString);
  }
  
  public void E0(String paramString1, int paramInt, String paramString2, long paramLong1, long paramLong2, b.d.a0.b.d paramd)
  {
    try
    {
      Object localObject1 = (b.d.a0.b.f)this.f.get(paramString1);
      int m = 0;
      if ((localObject1 != null) && (((b.d.a0.b.f)localObject1).d() != null))
      {
        ((b.d.a0.b.f)localObject1).p(paramLong1);
        ((b.d.a0.b.f)localObject1).l(paramLong2);
        ((b.d.a0.b.f)localObject1).k(paramInt);
        ((b.d.a0.b.f)localObject1).o(paramString2);
        o localo = a0(paramString1);
        int n = m;
        Object localObject2;
        Object localObject3;
        if (((b.d.a0.b.f)localObject1).h() != null)
        {
          localObject2 = ((b.d.a0.b.f)localObject1).h().iterator();
          do
          {
            n = m;
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            localObject3 = (b.d.a0.b.e)((Iterator)localObject2).next();
          } while ((localObject3 == null) || (!((b.d.a0.b.e)localObject3).m()));
          n = 1;
        }
        if (n != 0)
        {
          localObject1 = ((b.d.a0.b.f)localObject1).h().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (b.d.a0.b.e)((Iterator)localObject1).next();
            if (localObject2 != null)
            {
              ((b.d.a0.b.e)localObject2).x();
              localObject3 = localo.d((b.d.i.a.a.f)localObject2, paramString1, paramString2, paramLong1, paramLong2);
              l locall = new com/tplink/libtpstreamclientmanager/l;
              locall.<init>((b.d.a0.b.e)localObject2, paramd, paramString1);
              localObject3 = ((q)localObject3).E(locall);
              localObject2 = new com/tplink/libtpstreamclientmanager/e;
              ((e)localObject2).<init>(paramd, paramString1);
              ((q)localObject3).C((io.reactivex.g0.g)localObject2).F0();
            }
          }
        }
        B0(paramString1);
        T(paramString1, paramInt, paramString2, ((b.d.a0.b.f)localObject1).d(), paramLong1, paramLong2, paramd);
        paramd.f(paramString1, paramLong1);
      }
      else
      {
        paramd.d(paramString1, false);
      }
      return;
    }
    finally {}
  }
  
  public void G0(String paramString1, String paramString2, long paramLong1, long paramLong2, b.d.a0.b.d paramd)
  {
    try
    {
      Object localObject1 = (b.d.a0.b.f)this.f.get(paramString1);
      if (localObject1 != null)
      {
        Object localObject3;
        if (((b.d.a0.b.f)localObject1).h() != null)
        {
          localObject2 = ((b.d.a0.b.f)localObject1).h().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (b.d.a0.b.e)((Iterator)localObject2).next();
            if ((localObject3 != null) && (((b.d.a0.b.e)localObject3).m()))
            {
              m = 1;
              break label86;
            }
          }
        }
        int m = 0;
        label86:
        Object localObject2 = a0(paramString1);
        if (m != 0)
        {
          ((b.d.a0.b.f)localObject1).o(paramString2);
          localObject1 = ((b.d.a0.b.f)localObject1).h().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            Object localObject4 = (b.d.a0.b.e)((Iterator)localObject1).next();
            if (localObject4 != null)
            {
              ((b.d.a0.b.e)localObject4).u();
              q localq = ((o)localObject2).d((b.d.i.a.a.f)localObject4, paramString1, paramString2, paramLong1, paramLong2);
              localObject3 = new com/tplink/libtpstreamclientmanager/d;
              ((d)localObject3).<init>((b.d.a0.b.e)localObject4, paramString2, paramd, paramString1);
              localObject4 = localq.E((io.reactivex.g0.g)localObject3);
              localObject3 = new com/tplink/libtpstreamclientmanager/g;
              ((g)localObject3).<init>(paramd, paramString1);
              ((q)localObject4).C((io.reactivex.g0.g)localObject3).F0();
            }
          }
        }
        paramd.e(paramString1, false, 1.0F);
      }
      return;
    }
    finally {}
  }
  
  public void H0(String paramString)
  {
    paramString = (b.d.v.b.b)this.g.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.b();
      if (paramString != null) {
        paramString.B();
      }
    }
  }
  
  public void I0(String paramString)
  {
    if ((paramString != null) && (paramString.equals(this.j)) && (this.g.get(paramString) != null)) {
      this.j = null;
    }
  }
  
  public void J0(String paramString)
  {
    paramString = (b.d.v.b.b)this.g.get(paramString);
    if (paramString != null)
    {
      paramString = paramString.b();
      if (paramString != null) {
        paramString.C();
      }
    }
  }
  
  public void O()
  {
    b.d.p.d.a(this.b, "destroy");
    z0();
    D0();
    t0();
    B();
    v0();
    D();
    a = null;
    Handler localHandler = this.l;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.l = null;
    }
  }
  
  public void P(String paramString1, b.d.v.b.c paramc, String paramString2)
  {
    b.d.v.b.b localb = (b.d.v.b.b)this.g.get(paramString1);
    if (localb == null)
    {
      G(paramString1, paramc, paramString2);
    }
    else if (localb.b() == null)
    {
      localb.c(null);
      this.g.remove(paramString1);
      G(paramString1, paramc, paramString2);
    }
  }
  
  public void Q(String paramString1, int paramInt1, int paramInt2, String paramString2, b.d.m.b.a parama)
  {
    b.d.m.b.c localc = (b.d.m.b.c)this.h.get(paramString1);
    if (localc == null)
    {
      J(paramString1, paramInt1, paramInt2, paramString2, parama);
    }
    else
    {
      localc.l(paramString2);
      localc.k(paramInt2);
      localc.h(paramInt1);
      o localo = U(paramString1);
      b.d.m.b.b localb = localc.e();
      if ((localb != null) && (localo != null))
      {
        paramString2 = localo.F(localb, paramString1, paramInt1, paramInt2, paramString2).E(new f(this, localb, paramString2, paramInt2, paramString1, parama)).C(new h(this, paramString1, localb, parama, localc)).F0();
        localc.a(paramString1, localb.a(), paramString2);
      }
      else if (parama != null)
      {
        parama.b(paramString1, paramString2, paramInt2, new Exception("no available connection"));
      }
    }
  }
  
  public void R(String paramString, b.d.o.b.c paramc, BitStreamType paramBitStreamType)
  {
    try
    {
      if (this.e.get(paramString) == null)
      {
        W(paramString).E();
        b.d.o.b.e locale = new b/d/o/b/e;
        locale.<init>();
        locale.j(paramc);
        this.e.put(paramString, locale);
        b.d.o.a.f.m().k(paramString, paramBitStreamType);
        b.d.p.d.a(this.b, "调用Connection层，尝试获取端口号，建立直播视频连接");
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void S(String paramString, byte[] paramArrayOfByte)
  {
    F0(paramString, paramArrayOfByte);
  }
  
  public void T(String paramString1, int paramInt, String paramString2, int[] paramArrayOfInt, long paramLong1, long paramLong2, b.d.a0.b.d paramd)
  {
    if (paramLong1 <= 0L) {
      return;
    }
    try
    {
      if ((b.d.a0.b.f)this.f.get(paramString1) == null)
      {
        a0(paramString1).E();
        b.d.a0.b.f localf = new b/d/a0/b/f;
        localf.<init>();
        localf.r(paramd);
        localf.p(paramLong1);
        localf.k(paramInt);
        localf.o(paramString2);
        localf.m(paramArrayOfInt);
        localf.q(paramLong1);
        localf.l(paramLong2);
        this.f.put(paramString1, localf);
        b.d.a0.a.f.c().b(paramString1, paramLong1, paramLong2);
      }
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public o U(String paramString)
  {
    return X("download", paramString);
  }
  
  public o W(String paramString)
  {
    return X("live", paramString);
  }
  
  public List<b.d.a0.b.e> Z(String paramString)
  {
    paramString = (b.d.a0.b.f)this.f.get(paramString);
    if (paramString != null) {
      return paramString.h();
    }
    return null;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    StatisticsStreamType localStatisticsStreamType;
    if (paramInt1 == 1) {
      try
      {
        localStatisticsStreamType = StatisticsStreamType.MIXED;
      }
      finally
      {
        break label377;
      }
    } else if (paramInt1 == 3) {
      localStatisticsStreamType = StatisticsStreamType.VIDEO;
    } else {
      localStatisticsStreamType = StatisticsStreamType.AUDIO;
    }
    if (16 == paramInt2) {
      b.d.o.a.f.m().w(paramString, true);
    }
    b.d.o.b.e locale = (b.d.o.b.e)this.e.get(paramString);
    if (locale != null)
    {
      locale.h();
      Object localObject1 = locale.e();
      if (localObject1 != null)
      {
        paramInt1 = 0;
        Object localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          b.d.o.b.d locald = (b.d.o.b.d)((Iterator)localObject2).next();
          if (locald.a() < paramInt2)
          {
            locald.p();
            locale.d(paramString, locald.a());
            ((Iterator)localObject2).remove();
            b.d.o.a.f.m().j(paramString, locald.a());
            Object localObject3 = StatisticsManager.getInstance().getOnceConnectionCacheKey(locald.b(), localStatisticsStreamType, locald.a());
            localObject3 = StatisticsManager.getInstance().getOnceConnectionVO((String)localObject3);
            if ((localObject3 != null) && (paramInt2 == 16) && (locald.a() == 0)) {
              ((OnceConnectionVO)localObject3).setStopReason(StopReason.RELAY_TO_P2P.value());
            }
          }
          else if ((locald.a() > paramInt2) && (locald.d()))
          {
            paramInt1 = 1;
          }
        }
        if (paramInt1 != 0)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (b.d.o.b.d)((Iterator)localObject1).next();
            if (((b.d.i.a.a.f)localObject2).a() == paramInt2)
            {
              ((b.d.o.b.d)localObject2).p();
              locale.d(paramString, ((b.d.i.a.a.f)localObject2).a());
              ((Iterator)localObject1).remove();
              b.d.o.a.f.m().j(paramString, paramInt2);
              localObject2 = StatisticsManager.getInstance().getOnceConnectionCacheKey(((b.d.i.a.a.f)localObject2).b(), localStatisticsStreamType, paramInt2);
              localObject2 = StatisticsManager.getInstance().getOnceConnectionVO((String)localObject2);
              if ((localObject2 != null) && (paramInt2 == 0)) {
                ((OnceConnectionVO)localObject2).setStopReason(StopReason.RELAY_TO_P2P.value());
              }
            }
          }
        }
      }
    }
    return;
    label377:
    throw paramString;
  }
  
  public o a0(String paramString)
  {
    return X("vod", paramString);
  }
  
  public void b(b.d.m.a.a parama)
  {
    if (parama != null)
    {
      String str = parama.getDeviceIdMD5();
      b.d.m.b.c localc = (b.d.m.b.c)this.h.get(str);
      if (localc != null)
      {
        b.d.m.b.a locala = localc.d();
        b.d.m.b.b localb = localc.e();
        if (localb != null) {
          localb.p();
        }
        localc.b();
        if (locala != null) {
          I(parama, localc, str);
        } else {
          this.d.p(str);
        }
      }
    }
  }
  
  public boolean b0(String paramString)
  {
    try
    {
      paramString = this.f.get(paramString);
      boolean bool;
      if (paramString != null) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void c(String paramString, int paramInt, Exception paramException)
  {
    if (paramInt == 17) {
      b.d.t.e.e.l(paramString, Status.unknown);
    }
    if (16 == paramInt) {
      this.d.g(paramString);
    }
    paramString = (b.d.m.b.c)this.h.remove(paramString);
    if (paramString != null)
    {
      paramException = paramString.e();
      if (paramException != null) {
        paramException.p();
      }
      paramString.b();
      paramString.j(null);
    }
  }
  
  public void c0(String paramString)
  {
    if ((paramString != null) && (this.g.get(paramString) != null)) {
      this.j = paramString;
    }
  }
  
  public void d(List<b.d.o.a.d> paramList)
  {
    if (paramList != null)
    {
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = (b.d.o.a.d)localIterator.next();
        int m = ((BaseConnection)localObject1).getConnectionType();
        if (((BaseConnection)localObject1).getStreamType() == 1) {
          paramList = StatisticsStreamType.MIXED;
        } else if (((BaseConnection)localObject1).getStreamType() == 3) {
          paramList = StatisticsStreamType.VIDEO;
        } else {
          paramList = StatisticsStreamType.AUDIO;
        }
        Object localObject2 = StatisticsManager.getInstance().getConnectionInfoCacheKey(((BaseConnection)localObject1).getDeviceIdMD5(), paramList);
        Object localObject3 = StatisticsManager.getInstance().getConnectionInfoVO((String)localObject2);
        paramList = (List<b.d.o.a.d>)localObject3;
        if (localObject3 == null)
        {
          paramList = new ConnectionInfoVO();
          StatisticsManager.getInstance().insertConnectionInfoVO((String)localObject2, paramList);
        }
        localObject3 = ((BaseConnection)localObject1).getStatistics();
        if (localObject3 != null)
        {
          localObject1 = ((List)localObject3).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (NatStatistics)((Iterator)localObject1).next();
            localObject3 = new OnceConnectionVO();
            ((OnceConnectionVO)localObject3).setSuccess(((NatStatistics)localObject2).getFailureReason());
            ((OnceConnectionVO)localObject3).setTraverseTime(Math.round((float)((NatStatistics)localObject2).getPenetrationTime() / 1000.0F));
            ((OnceConnectionVO)localObject3).setStopReason(-1);
            if (m == 16) {
              paramList.getP2pConnectionVO().addData((OnceConnectionVO)localObject3);
            } else if (m == 0) {
              paramList.getRelayConnectionVO().addData((OnceConnectionVO)localObject3);
            }
          }
        }
      }
    }
  }
  
  public void e(b.d.m.a.a parama) {}
  
  public void f(String paramString)
  {
    String str = this.b;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("设备：");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" onLiveConnectionFailure()");
    b.d.p.d.a(str, ((StringBuilder)localObject).toString());
    localObject = (b.d.o.b.e)this.e.get(paramString);
    if (localObject == null) {
      return;
    }
    ((b.d.o.b.e)localObject).f().b(paramString, new Exception("Live Connection Failure!"));
  }
  
  public void g(String paramString, int paramInt, Exception paramException)
  {
    if (paramInt == 17) {
      b.d.t.e.e.l(paramString, Status.unknown);
    }
    if (16 == paramInt) {
      this.c.e(paramString);
    }
    paramException = (b.d.v.b.b)this.g.remove(paramString);
    if (paramException != null)
    {
      paramString = paramException.b();
      if (paramString != null) {
        paramString.p();
      }
      paramException.c(null);
    }
  }
  
  public void h(b.d.v.a.a parama)
  {
    if (parama != null)
    {
      Object localObject1 = parama.getDeviceIdMD5();
      Object localObject2 = (b.d.v.b.b)this.g.get(localObject1);
      if (localObject2 != null)
      {
        Object localObject3 = ((b.d.v.b.b)localObject2).a();
        Object localObject4 = ((b.d.v.b.b)localObject2).b();
        if (localObject4 != null) {
          ((b.d.v.b.d)localObject4).p();
        }
        if (localObject3 != null)
        {
          H(parama, (b.d.v.b.b)localObject2, (String)localObject1);
          localObject3 = StatisticsManager.getInstance();
          localObject4 = parama.getDeviceIdMD5();
          localObject1 = StatisticsStreamType.DOUBLE_TALK;
          localObject2 = ((StatisticsManager)localObject3).getConnectionInfoCacheKey((String)localObject4, (StatisticsStreamType)localObject1);
          localObject3 = StatisticsManager.getInstance().getConnectionInfoVO((String)localObject2);
          localObject4 = localObject3;
          if (localObject3 == null)
          {
            localObject4 = new ConnectionInfoVO();
            StatisticsManager.getInstance().insertConnectionInfoVO((String)localObject2, (ConnectionInfoVO)localObject4);
          }
          localObject3 = parama.getStatistics();
          if (localObject3 != null)
          {
            localObject1 = ((List)localObject3).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (NatStatistics)((Iterator)localObject1).next();
              localObject3 = new OnceConnectionVO();
              int m = ((NatStatistics)localObject2).getFailureReason();
              ((OnceConnectionVO)localObject3).setSuccess(m);
              ((OnceConnectionVO)localObject3).setTraverseTime(Math.round((float)((NatStatistics)localObject2).getPenetrationTime() / 1000.0F));
              if (m != 0)
              {
                ((OnceConnectionVO)localObject3).setStopReason(-1);
                if (parama.getConnectionType() == 16) {
                  ((ConnectionInfoVO)localObject4).getP2pConnectionVO().addData((OnceConnectionVO)localObject3);
                } else if (parama.getConnectionType() == 0) {
                  ((ConnectionInfoVO)localObject4).getRelayConnectionVO().addData((OnceConnectionVO)localObject3);
                }
              }
              else
              {
                localObject2 = StatisticsManager.getInstance().getOnceConnectionCacheKey(parama.getDeviceIdMD5(), StatisticsStreamType.DOUBLE_TALK, parama.getConnectionType());
                StatisticsManager.getInstance().insertOnceConnectionVO((String)localObject2, (OnceConnectionVO)localObject3);
              }
            }
          }
          if (parama.getConnectionType() == 256)
          {
            localObject4 = new OnceConnectionVO();
            ((OnceConnectionVO)localObject4).setSuccess(0);
            ((OnceConnectionVO)localObject4).setTraverseTime(0);
            parama = StatisticsManager.getInstance().getOnceConnectionCacheKey(parama.getDeviceIdMD5(), (StatisticsStreamType)localObject1, parama.getConnectionType());
            StatisticsManager.getInstance().insertOnceConnectionVO(parama, (OnceConnectionVO)localObject4);
          }
        }
        else
        {
          this.c.n((String)localObject1);
        }
      }
    }
  }
  
  public void i(String paramString, int paramInt)
  {
    if (16 == paramInt) {}
    try
    {
      b.d.a0.a.f.c().j(paramString, true);
      Object localObject1 = (b.d.a0.b.f)this.f.get(paramString);
      if (localObject1 != null)
      {
        ((b.d.a0.b.f)localObject1).j();
        List localList = ((b.d.a0.b.f)localObject1).h();
        if (localList != null)
        {
          int m = 0;
          localObject1 = localList.iterator();
          Object localObject2;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (b.d.a0.b.e)((Iterator)localObject1).next();
            if (((b.d.i.a.a.f)localObject2).a() < paramInt)
            {
              ((b.d.a0.b.e)localObject2).s();
              ((Iterator)localObject1).remove();
              b.d.a0.a.f.c().g(paramString, ((b.d.i.a.a.f)localObject2).a());
              Object localObject3 = StatisticsManager.getInstance().getOnceConnectionCacheKey(((b.d.i.a.a.f)localObject2).b(), StatisticsStreamType.SD_VOD, ((b.d.i.a.a.f)localObject2).a());
              localObject3 = StatisticsManager.getInstance().getOnceConnectionVO((String)localObject3);
              if ((localObject3 != null) && (paramInt == 16) && (((b.d.i.a.a.f)localObject2).a() == 0)) {
                ((OnceConnectionVO)localObject3).setStopReason(StopReason.RELAY_TO_P2P.value());
              }
            }
            else if ((((b.d.i.a.a.f)localObject2).a() > paramInt) && (((b.d.i.a.a.f)localObject2).d()))
            {
              m = 1;
            }
          }
          if (m != 0)
          {
            localObject1 = localList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (b.d.a0.b.e)((Iterator)localObject1).next();
              if (((b.d.i.a.a.f)localObject2).a() == paramInt)
              {
                ((b.d.a0.b.e)localObject2).s();
                ((Iterator)localObject1).remove();
                b.d.a0.a.f.c().g(paramString, paramInt);
                localObject2 = StatisticsManager.getInstance().getOnceConnectionCacheKey(((b.d.i.a.a.f)localObject2).b(), StatisticsStreamType.SD_VOD, paramInt);
                localObject2 = StatisticsManager.getInstance().getOnceConnectionVO((String)localObject2);
                if ((localObject2 != null) && (paramInt == 0)) {
                  ((OnceConnectionVO)localObject2).setStopReason(StopReason.RELAY_TO_P2P.value());
                }
              }
            }
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public void j(String paramString)
  {
    Object localObject = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("设备：");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" onVodConnectionFailure()");
    b.d.p.d.a((String)localObject, localStringBuilder.toString());
    localObject = this.b;
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("onVodVideoConnectionFailure ");
    localStringBuilder.append(paramString);
    b.d.p.d.c((String)localObject, localStringBuilder.toString());
    localObject = (b.d.a0.b.f)this.f.get(paramString);
    if (localObject == null) {
      return;
    }
    ((b.d.a0.b.f)localObject).g().b(paramString, new Exception("VOD Connection Failure!"));
  }
  
  public void k(List<b.d.o.a.d> paramList)
  {
    b.d.p.d.a(this.b, "Connection层直播穿透成功！");
    if ((paramList != null) && (paramList.size() > 0))
    {
      String str = ((b.d.o.a.d)paramList.get(0)).getDeviceIdMD5();
      b.d.o.b.e locale = (b.d.o.b.e)this.e.get(str);
      if (locale == null) {
        return;
      }
      b.d.o.b.c localc = locale.f();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        b.d.o.a.d locald = (b.d.o.a.d)localIterator.next();
        int m = locald.getConnectionType();
        paramList = this.b;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("设备：");
        ((StringBuilder)localObject1).append(str);
        ((StringBuilder)localObject1).append(" connectionType ");
        ((StringBuilder)localObject1).append(m);
        b.d.p.d.a(paramList, ((StringBuilder)localObject1).toString());
        if (locald.getStreamType() == 1) {
          paramList = StatisticsStreamType.MIXED;
        } else if (locald.getStreamType() == 3) {
          paramList = StatisticsStreamType.VIDEO;
        } else {
          paramList = StatisticsStreamType.AUDIO;
        }
        Object localObject2 = StatisticsManager.getInstance().getConnectionInfoCacheKey(locald.getDeviceIdMD5(), paramList);
        Object localObject3 = StatisticsManager.getInstance().getConnectionInfoVO((String)localObject2);
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          localObject1 = new ConnectionInfoVO();
          StatisticsManager.getInstance().insertConnectionInfoVO((String)localObject2, (ConnectionInfoVO)localObject1);
        }
        localObject3 = locald.getStatistics();
        if (localObject3 != null)
        {
          localObject2 = ((List)localObject3).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject4 = (NatStatistics)((Iterator)localObject2).next();
            localObject3 = new OnceConnectionVO();
            int n = ((NatStatistics)localObject4).getFailureReason();
            ((OnceConnectionVO)localObject3).setSuccess(n);
            ((OnceConnectionVO)localObject3).setTraverseTime(Math.round((float)((NatStatistics)localObject4).getPenetrationTime() / 1000.0F));
            if (n != 0)
            {
              ((OnceConnectionVO)localObject3).setStopReason(-1);
              if (m == 16) {
                ((ConnectionInfoVO)localObject1).getP2pConnectionVO().addData((OnceConnectionVO)localObject3);
              } else if (m == 0) {
                ((ConnectionInfoVO)localObject1).getRelayConnectionVO().addData((OnceConnectionVO)localObject3);
              }
            }
            else
            {
              localObject4 = StatisticsManager.getInstance().getOnceConnectionCacheKey(locald.getDeviceIdMD5(), paramList, m);
              StatisticsManager.getInstance().insertOnceConnectionVO((String)localObject4, (OnceConnectionVO)localObject3);
            }
          }
        }
        if (localc != null) {
          if ((16 == locald.getConnectionType()) && (b.d.d.d.c.m(str))) {
            L(locald, locale, str);
          } else {
            K(locald, locale, str);
          }
        }
      }
      Object localObject1 = this.b;
      paramList = new StringBuilder();
      paramList.append("设备：");
      paramList.append(str);
      paramList.append(" onLiveConnectionSuccess()");
      b.d.p.d.a((String)localObject1, paramList.toString());
    }
  }
  
  public void l(b.d.a0.a.d paramd)
  {
    if (paramd != null)
    {
      int m = paramd.getConnectionType();
      Object localObject1 = StatisticsManager.getInstance().getConnectionInfoCacheKey(paramd.getDeviceIdMD5(), StatisticsStreamType.SD_VOD);
      Object localObject2 = StatisticsManager.getInstance().getConnectionInfoVO((String)localObject1);
      Object localObject3 = localObject2;
      if (localObject2 == null)
      {
        localObject3 = new ConnectionInfoVO();
        StatisticsManager.getInstance().insertConnectionInfoVO((String)localObject1, (ConnectionInfoVO)localObject3);
      }
      paramd = paramd.getStatistics();
      if (paramd != null)
      {
        paramd = paramd.iterator();
        while (paramd.hasNext())
        {
          localObject1 = (NatStatistics)paramd.next();
          localObject2 = new OnceConnectionVO();
          ((OnceConnectionVO)localObject2).setSuccess(((NatStatistics)localObject1).getFailureReason());
          ((OnceConnectionVO)localObject2).setTraverseTime(Math.round((float)((NatStatistics)localObject1).getPenetrationTime() / 1000.0F));
          ((OnceConnectionVO)localObject2).setStopReason(-1);
          if (m == 16) {
            ((ConnectionInfoVO)localObject3).getP2pConnectionVO().addData((OnceConnectionVO)localObject2);
          } else if (m == 0) {
            ((ConnectionInfoVO)localObject3).getRelayConnectionVO().addData((OnceConnectionVO)localObject2);
          }
        }
      }
    }
  }
  
  public void m(String paramString, int paramInt, boolean paramBoolean, Exception paramException)
  {
    if (paramInt == 17) {
      try
      {
        b.d.t.e.e.l(paramString, Status.unknown);
      }
      finally
      {
        break label354;
      }
    }
    if (16 == paramInt) {
      b.d.a0.a.f.c().j(paramString, false);
    }
    b.d.a0.b.f localf = (b.d.a0.b.f)this.f.get(paramString);
    if (localf != null)
    {
      Object localObject1 = localf.h();
      Object localObject2;
      if (localObject1 != null)
      {
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (b.d.a0.b.e)((Iterator)localObject2).next();
          if (((b.d.i.a.a.f)localObject3).a() == paramInt)
          {
            ((b.d.a0.b.e)localObject3).s();
            ((Iterator)localObject2).remove();
            b.d.a0.a.f.c().g(paramString, paramInt);
            localObject3 = StatisticsManager.getInstance().getOnceConnectionCacheKey(((b.d.i.a.a.f)localObject3).b(), StatisticsStreamType.SD_VOD, ((b.d.i.a.a.f)localObject3).a());
            localObject3 = StatisticsManager.getInstance().getOnceConnectionVO((String)localObject3);
            if (localObject3 != null) {
              ((OnceConnectionVO)localObject3).setStopReason(StopReason.NETWORK_ERROR.value());
            }
          }
        }
      }
      if ((paramBoolean) || (17 == paramInt))
      {
        if (!localf.i())
        {
          localObject1 = localf.g();
          if (localObject1 != null)
          {
            paramException = new java/lang/Exception;
            paramException.<init>("vod stream create failed");
            ((b.d.a0.b.d)localObject1).b(paramString, paramException);
          }
          return;
        }
        localf.n(false);
        if ((paramException.getMessage() != null) && (paramException.getMessage().contains("unknown_psk_identity")))
        {
          localObject2 = b.d.t.e.e.k(paramString).L0(io.reactivex.l0.a.c());
          paramException = new com/tplink/libtpstreamclientmanager/m$e;
          paramException.<init>(this, (List)localObject1, paramString);
          ((q)localObject2).z(paramException).F0();
        }
        else if ((localObject1 == null) || (((List)localObject1).size() == 0))
        {
          paramException = this.l;
          if (paramException != null)
          {
            localObject1 = new com/tplink/libtpstreamclientmanager/m$f;
            ((f)localObject1).<init>(this, paramString);
            paramException.postDelayed((Runnable)localObject1, 3000L);
          }
        }
      }
    }
    return;
    label354:
    throw paramString;
  }
  
  public void n(List<b.d.m.a.a> paramList)
  {
    b.d.m.a.a locala = (b.d.m.a.a)paramList.get(0);
    b.d.m.b.c localc = (b.d.m.b.c)this.h.get(locala.getDeviceIdMD5());
    if (localc != null)
    {
      paramList = localc.d();
      if (paramList != null) {
        paramList.b(locala.getDeviceIdMD5(), localc.g(), localc.f(), new Exception("ConnectionFailure"));
      }
    }
  }
  
  public void o(String paramString, int paramInt)
  {
    if (16 == paramInt) {
      this.c.g(paramString);
    }
  }
  
  public void p(b.d.v.a.a parama)
  {
    int m = parama.getConnectionType();
    Object localObject1 = StatisticsManager.getInstance().getConnectionInfoCacheKey(parama.getDeviceIdMD5(), StatisticsStreamType.DOUBLE_TALK);
    Object localObject2 = StatisticsManager.getInstance().getConnectionInfoVO((String)localObject1);
    Object localObject3 = localObject2;
    if (localObject2 == null)
    {
      localObject3 = new ConnectionInfoVO();
      StatisticsManager.getInstance().insertConnectionInfoVO((String)localObject1, (ConnectionInfoVO)localObject3);
    }
    localObject2 = parama.getStatistics();
    if (localObject2 != null)
    {
      Iterator localIterator = ((List)localObject2).iterator();
      while (localIterator.hasNext())
      {
        localObject2 = (NatStatistics)localIterator.next();
        localObject1 = new OnceConnectionVO();
        ((OnceConnectionVO)localObject1).setSuccess(((NatStatistics)localObject2).getFailureReason());
        ((OnceConnectionVO)localObject1).setTraverseTime(Math.round((float)((NatStatistics)localObject2).getPenetrationTime() / 1000.0F));
        if (parama.b() == 2) {
          ((OnceConnectionVO)localObject1).setStopReason(-1);
        } else {
          ((OnceConnectionVO)localObject1).setStopReason(0);
        }
        if (m == 16) {
          ((ConnectionInfoVO)localObject3).getP2pConnectionVO().addData((OnceConnectionVO)localObject1);
        } else if (m == 0) {
          ((ConnectionInfoVO)localObject3).getRelayConnectionVO().addData((OnceConnectionVO)localObject1);
        } else if (m == 256) {
          ((ConnectionInfoVO)localObject3).getLocalConnectionVO().addData((OnceConnectionVO)localObject1);
        }
      }
    }
  }
  
  public void q(b.d.a0.a.d paramd)
  {
    b.d.p.d.a(this.b, "Connection层VOD穿透成功！");
    if (paramd != null)
    {
      Object localObject1 = this.b;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onVodVideoConnectionSuccess");
      ((StringBuilder)localObject2).append(paramd.toString());
      b.d.p.d.c((String)localObject1, ((StringBuilder)localObject2).toString());
      localObject1 = paramd.getDeviceIdMD5();
      localObject2 = (b.d.a0.b.f)this.f.get(localObject1);
      if (localObject2 == null) {
        return;
      }
      if ((16 == paramd.getConnectionType()) && (b.d.d.d.c.m((String)localObject1))) {
        M(paramd, (b.d.a0.b.f)localObject2, (String)localObject1);
      } else {
        N(paramd, (b.d.a0.b.f)localObject2, (String)localObject1);
      }
      int m = paramd.getConnectionType();
      Object localObject3 = StatisticsManager.getInstance().getConnectionInfoCacheKey(paramd.getDeviceIdMD5(), StatisticsStreamType.SD_VOD);
      localObject2 = StatisticsManager.getInstance().getConnectionInfoVO((String)localObject3);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ConnectionInfoVO();
        StatisticsManager.getInstance().insertConnectionInfoVO((String)localObject3, (ConnectionInfoVO)localObject1);
      }
      localObject2 = paramd.getStatistics();
      if (localObject2 != null)
      {
        localObject3 = ((List)localObject2).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject4 = (NatStatistics)((Iterator)localObject3).next();
          localObject2 = new OnceConnectionVO();
          int n = ((NatStatistics)localObject4).getFailureReason();
          ((OnceConnectionVO)localObject2).setSuccess(n);
          ((OnceConnectionVO)localObject2).setTraverseTime(Math.round((float)((NatStatistics)localObject4).getPenetrationTime() / 1000.0F));
          if (n != 0)
          {
            ((OnceConnectionVO)localObject2).setStopReason(-1);
            if (m == 16) {
              ((ConnectionInfoVO)localObject1).getP2pConnectionVO().addData((OnceConnectionVO)localObject2);
            } else if (m == 0) {
              ((ConnectionInfoVO)localObject1).getRelayConnectionVO().addData((OnceConnectionVO)localObject2);
            }
          }
          else
          {
            localObject4 = StatisticsManager.getInstance().getOnceConnectionCacheKey(paramd.getDeviceIdMD5(), StatisticsStreamType.SD_VOD, m);
            StatisticsManager.getInstance().insertOnceConnectionVO((String)localObject4, (OnceConnectionVO)localObject2);
          }
        }
      }
    }
  }
  
  public void q0()
  {
    s0("download");
  }
  
  public void r(String paramString, int paramInt)
  {
    if (16 == paramInt) {
      this.d.i(paramString);
    }
  }
  
  public void r0()
  {
    s0("live");
  }
  
  public void s(List<b.d.v.a.a> paramList)
  {
    paramList = (b.d.v.a.a)paramList.get(0);
    Object localObject = (b.d.v.b.b)this.g.get(paramList.getDeviceIdMD5());
    if (localObject != null)
    {
      localObject = ((b.d.v.b.b)localObject).a();
      if (localObject != null) {
        ((b.d.v.b.c)localObject).onDoubleTalkCreateFailure(paramList.getDeviceIdMD5(), paramList.b());
      }
    }
  }
  
  public void t(String paramString, int paramInt, boolean paramBoolean, Exception paramException)
  {
    if (paramInt == 17) {
      try
      {
        b.d.t.e.e.l(paramString, Status.unknown);
      }
      finally
      {
        break label409;
      }
    }
    if (16 == paramInt) {
      b.d.o.a.f.m().w(paramString, false);
    }
    b.d.o.b.e locale = (b.d.o.b.e)this.e.get(paramString);
    if (locale != null)
    {
      List localList = locale.e();
      Object localObject;
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          b.d.o.b.d locald = (b.d.o.b.d)localIterator.next();
          if (locald.a() == paramInt)
          {
            locald.p();
            locale.d(paramString, locald.a());
            localIterator.remove();
            F(locald, paramString);
            b.d.o.a.f.m().j(paramString, paramInt);
            if (locald.c() == 1) {
              localObject = StatisticsStreamType.MIXED;
            } else if (locald.c() == 3) {
              localObject = StatisticsStreamType.VIDEO;
            } else {
              localObject = StatisticsStreamType.AUDIO;
            }
            localObject = StatisticsManager.getInstance().getOnceConnectionCacheKey(locald.b(), (StatisticsStreamType)localObject, locald.a());
            localObject = StatisticsManager.getInstance().getOnceConnectionVO((String)localObject);
            if (localObject != null) {
              ((OnceConnectionVO)localObject).setStopReason(StopReason.NETWORK_ERROR.value());
            }
          }
        }
      }
      if ((paramBoolean) || (17 == paramInt))
      {
        if (!locale.g())
        {
          localObject = locale.f();
          if (localObject != null)
          {
            paramException = new java/lang/Exception;
            paramException.<init>("Create Live Stream Connection Failed");
            ((b.d.o.b.c)localObject).b(paramString, paramException);
          }
          return;
        }
        locale.i(false);
        if ((paramException.getMessage() != null) && (paramException.getMessage().contains("unknown_psk_identity")))
        {
          paramException = b.d.t.e.e.k(paramString).L0(io.reactivex.l0.a.c());
          localObject = new com/tplink/libtpstreamclientmanager/m$d;
          ((d)localObject).<init>(this, localList, paramString);
          paramException.z((io.reactivex.g0.a)localObject).F0();
        }
        else if ((localList == null) || (localList.size() == 0))
        {
          localObject = this.l;
          if (localObject != null)
          {
            paramException = new com/tplink/libtpstreamclientmanager/i;
            paramException.<init>(paramString);
            ((Handler)localObject).postDelayed(paramException, 3000L);
          }
        }
      }
    }
    return;
    label409:
    throw paramString;
  }
  
  public void t0()
  {
    this.c.m();
    Iterator localIterator = this.g.entrySet().iterator();
    while (localIterator.hasNext())
    {
      b.d.v.b.b localb = (b.d.v.b.b)((Map.Entry)localIterator.next()).getValue();
      b.d.v.b.d locald = localb.b();
      if (locald != null) {
        locald.p();
      }
      localb.c(null);
      localb.d(null);
    }
    this.g.clear();
  }
  
  public void u0(String paramString)
  {
    if ((paramString != null) && (!TextUtils.equals(paramString, this.j)))
    {
      b.d.v.b.b localb = (b.d.v.b.b)this.g.remove(paramString);
      if (localb != null)
      {
        b.d.v.b.d locald = localb.b();
        if (locald != null) {
          locald.p();
        }
        localb.c(null);
      }
      this.c.n(paramString);
    }
  }
  
  public void v0()
  {
    Iterator localIterator = this.h.entrySet().iterator();
    while (localIterator.hasNext())
    {
      b.d.m.b.c localc = (b.d.m.b.c)((Map.Entry)localIterator.next()).getValue();
      b.d.m.b.b localb = localc.e();
      if (localb != null) {
        localb.p();
      }
      localc.b();
      localc.i(null);
      localc.j(null);
    }
    this.d.o();
    this.h.clear();
  }
  
  public void w0(String paramString)
  {
    if (paramString == null) {
      return;
    }
    b.d.m.b.c localc = (b.d.m.b.c)this.h.remove(paramString);
    if (localc != null)
    {
      b.d.m.b.b localb = localc.e();
      if (localb != null) {
        localb.p();
      }
      localc.b();
      localc.j(null);
    }
    this.d.p(paramString);
  }
  
  public void x0(String paramString)
  {
    try
    {
      b.d.o.b.e locale = (b.d.o.b.e)this.e.remove(paramString);
      if (locale != null)
      {
        Object localObject = locale.e();
        if (localObject != null)
        {
          Iterator localIterator = ((List)localObject).iterator();
          while (localIterator.hasNext())
          {
            localObject = (b.d.o.b.d)localIterator.next();
            if (localObject != null) {
              ((b.d.o.b.d)localObject).p();
            }
            if (!paramString.equals(this.j)) {
              F((b.d.o.b.d)localObject, paramString);
            }
          }
        }
        locale.c();
        locale.h();
        locale.j(null);
      }
      b.d.o.a.f.m().i(paramString);
      return;
    }
    finally {}
  }
  
  public void y0(String paramString)
  {
    paramString = (o)this.i.remove(Y("live", paramString));
    if (paramString != null) {
      paramString.E();
    }
  }
  
  public void z0()
  {
    try
    {
      b.d.p.d.a(this.b, "整个APP的Live Stream被销毁");
      Iterator localIterator1 = this.e.entrySet().iterator();
      while (localIterator1.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator1.next();
        List localList = ((b.d.o.b.e)localEntry.getValue()).e();
        if (localList != null)
        {
          Iterator localIterator2 = localList.iterator();
          while (localIterator2.hasNext())
          {
            b.d.o.b.d locald = (b.d.o.b.d)localIterator2.next();
            if (locald != null) {
              locald.p();
            }
            F(locald, (String)localEntry.getKey());
          }
          localList.clear();
          b.d.o.a.f.m().i((String)localEntry.getKey());
        }
        ((b.d.o.b.e)localEntry.getValue()).c();
        ((b.d.o.b.e)localEntry.getValue()).h();
      }
      this.e.clear();
      return;
    }
    finally {}
  }
  
  class a
    implements ThreadFactory
  {
    private final AtomicInteger c = new AtomicInteger(0);
    
    a() {}
    
    public Thread newThread(@NonNull Runnable paramRunnable)
    {
      paramRunnable = new Thread(paramRunnable);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pool-StreamManager.executorService-");
      localStringBuilder.append(this.c.incrementAndGet());
      paramRunnable.setName(localStringBuilder.toString());
      return paramRunnable;
    }
  }
  
  class b
    implements d.a
  {
    b(b.d.v.b.c paramc, b.d.v.a.a parama) {}
    
    public void a()
    {
      localc.onDoubleTalkCreateSuccess(parama.getDeviceIdMD5());
    }
    
    public void b(int paramInt)
    {
      NatStatistics localNatStatistics;
      if (paramInt == -52411)
      {
        localc.onDoubleTalkCreateFailure(parama.getDeviceIdMD5(), 1);
        m.u(m.this).n(parama.getDeviceIdMD5());
        localNatStatistics = new NatStatistics();
        localNatStatistics.setPenetrationTime(0L);
        localNatStatistics.setFailureReason(-1);
        parama.getStatistics().add(localNatStatistics);
      }
      else
      {
        localc.onDoubleTalkCreateFailure(parama.getDeviceIdMD5(), 2);
        m.u(m.this).n(parama.getDeviceIdMD5());
        localNatStatistics = new NatStatistics();
        localNatStatistics.setPenetrationTime(0L);
        localNatStatistics.setFailureReason(-1);
        parama.getStatistics().add(localNatStatistics);
      }
    }
  }
  
  class c
    implements b.a
  {
    c(String paramString, b.d.m.b.b paramb, b.d.m.b.a parama, b.d.m.b.c paramc) {}
    
    public void a() {}
    
    public void b(int paramInt)
    {
      m.v(m.this).remove(paramString);
      localb.p();
      m.w(m.this).p(paramString);
      b.d.m.b.a locala = locala;
      String str1 = paramString;
      String str2 = paramc.g();
      int i = paramc.f();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("error ");
      localStringBuilder.append(paramInt);
      locala.b(str1, str2, i, new Exception(localStringBuilder.toString()));
    }
  }
  
  class d
    implements io.reactivex.g0.a
  {
    d(List paramList, String paramString) {}
    
    public void run()
      throws Exception
    {
      List localList = this.a;
      if (((localList == null) || (localList.size() == 0)) && (m.x(m.this) != null)) {
        m.x(m.this).postDelayed(new b(this.b), 3000L);
      }
    }
  }
  
  class e
    implements io.reactivex.g0.a
  {
    e(List paramList, String paramString) {}
    
    public void run()
      throws Exception
    {
      Object localObject = this.a;
      if (((localObject == null) || (((List)localObject).size() == 0)) && ((b.d.a0.b.f)m.y(m.this).get(this.b) != null))
      {
        String str = m.z(m.this);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("设备： ");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append("VOD 重连！");
        b.d.p.d.a(str, ((StringBuilder)localObject).toString());
        b.d.a0.a.f.c().a(this.b);
      }
    }
  }
  
  class f
    implements Runnable
  {
    f(String paramString) {}
    
    public void run()
    {
      if ((b.d.a0.b.f)m.y(m.this).get(this.c) != null)
      {
        String str = m.z(m.this);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("设备： ");
        localStringBuilder.append(this.c);
        localStringBuilder.append("VOD 重连！");
        b.d.p.d.a(str, localStringBuilder.toString());
        b.d.a0.a.f.c().a(this.c);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpstreamclientmanager\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */