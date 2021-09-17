package DataStructures;

public class Array {
    public int[] list;
    private int count;
    public Array(int length) {
        this.count = 0;
        this.list = new int[length];
    }
    public void insert(int item) {
        if (count == list.length) {
            int[] newList = new int[count * 2];
            for (int i = 0; i < count; i++) {
                newList[i] = list[i];
            }
            list = newList;
        }
        list[count++] = item;
    }
    public void removeAt(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException();
        }
        for (int i = index; i < count; i++) {
            list[i] = list[i + 1];
        }
        count--;
    }
    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (list[i] == item) {
                return i;
            }
        }
        return -1;
    }
    public void print() {
        System.out.print("[");
        for (int i = 0; i < count; i++) {
            System.out.print(list[i] + (i < count - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
