package kotlin.text;

import kotlin.jvm.b.l;
import kotlin.jvm.internal.j;

class n
{
  public static <T> void a(Appendable paramAppendable, T paramT, l<? super T, ? extends CharSequence> paraml)
  {
    j.e(paramAppendable, "$this$appendElement");
    if (paraml != null)
    {
      paramAppendable.append((CharSequence)paraml.invoke(paramT));
    }
    else
    {
      boolean bool;
      if (paramT != null) {
        bool = paramT instanceof CharSequence;
      } else {
        bool = true;
      }
      if (bool) {
        paramAppendable.append((CharSequence)paramT);
      } else if ((paramT instanceof Character)) {
        paramAppendable.append(((Character)paramT).charValue());
      } else {
        paramAppendable.append(String.valueOf(paramT));
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\text\n.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */