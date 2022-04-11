package com.tplink.libtpnetwork.IoTNetwork.transport.http;

import android.text.TextUtils;
import android.util.Base64;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTRequest;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTResponse;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTDataWrapper;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.IoTResult;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceAccountBean;
import com.tplink.libtpnetwork.IoTNetwork.bean.common.params.DeviceAccountParams;
import com.tplink.libtpnetwork.IoTNetwork.transport.http.bean.handshake.HandShakeRequest;
import com.tplink.libtpnetwork.IoTNetwork.transport.http.bean.handshake.HandShakeResponse;
import com.tplink.libtpnetwork.IoTNetwork.transport.http.bean.handshake.HandShakeResponse.ResultBean;
import com.tplink.libtpnetwork.IoTNetwork.transport.http.bean.login.LoginDeviceRequest;
import com.tplink.libtpnetwork.IoTNetwork.transport.http.bean.login.LoginDeviceResponse;
import com.tplink.libtpnetwork.IoTNetwork.transport.http.bean.login.LoginDeviceResponse.ResultBean;
import com.tplink.libtpnetwork.IoTNetwork.transport.http.bean.secure.SecurePassThroughRequest;
import com.tplink.libtpnetwork.IoTNetwork.transport.http.bean.secure.SecurePassThroughRequest.ParamsBean;
import com.tplink.libtpnetwork.IoTNetwork.transport.http.bean.secure.SecurePassThroughResponse;
import com.tplink.libtpnetwork.IoTNetwork.transport.http.bean.secure.SecurePassThroughResponse.ResultBean;
import com.tplink.libtpnetwork.exception.IoTTransportException;
import io.reactivex.g0.j;
import io.reactivex.g0.l;
import io.reactivex.m;
import io.reactivex.q;
import io.reactivex.t;
import io.reactivex.v;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;
import retrofit2.HttpException;

public class b
  extends com.tplink.libtpnetwork.IoTNetwork.y.a
{
  private c b;
  private com.tplink.libtpnetwork.IoTNetwork.transport.http.cookie.c c;
  private com.tplink.libtpnetwork.IoTNetwork.transport.http.e.a d;
  private com.tplink.libtpnetwork.IoTNetwork.transport.http.e.a e;
  private volatile boolean f;
  private volatile long g;
  private final a h;
  private io.reactivex.m0.g<IoTDataWrapper<String>> i = io.reactivex.m0.b.n1().l1();
  private final Object j = new Object();
  private io.reactivex.e0.c k;
  private q<String> l = new h();
  private q<String> m;
  private q<String> n;
  
  public b(c paramc)
  {
    Object localObject = q.f0(Integer.valueOf(0)).N(new i());
    this.m = ((q)localObject);
    this.n = q.j(this.l, (t)localObject).L(new j()).M().p();
    this.b = paramc;
    localObject = new a();
    this.h = ((a)localObject);
    this.c = new com.tplink.libtpnetwork.IoTNetwork.transport.http.cookie.c((a)localObject);
    this.d = ((com.tplink.libtpnetwork.IoTNetwork.transport.http.e.a)new d(null).a(paramc.d(), com.tplink.libtpnetwork.IoTNetwork.transport.http.e.a.class, this.c, true));
    this.e = ((com.tplink.libtpnetwork.IoTNetwork.transport.http.e.a)new d(null).a(paramc.d(), com.tplink.libtpnetwork.IoTNetwork.transport.http.e.a.class, this.c, false));
  }
  
  private <T> q<SecurePassThroughResponse> A(SecurePassThroughRequest paramSecurePassThroughRequest, String paramString)
  {
    return this.e.b(paramString, paramSecurePassThroughRequest);
  }
  
  private SecurePassThroughRequest C(TPIoTRequest paramTPIoTRequest)
  {
    String str = com.tplink.libtpnetwork.Utils.i.g(paramTPIoTRequest, TPIoTRequest.class);
    N(paramTPIoTRequest);
    return new SecurePassThroughRequest(new SecurePassThroughRequest.ParamsBean(this.h.c(str)));
  }
  
  private <T> q<HandShakeResponse> D(TPIoTRequest<T> paramTPIoTRequest)
  {
    return x(paramTPIoTRequest);
  }
  
  private q<HandShakeResponse> E()
  {
    HandShakeRequest localHandShakeRequest = new HandShakeRequest();
    try
    {
      localHandShakeRequest.setKey(this.h.e());
      TPIoTRequest localTPIoTRequest = new TPIoTRequest();
      localTPIoTRequest.setMethod("handshake");
      localTPIoTRequest.setParams(localHandShakeRequest);
      return D(localTPIoTRequest).E(new k());
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException) {}
    return q.J(new IoTTransportException(1003));
  }
  
  private boolean F()
  {
    boolean bool;
    if (System.currentTimeMillis() - this.g <= 5000L) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean G(Throwable paramThrowable)
  {
    boolean bool1 = paramThrowable instanceof IoTTransportException;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramThrowable = (IoTTransportException)paramThrowable;
      if (paramThrowable.getErrCode() != 1003)
      {
        bool3 = bool2;
        if (paramThrowable.getErrCode() != 64035) {}
      }
      else
      {
        bool3 = true;
      }
    }
    return bool3;
  }
  
  private boolean H(Throwable paramThrowable)
  {
    boolean bool;
    if (((paramThrowable instanceof SocketException)) && ("Connection reset".equals(paramThrowable.getMessage()))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean I(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof IoTTransportException))
    {
      if (((IoTTransportException)paramThrowable).getErrCode() == 9999)
      {
        if ((!this.f) && (!F()))
        {
          this.c.l();
          this.c.d();
        }
        return true;
      }
    }
    else if (H(paramThrowable)) {
      return true;
    }
    return false;
  }
  
  private boolean J(Throwable paramThrowable)
  {
    boolean bool;
    if ((!(paramThrowable instanceof ProtocolException)) && (!(paramThrowable instanceof UnknownHostException)) && (!(paramThrowable instanceof ConnectException)) && (!(paramThrowable instanceof SocketException)) && (!(paramThrowable instanceof SocketTimeoutException)) && ((!(paramThrowable instanceof HttpException)) || (((HttpException)paramThrowable).code() < 300)) && (!(paramThrowable instanceof TimeoutException)) && (!G(paramThrowable))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  private q<String> L()
  {
    return K(this.b.e(), this.b.a(), false).N(new m());
  }
  
  private <T> q<SecurePassThroughResponse> M(final TPIoTRequest<T> paramTPIoTRequest)
  {
    return q.f0(new HandShakeResponse()).N(new o(paramTPIoTRequest));
  }
  
  private void N(TPIoTRequest<?> paramTPIoTRequest)
  {
    int i1 = paramTPIoTRequest.hashCode();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceIdMD5: [");
    localStringBuilder.append(this.b.b());
    localStringBuilder.append("]\n");
    localStringBuilder.append("Request@[");
    localStringBuilder.append(i1);
    localStringBuilder.append("]\n");
    localStringBuilder.append(com.tplink.libtpnetwork.Utils.i.j(paramTPIoTRequest));
    localStringBuilder.append("\n");
    b.d.w.c.a.c("IOT_HTTP", localStringBuilder.toString());
  }
  
  private void O(TPIoTRequest<?> paramTPIoTRequest, SecurePassThroughResponse paramSecurePassThroughResponse)
  {
    int i1 = paramTPIoTRequest.hashCode();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("DeviceIdMD5: [");
    localStringBuilder.append(this.b.b());
    localStringBuilder.append("]\n");
    localStringBuilder.append("Response of Request@[");
    localStringBuilder.append(i1);
    localStringBuilder.append("] {\n");
    localStringBuilder.append("    method=");
    localStringBuilder.append(paramTPIoTRequest.getMethod());
    localStringBuilder.append("\n}\n");
    localStringBuilder.append("Response Start ====>\n");
    paramTPIoTRequest = paramSecurePassThroughResponse.getResult().getResponse();
    try
    {
      localStringBuilder.append(com.tplink.libtpnetwork.Utils.i.j(com.tplink.libtpnetwork.Utils.i.b(paramTPIoTRequest, com.google.gson.i.class)));
      localStringBuilder.append("\n");
    }
    catch (Exception paramSecurePassThroughResponse)
    {
      localStringBuilder.append(paramTPIoTRequest);
      localStringBuilder.append("\n");
    }
    localStringBuilder.append("<=============== END\n");
    b.d.w.c.a.c("IOT_HTTP", localStringBuilder.toString());
  }
  
  private <T> q<SecurePassThroughResponse> P(final TPIoTRequest<T> paramTPIoTRequest)
  {
    return this.i.Q0(1L).F(new a()).N(new p(paramTPIoTRequest));
  }
  
  private q<String> Q(DeviceAccountParams paramDeviceAccountParams, final String paramString)
  {
    final TPIoTRequest localTPIoTRequest = new TPIoTRequest();
    localTPIoTRequest.setMethod("account_sync");
    localTPIoTRequest.setParams(paramDeviceAccountParams);
    return A(C(localTPIoTRequest), paramString).g0(new n(localTPIoTRequest, paramString));
  }
  
  private void w()
  {
    if ((this.h.f()) && (!TextUtils.isEmpty(this.c.h()))) {
      this.i.onNext(new IoTDataWrapper(this.c.h()));
    }
    synchronized (this.j)
    {
      if ((!this.f) && ((!this.h.f()) || (TextUtils.isEmpty(this.c.h()))))
      {
        this.f = true;
        Object localObject2 = E();
        Object localObject3 = new com/tplink/libtpnetwork/IoTNetwork/transport/http/b$d;
        ((d)localObject3).<init>(this);
        q localq = ((q)localObject2).N((j)localObject3);
        localObject2 = new com/tplink/libtpnetwork/IoTNetwork/transport/http/b$b;
        ((b)localObject2).<init>(this);
        localObject3 = new com/tplink/libtpnetwork/IoTNetwork/transport/http/b$c;
        ((c)localObject3).<init>(this);
        localq.H0((io.reactivex.g0.g)localObject2, (io.reactivex.g0.g)localObject3);
      }
      return;
    }
  }
  
  private <T> q<HandShakeResponse> x(TPIoTRequest<T> paramTPIoTRequest)
  {
    return this.e.a(paramTPIoTRequest);
  }
  
  private <T> q<SecurePassThroughResponse> y(SecurePassThroughRequest paramSecurePassThroughRequest)
  {
    return this.e.c(paramSecurePassThroughRequest);
  }
  
  private <T> q<SecurePassThroughResponse> z(SecurePassThroughRequest paramSecurePassThroughRequest, String paramString)
  {
    return this.d.b(paramString, paramSecurePassThroughRequest);
  }
  
  public void B(Throwable paramThrowable)
  {
    if (J(paramThrowable)) {
      g(false);
    }
  }
  
  public q<String> K(final String paramString1, String paramString2, final boolean paramBoolean)
  {
    LoginDeviceRequest localLoginDeviceRequest = new LoginDeviceRequest();
    localLoginDeviceRequest.setUsername(Base64.encodeToString(b.d.w.h.a.h(paramString1).getBytes(), 2));
    localLoginDeviceRequest.setPassword(Base64.encodeToString(paramString2.getBytes(), 2));
    paramString1 = new TPIoTRequest();
    paramString1.setMethod("login_device");
    paramString1.setParams(localLoginDeviceRequest);
    return M(paramString1).N(new l(paramString1, paramBoolean));
  }
  
  public void R(c paramc)
  {
    if (!TextUtils.equals(this.b.d(), paramc.d()))
    {
      this.d = ((com.tplink.libtpnetwork.IoTNetwork.transport.http.e.a)new d(null).a(paramc.d(), com.tplink.libtpnetwork.IoTNetwork.transport.http.e.a.class, this.c, true));
      this.e = ((com.tplink.libtpnetwork.IoTNetwork.transport.http.e.a)new d(null).a(paramc.d(), com.tplink.libtpnetwork.IoTNetwork.transport.http.e.a.class, this.c, false));
    }
    this.b = paramc;
  }
  
  public void e()
  {
    io.reactivex.e0.c localc = this.k;
    if (localc != null)
    {
      localc.dispose();
      this.k = null;
    }
    super.e();
  }
  
  public <T> q<TPIoTResponse> f(final TPIoTRequest<T> paramTPIoTRequest)
    throws IoTTransportException
  {
    if (d()) {
      return P(paramTPIoTRequest).g0(new g(paramTPIoTRequest)).v0(1L, new f()).C(new e());
    }
    throw new IoTTransportException(1002);
  }
  
  class a
    implements io.reactivex.g0.g<io.reactivex.e0.c>
  {
    a() {}
    
    public void a(io.reactivex.e0.c paramc)
      throws Exception
    {
      b.v(b.this);
    }
  }
  
  class b
    implements io.reactivex.g0.g<String>
  {
    b() {}
    
    public void a(String paramString)
      throws Exception
    {
      b.j(b.this, false);
      b.k(b.this, System.currentTimeMillis());
      b.l(b.this).onNext(new IoTDataWrapper(paramString));
    }
  }
  
  class c
    implements io.reactivex.g0.g<Throwable>
  {
    c() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      b.j(b.this, false);
      b.h(b.this).d();
      b.h(b.this).l();
      paramThrowable.printStackTrace();
      b.l(b.this).onNext(new IoTDataWrapper(paramThrowable));
    }
  }
  
  class d
    implements j<HandShakeResponse, t<String>>
  {
    d() {}
    
    public t<String> a(HandShakeResponse paramHandShakeResponse)
      throws Exception
    {
      return b.m(b.this);
    }
  }
  
  class e
    implements io.reactivex.g0.g<Throwable>
  {
    e() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      b.this.B(paramThrowable);
    }
  }
  
  class f
    implements l<Throwable>
  {
    f() {}
    
    public boolean a(Throwable paramThrowable)
      throws Exception
    {
      return b.n(b.this, paramThrowable);
    }
  }
  
  class g
    implements j<SecurePassThroughResponse, TPIoTResponse>
  {
    g(TPIoTRequest paramTPIoTRequest) {}
    
    public TPIoTResponse a(SecurePassThroughResponse paramSecurePassThroughResponse)
      throws IoTTransportException
    {
      if (paramSecurePassThroughResponse != null)
      {
        if (paramSecurePassThroughResponse.getErrorCode() == 0)
        {
          TPIoTResponse localTPIoTResponse = new TPIoTResponse();
          if (paramSecurePassThroughResponse.getResult() != null)
          {
            paramSecurePassThroughResponse.getResult().setResponse(b.o(b.this).a(paramSecurePassThroughResponse.getResult().getResponse()));
            b.p(b.this, paramTPIoTRequest, paramSecurePassThroughResponse);
          }
          localTPIoTResponse.setErrorCode(paramSecurePassThroughResponse.getErrorCode());
          paramSecurePassThroughResponse = paramSecurePassThroughResponse.getResult();
          if ((paramSecurePassThroughResponse != null) && (paramSecurePassThroughResponse.getResponse() != null)) {
            localTPIoTResponse.setResult(paramSecurePassThroughResponse.getResponse());
          }
          return localTPIoTResponse;
        }
        throw new IoTTransportException(paramSecurePassThroughResponse.getErrorCode(), paramSecurePassThroughResponse.getErrMsg());
      }
      throw new IoTTransportException(1112, "response is null");
    }
  }
  
  class h
    extends q<String>
  {
    h() {}
    
    protected void K0(v<? super String> paramv)
    {
      paramv.onNext(b.h(b.this).h());
      paramv.onComplete();
    }
  }
  
  class i
    implements j<Integer, t<String>>
  {
    i() {}
    
    public t<String> a(Integer paramInteger)
      throws Exception
    {
      if (b.i(b.this) != null)
      {
        paramInteger = b.this;
        return paramInteger.K(b.i(paramInteger).e(), b.i(b.this).c(), true);
      }
      throw new IoTTransportException(-1, "param is null");
    }
  }
  
  class j
    implements l<String>
  {
    j() {}
    
    public boolean a(String paramString)
      throws Exception
    {
      return TextUtils.isEmpty(paramString) ^ true;
    }
  }
  
  class k
    implements io.reactivex.g0.g<HandShakeResponse>
  {
    k() {}
    
    public void a(HandShakeResponse paramHandShakeResponse)
      throws Exception
    {
      if ((paramHandShakeResponse != null) && (paramHandShakeResponse.getResult() != null) && (!TextUtils.isEmpty(paramHandShakeResponse.getResult().getKey())))
      {
        b.o(b.this).b(paramHandShakeResponse.getResult().getKey());
        return;
      }
      int i;
      if (paramHandShakeResponse == null) {
        i = 1100;
      } else {
        i = paramHandShakeResponse.getErrorCode();
      }
      if (paramHandShakeResponse == null)
      {
        paramHandShakeResponse = "hand shake response is null";
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramHandShakeResponse.getErrMsg());
        localStringBuilder.append(".");
        paramHandShakeResponse = localStringBuilder.toString();
      }
      throw new IoTTransportException(i, paramHandShakeResponse);
    }
  }
  
  class l
    implements j<SecurePassThroughResponse, t<String>>
  {
    l(TPIoTRequest paramTPIoTRequest, boolean paramBoolean) {}
    
    public t<String> a(SecurePassThroughResponse paramSecurePassThroughResponse)
      throws Exception
    {
      int i = 1111;
      if ((paramSecurePassThroughResponse != null) && (paramSecurePassThroughResponse.getErrorCode() == 0))
      {
        LoginDeviceResponse localLoginDeviceResponse = null;
        if (paramSecurePassThroughResponse.getResult() != null)
        {
          paramSecurePassThroughResponse.getResult().setResponse(b.o(b.this).a(paramSecurePassThroughResponse.getResult().getResponse()));
          b.p(b.this, paramString1, paramSecurePassThroughResponse);
          localLoginDeviceResponse = (LoginDeviceResponse)com.tplink.libtpnetwork.Utils.i.b(paramSecurePassThroughResponse.getResult().getResponse(), LoginDeviceResponse.class);
        }
        if ((localLoginDeviceResponse != null) && (localLoginDeviceResponse.getErrorCode() == 9998) && (b.i(b.this) != null) && (!TextUtils.isEmpty(b.i(b.this).a())) && (paramBoolean))
        {
          b.d.w.c.a.e("ffs", "FFS login in devices failed, 9998");
          return b.q(b.this);
        }
        if ((localLoginDeviceResponse != null) && (localLoginDeviceResponse.getErrorCode() == 0))
        {
          paramSecurePassThroughResponse = localLoginDeviceResponse.getResult().getToken();
          b.h(b.this).m(paramSecurePassThroughResponse);
          return q.f0(paramSecurePassThroughResponse);
        }
        if (localLoginDeviceResponse != null) {
          i = localLoginDeviceResponse.getErrorCode();
        }
        throw new IoTTransportException(i, "login in devices failed ");
      }
      if (paramSecurePassThroughResponse != null) {
        i = paramSecurePassThroughResponse.getErrorCode();
      }
      if (paramSecurePassThroughResponse == null) {
        paramSecurePassThroughResponse = "login Response is null ";
      } else {
        paramSecurePassThroughResponse = paramSecurePassThroughResponse.getErrMsg();
      }
      throw new IoTTransportException(i, paramSecurePassThroughResponse);
    }
  }
  
  class m
    implements j<String, t<String>>
  {
    m() {}
    
    public t<String> a(String paramString)
      throws Exception
    {
      b.h(b.this).m(paramString);
      DeviceAccountParams localDeviceAccountParams = new DeviceAccountParams();
      localDeviceAccountParams.setDeviceAccount(new DeviceAccountBean(b.i(b.this).e(), b.i(b.this).c()));
      return b.r(b.this, localDeviceAccountParams, paramString);
    }
  }
  
  class n
    implements j<SecurePassThroughResponse, String>
  {
    n(TPIoTRequest paramTPIoTRequest, String paramString) {}
    
    public String a(SecurePassThroughResponse paramSecurePassThroughResponse)
      throws Exception
    {
      int i = 1111;
      if ((paramSecurePassThroughResponse != null) && (paramSecurePassThroughResponse.getErrorCode() == 0))
      {
        IoTResult localIoTResult = null;
        if (paramSecurePassThroughResponse.getResult() != null)
        {
          paramSecurePassThroughResponse.getResult().setResponse(b.o(b.this).a(paramSecurePassThroughResponse.getResult().getResponse()));
          b.p(b.this, localTPIoTRequest, paramSecurePassThroughResponse);
          localIoTResult = (IoTResult)com.tplink.libtpnetwork.Utils.i.b(paramSecurePassThroughResponse.getResult().getResponse(), IoTResult.class);
        }
        if ((localIoTResult != null) && (localIoTResult.getErrCode() == 0)) {
          return paramString;
        }
        if (localIoTResult != null) {
          i = localIoTResult.getErrCode();
        }
        throw new IoTTransportException(i, "FSS sync device account failed");
      }
      if (paramSecurePassThroughResponse != null) {
        i = paramSecurePassThroughResponse.getErrorCode();
      }
      if (paramSecurePassThroughResponse == null) {
        paramSecurePassThroughResponse = "FFS sync Account Response is null ";
      } else {
        paramSecurePassThroughResponse = paramSecurePassThroughResponse.getErrMsg();
      }
      throw new IoTTransportException(i, paramSecurePassThroughResponse);
    }
  }
  
  class o
    implements j<HandShakeResponse, t<SecurePassThroughResponse>>
  {
    o(TPIoTRequest paramTPIoTRequest) {}
    
    public t<SecurePassThroughResponse> a(HandShakeResponse paramHandShakeResponse)
      throws Exception
    {
      paramHandShakeResponse = b.this;
      return b.t(paramHandShakeResponse, b.s(paramHandShakeResponse, paramTPIoTRequest));
    }
  }
  
  class p
    implements j<IoTDataWrapper<String>, t<SecurePassThroughResponse>>
  {
    p(TPIoTRequest paramTPIoTRequest) {}
    
    public t<SecurePassThroughResponse> a(IoTDataWrapper<String> paramIoTDataWrapper)
      throws Exception
    {
      if (paramIoTDataWrapper.getData() == null) {
        return q.J(paramIoTDataWrapper.getThrowable());
      }
      if ("login_device_test".equals(paramTPIoTRequest.getMethod())) {
        return q.f0(new SecurePassThroughResponse(0));
      }
      b localb = b.this;
      return b.u(localb, b.s(localb, paramTPIoTRequest), (String)paramIoTDataWrapper.getData());
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\transport\http\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */