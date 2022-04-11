package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import java.util.ArrayList;

public class ConstraintHorizontalLayout
  extends ConstraintWidgetContainer
{
  private ContentAlignment mAlignment = ContentAlignment.MIDDLE;
  
  public ConstraintHorizontalLayout() {}
  
  public ConstraintHorizontalLayout(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
  }
  
  public ConstraintHorizontalLayout(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void addToSolver(LinearSystem paramLinearSystem)
  {
    if (this.mChildren.size() != 0)
    {
      int i = 0;
      int j = this.mChildren.size();
      Object localObject2;
      Object localObject3;
      for (Object localObject1 = this; i < j; localObject1 = localObject2)
      {
        localObject2 = (ConstraintWidget)this.mChildren.get(i);
        ConstraintAnchor.Type localType;
        if (localObject1 != this)
        {
          localObject3 = ConstraintAnchor.Type.LEFT;
          localType = ConstraintAnchor.Type.RIGHT;
          ((ConstraintWidget)localObject2).connect((ConstraintAnchor.Type)localObject3, (ConstraintWidget)localObject1, localType);
          ((ConstraintWidget)localObject1).connect(localType, (ConstraintWidget)localObject2, (ConstraintAnchor.Type)localObject3);
        }
        else
        {
          localObject3 = ConstraintAnchor.Strength.STRONG;
          if (this.mAlignment == ContentAlignment.END) {
            localObject3 = ConstraintAnchor.Strength.WEAK;
          }
          localType = ConstraintAnchor.Type.LEFT;
          ((ConstraintWidget)localObject2).connect(localType, (ConstraintWidget)localObject1, localType, 0, (ConstraintAnchor.Strength)localObject3);
        }
        localObject1 = ConstraintAnchor.Type.TOP;
        ((ConstraintWidget)localObject2).connect((ConstraintAnchor.Type)localObject1, this, (ConstraintAnchor.Type)localObject1);
        localObject1 = ConstraintAnchor.Type.BOTTOM;
        ((ConstraintWidget)localObject2).connect((ConstraintAnchor.Type)localObject1, this, (ConstraintAnchor.Type)localObject1);
        i++;
      }
      if (localObject1 != this)
      {
        localObject3 = ConstraintAnchor.Strength.STRONG;
        if (this.mAlignment == ContentAlignment.BEGIN) {
          localObject3 = ConstraintAnchor.Strength.WEAK;
        }
        localObject2 = ConstraintAnchor.Type.RIGHT;
        ((ConstraintWidget)localObject1).connect((ConstraintAnchor.Type)localObject2, this, (ConstraintAnchor.Type)localObject2, 0, (ConstraintAnchor.Strength)localObject3);
      }
    }
    super.addToSolver(paramLinearSystem);
  }
  
  public static enum ContentAlignment
  {
    static
    {
      ContentAlignment localContentAlignment1 = new ContentAlignment("BEGIN", 0);
      BEGIN = localContentAlignment1;
      ContentAlignment localContentAlignment2 = new ContentAlignment("MIDDLE", 1);
      MIDDLE = localContentAlignment2;
      ContentAlignment localContentAlignment3 = new ContentAlignment("END", 2);
      END = localContentAlignment3;
      ContentAlignment localContentAlignment4 = new ContentAlignment("TOP", 3);
      TOP = localContentAlignment4;
      ContentAlignment localContentAlignment5 = new ContentAlignment("VERTICAL_MIDDLE", 4);
      VERTICAL_MIDDLE = localContentAlignment5;
      ContentAlignment localContentAlignment6 = new ContentAlignment("BOTTOM", 5);
      BOTTOM = localContentAlignment6;
      ContentAlignment localContentAlignment7 = new ContentAlignment("LEFT", 6);
      LEFT = localContentAlignment7;
      ContentAlignment localContentAlignment8 = new ContentAlignment("RIGHT", 7);
      RIGHT = localContentAlignment8;
      $VALUES = new ContentAlignment[] { localContentAlignment1, localContentAlignment2, localContentAlignment3, localContentAlignment4, localContentAlignment5, localContentAlignment6, localContentAlignment7, localContentAlignment8 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\solver\widgets\ConstraintHorizontalLayout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */