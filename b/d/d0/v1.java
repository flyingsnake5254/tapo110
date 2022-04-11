package b.d.d0;

import com.tplink.tmp.enumerate.EnumTMPTransportStatus;
import com.tplink.tmp.enumerate.EnumTMPTransportType;
import com.tplink.tpble.EnumBLEStatus;
import com.tplink.tpble.n;
import com.tplink.tpble.o;
import com.tplink.tpble.s;
import java.util.concurrent.TimeUnit;

public class v1
  extends y1
  implements n
{
  private io.reactivex.e0.c i;
  private o j = new o(new s(paramb.c(), paramb.f(), paramb.e(), paramb.g(), paramb.d()), this);
  
  v1(EnumTMPTransportType paramEnumTMPTransportType, b.d.d0.h2.b.b paramb)
  {
    super(paramEnumTMPTransportType, paramb);
  }
  
  private void D()
  {
    this.i = io.reactivex.q.a0(1000L, 150L, TimeUnit.MILLISECONDS).G0(new e(this));
  }
  
  private void E()
  {
    io.reactivex.e0.c localc = this.i;
    if (localc != null)
    {
      localc.dispose();
      this.i = null;
    }
  }
  
  private int F(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 14: 
      return 64023;
    case 13: 
      return 64024;
    case 12: 
      return 64025;
    case 11: 
      return 64026;
    case 10: 
      return 64027;
    case 9: 
      return 64028;
    case 8: 
      return 64029;
    case 7: 
      return 64030;
    case 6: 
      return 64031;
    case 5: 
      return 64032;
    case 4: 
      return 64033;
    case 3: 
      return 64034;
    }
    return 64035;
  }
  
  private b.d.d0.i2.b G(com.tplink.tpble.q paramq)
  {
    return new b.d.d0.i2.b(F(paramq.a()), paramq.b());
  }
  
  public void a(com.tplink.tpble.q paramq, EnumBLEStatus paramEnumBLEStatus)
  {
    if (paramEnumBLEStatus == EnumBLEStatus.BLE_STATUS_DISCONNECTED)
    {
      t(G(paramq), EnumTMPTransportStatus.TMP_TRANSPORT_STATUS_DISCONNECTED);
      E();
    }
  }
  
  public void e(byte[] paramArrayOfByte)
  {
    r(paramArrayOfByte);
  }
  
  public void g()
  {
    super.g();
    this.j.b();
    E();
  }
  
  public io.reactivex.q<b.d.d0.i2.b> h()
  {
    return this.j.c().g0(new c(this)).F(new f(this));
  }
  
  public io.reactivex.q<b.d.d0.i2.b> u(byte[] paramArrayOfByte)
  {
    return this.j.f(paramArrayOfByte).g0(new d(this));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d0\v1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */