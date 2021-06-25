package Archive;

public class SingletonTest {
    private int data=5;
    private static SingletonTest instance = new SingletonTest();
    private SingletonTest(){
        data = 10;
    }

    public static SingletonTest getInstance() {
        return instance;
    }

    public int getData() {
        return data;
    }
    public void setData(int num){
        data = num; 
    }
}
