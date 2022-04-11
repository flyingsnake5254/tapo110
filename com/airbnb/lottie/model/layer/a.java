package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.model.content.Mask.MaskMode;
import com.airbnb.lottie.model.i.l;
import com.airbnb.lottie.n;
import com.airbnb.lottie.s.c.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class a
  implements com.airbnb.lottie.s.b.e, com.airbnb.lottie.s.c.a.b, com.airbnb.lottie.model.e
{
  private final Path a = new Path();
  private final Matrix b = new Matrix();
  private final Paint c = new com.airbnb.lottie.s.a(1);
  private final Paint d = new com.airbnb.lottie.s.a(1, PorterDuff.Mode.DST_IN);
  private final Paint e = new com.airbnb.lottie.s.a(1, PorterDuff.Mode.DST_OUT);
  private final Paint f;
  private final Paint g;
  private final RectF h;
  private final RectF i;
  private final RectF j;
  private final RectF k;
  private final String l;
  final Matrix m;
  final com.airbnb.lottie.f n;
  final Layer o;
  @Nullable
  private com.airbnb.lottie.s.c.g p;
  @Nullable
  private com.airbnb.lottie.s.c.c q;
  @Nullable
  private a r;
  @Nullable
  private a s;
  private List<a> t;
  private final List<com.airbnb.lottie.s.c.a<?, ?>> u;
  final o v;
  private boolean w;
  
  a(com.airbnb.lottie.f paramf, Layer paramLayer)
  {
    com.airbnb.lottie.s.a locala = new com.airbnb.lottie.s.a(1);
    this.f = locala;
    this.g = new com.airbnb.lottie.s.a(PorterDuff.Mode.CLEAR);
    this.h = new RectF();
    this.i = new RectF();
    this.j = new RectF();
    this.k = new RectF();
    this.m = new Matrix();
    this.u = new ArrayList();
    this.w = true;
    this.n = paramf;
    this.o = paramLayer;
    paramf = new StringBuilder();
    paramf.append(paramLayer.g());
    paramf.append("#draw");
    this.l = paramf.toString();
    if (paramLayer.f() == Layer.MatteType.INVERT) {
      locala.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    } else {
      locala.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }
    paramf = paramLayer.u().b();
    this.v = paramf;
    paramf.b(this);
    if ((paramLayer.e() != null) && (!paramLayer.e().isEmpty()))
    {
      paramf = new com.airbnb.lottie.s.c.g(paramLayer.e());
      this.p = paramf;
      paramf = paramf.a().iterator();
      while (paramf.hasNext()) {
        ((com.airbnb.lottie.s.c.a)paramf.next()).a(this);
      }
      paramf = this.p.c().iterator();
      while (paramf.hasNext())
      {
        paramLayer = (com.airbnb.lottie.s.c.a)paramf.next();
        i(paramLayer);
        paramLayer.a(this);
      }
    }
    I();
  }
  
  private void A()
  {
    this.n.invalidateSelf();
  }
  
  private void B(float paramFloat)
  {
    this.n.m().m().a(this.o.g(), paramFloat);
  }
  
  private void H(boolean paramBoolean)
  {
    if (paramBoolean != this.w)
    {
      this.w = paramBoolean;
      A();
    }
  }
  
  private void I()
  {
    boolean bool1 = this.o.c().isEmpty();
    boolean bool2 = true;
    if (!bool1)
    {
      com.airbnb.lottie.s.c.c localc = new com.airbnb.lottie.s.c.c(this.o.c());
      this.q = localc;
      localc.k();
      this.q.a(new a());
      if (((Float)this.q.h()).floatValue() != 1.0F) {
        bool2 = false;
      }
      H(bool2);
      i(this.q);
    }
    else
    {
      H(true);
    }
  }
  
  private void j(Canvas paramCanvas, Matrix paramMatrix, Mask paramMask, com.airbnb.lottie.s.c.a<com.airbnb.lottie.model.content.h, Path> parama, com.airbnb.lottie.s.c.a<Integer, Integer> parama1)
  {
    paramMask = (Path)parama.h();
    this.a.set(paramMask);
    this.a.transform(paramMatrix);
    this.c.setAlpha((int)(((Integer)parama1.h()).intValue() * 2.55F));
    paramCanvas.drawPath(this.a, this.c);
  }
  
  private void k(Canvas paramCanvas, Matrix paramMatrix, Mask paramMask, com.airbnb.lottie.s.c.a<com.airbnb.lottie.model.content.h, Path> parama, com.airbnb.lottie.s.c.a<Integer, Integer> parama1)
  {
    com.airbnb.lottie.v.h.m(paramCanvas, this.h, this.d);
    paramMask = (Path)parama.h();
    this.a.set(paramMask);
    this.a.transform(paramMatrix);
    this.c.setAlpha((int)(((Integer)parama1.h()).intValue() * 2.55F));
    paramCanvas.drawPath(this.a, this.c);
    paramCanvas.restore();
  }
  
  private void l(Canvas paramCanvas, Matrix paramMatrix, Mask paramMask, com.airbnb.lottie.s.c.a<com.airbnb.lottie.model.content.h, Path> parama, com.airbnb.lottie.s.c.a<Integer, Integer> parama1)
  {
    com.airbnb.lottie.v.h.m(paramCanvas, this.h, this.c);
    paramCanvas.drawRect(this.h, this.c);
    paramMask = (Path)parama.h();
    this.a.set(paramMask);
    this.a.transform(paramMatrix);
    this.c.setAlpha((int)(((Integer)parama1.h()).intValue() * 2.55F));
    paramCanvas.drawPath(this.a, this.e);
    paramCanvas.restore();
  }
  
  private void m(Canvas paramCanvas, Matrix paramMatrix, Mask paramMask, com.airbnb.lottie.s.c.a<com.airbnb.lottie.model.content.h, Path> parama, com.airbnb.lottie.s.c.a<Integer, Integer> parama1)
  {
    com.airbnb.lottie.v.h.m(paramCanvas, this.h, this.d);
    paramCanvas.drawRect(this.h, this.c);
    this.e.setAlpha((int)(((Integer)parama1.h()).intValue() * 2.55F));
    paramMask = (Path)parama.h();
    this.a.set(paramMask);
    this.a.transform(paramMatrix);
    paramCanvas.drawPath(this.a, this.e);
    paramCanvas.restore();
  }
  
  private void n(Canvas paramCanvas, Matrix paramMatrix, Mask paramMask, com.airbnb.lottie.s.c.a<com.airbnb.lottie.model.content.h, Path> parama, com.airbnb.lottie.s.c.a<Integer, Integer> parama1)
  {
    com.airbnb.lottie.v.h.m(paramCanvas, this.h, this.e);
    paramCanvas.drawRect(this.h, this.c);
    this.e.setAlpha((int)(((Integer)parama1.h()).intValue() * 2.55F));
    paramMask = (Path)parama.h();
    this.a.set(paramMask);
    this.a.transform(paramMatrix);
    paramCanvas.drawPath(this.a, this.e);
    paramCanvas.restore();
  }
  
  private void o(Canvas paramCanvas, Matrix paramMatrix)
  {
    com.airbnb.lottie.c.a("Layer#saveLayer");
    com.airbnb.lottie.v.h.n(paramCanvas, this.h, this.d, 19);
    if (Build.VERSION.SDK_INT < 28) {
      s(paramCanvas);
    }
    com.airbnb.lottie.c.b("Layer#saveLayer");
    for (int i1 = 0; i1 < this.p.b().size(); i1++)
    {
      Mask localMask = (Mask)this.p.b().get(i1);
      com.airbnb.lottie.s.c.a locala1 = (com.airbnb.lottie.s.c.a)this.p.a().get(i1);
      com.airbnb.lottie.s.c.a locala2 = (com.airbnb.lottie.s.c.a)this.p.c().get(i1);
      int i2 = b.b[localMask.a().ordinal()];
      if (i2 != 1)
      {
        if (i2 != 2)
        {
          if (i2 != 3)
          {
            if (i2 == 4) {
              if (localMask.d()) {
                l(paramCanvas, paramMatrix, localMask, locala1, locala2);
              } else {
                j(paramCanvas, paramMatrix, localMask, locala1, locala2);
              }
            }
          }
          else if (localMask.d()) {
            m(paramCanvas, paramMatrix, localMask, locala1, locala2);
          } else {
            k(paramCanvas, paramMatrix, localMask, locala1, locala2);
          }
        }
        else
        {
          if (i1 == 0)
          {
            this.c.setColor(-16777216);
            this.c.setAlpha(255);
            paramCanvas.drawRect(this.h, this.c);
          }
          if (localMask.d()) {
            n(paramCanvas, paramMatrix, localMask, locala1, locala2);
          } else {
            p(paramCanvas, paramMatrix, localMask, locala1, locala2);
          }
        }
      }
      else if (q())
      {
        this.c.setAlpha(255);
        paramCanvas.drawRect(this.h, this.c);
      }
    }
    com.airbnb.lottie.c.a("Layer#restoreLayer");
    paramCanvas.restore();
    com.airbnb.lottie.c.b("Layer#restoreLayer");
  }
  
  private void p(Canvas paramCanvas, Matrix paramMatrix, Mask paramMask, com.airbnb.lottie.s.c.a<com.airbnb.lottie.model.content.h, Path> parama, com.airbnb.lottie.s.c.a<Integer, Integer> parama1)
  {
    paramMask = (Path)parama.h();
    this.a.set(paramMask);
    this.a.transform(paramMatrix);
    paramCanvas.drawPath(this.a, this.e);
  }
  
  private boolean q()
  {
    if (this.p.a().isEmpty()) {
      return false;
    }
    for (int i1 = 0; i1 < this.p.b().size(); i1++) {
      if (((Mask)this.p.b().get(i1)).a() != Mask.MaskMode.MASK_MODE_NONE) {
        return false;
      }
    }
    return true;
  }
  
  private void r()
  {
    if (this.t != null) {
      return;
    }
    if (this.s == null)
    {
      this.t = Collections.emptyList();
      return;
    }
    this.t = new ArrayList();
    for (a locala = this.s; locala != null; locala = locala.s) {
      this.t.add(locala);
    }
  }
  
  private void s(Canvas paramCanvas)
  {
    com.airbnb.lottie.c.a("Layer#clearLayer");
    RectF localRectF = this.h;
    paramCanvas.drawRect(localRectF.left - 1.0F, localRectF.top - 1.0F, localRectF.right + 1.0F, localRectF.bottom + 1.0F, this.g);
    com.airbnb.lottie.c.b("Layer#clearLayer");
  }
  
  @Nullable
  static a u(Layer paramLayer, com.airbnb.lottie.f paramf, com.airbnb.lottie.d paramd)
  {
    switch (b.a[paramLayer.d().ordinal()])
    {
    default: 
      paramf = new StringBuilder();
      paramf.append("Unknown layer type ");
      paramf.append(paramLayer.d());
      com.airbnb.lottie.v.d.c(paramf.toString());
      return null;
    case 6: 
      return new g(paramf, paramLayer);
    case 5: 
      return new d(paramf, paramLayer);
    case 4: 
      return new c(paramf, paramLayer);
    case 3: 
      return new f(paramf, paramLayer);
    case 2: 
      return new b(paramf, paramLayer, paramd.n(paramLayer.k()), paramd);
    }
    return new e(paramf, paramLayer);
  }
  
  private void y(RectF paramRectF, Matrix paramMatrix)
  {
    this.i.set(0.0F, 0.0F, 0.0F, 0.0F);
    if (!w()) {
      return;
    }
    int i1 = this.p.b().size();
    int i2 = 0;
    while (i2 < i1)
    {
      Object localObject = (Mask)this.p.b().get(i2);
      Path localPath = (Path)((com.airbnb.lottie.s.c.a)this.p.a().get(i2)).h();
      this.a.set(localPath);
      this.a.transform(paramMatrix);
      int i3 = b.b[localObject.a().ordinal()];
      if ((i3 != 1) && (i3 != 2))
      {
        if (((i3 == 3) || (i3 == 4)) && (((Mask)localObject).d())) {
          return;
        }
        this.a.computeBounds(this.k, false);
        if (i2 == 0)
        {
          this.i.set(this.k);
        }
        else
        {
          localObject = this.i;
          ((RectF)localObject).set(Math.min(((RectF)localObject).left, this.k.left), Math.min(this.i.top, this.k.top), Math.max(this.i.right, this.k.right), Math.max(this.i.bottom, this.k.bottom));
        }
        i2++;
      }
      else
      {
        return;
      }
    }
    if (!paramRectF.intersect(this.i)) {
      paramRectF.set(0.0F, 0.0F, 0.0F, 0.0F);
    }
  }
  
  private void z(RectF paramRectF, Matrix paramMatrix)
  {
    if (!x()) {
      return;
    }
    if (this.o.f() == Layer.MatteType.INVERT) {
      return;
    }
    this.j.set(0.0F, 0.0F, 0.0F, 0.0F);
    this.r.e(this.j, paramMatrix, true);
    if (!paramRectF.intersect(this.j)) {
      paramRectF.set(0.0F, 0.0F, 0.0F, 0.0F);
    }
  }
  
  public void C(com.airbnb.lottie.s.c.a<?, ?> parama)
  {
    this.u.remove(parama);
  }
  
  void D(com.airbnb.lottie.model.d paramd1, int paramInt, List<com.airbnb.lottie.model.d> paramList, com.airbnb.lottie.model.d paramd2) {}
  
  void E(@Nullable a parama)
  {
    this.r = parama;
  }
  
  void F(@Nullable a parama)
  {
    this.s = parama;
  }
  
  void G(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    this.v.j(paramFloat);
    Object localObject = this.p;
    int i1 = 0;
    if (localObject != null) {
      for (i2 = 0; i2 < this.p.a().size(); i2++) {
        ((com.airbnb.lottie.s.c.a)this.p.a().get(i2)).l(paramFloat);
      }
    }
    float f1 = paramFloat;
    if (this.o.t() != 0.0F) {
      f1 = paramFloat / this.o.t();
    }
    localObject = this.q;
    if (localObject != null) {
      ((com.airbnb.lottie.s.c.a)localObject).l(f1 / this.o.t());
    }
    localObject = this.r;
    int i2 = i1;
    if (localObject != null)
    {
      paramFloat = ((a)localObject).o.t();
      this.r.G(paramFloat * f1);
    }
    for (i2 = i1; i2 < this.u.size(); i2++) {
      ((com.airbnb.lottie.s.c.a)this.u.get(i2)).l(f1);
    }
  }
  
  public void a()
  {
    A();
  }
  
  public void b(List<com.airbnb.lottie.s.b.c> paramList1, List<com.airbnb.lottie.s.b.c> paramList2) {}
  
  @CallSuper
  public <T> void c(T paramT, @Nullable com.airbnb.lottie.w.c<T> paramc)
  {
    this.v.c(paramT, paramc);
  }
  
  public void d(com.airbnb.lottie.model.d paramd1, int paramInt, List<com.airbnb.lottie.model.d> paramList, com.airbnb.lottie.model.d paramd2)
  {
    if (!paramd1.h(getName(), paramInt)) {
      return;
    }
    com.airbnb.lottie.model.d locald = paramd2;
    if (!"__container".equals(getName()))
    {
      paramd2 = paramd2.a(getName());
      locald = paramd2;
      if (paramd1.c(getName(), paramInt))
      {
        paramList.add(paramd2.j(this));
        locald = paramd2;
      }
    }
    if (paramd1.i(getName(), paramInt)) {
      D(paramd1, paramInt + paramd1.e(getName(), paramInt), paramList, locald);
    }
  }
  
  @CallSuper
  public void e(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean)
  {
    this.h.set(0.0F, 0.0F, 0.0F, 0.0F);
    r();
    this.m.set(paramMatrix);
    if (paramBoolean)
    {
      paramRectF = this.t;
      if (paramRectF != null) {
        for (int i1 = paramRectF.size() - 1; i1 >= 0; i1--) {
          this.m.preConcat(((a)this.t.get(i1)).v.f());
        }
      }
      paramRectF = this.s;
      if (paramRectF != null) {
        this.m.preConcat(paramRectF.v.f());
      }
    }
    this.m.preConcat(this.v.f());
  }
  
  public void g(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    com.airbnb.lottie.c.a(this.l);
    if ((this.w) && (!this.o.v()))
    {
      r();
      com.airbnb.lottie.c.a("Layer#parentMatrix");
      this.b.reset();
      this.b.set(paramMatrix);
      for (int i1 = this.t.size() - 1; i1 >= 0; i1--) {
        this.b.preConcat(((a)this.t.get(i1)).v.f());
      }
      com.airbnb.lottie.c.b("Layer#parentMatrix");
      if (this.v.h() == null) {
        i1 = 100;
      } else {
        i1 = ((Integer)this.v.h().h()).intValue();
      }
      paramInt = (int)(paramInt / 255.0F * i1 / 100.0F * 255.0F);
      if ((!x()) && (!w()))
      {
        this.b.preConcat(this.v.f());
        com.airbnb.lottie.c.a("Layer#drawLayer");
        t(paramCanvas, this.b, paramInt);
        com.airbnb.lottie.c.b("Layer#drawLayer");
        B(com.airbnb.lottie.c.b(this.l));
        return;
      }
      com.airbnb.lottie.c.a("Layer#computeBounds");
      e(this.h, this.b, false);
      z(this.h, paramMatrix);
      this.b.preConcat(this.v.f());
      y(this.h, this.b);
      if (!this.h.intersect(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight())) {
        this.h.set(0.0F, 0.0F, 0.0F, 0.0F);
      }
      com.airbnb.lottie.c.b("Layer#computeBounds");
      if (!this.h.isEmpty())
      {
        com.airbnb.lottie.c.a("Layer#saveLayer");
        this.c.setAlpha(255);
        com.airbnb.lottie.v.h.m(paramCanvas, this.h, this.c);
        com.airbnb.lottie.c.b("Layer#saveLayer");
        s(paramCanvas);
        com.airbnb.lottie.c.a("Layer#drawLayer");
        t(paramCanvas, this.b, paramInt);
        com.airbnb.lottie.c.b("Layer#drawLayer");
        if (w()) {
          o(paramCanvas, this.b);
        }
        if (x())
        {
          com.airbnb.lottie.c.a("Layer#drawMatte");
          com.airbnb.lottie.c.a("Layer#saveLayer");
          com.airbnb.lottie.v.h.n(paramCanvas, this.h, this.f, 19);
          com.airbnb.lottie.c.b("Layer#saveLayer");
          s(paramCanvas);
          this.r.g(paramCanvas, paramMatrix, paramInt);
          com.airbnb.lottie.c.a("Layer#restoreLayer");
          paramCanvas.restore();
          com.airbnb.lottie.c.b("Layer#restoreLayer");
          com.airbnb.lottie.c.b("Layer#drawMatte");
        }
        com.airbnb.lottie.c.a("Layer#restoreLayer");
        paramCanvas.restore();
        com.airbnb.lottie.c.b("Layer#restoreLayer");
      }
      B(com.airbnb.lottie.c.b(this.l));
      return;
    }
    com.airbnb.lottie.c.b(this.l);
  }
  
  public String getName()
  {
    return this.o.g();
  }
  
  public void i(@Nullable com.airbnb.lottie.s.c.a<?, ?> parama)
  {
    if (parama == null) {
      return;
    }
    this.u.add(parama);
  }
  
  abstract void t(Canvas paramCanvas, Matrix paramMatrix, int paramInt);
  
  Layer v()
  {
    return this.o;
  }
  
  boolean w()
  {
    com.airbnb.lottie.s.c.g localg = this.p;
    boolean bool;
    if ((localg != null) && (!localg.a().isEmpty())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  boolean x()
  {
    boolean bool;
    if (this.r != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  class a
    implements com.airbnb.lottie.s.c.a.b
  {
    a() {}
    
    public void a()
    {
      a locala = a.this;
      boolean bool;
      if (a.f(locala).o() == 1.0F) {
        bool = true;
      } else {
        bool = false;
      }
      a.h(locala, bool);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\layer\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */