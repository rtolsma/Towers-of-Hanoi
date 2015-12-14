import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryan on 12/11/15.
 */
public class Hanoi {
    final int POLE_NUM = 3;
    List<Integer> diskList;
    List<Pole> poleList;

    public Hanoi(int disks) {
        if (disks < 3) return;
        this.diskList = new ArrayList<Integer>();
        this.poleList = new ArrayList<Pole>();
        for (int j = 0; j < POLE_NUM; j++) this.poleList.add(new Pole());
        for (int i = 0; i < disks; i++) {
            this.diskList.add(i);
            /*
            Sets up the first pole with
            value "diskList" on the bottom, and 0 on the top
             */
            this.poleList.get(0).stack(disks - i);
        }
    }

    public Pole getPole(int n) {
      return  n>=poleList.size()? null: poleList.get(n);
    }


    /**
     * Moves stack from $from to $to using pole $mediary
     */
    private void moveStack(Pole from, Pole mediary, Pole to, int disks) {
           //If you want to watch the pole moving process, uncomment following line of code
            //printPoles();
            switch(disks) {
                case 0: return;  //nothing to move

                case 1:
                    //check that moving to other pole is allowed, if not, then switch stacks around
                    if(!from.popTo(to)) {
                        moveStack(to, from, mediary, to.getSize());
                        from.popTo(to);
                        moveStack(mediary, from, to, mediary.getSize());
                    }
                    break;

                default:
                    moveStack(from, to, mediary, disks-1);
                    from.popTo(to);
                    moveStack(mediary, from, to, disks-1);


            }
    }

    /**
     * @param poles List of poles to print
     *              Method used for debugging, to visually see steps in the recursion Process
     */

    public void printPoles(List<Pole> poles) {
        for (int i = 0; i < poles.size(); i++) System.out.print("\tP: " + i);
        System.out.println();


        int max = 0;
        for (int i = 0; i < poles.size(); i++) if (poles.get(i).getSize() > max) max = poles.get(i).getSize();
        String temp = "";
        //go from the number of the 'deepest pole' down in length
        for (int i = max; i > 0; i--) {

            for (int l = 0; l < poles.size(); l++) {


                if (poles.get(l).getSize() < i
                        || poles.get(l).getSize() <= 0) {
                    temp += "\t\t";
                } else {
                    temp += "\t\t" + poles.get(l).get(i - 1);
                }
            }


            System.out.println(temp);
            temp = "";

        }
    }

    public void printPoles() {
        printPoles(this.poleList);
    }

    public static void main(String[] args) {
        Hanoi h = new Hanoi(20);
        Pole from=h.getPole(0);
        Pole mediary=h.getPole(1);
        Pole to=h.getPole(2);
        h.printPoles();
        h.moveStack(from, mediary, to, from.getSize());
        h.printPoles();
    }

}

