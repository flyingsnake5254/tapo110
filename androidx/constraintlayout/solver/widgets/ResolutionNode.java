package androidx.constraintlayout.solver.widgets;

import java.util.HashSet;
import java.util.Iterator;

public class ResolutionNode
{
  public static final int REMOVED = 2;
  public static final int RESOLVED = 1;
  public static final int UNRESOLVED = 0;
  HashSet<ResolutionNode> dependents = new HashSet(2);
  int state = 0;
  
  public void addDependent(ResolutionNode paramResolutionNode)
  {
    this.dependents.add(paramResolutionNode);
  }
  
  public void didResolve()
  {
    this.state = 1;
    Iterator localIterator = this.dependents.iterator();
    while (localIterator.hasNext()) {
      ((ResolutionNode)localIterator.next()).resolve();
    }
  }
  
  public void invalidate()
  {
    this.state = 0;
    Iterator localIterator = this.dependents.iterator();
    while (localIterator.hasNext()) {
      ((ResolutionNode)localIterator.next()).invalidate();
    }
  }
  
  public void invalidateAnchors()
  {
    if ((this instanceof ResolutionAnchor)) {
      this.state = 0;
    }
    Iterator localIterator = this.dependents.iterator();
    while (localIterator.hasNext()) {
      ((ResolutionNode)localIterator.next()).invalidateAnchors();
    }
  }
  
  public boolean isResolved()
  {
    int i = this.state;
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    return bool;
  }
  
  public void remove(ResolutionDimension paramResolutionDimension) {}
  
  public void reset()
  {
    this.state = 0;
    this.dependents.clear();
  }
  
  public void resolve() {}
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\constraintlayout\solver\widgets\ResolutionNode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */