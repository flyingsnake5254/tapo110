package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TransitionValues
{
  final ArrayList<Transition> mTargetedTransitions = new ArrayList();
  public final Map<String, Object> values = new HashMap();
  public View view;
  
  @Deprecated
  public TransitionValues() {}
  
  public TransitionValues(@NonNull View paramView)
  {
    this.view = paramView;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof TransitionValues))
    {
      View localView = this.view;
      paramObject = (TransitionValues)paramObject;
      if ((localView == ((TransitionValues)paramObject).view) && (this.values.equals(((TransitionValues)paramObject).values))) {
        return true;
      }
    }
    return false;
  }
  
  public int hashCode()
  {
    return this.view.hashCode() * 31 + this.values.hashCode();
  }
  
  public String toString()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("TransitionValues@");
    ((StringBuilder)localObject1).append(Integer.toHexString(hashCode()));
    ((StringBuilder)localObject1).append(":\n");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("    view = ");
    ((StringBuilder)localObject2).append(this.view);
    ((StringBuilder)localObject2).append("\n");
    localObject2 = ((StringBuilder)localObject2).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append("    values:");
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = this.values.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("    ");
      localStringBuilder.append(str);
      localStringBuilder.append(": ");
      localStringBuilder.append(this.values.get(str));
      localStringBuilder.append("\n");
      localObject1 = localStringBuilder.toString();
    }
    return (String)localObject1;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\TransitionValues.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */