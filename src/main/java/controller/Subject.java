import java.util.ArrayList;
import java.util.List;

public class Subject {
  private List<Observer> file = new ArrayList<Observer>();

  public void addfile(Observer i) {
    file.add(i);
  }

  public List getList() {
    return this.file;
  }
}
