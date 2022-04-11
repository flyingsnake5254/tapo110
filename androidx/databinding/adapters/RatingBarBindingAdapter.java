package androidx.databinding.adapters;

import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import androidx.annotation.RestrictTo;
import androidx.databinding.BindingAdapter;
import androidx.databinding.InverseBindingListener;
import androidx.databinding.InverseBindingMethods;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
@InverseBindingMethods({@androidx.databinding.InverseBindingMethod(attribute="android:rating", type=RatingBar.class)})
public class RatingBarBindingAdapter
{
  @BindingAdapter(requireAll=false, value={"android:onRatingChanged", "android:ratingAttrChanged"})
  public static void setListeners(RatingBar paramRatingBar, RatingBar.OnRatingBarChangeListener paramOnRatingBarChangeListener, final InverseBindingListener paramInverseBindingListener)
  {
    if (paramInverseBindingListener == null) {
      paramRatingBar.setOnRatingBarChangeListener(paramOnRatingBarChangeListener);
    } else {
      paramRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener()
      {
        public void onRatingChanged(RatingBar paramAnonymousRatingBar, float paramAnonymousFloat, boolean paramAnonymousBoolean)
        {
          RatingBar.OnRatingBarChangeListener localOnRatingBarChangeListener = this.val$listener;
          if (localOnRatingBarChangeListener != null) {
            localOnRatingBarChangeListener.onRatingChanged(paramAnonymousRatingBar, paramAnonymousFloat, paramAnonymousBoolean);
          }
          paramInverseBindingListener.onChange();
        }
      });
    }
  }
  
  @BindingAdapter({"android:rating"})
  public static void setRating(RatingBar paramRatingBar, float paramFloat)
  {
    if (paramRatingBar.getRating() != paramFloat) {
      paramRatingBar.setRating(paramFloat);
    }
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\databinding\adapters\RatingBarBindingAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */