package com.tplink.iot.viewmodel.signup;

import android.annotation.SuppressLint;
import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.define.CloudException;
import com.tplink.cloud.define.EnumAccountStatus;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCAccountRepository;
import com.tplink.libtpnetwork.TPCloudNetwork.repository.TCProtocolRepository;
import com.tplink.libtpnetwork.Utils.x;
import io.reactivex.e;
import io.reactivex.e0.c;
import io.reactivex.g0.g;
import io.reactivex.g0.j;
import io.reactivex.q;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class SignUpViewModel
  extends AndroidViewModel
{
  private TCAccountRepository a;
  private TCProtocolRepository b;
  private MutableLiveData<Boolean> c = new MutableLiveData();
  private MutableLiveData<CloudException> d = new MutableLiveData();
  
  public SignUpViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = b.d.b.f.b.c(b.d.s.a.a.f());
    this.a = ((TCAccountRepository)paramApplication.a(TCAccountRepository.class));
    this.b = ((TCProtocolRepository)paramApplication.a(TCProtocolRepository.class));
  }
  
  public LiveData<Boolean> h()
  {
    return this.c;
  }
  
  public LiveData<CloudException> i()
  {
    return this.d;
  }
  
  @SuppressLint({"CheckResult"})
  public void j(final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean)
  {
    this.a.t(paramString1).R(new d(paramBoolean, paramString1, paramString2, paramString3)).C(io.reactivex.l0.a.c()).l(new c()).A(new a(), new b());
  }
  
  public void k()
  {
    boolean bool = this.b.f();
    if (!bool) {
      this.b.e().L0(io.reactivex.l0.a.c()).F0();
    }
    this.c.setValue(Boolean.valueOf(bool));
  }
  
  class a
    implements io.reactivex.g0.a
  {
    a() {}
    
    public void run()
      throws Exception
    {
      SignUpViewModel.f(SignUpViewModel.this).postValue(new CloudException(0, ""));
    }
  }
  
  class b
    implements g<Throwable>
  {
    b() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      if ((paramThrowable instanceof CloudException)) {
        SignUpViewModel.f(SignUpViewModel.this).postValue((CloudException)paramThrowable);
      } else {
        SignUpViewModel.f(SignUpViewModel.this).postValue(new CloudException(-1, ""));
      }
    }
  }
  
  class c
    implements g<c>
  {
    c() {}
    
    public void a(c paramc)
      throws Exception
    {
      SignUpViewModel.f(SignUpViewModel.this).setValue(null);
    }
  }
  
  class d
    implements j<Integer, e>
  {
    d(boolean paramBoolean, String paramString1, String paramString2, String paramString3) {}
    
    public e a(Integer paramInteger)
      throws Exception
    {
      if (paramInteger.intValue() == EnumAccountStatus.ACCOUNT_STATUS_NORMAL.getValue()) {
        return io.reactivex.a.m(new CloudException(16, "ERR_ACCOUNT_REGISTERED"));
      }
      if (paramInteger.intValue() == EnumAccountStatus.ACCOUNT_STATUS_LOCKED.getValue()) {
        return io.reactivex.a.m(new CloudException(17, "ERR_ACCOUNT_LOCKED"));
      }
      if (paramInteger.intValue() == EnumAccountStatus.ACCOUNT_STATUS_UNACTIVATED.getValue()) {
        return io.reactivex.a.m(new CloudException(19, "MSG_ERR_ACCOUNT_UNACTIVATED"));
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("GlobalMarketing", Boolean.valueOf(paramBoolean));
      paramInteger = SignUpViewModel.g(SignUpViewModel.this);
      String str = paramString1;
      return paramInteger.M(str, b.d.w.h.b.b(str), paramString2, x.d(Locale.getDefault()), paramString3, "NBU", localHashMap);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\signup\SignUpViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */