package b.c.a;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Objects;

final class k
{
  @NonNull
  static <T> T a(@Nullable T paramT)
  {
    Objects.requireNonNull(paramT);
    return paramT;
  }
  
  static boolean b(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (paramCharSequence1 == paramCharSequence2) {
      return true;
    }
    if ((paramCharSequence1 != null) && (paramCharSequence2 != null))
    {
      int i = paramCharSequence1.length();
      if (i == paramCharSequence2.length())
      {
        if (((paramCharSequence1 instanceof String)) && ((paramCharSequence2 instanceof String))) {
          return paramCharSequence1.equals(paramCharSequence2);
        }
        for (int j = 0; j < i; j++) {
          if (paramCharSequence1.charAt(j) != paramCharSequence2.charAt(j)) {
            return false;
          }
        }
        return true;
      }
    }
    return false;
  }
  
  static String c(Throwable paramThrowable)
  {
    if (paramThrowable == null) {
      return "";
    }
    for (Object localObject = paramThrowable; localObject != null; localObject = ((Throwable)localObject).getCause()) {
      if ((localObject instanceof UnknownHostException)) {
        return "";
      }
    }
    localObject = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter((Writer)localObject);
    paramThrowable.printStackTrace(localPrintWriter);
    localPrintWriter.flush();
    return ((StringWriter)localObject).toString();
  }
  
  static boolean d(CharSequence paramCharSequence)
  {
    boolean bool;
    if ((paramCharSequence != null) && (paramCharSequence.length() != 0)) {
      bool = false;
    } else {
      bool = true;
    }
    return bool;
  }
  
  public static String e(Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    if (!paramObject.getClass().isArray()) {
      return paramObject.toString();
    }
    if ((paramObject instanceof boolean[])) {
      return Arrays.toString((boolean[])paramObject);
    }
    if ((paramObject instanceof byte[])) {
      return Arrays.toString((byte[])paramObject);
    }
    if ((paramObject instanceof char[])) {
      return Arrays.toString((char[])paramObject);
    }
    if ((paramObject instanceof short[])) {
      return Arrays.toString((short[])paramObject);
    }
    if ((paramObject instanceof int[])) {
      return Arrays.toString((int[])paramObject);
    }
    if ((paramObject instanceof long[])) {
      return Arrays.toString((long[])paramObject);
    }
    if ((paramObject instanceof float[])) {
      return Arrays.toString((float[])paramObject);
    }
    if ((paramObject instanceof double[])) {
      return Arrays.toString((double[])paramObject);
    }
    if ((paramObject instanceof Object[])) {
      return Arrays.deepToString((Object[])paramObject);
    }
    return "Couldn't find a correct type for the object";
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\c\a\k.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */