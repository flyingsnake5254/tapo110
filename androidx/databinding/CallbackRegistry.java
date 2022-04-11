package androidx.databinding;

import java.util.ArrayList;
import java.util.List;

public class CallbackRegistry<C, T, A>
  implements Cloneable
{
  private static final String TAG = "CallbackRegistry";
  private List<C> mCallbacks = new ArrayList();
  private long mFirst64Removed = 0L;
  private int mNotificationLevel;
  private final NotifierCallback<C, T, A> mNotifier;
  private long[] mRemainderRemoved;
  
  public CallbackRegistry(NotifierCallback<C, T, A> paramNotifierCallback)
  {
    this.mNotifier = paramNotifierCallback;
  }
  
  private boolean isRemoved(int paramInt)
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if (paramInt < 64)
    {
      if ((1L << paramInt & this.mFirst64Removed) == 0L) {
        bool2 = false;
      }
      return bool2;
    }
    long[] arrayOfLong = this.mRemainderRemoved;
    if (arrayOfLong == null) {
      return false;
    }
    int i = paramInt / 64 - 1;
    if (i >= arrayOfLong.length) {
      return false;
    }
    if ((1L << paramInt % 64 & arrayOfLong[i]) != 0L) {
      bool2 = bool1;
    } else {
      bool2 = false;
    }
    return bool2;
  }
  
  private void notifyCallbacks(T paramT, int paramInt1, A paramA, int paramInt2, int paramInt3, long paramLong)
  {
    long l = 1L;
    while (paramInt2 < paramInt3)
    {
      if ((paramLong & l) == 0L) {
        this.mNotifier.onNotifyCallback(this.mCallbacks.get(paramInt2), paramT, paramInt1, paramA);
      }
      l <<= 1;
      paramInt2++;
    }
  }
  
  private void notifyFirst64(T paramT, int paramInt, A paramA)
  {
    notifyCallbacks(paramT, paramInt, paramA, 0, Math.min(64, this.mCallbacks.size()), this.mFirst64Removed);
  }
  
  private void notifyRecurse(T paramT, int paramInt, A paramA)
  {
    int i = this.mCallbacks.size();
    long[] arrayOfLong = this.mRemainderRemoved;
    int j;
    if (arrayOfLong == null) {
      j = -1;
    } else {
      j = arrayOfLong.length - 1;
    }
    notifyRemainder(paramT, paramInt, paramA, j);
    notifyCallbacks(paramT, paramInt, paramA, (j + 2) * 64, i, 0L);
  }
  
  private void notifyRemainder(T paramT, int paramInt1, A paramA, int paramInt2)
  {
    if (paramInt2 < 0)
    {
      notifyFirst64(paramT, paramInt1, paramA);
    }
    else
    {
      long l = this.mRemainderRemoved[paramInt2];
      int i = (paramInt2 + 1) * 64;
      int j = Math.min(this.mCallbacks.size(), i + 64);
      notifyRemainder(paramT, paramInt1, paramA, paramInt2 - 1);
      notifyCallbacks(paramT, paramInt1, paramA, i, j, l);
    }
  }
  
  private void removeRemovedCallbacks(int paramInt, long paramLong)
  {
    int i = paramInt + 64 - 1;
    long l = Long.MIN_VALUE;
    while (i >= paramInt)
    {
      if ((paramLong & l) != 0L) {
        this.mCallbacks.remove(i);
      }
      l >>>= 1;
      i--;
    }
  }
  
  private void setRemovalBit(int paramInt)
  {
    if (paramInt < 64)
    {
      this.mFirst64Removed = (1L << paramInt | this.mFirst64Removed);
    }
    else
    {
      int i = paramInt / 64 - 1;
      long[] arrayOfLong1 = this.mRemainderRemoved;
      if (arrayOfLong1 == null)
      {
        this.mRemainderRemoved = new long[this.mCallbacks.size() / 64];
      }
      else if (arrayOfLong1.length <= i)
      {
        long[] arrayOfLong2 = new long[this.mCallbacks.size() / 64];
        arrayOfLong1 = this.mRemainderRemoved;
        System.arraycopy(arrayOfLong1, 0, arrayOfLong2, 0, arrayOfLong1.length);
        this.mRemainderRemoved = arrayOfLong2;
      }
      arrayOfLong1 = this.mRemainderRemoved;
      arrayOfLong1[i] = (1L << paramInt % 64 | arrayOfLong1[i]);
    }
  }
  
  public void add(C paramC)
  {
    if (paramC != null) {
      try
      {
        int i = this.mCallbacks.lastIndexOf(paramC);
        if ((i < 0) || (isRemoved(i))) {
          this.mCallbacks.add(paramC);
        }
        return;
      }
      finally
      {
        break label59;
      }
    }
    paramC = new java/lang/IllegalArgumentException;
    paramC.<init>("callback cannot be null");
    throw paramC;
    label59:
    throw paramC;
  }
  
  public void clear()
  {
    try
    {
      if (this.mNotificationLevel == 0) {
        this.mCallbacks.clear();
      } else if (!this.mCallbacks.isEmpty()) {
        for (int i = this.mCallbacks.size() - 1; i >= 0; i--) {
          setRemovalBit(i);
        }
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public CallbackRegistry<C, T, A> clone()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokespecial 135	java/lang/Object:clone	()Ljava/lang/Object;
    //   6: checkcast 2	androidx/databinding/CallbackRegistry
    //   9: astore_1
    //   10: aload_1
    //   11: lconst_0
    //   12: putfield 38	androidx/databinding/CallbackRegistry:mFirst64Removed	J
    //   15: aload_1
    //   16: aconst_null
    //   17: putfield 47	androidx/databinding/CallbackRegistry:mRemainderRemoved	[J
    //   20: iconst_0
    //   21: istore_2
    //   22: aload_1
    //   23: iconst_0
    //   24: putfield 120	androidx/databinding/CallbackRegistry:mNotificationLevel	I
    //   27: new 33	java/util/ArrayList
    //   30: astore_3
    //   31: aload_3
    //   32: invokespecial 34	java/util/ArrayList:<init>	()V
    //   35: aload_1
    //   36: aload_3
    //   37: putfield 36	androidx/databinding/CallbackRegistry:mCallbacks	Ljava/util/List;
    //   40: aload_0
    //   41: getfield 36	androidx/databinding/CallbackRegistry:mCallbacks	Ljava/util/List;
    //   44: invokeinterface 66 1 0
    //   49: istore 4
    //   51: aload_1
    //   52: astore_3
    //   53: iload_2
    //   54: iload 4
    //   56: if_icmpge +54 -> 110
    //   59: aload_0
    //   60: iload_2
    //   61: invokespecial 106	androidx/databinding/CallbackRegistry:isRemoved	(I)Z
    //   64: ifne +23 -> 87
    //   67: aload_1
    //   68: getfield 36	androidx/databinding/CallbackRegistry:mCallbacks	Ljava/util/List;
    //   71: aload_0
    //   72: getfield 36	androidx/databinding/CallbackRegistry:mCallbacks	Ljava/util/List;
    //   75: iload_2
    //   76: invokeinterface 55 2 0
    //   81: invokeinterface 109 2 0
    //   86: pop
    //   87: iinc 2 1
    //   90: goto -39 -> 51
    //   93: astore_3
    //   94: goto +10 -> 104
    //   97: astore_1
    //   98: goto +16 -> 114
    //   101: astore_3
    //   102: aconst_null
    //   103: astore_1
    //   104: aload_3
    //   105: invokevirtual 138	java/lang/CloneNotSupportedException:printStackTrace	()V
    //   108: aload_1
    //   109: astore_3
    //   110: aload_0
    //   111: monitorexit
    //   112: aload_3
    //   113: areturn
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_1
    //   117: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	118	0	this	CallbackRegistry
    //   9	59	1	localCallbackRegistry	CallbackRegistry
    //   97	1	1	localObject1	Object
    //   103	14	1	localObject2	Object
    //   21	67	2	i	int
    //   30	23	3	localObject3	Object
    //   93	1	3	localCloneNotSupportedException1	CloneNotSupportedException
    //   101	4	3	localCloneNotSupportedException2	CloneNotSupportedException
    //   109	4	3	localObject4	Object
    //   49	8	4	j	int
    // Exception table:
    //   from	to	target	type
    //   10	20	93	java/lang/CloneNotSupportedException
    //   22	51	93	java/lang/CloneNotSupportedException
    //   59	87	93	java/lang/CloneNotSupportedException
    //   2	10	97	finally
    //   10	20	97	finally
    //   22	51	97	finally
    //   59	87	97	finally
    //   104	108	97	finally
    //   2	10	101	java/lang/CloneNotSupportedException
  }
  
  public ArrayList<C> copyCallbacks()
  {
    try
    {
      ArrayList localArrayList = new java/util/ArrayList;
      localArrayList.<init>(this.mCallbacks.size());
      int i = this.mCallbacks.size();
      for (int j = 0; j < i; j++) {
        if (!isRemoved(j)) {
          localArrayList.add(this.mCallbacks.get(j));
        }
      }
      return localArrayList;
    }
    finally {}
  }
  
  public void copyCallbacks(List<C> paramList)
  {
    try
    {
      paramList.clear();
      int i = this.mCallbacks.size();
      for (int j = 0; j < i; j++) {
        if (!isRemoved(j)) {
          paramList.add(this.mCallbacks.get(j));
        }
      }
      return;
    }
    finally {}
  }
  
  public boolean isEmpty()
  {
    try
    {
      boolean bool = this.mCallbacks.isEmpty();
      if (bool) {
        return true;
      }
      int i = this.mNotificationLevel;
      if (i == 0) {
        return false;
      }
      int j = this.mCallbacks.size();
      for (i = 0; i < j; i++)
      {
        bool = isRemoved(i);
        if (!bool) {
          return false;
        }
      }
      return true;
    }
    finally {}
  }
  
  public void notifyCallbacks(T paramT, int paramInt, A paramA)
  {
    try
    {
      this.mNotificationLevel += 1;
      notifyRecurse(paramT, paramInt, paramA);
      paramInt = this.mNotificationLevel - 1;
      this.mNotificationLevel = paramInt;
      if (paramInt == 0)
      {
        paramT = this.mRemainderRemoved;
        if (paramT != null) {
          for (paramInt = paramT.length - 1; paramInt >= 0; paramInt--)
          {
            l = this.mRemainderRemoved[paramInt];
            if (l != 0L)
            {
              removeRemovedCallbacks((paramInt + 1) * 64, l);
              this.mRemainderRemoved[paramInt] = 0L;
            }
          }
        }
        long l = this.mFirst64Removed;
        if (l != 0L)
        {
          removeRemovedCallbacks(0, l);
          this.mFirst64Removed = 0L;
        }
      }
      return;
    }
    finally {}
  }
  
  public void remove(C paramC)
  {
    try
    {
      if (this.mNotificationLevel == 0)
      {
        this.mCallbacks.remove(paramC);
      }
      else
      {
        int i = this.mCallbacks.lastIndexOf(paramC);
        if (i >= 0) {
          setRemovalBit(i);
        }
      }
      return;
    }
    finally {}
  }
  
  public static abstract class NotifierCallback<C, T, A>
  {
    public abstract void onNotifyCallback(C paramC, T paramT, int paramInt, A paramA);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\CallbackRegistry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */