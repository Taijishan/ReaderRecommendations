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
    //The 4 lists below are placeholder for a class where I could match the names to the images(how? idk) Perhaps I could also rather than use string lists, I could save the image/synopsis itself onto a gui list
    private String[] mysteryNovel = {"lord of Mysteries", "Deep Sea Embers", "Shrouded Seascape", "My House of Horrors", "Weird Live Broadcast: I can deduce endlessly"};
    private String[] romanceNovel = {"The Regressor and the Blind Saint", "Remarried Empress", "Martial King's Retired Life", "I Raised a Black Dragon", "My CP Rumor With The Movie Queen Has Gone Viral"};
    private String[] vrNovel = {"The Priest of Corruption", "Clearing The Game at the End of the World", "The Legendary Mechanic", "Reincarnation of the Strongest Sword God", "Overgeared"};
    private String[] xianxiaNovel = {"Ashes to Heaven", "Worlds' Apocalypse Online", "Martial World", "Cosmic Professional Gladiator", "I am the Fated Villain"};
}
