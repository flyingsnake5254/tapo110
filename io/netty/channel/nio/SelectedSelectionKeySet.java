package io.netty.channel.nio;

import java.nio.channels.SelectionKey;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class SelectedSelectionKeySet
  extends AbstractSet<SelectionKey>
{
  SelectionKey[] keys = new SelectionKey['Ѐ'];
  int size;
  
  private void increaseCapacity()
  {
    SelectionKey[] arrayOfSelectionKey1 = this.keys;
    SelectionKey[] arrayOfSelectionKey2 = new SelectionKey[arrayOfSelectionKey1.length << 1];
    System.arraycopy(arrayOfSelectionKey1, 0, arrayOfSelectionKey2, 0, this.size);
    this.keys = arrayOfSelectionKey2;
  }
  
  public boolean add(SelectionKey paramSelectionKey)
  {
    if (paramSelectionKey == null) {
      return false;
    }
    SelectionKey[] arrayOfSelectionKey = this.keys;
    int i = this.size;
    int j = i + 1;
    this.size = j;
    arrayOfSelectionKey[i] = paramSelectionKey;
    if (j == arrayOfSelectionKey.length) {
      increaseCapacity();
    }
    return true;
  }
  
  public boolean contains(Object paramObject)
  {
    return false;
  }
  
  public Iterator<SelectionKey> iterator()
  {
    new Iterator()
    {
      private int idx;
      
      public boolean hasNext()
      {
        boolean bool;
        if (this.idx < SelectedSelectionKeySet.this.size) {
          bool = true;
        } else {
          bool = false;
        }
        return bool;
      }
      
      public SelectionKey next()
      {
        if (hasNext())
        {
          SelectionKey[] arrayOfSelectionKey = SelectedSelectionKeySet.this.keys;
          int i = this.idx;
          this.idx = (i + 1);
          return arrayOfSelectionKey[i];
        }
        throw new NoSuchElementException();
      }
      
      public void remove()
      {
        throw new UnsupportedOperationException();
      }
    };
  }
  
  public boolean remove(Object paramObject)
  {
    return false;
  }
  
  void reset()
  {
    reset(0);
  }
  
  void reset(int paramInt)
  {
    Arrays.fill(this.keys, paramInt, this.size, null);
    this.size = 0;
  }
  
  public int size()
  {
    return this.size;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\channel\nio\SelectedSelectionKeySet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */