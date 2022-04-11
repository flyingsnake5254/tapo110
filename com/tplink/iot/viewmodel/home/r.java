package com.tplink.iot.viewmodel.home;

import android.text.TextUtils;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import com.tplink.cloud.context.TCAccountBean;
import com.tplink.cloud.context.b;
import com.tplink.iot.Utils.s;
import com.tplink.iot.cloud.bean.share.result.ShareDeviceResult;
import com.tplink.iot.model.home.HomeCacheBean;
import com.tplink.iot.model.home.e;
import com.tplink.iot.model.home.f;
import com.tplink.iot.model.home.k;
import com.tplink.libtpnetwork.Utils.i;
import com.tplink.libtpnetwork.Utils.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class r
{
  private static String a;
  private static volatile r b;
  private MediatorLiveData<f> c = new MediatorLiveData();
  private b d = new b(b.d.s.a.a.f().c().getEmail(), null);
  private MutableLiveData<Boolean> e = new MutableLiveData();
  
  public static r g()
  {
    if (b == null) {
      try
      {
        if (b == null)
        {
          r localr = new com/tplink/iot/viewmodel/home/r;
          localr.<init>();
          b = localr;
        }
      }
      finally {}
    }
    return b;
  }
  
  public void c()
  {
    b = null;
  }
  
  public MediatorLiveData<f> d()
  {
    return this.c;
  }
  
  public MutableLiveData<Boolean> e()
  {
    return this.e;
  }
  
  public void f()
  {
    this.c.postValue(b.a(this.d, false));
  }
  
  public void h()
  {
    this.c.postValue(b.a(this.d, true));
  }
  
  public void i(List<e> paramList, boolean paramBoolean)
  {
    this.c.postValue(b.a(b.d(b.c(this.d.g(paramList))), paramBoolean));
  }
  
  public void j()
  {
    this.c.postValue(b.a(this.d.h(), true));
  }
  
  public void k()
  {
    this.d.e();
  }
  
  public void l(boolean paramBoolean, String paramString)
  {
    b.d(b.c(this.d.i(paramBoolean, paramString)));
    h();
  }
  
  public void m(boolean paramBoolean, String paramString)
  {
    b.d(b.c(this.d.i(paramBoolean, paramString)));
  }
  
  public void n(List<k> paramList)
  {
    b.c(b.b(this.d, paramList));
  }
  
  public void o(List<k> paramList, boolean paramBoolean)
  {
    this.c.postValue(b.a(b.c(b.b(this.d, paramList)), paramBoolean));
  }
  
  public void p(List<ShareDeviceResult> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ShareDeviceResult localShareDeviceResult = (ShareDeviceResult)paramList.next();
        if ((localShareDeviceResult.getExpired() != null) && (!localShareDeviceResult.getExpired().booleanValue()))
        {
          bool = true;
          break label63;
        }
      }
    }
    boolean bool = false;
    label63:
    this.e.postValue(Boolean.valueOf(bool));
  }
  
  protected static class b
  {
    private List<HomeCacheBean> a = new ArrayList();
    private List<HomeCacheBean> b = new ArrayList();
    private List<HomeCacheBean> c = new ArrayList();
    private List<HomeCacheBean> d = new ArrayList();
    private List<HomeCacheBean> e = new ArrayList();
    private List<HomeCacheBean> f = new ArrayList();
    private boolean g;
    private o h = o.h0();
    
    private b(String paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("HOME_LIST");
      localStringBuilder.append(paramString);
      r.b(localStringBuilder.toString());
      this.c = i.e(o.h0().f(r.a(), ""), HomeCacheBean.class);
      j();
      paramString = new StringBuilder();
      paramString.append("get cache list-->");
      paramString.append(o.h0().f(r.a(), ""));
      b.d.w.c.a.d(paramString.toString());
    }
    
    private f f(boolean paramBoolean)
    {
      return new f(this.c, paramBoolean);
    }
    
    private b j()
    {
      this.a.clear();
      this.b.clear();
      if (s.b(this.c)) {
        return this;
      }
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        HomeCacheBean localHomeCacheBean = (HomeCacheBean)localIterator.next();
        if (localHomeCacheBean.isFavorite()) {
          this.a.add(localHomeCacheBean);
        } else {
          this.b.add(localHomeCacheBean);
        }
      }
      return this;
    }
    
    private b k()
    {
      if (s.b(this.c))
      {
        this.h.k(r.a(), "");
        return this;
      }
      this.h.k(r.a(), i.h(this.c));
      return this;
    }
    
    private b l(List<k> paramList)
    {
      if (s.b(paramList))
      {
        this.h.k(r.a(), "");
        return this;
      }
      this.c.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        k localk = (k)paramList.next();
        if (localk.k() != null) {
          this.c.add(localk.k());
        }
      }
      this.h.k(r.a(), i.h(this.c));
      return this;
    }
    
    public b e()
    {
      this.g = true;
      this.d = s.a(this.a);
      this.e = s.a(this.b);
      this.f = s.a(this.c);
      return this;
    }
    
    public b g(List<e> paramList)
    {
      if (s.b(paramList)) {
        return this;
      }
      if (s.b(this.c)) {
        this.c = new ArrayList();
      }
      this.c.clear();
      for (int i = 0; i < paramList.size(); i++)
      {
        Object localObject = (e)paramList.get(i);
        if ((localObject instanceof k))
        {
          localObject = (k)localObject;
          ((k)localObject).C(i);
          if (((k)localObject).k() != null) {
            this.c.add(((k)localObject).k());
          }
        }
      }
      return this;
    }
    
    public b h()
    {
      if (this.g)
      {
        this.g = false;
        this.a.clear();
        this.a.addAll(this.d);
        this.b.clear();
        this.b.addAll(this.e);
        this.c.clear();
        this.c.addAll(this.f);
      }
      return this;
    }
    
    public b i(boolean paramBoolean, String paramString)
    {
      Iterator localIterator = this.c.iterator();
      while (localIterator.hasNext())
      {
        HomeCacheBean localHomeCacheBean = (HomeCacheBean)localIterator.next();
        if (TextUtils.equals(localHomeCacheBean.getDeviceIdMD5(), paramString)) {
          localHomeCacheBean.setNewDevice(paramBoolean);
        }
      }
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\viewmodel\home\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */