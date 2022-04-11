package androidx.recyclerview.widget;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

class MessageThreadUtil<T>
  implements ThreadUtil<T>
{
  public ThreadUtil.BackgroundCallback<T> getBackgroundProxy(final ThreadUtil.BackgroundCallback<T> paramBackgroundCallback)
  {
    new ThreadUtil.BackgroundCallback()
    {
      static final int LOAD_TILE = 3;
      static final int RECYCLE_TILE = 4;
      static final int REFRESH = 1;
      static final int UPDATE_RANGE = 2;
      private Runnable mBackgroundRunnable = new Runnable()
      {
        public void run()
        {
          for (;;)
          {
            Object localObject = MessageThreadUtil.2.this.mQueue.next();
            if (localObject == null)
            {
              MessageThreadUtil.2.this.mBackgroundRunning.set(false);
              return;
            }
            int i = ((MessageThreadUtil.SyncQueueItem)localObject).what;
            if (i != 1)
            {
              if (i != 2)
              {
                if (i != 3)
                {
                  if (i != 4)
                  {
                    StringBuilder localStringBuilder = new StringBuilder();
                    localStringBuilder.append("Unsupported message, what=");
                    localStringBuilder.append(((MessageThreadUtil.SyncQueueItem)localObject).what);
                    Log.e("ThreadUtil", localStringBuilder.toString());
                  }
                  else
                  {
                    localObject = (TileList.Tile)((MessageThreadUtil.SyncQueueItem)localObject).data;
                    MessageThreadUtil.2.this.val$callback.recycleTile((TileList.Tile)localObject);
                  }
                }
                else {
                  MessageThreadUtil.2.this.val$callback.loadTile(((MessageThreadUtil.SyncQueueItem)localObject).arg1, ((MessageThreadUtil.SyncQueueItem)localObject).arg2);
                }
              }
              else
              {
                MessageThreadUtil.2.this.mQueue.removeMessages(2);
                MessageThreadUtil.2.this.mQueue.removeMessages(3);
                MessageThreadUtil.2.this.val$callback.updateRange(((MessageThreadUtil.SyncQueueItem)localObject).arg1, ((MessageThreadUtil.SyncQueueItem)localObject).arg2, ((MessageThreadUtil.SyncQueueItem)localObject).arg3, ((MessageThreadUtil.SyncQueueItem)localObject).arg4, ((MessageThreadUtil.SyncQueueItem)localObject).arg5);
              }
            }
            else
            {
              MessageThreadUtil.2.this.mQueue.removeMessages(1);
              MessageThreadUtil.2.this.val$callback.refresh(((MessageThreadUtil.SyncQueueItem)localObject).arg1);
            }
          }
        }
      };
      AtomicBoolean mBackgroundRunning = new AtomicBoolean(false);
      private final Executor mExecutor = AsyncTask.THREAD_POOL_EXECUTOR;
      final MessageThreadUtil.MessageQueue mQueue = new MessageThreadUtil.MessageQueue();
      
      private void maybeExecuteBackgroundRunnable()
      {
        if (this.mBackgroundRunning.compareAndSet(false, true)) {
          this.mExecutor.execute(this.mBackgroundRunnable);
        }
      }
      
      private void sendMessage(MessageThreadUtil.SyncQueueItem paramAnonymousSyncQueueItem)
      {
        this.mQueue.sendMessage(paramAnonymousSyncQueueItem);
        maybeExecuteBackgroundRunnable();
      }
      
      private void sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem paramAnonymousSyncQueueItem)
      {
        this.mQueue.sendMessageAtFrontOfQueue(paramAnonymousSyncQueueItem);
        maybeExecuteBackgroundRunnable();
      }
      
      public void loadTile(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(3, paramAnonymousInt1, paramAnonymousInt2));
      }
      
      public void recycleTile(TileList.Tile<T> paramAnonymousTile)
      {
        sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(4, 0, paramAnonymousTile));
      }
      
      public void refresh(int paramAnonymousInt)
      {
        sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem.obtainMessage(1, paramAnonymousInt, null));
      }
      
      public void updateRange(int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5)
      {
        sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem.obtainMessage(2, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4, paramAnonymousInt5, null));
      }
    };
  }
  
  public ThreadUtil.MainThreadCallback<T> getMainThreadProxy(final ThreadUtil.MainThreadCallback<T> paramMainThreadCallback)
  {
    new ThreadUtil.MainThreadCallback()
    {
      static final int ADD_TILE = 2;
      static final int REMOVE_TILE = 3;
      static final int UPDATE_ITEM_COUNT = 1;
      private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
      private Runnable mMainThreadRunnable = new Runnable()
      {
        public void run()
        {
          for (MessageThreadUtil.SyncQueueItem localSyncQueueItem = MessageThreadUtil.1.this.mQueue.next(); localSyncQueueItem != null; localSyncQueueItem = MessageThreadUtil.1.this.mQueue.next())
          {
            int i = localSyncQueueItem.what;
            if (i != 1)
            {
              Object localObject;
              if (i != 2)
              {
                if (i != 3)
                {
                  localObject = new StringBuilder();
                  ((StringBuilder)localObject).append("Unsupported message, what=");
                  ((StringBuilder)localObject).append(localSyncQueueItem.what);
                  Log.e("ThreadUtil", ((StringBuilder)localObject).toString());
                }
                else
                {
                  MessageThreadUtil.1.this.val$callback.removeTile(localSyncQueueItem.arg1, localSyncQueueItem.arg2);
                }
              }
              else
              {
                localObject = (TileList.Tile)localSyncQueueItem.data;
                MessageThreadUtil.1.this.val$callback.addTile(localSyncQueueItem.arg1, (TileList.Tile)localObject);
              }
            }
            else
            {
              MessageThreadUtil.1.this.val$callback.updateItemCount(localSyncQueueItem.arg1, localSyncQueueItem.arg2);
            }
          }
        }
      };
      final MessageThreadUtil.MessageQueue mQueue = new MessageThreadUtil.MessageQueue();
      
      private void sendMessage(MessageThreadUtil.SyncQueueItem paramAnonymousSyncQueueItem)
      {
        this.mQueue.sendMessage(paramAnonymousSyncQueueItem);
        this.mMainThreadHandler.post(this.mMainThreadRunnable);
      }
      
      public void addTile(int paramAnonymousInt, TileList.Tile<T> paramAnonymousTile)
      {
        sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(2, paramAnonymousInt, paramAnonymousTile));
      }
      
      public void removeTile(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(3, paramAnonymousInt1, paramAnonymousInt2));
      }
      
      public void updateItemCount(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        sendMessage(MessageThreadUtil.SyncQueueItem.obtainMessage(1, paramAnonymousInt1, paramAnonymousInt2));
      }
    };
  }
  
  static class MessageQueue
  {
    private MessageThreadUtil.SyncQueueItem mRoot;
    
    MessageThreadUtil.SyncQueueItem next()
    {
      try
      {
        MessageThreadUtil.SyncQueueItem localSyncQueueItem = this.mRoot;
        if (localSyncQueueItem == null) {
          return null;
        }
        this.mRoot = localSyncQueueItem.next;
        return localSyncQueueItem;
      }
      finally {}
    }
    
    void removeMessages(int paramInt)
    {
      try
      {
        Object localObject1;
        for (;;)
        {
          localObject1 = this.mRoot;
          if ((localObject1 == null) || (((MessageThreadUtil.SyncQueueItem)localObject1).what != paramInt)) {
            break;
          }
          this.mRoot = ((MessageThreadUtil.SyncQueueItem)localObject1).next;
          ((MessageThreadUtil.SyncQueueItem)localObject1).recycle();
        }
        if (localObject1 != null)
        {
          MessageThreadUtil.SyncQueueItem localSyncQueueItem;
          for (Object localObject2 = ((MessageThreadUtil.SyncQueueItem)localObject1).next; localObject2 != null; localObject2 = localSyncQueueItem)
          {
            localSyncQueueItem = ((MessageThreadUtil.SyncQueueItem)localObject2).next;
            if (((MessageThreadUtil.SyncQueueItem)localObject2).what == paramInt)
            {
              ((MessageThreadUtil.SyncQueueItem)localObject1).next = localSyncQueueItem;
              ((MessageThreadUtil.SyncQueueItem)localObject2).recycle();
            }
            else
            {
              localObject1 = localObject2;
            }
          }
        }
        return;
      }
      finally {}
    }
    
    void sendMessage(MessageThreadUtil.SyncQueueItem paramSyncQueueItem)
    {
      try
      {
        MessageThreadUtil.SyncQueueItem localSyncQueueItem1 = this.mRoot;
        MessageThreadUtil.SyncQueueItem localSyncQueueItem2 = localSyncQueueItem1;
        if (localSyncQueueItem1 == null)
        {
          this.mRoot = paramSyncQueueItem;
          return;
        }
        for (;;)
        {
          localSyncQueueItem1 = localSyncQueueItem2.next;
          if (localSyncQueueItem1 == null) {
            break;
          }
          localSyncQueueItem2 = localSyncQueueItem1;
        }
        localSyncQueueItem2.next = paramSyncQueueItem;
        return;
      }
      finally {}
    }
    
    void sendMessageAtFrontOfQueue(MessageThreadUtil.SyncQueueItem paramSyncQueueItem)
    {
      try
      {
        paramSyncQueueItem.next = this.mRoot;
        this.mRoot = paramSyncQueueItem;
        return;
      }
      finally
      {
        paramSyncQueueItem = finally;
        throw paramSyncQueueItem;
      }
    }
  }
  
  static class SyncQueueItem
  {
    private static SyncQueueItem sPool;
    private static final Object sPoolLock = new Object();
    public int arg1;
    public int arg2;
    public int arg3;
    public int arg4;
    public int arg5;
    public Object data;
    SyncQueueItem next;
    public int what;
    
    static SyncQueueItem obtainMessage(int paramInt1, int paramInt2, int paramInt3)
    {
      return obtainMessage(paramInt1, paramInt2, paramInt3, 0, 0, 0, null);
    }
    
    static SyncQueueItem obtainMessage(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, Object paramObject)
    {
      synchronized (sPoolLock)
      {
        SyncQueueItem localSyncQueueItem = sPool;
        if (localSyncQueueItem == null)
        {
          localSyncQueueItem = new androidx/recyclerview/widget/MessageThreadUtil$SyncQueueItem;
          localSyncQueueItem.<init>();
        }
        else
        {
          sPool = localSyncQueueItem.next;
          localSyncQueueItem.next = null;
        }
        localSyncQueueItem.what = paramInt1;
        localSyncQueueItem.arg1 = paramInt2;
        localSyncQueueItem.arg2 = paramInt3;
        localSyncQueueItem.arg3 = paramInt4;
        localSyncQueueItem.arg4 = paramInt5;
        localSyncQueueItem.arg5 = paramInt6;
        localSyncQueueItem.data = paramObject;
        return localSyncQueueItem;
      }
    }
    
    static SyncQueueItem obtainMessage(int paramInt1, int paramInt2, Object paramObject)
    {
      return obtainMessage(paramInt1, paramInt2, 0, 0, 0, 0, paramObject);
    }
    
    void recycle()
    {
      this.next = null;
      this.arg5 = 0;
      this.arg4 = 0;
      this.arg3 = 0;
      this.arg2 = 0;
      this.arg1 = 0;
      this.what = 0;
      this.data = null;
      synchronized (sPoolLock)
      {
        SyncQueueItem localSyncQueueItem = sPool;
        if (localSyncQueueItem != null) {
          this.next = localSyncQueueItem;
        }
        sPool = this;
        return;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\MessageThreadUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */