package com.tplink.iot.cloud.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttMessageListener;

public class r0
{
  private String a;
  private int b;
  private IMqttMessageListener c;
  
  public r0(String paramString, int paramInt, IMqttMessageListener paramIMqttMessageListener)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramIMqttMessageListener;
  }
  
  public IMqttMessageListener a()
  {
    return this.c;
  }
  
  public int b()
  {
    return this.b;
  }
  
  public boolean c()
  {
    int i = this.b;
    boolean bool = true;
    if ((i == 0) || (i == 1)) {
      bool = false;
    }
    return bool;
  }
  
  public boolean d()
  {
    int i = this.b;
    boolean bool1 = true;
    boolean bool2 = bool1;
    if (i != 0) {
      if (i == 1) {
        bool2 = bool1;
      } else {
        bool2 = false;
      }
    }
    return bool2;
  }
  
  public void e(IMqttMessageListener paramIMqttMessageListener)
  {
    this.c = paramIMqttMessageListener;
  }
  
  public void f(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\mqtt\r0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */