package com.tplink.libtpnetwork.IoTNetwork;

import com.tplink.libtpnetwork.cameranetwork.TPBaseDeviceContext;

public class u
{
  private int a;
  private ThingContext b;
  
  public u()
  {
    this.a = -1;
  }
  
  public u(int paramInt, ThingContext paramThingContext)
  {
    this.a = -1;
    this.a = paramInt;
    this.b = paramThingContext;
  }
  
  public u(boolean paramBoolean, ThingContext paramThingContext)
  {
    int i = -1;
    this.a = -1;
    if (paramBoolean) {
      i = 0;
    }
    this.a = i;
    this.b = paramThingContext;
  }
  
  public String a()
  {
    Object localObject = this.b;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = ((TPBaseDeviceContext)localObject).getDeviceIdMD5();
    }
    return (String)localObject;
  }
  
  public int b()
  {
    return this.a;
  }
  
  public ThingContext c()
  {
    return this.b;
  }
  
  public boolean d()
  {
    boolean bool;
    if (this.a == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */