package b.d.l.b;

import androidx.annotation.NonNull;
import com.tplink.libtpimagedownloadmedia.loader.f;
import com.tplink.libtpimagedownloadmedia.loader.g;

public class b
{
  @NonNull
  private g a;
  private f b;
  private int c;
  
  public b(@NonNull g paramg, f paramf)
  {
    this.a = paramg;
    this.b = paramf;
    this.c = 0;
  }
  
  public void a()
  {
    this.c += 1;
  }
  
  public f b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.c;
  }
  
  @NonNull
  public g d()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof b)) {
      return false;
    }
    paramObject = (b)paramObject;
    return d().equals(((b)paramObject).d());
  }
  
  public int hashCode()
  {
    return this.a.hashCode();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\l\b\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */