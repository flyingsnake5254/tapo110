package butterknife;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OnPageChange
{
  public static enum Callback
  {
    static
    {
      Callback localCallback1 = new Callback("PAGE_SELECTED", 0);
      PAGE_SELECTED = localCallback1;
      Callback localCallback2 = new Callback("PAGE_SCROLLED", 1);
      PAGE_SCROLLED = localCallback2;
      Callback localCallback3 = new Callback("PAGE_SCROLL_STATE_CHANGED", 2);
      PAGE_SCROLL_STATE_CHANGED = localCallback3;
      $VALUES = new Callback[] { localCallback1, localCallback2, localCallback3 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\butterknife\OnPageChange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */