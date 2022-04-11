package b.d.d0;

import b.d.d0.f2.e;
import com.tplink.tmp.enumerate.EnumTMPAppV2PacketType;
import com.tplink.tmp.enumerate.EnumTMPBusinessLayerStatus;
import com.tplink.tmp.exception.TPGeneralNetworkException;
import io.reactivex.m0.g;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.zip.CRC32;

public class a2
  extends x1
{
  private int i = 3;
  private e j = new d(this);
  
  public a2(e2 parame2)
  {
    super((byte)1, (byte)2, parame2);
  }
  
  private short r()
  {
    try
    {
      int k = this.i;
      if (65535 == k)
      {
        this.i = 0;
        return -1;
      }
      this.i = (k + 1);
      short s = (short)k;
      return s;
    }
    finally {}
  }
  
  public void a()
  {
    super.a();
    e locale = this.j;
    if (locale != null)
    {
      locale.clear();
      this.j = null;
    }
  }
  
  public q<b.d.d0.i2.b> b()
  {
    if (this.d != EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_DISCONNECTED)
    {
      b localb = new b((short)1, r(), null, null);
      return this.j.a(localb).F(new d0(this)).g0(c0.c).E(new a0(this)).C(new x(this));
    }
    throw new RuntimeException("BusinessLayer can't be recycled!");
  }
  
  public q<e> n(b.d.d0.f2.d paramd)
  {
    if (this.d == EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_DISCONNECTED) {
      return q.f0(new e(this.g.a(), this.g.b()));
    }
    if (this.j == null) {
      return q.f0(new e(64320));
    }
    paramd = new b(paramd.a(), r(), paramd.b(), null);
    return this.e.Q0(1L).N(new w(this)).N(new b0(this, paramd)).g0(z.c).L0(io.reactivex.l0.a.c());
  }
  
  public q<b.d.d0.i2.a<b.d.d0.g2.d>> q(b.d.d0.g2.d paramd)
  {
    return super.q(paramd).g0(y.c);
  }
  
  private static class b
  {
    private short a;
    private short b;
    private LinkedBlockingQueue<b.d.d0.g2.d> c;
    private LinkedBlockingQueue<b.d.d0.g2.d> d = null;
    private final List<a2.f<b.d.d0.g2.d, b.d.d0.g2.d>> e = new ArrayList();
    private List<b.d.d0.g2.d> f = new ArrayList();
    private boolean g = false;
    private a2.c h = null;
    private boolean i = false;
    
    private b(short paramShort1, short paramShort2, byte[] paramArrayOfByte)
    {
      this.b = ((short)paramShort1);
      this.a = ((short)paramShort2);
      this.c = new LinkedBlockingQueue();
      Object localObject;
      int j;
      if ((paramArrayOfByte != null) && (paramArrayOfByte.length > 0))
      {
        localObject = new CRC32();
        ((CRC32)localObject).update(paramArrayOfByte);
        j = (int)((CRC32)localObject).getValue();
        paramShort2 = paramArrayOfByte.length / 8156 + 1;
        paramShort1 = 0;
      }
      while (paramShort1 < paramShort2)
      {
        int k = paramShort1 * 8156;
        if (paramShort1 == paramShort2 - 1) {
          localObject = new byte[paramArrayOfByte.length - k];
        } else {
          localObject = new byte['῜'];
        }
        System.arraycopy(paramArrayOfByte, k, localObject, 0, localObject.length);
        localObject = new b.d.d0.g2.d(new b.d.d0.g2.b((byte)1, (byte)2, this.b, (byte)2, (byte)0, this.a, j, paramArrayOfByte.length, k), (byte[])localObject);
        this.c.offer(localObject);
        paramShort1++;
        continue;
        paramArrayOfByte = new b.d.d0.g2.d(new b.d.d0.g2.b((byte)1, (byte)2, this.b, (byte)2, (byte)0, this.a, 0, 0, 0), null);
        this.c.offer(paramArrayOfByte);
      }
    }
    
    private b.d.d0.g2.d f()
    {
      boolean bool = this.c.isEmpty();
      b.d.d0.g2.d locald = null;
      Object localObject;
      if (!bool)
      {
        locald = (b.d.d0.g2.d)this.c.poll();
        localObject = locald;
        if (locald != null)
        {
          this.f.add(locald);
          localObject = new a2.f(locald, null);
          this.e.add(localObject);
          localObject = locald;
        }
      }
      for (;;)
      {
        break;
        LinkedBlockingQueue localLinkedBlockingQueue = this.d;
        localObject = locald;
        if (localLinkedBlockingQueue == null) {
          break;
        }
        localObject = locald;
        if (localLinkedBlockingQueue.isEmpty()) {
          break;
        }
        locald = (b.d.d0.g2.d)this.d.poll();
        localObject = locald;
        if (locald != null)
        {
          localObject = new a2.f(locald, null);
          this.e.add(localObject);
          localObject = locald;
        }
      }
      return (b.d.d0.g2.d)localObject;
    }
    
    private a2.c g(byte[] paramArrayOfByte, int paramInt)
    {
      CRC32 localCRC32 = new CRC32();
      localCRC32.update(paramArrayOfByte);
      if (paramInt != (int)localCRC32.getValue()) {
        return new a2.c(this.a, 64436, null);
      }
      return new a2.c(this.a, paramArrayOfByte, null);
    }
    
    private boolean h(b.d.d0.g2.d paramd)
    {
      b.d.d0.g2.b localb = (b.d.d0.g2.b)paramd.a();
      int j = localb.h() / 8156;
      int k = 0;
      if (j == 0)
      {
        paramd = paramd.b();
        if (paramd != null) {
          k = paramd.length;
        }
        if (k != localb.h())
        {
          this.h = new a2.c(this.a, 64321, null);
          this.g = true;
          return true;
        }
        this.h = g(paramd, localb.d());
        this.g = true;
        return true;
      }
      k = 0;
      while (k < j)
      {
        short s1 = this.b;
        short s2 = this.a;
        k++;
        paramd = new b.d.d0.g2.d(new b.d.d0.g2.b((byte)1, (byte)2, s1, (byte)4, (byte)0, s2, 0, 0, k * 8156), null);
        this.d.offer(paramd);
      }
      return false;
    }
    
    private void i(b.d.d0.i2.b paramb, b.d.d0.g2.d paramd1, b.d.d0.g2.d paramd2)
    {
      try
      {
        if (paramb.a() != 0)
        {
          paramd1 = new b/d/d0/a2$c;
          paramd1.<init>(this.a, paramb.a(), paramb.b(), null);
          this.h = paramd1;
          this.g = true;
          return;
        }
        paramb = (b.d.d0.g2.b)paramd2.a();
        if ((EnumTMPAppV2PacketType.TYPE_DATA_PULL_ACK == paramb.g()) && (this.f.size() == 1) && ((paramb.h() == 0) || ((paramd2.b() != null) && (paramd2.b().length == paramb.h()))))
        {
          this.h = g(paramd2.b(), paramb.d());
          this.g = true;
          return;
        }
        Object localObject1 = this.e.iterator();
        Object localObject2;
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (a2.f)((Iterator)localObject1).next();
          if (paramd1 == a2.f.a((a2.f)localObject2)) {
            a2.f.c((a2.f)localObject2, paramd2);
          }
        }
        localObject1 = EnumTMPAppV2PacketType.TYPE_DATA_PULL_ACK;
        paramd1 = paramb.g();
        int j = 0;
        if (localObject1 == paramd1)
        {
          if (this.d == null)
          {
            paramb = new java/util/concurrent/LinkedBlockingQueue;
            paramb.<init>();
            this.d = paramb;
            h(paramd2);
          }
          else
          {
            if ((this.i) && (h(paramd2))) {
              return;
            }
            if (!j())
            {
              paramd2 = this.e.iterator();
              while (paramd2.hasNext())
              {
                paramd1 = (a2.f)paramd2.next();
                if ((EnumTMPAppV2PacketType.TYPE_DATA_PULL == ((b.d.d0.g2.b)((b.d.d0.g2.d)a2.f.a(paramd1)).a()).g()) && (a2.f.b(paramd1) == null))
                {
                  j = 0;
                  break label313;
                }
              }
              j = 1;
              label313:
              if (j != 0)
              {
                int k = paramb.h();
                paramb = new byte[k];
                paramd1 = this.e.iterator();
                j = 0;
                while (paramd1.hasNext())
                {
                  paramd2 = (a2.f)paramd1.next();
                  localObject1 = (b.d.d0.g2.d)a2.f.a(paramd2);
                  localObject2 = (b.d.d0.g2.d)a2.f.b(paramd2);
                  if ((localObject2 != null) && (localObject1 != null))
                  {
                    paramd2 = (b.d.d0.g2.b)((b.d.d0.g2.d)localObject2).a();
                    if (EnumTMPAppV2PacketType.TYPE_DATA_PULL_ACK == paramd2.g())
                    {
                      localObject2 = ((b.d.d0.g2.d)localObject2).b();
                      int m;
                      if (localObject2 == null) {
                        m = 0;
                      } else {
                        m = localObject2.length;
                      }
                      m += j;
                      localObject1 = (b.d.d0.g2.b)((b.d.d0.g2.d)localObject1).a();
                      if ((m <= k) && ((EnumTMPAppV2PacketType.TYPE_DATA_PULL != ((b.d.d0.g2.b)localObject1).g()) || (((b.d.d0.g2.b)localObject1).i() == paramd2.i())))
                      {
                        if (localObject2 != null) {
                          System.arraycopy(localObject2, 0, paramb, j, localObject2.length);
                        }
                        j = m;
                      }
                      else
                      {
                        paramb = new b/d/d0/a2$c;
                        paramb.<init>(this.a, 64321, null);
                        this.h = paramb;
                        this.g = true;
                        return;
                      }
                    }
                  }
                }
                paramd1 = new b/d/d0/a2$c;
                paramd1.<init>(this.a, paramb, null);
                this.h = paramd1;
                this.g = true;
              }
            }
          }
        }
        else if (!j())
        {
          paramd1 = this.e.iterator();
          while (paramd1.hasNext())
          {
            paramb = (a2.f)paramd1.next();
            if ((EnumTMPAppV2PacketType.TYPE_DATA_PUSH == ((b.d.d0.g2.b)((b.d.d0.g2.d)a2.f.a(paramb)).a()).g()) && (a2.f.b(paramb) == null)) {
              break label635;
            }
          }
          j = 1;
          label635:
          if ((j != 0) && (this.d == null))
          {
            paramd1 = new b/d/d0/g2/b;
            paramd1.<init>((byte)1, (byte)2, this.b, (byte)4, (byte)0, this.a, 0, 0, 0);
            paramb = new b/d/d0/g2/d;
            paramb.<init>(paramd1, null);
            paramd1 = new java/util/concurrent/LinkedBlockingQueue;
            paramd1.<init>();
            this.d = paramd1;
            paramd1.offer(paramb);
            this.i = true;
          }
        }
        return;
      }
      finally {}
    }
    
    private boolean j()
    {
      if (this.c.isEmpty())
      {
        LinkedBlockingQueue localLinkedBlockingQueue = this.d;
        if ((localLinkedBlockingQueue == null) || (localLinkedBlockingQueue.isEmpty())) {
          return false;
        }
      }
      boolean bool = true;
      return bool;
    }
    
    public a2.c e()
    {
      return this.h;
    }
  }
  
  private static class c
    extends b.d.d0.i2.b
  {
    private byte[] c;
    private short d;
    
    private c(short paramShort, int paramInt)
    {
      super();
      this.d = ((short)paramShort);
    }
    
    private c(short paramShort, int paramInt, String paramString)
    {
      super(paramString);
      this.d = ((short)paramShort);
    }
    
    private c(short paramShort, byte[] paramArrayOfByte)
    {
      this.d = ((short)paramShort);
      this.c = paramArrayOfByte;
    }
    
    public byte[] e()
    {
      return this.c;
    }
  }
  
  private static class d
    implements a2.e
  {
    private g<a2.c> a = io.reactivex.m0.b.n1().l1();
    private ExecutorService b = Executors.newSingleThreadExecutor();
    a2 c;
    private int d = 0;
    
    d(a2 parama2)
    {
      this.c = parama2;
    }
    
    public q<a2.c> a(a2.b paramb)
    {
      return q.f0(paramb).g0(new v(this));
    }
    
    public void clear()
    {
      this.a.onError(new TPGeneralNetworkException(-1));
      this.b.shutdown();
    }
  }
  
  private static abstract interface e
  {
    public abstract q<a2.c> a(a2.b paramb);
    
    public abstract void clear();
  }
  
  private static class f<F, S>
  {
    private F a;
    private S b;
    
    f(F paramF, S paramS)
    {
      this.a = paramF;
      this.b = paramS;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d0\a2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */