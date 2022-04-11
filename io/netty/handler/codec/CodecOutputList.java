package io.netty.handler.codec;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.internal.MathUtil;
import io.netty.util.internal.ObjectUtil;
import java.util.AbstractList;
import java.util.RandomAccess;

final class CodecOutputList
  extends AbstractList<Object>
  implements RandomAccess
{
  private static final FastThreadLocal<CodecOutputLists> CODEC_OUTPUT_LISTS_POOL = new FastThreadLocal()
  {
    protected CodecOutputList.CodecOutputLists initialValue()
      throws Exception
    {
      return new CodecOutputList.CodecOutputLists(16);
    }
  };
  private static final CodecOutputListRecycler NOOP_RECYCLER = new CodecOutputListRecycler()
  {
    public void recycle(CodecOutputList paramAnonymousCodecOutputList) {}
  };
  private Object[] array;
  private boolean insertSinceRecycled;
  private final CodecOutputListRecycler recycler;
  private int size;
  
  private CodecOutputList(CodecOutputListRecycler paramCodecOutputListRecycler, int paramInt)
  {
    this.recycler = paramCodecOutputListRecycler;
    this.array = new Object[paramInt];
  }
  
  private void checkIndex(int paramInt)
  {
    if (paramInt < this.size) {
      return;
    }
    throw new IndexOutOfBoundsException();
  }
  
  private void expandArray()
  {
    Object[] arrayOfObject1 = this.array;
    int i = arrayOfObject1.length << 1;
    if (i >= 0)
    {
      Object[] arrayOfObject2 = new Object[i];
      System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, arrayOfObject1.length);
      this.array = arrayOfObject2;
      return;
    }
    throw new OutOfMemoryError();
  }
  
  private void insert(int paramInt, Object paramObject)
  {
    this.array[paramInt] = paramObject;
    this.insertSinceRecycled = true;
  }
  
  static CodecOutputList newInstance()
  {
    return ((CodecOutputLists)CODEC_OUTPUT_LISTS_POOL.get()).getOrCreate();
  }
  
  public void add(int paramInt, Object paramObject)
  {
    ObjectUtil.checkNotNull(paramObject, "element");
    checkIndex(paramInt);
    if (this.size == this.array.length) {
      expandArray();
    }
    int i = this.size;
    if (paramInt != i)
    {
      Object[] arrayOfObject = this.array;
      System.arraycopy(arrayOfObject, paramInt, arrayOfObject, paramInt + 1, i - paramInt);
    }
    insert(paramInt, paramObject);
    this.size += 1;
  }
  
  public boolean add(Object paramObject)
  {
    ObjectUtil.checkNotNull(paramObject, "element");
    try
    {
      insert(this.size, paramObject);
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      expandArray();
      insert(this.size, paramObject);
    }
    this.size += 1;
    return true;
  }
  
  public void clear()
  {
    this.size = 0;
  }
  
  public Object get(int paramInt)
  {
    checkIndex(paramInt);
    return this.array[paramInt];
  }
  
  Object getUnsafe(int paramInt)
  {
    return this.array[paramInt];
  }
  
  boolean insertSinceRecycled()
  {
    return this.insertSinceRecycled;
  }
  
  void recycle()
  {
    for (int i = 0; i < this.size; i++) {
      this.array[i] = null;
    }
    this.size = 0;
    this.insertSinceRecycled = false;
    this.recycler.recycle(this);
  }
  
  public Object remove(int paramInt)
  {
    checkIndex(paramInt);
    Object[] arrayOfObject = this.array;
    Object localObject = arrayOfObject[paramInt];
    int i = this.size - paramInt - 1;
    if (i > 0) {
      System.arraycopy(arrayOfObject, paramInt + 1, arrayOfObject, paramInt, i);
    }
    arrayOfObject = this.array;
    paramInt = this.size - 1;
    this.size = paramInt;
    arrayOfObject[paramInt] = null;
    return localObject;
  }
  
  public Object set(int paramInt, Object paramObject)
  {
    ObjectUtil.checkNotNull(paramObject, "element");
    checkIndex(paramInt);
    Object localObject = this.array[paramInt];
    insert(paramInt, paramObject);
    return localObject;
  }
  
  public int size()
  {
    return this.size;
  }
  
  private static abstract interface CodecOutputListRecycler
  {
    public abstract void recycle(CodecOutputList paramCodecOutputList);
  }
  
  private static final class CodecOutputLists
    implements CodecOutputList.CodecOutputListRecycler
  {
    private int count;
    private int currentIdx;
    private final CodecOutputList[] elements;
    private final int mask;
    
    CodecOutputLists(int paramInt)
    {
      this.elements = new CodecOutputList[MathUtil.safeFindNextPositivePowerOfTwo(paramInt)];
      CodecOutputList[] arrayOfCodecOutputList;
      for (paramInt = 0;; paramInt++)
      {
        arrayOfCodecOutputList = this.elements;
        if (paramInt >= arrayOfCodecOutputList.length) {
          break;
        }
        arrayOfCodecOutputList[paramInt] = new CodecOutputList(this, 16, null);
      }
      this.count = arrayOfCodecOutputList.length;
      this.currentIdx = arrayOfCodecOutputList.length;
      this.mask = (arrayOfCodecOutputList.length - 1);
    }
    
    public CodecOutputList getOrCreate()
    {
      int i = this.count;
      if (i == 0) {
        return new CodecOutputList(CodecOutputList.NOOP_RECYCLER, 4, null);
      }
      this.count = (i - 1);
      i = this.currentIdx - 1 & this.mask;
      CodecOutputList localCodecOutputList = this.elements[i];
      this.currentIdx = i;
      return localCodecOutputList;
    }
    
    public void recycle(CodecOutputList paramCodecOutputList)
    {
      int i = this.currentIdx;
      this.elements[i] = paramCodecOutputList;
      this.currentIdx = (this.mask & i + 1);
      this.count += 1;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\CodecOutputList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */