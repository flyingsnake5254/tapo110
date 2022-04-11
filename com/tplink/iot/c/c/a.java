package com.tplink.iot.c.c;

import androidx.annotation.NonNull;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.iot.cloud.bean.common.IoTWebServiceIdParams;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class a
  extends com.tplink.cloud.context.b
{
  private com.tplink.iot.c.a f;
  private boolean g;
  private IoTWebServiceIdParams h;
  
  public a(TCAccountBean paramTCAccountBean, com.tplink.cloud.context.a parama, String paramString, IoTWebServiceIdParams paramIoTWebServiceIdParams)
  {
    super(paramTCAccountBean, parama);
    this.h = paramIoTWebServiceIdParams;
    this.f = new com.tplink.iot.c.a(paramString, new b(paramString, paramIoTWebServiceIdParams, paramTCAccountBean.getToken(), parama));
  }
  
  public void b()
  {
    this.f.Q1();
    super.b();
  }
  
  @NonNull
  public <T extends b.d.b.d.b.a> T create(@NonNull Class<T> paramClass)
  {
    try
    {
      b.d.b.d.b.a locala = (b.d.b.d.b.a)paramClass.getConstructor(new Class[] { a.class }).newInstance(new Object[] { this });
      return locala;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      return super.create(paramClass);
    }
    catch (InvocationTargetException localInvocationTargetException) {}catch (IllegalAccessException localIllegalAccessException) {}catch (InstantiationException localInstantiationException) {}
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Cannot create an instance of ");
    localStringBuilder.append(paramClass);
    throw new RuntimeException(localStringBuilder.toString(), localInstantiationException);
  }
  
  public void g(TCAccountBean paramTCAccountBean)
  {
    String str;
    if (c() != null) {
      str = c().getToken();
    } else {
      str = null;
    }
    super.g(paramTCAccountBean);
    if (paramTCAccountBean != null)
    {
      boolean bool;
      if ((str != null) && (!str.equals(paramTCAccountBean.getToken()))) {
        bool = true;
      } else {
        bool = false;
      }
      this.g = bool;
      this.f.T1(paramTCAccountBean.getToken());
    }
  }
  
  public String h()
  {
    return e().b();
  }
  
  public String i()
  {
    return this.f.S1().d();
  }
  
  public String j()
  {
    return this.f.S1().e();
  }
  
  public com.tplink.iot.c.a k()
  {
    return this.f;
  }
  
  public IoTWebServiceIdParams l()
  {
    return this.h;
  }
  
  public String m()
  {
    return e().q();
  }
  
  public boolean n()
  {
    return this.g;
  }
  
  public void o(String paramString)
  {
    this.f.S1().m(paramString);
  }
  
  public void p(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\c\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */