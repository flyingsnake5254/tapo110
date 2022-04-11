package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.LinearSystem;
import androidx.constraintlayout.solver.Metrics;
import androidx.constraintlayout.solver.SolverVariable;

public class ResolutionAnchor
  extends ResolutionNode
{
  public static final int BARRIER_CONNECTION = 5;
  public static final int CENTER_CONNECTION = 2;
  public static final int CHAIN_CONNECTION = 4;
  public static final int DIRECT_CONNECTION = 1;
  public static final int MATCH_CONNECTION = 3;
  public static final int UNCONNECTED = 0;
  float computedValue;
  private ResolutionDimension dimension = null;
  private int dimensionMultiplier = 1;
  ConstraintAnchor myAnchor;
  float offset;
  private ResolutionAnchor opposite;
  private ResolutionDimension oppositeDimension = null;
  private int oppositeDimensionMultiplier = 1;
  private float oppositeOffset;
  float resolvedOffset;
  ResolutionAnchor resolvedTarget;
  ResolutionAnchor target;
  int type = 0;
  
  public ResolutionAnchor(ConstraintAnchor paramConstraintAnchor)
  {
    this.myAnchor = paramConstraintAnchor;
  }
  
  void addResolvedValue(LinearSystem paramLinearSystem)
  {
    SolverVariable localSolverVariable = this.myAnchor.getSolverVariable();
    ResolutionAnchor localResolutionAnchor = this.resolvedTarget;
    if (localResolutionAnchor == null) {
      paramLinearSystem.addEquality(localSolverVariable, (int)(this.resolvedOffset + 0.5F));
    } else {
      paramLinearSystem.addEquality(localSolverVariable, paramLinearSystem.createObjectVariable(localResolutionAnchor.myAnchor), (int)(this.resolvedOffset + 0.5F), 6);
    }
  }
  
  public void dependsOn(int paramInt1, ResolutionAnchor paramResolutionAnchor, int paramInt2)
  {
    this.type = paramInt1;
    this.target = paramResolutionAnchor;
    this.offset = paramInt2;
    paramResolutionAnchor.addDependent(this);
  }
  
  public void dependsOn(ResolutionAnchor paramResolutionAnchor, int paramInt)
  {
    this.target = paramResolutionAnchor;
    this.offset = paramInt;
    paramResolutionAnchor.addDependent(this);
  }
  
  public void dependsOn(ResolutionAnchor paramResolutionAnchor, int paramInt, ResolutionDimension paramResolutionDimension)
  {
    this.target = paramResolutionAnchor;
    paramResolutionAnchor.addDependent(this);
    this.dimension = paramResolutionDimension;
    this.dimensionMultiplier = paramInt;
    paramResolutionDimension.addDependent(this);
  }
  
  public float getResolvedValue()
  {
    return this.resolvedOffset;
  }
  
  public void remove(ResolutionDimension paramResolutionDimension)
  {
    ResolutionDimension localResolutionDimension = this.dimension;
    if (localResolutionDimension == paramResolutionDimension)
    {
      this.dimension = null;
      this.offset = this.dimensionMultiplier;
    }
    else if (localResolutionDimension == this.oppositeDimension)
    {
      this.oppositeDimension = null;
      this.oppositeOffset = this.oppositeDimensionMultiplier;
    }
    resolve();
  }
  
  public void reset()
  {
    super.reset();
    this.target = null;
    this.offset = 0.0F;
    this.dimension = null;
    this.dimensionMultiplier = 1;
    this.oppositeDimension = null;
    this.oppositeDimensionMultiplier = 1;
    this.resolvedTarget = null;
    this.resolvedOffset = 0.0F;
    this.computedValue = 0.0F;
    this.opposite = null;
    this.oppositeOffset = 0.0F;
    this.type = 0;
  }
  
  public void resolve()
  {
    int i = this.state;
    int j = 1;
    if (i == 1) {
      return;
    }
    i = this.type;
    if (i == 4) {
      return;
    }
    Object localObject1 = this.dimension;
    if (localObject1 != null)
    {
      if (((ResolutionNode)localObject1).state != 1) {
        return;
      }
      this.offset = (this.dimensionMultiplier * ((ResolutionDimension)localObject1).value);
    }
    localObject1 = this.oppositeDimension;
    if (localObject1 != null)
    {
      if (((ResolutionNode)localObject1).state != 1) {
        return;
      }
      this.oppositeOffset = (this.oppositeDimensionMultiplier * ((ResolutionDimension)localObject1).value);
    }
    if (i == 1)
    {
      localObject1 = this.target;
      if ((localObject1 == null) || (((ResolutionNode)localObject1).state == 1))
      {
        if (localObject1 == null)
        {
          this.resolvedTarget = this;
          this.resolvedOffset = this.offset;
        }
        else
        {
          this.resolvedTarget = ((ResolutionAnchor)localObject1).resolvedTarget;
          this.resolvedOffset = (((ResolutionAnchor)localObject1).resolvedOffset + this.offset);
        }
        didResolve();
        return;
      }
    }
    Object localObject2;
    ResolutionAnchor localResolutionAnchor;
    if (i == 2)
    {
      localObject1 = this.target;
      if ((localObject1 != null) && (((ResolutionNode)localObject1).state == 1))
      {
        localObject1 = this.opposite;
        if (localObject1 != null)
        {
          localObject1 = ((ResolutionAnchor)localObject1).target;
          if ((localObject1 != null) && (((ResolutionNode)localObject1).state == 1))
          {
            if (LinearSystem.getMetrics() != null)
            {
              localObject1 = LinearSystem.getMetrics();
              ((Metrics)localObject1).centerConnectionResolved += 1L;
            }
            localObject1 = this.target;
            this.resolvedTarget = ((ResolutionAnchor)localObject1).resolvedTarget;
            localObject2 = this.opposite;
            localResolutionAnchor = ((ResolutionAnchor)localObject2).target;
            ((ResolutionAnchor)localObject2).resolvedTarget = localResolutionAnchor.resolvedTarget;
            ConstraintAnchor localConstraintAnchor = this.myAnchor;
            localObject2 = localConstraintAnchor.mType;
            ConstraintAnchor.Type localType = ConstraintAnchor.Type.RIGHT;
            int k = 0;
            i = j;
            if (localObject2 != localType) {
              if (localObject2 == ConstraintAnchor.Type.BOTTOM) {
                i = j;
              } else {
                i = 0;
              }
            }
            float f1;
            if (i != 0) {
              f1 = ((ResolutionAnchor)localObject1).resolvedOffset - localResolutionAnchor.resolvedOffset;
            } else {
              f1 = localResolutionAnchor.resolvedOffset - ((ResolutionAnchor)localObject1).resolvedOffset;
            }
            if ((localObject2 != ConstraintAnchor.Type.LEFT) && (localObject2 != localType))
            {
              f2 = f1 - localConstraintAnchor.mOwner.getHeight();
              f1 = this.myAnchor.mOwner.mVerticalBiasPercent;
            }
            else
            {
              f2 = f1 - localConstraintAnchor.mOwner.getWidth();
              f1 = this.myAnchor.mOwner.mHorizontalBiasPercent;
            }
            int m = this.myAnchor.getMargin();
            j = this.opposite.myAnchor.getMargin();
            if (this.myAnchor.getTarget() == this.opposite.myAnchor.getTarget())
            {
              f1 = 0.5F;
              j = 0;
            }
            else
            {
              k = m;
            }
            float f3 = k;
            float f4 = j;
            float f2 = f2 - f3 - f4;
            if (i != 0)
            {
              localObject1 = this.opposite;
              ((ResolutionAnchor)localObject1).resolvedOffset = (((ResolutionAnchor)localObject1).target.resolvedOffset + f4 + f2 * f1);
              this.resolvedOffset = (this.target.resolvedOffset - f3 - f2 * (1.0F - f1));
            }
            else
            {
              this.resolvedOffset = (this.target.resolvedOffset + f3 + f2 * f1);
              localObject1 = this.opposite;
              ((ResolutionAnchor)localObject1).resolvedOffset = (((ResolutionAnchor)localObject1).target.resolvedOffset - f4 - f2 * (1.0F - f1));
            }
            didResolve();
            this.opposite.didResolve();
            return;
          }
        }
      }
    }
    if (i == 3)
    {
      localObject1 = this.target;
      if ((localObject1 != null) && (((ResolutionNode)localObject1).state == 1))
      {
        localObject1 = this.opposite;
        if (localObject1 != null)
        {
          localObject1 = ((ResolutionAnchor)localObject1).target;
          if ((localObject1 != null) && (((ResolutionNode)localObject1).state == 1))
          {
            if (LinearSystem.getMetrics() != null)
            {
              localObject1 = LinearSystem.getMetrics();
              ((Metrics)localObject1).matchConnectionResolved += 1L;
            }
            localObject1 = this.target;
            this.resolvedTarget = ((ResolutionAnchor)localObject1).resolvedTarget;
            localResolutionAnchor = this.opposite;
            localObject2 = localResolutionAnchor.target;
            localResolutionAnchor.resolvedTarget = ((ResolutionAnchor)localObject2).resolvedTarget;
            this.resolvedOffset = (((ResolutionAnchor)localObject1).resolvedOffset + this.offset);
            localResolutionAnchor.resolvedOffset = (((ResolutionAnchor)localObject2).resolvedOffset + localResolutionAnchor.offset);
            didResolve();
            this.opposite.didResolve();
            return;
          }
        }
      }
    }
    if (i == 5) {
      this.myAnchor.mOwner.resolve();
    }
  }
  
  public void resolve(ResolutionAnchor paramResolutionAnchor, float paramFloat)
  {
    int i = this.state;
    if ((i == 0) || ((this.resolvedTarget != paramResolutionAnchor) && (this.resolvedOffset != paramFloat)))
    {
      this.resolvedTarget = paramResolutionAnchor;
      this.resolvedOffset = paramFloat;
      if (i == 1) {
        invalidate();
      }
      didResolve();
    }
  }
  
  String sType(int paramInt)
  {
    if (paramInt == 1) {
      return "DIRECT";
    }
    if (paramInt == 2) {
      return "CENTER";
    }
    if (paramInt == 3) {
      return "MATCH";
    }
    if (paramInt == 4) {
      return "CHAIN";
    }
    if (paramInt == 5) {
      return "BARRIER";
    }
    return "UNCONNECTED";
  }
  
  public void setOpposite(ResolutionAnchor paramResolutionAnchor, float paramFloat)
  {
    this.opposite = paramResolutionAnchor;
    this.oppositeOffset = paramFloat;
  }
  
  public void setOpposite(ResolutionAnchor paramResolutionAnchor, int paramInt, ResolutionDimension paramResolutionDimension)
  {
    this.opposite = paramResolutionAnchor;
    this.oppositeDimension = paramResolutionDimension;
    this.oppositeDimensionMultiplier = paramInt;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
  
  public String toString()
  {
    if (this.state == 1)
    {
      if (this.resolvedTarget == this)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[");
        localStringBuilder.append(this.myAnchor);
        localStringBuilder.append(", RESOLVED: ");
        localStringBuilder.append(this.resolvedOffset);
        localStringBuilder.append("]  type: ");
        localStringBuilder.append(sType(this.type));
        return localStringBuilder.toString();
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.myAnchor);
      localStringBuilder.append(", RESOLVED: ");
      localStringBuilder.append(this.resolvedTarget);
      localStringBuilder.append(":");
      localStringBuilder.append(this.resolvedOffset);
      localStringBuilder.append("] type: ");
      localStringBuilder.append(sType(this.type));
      return localStringBuilder.toString();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{ ");
    localStringBuilder.append(this.myAnchor);
    localStringBuilder.append(" UNRESOLVED} type: ");
    localStringBuilder.append(sType(this.type));
    return localStringBuilder.toString();
  }
  
  public void update()
  {
    ConstraintAnchor localConstraintAnchor = this.myAnchor.getTarget();
    if (localConstraintAnchor == null) {
      return;
    }
    if (localConstraintAnchor.getTarget() == this.myAnchor)
    {
      this.type = 4;
      localConstraintAnchor.getResolutionNode().type = 4;
    }
    int i = this.myAnchor.getMargin();
    ConstraintAnchor.Type localType = this.myAnchor.mType;
    int j;
    if (localType != ConstraintAnchor.Type.RIGHT)
    {
      j = i;
      if (localType != ConstraintAnchor.Type.BOTTOM) {}
    }
    else
    {
      j = -i;
    }
    dependsOn(localConstraintAnchor.getResolutionNode(), j);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\solver\widgets\ResolutionAnchor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */