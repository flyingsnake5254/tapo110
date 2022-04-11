package b.d.e0.h;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.SurfaceHolder;
import java.io.IOException;

public final class c
{
  public static int a = -1;
  public static int b = -1;
  public static int c = -1;
  private static c d;
  static final int e;
  private final Context f;
  private final b g;
  private Camera h;
  private Rect i;
  private Rect j;
  private boolean k;
  private boolean l;
  private final boolean m;
  private final h n;
  private final a o;
  
  static
  {
    int i1;
    try
    {
      i1 = Integer.parseInt(Build.VERSION.SDK);
    }
    catch (NumberFormatException localNumberFormatException)
    {
      i1 = 10000;
    }
    e = i1;
  }
  
  private c(Context paramContext)
  {
    this.f = paramContext;
    paramContext = new b(paramContext);
    this.g = paramContext;
    boolean bool;
    if (Integer.parseInt(Build.VERSION.SDK) > 3) {
      bool = true;
    } else {
      bool = false;
    }
    this.m = bool;
    this.n = new h(paramContext, bool);
    this.o = new a();
  }
  
  public static c c()
  {
    return d;
  }
  
  public static void i(Context paramContext)
  {
    if (d == null) {
      d = new c(paramContext);
    }
  }
  
  public g a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    Rect localRect = g();
    int i1 = this.g.e();
    String str = this.g.f();
    if ((i1 != 16) && (i1 != 17))
    {
      if ("yuv420p".equals(str)) {
        return new g(paramArrayOfByte, paramInt1, paramInt2, localRect.left, localRect.top, localRect.width(), localRect.height());
      }
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("Unsupported picture format: ");
      paramArrayOfByte.append(i1);
      paramArrayOfByte.append('/');
      paramArrayOfByte.append(str);
      throw new IllegalArgumentException(paramArrayOfByte.toString());
    }
    return new g(paramArrayOfByte, paramInt1, paramInt2, localRect.left, localRect.top, localRect.width(), localRect.height());
  }
  
  public void b()
  {
    if (this.h != null)
    {
      d.a();
      this.h.release();
      this.h = null;
    }
  }
  
  public a d()
  {
    return this.o;
  }
  
  public Camera e()
  {
    return this.h;
  }
  
  public Rect f()
  {
    try
    {
      Object localObject = this.g.g();
      if (this.h == null) {
        return null;
      }
      int i1 = (((Point)localObject).x - a) / 2;
      int i2 = c;
      if (i2 == -1) {
        i2 = (((Point)localObject).y - b) / 2;
      }
      localObject = new android/graphics/Rect;
      ((Rect)localObject).<init>(i1, i2, a + i1, b + i2);
      this.i = ((Rect)localObject);
      return (Rect)localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  public Rect g()
  {
    if (this.j == null)
    {
      Rect localRect = new Rect(f());
      Point localPoint1 = this.g.c();
      Point localPoint2 = this.g.g();
      int i1 = localRect.left;
      int i2 = localPoint1.y;
      int i3 = localPoint2.x;
      localRect.left = (i1 * i2 / i3);
      localRect.right = (localRect.right * i2 / i3);
      i2 = localRect.top;
      i3 = localPoint1.x;
      i1 = localPoint2.y;
      localRect.top = (i2 * i3 / i1);
      localRect.bottom = (localRect.bottom * i3 / i1);
      this.j = localRect;
    }
    return this.j;
  }
  
  public h h()
  {
    return this.n;
  }
  
  public boolean j()
  {
    return this.l;
  }
  
  public boolean k()
  {
    return this.m;
  }
  
  public void l(SurfaceHolder paramSurfaceHolder)
    throws IOException
  {
    if (this.h == null)
    {
      Camera localCamera = Camera.open();
      this.h = localCamera;
      if (localCamera != null)
      {
        localCamera.setPreviewDisplay(paramSurfaceHolder);
        if (!this.k)
        {
          this.k = true;
          this.g.h(this.h);
        }
        this.g.i(this.h);
        d.a();
      }
      else
      {
        throw new IOException();
      }
    }
  }
  
  public void m(Handler paramHandler, int paramInt)
  {
    if ((this.h != null) && (this.l))
    {
      this.o.a(paramHandler, paramInt);
      this.h.autoFocus(this.o);
    }
  }
  
  public void n(Handler paramHandler, int paramInt)
  {
    if ((this.h != null) && (this.l))
    {
      this.n.a(paramHandler, paramInt);
      if (this.m) {
        this.h.setOneShotPreviewCallback(this.n);
      } else {
        this.h.setPreviewCallback(this.n);
      }
    }
  }
  
  public void o(boolean paramBoolean)
  {
    this.l = paramBoolean;
  }
  
  public void p()
  {
    Camera localCamera = this.h;
    if ((localCamera != null) && (!this.l))
    {
      localCamera.startPreview();
      this.l = true;
    }
  }
  
  public void q()
  {
    Camera localCamera = this.h;
    if ((localCamera != null) && (this.l))
    {
      if (!this.m) {
        localCamera.setPreviewCallback(null);
      }
      this.h.stopPreview();
      this.n.a(null, 0);
      this.o.a(null, 0);
      this.l = false;
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\e0\h\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */