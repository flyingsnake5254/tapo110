package com.google.common.collect;

public enum BoundType
{
  final boolean inclusive;
  
  static
  {
    BoundType localBoundType1 = new BoundType("OPEN", 0, false);
    OPEN = localBoundType1;
    BoundType localBoundType2 = new BoundType("CLOSED", 1, true);
    CLOSED = localBoundType2;
    $VALUES = new BoundType[] { localBoundType1, localBoundType2 };
  }
  
  private BoundType(boolean paramBoolean)
  {
    this.inclusive = paramBoolean;
  }
  
  static BoundType forBoolean(boolean paramBoolean)
  {
    BoundType localBoundType;
    if (paramBoolean) {
      localBoundType = CLOSED;
    } else {
      localBoundType = OPEN;
    }
    return localBoundType;
  }
  
  BoundType flip()
  {
    return forBoolean(this.inclusive ^ true);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\common\collect\BoundType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */