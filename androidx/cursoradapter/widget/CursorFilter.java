package androidx.cursoradapter.widget;

import android.database.Cursor;
import android.widget.Filter;
import android.widget.Filter.FilterResults;

class CursorFilter
  extends Filter
{
  CursorFilterClient mClient;
  
  CursorFilter(CursorFilterClient paramCursorFilterClient)
  {
    this.mClient = paramCursorFilterClient;
  }
  
  public CharSequence convertResultToString(Object paramObject)
  {
    return this.mClient.convertToString((Cursor)paramObject);
  }
  
  protected Filter.FilterResults performFiltering(CharSequence paramCharSequence)
  {
    paramCharSequence = this.mClient.runQueryOnBackgroundThread(paramCharSequence);
    Filter.FilterResults localFilterResults = new Filter.FilterResults();
    if (paramCharSequence != null)
    {
      localFilterResults.count = paramCharSequence.getCount();
      localFilterResults.values = paramCharSequence;
    }
    else
    {
      localFilterResults.count = 0;
      localFilterResults.values = null;
    }
    return localFilterResults;
  }
  
  protected void publishResults(CharSequence paramCharSequence, Filter.FilterResults paramFilterResults)
  {
    paramCharSequence = this.mClient.getCursor();
    paramFilterResults = paramFilterResults.values;
    if ((paramFilterResults != null) && (paramFilterResults != paramCharSequence)) {
      this.mClient.changeCursor((Cursor)paramFilterResults);
    }
  }
  
  static abstract interface CursorFilterClient
  {
    public abstract void changeCursor(Cursor paramCursor);
    
    public abstract CharSequence convertToString(Cursor paramCursor);
    
    public abstract Cursor getCursor();
    
    public abstract Cursor runQueryOnBackgroundThread(CharSequence paramCharSequence);
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\androidx\cursoradapter\widget\CursorFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */