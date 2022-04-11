package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.j;

public final class IconKt
{
  @RequiresApi(26)
  public static final Icon toAdaptiveIcon(Bitmap paramBitmap)
  {
    j.f(paramBitmap, "$this$toAdaptiveIcon");
    paramBitmap = Icon.createWithAdaptiveBitmap(paramBitmap);
    j.b(paramBitmap, "Icon.createWithAdaptiveBitmap(this)");
    return paramBitmap;
  }
  
  @RequiresApi(26)
  public static final Icon toIcon(Bitmap paramBitmap)
  {
    j.f(paramBitmap, "$this$toIcon");
    paramBitmap = Icon.createWithBitmap(paramBitmap);
    j.b(paramBitmap, "Icon.createWithBitmap(this)");
    return paramBitmap;
  }
  
  @RequiresApi(26)
  public static final Icon toIcon(Uri paramUri)
  {
    j.f(paramUri, "$this$toIcon");
    paramUri = Icon.createWithContentUri(paramUri);
    j.b(paramUri, "Icon.createWithContentUri(this)");
    return paramUri;
  }
  
  @RequiresApi(26)
  public static final Icon toIcon(byte[] paramArrayOfByte)
  {
    j.f(paramArrayOfByte, "$this$toIcon");
    paramArrayOfByte = Icon.createWithData(paramArrayOfByte, 0, paramArrayOfByte.length);
    j.b(paramArrayOfByte, "Icon.createWithData(this, 0, size)");
    return paramArrayOfByte;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\graphics\drawable\IconKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */