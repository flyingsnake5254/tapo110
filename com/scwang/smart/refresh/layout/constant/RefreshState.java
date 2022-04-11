package com.scwang.smart.refresh.layout.constant;

public enum RefreshState
{
  public final boolean isDragging;
  public final boolean isFinishing;
  public final boolean isFooter;
  public final boolean isHeader;
  public final boolean isOpening;
  public final boolean isReleaseToOpening;
  public final boolean isTwoLevel;
  
  static
  {
    RefreshState localRefreshState1 = new RefreshState("None", 0, 0, false, false, false, false, false);
    None = localRefreshState1;
    RefreshState localRefreshState2 = new RefreshState("PullDownToRefresh", 1, 1, true, false, false, false, false);
    PullDownToRefresh = localRefreshState2;
    RefreshState localRefreshState3 = new RefreshState("PullUpToLoad", 2, 2, true, false, false, false, false);
    PullUpToLoad = localRefreshState3;
    RefreshState localRefreshState4 = new RefreshState("PullDownCanceled", 3, 1, false, false, false, false, false);
    PullDownCanceled = localRefreshState4;
    RefreshState localRefreshState5 = new RefreshState("PullUpCanceled", 4, 2, false, false, false, false, false);
    PullUpCanceled = localRefreshState5;
    RefreshState localRefreshState6 = new RefreshState("ReleaseToRefresh", 5, 1, true, false, false, false, true);
    ReleaseToRefresh = localRefreshState6;
    RefreshState localRefreshState7 = new RefreshState("ReleaseToLoad", 6, 2, true, false, false, false, true);
    ReleaseToLoad = localRefreshState7;
    RefreshState localRefreshState8 = new RefreshState("ReleaseToTwoLevel", 7, 1, true, false, false, true, true);
    ReleaseToTwoLevel = localRefreshState8;
    RefreshState localRefreshState9 = new RefreshState("TwoLevelReleased", 8, 1, false, false, false, true, false);
    TwoLevelReleased = localRefreshState9;
    RefreshState localRefreshState10 = new RefreshState("RefreshReleased", 9, 1, false, false, false, false, false);
    RefreshReleased = localRefreshState10;
    RefreshState localRefreshState11 = new RefreshState("LoadReleased", 10, 2, false, false, false, false, false);
    LoadReleased = localRefreshState11;
    RefreshState localRefreshState12 = new RefreshState("Refreshing", 11, 1, false, true, false, false, false);
    Refreshing = localRefreshState12;
    RefreshState localRefreshState13 = new RefreshState("Loading", 12, 2, false, true, false, false, false);
    Loading = localRefreshState13;
    RefreshState localRefreshState14 = new RefreshState("TwoLevel", 13, 1, false, true, false, true, false);
    TwoLevel = localRefreshState14;
    RefreshState localRefreshState15 = new RefreshState("RefreshFinish", 14, 1, false, false, true, false, false);
    RefreshFinish = localRefreshState15;
    RefreshState localRefreshState16 = new RefreshState("LoadFinish", 15, 2, false, false, true, false, false);
    LoadFinish = localRefreshState16;
    RefreshState localRefreshState17 = new RefreshState("TwoLevelFinish", 16, 1, false, false, true, true, false);
    TwoLevelFinish = localRefreshState17;
    $VALUES = new RefreshState[] { localRefreshState1, localRefreshState2, localRefreshState3, localRefreshState4, localRefreshState5, localRefreshState6, localRefreshState7, localRefreshState8, localRefreshState9, localRefreshState10, localRefreshState11, localRefreshState12, localRefreshState13, localRefreshState14, localRefreshState15, localRefreshState16, localRefreshState17 };
  }
  
  private RefreshState(int paramInt, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    boolean bool1 = false;
    if (paramInt == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    this.isHeader = bool2;
    boolean bool2 = bool1;
    if (paramInt == 2) {
      bool2 = true;
    }
    this.isFooter = bool2;
    this.isDragging = paramBoolean1;
    this.isOpening = paramBoolean2;
    this.isFinishing = paramBoolean3;
    this.isTwoLevel = paramBoolean4;
    this.isReleaseToOpening = paramBoolean5;
  }
  
  public RefreshState toFooter()
  {
    if ((this.isHeader) && (!this.isTwoLevel)) {
      return values()[(ordinal() + 1)];
    }
    return this;
  }
  
  public RefreshState toHeader()
  {
    if ((this.isFooter) && (!this.isTwoLevel)) {
      return values()[(ordinal() - 1)];
    }
    return this;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\com\scwang\smart\refresh\layout\constant\RefreshState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */