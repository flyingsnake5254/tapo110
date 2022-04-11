package com.airbnb.lottie.s.b;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.graphics.Path.Op;
import android.os.Build.VERSION;
import com.airbnb.lottie.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
public class l
  implements m, j
{
  private final Path a = new Path();
  private final Path b = new Path();
  private final Path c = new Path();
  private final String d;
  private final List<m> e = new ArrayList();
  private final MergePaths f;
  
  public l(MergePaths paramMergePaths)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.d = paramMergePaths.c();
      this.f = paramMergePaths;
      return;
    }
    throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
  }
  
  private void a()
  {
    for (int i = 0; i < this.e.size(); i++) {
      this.c.addPath(((m)this.e.get(i)).getPath());
    }
  }
  
  @TargetApi(19)
  private void c(Path.Op paramOp)
  {
    this.b.reset();
    this.a.reset();
    Object localObject2;
    Object localObject3;
    for (int i = this.e.size() - 1; i >= 1; i--)
    {
      localObject1 = (m)this.e.get(i);
      if ((localObject1 instanceof d))
      {
        localObject2 = (d)localObject1;
        localObject3 = ((d)localObject2).i();
        for (int j = ((List)localObject3).size() - 1; j >= 0; j--)
        {
          localObject1 = ((m)((List)localObject3).get(j)).getPath();
          ((Path)localObject1).transform(((d)localObject2).j());
          this.b.addPath((Path)localObject1);
        }
      }
      this.b.addPath(((m)localObject1).getPath());
    }
    Object localObject1 = this.e;
    i = 0;
    localObject1 = (m)((List)localObject1).get(0);
    if ((localObject1 instanceof d))
    {
      localObject3 = (d)localObject1;
      localObject1 = ((d)localObject3).i();
      while (i < ((List)localObject1).size())
      {
        localObject2 = ((m)((List)localObject1).get(i)).getPath();
        ((Path)localObject2).transform(((d)localObject3).j());
        this.a.addPath((Path)localObject2);
        i++;
      }
    }
    this.a.set(((m)localObject1).getPath());
    this.c.op(this.a, this.b, paramOp);
  }
  
  public void b(List<c> paramList1, List<c> paramList2)
  {
    for (int i = 0; i < this.e.size(); i++) {
      ((m)this.e.get(i)).b(paramList1, paramList2);
    }
  }
  
  public void f(ListIterator<c> paramListIterator)
  {
    while ((paramListIterator.hasPrevious()) && (paramListIterator.previous() != this)) {}
    while (paramListIterator.hasPrevious())
    {
      c localc = (c)paramListIterator.previous();
      if ((localc instanceof m))
      {
        this.e.add((m)localc);
        paramListIterator.remove();
      }
    }
  }
  
  public Path getPath()
  {
    this.c.reset();
    if (this.f.d()) {
      return this.c;
    }
    int i = a.a[this.f.b().ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 5) {
              c(Path.Op.XOR);
            }
          }
          else {
            c(Path.Op.INTERSECT);
          }
        }
        else {
          c(Path.Op.REVERSE_DIFFERENCE);
        }
      }
      else {
        c(Path.Op.UNION);
      }
    }
    else {
      a();
    }
    return this.c;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\b\l.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */