package b.d.d0;

import b.d.a.s;
import b.d.a.s.a;
import com.tplink.ata.common.ATAException;
import com.tplink.cloud.define.CloudException;
import com.tplink.tmp.enumerate.EnumTMPTransportStatus;
import com.tplink.tmp.enumerate.EnumTMPTransportType;
import io.reactivex.q;

public class u1
  extends y1
  implements s.a
{
  private s i = new s(parama.d(), parama.e(), parama.c(), this);
  
  protected u1(b.d.d0.h2.b.a parama)
  {
    super(EnumTMPTransportType.TRANSPORT_TYPE_ATA, parama);
  }
  
  public void b(Throwable paramThrowable)
  {
    boolean bool = paramThrowable instanceof CloudException;
    int j = 64236;
    int k;
    if (bool)
    {
      k = ((CloudException)paramThrowable).getErrCode();
    }
    else
    {
      k = j;
      if ((paramThrowable instanceof ATAException))
      {
        k = ((ATAException)paramThrowable).getErrorCode();
        if (k != 1)
        {
          if (k != 2)
          {
            if (k != 3)
            {
              if (k != 4)
              {
                if (k != 5) {
                  k = j;
                } else {
                  k = 64231;
                }
              }
              else {
                k = 64232;
              }
            }
            else {
              k = 64233;
            }
          }
          else {
            k = 64234;
          }
        }
        else {
          k = 64235;
        }
      }
    }
    t(new b.d.d0.i2.b(k), EnumTMPTransportStatus.TMP_TRANSPORT_STATUS_DISCONNECTED);
  }
  
  public void f(byte[] paramArrayOfByte)
  {
    r(paramArrayOfByte);
  }
  
  public void g()
  {
    this.i.e();
    super.g();
  }
  
  public q<b.d.d0.i2.b> h()
  {
    return this.i.f().g0(new b(this)).q0(new b.d.d0.i2.b(-1)).F(new a(this));
  }
  
  public q<b.d.d0.i2.b> u(byte[] paramArrayOfByte)
  {
    this.i.V(paramArrayOfByte);
    return q.f0(new b.d.d0.i2.b(0));
  }
  
  public void z()
  {
    this.i.d();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d0\u1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */