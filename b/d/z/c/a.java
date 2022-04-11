package b.d.z.c;

import b.d.p.e.b;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class a
{
  public static void a(ArrayList<WeakReference<b.d.z.a.a>> paramArrayList, b<b.d.z.a.a> paramb)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        WeakReference localWeakReference = (WeakReference)paramArrayList.get(i);
        if (localWeakReference.get() != null)
        {
          paramb.a((b.d.z.a.a)localWeakReference.get());
          i++;
        }
        else
        {
          paramArrayList.remove(i);
        }
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\z\c\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */