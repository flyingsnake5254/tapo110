package b.d.w.c.b;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.c.a.c;
import b.c.a.d;
import com.tplink.libtputility.security.PlainEncryptKeyDelegate;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class a
  implements d
{
  private static volatile a a;
  private final c b;
  private final String c;
  private final byte[] d;
  
  private a(Context paramContext, String paramString, long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.getApplicationContext().getCacheDir().getAbsolutePath());
    ((StringBuilder)localObject).append(File.separatorChar);
    ((StringBuilder)localObject).append("logger");
    String str = ((StringBuilder)localObject).toString();
    this.c = str;
    localObject = c();
    this.d = ((byte[])localObject);
    d(str);
    f(str);
    this.b = b.c(paramContext).d(paramString.toUpperCase()).b((byte[])localObject).c(paramLong).a();
  }
  
  private byte[] c()
  {
    byte[] arrayOfByte2;
    try
    {
      byte[] arrayOfByte1 = b.d.w.h.a.f(PlainEncryptKeyDelegate.b().getBytes("utf-8"));
    }
    catch (Exception localException)
    {
      arrayOfByte2 = null;
    }
    return arrayOfByte2;
  }
  
  private void d(String paramString)
  {
    paramString = new File(paramString);
    if ((paramString.exists()) && (b.d.w.b.b.e(paramString) > 491520032L)) {
      b.d.w.b.b.c(paramString);
    }
  }
  
  public static a e(Context paramContext, String paramString, long paramLong)
  {
    if (a == null) {
      try
      {
        if (a == null)
        {
          a locala = new b/d/w/c/b/a;
          locala.<init>(paramContext, paramString, paramLong);
          a = locala;
        }
      }
      finally {}
    }
    return a;
  }
  
  private void f(String paramString)
  {
    Object localObject = new File(paramString);
    if ((((File)localObject).exists()) && (!((File)localObject).isFile()))
    {
      localObject = b.d.w.b.b.f(((File)localObject).listFiles());
      if (((List)localObject).isEmpty()) {
        return;
      }
      if ("logs_0000.dat".equals(((File)((List)localObject).get(0)).getName())) {
        return;
      }
      localObject = ((List)localObject).iterator();
      for (int i = 0; ((Iterator)localObject).hasNext(); i++) {
        ((File)((Iterator)localObject).next()).renameTo(new File(paramString, String.format(Locale.US, "logs_%04d.dat", new Object[] { Integer.valueOf(i) })));
      }
    }
  }
  
  public void a(int paramInt, @Nullable String paramString1, @NonNull String paramString2)
  {
    this.b.a(paramInt, paramString1, paramString2);
  }
  
  public boolean b(int paramInt, @Nullable String paramString)
  {
    return true;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\w\c\b\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */