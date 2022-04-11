package b.a.a.a.a.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.net.NetworkInfo.State;
import androidx.annotation.NonNull;

public class a
{
  private NetworkInfo.State a;
  private NetworkInfo.DetailedState b;
  private int c;
  private int d;
  private boolean e;
  private boolean f;
  private boolean g;
  private String h;
  private String i;
  private String j;
  private String k;
  
  private a()
  {
    this(b());
  }
  
  private a(b paramb)
  {
    this.a = b.a(paramb);
    this.b = b.b(paramb);
    this.c = b.d(paramb);
    this.d = b.e(paramb);
    this.e = b.f(paramb);
    this.f = b.g(paramb);
    this.g = b.h(paramb);
    this.h = b.i(paramb);
    this.i = b.j(paramb);
    this.j = b.k(paramb);
    this.k = b.c(paramb);
  }
  
  private static b b()
  {
    return new b();
  }
  
  public static a c()
  {
    return b().m();
  }
  
  public static a d(@NonNull Context paramContext)
  {
    c.a(paramContext, "context == null");
    return e(paramContext, g(paramContext));
  }
  
  protected static a e(@NonNull Context paramContext, ConnectivityManager paramConnectivityManager)
  {
    c.a(paramContext, "context == null");
    if (paramConnectivityManager == null) {
      return c();
    }
    paramContext = paramConnectivityManager.getActiveNetworkInfo();
    if (paramContext == null) {
      paramContext = c();
    } else {
      paramContext = f(paramContext);
    }
    return paramContext;
  }
  
  private static a f(NetworkInfo paramNetworkInfo)
  {
    return new b().s(paramNetworkInfo.getState()).n(paramNetworkInfo.getDetailedState()).v(paramNetworkInfo.getType()).t(paramNetworkInfo.getSubtype()).l(paramNetworkInfo.isAvailable()).p(paramNetworkInfo.isFailover()).r(paramNetworkInfo.isRoaming()).w(paramNetworkInfo.getTypeName()).u(paramNetworkInfo.getSubtypeName()).q(paramNetworkInfo.getReason()).o(paramNetworkInfo.getExtraInfo()).m();
  }
  
  private static ConnectivityManager g(Context paramContext)
  {
    return (ConnectivityManager)paramContext.getSystemService("connectivity");
  }
  
  public boolean a()
  {
    return this.e;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (a.class == paramObject.getClass()))
    {
      paramObject = (a)paramObject;
      if (this.c != ((a)paramObject).c) {
        return false;
      }
      if (this.d != ((a)paramObject).d) {
        return false;
      }
      if (this.e != ((a)paramObject).e) {
        return false;
      }
      if (this.f != ((a)paramObject).f) {
        return false;
      }
      if (this.g != ((a)paramObject).g) {
        return false;
      }
      if (this.a != ((a)paramObject).a) {
        return false;
      }
      if (this.b != ((a)paramObject).b) {
        return false;
      }
      if (!this.h.equals(((a)paramObject).h)) {
        return false;
      }
      String str = this.i;
      if (str != null ? !str.equals(((a)paramObject).i) : ((a)paramObject).i != null) {
        return false;
      }
      str = this.j;
      if (str != null ? !str.equals(((a)paramObject).j) : ((a)paramObject).j != null) {
        return false;
      }
      str = this.k;
      paramObject = ((a)paramObject).k;
      if (str != null) {
        bool = str.equals(paramObject);
      } else if (paramObject != null) {
        bool = false;
      }
      return bool;
    }
    return false;
  }
  
  public NetworkInfo.State h()
  {
    return this.a;
  }
  
  public int hashCode()
  {
    int m = this.a.hashCode();
    Object localObject = this.b;
    int n = 0;
    int i1;
    if (localObject != null) {
      i1 = ((NetworkInfo.DetailedState)localObject).hashCode();
    } else {
      i1 = 0;
    }
    int i2 = this.c;
    int i3 = this.d;
    int i4 = this.e;
    int i5 = this.f;
    int i6 = this.g;
    int i7 = this.h.hashCode();
    localObject = this.i;
    int i8;
    if (localObject != null) {
      i8 = ((String)localObject).hashCode();
    } else {
      i8 = 0;
    }
    localObject = this.j;
    int i9;
    if (localObject != null) {
      i9 = ((String)localObject).hashCode();
    } else {
      i9 = 0;
    }
    localObject = this.k;
    if (localObject != null) {
      n = ((String)localObject).hashCode();
    }
    return (((((((((m * 31 + i1) * 31 + i2) * 31 + i3) * 31 + i4) * 31 + i5) * 31 + i6) * 31 + i7) * 31 + i8) * 31 + i9) * 31 + n;
  }
  
  public int i()
  {
    return this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Connectivity{state=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", detailedState=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", subType=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", available=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", failover=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", roaming=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", typeName='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", subTypeName='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", reason='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", extraInfo='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public static class b
  {
    private NetworkInfo.State a = NetworkInfo.State.DISCONNECTED;
    private NetworkInfo.DetailedState b = NetworkInfo.DetailedState.IDLE;
    private int c = -1;
    private int d = -1;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private String h = "NONE";
    private String i = "NONE";
    private String j = "";
    private String k = "";
    
    public b l(boolean paramBoolean)
    {
      this.e = paramBoolean;
      return this;
    }
    
    public a m()
    {
      return new a(this, null);
    }
    
    public b n(NetworkInfo.DetailedState paramDetailedState)
    {
      this.b = paramDetailedState;
      return this;
    }
    
    public b o(String paramString)
    {
      this.k = paramString;
      return this;
    }
    
    public b p(boolean paramBoolean)
    {
      this.f = paramBoolean;
      return this;
    }
    
    public b q(String paramString)
    {
      this.j = paramString;
      return this;
    }
    
    public b r(boolean paramBoolean)
    {
      this.g = paramBoolean;
      return this;
    }
    
    public b s(NetworkInfo.State paramState)
    {
      this.a = paramState;
      return this;
    }
    
    public b t(int paramInt)
    {
      this.d = paramInt;
      return this;
    }
    
    public b u(String paramString)
    {
      this.i = paramString;
      return this;
    }
    
    public b v(int paramInt)
    {
      this.c = paramInt;
      return this;
    }
    
    public b w(String paramString)
    {
      this.h = paramString;
      return this;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\a\a\a\a\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */