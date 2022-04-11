package com.tplink.iot.cloud.enumerate;

public enum StateOperator
{
  static
  {
    StateOperator localStateOperator1 = new StateOperator("EQ", 0);
    EQ = localStateOperator1;
    StateOperator localStateOperator2 = new StateOperator("NE", 1);
    NE = localStateOperator2;
    StateOperator localStateOperator3 = new StateOperator("CONTAINS", 2);
    CONTAINS = localStateOperator3;
    StateOperator localStateOperator4 = new StateOperator("START_WITH", 3);
    START_WITH = localStateOperator4;
    StateOperator localStateOperator5 = new StateOperator("ENDS_WITH", 4);
    ENDS_WITH = localStateOperator5;
    StateOperator localStateOperator6 = new StateOperator("REGEX", 5);
    REGEX = localStateOperator6;
    StateOperator localStateOperator7 = new StateOperator("BETWEEN", 6);
    BETWEEN = localStateOperator7;
    StateOperator localStateOperator8 = new StateOperator("NOT_BETWEEN", 7);
    NOT_BETWEEN = localStateOperator8;
    StateOperator localStateOperator9 = new StateOperator("IN", 8);
    IN = localStateOperator9;
    StateOperator localStateOperator10 = new StateOperator("NOT_IN", 9);
    NOT_IN = localStateOperator10;
    StateOperator localStateOperator11 = new StateOperator("GT", 10);
    GT = localStateOperator11;
    StateOperator localStateOperator12 = new StateOperator("GE", 11);
    GE = localStateOperator12;
    StateOperator localStateOperator13 = new StateOperator("LT", 12);
    LT = localStateOperator13;
    StateOperator localStateOperator14 = new StateOperator("LE", 13);
    LE = localStateOperator14;
    $VALUES = new StateOperator[] { localStateOperator1, localStateOperator2, localStateOperator3, localStateOperator4, localStateOperator5, localStateOperator6, localStateOperator7, localStateOperator8, localStateOperator9, localStateOperator10, localStateOperator11, localStateOperator12, localStateOperator13, localStateOperator14 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\enumerate\StateOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */