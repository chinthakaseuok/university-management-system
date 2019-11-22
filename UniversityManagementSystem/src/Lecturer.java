public class Lecturer {
    private int id;
    private String name;
    private int age;
    private String userName;
    private String password;

    public Lecturer() {
    }

    public Lecturer(int id, String name, int age, String userName, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.userName = userName;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
