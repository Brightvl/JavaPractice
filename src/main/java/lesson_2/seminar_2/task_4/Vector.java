package lesson_2.seminar_2.task_4;



public class Vector {
    double x;
    double y;
    double z;

    //с помощью alt+insert condtructor чтобы красиво выводить для того чтобы не писать одно и тое в MAin
    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }


    //@Override - переписать/переопределить стандаптный функционал
    @Override //@ Это аннотация это мы сделали с помощью alt+insert toString чтобы красиво выводить
    public String toString() {

        return "Vector{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    /**
     * @return длину вектора
     */
    public double vectorLength(){
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double Multiplication(Vector twoVector) {
        return x * twoVector.x + y * twoVector.y + z * twoVector.z;
    }

    public Vector vectorPr(Vector vector) {
        return new Vector(
                y * vector.z - z * vector.y,
                z * vector.x - x * vector.z,
                x * vector.y - y * vector.x
        );
    }

}
