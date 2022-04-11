package b.d.d0;

import b.d.d0.f2.e;
import b.d.d0.i2.b;
import com.tplink.tmp.enumerate.EnumTMPBusinessLayerStatus;

public class z1
  extends x1
{
  public z1(e2 parame2)
  {
    super((byte)1, (byte)1, parame2);
  }
  
  public io.reactivex.q<b> b()
  {
    if (this.d != EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_DISCONNECTED) {
      return io.reactivex.q.f0(new b()).F(new p(this)).E(new n(this)).C(new r(this));
    }
    throw new RuntimeException("BusinessLayer can't be recycled!");
  }
  
  public io.reactivex.q<e> n(b.d.d0.f2.d paramd)
  {
    if (this.d == EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_DISCONNECTED) {
      return io.reactivex.q.f0(new e(this.g.a(), this.g.b()));
    }
    return this.e.Q0(1L).N(new o(this)).N(new s(this, paramd)).g0(q.c).L0(io.reactivex.l0.a.c());
  }
  
  public io.reactivex.q<b.d.d0.i2.a<b.d.d0.g2.d>> q(b.d.d0.g2.d paramd)
  {
    return super.q(paramd).g0(t.c);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d0\z1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */