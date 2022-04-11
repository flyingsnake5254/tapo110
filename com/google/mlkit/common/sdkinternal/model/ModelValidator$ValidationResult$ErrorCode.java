package com.google.mlkit.common.sdkinternal.model;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public enum ModelValidator$ValidationResult$ErrorCode
{
  static
  {
    ErrorCode localErrorCode1 = new ErrorCode("OK", 0);
    OK = localErrorCode1;
    ErrorCode localErrorCode2 = new ErrorCode("TFLITE_VERSION_INCOMPATIBLE", 1);
    TFLITE_VERSION_INCOMPATIBLE = localErrorCode2;
    ErrorCode localErrorCode3 = new ErrorCode("MODEL_FORMAT_INVALID", 2);
    MODEL_FORMAT_INVALID = localErrorCode3;
    zza = new ErrorCode[] { localErrorCode1, localErrorCode2, localErrorCode3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\common\sdkinternal\model\ModelValidator$ValidationResult$ErrorCode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */