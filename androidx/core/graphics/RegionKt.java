package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.RegionIterator;
import java.util.Iterator;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;
import kotlin.jvm.internal.r.a;
import kotlin.p;

public final class RegionKt
{
  public static final Region and(Region paramRegion, Rect paramRect)
  {
    j.f(paramRegion, "$this$and");
    j.f(paramRect, "r");
    paramRegion = new Region(paramRegion);
    paramRegion.op(paramRect, Region.Op.INTERSECT);
    return paramRegion;
  }
  
  public static final Region and(Region paramRegion1, Region paramRegion2)
  {
    j.f(paramRegion1, "$this$and");
    j.f(paramRegion2, "r");
    paramRegion1 = new Region(paramRegion1);
    paramRegion1.op(paramRegion2, Region.Op.INTERSECT);
    return paramRegion1;
  }
  
  public static final boolean contains(Region paramRegion, Point paramPoint)
  {
    j.f(paramRegion, "$this$contains");
    j.f(paramPoint, "p");
    return paramRegion.contains(paramPoint.x, paramPoint.y);
  }
  
  public static final void forEach(Region paramRegion, l<? super Rect, p> paraml)
  {
    j.f(paramRegion, "$this$forEach");
    j.f(paraml, "action");
    paramRegion = new RegionIterator(paramRegion);
    for (;;)
    {
      Rect localRect = new Rect();
      if (!paramRegion.next(localRect)) {
        return;
      }
      paraml.invoke(localRect);
    }
  }
  
  public static final Iterator<Rect> iterator(Region paramRegion)
  {
    j.f(paramRegion, "$this$iterator");
    new Iterator()
    {
      private boolean hasMore;
      private final RegionIterator iterator;
      private final Rect rect;
      
      public boolean hasNext()
      {
        return this.hasMore;
      }
      
      public Rect next()
      {
        if (this.hasMore)
        {
          Rect localRect = new Rect(this.rect);
          this.hasMore = this.iterator.next(this.rect);
          return localRect;
        }
        throw new IndexOutOfBoundsException();
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
      }
    };
  }
  
  public static final Region minus(Region paramRegion, Rect paramRect)
  {
    j.f(paramRegion, "$this$minus");
    j.f(paramRect, "r");
    paramRegion = new Region(paramRegion);
    paramRegion.op(paramRect, Region.Op.DIFFERENCE);
    return paramRegion;
  }
  
  public static final Region minus(Region paramRegion1, Region paramRegion2)
  {
    j.f(paramRegion1, "$this$minus");
    j.f(paramRegion2, "r");
    paramRegion1 = new Region(paramRegion1);
    paramRegion1.op(paramRegion2, Region.Op.DIFFERENCE);
    return paramRegion1;
  }
  
  public static final Region not(Region paramRegion)
  {
    j.f(paramRegion, "$this$not");
    Region localRegion = new Region(paramRegion.getBounds());
    localRegion.op(paramRegion, Region.Op.DIFFERENCE);
    return localRegion;
  }
  
  public static final Region or(Region paramRegion, Rect paramRect)
  {
    j.f(paramRegion, "$this$or");
    j.f(paramRect, "r");
    paramRegion = new Region(paramRegion);
    paramRegion.union(paramRect);
    return paramRegion;
  }
  
  public static final Region or(Region paramRegion1, Region paramRegion2)
  {
    j.f(paramRegion1, "$this$or");
    j.f(paramRegion2, "r");
    paramRegion1 = new Region(paramRegion1);
    paramRegion1.op(paramRegion2, Region.Op.UNION);
    return paramRegion1;
  }
  
  public static final Region plus(Region paramRegion, Rect paramRect)
  {
    j.f(paramRegion, "$this$plus");
    j.f(paramRect, "r");
    paramRegion = new Region(paramRegion);
    paramRegion.union(paramRect);
    return paramRegion;
  }
  
  public static final Region plus(Region paramRegion1, Region paramRegion2)
  {
    j.f(paramRegion1, "$this$plus");
    j.f(paramRegion2, "r");
    paramRegion1 = new Region(paramRegion1);
    paramRegion1.op(paramRegion2, Region.Op.UNION);
    return paramRegion1;
  }
  
  public static final Region unaryMinus(Region paramRegion)
  {
    j.f(paramRegion, "$this$unaryMinus");
    Region localRegion = new Region(paramRegion.getBounds());
    localRegion.op(paramRegion, Region.Op.DIFFERENCE);
    return localRegion;
  }
  
  public static final Region xor(Region paramRegion, Rect paramRect)
  {
    j.f(paramRegion, "$this$xor");
    j.f(paramRect, "r");
    paramRegion = new Region(paramRegion);
    paramRegion.op(paramRect, Region.Op.XOR);
    return paramRegion;
  }
  
  public static final Region xor(Region paramRegion1, Region paramRegion2)
  {
    j.f(paramRegion1, "$this$xor");
    j.f(paramRegion2, "r");
    paramRegion1 = new Region(paramRegion1);
    paramRegion1.op(paramRegion2, Region.Op.XOR);
    return paramRegion1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\RegionKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */