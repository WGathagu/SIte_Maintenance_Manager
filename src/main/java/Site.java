public class Site {
    private String name;
    private int engineerId;

    public Site(String name, int engineerId) {
        this.name = name;
        this.engineerId = engineerId;
    }

    public String getName(){
        return name;
    }

    public int getEngineerId(){
        return engineerId;
    }
    @Override
    public boolean equals(Object otherSite){
        if (!(otherSite instanceof Site)) {
            return false;
        } else {
            Site newSite = (Site) otherSite;
            return this.getName().equals(newSite.getName()) &&
                    this.getEngineerId() == newSite.getEngineerId();
        }
    }

}
