package com.google.common.collect;

public class HashMultiset<E>
  extends f<E>
{
  private static final long serialVersionUID = 0L;
  
  HashMultiset(int paramInt)
  {
    super(paramInt);
  }
  
  public static <E> HashMultiset<E> create()
  {
    return create(3);
  }
  
  public static <E> HashMultiset<E> create(int paramInt)
  {
    return new HashMultiset(paramInt);
  }
  
  public static <E> HashMultiset<E> create(Iterable<? extends E> paramIterable)
  {
    HashMultiset localHashMultiset = create(v1.h(paramIterable));
    j1.a(localHashMultiset, paramIterable);
    return localHashMultiset;
  }
  
  void init(int paramInt)
  {
    this.backingMap = new y1(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\HashMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */