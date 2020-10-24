package model;

public class Worker {

    enum Status{
        IDLE,
        RUNNING,
        BUSY
    }

    Status status;

    public Worker() {
        this.status = Status.IDLE;
    }

    public Integer calculate(int num1, int num2, String opr) {
        String operand = opr.toLowerCase();
        if (operand.equals("tambah")) {

        } else if (operand.equals("kurang")){

        } else if (operand.equals("kali")){

        } else if (operand.equals("bagi")){

        }

    }

    public Status getStatus() {
        return this.status;
    }

    public void setStatus(String stat){
        String status=stat.toLowerCase();
        if(stat == "idle"){
            this.status = Status.IDLE;

        } else if(stat == "running") {
            this.status = Status.RUNNING;

        } else if(stat=="busy") {
            this.status = Status.BUSY;

        }

    }

    public void listen(){};

}
