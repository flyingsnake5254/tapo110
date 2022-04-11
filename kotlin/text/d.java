package kotlin.text;

import java.nio.charset.Charset;
import kotlin.jvm.internal.j;

public final class d
{
  public static final Charset a;
  public static final Charset b;
  public static final Charset c;
  public static final Charset d;
  public static final Charset e;
  public static final Charset f;
  public static final d g = new d();
  
  static
  {
    Charset localCharset = Charset.forName("UTF-8");
    j.d(localCharset, "Charset.forName(\"UTF-8\")");
    a = localCharset;
    localCharset = Charset.forName("UTF-16");
    j.d(localCharset, "Charset.forName(\"UTF-16\")");
    b = localCharset;
    localCharset = Charset.forName("UTF-16BE");
    j.d(localCharset, "Charset.forName(\"UTF-16BE\")");
    c = localCharset;
    localCharset = Charset.forName("UTF-16LE");
    j.d(localCharset, "Charset.forName(\"UTF-16LE\")");
    d = localCharset;
    localCharset = Charset.forName("US-ASCII");
    j.d(localCharset, "Charset.forName(\"US-ASCII\")");
    e = localCharset;
    localCharset = Charset.forName("ISO-8859-1");
    j.d(localCharset, "Charset.forName(\"ISO-8859-1\")");
    f = localCharset;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\text\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */