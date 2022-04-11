package com.tplink.iot.viewmodel.ipcamera.memories;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.tplink.libtpmediaother.memory.p;
import com.tplink.libtpmediaother.memory.r;
import com.tplink.libtpmediaother.memory.t;
import java.util.ArrayList;
import java.util.List;

public class MemoriesFilterViewModel
  extends AndroidViewModel
{
  r a = r.f();
  t b;
  public ObservableBoolean c = new ObservableBoolean(false);
  public ObservableBoolean d = new ObservableBoolean(false);
  public ObservableBoolean e = new ObservableBoolean(false);
  public ObservableBoolean f = new ObservableBoolean(false);
  public ObservableBoolean g = new ObservableBoolean(false);
  public ObservableBoolean h = new ObservableBoolean(true);
  private MutableLiveData<List<p>> i = new MutableLiveData();
  
  public MemoriesFilterViewModel(@NonNull Application paramApplication)
  {
    super(paramApplication);
    i();
  }
  
  private void i()
  {
    a locala = new a();
    this.b = locala;
    this.a.a(locala);
  }
  
  private void j()
  {
    this.a.I(this.b);
  }
  
  public MutableLiveData<List<p>> g()
  {
    return this.i;
  }
  
  public void h()
  {
    this.a.B();
  }
  
  protected void onCleared()
  {
    super.onCleared();
    j();
  }
  
  class a
    implements t
  {
    a() {}
    
    public void a(List<p> paramList)
    {
      if (paramList != null)
      {
        paramList = new ArrayList(paramList);
        MemoriesFilterViewModel.f(MemoriesFilterViewModel.this).postValue(paramList);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\ipcamera\memories\MemoriesFilterViewModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */