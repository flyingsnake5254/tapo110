package com.google.mlkit.common.sdkinternal;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public enum ModelType
{
  static
  {
    ModelType localModelType1 = new ModelType("UNKNOWN", 0);
    UNKNOWN = localModelType1;
    ModelType localModelType2 = new ModelType("BASE", 1);
    BASE = localModelType2;
    ModelType localModelType3 = new ModelType("AUTOML", 2);
    AUTOML = localModelType3;
    ModelType localModelType4 = new ModelType("TRANSLATE", 3);
    TRANSLATE = localModelType4;
    ModelType localModelType5 = new ModelType("ENTITY_EXTRACTION", 4);
    ENTITY_EXTRACTION = localModelType5;
    zza = new ModelType[] { localModelType1, localModelType2, localModelType3, localModelType4, localModelType5 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\common\sdkinternal\ModelType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */