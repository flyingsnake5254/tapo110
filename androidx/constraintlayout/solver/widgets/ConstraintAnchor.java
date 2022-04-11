package androidx.constraintlayout.solver.widgets;

import androidx.constraintlayout.solver.Cache;
import androidx.constraintlayout.solver.SolverVariable;
import androidx.constraintlayout.solver.SolverVariable.Type;
import java.util.ArrayList;
import java.util.HashSet;

public class ConstraintAnchor
{
  private static final boolean ALLOW_BINARY = false;
  public static final int AUTO_CONSTRAINT_CREATOR = 2;
  public static final int SCOUT_CREATOR = 1;
  private static final int UNSET_GONE_MARGIN = -1;
  public static final int USER_CREATOR = 0;
  private int mConnectionCreator = 0;
  private ConnectionType mConnectionType = ConnectionType.RELAXED;
  int mGoneMargin = -1;
  public int mMargin = 0;
  final ConstraintWidget mOwner;
  private ResolutionAnchor mResolutionAnchor = new ResolutionAnchor(this);
  SolverVariable mSolverVariable;
  private Strength mStrength = Strength.NONE;
  ConstraintAnchor mTarget;
  final Type mType;
  
  public ConstraintAnchor(ConstraintWidget paramConstraintWidget, Type paramType)
  {
    this.mOwner = paramConstraintWidget;
    this.mType = paramType;
  }
  
  private boolean isConnectionToMe(ConstraintWidget paramConstraintWidget, HashSet<ConstraintWidget> paramHashSet)
  {
    if (paramHashSet.contains(paramConstraintWidget)) {
      return false;
    }
    paramHashSet.add(paramConstraintWidget);
    if (paramConstraintWidget == getOwner()) {
      return true;
    }
    paramConstraintWidget = paramConstraintWidget.getAnchors();
    int i = paramConstraintWidget.size();
    for (int j = 0; j < i; j++)
    {
      ConstraintAnchor localConstraintAnchor = (ConstraintAnchor)paramConstraintWidget.get(j);
      if ((localConstraintAnchor.isSimilarDimensionConnection(this)) && (localConstraintAnchor.isConnected()) && (isConnectionToMe(localConstraintAnchor.getTarget().getOwner(), paramHashSet))) {
        return true;
      }
    }
    return false;
  }
  
  public boolean connect(ConstraintAnchor paramConstraintAnchor, int paramInt)
  {
    return connect(paramConstraintAnchor, paramInt, -1, Strength.STRONG, 0, false);
  }
  
  public boolean connect(ConstraintAnchor paramConstraintAnchor, int paramInt1, int paramInt2)
  {
    return connect(paramConstraintAnchor, paramInt1, -1, Strength.STRONG, paramInt2, false);
  }
  
  public boolean connect(ConstraintAnchor paramConstraintAnchor, int paramInt1, int paramInt2, Strength paramStrength, int paramInt3, boolean paramBoolean)
  {
    if (paramConstraintAnchor == null)
    {
      this.mTarget = null;
      this.mMargin = 0;
      this.mGoneMargin = -1;
      this.mStrength = Strength.NONE;
      this.mConnectionCreator = 2;
      return true;
    }
    if ((!paramBoolean) && (!isValidConnection(paramConstraintAnchor))) {
      return false;
    }
    this.mTarget = paramConstraintAnchor;
    if (paramInt1 > 0) {
      this.mMargin = paramInt1;
    } else {
      this.mMargin = 0;
    }
    this.mGoneMargin = paramInt2;
    this.mStrength = paramStrength;
    this.mConnectionCreator = paramInt3;
    return true;
  }
  
  public boolean connect(ConstraintAnchor paramConstraintAnchor, int paramInt1, Strength paramStrength, int paramInt2)
  {
    return connect(paramConstraintAnchor, paramInt1, -1, paramStrength, paramInt2, false);
  }
  
  public int getConnectionCreator()
  {
    return this.mConnectionCreator;
  }
  
  public ConnectionType getConnectionType()
  {
    return this.mConnectionType;
  }
  
  public int getMargin()
  {
    if (this.mOwner.getVisibility() == 8) {
      return 0;
    }
    if (this.mGoneMargin > -1)
    {
      ConstraintAnchor localConstraintAnchor = this.mTarget;
      if ((localConstraintAnchor != null) && (localConstraintAnchor.mOwner.getVisibility() == 8)) {
        return this.mGoneMargin;
      }
    }
    return this.mMargin;
  }
  
  public final ConstraintAnchor getOpposite()
  {
    switch (1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()])
    {
    default: 
      throw new AssertionError(this.mType.name());
    case 5: 
      return this.mOwner.mTop;
    case 4: 
      return this.mOwner.mBottom;
    case 3: 
      return this.mOwner.mLeft;
    case 2: 
      return this.mOwner.mRight;
    }
    return null;
  }
  
  public ConstraintWidget getOwner()
  {
    return this.mOwner;
  }
  
  public int getPriorityLevel()
  {
    switch (1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()])
    {
    default: 
      throw new AssertionError(this.mType.name());
    case 7: 
    case 8: 
    case 9: 
      return 0;
    case 6: 
      return 1;
    }
    return 2;
  }
  
  public ResolutionAnchor getResolutionNode()
  {
    return this.mResolutionAnchor;
  }
  
  public int getSnapPriorityLevel()
  {
    switch (1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()])
    {
    default: 
      throw new AssertionError(this.mType.name());
    case 9: 
      return 0;
    case 8: 
      return 1;
    case 7: 
      return 0;
    case 6: 
      return 2;
    case 4: 
    case 5: 
      return 0;
    case 2: 
    case 3: 
      return 1;
    }
    return 3;
  }
  
  public SolverVariable getSolverVariable()
  {
    return this.mSolverVariable;
  }
  
  public Strength getStrength()
  {
    return this.mStrength;
  }
  
  public ConstraintAnchor getTarget()
  {
    return this.mTarget;
  }
  
  public Type getType()
  {
    return this.mType;
  }
  
  public boolean isConnected()
  {
    boolean bool;
    if (this.mTarget != null) {
      bool = true;
    } else {
      bool = false;
    }
    return bool;
  }
  
  public boolean isConnectionAllowed(ConstraintWidget paramConstraintWidget)
  {
    if (isConnectionToMe(paramConstraintWidget, new HashSet())) {
      return false;
    }
    ConstraintWidget localConstraintWidget = getOwner().getParent();
    if (localConstraintWidget == paramConstraintWidget) {
      return true;
    }
    return paramConstraintWidget.getParent() == localConstraintWidget;
  }
  
  public boolean isConnectionAllowed(ConstraintWidget paramConstraintWidget, ConstraintAnchor paramConstraintAnchor)
  {
    return isConnectionAllowed(paramConstraintWidget);
  }
  
  public boolean isSideAnchor()
  {
    switch (1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()])
    {
    default: 
      throw new AssertionError(this.mType.name());
    case 2: 
    case 3: 
    case 4: 
    case 5: 
      return true;
    }
    return false;
  }
  
  public boolean isSimilarDimensionConnection(ConstraintAnchor paramConstraintAnchor)
  {
    paramConstraintAnchor = paramConstraintAnchor.getType();
    Type localType = this.mType;
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool3 = true;
    if (paramConstraintAnchor == localType) {
      return true;
    }
    switch (1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[localType.ordinal()])
    {
    default: 
      throw new AssertionError(this.mType.name());
    case 9: 
      return false;
    case 4: 
    case 5: 
    case 6: 
    case 8: 
      bool2 = bool3;
      if (paramConstraintAnchor != Type.TOP)
      {
        bool2 = bool3;
        if (paramConstraintAnchor != Type.BOTTOM)
        {
          bool2 = bool3;
          if (paramConstraintAnchor != Type.CENTER_Y) {
            if (paramConstraintAnchor == Type.BASELINE) {
              bool2 = bool3;
            } else {
              bool2 = false;
            }
          }
        }
      }
      return bool2;
    case 2: 
    case 3: 
    case 7: 
      bool2 = bool1;
      if (paramConstraintAnchor != Type.LEFT)
      {
        bool2 = bool1;
        if (paramConstraintAnchor != Type.RIGHT) {
          if (paramConstraintAnchor == Type.CENTER_X) {
            bool2 = bool1;
          } else {
            bool2 = false;
          }
        }
      }
      return bool2;
    }
    if (paramConstraintAnchor == Type.BASELINE) {
      bool2 = false;
    }
    return bool2;
  }
  
  public boolean isSnapCompatibleWith(ConstraintAnchor paramConstraintAnchor)
  {
    Object localObject = this.mType;
    if (localObject == Type.CENTER) {
      return false;
    }
    if (localObject == paramConstraintAnchor.getType()) {
      return true;
    }
    localObject = 1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type;
    int i;
    switch (localObject[this.mType.ordinal()])
    {
    default: 
      throw new AssertionError(this.mType.name());
    case 8: 
      i = localObject[paramConstraintAnchor.getType().ordinal()];
      return (i == 4) || (i == 5);
    case 7: 
      i = localObject[paramConstraintAnchor.getType().ordinal()];
      return (i == 2) || (i == 3);
    case 5: 
      i = localObject[paramConstraintAnchor.getType().ordinal()];
      return (i == 4) || (i == 8);
    case 4: 
      i = localObject[paramConstraintAnchor.getType().ordinal()];
      return (i == 5) || (i == 8);
    case 3: 
      i = localObject[paramConstraintAnchor.getType().ordinal()];
      return (i == 2) || (i == 7);
    case 2: 
      i = localObject[paramConstraintAnchor.getType().ordinal()];
      return (i == 3) || (i == 7);
    }
    return false;
  }
  
  public boolean isValidConnection(ConstraintAnchor paramConstraintAnchor)
  {
    boolean bool1 = false;
    boolean bool2 = false;
    boolean bool3 = false;
    if (paramConstraintAnchor == null) {
      return false;
    }
    Type localType1 = paramConstraintAnchor.getType();
    Type localType2 = this.mType;
    if (localType1 == localType2) {
      return (localType2 != Type.BASELINE) || ((paramConstraintAnchor.getOwner().hasBaseline()) && (getOwner().hasBaseline()));
    }
    switch (1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[localType2.ordinal()])
    {
    default: 
      throw new AssertionError(this.mType.name());
    case 6: 
    case 7: 
    case 8: 
    case 9: 
      return false;
    case 4: 
    case 5: 
      if ((localType1 != Type.TOP) && (localType1 != Type.BOTTOM)) {
        bool4 = false;
      } else {
        bool4 = true;
      }
      bool2 = bool4;
      if ((paramConstraintAnchor.getOwner() instanceof Guideline))
      {
        if (!bool4)
        {
          bool4 = bool3;
          if (localType1 != Type.CENTER_Y) {}
        }
        else
        {
          bool4 = true;
        }
        bool2 = bool4;
      }
      return bool2;
    case 2: 
    case 3: 
      if ((localType1 != Type.LEFT) && (localType1 != Type.RIGHT)) {
        bool4 = false;
      } else {
        bool4 = true;
      }
      bool2 = bool4;
      if ((paramConstraintAnchor.getOwner() instanceof Guideline))
      {
        if (!bool4)
        {
          bool4 = bool1;
          if (localType1 != Type.CENTER_X) {}
        }
        else
        {
          bool4 = true;
        }
        bool2 = bool4;
      }
      return bool2;
    }
    boolean bool4 = bool2;
    if (localType1 != Type.BASELINE)
    {
      bool4 = bool2;
      if (localType1 != Type.CENTER_X)
      {
        bool4 = bool2;
        if (localType1 != Type.CENTER_Y) {
          bool4 = true;
        }
      }
    }
    return bool4;
  }
  
  public boolean isVerticalAnchor()
  {
    switch (1.$SwitchMap$androidx$constraintlayout$solver$widgets$ConstraintAnchor$Type[this.mType.ordinal()])
    {
    default: 
      throw new AssertionError(this.mType.name());
    case 4: 
    case 5: 
    case 6: 
    case 8: 
    case 9: 
      return true;
    }
    return false;
  }
  
  public void reset()
  {
    this.mTarget = null;
    this.mMargin = 0;
    this.mGoneMargin = -1;
    this.mStrength = Strength.STRONG;
    this.mConnectionCreator = 0;
    this.mConnectionType = ConnectionType.RELAXED;
    this.mResolutionAnchor.reset();
  }
  
  public void resetSolverVariable(Cache paramCache)
  {
    paramCache = this.mSolverVariable;
    if (paramCache == null) {
      this.mSolverVariable = new SolverVariable(SolverVariable.Type.UNRESTRICTED, null);
    } else {
      paramCache.reset();
    }
  }
  
  public void setConnectionCreator(int paramInt)
  {
    this.mConnectionCreator = paramInt;
  }
  
  public void setConnectionType(ConnectionType paramConnectionType)
  {
    this.mConnectionType = paramConnectionType;
  }
  
  public void setGoneMargin(int paramInt)
  {
    if (isConnected()) {
      this.mGoneMargin = paramInt;
    }
  }
  
  public void setMargin(int paramInt)
  {
    if (isConnected()) {
      this.mMargin = paramInt;
    }
  }
  
  public void setStrength(Strength paramStrength)
  {
    if (isConnected()) {
      this.mStrength = paramStrength;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mOwner.getDebugName());
    localStringBuilder.append(":");
    localStringBuilder.append(this.mType.toString());
    return localStringBuilder.toString();
  }
  
  public static enum ConnectionType
  {
    static
    {
      ConnectionType localConnectionType1 = new ConnectionType("RELAXED", 0);
      RELAXED = localConnectionType1;
      ConnectionType localConnectionType2 = new ConnectionType("STRICT", 1);
      STRICT = localConnectionType2;
      $VALUES = new ConnectionType[] { localConnectionType1, localConnectionType2 };
    }
  }
  
  public static enum Strength
  {
    static
    {
      Strength localStrength1 = new Strength("NONE", 0);
      NONE = localStrength1;
      Strength localStrength2 = new Strength("STRONG", 1);
      STRONG = localStrength2;
      Strength localStrength3 = new Strength("WEAK", 2);
      WEAK = localStrength3;
      $VALUES = new Strength[] { localStrength1, localStrength2, localStrength3 };
    }
  }
  
  public static enum Type
  {
    static
    {
      Type localType1 = new Type("NONE", 0);
      NONE = localType1;
      Type localType2 = new Type("LEFT", 1);
      LEFT = localType2;
      Type localType3 = new Type("TOP", 2);
      TOP = localType3;
      Type localType4 = new Type("RIGHT", 3);
      RIGHT = localType4;
      Type localType5 = new Type("BOTTOM", 4);
      BOTTOM = localType5;
      Type localType6 = new Type("BASELINE", 5);
      BASELINE = localType6;
      Type localType7 = new Type("CENTER", 6);
      CENTER = localType7;
      Type localType8 = new Type("CENTER_X", 7);
      CENTER_X = localType8;
      Type localType9 = new Type("CENTER_Y", 8);
      CENTER_Y = localType9;
      $VALUES = new Type[] { localType1, localType2, localType3, localType4, localType5, localType6, localType7, localType8, localType9 };
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\solver\widgets\ConstraintAnchor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */