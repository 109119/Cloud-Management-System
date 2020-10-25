package portal;

import java.util.ArrayList;
import java.io.FileNotFoundException; 
import java.io.PrintWriter; 
import java.util.LinkedHashMap; 
import java.util.Map; 
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.ServerSocket;
import java.io.FileReader;
import java.util.Iterator;
import java.io.BufferedReader; 
import java.io.InputStreamReader;

public class Portal {
    private boolean isInitiated = false;
    private ArrayList<Worker> workerList;
    private int serverPort = 4201;
    private String name, ipAddress, port;

    public void initiateWorker(){
        isInitiated = true;

        workerList = new ArrayList<Worker>();

        try {
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
                Iterator<Map.Entry> itr1 = ((Map) itr2.next()).entrySet().iterator();
                name = ipAddress = port = "";

                while (itr1.hasNext()) { 
                    Map.Entry<String, String> pair = itr1.next(); 
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
        } catch(Exception e){
            System.out.println("Something went wrong.");
        }
    }

    public void listen(){
        try {
            ServerSocket ss = new ServerSocket(this.serverPort);
            Socket s = ss.accept();
            
            InputStreamReader in = new InputStreamReader(s.getInputStream());
            BufferedReader bf = new BufferedReader(in);

            String str = bf.readLine();

            Socket worker = new Socket("54.226.34.198", 6969);
            
            PrintWriter pr = new PrintWriter(worker.getOutputStream());
            pr.println(request);
            pr.flush();

            worker.close();
            
            s.close();

        } catch(Exception e){
            System.out.println("Something went wrong.");
        }
    }

    public void retrieveWorkerStatus(){
        try {
            Socket s = new Socket(this.ipAddress, Integer.valueOf(this.port));

            PrintWriter pr = new PrintWriter(s.getOutputStream());
            pr.write("RETRIVESTAT");
            pr.flush();
            
            s.close();
        } catch(Exception e){
            System.out.println("Something went wrong.");
        }
    }

    public void assignTask(String ipAddress, String port, String task){
        try {
            Socket s = new Socket(ipAddress, Integer.valueOf(port));

            PrintWriter pr = new PrintWriter(s.getOutputStream());
            pr.write("ASSIGN " + task);
            pr.flush();
            
            s.close();
        } catch(Exception e){
            System.out.println("Something went wrong.");
        }
    }
}
