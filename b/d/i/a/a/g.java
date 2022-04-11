package b.d.i.a.a;

import b.d.t.e.e;
import com.tplink.libtpappcommonmedia.bean.TPMediaDevice;
import io.reactivex.q;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class g
{
  private final AtomicBoolean a = new AtomicBoolean(false);
  
  private boolean b(String paramString)
  {
    boolean bool = false;
    if (paramString == null) {
      return false;
    }
    if (System.currentTimeMillis() / 1000L - e.f(paramString) > 86400L) {
      bool = true;
    }
    return bool;
  }
  
  public void a(List<TPMediaDevice> paramList)
  {
    if ((paramList != null) && (!this.a.get())) {
      q.f0(Integer.valueOf(1)).E(new a(this, paramList)).L0(io.reactivex.l0.a.c()).F(new b(this)).y(new c(this)).C(d.c).F0();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\i\a\a\g.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */