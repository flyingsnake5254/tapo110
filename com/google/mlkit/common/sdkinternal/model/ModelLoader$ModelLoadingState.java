package com.google.mlkit.common.sdkinternal.model;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public enum ModelLoader$ModelLoadingState
{
  static
  {
    ModelLoadingState localModelLoadingState1 = new ModelLoadingState("NO_MODEL_LOADED", 0);
    NO_MODEL_LOADED = localModelLoadingState1;
    ModelLoadingState localModelLoadingState2 = new ModelLoadingState("REMOTE_MODEL_LOADED", 1);
    REMOTE_MODEL_LOADED = localModelLoadingState2;
    ModelLoadingState localModelLoadingState3 = new ModelLoadingState("LOCAL_MODEL_LOADED", 2);
    LOCAL_MODEL_LOADED = localModelLoadingState3;
    zza = new ModelLoadingState[] { localModelLoadingState1, localModelLoadingState2, localModelLoadingState3 };
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\common\sdkinternal\model\ModelLoader$ModelLoadingState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */