package androidx.core.util;

import android.util.AtomicFile;
import androidx.annotation.RequiresApi;
import java.io.FileOutputStream;
import java.nio.charset.Charset;
import kotlin.jvm.b.l;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.j;
import kotlin.p;

public final class AtomicFileKt
{
  @RequiresApi(17)
  public static final byte[] readBytes(AtomicFile paramAtomicFile)
  {
    j.f(paramAtomicFile, "$this$readBytes");
    paramAtomicFile = paramAtomicFile.readFully();
    j.b(paramAtomicFile, "readFully()");
    return paramAtomicFile;
  }
  
  @RequiresApi(17)
  public static final String readText(AtomicFile paramAtomicFile, Charset paramCharset)
  {
    j.f(paramAtomicFile, "$this$readText");
    j.f(paramCharset, "charset");
    paramAtomicFile = paramAtomicFile.readFully();
    j.b(paramAtomicFile, "readFully()");
    return new String(paramAtomicFile, paramCharset);
  }
  
  @RequiresApi(17)
  public static final void tryWrite(AtomicFile paramAtomicFile, l<? super FileOutputStream, p> paraml)
  {
    j.f(paramAtomicFile, "$this$tryWrite");
    j.f(paraml, "block");
    FileOutputStream localFileOutputStream = paramAtomicFile.startWrite();
    try
    {
      j.b(localFileOutputStream, "stream");
      paraml.invoke(localFileOutputStream);
      return;
    }
    finally
    {
      i.b(1);
      paramAtomicFile.failWrite(localFileOutputStream);
      i.a(1);
    }
  }
  
  @RequiresApi(17)
  public static final void writeBytes(AtomicFile paramAtomicFile, byte[] paramArrayOfByte)
  {
    j.f(paramAtomicFile, "$this$writeBytes");
    j.f(paramArrayOfByte, "array");
    FileOutputStream localFileOutputStream = paramAtomicFile.startWrite();
    try
    {
      j.b(localFileOutputStream, "stream");
      localFileOutputStream.write(paramArrayOfByte);
      return;
    }
    finally
    {
      paramAtomicFile.failWrite(localFileOutputStream);
    }
  }
  
  @RequiresApi(17)
  public static final void writeText(AtomicFile paramAtomicFile, String paramString, Charset paramCharset)
  {
    j.f(paramAtomicFile, "$this$writeText");
    j.f(paramString, "text");
    j.f(paramCharset, "charset");
    paramString = paramString.getBytes(paramCharset);
    j.b(paramString, "(this as java.lang.String).getBytes(charset)");
    writeBytes(paramAtomicFile, paramString);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\util\AtomicFileKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */