package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.NonNull;

public final class ActionOnlyNavDirections
  implements NavDirections
{
  private final int mActionId;
  
  public ActionOnlyNavDirections(int paramInt)
  {
    this.mActionId = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if ((paramObject != null) && (ActionOnlyNavDirections.class == paramObject.getClass()))
    {
      paramObject = (ActionOnlyNavDirections)paramObject;
      return getActionId() == ((ActionOnlyNavDirections)paramObject).getActionId();
    }
    return false;
  }
  
  public int getActionId()
  {
    return this.mActionId;
  }
  
  @NonNull
  public Bundle getArguments()
  {
    return new Bundle();
  }
  
  public int hashCode()
  {
    return 31 + getActionId();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ActionOnlyNavDirections(actionId=");
    localStringBuilder.append(getActionId());
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\ActionOnlyNavDirections.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */