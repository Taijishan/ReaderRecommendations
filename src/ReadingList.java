import java.util.ArrayList;
public class ReadingList {
    private ArrayList<Novel> readingList = new ArrayList<Novel>();
    private ArrayList<Novel> allNovels = Novel.buildRandomRecommendation();
    public void addToList(String name){
        for (Novel n : allNovels) {

        }
    }
    public void removeFromList(String name){
        readingList.remove(name);
    }
    public ArrayList<Novel> showReadingList(){
        return readingList;
    }

}
