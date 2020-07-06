// Merge Intervals - Given a list of intervals, merge all overlapping intervals. 
// At the end of the merge, there should be no overlapping intervals.

// Q. Can we assume the time as an integer (e.g, Unix timestamp)?
// A. Yes  (This makes the code simpler, you don't have to mess with Date/Day time formats)
// Q. Can we assume that all intervals will be valid, i.e, no out of order elements?
// A. Yes, you can assume that.
// Q. If two intervals overlap on a single point, e.g., ​(1,3) and (3,5)​, ​ do those count as overlappingintervals?
// A. Yes, that counts as overlapping intervals.

//solution is line sweep first sort and thn sweep and while sweeping we maintian the count

// turn intervals into points and sort points
// num_intervals = 0
// currentStart = null
// for each point:     
//     if point is start:         
//     num_intervals++         
//     if num_intervals is 1:     // so if numinterval becomes 2 we ignore so it's merged
//          currentStart = point
//     else if point is end:
//          num_intervals--
//          if num_intervals is 0:
//               output new interval<currentStart, point> 


public static List<Interval> hasOverlap(Interval[] intervals) {    
    
    // Turn Intervals into Points    
    List<Point> points = new ArrayList<Point>();    
    for (Interval interval : intervals) {        
        points.add(new Point(interval.getStart(), true /*isStart*/));        
        points.add(new Point(interval.getEnd(), false /*isStart*/));    
    }    
    
    // Sort the Points in order of time    
    // ​Sort order is defined by the Comparable interface, which Point implements    
    Collections.sort(points);    
    
    List<Interval> result = new ArrayList<Interval>();    
    // Loop through Points 

    int numIntervals = 0;    
    Point startPoint = null;    
    for (int i = 0; i < points.size(); i++) {        
        Point point = points.get(i);        
        if (point.isStart()) { 
            // new interval           
            numIntervals++;
            // ignotring when start interval becomes 2 will give us merged interval            
            if (numIntervals == 1)                
                startPoint = point;        
            } else {              
                // end of interval            
                numIntervals--;            
                if (numIntervals == 0)
                    ​result.add(newInterval(startPoint.getTime(),point.getTime()));        
                }    
            }    
            return result;
}


public static class Interval {    
    int start;    
    int end;    
    
    public Interval(int start, int end) {
        super();        
        this.start = start;        
        this.end = end;    
    }    
    
    public int getStart() {        
        return start;    
    }    
    
    public int getEnd() {        
        return end;    
    }
}

//comparable interface for sorting
public static class Point implements Comparable<Point> {    
    int time;    
    boolean isStart;   

    public Point(int time, boolean isStart) {        
        super();        
        this.time = time;        
        this.isStart = isStart;    
    }    
    
    public int getTime() {        
        return time;    
    }    
    
    public boolean isStart() {        
        return isStart;    
    }    
    
    @Override
    public int compareTo(Point other) {        
        if (time == other.getTime()) {            
            if (isStart == other.isStart()) {                
                return 0;            
            } else {                
                return isStart ? -1 : 1;            
            }        
        }       
    return time > other.getTime() ? 1 : -1;    
    }
}