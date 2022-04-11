package androidx.core.os;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;

abstract interface LocaleListInterface
{
  public abstract Locale get(int paramInt);
  
  @Nullable
  public abstract Locale getFirstMatch(@NonNull String[] paramArrayOfString);
  
  public abstract Object getLocaleList();
  
  @IntRange(from=-1L)
  public abstract int indexOf(Locale paramLocale);
  
  public abstract boolean isEmpty();
  
  @IntRange(from=0L)
  public abstract int size();
  
  public abstract String toLanguageTags();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\core\os\LocaleListInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */