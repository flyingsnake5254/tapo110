package com.bumptech.glide.manager;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.d;
import com.bumptech.glide.util.j;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class r
{
  private final Set<d> a = Collections.newSetFromMap(new WeakHashMap());
  private final List<d> b = new ArrayList();
  private boolean c;
  
  public boolean a(@Nullable d paramd)
  {
    boolean bool1 = true;
    if (paramd == null) {
      return true;
    }
    boolean bool2 = this.a.remove(paramd);
    boolean bool3 = bool1;
    if (!this.b.remove(paramd)) {
      if (bool2) {
        bool3 = bool1;
      } else {
        bool3 = false;
      }
    }
    if (bool3) {
      paramd.clear();
    }
    return bool3;
  }
  
  public void b()
  {
    Iterator localIterator = j.j(this.a).iterator();
    while (localIterator.hasNext()) {
      a((d)localIterator.next());
    }
    this.b.clear();
  }
  
  public void c()
  {
    this.c = true;
    Iterator localIterator = j.j(this.a).iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if ((locald.isRunning()) || (locald.isComplete()))
      {
        locald.clear();
        this.b.add(locald);
      }
    }
  }
  
  public void d()
  {
    this.c = true;
    Iterator localIterator = j.j(this.a).iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if (locald.isRunning())
      {
        locald.pause();
        this.b.add(locald);
      }
    }
  }
  
  public void e()
  {
    Iterator localIterator = j.j(this.a).iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if ((!locald.isComplete()) && (!locald.e()))
      {
        locald.clear();
        if (!this.c) {
          locald.begin();
        } else {
          this.b.add(locald);
        }
      }
    }
  }
  
  public void f()
  {
    this.c = false;
    Iterator localIterator = j.j(this.a).iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if ((!locald.isComplete()) && (!locald.isRunning())) {
        locald.begin();
      }
    }
    this.b.clear();
  }
  
  public void g(@NonNull d paramd)
  {
    this.a.add(paramd);
    if (!this.c)
    {
      paramd.begin();
    }
    else
    {
      paramd.clear();
      if (Log.isLoggable("RequestTracker", 2)) {
        Log.v("RequestTracker", "Paused, delaying request");
      }
      this.b.add(paramd);
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("{numRequests=");
    localStringBuilder.append(this.a.size());
    localStringBuilder.append(", isPaused=");
    localStringBuilder.append(this.c);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\manager\r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */