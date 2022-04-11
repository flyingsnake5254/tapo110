package com.airbnb.lottie.model.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import com.airbnb.lottie.f;
import com.airbnb.lottie.k;
import com.airbnb.lottie.s.c.p;
import com.airbnb.lottie.v.h;
import java.util.ArrayList;
import java.util.List;

public class b
  extends a
{
  private final RectF A = new RectF();
  private Paint B = new Paint();
  @Nullable
  private com.airbnb.lottie.s.c.a<Float, Float> x;
  private final List<a> y = new ArrayList();
  private final RectF z = new RectF();
  
  public b(f paramf, Layer paramLayer, List<Layer> paramList, com.airbnb.lottie.d paramd)
  {
    super(paramf, paramLayer);
    paramLayer = paramLayer.s();
    if (paramLayer != null)
    {
      paramLayer = paramLayer.a();
      this.x = paramLayer;
      i(paramLayer);
      this.x.a(this);
    }
    else
    {
      this.x = null;
    }
    LongSparseArray localLongSparseArray = new LongSparseArray(paramd.j().size());
    int i = paramList.size() - 1;
    paramLayer = null;
    int j;
    for (;;)
    {
      j = 0;
      if (i < 0) {
        break;
      }
      Layer localLayer = (Layer)paramList.get(i);
      a locala = a.u(localLayer, paramf, paramd);
      if (locala != null)
      {
        localLongSparseArray.put(locala.v().b(), locala);
        if (paramLayer != null)
        {
          paramLayer.E(locala);
          paramLayer = null;
        }
        else
        {
          this.y.add(0, locala);
          j = a.a[localLayer.f().ordinal()];
          if ((j == 1) || (j == 2)) {
            paramLayer = locala;
          }
        }
      }
      i--;
    }
    while (j < localLongSparseArray.size())
    {
      paramf = (a)localLongSparseArray.get(localLongSparseArray.keyAt(j));
      if (paramf != null)
      {
        paramLayer = (a)localLongSparseArray.get(paramf.v().h());
        if (paramLayer != null) {
          paramf.F(paramLayer);
        }
      }
      j++;
    }
  }
  
  protected void D(com.airbnb.lottie.model.d paramd1, int paramInt, List<com.airbnb.lottie.model.d> paramList, com.airbnb.lottie.model.d paramd2)
  {
    for (int i = 0; i < this.y.size(); i++) {
      ((a)this.y.get(i)).d(paramd1, paramInt, paramList, paramd2);
    }
  }
  
  public void G(@FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    super.G(paramFloat);
    float f = paramFloat;
    if (this.x != null)
    {
      f = this.n.m().e();
      paramFloat = this.o.a().o();
      f = (((Float)this.x.h()).floatValue() * this.o.a().h() - paramFloat) / (f + 0.01F);
    }
    paramFloat = f;
    if (this.x == null) {
      paramFloat = f - this.o.p();
    }
    f = paramFloat;
    if (this.o.t() != 0.0F) {
      f = paramFloat / this.o.t();
    }
    for (int i = this.y.size() - 1; i >= 0; i--) {
      ((a)this.y.get(i)).G(f);
    }
  }
  
  public <T> void c(T paramT, @Nullable com.airbnb.lottie.w.c<T> paramc)
  {
    super.c(paramT, paramc);
    if (paramT == k.A) {
      if (paramc == null)
      {
        paramT = this.x;
        if (paramT != null) {
          paramT.m(null);
        }
      }
      else
      {
        paramT = new p(paramc);
        this.x = paramT;
        paramT.a(this);
        i(this.x);
      }
    }
  }
  
  public void e(RectF paramRectF, Matrix paramMatrix, boolean paramBoolean)
  {
    super.e(paramRectF, paramMatrix, paramBoolean);
    for (int i = this.y.size() - 1; i >= 0; i--)
    {
      this.z.set(0.0F, 0.0F, 0.0F, 0.0F);
      ((a)this.y.get(i)).e(this.z, this.m, true);
      paramRectF.union(this.z);
    }
  }
  
  void t(Canvas paramCanvas, Matrix paramMatrix, int paramInt)
  {
    com.airbnb.lottie.c.a("CompositionLayer#draw");
    this.A.set(0.0F, 0.0F, this.o.j(), this.o.i());
    paramMatrix.mapRect(this.A);
    if ((this.n.F()) && (this.y.size() > 1) && (paramInt != 255)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      this.B.setAlpha(paramInt);
      h.m(paramCanvas, this.A, this.B);
    }
    else
    {
      paramCanvas.save();
    }
    if (i != 0) {
      paramInt = 255;
    }
    for (int i = this.y.size() - 1; i >= 0; i--)
    {
      boolean bool;
      if (!this.A.isEmpty()) {
        bool = paramCanvas.clipRect(this.A);
      } else {
        bool = true;
      }
      if (bool) {
        ((a)this.y.get(i)).g(paramCanvas, paramMatrix, paramInt);
      }
    }
    paramCanvas.restore();
    com.airbnb.lottie.c.b("CompositionLayer#draw");
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\layer\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */