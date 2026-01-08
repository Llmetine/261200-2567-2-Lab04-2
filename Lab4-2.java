public class HealthRecord {
    private int height,sum,i;
    private static final int MIN_PERMITTED_HEIGHT = 50;
    private static final int MAX_PERMITTED_HEIGHT = 175;
    private static final int DEFAULT_HEIGHT = 100;

    // TODO: 1 Think about the initial value for maximum and minimum height
    private static int tallestHeight = 0 ;
    private static int shortestHeight = 0 ;
    private static int counter = 0;
    private static double averageHeight = 0;

    public HealthRecord(int height) {
        setHeight(height);
        counter ++;
    }
    public void setHeight(int height) {

        // TODO: 2 Check if the input height falls within the permitted range
        if ( height >= MIN_PERMITTED_HEIGHT && height <= MAX_PERMITTED_HEIGHT )
            this.height = height;
        else
            this.height = DEFAULT_HEIGHT ;

        averageHeight = ((averageHeight*counter)+this.height)/(counter+1) ;

        // TODO: 3 Update the tallest and shortest height
        if(tallestHeight == 0 && shortestHeight == 0){
            tallestHeight = this.height;
            shortestHeight = this.height;
        }
        if ( this.height > tallestHeight )
            tallestHeight = this.height ;
        if ( this.height < shortestHeight )
            shortestHeight = this.height ;
    }

    public int getHeight() {
        return this.height;
    }

    public static int getTallestHeight() {
        return HealthRecord.tallestHeight;
    }

    public static int getShortestHeight(){
        return HealthRecord.shortestHeight;
    }

    public static double getAverageHeight() {
        return HealthRecord.averageHeight;
    }

    public void displayDetails() {
        System.out.println("Height (cm): " + getHeight());
    }
    public static void displayClassDetails() {
        System.out.println("The tallest height (cm): " + getTallestHeight());
        System.out.println("The shortest height (cm): " + getShortestHeight());
        System.out.printf("The average height (cm): %.2f",getAverageHeight());
    }
}
