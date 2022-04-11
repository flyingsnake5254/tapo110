package b.d.n.e;

import b.d.n.i.d;
import com.tplink.nbu.bean.iam.Event;
import com.tplink.nbu.bean.iam.MaterialsResult;
import com.tplink.nbu.bean.iam.ShowedTaskParams;
import com.tplink.nbu.bean.iam.ShowedTaskResult;
import io.reactivex.q;
import java.util.concurrent.Executor;

public class b
  implements d
{
  private String a;
  private final String b;
  private com.tplink.nbu.a.a c;
  private final String d;
  
  public b(String paramString1, com.tplink.nbu.a.a parama, String paramString2)
  {
    this.c = parama;
    this.d = paramString2;
    this.b = paramString1;
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public void b(String paramString1, String paramString2, b.d.n.i.a parama)
  {
    b.d.n.h.b.a().execute(new c(paramString1, paramString2, this.d, parama));
  }
  
  public q<ShowedTaskResult> c(String paramString)
  {
    ShowedTaskParams localShowedTaskParams = new ShowedTaskParams();
    localShowedTaskParams.setAccountId(this.a);
    localShowedTaskParams.setTaskId(paramString);
    return this.c.c(this.b, localShowedTaskParams);
  }
  
  public void clear()
  {
    this.a = null;
  }
  
  public q<MaterialsResult> d(String paramString)
  {
    return this.c.b(this.b, this.a, paramString);
  }
  
  public void e(Event paramEvent)
  {
    this.c.a(this.b, paramEvent).j(a.c).C(io.reactivex.l0.a.b(b.d.n.h.a.a())).y();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\n\e\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */