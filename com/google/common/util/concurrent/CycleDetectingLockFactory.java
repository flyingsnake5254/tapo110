package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.n1;
import com.google.common.collect.o1;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Level;
import java.util.logging.Logger;

@CanIgnoreReturnValue
public class CycleDetectingLockFactory
{
  private static final ConcurrentMap<Class<? extends Enum>, Map<? extends Enum, c>> a = new o1().h().f();
  private static final Logger b = Logger.getLogger(CycleDetectingLockFactory.class.getName());
  private static final ThreadLocal<ArrayList<c>> c = new a();
  
  public static abstract enum Policies
  {
    static
    {
      a locala = new a("THROW", 0);
      THROW = locala;
      b localb = new b("WARN", 1);
      WARN = localb;
      c localc = new c("DISABLED", 2);
      DISABLED = localc;
      $VALUES = new Policies[] { locala, localb, localc };
    }
    
    static enum a
    {
      a()
      {
        super(paramInt, null);
      }
      
      public void handlePotentialDeadlock(CycleDetectingLockFactory.PotentialDeadlockException paramPotentialDeadlockException)
      {
        throw paramPotentialDeadlockException;
      }
    }
    
    static enum b
    {
      b()
      {
        super(paramInt, null);
      }
      
      public void handlePotentialDeadlock(CycleDetectingLockFactory.PotentialDeadlockException paramPotentialDeadlockException)
      {
        CycleDetectingLockFactory.a().log(Level.SEVERE, "Detected potential deadlock", paramPotentialDeadlockException);
      }
    }
    
    static enum c
    {
      c()
      {
        super(paramInt, null);
      }
      
      public void handlePotentialDeadlock(CycleDetectingLockFactory.PotentialDeadlockException paramPotentialDeadlockException) {}
    }
  }
  
  public static final class PotentialDeadlockException
    extends CycleDetectingLockFactory.b
  {
    private final CycleDetectingLockFactory.b conflictingStackTrace;
    
    private PotentialDeadlockException(CycleDetectingLockFactory.c paramc1, CycleDetectingLockFactory.c paramc2, CycleDetectingLockFactory.b paramb)
    {
      super(paramc2);
      this.conflictingStackTrace = paramb;
      initCause(paramb);
    }
    
    public CycleDetectingLockFactory.b getConflictingStackTrace()
    {
      return this.conflictingStackTrace;
    }
    
    public String getMessage()
    {
      StringBuilder localStringBuilder = new StringBuilder(super.getMessage());
      for (Object localObject = this.conflictingStackTrace; localObject != null; localObject = ((Throwable)localObject).getCause())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append(((Throwable)localObject).getMessage());
      }
      return localStringBuilder.toString();
    }
  }
  
  static final class a
    extends ThreadLocal<ArrayList<CycleDetectingLockFactory.c>>
  {
    protected ArrayList<CycleDetectingLockFactory.c> a()
    {
      return n1.k(3);
    }
  }
  
  private static class b
    extends IllegalStateException
  {
    static final StackTraceElement[] EMPTY_STACK_TRACE = new StackTraceElement[0];
    static final ImmutableSet<String> EXCLUDED_CLASS_NAMES = ImmutableSet.of(CycleDetectingLockFactory.class.getName(), b.class.getName(), CycleDetectingLockFactory.c.class.getName());
    
    b(CycleDetectingLockFactory.c paramc1, CycleDetectingLockFactory.c paramc2)
    {
      super();
      paramc1 = getStackTrace();
      int i = paramc1.length;
      for (int j = 0; j < i; j++)
      {
        if (CycleDetectingLockFactory.d.class.getName().equals(paramc1[j].getClassName()))
        {
          setStackTrace(EMPTY_STACK_TRACE);
          break;
        }
        if (!EXCLUDED_CLASS_NAMES.contains(paramc1[j].getClassName()))
        {
          setStackTrace((StackTraceElement[])Arrays.copyOfRange(paramc1, j, i));
          break;
        }
      }
    }
  }
  
  private static class c
  {
    final String a;
    
    String a()
    {
      return this.a;
    }
  }
  
  public static final class d<E extends Enum<E>>
    extends CycleDetectingLockFactory
  {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\util\concurrent\CycleDetectingLockFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */