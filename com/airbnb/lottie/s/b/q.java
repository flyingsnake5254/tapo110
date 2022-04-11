package com.airbnb.lottie.s.b;

import android.graphics.Path;
import android.graphics.Path.FillType;
import com.airbnb.lottie.f;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.content.k;
import com.airbnb.lottie.model.i.h;
import com.airbnb.lottie.s.c.a.b;
import java.util.List;

public class q
  implements m, a.b
{
  private final Path a = new Path();
  private final String b;
  private final boolean c;
  private final f d;
  private final com.airbnb.lottie.s.c.a<?, Path> e;
  private boolean f;
  private b g = new b();
  
  public q(f paramf, com.airbnb.lottie.model.layer.a parama, k paramk)
  {
    this.b = paramk.b();
    this.c = paramk.d();
    this.d = paramf;
    paramf = paramk.c().a();
    this.e = paramf;
    parama.i(paramf);
    paramf.a(this);
  }
  
  private void c()
  {
    this.f = false;
    this.d.invalidateSelf();
  }
  
  public void a()
  {
    c();
  }
  
  public void b(List<c> paramList1, List<c> paramList2)
  {
    for (int i = 0; i < paramList1.size(); i++)
    {
      paramList2 = (c)paramList1.get(i);
      if ((paramList2 instanceof s))
      {
        paramList2 = (s)paramList2;
        if (paramList2.i() == ShapeTrimPath.Type.SIMULTANEOUSLY)
        {
          this.g.a(paramList2);
          paramList2.c(this);
        }
      }
    }
  }
  
  public Path getPath()
  {
    if (this.f) {
      return this.a;
    }
    this.a.reset();
    if (this.c)
    {
      this.f = true;
      return this.a;
    }
    this.a.set((Path)this.e.h());
    this.a.setFillType(Path.FillType.EVEN_ODD);
    this.g.b(this.a);
    this.f = true;
    return this.a;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\b\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */