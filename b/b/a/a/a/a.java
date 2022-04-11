package b.b.a.a.a;

import android.graphics.Bitmap;
import android.media.Image.Plane;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.mlkit_vision_common.zzcx;
import com.google.mlkit.common.sdkinternal.i;
import java.nio.ByteBuffer;
import javax.annotation.concurrent.Immutable;

@Immutable
public class a
  implements i
{
  @Nullable
  private volatile Bitmap a;
  @Nullable
  private volatile ByteBuffer b;
  @Nullable
  private volatile a c;
  private final int d;
  private final int e;
  private final int f;
  private final int g;
  
  private a(@NonNull ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    boolean bool;
    if ((paramInt4 != 842094169) && (paramInt4 != 17)) {
      bool = false;
    } else {
      bool = true;
    }
    Preconditions.checkArgument(bool);
    this.b = ((ByteBuffer)Preconditions.checkNotNull(paramByteBuffer));
    paramByteBuffer.rewind();
    this.d = paramInt1;
    this.e = paramInt2;
    this.f = paramInt3;
    this.g = paramInt4;
  }
  
  @NonNull
  public static a a(@NonNull ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    long l = SystemClock.elapsedRealtime();
    a locala = new a(paramByteBuffer, paramInt1, paramInt2, paramInt3, paramInt4);
    zzcx.zza(paramInt4, 3, l, paramInt2, paramInt1, paramByteBuffer.limit());
    return locala;
  }
  
  @Nullable
  @KeepForSdk
  public Bitmap b()
  {
    return this.a;
  }
  
  @Nullable
  @KeepForSdk
  public ByteBuffer c()
  {
    return this.b;
  }
  
  @KeepForSdk
  public int d()
  {
    return this.g;
  }
  
  @KeepForSdk
  public int e()
  {
    return this.e;
  }
  
  @Nullable
  @RequiresApi(19)
  @KeepForSdk
  public Image.Plane[] f()
  {
    if (this.c == null) {
      return null;
    }
    throw null;
  }
  
  @KeepForSdk
  public int g()
  {
    return this.f;
  }
  
  @KeepForSdk
  public int h()
  {
    return this.d;
  }
  
  static final class a {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\b\a\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */