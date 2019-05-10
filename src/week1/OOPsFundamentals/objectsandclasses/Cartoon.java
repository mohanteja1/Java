package week1.OOPsFundamentals.objectsandclasses;

public class Cartoon implements Cloneable {
    String name;
    int nofSeasons;
    int totalNoOfEpisodes;

    public Cartoon(String name, int nofSeasons, int totalNoOfEpisodes) {
        this.name = name;
        this.nofSeasons = nofSeasons;
        this.totalNoOfEpisodes = totalNoOfEpisodes;
    }

    public double getEpisodeToSeasonRatio(){
       return totalNoOfEpisodes/nofSeasons;
    }

    @Override
    public String toString() {
        return "Cartoon{" +
                "name='" + name + '\'' +
                ", nofSeasons=" + nofSeasons +
                ", totalNoOfEpisodes=" + totalNoOfEpisodes +
                '}';
    }

    public Object clone() throws CloneNotSupportedException{
        return super.clone();
    }


    // setters


    public void setName(String name) {
        this.name = name;
    }

    public void setNofSeasons(int nofSeasons) {
        this.nofSeasons = nofSeasons;
    }

    public void setTotalNoOfEpisodes(int totalNoOfEpisodes) {
        this.totalNoOfEpisodes = totalNoOfEpisodes;
    }




}


