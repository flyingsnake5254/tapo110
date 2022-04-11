package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.h.x.j.y;
import com.google.android.datatransport.runtime.synchronization.a;
import java.util.concurrent.Executor;

public class s
{
  private final Executor a;
  private final y b;
  private final u c;
  private final a d;
  
  s(Executor paramExecutor, y paramy, u paramu, a parama)
  {
    this.a = paramExecutor;
    this.b = paramy;
    this.c = paramu;
    this.d = parama;
  }
  
  public void a()
  {
    this.a.execute(new l(this));
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\datatransport\runtime\scheduling\jobscheduling\s.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */