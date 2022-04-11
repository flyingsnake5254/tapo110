package com.bumptech.glide.request;

public abstract interface RequestCoordinator
{
  public abstract boolean a();
  
  public abstract boolean b(d paramd);
  
  public abstract boolean c(d paramd);
  
  public abstract void d(d paramd);
  
  public abstract void f(d paramd);
  
  public abstract RequestCoordinator getRoot();
  
  public abstract boolean h(d paramd);
  
  public static enum RequestState
  {
    private final boolean isComplete;
    
    static
    {
      RequestState localRequestState1 = new RequestState("RUNNING", 0, false);
      RUNNING = localRequestState1;
      RequestState localRequestState2 = new RequestState("PAUSED", 1, false);
      PAUSED = localRequestState2;
      RequestState localRequestState3 = new RequestState("CLEARED", 2, false);
      CLEARED = localRequestState3;
      RequestState localRequestState4 = new RequestState("SUCCESS", 3, true);
      SUCCESS = localRequestState4;
      RequestState localRequestState5 = new RequestState("FAILED", 4, true);
      FAILED = localRequestState5;
      $VALUES = new RequestState[] { localRequestState1, localRequestState2, localRequestState3, localRequestState4, localRequestState5 };
    }
    
    private RequestState(boolean paramBoolean)
    {
      this.isComplete = paramBoolean;
    }
    
    boolean isComplete()
    {
      return this.isComplete;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\bumptech\glide\request\RequestCoordinator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */