import java.lang.reflect.Array;
import java.util.ArrayList;
public class ReadingList {
    private ArrayList<String> readingList;
    public void addToList(String name){
        readingList.add(name);
    }
    private String[] mysteryNovel = {"lord of Mysteries", "Deep Sea Embers", "Shrouded Seascape", "My House of Horrors", "Weird Live Broadcast: I can deduce endlessly"};
    private String[] romanceNovel = {"The Regressor and the Blind Saint", "Remarried Empress", "Martial King's Retired Life", "I Raised a Black Dragon", "My CP Rumor With The Movie Queen Has Gone Viral"};
    private String[] vrNovel = {"The Priest of Corruption", "Clearing The Game at the End of the World", "The Legendary Mechanic", "Reincarnation of the Strongest Sword God", "Overgeared"};
    private String[] xianxiaNovel = {"Ashes to Heaven", "Worlds' Apocalypse Online", "Martial World", "Cosmic Professional Gladiator", "I am the Fated Villain"};
}
