public class Location {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public Location(String loc){
        setX(loc.charAt(0)-'a');
        setY(loc.charAt(1)-'0');
    }

    public Location() {}
    public void UserInput(String loc){
        setX(loc.charAt(0)-'a');
        setY(8-(loc.charAt(1)-'0'));
    }
    public String getSLocation(){
        return (char)(x+'a') + " " +  y;
    }

    @Override
    protected Location clone() {

        return new Location(getSLocation());
    }
}
