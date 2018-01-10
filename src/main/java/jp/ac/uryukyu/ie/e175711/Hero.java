package jp.ac.uryukyu.ie.e175711;

public class Hero extends LivingThing{
    public Hero(String name, int maximumHP, int attack) {
        super(name,maximumHP,attack) ;
    }
    @Override
    public void attack(LivingThing opponent) {
        int kai = (int)(Math.random()*10)+1;
        if (!getDead()) {
            int damage = (int) (Math.random() * getAttack());
            if (damage == 0) {
                System.out.printf("%sの攻撃！,,,だが、%sは攻撃を回避した！\n", getName(), opponent.getName());
            }
            if (damage != 0 && (kai-4) <= 0) {
                damage = damage*2;
                System.out.printf("%sの攻撃！会心の一撃！！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
            } else if (damage != 0 && kai - 4 > 0){
                System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", getName(), opponent.getName(), damage);
            }
            opponent.wounded(damage);
        }
    }
    public void wounded(int damage) {
        setHitPoint(getHitPoint()-damage);
        if(getHitPoint() < 0) {
            setDead(true);
            System.out.printf("勇者%sは道半ばで力尽きてしまった。\n", getName());
        }
    }
}
