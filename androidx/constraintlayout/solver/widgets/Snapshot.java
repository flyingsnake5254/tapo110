package androidx.constraintlayout.solver.widgets;

import java.util.ArrayList;

public class Snapshot
{
  private ArrayList<Connection> mConnections = new ArrayList();
  private int mHeight;
  private int mWidth;
  private int mX;
  private int mY;
  
  public Snapshot(ConstraintWidget paramConstraintWidget)
  {
    this.mX = paramConstraintWidget.getX();
    this.mY = paramConstraintWidget.getY();
    this.mWidth = paramConstraintWidget.getWidth();
    this.mHeight = paramConstraintWidget.getHeight();
    ArrayList localArrayList = paramConstraintWidget.getAnchors();
    int i = localArrayList.size();
    for (int j = 0; j < i; j++)
    {
      paramConstraintWidget = (ConstraintAnchor)localArrayList.get(j);
      this.mConnections.add(new Connection(paramConstraintWidget));
    }
  }
  
  public void applyTo(ConstraintWidget paramConstraintWidget)
  {
    paramConstraintWidget.setX(this.mX);
    paramConstraintWidget.setY(this.mY);
    paramConstraintWidget.setWidth(this.mWidth);
    paramConstraintWidget.setHeight(this.mHeight);
    int i = this.mConnections.size();
    for (int j = 0; j < i; j++) {
      ((Connection)this.mConnections.get(j)).applyTo(paramConstraintWidget);
    }
  }
  
  public void updateFrom(ConstraintWidget paramConstraintWidget)
  {
    this.mX = paramConstraintWidget.getX();
    this.mY = paramConstraintWidget.getY();
    this.mWidth = paramConstraintWidget.getWidth();
    this.mHeight = paramConstraintWidget.getHeight();
    int i = this.mConnections.size();
    for (int j = 0; j < i; j++) {
      ((Connection)this.mConnections.get(j)).updateFrom(paramConstraintWidget);
    }
  }
  
  static class Connection
  {
    private ConstraintAnchor mAnchor;
    private int mCreator;
    private int mMargin;
    private ConstraintAnchor.Strength mStrengh;
    private ConstraintAnchor mTarget;
    
    public Connection(ConstraintAnchor paramConstraintAnchor)
    {
      this.mAnchor = paramConstraintAnchor;
      this.mTarget = paramConstraintAnchor.getTarget();
      this.mMargin = paramConstraintAnchor.getMargin();
      this.mStrengh = paramConstraintAnchor.getStrength();
      this.mCreator = paramConstraintAnchor.getConnectionCreator();
    }
    
    public void applyTo(ConstraintWidget paramConstraintWidget)
    {
      paramConstraintWidget.getAnchor(this.mAnchor.getType()).connect(this.mTarget, this.mMargin, this.mStrengh, this.mCreator);
    }
    
    public void updateFrom(ConstraintWidget paramConstraintWidget)
    {
      paramConstraintWidget = paramConstraintWidget.getAnchor(this.mAnchor.getType());
      this.mAnchor = paramConstraintWidget;
      if (paramConstraintWidget != null)
      {
        this.mTarget = paramConstraintWidget.getTarget();
        this.mMargin = this.mAnchor.getMargin();
        this.mStrengh = this.mAnchor.getStrength();
        this.mCreator = this.mAnchor.getConnectionCreator();
      }
      else
      {
        this.mTarget = null;
        this.mMargin = 0;
        this.mStrengh = ConstraintAnchor.Strength.STRONG;
        this.mCreator = 0;
      }
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\solver\widgets\Snapshot.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */