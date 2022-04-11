package com.airbnb.lottie.s.b;

import android.graphics.Path;
import com.airbnb.lottie.v.h;
import java.util.ArrayList;
import java.util.List;

public class b
{
  private List<s> a = new ArrayList();
  
  void a(s params)
  {
    this.a.add(params);
  }
  
  public void b(Path paramPath)
  {
    for (int i = this.a.size() - 1; i >= 0; i--) {
      h.b(paramPath, (s)this.a.get(i));
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\airbnb\lottie\s\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */