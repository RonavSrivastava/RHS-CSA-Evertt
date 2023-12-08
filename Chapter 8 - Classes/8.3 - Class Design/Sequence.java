public class Sequence {
    public int first;
    public int d;

    public Sequence(int first, int d) {
        this.first = first;
        this.d = d;
    }

    public int sum(int num) {
        //formula = average of first and last * number of numbers
        int last = (first + (num-1)*d);
        return (int) (((first + last)/2)*num);
    }

    public String toString(int num) {
        String output = "";
        for(int i = 0; i < num; i++) {
            output += first + i*d + ", ";
        }
        output += " ...";
        return output;
    }

    public String toString() {
        return toString(5);
    }
}