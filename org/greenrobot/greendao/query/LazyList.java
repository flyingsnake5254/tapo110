package org.greenrobot.greendao.query;

import android.database.Cursor;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.concurrent.locks.ReentrantLock;
import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.InternalQueryDaoAccess;

public class LazyList<E>
  implements List<E>, Closeable
{
  private final Cursor cursor;
  private final InternalQueryDaoAccess<E> daoAccess;
  private final List<E> entities;
  private volatile int loadedCount;
  private final ReentrantLock lock;
  private final int size;
  
  LazyList(InternalQueryDaoAccess<E> paramInternalQueryDaoAccess, Cursor paramCursor, boolean paramBoolean)
  {
    this.cursor = paramCursor;
    this.daoAccess = paramInternalQueryDaoAccess;
    int i = paramCursor.getCount();
    this.size = i;
    if (paramBoolean)
    {
      this.entities = new ArrayList(i);
      for (i = 0; i < this.size; i++) {
        this.entities.add(null);
      }
    }
    this.entities = null;
    if (this.size == 0) {
      paramCursor.close();
    }
    this.lock = new ReentrantLock();
  }
  
  public void add(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean add(E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(int paramInt, Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean addAll(Collection<? extends E> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  protected void checkCached()
  {
    if (this.entities != null) {
      return;
    }
    throw new DaoException("This operation only works with cached lazy lists");
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public void close()
  {
    this.cursor.close();
  }
  
  public boolean contains(Object paramObject)
  {
    loadRemaining();
    return this.entities.contains(paramObject);
  }
  
  public boolean containsAll(Collection<?> paramCollection)
  {
    loadRemaining();
    return this.entities.containsAll(paramCollection);
  }
  
  public E get(int paramInt)
  {
    Object localObject1 = this.entities;
    if (localObject1 != null)
    {
      Object localObject4 = ((List)localObject1).get(paramInt);
      localObject1 = localObject4;
      if (localObject4 == null)
      {
        this.lock.lock();
        try
        {
          localObject4 = this.entities.get(paramInt);
          localObject1 = localObject4;
          if (localObject4 == null)
          {
            localObject4 = loadEntity(paramInt);
            this.entities.set(paramInt, localObject4);
            this.loadedCount += 1;
            localObject1 = localObject4;
            if (this.loadedCount == this.size)
            {
              this.cursor.close();
              localObject1 = localObject4;
            }
          }
        }
        finally
        {
          this.lock.unlock();
        }
      }
      return ?;
    }
    this.lock.lock();
    try
    {
      Object localObject2 = loadEntity(paramInt);
      return (E)localObject2;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  public int getLoadedCount()
  {
    return this.loadedCount;
  }
  
  public int indexOf(Object paramObject)
  {
    loadRemaining();
    return this.entities.indexOf(paramObject);
  }
  
  public boolean isClosed()
  {
    return this.cursor.isClosed();
  }
  
  public boolean isEmpty()
  {
    boolean bool;
    if (this.size == 0) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isLoadedCompletely()
  {
    boolean bool;
    if (this.loadedCount == this.size) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public Iterator<E> iterator()
  {
    return new LazyIterator(0, false);
  }
  
  public int lastIndexOf(Object paramObject)
  {
    loadRemaining();
    return this.entities.lastIndexOf(paramObject);
  }
  
  public ListIterator<E> listIterator(int paramInt)
  {
    return new LazyIterator(paramInt, false);
  }
  
  public CloseableListIterator<E> listIterator()
  {
    return new LazyIterator(0, false);
  }
  
  public CloseableListIterator<E> listIteratorAutoClose()
  {
    return new LazyIterator(0, true);
  }
  
  protected E loadEntity(int paramInt)
  {
    if (this.cursor.moveToPosition(paramInt))
    {
      localObject = this.daoAccess.loadCurrent(this.cursor, 0, true);
      if (localObject != null) {
        return (E)localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Loading of entity failed (null) at position ");
      ((StringBuilder)localObject).append(paramInt);
      throw new DaoException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Could not move to cursor location ");
    ((StringBuilder)localObject).append(paramInt);
    throw new DaoException(((StringBuilder)localObject).toString());
  }
  
  public void loadRemaining()
  {
    checkCached();
    int i = this.entities.size();
    for (int j = 0; j < i; j++) {
      get(j);
    }
  }
  
  public E peek(int paramInt)
  {
    List localList = this.entities;
    if (localList != null) {
      return (E)localList.get(paramInt);
    }
    return null;
  }
  
  public E remove(int paramInt)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean remove(Object paramObject)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean removeAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean retainAll(Collection<?> paramCollection)
  {
    throw new UnsupportedOperationException();
  }
  
  public E set(int paramInt, E paramE)
  {
    throw new UnsupportedOperationException();
  }
  
  public int size()
  {
    return this.size;
  }
  
  public List<E> subList(int paramInt1, int paramInt2)
  {
    checkCached();
    for (int i = paramInt1; i < paramInt2; i++) {
      get(i);
    }
    return this.entities.subList(paramInt1, paramInt2);
  }
  
  public Object[] toArray()
  {
    loadRemaining();
    return this.entities.toArray();
  }
  
  public <T> T[] toArray(T[] paramArrayOfT)
  {
    loadRemaining();
    return this.entities.toArray(paramArrayOfT);
  }
  
  protected class LazyIterator
    implements CloseableListIterator<E>
  {
    private final boolean closeWhenDone;
    private int index;
    
    public LazyIterator(int paramInt, boolean paramBoolean)
    {
      this.index = paramInt;
      this.closeWhenDone = paramBoolean;
    }
    
    public void add(E paramE)
    {
      throw new UnsupportedOperationException();
    }
    
    public void close()
    {
      LazyList.this.close();
    }
    
    public boolean hasNext()
    {
      boolean bool;
      if (this.index < LazyList.this.size) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public boolean hasPrevious()
    {
      boolean bool;
      if (this.index > 0) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    
    public E next()
    {
      if (this.index < LazyList.this.size)
      {
        Object localObject = LazyList.this.get(this.index);
        int i = this.index + 1;
        this.index = i;
        if ((i == LazyList.this.size) && (this.closeWhenDone)) {
          close();
        }
        return (E)localObject;
      }
      throw new NoSuchElementException();
    }
    
    public int nextIndex()
    {
      return this.index;
    }
    
    public E previous()
    {
      int i = this.index;
      if (i > 0)
      {
        i--;
        this.index = i;
        return (E)LazyList.this.get(i);
      }
      throw new NoSuchElementException();
    }
    
    public int previousIndex()
    {
      return this.index - 1;
    }
    
    public void remove()
    {
      throw new UnsupportedOperationException();
    }
    
    public void set(E paramE)
    {
      throw new UnsupportedOperationException();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\greenrobot\greendao\query\LazyList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */