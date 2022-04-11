package com.tplink.iot.view.home.f0.c;

import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.view.home.f0.b.b;

public class c
  implements b
{
  private MutableLiveData<Boolean> a;
  
  public c(MutableLiveData<Boolean> paramMutableLiveData)
  {
    this.a = paramMutableLiveData;
  }
  
  public int a()
  {
    return 1200;
  }
  
  public String b()
  {
    return "dialog_flag_long_press";
  }
  
  public void clear()
  {
    this.a.postValue(null);
  }
  
  public void show()
  {
    this.a.postValue(Boolean.TRUE);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\home\f0\c\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */