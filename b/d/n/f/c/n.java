package b.d.n.f.c;

import android.os.CountDownTimer;
import android.text.TextUtils;
import b.d.n.j.f;
import com.tplink.libtpinappmessaging.core.repository.IAMRepository;
import com.tplink.libtpinappmessaging.model.IAMException;
import com.tplink.libtpinappmessaging.model.c;
import com.tplink.nbu.bean.iam.HitTask;
import com.tplink.nbu.bean.iam.Material;
import com.tplink.nbu.bean.iam.Task;
import io.reactivex.q;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class n
{
  private static volatile boolean a = false;
  private IAMRepository b;
  private b.d.n.j.h c;
  
  public n(IAMRepository paramIAMRepository)
  {
    this.b = paramIAMRepository;
    this.c = new b.d.n.j.h();
  }
  
  private void a(com.tplink.libtpinappmessaging.model.a parama)
  {
    if ((parama != null) && (parama.c()) && (!a))
    {
      HitTask localHitTask = (HitTask)this.b.t().get(0);
      if (localHitTask != null)
      {
        Object localObject = localHitTask.getTaskList();
        if ((localObject != null) && (!((List)localObject).isEmpty()))
        {
          Iterator localIterator1 = ((List)localObject).iterator();
          while (localIterator1.hasNext())
          {
            localObject = (Task)localIterator1.next();
            if ((parama.b().equals(((Task)localObject).getMaterialId())) && (((Task)localObject).isShow()) && (!TextUtils.isEmpty(parama.a())) && (b.d.n.j.b.b(parama.a())))
            {
              com.tplink.libtpinappmessaging.model.d locald = new com.tplink.libtpinappmessaging.model.d();
              locald.i(parama.a());
              locald.j(((Task)localObject).getMaterial().getWebPageUrl());
              locald.f(((Task)localObject).getTaskId());
              locald.d(((Task)localObject).getBusinessType());
              locald.e(localHitTask.getPushType());
              Iterator localIterator2 = this.b.r().iterator();
              for (;;)
              {
                if (localIterator2.hasNext()) {
                  if (((b.d.n.i.b)localIterator2.next()).a(locald)) {
                    break;
                  }
                }
              }
              a = true;
              this.c.cancel();
              f.e(locald);
              this.b.L(((Task)localObject).getTaskId());
            }
          }
        }
      }
    }
  }
  
  private void c(boolean paramBoolean)
  {
    if (TextUtils.isEmpty(this.b.o()))
    {
      if (!paramBoolean) {
        f.d(new IAMException(-3, "cached AccountId empty!"));
      }
      return;
    }
    if (!paramBoolean) {
      this.c.start();
    }
    this.b.F().N(new d(this, paramBoolean)).N(new i(this)).E(new h(this, paramBoolean)).C(new g(this, paramBoolean)).L0(io.reactivex.l0.a.b(b.d.n.h.a.a())).F0();
  }
  
  private void d(List<Task> paramList, Map<String, String> paramMap, String paramString, List<String> paramList1)
  {
    if (!paramList.isEmpty())
    {
      Collections.sort(paramList, e.c);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Task localTask = (Task)localIterator.next();
        if (localTask.isShow())
        {
          Object localObject = localTask.getMaterialId();
          String str = (String)paramMap.get(localObject);
          if (localTask.getMaterial() != null) {
            paramList = localTask.getMaterial().getWebPageUrl();
          } else {
            paramList = "";
          }
          if (!b.d.n.j.b.b(str))
          {
            paramList1.add(localObject);
          }
          else if (!TextUtils.isEmpty(str))
          {
            localObject = new com.tplink.libtpinappmessaging.model.d();
            ((com.tplink.libtpinappmessaging.model.d)localObject).i(str);
            ((com.tplink.libtpinappmessaging.model.d)localObject).j(paramList);
            ((c)localObject).f(localTask.getTaskId());
            ((c)localObject).d(localTask.getBusinessType());
            ((c)localObject).e(paramString);
            paramList = this.b.r().iterator();
            for (;;)
            {
              if (paramList.hasNext()) {
                if (((b.d.n.i.b)paramList.next()).a((c)localObject)) {
                  break;
                }
              }
            }
            a = true;
            this.c.cancel();
            f.e((c)localObject);
            this.b.L(localTask.getTaskId());
          }
        }
      }
    }
  }
  
  public void b()
  {
    c(false);
  }
  
  public void o()
  {
    c(true);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\n\f\c\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */