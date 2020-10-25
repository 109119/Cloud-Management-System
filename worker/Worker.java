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

    public Integer calculate(int num1, int num2, String operand) {
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

    public void listen(){
        ServerSocket ss = new ServerSocket(this.serverPort);
        Socket s = ss.accept();

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = BufferedReader(in);

        String[] str = bf.readLine().split(" ");
        if (str[0].equals("CALC")) {
            switch (str[2]){
                case "+":
                    calculate(str[1],str[3],"tambah")
                    break;
                case "-":
                    calculate(str[1],str[3],"kurang")
                    break;
                case "*":
                    calculate(str[1],str[3],"kali")
                    break;
                case "/":
                    calculate(str[1],str[3],"bagi")
                    break;
            }
        }
        s.close()
    };

}
