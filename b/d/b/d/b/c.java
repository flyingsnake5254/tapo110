package b.d.b.d.b;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class c
{
  private final HashMap<String, a> a = new HashMap();
  
  public final void a()
  {
    Iterator localIterator = this.a.values().iterator();
    while (localIterator.hasNext()) {
      ((a)localIterator.next()).b();
    }
    this.a.clear();
  }
  
  final a b(String paramString)
  {
    return (a)this.a.get(paramString);
  }
  
  final void c(String paramString, a parama)
  {
    paramString = (a)this.a.put(paramString, parama);
    if (paramString != null) {
      paramString.b();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\b\d\b\d\b\c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */