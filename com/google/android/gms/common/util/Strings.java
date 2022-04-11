package com.google.android.gms.common.util;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.regex.Pattern;

@KeepForSdk
@VisibleForTesting
public class Strings
{
  private static final Pattern zzhh = Pattern.compile("\\$\\{(.*?)\\}");
  
  @Nullable
  @KeepForSdk
  public static String emptyToNull(@Nullable String paramString)
  {
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = null;
    }
    return str;
  }
  
  @KeepForSdk
  public static boolean isEmptyOrWhitespace(@Nullable String paramString)
  {
    return (paramString == null) || (paramString.trim().isEmpty());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\common\util\Strings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */