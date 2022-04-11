package com.tplink.iot.viewmodel.authflip;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpgoogleassistant.repository.OAuthCloudRepository;
import com.tplink.libtpnetwork.Utils.SingleLiveEvent;
import com.tplink.libtpnetwork.libwss.GoogleAssistantRepository;
import io.reactivex.g0.g;
import io.reactivex.q;

public class GoogleAssistantViewModel
  extends AndroidViewModel
{
  private OAuthCloudRepository a;
  private GoogleAssistantRepository b;
  private MutableLiveData<Boolean> c = new MutableLiveData();
  private SingleLiveEvent<Integer> d = new SingleLiveEvent();
  
  public GoogleAssistantViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    paramApplication = b.d.s.a.a.f();
    this.a = ((OAuthCloudRepository)b.d.b.f.b.c(paramApplication).a(OAuthCloudRepository.class));
    this.b = ((GoogleAssistantRepository)b.d.b.f.b.c(paramApplication).a(GoogleAssistantRepository.class));
  }
  
  public void g()
  {
    this.b.h("tapo").E(new d(this)).C(new a(this)).F0();
  }
  
  public LiveData<Boolean> h()
  {
    return this.c;
  }
  
  public SingleLiveEvent<Integer> i()
  {
    return this.d;
  }
  
  public void s()
  {
    this.b.i("tapo").l(new a()).i(new c(this)).j(new b(this)).y();
  }
  
  class a
    implements g<io.reactivex.e0.c>
  {
    a() {}
    
    public void a(io.reactivex.e0.c paramc)
      throws Exception
    {
      GoogleAssistantViewModel.f(GoogleAssistantViewModel.this).postValue(Integer.valueOf(-100));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\authflip\GoogleAssistantViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */