package androidx.navigation;

import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;

@NavOptionsDsl
public final class AnimBuilder
{
  @AnimRes
  @AnimatorRes
  private int enter = -1;
  @AnimRes
  @AnimatorRes
  private int exit = -1;
  @AnimRes
  @AnimatorRes
  private int popEnter = -1;
  @AnimRes
  @AnimatorRes
  private int popExit = -1;
  
  public final int getEnter()
  {
    return this.enter;
  }
  
  public final int getExit()
  {
    return this.exit;
  }
  
  public final int getPopEnter()
  {
    return this.popEnter;
  }
  
  public final int getPopExit()
  {
    return this.popExit;
  }
  
  public final void setEnter(int paramInt)
  {
    this.enter = paramInt;
  }
  
  public final void setExit(int paramInt)
  {
    this.exit = paramInt;
  }
  
  public final void setPopEnter(int paramInt)
  {
    this.popEnter = paramInt;
  }
  
  public final void setPopExit(int paramInt)
  {
    this.popExit = paramInt;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\navigation\AnimBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */