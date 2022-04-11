package io.netty.util.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public final class RecyclableArrayList
  extends ArrayList<Object>
{
  private static final int DEFAULT_INITIAL_CAPACITY = 8;
  private static final ObjectPool<RecyclableArrayList> RECYCLER = ObjectPool.newPool(new ObjectPool.ObjectCreator()
  {
    public RecyclableArrayList newObject(ObjectPool.Handle<RecyclableArrayList> paramAnonymousHandle)
    {
      return new RecyclableArrayList(paramAnonymousHandle, null);
    }
  });
  private static final long serialVersionUID = -8605125654176467947L;
  private final ObjectPool.Handle<RecyclableArrayList> handle;
  private boolean insertSinceRecycled;
  
  private RecyclableArrayList(ObjectPool.Handle<RecyclableArrayList> paramHandle)
  {
    this(paramHandle, 8);
  }
  
  private RecyclableArrayList(ObjectPool.Handle<RecyclableArrayList> paramHandle, int paramInt)
  {
    super(paramInt);
    this.handle = paramHandle;
  }
  
  private static void checkNullElements(Collection<?> paramCollection)
  {
    int i;
    int j;
    if (((paramCollection instanceof RandomAccess)) && ((paramCollection instanceof List)))
    {
      paramCollection = (List)paramCollection;
      i = paramCollection.size();
      j = 0;
    }
    while (j < i) {
      if (paramCollection.get(j) != null)
      {
        j++;
      }
      else
      {
        throw new IllegalArgumentException("c contains null values");
        paramCollection = paramCollection.iterator();
        while (paramCollection.hasNext()) {
          if (paramCollection.next() == null) {
            throw new IllegalArgumentException("c contains null values");
          }
        }
      }
    }
  }
  
  public static RecyclableArrayList newInstance()
  {
    return newInstance(8);
  }
  
  public static RecyclableArrayList newInstance(int paramInt)
  {
    RecyclableArrayList localRecyclableArrayList = (RecyclableArrayList)RECYCLER.get();
    localRecyclableArrayList.ensureCapacity(paramInt);
    return localRecyclableArrayList;
  }
  
  public void add(int paramInt, Object paramObject)
  {
    super.add(paramInt, ObjectUtil.checkNotNull(paramObject, "element"));
    this.insertSinceRecycled = true;
  }
  
  public boolean add(Object paramObject)
  {
    if (super.add(ObjectUtil.checkNotNull(paramObject, "element")))
    {
      this.insertSinceRecycled = true;
      return true;
    }
    return false;
  }
  
  public boolean addAll(int paramInt, Collection<?> paramCollection)
  {
    checkNullElements(paramCollection);
    if (super.addAll(paramInt, paramCollection))
    {
      this.insertSinceRecycled = true;
      return true;
    }
    return false;
  }
  
  public boolean addAll(Collection<?> paramCollection)
  {
    checkNullElements(paramCollection);
    if (super.addAll(paramCollection))
    {
      this.insertSinceRecycled = true;
      return true;
    }
    return false;
  }
  
  public boolean insertSinceRecycled()
  {
    return this.insertSinceRecycled;
  }
  
  public boolean recycle()
  {
    clear();
    this.insertSinceRecycled = false;
    this.handle.recycle(this);
    return true;
  }
  
  public Object set(int paramInt, Object paramObject)
  {
    paramObject = super.set(paramInt, ObjectUtil.checkNotNull(paramObject, "element"));
    this.insertSinceRecycled = true;
    return paramObject;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\util\internal\RecyclableArrayList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */