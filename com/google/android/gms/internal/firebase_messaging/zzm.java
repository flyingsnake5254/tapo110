package com.google.android.gms.internal.firebase_messaging;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

public final class zzm
{
  static final Logger zza = Logger.getLogger(zzm.class.getName());
  
  public static void zza(@CheckForNull InputStream paramInputStream)
  {
    if (paramInputStream == null) {
      return;
    }
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException paramInputStream)
    {
      try
      {
        zza.logp(Level.WARNING, "com.google.common.io.Closeables", "close", "IOException thrown while closing Closeable.", paramInputStream);
        return;
      }
      catch (IOException paramInputStream)
      {
        throw new AssertionError(paramInputStream);
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\google\android\gms\internal\firebase_messaging\zzm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */