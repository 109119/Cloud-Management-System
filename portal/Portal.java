package model;

import java.util.ArrayList;
import java.io.FileNotFoundException; 
import java.io.PrintWriter; 
import java.util.LinkedHashMap; 
import java.util.Map; 
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import Worker;
import java.net.Socket;
import java.net.ServerSocket;

public class Portal {
    private boolean isInitiated = false;
    private ArrayList<Worker> workerList;
    private serverPort = 4201;
    
    public Portal(){

    }

    public void initiateWorker(){
        isInitiated = true;
        String name, ipAddress, port;
        workerList = new ArrayList<Worker>;

        // parsing file "JSONExample.json" 
        Object obj = new JSONParser().parse(new FileReader("resources.json")); 
          
        // typecasting obj to JSONObject 
        JSONObject jo = (JSONObject) obj; 
          
       // getting phoneNumbers 
        JSONArray ja = (JSONArray) jo.get("worker"); 
          
        // iterating phoneNumbers 
        Iterator itr2 = ja.iterator(); 
          
        while (itr2.hasNext())  
        { 
            itr1 = ((Map) itr2.next()).entrySet().iterator();
            name = ipAddress = port = ""

            while (itr1.hasNext()) { 
                Map.Entry pair = itr1.next(); 
                switch(pair.getKey()){
                    case "name":
                        name = pair.getValue();
                        break;
                    case "ipAddress":
                        ipAddress = pair.getValue();
                        break;
                    case "port":
                        port = pair.getValue();
                        break;
                }
                this.workerList.add(new Worker(name, ipAddress, port));
            } 
        } 
    }

    public void listen(){
        ServerSocket ss = new ServerSocket(this.serverPort);
        Socket s = ss.accept();
        
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader bf = BufferedReader(in);

        String str = bf.readLine();

        s.close()
    }

    public void retrieveWorkerStatus(){
        Socket s = new Socket(ipAddress, port);

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.write("RETRIVESTAT");
        pr.flush();
        
        s.close();
    }

    public int assignTask(ipAddress, port, task){
        Socket s = new Socket(ipAddress, port);

        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.write("ASSIGN " + task);
        pr.flush();
        
        s.close();
    }
}
