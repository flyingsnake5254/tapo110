package com.tplink.libtpmediaother.memory;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import b.d.q.b.n;
import com.tplink.libtpmediaother.database.model.FileMemoryInfoDao.Properties;
import com.tplink.libtpmediaother.database.model.d;
import io.reactivex.q;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;
import org.greenrobot.greendao.query.WhereCondition.StringCondition;

public class r
{
  private static final String a = "r";
  private static r b;
  private ArrayList<WeakReference<s>> c = new ArrayList();
  private ArrayList<WeakReference<t>> d = new ArrayList();
  private ExecutorService e = Executors.newSingleThreadExecutor(new a());
  private Handler f = new Handler(Looper.getMainLooper());
  
  private void D(QueryBuilder<d> paramQueryBuilder)
  {
    paramQueryBuilder = new k(this, paramQueryBuilder);
    this.e.submit(paramQueryBuilder);
  }
  
  public static r f()
  {
    if (b == null) {
      try
      {
        if (b == null)
        {
          r localr = new com/tplink/libtpmediaother/memory/r;
          localr.<init>();
          b = localr;
        }
      }
      finally {}
    }
    return b;
  }
  
  public void B()
  {
    a locala = new a(this);
    this.e.submit(locala);
  }
  
  public void C(d paramd)
  {
    if (paramd != null) {
      D(paramd.b(-1, -1));
    }
  }
  
  public void E(MemoryBean paramMemoryBean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMemoryBean);
    F(localArrayList);
  }
  
  public void F(List<MemoryBean> paramList)
  {
    paramList = new f(this, paramList);
    this.e.submit(paramList);
  }
  
  public void G(MemoryBean paramMemoryBean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMemoryBean);
    H(localArrayList);
  }
  
  public void H(List<MemoryBean> paramList)
  {
    paramList = new b(this, paramList);
    this.e.submit(paramList);
  }
  
  public void I(t paramt)
  {
    if (paramt != null) {
      for (int i = this.d.size() - 1; i >= 0; i--) {
        if (paramt.equals((t)((WeakReference)this.d.get(i)).get()))
        {
          this.d.set(i, new WeakReference(null));
          break;
        }
      }
    }
  }
  
  public void J(s params)
  {
    if (params != null) {
      for (int i = this.c.size() - 1; i >= 0; i--) {
        if (params.equals((s)((WeakReference)this.c.get(i)).get()))
        {
          this.c.set(i, new WeakReference(null));
          break;
        }
      }
    }
  }
  
  public void a(t paramt)
  {
    if (paramt != null)
    {
      for (int i = this.d.size() - 1; i >= 0; i--)
      {
        t localt = (t)((WeakReference)this.d.get(i)).get();
        if ((localt != null) && (localt.equals(paramt))) {
          return;
        }
      }
      this.d.add(new WeakReference(paramt));
    }
  }
  
  public void b(s params)
  {
    if (params != null)
    {
      for (int i = this.c.size() - 1; i >= 0; i--)
      {
        s locals = (s)((WeakReference)this.c.get(i)).get();
        if ((locals != null) && (locals.equals(params))) {
          return;
        }
      }
      this.c.add(new WeakReference(params));
    }
  }
  
  public void c(ArrayList<WeakReference<t>> paramArrayList, b paramb)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        WeakReference localWeakReference = (WeakReference)paramArrayList.get(i);
        if (localWeakReference.get() != null)
        {
          paramb.a((t)localWeakReference.get());
          i++;
        }
        else
        {
          paramArrayList.remove(i);
        }
      }
    }
  }
  
  public q<Boolean> d(List<MemoryBean> paramList)
  {
    return q.f0(paramList).g0(m.c).L0(io.reactivex.l0.a.b(this.e)).l0(io.reactivex.d0.b.a.a());
  }
  
  public q<Boolean> e(MemoryBean paramMemoryBean)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramMemoryBean);
    return d(localArrayList);
  }
  
  public void g(ArrayList<WeakReference<s>> paramArrayList, c paramc)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        WeakReference localWeakReference = (WeakReference)paramArrayList.get(i);
        if (localWeakReference.get() != null)
        {
          paramc.a((s)localWeakReference.get());
          i++;
        }
        else
        {
          paramArrayList.remove(i);
        }
      }
    }
  }
  
  class a
    implements ThreadFactory
  {
    private final AtomicInteger c = new AtomicInteger(0);
    
    a() {}
    
    public Thread newThread(@NonNull Runnable paramRunnable)
    {
      Thread localThread = new Thread(paramRunnable);
      paramRunnable = new StringBuilder();
      paramRunnable.append("pool-MemoryManager.executorService-");
      paramRunnable.append(this.c.incrementAndGet());
      localThread.setName(paramRunnable.toString());
      return localThread;
    }
  }
  
  public static abstract interface b
  {
    public abstract void a(t paramt);
  }
  
  public static abstract interface c
  {
    public abstract void a(s params);
  }
  
  public static final class d
  {
    private String a;
    private List<String> b;
    private String c;
    private String d;
    private Boolean e;
    private Boolean f;
    private Boolean g;
    private Boolean h;
    private Boolean i;
    private Boolean j;
    
    public d a(String paramString)
    {
      this.d = paramString;
      return this;
    }
    
    public QueryBuilder b(int paramInt1, int paramInt2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.a != null)
      {
        localStringBuilder.append("UTC_TIMESTAMP = ");
        localStringBuilder.append("'");
        localStringBuilder.append(this.a);
        localStringBuilder.append("'");
        k = 1;
      }
      else
      {
        k = 0;
      }
      int m = k;
      if (this.c != null)
      {
        if (k != 0) {
          localStringBuilder.append(" AND ");
        }
        localStringBuilder.append(" DEVICE_ID_MD5 = ");
        localStringBuilder.append("'");
        localStringBuilder.append(this.c);
        localStringBuilder.append("'");
        m = 1;
      }
      int k = m;
      if (this.d != null)
      {
        if (m != 0) {
          localStringBuilder.append(" AND ");
        }
        localStringBuilder.append(" ASSOCIATED_ACCOUNT IN (");
        localStringBuilder.append("'");
        localStringBuilder.append(this.d);
        localStringBuilder.append("','");
        localStringBuilder.append("Public");
        localStringBuilder.append("')");
        k = 1;
      }
      Object localObject = this.e;
      if (localObject == null)
      {
        m = k;
        if (this.f == null) {}
      }
      else if ((!org.apache.commons.lang.b.b((Boolean)localObject)) || (org.apache.commons.lang.b.b(this.f)))
      {
        m = k;
        if (!org.apache.commons.lang.b.b(this.e))
        {
          m = k;
          if (!org.apache.commons.lang.b.b(this.f)) {}
        }
      }
      else
      {
        if (k != 0) {
          localStringBuilder.append(" AND ");
        }
        if (org.apache.commons.lang.b.b(this.e))
        {
          localStringBuilder.append(" IS_FAVORITE = ");
          localStringBuilder.append(1);
        }
        else
        {
          localStringBuilder.append(" IS_FAVORITE = ");
          localStringBuilder.append(0);
        }
        m = 1;
      }
      localObject = this.h;
      if ((localObject == null) && (this.g == null))
      {
        k = m;
        if (this.i == null) {}
      }
      else if ((org.apache.commons.lang.b.b((Boolean)localObject)) && (org.apache.commons.lang.b.b(this.g)) && (org.apache.commons.lang.b.b(this.i)))
      {
        k = m;
      }
      else
      {
        k = m;
        if (org.apache.commons.lang.b.b(this.h))
        {
          if (m != 0) {
            localStringBuilder.append(" AND (");
          }
          localStringBuilder.append(" FILE_ABSOLUTE_PATH LIKE ");
          localStringBuilder.append("'");
          localStringBuilder.append("%.jpg");
          localStringBuilder.append("'");
          k = 1;
        }
        if (org.apache.commons.lang.b.b(this.g))
        {
          if (k != 0) {
            if (org.apache.commons.lang.b.b(this.h)) {
              localStringBuilder.append(" OR ");
            } else {
              localStringBuilder.append(" AND ");
            }
          }
          if (org.apache.commons.lang.b.b(this.i))
          {
            localStringBuilder.append(" FILE_ABSOLUTE_PATH LIKE ");
            localStringBuilder.append("'");
            localStringBuilder.append("%.mp4");
            localStringBuilder.append("'");
          }
          else
          {
            localStringBuilder.append(" FILE_ABSOLUTE_PATH NOT LIKE ");
            localStringBuilder.append("'");
            localStringBuilder.append("%cloudvideo%");
            localStringBuilder.append("'");
            localStringBuilder.append(" AND ");
            localStringBuilder.append(" FILE_ABSOLUTE_PATH LIKE ");
            localStringBuilder.append("'");
            localStringBuilder.append("%.mp4");
            localStringBuilder.append("'");
          }
        }
        else if (org.apache.commons.lang.b.b(this.i))
        {
          if (k != 0) {
            if (org.apache.commons.lang.b.b(this.h)) {
              localStringBuilder.append(" OR ");
            } else {
              localStringBuilder.append(" AND ");
            }
          }
          localStringBuilder.append(" FILE_ABSOLUTE_PATH LIKE ");
          localStringBuilder.append("'");
          localStringBuilder.append("%cloudvideo%");
          localStringBuilder.append("'");
          localStringBuilder.append(" AND ");
          localStringBuilder.append(" FILE_ABSOLUTE_PATH LIKE ");
          localStringBuilder.append("'");
          localStringBuilder.append("%.mp4");
          localStringBuilder.append("'");
        }
        if ((org.apache.commons.lang.b.b(this.h)) && (k != 0)) {
          localStringBuilder.append(" ) ");
        }
        k = 1;
      }
      localObject = this.b;
      m = k;
      if (localObject != null)
      {
        m = k;
        if (((List)localObject).size() > 0)
        {
          if (k != 0) {
            localStringBuilder.append(" AND ");
          }
          localStringBuilder.append(" DEVICE_ALIAS IN (");
          for (m = 0; m < this.b.size(); m++)
          {
            localObject = (String)this.b.get(m);
            if (m != 0) {
              localStringBuilder.append(",");
            }
            localStringBuilder.append("'");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append("'");
          }
          localStringBuilder.append(")");
          m = 1;
        }
      }
      if (this.j != null)
      {
        if (m != 0) {
          localStringBuilder.append(" AND ");
        }
        if (org.apache.commons.lang.b.b(this.j))
        {
          localStringBuilder.append(" IS_DELETED_BY_USER = ");
          localStringBuilder.append(1);
        }
        else
        {
          localStringBuilder.append(" IS_DELETED_BY_USER = ");
          localStringBuilder.append(0);
        }
      }
      localObject = b.d.q.b.k.a().b().queryBuilder();
      if (!n.a(localStringBuilder.toString())) {
        ((QueryBuilder)localObject).where(new WhereCondition.StringCondition(localStringBuilder.toString()), new WhereCondition[0]);
      }
      if ((paramInt1 != -1) && (paramInt2 != -1))
      {
        m = paramInt1 * paramInt2;
        paramInt1 = m;
        if (m < 0) {
          paramInt1 = 0;
        }
        ((QueryBuilder)localObject).offset(paramInt1).limit(paramInt2);
      }
      ((QueryBuilder)localObject).orderDesc(new Property[] { FileMemoryInfoDao.Properties.a });
      return (QueryBuilder)localObject;
    }
    
    public d c(List<String> paramList)
    {
      this.b = paramList;
      return this;
    }
    
    public d d(String paramString)
    {
      this.c = paramString;
      return this;
    }
    
    public d e(Boolean paramBoolean)
    {
      this.i = paramBoolean;
      return this;
    }
    
    public d f(Boolean paramBoolean)
    {
      this.e = paramBoolean;
      return this;
    }
    
    public d g(Boolean paramBoolean)
    {
      this.h = paramBoolean;
      return this;
    }
    
    public d h(Boolean paramBoolean)
    {
      this.f = paramBoolean;
      return this;
    }
    
    public d i(Boolean paramBoolean)
    {
      this.g = paramBoolean;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpmediaother\memory\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */