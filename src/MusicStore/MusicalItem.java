package MusicStore;
import java.util.*;

public class MusicalItem {
   String musicName;
   MusicCategory category;
   String duration;
   String description;
   String releaseDate;
   int  quantity;
   String artist;
   double price;

    public MusicalItem(String musicName, String duration, String description, String releaseDate, int quantity, String artist, double price, MusicCategory category) {
        this.musicName = musicName;
        this.duration = duration;
        this.description = description;
        this.releaseDate = releaseDate;
        this.quantity = quantity;
        this.artist = artist;
        this.price = price;
        this.category =category;
    }

   
   
    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public MusicCategory getCategory() {
        return category;
    }

    public void setCategory(MusicCategory category) {
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

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
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
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.musicName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MusicalItem other = (MusicalItem) obj;
        return Objects.equals(this.musicName, other.musicName);
    }
    
    
    @Override
    public String toString() {
        return "MusicalItem{" + "musicName=" + musicName + ", category=" + category + ", duration=" + duration + ", description=" + description + ", releaseDate=" + releaseDate + ", quantity=" + quantity + ", artist=" + artist + ", price=" + price + '}';
    }

   
    public String toString(int index) {
        return index + "\t " + musicName + "\t " + category + "\t " + duration + "\t " + description + "\t " + releaseDate + "\t " + quantity + "\t " + artist + "\t " + price 
                +"\n--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------";
    }
   
   
   
}
