package com.tplink.iot.cloud.enumerate;

public enum StateValueDataType
{
  static
  {
    StateValueDataType localStateValueDataType1 = new StateValueDataType("INT", 0);
    INT = localStateValueDataType1;
    StateValueDataType localStateValueDataType2 = new StateValueDataType("LONG", 1);
    LONG = localStateValueDataType2;
    StateValueDataType localStateValueDataType3 = new StateValueDataType("FLOAT", 2);
    FLOAT = localStateValueDataType3;
    StateValueDataType localStateValueDataType4 = new StateValueDataType("DOUBLE", 3);
    DOUBLE = localStateValueDataType4;
    StateValueDataType localStateValueDataType5 = new StateValueDataType("STRING", 4);
    STRING = localStateValueDataType5;
    StateValueDataType localStateValueDataType6 = new StateValueDataType("BOOL", 5);
    BOOL = localStateValueDataType6;
    $VALUES = new StateValueDataType[] { localStateValueDataType1, localStateValueDataType2, localStateValueDataType3, localStateValueDataType4, localStateValueDataType5, localStateValueDataType6 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\iot\cloud\enumerate\StateValueDataType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */