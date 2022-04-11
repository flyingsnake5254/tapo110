package androidx.recyclerview.widget;

import androidx.core.util.Pools.Pool;
import androidx.core.util.Pools.SimplePool;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class AdapterHelper
  implements OpReorderer.Callback
{
  private static final boolean DEBUG = false;
  static final int POSITION_TYPE_INVISIBLE = 0;
  static final int POSITION_TYPE_NEW_OR_LAID_OUT = 1;
  private static final String TAG = "AHT";
  final Callback mCallback;
  final boolean mDisableRecycler;
  private int mExistingUpdateTypes = 0;
  Runnable mOnItemProcessedCallback;
  final OpReorderer mOpReorderer;
  final ArrayList<UpdateOp> mPendingUpdates = new ArrayList();
  final ArrayList<UpdateOp> mPostponedList = new ArrayList();
  private Pools.Pool<UpdateOp> mUpdateOpPool = new Pools.SimplePool(30);
  
  AdapterHelper(Callback paramCallback)
  {
    this(paramCallback, false);
  }
  
  AdapterHelper(Callback paramCallback, boolean paramBoolean)
  {
    this.mCallback = paramCallback;
    this.mDisableRecycler = paramBoolean;
    this.mOpReorderer = new OpReorderer(this);
  }
  
  private void applyAdd(UpdateOp paramUpdateOp)
  {
    postponeAndUpdateViewHolders(paramUpdateOp);
  }
  
  private void applyMove(UpdateOp paramUpdateOp)
  {
    postponeAndUpdateViewHolders(paramUpdateOp);
  }
  
  private void applyRemove(UpdateOp paramUpdateOp)
  {
    int i = paramUpdateOp.positionStart;
    int j = paramUpdateOp.itemCount + i;
    int k = -1;
    int m = i;
    int i2;
    for (int n = 0; m < j; n = i2)
    {
      if ((this.mCallback.findViewHolder(m) == null) && (!canFindInPreLayout(m)))
      {
        if (k == 1)
        {
          postponeAndUpdateViewHolders(obtainUpdateOp(2, i, n, null));
          k = 1;
        }
        else
        {
          k = 0;
        }
        int i1 = 0;
        i2 = k;
        k = i1;
      }
      else
      {
        if (k == 0)
        {
          dispatchAndUpdateViewHolders(obtainUpdateOp(2, i, n, null));
          i2 = 1;
        }
        else
        {
          i2 = 0;
        }
        k = 1;
      }
      if (i2 != 0)
      {
        m -= n;
        j -= n;
        i2 = 1;
      }
      else
      {
        i2 = n + 1;
      }
      m++;
    }
    UpdateOp localUpdateOp = paramUpdateOp;
    if (n != paramUpdateOp.itemCount)
    {
      recycleUpdateOp(paramUpdateOp);
      localUpdateOp = obtainUpdateOp(2, i, n, null);
    }
    if (k == 0) {
      dispatchAndUpdateViewHolders(localUpdateOp);
    } else {
      postponeAndUpdateViewHolders(localUpdateOp);
    }
  }
  
  private void applyUpdate(UpdateOp paramUpdateOp)
  {
    int i = paramUpdateOp.positionStart;
    int j = paramUpdateOp.itemCount;
    int k = i;
    int m = -1;
    int n = 0;
    int i1 = i;
    while (i1 < j + i)
    {
      int i2;
      if ((this.mCallback.findViewHolder(i1) == null) && (!canFindInPreLayout(i1)))
      {
        i2 = k;
        i3 = n;
        if (m == 1)
        {
          postponeAndUpdateViewHolders(obtainUpdateOp(4, k, n, paramUpdateOp.payload));
          i2 = i1;
          i3 = 0;
        }
        n = 0;
        k = i2;
        i2 = i3;
      }
      else
      {
        i3 = k;
        i2 = n;
        if (m == 0)
        {
          dispatchAndUpdateViewHolders(obtainUpdateOp(4, k, n, paramUpdateOp.payload));
          i3 = i1;
          i2 = 0;
        }
        n = 1;
        k = i3;
      }
      int i3 = i2 + 1;
      i1++;
      m = n;
      n = i3;
    }
    Object localObject = paramUpdateOp;
    if (n != paramUpdateOp.itemCount)
    {
      localObject = paramUpdateOp.payload;
      recycleUpdateOp(paramUpdateOp);
      localObject = obtainUpdateOp(4, k, n, localObject);
    }
    if (m == 0) {
      dispatchAndUpdateViewHolders((UpdateOp)localObject);
    } else {
      postponeAndUpdateViewHolders((UpdateOp)localObject);
    }
  }
  
  private boolean canFindInPreLayout(int paramInt)
  {
    int i = this.mPostponedList.size();
    for (int j = 0; j < i; j++)
    {
      UpdateOp localUpdateOp = (UpdateOp)this.mPostponedList.get(j);
      int k = localUpdateOp.cmd;
      if (k == 8)
      {
        if (findPositionOffset(localUpdateOp.itemCount, j + 1) == paramInt) {
          return true;
        }
      }
      else if (k == 1)
      {
        int m = localUpdateOp.positionStart;
        int n = localUpdateOp.itemCount;
        for (k = m; k < n + m; k++) {
          if (findPositionOffset(k, j + 1) == paramInt) {
            return true;
          }
        }
      }
    }
    return false;
  }
  
  private void dispatchAndUpdateViewHolders(UpdateOp paramUpdateOp)
  {
    int i = paramUpdateOp.cmd;
    if ((i != 1) && (i != 8))
    {
      int j = updatePositionWithPostponed(paramUpdateOp.positionStart, i);
      i = paramUpdateOp.positionStart;
      int k = paramUpdateOp.cmd;
      int m;
      if (k != 2)
      {
        if (k == 4)
        {
          m = 1;
        }
        else
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("op should be remove or update.");
          ((StringBuilder)localObject).append(paramUpdateOp);
          throw new IllegalArgumentException(((StringBuilder)localObject).toString());
        }
      }
      else {
        m = 0;
      }
      int n = 1;
      k = 1;
      while (n < paramUpdateOp.itemCount)
      {
        int i1 = updatePositionWithPostponed(paramUpdateOp.positionStart + m * n, paramUpdateOp.cmd);
        int i2 = paramUpdateOp.cmd;
        int i3;
        if (i2 != 2)
        {
          if (i2 != 4) {}
          while (i1 != j + 1)
          {
            i3 = 0;
            break;
          }
        }
        for (;;)
        {
          i3 = 1;
          break label177;
          if (i1 != j) {
            break;
          }
        }
        label177:
        if (i3 != 0)
        {
          k++;
        }
        else
        {
          localObject = obtainUpdateOp(i2, j, k, paramUpdateOp.payload);
          dispatchFirstPassAndUpdateViewHolders((UpdateOp)localObject, i);
          recycleUpdateOp((UpdateOp)localObject);
          j = i;
          if (paramUpdateOp.cmd == 4) {
            j = i + k;
          }
          i3 = i1;
          k = 1;
          i = j;
          j = i3;
        }
        n++;
      }
      Object localObject = paramUpdateOp.payload;
      recycleUpdateOp(paramUpdateOp);
      if (k > 0)
      {
        paramUpdateOp = obtainUpdateOp(paramUpdateOp.cmd, j, k, localObject);
        dispatchFirstPassAndUpdateViewHolders(paramUpdateOp, i);
        recycleUpdateOp(paramUpdateOp);
      }
      return;
    }
    throw new IllegalArgumentException("should not dispatch add or move for pre layout");
  }
  
  private void postponeAndUpdateViewHolders(UpdateOp paramUpdateOp)
  {
    this.mPostponedList.add(paramUpdateOp);
    int i = paramUpdateOp.cmd;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 4)
        {
          if (i == 8)
          {
            this.mCallback.offsetPositionsForMove(paramUpdateOp.positionStart, paramUpdateOp.itemCount);
          }
          else
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Unknown update op type for ");
            localStringBuilder.append(paramUpdateOp);
            throw new IllegalArgumentException(localStringBuilder.toString());
          }
        }
        else {
          this.mCallback.markViewHoldersUpdated(paramUpdateOp.positionStart, paramUpdateOp.itemCount, paramUpdateOp.payload);
        }
      }
      else {
        this.mCallback.offsetPositionsForRemovingLaidOutOrNewView(paramUpdateOp.positionStart, paramUpdateOp.itemCount);
      }
    }
    else {
      this.mCallback.offsetPositionsForAdd(paramUpdateOp.positionStart, paramUpdateOp.itemCount);
    }
  }
  
  private int updatePositionWithPostponed(int paramInt1, int paramInt2)
  {
    int i = this.mPostponedList.size() - 1;
    UpdateOp localUpdateOp;
    for (int j = paramInt1; i >= 0; j = paramInt1)
    {
      localUpdateOp = (UpdateOp)this.mPostponedList.get(i);
      int k = localUpdateOp.cmd;
      int m;
      if (k == 8)
      {
        m = localUpdateOp.positionStart;
        k = localUpdateOp.itemCount;
        int n;
        if (m < k)
        {
          paramInt1 = m;
          n = k;
        }
        else
        {
          n = m;
          paramInt1 = k;
        }
        if ((j >= paramInt1) && (j <= n))
        {
          if (paramInt1 == m)
          {
            if (paramInt2 == 1) {
              localUpdateOp.itemCount = (k + 1);
            } else if (paramInt2 == 2) {
              localUpdateOp.itemCount = (k - 1);
            }
            paramInt1 = j + 1;
          }
          else
          {
            if (paramInt2 == 1) {
              localUpdateOp.positionStart = (m + 1);
            } else if (paramInt2 == 2) {
              localUpdateOp.positionStart = (m - 1);
            }
            paramInt1 = j - 1;
          }
        }
        else
        {
          paramInt1 = j;
          if (j < m) {
            if (paramInt2 == 1)
            {
              localUpdateOp.positionStart = (m + 1);
              localUpdateOp.itemCount = (k + 1);
              paramInt1 = j;
            }
            else
            {
              paramInt1 = j;
              if (paramInt2 == 2)
              {
                localUpdateOp.positionStart = (m - 1);
                localUpdateOp.itemCount = (k - 1);
                paramInt1 = j;
              }
            }
          }
        }
      }
      else
      {
        m = localUpdateOp.positionStart;
        if (m <= j)
        {
          if (k == 1)
          {
            paramInt1 = j - localUpdateOp.itemCount;
          }
          else
          {
            paramInt1 = j;
            if (k == 2) {
              paramInt1 = j + localUpdateOp.itemCount;
            }
          }
        }
        else if (paramInt2 == 1)
        {
          localUpdateOp.positionStart = (m + 1);
          paramInt1 = j;
        }
        else
        {
          paramInt1 = j;
          if (paramInt2 == 2)
          {
            localUpdateOp.positionStart = (m - 1);
            paramInt1 = j;
          }
        }
      }
      i--;
    }
    for (paramInt1 = this.mPostponedList.size() - 1; paramInt1 >= 0; paramInt1--)
    {
      localUpdateOp = (UpdateOp)this.mPostponedList.get(paramInt1);
      if (localUpdateOp.cmd == 8)
      {
        paramInt2 = localUpdateOp.itemCount;
        if ((paramInt2 == localUpdateOp.positionStart) || (paramInt2 < 0))
        {
          this.mPostponedList.remove(paramInt1);
          recycleUpdateOp(localUpdateOp);
        }
      }
      else if (localUpdateOp.itemCount <= 0)
      {
        this.mPostponedList.remove(paramInt1);
        recycleUpdateOp(localUpdateOp);
      }
    }
    return j;
  }
  
  AdapterHelper addUpdateOp(UpdateOp... paramVarArgs)
  {
    Collections.addAll(this.mPendingUpdates, paramVarArgs);
    return this;
  }
  
  public int applyPendingUpdatesToPosition(int paramInt)
  {
    int i = this.mPendingUpdates.size();
    int j = 0;
    for (int k = paramInt; j < i; k = paramInt)
    {
      UpdateOp localUpdateOp = (UpdateOp)this.mPendingUpdates.get(j);
      paramInt = localUpdateOp.cmd;
      if (paramInt != 1)
      {
        int m;
        if (paramInt != 2)
        {
          if (paramInt != 8)
          {
            paramInt = k;
          }
          else
          {
            paramInt = localUpdateOp.positionStart;
            if (paramInt == k)
            {
              paramInt = localUpdateOp.itemCount;
            }
            else
            {
              m = k;
              if (paramInt < k) {
                m = k - 1;
              }
              paramInt = m;
              if (localUpdateOp.itemCount <= m) {
                paramInt = m + 1;
              }
            }
          }
        }
        else
        {
          m = localUpdateOp.positionStart;
          paramInt = k;
          if (m <= k)
          {
            paramInt = localUpdateOp.itemCount;
            if (m + paramInt > k) {
              return -1;
            }
            paramInt = k - paramInt;
          }
        }
      }
      else
      {
        paramInt = k;
        if (localUpdateOp.positionStart <= k) {
          paramInt = k + localUpdateOp.itemCount;
        }
      }
      j++;
    }
    return k;
  }
  
  void consumePostponedUpdates()
  {
    int i = this.mPostponedList.size();
    for (int j = 0; j < i; j++) {
      this.mCallback.onDispatchSecondPass((UpdateOp)this.mPostponedList.get(j));
    }
    recycleUpdateOpsAndClearList(this.mPostponedList);
    this.mExistingUpdateTypes = 0;
  }
  
  void consumeUpdatesInOnePass()
  {
    consumePostponedUpdates();
    int i = this.mPendingUpdates.size();
    for (int j = 0; j < i; j++)
    {
      Object localObject = (UpdateOp)this.mPendingUpdates.get(j);
      int k = ((UpdateOp)localObject).cmd;
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 4)
          {
            if (k == 8)
            {
              this.mCallback.onDispatchSecondPass((UpdateOp)localObject);
              this.mCallback.offsetPositionsForMove(((UpdateOp)localObject).positionStart, ((UpdateOp)localObject).itemCount);
            }
          }
          else
          {
            this.mCallback.onDispatchSecondPass((UpdateOp)localObject);
            this.mCallback.markViewHoldersUpdated(((UpdateOp)localObject).positionStart, ((UpdateOp)localObject).itemCount, ((UpdateOp)localObject).payload);
          }
        }
        else
        {
          this.mCallback.onDispatchSecondPass((UpdateOp)localObject);
          this.mCallback.offsetPositionsForRemovingInvisible(((UpdateOp)localObject).positionStart, ((UpdateOp)localObject).itemCount);
        }
      }
      else
      {
        this.mCallback.onDispatchSecondPass((UpdateOp)localObject);
        this.mCallback.offsetPositionsForAdd(((UpdateOp)localObject).positionStart, ((UpdateOp)localObject).itemCount);
      }
      localObject = this.mOnItemProcessedCallback;
      if (localObject != null) {
        ((Runnable)localObject).run();
      }
    }
    recycleUpdateOpsAndClearList(this.mPendingUpdates);
    this.mExistingUpdateTypes = 0;
  }
  
  void dispatchFirstPassAndUpdateViewHolders(UpdateOp paramUpdateOp, int paramInt)
  {
    this.mCallback.onDispatchFirstPass(paramUpdateOp);
    int i = paramUpdateOp.cmd;
    if (i != 2)
    {
      if (i == 4) {
        this.mCallback.markViewHoldersUpdated(paramInt, paramUpdateOp.itemCount, paramUpdateOp.payload);
      } else {
        throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
      }
    }
    else {
      this.mCallback.offsetPositionsForRemovingInvisible(paramInt, paramUpdateOp.itemCount);
    }
  }
  
  int findPositionOffset(int paramInt)
  {
    return findPositionOffset(paramInt, 0);
  }
  
  int findPositionOffset(int paramInt1, int paramInt2)
  {
    int i = this.mPostponedList.size();
    int j = paramInt2;
    for (paramInt2 = paramInt1; j < i; paramInt2 = paramInt1)
    {
      UpdateOp localUpdateOp = (UpdateOp)this.mPostponedList.get(j);
      int k = localUpdateOp.cmd;
      int m;
      if (k == 8)
      {
        paramInt1 = localUpdateOp.positionStart;
        if (paramInt1 == paramInt2)
        {
          paramInt1 = localUpdateOp.itemCount;
        }
        else
        {
          m = paramInt2;
          if (paramInt1 < paramInt2) {
            m = paramInt2 - 1;
          }
          paramInt1 = m;
          if (localUpdateOp.itemCount <= m) {
            paramInt1 = m + 1;
          }
        }
      }
      else
      {
        m = localUpdateOp.positionStart;
        paramInt1 = paramInt2;
        if (m <= paramInt2) {
          if (k == 2)
          {
            paramInt1 = localUpdateOp.itemCount;
            if (paramInt2 < m + paramInt1) {
              return -1;
            }
            paramInt1 = paramInt2 - paramInt1;
          }
          else
          {
            paramInt1 = paramInt2;
            if (k == 1) {
              paramInt1 = paramInt2 + localUpdateOp.itemCount;
            }
          }
        }
      }
      j++;
    }
    return paramInt2;
  }
  
  boolean hasAnyUpdateTypes(int paramInt)
  {
    boolean bool;
    if ((paramInt & this.mExistingUpdateTypes) != 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  boolean hasPendingUpdates()
  {
    boolean bool;
    if (this.mPendingUpdates.size() > 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  boolean hasUpdates()
  {
    boolean bool;
    if ((!this.mPostponedList.isEmpty()) && (!this.mPendingUpdates.isEmpty())) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public UpdateOp obtainUpdateOp(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    UpdateOp localUpdateOp = (UpdateOp)this.mUpdateOpPool.acquire();
    if (localUpdateOp == null)
    {
      paramObject = new UpdateOp(paramInt1, paramInt2, paramInt3, paramObject);
    }
    else
    {
      localUpdateOp.cmd = paramInt1;
      localUpdateOp.positionStart = paramInt2;
      localUpdateOp.itemCount = paramInt3;
      localUpdateOp.payload = paramObject;
      paramObject = localUpdateOp;
    }
    return (UpdateOp)paramObject;
  }
  
  boolean onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
  {
    boolean bool = false;
    if (paramInt2 < 1) {
      return false;
    }
    this.mPendingUpdates.add(obtainUpdateOp(4, paramInt1, paramInt2, paramObject));
    this.mExistingUpdateTypes |= 0x4;
    if (this.mPendingUpdates.size() == 1) {
      bool = true;
    }
    return bool;
  }
  
  boolean onItemRangeInserted(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramInt2 < 1) {
      return false;
    }
    this.mPendingUpdates.add(obtainUpdateOp(1, paramInt1, paramInt2, null));
    this.mExistingUpdateTypes |= 0x1;
    if (this.mPendingUpdates.size() == 1) {
      bool = true;
    }
    return bool;
  }
  
  boolean onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool = false;
    if (paramInt1 == paramInt2) {
      return false;
    }
    if (paramInt3 == 1)
    {
      this.mPendingUpdates.add(obtainUpdateOp(8, paramInt1, paramInt2, null));
      this.mExistingUpdateTypes |= 0x8;
      if (this.mPendingUpdates.size() == 1) {
        bool = true;
      }
      return bool;
    }
    throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
  }
  
  boolean onItemRangeRemoved(int paramInt1, int paramInt2)
  {
    boolean bool = false;
    if (paramInt2 < 1) {
      return false;
    }
    this.mPendingUpdates.add(obtainUpdateOp(2, paramInt1, paramInt2, null));
    this.mExistingUpdateTypes |= 0x2;
    if (this.mPendingUpdates.size() == 1) {
      bool = true;
    }
    return bool;
  }
  
  void preProcess()
  {
    this.mOpReorderer.reorderOps(this.mPendingUpdates);
    int i = this.mPendingUpdates.size();
    for (int j = 0; j < i; j++)
    {
      Object localObject = (UpdateOp)this.mPendingUpdates.get(j);
      int k = ((UpdateOp)localObject).cmd;
      if (k != 1)
      {
        if (k != 2)
        {
          if (k != 4)
          {
            if (k == 8) {
              applyMove((UpdateOp)localObject);
            }
          }
          else {
            applyUpdate((UpdateOp)localObject);
          }
        }
        else {
          applyRemove((UpdateOp)localObject);
        }
      }
      else {
        applyAdd((UpdateOp)localObject);
      }
      localObject = this.mOnItemProcessedCallback;
      if (localObject != null) {
        ((Runnable)localObject).run();
      }
    }
    this.mPendingUpdates.clear();
  }
  
  public void recycleUpdateOp(UpdateOp paramUpdateOp)
  {
    if (!this.mDisableRecycler)
    {
      paramUpdateOp.payload = null;
      this.mUpdateOpPool.release(paramUpdateOp);
    }
  }
  
  void recycleUpdateOpsAndClearList(List<UpdateOp> paramList)
  {
    int i = paramList.size();
    for (int j = 0; j < i; j++) {
      recycleUpdateOp((UpdateOp)paramList.get(j));
    }
    paramList.clear();
  }
  
  void reset()
  {
    recycleUpdateOpsAndClearList(this.mPendingUpdates);
    recycleUpdateOpsAndClearList(this.mPostponedList);
    this.mExistingUpdateTypes = 0;
  }
  
  static abstract interface Callback
  {
    public abstract RecyclerView.ViewHolder findViewHolder(int paramInt);
    
    public abstract void markViewHoldersUpdated(int paramInt1, int paramInt2, Object paramObject);
    
    public abstract void offsetPositionsForAdd(int paramInt1, int paramInt2);
    
    public abstract void offsetPositionsForMove(int paramInt1, int paramInt2);
    
    public abstract void offsetPositionsForRemovingInvisible(int paramInt1, int paramInt2);
    
    public abstract void offsetPositionsForRemovingLaidOutOrNewView(int paramInt1, int paramInt2);
    
    public abstract void onDispatchFirstPass(AdapterHelper.UpdateOp paramUpdateOp);
    
    public abstract void onDispatchSecondPass(AdapterHelper.UpdateOp paramUpdateOp);
  }
  
  static final class UpdateOp
  {
    static final int ADD = 1;
    static final int MOVE = 8;
    static final int POOL_SIZE = 30;
    static final int REMOVE = 2;
    static final int UPDATE = 4;
    int cmd;
    int itemCount;
    Object payload;
    int positionStart;
    
    UpdateOp(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
    {
      this.cmd = paramInt1;
      this.positionStart = paramInt2;
      this.itemCount = paramInt3;
      this.payload = paramObject;
    }
    
    String cmdToString()
    {
      int i = this.cmd;
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 4)
          {
            if (i != 8) {
              return "??";
            }
            return "mv";
          }
          return "up";
        }
        return "rm";
      }
      return "add";
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {
        return true;
      }
      if (!(paramObject instanceof UpdateOp)) {
        return false;
      }
      UpdateOp localUpdateOp = (UpdateOp)paramObject;
      int i = this.cmd;
      if (i != localUpdateOp.cmd) {
        return false;
      }
      if ((i == 8) && (Math.abs(this.itemCount - this.positionStart) == 1) && (this.itemCount == localUpdateOp.positionStart) && (this.positionStart == localUpdateOp.itemCount)) {
        return true;
      }
      if (this.itemCount != localUpdateOp.itemCount) {
        return false;
      }
      if (this.positionStart != localUpdateOp.positionStart) {
        return false;
      }
      paramObject = this.payload;
      if (paramObject != null)
      {
        if (!paramObject.equals(localUpdateOp.payload)) {
          return false;
        }
      }
      else if (localUpdateOp.payload != null) {
        return false;
      }
      return true;
    }
    
    public int hashCode()
    {
      return (this.cmd * 31 + this.positionStart) * 31 + this.itemCount;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
      localStringBuilder.append("[");
      localStringBuilder.append(cmdToString());
      localStringBuilder.append(",s:");
      localStringBuilder.append(this.positionStart);
      localStringBuilder.append("c:");
      localStringBuilder.append(this.itemCount);
      localStringBuilder.append(",p:");
      localStringBuilder.append(this.payload);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\AdapterHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */