package com.tplink.iot.model.smart;

import androidx.annotation.Nullable;
import com.tplink.iot.cloud.bean.smart.common.SmartReferAction;
import com.tplink.iot.cloud.bean.smart.common.SmartThingAction;

public class e
{
  private int a;
  private SmartReferAction b;
  private SmartThingAction c;
  
  public e(SmartReferAction paramSmartReferAction, int paramInt)
  {
    this.b = paramSmartReferAction;
    this.a = paramInt;
  }
  
  public e(SmartThingAction paramSmartThingAction, int paramInt)
  {
    this.c = paramSmartThingAction;
    this.a = paramInt;
  }
  
  public int a()
  {
    SmartReferAction localSmartReferAction = this.b;
    int i;
    if (localSmartReferAction != null) {
      i = localSmartReferAction.getAction();
    } else {
      i = -1;
    }
    return i;
  }
  
  public int b()
  {
    return this.a;
  }
  
  public String c()
  {
    Object localObject = this.c;
    if (localObject != null) {
      localObject = ((SmartThingAction)localObject).getCategory();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public String d()
  {
    Object localObject = this.b;
    if (localObject != null) {
      localObject = ((SmartReferAction)localObject).getId();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  @Nullable
  public String e()
  {
    Object localObject = this.c;
    if (localObject != null) {
      localObject = ((SmartThingAction)localObject).getNickname();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
  
  public SmartReferAction f()
  {
    return this.b;
  }
  
  public SmartThingAction g()
  {
    return this.c;
  }
  
  public String h()
  {
    Object localObject = this.c;
    if (localObject != null) {
      localObject = ((SmartThingAction)localObject).getThingName();
    } else {
      localObject = null;
    }
    return (String)localObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\model\smart\e.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */