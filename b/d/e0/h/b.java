package b.d.e0.h;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Build;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import java.util.regex.Pattern;

final class b
{
  private static final String a = "b";
  private static final Pattern b = Pattern.compile(",");
  private final Context c;
  private Point d;
  private Point e;
  private int f;
  private String g;
  
  b(Context paramContext)
  {
    this.c = paramContext;
  }
  
  private static int a(CharSequence paramCharSequence, int paramInt)
  {
    paramCharSequence = b.split(paramCharSequence);
    int i = paramCharSequence.length;
    int j = 0;
    int k = 0;
    while (j < i)
    {
      String str = paramCharSequence[j].trim();
      try
      {
        double d1 = Double.parseDouble(str);
        int m = (int)(10.0D * d1);
        int n = k;
        if (Math.abs(paramInt - d1) < Math.abs(paramInt - k)) {
          n = m;
        }
        j++;
        k = n;
      }
      catch (NumberFormatException paramCharSequence)
      {
        return paramInt;
      }
    }
    return k;
  }
  
  private static Point b(CharSequence paramCharSequence, Point paramPoint)
  {
    String[] arrayOfString = b.split(paramCharSequence);
    int i = arrayOfString.length;
    int j = Integer.MAX_VALUE;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1;
    int i2;
    for (;;)
    {
      i1 = m;
      i2 = n;
      if (k >= i) {
        break;
      }
      paramCharSequence = arrayOfString[k].trim();
      i2 = paramCharSequence.indexOf('x');
      Object localObject;
      if (i2 < 0)
      {
        String str = a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Bad preview-size: ");
        ((StringBuilder)localObject).append(paramCharSequence);
        Log.w(str, ((StringBuilder)localObject).toString());
        i2 = j;
      }
      else
      {
        try
        {
          i1 = Integer.parseInt(paramCharSequence.substring(0, i2));
          int i3 = Integer.parseInt(paramCharSequence.substring(i2 + 1));
          int i4 = Math.abs(i1 - paramPoint.x) + Math.abs(i3 - paramPoint.y);
          if (i4 == 0)
          {
            i2 = i3;
            break;
          }
          i2 = j;
          if (i4 < j)
          {
            n = i3;
            i2 = i4;
            m = i1;
          }
        }
        catch (NumberFormatException localNumberFormatException)
        {
          localObject = a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Bad preview-size: ");
          localStringBuilder.append(paramCharSequence);
          Log.w((String)localObject, localStringBuilder.toString());
          i2 = j;
        }
      }
      k++;
      j = i2;
    }
    if ((i1 > 0) && (i2 > 0)) {
      return new Point(i1, i2);
    }
    return null;
  }
  
