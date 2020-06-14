package com.jin.maintest.innner_class_single;


class Out {
    public int num = 10;

    public void outfun1() {
        System.out.println("outfun1");
    }
    public void outfun2() {
        System.out.println("outfun2");
        class InClass{
            public void show() {
                num=10;
            }
        }
    }

    class Inner {
        public  int num = 20;

        public void show() {
            int num = 30;
            System.out.println(num);
            System.out.println(this.num);
            System.out.println(Out.this.num);
            outfun1();
            infun1();
        }
        public void infun1() {
            System.out.println("infun1");
        }
    }
}

class InnerClassTest {
    public static void main(String[] args) {
        Out.Inner oi = new Out().new Inner();
        oi.show();
    }
}

