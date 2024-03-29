import java.util.ArrayList;

public class TitanicSimulator extends TitanicSimulatorBase {
    // Constructor(s)
    public TitanicSimulator() {
    }

    // Sorts students by the requested method, the returned list should contain the-
    //  number of students equal to 'studentCount' and ordered by the requested method.
    public ArrayList<Student> pickStudents(Skyward skyward, int studentCount, SortMethod sortMethod) {
        ArrayList<Student> s = sort(skyward.getStudents(), sortMethod);
        return copyFirstN(s, studentCount);
    }

    // private ArrayList<Student> sort(ArrayList<Student> s, SortMethod sortMethod) {
    //     for(int i = 1; i < s.size(); i++) {
    //         Student cur = s.remove(i);
    //         for(int j = 0; j < i; j++) {
    //             if(compareStudents(cur, s.get(j), sortMethod) < 0) {
    //                 s.add(j, cur); //insert
    //                 break;
    //             }
    //         }
    //     }
    //     System.out.println(s);
    //     return s;
    // }

    private ArrayList<Student> sort(ArrayList<Student> s, SortMethod sortMethod) {
        for(int i = 0; i < s.size(); i++) {
            int idx = 0;
            Student cur = s.get(i);
            for(int j = i; j < s.size(); j++) {
                if(compareStudents(cur, s.get(j), sortMethod) < 0) {
                    idx = j;
                    cur = s.get(j);
                }
            }
            s.remove(idx);
            s.add(0, cur);
        }
        System.out.println(s);
        return s;
    }
    
    // This is a helper method you can use. It compares two students using your the provided comparison method. 
    private int compareStudents(Student a, Student b, SortMethod sortMethod) {
        if (sortMethod == SortMethod.FIRST_NAME) {
            return a.getFirstName().toUpperCase().compareTo(b.getFirstName().toUpperCase());
        }
        else if (sortMethod == SortMethod.LAST_NAME) {
            return a.getLastName().toUpperCase().compareTo(b.getLastName().toUpperCase());
        }
        else if (sortMethod == SortMethod.STUDENT_ID) {
            return Integer.compare(a.getStudentId(), b.getStudentId());
        }
        else { // sortMethod == SortMethod.GRADE
            return Double.compare(b.getGrade(), a.getGrade());
        }
    }

    // Here's another helper method for you. It copies the first 'count' students into a new ArrayList for you.
    private ArrayList<Student> copyFirstN(ArrayList<Student> students, int count) {
        ArrayList<Student> copy = new ArrayList<Student>();
        for (int i = 0; (i < count) && (i < students.size()); i++) {
            copy.add( students.get(i) );
        }
        return copy;
    }
}
