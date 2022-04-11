package okio;

import javax.annotation.Nullable;

final class SegmentPool
{
  static final long MAX_SIZE = 65536L;
  static long byteCount;
  @Nullable
  static Segment next;
  
  static void recycle(Segment paramSegment)
  {
    if ((paramSegment.next == null) && (paramSegment.prev == null))
    {
      if (paramSegment.shared) {
        return;
      }
      try
      {
        long l = byteCount;
        if (l + 8192L > 65536L) {
          return;
        }
        byteCount = l + 8192L;
        paramSegment.next = next;
        paramSegment.limit = 0;
        paramSegment.pos = 0;
        next = paramSegment;
        return;
      }
      finally {}
    }
    throw new IllegalArgumentException();
  }
  
  static Segment take()
  {
    try
    {
      Segment localSegment = next;
      if (localSegment != null)
      {
        next = localSegment.next;
        localSegment.next = null;
        byteCount -= 8192L;
        return localSegment;
      }
      return new Segment();
    }
    finally {}
  }
}


/* Location:              C:\Users\User\Desktop\decompile\jdgui110\Tapojar.jar!\okio\SegmentPool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */