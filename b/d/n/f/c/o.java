package b.d.n.f.c;

import android.text.TextUtils;
import com.tplink.libtpinappmessaging.core.repository.IAMRepository;
import io.reactivex.q;
import java.util.HashMap;
import java.util.Map;

public class o
{
  private IAMRepository a;
  private final Map<String, Integer> b = new HashMap();
  private int c = 1;
  
  public o(IAMRepository paramIAMRepository)
  {
    this.a = paramIAMRepository;
  }
  
  private boolean a()
  {
    return TextUtils.isEmpty(this.a.o()) ^ true;
  }
  
  private boolean b(String paramString)
  {
    Object localObject = this.b.get(paramString);
    boolean bool = true;
    if (localObject == null) {
      return true;
    }
    if (((Integer)this.b.get(paramString)).intValue() >= this.c) {
      bool = false;
    }
    return bool;
  }
  
  public void c(String paramString)
  {
    if (!a()) {
      return;
    }
    if (!b(paramString)) {
      return;
    }
    this.a.s().E(new j(this, paramString)).C(l.c).F0();
  }
  
  public void g()
  {
    if (!a()) {
      return;
    }
    this.a.E().C(l.c).F0();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\n\f\c\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */