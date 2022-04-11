package io.netty.handler.codec.http2;

final class HpackDynamicTable
{
  private long capacity = -1L;
  int head;
  HpackHeaderField[] hpackHeaderFields;
  private long size;
  int tail;
  
  HpackDynamicTable(long paramLong)
  {
    setCapacity(paramLong);
  }
  
  public void add(HpackHeaderField paramHpackHeaderField)
  {
    long l1 = paramHpackHeaderField.size();
    if (l1 > this.capacity)
    {
      clear();
      return;
    }
    long l3;
    for (;;)
    {
      long l2 = this.capacity;
      l3 = this.size;
      if (l2 - l3 >= l1) {
        break;
      }
      remove();
    }
    HpackHeaderField[] arrayOfHpackHeaderField = this.hpackHeaderFields;
    int i = this.head;
    this.head = (i + 1);
    arrayOfHpackHeaderField[i] = paramHpackHeaderField;
    this.size = (l3 + paramHpackHeaderField.size());
    if (this.head == this.hpackHeaderFields.length) {
      this.head = 0;
    }
  }
  
  public long capacity()
  {
    return this.capacity;
  }
  
  public void clear()
  {
    for (;;)
    {
      int i = this.tail;
      if (i == this.head) {
        break;
      }
      HpackHeaderField[] arrayOfHpackHeaderField = this.hpackHeaderFields;
      int j = i + 1;
      this.tail = j;
      arrayOfHpackHeaderField[i] = null;
      if (j == arrayOfHpackHeaderField.length) {
        this.tail = 0;
      }
    }
    this.head = 0;
    this.tail = 0;
    this.size = 0L;
  }
  
  public HpackHeaderField getEntry(int paramInt)
  {
    if ((paramInt > 0) && (paramInt <= length()))
    {
      paramInt = this.head - paramInt;
      if (paramInt < 0)
      {
        localObject = this.hpackHeaderFields;
        return localObject[(paramInt + localObject.length)];
      }
      return this.hpackHeaderFields[paramInt];
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Index ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" out of bounds for length ");
    ((StringBuilder)localObject).append(length());
    throw new IndexOutOfBoundsException(((StringBuilder)localObject).toString());
  }
  
  public int length()
  {
    int i = this.head;
    int j = this.tail;
    if (i < j) {
      i = this.hpackHeaderFields.length - j + i;
    } else {
      i -= j;
    }
    return i;
  }
  
  public HpackHeaderField remove()
  {
    HpackHeaderField localHpackHeaderField = this.hpackHeaderFields[this.tail];
    if (localHpackHeaderField == null) {
      return null;
    }
    this.size -= localHpackHeaderField.size();
    HpackHeaderField[] arrayOfHpackHeaderField = this.hpackHeaderFields;
    int i = this.tail;
    int j = i + 1;
    this.tail = j;
    arrayOfHpackHeaderField[i] = null;
    if (j == arrayOfHpackHeaderField.length) {
      this.tail = 0;
    }
    return localHpackHeaderField;
  }
  
  public void setCapacity(long paramLong)
  {
    boolean bool = paramLong < 0L;
    if ((!bool) && (paramLong <= 4294967295L))
    {
      if (this.capacity == paramLong) {
        return;
      }
      this.capacity = paramLong;
      if (!bool) {
        clear();
      } else {
        while (this.size > paramLong) {
          remove();
        }
      }
      int j = (int)(paramLong / 32L);
      bool = j;
      if (paramLong % 32L != 0L) {
        i = j + 1;
      }
      localObject = this.hpackHeaderFields;
      if ((localObject != null) && (localObject.length == i)) {
        return;
      }
      HpackHeaderField[] arrayOfHpackHeaderField = new HpackHeaderField[i];
      int k = length();
      int i = this.tail;
      for (j = 0; j < k; j++)
      {
        localObject = this.hpackHeaderFields;
        int m = i + 1;
        arrayOfHpackHeaderField[j] = localObject[i];
        if (m == localObject.length) {
          i = 0;
        } else {
          i = m;
        }
      }
      this.tail = 0;
      this.head = (0 + k);
      this.hpackHeaderFields = arrayOfHpackHeaderField;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("capacity is invalid: ");
    ((StringBuilder)localObject).append(paramLong);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public long size()
  {
    return this.size;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\io\netty\handler\codec\http2\HpackDynamicTable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */