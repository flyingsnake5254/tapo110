package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.upstream.x.c;
import com.google.android.exoplayer2.util.g;
import com.google.android.exoplayer2.util.l;
import com.google.android.exoplayer2.util.m;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.util.u;
import com.google.android.exoplayer2.w0;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

@RequiresApi(18)
class DefaultDrmSession
  implements DrmSession
{
  @Nullable
  public final List<DrmInitData.SchemeData> a;
  private final e0 b;
  private final a c;
  private final b d;
  private final int e;
  private final boolean f;
  private final boolean g;
  private final HashMap<String, String> h;
  private final m<v.a> i;
  private final com.google.android.exoplayer2.upstream.x j;
  final i0 k;
  final UUID l;
  final e m;
  private int n;
  private int o;
  @Nullable
  private HandlerThread p;
  @Nullable
  private c q;
  @Nullable
  private d0 r;
  @Nullable
  private DrmSession.DrmSessionException s;
  @Nullable
  private byte[] t;
  private byte[] u;
  @Nullable
  private e0.a v;
  @Nullable
  private e0.d w;
  
  public DefaultDrmSession(UUID paramUUID, e0 parame0, a parama, b paramb, @Nullable List<DrmInitData.SchemeData> paramList, int paramInt, boolean paramBoolean1, boolean paramBoolean2, @Nullable byte[] paramArrayOfByte, HashMap<String, String> paramHashMap, i0 parami0, Looper paramLooper, com.google.android.exoplayer2.upstream.x paramx)
  {
    if ((paramInt == 1) || (paramInt == 3)) {
      g.e(paramArrayOfByte);
    }
    this.l = paramUUID;
    this.c = parama;
    this.d = paramb;
    this.b = parame0;
    this.e = paramInt;
    this.f = paramBoolean1;
    this.g = paramBoolean2;
    if (paramArrayOfByte != null)
    {
      this.u = paramArrayOfByte;
      this.a = null;
    }
    else
    {
      this.a = Collections.unmodifiableList((List)g.e(paramList));
    }
    this.h = paramHashMap;
    this.k = parami0;
    this.i = new m();
    this.j = paramx;
    this.n = 2;
    this.m = new e(paramLooper);
  }
  
  private void A(byte[] paramArrayOfByte, int paramInt, boolean paramBoolean)
  {
    try
    {
      this.v = this.b.k(paramArrayOfByte, this.a, paramInt, this.h);
      ((c)o0.i(this.q)).b(1, g.e(this.v), paramBoolean);
    }
    catch (Exception paramArrayOfByte)
    {
      t(paramArrayOfByte, true);
    }
  }
  
  @RequiresNonNull({"sessionId", "offlineLicenseKeySetId"})
  private boolean C()
  {
    try
    {
      this.b.f(this.t, this.u);
      return true;
    }
    catch (Exception localException)
    {
      r(localException, 1);
    }
    return false;
  }
  
  private void k(l<v.a> paraml)
  {
    Iterator localIterator = this.i.elementSet().iterator();
    while (localIterator.hasNext()) {
      paraml.accept((v.a)localIterator.next());
    }
  }
  
  @RequiresNonNull({"sessionId"})
  private void l(boolean paramBoolean)
  {
    if (this.g) {
      return;
    }
    byte[] arrayOfByte = (byte[])o0.i(this.t);
    int i1 = this.e;
    if ((i1 != 0) && (i1 != 1))
    {
      if (i1 != 2)
      {
        if (i1 == 3)
        {
          g.e(this.u);
          g.e(this.t);
          A(this.u, 3, paramBoolean);
        }
      }
      else if ((this.u == null) || (C())) {
        A(arrayOfByte, 2, paramBoolean);
      }
    }
    else if (this.u == null)
    {
      A(arrayOfByte, 1, paramBoolean);
    }
    else if ((this.n == 4) || (C()))
    {
      long l1 = m();
      if ((this.e == 0) && (l1 <= 60L))
      {
        StringBuilder localStringBuilder = new StringBuilder(88);
        localStringBuilder.append("Offline license has expired or will expire soon. Remaining seconds: ");
        localStringBuilder.append(l1);
        u.b("DefaultDrmSession", localStringBuilder.toString());
        A(arrayOfByte, 2, paramBoolean);
      }
      else if (l1 <= 0L)
      {
        r(new KeysExpiredException(), 2);
      }
      else
      {
        this.n = 4;
        k(q.a);
      }
    }
  }
  
  private long m()
  {
    if (!w0.d.equals(this.l)) {
      return Long.MAX_VALUE;
    }
    Pair localPair = (Pair)g.e(k0.b(this));
    return Math.min(((Long)localPair.first).longValue(), ((Long)localPair.second).longValue());
  }
  
  @EnsuresNonNullIf(expression={"sessionId"}, result=true)
  private boolean o()
  {
    int i1 = this.n;
    boolean bool;
    if ((i1 != 3) && (i1 != 4)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private void r(Exception paramException, int paramInt)
  {
    this.s = new DrmSession.DrmSessionException(paramException, a0.a(paramException, paramInt));
    u.d("DefaultDrmSession", "DRM session error", paramException);
    k(new b(paramException));
    if (this.n != 4) {
      this.n = 1;
    }
  }
  
  private void s(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == this.v) && (o()))
    {
      this.v = null;
      if ((paramObject2 instanceof Exception))
      {
        t((Exception)paramObject2, false);
        return;
      }
      try
      {
        paramObject1 = (byte[])paramObject2;
        if (this.e == 3)
        {
          this.b.j((byte[])o0.i(this.u), (byte[])paramObject1);
          k(a.a);
        }
        else
        {
          paramObject1 = this.b.j(this.t, (byte[])paramObject1);
          int i1 = this.e;
          if (((i1 == 2) || ((i1 == 0) && (this.u != null))) && (paramObject1 != null) && (paramObject1.length != 0)) {
            this.u = ((byte[])paramObject1);
          }
          this.n = 4;
          k(p.a);
        }
      }
      catch (Exception paramObject1)
      {
        t((Exception)paramObject1, true);
      }
    }
  }
  
  private void t(Exception paramException, boolean paramBoolean)
  {
    if ((paramException instanceof NotProvisionedException))
    {
      this.c.b(this);
    }
    else
    {
      int i1;
      if (paramBoolean) {
        i1 = 1;
      } else {
        i1 = 2;
      }
      r(paramException, i1);
    }
  }
  
  private void u()
  {
    if ((this.e == 0) && (this.n == 4))
    {
      o0.i(this.t);
      l(false);
    }
  }
  
  private void y(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 == this.w) && ((this.n == 2) || (o())))
    {
      this.w = null;
      if ((paramObject2 instanceof Exception))
      {
        this.c.a((Exception)paramObject2, false);
        return;
      }
      try
      {
        this.b.h((byte[])paramObject2);
        this.c.c();
        return;
      }
      catch (Exception paramObject1)
      {
        this.c.a((Exception)paramObject1, true);
      }
    }
  }
  
  @EnsuresNonNullIf(expression={"sessionId"}, result=true)
  private boolean z()
  {
    if (o()) {
      return true;
    }
    try
    {
      Object localObject = this.b.e();
      this.t = ((byte[])localObject);
      this.r = this.b.c((byte[])localObject);
      this.n = 3;
      localObject = new com/google/android/exoplayer2/drm/c;
      ((c)localObject).<init>(3);
      k((l)localObject);
      g.e(this.t);
      return true;
    }
    catch (Exception localException)
    {
      r(localException, 1);
    }
    catch (NotProvisionedException localNotProvisionedException)
    {
      this.c.b(this);
    }
    return false;
  }
  
  public void B()
  {
    this.w = this.b.d();
    ((c)o0.i(this.q)).b(0, g.e(this.w), true);
  }
  
  public void a(@Nullable v.a parama)
  {
    int i1 = this.o;
    boolean bool1 = false;
    boolean bool2;
    if (i1 >= 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    g.g(bool2);
    if (parama != null) {
      this.i.a(parama);
    }
    i1 = this.o + 1;
    this.o = i1;
    if (i1 == 1)
    {
      bool2 = bool1;
      if (this.n == 2) {
        bool2 = true;
      }
      g.g(bool2);
      parama = new HandlerThread("ExoPlayer:DrmRequestHandler");
      this.p = parama;
      parama.start();
      this.q = new c(this.p.getLooper());
      if (z()) {
        l(true);
      }
    }
    else if ((parama != null) && (o()) && (this.i.count(parama) == 1))
    {
      parama.e(this.n);
    }
    this.d.a(this, this.o);
  }
  
  public void b(@Nullable v.a parama)
  {
    boolean bool;
    if (this.o > 0) {
      bool = true;
    } else {
      bool = false;
    }
    g.g(bool);
    int i1 = this.o - 1;
    this.o = i1;
    if (i1 == 0)
    {
      this.n = 0;
      ((e)o0.i(this.m)).removeCallbacksAndMessages(null);
      ((c)o0.i(this.q)).c();
      this.q = null;
      ((HandlerThread)o0.i(this.p)).quit();
      this.p = null;
      this.r = null;
      this.s = null;
      this.v = null;
      this.w = null;
      byte[] arrayOfByte = this.t;
      if (arrayOfByte != null)
      {
        this.b.i(arrayOfByte);
        this.t = null;
      }
    }
    if (parama != null)
    {
      this.i.b(parama);
      if (this.i.count(parama) == 0) {
        parama.g();
      }
    }
    this.d.b(this, this.o);
  }
  
  public final UUID c()
  {
    return this.l;
  }
  
  public boolean d()
  {
    return this.f;
  }
  
  @Nullable
  public final d0 e()
  {
    return this.r;
  }
  
  @Nullable
  public final DrmSession.DrmSessionException f()
  {
    DrmSession.DrmSessionException localDrmSessionException;
    if (this.n == 1) {
      localDrmSessionException = this.s;
    } else {
      localDrmSessionException = null;
    }
    return localDrmSessionException;
  }
  
  @Nullable
  public Map<String, String> g()
  {
    Object localObject = this.t;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = this.b.b((byte[])localObject);
    }
    return (Map<String, String>)localObject;
  }
  
  public final int getState()
  {
    return this.n;
  }
  
  public boolean n(byte[] paramArrayOfByte)
  {
    return Arrays.equals(this.t, paramArrayOfByte);
  }
  
  public void v(int paramInt)
  {
    if (paramInt == 2) {
      u();
    }
  }
  
  public void w()
  {
    if (z()) {
      l(true);
    }
  }
  
  public void x(Exception paramException, boolean paramBoolean)
  {
    int i1;
    if (paramBoolean) {
      i1 = 1;
    } else {
      i1 = 3;
    }
    r(paramException, i1);
  }
  
  public static final class UnexpectedDrmSessionException
    extends IOException
  {
    public UnexpectedDrmSessionException(@Nullable Throwable paramThrowable)
    {
      super();
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(Exception paramException, boolean paramBoolean);
    
    public abstract void b(DefaultDrmSession paramDefaultDrmSession);
    
    public abstract void c();
  }
  
  public static abstract interface b
  {
    public abstract void a(DefaultDrmSession paramDefaultDrmSession, int paramInt);
    
    public abstract void b(DefaultDrmSession paramDefaultDrmSession, int paramInt);
  }
  
  @SuppressLint({"HandlerLeak"})
  private class c
    extends Handler
  {
    @GuardedBy("this")
    private boolean a;
    
    public c(Looper paramLooper)
    {
      super();
    }
    
    private boolean a(Message paramMessage, MediaDrmCallbackException paramMediaDrmCallbackException)
    {
      DefaultDrmSession.d locald = (DefaultDrmSession.d)paramMessage.obj;
      if (!locald.b) {
        return false;
      }
      int i = locald.e + 1;
      locald.e = i;
      if (i > DefaultDrmSession.j(DefaultDrmSession.this).b(3)) {
        return false;
      }
      com.google.android.exoplayer2.source.x localx = new com.google.android.exoplayer2.source.x(locald.a, paramMediaDrmCallbackException.dataSpec, paramMediaDrmCallbackException.uriAfterRedirects, paramMediaDrmCallbackException.responseHeaders, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - locald.c, paramMediaDrmCallbackException.bytesLoaded);
      com.google.android.exoplayer2.source.a0 locala0 = new com.google.android.exoplayer2.source.a0(3);
      if ((paramMediaDrmCallbackException.getCause() instanceof IOException)) {
        paramMediaDrmCallbackException = (IOException)paramMediaDrmCallbackException.getCause();
      } else {
        paramMediaDrmCallbackException = new DefaultDrmSession.UnexpectedDrmSessionException(paramMediaDrmCallbackException.getCause());
      }
      long l = DefaultDrmSession.j(DefaultDrmSession.this).a(new x.c(localx, locala0, paramMediaDrmCallbackException, locald.e));
      if (l == -9223372036854775807L) {
        return false;
      }
      try
      {
        if (!this.a)
        {
          sendMessageDelayed(Message.obtain(paramMessage), l);
          return true;
        }
        return false;
      }
      finally {}
    }
    
    void b(int paramInt, Object paramObject, boolean paramBoolean)
    {
      obtainMessage(paramInt, new DefaultDrmSession.d(com.google.android.exoplayer2.source.x.a(), paramBoolean, SystemClock.elapsedRealtime(), paramObject)).sendToTarget();
    }
    
    public void c()
    {
      try
      {
        removeCallbacksAndMessages(null);
        this.a = true;
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    public void handleMessage(Message paramMessage)
    {
      DefaultDrmSession.d locald = (DefaultDrmSession.d)paramMessage.obj;
      Object localObject2;
      try
      {
        int i = paramMessage.what;
        Object localObject1;
        if (i != 0)
        {
          if (i == 1)
          {
            localObject1 = DefaultDrmSession.this;
            localObject1 = ((DefaultDrmSession)localObject1).k.b(((DefaultDrmSession)localObject1).l, (e0.a)locald.d);
          }
          else
          {
            localObject1 = new java/lang/RuntimeException;
            ((RuntimeException)localObject1).<init>();
            throw ((Throwable)localObject1);
          }
        }
        else
        {
          localObject1 = DefaultDrmSession.this;
          localObject1 = ((DefaultDrmSession)localObject1).k.a(((DefaultDrmSession)localObject1).l, (e0.d)locald.d);
        }
      }
      catch (Exception localException)
      {
        u.i("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", localException);
      }
      catch (MediaDrmCallbackException localMediaDrmCallbackException)
      {
        localObject2 = localMediaDrmCallbackException;
        if (a(paramMessage, localMediaDrmCallbackException)) {
          return;
        }
      }
      DefaultDrmSession.j(DefaultDrmSession.this).d(locald.a);
      try
      {
        if (!this.a) {
          DefaultDrmSession.this.m.obtainMessage(paramMessage.what, Pair.create(locald.d, localObject2)).sendToTarget();
        }
        return;
      }
      finally {}
    }
  }
  
  private static final class d
  {
    public final long a;
    public final boolean b;
    public final long c;
    public final Object d;
    public int e;
    
    public d(long paramLong1, boolean paramBoolean, long paramLong2, Object paramObject)
    {
      this.a = paramLong1;
      this.b = paramBoolean;
      this.c = paramLong2;
      this.d = paramObject;
    }
  }
  
  @SuppressLint({"HandlerLeak"})
  private class e
    extends Handler
  {
    public e(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      Object localObject1 = (Pair)paramMessage.obj;
      Object localObject2 = ((Pair)localObject1).first;
      localObject1 = ((Pair)localObject1).second;
      int i = paramMessage.what;
      if (i != 0)
      {
        if (i == 1) {
          DefaultDrmSession.i(DefaultDrmSession.this, localObject2, localObject1);
        }
      }
      else {
        DefaultDrmSession.h(DefaultDrmSession.this, localObject2, localObject1);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\drm\DefaultDrmSession.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */