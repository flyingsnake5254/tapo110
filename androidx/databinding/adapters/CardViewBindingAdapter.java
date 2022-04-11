package androidx.databinding.adapters;

import androidx.annotation.RestrictTo;
import androidx.cardview.widget.CardView;
import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingMethods;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
@BindingMethods({@androidx.databinding.BindingMethod(attribute="cardCornerRadius", method="setRadius", type=CardView.class), @androidx.databinding.BindingMethod(attribute="cardMaxElevation", method="setMaxCardElevation", type=CardView.class), @androidx.databinding.BindingMethod(attribute="cardPreventCornerOverlap", method="setPreventCornerOverlap", type=CardView.class), @androidx.databinding.BindingMethod(attribute="cardUseCompatPadding", method="setUseCompatPadding", type=CardView.class)})
public class CardViewBindingAdapter
{
  @BindingAdapter({"contentPadding"})
  public static void setContentPadding(CardView paramCardView, int paramInt)
  {
    paramCardView.setContentPadding(paramInt, paramInt, paramInt, paramInt);
  }
  
  @BindingAdapter({"contentPaddingBottom"})
  public static void setContentPaddingBottom(CardView paramCardView, int paramInt)
  {
    paramCardView.setContentPadding(paramCardView.getContentPaddingLeft(), paramCardView.getContentPaddingTop(), paramCardView.getContentPaddingRight(), paramInt);
  }
  
  @BindingAdapter({"contentPaddingLeft"})
  public static void setContentPaddingLeft(CardView paramCardView, int paramInt)
  {
    paramCardView.setContentPadding(paramInt, paramCardView.getContentPaddingTop(), paramCardView.getContentPaddingRight(), paramCardView.getContentPaddingBottom());
  }
  
  @BindingAdapter({"contentPaddingRight"})
  public static void setContentPaddingRight(CardView paramCardView, int paramInt)
  {
    paramCardView.setContentPadding(paramCardView.getContentPaddingLeft(), paramCardView.getContentPaddingTop(), paramInt, paramCardView.getContentPaddingBottom());
  }
  
  @BindingAdapter({"contentPaddingTop"})
  public static void setContentPaddingTop(CardView paramCardView, int paramInt)
  {
    paramCardView.setContentPadding(paramCardView.getContentPaddingLeft(), paramInt, paramCardView.getContentPaddingRight(), paramCardView.getContentPaddingBottom());
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\adapters\CardViewBindingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */