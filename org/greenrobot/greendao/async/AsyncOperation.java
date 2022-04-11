package org.greenrobot.greendao.async;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.database.Database;

public class AsyncOperation
{
  public static final int FLAG_MERGE_TX = 1;
  public static final int FLAG_STOP_QUEUE_ON_EXCEPTION = 2;
  public static final int FLAG_TRACK_CREATOR_STACKTRACE = 4;
  private volatile boolean completed;
  final Exception creatorStacktrace;
  final AbstractDao<Object, Object> dao;
  private final Database database;
  final int flags;
  volatile int mergedOperationsCount;
  final Object parameter;
  volatile Object result;
  int sequenceNumber;
  volatile Throwable throwable;
  volatile long timeCompleted;
  volatile long timeStarted;
  final OperationType type;
  
  AsyncOperation(OperationType paramOperationType, AbstractDao<?, ?> paramAbstractDao, Database paramDatabase, Object paramObject, int paramInt)
  {
    this.type = paramOperationType;
    this.flags = paramInt;
    this.dao = paramAbstractDao;
    this.database = paramDatabase;
    this.parameter = paramObject;
    if ((paramInt & 0x4) != 0) {
      paramOperationType = new Exception("AsyncOperation was created here");
    } else {
      paramOperationType = null;
    }
    this.creatorStacktrace = paramOperationType;
  }
  
  public Exception getCreatorStacktrace()
  {
    return this.creatorStacktrace;
  }
  
  Database getDatabase()
  {
    Database localDatabase = this.database;
    if (localDatabase == null) {
      localDatabase = this.dao.getDatabase();
    }
    return localDatabase;
  }
  
  public long getDuration()
  {
    if (this.timeCompleted != 0L) {
      return this.timeCompleted - this.timeStarted;
    }
    throw new DaoException("This operation did not yet complete");
  }
  
  public int getMergedOperationsCount()
  {
    return this.mergedOperationsCount;
  }
  
  public Object getParameter()
  {
    return this.parameter;
  }
  
  public Object getResult()
  {
    try
    {
      if (!this.completed) {
        waitForCompletion();
      }
      if (this.throwable == null)
      {
        localObject1 = this.result;
        return localObject1;
      }
      Object localObject1 = new org/greenrobot/greendao/async/AsyncDaoException;
      ((AsyncDaoException)localObject1).<init>(this, this.throwable);
      throw ((Throwable)localObject1);
    }
    finally {}
  }
  
  public int getSequenceNumber()
  {
    return this.sequenceNumber;
  }
  
  public Throwable getThrowable()
  {
    return this.throwable;
  }
  
  public long getTimeCompleted()
  {
    return this.timeCompleted;
  }
  
  public long getTimeStarted()
  {
    return this.timeStarted;
  }
  
  public OperationType getType()
  {
    return this.type;
  }
  
  public boolean isCompleted()
  {
    return this.completed;
  }
  
  public boolean isCompletedSucessfully()
  {
    boolean bool;
    if ((this.completed) && (this.throwable == null)) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isFailed()
  {
    boolean bool;
    if (this.throwable != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isMergeTx()
  {
    int i = this.flags;
    boolean bool = true;
    if ((i & 0x1) == 0) {
      bool = false;
    }
    return bool;
  }
  
  boolean isMergeableWith(AsyncOperation paramAsyncOperation)
  {
    boolean bool;
    if ((paramAsyncOperation != null) && (isMergeTx()) && (paramAsyncOperation.isMergeTx()) && (getDatabase() == paramAsyncOperation.getDatabase())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  void reset()
  {
    this.timeStarted = 0L;
    this.timeCompleted = 0L;
    this.completed = false;
    this.throwable = null;
    this.result = null;
    this.mergedOperationsCount = 0;
  }
  
  void setCompleted()
  {
    try
    {
      this.completed = true;
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public void setThrowable(Throwable paramThrowable)
  {
    this.throwable = paramThrowable;
  }
  
  public Object waitForCompletion()
  {
    try
    {
      for (;;)
      {
        boolean bool = this.completed;
        if (!bool) {
          try
          {
            wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            localObject1 = new org/greenrobot/greendao/DaoException;
            ((DaoException)localObject1).<init>("Interrupted while waiting for operation to complete", localInterruptedException);
            throw ((Throwable)localObject1);
          }
        }
      }
      Object localObject1 = this.result;
      return localObject1;
    }
    finally {}
  }
  
  public boolean waitForCompletion(int paramInt)
  {
    try
    {
      boolean bool = this.completed;
      if (!bool)
      {
        long l = paramInt;
        try
        {
          wait(l);
        }
        catch (InterruptedException localInterruptedException)
        {
          DaoException localDaoException = new org/greenrobot/greendao/DaoException;
          localDaoException.<init>("Interrupted while waiting for operation to complete", localInterruptedException);
          throw localDaoException;
        }
      }
      bool = this.completed;
      return bool;
    }
    finally {}
  }
  
  public static enum OperationType
  {
    static
    {
      OperationType localOperationType1 = new OperationType("Insert", 0);
      Insert = localOperationType1;
      OperationType localOperationType2 = new OperationType("InsertInTxIterable", 1);
      InsertInTxIterable = localOperationType2;
      OperationType localOperationType3 = new OperationType("InsertInTxArray", 2);
      InsertInTxArray = localOperationType3;
      OperationType localOperationType4 = new OperationType("InsertOrReplace", 3);
      InsertOrReplace = localOperationType4;
      OperationType localOperationType5 = new OperationType("InsertOrReplaceInTxIterable", 4);
      InsertOrReplaceInTxIterable = localOperationType5;
      OperationType localOperationType6 = new OperationType("InsertOrReplaceInTxArray", 5);
      InsertOrReplaceInTxArray = localOperationType6;
      OperationType localOperationType7 = new OperationType("Update", 6);
      Update = localOperationType7;
      OperationType localOperationType8 = new OperationType("UpdateInTxIterable", 7);
      UpdateInTxIterable = localOperationType8;
      OperationType localOperationType9 = new OperationType("UpdateInTxArray", 8);
      UpdateInTxArray = localOperationType9;
      OperationType localOperationType10 = new OperationType("Delete", 9);
      Delete = localOperationType10;
      OperationType localOperationType11 = new OperationType("DeleteInTxIterable", 10);
      DeleteInTxIterable = localOperationType11;
      OperationType localOperationType12 = new OperationType("DeleteInTxArray", 11);
      DeleteInTxArray = localOperationType12;
      OperationType localOperationType13 = new OperationType("DeleteByKey", 12);
      DeleteByKey = localOperationType13;
      OperationType localOperationType14 = new OperationType("DeleteAll", 13);
      DeleteAll = localOperationType14;
      OperationType localOperationType15 = new OperationType("TransactionRunnable", 14);
      TransactionRunnable = localOperationType15;
      OperationType localOperationType16 = new OperationType("TransactionCallable", 15);
      TransactionCallable = localOperationType16;
      OperationType localOperationType17 = new OperationType("QueryList", 16);
      QueryList = localOperationType17;
      OperationType localOperationType18 = new OperationType("QueryUnique", 17);
      QueryUnique = localOperationType18;
      OperationType localOperationType19 = new OperationType("Load", 18);
      Load = localOperationType19;
      OperationType localOperationType20 = new OperationType("LoadAll", 19);
      LoadAll = localOperationType20;
      OperationType localOperationType21 = new OperationType("Count", 20);
      Count = localOperationType21;
      OperationType localOperationType22 = new OperationType("Refresh", 21);
      Refresh = localOperationType22;
      $VALUES = new OperationType[] { localOperationType1, localOperationType2, localOperationType3, localOperationType4, localOperationType5, localOperationType6, localOperationType7, localOperationType8, localOperationType9, localOperationType10, localOperationType11, localOperationType12, localOperationType13, localOperationType14, localOperationType15, localOperationType16, localOperationType17, localOperationType18, localOperationType19, localOperationType20, localOperationType21, localOperationType22 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\async\AsyncOperation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */