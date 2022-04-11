package b.d.n.j;

import android.os.CountDownTimer;
import com.tplink.libtpinappmessaging.model.IAMException;

public class h
  extends CountDownTimer
{
  public h()
  {
    super(4000L, 1000L);
  }
  
  public void onFinish()
  {
    f.d(new IAMException(-2, "splash time out"));
  }
  
  public void onTick(long paramLong) {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\n\j\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */