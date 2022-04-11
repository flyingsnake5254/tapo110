package retrofit2.adapter.rxjava2;

import io.reactivex.BackpressureStrategy;
import io.reactivex.q;
import io.reactivex.w;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

final class f<R>
  implements retrofit2.c<R, Object>
{
  private final Type a;
  @Nullable
  private final w b;
  private final boolean c;
  private final boolean d;
  private final boolean e;
  private final boolean f;
  private final boolean g;
  private final boolean h;
  private final boolean i;
  
  f(Type paramType, @Nullable w paramw, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, boolean paramBoolean6, boolean paramBoolean7)
  {
    this.a = paramType;
    this.b = paramw;
    this.c = paramBoolean1;
    this.d = paramBoolean2;
    this.e = paramBoolean3;
    this.f = paramBoolean4;
    this.g = paramBoolean5;
    this.h = paramBoolean6;
    this.i = paramBoolean7;
  }
  
  public Type a()
  {
    return this.a;
  }
  
  public Object b(retrofit2.b<R> paramb)
  {
    if (this.c) {
      localObject = new b(paramb);
    } else {
      localObject = new c(paramb);
    }
    if (this.d) {}
    for (paramb = new e((q)localObject);; paramb = new a((q)localObject))
    {
      break;
      paramb = (retrofit2.b<R>)localObject;
      if (!this.e) {
        break;
      }
    }
    w localw = this.b;
    Object localObject = paramb;
    if (localw != null) {
      localObject = paramb.L0(localw);
    }
    if (this.f) {
      return ((q)localObject).Y0(BackpressureStrategy.LATEST);
    }
    if (this.g) {
      return ((q)localObject).C0();
    }
    if (this.h) {
      return ((q)localObject).B0();
    }
    if (this.i) {
      return ((q)localObject).Z();
    }
    return io.reactivex.j0.a.n((q)localObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\retrofit2\adapter\rxjava2\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */