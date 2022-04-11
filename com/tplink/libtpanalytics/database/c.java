package com.tplink.libtpanalytics.database;

import android.app.Application;
import androidx.room.Room;
import androidx.room.RoomDatabase.Builder;
import androidx.room.migration.Migration;
import com.tplink.libtpanalytics.database.e.e;
import com.tplink.libtpanalytics.utils.i;
import io.reactivex.q;
import java.util.ArrayList;
import java.util.List;

public class c
  implements b.d.c.c.b
{
  private com.tplink.libtpanalytics.database.e.c a;
  private e b;
  private com.tplink.libtpanalytics.database.e.a c;
  private volatile boolean d = false;
  private AppDatabase e;
  
  private void l()
  {
    if (this.d) {
      return;
    }
    throw new DBException("please call init(...) first");
  }
  
  public void a(Application paramApplication)
  {
    if (!this.d)
    {
      this.d = true;
      paramApplication = (AppDatabase)Room.databaseBuilder(paramApplication, AppDatabase.class, "events.db").fallbackToDestructiveMigration().addMigrations(new Migration[] { b.a, b.c, b.b }).build();
      this.e = paramApplication;
      this.a = paramApplication.b();
      this.b = this.e.c();
      this.c = this.e.a();
    }
  }
  
  public List<com.tplink.libtpanalytics.database.d.b> b(int paramInt)
  {
    l();
    try
    {
      List localList = this.b.b(paramInt);
      localList = this.a.d(localList);
      return localList;
    }
    catch (Exception localException)
    {
      i.b("----getLimitEvent Failed----");
      localException.printStackTrace();
    }
    return new ArrayList();
  }
  
  public void c(com.tplink.libtpanalytics.database.d.a parama)
  {
    l();
    try
    {
      this.c.b(new com.tplink.libtpanalytics.database.d.a[] { parama });
    }
    catch (Exception parama)
    {
      i.b("----addEncryptVersionOption Failed----");
      parama.printStackTrace();
    }
  }
  
  public void d()
  {
    l();
    try
    {
      this.b.a();
    }
    catch (Exception localException)
    {
      i.b("----deleteTempAll Failed----");
      localException.printStackTrace();
    }
  }
  
  public void e(List<com.tplink.libtpanalytics.database.d.b> paramList)
  {
    l();
    try
    {
      this.a.b(paramList);
    }
    catch (Exception paramList)
    {
      i.b("----deleteEventsWithTempTableAndRange Failed----");
      paramList.printStackTrace();
      j();
      d();
    }
  }
  
  public List<com.tplink.libtpanalytics.database.d.a> f()
  {
    l();
    try
    {
      List localList = this.c.c();
      return localList;
    }
    catch (Exception localException)
    {
      i.b("----getEncryptVersionOptionAll Failed----");
      localException.printStackTrace();
    }
    return new ArrayList();
  }
  
  public void g(com.tplink.libtpanalytics.database.d.b paramb)
  {
    l();
    try
    {
      this.a.c(new com.tplink.libtpanalytics.database.d.b[] { paramb });
    }
    catch (Exception paramb)
    {
      i.b("----addEvent Failed----");
      j();
      paramb.printStackTrace();
    }
  }
  
  public void h()
  {
    l();
    try
    {
      this.c.a();
    }
    catch (Exception localException)
    {
      i.b("----deleteEncryptVersionOptionAll Failed----");
      localException.printStackTrace();
    }
  }
  
  public long i()
  {
    l();
    try
    {
      int i = this.a.count();
      return i;
    }
    catch (Exception localException)
    {
      i.b("----getEventsCount Failed----");
      j();
      localException.printStackTrace();
    }
    return 0L;
  }
  
  public void j()
  {
    l();
    try
    {
      this.a.a();
    }
    catch (Exception localException)
    {
      i.b("----deleteEventsAll Failed----");
      localException.printStackTrace();
    }
  }
  
  public q<Integer> k()
  {
    l();
    return q.f0(Integer.valueOf(1)).g0(new a(this));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpanalytics\database\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */