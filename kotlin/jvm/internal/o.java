package kotlin.jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class o
{
  private final ArrayList<Object> a;
  
  public o(int paramInt)
  {
    this.a = new ArrayList(paramInt);
  }
  
  public void a(Object paramObject)
  {
    this.a.add(paramObject);
  }
  
  public void b(Object paramObject)
  {
    if (paramObject == null) {
      return;
    }
    if ((paramObject instanceof Object[]))
    {
      paramObject = (Object[])paramObject;
      if (paramObject.length > 0)
      {
        localObject = this.a;
        ((ArrayList)localObject).ensureCapacity(((ArrayList)localObject).size() + paramObject.length);
        Collections.addAll(this.a, (Object[])paramObject);
      }
    }
    else if ((paramObject instanceof Collection))
    {
      this.a.addAll((Collection)paramObject);
    }
    else
    {
      if ((paramObject instanceof Iterable))
      {
        paramObject = ((Iterable)paramObject).iterator();
        while (((Iterator)paramObject).hasNext())
        {
          localObject = ((Iterator)paramObject).next();
          this.a.add(localObject);
        }
      }
      if (!(paramObject instanceof Iterator)) {
        break label156;
      }
      paramObject = (Iterator)paramObject;
      while (((Iterator)paramObject).hasNext()) {
        this.a.add(((Iterator)paramObject).next());
      }
    }
    return;
    label156:
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Don't know how to spread ");
    ((StringBuilder)localObject).append(paramObject.getClass());
    throw new UnsupportedOperationException(((StringBuilder)localObject).toString());
  }
  
  public int c()
  {
    return this.a.size();
  }
  
  public Object[] d(Object[] paramArrayOfObject)
  {
    return this.a.toArray(paramArrayOfObject);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\kotlin\jvm\internal\o.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */