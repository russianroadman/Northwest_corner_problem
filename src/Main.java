public class Main {

    private static final int[][] t = {
            {0,   28,  35,  32,  36,  15},
            {25,  0,   0,   0,   0,   0},
            {34,  0,   0,   0,  0,   0},
            {42,  0,  0,   0,   0,   0},
            {45,  0,  0,   0,   0,   0}
    };

    public static void main(String[] args) {

        print();

        for (int i = 1; i < t.length; i++){
            for (int j = 1; j < t[0].length; j++){

                if (offer(i) > demand(j)){

                    t[i][j] = demand(j);
                    setDemand(j,0);
                    setOffer(i,offer(i) - t[i][j]);

                } else if (offer(i) == demand(j)){

                    t[i][j] = demand(j);
                    setOffer(i, 0);
                    setDemand(j, 0);

                    if (i != t.length-1 && j != t[0].length-1){
                        j--;
                        i++;
                    }

                } else {

                    t[i][j] = offer(i);
                    setDemand(j, demand(j) - offer(i));
                    setOffer(i, 0);

                    if (i != t.length-1 && j != t[0].length-1){
                        j--;
                        i++;
                    }

                }

                print();

            }
        }
    }

    public static int offer(int i){
        return t[i][0];
    }

    public static int demand(int j){
        return t[0][j];
    }

    public static void setOffer(int i, int value){
        t[i][0] = value;
    }

    public static void setDemand(int j, int value){
        t[0][j] = value;
    }

    public static void print(){
        for (int[] ints : t) {
            for (int j = 0; j < t[0].length; j++) {
                System.out.printf("%5d ", ints[j]);
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------");
    }

}
