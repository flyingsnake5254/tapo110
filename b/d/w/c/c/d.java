package b.d.w.c.c;

import android.content.Context;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import b.c.a.b;
import b.c.a.c;
import b.c.a.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class d
  implements c
{
  private static final String a = System.getProperty("line.separator");
  private final Date b;
  private final SimpleDateFormat c;
  private final e d;
  private final String e;
  private final boolean f;
  
  public d(b paramb)
  {
    this.b = paramb.a;
    this.c = paramb.b;
    this.d = paramb.c;
    this.e = paramb.d;
    this.f = paramb.f;
  }
  
  public static b b(Context paramContext)
  {
    return new b(paramContext, null);
  }
  
  public void a(int paramInt, String paramString1, @NonNull String paramString2)
  {
    if ((this.f) && ((paramString1 == null) || (!paramString1.equals(this.e)))) {
      return;
    }
    this.b.setTime(System.currentTimeMillis());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c.format(this.b));
    localStringBuilder.append(",");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(a);
    paramString2 = localStringBuilder.toString();
    this.d.a(paramInt, paramString1, paramString2);
  }
  
  public static final class b
  {
    Date a;
    SimpleDateFormat b;
    e c;
    String d = "Tiny";
    Context e;
    boolean f = true;
    
    private b(Context paramContext)
    {
      this.e = paramContext;
    }
    
    public d a()
    {
      if (this.a == null) {
        this.a = new Date();
      }
      if (this.b == null) {
        this.b = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss", Locale.US);
      }
      if (this.c == null)
      {
        HandlerThread localHandlerThread = new HandlerThread("AndroidTinyFileLogger");
        localHandlerThread.start();
        this.c = new b(new f(this.e, localHandlerThread.getLooper()));
      }
      return new d(this);
    }
    
    public b b(boolean paramBoolean)
    {
      this.f = paramBoolean;
      return this;
    }
    
    public b c(e parame)
    {
      this.c = parame;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\w\c\c\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */