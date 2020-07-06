// Given a list of time intervals, find if any of them overlap.

// Questions to Clarify:
// Q. Do the time intervals contain start and stop times?
// A. Yes
// Q. Can we assume the time as an integer (e.g, Unix timestamp)?
// A. Yes  
// Q. If event A ends at time T, and event B starts at time T, is that considered an overlap?
// A. Yes, if they overlap even for 1 point, we will consider it an overlap.

// The concept is simple: You sort the intervals in order, and then sweep through them, like aline sweeping across a timeline.

// Remember​: The common sequence in most Line Sweep solutions is:          
// 1. break down intervals into points,         
//  2. sort the points, and          
// 3. loop through them.
// 1 a 2 3 b c  (1 is start, a is end 2 and 3 both start so overlap)

// ime Complexity:​ O(NlogN) to sort the points

public static boolean hasOverlap(Interval[] intervals) {    
    // Turn Intervals into Points    
    
    List<Point> points = new ArrayList<Point>();    

    // citerating though interval and adding it to point (point DS also maintains if it is start or not)
    for (Interval interval : intervals) {        
        points.add(new Point(interval.getStart(), true /*isStart*/));        
        points.add(new Point(interval.getEnd(), false /*isStart*/));        
    }    
    
    // Sort the Points in order of time    
    // Sort order is defined by the Comparable interface, which Point implements    
    Collections.sort(points);    
    
    // Loop through Points    
    int count = 0;    
    for (int i = 0; i < points.size(); i++) {
        // if start add one poitn and if end -1 point at any point if count is greter thn 1 thn we have overlap        
        count = points.get(i).isStart() ? count + 1 : count - 1;        
        if (count > 1)            
            return true;    
        }    
    return false;
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