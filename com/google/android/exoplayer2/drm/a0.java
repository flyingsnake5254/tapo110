package com.google.android.exoplayer2.drm;

import android.media.DeniedByServerException;
import android.media.MediaDrm.MediaDrmStateException;
import android.media.MediaDrmResetException;
import android.media.NotProvisionedException;
import androidx.annotation.DoNotInline;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.o0;
import com.google.android.exoplayer2.w0;

public final class a0
{
  public static int a(Exception paramException, int paramInt)
  {
    int i = o0.a;
    if ((i >= 21) && (b.a(paramException))) {
      return b.b(paramException);
    }
    if ((i >= 23) && (c.a(paramException))) {
      return 6006;
    }
    if ((i >= 18) && (a.b(paramException))) {
      return 6002;
    }
    if ((i >= 18) && (a.a(paramException))) {
      return 6007;
    }
    if ((paramException instanceof UnsupportedDrmException)) {
      return 6001;
    }
    if ((paramException instanceof DefaultDrmSessionManager.MissingSchemeDataException)) {
      return 6003;
    }
    if ((paramException instanceof KeysExpiredException)) {
      return 6008;
    }
    if (paramInt == 1) {
      return 6006;
    }
    if (paramInt == 2) {
      return 6004;
    }
    if (paramInt == 3) {
      return 6002;
    }
    throw new IllegalArgumentException();
  }
  
  @RequiresApi(18)
  private static final class a
  {
    @DoNotInline
    public static boolean a(@Nullable Throwable paramThrowable)
    {
      return paramThrowable instanceof DeniedByServerException;
    }
    
    @DoNotInline
    public static boolean b(@Nullable Throwable paramThrowable)
    {
      return paramThrowable instanceof NotProvisionedException;
    }
  }
  
  @RequiresApi(21)
  private static final class b
  {
    @DoNotInline
    public static boolean a(@Nullable Throwable paramThrowable)
    {
      return paramThrowable instanceof MediaDrm.MediaDrmStateException;
    }
    
    @DoNotInline
    public static int b(Throwable paramThrowable)
    {
      return w0.b(o0.P(((MediaDrm.MediaDrmStateException)paramThrowable).getDiagnosticInfo()));
    }
  }
  
  @RequiresApi(23)
  private static final class c
  {
    @DoNotInline
    public static boolean a(@Nullable Throwable paramThrowable)
    {
      return paramThrowable instanceof MediaDrmResetException;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\exoplayer2\drm\a0.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */