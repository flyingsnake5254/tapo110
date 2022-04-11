package b.d.w.c.b;

import android.content.Context;
import android.os.Environment;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import b.c.a.e;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class b
  implements b.c.a.c
{
  public static final String a = System.getProperty("line.separator");
  private final Date b;
  private final SimpleDateFormat c;
  private final e d;
  private final String e;
  
  private b(b paramb)
  {
    this.b = paramb.a;
    this.c = paramb.b;
    this.d = paramb.c;
    this.e = paramb.d;
  }
  
  private String b(String paramString)
  {
    if ((!b.d.w.h.b.d(paramString)) && (!b.d.w.h.b.a(this.e, paramString)))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.e);
      localStringBuilder.append("-");
      localStringBuilder.append(paramString);
      return localStringBuilder.toString();
    }
    return this.e;
  }
  
  public static b c(Context paramContext)
  {
    return new b(paramContext, null);
  }
  
  public void a(int paramInt, String paramString1, @NonNull String paramString2)
  {
    String str1 = b(paramString1);
    this.b.setTime(System.currentTimeMillis());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c.format(this.b));
    localStringBuilder.append(",");
    localStringBuilder.append(str1);
    String str2 = a;
    paramString1 = paramString2;
    if (paramString2.contains(str2)) {
      paramString1 = paramString2.replaceAll(str2, "<br>");
    }
    localStringBuilder.append(",");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(str2);
    this.d.a(paramInt, str1, localStringBuilder.toString());
  }
  
  public static final class b
  {
    Date a;
    SimpleDateFormat b;
    e c;
    String d = "PRETTY_LOGGER";
    Context e;
    byte[] f;
    long g;
    
    private b(Context paramContext)
    {
      this.e = paramContext;
    }
    
    public b a()
    {
      if (this.a == null) {
        this.a = new Date();
      }
      if (this.b == null) {
        this.b = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SSS", Locale.US);
      }
      if (this.c == null)
      {
        Object localObject1 = this.e;
        if (localObject1 != null) {
          localObject1 = ((Context)localObject1).getApplicationContext().getCacheDir().getAbsolutePath();
        } else {
          localObject1 = Environment.getExternalStorageDirectory().getAbsolutePath();
        }
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(File.separatorChar);
        ((StringBuilder)localObject2).append("logger");
        localObject1 = ((StringBuilder)localObject2).toString();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("AndroidFileLogger.");
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject2 = new HandlerThread(((StringBuilder)localObject2).toString());
        ((HandlerThread)localObject2).start();
        this.c = new b.c.a.b(new c(((HandlerThread)localObject2).getLooper(), (String)localObject1, 512000, this.f, this.g));
      }
      return new b(this, null);
    }
    
    public b b(byte[] paramArrayOfByte)
    {
      this.f = paramArrayOfByte;
      return this;
    }
    
    public b c(long paramLong)
    {
      this.g = paramLong;
      if (paramLong > 2048000L)
      {
        if (paramLong > 409600000L) {
          this.g = 409600000L;
        }
      }
      else {
        this.g = 0L;
      }
      if (paramLong < 2048000L) {
        this.g = 0L;
      }
      return this;
    }
    
    public b d(String paramString)
    {
      this.d = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\w\c\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */