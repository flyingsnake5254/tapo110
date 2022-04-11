package com.google.common.collect;

public final class LinkedHashMultiset<E>
  extends f<E>
{
  LinkedHashMultiset(int paramInt)
  {
    super(paramInt);
  }
  
  public static <E> LinkedHashMultiset<E> create()
  {
    return create(3);
  }
  
  public static <E> LinkedHashMultiset<E> create(int paramInt)
  {
    return new LinkedHashMultiset(paramInt);
  }
  
  public static <E> LinkedHashMultiset<E> create(Iterable<? extends E> paramIterable)
  {
    LinkedHashMultiset localLinkedHashMultiset = create(v1.h(paramIterable));
    j1.a(localLinkedHashMultiset, paramIterable);
    return localLinkedHashMultiset;
  }
  
  void init(int paramInt)
  {
    this.backingMap = new z1(paramInt);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\LinkedHashMultiset.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */