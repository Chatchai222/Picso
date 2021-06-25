package Archive;

public class MyLockObject {
    int data;

    private static MyLockObject instance = new MyLockObject();

    private MyLockObject(){
        this.data = 10;
    }

    public static MyLockObject getInstance() {
        return instance;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
