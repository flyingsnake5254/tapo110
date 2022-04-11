package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public final class s
  implements m
{
  private final Set<com.bumptech.glide.request.k.j<?>> c = Collections.newSetFromMap(new WeakHashMap());
  
  public void g()
  {
    this.c.clear();
  }
  
  @NonNull
  public List<com.bumptech.glide.request.k.j<?>> i()
  {
    return com.bumptech.glide.util.j.j(this.c);
  }
  
  public void k(@NonNull com.bumptech.glide.request.k.j<?> paramj)
  {
    this.c.add(paramj);
  }
  
  public void l(@NonNull com.bumptech.glide.request.k.j<?> paramj)
  {
    this.c.remove(paramj);
  }
  
  public void onDestroy()
  {
    Iterator localIterator = com.bumptech.glide.util.j.j(this.c).iterator();
    while (localIterator.hasNext()) {
      ((com.bumptech.glide.request.k.j)localIterator.next()).onDestroy();
    }
  }
  
  public void onStart()
  {
    Iterator localIterator = com.bumptech.glide.util.j.j(this.c).iterator();
    while (localIterator.hasNext()) {
      ((com.bumptech.glide.request.k.j)localIterator.next()).onStart();
    }
  }
  
  public void onStop()
  {
    Iterator localIterator = com.bumptech.glide.util.j.j(this.c).iterator();
    while (localIterator.hasNext()) {
      ((com.bumptech.glide.request.k.j)localIterator.next()).onStop();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\manager\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */