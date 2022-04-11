package com.google.mlkit.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;

public class MlKitException
  extends Exception
{
  public static final int ABORTED = 10;
  public static final int ALREADY_EXISTS = 6;
  public static final int CANCELLED = 1;
  public static final int DATA_LOSS = 15;
  public static final int DEADLINE_EXCEEDED = 4;
  public static final int FAILED_PRECONDITION = 9;
  public static final int INTERNAL = 13;
  public static final int INVALID_ARGUMENT = 3;
  public static final int MODEL_HASH_MISMATCH = 102;
  public static final int MODEL_INCOMPATIBLE_WITH_TFLITE = 100;
  public static final int NETWORK_ISSUE = 17;
  public static final int NOT_ENOUGH_SPACE = 101;
  public static final int NOT_FOUND = 5;
  public static final int OUT_OF_RANGE = 11;
  public static final int PERMISSION_DENIED = 7;
  public static final int RESOURCE_EXHAUSTED = 8;
  public static final int UNAUTHENTICATED = 16;
  public static final int UNAVAILABLE = 14;
  public static final int UNIMPLEMENTED = 12;
  public static final int UNKNOWN = 2;
  private final int zza;
  
  public MlKitException(@NonNull String paramString, int paramInt)
  {
    super(Preconditions.checkNotEmpty(paramString, "Provided message must not be empty."));
    this.zza = paramInt;
  }
  
  public MlKitException(@NonNull String paramString, int paramInt, @Nullable Throwable paramThrowable)
  {
    super(Preconditions.checkNotEmpty(paramString, "Provided message must not be empty."), paramThrowable);
    this.zza = paramInt;
  }
  
  public int getErrorCode()
  {
    return this.zza;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\mlkit\common\MlKitException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */