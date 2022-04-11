package com.tplink.iot.model.smart;

import com.tplink.iot.cloud.bean.smart.common.SmartScheduleSetting;
import com.tplink.iot.cloud.bean.smart.common.SmartThingTrigger;

public final class g
{
  public static final a a = new a(null);
  private int b;
  private SmartScheduleSetting c;
  private SmartThingTrigger d;
  
  public g()
  {
    this(0, null, null);
  }
  
  public g(int paramInt, SmartScheduleSetting paramSmartScheduleSetting)
  {
    this(paramInt, paramSmartScheduleSetting, null);
  }
  
  private g(int paramInt, SmartScheduleSetting paramSmartScheduleSetting, SmartThingTrigger paramSmartThingTrigger)
  {
    this.b = paramInt;
    this.c = paramSmartScheduleSetting;
    this.d = paramSmartThingTrigger;
  }
  
  public g(int paramInt, SmartThingTrigger paramSmartThingTrigger)
  {
    this(paramInt, null, paramSmartThingTrigger);
  }
  
  public final int a()
  {
    return this.b;
  }
  
  public final SmartScheduleSetting b()
  {
    return this.c;
  }
  
  public final String c()
  {
    Object localObject = this.d;
    if (localObject != null) {
      localObject = ((SmartThingTrigger)localObject).getThingName();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public final SmartThingTrigger d()
  {
    return this.d;
  }
  
  public static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\smart\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */