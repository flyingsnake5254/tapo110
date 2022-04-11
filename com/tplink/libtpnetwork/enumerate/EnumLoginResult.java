package com.tplink.libtpnetwork.enumerate;

public enum EnumLoginResult
{
  static
  {
    EnumLoginResult localEnumLoginResult1 = new EnumLoginResult("CLOUD_SUCCESS", 0);
    CLOUD_SUCCESS = localEnumLoginResult1;
    EnumLoginResult localEnumLoginResult2 = new EnumLoginResult("LOCAL_SUCCESS", 1);
    LOCAL_SUCCESS = localEnumLoginResult2;
    EnumLoginResult localEnumLoginResult3 = new EnumLoginResult("FAIL", 2);
    FAIL = localEnumLoginResult3;
    $VALUES = new EnumLoginResult[] { localEnumLoginResult1, localEnumLoginResult2, localEnumLoginResult3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\tplink\libtpnetwork\enumerate\EnumLoginResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */