package livid_design_pattern.observer;

public interface Subject {
    void registerObserver(Observer o); //옵저버 등록
    void removeObserver(Observer o); //옵저버 삭제
    void notifyObserver(); //주제와 상태 변경시 모든 옵저버에게 변경 내용 전달
}
