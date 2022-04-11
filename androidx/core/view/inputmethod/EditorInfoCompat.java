package androidx.core.view.inputmethod;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.inputmethod.EditorInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class EditorInfoCompat
{
  private static final String CONTENT_MIME_TYPES_INTEROP_KEY = "android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
  private static final String CONTENT_MIME_TYPES_KEY = "androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES";
  private static final String[] EMPTY_STRING_ARRAY = new String[0];
  public static final int IME_FLAG_FORCE_ASCII = Integer.MIN_VALUE;
  public static final int IME_FLAG_NO_PERSONALIZED_LEARNING = 16777216;
  
  @NonNull
  public static String[] getContentMimeTypes(EditorInfo paramEditorInfo)
  {
    if (Build.VERSION.SDK_INT >= 25)
    {
      paramEditorInfo = paramEditorInfo.contentMimeTypes;
      if (paramEditorInfo == null) {
        paramEditorInfo = EMPTY_STRING_ARRAY;
      }
      return paramEditorInfo;
    }
    Object localObject = paramEditorInfo.extras;
    if (localObject == null) {
      return EMPTY_STRING_ARRAY;
    }
    String[] arrayOfString = ((Bundle)localObject).getStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
    localObject = arrayOfString;
    if (arrayOfString == null) {
      localObject = paramEditorInfo.extras.getStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
    }
    if (localObject == null) {
      localObject = EMPTY_STRING_ARRAY;
    }
    return (String[])localObject;
  }
  
  static int getProtocol(EditorInfo paramEditorInfo)
  {
    if (Build.VERSION.SDK_INT >= 25) {
      return 1;
    }
    Bundle localBundle = paramEditorInfo.extras;
    if (localBundle == null) {
      return 0;
    }
    boolean bool1 = localBundle.containsKey("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
    boolean bool2 = paramEditorInfo.extras.containsKey("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES");
    if ((bool1) && (bool2)) {
      return 4;
    }
    if (bool1) {
      return 3;
    }
    if (bool2) {
      return 2;
    }
    return 0;
  }
  
  public static void setContentMimeTypes(@NonNull EditorInfo paramEditorInfo, @Nullable String[] paramArrayOfString)
  {
    if (Build.VERSION.SDK_INT >= 25)
    {
      paramEditorInfo.contentMimeTypes = paramArrayOfString;
    }
    else
    {
      if (paramEditorInfo.extras == null) {
        paramEditorInfo.extras = new Bundle();
      }
      paramEditorInfo.extras.putStringArray("androidx.core.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", paramArrayOfString);
      paramEditorInfo.extras.putStringArray("android.support.v13.view.inputmethod.EditorInfoCompat.CONTENT_MIME_TYPES", paramArrayOfString);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\view\inputmethod\EditorInfoCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */