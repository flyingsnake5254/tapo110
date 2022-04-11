package com.tplink.iot.c.b;

import com.tplink.iot.cloud.bean.push.params.IoTSubscribeMsgParams;
import retrofit2.x.o;
import retrofit2.x.s;

public abstract interface g
{
  @o("{url}/v1/events/subscriptions")
  public abstract io.reactivex.a n0(@s(encoded=true, value="url") String paramString, @retrofit2.x.a IoTSubscribeMsgParams paramIoTSubscribeMsgParams);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\c\b\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */