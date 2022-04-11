package androidx.recyclerview.widget;

import java.util.List;

class OpReorderer
{
  final Callback mCallback;
  
  OpReorderer(Callback paramCallback)
  {
    this.mCallback = paramCallback;
  }
  
  private int getLastMoveOutOfOrder(List<AdapterHelper.UpdateOp> paramList)
  {
    int i = paramList.size() - 1;
    int k;
    for (int j = 0; i >= 0; j = k)
    {
      if (((AdapterHelper.UpdateOp)paramList.get(i)).cmd == 8)
      {
        k = j;
        if (j != 0) {
          return i;
        }
      }
      else
      {
        k = 1;
      }
      i--;
    }
    return -1;
  }
  
  private void swapMoveAdd(List<AdapterHelper.UpdateOp> paramList, int paramInt1, AdapterHelper.UpdateOp paramUpdateOp1, int paramInt2, AdapterHelper.UpdateOp paramUpdateOp2)
  {
    int i = paramUpdateOp1.itemCount;
    int j = paramUpdateOp2.positionStart;
    if (i < j) {
      k = -1;
    } else {
      k = 0;
    }
    int m = paramUpdateOp1.positionStart;
    int n = k;
    if (m < j) {
      n = k + 1;
    }
    if (j <= m) {
      paramUpdateOp1.positionStart = (m + paramUpdateOp2.itemCount);
    }
    int k = paramUpdateOp2.positionStart;
    if (k <= i) {
      paramUpdateOp1.itemCount = (i + paramUpdateOp2.itemCount);
    }
    paramUpdateOp2.positionStart = (k + n);
    paramList.set(paramInt1, paramUpdateOp2);
    paramList.set(paramInt2, paramUpdateOp1);
  }
  
  private void swapMoveOp(List<AdapterHelper.UpdateOp> paramList, int paramInt1, int paramInt2)
  {
    AdapterHelper.UpdateOp localUpdateOp1 = (AdapterHelper.UpdateOp)paramList.get(paramInt1);
    AdapterHelper.UpdateOp localUpdateOp2 = (AdapterHelper.UpdateOp)paramList.get(paramInt2);
    int i = localUpdateOp2.cmd;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i == 4) {
          swapMoveUpdate(paramList, paramInt1, localUpdateOp1, paramInt2, localUpdateOp2);
        }
      }
      else {
        swapMoveRemove(paramList, paramInt1, localUpdateOp1, paramInt2, localUpdateOp2);
      }
    }
    else {
      swapMoveAdd(paramList, paramInt1, localUpdateOp1, paramInt2, localUpdateOp2);
    }
  }
  
  void reorderOps(List<AdapterHelper.UpdateOp> paramList)
  {
    for (;;)
    {
      int i = getLastMoveOutOfOrder(paramList);
      if (i == -1) {
        break;
      }
      swapMoveOp(paramList, i, i + 1);
    }
  }
  
  void swapMoveRemove(List<AdapterHelper.UpdateOp> paramList, int paramInt1, AdapterHelper.UpdateOp paramUpdateOp1, int paramInt2, AdapterHelper.UpdateOp paramUpdateOp2)
  {
    int i = paramUpdateOp1.positionStart;
    int j = paramUpdateOp1.itemCount;
    int k = 0;
    if (i < j)
    {
      if ((paramUpdateOp2.positionStart == i) && (paramUpdateOp2.itemCount == j - i))
      {
        i = 0;
      }
      else
      {
        i = 0;
        break label94;
      }
    }
    else
    {
      if ((paramUpdateOp2.positionStart != j + 1) || (paramUpdateOp2.itemCount != i - j)) {
        break label91;
      }
      i = 1;
    }
    k = 1;
    break label94;
    label91:
    i = 1;
    label94:
    int m = paramUpdateOp2.positionStart;
    int n;
    if (j < m)
    {
      paramUpdateOp2.positionStart = (m - 1);
    }
    else
    {
      n = paramUpdateOp2.itemCount;
      if (j < m + n)
      {
        paramUpdateOp2.itemCount = (n - 1);
        paramUpdateOp1.cmd = 2;
        paramUpdateOp1.itemCount = 1;
        if (paramUpdateOp2.itemCount == 0)
        {
          paramList.remove(paramInt2);
          this.mCallback.recycleUpdateOp(paramUpdateOp2);
        }
        return;
      }
    }
    j = paramUpdateOp1.positionStart;
    m = paramUpdateOp2.positionStart;
    AdapterHelper.UpdateOp localUpdateOp = null;
    if (j <= m)
    {
      paramUpdateOp2.positionStart = (m + 1);
    }
    else
    {
      n = paramUpdateOp2.itemCount;
      if (j < m + n)
      {
        localUpdateOp = this.mCallback.obtainUpdateOp(2, j + 1, m + n - j, null);
        paramUpdateOp2.itemCount = (paramUpdateOp1.positionStart - paramUpdateOp2.positionStart);
      }
    }
    if (k != 0)
    {
      paramList.set(paramInt1, paramUpdateOp2);
      paramList.remove(paramInt2);
      this.mCallback.recycleUpdateOp(paramUpdateOp1);
      return;
    }
    if (i != 0)
    {
      if (localUpdateOp != null)
      {
        i = paramUpdateOp1.positionStart;
        if (i > localUpdateOp.positionStart) {
          paramUpdateOp1.positionStart = (i - localUpdateOp.itemCount);
        }
        i = paramUpdateOp1.itemCount;
        if (i > localUpdateOp.positionStart) {
          paramUpdateOp1.itemCount = (i - localUpdateOp.itemCount);
        }
      }
      i = paramUpdateOp1.positionStart;
      if (i > paramUpdateOp2.positionStart) {
        paramUpdateOp1.positionStart = (i - paramUpdateOp2.itemCount);
      }
      i = paramUpdateOp1.itemCount;
      if (i > paramUpdateOp2.positionStart) {
        paramUpdateOp1.itemCount = (i - paramUpdateOp2.itemCount);
      }
    }
    else
    {
      if (localUpdateOp != null)
      {
        i = paramUpdateOp1.positionStart;
        if (i >= localUpdateOp.positionStart) {
          paramUpdateOp1.positionStart = (i - localUpdateOp.itemCount);
        }
        i = paramUpdateOp1.itemCount;
        if (i >= localUpdateOp.positionStart) {
          paramUpdateOp1.itemCount = (i - localUpdateOp.itemCount);
        }
      }
      i = paramUpdateOp1.positionStart;
      if (i >= paramUpdateOp2.positionStart) {
        paramUpdateOp1.positionStart = (i - paramUpdateOp2.itemCount);
      }
      i = paramUpdateOp1.itemCount;
      if (i >= paramUpdateOp2.positionStart) {
        paramUpdateOp1.itemCount = (i - paramUpdateOp2.itemCount);
      }
    }
    paramList.set(paramInt1, paramUpdateOp2);
    if (paramUpdateOp1.positionStart != paramUpdateOp1.itemCount) {
      paramList.set(paramInt2, paramUpdateOp1);
    } else {
      paramList.remove(paramInt2);
    }
    if (localUpdateOp != null) {
      paramList.add(paramInt1, localUpdateOp);
    }
  }
  
  void swapMoveUpdate(List<AdapterHelper.UpdateOp> paramList, int paramInt1, AdapterHelper.UpdateOp paramUpdateOp1, int paramInt2, AdapterHelper.UpdateOp paramUpdateOp2)
  {
    int i = paramUpdateOp1.itemCount;
    int j = paramUpdateOp2.positionStart;
    AdapterHelper.UpdateOp localUpdateOp1 = null;
    if (i < j)
    {
      paramUpdateOp2.positionStart = (j - 1);
    }
    else
    {
      k = paramUpdateOp2.itemCount;
      if (i < j + k)
      {
        paramUpdateOp2.itemCount = (k - 1);
        localUpdateOp2 = this.mCallback.obtainUpdateOp(4, paramUpdateOp1.positionStart, 1, paramUpdateOp2.payload);
        break label89;
      }
    }
    AdapterHelper.UpdateOp localUpdateOp2 = null;
    label89:
    j = paramUpdateOp1.positionStart;
    int k = paramUpdateOp2.positionStart;
    if (j <= k)
    {
      paramUpdateOp2.positionStart = (k + 1);
    }
    else
    {
      i = paramUpdateOp2.itemCount;
      if (j < k + i)
      {
        i = k + i - j;
        localUpdateOp1 = this.mCallback.obtainUpdateOp(4, j + 1, i, paramUpdateOp2.payload);
        paramUpdateOp2.itemCount -= i;
      }
    }
    paramList.set(paramInt2, paramUpdateOp1);
    if (paramUpdateOp2.itemCount > 0)
    {
      paramList.set(paramInt1, paramUpdateOp2);
    }
    else
    {
      paramList.remove(paramInt1);
      this.mCallback.recycleUpdateOp(paramUpdateOp2);
    }
    if (localUpdateOp2 != null) {
      paramList.add(paramInt1, localUpdateOp2);
    }
    if (localUpdateOp1 != null) {
      paramList.add(paramInt1, localUpdateOp1);
    }
  }
  
  static abstract interface Callback
  {
    public abstract AdapterHelper.UpdateOp obtainUpdateOp(int paramInt1, int paramInt2, int paramInt3, Object paramObject);
    
    public abstract void recycleUpdateOp(AdapterHelper.UpdateOp paramUpdateOp);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\recyclerview\widget\OpReorderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */