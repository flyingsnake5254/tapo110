package b.d.s.c;

import android.text.TextUtils;
import com.tplink.libtpnetwork.enumerate.EnumDeviceType;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang.e;

public class a
{
  private static final String[] a;
  private static final String[] b;
  private static final String[] c;
  
  static
  {
    EnumDeviceType localEnumDeviceType1 = EnumDeviceType.PLUG;
    String str1 = localEnumDeviceType1.getDeviceType();
    EnumDeviceType localEnumDeviceType2 = EnumDeviceType.BULB;
    String str2 = localEnumDeviceType2.getDeviceType();
    EnumDeviceType localEnumDeviceType3 = EnumDeviceType.CAMERA;
    a = new String[] { str1, str2, localEnumDeviceType3.getDeviceType() };
    b = new String[] { localEnumDeviceType1.getDeviceType(), localEnumDeviceType2.getDeviceType(), localEnumDeviceType3.getDeviceType() };
    c = new String[] { localEnumDeviceType1.getDeviceType(), localEnumDeviceType2.getDeviceType() };
  }
  
  public static String[] a()
  {
    return a;
  }
  
  public static String b()
  {
    String[] arrayOfString = b;
    if (arrayOfString.length == 0) {
      return null;
    }
    return e.b(arrayOfString, ",");
  }
  
  public static String c(String... paramVarArgs)
  {
    if (paramVarArgs.length == 0) {
      return null;
    }
    return TextUtils.join(",", paramVarArgs);
  }
  
  public static List<String> d()
  {
    return Arrays.asList(a);
  }
  
  public static List<String> e()
  {
    return Arrays.asList(c);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\s\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */