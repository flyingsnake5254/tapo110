package com.tplink.libtpnetwork.cameranetwork.business.repo;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.cameranetwork.TPCameraDeviceContext;
import com.tplink.libtpnetwork.cameranetwork.f4;
import com.tplink.libtpnetwork.cameranetwork.g4.m;
import com.tplink.libtpnetwork.cameranetwork.model.DiagnoseStatus;
import com.tplink.libtpnetwork.cameranetwork.model.SystemInfo;
import com.tplink.libtpnetwork.cameranetwork.net.CameraException;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.q;
import io.reactivex.t;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;
import okhttp3.ResponseBody;

public class LdcDianoseSettingRepository
  extends com.tplink.libtpnetwork.cameranetwork.business.repo.l7.c
{
  private MutableLiveData<Boolean> d = new MutableLiveData();
  private MutableLiveData<Boolean> e = new MutableLiveData();
  private MutableLiveData<Boolean> f = new MutableLiveData();
  
  public LdcDianoseSettingRepository(TPCameraDeviceContext paramTPCameraDeviceContext)
  {
    super(paramTPCameraDeviceContext);
  }
  
  private void A(Throwable paramThrowable)
  {
    boolean bool = paramThrowable instanceof CameraException;
  }
  
  private q<Boolean> V(boolean paramBoolean)
  {
    if (paramBoolean) {
      return this.c.v2(false).i(m.g()).L0(io.reactivex.l0.a.c()).N(new e()).C(f7.c);
    }
    return this.c.v2(true).i(m.g()).L0(io.reactivex.l0.a.c()).C(f7.c);
  }
  
  public q<Boolean> S(final boolean paramBoolean)
  {
    q localq = this.c.L().i(m.a()).L0(io.reactivex.l0.a.c()).g0(t2.c);
    f7 localf7 = f7.c;
    return q.f(localq.C(localf7), this.c.M().i(m.a()).L0(io.reactivex.l0.a.c()), new b()).E(new o2(this)).E(new a(paramBoolean)).C(localf7);
  }
  
  public q<Boolean> T()
  {
    return this.c.U().i(m.a()).L0(io.reactivex.l0.a.c()).g0(u2.c).E(new p2(this)).C(f7.c);
  }
  
  public q<Boolean> U(boolean paramBoolean)
  {
    if (!paramBoolean) {
      return this.c.v2(false).C(f7.c).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new s2(this)).C(new m2(this)).g0(r2.c);
    }
    return this.c.L().i(m.a()).L0(io.reactivex.l0.a.c()).N(new d()).N(new c()).C(new q2(this));
  }
  
  public q<Boolean> W(boolean paramBoolean)
  {
    return this.c.B2(paramBoolean).C(f7.c).i(m.g()).L0(io.reactivex.l0.a.c()).l0(io.reactivex.d0.b.a.a()).E(new v2(this, paramBoolean)).C(new l2(this, paramBoolean)).g0(n2.c);
  }
  
  public q<String> v()
  {
    return this.c.t().L0(io.reactivex.l0.a.c()).N(new g()).C(f7.c);
  }
  
  public q<String> w()
  {
    return S(false).L0(io.reactivex.l0.a.c()).N(new f()).C(f7.c);
  }
  
  public MutableLiveData<Boolean> x()
  {
    return this.e;
  }
  
  public MutableLiveData<Boolean> y()
  {
    return this.d;
  }
  
  public MutableLiveData<Boolean> z()
  {
    return this.f;
  }
  
  class a
    implements g<Boolean>
  {
    a(boolean paramBoolean) {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      if ((paramBoolean) && (paramBoolean != null) && (!paramBoolean.booleanValue())) {
        LdcDianoseSettingRepository.s(LdcDianoseSettingRepository.this).postValue(Boolean.TRUE);
      }
    }
  }
  
  class b
    implements io.reactivex.g0.c<Boolean, DiagnoseStatus, Boolean>
  {
    b() {}
    
    public Boolean a(Boolean paramBoolean, DiagnoseStatus paramDiagnoseStatus)
      throws Exception
    {
      boolean bool;
      if ((paramBoolean != null) && (paramBoolean.booleanValue()) && (paramDiagnoseStatus != null) && (TextUtils.equals(paramDiagnoseStatus.getStatus(), "running"))) {
        bool = true;
      } else {
        bool = false;
      }
      return Boolean.valueOf(bool);
    }
  }
  
  class c
    implements j<Boolean, t<Boolean>>
  {
    c() {}
    
    public t<Boolean> a(Boolean paramBoolean)
      throws Exception
    {
      return LdcDianoseSettingRepository.this.S(true).r(1L, TimeUnit.SECONDS);
    }
  }
  
  class d
    implements j<SystemInfo, t<Boolean>>
  {
    d() {}
    
    public t<Boolean> a(SystemInfo paramSystemInfo)
      throws Exception
    {
      return LdcDianoseSettingRepository.t(LdcDianoseSettingRepository.this, TextUtils.equals(paramSystemInfo.getDiagnoseMode(), "on"));
    }
  }
  
  class e
    implements j<Boolean, t<Boolean>>
  {
    e() {}
    
    public t<Boolean> a(Boolean paramBoolean)
      throws Exception
    {
      return LdcDianoseSettingRepository.u(LdcDianoseSettingRepository.this).v2(true).i(m.g()).L0(io.reactivex.l0.a.c()).C(f7.c);
    }
  }
  
  class f
    implements j<Boolean, t<String>>
  {
    f() {}
    
    public t<String> a(Boolean paramBoolean)
      throws Exception
    {
      if ((paramBoolean != null) && (paramBoolean.booleanValue())) {
        return LdcDianoseSettingRepository.this.v();
      }
      return q.f0("");
    }
  }
  
  class g
    implements j<ResponseBody, t<String>>
  {
    g() {}
    
    public t<String> a(ResponseBody paramResponseBody)
      throws Exception
    {
      InputStream localInputStream = paramResponseBody.byteStream();
      paramResponseBody = new ByteArrayOutputStream();
      Object localObject = new byte['Ѐ'];
      for (;;)
      {
        int i = localInputStream.read((byte[])localObject);
        if (i == -1) {
          break;
        }
        paramResponseBody.write((byte[])localObject, 0, i);
        paramResponseBody.flush();
      }
      localObject = paramResponseBody.toString();
      paramResponseBody.close();
      return q.f0(localObject);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\business\repo\LdcDianoseSettingRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */