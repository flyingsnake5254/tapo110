package b.d.n.i;

import com.tplink.nbu.bean.iam.Event;
import com.tplink.nbu.bean.iam.MaterialsResult;
import com.tplink.nbu.bean.iam.ShowedTaskResult;
import io.reactivex.q;

public abstract interface d
{
  public abstract void a(String paramString);
  
  public abstract void b(String paramString1, String paramString2, a parama);
  
  public abstract q<ShowedTaskResult> c(String paramString);
  
  public abstract void clear();
  
  public abstract q<MaterialsResult> d(String paramString);
  
  public abstract void e(Event paramEvent);
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\n\i\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */