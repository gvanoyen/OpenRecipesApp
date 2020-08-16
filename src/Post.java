import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public class Post {
    private String title;
    private String author;
    private String descript;
    private final Date postTime;
    private ArrayList<String> steps;
    private ArrayList<String> ing;

    public Post(String title, String descript, ArrayList<String> steps, ArrayList<String> ing){
        this.title = title;
        this.descript = descript;
        postTime = new Date();
        setLists(steps, ing);
    }

    public Post(){
        postTime = new Date();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public Date getPostTime() {
        return postTime;
    }
    public void removeStepItem(String step){
        steps.remove(step);
    }

    public void removeStepAtIndex(int index){
        steps.remove(index);
    }

    public void addStep(String step){
        steps.add(step);
    }

    public void removeIngItem(String item){
        ing.remove(item);
    }

    public void removeIngAtIndex(int index){
        ing.remove(index);
    }

    public void addIng(String item){
        ing.add(item);
    }

    public void setSteps(ArrayList<String> steps){
        this.steps = new ArrayList<String>();
        this.steps.addAll(steps);
    }

    public void setIng(ArrayList<String> ing){
        this.ing = new ArrayList<String>();
        this.ing.addAll(ing);
    }

    private void setLists(ArrayList<String> steps, ArrayList<String> ing){
        this.steps = new ArrayList<String>();
        this.ing = new ArrayList<String>();

        Iterator<String> iteratorS = steps.iterator();
        Iterator<String> iteratorI = ing.iterator();

        this.steps.addAll(ing);
        this.ing.addAll(ing);
    }
}
