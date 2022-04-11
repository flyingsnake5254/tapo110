package com.tplink.libtpnetwork.cameranetwork.h4.o4;

import android.text.TextUtils;
import com.tplink.libtpnetwork.cameranetwork.business.model.CameraErrorCode;
import com.tplink.libtpnetwork.cameranetwork.h4.h4;
import com.tplink.libtpnetwork.cameranetwork.h4.j4;
import com.tplink.libtpnetwork.cameranetwork.model.Account;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleRequest;
import com.tplink.libtpnetwork.cameranetwork.model.MultipleResponse;
import com.tplink.libtpnetwork.cameranetwork.model.Request;
import com.tplink.libtpnetwork.cameranetwork.model.Response;
import com.tplink.libtpnetwork.cameranetwork.model.Wrappers;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import io.reactivex.q;
import io.reactivex.v;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import okhttp3.ResponseBody;
import retrofit2.HttpException;

public class s
  extends h4
{
  private u c;
  private String d;
  private t e;
  private Account f;
  private volatile boolean g;
  private volatile long h;
  private volatile boolean i;
  private io.reactivex.m0.g<com.tplink.libtpnetwork.cameranetwork.common.a<String>> j = io.reactivex.m0.b.n1().l1();
  private final Object k = new Object();
  private io.reactivex.e0.b l = new io.reactivex.e0.b();
  private q<String> m = new a();
  private q<String> n;
  private q<String> o;
  
  public s(u paramu)
  {
    q localq = q.f0(Integer.valueOf(0)).N(new b());
    this.n = localq;
    this.o = q.j(this.m, localq).L(f.c).M().p();
    this.c = paramu;
    this.f = new Account("admin", paramu.c(), false);
    this.e = new j4(null).a(paramu.d(), null, null, paramu.a());
  }
  
  private void V4()
  {
    if (TextUtils.isEmpty(this.d)) {
      synchronized (this.k)
      {
        if ((!this.g) || (TextUtils.isEmpty(this.d)))
        {
          this.g = true;
          io.reactivex.e0.b localb = this.l;
          Object localObject3 = this.o;
          Object localObject4 = new com/tplink/libtpnetwork/cameranetwork/h4/o4/h;
          ((h)localObject4).<init>(this);
          localObject4 = ((q)localObject3).y((io.reactivex.g0.a)localObject4);
          localObject3 = new com/tplink/libtpnetwork/cameranetwork/h4/o4/d;
          ((d)localObject3).<init>(this);
          k localk = new com/tplink/libtpnetwork/cameranetwork/h4/o4/k;
          localk.<init>(this);
          localb.b(((q)localObject4).H0((io.reactivex.g0.g)localObject3, localk));
        }
      }
    }
    this.j.onNext(new com.tplink.libtpnetwork.cameranetwork.common.a(this.d));
  }
  
  private void l4(Throwable paramThrowable)
  {
    if (q4(paramThrowable)) {
      o3(false);
    }
  }
  
  private boolean o4()
  {
    boolean bool;
    if (System.currentTimeMillis() - this.h <= 5000L) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean p4(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof CameraException))
    {
      CameraErrorCode localCameraErrorCode = CameraErrorCode.SESSION_EXPIRED;
      paramThrowable = (CameraException)paramThrowable;
      if (localCameraErrorCode.isEqual(paramThrowable.getErrorCode()))
      {
        if ((!this.g) && (!o4()))
        {
          this.d = null;
          this.f = new Account("admin", this.c.c(), false);
        }
        return true;
      }
      if (CameraErrorCode.FFS_NONE_PWD.isEqual(paramThrowable.getErrorCode()))
      {
        if ((!this.g) && (!o4()))
        {
          this.d = null;
          this.f = new Account("admin", this.c.b(), false);
        }
        return true;
      }
    }
    return false;
  }
  
  private boolean q4(Throwable paramThrowable)
  {
    boolean bool;
    if ((!(paramThrowable instanceof ProtocolException)) && (!(paramThrowable instanceof UnknownHostException)) && (!(paramThrowable instanceof ConnectException)) && (!(paramThrowable instanceof SocketException)) && (!(paramThrowable instanceof SocketTimeoutException)) && ((!(paramThrowable instanceof HttpException)) || (((HttpException)paramThrowable).code() < 300))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public q<String> S4(Account paramAccount)
  {
    if (paramAccount != null) {
      if (this.f == null) {
        this.f = paramAccount;
      } else if (!paramAccount.getPassword().equals(this.f.getPassword())) {
        this.f = paramAccount;
      }
    }
    return this.j.Q0(1L).F(new i(this)).N(a.c);
  }
  
  public boolean T4()
  {
    return this.i;
  }
  
  public void U4()
  {
    this.i = false;
    o3(true);
  }
  
  public void W4(u paramu)
  {
    if (!TextUtils.equals(this.c.d(), paramu.d())) {
      this.e = new j4(null).a(paramu.d(), null, null, paramu.a());
    }
    if (!TextUtils.equals(this.c.c(), paramu.c())) {
      this.f = new Account("admin", paramu.c(), false);
    }
    this.c = paramu;
  }
  
  protected q<Response<Wrappers>> c3(Request<MultipleRequest> paramRequest)
  {
    return this.j.Q0(1L).F(new o(this)).N(new l(this, paramRequest)).v0(1L, new p(this)).C(new n(this));
  }
  
  protected q<Response<MultipleResponse>> d3(Request<MultipleRequest> paramRequest)
  {
    return this.j.Q0(1L).F(new e(this)).N(new m(this, paramRequest)).v0(1L, new p(this)).C(new j(this));
  }
  
  protected q<Response<Wrappers>> e3(Request paramRequest)
  {
    return this.e.f(paramRequest);
  }
  
  public q<ResponseBody> m4()
  {
    return this.j.Q0(1L).F(new g(this)).N(new c(this));
  }
  
  public u n4()
  {
    return this.c;
  }
  
  class a
    extends q<String>
  {
    a() {}
    
    protected void K0(v<? super String> paramv)
    {
      paramv.onNext(s.h4(s.this));
      paramv.onComplete();
    }
  }
  
  class b
    implements io.reactivex.g0.j<Integer, io.reactivex.t<String>>
  {
    b() {}
    
    public io.reactivex.t<String> a(Integer paramInteger)
      throws Exception
    {
      if (!s.i4(s.this))
      {
        if ((s.j4(s.this) != null) && (s.k4(s.this) != null)) {
          return s.k4(s.this).c(s.j4(s.this)).g0(b.c);
        }
        throw new Exception("param is null");
      }
      throw new Exception("needSyncPassword");
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\h4\o4\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */