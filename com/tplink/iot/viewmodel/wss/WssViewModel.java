package com.tplink.iot.viewmodel.wss;

import android.app.Application;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.libwss.TapoAlexaCloudRepository;
import com.tplink.libtpnetwork.libwss.WssCloudRepository;
import com.tplink.libtpnetwork.libwss.bean.params.SkillActiveParams;
import com.tplink.libtpnetwork.libwss.bean.result.AlexaLinkInfoResult;
import com.tplink.libtpnetwork.libwss.enumerate.WssAccountBindState;
import io.reactivex.q;

public class WssViewModel
  extends AndroidViewModel
{
  private TapoAlexaCloudRepository a;
  private WssCloudRepository b;
  private MutableLiveData<WssAccountBindState> c = new MutableLiveData();
  private SingleLiveEvent<Boolean> d = new SingleLiveEvent();
  private SingleLiveEvent<Boolean> e = new SingleLiveEvent();
  private SingleLiveEvent<Integer> f = new SingleLiveEvent();
  private SingleLiveEvent<Boolean> g = new SingleLiveEvent();
  private SingleLiveEvent<Boolean> h = new SingleLiveEvent();
  private MutableLiveData<AlexaLinkInfoResult> i = new MutableLiveData();
  
  public WssViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = b.d.s.a.a.f();
    this.b = ((WssCloudRepository)b.d.b.f.b.c(paramApplication).a(WssCloudRepository.class));
    this.a = ((TapoAlexaCloudRepository)b.d.b.f.b.c(paramApplication).a(TapoAlexaCloudRepository.class));
  }
  
  private void g(SkillActiveParams paramSkillActiveParams)
  {
    this.e.postValue(Boolean.TRUE);
    this.a.f("tapo", paramSkillActiveParams).i(new b(this)).j(new a(this)).y();
  }
  
  public void H()
  {
    this.b.j("tapo").l(new h(this)).h(new d(this)).i(new g(this)).j(new e(this)).y();
  }
  
  public void h(SkillActiveParams paramSkillActiveParams)
  {
    this.b.f("tapo", paramSkillActiveParams).i(new b()).j(new a()).y();
  }
  
  public void i()
  {
    this.e.postValue(Boolean.TRUE);
    this.a.g("tapo").E(new c(this)).C(new f(this)).F0();
  }
  
  public SingleLiveEvent<Boolean> j()
  {
    return this.d;
  }
  
  public SingleLiveEvent<Boolean> k()
  {
    return this.g;
  }
  
  public SingleLiveEvent<Boolean> l()
  {
    return this.h;
  }
  
  public SingleLiveEvent<Boolean> m()
  {
    return this.e;
  }
  
  public SingleLiveEvent<Integer> n()
  {
    return this.f;
  }
  
  public MutableLiveData<AlexaLinkInfoResult> o()
  {
    return this.i;
  }
  
  public void p(Uri paramUri)
  {
    if (paramUri == null) {
      return;
    }
    String str1 = paramUri.getQueryParameter("error");
    String str2 = paramUri.getQueryParameter("code");
    paramUri = paramUri.getQueryParameter("state");
    SkillActiveParams localSkillActiveParams = new SkillActiveParams();
    localSkillActiveParams.setError(str1);
    localSkillActiveParams.setCode(str2);
    localSkillActiveParams.setState(paramUri);
    g(localSkillActiveParams);
  }
  
  class a
    implements io.reactivex.g0.g<Throwable>
  {
    a() {}
    
    public void a(Throwable paramThrowable)
      throws Exception
    {
      b.d.w.c.a.e("wss", "skill fail");
      WssViewModel.f(WssViewModel.this).postValue(Boolean.FALSE);
    }
  }
  
  class b
    implements io.reactivex.g0.a
  {
    b() {}
    
    public void run()
      throws Exception
    {
      b.d.w.c.a.e("wss", "skill success");
      WssViewModel.f(WssViewModel.this).postValue(Boolean.TRUE);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\wss\WssViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */