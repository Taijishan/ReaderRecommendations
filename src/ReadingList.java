import java.util.ArrayList;
public class ReadingList {
    private ArrayList<Novel> readingList = new ArrayList<Novel>();
    private ArrayList<Novel> allNovels = Novel.buildRandomRecommendation();
    public void removeFromList(Novel name){
        allNovels.remove(name);
        readingList.add(name);
    }
    public ArrayList<Novel> showReadingList(){
        return readingList;
    }

}
