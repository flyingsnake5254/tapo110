package androidx.core.view.accessibility;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

public final class AccessibilityClickableSpanCompat
  extends ClickableSpan
{
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public static final String SPAN_ID = "ACCESSIBILITY_CLICKABLE_SPAN_ID";
  private final int mClickableSpanActionId;
  private final AccessibilityNodeInfoCompat mNodeInfoCompat;
  private final int mOriginalClickableSpanId;
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public AccessibilityClickableSpanCompat(int paramInt1, AccessibilityNodeInfoCompat paramAccessibilityNodeInfoCompat, int paramInt2)
  {
    this.mOriginalClickableSpanId = paramInt1;
    this.mNodeInfoCompat = paramAccessibilityNodeInfoCompat;
    this.mClickableSpanActionId = paramInt2;
  }
  
  public void onClick(@NonNull View paramView)
  {
    paramView = new Bundle();
    paramView.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.mOriginalClickableSpanId);
    this.mNodeInfoCompat.performAction(this.mClickableSpanActionId, paramView);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\view\accessibility\AccessibilityClickableSpanCompat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */