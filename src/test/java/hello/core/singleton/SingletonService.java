package hello.core.singleton;

public class SingletonService {

    // 1. static 영역에 객체 instance를 미리 하나 생성해서 올려둔다.
    // 2. 객체 인스턴스가 필요하면 오직 getInstance() 메서드로만 조회할 수 있다.
    // 3. 1개의 객체 인스턴스만 존재해야 하므로, 생성자를 private로 막아 외부에서 new 키워드로 객체 인스턴스가 생성되는 것을 막는다.

    // 자기 자신을 내부의 private로 하나 가지고 있다.
    // static: 클래스 레벨에 생성되므로 딱 하나의 객체만 만들어져서 올라간다.
    private static final SingletonService instance = new SingletonService();

    // 인스턴스를 참조할 수 있는 유일한 방법. 생성할 수 있는 곳은 없다.
    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private로 막는다! 막는다!
    private SingletonService() {
    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
    // new를 막 만들 수 있음!
    public static void main(String[] args) {
        SingletonService singletonService = new SingletonService();
    }
}
