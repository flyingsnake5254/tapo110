package com.google.mlkit.common.sdkinternal.model;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public enum BaseModel
{
  static
  {
    BaseModel localBaseModel1 = new BaseModel("FACE_DETECTION", 0);
    zza = localBaseModel1;
    BaseModel localBaseModel2 = new BaseModel("SMART_REPLY", 1);
    zzb = localBaseModel2;
    BaseModel localBaseModel3 = new BaseModel("TRANSLATE", 2);
    TRANSLATE = localBaseModel3;
    BaseModel localBaseModel4 = new BaseModel("ENTITY_EXTRACTION", 3);
    ENTITY_EXTRACTION = localBaseModel4;
    zzc = new BaseModel[] { localBaseModel1, localBaseModel2, localBaseModel3, localBaseModel4 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\common\sdkinternal\model\BaseModel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */