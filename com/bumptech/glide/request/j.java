package com.bumptech.glide.request;

import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;

public class j
  implements RequestCoordinator, d
{
  @Nullable
  private final RequestCoordinator a;
  private final Object b;
  private volatile d c;
  private volatile d d;
  @GuardedBy("requestLock")
  private RequestCoordinator.RequestState e;
  @GuardedBy("requestLock")
  private RequestCoordinator.RequestState f;
  @GuardedBy("requestLock")
  private boolean g;
  
  public j(Object paramObject, @Nullable RequestCoordinator paramRequestCoordinator)
  {
    RequestCoordinator.RequestState localRequestState = RequestCoordinator.RequestState.CLEARED;
    this.e = localRequestState;
    this.f = localRequestState;
    this.b = paramObject;
    this.a = paramRequestCoordinator;
  }
  
  @GuardedBy("requestLock")
  private boolean i()
  {
    RequestCoordinator localRequestCoordinator = this.a;
    boolean bool;
    if ((localRequestCoordinator != null) && (!localRequestCoordinator.h(this))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  @GuardedBy("requestLock")
  private boolean j()
  {
    RequestCoordinator localRequestCoordinator = this.a;
    boolean bool;
    if ((localRequestCoordinator != null) && (!localRequestCoordinator.b(this))) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  @GuardedBy("requestLock")
  private boolean k()
  {
    RequestCoordinator localRequestCoordinator = this.a;
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
    synchronized (this.b)
    {
      boolean bool;
      if ((!this.d.a()) && (!this.c.a())) {
        bool = false;
      } else {
        bool = true;
      }
      return bool;
    }
  }
  
  public boolean b(d paramd)
  {
    synchronized (this.b)
    {
      boolean bool;
      if ((j()) && (paramd.equals(this.c)) && (!a())) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public void begin()
  {
    synchronized (this.b)
    {
      this.g = true;
      try
      {
        RequestCoordinator.RequestState localRequestState1;
        RequestCoordinator.RequestState localRequestState2;
        if (this.e != RequestCoordinator.RequestState.SUCCESS)
        {
          localRequestState1 = this.f;
          localRequestState2 = RequestCoordinator.RequestState.RUNNING;
          if (localRequestState1 != localRequestState2)
          {
            this.f = localRequestState2;
            this.d.begin();
          }
        }
        if (this.g)
        {
          localRequestState1 = this.e;
          localRequestState2 = RequestCoordinator.RequestState.RUNNING;
          if (localRequestState1 != localRequestState2)
          {
            this.e = localRequestState2;
            this.c.begin();
          }
        }
        this.g = false;
        return;
      }
      finally
      {
        this.g = false;
      }
    }
  }
  
  public boolean c(d paramd)
  {
    synchronized (this.b)
    {
      boolean bool;
      if ((k()) && ((paramd.equals(this.c)) || (this.e != RequestCoordinator.RequestState.SUCCESS))) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public void clear()
  {
    synchronized (this.b)
    {
      this.g = false;
      RequestCoordinator.RequestState localRequestState = RequestCoordinator.RequestState.CLEARED;
      this.e = localRequestState;
      this.f = localRequestState;
      this.d.clear();
      this.c.clear();
      return;
    }
  }
  
  public void d(d paramd)
  {
    synchronized (this.b)
    {
      if (!paramd.equals(this.c))
      {
        this.f = RequestCoordinator.RequestState.FAILED;
        return;
      }
      this.e = RequestCoordinator.RequestState.FAILED;
      paramd = this.a;
      if (paramd != null) {
        paramd.d(this);
      }
      return;
    }
  }
  
  public boolean e()
  {
    synchronized (this.b)
    {
      boolean bool;
      if (this.e == RequestCoordinator.RequestState.CLEARED) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public void f(d paramd)
  {
    synchronized (this.b)
    {
      if (paramd.equals(this.d))
      {
        this.f = RequestCoordinator.RequestState.SUCCESS;
        return;
      }
      this.e = RequestCoordinator.RequestState.SUCCESS;
      paramd = this.a;
      if (paramd != null) {
        paramd.f(this);
      }
      if (!this.f.isComplete()) {
        this.d.clear();
      }
      return;
    }
  }
  
  public boolean g(d paramd)
  {
    boolean bool1 = paramd instanceof j;
    boolean bool2 = false;
    boolean bool3 = bool2;
    if (bool1)
    {
      paramd = (j)paramd;
      if (this.c == null)
      {
        bool3 = bool2;
        if (paramd.c != null) {
          break label100;
        }
      }
      else
      {
        bool3 = bool2;
        if (!this.c.g(paramd.c)) {
          break label100;
        }
      }
      if (this.d == null)
      {
        bool3 = bool2;
        if (paramd.d != null) {
          break label100;
        }
      }
      else
      {
        bool3 = bool2;
        if (!this.d.g(paramd.d)) {
          break label100;
        }
      }
      bool3 = true;
    }
    label100:
    return bool3;
  }
  
  public RequestCoordinator getRoot()
  {
    synchronized (this.b)
    {
      Object localObject2 = this.a;
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
    synchronized (this.b)
    {
      boolean bool;
      if ((i()) && (paramd.equals(this.c)) && (this.e != RequestCoordinator.RequestState.PAUSED)) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public boolean isComplete()
  {
    synchronized (this.b)
    {
      boolean bool;
      if (this.e == RequestCoordinator.RequestState.SUCCESS) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public boolean isRunning()
  {
    synchronized (this.b)
    {
      boolean bool;
      if (this.e == RequestCoordinator.RequestState.RUNNING) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
  }
  
  public void l(d paramd1, d paramd2)
  {
    this.c = paramd1;
    this.d = paramd2;
  }
  
  public void pause()
  {
    synchronized (this.b)
    {
      if (!this.f.isComplete())
      {
        this.f = RequestCoordinator.RequestState.PAUSED;
        this.d.pause();
      }
      if (!this.e.isComplete())
      {
        this.e = RequestCoordinator.RequestState.PAUSED;
        this.c.pause();
      }
      return;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\request\j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */