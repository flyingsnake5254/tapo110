package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.j;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

class a
  implements l
{
  private final Set<m> a = Collections.newSetFromMap(new WeakHashMap());
  private boolean b;
  private boolean c;
  
  public void a(@NonNull m paramm)
  {
    this.a.remove(paramm);
  }
  
  public void b(@NonNull m paramm)
  {
    this.a.add(paramm);
    if (this.c) {
      paramm.onDestroy();
    } else if (this.b) {
      paramm.onStart();
    } else {
      paramm.onStop();
    }
  }
  
  void c()
  {
    this.c = true;
    Iterator localIterator = j.j(this.a).iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).onDestroy();
    }
  }
  
  void d()
  {
    this.b = true;
    Iterator localIterator = j.j(this.a).iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).onStart();
    }
  }
  
  void e()
  {
    this.b = false;
    Iterator localIterator = j.j(this.a).iterator();
    while (localIterator.hasNext()) {
      ((m)localIterator.next()).onStop();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\manager\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */