package androidx.constraintlayout.solver.widgets;

public class ResolutionDimension
  extends ResolutionNode
{
  float value = 0.0F;
  
  public void remove()
  {
    this.state = 2;
  }
  
  public void reset()
  {
    super.reset();
    this.value = 0.0F;
  }
  
  public void resolve(int paramInt)
  {
    int i = this.state;
    if ((i == 0) || (this.value != paramInt))
    {
      this.value = paramInt;
      if (i == 1) {
        invalidate();
      }
      didResolve();
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\solver\widgets\ResolutionDimension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */