package androidx.appcompat.widget;

import android.content.Context;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.util.Preconditions;

final class AppCompatTextClassifierHelper
{
  @Nullable
  private TextClassifier mTextClassifier;
  @NonNull
  private TextView mTextView;
  
  AppCompatTextClassifierHelper(@NonNull TextView paramTextView)
  {
    this.mTextView = ((TextView)Preconditions.checkNotNull(paramTextView));
  }
  
  @NonNull
  @RequiresApi(api=26)
  public TextClassifier getTextClassifier()
  {
    TextClassifier localTextClassifier = this.mTextClassifier;
    Object localObject = localTextClassifier;
    if (localTextClassifier == null)
    {
      localObject = (TextClassificationManager)this.mTextView.getContext().getSystemService(TextClassificationManager.class);
      if (localObject != null) {
        return ((TextClassificationManager)localObject).getTextClassifier();
      }
      localObject = TextClassifier.NO_OP;
    }
    return (TextClassifier)localObject;
  }
  
  @RequiresApi(api=26)
  public void setTextClassifier(@Nullable TextClassifier paramTextClassifier)
  {
    this.mTextClassifier = paramTextClassifier;
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\appcompat\widget\AppCompatTextClassifierHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */