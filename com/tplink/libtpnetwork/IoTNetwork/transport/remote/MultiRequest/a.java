package com.tplink.libtpnetwork.IoTNetwork.transport.remote.MultiRequest;

import android.text.TextUtils;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTRequest;
import com.tplink.libtpnetwork.IoTNetwork.TPIoTResponse;
import io.reactivex.g;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class a
{
  private volatile CopyOnWriteArrayList<TPIoTRequest> a = new CopyOnWriteArrayList();
  private volatile ArrayList<TPIoTRequest> b = new ArrayList();
  private ConcurrentHashMap<TPIoTRequest, List<g<TPIoTResponse>>> c = new ConcurrentHashMap();
  
  private TPIoTRequest c()
  {
    TPIoTRequest localTPIoTRequest1 = new TPIoTRequest();
    MultiRequestBean localMultiRequestBean = new MultiRequestBean();
    localTPIoTRequest1.setMethod("multipleRequest");
    ArrayList localArrayList = new ArrayList();
    this.b.clear();
    if (!this.a.isEmpty())
    {
      if (!RequestMethod.b(((TPIoTRequest)this.a.get(0)).getMethod()))
      {
        localObject = (TPIoTRequest)this.a.get(0);
        this.b.add(this.a.remove(0));
        return (TPIoTRequest)localObject;
      }
      Object localObject = this.a.iterator();
      while ((((Iterator)localObject).hasNext()) && (localArrayList.size() <= 3))
      {
        TPIoTRequest localTPIoTRequest2 = (TPIoTRequest)((Iterator)localObject).next();
        if ((RequestMethod.b(localTPIoTRequest2.getMethod())) && (!j(localArrayList, localTPIoTRequest2)))
        {
          q(localArrayList, localTPIoTRequest2);
          this.a.remove(0);
        }
      }
    }
    this.b.addAll(localArrayList);
    localMultiRequestBean.setRequests(localArrayList);
    localTPIoTRequest1.setParams(localMultiRequestBean);
    return localTPIoTRequest1;
  }
  
  private boolean d(TPIoTRequest paramTPIoTRequest1, TPIoTRequest paramTPIoTRequest2)
  {
    if (!this.c.isEmpty())
    {
      paramTPIoTRequest1 = (List)this.c.get(paramTPIoTRequest1);
      List localList = (List)this.c.get(paramTPIoTRequest2);
      if (paramTPIoTRequest1 != null)
      {
        paramTPIoTRequest1.addAll(localList);
        this.c.remove(paramTPIoTRequest2);
        return true;
      }
    }
    return false;
  }
  
  private Object e(Object paramObject1, Object paramObject2)
  {
    if ((paramObject1 != null) && (paramObject2 != null))
    {
      Object localObject = paramObject1.getClass();
      Class localClass = paramObject2.getClass();
      localObject = ((Class)localObject).getDeclaredFields();
      Field[] arrayOfField = localClass.getDeclaredFields();
      for (int i = 0; i < localObject.length; i++)
      {
        localClass = localObject[i];
        Field localField = arrayOfField[i];
        localClass.setAccessible(true);
        localField.setAccessible(true);
        try
        {
          if (localClass.get(paramObject1) == null) {
            continue;
          }
          localField.set(paramObject2, localClass.get(paramObject1));
        }
        catch (IllegalAccessException localIllegalAccessException) {}catch (IllegalArgumentException localIllegalArgumentException) {}
        localIllegalArgumentException.printStackTrace();
      }
      return paramObject2;
    }
    return paramObject1;
  }
  
  private void f(Throwable paramThrowable, TPIoTRequest paramTPIoTRequest)
  {
    paramTPIoTRequest = (List)this.c.get(paramTPIoTRequest);
    if ((paramTPIoTRequest != null) && (paramTPIoTRequest.size() != 0))
    {
      paramTPIoTRequest = paramTPIoTRequest.iterator();
      while (paramTPIoTRequest.hasNext()) {
        ((g)paramTPIoTRequest.next()).onError(paramThrowable);
      }
    }
  }
  
  private void g(TPIoTResponse paramTPIoTResponse, TPIoTRequest paramTPIoTRequest)
  {
    paramTPIoTRequest = (List)this.c.get(paramTPIoTRequest);
    if ((paramTPIoTRequest != null) && (paramTPIoTRequest.size() != 0))
    {
      paramTPIoTRequest = paramTPIoTRequest.iterator();
      while (paramTPIoTRequest.hasNext())
      {
        g localg = (g)paramTPIoTRequest.next();
        localg.onNext(paramTPIoTResponse);
        localg.onComplete();
      }
    }
  }
  
  private boolean j(List<TPIoTRequest> paramList, TPIoTRequest paramTPIoTRequest)
  {
    boolean bool;
    if ((TextUtils.equals(RequestMethod.a(paramTPIoTRequest.getMethod()).toString(), RequestMethod.RequestMethodType.NOT_REPLACE_TYPE.toString())) && (k(paramList, paramTPIoTRequest))) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  private boolean k(List<TPIoTRequest> paramList, TPIoTRequest paramTPIoTRequest)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (TextUtils.equals(((TPIoTRequest)paramList.next()).getMethod(), paramTPIoTRequest.getMethod())) {
          return true;
        }
      }
    }
    return false;
  }
  
  private void o(List<TPIoTRequest> paramList, TPIoTRequest paramTPIoTRequest)
  {
    if (paramList.isEmpty())
    {
      paramList.add(paramTPIoTRequest);
      return;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      TPIoTRequest localTPIoTRequest = (TPIoTRequest)localIterator.next();
      if (TextUtils.equals(localTPIoTRequest.getMethod(), paramTPIoTRequest.getMethod()))
      {
        localIterator.remove();
        paramTPIoTRequest.setParams(e(paramTPIoTRequest.getParams(), localTPIoTRequest.getParams()));
        d(paramTPIoTRequest, localTPIoTRequest);
      }
    }
    paramList.add(paramTPIoTRequest);
  }
  
  private void p(List<TPIoTRequest> paramList, TPIoTRequest paramTPIoTRequest)
  {
    if (paramList.isEmpty())
    {
      paramList.add(paramTPIoTRequest);
      return;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      TPIoTRequest localTPIoTRequest = (TPIoTRequest)localIterator.next();
      if ((TextUtils.equals(localTPIoTRequest.getMethod(), paramTPIoTRequest.getMethod())) && (d(localTPIoTRequest, paramTPIoTRequest))) {
        return;
      }
    }
    paramList.add(paramTPIoTRequest);
  }
  
  private void q(List<TPIoTRequest> paramList, TPIoTRequest paramTPIoTRequest)
  {
    int i = a.a[RequestMethod.a(paramTPIoTRequest.getMethod()).ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          paramList.add(paramTPIoTRequest);
        } else {
          paramList.add(paramTPIoTRequest);
        }
      }
      else {
        o(paramList, paramTPIoTRequest);
      }
    }
    else {
      p(paramList, paramTPIoTRequest);
    }
  }
  
  public void a(TPIoTRequest paramTPIoTRequest)
  {
    this.a.add(paramTPIoTRequest);
  }
  
  public void b(TPIoTRequest paramTPIoTRequest, List<g<TPIoTResponse>> paramList)
  {
    this.c.put(paramTPIoTRequest, paramList);
  }
  
  public TPIoTRequest h()
  {
    try
    {
      TPIoTRequest localTPIoTRequest = c();
      return localTPIoTRequest;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public boolean i()
  {
    return this.a.isEmpty();
  }
  
  public boolean l()
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext()) {
      if (!RequestMethod.b(((TPIoTRequest)localIterator.next()).getMethod())) {
        return false;
      }
    }
    return true;
  }
  
  public void m(Throwable paramThrowable)
  {
    if ((!this.b.isEmpty()) && (!this.c.isEmpty()))
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        TPIoTRequest localTPIoTRequest = (TPIoTRequest)localIterator.next();
        f(paramThrowable, localTPIoTRequest);
        localIterator.remove();
        this.c.remove(localTPIoTRequest);
      }
    }
  }
  
  public void n(TPIoTResponse paramTPIoTResponse)
  {
    if ((!this.b.isEmpty()) && (!this.c.isEmpty()))
    {
      g(paramTPIoTResponse, (TPIoTRequest)this.b.get(0));
      this.c.remove(this.b.remove(0));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\IoTNetwork\transport\remote\MultiRequest\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */