package com.tplink.iot.view.home.f0.c;

import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.view.home.f0.b.b;

public class f
  implements b
{
  private MutableLiveData<Integer> a;
  private int b;
  
  public f(MutableLiveData<Integer> paramMutableLiveData, int paramInt)
  {
    this.a = paramMutableLiveData;
    this.b = paramInt;
  }
  
  public int a()
  {
    return 1000;
  }
  
  public String b()
  {
    return "dialog_flag_voice_control_guide";
  }
  
  public void clear()
  {
    this.a.postValue(null);
  }
  
  public void show()
  {
    this.a.postValue(Integer.valueOf(this.b));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\home\f0\c\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */