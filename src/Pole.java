import java.util.ArrayList;
import java.util.List;

/**
 * Created by ryan on 12/11/15.
 *
 * Represents the pole/stack in the Towers of Hanoi Problem
 *
 * A list of integers represents the "diskList" involved with the stacks
 *
 * First item in the list represents the bottom of the stack, while
 * the last item represents the top of the stack
 *
 *
 *
 */
public class Pole {

    List<Integer> disks;

    public Pole(List<Integer> disks) {

        this.disks=disks;

    }

    public Pole() {
        this(new ArrayList<Integer>());
    }



    public boolean stack(int val) {

        if(val>getLastDisk() && disks.size()>0) return false;

        else disks.add(val);
        return true;
    }
    //Pops top disk to another pole
    public boolean popTo(Pole destination) {

        if(destination.stack(getLastDisk())) {
            pop();
            return true;
        }
        return false;
    }
        public int getSize() {
            return disks.size();
        }
    public int get(int index) {return disks.get(index);}
    private int getLastDisk() {
        if(disks!=null && disks.size()>0)
         return disks.get(disks.size()-1);

        return -1;
    }

    private void pop() {
        if(disks!=null && disks.size()>0)
        disks.remove(disks.size()-1);
    }



}
