package com.airbnb.lottie.model.content;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import com.airbnb.lottie.model.a;
import com.airbnb.lottie.v.d;
import com.airbnb.lottie.v.g;
import java.util.ArrayList;
import java.util.List;

public class h
{
  private final List<a> a;
  private PointF b;
  private boolean c;
  
  public h()
  {
    this.a = new ArrayList();
  }
  
  public h(PointF paramPointF, boolean paramBoolean, List<a> paramList)
  {
    this.b = paramPointF;
    this.c = paramBoolean;
    this.a = new ArrayList(paramList);
  }
  
  private void e(float paramFloat1, float paramFloat2)
  {
    if (this.b == null) {
      this.b = new PointF();
    }
    this.b.set(paramFloat1, paramFloat2);
  }
  
  public List<a> a()
  {
    return this.a;
  }
  
  public PointF b()
  {
    return this.b;
  }
  
  public void c(h paramh1, h paramh2, @FloatRange(from=0.0D, to=1.0D) float paramFloat)
  {
    if (this.b == null) {
      this.b = new PointF();
    }
    boolean bool;
    if ((!paramh1.d()) && (!paramh2.d())) {
      bool = false;
    } else {
      bool = true;
    }
    this.c = bool;
    if (paramh1.a().size() != paramh2.a().size())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Curves must have the same number of control points. Shape 1: ");
      ((StringBuilder)localObject1).append(paramh1.a().size());
      ((StringBuilder)localObject1).append("\tShape 2: ");
      ((StringBuilder)localObject1).append(paramh2.a().size());
      d.c(((StringBuilder)localObject1).toString());
    }
    int i = Math.min(paramh1.a().size(), paramh2.a().size());
    if (this.a.size() < i) {
      for (j = this.a.size(); j < i; j++) {
        this.a.add(new a());
      }
    }
    if (this.a.size() > i) {
      for (j = this.a.size() - 1; j >= i; j--)
      {
        localObject1 = this.a;
        ((List)localObject1).remove(((List)localObject1).size() - 1);
      }
    }
    Object localObject1 = paramh1.b();
    PointF localPointF1 = paramh2.b();
    e(g.j(((PointF)localObject1).x, localPointF1.x, paramFloat), g.j(((PointF)localObject1).y, localPointF1.y, paramFloat));
    for (int j = this.a.size() - 1; j >= 0; j--)
    {
      Object localObject2 = (a)paramh1.a().get(j);
      Object localObject3 = (a)paramh2.a().get(j);
      localPointF1 = ((a)localObject2).a();
      localObject1 = ((a)localObject2).b();
      PointF localPointF2 = ((a)localObject2).c();
      localObject2 = ((a)localObject3).a();
      PointF localPointF3 = ((a)localObject3).b();
      localObject3 = ((a)localObject3).c();
      ((a)this.a.get(j)).d(g.j(localPointF1.x, ((PointF)localObject2).x, paramFloat), g.j(localPointF1.y, ((PointF)localObject2).y, paramFloat));
      ((a)this.a.get(j)).e(g.j(((PointF)localObject1).x, localPointF3.x, paramFloat), g.j(((PointF)localObject1).y, localPointF3.y, paramFloat));
      ((a)this.a.get(j)).f(g.j(localPointF2.x, ((PointF)localObject3).x, paramFloat), g.j(localPointF2.y, ((PointF)localObject3).y, paramFloat));
    }
  }
  
  public boolean d()
  {
    return this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShapeData{numCurves=");
    localStringBuilder.append(this.a.size());
    localStringBuilder.append("closed=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\content\h.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */