package androidx.room;

import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import io.reactivex.BackpressureStrategy;
import io.reactivex.a0;
import io.reactivex.e0.d;
import io.reactivex.g;
import io.reactivex.h;
import io.reactivex.i;
import io.reactivex.m;
import io.reactivex.o;
import io.reactivex.q;
import io.reactivex.r;
import io.reactivex.s;
import io.reactivex.w;
import io.reactivex.x;
import io.reactivex.y;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public class RxRoom
{
  public static final Object NOTHING = new Object();
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static <T> h<T> createFlowable(RoomDatabase paramRoomDatabase, boolean paramBoolean, String[] paramArrayOfString, Callable<T> paramCallable)
  {
    w localw = io.reactivex.l0.a.b(getExecutor(paramRoomDatabase, paramBoolean));
    paramCallable = m.j(paramCallable);
    createFlowable(paramRoomDatabase, paramArrayOfString).I(localw).L(localw).w(localw).s(new io.reactivex.g0.j()
    {
      public o<T> apply(Object paramAnonymousObject)
        throws Exception
      {
        return this.val$maybe;
      }
    });
  }
  
  public static h<Object> createFlowable(final RoomDatabase paramRoomDatabase, String... paramVarArgs)
  {
    h.f(new io.reactivex.j()
    {
      public void subscribe(final i<Object> paramAnonymousi)
        throws Exception
      {
        final InvalidationTracker.Observer local1 = new InvalidationTracker.Observer(this.val$tableNames)
        {
          public void onInvalidated(@NonNull Set<String> paramAnonymous2Set)
          {
            if (!paramAnonymousi.isCancelled()) {
              paramAnonymousi.onNext(RxRoom.NOTHING);
            }
          }
        };
        if (!paramAnonymousi.isCancelled())
        {
          paramRoomDatabase.getInvalidationTracker().addObserver(local1);
          paramAnonymousi.a(d.c(new io.reactivex.g0.a()
          {
            public void run()
              throws Exception
            {
              RxRoom.1.this.val$database.getInvalidationTracker().removeObserver(local1);
            }
          }));
        }
        if (!paramAnonymousi.isCancelled()) {
          paramAnonymousi.onNext(RxRoom.NOTHING);
        }
      }
    }, BackpressureStrategy.LATEST);
  }
  
  @Deprecated
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static <T> h<T> createFlowable(RoomDatabase paramRoomDatabase, String[] paramArrayOfString, Callable<T> paramCallable)
  {
    return createFlowable(paramRoomDatabase, false, paramArrayOfString, paramCallable);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static <T> q<T> createObservable(RoomDatabase paramRoomDatabase, boolean paramBoolean, String[] paramArrayOfString, Callable<T> paramCallable)
  {
    w localw = io.reactivex.l0.a.b(getExecutor(paramRoomDatabase, paramBoolean));
    paramCallable = m.j(paramCallable);
    createObservable(paramRoomDatabase, paramArrayOfString).L0(localw).b1(localw).l0(localw).U(new io.reactivex.g0.j()
    {
      public o<T> apply(Object paramAnonymousObject)
        throws Exception
      {
        return this.val$maybe;
      }
    });
  }
  
  public static q<Object> createObservable(final RoomDatabase paramRoomDatabase, String... paramVarArgs)
  {
    q.m(new s()
    {
      public void subscribe(final r<Object> paramAnonymousr)
        throws Exception
      {
        final InvalidationTracker.Observer local1 = new InvalidationTracker.Observer(this.val$tableNames)
        {
          public void onInvalidated(@NonNull Set<String> paramAnonymous2Set)
          {
            paramAnonymousr.onNext(RxRoom.NOTHING);
          }
        };
        paramRoomDatabase.getInvalidationTracker().addObserver(local1);
        paramAnonymousr.a(d.c(new io.reactivex.g0.a()
        {
          public void run()
            throws Exception
          {
            RxRoom.3.this.val$database.getInvalidationTracker().removeObserver(local1);
          }
        }));
        paramAnonymousr.onNext(RxRoom.NOTHING);
      }
    });
  }
  
  @Deprecated
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static <T> q<T> createObservable(RoomDatabase paramRoomDatabase, String[] paramArrayOfString, Callable<T> paramCallable)
  {
    return createObservable(paramRoomDatabase, false, paramArrayOfString, paramCallable);
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static <T> x<T> createSingle(Callable<T> paramCallable)
  {
    x.e(new a0()
    {
      public void subscribe(y<T> paramAnonymousy)
        throws Exception
      {
        try
        {
          paramAnonymousy.onSuccess(this.val$callable.call());
        }
        catch (EmptyResultSetException localEmptyResultSetException)
        {
          paramAnonymousy.a(localEmptyResultSetException);
        }
      }
    });
  }
  
  private static Executor getExecutor(RoomDatabase paramRoomDatabase, boolean paramBoolean)
  {
    if (paramBoolean) {
      return paramRoomDatabase.getTransactionExecutor();
    }
    return paramRoomDatabase.getQueryExecutor();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\room\RxRoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */