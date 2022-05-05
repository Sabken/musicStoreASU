package MusicStore;
import java.util.*;

public class MusicalItem {
   String musicName;
   ArrayList<String> category;
   String duration;
   String description;
   Date releaseDate;
   int  quantity;
   String artist;
   double price;

    public MusicalItem(String musicName, String duration, String description, Date releaseDate, int quantity, String artist, double price) {
        this.musicName = musicName;
        this.duration = duration;
        this.description = description;
        this.releaseDate = releaseDate;
        this.quantity = quantity;
        this.artist = artist;
        this.price = price;
    }

   
   
    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public ArrayList<String> getCategory() {
        return category;
    }

    public void setCategory(ArrayList<String> category) {
        this.category = category;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "MusicalItem{" + "musicName=" + musicName + ", category=" + category + ", duration=" + duration + ", description=" + description + ", releaseDate=" + releaseDate + ", quantity=" + quantity + ", artist=" + artist + ", price=" + price + '}';
    }

   
    public String toString(int id) {
        return id + "\t " + musicName + "\t " + category + "\t " + duration + "\t " + description + "\t " + releaseDate + "\t " + quantity + "\t " + artist + "\t " + price 
                +"\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
    }
   
   
   
}
