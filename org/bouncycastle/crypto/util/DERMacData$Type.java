package org.bouncycastle.crypto.util;

import org.bouncycastle.util.i;

public enum DERMacData$Type
{
  private final String enc;
  
  static
  {
    Type localType1 = new Type("UNILATERALU", 0, "KC_1_U");
    UNILATERALU = localType1;
    Type localType2 = new Type("UNILATERALV", 1, "KC_1_V");
    UNILATERALV = localType2;
    Type localType3 = new Type("BILATERALU", 2, "KC_2_U");
    BILATERALU = localType3;
    Type localType4 = new Type("BILATERALV", 3, "KC_2_V");
    BILATERALV = localType4;
    $VALUES = new Type[] { localType1, localType2, localType3, localType4 };
  }
  
  private DERMacData$Type(String paramString)
  {
    this.enc = paramString;
  }
  
  public byte[] getHeader()
  {
    return i.e(this.enc);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\bouncycastle\crypto\util\DERMacData$Type.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */