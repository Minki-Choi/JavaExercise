/**
 * Created by cj on 2016-03-03.
 */
import java.util.Scanner;

public class Tetris {
    int x1,x2,x3,x4;
    int y1,y2,y3,y4;
    char[][] tempBlock;
    char[][] squre=
            {{'*','*','.','.'},
            {'*','*','.','.'},
            {'.','.','.','.'},
            {'.','.','.','.'}};

    char[][] LBlock=
            {{'.','.','.','.'},
            {'*','.','.','.'},
            {'*','.','.','.'},
            {'*','*','.','.'}};

    char[][] LBlockReversal=
            {{'.','.','.','.'},
            {'.','.','.','*'},
            {'.','.','.','*'},
            {'.','.','*','*'}};

    char[][] bar=
            {{'.','.','.','.'},
            {'.','.','.','.'},
            {'.','.','.','.'},
            {'*','*','*','*'}};

    char[][] lightening=
            {{'.','.','.','.'},
            {'.','.','.','.'},
            {'.','*','*','.'},
            {'*','*','.','.'}};

    char[][] lighteningReversal=
            {{'.','.','.','.'},
            {'.','.','.','.'},
            {'.','*','*','.'},
            {'.','.','*','*'}};

    char[][] TBlock=
            {{'.','.','.','.'},
            {'.','.','.','.'},
            {'.','*','.','.'},
            {'*','*','*','.'}};
    static char[][] board;

    public void printBoard() {
        System.out.print("y"+"\\"+"x");
        for(int i=0; i<board.length; i++)
            System.out.print("\t"+i);
        System.out.println();
        for(int i=0; i<board[0].length; i++) {
            System.out.print(i+"\t");
            for (int j = 0; j < board.length; j++)
                System.out.print(board[j][i] + "\t");
            System.out.println();
        }
    }
    public void printBlock(char[][] block) {
        for(int i=0; i<block[0].length; i++) {
            for(int j=0; j<block.length; j++) {
                System.out.print(block[j][i]+"\t");
            }
            System.out.println();
        }
    }

    public void newBoard(int n) {
        board=new char[n][n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                    board[j][i]='.';
    }

    public void turnSample(char[][] block) {
        char[][] temp=new char[4][4];
        for(int i=0; i<block[0].length; i++) {
            for (int j=0; j<block.length; j++) {
                temp[j][i]=block[j][i];
            }
        }
        for(int i=0; i<block[0].length; i++) {
            for (int j=0; j<block.length; j++) {
                block[j][i]=temp[i][3-j];
            }
        }

    }

    public int newRandomBlock() {
        int randomNum;
        randomNum=(int)(Math.random()*7);
        switch(randomNum) {
            case 0:
                System.out.println("*\t*");
                System.out.println("*\t*");
                break;
            case 1:
                System.out.println("*");
                System.out.println("*");
                System.out.println("*\t*");
                break;
            case 2:
                System.out.println(" \t*");
                System.out.println(" \t*");
                System.out.println("*\t*");
                break;
            case 3:
                System.out.println("*\t*\t*\t*");
                break;
            case 4:
                System.out.println(" \t*\t*");
                System.out.println("*\t*");
                break;
            case 5:
                System.out.println("*\t*");
                System.out.println(" \t*\t*");
                break;
            case 6:
                System.out.println(" \t*");
                System.out.println("*\t*\t*");
        }
        return randomNum;
    }

    public  int inputPoint(int x, String str, int i) {
        Scanner sc = new Scanner(System.in);
        System.out.println(str + i + "입력");
        x = sc.nextInt();
        return x;
    }
    public boolean selectPosition() {

        int differenceX;
        int differenceY;

        x1=inputPoint(x1,"x",1);
        y1=inputPoint(y1,"y",1);
        x2=inputPoint(x2,"x",2);
        y2=inputPoint(y2,"y",2);
        if(x1==x2 && y1==y2) {
            System.out.println("입력이 잘못되었습니다");
            return false;
        }
        x3=inputPoint(x3,"x",3);
        y3=inputPoint(y3,"y",3);
        if((x3==x1&&y3==y1)||(x3==x2&&y3==y2)) {
            System.out.println("입력이 잘못되었습니다");
            return false;
        }
        x4=inputPoint(x4,"x",4);
        y4=inputPoint(y4,"y",4);
        if((x4==x1&&y4==y1)||(x4==x2&&y4==y2)||(x4==x3&&y4==y3)) {
            System.out.println("입력이 잘못되었습니다");
            return false;
        }
        differenceX = getMax(x1, x2, x3, x4) - getMin(x1, x2, x3, x4);
        if (differenceX > 3) {
            System.out.println("입력이 잘못되었습니다");
            return false;
        }

        differenceY = getMax(y1, y2, y3, y4) - getMin(y1, y2, y3, y4);
        if (differenceY > 3) {
            System.out.println("입력이 잘못되었습니다");
            return false;
        }

        tempBlock=new char[differenceX+1][differenceY+1];
        for (int i = 0; i <= differenceY; i++) {
            for (int j = 0; j <= differenceX; j++) {
                int n1,n2,n3,n4;
                int m1,m2,m3,m4;
                n1=x1-getMin(x1,x2,x3,x4);
                n2=x2-getMin(x1,x2,x3,x4);
                n3=x3-getMin(x1,x2,x3,x4);
                n4=x4-getMin(x1,x2,x3,x4);
                m1=y1-getMin(y1,y2,y3,y4);
                m2=y2-getMin(y1,y2,y3,y4);
                m3=y3-getMin(y1,y2,y3,y4);
                m4=y4-getMin(y1,y2,y3,y4);
                if ((n1 == j && m1 == i) || (n2 == j && m2 == i) || (n3 == j && m3 == i) || (n4 == j && m4 == i)) {
                    tempBlock[j][i] = '*';
                } else {
                    tempBlock[j][i] = '.';
                }
            }
        }
        return true;
    }

    public boolean contrastBlock(char sample[][]) {
        int cnt=0;
        for(int i=0;i<=sample[0].length-tempBlock[0].length; i++) {
            for(int j=0; j<=sample.length-tempBlock.length; j++){

                for(int n=0; n<tempBlock[0].length; n++) {
                    for(int m=0; m<tempBlock.length; m++) {
                        if (sample[j+m][i+n] == tempBlock[m][n]) {
                            ++cnt;
                            if(cnt==tempBlock.length*tempBlock[i].length)
                                return true;
                        }
                    }
                }
                cnt=0;
            }
        }
        return false;
    }

    public boolean contrastBlock2(char sample[][],int n) {
        for(int i=0; i<=n; i++) {
            if(contrastBlock(sample)) {
                placetempBlock();
            return true;
        }
            turnSample(sample);
        }
        System.out.println("입력이 잘못되었습니다.다시 입력해주세요");
        return false;
    }

//
//    public void contrastBoard(char block[][]) {
//        for(int i=0; i<=board[0].length-block[0].length; i++) {
//            for(int j=0; j<=board.length-block.length; j++) {
//                for(int m=0; m<block[0].length; m++) {
//                    for(int n=0; n<block.length; n++) {
//                    }
//                }/
//            }
//        }
//    }

    public void placetempBlock() {
        int minX=getMin(x1,x2,x3,x4);
        int minY=getMin(y1,y2,y3,y4);
        for(int i=0; i<tempBlock[0].length; i++) {
            for(int j=0; j<tempBlock.length; j++) {
                if(board[minX+j][minY+i]=='*' && tempBlock[j][i]=='*'){
                    System.out.println("놓을 수 없습니다");
                    return;
                }
                else if(board[minX+j][minY+i]=='*' && tempBlock[j][i]=='.')
                    board[minX+j][minY+i]='*';
                else
                    board[minX+j][minY+i]=tempBlock[j][i];
            }
        }
        printBoard();
        System.out.println();
    }

    public int getMax(int a,int b,int c,int d) {
        return Math.max(Math.max(Math.max(a,b),c),d);
    }
    public int getMin(int a,int b,int c,int d) {
        return Math.min(Math.min(Math.min(a,b),c),d);
    }

    public void UI() {
        int randomNum;
        boolean randomNumflag=false;
        newBoard(10);
        printBoard();
        System.out.println();
        randomNum=newRandomBlock();
        while(true) {
            if(randomNumflag==true) {
                randomNum = newRandomBlock();
            }
            if(selectPosition()) {
                randomNumflag = true;
            } else {
                randomNumflag = false;
                continue;
            }
                System.out.println();


                switch (randomNum) {
                    case 0:
                        if(!contrastBlock2(squre, 0)) {
                            randomNumflag=false;
                            continue;
                        }
                        break;
                    case 1:
                        if(!contrastBlock2(LBlockReversal, 3)) {
                            randomNumflag=false;
                            continue;
                        }
                        break;
                    case 2:
                        if(!contrastBlock2(LBlock, 3)) {
                            randomNumflag=false;
                            continue;
                        }
                        break;
                    case 3:
                        if(!contrastBlock2(bar, 1)) {
                            randomNumflag=false;
                            continue;
                        }
                        break;
                    case 4:
                        if(!contrastBlock2(lighteningReversal, 1)) {
                            randomNumflag=false;
                            continue;
                        }
                        break;
                    case 5:
                        if(!contrastBlock2(lightening, 1)) {
                            randomNumflag=false;
                            continue;
                        }
                        break;
                    case 6:
                        if(!contrastBlock2(TBlock, 3)) {
                            randomNumflag=false;
                            continue;
                        }
                        break;
                }

        }
    }

    

    public static void main(String[] args) {
        Tetris Tetris=new Tetris();
        Tetris.UI();
    }
}