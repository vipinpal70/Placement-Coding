

class student {
    String Reg_no = "22MCA10064";
    String course = "MCA";
}
class TestStudent1 {
    public static void main(String[] args) {
        student s = new student();
        System.out.println(s.Reg_no);
        System.out.println(s.course);
        s.Reg_no.length();  //length
        s.Reg_no.concat(s.course);
        // s.Reg_no.equal(s.course.);
        
    }
}
