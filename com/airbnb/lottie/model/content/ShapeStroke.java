package com.airbnb.lottie.model.content;

import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import androidx.annotation.Nullable;
import com.airbnb.lottie.f;
import com.airbnb.lottie.model.i.d;
import com.airbnb.lottie.s.b.c;
import com.airbnb.lottie.s.b.r;
import java.util.List;

public class ShapeStroke
  implements b
{
  private final String a;
  @Nullable
  private final com.airbnb.lottie.model.i.b b;
  private final List<com.airbnb.lottie.model.i.b> c;
  private final com.airbnb.lottie.model.i.a d;
  private final d e;
  private final com.airbnb.lottie.model.i.b f;
  private final LineCapType g;
  private final LineJoinType h;
  private final float i;
  private final boolean j;
  
  public ShapeStroke(String paramString, @Nullable com.airbnb.lottie.model.i.b paramb1, List<com.airbnb.lottie.model.i.b> paramList, com.airbnb.lottie.model.i.a parama, d paramd, com.airbnb.lottie.model.i.b paramb2, LineCapType paramLineCapType, LineJoinType paramLineJoinType, float paramFloat, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramb1;
    this.c = paramList;
    this.d = parama;
    this.e = paramd;
    this.f = paramb2;
    this.g = paramLineCapType;
    this.h = paramLineJoinType;
    this.i = paramFloat;
    this.j = paramBoolean;
  }
  
  public c a(f paramf, com.airbnb.lottie.model.layer.a parama)
  {
    return new r(paramf, parama, this);
  }
  
  public LineCapType b()
  {
    return this.g;
  }
  
  public com.airbnb.lottie.model.i.a c()
  {
    return this.d;
  }
  
  public com.airbnb.lottie.model.i.b d()
  {
    return this.b;
  }
  
  public LineJoinType e()
  {
    return this.h;
  }
  
  public List<com.airbnb.lottie.model.i.b> f()
  {
    return this.c;
  }
  
  public float g()
  {
    return this.i;
  }
  
  public String h()
  {
    return this.a;
  }
  
  public d i()
  {
    return this.e;
  }
  
  public com.airbnb.lottie.model.i.b j()
  {
    return this.f;
  }
  
  public boolean k()
  {
    return this.j;
  }
  
  public static enum LineCapType
  {
    static
    {
      LineCapType localLineCapType1 = new LineCapType("BUTT", 0);
      BUTT = localLineCapType1;
      LineCapType localLineCapType2 = new LineCapType("ROUND", 1);
      ROUND = localLineCapType2;
      LineCapType localLineCapType3 = new LineCapType("UNKNOWN", 2);
      UNKNOWN = localLineCapType3;
      $VALUES = new LineCapType[] { localLineCapType1, localLineCapType2, localLineCapType3 };
    }
    
    public Paint.Cap toPaintCap()
    {
      int i = ShapeStroke.a.a[ordinal()];
      if (i != 1)
      {
        if (i != 2) {
          return Paint.Cap.SQUARE;
        }
        return Paint.Cap.ROUND;
      }
      return Paint.Cap.BUTT;
    }
  }
  
  public static enum LineJoinType
  {
    static
    {
      LineJoinType localLineJoinType1 = new LineJoinType("MITER", 0);
      MITER = localLineJoinType1;
      LineJoinType localLineJoinType2 = new LineJoinType("ROUND", 1);
      ROUND = localLineJoinType2;
      LineJoinType localLineJoinType3 = new LineJoinType("BEVEL", 2);
      BEVEL = localLineJoinType3;
      $VALUES = new LineJoinType[] { localLineJoinType1, localLineJoinType2, localLineJoinType3 };
    }
    
    public Paint.Join toPaintJoin()
    {
      int i = ShapeStroke.a.b[ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3) {
            return null;
          }
          return Paint.Join.ROUND;
        }
        return Paint.Join.MITER;
      }
      return Paint.Join.BEVEL;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\model\content\ShapeStroke.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */