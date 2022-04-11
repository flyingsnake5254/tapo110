package com.tplink.ata.common;

import com.google.gson.q.c;

public enum ATATransferType
{
  static
  {
    ATATransferType localATATransferType1 = new ATATransferType("P2P", 0);
    P2P = localATATransferType1;
    ATATransferType localATATransferType2 = new ATATransferType("NAS", 1);
    NAS = localATATransferType2;
    ATATransferType localATATransferType3 = new ATATransferType("TMP", 2);
    TMP = localATATransferType3;
    $VALUES = new ATATransferType[] { localATATransferType1, localATATransferType2, localATATransferType3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\ata\common\ATATransferType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */