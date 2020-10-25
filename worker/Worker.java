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
            return num1+num2;
        } else if (operand.equals("kurang")){
            return num1-num2;
        } else if (operand.equals("kali")){
            return num1*num2;
        } else if (operand.equals("bagi")){
            return num1/num2;
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

    public void retrieveCalcInput(){
        try {
            Socket s = new Socket(this.ipAddress, Integer.valueOf(this.port));

            PrintWriter pr = new PrintWriter(s.getOutputStream());
            pr.write("RETRIVECALCINPUT");
            pr.flush();

            s.close();
        } catch(Exception e){
            System.out.println("Something went wrong.");
        }
    }

}
