package com.tplink.libtpnetwork.cameranetwork.bean.listing;

public enum Operation
{
  static
  {
    Operation localOperation1 = new Operation("EQ", 0);
    EQ = localOperation1;
    Operation localOperation2 = new Operation("GE", 1);
    GE = localOperation2;
    Operation localOperation3 = new Operation("LE", 2);
    LE = localOperation3;
    Operation localOperation4 = new Operation("GT", 3);
    GT = localOperation4;
    Operation localOperation5 = new Operation("LT", 4);
    LT = localOperation5;
    Operation localOperation6 = new Operation("CONTAINS", 5);
    CONTAINS = localOperation6;
    Operation localOperation7 = new Operation("STARTSWITH", 6);
    STARTSWITH = localOperation7;
    Operation localOperation8 = new Operation("ENDSWITH", 7);
    ENDSWITH = localOperation8;
    Operation localOperation9 = new Operation("IN", 8);
    IN = localOperation9;
    Operation localOperation10 = new Operation("NOTIN", 9);
    NOTIN = localOperation10;
    $VALUES = new Operation[] { localOperation1, localOperation2, localOperation3, localOperation4, localOperation5, localOperation6, localOperation7, localOperation8, localOperation9, localOperation10 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\cameranetwork\bean\listing\Operation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */