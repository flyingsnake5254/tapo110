package com.tplink.libtpinappmessaging.core.repository;

import android.app.Application;
import com.tplink.nbu.AbstractNbuCloudRepository;
import com.tplink.nbu.bean.iam.HitTask;
import com.tplink.nbu.bean.iam.Task;
import io.reactivex.q;
import io.reactivex.r;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class IAMRepository
  extends AbstractNbuCloudRepository
{
  private static final String e = "IAMRepository";
  private b.d.n.i.d f;
  private b.d.n.i.c g;
  private List<HitTask> h = Collections.synchronizedList(new ArrayList());
  private List<HitTask> i = Collections.synchronizedList(new ArrayList());
  private Map<String, String> j;
  private io.reactivex.e0.b k = new io.reactivex.e0.b();
  private String l = "";
  private final List<b.d.n.i.b> m = new ArrayList();
  
  public IAMRepository(com.tplink.cloud.context.b paramb)
  {
    super(paramb);
  }
  
  private void J(String paramString1, String paramString2)
  {
    this.j.put(paramString1, paramString2);
    this.g.f(this.j);
  }
  
  private void K(String paramString, boolean paramBoolean)
  {
    Object localObject1 = this.h;
    Object localObject2;
    Iterator localIterator;
    if (localObject1 != null)
    {
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localIterator = ((HitTask)((Iterator)localObject2).next()).getTaskList().iterator();
        while (localIterator.hasNext())
        {
          localObject1 = (Task)localIterator.next();
          if (((Task)localObject1).getTaskId().equals(paramString)) {
            ((Task)localObject1).setShow(paramBoolean);
          }
        }
      }
    }
    localObject1 = this.i;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localIterator = ((HitTask)((Iterator)localObject1).next()).getTaskList().iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (Task)localIterator.next();
          if (((Task)localObject2).getTaskId().equals(paramString)) {
            ((Task)localObject2).setShow(paramBoolean);
          }
        }
      }
    }
  }
  
  private String p()
  {
    return this.g.d();
  }
  
  public q<Boolean> E()
  {
    q localq = this.f.d("other");
    io.reactivex.e0.b localb = this.k;
    Objects.requireNonNull(localb);
    return localq.F(new a(localb)).E(new c(this)).g0(g.c).C(h.c).L0(io.reactivex.l0.a.b(b.d.n.h.a.a()));
  }
  
  public q<Boolean> F()
  {
    q localq = this.f.d("splash");
    io.reactivex.e0.b localb = this.k;
    Objects.requireNonNull(localb);
    return localq.F(new a(localb)).E(new e(this)).g0(f.c).L0(io.reactivex.l0.a.b(b.d.n.h.a.a()));
  }
  
  public void G()
  {
    this.m.clear();
  }
  
  public void H(String paramString)
  {
    this.g.a(paramString);
    this.f.a(paramString);
    this.l = paramString;
  }
  
  public void I(Application paramApplication, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramApplication.getCacheDir().getAbsolutePath());
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("iamCache");
    localObject = ((StringBuilder)localObject).toString();
    this.f = new b.d.n.e.b(paramString, (com.tplink.nbu.a.a)this.d.R1(com.tplink.nbu.a.a.class), (String)localObject);
    this.g = new b.d.n.d.c(paramApplication, (String)localObject);
    this.l = p();
    b.d.n.j.d.c().f(this.l);
    b.d.n.j.d.c().h(this.f);
    this.f.a(this.l);
    paramApplication = new ConcurrentHashMap();
    this.j = paramApplication;
    paramApplication.putAll(this.g.e());
  }
  
  public void L(String paramString)
  {
    q localq = this.f.c(paramString);
    io.reactivex.e0.b localb = this.k;
    Objects.requireNonNull(localb);
    localq.F(new a(localb)).E(new d(this, paramString)).C(h.c).L0(io.reactivex.l0.a.b(b.d.n.h.a.a())).F0();
  }
  
  public void j(b.d.n.i.b paramb)
  {
    if (!this.m.contains(paramb)) {
      this.m.add(paramb);
    }
  }
  
  public void k()
  {
    this.l = "";
    this.g.clear();
    this.f.clear();
  }
  
  public void l()
  {
    this.g.c();
    this.j.clear();
    this.g.f(this.j);
  }
  
  public void m(List<String> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      paramList = (String)localIterator.next();
      this.g.b(paramList);
      this.j.remove(paramList);
    }
    this.g.f(this.j);
  }
  
  public q<com.tplink.libtpinappmessaging.model.a> n(String paramString1, String paramString2)
  {
    return q.m(new b(this, paramString2, paramString1));
  }
  
  public String o()
  {
    return this.l;
  }
  
  public Map<String, String> q()
  {
    return this.j;
  }
  
  public List<b.d.n.i.b> r()
  {
    return this.m;
  }
  
  public q<List<HitTask>> s()
  {
    return q.f0(this.i);
  }
  
  public List<HitTask> t()
  {
    return this.h;
  }
  
  class a
    implements b.d.n.i.a
  {
    a(r paramr) {}
    
    public void a(String paramString1, String paramString2)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(IAMRepository.h());
      ((StringBuilder)localObject).append(" downloadSuccess \n[materialId]:");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(" \n[fileName]:");
      ((StringBuilder)localObject).append(paramString2);
      b.d.n.j.e.b(((StringBuilder)localObject).toString());
      IAMRepository.i(IAMRepository.this, paramString1, paramString2);
      localObject = new com.tplink.libtpinappmessaging.model.a();
      ((com.tplink.libtpinappmessaging.model.a)localObject).f(true);
      ((com.tplink.libtpinappmessaging.model.a)localObject).d(paramString2);
      ((com.tplink.libtpinappmessaging.model.a)localObject).e(paramString1);
      this.a.onNext(localObject);
    }
    
    public void b(String paramString) {}
    
    public void c(String paramString)
    {
      paramString = new com.tplink.libtpinappmessaging.model.a();
      paramString.f(false);
      this.a.onNext(paramString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpinappmessaging\core\repository\IAMRepository.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */