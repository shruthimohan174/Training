package MergeIntervals;

public class Interval implements  Comparable<Interval>{
    int start, end;

    Interval(int start, int end)
    {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval o) {
        return Integer.compare(this.start, o.start);
    }
}