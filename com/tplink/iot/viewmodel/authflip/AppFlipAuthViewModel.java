package com.tplink.iot.viewmodel.authflip;

import android.annotation.SuppressLint;
import android.app.Application;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.bean.account.result.LoginV1Result;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.define.CloudException;
import com.tplink.iot.core.n;
import com.tplink.iot.thirdpartlink.ThirdPartLinkNetworkType;
import com.tplink.libtpgoogleassistant.bean.params.AuthCodeParams;
import com.tplink.libtpgoogleassistant.bean.result.AuthCodeResult;
import com.tplink.libtpgoogleassistant.bean.result.AuthResult;
import com.tplink.libtpgoogleassistant.repository.OAuthCloudRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.exception.CloudAccountV1Exception;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAccountRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.Utils.x;
import io.reactivex.g0.g;
import io.reactivex.q;
import java.util.Locale;

public class AppFlipAuthViewModel
  extends AndroidViewModel
{
  private TCAccountRepository a;
  private OAuthCloudRepository b;
  private MutableLiveData<String> c = new MutableLiveData();
  private SingleLiveEvent<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<com.tplink.iot.viewmodel.quicksetup.i<LoginV1Result>>> d = new SingleLiveEvent();
  private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> e = new MutableLiveData();
  private MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> f = new MutableLiveData();
  private String g;
  private String h;
  private ThirdPartLinkNetworkType i;
  
  public AppFlipAuthViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = b.d.s.a.a.f();
    this.a = ((TCAccountRepository)b.d.b.f.b.a(b.d.s.a.a.f(), TCAccountRepository.class));
    this.b = ((OAuthCloudRepository)b.d.b.f.b.c(paramApplication).a(OAuthCloudRepository.class));
    A(r());
  }
  
  private void l()
  {
    this.a.q();
  }
  
  public void A(String paramString)
  {
    this.h = paramString;
  }
  
  public void B(String paramString)
  {
    this.g = paramString;
  }
  
  @SuppressLint({"CheckResult"})
  public void k(String paramString)
  {
    if (!this.a.y()) {
      this.e.setValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(-99)));
    } else {
      this.a.t(paramString).L0(io.reactivex.l0.a.c()).H0(new e(), new f());
    }
  }
  
  public String m()
  {
    Object localObject = b.d.s.a.a.f();
    if (localObject != null)
    {
      localObject = ((com.tplink.cloud.context.b)localObject).c();
      if (localObject != null) {
        return ((TCAccountBean)localObject).getToken();
      }
    }
    return null;
  }
  
  @SuppressLint({"CheckResult"})
  public void n(AuthCodeParams paramAuthCodeParams)
  {
    this.b.d(paramAuthCodeParams).H0(new a(), new b());
  }
  
  public MutableLiveData<String> o()
  {
    return this.c;
  }
  
  public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> p()
  {
    return this.e;
  }
  
  public String r()
  {
    Object localObject = b.d.s.a.a.f();
    if (localObject != null)
    {
      localObject = ((com.tplink.cloud.context.b)localObject).c();
      if (localObject != null) {
        return ((TCAccountBean)localObject).getCloudUserName();
      }
    }
    return null;
  }
  
  public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<com.tplink.iot.viewmodel.quicksetup.i<LoginV1Result>>> s()
  {
    return this.d;
  }
  
  public ThirdPartLinkNetworkType t()
  {
    return this.i;
  }
  
  public LiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<Integer>> u()
  {
    return this.f;
  }
  
  public String v()
  {
    if (!TextUtils.isEmpty(this.h)) {
      return this.h;
    }
    return "";
  }
  
  public String w()
  {
    return this.g;
  }
  
  @SuppressLint({"CheckResult"})
  public void x(String paramString1, String paramString2)
  {
    paramString1 = new TCAccountBean(paramString1, paramString2);
    paramString2 = n.a();
    this.a.C(paramString1, paramString2.b(), paramString2.g(), paramString2.f(), paramString2.c(), false).L0(io.reactivex.l0.a.c()).H0(new c(), new d());
  }
  
  @SuppressLint({"CheckResult"})
  public void y(String paramString)
  {
    this.a.v(paramString, x.d(Locale.getDefault())).C(io.reactivex.l0.a.c()).A(new g(), new h());
  }
  
  public void z(ThirdPartLinkNetworkType paramThirdPartLinkNetworkType)
  {
    this.i = paramThirdPartLinkNetworkType;
  }
  
  class a
    implements g<AuthResult<AuthCodeResult>>
  {
    a() {}
    
    public void a(AuthResult<AuthCodeResult> paramAuthResult)
      throws Exception
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("result=");
      localStringBuilder.append(com.tplink.libtpnetwork.Utils.i.f(paramAuthResult));
      b.d.w.c.a.e("getAuthCode", localStringBuilder.toString());
      if (paramAuthResult != null)
      {
        if (paramAuthResult.getErrorCode() == 0)
        {
          paramAuthResult = (AuthCodeResult)paramAuthResult.getResult();
          if (paramAuthResult != null) {
            AppFlipAuthViewModel.f(AppFlipAuthViewModel.this).postValue(paramAuthResult.getAuthCode());
          } else {
            AppFlipAuthViewModel.f(AppFlipAuthViewModel.this).postValue(null);
          }
        }
        else
        {
          AppFlipAuthViewModel.f(AppFlipAuthViewModel.this).postValue(null);
        }
      }
      else {
        AppFlipAuthViewModel.f(AppFlipAuthViewModel.this).postValue(null);
      }
    }
  }
  
  class b
    implements g<Throwable>
  {
    b() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      paramThrowable.printStackTrace();
      b.d.w.c.a.e("getAuthCode", "result=error");
      AppFlipAuthViewModel.f(AppFlipAuthViewModel.this).postValue(null);
    }
  }
  
  class c
    implements g<Boolean>
  {
    c() {}
    
    public void a(Boolean paramBoolean)
      throws Exception
    {
      if (paramBoolean.booleanValue())
      {
        paramBoolean = new com.tplink.iot.viewmodel.quicksetup.i(0, new LoginV1Result());
      }
      else
      {
        AppFlipAuthViewModel.g(AppFlipAuthViewModel.this);
        paramBoolean = new com.tplink.iot.viewmodel.quicksetup.i(1, null);
      }
      AppFlipAuthViewModel.h(AppFlipAuthViewModel.this).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(paramBoolean));
    }
  }
  
  class d
    implements g<Throwable>
  {
    d() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      AppFlipAuthViewModel.g(AppFlipAuthViewModel.this);
      if ((paramThrowable instanceof CloudAccountV1Exception)) {
        paramThrowable = new com.tplink.iot.viewmodel.quicksetup.i(0, ((CloudAccountV1Exception)paramThrowable).getLoginV1Result());
      } else {
        paramThrowable = new com.tplink.iot.viewmodel.quicksetup.i(1, null);
      }
      AppFlipAuthViewModel.h(AppFlipAuthViewModel.this).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(paramThrowable));
    }
  }
  
  class e
    implements g<Integer>
  {
    e() {}
    
    public void a(Integer paramInteger)
      throws Exception
    {
      int i = paramInteger.intValue();
      int j = 16;
      int k;
      if (i != 0)
      {
        k = j;
        if (i != 1) {
          if (i != 2)
          {
            if (i != 3) {
              k = j;
            } else {
              k = 19;
            }
          }
          else {
            k = 17;
          }
        }
      }
      else
      {
        k = 18;
      }
      AppFlipAuthViewModel.i(AppFlipAuthViewModel.this).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(k)));
    }
  }
  
  class f
    implements g<Throwable>
  {
    f() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if ((paramThrowable instanceof CloudException)) {
        AppFlipAuthViewModel.i(AppFlipAuthViewModel.this).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(((CloudException)paramThrowable).getErrCode())));
      } else {
        AppFlipAuthViewModel.i(AppFlipAuthViewModel.this).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(-1)));
      }
    }
  }
  
  class g
    implements io.reactivex.g0.a
  {
    g() {}
    
    public void run()
      throws Exception
    {
      AppFlipAuthViewModel.j(AppFlipAuthViewModel.this).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(0)));
    }
  }
  
  class h
    implements g<Throwable>
  {
    h() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if ((paramThrowable instanceof CloudException)) {
        AppFlipAuthViewModel.j(AppFlipAuthViewModel.this).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(((CloudException)paramThrowable).getErrCode())));
      } else {
        AppFlipAuthViewModel.j(AppFlipAuthViewModel.this).postValue(new com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a(Integer.valueOf(-1)));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\authflip\AppFlipAuthViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */