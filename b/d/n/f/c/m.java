package b.d.n.f.c;

import android.text.TextUtils;
import b.d.n.j.e;
import com.tplink.libtpinappmessaging.core.repository.IAMRepository;
import io.reactivex.q;

public class m
{
  private static final String a = "m";
  private IAMRepository b;
  
  public m(IAMRepository paramIAMRepository)
  {
    this.b = paramIAMRepository;
  }
  
  public void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(this.b.o())))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(a);
      localStringBuilder.append("handelNotificationMessage taskId:");
      localStringBuilder.append(paramString);
      e.b(localStringBuilder.toString());
      this.b.E().N(new b(this)).E(new c(this, paramString)).C(l.c).F0();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\n\f\c\m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */