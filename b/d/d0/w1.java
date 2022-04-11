package b.d.d0;

import b.d.d0.h2.b.c;
import b.d.d0.i2.b;
import com.tplink.ssh2.EnumSSH2Status;
import com.tplink.ssh2.a0;
import com.tplink.ssh2.w;
import com.tplink.ssh2.x;
import com.tplink.tmp.enumerate.EnumTMPTransportStatus;
import com.tplink.tmp.enumerate.EnumTMPTransportType;
import io.reactivex.q;

public class w1
  extends y1
  implements w
{
  private x i;
  
  w1(EnumTMPTransportType paramEnumTMPTransportType, c paramc)
  {
    super(paramEnumTMPTransportType, paramc);
    this.i = new x(paramc.h(), paramc.c(), paramc.f(), paramc.g(), paramc.e(), this, paramc.d());
  }
  
  private int B(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 13: 
      return 64124;
    case 12: 
      return 64125;
    case 11: 
      return 64126;
    case 10: 
      return 64127;
    case 9: 
      return 64128;
    case 8: 
      return 64129;
    case 7: 
      return 64130;
    case 6: 
      return 64131;
    case 5: 
      return 64132;
    case 4: 
      return 64133;
    case 3: 
      return 64134;
    case 2: 
      return 64135;
    }
    return 64136;
  }
  
  private b C(a0 parama0)
  {
    return new b(B(parama0.a()), parama0.b());
  }
  
  public void c(byte[] paramArrayOfByte)
  {
    r(paramArrayOfByte);
  }
  
  public void d(a0 parama0, EnumSSH2Status paramEnumSSH2Status)
  {
    if (paramEnumSSH2Status == EnumSSH2Status.SSH2_STATUS_DISCONNECTED) {
      t(C(parama0), EnumTMPTransportStatus.TMP_TRANSPORT_STATUS_DISCONNECTED);
    }
  }
  
  public void g()
  {
    super.g();
    this.i.a();
  }
  
  public q<b> h()
  {
    return this.i.b().g0(new g(this)).F(new h(this));
  }
  
  public q<b> u(byte[] paramArrayOfByte)
  {
    return this.i.l(paramArrayOfByte).g0(new i(this));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d0\w1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */