package com.tplink.iot.view.home.f0.c;

import androidx.lifecycle.MutableLiveData;
import com.tplink.libtpnetwork.TDPNetwork.bean.TDPIoTDevice;
import java.util.List;

public class b
  implements com.tplink.iot.view.home.f0.b.b
{
  private final MutableLiveData<List<TDPIoTDevice>> a;
  private final List<TDPIoTDevice> b;
  
  public b(MutableLiveData<List<TDPIoTDevice>> paramMutableLiveData, List<TDPIoTDevice> paramList)
  {
    this.a = paramMutableLiveData;
    this.b = paramList;
  }
  
  public int a()
  {
    return 1150;
  }
  
  public String b()
  {
    return "dialog_flag_discovery_device";
  }
  
  public void clear() {}
  
  public void show()
  {
    this.a.postValue(this.b);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\view\home\f0\c\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */