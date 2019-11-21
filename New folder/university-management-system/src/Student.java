public class Student
{
    private String stdName;
    private int stdAge;
    private String username;
    private String password;

    public Student() {
    }

    public Student(String stdName, int stdAge, String username, String password) {
        this.stdName = stdName;
        this.stdAge = stdAge;
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public int getStdAge() {
        return stdAge;
    }

    public void setStdAge(int stdAge) {
        this.stdAge = stdAge;
    }


}
