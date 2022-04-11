package com.airbnb.lottie.s.b;

import com.airbnb.lottie.model.content.ShapeTrimPath;
import com.airbnb.lottie.model.content.ShapeTrimPath.Type;
import com.airbnb.lottie.model.i.b;
import com.airbnb.lottie.s.c.a.b;
import java.util.ArrayList;
import java.util.List;

public class s
  implements c, a.b
{
  private final String a;
  private final boolean b;
  private final List<a.b> c = new ArrayList();
  private final ShapeTrimPath.Type d;
  private final com.airbnb.lottie.s.c.a<?, Float> e;
  private final com.airbnb.lottie.s.c.a<?, Float> f;
  private final com.airbnb.lottie.s.c.a<?, Float> g;
  
  public s(com.airbnb.lottie.model.layer.a parama, ShapeTrimPath paramShapeTrimPath)
  {
    this.a = paramShapeTrimPath.c();
    this.b = paramShapeTrimPath.g();
    this.d = paramShapeTrimPath.f();
    com.airbnb.lottie.s.c.a locala1 = paramShapeTrimPath.e().a();
    this.e = locala1;
    com.airbnb.lottie.s.c.a locala2 = paramShapeTrimPath.b().a();
    this.f = locala2;
    paramShapeTrimPath = paramShapeTrimPath.d().a();
    this.g = paramShapeTrimPath;
    parama.i(locala1);
    parama.i(locala2);
    parama.i(paramShapeTrimPath);
    locala1.a(this);
    locala2.a(this);
    paramShapeTrimPath.a(this);
  }
  
  public void a()
  {
    for (int i = 0; i < this.c.size(); i++) {
      ((a.b)this.c.get(i)).a();
    }
  }
  
  public void b(List<c> paramList1, List<c> paramList2) {}
  
  void c(a.b paramb)
  {
    this.c.add(paramb);
  }
  
  public com.airbnb.lottie.s.c.a<?, Float> d()
  {
    return this.f;
  }
  
  public com.airbnb.lottie.s.c.a<?, Float> f()
  {
    return this.g;
  }
  
  public com.airbnb.lottie.s.c.a<?, Float> h()
  {
    return this.e;
  }
  
  ShapeTrimPath.Type i()
  {
    return this.d;
  }
  
  public boolean j()
  {
    return this.b;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\b\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */