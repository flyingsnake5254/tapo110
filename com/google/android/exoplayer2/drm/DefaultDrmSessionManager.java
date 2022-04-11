package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.upstream.t;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.util.y;
import com.google.android.exoplayer2.w0;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.j3;
import com.google.common.collect.u2;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

@RequiresApi(18)
public class DefaultDrmSessionManager
  implements x
{
  private final UUID c;
  private final e0.c d;
  private final i0 e;
  private final HashMap<String, String> f;
  private final boolean g;
  private final int[] h;
  private final boolean i;
  private final f j;
  private final com.google.android.exoplayer2.upstream.x k;
  private final g l;
  private final long m;
  private final List<DefaultDrmSession> n;
  private final Set<e> o;
  private final Set<DefaultDrmSession> p;
  private int q;
  @Nullable
  private e0 r;
  @Nullable
  private DefaultDrmSession s;
  @Nullable
  private DefaultDrmSession t;
  private Looper u;
  private Handler v;
  private int w;
  @Nullable
  private byte[] x;
  @Nullable
  volatile d y;
  
  private DefaultDrmSessionManager(UUID paramUUID, e0.c paramc, i0 parami0, HashMap<String, String> paramHashMap, boolean paramBoolean1, int[] paramArrayOfInt, boolean paramBoolean2, com.google.android.exoplayer2.upstream.x paramx, long paramLong)
  {
    g.e(paramUUID);
    g.b(w0.b.equals(paramUUID) ^ true, "Use C.CLEARKEY_UUID instead");
    this.c = paramUUID;
    this.d = paramc;
    this.e = parami0;
    this.f = paramHashMap;
    this.g = paramBoolean1;
    this.h = paramArrayOfInt;
    this.i = paramBoolean2;
    this.k = paramx;
    this.j = new f();
    this.l = new g(null);
    this.w = 0;
    this.n = new ArrayList();
    this.o = u2.f();
    this.p = u2.f();
    this.m = paramLong;
  }
  
  private void A()
  {
    if ((this.r != null) && (this.q == 0) && (this.n.isEmpty()) && (this.o.isEmpty()))
    {
      ((e0)g.e(this.r)).release();
      this.r = null;
    }
  }
  
  private void B()
  {
    j3 localj3 = ImmutableSet.copyOf(this.o).iterator();
    while (localj3.hasNext()) {
      ((e)localj3.next()).release();
    }
  }
  
  private void D(DrmSession paramDrmSession, @Nullable v.a parama)
  {
    paramDrmSession.b(parama);
    if (this.m != -9223372036854775807L) {
      paramDrmSession.b(null);
    }
  }
  
  @Nullable
  private DrmSession r(Looper paramLooper, @Nullable v.a parama, Format paramFormat, boolean paramBoolean)
  {
    z(paramLooper);
    paramLooper = paramFormat.K3;
    if (paramLooper == null) {
      return y(y.k(paramFormat.H3), paramBoolean);
    }
    paramFormat = this.x;
    Object localObject = null;
    if (paramFormat == null)
    {
      paramLooper = w((DrmInitData)g.e(paramLooper), this.c, false);
      paramFormat = paramLooper;
      if (paramLooper.isEmpty())
      {
        paramLooper = new MissingSchemeDataException(this.c, null);
        u.d("DefaultDrmSessionMgr", "DRM error", paramLooper);
        if (parama != null) {
          parama.f(paramLooper);
        }
        return new c0(new DrmSession.DrmSessionException(paramLooper, 6003));
      }
    }
    else
    {
      paramFormat = null;
    }
    if (!this.g)
    {
      paramLooper = this.t;
    }
    else
    {
      Iterator localIterator = this.n.iterator();
      do
      {
        paramLooper = (Looper)localObject;
        if (!localIterator.hasNext()) {
          break;
        }
        paramLooper = (DefaultDrmSession)localIterator.next();
      } while (!o0.b(paramLooper.a, paramFormat));
    }
    if (paramLooper == null)
    {
      paramLooper = v(paramFormat, false, parama, paramBoolean);
      if (!this.g) {
        this.t = paramLooper;
      }
      this.n.add(paramLooper);
    }
    else
    {
      paramLooper.a(parama);
    }
    return paramLooper;
  }
  
  private static boolean s(DrmSession paramDrmSession)
  {
    int i1 = paramDrmSession.getState();
    boolean bool1 = true;
    if (i1 == 1)
    {
      bool2 = bool1;
      if (o0.a < 19) {
        return bool2;
      }
      if ((((DrmSession.DrmSessionException)g.e(paramDrmSession.f())).getCause() instanceof ResourceBusyException)) {
        return bool1;
      }
    }
    boolean bool2 = false;
    return bool2;
  }
  
  private boolean t(DrmInitData paramDrmInitData)
  {
    Object localObject = this.x;
    boolean bool = true;
    if (localObject != null) {
      return true;
    }
    if (w(paramDrmInitData, this.c, true).isEmpty()) {
      if ((paramDrmInitData.q == 1) && (paramDrmInitData.e(0).c(w0.b)))
      {
        localObject = String.valueOf(this.c);
        StringBuilder localStringBuilder = new StringBuilder(((String)localObject).length() + 72);
        localStringBuilder.append("DrmInitData only contains common PSSH SchemeData. Assuming support for: ");
        localStringBuilder.append((String)localObject);
        u.h("DefaultDrmSessionMgr", localStringBuilder.toString());
      }
      else
      {
        return false;
      }
    }
    paramDrmInitData = paramDrmInitData.f;
    if ((paramDrmInitData != null) && (!"cenc".equals(paramDrmInitData)))
    {
      if ("cbcs".equals(paramDrmInitData))
      {
        if (o0.a < 25) {
          bool = false;
        }
        return bool;
      }
      return (!"cbc1".equals(paramDrmInitData)) && (!"cens".equals(paramDrmInitData));
    }
    return true;
  }
  
  private DefaultDrmSession u(@Nullable List<DrmInitData.SchemeData> paramList, boolean paramBoolean, @Nullable v.a parama)
  {
    g.e(this.r);
    boolean bool = this.i;
    paramList = new DefaultDrmSession(this.c, this.r, this.j, this.l, paramList, this.w, bool | paramBoolean, paramBoolean, this.x, this.f, this.e, (Looper)g.e(this.u), this.k);
    paramList.a(parama);
    if (this.m != -9223372036854775807L) {
      paramList.a(null);
    }
    return paramList;
  }
  
  private DefaultDrmSession v(@Nullable List<DrmInitData.SchemeData> paramList, boolean paramBoolean1, @Nullable v.a parama, boolean paramBoolean2)
  {
    Object localObject1 = u(paramList, paramBoolean1, parama);
    Object localObject2 = localObject1;
    if (s((DrmSession)localObject1))
    {
      localObject2 = localObject1;
      if (!this.p.isEmpty())
      {
        localObject2 = ImmutableSet.copyOf(this.p).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((DrmSession)((Iterator)localObject2).next()).b(null);
        }
        D((DrmSession)localObject1, parama);
        localObject2 = u(paramList, paramBoolean1, parama);
      }
    }
    localObject1 = localObject2;
    if (s((DrmSession)localObject2))
    {
      localObject1 = localObject2;
      if (paramBoolean2)
      {
        localObject1 = localObject2;
        if (!this.o.isEmpty())
        {
          B();
          D((DrmSession)localObject2, parama);
          localObject1 = u(paramList, paramBoolean1, parama);
        }
      }
    }
    return (DefaultDrmSession)localObject1;
  }
  
  private static List<DrmInitData.SchemeData> w(DrmInitData paramDrmInitData, UUID paramUUID, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(paramDrmInitData.q);
    for (int i1 = 0; i1 < paramDrmInitData.q; i1++)
    {
      DrmInitData.SchemeData localSchemeData = paramDrmInitData.e(i1);
      int i2;
      if ((!localSchemeData.c(paramUUID)) && ((!w0.c.equals(paramUUID)) || (!localSchemeData.c(w0.b)))) {
        i2 = 0;
      } else {
        i2 = 1;
      }
      if ((i2 != 0) && ((localSchemeData.x != null) || (paramBoolean))) {
        localArrayList.add(localSchemeData);
      }
    }
    return localArrayList;
  }
  
  @EnsuresNonNull({"this.playbackLooper", "this.playbackHandler"})
  private void x(Looper paramLooper)
  {
    try
    {
      Object localObject = this.u;
      if (localObject == null)
      {
        this.u = paramLooper;
        localObject = new android/os/Handler;
        ((Handler)localObject).<init>(paramLooper);
        this.v = ((Handler)localObject);
      }
      else
      {
        boolean bool;
        if (localObject == paramLooper) {
          bool = true;
        } else {
          bool = false;
        }
        g.g(bool);
        g.e(this.v);
      }
      return;
    }
    finally {}
  }
  
  @Nullable
  private DrmSession y(int paramInt, boolean paramBoolean)
  {
    Object localObject = (e0)g.e(this.r);
    int i1;
    if ((f0.class.equals(((e0)localObject).a())) && (f0.a)) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if ((i1 == 0) && (o0.p0(this.h, paramInt) != -1) && (!j0.class.equals(((e0)localObject).a())))
    {
      localObject = this.s;
      if (localObject == null)
      {
        localObject = v(ImmutableList.of(), true, null, paramBoolean);
        this.n.add(localObject);
        this.s = ((DefaultDrmSession)localObject);
      }
      else
      {
        ((DefaultDrmSession)localObject).a(null);
      }
      return this.s;
    }
    return null;
  }
  
  private void z(Looper paramLooper)
  {
    if (this.y == null) {
      this.y = new d(paramLooper);
    }
  }
  
  public void C(int paramInt, @Nullable byte[] paramArrayOfByte)
  {
    g.g(this.n.isEmpty());
    if ((paramInt == 1) || (paramInt == 3)) {
      g.e(paramArrayOfByte);
    }
    this.w = paramInt;
    this.x = paramArrayOfByte;
  }
  
  @Nullable
  public DrmSession a(Looper paramLooper, @Nullable v.a parama, Format paramFormat)
  {
    boolean bool;
    if (this.q > 0) {
      bool = true;
    } else {
      bool = false;
    }
    g.g(bool);
    x(paramLooper);
    return r(paramLooper, parama, paramFormat, true);
  }
  
  public x.b b(Looper paramLooper, @Nullable v.a parama, Format paramFormat)
  {
    boolean bool;
    if (this.q > 0) {
      bool = true;
    } else {
      bool = false;
    }
    g.g(bool);
    x(paramLooper);
    paramLooper = new e(parama);
    paramLooper.a(paramFormat);
    return paramLooper;
  }
  
  @Nullable
  public Class<? extends d0> c(Format paramFormat)
  {
    Class localClass = ((e0)g.e(this.r)).a();
    DrmInitData localDrmInitData = paramFormat.K3;
    if (localDrmInitData == null)
    {
      int i1 = y.k(paramFormat.H3);
      if (o0.p0(this.h, i1) == -1) {
        localClass = null;
      }
      return localClass;
    }
    if (!t(localDrmInitData)) {
      localClass = j0.class;
    }
    return localClass;
  }
  
  public final void prepare()
  {
    int i1 = this.q;
    this.q = (i1 + 1);
    if (i1 != 0) {
      return;
    }
    if (this.r == null)
    {
      e0 locale0 = this.d.a(this.c);
      this.r = locale0;
      locale0.g(new c(null));
    }
    else if (this.m != -9223372036854775807L)
    {
      for (i1 = 0; i1 < this.n.size(); i1++) {
        ((DefaultDrmSession)this.n.get(i1)).a(null);
      }
    }
  }
  
  public final void release()
  {
    int i1 = this.q - 1;
    this.q = i1;
    if (i1 != 0) {
      return;
    }
    if (this.m != -9223372036854775807L)
    {
      ArrayList localArrayList = new ArrayList(this.n);
      for (i1 = 0; i1 < localArrayList.size(); i1++) {
        ((DefaultDrmSession)localArrayList.get(i1)).b(null);
      }
    }
    B();
    A();
  }
  
  public static final class MissingSchemeDataException
    extends Exception
  {
    private MissingSchemeDataException(UUID paramUUID)
    {
      super();
    }
  }
  
  public static final class b
  {
    private final HashMap<String, String> a = new HashMap();
    private UUID b = w0.d;
    private e0.c c = g0.a;
    private boolean d;
    private int[] e = new int[0];
    private boolean f;
    private com.google.android.exoplayer2.upstream.x g = new t();
    private long h = 300000L;
    
    public DefaultDrmSessionManager a(i0 parami0)
    {
      return new DefaultDrmSessionManager(this.b, this.c, parami0, this.a, this.d, this.e, this.f, this.g, this.h, null);
    }
    
    public b b(boolean paramBoolean)
    {
      this.d = paramBoolean;
      return this;
    }
    
    public b c(boolean paramBoolean)
    {
      this.f = paramBoolean;
      return this;
    }
    
    public b d(int... paramVarArgs)
    {
      int i = paramVarArgs.length;
      for (int j = 0; j < i; j++)
      {
        int k = paramVarArgs[j];
        boolean bool1 = true;
        boolean bool2 = bool1;
        if (k != 2) {
          if (k == 1) {
            bool2 = bool1;
          } else {
            bool2 = false;
          }
        }
        g.a(bool2);
      }
      this.e = ((int[])paramVarArgs.clone());
      return this;
    }
    
    public b e(UUID paramUUID, e0.c paramc)
    {
      this.b = ((UUID)g.e(paramUUID));
      this.c = ((e0.c)g.e(paramc));
      return this;
    }
  }
  
  private class c
    implements e0.b
  {
    private c() {}
    
    public void a(e0 parame0, @Nullable byte[] paramArrayOfByte1, int paramInt1, int paramInt2, @Nullable byte[] paramArrayOfByte2)
    {
      ((DefaultDrmSessionManager.d)g.e(DefaultDrmSessionManager.this.y)).obtainMessage(paramInt1, paramArrayOfByte1).sendToTarget();
    }
  }
  
  @SuppressLint({"HandlerLeak"})
  private class d
    extends Handler
  {
    public d(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      byte[] arrayOfByte = (byte[])paramMessage.obj;
      if (arrayOfByte == null) {
        return;
      }
      Iterator localIterator = DefaultDrmSessionManager.k(DefaultDrmSessionManager.this).iterator();
      while (localIterator.hasNext())
      {
        DefaultDrmSession localDefaultDrmSession = (DefaultDrmSession)localIterator.next();
        if (localDefaultDrmSession.n(arrayOfByte)) {
          localDefaultDrmSession.v(paramMessage.what);
        }
      }
    }
  }
  
  private class e
    implements x.b
  {
    @Nullable
    private final v.a b;
    @Nullable
    private DrmSession c;
    private boolean d;
    
    public e(v.a parama)
    {
      this.b = parama;
    }
    
    public void a(Format paramFormat)
    {
      ((Handler)g.e(DefaultDrmSessionManager.n(DefaultDrmSessionManager.this))).post(new e(this, paramFormat));
    }
    
    public void release()
    {
      o0.z0((Handler)g.e(DefaultDrmSessionManager.n(DefaultDrmSessionManager.this)), new d(this));
    }
  }
  
  private class f
    implements DefaultDrmSession.a
  {
    private final Set<DefaultDrmSession> a = new HashSet();
    @Nullable
    private DefaultDrmSession b;
    
    public f() {}
    
    public void a(Exception paramException, boolean paramBoolean)
    {
      this.b = null;
      Object localObject = ImmutableList.copyOf(this.a);
      this.a.clear();
      localObject = ((ImmutableList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((DefaultDrmSession)((Iterator)localObject).next()).x(paramException, paramBoolean);
      }
    }
    
    public void b(DefaultDrmSession paramDefaultDrmSession)
    {
      this.a.add(paramDefaultDrmSession);
      if (this.b != null) {
        return;
      }
      this.b = paramDefaultDrmSession;
      paramDefaultDrmSession.B();
    }
    
    public void c()
    {
      this.b = null;
      Object localObject = ImmutableList.copyOf(this.a);
      this.a.clear();
      localObject = ((ImmutableList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((DefaultDrmSession)((Iterator)localObject).next()).w();
      }
    }
    
    public void d(DefaultDrmSession paramDefaultDrmSession)
    {
      this.a.remove(paramDefaultDrmSession);
      if (this.b == paramDefaultDrmSession)
      {
        this.b = null;
        if (!this.a.isEmpty())
        {
          paramDefaultDrmSession = (DefaultDrmSession)this.a.iterator().next();
          this.b = paramDefaultDrmSession;
          paramDefaultDrmSession.B();
        }
      }
    }
  }
  
  private class g
    implements DefaultDrmSession.b
  {
    private g() {}
    
    public void a(DefaultDrmSession paramDefaultDrmSession, int paramInt)
    {
      if (DefaultDrmSessionManager.l(DefaultDrmSessionManager.this) != -9223372036854775807L)
      {
        DefaultDrmSessionManager.m(DefaultDrmSessionManager.this).remove(paramDefaultDrmSession);
        ((Handler)g.e(DefaultDrmSessionManager.n(DefaultDrmSessionManager.this))).removeCallbacksAndMessages(paramDefaultDrmSession);
      }
    }
    
    public void b(DefaultDrmSession paramDefaultDrmSession, int paramInt)
    {
      if ((paramInt == 1) && (DefaultDrmSessionManager.o(DefaultDrmSessionManager.this) > 0) && (DefaultDrmSessionManager.l(DefaultDrmSessionManager.this) != -9223372036854775807L))
      {
        DefaultDrmSessionManager.m(DefaultDrmSessionManager.this).add(paramDefaultDrmSession);
        ((Handler)g.e(DefaultDrmSessionManager.n(DefaultDrmSessionManager.this))).postAtTime(new f(paramDefaultDrmSession), paramDefaultDrmSession, SystemClock.uptimeMillis() + DefaultDrmSessionManager.l(DefaultDrmSessionManager.this));
      }
      else if (paramInt == 0)
      {
        DefaultDrmSessionManager.k(DefaultDrmSessionManager.this).remove(paramDefaultDrmSession);
        if (DefaultDrmSessionManager.p(DefaultDrmSessionManager.this) == paramDefaultDrmSession) {
          DefaultDrmSessionManager.q(DefaultDrmSessionManager.this, null);
        }
        if (DefaultDrmSessionManager.d(DefaultDrmSessionManager.this) == paramDefaultDrmSession) {
          DefaultDrmSessionManager.e(DefaultDrmSessionManager.this, null);
        }
        DefaultDrmSessionManager.f(DefaultDrmSessionManager.this).d(paramDefaultDrmSession);
        if (DefaultDrmSessionManager.l(DefaultDrmSessionManager.this) != -9223372036854775807L)
        {
          ((Handler)g.e(DefaultDrmSessionManager.n(DefaultDrmSessionManager.this))).removeCallbacksAndMessages(paramDefaultDrmSession);
          DefaultDrmSessionManager.m(DefaultDrmSessionManager.this).remove(paramDefaultDrmSession);
        }
      }
      DefaultDrmSessionManager.g(DefaultDrmSessionManager.this);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\drm\DefaultDrmSessionManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */