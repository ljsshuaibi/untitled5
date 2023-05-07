import java.util.Random;
import java.util.Scanner;

public class Main{
    public static void main(String [] args){
        begin();
    }

    static void init(int [][]a){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                a[i][j]=0;
            }
        }
    }
    static int judge(int [][]a){
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(a[i][j]==0){
                    return 1;
                }
            }
        }
        return 0;
    }
    static void random(int [][]a){
        while(true){
            Random r=new Random();
            double i1=Math.random()*4;
            double j1=Math.random()*4;
            int i=(int)i1;
            int j=(int)j1;
            if(a[i][j]==0){
                a[i][j]=2;
                break;
            }
        }
    }
    static int jij(int [][]a){
        int i=judge(a);
        if(i==1) return 1;
        else{
            for(int q=0;q<4;q++){
                for(int j=0;j<4;j++) {
                    if (q + 1 < 4) {
                        if (a[q][j] == a[q + 1][j]) return 1;
                    }
                    if (q - 1 >= 0) {
                        if (a[q][j] == a[q - 1][j]) return 1;
                    }
                    if (j + 1 < 4) {
                        if (a[q][j] == a[q][j + 1]) return 1;
                    }
                    if (j - 1 >= 0) {
                        if (a[q][j] == a[q][j - 1]) return 1;
                    }
                }
            }
            return 0;
        }
    }
    static void move(int [][]a,String ch) {
        if (ch.equals("w")) {
            for (int i = 1; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    int m = i - 1;
                    while (m >= 0) {
                        if (a[m][j] != 0) {
                            break;
                        }
                        m--;
                    }
                    if (m + 1 != i) {
                        a[m + 1][j] = a[i][j];
                        a[i][j] = 0;
                    }
                }
            }
        }
        if (ch.equals("s")) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    int m = i + 1;
                    while (m <= 3) {
                        if (a[m][j] != 0) {
                            break;
                        }
                        m++;
                    }
                    if (m - 1 != i) {
                        a[m - 1][j] = a[i][j];
                        a[i][j] = 0;
                    }
                }
            }
        }
        if(ch.equals("d")) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    int m = j + 1;
                    while (m <= 3) {
                        if (a[i][m] != 0) {
                            break;
                        }
                        m++;
                    }
                    if (m - 1 != j) {
                        a[i][m - 1] = a[i][j];
                        a[i][j] = 0;
                    }
                }
            }
        }
        if(ch.equals("a")) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    int m = j - 1;
                    while (m >= 0) {
                        if (a[i][m] != 0) break;
                        m--;
                    }
                    if (m + 1 != j) {
                        a[i][m + 1] = a[i][j];
                        a[i][j] = 0;
                    }
                }
            }
        }
    }
    static void add(int [][]a,String ch) {
        if (ch.equals("w")) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    if (a[i + 1][j] ==a[i][j]){
                        a[i][j]+=a[i+1][j];
                        a[i+1][j]=0;
                    }
                }
            }
        }
        if(ch.equals("s")){
            for (int i = 3; i>0; i--) {
                for (int j = 0; j < 4; j++) {
                    if (a[i - 1][j] ==a[i][j]){
                        a[i][j]+=a[i-1][j];
                        a[i-1][j]=0;
                    }
                }
            }
        }
        if(ch.equals("d")){
            for (int i = 0; i < 4; i++) {
                for (int j = 3; j > 0; j--) {
                    if(a[i][j]==a[i][j-1]) {
                        a[i][j] += a[i][j - 1];
                        a[i][j - 1] = 0;
                    }
                }
            }
        }
        if(ch.equals("a")){
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if(a[i][j]==a[i][j+1]) {
                        a[i][j] += a[i][j + 1];
                        a[i][j + 1] = 0;
                    }
                }
            }
        }
    }
    static void imp(int [][]a) {
        String ch;
        Scanner sc = new Scanner(System.in);
        ch = sc.next();
        move(a, ch);
        move(a,ch);
        move(a,ch);
        move(a,ch);
        add(a, ch);
        move(a,ch);
        move(a,ch);
        move(a,ch);
        move(a,ch);
    }
    static void cot(int [][]a){
        for(int i=0;i<4;i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(a[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    static void begin(){
        int [][]a=new int[4][4];
        init(a);
        random(a);
        cot(a);
        int x;
        int xw;
        while(true) {
            x = jij(a);
            if(x==0) break;
            imp(a);
            random(a);
            cot(a);
        }
    }
}