  private static Point d(Camera.Parameters paramParameters, Point paramPoint)
  {
    Object localObject1 = paramParameters.get("preview-size-values");
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = paramParameters.get("preview-size-value");
    }
    paramParameters = null;
    if (localObject2 != null)
    {
      paramParameters = a;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("preview-size-values parameter: ");
      ((StringBuilder)localObject1).append((String)localObject2);
      Log.d(paramParameters, ((StringBuilder)localObject1).toString());
      paramParameters = b((CharSequence)localObject2, paramPoint);
    }
    localObject2 = paramParameters;
    if (paramParameters == null) {
      localObject2 = new Point(paramPoint.x >> 3 << 3, paramPoint.y >> 3 << 3);
    }
    return (Point)localObject2;
  }
  
  private void j(Camera.Parameters paramParameters)
  {
    if ((Build.MODEL.contains("Behold II")) && (c.e == 3)) {
      paramParameters.set("flash-value", 1);
    } else {
      paramParameters.set("flash-value", 2);
    }
    paramParameters.set("flash-mode", "off");
  }
  
  private void k(Camera.Parameters paramParameters)
  {
    String str1 = paramParameters.get("zoom-supported");
    if ((str1 != null) && (!Boolean.parseBoolean(str1))) {
      return;
    }
    int i = 27;
    str1 = paramParameters.get("max-zoom");
    int j = i;
    if (str1 != null) {
      try
      {
        double d1 = Double.parseDouble(str1);
        k = (int)(d1 * 10.0D);
        j = i;
        if (27 > k) {
          j = k;
        }
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        String str2 = a;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Bad max-zoom: ");
        ((StringBuilder)localObject1).append(str1);
        Log.w(str2, ((StringBuilder)localObject1).toString());
        j = i;
      }
    }
    Object localObject1 = paramParameters.get("taking-picture-zoom-max");
    int k = j;
    if (localObject1 != null) {
      try
      {
        i = Integer.parseInt((String)localObject1);
        k = j;
        if (j > i) {
          k = i;
        }
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        str3 = a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("Bad taking-picture-zoom-max: ");
        ((StringBuilder)localObject2).append((String)localObject1);
        Log.w(str3, ((StringBuilder)localObject2).toString());
        k = j;
      }
    }
    String str3 = paramParameters.get("mot-zoom-values");
    j = k;
    if (str3 != null) {
      j = a(str3, k);
    }
    Object localObject2 = paramParameters.get("mot-zoom-step");
    k = j;
    if (localObject2 != null) {
      try
      {
        i = (int)(Double.parseDouble(((String)localObject2).trim()) * 10.0D);
        k = j;
        if (i > 1) {
          k = j - j % i;
        }
      }
      catch (NumberFormatException localNumberFormatException3)
      {
        k = j;
      }
    }
    if ((str1 != null) || (str3 != null)) {
      paramParameters.set("zoom", String.valueOf(k / 10.0D));
    }
    if (localObject1 != null) {
      paramParameters.set("taking-picture-zoom", k);
    }
  }
  
  Point c()
  {
    return this.e;
  }
  
  int e()
  {
    return this.f;
  }
  
  String f()
  {
    return this.g;
  }
  
  Point g()
  {
    return this.d;
  }
  
  void h(Camera paramCamera)
  {
    Object localObject1 = paramCamera.getParameters();
    this.f = ((Camera.Parameters)localObject1).getPreviewFormat();
    this.g = ((Camera.Parameters)localObject1).get("preview-format");
    paramCamera = a;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Default preview format: ");
    ((StringBuilder)localObject2).append(this.f);
    ((StringBuilder)localObject2).append('/');
    ((StringBuilder)localObject2).append(this.g);
    Log.d(paramCamera, ((StringBuilder)localObject2).toString());
    localObject2 = ((WindowManager)this.c.getSystemService("window")).getDefaultDisplay();
    this.d = new Point(((Display)localObject2).getWidth(), ((Display)localObject2).getHeight());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Screen resolution: ");
    ((StringBuilder)localObject2).append(this.d);
    Log.d(paramCamera, ((StringBuilder)localObject2).toString());
    localObject2 = new Point();
    Object localObject3 = this.d;
    ((Point)localObject2).x = ((Point)localObject3).x;
    ((Point)localObject2).y = ((Point)localObject3).y;
    int i = ((Point)localObject3).x;
    int j = ((Point)localObject3).y;
    if (i < j)
    {
      ((Point)localObject2).x = j;
      ((Point)localObject2).y = ((Point)localObject3).x;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("screenX:");
    ((StringBuilder)localObject3).append(((Point)localObject2).x);
    ((StringBuilder)localObject3).append("   screenY:");
    ((StringBuilder)localObject3).append(((Point)localObject2).y);
    Log.i("#########", ((StringBuilder)localObject3).toString());
    this.e = d((Camera.Parameters)localObject1, (Point)localObject2);
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("Camera resolution: ");
    ((StringBuilder)localObject1).append(this.d);
    Log.d(paramCamera, ((StringBuilder)localObject1).toString());
  }
  
  void i(Camera paramCamera)
  {
    Camera.Parameters localParameters = paramCamera.getParameters();
    Object localObject = a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Setting preview size: ");
    localStringBuilder.append(this.e);
    Log.d((String)localObject, localStringBuilder.toString());
    localObject = this.e;
    localParameters.setPreviewSize(((Point)localObject).x, ((Point)localObject).y);
    j(localParameters);
    k(localParameters);
    paramCamera.setDisplayOrientation(90);
    paramCamera.setParameters(localParameters);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\e0\h\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */