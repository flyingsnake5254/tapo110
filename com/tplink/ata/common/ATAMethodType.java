package com.tplink.ata.common;

import com.google.gson.q.c;

public enum ATAMethodType
{
  static
  {
    ATAMethodType localATAMethodType1 = new ATAMethodType("CONNECT", 0);
    CONNECT = localATAMethodType1;
    ATAMethodType localATAMethodType2 = new ATAMethodType("TRANSFER", 1);
    TRANSFER = localATAMethodType2;
    ATAMethodType localATAMethodType3 = new ATAMethodType("DISCONNECT", 2);
    DISCONNECT = localATAMethodType3;
    ATAMethodType localATAMethodType4 = new ATAMethodType("TEST", 3);
    TEST = localATAMethodType4;
    $VALUES = new ATAMethodType[] { localATAMethodType1, localATAMethodType2, localATAMethodType3, localATAMethodType4 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\ata\common\ATAMethodType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */