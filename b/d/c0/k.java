package b.d.c0;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkRequest.Builder;
import android.os.Build.VERSION;
import android.os.Process;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.tplink.tdp.bean.BaseTDPDevice;
import io.reactivex.q;
import io.reactivex.v;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.zip.CRC32;

public final class k
{
  private DatagramChannel a;
  private Selector b;
  private InetSocketAddress c;
  private com.tplink.tdp.common.b d;
  private io.reactivex.m0.g<BaseTDPDevice> e = io.reactivex.m0.d.n1();
  private io.reactivex.e0.b f = new io.reactivex.e0.b();
  private ConnectivityManager g;
  private boolean h;
  private Network i;
  private a j;
  private io.reactivex.m0.c k = io.reactivex.m0.c.M();
  
  public k(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, paramBoolean, null);
  }
  
  public k(Context paramContext, boolean paramBoolean, Network paramNetwork)
  {
    this.h = paramBoolean;
    this.i = paramNetwork;
    if (Build.VERSION.SDK_INT >= 22)
    {
      if ((paramBoolean) && (paramNetwork != null))
      {
        this.k.onComplete();
      }
      else if ((paramBoolean) && (paramContext != null) && (paramContext.checkPermission("android.permission.CHANGE_NETWORK_STATE", Process.myPid(), Process.myUid()) == 0))
      {
        paramContext = (ConnectivityManager)paramContext.getSystemService("connectivity");
        this.g = paramContext;
        if (paramContext != null)
        {
          paramContext = new NetworkRequest.Builder().addCapability(13).addTransportType(1).build();
          paramNetwork = new a(this);
          this.j = paramNetwork;
          try
          {
            this.g.requestNetwork(paramContext, paramNetwork);
          }
          catch (SecurityException paramContext)
          {
            this.k.onComplete();
          }
        }
        else
        {
          this.k.onComplete();
        }
      }
      else
      {
        this.k.onComplete();
      }
    }
    else {
      this.k.onComplete();
    }
  }
  
  private void A(long paramLong)
  {
    this.f.b(q.W0(paramLong, TimeUnit.MILLISECONDS).G0(new c(this)));
  }
  
  private <T extends BaseTDPDevice> void B(b.d.c0.l.b<T> paramb)
  {
    this.f.b(q.f0(paramb).L0(io.reactivex.l0.a.c()).y(new g(this)).H0(new h(this), new a(this)));
  }
  
  private <T extends BaseTDPDevice> void C(com.tplink.tdp.common.c<T> paramc, boolean paramBoolean)
  {
    io.reactivex.e0.b localb = this.f;
    io.reactivex.m0.c localc = this.k;
    TimeUnit localTimeUnit = TimeUnit.MILLISECONDS;
    localb.b(localc.D(300L, localTimeUnit).s().d(q.d0(0L, paramc.a(), 0L, paramc.c(), localTimeUnit).F(new e(this, paramc, paramBoolean))).I0(new d(this), new a(this), new b(this, paramc)));
  }
  
  private void E()
  {
    if (Build.VERSION.SDK_INT >= 22)
    {
      ConnectivityManager localConnectivityManager = this.g;
      if (localConnectivityManager != null)
      {
        a locala = this.j;
        if (locala != null)
        {
          localConnectivityManager.unregisterNetworkCallback(locala);
          this.j = null;
        }
      }
    }
  }
  
  private boolean F(com.tplink.tdp.common.b paramb, byte[] paramArrayOfByte, int paramInt)
  {
    int m = paramb.f();
    boolean bool = false;
    if (m <= 0) {
      return false;
    }
    m = paramb.d();
    System.arraycopy(b.d.w.e.a.c(1516993677), 0, paramArrayOfByte, 12, 4);
    int n = paramb.f() + 16;
    paramb = new byte[n];
    if (paramArrayOfByte.length < n) {
      return false;
    }
    System.arraycopy(paramArrayOfByte, paramInt, paramb, 0, n);
    paramArrayOfByte = new CRC32();
    paramArrayOfByte.update(paramb);
    if (m == (int)paramArrayOfByte.getValue()) {
      bool = true;
    }
    return bool;
  }
  
  private void c()
    throws IOException
  {
    b.d.w.c.a.c("TDP", "mDatagramChannel.close");
    Selector localSelector = this.b;
    if ((localSelector != null) && (localSelector.isOpen())) {
      this.b.close();
    }
    if (this.a.isOpen()) {
      this.a.close();
    }
    if ((!this.e.j1()) && (!this.e.k1())) {
      this.e.onComplete();
    }
  }
  
  private void e()
  {
    b.d.w.c.a.c("TDP", "handleTDPComplete");
    E();
    if ((!this.e.j1()) && (!this.e.k1())) {
      this.e.onComplete();
    }
    io.reactivex.e0.b localb = this.f;
    if (localb != null) {
      localb.d();
    }
  }
  
  private void f(Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleTDPException");
    localStringBuilder.append(paramThrowable.toString());
    b.d.w.c.a.c("TDP", localStringBuilder.toString());
    E();
    if ((!this.e.j1()) && (!this.e.k1())) {
      this.e.onError(paramThrowable);
    }
    paramThrowable = this.f;
    if (paramThrowable != null) {
      paramThrowable.d();
    }
  }
  
  private <T extends BaseTDPDevice> void g(b.d.c0.l.b<T> paramb)
    throws IOException
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate(8192);
    this.a.register(this.b, 1);
    while (this.b.select() > 0)
    {
      Iterator localIterator = this.b.selectedKeys().iterator();
      while (localIterator.hasNext())
      {
        if (((SelectionKey)localIterator.next()).isReadable())
        {
          b.d.w.c.a.c("TDP", "mDatagramChannel.receive");
          this.a.receive(localByteBuffer);
          z(localByteBuffer, paramb);
        }
        localIterator.remove();
      }
    }
  }
  
  private void h()
    throws IOException
  {
    b.d.w.c.a.c("TDP", "mDatagramChannel.send");
    this.a.send(ByteBuffer.wrap(this.d.e()), this.c);
  }
  
  private <T extends BaseTDPDevice> List<T> x(List<T> paramList, T paramT)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      BaseTDPDevice localBaseTDPDevice = (BaseTDPDevice)localIterator.next();
      if ((localBaseTDPDevice.getMac() != null) && (localBaseTDPDevice.getMac().equals(paramT.getMac()))) {
        paramList.remove(localBaseTDPDevice);
      }
    }
    paramList.add(paramT);
    return paramList;
  }
  
  private <T extends BaseTDPDevice> void y(com.tplink.tdp.common.c<T> paramc, boolean paramBoolean)
    throws IOException
  {
    b.d.w.c.a.c("TDP", "DatagramChannel.open");
    Object localObject1 = DatagramChannel.open();
    this.a = ((DatagramChannel)localObject1);
    ((DatagramChannel)localObject1).socket().setReuseAddress(true);
    this.a.socket().setSoTimeout(8000);
    this.a.configureBlocking(false);
    if ((Build.VERSION.SDK_INT >= 22) && (this.h))
    {
      localObject1 = this.i;
      if (localObject1 != null)
      {
        try
        {
          ((Network)localObject1).bindSocket(this.a.socket());
        }
        catch (SecurityException localSecurityException) {}catch (IOException localIOException) {}
        b.d.w.c.a.f("TDP", localIOException, "bindSocket", new Object[0]);
      }
    }
    this.c = new InetSocketAddress(paramc.g(), paramc.h());
    int m = 32;
    if (paramBoolean)
    {
      m = 16;
      this.a.socket().setBroadcast(true);
    }
    byte b1 = paramc.i();
    Object localObject2;
    if (b1 == 1) {
      localObject2 = new b.d.c0.l.c(paramc.f());
    } else {
      localObject2 = new b.d.c0.l.a(paramc.f());
    }
    this.d = new com.tplink.tdp.common.b(b1, paramc.d(), (byte)(m | 0x1), paramc.e());
    this.b = Selector.open();
    B((b.d.c0.l.b)localObject2);
  }
  
  private <T extends BaseTDPDevice> void z(ByteBuffer paramByteBuffer, b.d.c0.l.b<T> paramb)
  {
    byte[] arrayOfByte = paramByteBuffer.array();
    paramByteBuffer.flip();
    com.tplink.tdp.common.b localb;
    for (int m = 0; m < arrayOfByte.length; m = m + 16 + localb.f())
    {
      if (paramByteBuffer.remaining() < 16)
      {
        paramByteBuffer.compact();
        return;
      }
      localb = new com.tplink.tdp.common.b(paramByteBuffer);
      if (!F(localb, arrayOfByte, m))
      {
        paramByteBuffer.clear();
        return;
      }
      int n = localb.g();
      if ((localb.h() == this.d.h()) && (localb.i() == this.d.i()) && ((n == 0) || (n == 1)))
      {
        Object localObject = new byte[localb.f()];
        paramByteBuffer.get((byte[])localObject);
        localObject = paramb.a((byte[])localObject);
        if (localObject != null)
        {
          b.d.w.c.a.k("parseTdpPkt", localObject.toString());
          if ((!this.e.j1()) && (!this.e.k1())) {
            this.e.onNext(localObject);
          }
        }
      }
    }
    paramByteBuffer.compact();
  }
  
  public <T extends BaseTDPDevice> q<List<T>> D(@NonNull com.tplink.tdp.common.c<T> paramc)
  {
    return q.f0(paramc).N(new f(this)).e(paramc.f()).z0(new ArrayList(), new i(this)).y(new j(this));
  }
  
  public Network d()
  {
    return this.i;
  }
  
  @RequiresApi(api=21)
  static class a
    extends ConnectivityManager.NetworkCallback
  {
    private final k a;
    
    a(k paramk)
    {
      this.a = paramk;
    }
    
    public void onAvailable(Network paramNetwork)
    {
      super.onAvailable(paramNetwork);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("TDPNetworkCallback.");
      localStringBuilder.append(paramNetwork.toString());
      b.d.w.c.a.c("TDP", localStringBuilder.toString());
      k.a(this.a, paramNetwork);
      k.b(this.a).onComplete();
    }
    
    public void onLosing(Network paramNetwork, int paramInt)
    {
      super.onLosing(paramNetwork, paramInt);
    }
    
    public void onLost(Network paramNetwork)
    {
      super.onLost(paramNetwork);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\c0\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */