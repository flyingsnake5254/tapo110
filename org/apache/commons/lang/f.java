package org.apache.commons.lang;

import java.io.PrintStream;

public class f
{
  public static final String A;
  public static final String B;
  public static final String C;
  public static final String D;
  public static final String E;
  public static final String F;
  public static final String G;
  public static final String H;
  public static final String I;
  public static final String J;
  public static final String K;
  public static final String L;
  public static final String M;
  public static final String N;
  public static final String O;
  public static final String P;
  public static final String Q;
  public static final float R;
  public static final int S;
  public static final boolean T;
  public static final boolean U;
  public static final boolean V;
  public static final boolean W;
  public static final boolean X;
  public static final boolean Y;
  public static final boolean Z;
  public static final String a = g("awt.toolkit");
  public static final boolean a0;
  public static final String b = g("file.encoding");
  public static final boolean b0;
  public static final String c = g("file.separator");
  public static final boolean c0;
  public static final String d = g("java.awt.fonts");
  public static final boolean d0;
  public static final String e = g("java.awt.graphicsenv");
  public static final boolean e0;
  public static final String f = g("java.awt.headless");
  public static final boolean f0;
  public static final String g = g("java.awt.printerjob");
  public static final boolean g0;
  public static final String h = g("java.class.path");
  public static final boolean h0;
  public static final String i = g("java.class.version");
  public static final boolean i0;
  public static final String j = g("java.compiler");
  public static final boolean j0;
  public static final String k = g("java.endorsed.dirs");
  public static final boolean k0 = f("Windows");
  public static final String l = g("java.ext.dirs");
  public static final boolean l0 = e("Windows", "5.0");
  public static final String m = g("java.home");
  public static final boolean m0 = e("Windows 9", "4.0");
  public static final String n = g("java.io.tmpdir");
  public static final boolean n0 = e("Windows 9", "4.1");
  public static final String o = g("java.library.path");
  public static final boolean o0 = e("Windows", "4.9");
  public static final String p = g("java.runtime.name");
  public static final boolean p0 = f("Windows NT");
  public static final String q = g("java.runtime.version");
  public static final boolean q0 = e("Windows", "5.1");
  public static final String r = g("java.specification.name");
  public static final boolean r0 = e("Windows", "6.0");
  public static final String s = g("java.specification.vendor");
  public static final boolean s0 = e("Windows", "6.1");
  public static final String t = g("java.specification.version");
  public static final String u = g("java.util.prefs.PreferencesFactory");
  public static final String v = g("java.vendor");
  public static final String w = g("java.vendor.url");
  public static final String x = g("java.version");
  public static final String y = g("java.vm.info");
  public static final String z = g("java.vm.name");
  
  static
  {
    A = g("java.vm.specification.name");
    B = g("java.vm.specification.vendor");
    C = g("java.vm.specification.version");
    D = g("java.vm.vendor");
    E = g("java.vm.version");
    F = g("line.separator");
    G = g("os.arch");
    H = g("os.name");
    I = g("os.version");
    J = g("path.separator");
    String str = "user.country";
    if (g("user.country") == null) {
      str = "user.region";
    }
    K = g(str);
    L = g("user.dir");
    M = g("user.home");
    N = g("user.language");
    O = g("user.name");
    P = g("user.timezone");
    Q = d();
    R = a();
    S = b();
    T = c("1.1");
    U = c("1.2");
    V = c("1.3");
    W = c("1.4");
    X = c("1.5");
    Y = c("1.6");
    Z = c("1.7");
    boolean bool1 = f("AIX");
    a0 = bool1;
    boolean bool2 = f("HP-UX");
    b0 = bool2;
    boolean bool3 = f("Irix");
    c0 = bool3;
    boolean bool4 = f("Linux");
    boolean bool5 = false;
    if ((!bool4) && (!f("LINUX"))) {
      bool4 = false;
    } else {
      bool4 = true;
    }
    d0 = bool4;
    e0 = f("Mac");
    boolean bool6 = f("Mac OS X");
    f0 = bool6;
    g0 = f("OS/2");
    boolean bool7 = f("Solaris");
    h0 = bool7;
    boolean bool8 = f("SunOS");
    i0 = bool8;
    if ((!bool1) && (!bool2) && (!bool3) && (!bool4) && (!bool6) && (!bool7))
    {
      bool4 = bool5;
      if (!bool8) {}
    }
    else
    {
      bool4 = true;
    }
    j0 = bool4;
  }
  
  private static float a()
  {
    return m(l(x, 3));
  }
  
  private static int b()
  {
    return n(l(x, 3));
  }
  
  private static boolean c(String paramString)
  {
    return i(Q, paramString);
  }
  
  private static String d()
  {
    if (x != null) {
      for (int i1 = 0;; i1++)
      {
        String str = x;
        if (i1 >= str.length()) {
          break;
        }
        int i2 = str.charAt(i1);
        if ((i2 >= 48) && (i2 <= 57)) {
          return str.substring(i1);
        }
      }
    }
    return null;
  }
  
  private static boolean e(String paramString1, String paramString2)
  {
    return j(H, I, paramString1, paramString2);
  }
  
  private static boolean f(String paramString)
  {
    return k(H, paramString);
  }
  
  private static String g(String paramString)
  {
    try
    {
      String str = System.getProperty(paramString);
      return str;
    }
    catch (SecurityException localSecurityException)
    {
      PrintStream localPrintStream = System.err;
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("Caught a SecurityException reading the system property '");
      localStringBuffer.append(paramString);
      localStringBuffer.append("'; the SystemUtils property value will default to null.");
      localPrintStream.println(localStringBuffer.toString());
    }
    return null;
  }
  
  public static boolean h(float paramFloat)
  {
    boolean bool;
    if (R >= paramFloat) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  static boolean i(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return false;
    }
    return paramString1.startsWith(paramString2);
  }
  
  static boolean j(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramString1 != null) {
      if (paramString2 == null)
      {
        bool2 = bool1;
      }
      else
      {
        bool2 = bool1;
        if (paramString1.startsWith(paramString3))
        {
          bool2 = bool1;
          if (paramString2.startsWith(paramString4)) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  static boolean k(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return false;
    }
    return paramString1.startsWith(paramString2);
  }
  
  private static int[] l(String paramString, int paramInt)
  {
    if (paramString == null) {
      return a.f;
    }
    paramString = e.d(paramString, "._- ");
    int i1 = Math.min(paramInt, paramString.length);
    int[] arrayOfInt = new int[i1];
    int i2 = 0;
    for (i3 = 0; (i2 < paramString.length) && (i3 < paramInt); i3 = i4)
    {
      String str = paramString[i2];
      int i4 = i3;
      if (str.length() > 0) {}
      try
      {
        arrayOfInt[i3] = Integer.parseInt(str);
        i4 = i3 + 1;
        i2++;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          i4 = i3;
        }
      }
    }
    paramString = arrayOfInt;
    if (i1 > i3)
    {
      paramString = new int[i3];
      System.arraycopy(arrayOfInt, 0, paramString, 0, i3);
    }
    return paramString;
  }
  
  private static float m(int[] paramArrayOfInt)
  {
    StringBuffer localStringBuffer;
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length != 0))
    {
      int i1 = paramArrayOfInt.length;
      int i2 = 1;
      if (i1 == 1) {
        return paramArrayOfInt[0];
      }
      localStringBuffer = new StringBuffer();
      localStringBuffer.append(paramArrayOfInt[0]);
      localStringBuffer.append('.');
      while (i2 < paramArrayOfInt.length)
      {
        localStringBuffer.append(paramArrayOfInt[i2]);
        i2++;
      }
    }
    try
    {
      float f1 = Float.parseFloat(localStringBuffer.toString());
      return f1;
    }
    catch (Exception paramArrayOfInt)
    {
      for (;;) {}
    }
    return 0.0F;
  }
  
  private static int n(int[] paramArrayOfInt)
  {
    int i1 = 0;
    if (paramArrayOfInt == null) {
      return 0;
    }
    int i2 = paramArrayOfInt.length;
    if (i2 >= 1) {
      i1 = paramArrayOfInt[0] * 100;
    }
    int i3 = i1;
    if (i2 >= 2) {
      i3 = i1 + paramArrayOfInt[1] * 10;
    }
    i1 = i3;
    if (i2 >= 3) {
      i1 = i3 + paramArrayOfInt[2];
    }
    return i1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\org\apache\commons\lang\f.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */