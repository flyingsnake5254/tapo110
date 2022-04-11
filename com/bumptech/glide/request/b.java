package com.bumptech.glide.request;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;

public final class b
  implements RequestCoordinator, d
{
  private final Object a;
  @Nullable
  private final RequestCoordinator b;
  private volatile d c;
  private volatile d d;
  @GuardedBy("requestLock")
  private RequestCoordinator.RequestState e;
  @GuardedBy("requestLock")
  private RequestCoordinator.RequestState f;
  
  public b(Object paramObject, @Nullable RequestCoordinator paramRequestCoordinator)
  {
    RequestCoordinator.RequestState localRequestState = RequestCoordinator.RequestState.CLEARED;
    this.e = localRequestState;
    this.f = localRequestState;
    this.a = paramObject;
    this.b = paramRequestCoordinator;
  }
  
  @GuardedBy("requestLock")
  private boolean i(d paramd)
  {
    boolean bool;
    if ((!paramd.equals(this.c)) && ((this.e != RequestCoordinator.RequestState.FAILED) || (!paramd.equals(this.d)))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  @GuardedBy("requestLock")
  private boolean j()
  {
    RequestCoordinator localRequestCoordinator = this.b;
    boolean bool;
    if ((localRequestCoordinator != null) && (!localRequestCoordinator.h(this))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  @GuardedBy("requestLock")
  private boolean k()
  {
    RequestCoordinator localRequestCoordinator = this.b;
    boolean bool;
    if ((localRequestCoordinator != null) && (!localRequestCoordinator.b(this))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  @GuardedBy("requestLock")
  private boolean l()
  {
    RequestCoordinator localRequestCoordinator = this.b;
    boolean bool;
    if ((localRequestCoordinator != null) && (!localRequestCoordinator.c(this))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public boolean a()
  {
    synchronized (this.a)
    {
      boolean bool;
      if ((!this.c.a()) && (!this.d.a())) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
  }
  
  public boolean b(d paramd)
  {
    synchronized (this.a)
    {
      boolean bool;
      if ((k()) && (i(paramd))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public void begin()
  {
    synchronized (this.a)
    {
      RequestCoordinator.RequestState localRequestState1 = this.e;
      RequestCoordinator.RequestState localRequestState2 = RequestCoordinator.RequestState.RUNNING;
      if (localRequestState1 != localRequestState2)
      {
        this.e = localRequestState2;
        this.c.begin();
      }
      return;
    }
  }
  
  public boolean c(d paramd)
  {
    synchronized (this.a)
    {
      boolean bool;
      if ((l()) && (i(paramd))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public void clear()
  {
    synchronized (this.a)
    {
      RequestCoordinator.RequestState localRequestState = RequestCoordinator.RequestState.CLEARED;
      this.e = localRequestState;
      this.c.clear();
      if (this.f != localRequestState)
      {
        this.f = localRequestState;
        this.d.clear();
      }
      return;
    }
  }
  
  public void d(d paramd)
  {
    synchronized (this.a)
    {
      if (!paramd.equals(this.d))
      {
        this.e = RequestCoordinator.RequestState.FAILED;
        RequestCoordinator.RequestState localRequestState = this.f;
        paramd = RequestCoordinator.RequestState.RUNNING;
        if (localRequestState != paramd)
        {
          this.f = paramd;
          this.d.begin();
        }
        return;
      }
      this.f = RequestCoordinator.RequestState.FAILED;
      paramd = this.b;
      if (paramd != null) {
        paramd.d(this);
      }
      return;
    }
  }
  
  public boolean e()
  {
    synchronized (this.a)
    {
      RequestCoordinator.RequestState localRequestState1 = this.e;
      RequestCoordinator.RequestState localRequestState2 = RequestCoordinator.RequestState.CLEARED;
      boolean bool;
      if ((localRequestState1 == localRequestState2) && (this.f == localRequestState2)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public void f(d paramd)
  {
    synchronized (this.a)
    {
      if (paramd.equals(this.c)) {
        this.e = RequestCoordinator.RequestState.SUCCESS;
      } else if (paramd.equals(this.d)) {
        this.f = RequestCoordinator.RequestState.SUCCESS;
      }
      paramd = this.b;
      if (paramd != null) {
        paramd.f(this);
      }
      return;
    }
  }
  
  public boolean g(d paramd)
  {
    boolean bool1 = paramd instanceof b;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramd = (b)paramd;
      bool3 = bool2;
      if (this.c.g(paramd.c))
      {
        bool3 = bool2;
        if (this.d.g(paramd.d)) {
          bool3 = true;
        }
      }
    }
    return bool3;
  }
  
  public RequestCoordinator getRoot()
  {
    synchronized (this.a)
    {
      Object localObject2 = this.b;
      if (localObject2 != null) {
        localObject2 = ((RequestCoordinator)localObject2).getRoot();
      } else {
        localObject2 = this;
      }
      return (RequestCoordinator)localObject2;
    }
  }
  
  public boolean h(d paramd)
  {
    synchronized (this.a)
    {
      boolean bool;
      if ((j()) && (i(paramd))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public boolean isComplete()
  {
    synchronized (this.a)
    {
      RequestCoordinator.RequestState localRequestState1 = this.e;
      RequestCoordinator.RequestState localRequestState2 = RequestCoordinator.RequestState.SUCCESS;
      boolean bool;
      if ((localRequestState1 != localRequestState2) && (this.f != localRequestState2)) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
  }
  
  public boolean isRunning()
  {
    synchronized (this.a)
    {
      RequestCoordinator.RequestState localRequestState1 = this.e;
      RequestCoordinator.RequestState localRequestState2 = RequestCoordinator.RequestState.RUNNING;
      boolean bool;
      if ((localRequestState1 != localRequestState2) && (this.f != localRequestState2)) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
  }
  
  public void m(d paramd1, d paramd2)
  {
    this.c = paramd1;
    this.d = paramd2;
  }
  
  public void pause()
  {
    synchronized (this.a)
    {
      RequestCoordinator.RequestState localRequestState1 = this.e;
      RequestCoordinator.RequestState localRequestState2 = RequestCoordinator.RequestState.RUNNING;
      if (localRequestState1 == localRequestState2)
      {
        this.e = RequestCoordinator.RequestState.PAUSED;
        this.c.pause();
      }
      if (this.f == localRequestState2)
      {
        this.f = RequestCoordinator.RequestState.PAUSED;
        this.d.pause();
      }
      return;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\request\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */