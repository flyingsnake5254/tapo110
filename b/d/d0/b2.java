package b.d.d0;

import b.d.d0.f2.d;
import b.d.d0.f2.e;
import b.d.d0.i2.b;
import com.tplink.tmp.enumerate.EnumTMPBusinessLayerStatus;
import io.reactivex.l0.a;
import io.reactivex.q;

public class b2
  extends x1
{
  public b2(e2 parame2)
  {
    super((byte)1, (byte)3, parame2);
  }
  
  q<b> b()
  {
    if (this.d != EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_DISCONNECTED) {
      return q.f0(new b()).F(new h0(this)).E(new e0(this)).C(new g0(this));
    }
    throw new RuntimeException("BusinessLayer can't be recycled!");
  }
  
  q<e> n(d paramd)
  {
    if (this.d == EnumTMPBusinessLayerStatus.TMP_BUSINESS_LAYER_STATUS_DISCONNECTED) {
      return q.f0(new e(this.g.a(), this.g.b()));
    }
    return this.e.Q0(1L).N(new i0(this)).N(new j0(this, paramd)).g0(f0.c).L0(a.c());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\d0\b2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */