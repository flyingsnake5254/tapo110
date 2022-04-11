package androidx.transition;

import android.util.SparseArray;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;

class TransitionValuesMaps
{
  final SparseArray<View> mIdValues = new SparseArray();
  final LongSparseArray<View> mItemIdValues = new LongSparseArray();
  final ArrayMap<String, View> mNameValues = new ArrayMap();
  final ArrayMap<View, TransitionValues> mViewValues = new ArrayMap();
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\transition\TransitionValuesMaps.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */