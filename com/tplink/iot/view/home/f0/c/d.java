package com.tplink.iot.view.home.f0.c;

import androidx.lifecycle.MutableLiveData;
import com.tplink.iot.view.home.f0.b.b;

public class d
  implements b
{
  private MutableLiveData<com.tplink.iot.model.home.d> a;
  private com.tplink.iot.model.home.d b;
  
  public d(MutableLiveData<com.tplink.iot.model.home.d> paramMutableLiveData, com.tplink.iot.model.home.d paramd)
  {
    this.a = paramMutableLiveData;
    this.b = paramd;
  }
  
  public int a()
  {
    return 1300;
  }
  
  public String b()
  {
    return "dialog_flag_tapo_care_downgrade";
  }
  
  public void clear() {}
  
  public void show()
  {
    this.a.postValue(this.b);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\home\f0\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */