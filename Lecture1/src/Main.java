import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello,world!");
        // <kieu cua bien>tenbien
//        float a = 3;
//        float b = 2;
//        float c = a / b;
//        System.out.println(c);
//        String s = "Hello, world!";
//        String s1 = " Kien";
//        String result = s + s1 + a;
//        System.out.println(result);
        // if - else
//        int a=3;
//        boolean result = true;
//
//        if (!result) {
//
//        }else {
//
//        }
//
//
//        if (!(a <= 3)) { // == > >= < <=
//            System.out.println("abc");
//        } else if (a == 4) {
//
//        } else {
//
//        }
//        String s1 = 'Ahihi';
//        String s2 = "Kien";
//        if ((s1 == s2) || (a==3)) {
//
//        }
//
//        switch (a) {
//            case 1:
//                System.out.println("1");
//                break; // ngat cau lenh
//            case 2:
//                System.out.println("2");
//                break;
//            case 3:
//                System.out.println("3");
//                break;
//            case 4:
//                break;)
//                    //neu case khon thoa man thi nhay vao day
//                    break;
//        }
        // loop
//        a = a + 2;
//        for (int i = 5; i > 0; i -= 1) {
//            System.out.println(i);
//        }
//        int i = 0;
//        while (i < 5){
//            //code
//            System.out.println(i);
//            i += 1;
//        }

//        while (true) {
//            break;
//        }
//
//        do {
//
//        } while (true);
//
//        do {
//            i++;
//            System.out.println(i);
//        } while (i<5);
        //khai bao mang tinh
//        int[] array = new int [10];
//        int[] list = {1, 3, 4, -4, 1 ,0};
//
//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
//        list.add(4, "d");
//
//        for (int i = 0; i < list.size(); i++){
//
//        }
//
//        for (String string: list){
//
//        }
//
//        String string = list.get(0);
//        array[0] = 1;
//        array[1] = 2;
//        for (int i = 0; i < array.length; i++){
//            array[i] = i; //gan
//            int a = array[i]; //lay
//        }

//        for (int i = 0; i < array.length; i++){
//            System.out.println(array[i]);
//        }

//        for (int element: array) {
//            System.out.println(element);
//        }
//        Scanner scanner = new Scanncer();
//        Scanner scanner = new Scanner(System.in);
//        int a = scanner.nextInt();
//        double b = scanner.nextDouble();

//        String a = scanner.next();
//        if (a.equals("a")) {
//
//        }
//        System.out.println(a);
//        String[][] list = {
//                {"*","*"},
//                {"*","*"}
//        };

        int[] player = new int[2];
        player[0] = 0;
        player[1] = 0;

        Random randoma = new Random();
        int a = randoma.nextInt(5);

        Random randomb = new Random();
        int b = randomb.nextInt(5);

        Random randomc = new Random();
        int c = randomc.nextInt(5);

        Random randomd = new Random();
        int d = randomd.nextInt(5);


        int[] enemy1 = new int[2];
        enemy1[0] = a;
        enemy1[1] = b;

        int[] enemy2 = new int[2];
        enemy2[0] = c;
        enemy2[1] = d;

        while (true) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    boolean is_p = false;
                    boolean is_en_1 = false;
                    boolean is_en_2 = false;
                    if (i == player[0] && j == player[1]) {
                        is_p = true;
                        if (is_p = true) {
                            System.out.print("P ");
                        }   
                    } else if(i == enemy1[0] && j == enemy1[1]) {
                        is_en_1 = true;
                        if (is_en_1 = true) {
                            System.out.print("x ");
                        }
                    } else if(i == enemy2[0] && j == enemy2[1]) {
                        is_en_2 = true;
                        if (is_en_2 = true) {
                            System.out.print("x ");
                        }
                    }else {
                        System.out.print("* ");
                    }
                }
                System.out.println();
            }
            Scanner scanner = new Scanner(System.in);
            String movement = scanner.next();

            int dx = 0;
            int dy = 0;

            if (movement.equals("a")) {
                dy= -1;
            } else if (movement.equals("w")) {
                dx = -1;
            } else if (movement.equals("s")) {
                dx = 1;
            } else if (movement.equals("d")) {
                dy = 1;
            }

            enemy1[1] = enemy1[1] + 1;
            enemy2[0] = enemy2[0] + 1;

            player[0] = player[0] + dx;
            player[1] = player[1] + dy;

//            if (player[0] < 0 || player[0] > 4 || player[1] < 0 || player[1] > 4) {
//                player[0] = player[0] - dx;
//                player[1] = player[1] - dy;
//                System.out.println("error");
//            }

            if (player[0] == -1) {
                player[0] = 4;
            }
            if (player[1] == -1) {
                player[1] = 4;
            }
            if (player[0] == 5) {
                player[0] = 0;
            }
            if (player[1] == 5){
                player[1] = 0;
            }
            if (enemy2[0] == -1) {
                enemy2[0] = 4;
            }
            if (enemy1[1] == -1) {
                enemy1[1] = 4;
            }
            if (enemy2[0] == 5) {
                enemy2[0] = 0;
            }
            if (enemy1[1] == 5){
                enemy1[1] = 0;
            }
        }
    }
}

