package com.tplink.iot.viewmodel.ipcamera.memories;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableField;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import b.d.q.b.i;
import com.tplink.libtpmediaother.memory.MemoryBean;
import com.tplink.libtpmediaother.memory.r;
import com.tplink.libtpmediaother.memory.r.d;
import com.tplink.libtpmediaother.memory.s;
import io.reactivex.q;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MemoriesViewModel
  extends AndroidViewModel
{
  r a = r.f();
  s b;
  public ObservableBoolean c = new ObservableBoolean(false);
  public ObservableBoolean d = new ObservableBoolean(false);
  public ObservableBoolean e = new ObservableBoolean(false);
  public ObservableBoolean f = new ObservableBoolean(false);
  public ObservableBoolean g = new ObservableBoolean(false);
  public ObservableBoolean h = new ObservableBoolean(false);
  public ObservableBoolean i = new ObservableBoolean(true);
  public ObservableField<CharSequence> j = new ObservableField();
  public ObservableField<String> k = new ObservableField();
  public ObservableBoolean l = new ObservableBoolean(false);
  public ObservableBoolean m = new ObservableBoolean(false);
  public int n = 0;
  public ObservableBoolean o = new ObservableBoolean(false);
  private MutableLiveData<List<MemoryBean>> p = new MutableLiveData();
  public final MutableLiveData<com.tplink.libtpnetwork.cameranetwork.lifecycleutils.a<String>> q = new MutableLiveData();
  private io.reactivex.e0.b r = new io.reactivex.e0.b();
  
  public MemoriesViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    z();
  }
  
  private void A()
  {
    this.a.J(this.b);
  }
  
  private void z()
  {
    a locala = new a();
    this.b = locala;
    this.a.b(locala);
  }
  
  public void g(List<MemoryBean> paramList)
  {
    paramList = r.f().d(paramList).F(new c(this)).y(new f(this)).H0(new d(this), g.c);
    this.r.b(paramList);
  }
  
  public void h(MemoryBean paramMemoryBean)
  {
    paramMemoryBean = this.a.e(paramMemoryBean).F(new b(this)).y(new e(this)).H0(new a(this), g.c);
    this.r.b(paramMemoryBean);
  }
  
  public MutableLiveData<List<MemoryBean>> i()
  {
    return this.p;
  }
  
  protected void onCleared()
  {
    super.onCleared();
    A();
    this.r.d();
  }
  
  public void w()
  {
    r.d locald = new r.d();
    locald.a(i.a());
    this.a.C(locald);
  }
  
  public void x(r.d paramd)
  {
    paramd.a(i.a());
    this.a.C(paramd);
  }
  
  public void y(MemoryBean paramMemoryBean)
  {
    this.a.G(paramMemoryBean);
  }
  
  class a
    implements s
  {
    a() {}
    
    public void a() {}
    
    public void b(List<MemoryBean> paramList)
    {
      if ((paramList != null) && (paramList.size() > 0))
      {
        for (int i = 0; (i < paramList.size()) && (!new File(((MemoryBean)paramList.get(i)).getThumbnailPath()).exists()); i++) {}
        if (i >= paramList.size())
        {
          MemoriesViewModel.f(MemoriesViewModel.this).postValue(new ArrayList());
          return;
        }
        ArrayList localArrayList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          MemoryBean localMemoryBean = (MemoryBean)paramList.next();
          if (!new File(localMemoryBean.getThumbnailPath()).exists()) {
            r.f().E(localMemoryBean);
          } else {
            localArrayList.add(localMemoryBean);
          }
        }
        MemoriesViewModel.f(MemoriesViewModel.this).postValue(localArrayList);
        return;
      }
      MemoriesViewModel.f(MemoriesViewModel.this).postValue(new ArrayList());
    }
    
    public void c() {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\memories\MemoriesViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */