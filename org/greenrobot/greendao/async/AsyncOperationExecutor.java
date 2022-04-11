package org.greenrobot.greendao.async;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.DaoLog;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.query.Query;

class AsyncOperationExecutor
  implements Runnable, Handler.Callback
{
  private static ExecutorService executorService = ;
  private int countOperationsCompleted;
  private int countOperationsEnqueued;
  private volatile boolean executorRunning;
  private Handler handlerMainThread;
  private int lastSequenceNumber;
  private volatile AsyncOperationListener listener;
  private volatile AsyncOperationListener listenerMainThread;
  private volatile int maxOperationCountToMerge = 50;
  private final BlockingQueue<AsyncOperation> queue = new LinkedBlockingQueue();
  private volatile int waitForMergeMillis = 50;
  
  private void executeOperation(AsyncOperation paramAsyncOperation)
  {
    paramAsyncOperation.timeStarted = System.currentTimeMillis();
    try
    {
      DaoException localDaoException;
      switch (1.$SwitchMap$org$greenrobot$greendao$async$AsyncOperation$OperationType[paramAsyncOperation.type.ordinal()])
      {
      default: 
        localDaoException = new org/greenrobot/greendao/DaoException;
        break;
      case 22: 
        paramAsyncOperation.dao.refresh(paramAsyncOperation.parameter);
        break;
      case 21: 
        paramAsyncOperation.result = Long.valueOf(paramAsyncOperation.dao.count());
        break;
      case 20: 
        paramAsyncOperation.result = paramAsyncOperation.dao.loadAll();
        break;
      case 19: 
        paramAsyncOperation.result = paramAsyncOperation.dao.load(paramAsyncOperation.parameter);
        break;
      case 18: 
        paramAsyncOperation.dao.deleteAll();
        break;
      case 17: 
        paramAsyncOperation.dao.deleteByKey(paramAsyncOperation.parameter);
        break;
      case 16: 
        paramAsyncOperation.result = ((Query)paramAsyncOperation.parameter).forCurrentThread().unique();
        break;
      case 15: 
        paramAsyncOperation.result = ((Query)paramAsyncOperation.parameter).forCurrentThread().list();
        break;
      case 14: 
        executeTransactionCallable(paramAsyncOperation);
        break;
      case 13: 
        executeTransactionRunnable(paramAsyncOperation);
        break;
      case 12: 
        paramAsyncOperation.dao.updateInTx((Object[])paramAsyncOperation.parameter);
        break;
      case 11: 
        paramAsyncOperation.dao.updateInTx((Iterable)paramAsyncOperation.parameter);
        break;
      case 10: 
        paramAsyncOperation.dao.update(paramAsyncOperation.parameter);
        break;
      case 9: 
        paramAsyncOperation.dao.insertOrReplaceInTx((Object[])paramAsyncOperation.parameter);
        break;
      case 8: 
        paramAsyncOperation.dao.insertOrReplaceInTx((Iterable)paramAsyncOperation.parameter);
        break;
      case 7: 
        paramAsyncOperation.dao.insertOrReplace(paramAsyncOperation.parameter);
        break;
      case 6: 
        paramAsyncOperation.dao.insertInTx((Object[])paramAsyncOperation.parameter);
        break;
      case 5: 
        paramAsyncOperation.dao.insertInTx((Iterable)paramAsyncOperation.parameter);
        break;
      case 4: 
        paramAsyncOperation.dao.insert(paramAsyncOperation.parameter);
        break;
      case 3: 
        paramAsyncOperation.dao.deleteInTx((Object[])paramAsyncOperation.parameter);
        break;
      case 2: 
        paramAsyncOperation.dao.deleteInTx((Iterable)paramAsyncOperation.parameter);
        break;
      case 1: 
        paramAsyncOperation.dao.delete(paramAsyncOperation.parameter);
        break;
      }
      StringBuilder localStringBuilder = new java/lang/StringBuilder;
      localStringBuilder.<init>();
      localStringBuilder.append("Unsupported operation: ");
      localStringBuilder.append(paramAsyncOperation.type);
      localDaoException.<init>(localStringBuilder.toString());
      throw localDaoException;
    }
    finally
    {
      paramAsyncOperation.throwable = localThrowable;
      paramAsyncOperation.timeCompleted = System.currentTimeMillis();
    }
  }
  
  private void executeOperationAndPostCompleted(AsyncOperation paramAsyncOperation)
  {
    executeOperation(paramAsyncOperation);
    handleOperationCompleted(paramAsyncOperation);
  }
  
  private void executeTransactionCallable(AsyncOperation paramAsyncOperation)
    throws Exception
  {
    Database localDatabase = paramAsyncOperation.getDatabase();
    localDatabase.beginTransaction();
    try
    {
      paramAsyncOperation.result = ((Callable)paramAsyncOperation.parameter).call();
      localDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      localDatabase.endTransaction();
    }
  }
  
  private void executeTransactionRunnable(AsyncOperation paramAsyncOperation)
  {
    Database localDatabase = paramAsyncOperation.getDatabase();
    localDatabase.beginTransaction();
    try
    {
      ((Runnable)paramAsyncOperation.parameter).run();
      localDatabase.setTransactionSuccessful();
      return;
    }
    finally
    {
      localDatabase.endTransaction();
    }
  }
  
  private void handleOperationCompleted(AsyncOperation paramAsyncOperation)
  {
    paramAsyncOperation.setCompleted();
    AsyncOperationListener localAsyncOperationListener = this.listener;
    if (localAsyncOperationListener != null) {
      localAsyncOperationListener.onAsyncOperationCompleted(paramAsyncOperation);
    }
    if (this.listenerMainThread != null)
    {
      if (this.handlerMainThread == null) {
        this.handlerMainThread = new Handler(Looper.getMainLooper(), this);
      }
      paramAsyncOperation = this.handlerMainThread.obtainMessage(1, paramAsyncOperation);
      this.handlerMainThread.sendMessage(paramAsyncOperation);
    }
    try
    {
      int i = this.countOperationsCompleted + 1;
      this.countOperationsCompleted = i;
      if (i == this.countOperationsEnqueued) {
        notifyAll();
      }
      return;
    }
    finally {}
  }
  
  private void mergeTxAndExecute(AsyncOperation paramAsyncOperation1, AsyncOperation paramAsyncOperation2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramAsyncOperation1);
    localArrayList.add(paramAsyncOperation2);
    paramAsyncOperation1 = paramAsyncOperation1.getDatabase();
    paramAsyncOperation1.beginTransaction();
    boolean bool1 = false;
    int i = 0;
    try
    {
      for (;;)
      {
        int j = localArrayList.size();
        bool2 = true;
        if (i >= j) {
          break;
        }
        AsyncOperation localAsyncOperation = (AsyncOperation)localArrayList.get(i);
        executeOperation(localAsyncOperation);
        if (localAsyncOperation.isFailed()) {
          break;
        }
        if (i == localArrayList.size() - 1)
        {
          paramAsyncOperation2 = (AsyncOperation)this.queue.peek();
          if ((i < this.maxOperationCountToMerge) && (localAsyncOperation.isMergeableWith(paramAsyncOperation2)))
          {
            localAsyncOperation = (AsyncOperation)this.queue.remove();
            if (localAsyncOperation == paramAsyncOperation2)
            {
              localArrayList.add(localAsyncOperation);
            }
            else
            {
              paramAsyncOperation2 = new org/greenrobot/greendao/DaoException;
              paramAsyncOperation2.<init>("Internal error: peeked op did not match removed op");
              throw paramAsyncOperation2;
            }
          }
          else
          {
            paramAsyncOperation1.setTransactionSuccessful();
            break label184;
          }
        }
        i++;
      }
      boolean bool2 = false;
      try
      {
        label184:
        paramAsyncOperation1.endTransaction();
      }
      catch (RuntimeException paramAsyncOperation2)
      {
        paramAsyncOperation1 = new StringBuilder();
        paramAsyncOperation1.append("Async transaction could not be ended, success so far was: ");
        paramAsyncOperation1.append(bool2);
        DaoLog.i(paramAsyncOperation1.toString(), paramAsyncOperation2);
        bool2 = bool1;
      }
      if (bool2)
      {
        i = localArrayList.size();
        paramAsyncOperation2 = localArrayList.iterator();
        while (paramAsyncOperation2.hasNext())
        {
          paramAsyncOperation1 = (AsyncOperation)paramAsyncOperation2.next();
          paramAsyncOperation1.mergedOperationsCount = i;
          handleOperationCompleted(paramAsyncOperation1);
        }
      }
      DaoLog.i("Reverted merged transaction because one of the operations failed. Executing operations one by one instead...");
      paramAsyncOperation2 = localArrayList.iterator();
      while (paramAsyncOperation2.hasNext())
      {
        paramAsyncOperation1 = (AsyncOperation)paramAsyncOperation2.next();
        paramAsyncOperation1.reset();
        executeOperationAndPostCompleted(paramAsyncOperation1);
      }
      return;
    }
    finally
    {
      try
      {
        paramAsyncOperation1.endTransaction();
      }
      catch (RuntimeException localRuntimeException)
      {
        paramAsyncOperation1 = new StringBuilder();
        paramAsyncOperation1.append("Async transaction could not be ended, success so far was: ");
        paramAsyncOperation1.append(false);
        DaoLog.i(paramAsyncOperation1.toString(), localRuntimeException);
      }
    }
  }
  
  public void enqueue(AsyncOperation paramAsyncOperation)
  {
    try
    {
      int i = this.lastSequenceNumber + 1;
      this.lastSequenceNumber = i;
      paramAsyncOperation.sequenceNumber = i;
      this.queue.add(paramAsyncOperation);
      this.countOperationsEnqueued += 1;
      if (!this.executorRunning)
      {
        this.executorRunning = true;
        executorService.execute(this);
      }
      return;
    }
    finally {}
  }
  
  public AsyncOperationListener getListener()
  {
    return this.listener;
  }
  
  public AsyncOperationListener getListenerMainThread()
  {
    return this.listenerMainThread;
  }
  
  public int getMaxOperationCountToMerge()
  {
    return this.maxOperationCountToMerge;
  }
  
  public int getWaitForMergeMillis()
  {
    return this.waitForMergeMillis;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    AsyncOperationListener localAsyncOperationListener = this.listenerMainThread;
    if (localAsyncOperationListener != null) {
      localAsyncOperationListener.onAsyncOperationCompleted((AsyncOperation)paramMessage.obj);
    }
    return false;
  }
  
  public boolean isCompleted()
  {
    try
    {
      int i = this.countOperationsEnqueued;
      int j = this.countOperationsCompleted;
      boolean bool;
      if (i == j) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 47	org/greenrobot/greendao/async/AsyncOperationExecutor:queue	Ljava/util/concurrent/BlockingQueue;
    //   4: lconst_1
    //   5: getstatic 384	java/util/concurrent/TimeUnit:SECONDS	Ljava/util/concurrent/TimeUnit;
    //   8: invokeinterface 388 4 0
    //   13: checkcast 61	org/greenrobot/greendao/async/AsyncOperation
    //   16: astore_1
    //   17: aload_1
    //   18: astore_2
    //   19: aload_1
    //   20: ifnonnull +45 -> 65
    //   23: aload_0
    //   24: monitorenter
    //   25: aload_0
    //   26: getfield 47	org/greenrobot/greendao/async/AsyncOperationExecutor:queue	Ljava/util/concurrent/BlockingQueue;
    //   29: invokeinterface 390 1 0
    //   34: checkcast 61	org/greenrobot/greendao/async/AsyncOperation
    //   37: astore_2
    //   38: aload_2
    //   39: ifnonnull +16 -> 55
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield 358	org/greenrobot/greendao/async/AsyncOperationExecutor:executorRunning	Z
    //   47: aload_0
    //   48: monitorexit
    //   49: aload_0
    //   50: iconst_0
    //   51: putfield 358	org/greenrobot/greendao/async/AsyncOperationExecutor:executorRunning	Z
    //   54: return
    //   55: aload_0
    //   56: monitorexit
    //   57: goto +8 -> 65
    //   60: astore_2
    //   61: aload_0
    //   62: monitorexit
    //   63: aload_2
    //   64: athrow
    //   65: aload_2
    //   66: invokevirtual 393	org/greenrobot/greendao/async/AsyncOperation:isMergeTx	()Z
    //   69: ifeq +58 -> 127
    //   72: aload_0
    //   73: getfield 47	org/greenrobot/greendao/async/AsyncOperationExecutor:queue	Ljava/util/concurrent/BlockingQueue;
    //   76: aload_0
    //   77: getfield 51	org/greenrobot/greendao/async/AsyncOperationExecutor:waitForMergeMillis	I
    //   80: i2l
    //   81: getstatic 396	java/util/concurrent/TimeUnit:MILLISECONDS	Ljava/util/concurrent/TimeUnit;
    //   84: invokeinterface 388 4 0
    //   89: checkcast 61	org/greenrobot/greendao/async/AsyncOperation
    //   92: astore_1
    //   93: aload_1
    //   94: ifnull +33 -> 127
    //   97: aload_2
    //   98: aload_1
    //   99: invokevirtual 308	org/greenrobot/greendao/async/AsyncOperation:isMergeableWith	(Lorg/greenrobot/greendao/async/AsyncOperation;)Z
    //   102: ifeq +12 -> 114
    //   105: aload_0
    //   106: aload_2
    //   107: aload_1
    //   108: invokespecial 398	org/greenrobot/greendao/async/AsyncOperationExecutor:mergeTxAndExecute	(Lorg/greenrobot/greendao/async/AsyncOperation;Lorg/greenrobot/greendao/async/AsyncOperation;)V
    //   111: goto -111 -> 0
    //   114: aload_0
    //   115: aload_2
    //   116: invokespecial 349	org/greenrobot/greendao/async/AsyncOperationExecutor:executeOperationAndPostCompleted	(Lorg/greenrobot/greendao/async/AsyncOperation;)V
    //   119: aload_0
    //   120: aload_1
    //   121: invokespecial 349	org/greenrobot/greendao/async/AsyncOperationExecutor:executeOperationAndPostCompleted	(Lorg/greenrobot/greendao/async/AsyncOperation;)V
    //   124: goto -124 -> 0
    //   127: aload_0
    //   128: aload_2
    //   129: invokespecial 349	org/greenrobot/greendao/async/AsyncOperationExecutor:executeOperationAndPostCompleted	(Lorg/greenrobot/greendao/async/AsyncOperation;)V
    //   132: goto -132 -> 0
    //   135: astore_2
    //   136: goto +46 -> 182
    //   139: astore_2
    //   140: new 181	java/lang/StringBuilder
    //   143: astore_1
    //   144: aload_1
    //   145: invokespecial 182	java/lang/StringBuilder:<init>	()V
    //   148: aload_1
    //   149: invokestatic 404	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   152: invokevirtual 407	java/lang/Thread:getName	()Ljava/lang/String;
    //   155: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload_1
    //   160: ldc_w 409
    //   163: invokevirtual 188	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: aload_1
    //   168: invokevirtual 195	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   171: aload_2
    //   172: invokestatic 412	org/greenrobot/greendao/DaoLog:w	(Ljava/lang/String;Ljava/lang/Throwable;)I
    //   175: pop
    //   176: aload_0
    //   177: iconst_0
    //   178: putfield 358	org/greenrobot/greendao/async/AsyncOperationExecutor:executorRunning	Z
    //   181: return
    //   182: aload_0
    //   183: iconst_0
    //   184: putfield 358	org/greenrobot/greendao/async/AsyncOperationExecutor:executorRunning	Z
    //   187: aload_2
    //   188: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	189	0	this	AsyncOperationExecutor
    //   16	152	1	localObject1	Object
    //   18	21	2	localObject2	Object
    //   60	69	2	localAsyncOperation	AsyncOperation
    //   135	1	2	localObject3	Object
    //   139	49	2	localInterruptedException	InterruptedException
    // Exception table:
    //   from	to	target	type
    //   25	38	60	finally
    //   42	49	60	finally
    //   55	57	60	finally
    //   61	63	60	finally
    //   0	17	135	finally
    //   23	25	135	finally
    //   63	65	135	finally
    //   65	93	135	finally
    //   97	111	135	finally
    //   114	124	135	finally
    //   127	132	135	finally
    //   140	176	135	finally
    //   0	17	139	java/lang/InterruptedException
    //   23	25	139	java/lang/InterruptedException
    //   63	65	139	java/lang/InterruptedException
    //   65	93	139	java/lang/InterruptedException
    //   97	111	139	java/lang/InterruptedException
    //   114	124	139	java/lang/InterruptedException
    //   127	132	139	java/lang/InterruptedException
  }
  
  public void setListener(AsyncOperationListener paramAsyncOperationListener)
  {
    this.listener = paramAsyncOperationListener;
  }
  
  public void setListenerMainThread(AsyncOperationListener paramAsyncOperationListener)
  {
    this.listenerMainThread = paramAsyncOperationListener;
  }
  
  public void setMaxOperationCountToMerge(int paramInt)
  {
    this.maxOperationCountToMerge = paramInt;
  }
  
  public void setWaitForMergeMillis(int paramInt)
  {
    this.waitForMergeMillis = paramInt;
  }
  
  public void waitForCompletion()
  {
    try
    {
      for (;;)
      {
        boolean bool = isCompleted();
        if (!bool) {
          try
          {
            wait();
          }
          catch (InterruptedException localInterruptedException)
          {
            DaoException localDaoException = new org/greenrobot/greendao/DaoException;
            localDaoException.<init>("Interrupted while waiting for all operations to complete", localInterruptedException);
            throw localDaoException;
          }
        }
      }
      return;
    }
    finally {}
  }
  
  public boolean waitForCompletion(int paramInt)
  {
    try
    {
      boolean bool = isCompleted();
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
          localDaoException.<init>("Interrupted while waiting for all operations to complete", localInterruptedException);
          throw localDaoException;
        }
      }
      bool = isCompleted();
      return bool;
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\async\AsyncOperationExecutor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */